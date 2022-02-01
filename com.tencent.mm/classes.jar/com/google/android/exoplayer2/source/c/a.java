package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d.k;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.i.w;
import com.google.android.exoplayer2.source.a.c;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.a.i;
import com.google.android.exoplayer2.source.a.l;
import com.google.android.exoplayer2.source.c.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;

public final class a
  implements b
{
  private final g aWG;
  private final u bmW;
  private final f bnC;
  private IOException bnF;
  private final int bre;
  private final d[] brf;
  private com.google.android.exoplayer2.source.c.a.a brg;
  private int brh;
  
  public a(u paramu, com.google.android.exoplayer2.source.c.a.a parama, int paramInt, f paramf, g paramg, k[] paramArrayOfk)
  {
    AppMethodBeat.i(89978);
    this.bmW = paramu;
    this.brg = parama;
    this.bre = paramInt;
    this.bnC = paramf;
    this.aWG = paramg;
    paramu = parama.brp[paramInt];
    this.brf = new d[paramf.length()];
    paramInt = 0;
    if (paramInt < this.brf.length)
    {
      int j = paramf.ff(paramInt);
      paramg = paramu.blC[j];
      if (paramu.type == 2) {}
      for (int i = 4;; i = 0)
      {
        com.google.android.exoplayer2.c.d.e locale = new com.google.android.exoplayer2.c.d.e(3, null, new com.google.android.exoplayer2.c.d.j(j, paramu.type, paramu.bdm, -9223372036854775807L, parama.aSz, paramg, 0, paramArrayOfk, i, null, null));
        this.brf[paramInt] = new d(locale, paramg);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(89978);
  }
  
  public final void a(c paramc) {}
  
  public final void a(l paraml, long paramLong, com.google.android.exoplayer2.source.a.e parame)
  {
    AppMethodBeat.i(89980);
    if (this.bnF != null)
    {
      AppMethodBeat.o(89980);
      return;
    }
    Object localObject1;
    if (paraml != null)
    {
      l = paraml.bmq - paramLong;
      this.bnC.aj(l);
      localObject1 = this.brg.brp[this.bre];
      if (((a.b)localObject1).bmP != 0) {
        break label101;
      }
      if (this.brg.bqS) {
        break label95;
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      parame.bmy = bool;
      AppMethodBeat.o(89980);
      return;
      l = 0L;
      break;
    }
    label101:
    int i;
    if (paraml == null)
    {
      i = ((a.b)localObject1).J(paramLong);
      if (i < ((a.b)localObject1).bmP) {
        break label192;
      }
      if (this.brg.bqS) {
        break label186;
      }
    }
    label186:
    for (bool = true;; bool = false)
    {
      parame.bmy = bool;
      AppMethodBeat.o(89980);
      return;
      j = paraml.uc() - this.brh;
      i = j;
      if (j >= 0) {
        break;
      }
      this.bnF = new com.google.android.exoplayer2.source.b();
      AppMethodBeat.o(89980);
      return;
    }
    label192:
    paramLong = localObject1.bru[i];
    long l = ((a.b)localObject1).eQ(i);
    int j = this.brh;
    int k = this.bnC.getSelectedIndex();
    paraml = this.brf[k];
    k = this.bnC.ff(k);
    if (((a.b)localObject1).blC != null)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
      if (((a.b)localObject1).brt == null) {
        break label484;
      }
      bool = true;
      label275:
      com.google.android.exoplayer2.i.a.checkState(bool);
      if (i >= ((a.b)localObject1).brt.size()) {
        break label490;
      }
    }
    label484:
    label490:
    for (bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      Object localObject2 = Integer.toString(localObject1.blC[k].bitrate);
      Object localObject3 = ((Long)((a.b)localObject1).brt.get(i)).toString();
      localObject2 = ((a.b)localObject1).brs.replace("{bitrate}", (CharSequence)localObject2).replace("{Bitrate}", (CharSequence)localObject2).replace("{start time}", (CharSequence)localObject3).replace("{start_time}", (CharSequence)localObject3);
      localObject1 = w.l(((a.b)localObject1).bqj, (String)localObject2);
      localObject2 = this.bnC.vb();
      localObject3 = this.aWG;
      k = this.bnC.up();
      Object localObject4 = this.bnC.uq();
      parame.bmx = new i((g)localObject3, new com.google.android.exoplayer2.h.j((Uri)localObject1, 0L, -1L, null), (Format)localObject2, k, localObject4, paramLong, paramLong + l, i + j, 1, paramLong, paraml);
      AppMethodBeat.o(89980);
      return;
      bool = false;
      break;
      bool = false;
      break label275;
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.c.a.a parama)
  {
    AppMethodBeat.i(89979);
    a.b localb1 = this.brg.brp[this.bre];
    int i = localb1.bmP;
    a.b localb2 = parama.brp[this.bre];
    if ((i == 0) || (localb2.bmP == 0)) {
      this.brh += i;
    }
    for (;;)
    {
      this.brg = parama;
      AppMethodBeat.o(89979);
      return;
      int j = i - 1;
      long l1 = localb1.bru[j];
      long l2 = localb1.eQ(j);
      long l3 = localb2.bru[0];
      if (l1 + l2 <= l3)
      {
        this.brh += i;
      }
      else
      {
        i = this.brh;
        this.brh = (localb1.J(l3) + i);
      }
    }
  }
  
  public final boolean a(c paramc, boolean paramBoolean, Exception paramException)
  {
    AppMethodBeat.i(89981);
    if ((paramBoolean) && (h.a(this.bnC, this.bnC.j(paramc.bmm), paramException)))
    {
      AppMethodBeat.o(89981);
      return true;
    }
    AppMethodBeat.o(89981);
    return false;
  }
  
  public static final class a
    implements b.a
  {
    private final g.a blq;
    
    public a(g.a parama)
    {
      this.blq = parama;
    }
    
    public final b a(u paramu, com.google.android.exoplayer2.source.c.a.a parama, int paramInt, f paramf, k[] paramArrayOfk)
    {
      AppMethodBeat.i(89977);
      paramu = new a(paramu, parama, paramInt, paramf, this.blq.vi(), paramArrayOfk);
      AppMethodBeat.o(89977);
      return paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a
 * JD-Core Version:    0.7.0.1
 */