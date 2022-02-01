package com.tencent.qav;

import android.content.Context;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.controller.c2c.IC2COperator;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.controller.nodereport.NodeReportOperator;
import com.tencent.qav.observer.FilterableObserver;
import com.tencent.qav.observer.ObserverDispatcher;
import com.tencent.qav.session.SessionMgr;

public class QavSDK
  implements IQavSDK
{
  public static final int AppType_Audio = 0;
  public static final int AppType_Audio_SwitchTer = 1;
  public static final int AppType_Video = 1;
  public static final int AppType_Video_SwitchTer = 0;
  public static final int RelationType_Discuss = 2;
  public static final int RelationType_Friends = 1;
  public static final int RelationType_Group = 3;
  public static final int RelationType_Temp = 4;
  public static final int RelationType_Tribe_Temp = 27;
  private static final String TAG = "QavSDK";
  private static volatile QavSDK sInstance;
  private Context mContext;
  private boolean mInited = false;
  private QavCtrl mQavCtrl;
  private long mSelfUin;
  private SessionMgr mSessionMgr = SessionMgr.getInstanse();
  private VideoChannelInterface mVideoChannel;
  
  public static QavSDK getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QavSDK();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void addObserver(FilterableObserver paramFilterableObserver)
  {
    ObserverDispatcher.instance().addObserver(paramFilterableObserver, true);
  }
  
  public IC2COperator getC2COperator()
  {
    IC2COperator localIC2COperator = null;
    if (this.mQavCtrl != null) {
      localIC2COperator = this.mQavCtrl.getC2COperator();
    }
    return localIC2COperator;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public IMultiOperator getMultiOperator()
  {
    IMultiOperator localIMultiOperator = null;
    if (this.mQavCtrl != null) {
      localIMultiOperator = this.mQavCtrl.getMultiOperator();
    }
    return localIMultiOperator;
  }
  
  public NodeReportOperator getNodeReportOperator()
  {
    NodeReportOperator localNodeReportOperator = null;
    if (this.mQavCtrl != null) {
      localNodeReportOperator = this.mQavCtrl.getNodeReportOperator();
    }
    return localNodeReportOperator;
  }
  
  public SessionMgr getSessionMgr()
  {
    return this.mSessionMgr;
  }
  
  /* Error */
  public void initSDK(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 26
    //   4: ldc 98
    //   6: iconst_3
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_2
    //   17: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: aload 4
    //   25: aastore
    //   26: invokestatic 110	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokestatic 116	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 46	com/tencent/qav/QavSDK:mInited	Z
    //   36: ifeq +13 -> 49
    //   39: ldc 26
    //   41: ldc 118
    //   43: invokestatic 121	com/tencent/qav/log/AVLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 126	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putfield 83	com/tencent/qav/QavSDK:mContext	Landroid/content/Context;
    //   57: aload_0
    //   58: lload_2
    //   59: putfield 128	com/tencent/qav/QavSDK:mSelfUin	J
    //   62: aload_0
    //   63: aload 4
    //   65: putfield 130	com/tencent/qav/QavSDK:mVideoChannel	Lcom/tencent/qav/channel/VideoChannelInterface;
    //   68: aload_0
    //   69: getfield 75	com/tencent/qav/QavSDK:mQavCtrl	Lcom/tencent/qav/controller/QavCtrl;
    //   72: ifnonnull +26 -> 98
    //   75: aload_0
    //   76: new 77	com/tencent/qav/controller/QavCtrl
    //   79: dup
    //   80: aload_0
    //   81: getfield 83	com/tencent/qav/QavSDK:mContext	Landroid/content/Context;
    //   84: aload_0
    //   85: getfield 128	com/tencent/qav/QavSDK:mSelfUin	J
    //   88: aload_0
    //   89: getfield 130	com/tencent/qav/QavSDK:mVideoChannel	Lcom/tencent/qav/channel/VideoChannelInterface;
    //   92: invokespecial 132	com/tencent/qav/controller/QavCtrl:<init>	(Landroid/content/Context;JLcom/tencent/qav/channel/VideoChannelInterface;)V
    //   95: putfield 75	com/tencent/qav/QavSDK:mQavCtrl	Lcom/tencent/qav/controller/QavCtrl;
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 46	com/tencent/qav/QavSDK:mInited	Z
    //   103: goto -57 -> 46
    //   106: astore_1
    //   107: ldc 26
    //   109: ldc 134
    //   111: aload_1
    //   112: invokestatic 138	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 75	com/tencent/qav/QavSDK:mQavCtrl	Lcom/tencent/qav/controller/QavCtrl;
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 46	com/tencent/qav/QavSDK:mInited	Z
    //   125: goto -79 -> 46
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	QavSDK
    //   0	133	1	paramContext	Context
    //   0	133	2	paramLong	long
    //   0	133	4	paramVideoChannelInterface	VideoChannelInterface
    // Exception table:
    //   from	to	target	type
    //   49	98	106	java/lang/Throwable
    //   98	103	106	java/lang/Throwable
    //   2	46	128	finally
    //   49	98	128	finally
    //   98	103	128	finally
    //   107	125	128	finally
  }
  
  public void removeObserver(FilterableObserver paramFilterableObserver)
  {
    ObserverDispatcher.instance().removeObserver(paramFilterableObserver);
  }
  
  public void unInitSDK()
  {
    try
    {
      ObserverDispatcher.instance().destroy();
      if (this.mQavCtrl != null)
      {
        this.mQavCtrl.destroy();
        this.mQavCtrl = null;
      }
      this.mContext = null;
      this.mSelfUin = 0L;
      this.mVideoChannel = null;
      this.mInited = false;
      sInstance = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.QavSDK
 * JD-Core Version:    0.7.0.1
 */