package com.tencent.mm.live.core.core.trtc.sdkadapter.b;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.e.k;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class c
{
  TRTCCloud koH;
  private h koN;
  private final a kpI;
  private boolean kpJ;
  private ArrayList<b> kpK;
  private String kpL;
  private HashMap<String, j> kpM;
  private HashMap<Long, TXLivePlayer> kpN;
  private int kpO;
  private int kpP;
  int kpQ;
  JSONObject kpR;
  private MTimerHandler kpS;
  
  public c(TRTCCloud paramTRTCCloud, a parama, int paramInt, h paramh)
  {
    AppMethodBeat.i(199542);
    this.kpO = 1258344707;
    this.kpP = 58415;
    this.kpQ = 0;
    this.koN = null;
    this.kpR = null;
    this.kpS = new MTimerHandler("link_mic_sei_sender", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(198709);
        cue localcue;
        if (c.this.kpR != null)
        {
          Object localObject1 = c.this.kpR.optString("d");
          try
          {
            cud localcud = new cud();
            localcud.parseFrom(((String)localObject1).getBytes(kotlin.n.d.UTF_8));
            if (localcud.SKD != null)
            {
              localObject1 = localcud.SKD.iterator();
              for (;;)
              {
                if (((Iterator)localObject1).hasNext())
                {
                  localcue = (cue)((Iterator)localObject1).next();
                  Object localObject2 = b.a.aMa().NE(localcue.RUq);
                  if (localObject2 != null) {
                    if (((a)localObject2).kpF <= c.this.kpQ)
                    {
                      int i = localcue.TBU;
                      localObject2 = e.k.kkA;
                      localcue.TBU = (i | e.k.aKD());
                      continue;
                      AppMethodBeat.o(198709);
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
          localcue.TBU = 0;
          break;
          String str = new String(localException.toByteArray());
          c.this.kpR.putOpt("d", str);
          c.this.koH.sendSEIMsg(c.this.kpR.toString().getBytes(), 1);
        }
      }
    }, true);
    this.koH = paramTRTCCloud;
    this.kpI = parama;
    this.kpJ = true;
    this.kpK = new ArrayList();
    this.kpM = new HashMap();
    this.kpN = new HashMap();
    this.kpQ = paramInt;
    this.koN = paramh;
    AppMethodBeat.o(199542);
  }
  
  private boolean NG(String paramString)
  {
    AppMethodBeat.i(199547);
    Iterator localIterator = this.kpK.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(199547);
        return true;
      }
    }
    AppMethodBeat.o(199547);
    return false;
  }
  
  private b NH(String paramString)
  {
    AppMethodBeat.i(199549);
    Iterator localIterator = this.kpK.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(199549);
        return localb;
      }
    }
    AppMethodBeat.o(199549);
    return null;
  }
  
  public static void NJ(String paramString)
  {
    AppMethodBeat.i(199562);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    if (b.a.aMa().NE(paramString) == null)
    {
      paramString = new a(paramString);
      b.a.aMa().a(paramString);
    }
    AppMethodBeat.o(199562);
  }
  
  public static void NK(String paramString)
  {
    AppMethodBeat.i(199563);
    b.a.aMa().ND(Util.nullAsNil(paramString));
    AppMethodBeat.o(199563);
  }
  
  private void NM(String paramString)
  {
    AppMethodBeat.i(199574);
    j localj = (j)this.kpM.remove(paramString);
    if (localj != null) {
      localj.release();
    }
    this.koH.stopRemoteSubStreamView(paramString);
    AppMethodBeat.o(199574);
  }
  
  /* Error */
  private JSONObject ac(List<TRTCCloudDef.TRTCMixUser> paramList)
  {
    // Byte code:
    //   0: ldc 189
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +17 -> 23
    //   9: ldc 191
    //   11: ldc 193
    //   13: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 189
    //   18: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 84	java/util/ArrayList
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 201	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   31: astore 4
    //   33: aload 4
    //   35: invokeinterface 207 1 0
    //   40: ifle +12 -> 52
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 210 2 0
    //   51: pop
    //   52: aload 4
    //   54: invokeinterface 207 1 0
    //   59: ifne +17 -> 76
    //   62: ldc 191
    //   64: ldc 212
    //   66: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: ldc 189
    //   71: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aconst_null
    //   75: areturn
    //   76: new 84	java/util/ArrayList
    //   79: dup
    //   80: invokespecial 85	java/util/ArrayList:<init>	()V
    //   83: astore_1
    //   84: aload 4
    //   86: invokeinterface 213 1 0
    //   91: astore 4
    //   93: aload 4
    //   95: invokeinterface 111 1 0
    //   100: ifeq +166 -> 266
    //   103: aload 4
    //   105: invokeinterface 115 1 0
    //   110: checkcast 215	com/tencent/trtc/TRTCCloudDef$TRTCMixUser
    //   113: astore 6
    //   115: new 217	com/tencent/mm/protocal/protobuf/cue
    //   118: dup
    //   119: invokespecial 218	com/tencent/mm/protocal/protobuf/cue:<init>	()V
    //   122: astore 5
    //   124: invokestatic 142	com/tencent/mm/live/core/core/trtc/sdkadapter/b/b$a:aMa	()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/b/b;
    //   127: aload 6
    //   129: getfield 219	com/tencent/trtc/TRTCCloudDef$TRTCMixUser:userId	Ljava/lang/String;
    //   132: invokevirtual 148	com/tencent/mm/live/core/core/trtc/sdkadapter/b/b:NE	(Ljava/lang/String;)Lcom/tencent/mm/live/core/core/trtc/sdkadapter/b/a;
    //   135: astore 7
    //   137: aload 5
    //   139: aload 6
    //   141: getfield 219	com/tencent/trtc/TRTCCloudDef$TRTCMixUser:userId	Ljava/lang/String;
    //   144: putfield 222	com/tencent/mm/protocal/protobuf/cue:RUq	Ljava/lang/String;
    //   147: aload 6
    //   149: getfield 225	com/tencent/trtc/TRTCCloudDef$TRTCMixUser:pureAudio	Z
    //   152: ifne +100 -> 252
    //   155: iconst_1
    //   156: istore_3
    //   157: aload 5
    //   159: iload_3
    //   160: putfield 228	com/tencent/mm/protocal/protobuf/cue:TBT	Z
    //   163: aload 7
    //   165: ifnull +36 -> 201
    //   168: aload 7
    //   170: getfield 231	com/tencent/mm/live/core/core/trtc/sdkadapter/b/a:kpF	I
    //   173: aload_0
    //   174: getfield 60	com/tencent/mm/live/core/core/trtc/sdkadapter/b/c:kpQ	I
    //   177: if_icmpgt +80 -> 257
    //   180: aload 5
    //   182: getfield 234	com/tencent/mm/protocal/protobuf/cue:TBU	I
    //   185: istore_2
    //   186: getstatic 240	com/tencent/mm/live/core/core/e$k:kkA	Lcom/tencent/mm/live/core/core/e$k;
    //   189: astore 6
    //   191: aload 5
    //   193: iload_2
    //   194: invokestatic 243	com/tencent/mm/live/core/core/e$k:aKD	()I
    //   197: ior
    //   198: putfield 234	com/tencent/mm/protocal/protobuf/cue:TBU	I
    //   201: aload_1
    //   202: aload 5
    //   204: invokeinterface 246 2 0
    //   209: pop
    //   210: ldc 191
    //   212: new 248	java/lang/StringBuilder
    //   215: dup
    //   216: ldc 250
    //   218: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload 5
    //   223: getfield 222	com/tencent/mm/protocal/protobuf/cue:RUq	Ljava/lang/String;
    //   226: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 257
    //   232: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 5
    //   237: getfield 228	com/tencent/mm/protocal/protobuf/cue:TBT	Z
    //   240: invokevirtual 260	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   243: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: goto -156 -> 93
    //   252: iconst_0
    //   253: istore_3
    //   254: goto -97 -> 157
    //   257: aload 5
    //   259: iconst_0
    //   260: putfield 234	com/tencent/mm/protocal/protobuf/cue:TBU	I
    //   263: goto -62 -> 201
    //   266: new 266	com/tencent/mm/protocal/protobuf/cud
    //   269: dup
    //   270: invokespecial 267	com/tencent/mm/protocal/protobuf/cud:<init>	()V
    //   273: astore 4
    //   275: aload 4
    //   277: getfield 271	com/tencent/mm/protocal/protobuf/cud:SKD	Ljava/util/LinkedList;
    //   280: aload_1
    //   281: invokevirtual 277	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   284: pop
    //   285: new 120	java/lang/String
    //   288: dup
    //   289: aload 4
    //   291: invokevirtual 281	com/tencent/mm/protocal/protobuf/cud:toByteArray	()[B
    //   294: invokespecial 284	java/lang/String:<init>	([B)V
    //   297: astore 4
    //   299: new 286	org/json/JSONObject
    //   302: dup
    //   303: invokespecial 287	org/json/JSONObject:<init>	()V
    //   306: astore_1
    //   307: aload_1
    //   308: ldc_w 289
    //   311: getstatic 295	com/tencent/mm/live/core/core/e$o:kkP	Lcom/tencent/mm/live/core/core/e$o;
    //   314: getfield 298	com/tencent/mm/live/core/core/e$o:value	I
    //   317: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   320: invokevirtual 308	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   323: pop
    //   324: aload_1
    //   325: ldc_w 310
    //   328: aload 4
    //   330: invokevirtual 308	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   333: pop
    //   334: ldc 189
    //   336: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aload_1
    //   340: areturn
    //   341: astore_1
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -10 -> 334
    //   347: astore 4
    //   349: goto -15 -> 334
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_1
    //   355: goto -21 -> 334
    //   358: astore 4
    //   360: goto -26 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	c
    //   0	363	1	paramList	List<TRTCCloudDef.TRTCMixUser>
    //   185	13	2	i	int
    //   156	98	3	bool	boolean
    //   31	298	4	localObject1	Object
    //   347	1	4	localJSONException	org.json.JSONException
    //   358	1	4	localIOException	java.io.IOException
    //   122	136	5	localcue	cue
    //   113	77	6	localObject2	Object
    //   135	34	7	locala	a
    // Exception table:
    //   from	to	target	type
    //   285	307	341	org/json/JSONException
    //   307	334	347	org/json/JSONException
    //   285	307	352	java/io/IOException
    //   307	334	358	java/io/IOException
  }
  
  public final void D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199632);
    int i = 720;
    int j = 1280;
    if (!a.a.aLN().aLJ().kpo)
    {
      i = 1280;
      j = 720;
    }
    int k = 180;
    int m = 320;
    if (!a.a.aLN().aLJ().kpy)
    {
      k = 320;
      m = 180;
    }
    int i3 = 50;
    int i2 = 1500;
    int i1;
    int n;
    switch (a.a.aLN().aLJ().kpi)
    {
    default: 
      i1 = m;
      n = i;
      m = j;
      j = i1;
      i1 = i3;
      i = i2;
      i2 = a.a.aLN().aLJ().mVideoBitrate;
      if (i2 > 0) {
        i = i2;
      }
      i2 = a.a.aLN().aLJ().kpj;
      if (i2 <= 0) {
        break;
      }
    }
    for (;;)
    {
      float f1 = paramFloat1 / ax.au(MMApplicationContext.getContext()).x;
      f1 = n * f1;
      float f2 = paramFloat2 / ax.au(MMApplicationContext.getContext()).y;
      f2 = m * f2;
      Log.i("MicroMsg.LiveCoreVisitor", "xOffset:%s, realXOffset:%s, yOffset:%s, realYOffset:%s, videoWidth:%s, videoHeight:%s, bitrate:%s,fps:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(f1), Float.valueOf(paramFloat2), Float.valueOf(f2), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i2) });
      TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
      localTRTCTranscodingConfig.appId = this.kpO;
      localTRTCTranscodingConfig.bizId = this.kpP;
      localTRTCTranscodingConfig.videoWidth = n;
      localTRTCTranscodingConfig.videoHeight = m;
      localTRTCTranscodingConfig.videoGOP = 1;
      localTRTCTranscodingConfig.videoFramerate = i2;
      localTRTCTranscodingConfig.videoBitrate = i;
      localTRTCTranscodingConfig.audioSampleRate = 48000;
      localTRTCTranscodingConfig.audioBitrate = 64;
      if (a.a.aLN().aLK().kpb == 3) {
        localTRTCTranscodingConfig.audioBitrate = 128;
      }
      localTRTCTranscodingConfig.audioChannels = 2;
      Object localObject1 = new TRTCCloudDef.TRTCMixUser();
      ((TRTCCloudDef.TRTCMixUser)localObject1).userId = this.kpL;
      ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).x = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).width = n;
      ((TRTCCloudDef.TRTCMixUser)localObject1).height = m;
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      localTRTCTranscodingConfig.mixUsers.add(localObject1);
      if (a.a.aLN().aLJ().kpw)
      {
        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.kpK.size());
        localObject1 = b.a.aMa().kpG;
        label810:
        label1722:
        label1738:
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          label590:
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (a)((Iterator)localObject1).next();
            TRTCCloudDef.TRTCMixUser localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
            com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d locald = a.a.aLN().aLL();
            if ((locald.kpg) && (((a)localObject2).iSn.equalsIgnoreCase(locald.kpf))) {
              localTRTCMixUser.roomId = locald.kpe;
            }
            localTRTCMixUser.userId = ((a)localObject2).iSn;
            localTRTCMixUser.streamType = ((a)localObject2).mStreamType;
            localTRTCMixUser.zOrder = (i + 1);
            localTRTCMixUser.pureAudio = true;
            localObject2 = NH(localTRTCMixUser.userId);
            if (localObject2 != null)
            {
              localTRTCMixUser.pureAudio = ((b)localObject2).kpV;
              if (i >= 3) {
                break label1755;
              }
              if (((b)localObject2).x != 0) {
                break label1722;
              }
              localTRTCMixUser.x = (n - 5 - k + (int)f1);
              label753:
              localTRTCMixUser.x = Math.max(Math.min(n - k, localTRTCMixUser.x), 0);
              ((b)localObject2).x = localTRTCMixUser.x;
              if (((b)localObject2).y != 0) {
                break label1738;
              }
              localTRTCMixUser.y = (i * j + i1 + (int)f2);
              localTRTCMixUser.y = Math.max(Math.min(m - j, localTRTCMixUser.y), 0);
              ((b)localObject2).y = localTRTCMixUser.y;
              localTRTCMixUser.width = k;
              localTRTCMixUser.height = j;
            }
            for (;;)
            {
              TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser.userId + ", pureAudioMode: " + localTRTCMixUser.pureAudio);
              localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
              i += 1;
              break label590;
              n = 160;
              m = 160;
              i = 27;
              j = 48;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 336;
                j = 192;
              }
              k = 54;
              m = 96;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 320;
                j = 240;
              }
              k = 54;
              m = 96;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 640;
                j = 368;
              }
              k = 90;
              m = 160;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 640;
                j = 480;
              }
              k = 90;
              m = 160;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 960;
                j = 544;
              }
              k = 171;
              m = 304;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 1280;
                j = 720;
              }
              k = 180;
              m = 320;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 1920;
                j = 1088;
              }
              k = 272;
              m = 480;
              if (!a.a.aLN().aLJ().kpy)
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
              localTRTCMixUser.x = (((b)localObject2).x + (int)f1);
              break label753;
              localTRTCMixUser.y = (((b)localObject2).y + (int)f2);
              break label810;
              label1755:
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
      boolean bool = a.a.aLN().aLJ().kpz;
      if ((bool) || ((localTRTCTranscodingConfig.mixUsers != null) && (localTRTCTranscodingConfig.mixUsers.size() > 1)))
      {
        this.koH.setMixTranscodingConfig(localTRTCTranscodingConfig);
        Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", new Object[] { localTRTCTranscodingConfig, Boolean.valueOf(bool) });
        AppMethodBeat.o(199632);
        return;
      }
      this.koH.setMixTranscodingConfig(null);
      Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
      AppMethodBeat.o(199632);
      return;
      i2 = 15;
    }
  }
  
  public final TXLivePlayer FA(long paramLong)
  {
    AppMethodBeat.i(199570);
    if ((this.kpN != null) && (this.kpN.containsKey(Long.valueOf(paramLong))))
    {
      TXLivePlayer localTXLivePlayer = (TXLivePlayer)this.kpN.get(Long.valueOf(paramLong));
      AppMethodBeat.o(199570);
      return localTXLivePlayer;
    }
    AppMethodBeat.o(199570);
    return null;
  }
  
  public final void ND(String paramString)
  {
    AppMethodBeat.i(199566);
    b.a.aMa().ND(paramString);
    NM(paramString);
    this.koH.stopRemoteView(paramString);
    this.koH.stopRemoteSubStreamView(paramString);
    com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d locald = a.a.aLN().aLL();
    if (paramString.equals(locald.kpf)) {
      locald.reset();
    }
    AppMethodBeat.o(199566);
  }
  
  public final void NF(String paramString)
  {
    this.kpL = paramString;
  }
  
  public final void NI(String paramString)
  {
    AppMethodBeat.i(199555);
    if (!this.kpJ) {
      this.koH.stopRemoteView(paramString);
    }
    for (;;)
    {
      b.a.aMa().ND(Util.nullAsNil(paramString));
      Iterator localIterator = this.kpK.iterator();
      b localb;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localb = (b)localIterator.next();
      } while ((localb.userId == null) || (!localb.userId.equals(paramString)) || (localb.streamType != 0));
      localIterator.remove();
      TXLog.i("MicroMsg.LiveCoreVisitor", "removeVideoStream " + paramString + ", stream 0, size " + this.kpK.size());
      AppMethodBeat.o(199555);
      return;
      NM(paramString);
    }
    AppMethodBeat.o(199555);
  }
  
  public final j NL(String paramString)
  {
    AppMethodBeat.i(199569);
    if ((this.kpM != null) && (!Util.isNullOrNil(paramString)) && (this.kpM.containsKey(paramString)))
    {
      paramString = (j)this.kpM.get(paramString);
      AppMethodBeat.o(199569);
      return paramString;
    }
    AppMethodBeat.o(199569);
    return null;
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(199573);
    Log.i("MicroMsg.LiveCoreVisitor", "cdnPlayAvailable liveId:" + paramLong + ",player:" + paramTXLivePlayer);
    this.kpN.put(Long.valueOf(paramLong), paramTXLivePlayer);
    AppMethodBeat.o(199573);
  }
  
  public final void a(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(199561);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    localb.kpV = false;
    Object localObject1;
    if (b.a.aMa().NE(paramString) == null)
    {
      localObject1 = new a(paramString);
      b.a.aMa().a((a)localObject1);
    }
    if (!this.kpJ) {
      if (paramTXCloudVideoView != null)
      {
        this.koH.setDebugViewMargin(paramString, new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F));
        this.koH.setRemoteViewFillMode(paramString, 1);
        this.koH.startRemoteView(paramString, paramTXCloudVideoView);
      }
    }
    for (;;)
    {
      if (!NG(paramString))
      {
        this.kpK.add(localb);
        TXLog.i("MicroMsg.LiveCoreVisitor", "remoteUserVideoAvailable " + localb.userId + ", stream 0, size " + this.kpK.size());
      }
      AppMethodBeat.o(199561);
      return;
      Object localObject2 = NL(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new j(paramString);
      }
      localObject2 = new TextureView(paramTXCloudVideoView.getContext());
      ((TextureView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      paramTXCloudVideoView.addVideoView((TextureView)localObject2);
      ((TextureView)localObject2).setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
      {
        public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(200479);
          Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          this.kpU.bO(new Surface(paramAnonymousSurfaceTexture));
          this.kpU.dt(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(200479);
        }
        
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(200484);
          Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
          this.kpU.aMX();
          AppMethodBeat.o(200484);
          return false;
        }
        
        public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(200481);
          Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          this.kpU.dt(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(200481);
        }
        
        public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
      });
      this.koH.setRemoteVideoRenderListener(paramString, 1, 2, (TRTCCloudListener.TRTCVideoRenderListener)localObject1);
      this.kpM.put(paramString, localObject1);
      this.koH.startRemoteView(paramString, null);
      ((TextureView)localObject2).invalidate();
    }
  }
  
  public final void aMb()
  {
    AppMethodBeat.i(199550);
    this.kpK.clear();
    AppMethodBeat.o(199550);
  }
  
  public final void aMc()
  {
    AppMethodBeat.i(199599);
    int i = 720;
    int j = 1280;
    if (!a.a.aLN().aLJ().kpo)
    {
      i = 1280;
      j = 720;
    }
    int k = 180;
    int m = 320;
    if (!a.a.aLN().aLJ().kpy)
    {
      k = 320;
      m = 180;
    }
    int i3 = 50;
    int i2 = 1500;
    int i1;
    int n;
    switch (a.a.aLN().aLJ().kpi)
    {
    default: 
      i1 = m;
      n = i;
      m = j;
      j = i1;
      i1 = i3;
      i = i2;
      i2 = a.a.aLN().aLJ().mVideoBitrate;
      if (i2 > 0) {
        i = i2;
      }
      i2 = a.a.aLN().aLJ().kpj;
      if (i2 <= 0) {
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s, fps:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i2) });
      TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
      localTRTCTranscodingConfig.appId = this.kpO;
      localTRTCTranscodingConfig.bizId = this.kpP;
      localTRTCTranscodingConfig.videoWidth = n;
      localTRTCTranscodingConfig.videoHeight = m;
      localTRTCTranscodingConfig.videoGOP = 1;
      localTRTCTranscodingConfig.videoFramerate = i2;
      localTRTCTranscodingConfig.videoBitrate = i;
      localTRTCTranscodingConfig.audioSampleRate = 48000;
      localTRTCTranscodingConfig.audioBitrate = 64;
      if (a.a.aLN().aLK().kpb == 3) {
        localTRTCTranscodingConfig.audioBitrate = 128;
      }
      localTRTCTranscodingConfig.audioChannels = 2;
      Object localObject1 = new TRTCCloudDef.TRTCMixUser();
      ((TRTCCloudDef.TRTCMixUser)localObject1).userId = this.kpL;
      ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).x = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).width = n;
      ((TRTCCloudDef.TRTCMixUser)localObject1).height = m;
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      localTRTCTranscodingConfig.mixUsers.add(localObject1);
      if (a.a.aLN().aLJ().kpw)
      {
        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.kpK.size());
        localObject1 = b.a.aMa().kpG;
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
            com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d locald = a.a.aLN().aLL();
            if ((locald.kpg) && (((a)localObject2).iSn.equalsIgnoreCase(locald.kpf))) {
              localTRTCMixUser.roomId = locald.kpe;
            }
            localTRTCMixUser.userId = ((a)localObject2).iSn;
            localTRTCMixUser.streamType = ((a)localObject2).mStreamType;
            localTRTCMixUser.zOrder = (i + 1);
            localTRTCMixUser.pureAudio = true;
            localObject2 = NH(localTRTCMixUser.userId);
            if (localObject2 != null)
            {
              localTRTCMixUser.pureAudio = ((b)localObject2).kpV;
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
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 336;
                j = 192;
              }
              k = 54;
              m = 96;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 320;
                j = 240;
              }
              k = 54;
              m = 96;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 640;
                j = 368;
              }
              k = 90;
              m = 160;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 640;
                j = 480;
              }
              k = 90;
              m = 160;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 960;
                j = 544;
              }
              k = 171;
              m = 304;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 1280;
                j = 720;
              }
              k = 180;
              m = 320;
              if (!a.a.aLN().aLJ().kpy)
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
              if (!a.a.aLN().aLJ().kpo)
              {
                i = 1920;
                j = 1088;
              }
              k = 272;
              m = 480;
              if (!a.a.aLN().aLJ().kpy)
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
      boolean bool = a.a.aLN().aLJ().kpz;
      if ((bool) || ((localTRTCTranscodingConfig.mixUsers != null) && (localTRTCTranscodingConfig.mixUsers.size() > 1)))
      {
        this.koH.setMixTranscodingConfig(localTRTCTranscodingConfig);
        Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", new Object[] { localTRTCTranscodingConfig, Boolean.valueOf(bool) });
        AppMethodBeat.o(199599);
        return;
      }
      this.koH.setMixTranscodingConfig(null);
      Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
      AppMethodBeat.o(199599);
      return;
      i2 = 15;
    }
  }
  
  public final void fh(boolean paramBoolean)
  {
    AppMethodBeat.i(199650);
    int i = 720;
    int j = 1280;
    if (!a.a.aLN().aLJ().kpo)
    {
      i = 1280;
      j = 720;
    }
    a.a.aLN().aLJ();
    int m = 1500;
    int k;
    switch (a.a.aLN().aLJ().kpi)
    {
    default: 
      k = i;
      i = m;
      m = a.a.aLN().aLJ().mVideoBitrate;
      if (m > 0) {
        i = m;
      }
      m = a.a.aLN().aLJ().kpj;
      if (m <= 0) {
        break;
      }
    }
    for (;;)
    {
      boolean bool1;
      if ((this.koN != null) && (this.koN.aLs()))
      {
        bool1 = true;
        label197:
        if ((this.koN == null) || (!this.koN.kmG)) {
          break label1220;
        }
      }
      TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig;
      TRTCCloudDef.TRTCMixUser localTRTCMixUser1;
      Object localObject1;
      Object localObject2;
      TRTCCloudDef.TRTCMixUser localTRTCMixUser2;
      com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d locald;
      label1220:
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s, fps:%s, audioMode:%s, isScreenShareMode:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
        localTRTCTranscodingConfig.appId = this.kpO;
        localTRTCTranscodingConfig.bizId = this.kpP;
        localTRTCTranscodingConfig.videoWidth = k;
        localTRTCTranscodingConfig.videoHeight = j;
        localTRTCTranscodingConfig.videoGOP = 1;
        localTRTCTranscodingConfig.videoFramerate = m;
        localTRTCTranscodingConfig.videoBitrate = i;
        localTRTCTranscodingConfig.audioSampleRate = 48000;
        localTRTCTranscodingConfig.audioBitrate = 64;
        if (a.a.aLN().aLK().kpb == 3) {
          localTRTCTranscodingConfig.audioBitrate = 128;
        }
        localTRTCTranscodingConfig.audioChannels = 2;
        localTRTCMixUser1 = new TRTCCloudDef.TRTCMixUser();
        localTRTCMixUser1.userId = this.kpL;
        localTRTCMixUser1.zOrder = 0;
        localTRTCMixUser1.x = 0;
        localTRTCMixUser1.y = 0;
        localTRTCMixUser1.width = k;
        localTRTCMixUser1.height = j;
        localTRTCTranscodingConfig.mixUsers = new ArrayList();
        localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser1);
        if (bool1) {
          localTRTCTranscodingConfig.backgroundImage = "538";
        }
        if (!a.a.aLN().aLJ().kpw) {
          break label1961;
        }
        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.kpK.size());
        localObject1 = b.a.aMa().kpG;
        if (localObject1 == null) {
          break label1961;
        }
        i = ((List)localObject1).size();
        if (i != 1) {
          break label1226;
        }
        localTRTCMixUser1.x = 0;
        localTRTCMixUser1.y = 0;
        localTRTCMixUser1.width = (k / 2);
        localTRTCMixUser1.height = (j / 2);
        localTRTCTranscodingConfig.videoWidth = k;
        localTRTCTranscodingConfig.videoHeight = (j / 2);
        localTRTCTranscodingConfig.backgroundImage = "408";
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          localTRTCMixUser2 = new TRTCCloudDef.TRTCMixUser();
          locald = a.a.aLN().aLL();
          if ((locald.kpg) && (((a)localObject2).iSn.equalsIgnoreCase(locald.kpf))) {
            localTRTCMixUser2.roomId = locald.kpe;
          }
          localTRTCMixUser2.userId = ((a)localObject2).iSn;
          localTRTCMixUser2.streamType = ((a)localObject2).mStreamType;
          localTRTCMixUser2.zOrder = (i + 1);
          localTRTCMixUser2.pureAudio = true;
          localObject2 = NH(localTRTCMixUser2.userId);
          if (localObject2 != null)
          {
            localTRTCMixUser2.pureAudio = ((b)localObject2).kpV;
            localTRTCMixUser2.x = (k / 2);
            localTRTCMixUser2.y = 0;
            localTRTCMixUser2.width = (k / 2);
            localTRTCMixUser2.height = (j / 2);
          }
          TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser2.userId + ", pureAudioMode: " + localTRTCMixUser2.pureAudio + ", userStream: " + localObject2);
          localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser2);
          i += 1;
        }
        k = 160;
        a.a.aLN().aLJ();
        i = 200;
        j = 160;
        break;
        i = 192;
        j = 336;
        if (!a.a.aLN().aLJ().kpo)
        {
          i = 336;
          j = 192;
        }
        a.a.aLN().aLJ();
        m = 400;
        k = i;
        i = m;
        break;
        i = 240;
        j = 320;
        if (!a.a.aLN().aLJ().kpo)
        {
          i = 320;
          j = 240;
        }
        a.a.aLN().aLJ();
        m = 400;
        k = i;
        i = m;
        break;
        k = 480;
        a.a.aLN().aLJ();
        i = 600;
        j = 480;
        break;
        i = 368;
        j = 640;
        if (!a.a.aLN().aLJ().kpo)
        {
          i = 640;
          j = 368;
        }
        a.a.aLN().aLJ();
        m = 800;
        k = i;
        i = m;
        break;
        i = 480;
        j = 640;
        if (!a.a.aLN().aLJ().kpo)
        {
          i = 640;
          j = 480;
        }
        a.a.aLN().aLJ();
        m = 800;
        k = i;
        i = m;
        break;
        i = 544;
        j = 960;
        if (!a.a.aLN().aLJ().kpo)
        {
          i = 960;
          j = 544;
        }
        a.a.aLN().aLJ();
        m = 1000;
        k = i;
        i = m;
        break;
        i = 720;
        j = 1280;
        if (!a.a.aLN().aLJ().kpo)
        {
          i = 1280;
          j = 720;
        }
        a.a.aLN().aLJ();
        m = 1500;
        k = i;
        i = m;
        break;
        i = 1088;
        j = 1920;
        if (!a.a.aLN().aLJ().kpo)
        {
          i = 1920;
          j = 1088;
        }
        a.a.aLN().aLJ();
        m = 1900;
        k = i;
        i = m;
        break;
        bool1 = false;
        break label197;
      }
      label1226:
      if (i == 2)
      {
        localTRTCMixUser1.x = 0;
        localTRTCMixUser1.y = 0;
        localTRTCMixUser1.width = (k / 2);
        localTRTCMixUser1.height = (j / 2);
        localTRTCTranscodingConfig.videoWidth = k;
        localTRTCTranscodingConfig.videoHeight = (j / 2);
        localTRTCTranscodingConfig.backgroundImage = "409";
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          localTRTCMixUser2 = new TRTCCloudDef.TRTCMixUser();
          locald = a.a.aLN().aLL();
          if ((locald.kpg) && (((a)localObject2).iSn.equalsIgnoreCase(locald.kpf))) {
            localTRTCMixUser2.roomId = locald.kpe;
          }
          localTRTCMixUser2.userId = ((a)localObject2).iSn;
          localTRTCMixUser2.streamType = ((a)localObject2).mStreamType;
          localTRTCMixUser2.zOrder = (i + 1);
          localTRTCMixUser2.pureAudio = true;
          localObject2 = NH(localTRTCMixUser2.userId);
          if (localObject2 != null)
          {
            localTRTCMixUser2.pureAudio = ((b)localObject2).kpV;
            if (i != 0) {
              break label1532;
            }
            localTRTCMixUser2.x = (k / 2);
            localTRTCMixUser2.y = 0;
            localTRTCMixUser2.width = (k / 2);
            localTRTCMixUser2.height = (j / 4);
          }
          for (;;)
          {
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser2.userId + ", pureAudioMode: " + localTRTCMixUser2.pureAudio + ", userStream: " + localObject2);
            localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser2);
            i += 1;
            break;
            label1532:
            if (i == 1)
            {
              localTRTCMixUser2.x = (k / 2);
              localTRTCMixUser2.y = (j / 4);
              localTRTCMixUser2.width = (k / 2);
              localTRTCMixUser2.height = (j / 4);
            }
          }
        }
      }
      else if (i == 3)
      {
        localTRTCMixUser1.x = 0;
        localTRTCMixUser1.y = 0;
        localTRTCMixUser1.width = (k / 2);
        localTRTCMixUser1.height = (j / 4);
        localTRTCTranscodingConfig.videoWidth = k;
        localTRTCTranscodingConfig.videoHeight = (j / 2);
        localTRTCTranscodingConfig.backgroundImage = "410";
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          localTRTCMixUser2 = new TRTCCloudDef.TRTCMixUser();
          locald = a.a.aLN().aLL();
          if ((locald.kpg) && (((a)localObject2).iSn.equalsIgnoreCase(locald.kpf))) {
            localTRTCMixUser2.roomId = locald.kpe;
          }
          localTRTCMixUser2.userId = ((a)localObject2).iSn;
          localTRTCMixUser2.streamType = ((a)localObject2).mStreamType;
          localTRTCMixUser2.zOrder = (i + 1);
          localTRTCMixUser2.pureAudio = true;
          localObject2 = NH(localTRTCMixUser2.userId);
          if (localObject2 != null)
          {
            localTRTCMixUser2.pureAudio = ((b)localObject2).kpV;
            if (i != 0) {
              break label1880;
            }
            localTRTCMixUser2.x = (k / 2);
            localTRTCMixUser2.y = 0;
            localTRTCMixUser2.width = (k / 2);
            localTRTCMixUser2.height = (j / 4);
          }
          for (;;)
          {
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser2.userId + ", pureAudioMode: " + localTRTCMixUser2.pureAudio + ", userStream: " + localObject2);
            localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser2);
            i += 1;
            break;
            label1880:
            if (i == 1)
            {
              localTRTCMixUser2.x = 0;
              localTRTCMixUser2.y = (j / 4);
              localTRTCMixUser2.width = (k / 2);
              localTRTCMixUser2.height = (j / 4);
            }
            else if (i == 2)
            {
              localTRTCMixUser2.x = (k / 2);
              localTRTCMixUser2.y = (j / 4);
              localTRTCMixUser2.width = (k / 2);
              localTRTCMixUser2.height = (j / 4);
            }
          }
        }
      }
      label1961:
      if ((bool1) && (!bool2))
      {
        localTRTCMixUser1.width = 0;
        localTRTCMixUser1.height = 0;
      }
      bool2 = a.a.aLN().aLJ().kpz;
      if (paramBoolean)
      {
        this.koH.setMixTranscodingConfig(localTRTCTranscodingConfig);
        Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, reset");
      }
      for (;;)
      {
        this.kpR = ac(localTRTCTranscodingConfig.mixUsers);
        Log.i("MicroMsg.LiveCoreVisitor", "sendLinkMicSeiMsg linkMicSeiMsgJson:" + this.kpR);
        if (this.kpR != null) {
          break;
        }
        this.kpS.stopTimer();
        AppMethodBeat.o(199650);
        return;
        if ((bool2) || ((localTRTCTranscodingConfig.mixUsers != null) && (localTRTCTranscodingConfig.mixUsers.size() > 1)))
        {
          this.koH.setMixTranscodingConfig(localTRTCTranscodingConfig);
          Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", new Object[] { localTRTCTranscodingConfig, Boolean.valueOf(bool2) });
        }
        else if (bool1)
        {
          this.koH.setMixTranscodingConfig(localTRTCTranscodingConfig);
          Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", new Object[] { localTRTCTranscodingConfig, Boolean.valueOf(bool2) });
        }
        else
        {
          this.koH.setMixTranscodingConfig(null);
          Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
        }
      }
      this.kpS.startTimer(1000L);
      AppMethodBeat.o(199650);
      return;
      m = 15;
    }
  }
  
  public final void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(199546);
    this.koH.muteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(199546);
  }
  
  public final void y(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(199544);
    if (paramLong1 > 0L) {
      this.kpO = ((int)paramLong1);
    }
    if (paramLong2 > 0L) {
      this.kpP = ((int)paramLong2);
    }
    TXLog.i("MicroMsg.LiveCoreVisitor", "setQCloudAccount:appid: " + paramLong1 + ", bizid: " + paramLong2 + ", mCloudAppid: " + this.kpO + ", mCloudBizid: " + this.kpP);
    AppMethodBeat.o(199544);
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public boolean kpV = true;
    public int streamType;
    public String userId;
    public int x = 0;
    public int y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b.c
 * JD-Core Version:    0.7.0.1
 */