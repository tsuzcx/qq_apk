package com.tencent.mm.plugin.appbrand.permission;

import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.e.a;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.plugin.appbrand.widget.e.f;

final class a$2
  implements Runnable
{
  a$2(i parami, String paramString) {}
  
  public final void run()
  {
    Object localObject = this.fzd.Zz();
    String str;
    if (localObject != null)
    {
      localObject = ((n)localObject).getCurrentPage();
      if (localObject != null)
      {
        localObject = ((k)localObject).getCurrentPageView();
        if (localObject != null)
        {
          localObject = ((q)localObject).gTR;
          str = this.val$message;
          if ((((b)localObject).hBR.aha() != null) && (((b)localObject).hBR.mContext != null)) {
            break label61;
          }
        }
      }
    }
    return;
    label61:
    if (((b)localObject).hBS == null)
    {
      ((b)localObject).hBS = new a(((b)localObject).hBR.mContext);
      ((b)localObject).hBS.a(((b)localObject).hBR.aha());
    }
    ((b)localObject).hBR.aha().bringChildToFront(((b)localObject).hBS.getView());
    ((b)localObject).hBS.xk(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.2
 * JD-Core Version:    0.7.0.1
 */