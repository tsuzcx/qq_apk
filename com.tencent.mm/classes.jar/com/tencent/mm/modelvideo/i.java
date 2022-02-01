package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  implements f.a
{
  long hZA;
  private int hZB;
  private int hZC;
  public boolean hZD;
  boolean hZE;
  private boolean hZF;
  private boolean hZG;
  f hZH;
  long hZI;
  LinkedList<bo> hZz;
  
  public i()
  {
    AppMethodBeat.i(126879);
    this.hZz = new LinkedList();
    this.hZA = 0L;
    this.hZB = 0;
    this.hZC = 0;
    this.hZD = false;
    this.hZE = false;
    this.hZF = false;
    this.hZG = false;
    this.hZH = null;
    this.hZI = 0L;
    AppMethodBeat.o(126879);
  }
  
  public final void a(final f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126883);
    if (paramf == null)
    {
      ac.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(126883);
      return;
    }
    if (this.hZH != paramf) {
      ac.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    ac.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.aJq(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126878);
        long l = paramf.msgId;
        synchronized (i.this.hZz)
        {
          Iterator localIterator = i.this.hZz.iterator();
          while (localIterator.hasNext())
          {
            bo localbo = (bo)localIterator.next();
            if ((localbo != null) && (localbo.field_msgId == l))
            {
              ac.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(l) });
              localIterator.remove();
            }
          }
        }
        i.this.eV(true);
        if (i.this.hZH != null) {
          i.this.hZH.hZj = null;
        }
        i.this.hZH = null;
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
    localStringBuffer.append(bs.aNx()).append(",");
    localStringBuffer.append(bs.aNx()).append(",");
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
    localStringBuffer.append(c.ayd(paramString6));
    paramString1 = localStringBuffer.toString();
    ac.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new dc(paramString1).aHZ();
    AppMethodBeat.o(126886);
  }
  
  public final void eU(boolean paramBoolean)
  {
    AppMethodBeat.i(126882);
    this.hZE = paramBoolean;
    if (this.hZE) {
      stopDownload();
    }
    AppMethodBeat.o(126882);
  }
  
  public final void eV(boolean paramBoolean)
  {
    AppMethodBeat.i(126884);
    if (paramBoolean)
    {
      this.hZB = ((Integer)g.agR().agA().get(ah.a.GNo, Integer.valueOf(0))).intValue();
      this.hZB += 1;
      g.agR().agA().set(ah.a.GNo, Integer.valueOf(this.hZB));
      AppMethodBeat.o(126884);
      return;
    }
    this.hZC = ((Integer)g.agR().agA().get(ah.a.GNp, Integer.valueOf(0))).intValue();
    this.hZC += 1;
    g.agR().agA().set(ah.a.GNp, Integer.valueOf(this.hZC));
    AppMethodBeat.o(126884);
  }
  
  public final boolean eW(boolean paramBoolean)
  {
    int k = 1000;
    AppMethodBeat.i(126885);
    this.hZA = ((Long)g.agR().agA().get(ah.a.GNn, Long.valueOf(-1L))).longValue();
    if (bs.Ap(this.hZA) >= 86400000L)
    {
      this.hZA = bs.eWj();
      g.agR().agA().set(ah.a.GNn, Long.valueOf(this.hZA));
      g.agR().agA().set(ah.a.GNo, Integer.valueOf(0));
      g.agR().agA().set(ah.a.GNp, Integer.valueOf(0));
      this.hZG = false;
      this.hZF = false;
    }
    this.hZB = ((Integer)g.agR().agA().get(ah.a.GNo, Integer.valueOf(0))).intValue();
    this.hZC = ((Integer)g.agR().agA().get(ah.a.GNp, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.hZB;
      i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("C2CMaxPreloadVideo", 100);
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
        ac.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.hZB), Integer.valueOf(this.hZC) });
        if (bool)
        {
          if (!paramBoolean) {
            break label363;
          }
          if (!this.hZF)
          {
            this.hZF = true;
            h.wUl.idkeyStat(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126885);
        return bool;
        j = this.hZC;
        i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUt, 1000);
        break;
        bool = false;
        break label219;
        label363:
        if (!this.hZG)
        {
          this.hZG = true;
          h.wUl.idkeyStat(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void startDownload()
  {
    AppMethodBeat.i(126881);
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126877);
        boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSo, false);
        Object localObject1;
        if (!com.tencent.mm.r.a.aaZ())
        {
          localObject1 = new xh();
          ((xh)localObject1).dAb.dgL = 2;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
          if (!((xh)localObject1).dAc.dAd) {}
        }
        else if (bool)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (o.aJD().cWZ)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (i.this.hZH != null)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if ((i.this.hZD) || (i.this.hZE))
        {
          AppMethodBeat.o(126877);
          return;
        }
        int i;
        if (i.this.hZz.isEmpty())
        {
          localObject1 = i.this;
          if (bs.pN(((i)localObject1).hZI) > 600L) {
            ((i)localObject1).hZI = bs.aNx();
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
          synchronized (i.this.hZz)
          {
            Iterator localIterator = i.this.hZz.iterator();
            localObject1 = null;
            if (!localIterator.hasNext()) {
              break label816;
            }
            localObject1 = (bo)localIterator.next();
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
            s locals = u.Ej(((dy)localObject1).field_imgPath);
            if ((locals != null) && (locals.aJN()))
            {
              ac.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), locals.getFileName() });
              Object localObject7 = bv.L(locals.aJK(), "msg");
              String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
              localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
              bool = w.sQ(locals.getUser());
              if (!bool) {
                break label1087;
              }
              i = 2;
              long l = locals.hux;
              if (!w.sQ(locals.getUser())) {
                break label1092;
              }
              j = q.wb(locals.getUser());
              ((i)localObject6).a(str, i, l, locals.aJH(), locals.getUser(), j, (String)localObject7, "", "");
              h.wUl.idkeyStat(354L, 146L, 1L, false);
              if (bool)
              {
                h.wUl.idkeyStat(354L, 126L, 1L, false);
                ((PBool)localObject5).value = true;
                i = 0;
                continue;
              }
              h.wUl.idkeyStat(354L, 125L, 1L, false);
            }
          }
          if (bs.Ap(localObject2.field_createTime) >= 86400000L)
          {
            ac.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
            ((PBool)localObject5).value = true;
            i = 0;
          }
          else
          {
            if (((i)localObject6).eW(true)) {
              ac.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((i)localObject6).hZA) });
            }
            label803:
            for (;;)
            {
              ((PBool)localObject5).value = false;
              i = 0;
              break;
              ac.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.eul });
              localObject6 = bi.yr(localObject2.eul);
              if (localObject6 == null)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (((bi.b)localObject6).hoM <= 0)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (!com.tencent.mm.modelcontrol.b.BU(((bi.b)localObject6).hoO))
              {
                if (ax.isWifi(ai.getContext())) {
                  i = ((bi.b)localObject6).hoN & 0x1;
                }
                for (;;)
                {
                  if (i <= 0) {
                    break label803;
                  }
                  ((PBool)localObject5).value = false;
                  i = 1;
                  break;
                  if (ax.is4G(ai.getContext()))
                  {
                    i = ((bi.b)localObject6).hoN & 0x2;
                  }
                  else
                  {
                    if (!ax.is3G(ai.getContext())) {
                      break label805;
                    }
                    i = ((bi.b)localObject6).hoN & 0x4;
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
              i.this.hZH = new f(localObject2.field_msgId);
              ac.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(i.this.hashCode()), i.this.hZH.aJq() });
              if (i.this.hZH.a(i.this) < 0)
              {
                ac.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(i.this.hashCode()) });
                synchronized (i.this.hZz)
                {
                  ??? = i.this.hZz.iterator();
                  while (((Iterator)???).hasNext())
                  {
                    localObject5 = (bo)((Iterator)???).next();
                    if ((localObject5 != null) && (((dy)localObject5).field_msgId == i.this.hZH.msgId))
                    {
                      ac.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.hZH.msgId) });
                      ((Iterator)???).remove();
                    }
                  }
                }
                i.this.hZH = null;
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
    ac.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[] { Integer.valueOf(hashCode()) });
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126876);
        if (i.this.hZH != null) {
          i.this.hZH.stop();
        }
        i.this.hZH = null;
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