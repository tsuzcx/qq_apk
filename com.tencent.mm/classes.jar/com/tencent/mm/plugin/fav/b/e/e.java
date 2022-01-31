package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class e
  implements f, ac
{
  private static Map<Long, g.a> ckJ;
  private static Map<Long, Integer> mvk;
  private static Set<Long> mvm;
  private Queue<com.tencent.mm.plugin.fav.a.g> ckH;
  private boolean ckL;
  public int ckM;
  private long ckN;
  public ap ckR;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(5401);
    ckJ = new HashMap();
    mvk = new HashMap();
    mvm = new HashSet();
    AppMethodBeat.o(5401);
  }
  
  public e()
  {
    AppMethodBeat.i(5394);
    this.running = false;
    this.ckM = 0;
    this.ckN = 0L;
    this.ckL = false;
    this.ckH = new LinkedList();
    this.ckR = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new e.3(this), false);
    com.tencent.mm.kernel.g.Rc().a(401, this);
    AppMethodBeat.o(5394);
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(5398);
    aj localaj = new aj();
    com.tencent.mm.kernel.g.Rc().a(localaj, 0);
    AppMethodBeat.o(5398);
  }
  
  public final void ET()
  {
    AppMethodBeat.i(5397);
    ab.i("MicroMsg.Fav.FavSendService", "on finish");
    this.ckH.clear();
    ckJ.clear();
    this.running = false;
    this.ckL = false;
    mvk.clear();
    AppMethodBeat.o(5397);
  }
  
  public final boolean amw()
  {
    return this.ckL;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(5395);
    ab.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.RO().ac(new e.1(this, paramm, paramInt1, paramInt2));
    AppMethodBeat.o(5395);
  }
  
  public final void run()
  {
    AppMethodBeat.i(5396);
    com.tencent.mm.kernel.g.RO().ac(new e.2(this));
    AppMethodBeat.o(5396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e
 * JD-Core Version:    0.7.0.1
 */