package com.tencent.mm.plugin.game.model;

import android.os.HandlerThread;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class n
  implements com.tencent.mm.ah.f
{
  private static boolean isRunning = false;
  private static int kOP = 20;
  private static LinkedList<i> kOQ = new LinkedList();
  private static ai kOR;
  private int offset = 0;
  
  private void aZl()
  {
    isRunning = false;
    kOR.mnU.quit();
    g.Dk().b(1215, this);
  }
  
  public static void update()
  {
    if (!f.aZa())
    {
      y.i("MicroMsg.GameListUpdater", "No need to update");
      return;
    }
    if (isRunning)
    {
      y.e("MicroMsg.GameListUpdater", "Already running");
      return;
    }
    kOR = new ai("GameListUpdate");
    kOQ.clear();
    n localn = new n();
    g.Dk().a(1215, localn);
    g.Dk().a(new av(localn.offset, kOP), 0);
    isRunning = true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      aZl();
      return;
    }
    kOR.O(new n.1(this, paramm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.n
 * JD-Core Version:    0.7.0.1
 */