package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
import com.tencent.mm.g.b.a.hb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
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

public final class i
  implements f.a
{
  LinkedList<ca> jra;
  long jrb;
  private int jrc;
  private int jrd;
  public boolean jre;
  boolean jrf;
  private boolean jrg;
  private boolean jrh;
  f jri;
  long jrj;
  
  public i()
  {
    AppMethodBeat.i(126879);
    this.jra = new LinkedList();
    this.jrb = 0L;
    this.jrc = 0;
    this.jrd = 0;
    this.jre = false;
    this.jrf = false;
    this.jrg = false;
    this.jrh = false;
    this.jri = null;
    this.jrj = 0L;
    AppMethodBeat.o(126879);
  }
  
  public final void a(final f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126883);
    if (paramf == null)
    {
      Log.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(126883);
      return;
    }
    if (this.jri != paramf) {
      Log.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    Log.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.bha(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126878);
        long l = paramf.msgId;
        synchronized (i.this.jra)
        {
          Iterator localIterator = i.this.jra.iterator();
          while (localIterator.hasNext())
          {
            ca localca = (ca)localIterator.next();
            if ((localca != null) && (localca.field_msgId == l))
            {
              Log.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(l) });
              localIterator.remove();
            }
          }
        }
        i.this.fQ(true);
        if (i.this.jri != null) {
          i.this.jri.jqL = null;
        }
        i.this.jri = null;
        i.a(i.this);
        i.this.startDownload();
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
    localStringBuffer.append(c.aTR(paramString6));
    paramString1 = localStringBuffer.toString();
    Log.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new hb(paramString1).bfK();
    AppMethodBeat.o(126886);
  }
  
  public final void fP(boolean paramBoolean)
  {
    AppMethodBeat.i(126882);
    this.jrf = paramBoolean;
    if (this.jrf) {
      stopDownload();
    }
    AppMethodBeat.o(126882);
  }
  
  public final void fQ(boolean paramBoolean)
  {
    AppMethodBeat.i(126884);
    if (paramBoolean)
    {
      this.jrc = ((Integer)g.aAh().azQ().get(ar.a.Ocs, Integer.valueOf(0))).intValue();
      this.jrc += 1;
      g.aAh().azQ().set(ar.a.Ocs, Integer.valueOf(this.jrc));
      AppMethodBeat.o(126884);
      return;
    }
    this.jrd = ((Integer)g.aAh().azQ().get(ar.a.Oct, Integer.valueOf(0))).intValue();
    this.jrd += 1;
    g.aAh().azQ().set(ar.a.Oct, Integer.valueOf(this.jrd));
    AppMethodBeat.o(126884);
  }
  
  public final boolean fR(boolean paramBoolean)
  {
    int k = 1000;
    AppMethodBeat.i(126885);
    this.jrb = ((Long)g.aAh().azQ().get(ar.a.Ocr, Long.valueOf(-1L))).longValue();
    if (Util.milliSecondsToNow(this.jrb) >= 86400000L)
    {
      this.jrb = Util.nowMilliSecond();
      g.aAh().azQ().set(ar.a.Ocr, Long.valueOf(this.jrb));
      g.aAh().azQ().set(ar.a.Ocs, Integer.valueOf(0));
      g.aAh().azQ().set(ar.a.Oct, Integer.valueOf(0));
      this.jrh = false;
      this.jrg = false;
    }
    this.jrc = ((Integer)g.aAh().azQ().get(ar.a.Ocs, Integer.valueOf(0))).intValue();
    this.jrd = ((Integer)g.aAh().azQ().get(ar.a.Oct, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.jrc;
      i = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("C2CMaxPreloadVideo", 100);
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
        Log.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.jrc), Integer.valueOf(this.jrd) });
        if (bool)
        {
          if (!paramBoolean) {
            break label363;
          }
          if (!this.jrg)
          {
            this.jrg = true;
            h.CyF.idkeyStat(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126885);
        return bool;
        j = this.jrd;
        i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZs, 1000);
        break;
        bool = false;
        break label219;
        label363:
        if (!this.jrh)
        {
          this.jrh = true;
          h.CyF.idkeyStat(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void startDownload()
  {
    AppMethodBeat.i(126881);
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126877);
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWM, false);
        Object localObject1;
        if (!com.tencent.mm.q.a.att())
        {
          localObject1 = new zj();
          ((zj)localObject1).efx.dKy = 2;
          EventCenter.instance.publish((IEvent)localObject1);
          if (!((zj)localObject1).efy.calling) {}
        }
        else if (bool)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (o.bho().dAD)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (i.this.jri != null)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if ((i.this.jre) || (i.this.jrf))
        {
          AppMethodBeat.o(126877);
          return;
        }
        int i;
        if (i.this.jra.isEmpty())
        {
          localObject1 = i.this;
          if (Util.secondsToNow(((i)localObject1).jrj) > 600L) {
            ((i)localObject1).jrj = Util.nowSecond();
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              i.a(i.this);
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
          synchronized (i.this.jra)
          {
            Iterator localIterator = i.this.jra.iterator();
            localObject1 = null;
            if (!localIterator.hasNext()) {
              break label817;
            }
            localObject1 = (ca)localIterator.next();
            localObject6 = i.this;
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
            s locals = u.QN(((eo)localObject1).field_imgPath);
            if ((locals != null) && (locals.bhy()))
            {
              Log.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), locals.getFileName() });
              Object localObject7 = XmlParser.parseXml(locals.bhv(), "msg", null);
              String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
              localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
              bool = ab.Eq(locals.getUser());
              if (!bool) {
                break label1088;
              }
              i = 2;
              long l = locals.iKP;
              if (!ab.Eq(locals.getUser())) {
                break label1093;
              }
              j = v.Ie(locals.getUser());
              ((i)localObject6).a(str, i, l, locals.bhs(), locals.getUser(), j, (String)localObject7, "", "");
              h.CyF.idkeyStat(354L, 146L, 1L, false);
              if (bool)
              {
                h.CyF.idkeyStat(354L, 126L, 1L, false);
                ((PBool)localObject5).value = true;
                i = 0;
                continue;
              }
              h.CyF.idkeyStat(354L, 125L, 1L, false);
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
            if (((i)localObject6).fR(true)) {
              Log.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((i)localObject6).jrb) });
            }
            label804:
            for (;;)
            {
              ((PBool)localObject5).value = false;
              i = 0;
              break;
              Log.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.fqK });
              localObject6 = bp.Ky(localObject2.fqK);
              if (localObject6 == null)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (((bp.b)localObject6).iEG <= 0)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (!com.tencent.mm.modelcontrol.b.Of(((bp.b)localObject6).iEI))
              {
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                  i = ((bp.b)localObject6).iEH & 0x1;
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
                    i = ((bp.b)localObject6).iEH & 0x2;
                  }
                  else
                  {
                    if (!NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                      break label806;
                    }
                    i = ((bp.b)localObject6).iEH & 0x4;
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
              i.this.jri = new f(localObject2.field_msgId);
              Log.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(i.this.hashCode()), i.this.jri.bha() });
              if (i.this.jri.a(i.this) < 0)
              {
                Log.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(i.this.hashCode()) });
                synchronized (i.this.jra)
                {
                  ??? = i.this.jra.iterator();
                  while (((Iterator)???).hasNext())
                  {
                    localObject5 = (ca)((Iterator)???).next();
                    if ((localObject5 != null) && (((eo)localObject5).field_msgId == i.this.jri.msgId))
                    {
                      Log.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.jri.msgId) });
                      ((Iterator)???).remove();
                    }
                  }
                }
                i.this.jri = null;
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
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126876);
        if (i.this.jri != null) {
          i.this.jri.stop();
        }
        i.this.jri = null;
        AppMethodBeat.o(126876);
      }
    });
    AppMethodBeat.o(126880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i
 * JD-Core Version:    0.7.0.1
 */