package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.lq;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p
  implements j.a
{
  LinkedList<cc> oZN;
  long oZO;
  private int oZP;
  private int oZQ;
  public boolean oZR;
  boolean oZS;
  private boolean oZT;
  private boolean oZU;
  j oZV;
  long oZW;
  
  public p()
  {
    AppMethodBeat.i(126879);
    this.oZN = new LinkedList();
    this.oZO = 0L;
    this.oZP = 0;
    this.oZQ = 0;
    this.oZR = false;
    this.oZS = false;
    this.oZT = false;
    this.oZU = false;
    this.oZV = null;
    this.oZW = 0L;
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
    if (this.oZV != paramj) {
      Log.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    Log.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramj.bNY(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126878);
        long l = paramj.msgId;
        synchronized (p.this.oZN)
        {
          Iterator localIterator = p.this.oZN.iterator();
          while (localIterator.hasNext())
          {
            cc localcc = (cc)localIterator.next();
            if ((localcc != null) && (localcc.field_msgId == l))
            {
              Log.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(p.this.hashCode()), Long.valueOf(l) });
              localIterator.remove();
            }
          }
        }
        p.this.hq(true);
        if (p.this.oZV != null) {
          p.this.oZV.oZi = null;
        }
        p.this.oZV = null;
        p.a(p.this);
        p.this.startDownload();
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
    localStringBuffer.append(com.tencent.mm.plugin.video.c.beW(paramString6));
    paramString1 = localStringBuffer.toString();
    Log.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new lq(paramString1).bMH();
    AppMethodBeat.o(126886);
  }
  
  public final void au(cc paramcc)
  {
    AppMethodBeat.i(241271);
    synchronized (this.oZN)
    {
      this.oZN.offerFirst(paramcc);
      startDownload();
      AppMethodBeat.o(241271);
      return;
    }
  }
  
  public final void hp(boolean paramBoolean)
  {
    AppMethodBeat.i(126882);
    this.oZS = paramBoolean;
    if (this.oZS) {
      stopDownload();
    }
    AppMethodBeat.o(126882);
  }
  
  public final void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(126884);
    if (paramBoolean)
    {
      this.oZP = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRX, Integer.valueOf(0))).intValue();
      this.oZP += 1;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRX, Integer.valueOf(this.oZP));
      AppMethodBeat.o(126884);
      return;
    }
    this.oZQ = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRY, Integer.valueOf(0))).intValue();
    this.oZQ += 1;
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acRY, Integer.valueOf(this.oZQ));
    AppMethodBeat.o(126884);
  }
  
  public final boolean hr(boolean paramBoolean)
  {
    int k = 1000;
    AppMethodBeat.i(126885);
    this.oZO = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRW, Long.valueOf(-1L))).longValue();
    if (Util.milliSecondsToNow(this.oZO) >= 86400000L)
    {
      this.oZO = Util.nowMilliSecond();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRW, Long.valueOf(this.oZO));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRX, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRY, Integer.valueOf(0));
      this.oZU = false;
      this.oZT = false;
    }
    this.oZP = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRX, Integer.valueOf(0))).intValue();
    this.oZQ = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRY, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.oZP;
      i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("C2CMaxPreloadVideo", 100);
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
        Log.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.oZP), Integer.valueOf(this.oZQ) });
        if (bool)
        {
          if (!paramBoolean) {
            break label363;
          }
          if (!this.oZT)
          {
            this.oZT = true;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126885);
        return bool;
        j = this.oZQ;
        i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVY, 1000);
        break;
        bool = false;
        break label219;
        label363:
        if (!this.oZU)
        {
          this.oZU = true;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void startDownload()
  {
    AppMethodBeat.i(126881);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126877);
        boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRY, false);
        Object localObject1;
        if (!com.tencent.mm.n.a.aTe())
        {
          localObject1 = new acn();
          ((acn)localObject1).ifU.hId = 2;
          ((acn)localObject1).publish();
          if (!((acn)localObject1).ifV.calling) {}
        }
        else if (bool)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (v.bOm().hxH)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if (p.this.oZV != null)
        {
          AppMethodBeat.o(126877);
          return;
        }
        if ((p.this.oZR) || (p.this.oZS))
        {
          AppMethodBeat.o(126877);
          return;
        }
        int i;
        if (p.this.oZN.isEmpty())
        {
          localObject1 = p.this;
          if (Util.secondsToNow(((p)localObject1).oZW) > 600L) {
            ((p)localObject1).oZW = Util.nowSecond();
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              p.a(p.this);
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
          synchronized (p.this.oZN)
          {
            Iterator localIterator = p.this.oZN.iterator();
            localObject1 = null;
            if (!localIterator.hasNext()) {
              break label814;
            }
            localObject1 = (cc)localIterator.next();
            localObject6 = p.this;
            if (localObject1 == null)
            {
              ((PBool)localObject5).value = true;
              i = 0;
              if (!((PBool)localObject5).value) {
                break label1078;
              }
              localIterator.remove();
              break label1078;
            }
            z localz = ab.Qo(((fi)localObject1).field_imgPath);
            if ((localz != null) && (localz.bOx()))
            {
              Log.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), localz.getFileName() });
              Object localObject7 = XmlParser.parseXml(localz.bOu(), "msg", null);
              String str = (String)((Map)localObject7).get(".msg.videomsg.$newmd5");
              localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
              bool = au.bwE(localz.bOs());
              if (!bool) {
                break label1085;
              }
              i = 2;
              long l = localz.osy;
              if (!au.bwE(localz.bOs())) {
                break label1090;
              }
              j = com.tencent.mm.model.v.getMembersCountByChatRoomName(localz.bOs());
              ((p)localObject6).a(str, i, l, localz.bOq(), localz.bOs(), j, (String)localObject7, "", "");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 146L, 1L, false);
              if (bool)
              {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 126L, 1L, false);
                ((PBool)localObject5).value = true;
                i = 0;
                continue;
              }
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 125L, 1L, false);
            }
          }
          if (Util.milliSecondsToNow(localObject2.getCreateTime()) >= 86400000L)
          {
            Log.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
            ((PBool)localObject5).value = true;
            i = 0;
          }
          else
          {
            if (((p)localObject6).hr(true)) {
              Log.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((p)localObject6).oZO) });
            }
            label801:
            for (;;)
            {
              ((PBool)localObject5).value = false;
              i = 0;
              break;
              Log.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(localObject2.field_msgId), localObject2.jUr });
              localObject6 = br.JP(localObject2.jUr);
              if (localObject6 == null)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (((br.b)localObject6).omg <= 0)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (!b.NB(((br.b)localObject6).omi))
              {
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                  i = ((br.b)localObject6).omh & 0x1;
                }
                for (;;)
                {
                  if (i <= 0) {
                    break label801;
                  }
                  ((PBool)localObject5).value = false;
                  i = 1;
                  break;
                  if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
                  {
                    i = ((br.b)localObject6).omh & 0x2;
                  }
                  else
                  {
                    if (!NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                      break label803;
                    }
                    i = ((br.b)localObject6).omh & 0x4;
                  }
                }
              }
            }
            label803:
            ((PBool)localObject5).value = false;
            i = 0;
            continue;
            label814:
            label1078:
            do
            {
              if (localObject2 == null)
              {
                AppMethodBeat.o(126877);
                return;
              }
              p.this.oZV = new j(localObject2.field_msgId);
              Log.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(p.this.hashCode()), p.this.oZV.bNY() });
              if (p.this.oZV.a(p.this) < 0)
              {
                Log.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(p.this.hashCode()) });
                synchronized (p.this.oZN)
                {
                  ??? = p.this.oZN.iterator();
                  while (((Iterator)???).hasNext())
                  {
                    localObject5 = (cc)((Iterator)???).next();
                    if ((localObject5 != null) && (((fi)localObject5).field_msgId == p.this.oZV.msgId))
                    {
                      Log.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(p.this.hashCode()), Long.valueOf(p.this.oZV.msgId) });
                      ((Iterator)???).remove();
                    }
                  }
                }
                p.this.oZV = null;
              }
              AppMethodBeat.o(126877);
              return;
            } while (i != 0);
            continue;
            label1085:
            i = 1;
            continue;
            label1090:
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
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126876);
        if (p.this.oZV != null) {
          p.this.oZV.stop();
        }
        p.this.oZV = null;
        AppMethodBeat.o(126876);
      }
    });
    AppMethodBeat.o(126880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */