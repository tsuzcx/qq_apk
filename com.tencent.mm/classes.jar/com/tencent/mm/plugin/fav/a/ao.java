package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.mm.h.a.kv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ao
  implements n.a
{
  private static n kai = null;
  private static ao kaj = null;
  public int bNM;
  public int duration;
  public String path;
  
  public static ao aQQ()
  {
    if (kaj == null) {
      kaj = new ao();
    }
    return kaj;
  }
  
  public static n aQS()
  {
    return kai;
  }
  
  public final void aQR()
  {
    if (kai == null) {
      kai = new n();
    }
    kai.a(this);
    kai.jZD = true;
    n localn = kai;
    if (n.iah == null) {
      n.iah = new SensorController(ae.getContext());
    }
    if (localn.ial == null) {
      localn.ial = new bb(ae.getContext());
    }
  }
  
  public final void bj(String paramString, int paramInt)
  {
    y.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 1);
    if (!bk.aM(paramString, "").equals(this.path)) {
      localBundle.putBoolean("result", true);
    }
    for (;;)
    {
      localBundle.putInt("position", paramInt);
      paramString = new kv();
      paramString.bTV.bTQ = localBundle;
      paramString.bTV.type = 4;
      a.udP.m(paramString);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void onFinish()
  {
    kai.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    kv localkv = new kv();
    localkv.bTV.bTQ = localBundle;
    localkv.bTV.type = 4;
    a.udP.m(localkv);
  }
  
  public final void onPause()
  {
    kai.aQm();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    kv localkv = new kv();
    localkv.bTV.bTQ = localBundle;
    localkv.bTV.type = 4;
    a.udP.m(localkv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ao
 * JD-Core Version:    0.7.0.1
 */