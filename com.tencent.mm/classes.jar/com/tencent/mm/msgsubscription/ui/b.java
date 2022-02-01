package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgDialogUIHelper;", "", "()V", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a pkZ;
  
  static
  {
    AppMethodBeat.i(236546);
    pkZ = new a((byte)0);
    AppMethodBeat.o(236546);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgDialogUIHelper$Companion;", "", "()V", "configDialogLayoutParams", "", "rotation", "", "dialogRootView", "Landroid/view/View;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void d(int paramInt, View paramView)
    {
      AppMethodBeat.i(236614);
      s.u(paramView, "dialogRootView");
      Object localObject2 = paramView.getContext();
      switch (paramInt)
      {
      case 2: 
      default: 
        s.s(localObject2, "context");
        if ((((Context)localObject2).getResources().getConfiguration().screenLayout & 0xF) < 3) {
          break;
        }
      }
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        localObject1 = (a)new a(paramView, (Context)localObject2);
        if (paramView.getViewTreeObserver().isAlive()) {
          paramView.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new c.a(paramView, (a)localObject1));
        }
        AppMethodBeat.o(236614);
        return;
        localObject1 = paramView.getLayoutParams();
        s.s(localObject2, "context");
        ((ViewGroup.LayoutParams)localObject1).width = c.dZ((Context)localObject2);
        localObject2 = ah.aiuX;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(236614);
        return;
      }
      Object localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = -1;
      localObject2 = ah.aiuX;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(236614);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(View paramView, Context paramContext)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b
 * JD-Core Version:    0.7.0.1
 */