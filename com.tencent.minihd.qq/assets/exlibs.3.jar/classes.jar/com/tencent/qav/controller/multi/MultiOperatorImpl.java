package com.tencent.qav.controller.multi;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVUserInfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qav.QavDef.MultiParams;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.observer.ObserverDispatcher;
import com.tencent.qav.thread.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MultiOperatorImpl
  extends MultiOperatorBase
  implements IMultiOperator
{
  private static final long ENTER_ROOM_TIMEOUT = 30000L;
  private static final String TAG = "MultiOperatorImpl";
  private AudioManager mAudioManager;
  private int mAudioRoute;
  private Runnable mEnterRoomTimeoutCheck;
  private boolean mHasEnterRoom;
  private boolean mLocalAudioEnable;
  private QavDef.MultiParams mMultiParams;
  private boolean mRemoteAudioEnable;
  private boolean mRequestRoomInfo;
  private Map<Long, QavDef.MultiUserInfo> mUsers;
  
  public MultiOperatorImpl(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    super(paramContext, paramLong, paramVideoChannelInterface);
    AVLog.d("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), paramVideoChannelInterface }));
    this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    this.mUsers = new HashMap();
  }
  
  private void checkEnterRoomTimeout()
  {
    if (this.mEnterRoomTimeoutCheck == null)
    {
      this.mEnterRoomTimeoutCheck = new Runnable()
      {
        public void run()
        {
          MultiOperatorImpl.this.exitRoom();
          MultiOperatorImpl.this.notifyError(1);
          MultiOperatorImpl.access$102(MultiOperatorImpl.this, null);
        }
      };
      ThreadManager.executeOnSubThreadDelay(this.mEnterRoomTimeoutCheck, 30000L);
    }
  }
  
  private QavDef.MultiUserInfo getMultiUserInfo(long paramLong)
  {
    QavDef.MultiUserInfo localMultiUserInfo = null;
    if (this.mUsers != null) {
      localMultiUserInfo = (QavDef.MultiUserInfo)this.mUsers.get(Long.valueOf(paramLong));
    }
    return localMultiUserInfo;
  }
  
  private List<QavDef.MultiUserInfo> getMultiUserList()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mUsers != null)
    {
      Collection localCollection = this.mUsers.values();
      localObject1 = localObject2;
      if (!localCollection.isEmpty()) {
        localObject1 = new ArrayList(localCollection);
      }
    }
    return localObject1;
  }
  
  private void notifyError(int paramInt)
  {
    AVLog.e("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    ObserverDispatcher.instance().notifyObservers(QavMultiObserver.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void notifyUserAudioAvailable(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    ObserverDispatcher.instance().notifyObservers(QavMultiObserver.class, 5, new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) });
  }
  
  private void notifyUserEnter(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    ObserverDispatcher.instance().notifyObservers(QavMultiObserver.class, 3, new Object[] { paramMultiUserInfo });
  }
  
  private void notifyUserExit(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    ObserverDispatcher.instance().notifyObservers(QavMultiObserver.class, 4, new Object[] { paramMultiUserInfo });
  }
  
  private void putMultiUserInfo(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (this.mUsers != null) {
      this.mUsers.put(Long.valueOf(paramMultiUserInfo.mUin), paramMultiUserInfo);
    }
  }
  
  private void removeEnterRoomTimeout()
  {
    if (this.mEnterRoomTimeoutCheck != null)
    {
      ThreadManager.removeSubThreadCallbacks(this.mEnterRoomTimeoutCheck);
      this.mEnterRoomTimeoutCheck = null;
    }
  }
  
  private QavDef.MultiUserInfo removeMultiUserInfo(long paramLong)
  {
    QavDef.MultiUserInfo localMultiUserInfo = null;
    if (this.mUsers != null) {
      localMultiUserInfo = (QavDef.MultiUserInfo)this.mUsers.remove(Long.valueOf(paramLong));
    }
    return localMultiUserInfo;
  }
  
  private void setLocalAudioEnable(boolean paramBoolean)
  {
    AVLog.d("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.mGAudioCtrl != null)
    {
      if (paramBoolean) {
        this.mGAudioCtrl.startAudioSend(true);
      }
    }
    else {
      return;
    }
    this.mGAudioCtrl.stopAudioSend(true);
  }
  
  private void setRemoteAudioEnable(boolean paramBoolean)
  {
    AVLog.d("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.mGAudioCtrl != null)
    {
      if (paramBoolean) {
        this.mGAudioCtrl.startAudioRecv();
      }
    }
    else {
      return;
    }
    this.mGAudioCtrl.stopAudioRecv();
  }
  
  private void updateRoomInfoInternal()
  {
    if (this.mGAudioCtrl != null) {
      this.mGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.mUsers != null)
      {
        this.mUsers.clear();
        this.mUsers = null;
      }
      super.destroy();
      return;
    }
    finally {}
  }
  
  public void enableLocalAudio(boolean paramBoolean)
  {
    setLocalAudioEnable(paramBoolean);
    this.mLocalAudioEnable = paramBoolean;
  }
  
  public void enableRemoteAudio(boolean paramBoolean)
  {
    setRemoteAudioEnable(paramBoolean);
    this.mRemoteAudioEnable = paramBoolean;
  }
  
  /* Error */
  public int enterRoom(QavDef.MultiParams paramMultiParams)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 16
    //   4: ldc 231
    //   6: iconst_1
    //   7: anewarray 40	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokestatic 58	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 233	com/tencent/qav/controller/multi/MultiOperatorImpl:mHasEnterRoom	Z
    //   24: ifeq +17 -> 41
    //   27: ldc 16
    //   29: ldc 235
    //   31: invokestatic 141	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: bipush 253
    //   36: istore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_2
    //   40: ireturn
    //   41: aload_0
    //   42: getfield 239	com/tencent/qav/controller/multi/MultiOperatorImpl:mVideoChannel	Lcom/tencent/qav/channel/VideoChannelInterface;
    //   45: invokestatic 245	com/tencent/qav/controller/QavCtrl:updateGateway	(Lcom/tencent/qav/channel/VideoChannelInterface;)V
    //   48: aload_0
    //   49: getfield 239	com/tencent/qav/controller/multi/MultiOperatorImpl:mVideoChannel	Lcom/tencent/qav/channel/VideoChannelInterface;
    //   52: aload_0
    //   53: getfield 62	com/tencent/qav/controller/multi/MultiOperatorImpl:mContext	Landroid/content/Context;
    //   56: aload_0
    //   57: getfield 248	com/tencent/qav/controller/multi/MultiOperatorImpl:mSelfUin	J
    //   60: invokestatic 252	com/tencent/qav/controller/QavCtrl:updateVideoConfig	(Lcom/tencent/qav/channel/VideoChannelInterface;Landroid/content/Context;J)V
    //   63: iconst_m1
    //   64: istore_2
    //   65: aload_0
    //   66: getfield 188	com/tencent/qav/controller/multi/MultiOperatorImpl:mGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   69: ifnull +80 -> 149
    //   72: aload_0
    //   73: aload_1
    //   74: putfield 254	com/tencent/qav/controller/multi/MultiOperatorImpl:mMultiParams	Lcom/tencent/qav/QavDef$MultiParams;
    //   77: aload_0
    //   78: getfield 188	com/tencent/qav/controller/multi/MultiOperatorImpl:mGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   81: aload_1
    //   82: getfield 259	com/tencent/qav/QavDef$MultiParams:mRelationType	I
    //   85: aload_1
    //   86: getfield 262	com/tencent/qav/QavDef$MultiParams:mMultiAVType	I
    //   89: aload_1
    //   90: getfield 265	com/tencent/qav/QavDef$MultiParams:mMultiAVSubType	I
    //   93: aload_1
    //   94: getfield 268	com/tencent/qav/QavDef$MultiParams:mRoomId	I
    //   97: i2l
    //   98: aload_0
    //   99: getfield 248	com/tencent/qav/controller/multi/MultiOperatorImpl:mSelfUin	J
    //   102: aload_1
    //   103: getfield 271	com/tencent/qav/QavDef$MultiParams:mOpenId	Ljava/lang/String;
    //   106: aload_1
    //   107: getfield 274	com/tencent/qav/QavDef$MultiParams:mSourceId	I
    //   110: aload_1
    //   111: getfield 278	com/tencent/qav/QavDef$MultiParams:mSig	[B
    //   114: invokevirtual 282	com/tencent/av/gaudio/QQGAudioCtrl:startCommonGAudio	(IIIJJLjava/lang/String;I[B)I
    //   117: istore_2
    //   118: ldc 16
    //   120: ldc_w 284
    //   123: iconst_1
    //   124: anewarray 40	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: iload_2
    //   130: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   137: invokestatic 58	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_0
    //   141: invokespecial 286	com/tencent/qav/controller/multi/MultiOperatorImpl:checkEnterRoomTimeout	()V
    //   144: aload_0
    //   145: iconst_1
    //   146: putfield 233	com/tencent/qav/controller/multi/MultiOperatorImpl:mHasEnterRoom	Z
    //   149: iload_2
    //   150: ifne +8 -> 158
    //   153: iconst_0
    //   154: istore_2
    //   155: goto -118 -> 37
    //   158: iconst_m1
    //   159: istore_2
    //   160: goto -123 -> 37
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	MultiOperatorImpl
    //   0	168	1	paramMultiParams	QavDef.MultiParams
    //   36	124	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	34	163	finally
    //   41	63	163	finally
    //   65	149	163	finally
  }
  
  public void exitRoom()
  {
    try
    {
      AVLog.d("MultiOperatorImpl", "exitRoom");
      this.mMultiParams = null;
      if (this.mUsers != null) {
        this.mUsers.clear();
      }
      if (this.mGAudioCtrl != null)
      {
        this.mGAudioCtrl.quit(0);
        removeEnterRoomTimeout();
        this.mHasEnterRoom = false;
      }
      return;
    }
    finally {}
  }
  
  public int getAudioRoute()
  {
    return this.mAudioRoute;
  }
  
  public boolean isLocalAudioEnable()
  {
    return this.mLocalAudioEnable;
  }
  
  public boolean isRemoteAudioEnable()
  {
    return this.mRemoteAudioEnable;
  }
  
  public void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2)
  {
    AVLog.d("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    QavDef.MultiUserInfo localMultiUserInfo;
    if (!paramBoolean)
    {
      bool1 = true;
      AVLog.d("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localMultiUserInfo = getMultiUserInfo(paramLong);
      if (localMultiUserInfo != null) {
        if (paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localMultiUserInfo.mMicOn = paramBoolean;
      if ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.mMultiParams.mRelationType != 11)) {
        notifyUserAudioAvailable(localMultiUserInfo, bool1);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onGAudioSDKError(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AVLog.e("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    exitRoom();
    removeEnterRoomTimeout();
    if (paramInt2 == 15)
    {
      notifyError(3);
      return;
    }
    notifyError(2);
  }
  
  public void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AVLog.d("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    exitRoom();
    removeEnterRoomTimeout();
    notifyError(2);
  }
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (paramInt1 == 70)
    {
      AVLog.d("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      if (paramAVUserInfo.account == this.mSelfUin)
      {
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          removeEnterRoomTimeout();
          ObserverDispatcher.instance().notifyObservers(QavMultiObserver.class, 1, new Object[0]);
        }
        paramVarArgs = getMultiUserInfo(paramAVUserInfo.account);
        if ((paramVarArgs == null) && (paramInt1 == 0)) {
          break label156;
        }
        paramAVUserInfo = paramVarArgs;
        if (paramInt1 != 0)
        {
          paramAVUserInfo = new QavDef.MultiUserInfo();
          paramAVUserInfo.mUin = this.mMultiParams.mUin;
          paramAVUserInfo.mOpenId = this.mMultiParams.mOpenId;
          paramAVUserInfo.mMicOn = true;
          putMultiUserInfo(paramAVUserInfo);
        }
        notifyUserEnter(paramAVUserInfo);
      }
    }
    label156:
    do
    {
      do
      {
        return;
        paramInt1 = 0;
        break;
        paramVarArgs = new QavDef.MultiUserInfo();
        paramVarArgs.mUin = paramAVUserInfo.account;
        paramVarArgs.mMicOn = true;
        putMultiUserInfo(paramVarArgs);
        if (this.mMultiParams.mRelationType == 11)
        {
          updateRoomInfoInternal();
          return;
        }
        notifyUserEnter(paramVarArgs);
        return;
      } while (paramInt1 != 71);
      AVLog.d("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      paramAVUserInfo = removeMultiUserInfo(paramAVUserInfo.account);
    } while (paramAVUserInfo == null);
    notifyUserExit(paramAVUserInfo);
  }
  
  public void onMemberPosChanged(long paramLong, ArrayList<AVUserInfo> paramArrayList)
  {
    if (this.mMultiParams.mRelationType == 11)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        AVUserInfo localAVUserInfo = (AVUserInfo)localIterator.next();
        QavDef.MultiUserInfo localMultiUserInfo = getMultiUserInfo(localAVUserInfo.account);
        paramArrayList = localMultiUserInfo;
        if (localMultiUserInfo == null)
        {
          paramArrayList = new QavDef.MultiUserInfo();
          paramArrayList.mUin = localAVUserInfo.account;
          paramArrayList.mMicOn = true;
          putMultiUserInfo(paramArrayList);
        }
        int i = 0;
        if (TextUtils.isEmpty(paramArrayList.mOpenId))
        {
          paramArrayList.mOpenId = localAVUserInfo.openId;
          i = 1;
        }
        if (i != 0)
        {
          notifyUserEnter(paramArrayList);
          if (!paramArrayList.mMicOn) {
            notifyUserAudioAvailable(paramArrayList, false);
          }
        }
      }
    }
    if (this.mRequestRoomInfo)
    {
      paramArrayList = getMultiUserList();
      AVLog.d("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
      ObserverDispatcher.instance().notifyObservers(QavMultiObserver.class, 7, new Object[] { paramArrayList });
      this.mRequestRoomInfo = false;
    }
  }
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3)
  {
    if ((paramInt1 == 42) || (paramInt1 == 43))
    {
      if (paramInt1 == 42) {}
      for (boolean bool = true;; bool = false)
      {
        paramInt2 = paramArrayOfLong.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          QavDef.MultiUserInfo localMultiUserInfo = getMultiUserInfo(paramArrayOfLong[paramInt1]);
          if ((localMultiUserInfo != null) && ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.mMultiParams.mRelationType != 11))) {
            ObserverDispatcher.instance().notifyObservers(QavMultiObserver.class, 6, new Object[] { localMultiUserInfo, Boolean.valueOf(bool) });
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void setAudioRoute(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mAudioManager.setSpeakerphoneOn(true);
      this.mAudioManager.setMode(0);
      this.mAudioRoute = paramInt;
    }
    while (paramInt != 0) {
      return;
    }
    this.mAudioManager.setSpeakerphoneOn(false);
    if (Build.VERSION.SDK_INT >= 21) {
      this.mAudioManager.setMode(3);
    }
    for (;;)
    {
      this.mAudioRoute = paramInt;
      return;
      this.mAudioManager.setMode(2);
    }
  }
  
  public void updateRoomInfo()
  {
    try
    {
      AVLog.d("MultiOperatorImpl", "updateRoomInfo");
      updateRoomInfoInternal();
      this.mRequestRoomInfo = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.multi.MultiOperatorImpl
 * JD-Core Version:    0.7.0.1
 */