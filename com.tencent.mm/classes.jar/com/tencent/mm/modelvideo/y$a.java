package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class y$a
  implements f, t.a
{
  private static int ckO = 0;
  Queue<String> ckH;
  Queue<String> ckI;
  Map<String, g.a> ckJ;
  boolean ckK;
  private boolean ckL;
  int ckM;
  private long ckN;
  g.a ckQ;
  private ap ckR;
  private VideoTransPara fXm;
  private VideoTransPara fXn;
  HandlerThread fYb;
  ak fYc;
  boolean fYd;
  private List<w> fYe;
  Queue<String> fYf;
  Queue<String> fYg;
  d fYh;
  g fYi;
  private HashMap<String, t.a> fYj;
  private boolean running;
  
  public y$a()
  {
    AppMethodBeat.i(50873);
    this.fYb = com.tencent.mm.sdk.g.d.ey("VideoService_runThread", 0);
    this.fYd = false;
    this.ckR = null;
    this.fXm = null;
    this.fXn = null;
    this.fYe = new ArrayList();
    this.ckH = new LinkedList();
    this.ckI = new LinkedList();
    this.fYf = new LinkedList();
    this.fYg = new LinkedList();
    this.ckJ = new HashMap();
    this.ckK = false;
    this.ckL = false;
    this.running = false;
    this.ckM = 0;
    this.ckN = 0L;
    this.fYh = null;
    this.fYi = null;
    this.ckQ = new g.a();
    this.fYj = new HashMap();
    com.tencent.mm.kernel.g.Rc().a(149, this);
    com.tencent.mm.kernel.g.Rc().a(150, this);
    o.alE().a(this, Looper.getMainLooper());
    this.fYb.start();
    this.fYd = true;
    this.fYc = new ak(this.fYb.getLooper());
    this.ckR = new ap(this.fYb.getLooper(), new y.a.1(this), false);
    ab.i("MicroMsg.VideoService", "create VideoService, start video send thread");
    AppMethodBeat.o(50873);
  }
  
  private void ET()
  {
    AppMethodBeat.i(50877);
    this.ckJ.clear();
    this.ckH.clear();
    this.ckI.clear();
    this.fYf.clear();
    this.fYg.clear();
    this.ckL = false;
    this.ckK = false;
    this.running = false;
    ab.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.ckQ.Mm());
    AppMethodBeat.o(50877);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(50883);
    Object localObject = (t.a)this.fYj.get(parama.fileName);
    if (localObject != null) {
      ((t.a)localObject).a(parama);
    }
    localObject = u.vr(parama.fileName);
    if ((localObject != null) && (((s)localObject).status == 199)) {
      this.fYj.remove(parama.fileName);
    }
    AppMethodBeat.o(50883);
  }
  
  public final void a(w paramw)
  {
    AppMethodBeat.i(50874);
    ab.b("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramw });
    if ((paramw != null) && (this.fYe != null) && (!this.fYe.contains(paramw))) {
      this.fYe.add(paramw);
    }
    AppMethodBeat.o(50874);
  }
  
  public final void a(String paramString, t.a parama)
  {
    AppMethodBeat.i(50882);
    this.fYj.put(paramString, parama);
    com.tencent.mm.kernel.g.RO().ac(new y.a.4(this, paramString));
    AppMethodBeat.o(50882);
  }
  
  public final boolean alZ()
  {
    AppMethodBeat.i(50879);
    boolean bool;
    if (this.fYh != null)
    {
      com.tencent.mm.kernel.g.Rc().a(this.fYh);
      bool = true;
      this.running = false;
    }
    for (;;)
    {
      this.ckJ.clear();
      this.ckH.clear();
      this.ckI.clear();
      this.fYf.clear();
      this.fYg.clear();
      AppMethodBeat.o(50879);
      return bool;
      bool = false;
    }
  }
  
  public final void ama()
  {
    AppMethodBeat.i(50880);
    com.tencent.mm.kernel.g.Rc().a(this.fYh);
    ET();
    AppMethodBeat.o(50880);
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(50875);
    if ((paramw != null) && (this.fYe != null)) {
      this.fYe.remove(paramw);
    }
    AppMethodBeat.o(50875);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(50876);
    if ((this.fYb == null) || (!this.fYd) || (this.fYc == null))
    {
      ab.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
      AppMethodBeat.o(50876);
      return;
    }
    this.fYc.post(new y.a.2(this, paramm, paramInt1, paramInt2));
    AppMethodBeat.o(50876);
  }
  
  public final void run()
  {
    AppMethodBeat.i(50878);
    if ((this.fYb == null) || (!this.fYd) || (this.fYc == null))
    {
      ab.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
      AppMethodBeat.o(50878);
      return;
    }
    this.fYc.post(new y.a.3(this));
    AppMethodBeat.o(50878);
  }
  
  public final void vA(String paramString)
  {
    AppMethodBeat.i(50881);
    this.ckJ.remove(paramString);
    AppMethodBeat.o(50881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y.a
 * JD-Core Version:    0.7.0.1
 */