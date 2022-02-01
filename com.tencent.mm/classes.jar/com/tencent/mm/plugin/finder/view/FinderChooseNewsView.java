package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "descText", "Landroid/widget/TextView;", "getDescText", "()Landroid/widget/TextView;", "descText$delegate", "fireChar", "", "likeChar", "isChecked", "", "scaleImage", "Landroid/graphics/drawable/Drawable;", "image", "width", "height", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderChooseNewsView
  extends RelativeLayout
{
  private final j Fdh;
  private final j Gxm;
  private final char Gxn;
  private final char Gxo;
  
  public FinderChooseNewsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344425);
    this.Fdh = k.cm((kotlin.g.a.a)new a(this));
    this.Gxm = k.cm((kotlin.g.a.a)new b(this));
    this.Gxn = ' ';
    this.Gxo = ' ';
    af.mU(getContext()).inflate(e.f.finder_post_choose_news_feed_layout, (ViewGroup)this, true);
    int i = getContext().getResources().getDimensionPixelSize(e.c.Edge_2A);
    paramContext = new SpannableString((CharSequence)getContext().getResources().getString(e.h.finder_set_news_feed_desc));
    Object localObject = bb.m(getContext(), e.g.icons_outlined_like, com.tencent.mm.cd.a.w(getContext(), e.b.FG_2));
    paramAttributeSet = bb.m(getContext(), e.g.icons_outlined_fire, com.tencent.mm.cd.a.w(getContext(), e.b.FG_2));
    ((Drawable)localObject).setBounds(0, 0, i, i);
    paramAttributeSet.setBounds(0, 0, i, i);
    localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
    paramAttributeSet = new com.tencent.mm.ui.widget.a(paramAttributeSet, 1);
    i = n.a((CharSequence)paramContext, this.Gxn, 0, false, 6);
    int j = n.a((CharSequence)paramContext, this.Gxo, 0, false, 6);
    paramContext.setSpan(localObject, i, i + 1, 34);
    paramContext.setSpan(paramAttributeSet, j, j + 1, 34);
    getDescText().setText((CharSequence)paramContext);
    AppMethodBeat.o(344425);
  }
  
  public FinderChooseNewsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344436);
    this.Fdh = k.cm((kotlin.g.a.a)new a(this));
    this.Gxm = k.cm((kotlin.g.a.a)new b(this));
    this.Gxn = ' ';
    this.Gxo = ' ';
    af.mU(getContext()).inflate(e.f.finder_post_choose_news_feed_layout, (ViewGroup)this, true);
    paramInt = getContext().getResources().getDimensionPixelSize(e.c.Edge_2A);
    paramContext = new SpannableString((CharSequence)getContext().getResources().getString(e.h.finder_set_news_feed_desc));
    Object localObject = bb.m(getContext(), e.g.icons_outlined_like, com.tencent.mm.cd.a.w(getContext(), e.b.FG_2));
    paramAttributeSet = bb.m(getContext(), e.g.icons_outlined_fire, com.tencent.mm.cd.a.w(getContext(), e.b.FG_2));
    ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
    paramAttributeSet.setBounds(0, 0, paramInt, paramInt);
    localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
    paramAttributeSet = new com.tencent.mm.ui.widget.a(paramAttributeSet, 1);
    paramInt = n.a((CharSequence)paramContext, this.Gxn, 0, false, 6);
    int i = n.a((CharSequence)paramContext, this.Gxo, 0, false, 6);
    paramContext.setSpan(localObject, paramInt, paramInt + 1, 34);
    paramContext.setSpan(paramAttributeSet, i, i + 1, 34);
    getDescText().setText((CharSequence)paramContext);
    AppMethodBeat.o(344436);
  }
  
  private final TextView getDescText()
  {
    AppMethodBeat.i(344444);
    TextView localTextView = (TextView)this.Gxm.getValue();
    AppMethodBeat.o(344444);
    return localTextView;
  }
  
  public final CheckBox getCheckBox()
  {
    AppMethodBeat.i(344453);
    CheckBox localCheckBox = (CheckBox)this.Fdh.getValue();
    AppMethodBeat.o(344453);
    return localCheckBox;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<CheckBox>
  {
    a(FinderChooseNewsView paramFinderChooseNewsView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<TextView>
  {
    b(FinderChooseNewsView paramFinderChooseNewsView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderChooseNewsView
 * JD-Core Version:    0.7.0.1
 */