package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.b;
import com.tencent.mm.g.b.a.dx;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class i
  implements f.a
{
  LinkedList<bv> ivO;
  long ivP;
  private int ivQ;
  private int ivR;
  public boolean ivS;
  boolean ivT;
  private boolean ivU;
  private boolean ivV;
  f ivW;
  long ivX;
  
  public i()
  {
    AppMethodBeat.i(126879);
    this.ivO = new LinkedList();
    this.ivP = 0L;
    this.ivQ = 0;
    this.ivR = 0;
    this.ivS = false;
    this.ivT = false;
    this.ivU = false;
    this.ivV = false;
    this.ivW = null;
    this.ivX = 0L;
    AppMethodBeat.o(126879);
  }
  
  public final void a(final f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126883);
    if (paramf == null)
    {
      ae.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(126883);
      return;
    }
    if (this.ivW != paramf) {
      ae.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    ae.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.aMY(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126878);
        long l = paramf.msgId;
        synchronized (i.this.ivO)
        {
          Iterator localIterator = i.this.ivO.iterator();
          while (localIterator.hasNext())
          {
            bv localbv = (bv)localIterator.next();
            if ((localbv != null) && (localbv.field_msgId == l))
            {
              ae.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(l) });
              localIterator.remove();
            }
          }
        }
        i.this.fa(true);
        if (i.this.ivW != null) {
          i.this.ivW.ivz = null;
        }
        i.this.ivW = null;
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
    localStringBuffer.append(bu.aRi()).append(",");
    localStringBuffer.append(bu.aRi()).append(",");
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
    localStringBuffer.append(c.aEB(paramString6));
    paramString1 = localStringBuffer.toString();
    ae.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new dx(paramString1).aLH();
    AppMethodBeat.o(126886);
  }
  
  public final void eZ(boolean paramBoolean)
  {
    AppMethodBeat.i(126882);
    this.ivT = paramBoolean;
    if (this.ivT) {
      stopDownload();
    }
    AppMethodBeat.o(126882);
  }
  
  public final void fa(boolean paramBoolean)
  {
    AppMethodBeat.i(126884);
    if (paramBoolean)
    {
      this.ivQ = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUe, Integer.valueOf(0))).intValue();
      this.ivQ += 1;
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUe, Integer.valueOf(this.ivQ));
      AppMethodBeat.o(126884);
      return;
    }
    this.ivR = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUf, Integer.valueOf(0))).intValue();
    this.ivR += 1;
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUf, Integer.valueOf(this.ivR));
    AppMethodBeat.o(126884);
  }
  
  public final boolean fb(boolean paramBoolean)
  {
    int k = 1000;
    AppMethodBeat.i(126885);
    this.ivP = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUd, Long.valueOf(-1L))).longValue();
    if (bu.DD(this.ivP) >= 86400000L)
    {
      this.ivP = bu.fpO();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUd, Long.valueOf(this.ivP));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUe, Integer.valueOf(0));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUf, Integer.valueOf(0));
      this.ivV = false;
      this.ivU = false;
    }
    this.ivQ = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUe, Integer.valueOf(0))).intValue();
    this.ivR = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUf, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.ivQ;
      i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("C2CMaxPreloadVideo", 100);
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
        ae.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.ivQ), Integer.valueOf(this.ivR) });
        if (bool)
        {
          if (!paramBoolean) {
            break label363;
          }
          if (!this.ivU)
          {
            this.ivU = true;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126885);
        return bool;
        j = this.ivR;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGf, 1000);
        break;
        bool = false;
        break label219;
        label363:
        if (!this.ivV)
        {
          this.ivV = true;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void startDownload()
  {
    AppMethodBeat.i(126881);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126877);
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDM, false);
        Object localObject1;
        if (!com.tencent.mm.r.a.adO())
        {
          localObject1 = new yh();
          ((yh)localObject1).dNE.dto = 2;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
          if (!((yh)localObject1).dNF.dNG) {}
        }
        else if (bool)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (o.aNm().djs)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (i.this.ivW != null)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if ((i.this.ivS) || (i.this.ivT))
        {
          AppMethodBeat.o(126877);
          return;
        }
        int i;
        if (i.this.ivO.isEmpty())
        {
          localObject1 = i.this;
          if (bu.rZ(((i)localObject1).ivX) > 600L) {
            ((i)localObject1).ivX = bu.aRi();
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
          synchronized (i.this.ivO)
          {
            Iterator localIterator = i.this.ivO.iterator();
            localObject1 = null;
            if (!localIterator.hasNext()) {
              break label816;
            }
            localObject1 = (bv)localIterator.next();
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
            s locals = u.Ia(((ei)localObject1).field_imgPath);
            if ((locals != null) && (locals.aNw()))
            {
              ae.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), locals.getFileName() });
              Object localObject7 = bx.M(locals.aNt(), "msg");
              String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
              localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
              bool = x.wb(locals.getUser());
              if (!bool) {
                break label1087;
              }
              i = 2;
              long l = locals.hPI;
              if (!x.wb(locals.getUser())) {
                break label1092;
              }
              j = r.zC(locals.getUser());
              ((i)localObject6).a(str, i, l, locals.aNq(), locals.getUser(), j, (String)localObject7, "", "");
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 146L, 1L, false);
              if (bool)
              {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 126L, 1L, false);
                ((PBool)localObject5).value = true;
                i = 0;
                continue;
              }
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 125L, 1L, false);
            }
          }
          if (bu.DD(localObject2.field_createTime) >= 86400000L)
          {
            ae.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
            ((PBool)localObject5).value = true;
            i = 0;
          }
          else
          {
            if (((i)localObject6).fb(true)) {
              ae.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((i)localObject6).ivP) });
            }
            label803:
            for (;;)
            {
              ((PBool)localObject5).value = false;
              i = 0;
              break;
              ae.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.eNd });
              localObject6 = bl.BS(localObject2.eNd);
              if (localObject6 == null)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (((bl.b)localObject6).hJW <= 0)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (!com.tencent.mm.modelcontrol.b.Fv(((bl.b)localObject6).hJY))
              {
                if (az.isWifi(ak.getContext())) {
                  i = ((bl.b)localObject6).hJX & 0x1;
                }
                for (;;)
                {
                  if (i <= 0) {
                    break label803;
                  }
                  ((PBool)localObject5).value = false;
                  i = 1;
                  break;
                  if (az.is4G(ak.getContext()))
                  {
                    i = ((bl.b)localObject6).hJX & 0x2;
                  }
                  else
                  {
                    if (!az.is3G(ak.getContext())) {
                      break label805;
                    }
                    i = ((bl.b)localObject6).hJX & 0x4;
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
              i.this.ivW = new f(localObject2.field_msgId);
              ae.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(i.this.hashCode()), i.this.ivW.aMY() });
              if (i.this.ivW.a(i.this) < 0)
              {
                ae.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(i.this.hashCode()) });
                synchronized (i.this.ivO)
                {
                  ??? = i.this.ivO.iterator();
                  while (((Iterator)???).hasNext())
                  {
                    localObject5 = (bv)((Iterator)???).next();
                    if ((localObject5 != null) && (((ei)localObject5).field_msgId == i.this.ivW.msgId))
                    {
                      ae.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.ivW.msgId) });
                      ((Iterator)???).remove();
                    }
                  }
                }
                i.this.ivW = null;
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
    ae.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126876);
        if (i.this.ivW != null) {
          i.this.ivW.stop();
        }
        i.this.ivW = null;
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