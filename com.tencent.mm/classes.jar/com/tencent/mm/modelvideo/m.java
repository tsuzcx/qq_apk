package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.f.b.a.jg;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class m
  implements j.a
{
  LinkedList<ca> mgD;
  long mgE;
  private int mgF;
  private int mgG;
  public boolean mgH;
  boolean mgI;
  private boolean mgJ;
  private boolean mgK;
  j mgL;
  long mgM;
  
  public m()
  {
    AppMethodBeat.i(126879);
    this.mgD = new LinkedList();
    this.mgE = 0L;
    this.mgF = 0;
    this.mgG = 0;
    this.mgH = false;
    this.mgI = false;
    this.mgJ = false;
    this.mgK = false;
    this.mgL = null;
    this.mgM = 0L;
    AppMethodBeat.o(126879);
  }
  
  public final void a(final j paramj, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126883);
    if (paramj == null)
    {
      Log.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(126883);
      return;
    }
    if (this.mgL != paramj) {
      Log.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    Log.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramj.bqs(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126878);
        long l = paramj.msgId;
        synchronized (m.this.mgD)
        {
          Iterator localIterator = m.this.mgD.iterator();
          while (localIterator.hasNext())
          {
            ca localca = (ca)localIterator.next();
            if ((localca != null) && (localca.field_msgId == l))
            {
              Log.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(m.this.hashCode()), Long.valueOf(l) });
              localIterator.remove();
            }
          }
        }
        m.this.gC(true);
        if (m.this.mgL != null) {
          m.this.mgL.mgm = null;
        }
        m.this.mgL = null;
        m.a(m.this);
        m.this.startDownload();
        AppMethodBeat.o(126878);
      }
    });
    AppMethodBeat.o(126883);
  }
  
  public final void a(String paramString1, int paramInt1, long paramLong, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126886);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(Util.nowSecond()).append(",");
    localStringBuffer.append(Util.nowSecond()).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramString1).append(",");
    localStringBuffer.append(paramInt1).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramLong).append(",");
    localStringBuffer.append(",");
    localStringBuffer.append(paramString2).append(",");
    localStringBuffer.append(paramString3).append(",");
    localStringBuffer.append(paramInt2).append(",");
    localStringBuffer.append(paramString4).append(",");
    localStringBuffer.append(paramString5).append(",");
    localStringBuffer.append(c.bfp(paramString6));
    paramString1 = localStringBuffer.toString();
    Log.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new jg(paramString1).bpa();
    AppMethodBeat.o(126886);
  }
  
  public final void gB(boolean paramBoolean)
  {
    AppMethodBeat.i(126882);
    this.mgI = paramBoolean;
    if (this.mgI) {
      stopDownload();
    }
    AppMethodBeat.o(126882);
  }
  
  public final void gC(boolean paramBoolean)
  {
    AppMethodBeat.i(126884);
    if (paramBoolean)
    {
      this.mgF = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqv, Integer.valueOf(0))).intValue();
      this.mgF += 1;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqv, Integer.valueOf(this.mgF));
      AppMethodBeat.o(126884);
      return;
    }
    this.mgG = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqw, Integer.valueOf(0))).intValue();
    this.mgG += 1;
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqw, Integer.valueOf(this.mgG));
    AppMethodBeat.o(126884);
  }
  
  public final boolean gD(boolean paramBoolean)
  {
    int k = 1000;
    AppMethodBeat.i(126885);
    this.mgE = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqu, Long.valueOf(-1L))).longValue();
    if (Util.milliSecondsToNow(this.mgE) >= 86400000L)
    {
      this.mgE = Util.nowMilliSecond();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqu, Long.valueOf(this.mgE));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqv, Integer.valueOf(0));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqw, Integer.valueOf(0));
      this.mgK = false;
      this.mgJ = false;
    }
    this.mgF = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqv, Integer.valueOf(0))).intValue();
    this.mgG = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqw, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.mgF;
      i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("C2CMaxPreloadVideo", 100);
      if (i > 0) {
        break label392;
      }
      i = k;
    }
    label392:
    for (;;)
    {
      boolean bool;
      if (j >= i)
      {
        bool = true;
        label219:
        Log.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.mgF), Integer.valueOf(this.mgG) });
        if (bool)
        {
          if (!paramBoolean) {
            break label363;
          }
          if (!this.mgJ)
          {
            this.mgJ = true;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126885);
        return bool;
        j = this.mgG;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGq, 1000);
        break;
        bool = false;
        break label219;
        label363:
        if (!this.mgK)
        {
          this.mgK = true;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void startDownload()
  {
    AppMethodBeat.i(126881);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126877);
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDy, false);
        Object localObject1;
        if (!com.tencent.mm.q.a.aAj())
        {
          localObject1 = new aaq();
          ((aaq)localObject1).fZM.fDn = 2;
          EventCenter.instance.publish((IEvent)localObject1);
          if (!((aaq)localObject1).fZN.calling) {}
        }
        else if (bool)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (s.bqG().fts)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (m.this.mgL != null)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if ((m.this.mgH) || (m.this.mgI))
        {
          AppMethodBeat.o(126877);
          return;
        }
        int i;
        if (m.this.mgD.isEmpty())
        {
          localObject1 = m.this;
          if (Util.secondsToNow(((m)localObject1).mgM) > 600L) {
            ((m)localObject1).mgM = Util.nowSecond();
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              m.a(m.this);
            }
            AppMethodBeat.o(126877);
            return;
          }
        }
        Object localObject5 = new PBool();
        for (;;)
        {
          Object localObject6;
          int j;
          synchronized (m.this.mgD)
          {
            Iterator localIterator = m.this.mgD.iterator();
            localObject1 = null;
            if (!localIterator.hasNext()) {
              break label817;
            }
            localObject1 = (ca)localIterator.next();
            localObject6 = m.this;
            if (localObject1 == null)
            {
              ((PBool)localObject5).value = true;
              i = 0;
              if (!((PBool)localObject5).value) {
                break label1081;
              }
              localIterator.remove();
              break label1081;
            }
            w localw = y.Yk(((et)localObject1).field_imgPath);
            if ((localw != null) && (localw.bqS()))
            {
              Log.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), localw.getFileName() });
              Object localObject7 = XmlParser.parseXml(localw.bqO(), "msg", null);
              String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
              localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
              bool = ab.Lj(localw.bqM());
              if (!bool) {
                break label1088;
              }
              i = 2;
              long l = localw.lAW;
              if (!ab.Lj(localw.bqM())) {
                break label1093;
              }
              j = v.Pu(localw.bqM());
              ((m)localObject6).a(str, i, l, localw.bqK(), localw.bqM(), j, (String)localObject7, "", "");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 146L, 1L, false);
              if (bool)
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 126L, 1L, false);
                ((PBool)localObject5).value = true;
                i = 0;
                continue;
              }
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 125L, 1L, false);
            }
          }
          if (Util.milliSecondsToNow(localObject2.field_createTime) >= 86400000L)
          {
            Log.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
            ((PBool)localObject5).value = true;
            i = 0;
          }
          else
          {
            if (((m)localObject6).gD(true)) {
              Log.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((m)localObject6).mgE) });
            }
            label804:
            for (;;)
            {
              ((PBool)localObject5).value = false;
              i = 0;
              break;
              Log.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.hxy });
              localObject6 = bq.RR(localObject2.hxy);
              if (localObject6 == null)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (((bq.b)localObject6).luI <= 0)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (!com.tencent.mm.modelcontrol.b.VC(((bq.b)localObject6).luK))
              {
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                  i = ((bq.b)localObject6).luJ & 0x1;
                }
                for (;;)
                {
                  if (i <= 0) {
                    break label804;
                  }
                  ((PBool)localObject5).value = false;
                  i = 1;
                  break;
                  if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
                  {
                    i = ((bq.b)localObject6).luJ & 0x2;
                  }
                  else
                  {
                    if (!NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                      break label806;
                    }
                    i = ((bq.b)localObject6).luJ & 0x4;
                  }
                }
              }
            }
            label806:
            ((PBool)localObject5).value = false;
            i = 0;
            continue;
            label817:
            label1081:
            do
            {
              if (localObject2 == null)
              {
                AppMethodBeat.o(126877);
                return;
              }
              m.this.mgL = new j(localObject2.field_msgId);
              Log.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(m.this.hashCode()), m.this.mgL.bqs() });
              if (m.this.mgL.a(m.this) < 0)
              {
                Log.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(m.this.hashCode()) });
                synchronized (m.this.mgD)
                {
                  ??? = m.this.mgD.iterator();
                  while (((Iterator)???).hasNext())
                  {
                    localObject5 = (ca)((Iterator)???).next();
                    if ((localObject5 != null) && (((et)localObject5).field_msgId == m.this.mgL.msgId))
                    {
                      Log.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(m.this.hashCode()), Long.valueOf(m.this.mgL.msgId) });
                      ((Iterator)???).remove();
                    }
                  }
                }
                m.this.mgL = null;
              }
              AppMethodBeat.o(126877);
              return;
            } while (i != 0);
            continue;
            label1088:
            i = 1;
            continue;
            label1093:
            j = 0;
          }
        }
      }
    });
    AppMethodBeat.o(126881);
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(126880);
    Log.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126876);
        if (m.this.mgL != null) {
          m.this.mgL.stop();
        }
        m.this.mgL = null;
        AppMethodBeat.o(126876);
      }
    });
    AppMethodBeat.o(126880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m
 * JD-Core Version:    0.7.0.1
 */