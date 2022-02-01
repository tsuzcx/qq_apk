package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.a;
import com.tencent.mm.g.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/model/ExDeviceSendIotLogic;", "", "msgId", "", "(J)V", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "getCdnCallback", "()Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "setCdnCallback", "(Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;)V", "cdnHWDeviceMsg", "Lcom/tencent/mm/protocal/protobuf/HwDeviceMsg;", "getCdnHWDeviceMsg", "()Lcom/tencent/mm/protocal/protobuf/HwDeviceMsg;", "setCdnHWDeviceMsg", "(Lcom/tencent/mm/protocal/protobuf/HwDeviceMsg;)V", "cdnMsgCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "currentCdnState", "", "getCurrentCdnState", "()I", "setCurrentCdnState", "(I)V", "getMsgId", "()J", "setMsgId", "normalMsgCallback", "pendingCdnWaitDevice", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/exdevice/model/NetworkDeviceInfo;", "getPendingCdnWaitDevice", "()Ljava/util/concurrent/ConcurrentHashMap;", "setPendingCdnWaitDevice", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "useCdnTransClientId", "getUseCdnTransClientId", "()Ljava/lang/String;", "setUseCdnTransClientId", "(Ljava/lang/String;)V", "cancelTask", "", "deviceId", "checkCdnTask", "", "deviceInfo", "doFileUpload", "fileUpload", "sendDataToIotDevice", "iotDeviceType", "sendRequest", "deviceMsg", "callback", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a ypk;
  long msgId;
  String oHX;
  private g.a osH;
  int ypl;
  ConcurrentHashMap<String, ae> ypm;
  dao ypn;
  private com.tencent.mm.am.h ypo;
  private com.tencent.mm.am.h ypp;
  
  static
  {
    AppMethodBeat.i(274616);
    ypk = new c.a((byte)0);
    AppMethodBeat.o(274616);
  }
  
  public c(long paramLong)
  {
    AppMethodBeat.i(274592);
    this.msgId = paramLong;
    this.ypm = new ConcurrentHashMap();
    this.ypo = new c..ExternalSyntheticLambda0(this);
    this.ypp = new c..ExternalSyntheticLambda1(this);
    this.osH = ((g.a)new b(this));
    AppMethodBeat.o(274592);
  }
  
  private static final void a(c paramc, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(274599);
    kotlin.g.b.s.u(paramc, "this$0");
    paramp.setHasCallbackToQueue(true);
    Log.i("ExDeviceSendIotLogic", "normalMsg, onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.model.NetSceneTransferToIotDevice");
      AppMethodBeat.o(274599);
      throw paramc;
    }
    paramString = (aa)paramp;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      bh.bCz();
      paramp = com.tencent.mm.model.c.bzD().sl(paramc.msgId);
      if (paramInt2 == -125)
      {
        Boolean localBoolean = e.aN(paramp);
        kotlin.g.b.s.s(localBoolean, "isImg(msgInfo)");
        if (!localBoolean.booleanValue())
        {
          localBoolean = e.aM(paramp);
          kotlin.g.b.s.s(localBoolean, "isFile(msgInfo)");
          if (!localBoolean.booleanValue())
          {
            paramp = e.aQ(paramp);
            kotlin.g.b.s.s(paramp, "isVideo(msgInfo)");
            if (!paramp.booleanValue()) {
              break label209;
            }
          }
        }
        paramString = paramString.ysf;
        kotlin.g.b.s.s(paramString, "sudScene.deviceInfo");
        com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda2(paramc, paramString), "ExDeviceSendIotLogic");
        AppMethodBeat.o(274599);
        return;
      }
      label209:
      e.gR(paramString.ysf.deviceID, e.ypy);
      ah.dFQ().lN(paramc.msgId);
      AppMethodBeat.o(274599);
      return;
    }
    e.gR(paramString.ysf.deviceID, e.ypx);
    AppMethodBeat.o(274599);
  }
  
  private static final void a(c paramc, ae paramae)
  {
    AppMethodBeat.i(274613);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramae, "$deviceInfo");
    Object localObject1;
    Object localObject2;
    cc localcc;
    Object localObject3;
    long l1;
    int i;
    switch (paramc.ypl)
    {
    default: 
      AppMethodBeat.o(274613);
      return;
    case 0: 
      kotlin.g.b.s.u(paramae, "deviceInfo");
      Log.i("ExDeviceSendIotLogic", "upload state %d", new Object[] { Integer.valueOf(paramc.ypl) });
      if (paramc.ypl == 0)
      {
        paramc.ypl = 1;
        localObject1 = (Map)paramc.ypm;
        localObject2 = paramae.deviceID;
        kotlin.g.b.s.s(localObject2, "deviceInfo.deviceID");
        ((Map)localObject1).put(localObject2, paramae);
        localObject2 = "";
        localObject1 = "";
        bh.bCz();
        localcc = com.tencent.mm.model.c.bzD().sl(paramc.msgId);
        kotlin.g.b.s.s(localcc, "getAccStg().messageStg.getById(msgId)");
        paramae = null;
        localObject3 = e.aN(localcc);
        kotlin.g.b.s.s(localObject3, "isImg(msgInfo)");
        if (((Boolean)localObject3).booleanValue())
        {
          paramae = r.bKa().af(localcc);
          kotlin.g.b.s.s(paramae, "getImgStg().getByMsg(msgInfo)");
          localObject2 = r.bKa().v(paramae.oGr, "", "");
          localObject1 = r.bKa().v(paramae.oGt, "", "");
          l1 = paramae.localId;
          i = paramae.oGu;
          if (!new u((String)localObject2).jKS()) {
            i = -1;
          }
          for (;;)
          {
            label273:
            if (i != 0)
            {
              paramc.ypl = 3;
              paramae = paramc.ypm.keySet().iterator();
              for (;;)
              {
                label295:
                if (paramae.hasNext())
                {
                  localObject1 = (String)paramae.next();
                  Log.i("ExDeviceSendIotLogic", "send cdn failed " + (String)localObject1 + " ret " + i);
                  if (i == -1)
                  {
                    e.gR((String)localObject1, e.ypA);
                    continue;
                    k.bHW();
                    if ((!com.tencent.mm.modelcdntran.g.vV(1)) && (Util.isNullOrNil(paramae.oGC)))
                    {
                      k.bHW();
                      Log.w("ExDeviceSendIotLogic", "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.g.vV(1)), paramae.oGC });
                      i = -2;
                      break;
                    }
                    paramc.oHX = com.tencent.mm.modelcdntran.h.a("upimg", localcc.getCreateTime(), localcc.field_talker, localcc.field_msgId + '_' + l1 + '_' + i);
                    if (i != 1) {
                      paramae = Integer.valueOf(2);
                    }
                  }
                }
              }
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      if ((paramc.oHX == null) || (paramae == null))
      {
        Log.w("ExDeviceSendIotLogic", "not support file Type");
        i = -2;
        break label273;
        paramae = Integer.valueOf(1);
        continue;
        localObject3 = e.aM(localcc);
        kotlin.g.b.s.s(localObject3, "isFile(msgInfo)");
        if (((Boolean)localObject3).booleanValue())
        {
          paramae = k.b.Hf(localcc.field_content);
          kotlin.g.b.s.s(paramae, "parse(msgInfo.content)");
          localObject2 = localcc.field_content;
          kotlin.g.b.s.s(localObject2, "msgInfo.content");
          localObject2 = k.b.Hf((String)localObject2);
          kotlin.g.b.s.s(localObject2, "parse(msgContent)");
          localObject3 = as.cWJ().bpI(((k.b)localObject2).hzM);
          if ((paramae.nRh != 0) || (paramae.nRd > 26214400)) {
            paramae = Integer.valueOf(a.lwb);
          }
          for (;;)
          {
            if (localObject3 != null)
            {
              localObject2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              if (!new u((String)localObject2).jKS())
              {
                i = -1;
                break;
                paramae = Integer.valueOf(a.MediaType_FILE);
                continue;
              }
              k.bHW();
              if ((com.tencent.mm.modelcdntran.g.vV(4)) || (((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_isUseCdn == 1)) {
                break label747;
              }
              k.bHW();
              Log.w("ExDeviceSendIotLogic", "cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.g.vV(4)), Integer.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_isUseCdn) });
              i = -2;
              break;
            }
          }
          Log.e("ExDeviceSendIotLogic", "getFilePath attInfo is null");
          i = -2;
          break label273;
          label747:
          if (!Util.isNullOrNil(localcc.field_imgPath)) {
            localObject1 = r.bKa().NY(localcc.field_imgPath);
          }
          l1 = y.bEl((String)localObject1);
          l2 = y.bEl(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
          if (l1 >= a.lwv)
          {
            Log.w("ExDeviceSendIotLogic", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(l1) });
            i = -2;
            break label273;
          }
          paramc.oHX = com.tencent.mm.modelcdntran.h.a("upvideo", localcc.getCreateTime(), localcc.field_talker, com.tencent.mm.modelvideo.aa.PW(localcc.aJO()));
          if (Util.isNullOrNil(paramc.oHX))
          {
            Log.w("ExDeviceSendIotLogic", "cdntra genClientId failed not use cdn compressType:%d", new Object[] { Integer.valueOf(0) });
            i = -2;
            break label273;
          }
          Log.d("ExDeviceSendIotLogic", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", new Object[] { Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_msgInfoId), ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath, Long.valueOf(l2), localObject1, Long.valueOf(l1) });
          continue;
        }
        localObject1 = e.aQ(localcc);
        kotlin.g.b.s.s(localObject1, "isVideo(msgInfo)");
        if (!((Boolean)localObject1).booleanValue()) {
          break label1525;
        }
        i = a.MediaType_VIDEO;
        v.bOh();
        localObject2 = com.tencent.mm.modelvideo.aa.PX(localcc.field_imgPath);
        v.bOh();
        localObject1 = com.tencent.mm.modelvideo.aa.PY(localcc.field_imgPath);
        if (!new u((String)localObject2).jKS())
        {
          i = -1;
          break label273;
        }
        Log.d("ExDeviceSendIotLogic", " fullpath " + localObject2 + " thumbPath " + localObject1);
        l1 = y.bEl((String)localObject1);
        long l2 = y.bEl((String)localObject2);
        if (l1 >= a.lwv)
        {
          Log.w("ExDeviceSendIotLogic", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(l1) });
          i = -2;
          break label273;
        }
        paramc.oHX = com.tencent.mm.modelcdntran.h.a("upvideo", localcc.getCreateTime(), localcc.field_talker, kotlin.g.b.s.X("", Integer.valueOf(0)));
        if (Util.isNullOrNil(paramc.oHX))
        {
          Log.w("ExDeviceSendIotLogic", "cdntra genClientId failed not use cdn compressType:%d", new Object[] { Integer.valueOf(0) });
          i = -2;
          break label273;
        }
        Log.d("ExDeviceSendIotLogic", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", new Object[] { Long.valueOf(localcc.field_msgId), localObject2, Long.valueOf(l2), localObject1, Long.valueOf(l1) });
        paramae = Integer.valueOf(i);
        continue;
      }
      localObject3 = new com.tencent.mm.g.g();
      ((com.tencent.mm.g.g)localObject3).taskName = "task_ExdeviceSendDataToNetworkDevice";
      ((com.tencent.mm.g.g)localObject3).lwL = paramc.osH;
      ((com.tencent.mm.g.g)localObject3).field_mediaId = paramc.oHX;
      ((com.tencent.mm.g.g)localObject3).field_fullpath = ((String)localObject2);
      ((com.tencent.mm.g.g)localObject3).field_thumbpath = ((String)localObject1);
      ((com.tencent.mm.g.g)localObject3).field_fileType = paramae.intValue();
      ((com.tencent.mm.g.g)localObject3).field_talker = localcc.field_talker;
      ((com.tencent.mm.g.g)localObject3).field_priority = a.lvY;
      ((com.tencent.mm.g.g)localObject3).field_needStorage = false;
      ((com.tencent.mm.g.g)localObject3).field_isStreamMedia = false;
      ((com.tencent.mm.g.g)localObject3).field_appType = 1;
      ((com.tencent.mm.g.g)localObject3).field_bzScene = 0;
      if ((com.tencent.mm.modelcdntran.h.bHQ()) && (((com.tencent.mm.g.g)localObject3).field_fileType == a.lwb)) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.g.g)localObject3).field_use_multithread = bool;
        if (k.bHW().g((com.tencent.mm.g.g)localObject3)) {
          break label1400;
        }
        Log.e("ExDeviceSendIotLogic", "cdntra addSendTask failed. clientid:%s", new Object[] { paramc.oHX });
        paramc.oHX = "";
        i = -2;
        break;
      }
      label1400:
      i = 0;
      break label273;
      e.gR((String)localObject1, e.ypy);
      break label295;
      paramc.ypm.clear();
      AppMethodBeat.o(274613);
      return;
      paramc = (Map)paramc.ypm;
      localObject1 = paramae.deviceID;
      kotlin.g.b.s.s(localObject1, "deviceInfo.deviceID");
      paramc.put(localObject1, paramae);
      AppMethodBeat.o(274613);
      return;
      localObject1 = paramc.ypn;
      if (localObject1 != null)
      {
        a((dao)localObject1, paramae, paramc.ypp);
        AppMethodBeat.o(274613);
        return;
      }
      Log.i("ExDeviceSendIotLogic", "no cdn msg");
      AppMethodBeat.o(274613);
      return;
      e.gR(paramae.deviceID, e.ypy);
      break;
      label1525:
      localObject1 = "";
    }
  }
  
  private static final void a(c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(274615);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramString, "$deviceId");
    Log.i("ExDeviceSendIotLogic", "send msgid %d", new Object[] { Long.valueOf(paramc.msgId) });
    bh.bCz();
    com.tencent.mm.model.c.bzD().sl(paramc.msgId);
    ae localae = new ae();
    localae.deviceID = paramString;
    localae.hFT = paramInt;
    localae.hEm = true;
    paramString = new dao();
    if (e.a(paramString, paramc.msgId)) {
      a(paramString, localae, paramc.ypo);
    }
    AppMethodBeat.o(274615);
  }
  
  public static void a(dao paramdao, ae paramae, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(274594);
    kotlin.g.b.s.u(paramae, "deviceInfo");
    kotlin.g.b.s.u(paramh, "callback");
    if (paramdao == null)
    {
      Log.w("ExDeviceSendIotLogic", "deviceMsg null");
      AppMethodBeat.o(274594);
      return;
    }
    com.tencent.mm.network.g localg = com.tencent.mm.kernel.h.aZW().oun;
    if (localg == null)
    {
      Log.w("ExDeviceSendIotLogic", "dispatcher null");
      AppMethodBeat.o(274594);
      return;
    }
    new aa(paramdao, paramae).doScene(localg, paramh);
    AppMethodBeat.o(274594);
  }
  
  private static final void b(c paramc, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(274602);
    kotlin.g.b.s.u(paramc, "this$0");
    paramp.setHasCallbackToQueue(true);
    Log.i("ExDeviceSendIotLogic", "cdnMsg, onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.model.NetSceneTransferToIotDevice");
      AppMethodBeat.o(274602);
      throw paramc;
    }
    paramp = (aa)paramp;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("ExDeviceSendIotLogic", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      e.gR(paramp.ysf.deviceID, e.ypy);
      ah.dFQ().lN(paramc.msgId);
      AppMethodBeat.o(274602);
      return;
    }
    Log.e("ExDeviceSendIotLogic", "cdn reupload");
    e.gR(paramp.ysf.deviceID, e.ypx);
    AppMethodBeat.o(274602);
  }
  
  public final void bi(int paramInt, String paramString)
  {
    AppMethodBeat.i(274624);
    kotlin.g.b.s.u(paramString, "deviceId");
    com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda3(this, paramString, paramInt), "ExDeviceSendIotLogic");
    AppMethodBeat.o(274624);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/exdevice/model/ExDeviceSendIotLogic$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(c paramc) {}
    
    private static final void b(c paramc)
    {
      AppMethodBeat.i(274663);
      kotlin.g.b.s.u(paramc, "this$0");
      Iterator localIterator = paramc.ypm.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        Log.i("ExDeviceSendIotLogic", kotlin.g.b.s.X("start send pending ", localObject));
        localObject = (ae)paramc.ypm.get(localObject);
        if (localObject != null) {
          c.a(paramc.ypn, (ae)localObject, c.a(paramc));
        }
      }
      paramc.ypm.clear();
      AppMethodBeat.o(274663);
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(274676);
      kotlin.g.b.s.u(paramString, "mediaId");
      Log.d("ExDeviceSendIotLogic", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.ypq.oHX, Integer.valueOf(paramInt), paramc, paramd });
      if (paramc != null) {}
      label383:
      for (;;)
      {
        try
        {
          paramInt = (int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F);
          Log.d("ExDeviceSendIotLogic", "sent to cloud progress %d", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt < 100) {
            break label383;
          }
          paramInt = 99;
          paramString = this.ypq.ypm.keySet().iterator();
          if (paramString.hasNext())
          {
            e.ee((String)paramString.next(), paramInt);
            continue;
            AppMethodBeat.o(274676);
          }
        }
        catch (Exception paramString)
        {
          Log.e("ExDeviceSendIotLogic", "cdnCallback Exception %s", new Object[] { paramString });
        }
        while (paramd == null) {
          return 0;
        }
        paramString = new dao();
        bh.bCz();
        paramc = com.tencent.mm.model.c.bzD().sl(this.ypq.msgId);
        com.tencent.mm.plugin.exdevice.i.d locald = new com.tencent.mm.plugin.exdevice.i.d();
        locald.field_fileid = paramd.field_fileId;
        locald.field_aeskey = paramd.field_aesKey;
        locald.field_msgid = this.ypq.msgId;
        locald.field_md5 = paramd.field_filemd5;
        locald.field_size = ((int)paramd.field_fileLength);
        locald.field_talker = paramc.field_talker;
        Log.d("ExDeviceSendIotLogic", kotlin.g.b.s.X("fields length", locald.getDBInfo().fields));
        ah.a(locald);
        e.a(paramString, this.ypq.msgId);
        Log.i("ExDeviceSendIotLogic", "cdn uploaded md5 " + paramd.field_filemd5 + " size " + paramd.field_fileLength);
        this.ypq.ypn = paramString;
        this.ypq.ypl = 2;
        com.tencent.threadpool.h.ahAA.g(new c.b..ExternalSyntheticLambda0(this.ypq), "ExDeviceSendIotLogic");
        AppMethodBeat.o(274676);
        return 0;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(274680);
      kotlin.g.b.s.u(paramString, "mediaId");
      kotlin.g.b.s.u(paramByteArrayOutputStream, "buff");
      Log.i("ExDeviceSendIotLogic", kotlin.g.b.s.X("getCdnAuthInfo mediaId = ", paramString));
      AppMethodBeat.o(274680);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(274682);
      kotlin.g.b.s.u(paramString, "mediaId");
      kotlin.g.b.s.u(paramArrayOfByte, "inbuf");
      Log.i("ExDeviceSendIotLogic", "decodePrepareResponse ");
      AppMethodBeat.o(274682);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */