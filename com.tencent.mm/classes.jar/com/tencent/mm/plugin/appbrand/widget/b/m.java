package com.tencent.mm.plugin.appbrand.widget.b;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper;", "", "()V", "Companion", "luggage-wechat-full-sdk_release"})
public final class m
{
  public static final a jkc;
  
  static
  {
    AppMethodBeat.i(102508);
    jkc = new a((byte)0);
    AppMethodBeat.o(102508);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper$Companion;", "", "()V", "applyStyleByRotation", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "buttonGroup", "rotation", "", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static void a(Context paramContext, View paramView1, View paramView2, int paramInt)
    {
      AppMethodBeat.i(102507);
      j.q(paramContext, "context");
      j.q(paramView1, "rootView");
      j.q(paramView2, "buttonGroup");
      ViewGroup.LayoutParams localLayoutParams = paramView2.getLayoutParams();
      if ((paramInt == 1) || (paramInt == 3))
      {
        if ((paramView2.getParent() instanceof RelativeLayout))
        {
          if (localLayoutParams == null)
          {
            paramContext = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(102507);
            throw paramContext;
          }
          ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131428106);
        }
        paramView2 = paramView1.getLayoutParams();
        paramView2.width = paramContext.getResources().getDimensionPixelSize(2131428109);
        paramView1.setLayoutParams(paramView2);
        AppMethodBeat.o(102507);
        return;
      }
      if ((paramView2.getParent() instanceof RelativeLayout))
      {
        if (localLayoutParams == null)
        {
          paramContext = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(102507);
          throw paramContext;
        }
        ((RelativeLayout.LayoutParams)localLayoutParams).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131428107);
      }
      paramContext = paramView1.getLayoutParams();
      paramContext.width = -1;
      paramView1.setLayoutParams(paramContext);
      AppMethodBeat.o(102507);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.m
 * JD-Core Version:    0.7.0.1
 */