package com.tencent.mm.plugin.finder.conv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import kotlin.k.i;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConvChooseTipsView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "initView", "", "plugin-finder_release"})
public final class FinderConvChooseTipsView
  extends FrameLayout
{
  private final String TAG;
  
  public FinderConvChooseTipsView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(282693);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(282693);
  }
  
  public FinderConvChooseTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282694);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(282694);
  }
  
  public FinderConvChooseTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(282695);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(282695);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(282692);
    TextView localTextView = (TextView)ad.kS(getContext()).inflate(b.g.finder_conversation_choose_role_tips_view, (ViewGroup)this).findViewById(b.f.finder_conv_choose_text);
    Object localObject1 = Spannable.Factory.getInstance();
    kotlin.g.b.p.j(localTextView, "chooseTxt");
    localObject1 = ((Spannable.Factory)localObject1).newSpannable(localTextView.getText());
    Object localObject2 = localTextView.getText();
    String str = getContext().getString(b.j.finder_conversation_choose_role_tips_span_part);
    kotlin.g.b.p.j(str, "context.getString(R.stri…oose_role_tips_span_part)");
    kotlin.g.b.p.j(localObject2, "str");
    int i = i.ov(n.a((CharSequence)localObject2, str, 0, false, 6), 0);
    int j = i.ow(str.length() + i, ((CharSequence)localObject2).length());
    localObject2 = getContext();
    kotlin.g.b.p.j(localObject2, "context");
    final int k = ((Context)localObject2).getResources().getColor(b.c.link_color);
    localObject2 = getContext();
    kotlin.g.b.p.j(localObject2, "context");
    final int m = ((Context)localObject2).getResources().getColor(b.c.link_color_pressed);
    ((Spannable)localObject1).setSpan(new a(this, k, m, k, m), i, j, 18);
    localTextView.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(282692);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/conv/FinderConvChooseTipsView$initView$clickable$1", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(i);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289012);
      kotlin.g.b.p.k(paramView, "v");
      Log.i(this.xfS.getTAG(), "choose role click");
      paramView = new Intent();
      if ((this.xfS.getContext() instanceof Activity))
      {
        paramView.putExtra("KEY_CAN_MODEI_ALIAS", false);
        paramView.putExtra("KEY_SOURCE", 2);
        Object localObject = a.ACH;
        localObject = this.xfS.getContext();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(289012);
          throw paramView;
        }
        a.a((Activity)localObject, paramView, 1010, false);
      }
      AppMethodBeat.o(289012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.FinderConvChooseTipsView
 * JD-Core Version:    0.7.0.1
 */