package com.tencent.mm.modelvideo;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.br;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.cc;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class t
{
  private static int pae = 0;
  private boolean hxI;
  int hxJ;
  private f.a hxM;
  private MTimerHandler hxN;
  private LinkedList<Long> oZZ;
  private Map<Long, f.a> paa;
  private Map<Long, String> pab;
  private Object pac;
  String pad;
  private boolean running;
  
  public t()
  {
    AppMethodBeat.i(126906);
    this.oZZ = new LinkedList();
    this.paa = new HashMap();
    this.pab = new HashMap();
    this.pac = new Object();
    this.hxI = false;
    this.running = false;
    this.hxJ = 0;
    this.hxM = new f.a();
    this.hxN = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126901);
        t.h(t.this);
        AppMethodBeat.o(126901);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(126902);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(126902);
        return str;
      }
    }, false);
    AppMethodBeat.o(126906);
  }
  
  private void aHh()
  {
    AppMethodBeat.i(126911);
    this.pab.clear();
    this.paa.clear();
    this.oZZ.clear();
    this.hxI = false;
    this.running = false;
    Log.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.hxM.aPY());
    AppMethodBeat.o(126911);
  }
  
  public static void cj(List<z> paramList)
  {
    AppMethodBeat.i(126907);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126907);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ab.Qf(((z)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126907);
  }
  
  public static void ck(List<z> paramList)
  {
    AppMethodBeat.i(126908);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126908);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ab.Qg(((z)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126908);
  }
  
  private String jc(long paramLong)
  {
    AppMethodBeat.i(126909);
    Object localObject2 = v.bOh().jd(paramLong);
    if (((List)localObject2).isEmpty())
    {
      Log.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (z)((Iterator)localObject1).next();
      if (com.tencent.mm.model.ab.IW(((z)localObject3).bOs()))
      {
        Log.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((z)localObject3).bOs(), ((z)localObject3).pbj, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
      k.bHW();
      if ((!com.tencent.mm.modelcdntran.g.vV(2)) && (((z)localObject3).pbg != 1))
      {
        k.bHW();
        Log.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.g.vV(2)), Integer.valueOf(((z)localObject3).pbg), ((z)localObject3).pbj, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
    }
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      Log.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
      AppMethodBeat.o(126909);
      return null;
      int i = 0;
      for (;;)
      {
        if (i >= ((List)localObject2).size()) {
          break label425;
        }
        localObject3 = (z)((List)localObject2).get(i);
        localObject1 = ab.Qo(((z)localObject3).getFileName());
        if (localObject1 != null)
        {
          Log.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((z)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((z)localObject3).pbj });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        Log.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((z)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((z)localObject3).pbj });
        i += 1;
      }
      label425:
      localObject1 = null;
    }
    Object localObject3 = com.tencent.mm.modelcdntran.h.a("upvideo", ((z)localObject1).createTime, ((z)localObject1).pbj, ((z)localObject1).getFileName());
    if (Util.isNullOrNil((String)localObject3))
    {
      Log.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((z)localObject1).getFileName(), Long.valueOf(((z)localObject1).oYW), ((z)localObject1).pbj });
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject4 = ((z)localObject1).getFileName();
    v.bOh();
    String str1 = aa.PY((String)localObject4);
    v.bOh();
    String str2 = aa.PX((String)localObject4);
    a locala = new a((byte)0);
    locala.ooG = ((List)localObject2);
    locala.oYW = paramLong;
    locala.pah = ((String)localObject3);
    locala.startTime = Util.nowMilliSecond();
    locala.oYX = ((z)localObject1);
    localObject4 = new com.tencent.mm.g.g();
    ((com.tencent.mm.g.g)localObject4).taskName = "task_NetSceneUploadVideo_2";
    ((com.tencent.mm.g.g)localObject4).lwL = locala;
    ((com.tencent.mm.g.g)localObject4).field_mediaId = ((String)localObject3);
    ((com.tencent.mm.g.g)localObject4).field_fullpath = str2;
    ((com.tencent.mm.g.g)localObject4).field_thumbpath = str1;
    ((com.tencent.mm.g.g)localObject4).field_fileType = a.MediaType_VIDEO;
    ((com.tencent.mm.g.g)localObject4).field_smallVideoFlag = 1;
    ((com.tencent.mm.g.g)localObject4).field_talker = ((z)localObject1).pbj;
    ((com.tencent.mm.g.g)localObject4).field_priority = a.lvZ;
    ((com.tencent.mm.g.g)localObject4).field_needStorage = false;
    ((com.tencent.mm.g.g)localObject4).field_isStreamMedia = false;
    localObject1 = XmlParser.parseXml(((z)localObject1).bOu(), "msg", null);
    if (localObject1 != null)
    {
      ((com.tencent.mm.g.g)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.g.g)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!k.bHW().g((com.tencent.mm.g.g)localObject4))
    {
      Log.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      AppMethodBeat.o(126909);
      return null;
      Log.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (z)((Iterator)localObject1).next();
      if (((z)localObject2).pbg != 1)
      {
        ((z)localObject2).pbg = 1;
        ((z)localObject2).eQp = 524288;
        boolean bool = ab.f((z)localObject2);
        Log.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((z)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(126909);
    return localObject3;
  }
  
  public final void f(final long paramLong, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(126910);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126897);
        t.bOd();
        t.c(t.this);
        t.a(t.this, "");
        long l2 = 0L;
        long l1 = l2;
        if (paramLong > 0L)
        {
          l1 = l2;
          if (t.d(t.this).get(Long.valueOf(paramLong)) != null) {
            l1 = ((f.a)t.d(t.this).get(Long.valueOf(paramLong))).aPY();
          }
        }
        Log.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Integer.valueOf(paramInt2), Integer.valueOf(this.val$errCode) });
        if ((paramInt2 != 0) || (this.val$errCode != 0)) {
          t.j(t.this);
        }
        Log.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(t.pae), Integer.valueOf(t.e(t.this)), Boolean.valueOf(t.f(t.this)), Boolean.valueOf(t.g(t.this)) });
        if (t.e(t.this) > 0) {
          t.h(t.this);
        }
        while (t.g(t.this))
        {
          t.bOe();
          AppMethodBeat.o(126897);
          return;
        }
        Log.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
        aa localaa = v.bOh();
        Object localObject2 = t.k(t.this);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {}
        for (;;)
        {
          t.i(t.this);
          break;
          l1 = System.currentTimeMillis() / 1000L;
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append('(');
          int i = 0;
          while (i < ((List)localObject2).size() - 1)
          {
            ((StringBuilder)localObject1).append((Long)((List)localObject2).get(i));
            ((StringBuilder)localObject1).append(',');
            i += 1;
          }
          localObject2 = (Long)((List)localObject2).get(((List)localObject2).size() - 1);
          if (localObject2 != null) {
            ((StringBuilder)localObject1).append(localObject2);
          }
          ((StringBuilder)localObject1).append(')');
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject1 = "UPDATE videoinfo2 SET status=198, lastmodifytime=" + l1 + " WHERE masssendid IN " + (String)localObject1;
          Log.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject1 });
          localaa.omV.execSQL("videoinfo2", (String)localObject1);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(126898);
        String str = super.toString() + "|onSceneEnd";
        AppMethodBeat.o(126898);
        return str;
      }
    });
    AppMethodBeat.o(126910);
  }
  
  final class a
    implements com.tencent.mm.am.h, g.a
  {
    long oYW;
    z oYX;
    List<z> ooG;
    String pah;
    long startTime;
    
    private a() {}
    
    public final int a(String arg1, int paramInt, c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126904);
      Log.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.pah, Integer.valueOf(paramInt), paramc, paramd });
      if (paramInt == -21005)
      {
        Log.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.pah });
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramInt != 0)
      {
        t.cj(this.ooG);
        Log.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.oYW), Integer.valueOf(paramInt) });
        t.this.f(this.oYW, 3, paramInt);
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramc != null)
      {
        Log.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Long.valueOf(paramc.field_finishedLength) });
        ??? = this.ooG.iterator();
        while (???.hasNext())
        {
          paramd = (z)???.next();
          paramd.pba = Util.nowSecond();
          paramd.oZm = ((int)paramc.field_finishedLength);
          paramd.eQp = 1032;
          ab.f(paramd);
        }
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramd != null)
      {
        if (paramd.field_retCode != 0)
        {
          Log.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, Long.valueOf(this.oYW) });
          t.cj(this.ooG);
          t.this.f(this.oYW, 3, paramd.field_retCode);
        }
      }
      else
      {
        AppMethodBeat.o(126904);
        return 0;
      }
      Log.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Long.valueOf(this.oYW) });
      ??? = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "length=\"" + paramd.field_fileLength + "\" ";
      ??? = ??? + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
      Log.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
      paramc = this.ooG.iterator();
      while (paramc.hasNext())
      {
        z localz = (z)paramc.next();
        if (Util.isNullOrNil(localz.bOu()))
        {
          localz.pbh = ???;
          localz.eQp = 2097152;
          paramBoolean = ab.f(localz);
          Log.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.oYW), localz.getFileName(), Boolean.valueOf(paramBoolean) });
        }
      }
      for (;;)
      {
        synchronized (t.a(t.this))
        {
          paramc = (String)t.b(t.this).get(Long.valueOf(this.oYW));
          if (Util.isNullOrNil(paramc)) {
            Log.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.oYW), paramc, this.pah });
          }
        }
        Log.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.oYW), paramc, this.pah });
        t.b(t.this).put(Long.valueOf(this.oYW), "done_upload_cdn_client_id");
        com.tencent.mm.kernel.h.aZW().a(245, this);
        paramc = new i(this.oYW, this.oYX, paramd, this.pah);
        if (!com.tencent.mm.kernel.h.aZW().a(paramc, 0))
        {
          Log.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
          com.tencent.mm.kernel.h.aZW().b(245, this);
          t.this.f(this.oYW, 3, 0);
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(126905);
      com.tencent.mm.kernel.h.aZW().b(245, this);
      if ((paramInt1 == 4) && (paramInt2 == -22))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.oYW);
        t.ck(this.ooG);
        t.this.f(this.oYW, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 != 0))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.oYW);
        t.cj(this.ooG);
        t.this.f(this.oYW, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.oYW);
        t.cj(this.ooG);
        t.this.f(this.oYW, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      paramString = this.ooG.iterator();
      if (paramString.hasNext())
      {
        paramp = (z)paramString.next();
        paramp.pba = Util.nowSecond();
        paramp.status = 199;
        paramp.eQp = 1280;
        if (ab.f(paramp))
        {
          if (paramp != null) {
            break label378;
          }
          Log.e("MicroMsg.VideoLogic", "video info is null");
        }
        for (;;)
        {
          Log.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.oYW), paramp.getFileName(), Integer.valueOf(199) });
          break;
          label378:
          cc localcc;
          if (paramp.pbc > 0)
          {
            localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramp.pbc);
            paramInt1 = localcc.getType();
            Log.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
            if ((43 == paramInt1) || (62 == paramInt1))
            {
              localcc.pI(1);
              localcc.BS(paramp.bOs());
              localcc.gX(paramp.hTh);
              localcc.setStatus(2);
              localcc.setContent(x.a(paramp.bOq(), paramp.omT, false));
              ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramp.pbc, localcc);
              Log.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localcc.field_msgId) });
            }
          }
          else
          {
            localcc = new cc();
            localcc.BS(paramp.bOs());
            localcc.setType(62);
            localcc.pI(1);
            localcc.BT(paramp.getFileName());
            localcc.setStatus(2);
            localcc.setCreateTime(br.JN(paramp.bOs()));
            paramp.pbc = ((int)br.B(localcc));
            paramp.eQp = 8192;
            ab.f(paramp);
            Log.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localcc.field_msgId) });
          }
        }
      }
      paramString = t.this;
      long l = this.oYW;
      com.tencent.mm.kernel.h.baH().postToWorker(new t.1(paramString, l));
      AppMethodBeat.o(126905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.t
 * JD-Core Version:    0.7.0.1
 */