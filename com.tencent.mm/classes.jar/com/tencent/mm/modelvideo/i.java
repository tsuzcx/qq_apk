package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class i
  implements f.a
{
  LinkedList<bi> fWm;
  long fWn;
  private int fWo;
  private int fWp;
  public boolean fWq;
  public boolean fWr;
  private boolean fWs;
  private boolean fWt;
  f fWu;
  long fWv;
  
  public i()
  {
    AppMethodBeat.i(50718);
    this.fWm = new LinkedList();
    this.fWn = 0L;
    this.fWo = 0;
    this.fWp = 0;
    this.fWq = false;
    this.fWr = false;
    this.fWs = false;
    this.fWt = false;
    this.fWu = null;
    this.fWv = 0L;
    AppMethodBeat.o(50718);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50721);
    if (paramf == null)
    {
      ab.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(50721);
      return;
    }
    if (this.fWu != paramf) {
      ab.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    ab.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.alv(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.RO().ac(new i.3(this, paramf));
    AppMethodBeat.o(50721);
  }
  
  public final void a(String paramString1, int paramInt1, long paramLong, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(50724);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(bo.aox()).append(",");
    localStringBuffer.append(bo.aox()).append(",");
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
    localStringBuffer.append(c.aeA(paramString6));
    paramString1 = localStringBuffer.toString();
    ab.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new com.tencent.mm.g.b.a.z(paramString1).ake();
    AppMethodBeat.o(50724);
  }
  
  public final void alw()
  {
    AppMethodBeat.i(50720);
    g.RO().ac(new i.2(this));
    AppMethodBeat.o(50720);
  }
  
  public final void di(boolean paramBoolean)
  {
    AppMethodBeat.i(50722);
    if (paramBoolean)
    {
      this.fWo = ((Integer)g.RL().Ru().get(ac.a.yGN, Integer.valueOf(0))).intValue();
      this.fWo += 1;
      g.RL().Ru().set(ac.a.yGN, Integer.valueOf(this.fWo));
      AppMethodBeat.o(50722);
      return;
    }
    this.fWp = ((Integer)g.RL().Ru().get(ac.a.yGO, Integer.valueOf(0))).intValue();
    this.fWp += 1;
    g.RL().Ru().set(ac.a.yGO, Integer.valueOf(this.fWp));
    AppMethodBeat.o(50722);
  }
  
  public final boolean dj(boolean paramBoolean)
  {
    int k = 100;
    AppMethodBeat.i(50723);
    this.fWn = ((Long)g.RL().Ru().get(ac.a.yGM, Long.valueOf(-1L))).longValue();
    if (bo.hl(this.fWn) >= 86400000L)
    {
      this.fWn = bo.aoy();
      g.RL().Ru().set(ac.a.yGM, Long.valueOf(this.fWn));
      g.RL().Ru().set(ac.a.yGN, Integer.valueOf(0));
      g.RL().Ru().set(ac.a.yGO, Integer.valueOf(0));
      this.fWt = false;
      this.fWs = false;
    }
    this.fWo = ((Integer)g.RL().Ru().get(ac.a.yGN, Integer.valueOf(0))).intValue();
    this.fWp = ((Integer)g.RL().Ru().get(ac.a.yGO, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.fWo;
      i = ((a)g.E(a.class)).Nq().getInt("C2CMaxPreloadVideo", 100);
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
        label218:
        ab.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.fWo), Integer.valueOf(this.fWp) });
        if (bool)
        {
          if (!paramBoolean) {
            break label363;
          }
          if (!this.fWs)
          {
            this.fWs = true;
            h.qsU.idkeyStat(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(50723);
        return bool;
        j = this.fWp;
        i = ((a)g.E(a.class)).Nq().getInt("SnsMaxPreloadVideo", 100);
        break;
        bool = false;
        break label218;
        label363:
        if (!this.fWt)
        {
          this.fWt = true;
          h.qsU.idkeyStat(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(50719);
    ab.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[] { Integer.valueOf(hashCode()) });
    g.RO().ac(new i.1(this));
    AppMethodBeat.o(50719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i
 * JD-Core Version:    0.7.0.1
 */