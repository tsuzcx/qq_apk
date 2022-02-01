package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onButtonClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOK", "", "setOnButtonClickListener", "listener", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveVisitorMicTipDialogView
  extends RelativeLayout
{
  private kotlin.g.a.b<? super Boolean, ah> nmu;
  
  public LiveVisitorMicTipDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246393);
    paramContext = (TextView)LayoutInflater.from(paramContext).inflate(b.f.live_visitor_mic_dialog_view, (ViewGroup)this, true).findViewById(b.e.live_mic_dialog_confirm);
    if (paramContext != null) {
      paramContext.setOnClickListener(new LiveVisitorMicTipDialogView..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(246393);
  }
  
  private static final void a(LiveVisitorMicTipDialogView paramLiveVisitorMicTipDialogView, View paramView)
  {
    AppMethodBeat.i(246412);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveVisitorMicTipDialogView);
    localb.cH(paramView);
    a.c("com/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveVisitorMicTipDialogView, "this$0");
    paramLiveVisitorMicTipDialogView = paramLiveVisitorMicTipDialogView.nmu;
    if (paramLiveVisitorMicTipDialogView != null) {
      paramLiveVisitorMicTipDialogView.invoke(Boolean.TRUE);
    }
    a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246412);
  }
  
  public final void setOnButtonClickListener(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(246426);
    s.u(paramb, "listener");
    this.nmu = paramb;
    AppMethodBeat.o(246426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveVisitorMicTipDialogView
 * JD-Core Version:    0.7.0.1
 */