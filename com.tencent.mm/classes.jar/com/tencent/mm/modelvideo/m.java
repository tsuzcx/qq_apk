package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m
{
  private static int djw = 0;
  private boolean djt;
  int dju;
  private f.a djy;
  private aw djz;
  private LinkedList<Long> iwa;
  private Map<Long, f.a> iwb;
  private Map<Long, String> iwc;
  private Object iwd;
  String iwe;
  private boolean running;
  
  public m()
  {
    AppMethodBeat.i(126906);
    this.iwa = new LinkedList();
    this.iwb = new HashMap();
    this.iwc = new HashMap();
    this.iwd = new Object();
    this.djt = false;
    this.running = false;
    this.dju = 0;
    this.djy = new f.a();
    this.djz = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
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
  
  private void Qd()
  {
    AppMethodBeat.i(126911);
    this.iwc.clear();
    this.iwb.clear();
    this.iwa.clear();
    this.djt = false;
    this.running = false;
    ae.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.djy.abs());
    AppMethodBeat.o(126911);
  }
  
  public static void ax(List<s> paramList)
  {
    AppMethodBeat.i(126907);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126907);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.HR(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126907);
  }
  
  public static void ay(List<s> paramList)
  {
    AppMethodBeat.i(126908);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126908);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.HS(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126908);
  }
  
  private String sD(long paramLong)
  {
    AppMethodBeat.i(126909);
    Object localObject2 = o.aNh().sE(paramLong);
    if (((List)localObject2).isEmpty())
    {
      ae.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (s)((Iterator)localObject1).next();
      if (x.Ba(((s)localObject3).getUser()))
      {
        ae.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((s)localObject3).getUser(), ((s)localObject3).ixg, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
      com.tencent.mm.an.f.aGZ();
      if ((!b.pd(2)) && (((s)localObject3).ixd != 1))
      {
        com.tencent.mm.an.f.aGZ();
        ae.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(b.pd(2)), Integer.valueOf(((s)localObject3).ixd), ((s)localObject3).ixg, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
    }
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      ae.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
      AppMethodBeat.o(126909);
      return null;
      int i = 0;
      for (;;)
      {
        if (i >= ((List)localObject2).size()) {
          break label425;
        }
        localObject3 = (s)((List)localObject2).get(i);
        localObject1 = u.Ia(((s)localObject3).getFileName());
        if (localObject1 != null)
        {
          ae.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).ixg });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        ae.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).ixg });
        i += 1;
      }
      label425:
      localObject1 = null;
    }
    Object localObject3 = com.tencent.mm.an.c.a("upvideo", ((s)localObject1).createTime, ((s)localObject1).ixg, ((s)localObject1).getFileName());
    if (bu.isNullOrNil((String)localObject3))
    {
      ae.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((s)localObject1).getFileName(), Long.valueOf(((s)localObject1).ivn), ((s)localObject1).ixg });
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject4 = ((s)localObject1).getFileName();
    o.aNh();
    String str1 = t.HK((String)localObject4);
    o.aNh();
    String str2 = t.HJ((String)localObject4);
    a locala = new a((byte)0);
    locala.hMd = ((List)localObject2);
    locala.ivn = paramLong;
    locala.iwh = ((String)localObject3);
    locala.startTime = bu.fpO();
    locala.ivo = ((s)localObject1);
    localObject4 = new com.tencent.mm.i.g();
    ((com.tencent.mm.i.g)localObject4).fLl = "task_NetSceneUploadVideo_2";
    ((com.tencent.mm.i.g)localObject4).fLm = locala;
    ((com.tencent.mm.i.g)localObject4).field_mediaId = ((String)localObject3);
    ((com.tencent.mm.i.g)localObject4).field_fullpath = str2;
    ((com.tencent.mm.i.g)localObject4).field_thumbpath = str1;
    ((com.tencent.mm.i.g)localObject4).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    ((com.tencent.mm.i.g)localObject4).field_smallVideoFlag = 1;
    ((com.tencent.mm.i.g)localObject4).field_talker = ((s)localObject1).ixg;
    ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.fKA;
    ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
    ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
    localObject1 = bx.M(((s)localObject1).aNt(), "msg");
    if (localObject1 != null)
    {
      ((com.tencent.mm.i.g)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.i.g)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!com.tencent.mm.an.f.aGZ().f((com.tencent.mm.i.g)localObject4))
    {
      ae.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      AppMethodBeat.o(126909);
      return null;
      ae.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (s)((Iterator)localObject1).next();
      if (((s)localObject2).ixd != 1)
      {
        ((s)localObject2).ixd = 1;
        ((s)localObject2).dEu = 524288;
        boolean bool = u.f((s)localObject2);
        ae.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((s)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(126909);
    return localObject3;
  }
  
  public final void d(final long paramLong, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(126910);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126897);
        m.aNd();
        m.c(m.this);
        m.a(m.this, "");
        long l2 = 0L;
        long l1 = l2;
        if (paramLong > 0L)
        {
          l1 = l2;
          if (m.d(m.this).get(Long.valueOf(paramLong)) != null) {
            l1 = ((f.a)m.d(m.this).get(Long.valueOf(paramLong))).abs();
          }
        }
        ae.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Integer.valueOf(paramInt2), Integer.valueOf(this.val$errCode) });
        if ((paramInt2 != 0) || (this.val$errCode != 0)) {
          m.j(m.this);
        }
        ae.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(m.djw), Integer.valueOf(m.e(m.this)), Boolean.valueOf(m.f(m.this)), Boolean.valueOf(m.g(m.this)) });
        if (m.e(m.this) > 0) {
          m.h(m.this);
        }
        while (m.g(m.this))
        {
          m.aNe();
          AppMethodBeat.o(126897);
          return;
        }
        ae.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
        t localt = o.aNh();
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
          ae.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject1 });
          localt.hKK.execSQL("videoinfo2", (String)localObject1);
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
    implements com.tencent.mm.ak.f, g.a
  {
    List<s> hMd;
    long ivn;
    s ivo;
    String iwh;
    long startTime;
    
    private a() {}
    
    public final int a(String arg1, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126904);
      ae.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.iwh, Integer.valueOf(paramInt), paramc, paramd });
      if (paramInt == -21005)
      {
        ae.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.iwh });
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramInt != 0)
      {
        m.ax(this.hMd);
        ae.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.ivn), Integer.valueOf(paramInt) });
        new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(0), "" })).aLH();
        m.this.d(this.ivn, 3, paramInt);
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramc != null)
      {
        ae.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Long.valueOf(paramc.field_finishedLength) });
        ??? = this.hMd.iterator();
        while (???.hasNext())
        {
          paramd = (s)???.next();
          paramd.iwX = bu.aRi();
          paramd.ivD = ((int)paramc.field_finishedLength);
          paramd.dEu = 1032;
          u.f(paramd);
        }
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramd != null)
      {
        if (paramd.field_retCode != 0)
        {
          ae.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, Long.valueOf(this.ivn) });
          m.ax(this.hMd);
          ??? = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fKX });
          new j(???).aLH();
          new com.tencent.mm.g.b.a.h(???).aLH();
          m.this.d(this.ivn, 3, paramd.field_retCode);
        }
      }
      else
      {
        AppMethodBeat.o(126904);
        return 0;
      }
      ae.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Long.valueOf(this.ivn) });
      ??? = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "length=\"" + paramd.field_fileLength + "\" ";
      ??? = ??? + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
      ae.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
      paramc = this.hMd.iterator();
      while (paramc.hasNext())
      {
        s locals = (s)paramc.next();
        if (bu.isNullOrNil(locals.aNt()))
        {
          locals.ixe = ???;
          locals.dEu = 2097152;
          paramBoolean = u.f(locals);
          ae.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.ivn), locals.getFileName(), Boolean.valueOf(paramBoolean) });
        }
      }
      for (;;)
      {
        synchronized (m.a(m.this))
        {
          paramc = (String)m.b(m.this).get(Long.valueOf(this.ivn));
          if (bu.isNullOrNil(paramc)) {
            ae.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.ivn), paramc, this.iwh });
          }
        }
        ae.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.ivn), paramc, this.iwh });
        m.b(m.this).put(Long.valueOf(this.ivn), "done_upload_cdn_client_id");
        com.tencent.mm.kernel.g.ajj().a(245, this);
        paramc = new e(this.ivn, this.ivo, paramd, this.iwh);
        if (!com.tencent.mm.kernel.g.ajj().a(paramc, 0))
        {
          ae.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
          com.tencent.mm.kernel.g.ajj().b(245, this);
          m.this.d(this.ivn, 3, 0);
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
      com.tencent.mm.kernel.g.ajj().b(245, this);
      if ((paramInt1 == 4) && (paramInt2 == -22))
      {
        ae.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.ivn);
        m.ay(this.hMd);
        m.this.d(this.ivn, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 != 0))
      {
        ae.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.ivn);
        m.ax(this.hMd);
        m.this.d(this.ivn, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.ivn);
        m.ax(this.hMd);
        m.this.d(this.ivn, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      paramString = this.hMd.iterator();
      if (paramString.hasNext())
      {
        paramn = (s)paramString.next();
        paramn.iwX = bu.aRi();
        paramn.status = 199;
        paramn.dEu = 1280;
        if (u.f(paramn))
        {
          if (paramn != null) {
            break label378;
          }
          ae.e("MicroMsg.VideoLogic", "video info is null");
        }
        for (;;)
        {
          ae.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.ivn), paramn.getFileName(), Integer.valueOf(199) });
          break;
          label378:
          bv localbv;
          if (paramn.iwZ > 0)
          {
            localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramn.iwZ);
            paramInt1 = localbv.getType();
            ae.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
            if ((43 == paramInt1) || (62 == paramInt1))
            {
              localbv.kt(1);
              localbv.ui(paramn.getUser());
              localbv.qM(paramn.dCd);
              localbv.setStatus(2);
              localbv.setContent(q.b(paramn.aNq(), paramn.hKI, false));
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramn.iwZ, localbv);
              ae.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localbv.field_msgId) });
            }
          }
          else
          {
            localbv = new bv();
            localbv.ui(paramn.getUser());
            localbv.setType(62);
            localbv.kt(1);
            localbv.uj(paramn.getFileName());
            localbv.setStatus(2);
            localbv.qN(bl.BQ(paramn.getUser()));
            paramn.iwZ = ((int)bl.v(localbv));
            paramn.dEu = 8192;
            u.f(paramn);
            ae.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localbv.field_msgId) });
          }
        }
      }
      paramString = m.this;
      long l = this.ivn;
      com.tencent.mm.kernel.g.ajU().aw(new m.1(paramString, l));
      AppMethodBeat.o(126905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m
 * JD-Core Version:    0.7.0.1
 */