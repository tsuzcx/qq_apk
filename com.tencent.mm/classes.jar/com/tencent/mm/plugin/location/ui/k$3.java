package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class k$3
  implements View.OnClickListener
{
  k$3(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55965);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    k.a(this.yKq, localObject[0], localObject[1]);
    a.a(this, "com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(55965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.3
 * JD-Core Version:    0.7.0.1
 */