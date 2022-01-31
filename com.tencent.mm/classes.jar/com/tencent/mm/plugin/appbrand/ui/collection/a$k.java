package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v4.app.FragmentActivity;
import com.tencent.mm.plugin.appbrand.ui.a.b;

final class a$k
  implements Runnable
{
  a$k(a parama) {}
  
  public final void run()
  {
    FragmentActivity localFragmentActivity = this.hgh.getActivity();
    Object localObject = localFragmentActivity;
    if (!(localFragmentActivity instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null) {
      ((b)localObject).dC(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a.k
 * JD-Core Version:    0.7.0.1
 */