package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class j$1
  implements ViewStub.OnInflateListener
{
  j$1(j paramj) {}
  
  public final void onInflate(ViewStub paramViewStub, View paramView)
  {
    AppMethodBeat.i(56147);
    paramView.findViewById(2131301527).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(188488);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$1$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.a(true, this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$1$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(188488);
        return true;
      }
    });
    AppMethodBeat.o(56147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.1
 * JD-Core Version:    0.7.0.1
 */