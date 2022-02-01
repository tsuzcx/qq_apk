package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m
{
  private static int cXd = 0;
  private boolean cXa;
  int cXb;
  private f.a cXf;
  private au cXg;
  private LinkedList<Long> hZL;
  private Map<Long, f.a> hZM;
  private Map<Long, String> hZN;
  private Object hZO;
  String hZP;
  private boolean running;
  
  public m()
  {
    AppMethodBeat.i(126906);
    this.hZL = new LinkedList();
    this.hZM = new HashMap();
    this.hZN = new HashMap();
    this.hZO = new Object();
    this.cXa = false;
    this.running = false;
    this.cXb = 0;
    this.cXf = new f.a();
    this.cXg = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
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
  
  private void Ou()
  {
    AppMethodBeat.i(126911);
    this.hZN.clear();
    this.hZM.clear();
    this.hZL.clear();
    this.cXa = false;
    this.running = false;
    ac.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.cXf.YH());
    AppMethodBeat.o(126911);
  }
  
  public static void aw(List<s> paramList)
  {
    AppMethodBeat.i(126907);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126907);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.Ea(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126907);
  }
  
  public static void ax(List<s> paramList)
  {
    AppMethodBeat.i(126908);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126908);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.Eb(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126908);
  }
  
  private String qr(long paramLong)
  {
    AppMethodBeat.i(126909);
    Object localObject2 = o.aJy().qs(paramLong);
    if (((List)localObject2).isEmpty())
    {
      ac.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (s)((Iterator)localObject1).next();
      if (w.xs(((s)localObject3).getUser()))
      {
        ac.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((s)localObject3).getUser(), ((s)localObject3).iaQ, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
      com.tencent.mm.an.f.aDD();
      if ((!b.oz(2)) && (((s)localObject3).iaN != 1))
      {
        com.tencent.mm.an.f.aDD();
        ac.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(b.oz(2)), Integer.valueOf(((s)localObject3).iaN), ((s)localObject3).iaQ, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
    }
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      ac.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
      AppMethodBeat.o(126909);
      return null;
      int i = 0;
      for (;;)
      {
        if (i >= ((List)localObject2).size()) {
          break label425;
        }
        localObject3 = (s)((List)localObject2).get(i);
        localObject1 = u.Ej(((s)localObject3).getFileName());
        if (localObject1 != null)
        {
          ac.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).iaQ });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        ac.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).iaQ });
        i += 1;
      }
      label425:
      localObject1 = null;
    }
    Object localObject3 = com.tencent.mm.an.c.a("upvideo", ((s)localObject1).createTime, ((s)localObject1).iaQ, ((s)localObject1).getFileName());
    if (bs.isNullOrNil((String)localObject3))
    {
      ac.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((s)localObject1).getFileName(), Long.valueOf(((s)localObject1).hYX), ((s)localObject1).iaQ });
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject4 = ((s)localObject1).getFileName();
    o.aJy();
    String str1 = t.DW((String)localObject4);
    o.aJy();
    String str2 = t.DV((String)localObject4);
    a locala = new a((byte)0);
    locala.hqS = ((List)localObject2);
    locala.hYX = paramLong;
    locala.hZS = ((String)localObject3);
    locala.startTime = bs.eWj();
    locala.hYY = ((s)localObject1);
    localObject4 = new com.tencent.mm.i.g();
    ((com.tencent.mm.i.g)localObject4).frb = locala;
    ((com.tencent.mm.i.g)localObject4).field_mediaId = ((String)localObject3);
    ((com.tencent.mm.i.g)localObject4).field_fullpath = str2;
    ((com.tencent.mm.i.g)localObject4).field_thumbpath = str1;
    ((com.tencent.mm.i.g)localObject4).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    ((com.tencent.mm.i.g)localObject4).field_smallVideoFlag = 1;
    ((com.tencent.mm.i.g)localObject4).field_talker = ((s)localObject1).iaQ;
    ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.fqp;
    ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
    ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
    localObject1 = bv.L(((s)localObject1).aJK(), "msg");
    if (localObject1 != null)
    {
      ((com.tencent.mm.i.g)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.i.g)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!com.tencent.mm.an.f.aDD().f((com.tencent.mm.i.g)localObject4))
    {
      ac.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      AppMethodBeat.o(126909);
      return null;
      ac.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (s)((Iterator)localObject1).next();
      if (((s)localObject2).iaN != 1)
      {
        ((s)localObject2).iaN = 1;
        ((s)localObject2).drx = 524288;
        boolean bool = u.f((s)localObject2);
        ac.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((s)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(126909);
    return localObject3;
  }
  
  public final void d(final long paramLong, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(126910);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126897);
        m.aJu();
        m.c(m.this);
        m.a(m.this, "");
        long l2 = 0L;
        long l1 = l2;
        if (paramLong > 0L)
        {
          l1 = l2;
          if (m.d(m.this).get(Long.valueOf(paramLong)) != null) {
            l1 = ((f.a)m.d(m.this).get(Long.valueOf(paramLong))).YH();
          }
        }
        ac.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Integer.valueOf(paramInt2), Integer.valueOf(this.val$errCode) });
        if ((paramInt2 != 0) || (this.val$errCode != 0)) {
          m.j(m.this);
        }
        ac.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(m.cXd), Integer.valueOf(m.e(m.this)), Boolean.valueOf(m.f(m.this)), Boolean.valueOf(m.g(m.this)) });
        if (m.e(m.this) > 0) {
          m.h(m.this);
        }
        while (m.g(m.this))
        {
          m.aJv();
          AppMethodBeat.o(126897);
          return;
        }
        ac.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
        t localt = o.aJy();
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
          ac.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject1 });
          localt.hpA.execSQL("videoinfo2", (String)localObject1);
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
    implements com.tencent.mm.ak.g, g.a
  {
    long hYX;
    s hYY;
    String hZS;
    List<s> hqS;
    long startTime;
    
    private a() {}
    
    public final int a(String arg1, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126904);
      ac.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.hZS, Integer.valueOf(paramInt), paramc, paramd });
      if (paramInt == -21005)
      {
        ac.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.hZS });
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramInt != 0)
      {
        m.aw(this.hqS);
        ac.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.hYX), Integer.valueOf(paramInt) });
        new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(0), "" })).aHZ();
        m.this.d(this.hYX, 3, paramInt);
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramc != null)
      {
        ac.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Long.valueOf(paramc.field_finishedLength) });
        ??? = this.hqS.iterator();
        while (???.hasNext())
        {
          paramd = (s)???.next();
          paramd.iaH = bs.aNx();
          paramd.hZn = ((int)paramc.field_finishedLength);
          paramd.drx = 1032;
          u.f(paramd);
        }
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramd != null)
      {
        if (paramd.field_retCode != 0)
        {
          ac.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, Long.valueOf(this.hYX) });
          m.aw(this.hqS);
          ??? = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fqM });
          new com.tencent.mm.g.b.a.h(???).aHZ();
          new com.tencent.mm.g.b.a.f(???).aHZ();
          m.this.d(this.hYX, 3, paramd.field_retCode);
        }
      }
      else
      {
        AppMethodBeat.o(126904);
        return 0;
      }
      ac.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Long.valueOf(this.hYX) });
      ??? = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "length=\"" + paramd.field_fileLength + "\" ";
      ??? = ??? + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
      ac.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
      paramc = this.hqS.iterator();
      while (paramc.hasNext())
      {
        s locals = (s)paramc.next();
        if (bs.isNullOrNil(locals.aJK()))
        {
          locals.iaO = ???;
          locals.drx = 2097152;
          paramBoolean = u.f(locals);
          ac.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.hYX), locals.getFileName(), Boolean.valueOf(paramBoolean) });
        }
      }
      for (;;)
      {
        synchronized (m.a(m.this))
        {
          paramc = (String)m.b(m.this).get(Long.valueOf(this.hYX));
          if (bs.isNullOrNil(paramc)) {
            ac.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.hYX), paramc, this.hZS });
          }
        }
        ac.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.hYX), paramc, this.hZS });
        m.b(m.this).put(Long.valueOf(this.hYX), "done_upload_cdn_client_id");
        com.tencent.mm.kernel.g.agi().a(245, this);
        paramc = new e(this.hYX, this.hYY, paramd, this.hZS);
        if (!com.tencent.mm.kernel.g.agi().a(paramc, 0))
        {
          ac.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
          com.tencent.mm.kernel.g.agi().b(245, this);
          m.this.d(this.hYX, 3, 0);
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
      com.tencent.mm.kernel.g.agi().b(245, this);
      if ((paramInt1 == 4) && (paramInt2 == -22))
      {
        ac.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.hYX);
        m.ax(this.hqS);
        m.this.d(this.hYX, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 != 0))
      {
        ac.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.hYX);
        m.aw(this.hqS);
        m.this.d(this.hYX, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.hYX);
        m.aw(this.hqS);
        m.this.d(this.hYX, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      paramString = this.hqS.iterator();
      if (paramString.hasNext())
      {
        paramn = (s)paramString.next();
        paramn.iaH = bs.aNx();
        paramn.status = 199;
        paramn.drx = 1280;
        if (u.f(paramn))
        {
          if (paramn != null) {
            break label378;
          }
          ac.e("MicroMsg.VideoLogic", "video info is null");
        }
        for (;;)
        {
          ac.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.hYX), paramn.getFileName(), Integer.valueOf(199) });
          break;
          label378:
          bo localbo;
          if (paramn.iaJ > 0)
          {
            localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramn.iaJ);
            paramInt1 = localbo.getType();
            ac.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
            if ((43 == paramInt1) || (62 == paramInt1))
            {
              localbo.jT(1);
              localbo.re(paramn.getUser());
              localbo.oz(paramn.dpl);
              localbo.setStatus(2);
              localbo.setContent(q.b(paramn.aJH(), paramn.hpy, false));
              ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(paramn.iaJ, localbo);
              ac.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localbo.field_msgId) });
            }
          }
          else
          {
            localbo = new bo();
            localbo.re(paramn.getUser());
            localbo.setType(62);
            localbo.jT(1);
            localbo.rf(paramn.getFileName());
            localbo.setStatus(2);
            localbo.oA(bi.yp(paramn.getUser()));
            paramn.iaJ = ((int)bi.u(localbo));
            paramn.drx = 8192;
            u.f(paramn);
            ac.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localbo.field_msgId) });
          }
        }
      }
      paramString = m.this;
      long l = this.hYX;
      com.tencent.mm.kernel.g.agU().az(new m.1(paramString, l));
      AppMethodBeat.o(126905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m
 * JD-Core Version:    0.7.0.1
 */