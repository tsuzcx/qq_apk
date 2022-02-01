package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ak$c
  extends ContextWrapper
{
  private Resources mResources;
  
  public ak$c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(49917);
    if ((this.mResources != null) && ((this.mResources instanceof ak.d)))
    {
      localResources = this.mResources;
      AppMethodBeat.o(49917);
      return localResources;
    }
    Resources localResources = super.getResources();
    this.mResources = new ak.d(localResources.getAssets(), localResources.getDisplayMetrics(), localResources.getConfiguration());
    localResources = this.mResources;
    AppMethodBeat.o(49917);
    return localResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak.c
 * JD-Core Version:    0.7.0.1
 */