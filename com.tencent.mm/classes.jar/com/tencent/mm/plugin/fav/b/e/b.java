package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class b
  implements f, r
{
  private static Map<Long, g.a> ckJ;
  private Queue<com.tencent.mm.plugin.fav.a.g> ckH;
  private boolean ckL;
  private long ckN;
  public ap ckR;
  public n fyJ;
  private boolean muY;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(5361);
    ckJ = new HashMap();
    AppMethodBeat.o(5361);
  }
  
  public b()
  {
    AppMethodBeat.i(5356);
    this.running = false;
    this.ckN = 0L;
    this.ckL = false;
    this.ckH = new LinkedList();
    this.fyJ = new b.2(this);
    this.ckR = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new b.4(this), false);
    this.muY = at.isWifi(ah.getContext());
    com.tencent.mm.kernel.g.RK().a(this.fyJ);
    com.tencent.mm.kernel.g.Rc().a(404, this);
    AppMethodBeat.o(5356);
  }
  
  public final void ET()
  {
    AppMethodBeat.i(5359);
    this.ckH.clear();
    ckJ.clear();
    this.running = false;
    this.ckL = false;
    AppMethodBeat.o(5359);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(5357);
    com.tencent.mm.kernel.g.RO().ac(new b.1(this, paramm, paramInt1));
    AppMethodBeat.o(5357);
  }
  
  public final void run()
  {
    AppMethodBeat.i(5358);
    com.tencent.mm.kernel.g.RO().ac(new b.3(this));
    AppMethodBeat.o(5358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b
 * JD-Core Version:    0.7.0.1
 */