package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.m.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class q
{
  public static void a(View paramView, AppBrandCircleProgressView paramAppBrandCircleProgressView, TextView paramTextView)
  {
    AppMethodBeat.i(322201);
    ViewGroup.LayoutParams localLayoutParams = paramAppBrandCircleProgressView.getLayoutParams();
    localLayoutParams.width = a.br(MMApplicationContext.getContext(), a.b.Edge_8A);
    localLayoutParams.height = a.br(MMApplicationContext.getContext(), a.b.Edge_8A);
    paramAppBrandCircleProgressView.setLayoutParams(localLayoutParams);
    paramAppBrandCircleProgressView = paramView.getLayoutParams();
    paramAppBrandCircleProgressView.width = a.br(MMApplicationContext.getContext(), a.b.Edge_6A);
    paramAppBrandCircleProgressView.height = a.br(MMApplicationContext.getContext(), a.b.Edge_6A);
    paramView.requestLayout();
    paramTextView.setTextSize(0, a.br(MMApplicationContext.getContext(), a.b.ActionBarTextSize));
    AppMethodBeat.o(322201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.q
 * JD-Core Version:    0.7.0.1
 */