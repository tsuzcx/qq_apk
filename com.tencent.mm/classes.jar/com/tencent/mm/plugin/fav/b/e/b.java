package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class b
  implements f, r
{
  private static Map<Long, g.a> bDU = new HashMap();
  private Queue<com.tencent.mm.plugin.fav.a.g> bDS = new LinkedList();
  private boolean bDW = false;
  private boolean bDX = false;
  private long bDZ = 0L;
  public am bEd = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new b.4(this), false);
  public n eiF = new b.2(this);
  private boolean kaC = aq.isWifi(ae.getContext());
  
  public b()
  {
    com.tencent.mm.kernel.g.DO().a(this.eiF);
    com.tencent.mm.kernel.g.Dk().a(404, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.kernel.g.DS().O(new b.1(this, paramm, paramInt1));
  }
  
  public final void run()
  {
    com.tencent.mm.kernel.g.DS().O(new b.3(this));
  }
  
  public final void uB()
  {
    this.bDS.clear();
    bDU.clear();
    this.bDX = false;
    this.bDW = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b
 * JD-Core Version:    0.7.0.1
 */