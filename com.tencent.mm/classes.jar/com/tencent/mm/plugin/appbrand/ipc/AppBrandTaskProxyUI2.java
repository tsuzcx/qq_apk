package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandTaskProxyUI2
  extends AppBrandTaskProxyUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI2
 * JD-Core Version:    0.7.0.1
 */