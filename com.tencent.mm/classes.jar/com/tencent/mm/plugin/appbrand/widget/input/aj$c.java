package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

final class aj$c
  extends ContextWrapper
{
  private Resources mResources;
  
  public aj$c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final Resources getResources()
  {
    if ((this.mResources != null) && ((this.mResources instanceof aj.d))) {
      return this.mResources;
    }
    Resources localResources = super.getResources();
    this.mResources = new aj.d(localResources.getAssets(), localResources.getDisplayMetrics(), localResources.getConfiguration());
    return this.mResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj.c
 * JD-Core Version:    0.7.0.1
 */