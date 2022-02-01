package com.tencent.mm.live.core.core.trtc.sdkadapter.b;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.TextureView;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private i mSD;
  public TRTCCloud mSx;
  private final a mTD;
  public boolean mTE;
  public ArrayList<b> mTF;
  public String mTG;
  public String mTH;
  private HashMap<String, h> mTI;
  public int mTJ;
  public int mTK;
  int mTL;
  JSONObject mTM;
  private MTimerHandler mTN;
  public JSONObject mTO;
  
  public c(TRTCCloud paramTRTCCloud, a parama, int paramInt, i parami)
  {
    AppMethodBeat.i(248324);
    this.mTJ = 1258344707;
    this.mTK = 58415;
    this.mTL = 0;
    this.mSD = null;
    this.mTM = null;
    this.mTN = new MTimerHandler("link_mic_sei_sender", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(248312);
        dlh localdlh;
        if (c.this.mTM != null)
        {
          Object localObject1 = c.this.mTM.optString("d");
          try
          {
            dlg localdlg = new dlg();
            localdlg.parseFrom(((String)localObject1).getBytes(kotlin.n.d.UTF_8));
            if (localdlg.ToF != null)
            {
              localObject1 = localdlg.ToF.iterator();
              for (;;)
              {
                if (((Iterator)localObject1).hasNext())
                {
                  localdlh = (dlh)((Iterator)localObject1).next();
                  Object localObject2 = b.a.bfv().FU(localdlh.YRR);
                  if (localObject2 != null) {
                    if (((a)localObject2).mTx <= c.this.mTL)
                    {
                      int i = localdlh.aaRl;
                      localObject2 = e.m.mLr;
                      localdlh.aaRl = (i | e.m.bdw());
                      continue;
                      AppMethodBeat.o(248312);
                    }
                  }
                }
              }
            }
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.LiveCoreVisitor", "send mic sei fail! %s", new Object[] { localException.getMessage() });
          }
        }
        for (;;)
        {
          return true;
          localdlh.aaRl = 0;
          break;
          String str = new String(localException.toByteArray());
          c.this.mTM.putOpt("d", str);
          c.this.mSx.sendSEIMsg(c.this.mTM.toString().getBytes(), 1);
        }
      }
    }, true);
    this.mTO = null;
    this.mSx = paramTRTCCloud;
    this.mTD = parama;
    this.mTE = true;
    this.mTF = new ArrayList();
    this.mTI = new HashMap();
    this.mTL = paramInt;
    this.mSD = parami;
    AppMethodBeat.o(248324);
  }
  
  private boolean FV(String paramString)
  {
    AppMethodBeat.i(248333);
    Iterator localIterator = this.mTF.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(248333);
        return true;
      }
    }
    AppMethodBeat.o(248333);
    return false;
  }
  
  private JSONObject a(TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    AppMethodBeat.i(248390);
    Object localObject1 = paramTRTCTranscodingConfig.mixUsers;
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      Log.i("MicroMsg.LiveCoreVisitor", "prepareAnchorInfoLinkMicJson return nil, mixUserList == null or mixUserList.size == 0");
      AppMethodBeat.o(248390);
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label539;
        }
        localObject2 = (TRTCCloudDef.TRTCMixUser)((Iterator)localObject1).next();
        if (i != 0) {
          break;
        }
        localJSONObject1.putOpt("x", ei(((TRTCCloudDef.TRTCMixUser)localObject2).x, paramTRTCTranscodingConfig.videoWidth));
        localJSONObject1.putOpt("y", ei(((TRTCCloudDef.TRTCMixUser)localObject2).y, paramTRTCTranscodingConfig.videoHeight));
        localJSONObject1.putOpt("w", ei(((TRTCCloudDef.TRTCMixUser)localObject2).width, paramTRTCTranscodingConfig.videoWidth));
        localJSONObject1.putOpt("h", ei(((TRTCCloudDef.TRTCMixUser)localObject2).height, paramTRTCTranscodingConfig.videoHeight));
        Log.i("MicroMsg.LiveCoreVisitor", "prepareAnchorInfoLinkMicJson: add userInfo, index: " + i + ", info:" + localJSONObject1);
        i += 1;
      }
      localJSONObject2 = new JSONObject();
      localJSONObject2.putOpt("uId", ((TRTCCloudDef.TRTCMixUser)localObject2).userId);
      localJSONObject2.putOpt("x", ei(((TRTCCloudDef.TRTCMixUser)localObject2).x, paramTRTCTranscodingConfig.videoWidth));
      localJSONObject2.putOpt("y", ei(((TRTCCloudDef.TRTCMixUser)localObject2).y, paramTRTCTranscodingConfig.videoHeight));
      localJSONObject2.putOpt("w", ei(((TRTCCloudDef.TRTCMixUser)localObject2).width, paramTRTCTranscodingConfig.videoWidth));
      localJSONObject2.putOpt("h", ei(((TRTCCloudDef.TRTCMixUser)localObject2).height, paramTRTCTranscodingConfig.videoHeight));
      localObject3 = b.a.bfv().FU(((TRTCCloudDef.TRTCMixUser)localObject2).userId);
      if (localObject3 == null) {
        break label566;
      }
      if (((a)localObject3).mTx > this.mTL) {
        break label475;
      }
      localm = e.m.mLr;
      j = e.m.bdw() | 0x0;
      label356:
      if (!((a)localObject3).mTy) {
        break label491;
      }
      localObject3 = e.m.mLr;
      j |= e.m.bdy();
    }
    catch (JSONException paramTRTCTranscodingConfig)
    {
      for (;;)
      {
        int i;
        Object localObject2;
        JSONObject localJSONObject2;
        Object localObject3;
        e.m localm;
        label375:
        paramTRTCTranscodingConfig = null;
        label396:
        label475:
        label491:
        continue;
        label523:
        label539:
        int j = 0;
      }
    }
    if (this.mSD.bex())
    {
      localObject3 = e.m.mLr;
      j |= e.m.bdx();
      if (((TRTCCloudDef.TRTCMixUser)localObject2).roomId == null) {
        break label523;
      }
      localObject2 = e.m.mLr;
    }
    for (j = e.m.bdz() | j;; j = (e.m.bdz() ^ 0xFFFFFFFF) & j)
    {
      localJSONObject2.putOpt("us", Integer.valueOf(j));
      localJSONArray.put(localJSONObject2);
      Log.i("MicroMsg.LiveCoreVisitor", "prepareAnchorInfoLinkMicJson: add userInfo, index: " + i + ", userInfo:" + localJSONObject2);
      i += 1;
      break;
      localm = e.m.mLr;
      j = (e.m.bdw() ^ 0xFFFFFFFF) & 0x0;
      break label356;
      localObject3 = e.m.mLr;
      j &= (e.m.bdy() ^ 0xFFFFFFFF);
      break label375;
      localObject3 = e.m.mLr;
      j &= (e.m.bdx() ^ 0xFFFFFFFF);
      break label396;
      localObject2 = e.m.mLr;
    }
    localJSONObject1.putOpt("list", localJSONArray);
    paramTRTCTranscodingConfig = localJSONObject1;
    AppMethodBeat.o(248390);
    return paramTRTCTranscodingConfig;
  }
  
  private void a(List<a> paramList, TRTCCloudDef.TRTCMixUser paramTRTCMixUser, TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig, String paramString, Point paramPoint, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248384);
    int i = paramList.size();
    int j = paramPoint.x;
    int k = paramPoint.y;
    paramTRTCMixUser.x = j;
    paramTRTCMixUser.y = k;
    Log.i("MicroMsg.LiveCoreVisitor", "configRoomPkParams: userConfigList.size:%d, roomId:%s, originX:%d, originY:%d, videoWidth:%d, videoHeight:%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (i)
    {
    }
    for (;;)
    {
      TXLog.i("MicroMsg.LiveCoreVisitor", "configRoomPkParams: anchor userId " + paramTRTCMixUser.userId + ", pureAudioMode: " + paramTRTCMixUser.pureAudio + ", width: " + paramTRTCMixUser.width + ", height: " + paramTRTCMixUser.height);
      AppMethodBeat.o(248384);
      return;
      paramTRTCMixUser.width = (paramInt1 / 2);
      paramTRTCMixUser.height = (paramInt2 / 2);
      continue;
      paramTRTCMixUser.width = (paramInt1 / 2);
      paramTRTCMixUser.height = (paramInt2 / 4);
      paramList = paramList.iterator();
      i = 0;
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (a)paramList.next();
        paramPoint = new TRTCCloudDef.TRTCMixUser();
        paramPoint.roomId = paramString;
        paramPoint.userId = ((a)localObject).luk;
        paramPoint.streamType = ((a)localObject).mStreamType;
        paramPoint.zOrder = (i + 1);
        paramPoint.pureAudio = true;
        paramPoint.width = (paramInt1 / 2);
        paramPoint.height = (paramInt2 / 4);
        paramPoint.x = j;
        paramPoint.y = (paramTRTCMixUser.height + k);
        localObject = FW(paramPoint.userId);
        if (localObject != null) {
          paramPoint.pureAudio = ((b)localObject).mTR;
        }
        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + paramPoint.userId + ", pureAudioMode: " + paramPoint.pureAudio + ", userStream: " + localObject);
        Log.i("MicroMsg.LiveCoreVisitor", "configRoomPkParams: add mixUser, userId:%s, x:%d, y:%d, width:%d, height:%d", new Object[] { paramPoint.userId, Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Integer.valueOf(paramPoint.width), Integer.valueOf(paramPoint.height) });
        paramTRTCTranscodingConfig.mixUsers.add(paramPoint);
        i += 1;
      }
      paramTRTCMixUser.width = (paramInt1 / 2);
      paramTRTCMixUser.height = (paramInt2 / 4);
      paramList = paramList.iterator();
      i = 0;
      while (paramList.hasNext())
      {
        localObject = (a)paramList.next();
        paramPoint = new TRTCCloudDef.TRTCMixUser();
        paramPoint.roomId = paramString;
        paramPoint.userId = ((a)localObject).luk;
        paramPoint.streamType = ((a)localObject).mStreamType;
        paramPoint.zOrder = (i + 1);
        paramPoint.pureAudio = true;
        paramPoint.width = (paramInt1 / 4);
        paramPoint.height = (paramInt2 / 4);
        paramPoint.x = (paramPoint.width * i + j);
        paramPoint.y = (paramTRTCMixUser.height + k);
        localObject = FW(paramPoint.userId);
        if (localObject != null) {
          paramPoint.pureAudio = ((b)localObject).mTR;
        }
        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + paramPoint.userId + ", pureAudioMode: " + paramPoint.pureAudio + ", userStream: " + localObject);
        Log.i("MicroMsg.LiveCoreVisitor", "configRoomPkParams: add mixUser, userId:%s, x:%d, y:%d, width:%d, height:%d", new Object[] { paramPoint.userId, Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Integer.valueOf(paramPoint.width), Integer.valueOf(paramPoint.height) });
        paramTRTCTranscodingConfig.mixUsers.add(paramPoint);
        i += 1;
      }
    }
  }
  
  private void b(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(248339);
    if (paramTXCloudVideoView != null)
    {
      this.mSx.setDebugViewMargin(paramString, new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F));
      this.mSx.setRemoteViewFillMode(paramString, 1);
      this.mSx.startRemoteView(paramString, paramTXCloudVideoView);
      AppMethodBeat.o(248339);
      return;
    }
    AppMethodBeat.o(248339);
  }
  
  /* Error */
  private JSONObject bB(List<TRTCCloudDef.TRTCMixUser> paramList)
  {
    // Byte code:
    //   0: ldc_w 361
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +19 -> 26
    //   10: ldc 142
    //   12: ldc_w 363
    //   15: invokestatic 149	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc_w 361
    //   21: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 84	java/util/ArrayList
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 366	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   34: astore 4
    //   36: aload 4
    //   38: invokeinterface 140 1 0
    //   43: ifle +12 -> 55
    //   46: aload 4
    //   48: iconst_0
    //   49: invokeinterface 370 2 0
    //   54: pop
    //   55: aload 4
    //   57: invokeinterface 140 1 0
    //   62: ifne +19 -> 81
    //   65: ldc 142
    //   67: ldc_w 372
    //   70: invokestatic 149	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 361
    //   76: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aconst_null
    //   80: areturn
    //   81: new 84	java/util/ArrayList
    //   84: dup
    //   85: invokespecial 85	java/util/ArrayList:<init>	()V
    //   88: astore_1
    //   89: aload 4
    //   91: invokeinterface 156 1 0
    //   96: astore 4
    //   98: aload 4
    //   100: invokeinterface 109 1 0
    //   105: ifeq +167 -> 272
    //   108: aload 4
    //   110: invokeinterface 113 1 0
    //   115: checkcast 158	com/tencent/trtc/TRTCCloudDef$TRTCMixUser
    //   118: astore 6
    //   120: new 374	com/tencent/mm/protocal/protobuf/dlh
    //   123: dup
    //   124: invokespecial 375	com/tencent/mm/protocal/protobuf/dlh:<init>	()V
    //   127: astore 5
    //   129: invokestatic 222	com/tencent/mm/live/core/core/trtc/sdkadapter/b/b$a:bfv	()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/b/b;
    //   132: aload 6
    //   134: getfield 216	com/tencent/trtc/TRTCCloudDef$TRTCMixUser:userId	Ljava/lang/String;
    //   137: invokevirtual 228	com/tencent/mm/live/core/core/trtc/sdkadapter/b/b:FU	(Ljava/lang/String;)Lcom/tencent/mm/live/core/core/trtc/sdkadapter/b/a;
    //   140: astore 7
    //   142: aload 5
    //   144: aload 6
    //   146: getfield 216	com/tencent/trtc/TRTCCloudDef$TRTCMixUser:userId	Ljava/lang/String;
    //   149: putfield 378	com/tencent/mm/protocal/protobuf/dlh:YRR	Ljava/lang/String;
    //   152: aload 6
    //   154: getfield 296	com/tencent/trtc/TRTCCloudDef$TRTCMixUser:pureAudio	Z
    //   157: ifne +101 -> 258
    //   160: iconst_1
    //   161: istore_3
    //   162: aload 5
    //   164: iload_3
    //   165: putfield 381	com/tencent/mm/protocal/protobuf/dlh:aaRk	Z
    //   168: aload 7
    //   170: ifnull +36 -> 206
    //   173: aload 7
    //   175: getfield 233	com/tencent/mm/live/core/core/trtc/sdkadapter/b/a:mTx	I
    //   178: aload_0
    //   179: getfield 58	com/tencent/mm/live/core/core/trtc/sdkadapter/b/c:mTL	I
    //   182: if_icmpgt +81 -> 263
    //   185: aload 5
    //   187: getfield 384	com/tencent/mm/protocal/protobuf/dlh:aaRl	I
    //   190: istore_2
    //   191: getstatic 239	com/tencent/mm/live/core/core/e$m:mLr	Lcom/tencent/mm/live/core/core/e$m;
    //   194: astore 6
    //   196: aload 5
    //   198: iload_2
    //   199: invokestatic 242	com/tencent/mm/live/core/core/e$m:bdw	()I
    //   202: ior
    //   203: putfield 384	com/tencent/mm/protocal/protobuf/dlh:aaRl	I
    //   206: aload_1
    //   207: aload 5
    //   209: invokeinterface 385 2 0
    //   214: pop
    //   215: ldc 142
    //   217: new 192	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 387
    //   224: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload 5
    //   229: getfield 378	com/tencent/mm/protocal/protobuf/dlh:YRR	Ljava/lang/String;
    //   232: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 389
    //   238: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 5
    //   243: getfield 381	com/tencent/mm/protocal/protobuf/dlh:aaRk	Z
    //   246: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   249: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 149	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: goto -157 -> 98
    //   258: iconst_0
    //   259: istore_3
    //   260: goto -98 -> 162
    //   263: aload 5
    //   265: iconst_0
    //   266: putfield 384	com/tencent/mm/protocal/protobuf/dlh:aaRl	I
    //   269: goto -63 -> 206
    //   272: new 391	com/tencent/mm/protocal/protobuf/dlg
    //   275: dup
    //   276: invokespecial 392	com/tencent/mm/protocal/protobuf/dlg:<init>	()V
    //   279: astore 4
    //   281: aload 4
    //   283: getfield 396	com/tencent/mm/protocal/protobuf/dlg:ToF	Ljava/util/LinkedList;
    //   286: aload_1
    //   287: invokevirtual 402	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   290: pop
    //   291: new 118	java/lang/String
    //   294: dup
    //   295: aload 4
    //   297: invokevirtual 406	com/tencent/mm/protocal/protobuf/dlg:toByteArray	()[B
    //   300: invokespecial 409	java/lang/String:<init>	([B)V
    //   303: astore 4
    //   305: new 151	org/json/JSONObject
    //   308: dup
    //   309: invokespecial 152	org/json/JSONObject:<init>	()V
    //   312: astore_1
    //   313: aload_1
    //   314: ldc_w 411
    //   317: getstatic 417	com/tencent/mm/live/core/core/e$q:mLK	Lcom/tencent/mm/live/core/core/e$q;
    //   320: getfield 420	com/tencent/mm/live/core/core/e$q:value	I
    //   323: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   326: invokevirtual 173	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload_1
    //   331: ldc_w 422
    //   334: aload 4
    //   336: invokevirtual 173	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   339: pop
    //   340: ldc_w 361
    //   343: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: aload_1
    //   347: areturn
    //   348: astore_1
    //   349: aconst_null
    //   350: astore_1
    //   351: goto -11 -> 340
    //   354: astore 4
    //   356: goto -16 -> 340
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_1
    //   362: goto -22 -> 340
    //   365: astore 4
    //   367: goto -27 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	c
    //   0	370	1	paramList	List<TRTCCloudDef.TRTCMixUser>
    //   190	13	2	i	int
    //   161	99	3	bool	boolean
    //   34	301	4	localObject1	Object
    //   354	1	4	localJSONException	JSONException
    //   365	1	4	localIOException	java.io.IOException
    //   127	137	5	localdlh	dlh
    //   118	77	6	localObject2	Object
    //   140	34	7	locala	a
    // Exception table:
    //   from	to	target	type
    //   291	313	348	org/json/JSONException
    //   313	340	354	org/json/JSONException
    //   291	313	359	java/io/IOException
    //   313	340	365	java/io/IOException
  }
  
  private void bfx()
  {
    AppMethodBeat.i(248369);
    Log.i("MicroMsg.LiveCoreVisitor", "sendLinkMicSeiMsg linkMicSeiMsgJson:" + this.mTM);
    if (this.mTM == null)
    {
      this.mTN.stopTimer();
      AppMethodBeat.o(248369);
      return;
    }
    this.mTN.startTimer(1000L);
    AppMethodBeat.o(248369);
  }
  
  private void c(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(248349);
    Object localObject2 = FY(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new h(paramString);
    }
    localObject2 = new TextureView(paramTXCloudVideoView.getContext());
    ((TextureView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramTXCloudVideoView.addVideoView((TextureView)localObject2);
    ((TextureView)localObject2).setSurfaceTextureListener(new c.2(this, (h)localObject1));
    this.mSx.setRemoteVideoRenderListener(paramString, 1, 2, (TRTCCloudListener.TRTCVideoRenderListener)localObject1);
    this.mTI.put(paramString, localObject1);
    this.mSx.startRemoteView(paramString, null);
    ((TextureView)localObject2).invalidate();
    AppMethodBeat.o(248349);
  }
  
  private static String eh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248375);
    String str = "408";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.LiveCoreVisitor", "chooseLinkMicBackground: ".concat(String.valueOf(str)));
      AppMethodBeat.o(248375);
      return str;
      switch (paramInt2)
      {
      default: 
        break;
      case 0: 
        str = "408";
        break;
      case 1: 
        str = "409";
        break;
      case 2: 
        str = "2072";
        continue;
        switch (paramInt2)
        {
        default: 
          break;
        case 0: 
          str = "2073";
          break;
        case 1: 
          str = "410";
          break;
        case 2: 
          str = "2074";
          continue;
          switch (paramInt2)
          {
          default: 
            break;
          case 0: 
            str = "2075";
            break;
          case 1: 
            str = "2076";
            break;
          case 2: 
            str = "2077";
          }
          break;
        }
        break;
      }
    }
  }
  
  private static String ei(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248395);
    String str = new BigDecimal(1.0F * paramInt1 / paramInt2).setScale(2, 4).toPlainString();
    AppMethodBeat.o(248395);
    return str;
  }
  
  public final b FW(String paramString)
  {
    AppMethodBeat.i(248404);
    Iterator localIterator = this.mTF.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(248404);
        return localb;
      }
    }
    AppMethodBeat.o(248404);
    return null;
  }
  
  public final void FX(String paramString)
  {
    AppMethodBeat.i(248407);
    Iterator localIterator = this.mTF.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        localIterator.remove();
        TXLog.i("MicroMsg.LiveCoreVisitor", "removeVideoStream " + paramString + ", stream 0, size " + this.mTF.size());
        AppMethodBeat.o(248407);
        return;
      }
    }
    AppMethodBeat.o(248407);
  }
  
  public final h FY(String paramString)
  {
    AppMethodBeat.i(248413);
    if ((this.mTI != null) && (!Util.isNullOrNil(paramString)) && (this.mTI.containsKey(paramString)))
    {
      paramString = (h)this.mTI.get(paramString);
      AppMethodBeat.o(248413);
      return paramString;
    }
    AppMethodBeat.o(248413);
    return null;
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(248414);
    h localh = (h)this.mTI.remove(paramString);
    if (localh != null) {
      localh.release();
    }
    this.mSx.stopRemoteSubStreamView(paramString);
    AppMethodBeat.o(248414);
  }
  
  public final void a(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(248411);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    localb.mTR = false;
    if (b.a.bfv().FU(paramString) == null)
    {
      a locala = new a(paramString, (byte)0);
      b.a.bfv().a(locala);
    }
    if (!this.mTE) {
      b(paramString, paramTXCloudVideoView);
    }
    for (;;)
    {
      if (!FV(paramString))
      {
        this.mTF.add(localb);
        TXLog.i("MicroMsg.LiveCoreVisitor", "remoteUserVideoAvailable " + localb.userId + ", stream 0, size " + this.mTF.size());
      }
      AppMethodBeat.o(248411);
      return;
      c(paramString, paramTXCloudVideoView);
    }
  }
  
  public final void bfw()
  {
    AppMethodBeat.i(248419);
    int i = 720;
    int j = 1280;
    if (!a.a.bfr().bfn().mTf)
    {
      i = 1280;
      j = 720;
    }
    int k = 180;
    int m = 320;
    if (!a.a.bfr().bfn().mTp)
    {
      k = 320;
      m = 180;
    }
    int i3 = 50;
    int i2 = 1500;
    int i1;
    int n;
    switch (a.a.bfr().bfn().mSZ)
    {
    default: 
      i1 = m;
      n = i;
      m = j;
      j = i1;
      i1 = i3;
      i = i2;
      i2 = a.a.bfr().bfn().mVideoBitrate;
      if (i2 > 0) {
        i = i2;
      }
      i2 = a.a.bfr().bfn().mTa;
      if (i2 <= 0) {
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s, fps:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i2) });
      TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
      localTRTCTranscodingConfig.appId = this.mTJ;
      localTRTCTranscodingConfig.bizId = this.mTK;
      localTRTCTranscodingConfig.videoWidth = n;
      localTRTCTranscodingConfig.videoHeight = m;
      localTRTCTranscodingConfig.videoGOP = 1;
      localTRTCTranscodingConfig.videoFramerate = i2;
      localTRTCTranscodingConfig.videoBitrate = i;
      localTRTCTranscodingConfig.audioSampleRate = 48000;
      localTRTCTranscodingConfig.audioBitrate = 64;
      if (a.a.bfr().bfo().mSP == 3) {
        localTRTCTranscodingConfig.audioBitrate = 128;
      }
      localTRTCTranscodingConfig.audioChannels = 2;
      Object localObject1 = new TRTCCloudDef.TRTCMixUser();
      ((TRTCCloudDef.TRTCMixUser)localObject1).userId = this.mTG;
      ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).x = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).width = n;
      ((TRTCCloudDef.TRTCMixUser)localObject1).height = m;
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      localTRTCTranscodingConfig.mixUsers.add(localObject1);
      if (a.a.bfr().bfn().mTn)
      {
        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.mTF.size());
        localObject1 = b.a.bfv().mTz;
        label1453:
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          label501:
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (a)((Iterator)localObject1).next();
            TRTCCloudDef.TRTCMixUser localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
            com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d locald = a.a.bfr().bfp();
            if ((locald.mST) && (((a)localObject2).luk.equalsIgnoreCase(locald.mSS))) {
              localTRTCMixUser.roomId = locald.mSR;
            }
            localTRTCMixUser.userId = ((a)localObject2).luk;
            localTRTCMixUser.streamType = ((a)localObject2).mStreamType;
            localTRTCMixUser.zOrder = (i + 1);
            localTRTCMixUser.pureAudio = true;
            localObject2 = FW(localTRTCMixUser.userId);
            if (localObject2 != null)
            {
              localTRTCMixUser.pureAudio = ((b)localObject2).mTR;
              if (i >= 3) {
                break label1453;
              }
              localTRTCMixUser.x = (n - 5 - k);
              localTRTCMixUser.y = (i * j + i1);
              localTRTCMixUser.width = k;
              localTRTCMixUser.height = j;
            }
            for (;;)
            {
              TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser.userId + ", pureAudioMode: " + localTRTCMixUser.pureAudio);
              localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
              i += 1;
              break label501;
              n = 160;
              m = 160;
              i = 27;
              j = 48;
              if (!a.a.bfr().bfn().mTp)
              {
                i = 48;
                j = 27;
              }
              i2 = 200;
              i1 = 20;
              k = i;
              i = i2;
              break;
              i = 192;
              j = 336;
              if (!a.a.bfr().bfn().mTf)
              {
                i = 336;
                j = 192;
              }
              k = 54;
              m = 96;
              if (!a.a.bfr().bfn().mTp)
              {
                k = 96;
                m = 54;
              }
              i1 = 30;
              i3 = 400;
              n = j;
              i2 = i;
              i = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 240;
              j = 320;
              if (!a.a.bfr().bfn().mTf)
              {
                i = 320;
                j = 240;
              }
              k = 54;
              m = 96;
              if (!a.a.bfr().bfn().mTp)
              {
                k = 96;
                m = 54;
              }
              i1 = 400;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              n = 480;
              i = 72;
              j = 128;
              if (!a.a.bfr().bfn().mTp)
              {
                i = 128;
                j = 72;
              }
              i1 = 600;
              k = i;
              m = 480;
              i = i1;
              i1 = i3;
              break;
              i = 368;
              j = 640;
              if (!a.a.bfr().bfn().mTf)
              {
                i = 640;
                j = 368;
              }
              k = 90;
              m = 160;
              if (!a.a.bfr().bfn().mTp)
              {
                k = 160;
                m = 90;
              }
              i1 = 800;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 480;
              j = 640;
              if (!a.a.bfr().bfn().mTf)
              {
                i = 640;
                j = 480;
              }
              k = 90;
              m = 160;
              if (!a.a.bfr().bfn().mTp)
              {
                k = 160;
                m = 90;
              }
              i1 = 800;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 544;
              j = 960;
              if (!a.a.bfr().bfn().mTf)
              {
                i = 960;
                j = 544;
              }
              k = 171;
              m = 304;
              if (!a.a.bfr().bfn().mTp)
              {
                k = 304;
                m = 171;
              }
              i1 = 1000;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 720;
              j = 1280;
              if (!a.a.bfr().bfn().mTf)
              {
                i = 1280;
                j = 720;
              }
              k = 180;
              m = 320;
              if (!a.a.bfr().bfn().mTp)
              {
                k = 320;
                m = 180;
              }
              i1 = 1500;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              i = 1088;
              j = 1920;
              if (!a.a.bfr().bfn().mTf)
              {
                i = 1920;
                j = 1088;
              }
              k = 272;
              m = 480;
              if (!a.a.bfr().bfn().mTp)
              {
                k = 480;
                m = 272;
              }
              i1 = 1900;
              n = j;
              i2 = i;
              i = i1;
              i1 = i3;
              j = m;
              m = n;
              n = i2;
              break;
              if (i < 6)
              {
                localTRTCMixUser.x = 5;
                localTRTCMixUser.y = (m - i1 - (i - 3) * j - j);
                localTRTCMixUser.width = k;
                localTRTCMixUser.height = j;
              }
            }
          }
        }
      }
      boolean bool1 = a.a.bfr().bfn().mTq;
      boolean bool2 = a.a.bfr().bfn().mTr;
      if ((bool1) && (bool2)) {}
      for (i = 1;; i = 0)
      {
        Log.i("MicroMsg.LiveCoreVisitor", "cloudmixing,is265:%b, forceMixing:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((i == 0) && ((localTRTCTranscodingConfig.mixUsers == null) || (localTRTCTranscodingConfig.mixUsers.size() <= 1))) {
          break;
        }
        this.mSx.setMixTranscodingConfig(localTRTCTranscodingConfig);
        Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", new Object[] { localTRTCTranscodingConfig, Boolean.valueOf(bool1) });
        AppMethodBeat.o(248419);
        return;
      }
      this.mSx.setMixTranscodingConfig(null);
      Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
      AppMethodBeat.o(248419);
      return;
      i2 = 15;
    }
  }
  
  public final void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(248424);
    int i = 720;
    int j = 1280;
    if (!a.a.bfr().bfn().mTf)
    {
      i = 1280;
      j = 720;
    }
    int m = 1500;
    int k;
    switch (a.a.bfr().bfn().mSZ)
    {
    default: 
      k = j;
      j = i;
      i = m;
      m = a.a.bfr().bfn().mVideoBitrate;
      if (m > 0) {
        i = m;
      }
      m = a.a.bfr().bfn().mTa;
      if (m <= 0) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2;
      label195:
      boolean bool3;
      label215:
      TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig;
      TRTCCloudDef.TRTCMixUser localTRTCMixUser;
      Object localObject1;
      boolean bool4;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Iterator localIterator;
      if ((this.mSD != null) && (this.mSD.bex()))
      {
        bool2 = true;
        if ((this.mSD == null) || (!this.mSD.mNQ)) {
          break label1096;
        }
        bool3 = true;
        Log.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s, fps:%s, audioMode:%s, isScreenShareMode:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
        localTRTCTranscodingConfig.appId = this.mTJ;
        localTRTCTranscodingConfig.bizId = this.mTK;
        localTRTCTranscodingConfig.videoWidth = j;
        localTRTCTranscodingConfig.videoHeight = k;
        localTRTCTranscodingConfig.videoGOP = 1;
        localTRTCTranscodingConfig.videoFramerate = m;
        localTRTCTranscodingConfig.videoBitrate = i;
        localTRTCTranscodingConfig.audioSampleRate = 48000;
        localTRTCTranscodingConfig.audioBitrate = 64;
        if (a.a.bfr().bfo().mSP == 3) {
          localTRTCTranscodingConfig.audioBitrate = 128;
        }
        localTRTCTranscodingConfig.audioChannels = 2;
        localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
        localTRTCMixUser.userId = this.mTG;
        localTRTCMixUser.zOrder = 0;
        localTRTCMixUser.x = 0;
        localTRTCMixUser.y = 0;
        localTRTCMixUser.width = j;
        localTRTCMixUser.height = k;
        localTRTCTranscodingConfig.mixUsers = new ArrayList();
        localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
        if (bool2) {
          localTRTCTranscodingConfig.backgroundImage = "538";
        }
        bool1 = true;
        if (!a.a.bfr().bfn().mTn) {
          break label2900;
        }
        localObject1 = a.a.bfr().bfp();
        bool4 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mSV;
        Log.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParamsForFinder: isRoomPk = ".concat(String.valueOf(bool4)));
        if (!bool4) {
          break label1657;
        }
        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.mTF.size());
        localObject1 = b.a.bfv().mTz;
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label1643;
        }
        localObject2 = new LinkedList();
        localObject3 = new LinkedList();
        localObject4 = new TRTCCloudDef.TRTCMixUser();
        localIterator = ((List)localObject1).iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1335;
        }
        a locala = (a)localIterator.next();
        if (Util.isNullOrNil(locala.lyn))
        {
          String str = b.a.bfv().mTB;
          localObject1 = null;
          if (str != null) {
            localObject1 = (Map)b.a.bfv().mTA.get(str);
          }
          if ((localObject1 == null) || (!((Map)localObject1).containsKey(locala.luk)) || (((Map)localObject1).get(locala.luk) == null))
          {
            Log.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParamsForFinder: roomId is empty for userId:" + locala.luk + ", sessionId:" + str + ", abort for waiting");
            AppMethodBeat.o(248424);
            return;
            k = 160;
            i = 200;
            j = 160;
            break;
            i = 192;
            j = 336;
            if (!a.a.bfr().bfn().mTf)
            {
              i = 336;
              j = 192;
            }
            m = 400;
            k = j;
            j = i;
            i = m;
            break;
            i = 240;
            j = 320;
            if (!a.a.bfr().bfn().mTf)
            {
              i = 320;
              j = 240;
            }
            m = 400;
            k = j;
            j = i;
            i = m;
            break;
            k = 480;
            i = 600;
            j = 480;
            break;
            i = 368;
            j = 640;
            if (!a.a.bfr().bfn().mTf)
            {
              i = 640;
              j = 368;
            }
            m = 800;
            k = j;
            j = i;
            i = m;
            break;
            i = 480;
            j = 640;
            if (!a.a.bfr().bfn().mTf)
            {
              i = 640;
              j = 480;
            }
            m = 800;
            k = j;
            j = i;
            i = m;
            break;
            i = 544;
            j = 960;
            if (!a.a.bfr().bfn().mTf)
            {
              i = 960;
              j = 544;
            }
            m = 1000;
            k = j;
            j = i;
            i = m;
            break;
            i = 720;
            j = 1280;
            if (!a.a.bfr().bfn().mTf)
            {
              i = 1280;
              j = 720;
            }
            m = 1500;
            k = j;
            j = i;
            i = m;
            break;
            i = 1088;
            j = 1920;
            if (!a.a.bfr().bfn().mTf)
            {
              i = 1920;
              j = 1088;
            }
            m = 1900;
            k = j;
            j = i;
            i = m;
            break;
            bool2 = false;
            break label195;
            label1096:
            bool3 = false;
            break label215;
          }
          localObject1 = (a)((Map)localObject1).get(locala.luk);
          locala.lyn = ((a)localObject1).lyn;
          locala.mTy = ((a)localObject1).mTy;
          Log.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParamsForFinder: read from cache for userId:" + locala.luk + ", sessionId:" + str + ", roomId:" + ((a)localObject1).lyn + ", isAnchor:" + ((a)localObject1).mTy);
        }
        if (TextUtils.equals(locala.lyn, this.mTH))
        {
          ((List)localObject2).add(locala);
        }
        else if (locala.mTy)
        {
          ((TRTCCloudDef.TRTCMixUser)localObject4).userId = locala.luk;
          ((TRTCCloudDef.TRTCMixUser)localObject4).zOrder = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject4).roomId = locala.lyn;
          ((TRTCCloudDef.TRTCMixUser)localObject4).streamType = locala.mStreamType;
          ((TRTCCloudDef.TRTCMixUser)localObject4).pureAudio = true;
          localObject1 = FW(((TRTCCloudDef.TRTCMixUser)localObject4).userId);
          if (localObject1 != null) {
            ((TRTCCloudDef.TRTCMixUser)localObject4).pureAudio = ((b)localObject1).mTR;
          }
          localTRTCTranscodingConfig.mixUsers.add(localObject4);
        }
        else
        {
          ((List)localObject3).add(locala);
        }
      }
      label1335:
      i = ((List)localObject2).size();
      m = ((List)localObject3).size();
      localTRTCTranscodingConfig.backgroundImage = eh(i, m);
      localTRTCTranscodingConfig.videoWidth = j;
      localTRTCTranscodingConfig.videoHeight = (k / 2);
      if (i + m > 0) {}
      for (boolean bool1 = false;; bool1 = true)
      {
        Log.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParamsForFinder: selfRoomSize:%d, otherRoomSize:%d, canSendPreviousSei:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Boolean.valueOf(bool1) });
        a((List)localObject2, localTRTCMixUser, localTRTCTranscodingConfig, null, new Point(0, 0), j, k);
        a((List)localObject3, (TRTCCloudDef.TRTCMixUser)localObject4, localTRTCTranscodingConfig, ((TRTCCloudDef.TRTCMixUser)localObject4).roomId, new Point(j / 2, 0), j, k);
        localObject1 = a(localTRTCTranscodingConfig);
        for (;;)
        {
          this.mTO = ((JSONObject)localObject1);
          if ((bool2) && (!bool3))
          {
            localTRTCMixUser.width = 0;
            localTRTCMixUser.height = 0;
          }
          bool3 = a.a.bfr().bfn().mTq;
          bool4 = a.a.bfr().bfn().mTr;
          if ((bool3) && (bool4))
          {
            i = 1;
            label1545:
            Log.i("MicroMsg.LiveCoreVisitor", "cloudmixing,is265:%b, forceMixing:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
            if (!paramBoolean) {
              break label2770;
            }
            this.mSx.setMixTranscodingConfig(localTRTCTranscodingConfig);
            Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, reset");
            label1594:
            if (!bool1) {
              break label2892;
            }
          }
          label2326:
          label2507:
          label2892:
          for (this.mTM = bB(localTRTCTranscodingConfig.mixUsers);; this.mTM = null)
          {
            bfx();
            if (this.mTD != null) {
              this.mTD.C(this.mTO);
            }
            AppMethodBeat.o(248424);
            return;
            label1643:
            Log.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParamsForFinder: remoteUserConfigList is null or size = 0");
            localObject1 = null;
            break;
            label1657:
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.mTF.size());
            localObject2 = b.a.bfv().mTz;
            if (localObject2 == null) {
              break label2900;
            }
            i = ((List)localObject2).size();
            if (i == 1)
            {
              localTRTCMixUser.x = 0;
              localTRTCMixUser.y = 0;
              localTRTCMixUser.width = (j / 2);
              localTRTCMixUser.height = (k / 2);
              localTRTCTranscodingConfig.videoWidth = j;
              localTRTCTranscodingConfig.videoHeight = (k / 2);
              localTRTCTranscodingConfig.backgroundImage = "408";
              localObject2 = ((List)localObject2).iterator();
              i = 0;
              if (((Iterator)localObject2).hasNext())
              {
                localObject4 = (a)((Iterator)localObject2).next();
                localObject3 = new TRTCCloudDef.TRTCMixUser();
                if ((((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mST) && (((a)localObject4).luk.equalsIgnoreCase(((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mSS))) {
                  ((TRTCCloudDef.TRTCMixUser)localObject3).roomId = ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mSR;
                }
                for (;;)
                {
                  ((TRTCCloudDef.TRTCMixUser)localObject3).userId = ((a)localObject4).luk;
                  ((TRTCCloudDef.TRTCMixUser)localObject3).streamType = ((a)localObject4).mStreamType;
                  ((TRTCCloudDef.TRTCMixUser)localObject3).zOrder = (i + 1);
                  ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio = true;
                  localObject4 = FW(((TRTCCloudDef.TRTCMixUser)localObject3).userId);
                  if (localObject4 != null)
                  {
                    ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio = ((b)localObject4).mTR;
                    ((TRTCCloudDef.TRTCMixUser)localObject3).x = (j / 2);
                    ((TRTCCloudDef.TRTCMixUser)localObject3).y = 0;
                    ((TRTCCloudDef.TRTCMixUser)localObject3).width = (j / 2);
                    ((TRTCCloudDef.TRTCMixUser)localObject3).height = (k / 2);
                  }
                  TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + ((TRTCCloudDef.TRTCMixUser)localObject3).userId + ", pureAudioMode: " + ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio + ", userStream: " + localObject4);
                  localTRTCTranscodingConfig.mixUsers.add(localObject3);
                  i += 1;
                  break;
                  ((a)localObject4).lyn = this.mTH;
                }
              }
              localObject1 = null;
              break;
            }
            if (i == 2)
            {
              localTRTCMixUser.x = 0;
              localTRTCMixUser.y = 0;
              localTRTCMixUser.width = (j / 2);
              localTRTCMixUser.height = (k / 2);
              localTRTCTranscodingConfig.videoWidth = j;
              localTRTCTranscodingConfig.videoHeight = (k / 2);
              localTRTCTranscodingConfig.backgroundImage = "409";
              localObject2 = ((List)localObject2).iterator();
              i = 0;
              if (((Iterator)localObject2).hasNext())
              {
                localObject4 = (a)((Iterator)localObject2).next();
                localObject3 = new TRTCCloudDef.TRTCMixUser();
                if ((((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mST) && (((a)localObject4).luk.equalsIgnoreCase(((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mSS)))
                {
                  ((TRTCCloudDef.TRTCMixUser)localObject3).roomId = ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mSR;
                  label2150:
                  ((TRTCCloudDef.TRTCMixUser)localObject3).userId = ((a)localObject4).luk;
                  ((TRTCCloudDef.TRTCMixUser)localObject3).streamType = ((a)localObject4).mStreamType;
                  ((TRTCCloudDef.TRTCMixUser)localObject3).zOrder = (i + 1);
                  ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio = true;
                  localObject4 = FW(((TRTCCloudDef.TRTCMixUser)localObject3).userId);
                  if (localObject4 != null)
                  {
                    ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio = ((b)localObject4).mTR;
                    if (i != 0) {
                      break label2326;
                    }
                    ((TRTCCloudDef.TRTCMixUser)localObject3).x = (j / 2);
                    ((TRTCCloudDef.TRTCMixUser)localObject3).y = 0;
                    ((TRTCCloudDef.TRTCMixUser)localObject3).width = (j / 2);
                    ((TRTCCloudDef.TRTCMixUser)localObject3).height = (k / 4);
                  }
                }
                for (;;)
                {
                  TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + ((TRTCCloudDef.TRTCMixUser)localObject3).userId + ", pureAudioMode: " + ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio + ", userStream: " + localObject4);
                  localTRTCTranscodingConfig.mixUsers.add(localObject3);
                  i += 1;
                  break;
                  ((a)localObject4).lyn = this.mTH;
                  break label2150;
                  if (i == 1)
                  {
                    ((TRTCCloudDef.TRTCMixUser)localObject3).x = (j / 2);
                    ((TRTCCloudDef.TRTCMixUser)localObject3).y = (k / 4);
                    ((TRTCCloudDef.TRTCMixUser)localObject3).width = (j / 2);
                    ((TRTCCloudDef.TRTCMixUser)localObject3).height = (k / 4);
                  }
                }
              }
              localObject1 = null;
              break;
            }
            if (i != 3) {
              break label2900;
            }
            localTRTCMixUser.x = 0;
            localTRTCMixUser.y = 0;
            localTRTCMixUser.width = (j / 2);
            localTRTCMixUser.height = (k / 4);
            localTRTCTranscodingConfig.videoWidth = j;
            localTRTCTranscodingConfig.videoHeight = (k / 2);
            localTRTCTranscodingConfig.backgroundImage = "410";
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject2).hasNext()) {
              break label2900;
            }
            localObject4 = (a)((Iterator)localObject2).next();
            localObject3 = new TRTCCloudDef.TRTCMixUser();
            if ((((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mST) && (((a)localObject4).luk.equalsIgnoreCase(((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mSS)))
            {
              ((TRTCCloudDef.TRTCMixUser)localObject3).roomId = ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d)localObject1).mSR;
              ((TRTCCloudDef.TRTCMixUser)localObject3).userId = ((a)localObject4).luk;
              ((TRTCCloudDef.TRTCMixUser)localObject3).streamType = ((a)localObject4).mStreamType;
              ((TRTCCloudDef.TRTCMixUser)localObject3).zOrder = (i + 1);
              ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio = true;
              localObject4 = FW(((TRTCCloudDef.TRTCMixUser)localObject3).userId);
              if (localObject4 != null)
              {
                ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio = ((b)localObject4).mTR;
                if (i != 0) {
                  break label2683;
                }
                ((TRTCCloudDef.TRTCMixUser)localObject3).x = (j / 2);
                ((TRTCCloudDef.TRTCMixUser)localObject3).y = 0;
                ((TRTCCloudDef.TRTCMixUser)localObject3).width = (j / 2);
                ((TRTCCloudDef.TRTCMixUser)localObject3).height = (k / 4);
              }
            }
            for (;;)
            {
              TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + ((TRTCCloudDef.TRTCMixUser)localObject3).userId + ", pureAudioMode: " + ((TRTCCloudDef.TRTCMixUser)localObject3).pureAudio + ", userStream: " + localObject4);
              localTRTCTranscodingConfig.mixUsers.add(localObject3);
              i += 1;
              break;
              ((a)localObject4).lyn = this.mTH;
              break label2507;
              label2683:
              if (i == 1)
              {
                ((TRTCCloudDef.TRTCMixUser)localObject3).x = 0;
                ((TRTCCloudDef.TRTCMixUser)localObject3).y = (k / 4);
                ((TRTCCloudDef.TRTCMixUser)localObject3).width = (j / 2);
                ((TRTCCloudDef.TRTCMixUser)localObject3).height = (k / 4);
              }
              else if (i == 2)
              {
                ((TRTCCloudDef.TRTCMixUser)localObject3).x = (j / 2);
                ((TRTCCloudDef.TRTCMixUser)localObject3).y = (k / 4);
                ((TRTCCloudDef.TRTCMixUser)localObject3).width = (j / 2);
                ((TRTCCloudDef.TRTCMixUser)localObject3).height = (k / 4);
              }
            }
            i = 0;
            break label1545;
            label2770:
            if ((i != 0) || ((localTRTCTranscodingConfig.mixUsers != null) && (localTRTCTranscodingConfig.mixUsers.size() > 1)))
            {
              this.mSx.setMixTranscodingConfig(localTRTCTranscodingConfig);
              Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", new Object[] { localTRTCTranscodingConfig, Boolean.valueOf(bool3) });
              break label1594;
            }
            if (bool2)
            {
              this.mSx.setMixTranscodingConfig(localTRTCTranscodingConfig);
              Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", new Object[] { localTRTCTranscodingConfig, Boolean.valueOf(bool3) });
              break label1594;
            }
            this.mSx.setMixTranscodingConfig(null);
            Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
            break label1594;
          }
          label2900:
          localObject1 = null;
        }
      }
      m = 15;
    }
  }
  
  public final void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(248399);
    this.mSx.muteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(248399);
  }
  
  public static abstract interface a
  {
    public abstract void C(JSONObject paramJSONObject);
  }
  
  public static final class b
  {
    public boolean mTR = true;
    public int streamType;
    public String userId;
    public int x = 0;
    public int y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b.c
 * JD-Core Version:    0.7.0.1
 */