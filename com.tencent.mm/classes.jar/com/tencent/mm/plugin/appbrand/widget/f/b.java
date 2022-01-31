package com.tencent.mm.plugin.appbrand.widget.f;

import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.v;

public final class b
{
  public final v jug;
  b.a juh;
  public f jui;
  
  public b(v paramv)
  {
    this.jug = paramv;
  }
  
  public final b.a aSf()
  {
    AppMethodBeat.i(141729);
    if ((this.juh != null) && (t.aw(this.juh)))
    {
      localObject = this.juh;
      AppMethodBeat.o(141729);
      return localObject;
    }
    this.juh = null;
    Object localObject = this.jug.ixm.aJJ();
    int i = 0;
    while (i < ((ViewGroup)localObject).getChildCount())
    {
      View localView = ((ViewGroup)localObject).getChildAt(i);
      if ((localView instanceof b.a))
      {
        localObject = (b.a)localView;
        AppMethodBeat.o(141729);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(141729);
    return null;
  }
  
  public final b.a aSg()
  {
    AppMethodBeat.i(141730);
    ViewGroup localViewGroup = this.jug.ixm.aJJ();
    b.a locala2 = aSf();
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new b.a(this.jug.getContext());
      locala1.addOnAttachStateChangeListener(new b.1(this));
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.juh = locala1;
    AppMethodBeat.o(141730);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.b
 * JD-Core Version:    0.7.0.1
 */