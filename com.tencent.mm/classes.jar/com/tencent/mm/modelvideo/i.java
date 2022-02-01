package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  implements f.a
{
  LinkedList<bu> isU;
  long isV;
  private int isW;
  private int isX;
  public boolean isY;
  boolean isZ;
  private boolean ita;
  private boolean itb;
  f itc;
  long itd;
  
  public i()
  {
    AppMethodBeat.i(126879);
    this.isU = new LinkedList();
    this.isV = 0L;
    this.isW = 0;
    this.isX = 0;
    this.isY = false;
    this.isZ = false;
    this.ita = false;
    this.itb = false;
    this.itc = null;
    this.itd = 0L;
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
    if (this.itc != paramf) {
      ad.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    ad.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.aMA(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126878);
        long l = paramf.msgId;
        synchronized (i.this.isU)
        {
          Iterator localIterator = i.this.isU.iterator();
          while (localIterator.hasNext())
          {
            bu localbu = (bu)localIterator.next();
            if ((localbu != null) && (localbu.field_msgId == l))
            {
              ad.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(l) });
              localIterator.remove();
            }
          }
        }
        i.this.eX(true);
        if (i.this.itc != null) {
          i.this.itc.isF = null;
        }
        i.this.itc = null;
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
    localStringBuffer.append(bt.aQJ()).append(",");
    localStringBuffer.append(bt.aQJ()).append(",");
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
    localStringBuffer.append(c.aDi(paramString6));
    paramString1 = localStringBuffer.toString();
    ad.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new dv(paramString1).aLk();
    AppMethodBeat.o(126886);
  }
  
  public final void eW(boolean paramBoolean)
  {
    AppMethodBeat.i(126882);
    this.isZ = paramBoolean;
    if (this.isZ) {
      stopDownload();
    }
    AppMethodBeat.o(126882);
  }
  
  public final void eX(boolean paramBoolean)
  {
    AppMethodBeat.i(126884);
    if (paramBoolean)
    {
      this.isW = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IzF, Integer.valueOf(0))).intValue();
      this.isW += 1;
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IzF, Integer.valueOf(this.isW));
      AppMethodBeat.o(126884);
      return;
    }
    this.isX = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IzG, Integer.valueOf(0))).intValue();
    this.isX += 1;
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IzG, Integer.valueOf(this.isX));
    AppMethodBeat.o(126884);
  }
  
  public final boolean eY(boolean paramBoolean)
  {
    int k = 1000;
    AppMethodBeat.i(126885);
    this.isV = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IzE, Long.valueOf(-1L))).longValue();
    if (bt.Df(this.isV) >= 86400000L)
    {
      this.isV = bt.flT();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IzE, Long.valueOf(this.isV));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IzF, Integer.valueOf(0));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IzG, Integer.valueOf(0));
      this.itb = false;
      this.ita = false;
    }
    this.isW = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IzF, Integer.valueOf(0))).intValue();
    this.isX = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IzG, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.isW;
      i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("C2CMaxPreloadVideo", 100);
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
        ad.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.isW), Integer.valueOf(this.isX) });
        if (bool)
        {
          if (!paramBoolean) {
            break label363;
          }
          if (!this.ita)
          {
            this.ita = true;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126885);
        return bool;
        j = this.isX;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyZ, 1000);
        break;
        bool = false;
        break label219;
        label363:
        if (!this.itb)
        {
          this.itb = true;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void startDownload()
  {
    AppMethodBeat.i(126881);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126877);
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwM, false);
        Object localObject1;
        if (!com.tencent.mm.s.a.adC())
        {
          localObject1 = new yb();
          ((yb)localObject1).dMo.dsi = 2;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
          if (!((yb)localObject1).dMp.dMq) {}
        }
        else if (bool)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (o.aMO().dip)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (i.this.itc != null)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if ((i.this.isY) || (i.this.isZ))
        {
          AppMethodBeat.o(126877);
          return;
        }
        int i;
        if (i.this.isU.isEmpty())
        {
          localObject1 = i.this;
          if (bt.rM(((i)localObject1).itd) > 600L) {
            ((i)localObject1).itd = bt.aQJ();
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
          synchronized (i.this.isU)
          {
            Iterator localIterator = i.this.isU.iterator();
            localObject1 = null;
            if (!localIterator.hasNext()) {
              break label816;
            }
            localObject1 = (bu)localIterator.next();
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
            s locals = u.Hy(((ei)localObject1).field_imgPath);
            if ((locals != null) && (locals.aMY()))
            {
              ad.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), locals.getFileName() });
              Object localObject7 = bw.M(locals.aMV(), "msg");
              String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
              localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
              bool = w.vF(locals.getUser());
              if (!bool) {
                break label1087;
              }
              i = 2;
              long l = locals.hMP;
              if (!w.vF(locals.getUser())) {
                break label1092;
              }
              j = q.yS(locals.getUser());
              ((i)localObject6).a(str, i, l, locals.aMS(), locals.getUser(), j, (String)localObject7, "", "");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 146L, 1L, false);
              if (bool)
              {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 126L, 1L, false);
                ((PBool)localObject5).value = true;
                i = 0;
                continue;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 125L, 1L, false);
            }
          }
          if (bt.Df(localObject2.field_createTime) >= 86400000L)
          {
            ad.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
            ((PBool)localObject5).value = true;
            i = 0;
          }
          else
          {
            if (((i)localObject6).eY(true)) {
              ad.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((i)localObject6).isV) });
            }
            label803:
            for (;;)
            {
              ((PBool)localObject5).value = false;
              i = 0;
              break;
              ad.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.eLs });
              localObject6 = bj.Bq(localObject2.eLs);
              if (localObject6 == null)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (((bj.b)localObject6).hHe <= 0)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (!com.tencent.mm.modelcontrol.b.ET(((bj.b)localObject6).hHg))
              {
                if (ay.isWifi(aj.getContext())) {
                  i = ((bj.b)localObject6).hHf & 0x1;
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
                    i = ((bj.b)localObject6).hHf & 0x2;
                  }
                  else
                  {
                    if (!ay.is3G(aj.getContext())) {
                      break label805;
                    }
                    i = ((bj.b)localObject6).hHf & 0x4;
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
              i.this.itc = new f(localObject2.field_msgId);
              ad.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(i.this.hashCode()), i.this.itc.aMA() });
              if (i.this.itc.a(i.this) < 0)
              {
                ad.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(i.this.hashCode()) });
                synchronized (i.this.isU)
                {
                  ??? = i.this.isU.iterator();
                  while (((Iterator)???).hasNext())
                  {
                    localObject5 = (bu)((Iterator)???).next();
                    if ((localObject5 != null) && (((ei)localObject5).field_msgId == i.this.itc.msgId))
                    {
                      ad.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.itc.msgId) });
                      ((Iterator)???).remove();
                    }
                  }
                }
                i.this.itc = null;
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
  
  public final void stopDownload()
  {
    AppMethodBeat.i(126880);
    ad.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126876);
        if (i.this.itc != null) {
          i.this.itc.stop();
        }
        i.this.itc = null;
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