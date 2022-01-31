package com.tencent.mm.plugin.appbrand.ui.collection;

import a.d.b.g;
import android.support.v4.app.FragmentActivity;
import com.tencent.mm.plugin.appbrand.ui.a.b;
import java.util.List;

final class a$g$a
  implements Runnable
{
  a$g$a(List paramList, a.g paramg) {}
  
  public final void run()
  {
    Object localObject;
    if (this.hgm.isEmpty())
    {
      FragmentActivity localFragmentActivity = this.hgn.hgh.getActivity();
      localObject = localFragmentActivity;
      if (!(localFragmentActivity instanceof b)) {
        localObject = null;
      }
      localObject = (b)localObject;
      if (localObject != null) {
        ((b)localObject).dC(false);
      }
    }
    for (;;)
    {
      localObject = (Runnable)this.hgn.hgl.invoke();
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      return;
      localObject = a.b(this.hgn.hgh);
      if (localObject == null) {
        g.cUk();
      }
      ((h)localObject).aB(this.hgm);
      if (this.hgn.hgk)
      {
        localObject = a.b(this.hgn.hgh);
        if (localObject == null) {
          g.cUk();
        }
        ((h)localObject).ah(0, this.hgm.size());
      }
      else
      {
        localObject = a.b(this.hgn.hgh);
        if (localObject == null) {
          g.cUk();
        }
        ((h)localObject).aj(0, this.hgm.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a.g.a
 * JD-Core Version:    0.7.0.1
 */