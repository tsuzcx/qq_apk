package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$b$4$1
  implements b.a
{
  a$b$4$1(a.b.4 param4) {}
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.IPCInvoke_DoAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    default: 
      y.d("MicroMsg.IPCInvoke_DoAuthorize", "press back button!");
      localBundle.putInt("retCode", -1);
    }
    for (;;)
    {
      this.fVl.fVi.g(localBundle);
      return;
      localBundle.putInt("retCode", 0);
      localBundle.putInt("resultCode", paramInt);
      localBundle.putBundle("resultData", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b.4.1
 * JD-Core Version:    0.7.0.1
 */