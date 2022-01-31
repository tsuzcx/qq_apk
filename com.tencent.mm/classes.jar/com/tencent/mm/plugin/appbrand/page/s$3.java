package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.a.c;

final class s$3
  implements ai
{
  private boolean foreground = false;
  private boolean gUu = false;
  private int gUv;
  private int gUw;
  
  s$3(s params, Context paramContext) {}
  
  private void anv()
  {
    Object localObject = this.gUs.getRuntime().aad();
    if (localObject == null) {}
    int[] arrayOfInt;
    do
    {
      do
      {
        return;
        localObject = ((o)localObject).getCurrentPage();
      } while (localObject == null);
      localObject = ((k)localObject).getPageConfig();
      arrayOfInt = com.tencent.mm.plugin.appbrand.v.r.j(this.gUs.aae());
    } while (!"auto".equals(((a.d)localObject).fOf));
    com.tencent.mm.plugin.appbrand.jsapi.r.a(this.gUs, this.gUs.hashCode(), this.gUv, this.gUw, arrayOfInt[0], arrayOfInt[1], this.val$context.getResources().getConfiguration().orientation);
  }
  
  public final void agH()
  {
    if (this.gUu)
    {
      anv();
      this.gUu = false;
    }
    this.gUs.gTS.onOrientationChanged(this.val$context.getResources().getConfiguration().orientation);
    this.foreground = true;
  }
  
  public final void agI()
  {
    this.foreground = false;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.o paramo)
  {
    int k = 0;
    paramo = com.tencent.mm.plugin.appbrand.v.r.i(paramo);
    int m = paramo[0];
    int n = paramo[1];
    int i;
    if ((m != this.gUv) || (n != this.gUw))
    {
      i = 1;
      int j = k;
      if (this.gUv != 0)
      {
        j = k;
        if (this.gUw != 0) {
          j = 1;
        }
      }
      if ((j == 0) || (i == 0)) {
        break label103;
      }
      this.gUv = m;
      this.gUw = n;
      if (!this.foreground) {
        break label97;
      }
      anv();
    }
    label97:
    label103:
    while ((this.gUv != 0) || (this.gUw != 0))
    {
      return;
      i = 0;
      break;
      this.gUu = true;
      return;
    }
    this.gUv = m;
    this.gUw = n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.3
 * JD-Core Version:    0.7.0.1
 */