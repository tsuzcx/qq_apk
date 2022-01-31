package com.tencent.mm.plugin.appbrand.debugger;

import a.b;
import a.c;
import a.d.a.a;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.launching.b.e;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  implements DebuggerShell.a
{
  private final b fRG = c.f((a)g.a.fRH);
  
  public final void l(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("url");
      if (paramIntent != null) {
        ((e)this.fRG.getValue()).a(ae.getContext(), paramIntent, 1011, new Bundle());
      }
    }
  }
  
  public final String name()
  {
    return "MockScanCodeUrl";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.g
 * JD-Core Version:    0.7.0.1
 */