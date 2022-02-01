package com.tencent.mm.modelvideo;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.aq.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.f.b.a.ac;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.ca;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class q
{
  private static int mgU = 0;
  private boolean ftt;
  int ftu;
  private f.a ftx;
  private MTimerHandler fty;
  private LinkedList<Long> mgP;
  private Map<Long, f.a> mgQ;
  private Map<Long, String> mgR;
  private Object mgS;
  String mgT;
  private boolean running;
  
  public q()
  {
    AppMethodBeat.i(126906);
    this.mgP = new LinkedList();
    this.mgQ = new HashMap();
    this.mgR = new HashMap();
    this.mgS = new Object();
    this.ftt = false;
    this.running = false;
    this.ftu = 0;
    this.ftx = new f.a();
    this.fty = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126901);
        q.h(q.this);
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
  
  private String GR(long paramLong)
  {
    AppMethodBeat.i(126909);
    Object localObject2 = s.bqB().GS(paramLong);
    if (((List)localObject2).isEmpty())
    {
      Log.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (w)((Iterator)localObject1).next();
      if (ab.QY(((w)localObject3).bqM()))
      {
        Log.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((w)localObject3).bqM(), ((w)localObject3).mhY, Long.valueOf(paramLong) });
        AppMethodBeat.o(126909);
        return null;
      }
      f.bkg();
      if ((!b.vQ(2)) && (((w)localObject3).mhV != 1))
      {
        f.bkg();
        Log.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(b.vQ(2)), Integer.valueOf(((w)localObject3).mhV), ((w)localObject3).mhY, Long.valueOf(paramLong) });
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
        localObject3 = (w)((List)localObject2).get(i);
        localObject1 = y.Yk(((w)localObject3).getFileName());
        if (localObject1 != null)
        {
          Log.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((w)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((w)localObject3).mhY });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        Log.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((w)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((w)localObject3).mhY });
        i += 1;
      }
      label414:
      localObject1 = null;
    }
    Object localObject3 = com.tencent.mm.aq.c.a("upvideo", ((w)localObject1).createTime, ((w)localObject1).mhY, ((w)localObject1).getFileName());
    if (Util.isNullOrNil((String)localObject3))
    {
      Log.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((w)localObject1).getFileName(), Long.valueOf(((w)localObject1).mga), ((w)localObject1).mhY });
      AppMethodBeat.o(126909);
      return null;
    }
    Object localObject4 = ((w)localObject1).getFileName();
    s.bqB();
    String str1 = x.XU((String)localObject4);
    s.bqB();
    String str2 = x.XT((String)localObject4);
    a locala = new a((byte)0);
    locala.lxi = ((List)localObject2);
    locala.mga = paramLong;
    locala.mgX = ((String)localObject3);
    locala.startTime = Util.nowMilliSecond();
    locala.mgb = ((w)localObject1);
    localObject4 = new g();
    ((g)localObject4).taskName = "task_NetSceneUploadVideo_2";
    ((g)localObject4).iUG = locala;
    ((g)localObject4).field_mediaId = ((String)localObject3);
    ((g)localObject4).field_fullpath = str2;
    ((g)localObject4).field_thumbpath = str1;
    ((g)localObject4).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    ((g)localObject4).field_smallVideoFlag = 1;
    ((g)localObject4).field_talker = ((w)localObject1).mhY;
    ((g)localObject4).field_priority = com.tencent.mm.i.a.iTU;
    ((g)localObject4).field_needStorage = false;
    ((g)localObject4).field_isStreamMedia = false;
    localObject1 = XmlParser.parseXml(((w)localObject1).bqO(), "msg", null);
    if (localObject1 != null)
    {
      ((g)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((g)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!f.bkg().f((g)localObject4))
    {
      Log.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      AppMethodBeat.o(126909);
      return null;
      Log.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (w)((Iterator)localObject1).next();
      if (((w)localObject2).mhV != 1)
      {
        ((w)localObject2).mhV = 1;
        ((w)localObject2).cUP = 524288;
        boolean bool = y.f((w)localObject2);
        Log.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((w)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(126909);
    return localObject3;
  }
  
  public static void aE(List<w> paramList)
  {
    AppMethodBeat.i(126907);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126907);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      y.Yb(((w)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126907);
  }
  
  public static void aF(List<w> paramList)
  {
    AppMethodBeat.i(126908);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(126908);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      y.Yc(((w)paramList.next()).getFileName());
    }
    AppMethodBeat.o(126908);
  }
  
  private void afk()
  {
    AppMethodBeat.i(126911);
    this.mgR.clear();
    this.mgQ.clear();
    this.mgP.clear();
    this.ftt = false;
    this.running = false;
    Log.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.ftx.avE());
    AppMethodBeat.o(126911);
  }
  
  public final void d(final long paramLong, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(126910);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126897);
        q.bqx();
        q.c(q.this);
        q.a(q.this, "");
        long l2 = 0L;
        long l1 = l2;
        if (paramLong > 0L)
        {
          l1 = l2;
          if (q.d(q.this).get(Long.valueOf(paramLong)) != null) {
            l1 = ((f.a)q.d(q.this).get(Long.valueOf(paramLong))).avE();
          }
        }
        Log.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Integer.valueOf(paramInt2), Integer.valueOf(this.val$errCode) });
        if ((paramInt2 != 0) || (this.val$errCode != 0)) {
          q.j(q.this);
        }
        Log.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(q.mgU), Integer.valueOf(q.e(q.this)), Boolean.valueOf(q.f(q.this)), Boolean.valueOf(q.g(q.this)) });
        if (q.e(q.this) > 0) {
          q.h(q.this);
        }
        while (q.g(q.this))
        {
          q.bqy();
          AppMethodBeat.o(126897);
          return;
        }
        Log.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
        x localx = s.bqB();
        Object localObject2 = q.k(q.this);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {}
        for (;;)
        {
          q.i(q.this);
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
          localx.lvy.execSQL("videoinfo2", (String)localObject1);
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
    implements com.tencent.mm.an.i, g.a
  {
    List<w> lxi;
    String mgX;
    long mga;
    w mgb;
    long startTime;
    
    private a() {}
    
    public final int a(String arg1, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(126904);
      Log.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.mgX, Integer.valueOf(paramInt), paramc, paramd });
      if (paramInt == -21005)
      {
        Log.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { this.mgX });
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramInt != 0)
      {
        q.aE(this.lxi);
        Log.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[] { Long.valueOf(this.mga), Integer.valueOf(paramInt) });
        new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Integer.valueOf(0), "" })).bpa();
        q.this.d(this.mga, 3, paramInt);
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramc != null)
      {
        Log.v("MicroMsg.SightMassSendService", "progress length %d", new Object[] { Long.valueOf(paramc.field_finishedLength) });
        ??? = this.lxi.iterator();
        while (???.hasNext())
        {
          paramd = (w)???.next();
          paramd.mhP = Util.nowSecond();
          paramd.mgq = ((int)paramc.field_finishedLength);
          paramd.cUP = 1032;
          y.f(paramd);
        }
        AppMethodBeat.o(126904);
        return 0;
      }
      if (paramd != null)
      {
        if (paramd.field_retCode != 0)
        {
          Log.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, Long.valueOf(this.mga) });
          q.aE(this.lxi);
          ??? = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_TinyVideo), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.iUs });
          new ae(???).bpa();
          new ac(???).bpa();
          q.this.d(this.mga, 3, paramd.field_retCode);
        }
      }
      else
      {
        AppMethodBeat.o(126904);
        return 0;
      }
      Log.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[] { Integer.valueOf(paramd.field_UploadHitCacheType), Long.valueOf(this.mga) });
      ??? = "<msg><videomsg aeskey=\"" + paramd.field_aesKey + "\" cdnthumbaeskey=\"" + paramd.field_aesKey + "\" cdnvideourl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "cdnthumburl=\"" + paramd.field_fileId + "\" ";
      ??? = ??? + "length=\"" + paramd.field_fileLength + "\" ";
      ??? = ??? + "cdnthumblength=\"" + paramd.field_thumbimgLength + "\"/></msg>";
      Log.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[] { ??? });
      paramc = this.lxi.iterator();
      while (paramc.hasNext())
      {
        w localw = (w)paramc.next();
        if (Util.isNullOrNil(localw.bqO()))
        {
          localw.mhW = ???;
          localw.cUP = 2097152;
          paramBoolean = y.f(localw);
          Log.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[] { Long.valueOf(this.mga), localw.getFileName(), Boolean.valueOf(paramBoolean) });
        }
      }
      for (;;)
      {
        synchronized (q.a(q.this))
        {
          paramc = (String)q.b(q.this).get(Long.valueOf(this.mga));
          if (Util.isNullOrNil(paramc)) {
            Log.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.mga), paramc, this.mgX });
          }
        }
        Log.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[] { Long.valueOf(this.mga), paramc, this.mgX });
        q.b(q.this).put(Long.valueOf(this.mga), "done_upload_cdn_client_id");
        com.tencent.mm.kernel.h.aGY().a(245, this);
        paramc = new i(this.mga, this.mgb, paramd, this.mgX);
        if (!com.tencent.mm.kernel.h.aGY().a(paramc, 0))
        {
          Log.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
          com.tencent.mm.kernel.h.aGY().b(245, this);
          q.this.d(this.mga, 3, 0);
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(126905);
      com.tencent.mm.kernel.h.aGY().b(245, this);
      if ((paramInt1 == 4) && (paramInt2 == -22))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + paramInt1 + " errCode:" + paramInt2 + " massSendId:" + this.mga);
        q.aF(this.lxi);
        q.this.d(this.mga, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 != 0))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.mga);
        q.aE(this.lxi);
        q.this.d(this.mga, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt1 + " errCode:" + paramInt2 + "  massSendId:" + this.mga);
        q.aE(this.lxi);
        q.this.d(this.mga, paramInt1, paramInt2);
        AppMethodBeat.o(126905);
        return;
      }
      paramString = this.lxi.iterator();
      if (paramString.hasNext())
      {
        paramq = (w)paramString.next();
        paramq.mhP = Util.nowSecond();
        paramq.status = 199;
        paramq.cUP = 1280;
        if (y.f(paramq))
        {
          if (paramq != null) {
            break label378;
          }
          Log.e("MicroMsg.VideoLogic", "video info is null");
        }
        for (;;)
        {
          Log.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[] { Long.valueOf(this.mga), paramq.getFileName(), Integer.valueOf(199) });
          break;
          label378:
          ca localca;
          if (paramq.mhR > 0)
          {
            localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramq.mhR);
            paramInt1 = localca.getType();
            Log.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[] { Integer.valueOf(paramInt1) });
            if ((43 == paramInt1) || (62 == paramInt1))
            {
              localca.pJ(1);
              localca.Jm(paramq.bqM());
              localca.EG(paramq.fNu);
              localca.setStatus(2);
              localca.setContent(u.a(paramq.bqK(), paramq.lvw, false));
              ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramq.mhR, localca);
              Log.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[] { Long.valueOf(localca.field_msgId) });
            }
          }
          else
          {
            localca = new ca();
            localca.Jm(paramq.bqM());
            localca.setType(62);
            localca.pJ(1);
            localca.Jn(paramq.getFileName());
            localca.setStatus(2);
            localca.setCreateTime(bq.RP(paramq.bqM()));
            paramq.mhR = ((int)bq.z(localca));
            paramq.cUP = 8192;
            y.f(paramq);
            Log.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[] { Long.valueOf(localca.field_msgId) });
          }
        }
      }
      paramString = q.this;
      long l = this.mga;
      com.tencent.mm.kernel.h.aHJ().postToWorker(new q.1(paramString, l));
      AppMethodBeat.o(126905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.q
 * JD-Core Version:    0.7.0.1
 */