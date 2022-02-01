package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.g.b.a.bo;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  implements f.a
{
  LinkedList<bl> hyY;
  long hyZ;
  private int hza;
  private int hzb;
  public boolean hzc;
  boolean hzd;
  private boolean hze;
  private boolean hzf;
  f hzg;
  long hzh;
  
  public i()
  {
    AppMethodBeat.i(126879);
    this.hyY = new LinkedList();
    this.hyZ = 0L;
    this.hza = 0;
    this.hzb = 0;
    this.hzc = false;
    this.hzd = false;
    this.hze = false;
    this.hzf = false;
    this.hzg = null;
    this.hzh = 0L;
    AppMethodBeat.o(126879);
  }
  
  public final void a(final f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126883);
    if (paramf == null)
    {
      ad.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(126883);
      return;
    }
    if (this.hzg != paramf) {
      ad.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    ad.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.aCz(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126878);
        long l = paramf.msgId;
        synchronized (i.this.hyY)
        {
          Iterator localIterator = i.this.hyY.iterator();
          while (localIterator.hasNext())
          {
            bl localbl = (bl)localIterator.next();
            if ((localbl != null) && (localbl.field_msgId == l))
            {
              ad.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(l) });
              localIterator.remove();
            }
          }
        }
        i.this.eB(true);
        if (i.this.hzg != null) {
          i.this.hzg.hyI = null;
        }
        i.this.hzg = null;
        i.a(i.this);
        i.this.aCA();
        AppMethodBeat.o(126878);
      }
    });
    AppMethodBeat.o(126883);
  }
  
  public final void a(String paramString1, int paramInt1, long paramLong, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126886);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(bt.aGK()).append(",");
    localStringBuffer.append(bt.aGK()).append(",");
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
    localStringBuffer.append(c.asU(paramString6));
    paramString1 = localStringBuffer.toString();
    ad.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new bo(paramString1).aBj();
    AppMethodBeat.o(126886);
  }
  
  public final void aCA()
  {
    AppMethodBeat.i(126881);
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126877);
        boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poH, false);
        Object localObject1;
        if (!com.tencent.mm.r.a.aad())
        {
          localObject1 = new ww();
          ((ww)localObject1).dCp.djq = 2;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
          if (!((ww)localObject1).dCq.dCr) {}
        }
        else if (bool)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (o.aCN().cZD)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (i.this.hzg != null)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if ((i.this.hzc) || (i.this.hzd))
        {
          AppMethodBeat.o(126877);
          return;
        }
        int i;
        if (i.this.hyY.isEmpty())
        {
          localObject1 = i.this;
          if (bt.lZ(((i)localObject1).hzh) > 600L) {
            ((i)localObject1).hzh = bt.aGK();
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
          synchronized (i.this.hyY)
          {
            Iterator localIterator = i.this.hyY.iterator();
            localObject1 = null;
            if (!localIterator.hasNext()) {
              break label816;
            }
            localObject1 = (bl)localIterator.next();
            localObject6 = i.this;
            if (localObject1 == null)
            {
              ((PBool)localObject5).value = true;
              i = 0;
              if (!((PBool)localObject5).value) {
                break label1080;
              }
              localIterator.remove();
              break label1080;
            }
            s locals = u.Ae(((du)localObject1).field_imgPath);
            if ((locals != null) && (locals.aCW()))
            {
              ad.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), locals.getFileName() });
              Object localObject7 = bw.K(locals.aCT(), "msg");
              String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
              localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
              bool = w.pF(locals.getUser());
              if (!bool) {
                break label1087;
              }
              i = 2;
              long l = locals.gTY;
              if (!w.pF(locals.getUser())) {
                break label1092;
              }
              j = q.rY(locals.getUser());
              ((i)localObject6).a(str, i, l, locals.aCQ(), locals.getUser(), j, (String)localObject7, "", "");
              h.vKh.idkeyStat(354L, 146L, 1L, false);
              if (bool)
              {
                h.vKh.idkeyStat(354L, 126L, 1L, false);
                ((PBool)localObject5).value = true;
                i = 0;
                continue;
              }
              h.vKh.idkeyStat(354L, 125L, 1L, false);
            }
          }
          if (bt.vM(localObject2.field_createTime) >= 86400000L)
          {
            ad.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
            ((PBool)localObject5).value = true;
            i = 0;
          }
          else
          {
            if (((i)localObject6).eC(true)) {
              ad.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((i)localObject6).hyZ) });
            }
            label803:
            for (;;)
            {
              ((PBool)localObject5).value = false;
              i = 0;
              break;
              ad.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.esh });
              localObject6 = bi.ul(localObject2.esh);
              if (localObject6 == null)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (((bi.b)localObject6).gOm <= 0)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (!com.tencent.mm.modelcontrol.b.xO(((bi.b)localObject6).gOo))
              {
                if (ay.isWifi(aj.getContext())) {
                  i = ((bi.b)localObject6).gOn & 0x1;
                }
                for (;;)
                {
                  if (i <= 0) {
                    break label803;
                  }
                  ((PBool)localObject5).value = false;
                  i = 1;
                  break;
                  if (ay.is4G(aj.getContext()))
                  {
                    i = ((bi.b)localObject6).gOn & 0x2;
                  }
                  else
                  {
                    if (!ay.is3G(aj.getContext())) {
                      break label805;
                    }
                    i = ((bi.b)localObject6).gOn & 0x4;
                  }
                }
              }
            }
            label805:
            ((PBool)localObject5).value = false;
            i = 0;
            continue;
            label816:
            label1080:
            do
            {
              if (localObject2 == null)
              {
                AppMethodBeat.o(126877);
                return;
              }
              i.this.hzg = new f(localObject2.field_msgId);
              ad.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(i.this.hashCode()), i.this.hzg.aCz() });
              if (i.this.hzg.a(i.this) < 0)
              {
                ad.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(i.this.hashCode()) });
                synchronized (i.this.hyY)
                {
                  ??? = i.this.hyY.iterator();
                  while (((Iterator)???).hasNext())
                  {
                    localObject5 = (bl)((Iterator)???).next();
                    if ((localObject5 != null) && (((du)localObject5).field_msgId == i.this.hzg.msgId))
                    {
                      ad.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.hzg.msgId) });
                      ((Iterator)???).remove();
                    }
                  }
                }
                i.this.hzg = null;
              }
              AppMethodBeat.o(126877);
              return;
            } while (i != 0);
            continue;
            label1087:
            i = 1;
            continue;
            label1092:
            j = 0;
          }
        }
      }
    });
    AppMethodBeat.o(126881);
  }
  
  public final void eA(boolean paramBoolean)
  {
    AppMethodBeat.i(126882);
    this.hzd = paramBoolean;
    if (this.hzd) {
      stopDownload();
    }
    AppMethodBeat.o(126882);
  }
  
  public final void eB(boolean paramBoolean)
  {
    AppMethodBeat.i(126884);
    if (paramBoolean)
    {
      this.hza = ((Integer)g.afB().afk().get(ae.a.Fpy, Integer.valueOf(0))).intValue();
      this.hza += 1;
      g.afB().afk().set(ae.a.Fpy, Integer.valueOf(this.hza));
      AppMethodBeat.o(126884);
      return;
    }
    this.hzb = ((Integer)g.afB().afk().get(ae.a.Fpz, Integer.valueOf(0))).intValue();
    this.hzb += 1;
    g.afB().afk().set(ae.a.Fpz, Integer.valueOf(this.hzb));
    AppMethodBeat.o(126884);
  }
  
  public final boolean eC(boolean paramBoolean)
  {
    int k = 1000;
    AppMethodBeat.i(126885);
    this.hyZ = ((Long)g.afB().afk().get(ae.a.Fpx, Long.valueOf(-1L))).longValue();
    if (bt.vM(this.hyZ) >= 86400000L)
    {
      this.hyZ = bt.eGO();
      g.afB().afk().set(ae.a.Fpx, Long.valueOf(this.hyZ));
      g.afB().afk().set(ae.a.Fpy, Integer.valueOf(0));
      g.afB().afk().set(ae.a.Fpz, Integer.valueOf(0));
      this.hzf = false;
      this.hze = false;
    }
    this.hza = ((Integer)g.afB().afk().get(ae.a.Fpy, Integer.valueOf(0))).intValue();
    this.hzb = ((Integer)g.afB().afk().get(ae.a.Fpz, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.hza;
      i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("C2CMaxPreloadVideo", 100);
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
        ad.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.hza), Integer.valueOf(this.hzb) });
        if (bool)
        {
          if (!paramBoolean) {
            break label363;
          }
          if (!this.hze)
          {
            this.hze = true;
            h.vKh.idkeyStat(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126885);
        return bool;
        j = this.hzb;
        i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqG, 1000);
        break;
        bool = false;
        break label219;
        label363:
        if (!this.hzf)
        {
          this.hzf = true;
          h.vKh.idkeyStat(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(126880);
    ad.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[] { Integer.valueOf(hashCode()) });
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126876);
        if (i.this.hzg != null) {
          i.this.hzg.stop();
        }
        i.this.hzg = null;
        AppMethodBeat.o(126876);
      }
    });
    AppMethodBeat.o(126880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i
 * JD-Core Version:    0.7.0.1
 */