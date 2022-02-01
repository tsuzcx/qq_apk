package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.ao.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m
{
  private static int cZH = 0;
  private boolean cZE;
  int cZF;
  private f.a cZJ;
  private av cZK;
  private LinkedList<Long> hzk;
  private Map<Long, f.a> hzl;
  private Map<Long, String> hzm;
  private Object hzn;
  String hzo;
  private boolean running;
  
  public m()
  {
    AppMethodBeat.i(126906);
    this.hzk = new LinkedList();
    this.hzl = new HashMap();
    this.hzm = new HashMap();
    this.hzn = new Object();
    this.cZE = false;
    this.running = false;
    this.cZF = 0;
    this.cZJ = new f.a();
    this.cZK = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126901);
        m.h(m.this);
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
  
  private void Oy()
  {
    AppMethodBeat.i(126911);
    this.hzm.clear();
    this.hzl.clear();
    this.hzk.clear();
    this.cZE = false;
    this.running = false;
    ad.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.cZJ.XK());
    AppMethodBeat.o(126911);
  }
  
  public static void aA(List<s> paramList)
  {
    AppMethodBeat.i(126908);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126908);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.zW(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126908);
  }
  
  public static void az(List<s> paramList)
  {
    AppMethodBeat.i(126907);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126907);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.zV(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126907);
  }
  
  private String mD(long paramLong)
  {
    AppMethodBeat.i(126909);
    Object localObject2 = o.aCI().mE(paramLong);
    if (((List)localObject2).isEmpty())
    {
      ad.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (s)((Iterator)localObject1).next();
      if (w.tp(((s)localObject3).getUser()))
      {
        ad.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((s)localObject3).getUser(), ((s)localObject3).hAp, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
      com.tencent.mm.ao.f.awL();
      if ((!b.nL(2)) && (((s)localObject3).hAm != 1))
      {
        com.tencent.mm.ao.f.awL();
        ad.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(b.nL(2)), Integer.valueOf(((s)localObject3).hAm), ((s)localObject3).hAp, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
    }
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      ad.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
      AppMethodBeat.o(126909);
      return null;
      int i = 0;
      for (;;)
      {
        if (i >= ((List)localObject2).size()) {
          break label425;
        }
        localObject3 = (s)((List)localObject2).get(i);
        localObject1 = u.Ae(((s)localObject3).getFileName());
        if (localObject1 != null)
        {
          ad.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).hAp });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        ad.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).hAp });
        i += 1;
      }
      label425:
      localObject1 = null;
    }
    Object localObject3 = com.tencent.mm.ao.c.a("upvideo", ((s)localObject1).createTime, ((s)localObject1).hAp, ((s)localObject1).getFileName());
    if (bt.isNullOrNil((String)localObject3))
    {
      ad.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((s)localObject1).getFileName(), Long.valueOf(((s)localObject1).hyw), ((s)localObject1).hAp });
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject4 = ((s)localObject1).getFileName();
    o.aCI();
    String str1 = t.zR((String)localObject4);
    o.aCI();
    String str2 = t.zQ((String)localObject4);
    a locala = new a((byte)0);
    locala.gQs = ((List)localObject2);
    locala.hyw = paramLong;
    locala.hzr = ((String)localObject3);
    locala.startTime = bt.eGO();
    locala.hyx = ((s)localObject1);
    localObject4 = new com.tencent.mm.i.g();
    ((com.tencent.mm.i.g)localObject4).fnH = locala;
    ((com.tencent.mm.i.g)localObject4).field_mediaId = ((String)localObject3);
    ((com.tencent.mm.i.g)localObject4).field_fullpath = str2;
    ((com.tencent.mm.i.g)localObject4).field_thumbpath = str1;
    ((com.tencent.mm.i.g)localObject4).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    ((com.tencent.mm.i.g)localObject4).field_smallVideoFlag = 1;
    ((com.tencent.mm.i.g)localObject4).field_talker = ((s)localObject1).hAp;
    ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.fmV;
    ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
    ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
    localObject1 = bw.K(((s)localObject1).aCT(), "msg");
    if (localObject1 != null)
    {
      ((com.tencent.mm.i.g)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.i.g)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!com.tencent.mm.ao.f.awL().e((com.tencent.mm.i.g)localObject4))
    {
      ad.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      AppMethodBeat.o(126909);
      return null;
      ad.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (s)((Iterator)localObject1).next();
      if (((s)localObject2).hAm != 1)
      {
        ((s)localObject2).hAm = 1;
        ((s)localObject2).dtM = 524288;
        boolean bool = u.f((s)localObject2);
        ad.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((s)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(126909);
    return localObject3;
  }
  
  public final void d(final long paramLong, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(126910);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126897);
        m.aCE();
        m.c(m.this);
        m.a(m.this, "");
        long l2 = 0L;
        long l1 = l2;
        if (paramLong > 0L)
        {
          l1 = l2;
          if (m.d(m.this).get(Long.valueOf(paramLong)) != null) {
            l1 = ((f.a)m.d(m.this).get(Long.valueOf(paramLong))).XK();
          }
        }
        ad.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Integer.valueOf(paramInt2), Integer.valueOf(this.val$errCode) });
        if ((paramInt2 != 0) || (this.val$errCode != 0)) {
          m.j(m.this);
        }
        ad.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(m.cZH), Integer.valueOf(m.e(m.this)), Boolean.valueOf(m.f(m.this)), Boolean.valueOf(m.g(m.this)) });
        if (m.e(m.this) > 0) {
          m.h(m.this);
        }
        while (m.g(m.this))
        {
          m.aCF();
          AppMethodBeat.o(126897);
          return;
        }
        ad.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
        t localt = o.aCI();
        Object localObject2 = m.k(m.this);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {}
        for (;;)
        {
          m.i(m.this);
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
          ad.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject1 });
          localt.gPa.execSQL("videoinfo2", (String)localObject1);
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
    implements com.tencent.mm.al.g, g.a
  {
    List<s> gQs;
    long hyw;
    s hyx;
    String hzr;
    long startTime;
    
    private a() {}
    
    public final int a(String arg1, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126904);
      ad.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.hzr, Integer.valueOf(paramInt), paramc, paramd });
      if (paramInt == -21005)
      {
        ad.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.hzr });
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramInt != 0)
      {
        m.az(this.gQs);
        ad.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.hyw), Integer.valueOf(paramInt) });
        new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(0), "" })).aBj();
        m.this.d(this.hyw, 3, paramInt);
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramc != null)
      {
        ad.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Long.valueOf(paramc.field_finishedLength) });
        ??? = this.gQs.iterator();
        while (???.hasNext())
        {
          paramd = (s)???.next();
          paramd.hAg = bt.aGK();
          paramd.hyM = ((int)paramc.field_finishedLength);
          paramd.dtM = 1032;
          u.f(paramd);
        }
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramd != null)
      {
        if (paramd.field_retCode != 0)
        {
          ad.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, Long.valueOf(this.hyw) });
          m.az(this.gQs);
          ??? = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns });
          new com.tencent.mm.g.b.a.h(???).aBj();
          new com.tencent.mm.g.b.a.f(???).aBj();
          m.this.d(this.hyw, 3, paramd.field_retCode);
        }
      }
      else
      {
        AppMethodBeat.o(126904);
        return 0;
      }
      ad.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Long.valueOf(this.hyw) });
      ??? = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "length=\"" + paramd.field_fileLength + "\" ";
      ??? = ??? + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
      ad.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
      paramc = this.gQs.iterator();
      while (paramc.hasNext())
      {
        s locals = (s)paramc.next();
        if (bt.isNullOrNil(locals.aCT()))
        {
          locals.hAn = ???;
          locals.dtM = 2097152;
          paramBoolean = u.f(locals);
          ad.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.hyw), locals.getFileName(), Boolean.valueOf(paramBoolean) });
        }
      }
      for (;;)
      {
        synchronized (m.a(m.this))
        {
          paramc = (String)m.b(m.this).get(Long.valueOf(this.hyw));
          if (bt.isNullOrNil(paramc)) {
            ad.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.hyw), paramc, this.hzr });
          }
        }
        ad.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.hyw), paramc, this.hzr });
        m.b(m.this).put(Long.valueOf(this.hyw), "done_upload_cdn_client_id");
        com.tencent.mm.kernel.g.aeS().a(245, this);
        paramc = new e(this.hyw, this.hyx, paramd, this.hzr);
        if (!com.tencent.mm.kernel.g.aeS().a(paramc, 0))
        {
          ad.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
          com.tencent.mm.kernel.g.aeS().b(245, this);
          m.this.d(this.hyw, 3, 0);
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(126905);
      com.tencent.mm.kernel.g.aeS().b(245, this);
      if ((paramInt1 == 4) && (paramInt2 == -22))
      {
        ad.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.hyw);
        m.aA(this.gQs);
        m.this.d(this.hyw, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 != 0))
      {
        ad.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.hyw);
        m.az(this.gQs);
        m.this.d(this.hyw, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.hyw);
        m.az(this.gQs);
        m.this.d(this.hyw, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      paramString = this.gQs.iterator();
      if (paramString.hasNext())
      {
        paramn = (s)paramString.next();
        paramn.hAg = bt.aGK();
        paramn.status = 199;
        paramn.dtM = 1280;
        if (u.f(paramn))
        {
          if (paramn != null) {
            break label378;
          }
          ad.e("MicroMsg.VideoLogic", "video info is null");
        }
        for (;;)
        {
          ad.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.hyw), paramn.getFileName(), Integer.valueOf(199) });
          break;
          label378:
          bl localbl;
          if (paramn.hAi > 0)
          {
            localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramn.hAi);
            paramInt1 = localbl.getType();
            ad.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
            if ((43 == paramInt1) || (62 == paramInt1))
            {
              localbl.jV(1);
              localbl.nY(paramn.getUser());
              localbl.kX(paramn.drA);
              localbl.setStatus(2);
              localbl.setContent(q.b(paramn.aCQ(), paramn.gOY, false));
              ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(paramn.hAi, localbl);
              ad.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localbl.field_msgId) });
            }
          }
          else
          {
            localbl = new bl();
            localbl.nY(paramn.getUser());
            localbl.setType(62);
            localbl.jV(1);
            localbl.nZ(paramn.getFileName());
            localbl.setStatus(2);
            localbl.kY(bi.uj(paramn.getUser()));
            paramn.hAi = ((int)bi.u(localbl));
            paramn.dtM = 8192;
            u.f(paramn);
            ad.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localbl.field_msgId) });
          }
        }
      }
      paramString = m.this;
      long l = this.hyw;
      com.tencent.mm.kernel.g.afE().ax(new m.1(paramString, l));
      AppMethodBeat.o(126905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m
 * JD-Core Version:    0.7.0.1
 */