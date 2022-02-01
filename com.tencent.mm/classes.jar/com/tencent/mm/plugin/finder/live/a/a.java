package com.tencent.mm.plugin.finder.live.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.ui.widget.a.h;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/actionsheet/FinderLiveBottomSheet;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentLayout", "Landroid/widget/FrameLayout;", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "headerLayout", "Landroid/widget/RelativeLayout;", "leftBtn", "Landroid/view/View;", "onRightClickListener", "Lkotlin/Function0;", "", "rightLayout", "rightTextView", "Landroid/widget/TextView;", "titleView", "hide", "setContentView", "view", "params", "Landroid/widget/FrameLayout$LayoutParams;", "setHeaderVisibility", "visibiltiy", "", "setOnRightClickListener", "setRightText", "text", "", "setRightView", "setTitle", "title", "show", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
{
  public h Zuj;
  private RelativeLayout Zuk;
  public FrameLayout Zum;
  private View Zun;
  private FrameLayout Zuo;
  private TextView Zup;
  private kotlin.g.a.a<ah> Zuq;
  private TextView titleView;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(370913);
    this.Zuj = new h(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(p.f.VIx, null);
    s.s(paramContext, "from(context).inflate(R.…alog_bottom_layout, null)");
    View localView = paramContext.findViewById(p.e.HHD);
    s.s(localView, "customView.findViewById(…ttom_sheet_layout_header)");
    this.Zuk = ((RelativeLayout)localView);
    localView = paramContext.findViewById(p.e.HHC);
    s.s(localView, "customView.findViewById(…tom_sheet_layout_content)");
    this.Zum = ((FrameLayout)localView);
    localView = paramContext.findViewById(p.e.RqO);
    s.s(localView, "customView.findViewById(…live_left_back_btn_group)");
    this.Zun = localView;
    localView = paramContext.findViewById(p.e.Tbt);
    s.s(localView, "customView.findViewById(…d.finder_live_title_text)");
    this.titleView = ((TextView)localView);
    localView = paramContext.findViewById(p.e.REi);
    s.s(localView, "customView.findViewById(…finder_live_right_layout)");
    this.Zuo = ((FrameLayout)localView);
    localView = paramContext.findViewById(p.e.REj);
    s.s(localView, "customView.findViewById(…d.finder_live_right_text)");
    this.Zup = ((TextView)localView);
    this.Zun.setOnClickListener(new a..ExternalSyntheticLambda1(this));
    this.Zuo.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    this.Zuj.mh(paramContext);
    this.Zuj.jHQ();
    this.Zuj.GwS = true;
    AppMethodBeat.o(370913);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(370914);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/actionsheet/FinderLiveBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.Zuj.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/actionsheet/FinderLiveBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370914);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(370916);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/actionsheet/FinderLiveBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.Zuq;
    if (parama != null) {
      parama.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/actionsheet/FinderLiveBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370916);
  }
  
  public final void aqj(int paramInt)
  {
    AppMethodBeat.i(370928);
    this.Zuk.setVisibility(paramInt);
    AppMethodBeat.o(370928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.a.a
 * JD-Core Version:    0.7.0.1
 */