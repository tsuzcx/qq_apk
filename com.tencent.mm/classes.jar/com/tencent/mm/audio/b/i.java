package com.tencent.mm.audio.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class i
  implements f
{
  private static int ckO = 0;
  public static boolean ckP = true;
  Queue<String> ckH;
  Queue<r> ckI;
  Map<String, g.a> ckJ;
  private boolean ckK;
  private boolean ckL;
  public int ckM;
  private long ckN;
  g.a ckQ;
  private ap ckR;
  private boolean running;
  
  public i()
  {
    AppMethodBeat.i(116523);
    this.ckH = new LinkedList();
    this.ckI = new LinkedList();
    this.ckJ = new HashMap();
    this.ckK = false;
    this.ckL = false;
    this.running = false;
    this.ckM = 0;
    this.ckN = 0L;
    this.ckQ = new g.a();
    this.ckR = new ap(g.RO().oNc.getLooper(), new i.3(this), false);
    g.Rc().a(127, this);
    g.Rc().a(128, this);
    AppMethodBeat.o(116523);
  }
  
  private void ET()
  {
    AppMethodBeat.i(116525);
    this.ckJ.clear();
    this.ckH.clear();
    this.ckI.clear();
    this.ckL = false;
    this.ckK = false;
    this.running = false;
    ab.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.ckQ.Mm());
    AppMethodBeat.o(116525);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(116524);
    g.RO().ac(new i.1(this, paramm, paramInt1, paramInt2));
    AppMethodBeat.o(116524);
  }
  
  public final void run()
  {
    AppMethodBeat.i(116526);
    g.RO().ac(new i.2(this));
    AppMethodBeat.o(116526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.i
 * JD-Core Version:    0.7.0.1
 */