package com.tencent.mm.plugin.extqlauncher;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.be;
import java.util.HashMap;

public final class b
  implements at
{
  private b.a mfU;
  private b.b mfV;
  boolean mfW;
  private n.b mfX;
  boolean mfY;
  long mfZ;
  private final long mga;
  private final long mgb;
  private final String mgc;
  int mgd;
  private ak mge;
  
  public b()
  {
    AppMethodBeat.i(20483);
    this.mfW = false;
    this.mfX = new b.1(this);
    this.mfY = false;
    this.mfZ = 0L;
    this.mga = 300000L;
    this.mgb = 4000L;
    this.mgc = "fun1";
    this.mgd = 0;
    this.mge = new b.3(this, Looper.getMainLooper());
    AppMethodBeat.o(20483);
  }
  
  public static b btS()
  {
    AppMethodBeat.i(20484);
    aw.aat();
    b localb2 = (b)bw.pF("plugin.extqlauncher");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      aw.aat().a("plugin.extqlauncher", localb1);
    }
    AppMethodBeat.o(20484);
    return localb1;
  }
  
  public static int btT()
  {
    AppMethodBeat.i(20487);
    if (!aw.RG())
    {
      ab.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
      AppMethodBeat.o(20487);
      return 0;
    }
    int j = u.oM(t.flc);
    int k = l.Zj();
    int i = j;
    if ((r.Zr() & 0x8000) == 0) {
      i = j - k;
    }
    AppMethodBeat.o(20487);
    return i;
  }
  
  public final void btU()
  {
    AppMethodBeat.i(20488);
    this.mge.removeMessages(0);
    this.mge.sendEmptyMessageDelayed(0, 4000L);
    AppMethodBeat.o(20488);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20485);
    aw.aaz();
    c.YF().a(this.mfX);
    if (this.mfU == null) {
      this.mfU = new b.a();
    }
    a.ymk.c(this.mfU);
    if (this.mfV == null) {
      this.mfV = new b.b(this, (byte)0);
    }
    a.ymk.c(this.mfV);
    AppMethodBeat.o(20485);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20486);
    if (this.mfU != null) {
      a.ymk.d(this.mfU);
    }
    if (this.mfV != null) {
      a.ymk.d(this.mfV);
    }
    aw.aaz();
    c.YF().b(this.mfX);
    this.mge.removeMessages(0);
    AppMethodBeat.o(20486);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b
 * JD-Core Version:    0.7.0.1
 */