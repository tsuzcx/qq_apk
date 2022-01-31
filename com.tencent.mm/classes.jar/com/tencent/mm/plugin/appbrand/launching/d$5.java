package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;

final class d$5
  extends z
{
  d$5(d paramd, String paramString1, int paramInt1, String paramString2, int paramInt2, WxaAttributes.d paramd1)
  {
    super(paramString1, paramInt1, paramString2, paramInt2, paramd1);
  }
  
  public final void alE()
  {
    d.d(this.gKf);
  }
  
  public final void alG()
  {
    d.e(this.gKf);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    if (this.gKf.gJR != null) {
      this.gKf.gJR.onDownloadProgress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.5
 * JD-Core Version:    0.7.0.1
 */