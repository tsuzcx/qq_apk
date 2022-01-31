package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class e
  implements f, ac
{
  private static Map<Long, g.a> bDU = new HashMap();
  private static Map<Long, Integer> kaO = new HashMap();
  private static Set<Long> kaQ = new HashSet();
  private Queue<com.tencent.mm.plugin.fav.a.g> bDS = new LinkedList();
  private boolean bDW = false;
  private boolean bDX = false;
  public int bDY = 0;
  private long bDZ = 0L;
  public am bEd = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new e.3(this), false);
  
  public e()
  {
    com.tencent.mm.kernel.g.Dk().a(401, this);
  }
  
  public static void startSync()
  {
    aj localaj = new aj();
    com.tencent.mm.kernel.g.Dk().a(localaj, 0);
  }
  
  public final boolean Tk()
  {
    return this.bDW;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.DS().O(new e.1(this, paramm, paramInt1, paramInt2));
  }
  
  public final void run()
  {
    com.tencent.mm.kernel.g.DS().O(new e.2(this));
  }
  
  public final void uB()
  {
    y.i("MicroMsg.Fav.FavSendService", "on finish");
    this.bDS.clear();
    bDU.clear();
    this.bDX = false;
    this.bDW = false;
    kaO.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e
 * JD-Core Version:    0.7.0.1
 */