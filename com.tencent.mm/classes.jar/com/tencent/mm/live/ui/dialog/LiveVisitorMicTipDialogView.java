package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onButtonClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOK", "", "setOnButtonClickListener", "listener", "plugin-logic_release"})
public final class LiveVisitorMicTipDialogView
  extends RelativeLayout
{
  private d.g.a.b<? super Boolean, z> hcM;
  
  public LiveVisitorMicTipDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216527);
    paramContext = (TextView)LayoutInflater.from(paramContext).inflate(2131496354, (ViewGroup)this, true).findViewById(2131307696);
    if (paramContext != null)
    {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(216525);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = LiveVisitorMicTipDialogView.a(this.hcN);
          if (paramAnonymousView != null) {
            paramAnonymousView.invoke(Boolean.TRUE);
          }
          a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216525);
        }
      });
      AppMethodBeat.o(216527);
      return;
    }
    AppMethodBeat.o(216527);
  }
  
  public final void setOnButtonClickListener(d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(216526);
    p.h(paramb, "listener");
    this.hcM = paramb;
    AppMethodBeat.o(216526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorMicTipDialogView
 * JD-Core Version:    0.7.0.1
 */