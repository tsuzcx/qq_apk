package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashSet;
import java.util.Iterator;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = a.b(this.hoL);
    paramView = a.c(this.hoL);
    if (((b)localObject).hoM.isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        a.b(this.hoL).cb(a.c(this.hoL));
      }
      return;
      localObject = ((b)localObject).hoM.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.a.2
 * JD-Core Version:    0.7.0.1
 */