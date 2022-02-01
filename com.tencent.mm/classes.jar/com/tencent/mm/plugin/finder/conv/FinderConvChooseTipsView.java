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
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConvChooseTipsView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "initView", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderConvChooseTipsView
  extends FrameLayout
{
  private final String TAG;
  
  public FinderConvChooseTipsView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(335937);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(335937);
  }
  
  public FinderConvChooseTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335944);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(335944);
  }
  
  public FinderConvChooseTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(335950);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(335950);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(335962);
    TextView localTextView = (TextView)af.mU(getContext()).inflate(e.f.finder_conversation_choose_role_tips_view, (ViewGroup)this).findViewById(e.e.finder_conv_choose_text);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(localTextView.getText());
    CharSequence localCharSequence = localTextView.getText();
    String str = getContext().getString(e.h.finder_conversation_choose_role_tips_span_part);
    s.s(str, "context.getString(R.stri…oose_role_tips_span_part)");
    s.s(localCharSequence, "str");
    int i = k.qu(n.a(localCharSequence, str, 0, false, 6), 0);
    int j = k.qv(str.length() + i, localCharSequence.length());
    localSpannable.setSpan(new a(this, getContext().getResources().getColor(e.b.link_color), getContext().getResources().getColor(e.b.link_color_pressed)), i, j, 18);
    localTextView.setText((CharSequence)localSpannable, TextView.BufferType.SPANNABLE);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(335962);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/conv/FinderConvChooseTipsView$initView$clickable$1", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends t
  {
    a(FinderConvChooseTipsView paramFinderConvChooseTipsView, int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(336156);
      s.u(paramView, "v");
      Log.i(this.AFr.getTAG(), "choose role click");
      paramView = new Intent();
      if ((this.AFr.getContext() instanceof Activity))
      {
        paramView.putExtra("KEY_CAN_MODEI_ALIAS", false);
        paramView.putExtra("KEY_SOURCE", 2);
        a locala = a.GfO;
        Context localContext = this.AFr.getContext();
        if (localContext == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(336156);
          throw paramView;
        }
        locala.a((Activity)localContext, paramView, 1010, false);
      }
      AppMethodBeat.o(336156);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.FinderConvChooseTipsView
 * JD-Core Version:    0.7.0.1
 */