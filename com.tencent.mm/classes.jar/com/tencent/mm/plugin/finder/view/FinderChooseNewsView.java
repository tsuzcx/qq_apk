package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.au;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "descText", "Landroid/widget/TextView;", "getDescText", "()Landroid/widget/TextView;", "descText$delegate", "fireChar", "", "likeChar", "isChecked", "", "scaleImage", "Landroid/graphics/drawable/Drawable;", "image", "width", "height", "plugin-finder_release"})
public final class FinderChooseNewsView
  extends RelativeLayout
{
  private final f AUL;
  private final char AUM;
  private final char AUN;
  private HashMap _$_findViewCache;
  private final f xSE;
  
  public FinderChooseNewsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(288620);
    this.xSE = g.ar((kotlin.g.a.a)new a(this));
    this.AUL = g.ar((kotlin.g.a.a)new b(this));
    this.AUM = ' ';
    this.AUN = ' ';
    ad.kS(getContext()).inflate(b.g.finder_post_choose_news_feed_layout, (ViewGroup)this, true);
    paramContext = getContext();
    p.j(paramContext, "context");
    int i = paramContext.getResources().getDimensionPixelSize(b.d.Edge_2A);
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = new SpannableString((CharSequence)paramContext.getResources().getString(b.j.finder_set_news_feed_desc));
    Object localObject = au.o(getContext(), b.i.icons_outlined_like, com.tencent.mm.ci.a.w(getContext(), b.c.FG_2));
    paramAttributeSet = au.o(getContext(), b.i.icons_outlined_fire, com.tencent.mm.ci.a.w(getContext(), b.c.FG_2));
    ((Drawable)localObject).setBounds(0, 0, i, i);
    paramAttributeSet.setBounds(0, 0, i, i);
    localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
    paramAttributeSet = new com.tencent.mm.ui.widget.a(paramAttributeSet, 1);
    i = n.a((CharSequence)paramContext, this.AUM, 0, false, 6);
    int j = n.a((CharSequence)paramContext, this.AUN, 0, false, 6);
    paramContext.setSpan(localObject, i, i + 1, 34);
    paramContext.setSpan(paramAttributeSet, j, j + 1, 34);
    paramAttributeSet = getDescText();
    p.j(paramAttributeSet, "descText");
    paramAttributeSet.setText((CharSequence)paramContext);
    AppMethodBeat.o(288620);
  }
  
  public FinderChooseNewsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(288621);
    this.xSE = g.ar((kotlin.g.a.a)new a(this));
    this.AUL = g.ar((kotlin.g.a.a)new b(this));
    this.AUM = ' ';
    this.AUN = ' ';
    ad.kS(getContext()).inflate(b.g.finder_post_choose_news_feed_layout, (ViewGroup)this, true);
    paramContext = getContext();
    p.j(paramContext, "context");
    paramInt = paramContext.getResources().getDimensionPixelSize(b.d.Edge_2A);
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = new SpannableString((CharSequence)paramContext.getResources().getString(b.j.finder_set_news_feed_desc));
    Object localObject = au.o(getContext(), b.i.icons_outlined_like, com.tencent.mm.ci.a.w(getContext(), b.c.FG_2));
    paramAttributeSet = au.o(getContext(), b.i.icons_outlined_fire, com.tencent.mm.ci.a.w(getContext(), b.c.FG_2));
    ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
    paramAttributeSet.setBounds(0, 0, paramInt, paramInt);
    localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
    paramAttributeSet = new com.tencent.mm.ui.widget.a(paramAttributeSet, 1);
    paramInt = n.a((CharSequence)paramContext, this.AUM, 0, false, 6);
    int i = n.a((CharSequence)paramContext, this.AUN, 0, false, 6);
    paramContext.setSpan(localObject, paramInt, paramInt + 1, 34);
    paramContext.setSpan(paramAttributeSet, i, i + 1, 34);
    paramAttributeSet = getDescText();
    p.j(paramAttributeSet, "descText");
    paramAttributeSet.setText((CharSequence)paramContext);
    AppMethodBeat.o(288621);
  }
  
  private final CheckBox getCheckBox()
  {
    AppMethodBeat.i(288617);
    CheckBox localCheckBox = (CheckBox)this.xSE.getValue();
    AppMethodBeat.o(288617);
    return localCheckBox;
  }
  
  private final TextView getDescText()
  {
    AppMethodBeat.i(288618);
    TextView localTextView = (TextView)this.AUL.getValue();
    AppMethodBeat.o(288618);
    return localTextView;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(288622);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(288622);
    return localView1;
  }
  
  public final boolean isChecked()
  {
    AppMethodBeat.i(288619);
    CheckBox localCheckBox = getCheckBox();
    p.j(localCheckBox, "checkBox");
    boolean bool = localCheckBox.isChecked();
    AppMethodBeat.o(288619);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<CheckBox>
  {
    a(FinderChooseNewsView paramFinderChooseNewsView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
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