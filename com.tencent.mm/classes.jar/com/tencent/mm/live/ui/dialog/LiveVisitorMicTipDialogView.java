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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onButtonClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOK", "", "setOnButtonClickListener", "listener", "plugin-logic_release"})
public final class LiveVisitorMicTipDialogView
  extends RelativeLayout
{
  private kotlin.g.a.b<? super Boolean, x> hVE;
  
  public LiveVisitorMicTipDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208488);
    paramContext = (TextView)LayoutInflater.from(paramContext).inflate(2131495294, (ViewGroup)this, true).findViewById(2131303480);
    if (paramContext != null)
    {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(208486);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = LiveVisitorMicTipDialogView.a(this.hVF);
          if (paramAnonymousView != null) {
            paramAnonymousView.invoke(Boolean.TRUE);
          }
          a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208486);
        }
      });
      AppMethodBeat.o(208488);
      return;
    }
    AppMethodBeat.o(208488);
  }
  
  public final void setOnButtonClickListener(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(208487);
    p.h(paramb, "listener");
    this.hVE = paramb;
    AppMethodBeat.o(208487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorMicTipDialogView
 * JD-Core Version:    0.7.0.1
 */