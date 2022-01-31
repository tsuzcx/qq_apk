package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    if (!com.tencent.mm.ipcinvoker.b.BT().fC("com.tencent.mm:support")) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("forceKillProcess", true);
    f.a("com.tencent.mm:support", localBundle, b.a.class, new b.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b.3
 * JD-Core Version:    0.7.0.1
 */