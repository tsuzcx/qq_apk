package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandDesktopView$g
  extends RecyclerView.v
{
  protected EditText jfo;
  private long jfp;
  
  public AppBrandDesktopView$g(AppBrandDesktopView paramAppBrandDesktopView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(133852);
    this.jfp = 0L;
    this.jfo = ((EditText)paramView.findViewById(2131821197));
    if (this.jfo != null)
    {
      this.jfo.setFocusable(false);
      this.jfo.setOnClickListener(new AppBrandDesktopView.g.1(this, paramAppBrandDesktopView));
    }
    AppMethodBeat.o(133852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.g
 * JD-Core Version:    0.7.0.1
 */