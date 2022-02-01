package com.tencent.mm.modelvideo;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m
{
  private static int jrr = 0;
  private boolean dAE;
  int dAF;
  private f.a dAI;
  private MTimerHandler dAJ;
  private LinkedList<Long> jrm;
  private Map<Long, f.a> jrn;
  private Map<Long, String> jro;
  private Object jrp;
  String jrq;
  private boolean running;
  
  public m()
  {
    AppMethodBeat.i(126906);
    this.jrm = new LinkedList();
    this.jrn = new HashMap();
    this.jro = new HashMap();
    this.jrp = new Object();
    this.dAE = false;
    this.running = false;
    this.dAF = 0;
    this.dAI = new f.a();
    this.dAJ = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new MTimerHandler.CallBack()
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
  
  private String AJ(long paramLong)
  {
    AppMethodBeat.i(126909);
    Object localObject2 = o.bhj().AK(paramLong);
    if (((List)localObject2).isEmpty())
    {
      Log.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (s)((Iterator)localObject1).next();
      if (ab.JF(((s)localObject3).getUser()))
      {
        Log.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((s)localObject3).getUser(), ((s)localObject3).jsv, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
      f.baQ();
      if ((!b.sS(2)) && (((s)localObject3).jss != 1))
      {
        f.baQ();
        Log.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(b.sS(2)), Integer.valueOf(((s)localObject3).jss), ((s)localObject3).jsv, Long.valueOf(paramLong) });
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
          break label414;
        }
        localObject3 = (s)((List)localObject2).get(i);
        localObject1 = u.QN(((s)localObject3).getFileName());
        if (localObject1 != null)
        {
          Log.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).jsv });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        Log.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).jsv });
        i += 1;
      }
      label414:
      localObject1 = null;
    }
    Object localObject3 = com.tencent.mm.an.c.a("upvideo", ((s)localObject1).createTime, ((s)localObject1).jsv, ((s)localObject1).getFileName());
    if (Util.isNullOrNil((String)localObject3))
    {
      Log.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((s)localObject1).getFileName(), Long.valueOf(((s)localObject1).jqz), ((s)localObject1).jsv });
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject4 = ((s)localObject1).getFileName();
    o.bhj();
    String str1 = t.Qx((String)localObject4);
    o.bhj();
    String str2 = t.Qw((String)localObject4);
    a locala = new a((byte)0);
    locala.iHg = ((List)localObject2);
    locala.jqz = paramLong;
    locala.jru = ((String)localObject3);
    locala.startTime = Util.nowMilliSecond();
    locala.jqA = ((s)localObject1);
    localObject4 = new com.tencent.mm.i.g();
    ((com.tencent.mm.i.g)localObject4).taskName = "task_NetSceneUploadVideo_2";
    ((com.tencent.mm.i.g)localObject4).gqy = locala;
    ((com.tencent.mm.i.g)localObject4).field_mediaId = ((String)localObject3);
    ((com.tencent.mm.i.g)localObject4).field_fullpath = str2;
    ((com.tencent.mm.i.g)localObject4).field_thumbpath = str1;
    ((com.tencent.mm.i.g)localObject4).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    ((com.tencent.mm.i.g)localObject4).field_smallVideoFlag = 1;
    ((com.tencent.mm.i.g)localObject4).field_talker = ((s)localObject1).jsv;
    ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.gpM;
    ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
    ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
    localObject1 = XmlParser.parseXml(((s)localObject1).bhv(), "msg", null);
    if (localObject1 != null)
    {
      ((com.tencent.mm.i.g)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.i.g)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!f.baQ().f((com.tencent.mm.i.g)localObject4))
    {
      Log.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      AppMethodBeat.o(126909);
      return null;
      Log.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (s)((Iterator)localObject1).next();
      if (((s)localObject2).jss != 1)
      {
        ((s)localObject2).jss = 1;
        ((s)localObject2).cSx = 524288;
        boolean bool = u.f((s)localObject2);
        Log.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((s)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(126909);
    return localObject3;
  }
  
  public static void aG(List<s> paramList)
  {
    AppMethodBeat.i(126907);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126907);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.QE(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126907);
  }
  
  public static void aH(List<s> paramList)
  {
    AppMethodBeat.i(126908);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126908);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.QF(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126908);
  }
  
  private void aax()
  {
    AppMethodBeat.i(126911);
    this.jro.clear();
    this.jrn.clear();
    this.jrm.clear();
    this.dAE = false;
    this.running = false;
    Log.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.dAI.apr());
    AppMethodBeat.o(126911);
  }
  
  public final void d(final long paramLong, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(126910);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126897);
        m.bhf();
        m.c(m.this);
        m.a(m.this, "");
        long l2 = 0L;
        long l1 = l2;
        if (paramLong > 0L)
        {
          l1 = l2;
          if (m.d(m.this).get(Long.valueOf(paramLong)) != null) {
            l1 = ((f.a)m.d(m.this).get(Long.valueOf(paramLong))).apr();
          }
        }
        Log.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Integer.valueOf(paramInt2), Integer.valueOf(this.val$errCode) });
        if ((paramInt2 != 0) || (this.val$errCode != 0)) {
          m.j(m.this);
        }
        Log.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(m.jrr), Integer.valueOf(m.e(m.this)), Boolean.valueOf(m.f(m.this)), Boolean.valueOf(m.g(m.this)) });
        if (m.e(m.this) > 0) {
          m.h(m.this);
        }
        while (m.g(m.this))
        {
          m.bhg();
          AppMethodBeat.o(126897);
          return;
        }
        Log.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
        t localt = o.bhj();
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
          Log.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject1 });
          localt.iFy.execSQL("videoinfo2", (String)localObject1);
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
    implements com.tencent.mm.ak.i, g.a
  {
    List<s> iHg;
    s jqA;
    long jqz;
    String jru;
    long startTime;
    
    private a() {}
    
    public final int a(String arg1, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126904);
      Log.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.jru, Integer.valueOf(paramInt), paramc, paramd });
      if (paramInt == -21005)
      {
        Log.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.jru });
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramInt != 0)
      {
        m.aG(this.iHg);
        Log.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.jqz), Integer.valueOf(paramInt) });
        new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(0), "" })).bfK();
        m.this.d(this.jqz, 3, paramInt);
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramc != null)
      {
        Log.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Long.valueOf(paramc.field_finishedLength) });
        ??? = this.iHg.iterator();
        while (???.hasNext())
        {
          paramd = (s)???.next();
          paramd.jsm = Util.nowSecond();
          paramd.jqP = ((int)paramc.field_finishedLength);
          paramd.cSx = 1032;
          u.f(paramd);
        }
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramd != null)
      {
        if (paramd.field_retCode != 0)
        {
          Log.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, Long.valueOf(this.jqz) });
          m.aG(this.iHg);
          ??? = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.gqk });
          new y(???).bfK();
          new w(???).bfK();
          m.this.d(this.jqz, 3, paramd.field_retCode);
        }
      }
      else
      {
        AppMethodBeat.o(126904);
        return 0;
      }
      Log.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Long.valueOf(this.jqz) });
      ??? = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "length=\"" + paramd.field_fileLength + "\" ";
      ??? = ??? + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
      Log.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
      paramc = this.iHg.iterator();
      while (paramc.hasNext())
      {
        s locals = (s)paramc.next();
        if (Util.isNullOrNil(locals.bhv()))
        {
          locals.jst = ???;
          locals.cSx = 2097152;
          paramBoolean = u.f(locals);
          Log.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.jqz), locals.getFileName(), Boolean.valueOf(paramBoolean) });
        }
      }
      for (;;)
      {
        synchronized (m.a(m.this))
        {
          paramc = (String)m.b(m.this).get(Long.valueOf(this.jqz));
          if (Util.isNullOrNil(paramc)) {
            Log.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.jqz), paramc, this.jru });
          }
        }
        Log.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.jqz), paramc, this.jru });
        m.b(m.this).put(Long.valueOf(this.jqz), "done_upload_cdn_client_id");
        com.tencent.mm.kernel.g.azz().a(245, this);
        paramc = new e(this.jqz, this.jqA, paramd, this.jru);
        if (!com.tencent.mm.kernel.g.azz().a(paramc, 0))
        {
          Log.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
          com.tencent.mm.kernel.g.azz().b(245, this);
          m.this.d(this.jqz, 3, 0);
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(126905);
      com.tencent.mm.kernel.g.azz().b(245, this);
      if ((paramInt1 == 4) && (paramInt2 == -22))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.jqz);
        m.aH(this.iHg);
        m.this.d(this.jqz, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 != 0))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.jqz);
        m.aG(this.iHg);
        m.this.d(this.jqz, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.jqz);
        m.aG(this.iHg);
        m.this.d(this.jqz, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      paramString = this.iHg.iterator();
      if (paramString.hasNext())
      {
        paramq = (s)paramString.next();
        paramq.jsm = Util.nowSecond();
        paramq.status = 199;
        paramq.cSx = 1280;
        if (u.f(paramq))
        {
          if (paramq != null) {
            break label378;
          }
          Log.e("MicroMsg.VideoLogic", "video info is null");
        }
        for (;;)
        {
          Log.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.jqz), paramq.getFileName(), Integer.valueOf(199) });
          break;
          label378:
          ca localca;
          if (paramq.jso > 0)
          {
            localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramq.jso);
            paramInt1 = localca.getType();
            Log.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
            if ((43 == paramInt1) || (62 == paramInt1))
            {
              localca.nv(1);
              localca.Cy(paramq.getUser());
              localca.yF(paramq.dTS);
              localca.setStatus(2);
              localca.setContent(q.b(paramq.bhs(), paramq.iFw, false));
              ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(paramq.jso, localca);
              Log.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localca.field_msgId) });
            }
          }
          else
          {
            localca = new ca();
            localca.Cy(paramq.getUser());
            localca.setType(62);
            localca.nv(1);
            localca.Cz(paramq.getFileName());
            localca.setStatus(2);
            localca.setCreateTime(bp.Kw(paramq.getUser()));
            paramq.jso = ((int)bp.x(localca));
            paramq.cSx = 8192;
            u.f(paramq);
            Log.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localca.field_msgId) });
          }
        }
      }
      paramString = m.this;
      long l = this.jqz;
      com.tencent.mm.kernel.g.aAk().postToWorker(new m.1(paramString, l));
      AppMethodBeat.o(126905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m
 * JD-Core Version:    0.7.0.1
 */