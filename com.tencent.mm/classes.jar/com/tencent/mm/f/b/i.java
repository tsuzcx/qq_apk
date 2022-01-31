package com.tencent.mm.f.b;

import android.os.HandlerThread;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class i
  implements f
{
  private static int bEa = 0;
  public static boolean bEb = true;
  Queue<String> bDS = new LinkedList();
  Queue<com.tencent.mm.modelvoice.p> bDT = new LinkedList();
  Map<String, g.a> bDU = new HashMap();
  private boolean bDV = false;
  private boolean bDW = false;
  private boolean bDX = false;
  public int bDY = 0;
  private long bDZ = 0L;
  g.a bEc = new g.a();
  private am bEd = new am(g.DS().mnU.getLooper(), new i.3(this), false);
  
  public i()
  {
    g.Dk().a(127, this);
    g.Dk().a(128, this);
  }
  
  private void uB()
  {
    this.bDU.clear();
    this.bDS.clear();
    this.bDT.clear();
    this.bDW = false;
    this.bDV = false;
    this.bDX = false;
    y.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.bEc.zJ());
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.DS().O(new i.1(this, paramm, paramInt1, paramInt2));
  }
  
  public final void run()
  {
    g.DS().O(new i.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.i
 * JD-Core Version:    0.7.0.1
 */