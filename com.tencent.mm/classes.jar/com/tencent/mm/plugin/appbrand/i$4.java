package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;

final class i$4
  extends AppBrandMainProcessService.a
{
  private boolean fyO = false;
  
  i$4(i parami) {}
  
  public final void ZR()
  {
    if (this.fyO) {
      i.c(this.fyM);
    }
    this.fyO = false;
  }
  
  public final void ZS()
  {
    this.fyO = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.4
 * JD-Core Version:    0.7.0.1
 */