package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isLandscape", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "Landroid/view/View;", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"})
public final class b
  extends e
{
  public static final a KzI;
  private static final String TAG = "MicroMsg.LiveVisitorGuideDialog";
  
  static
  {
    AppMethodBeat.i(203393);
    KzI = new a((byte)0);
    TAG = "MicroMsg.LiveVisitorGuideDialog";
    AppMethodBeat.o(203393);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(203392);
    gl();
    AppMethodBeat.o(203392);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203390);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(203390);
  }
  
  public final void setContentView(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(203391);
    k.h(paramView, "view");
    Window localWindow = getWindow();
    if (localWindow == null) {
      k.fvU();
    }
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(2131820790);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    Object localObject = getContext();
    k.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "context.resources");
    if (((Resources)localObject).getConfiguration().orientation == 2) {
      i = 1;
    }
    if (i != 0) {
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      localWindow.setAttributes(localLayoutParams);
      super.setContentView(paramView);
      paramView = getWindow();
      if (paramView == null) {
        k.fvU();
      }
      paramView.setLayout(-1, -1);
      AppMethodBeat.o(203391);
      return;
      localLayoutParams.width = -1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideDialog$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.b
 * JD-Core Version:    0.7.0.1
 */