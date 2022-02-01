package com.tencent.mm.plugin.finder.live.gala.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/viewpager/LiveCommentTab;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tabType", "", "onClick", "Lkotlin/Function0;", "", "(Lcom/google/android/material/tabs/TabLayout$Tab;ILkotlin/jvm/functions/Function0;)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Lcom/google/android/material/tabs/TabLayout$Tab;", "setTab", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabRedIcon", "Landroid/view/ViewGroup;", "getTabRedIcon", "()Landroid/view/ViewGroup;", "setTabRedIcon", "(Landroid/view/ViewGroup;)V", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "Landroid/widget/TextView;", "getTabRedTv", "()Landroid/widget/TextView;", "setTabRedTv", "(Landroid/widget/TextView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "isShowRedDot", "", "setTextBold", "isBold", "setTextColor", "id", "setTitle", "title", "", "showRedDot", "show", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a admc;
  public ImageView EFo;
  public TabLayout.e dyQ;
  private int hJx;
  public int index;
  private TextView titleTv;
  
  static
  {
    AppMethodBeat.i(371178);
    admc = new a((byte)0);
    AppMethodBeat.o(371178);
  }
  
  public b(TabLayout.e parame, int paramInt, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(371160);
    this.dyQ = parame;
    this.hJx = paramInt;
    this.dyQ.tag = this;
    this.dyQ.jw(p.f.WMi);
    parame = this.dyQ.dyK;
    if (parame == null)
    {
      parame = null;
      this.titleTv = parame;
      parame = this.dyQ.dyK;
      if (parame != null) {
        break label169;
      }
      parame = null;
      label77:
      this.EFo = parame;
      parame = this.dyQ.dyK;
      if (parame != null) {
        parame.setOnClickListener(new b..ExternalSyntheticLambda0(parama));
      }
      parame = this.dyQ.dyM;
      if (!(parame instanceof View)) {
        break label183;
      }
    }
    label169:
    label183:
    for (parame = (View)parame;; parame = null)
    {
      if (parame != null) {
        parame.setOnTouchListener(b..ExternalSyntheticLambda1.INSTANCE);
      }
      setTextColor(p.b.BW_100_Alpha_0_5);
      setTextBold(false);
      AppMethodBeat.o(371160);
      return;
      parame = (TextView)parame.findViewById(p.e.tabTitle);
      break;
      parame = (ImageView)parame.findViewById(p.e.tabRed);
      break label77;
    }
  }
  
  private static final void m(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(371169);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/gala/viewpager/LiveCommentTab", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$v");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/gala/viewpager/LiveCommentTab", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371169);
  }
  
  private static final boolean q(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void setTextBold(boolean paramBoolean)
  {
    AppMethodBeat.i(371207);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        aw.a((Paint)localTextView.getPaint(), 0.8F);
        AppMethodBeat.o(371207);
        return;
      }
      localTextView.getPaint().setFakeBoldText(false);
      localTextView.getPaint().setStrokeWidth(0.0F);
    }
    AppMethodBeat.o(371207);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(371199);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      View localView = this.dyQ.dyK;
      s.checkNotNull(localView);
      localTextView.setTextColor(localView.getContext().getResources().getColor(paramInt));
    }
    AppMethodBeat.o(371199);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(371195);
    s.u(paramString, "title");
    TextView localTextView = this.titleTv;
    if (localTextView != null) {
      localTextView.setText((CharSequence)p.b(localTextView.getContext(), (CharSequence)paramString));
    }
    AppMethodBeat.o(371195);
  }
  
  public final void vm(boolean paramBoolean)
  {
    AppMethodBeat.i(371213);
    ImageView localImageView = this.EFo;
    if (localImageView != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(371213);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/viewpager/LiveCommentTab$Companion;", "", "()V", "BOX_COMMENT", "", "CREATE_COMMENT", "PUBLCI_COMMENT", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.viewpager.b
 * JD-Core Version:    0.7.0.1
 */