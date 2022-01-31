package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class y$a
  implements f, t.a
{
  private static int bEa = 0;
  Queue<String> bDS = new LinkedList();
  Queue<String> bDT = new LinkedList();
  Map<String, g.a> bDU = new HashMap();
  boolean bDV = false;
  private boolean bDW = false;
  private boolean bDX = false;
  int bDY = 0;
  private long bDZ = 0L;
  g.a bEc = new g.a();
  private am bEd = null;
  private VideoTransPara eHv = null;
  private VideoTransPara eHw = null;
  HandlerThread eIl = e.ds("VideoService_runThread", 0);
  ah eIm;
  boolean eIn = false;
  private List<w> eIo = new ArrayList();
  Queue<String> eIp = new LinkedList();
  Queue<String> eIq = new LinkedList();
  public d eIr = null;
  g eIs = null;
  private HashMap<String, t.a> eIt = new HashMap();
  
  public y$a()
  {
    com.tencent.mm.kernel.g.Dk().a(149, this);
    com.tencent.mm.kernel.g.Dk().a(150, this);
    o.Sr().a(this, Looper.getMainLooper());
    this.eIl.start();
    this.eIn = true;
    this.eIm = new ah(this.eIl.getLooper());
    this.bEd = new am(this.eIl.getLooper(), new y.a.1(this), false);
    y.i("MicroMsg.VideoService", "create VideoService, start video send thread");
  }
  
  public final boolean SN()
  {
    boolean bool;
    if (this.eIr != null)
    {
      com.tencent.mm.kernel.g.Dk().c(this.eIr);
      bool = true;
      this.bDX = false;
    }
    for (;;)
    {
      this.bDU.clear();
      this.bDS.clear();
      this.bDT.clear();
      this.eIp.clear();
      this.eIq.clear();
      return bool;
      bool = false;
    }
  }
  
  public final void a(t.a.a parama)
  {
    Object localObject = (t.a)this.eIt.get(parama.fileName);
    if (localObject != null) {
      ((t.a)localObject).a(parama);
    }
    localObject = u.oe(parama.fileName);
    if ((localObject != null) && (((s)localObject).status == 199)) {
      this.eIt.remove(parama.fileName);
    }
  }
  
  public final void a(w paramw)
  {
    y.l("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramw });
    if ((paramw != null) && (this.eIo != null) && (!this.eIo.contains(paramw))) {
      this.eIo.add(paramw);
    }
  }
  
  public final void a(String paramString, t.a parama)
  {
    this.eIt.put(paramString, parama);
    com.tencent.mm.kernel.g.DS().O(new y.a.4(this, paramString));
  }
  
  public final void b(w paramw)
  {
    if ((paramw != null) && (this.eIo != null)) {
      this.eIo.remove(paramw);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.eIl == null) || (!this.eIn) || (this.eIm == null))
    {
      y.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
      return;
    }
    this.eIm.post(new y.a.2(this, paramm, paramInt1, paramInt2));
  }
  
  public final void run()
  {
    if ((this.eIl == null) || (!this.eIn) || (this.eIm == null))
    {
      y.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
      return;
    }
    this.eIm.post(new y.a.3(this));
  }
  
  public final void uB()
  {
    this.bDU.clear();
    this.bDS.clear();
    this.bDT.clear();
    this.eIp.clear();
    this.eIq.clear();
    this.bDW = false;
    this.bDV = false;
    this.bDX = false;
    y.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.bEc.zJ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y.a
 * JD-Core Version:    0.7.0.1
 */