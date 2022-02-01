package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"getAppropriateLargeScreenRequestDialogWidth", "", "context", "Landroid/content/Context;", "dialogMeasuredWidth", "dp2Px", "dp", "isLargeScreenEnv", "", "onPreDrawOnce", "", "Landroid/view/View;", "block", "Lkotlin/Function0;", "postRequestLayout", "wxbiz-msgsubscription-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  static final int dZ(Context paramContext)
  {
    AppMethodBeat.i(236548);
    int i = a.eH(paramContext.getResources().getDisplayMetrics().density * 375.0F);
    AppMethodBeat.o(236548);
    return i;
  }
  
  static final void dm(View paramView)
  {
    AppMethodBeat.i(236553);
    MMHandlerThread.postToMainThread(new c..ExternalSyntheticLambda0(paramView));
    AppMethodBeat.o(236553);
  }
  
  private static final void dn(View paramView)
  {
    AppMethodBeat.i(236557);
    s.u(paramView, "$this_postRequestLayout");
    paramView.requestLayout();
    AppMethodBeat.o(236557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c
 * JD-Core Version:    0.7.0.1
 */