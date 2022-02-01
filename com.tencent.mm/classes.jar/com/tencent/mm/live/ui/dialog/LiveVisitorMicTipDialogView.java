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
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onButtonClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOK", "", "setOnButtonClickListener", "listener", "plugin-logic_release"})
public final class LiveVisitorMicTipDialogView
  extends RelativeLayout
{
  private b<? super Boolean, y> KzR;
  
  public LiveVisitorMicTipDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203403);
    paramContext = (TextView)LayoutInflater.from(paramContext).inflate(2131496345, (ViewGroup)this, true).findViewById(2131307613);
    if (paramContext != null)
    {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203401);
          paramAnonymousView = LiveVisitorMicTipDialogView.a(this.KzS);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.aA(Boolean.TRUE);
            AppMethodBeat.o(203401);
            return;
          }
          AppMethodBeat.o(203401);
        }
      });
      AppMethodBeat.o(203403);
      return;
    }
    AppMethodBeat.o(203403);
  }
  
  public final void setOnButtonClickListener(b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(203402);
    k.h(paramb, "listener");
    this.KzR = paramb;
    AppMethodBeat.o(203402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorMicTipDialogView
 * JD-Core Version:    0.7.0.1
 */