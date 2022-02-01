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
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "descText", "Landroid/widget/TextView;", "getDescText", "()Landroid/widget/TextView;", "descText$delegate", "fireChar", "", "likeChar", "isChecked", "", "scaleImage", "Landroid/graphics/drawable/Drawable;", "image", "width", "height", "plugin-finder_release"})
public final class FinderChooseNewsView
  extends RelativeLayout
{
  private HashMap _$_findViewCache;
  private final f vaQ;
  private final f wjR;
  private final char wjS;
  private final char wjT;
  
  public FinderChooseNewsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254677);
    this.vaQ = g.ah((kotlin.g.a.a)new a(this));
    this.wjR = g.ah((kotlin.g.a.a)new b(this));
    this.wjS = ' ';
    this.wjT = ' ';
    aa.jQ(getContext()).inflate(2131494566, (ViewGroup)this, true);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = paramContext.getResources().getDimensionPixelSize(2131165296);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new SpannableString((CharSequence)paramContext.getResources().getString(2131760548));
    Object localObject = ar.m(getContext(), 2131690822, com.tencent.mm.cb.a.n(getContext(), 2131099749));
    paramAttributeSet = ar.m(getContext(), 2131690803, com.tencent.mm.cb.a.n(getContext(), 2131099749));
    ((Drawable)localObject).setBounds(0, 0, i, i);
    paramAttributeSet.setBounds(0, 0, i, i);
    localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    paramAttributeSet = new com.tencent.mm.ui.widget.a(paramAttributeSet);
    i = n.a((CharSequence)paramContext, this.wjS, 0, false, 6);
    int j = n.a((CharSequence)paramContext, this.wjT, 0, false, 6);
    paramContext.setSpan(localObject, i, i + 1, 34);
    paramContext.setSpan(paramAttributeSet, j, j + 1, 34);
    paramAttributeSet = getDescText();
    p.g(paramAttributeSet, "descText");
    paramAttributeSet.setText((CharSequence)paramContext);
    AppMethodBeat.o(254677);
  }
  
  public FinderChooseNewsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254678);
    this.vaQ = g.ah((kotlin.g.a.a)new a(this));
    this.wjR = g.ah((kotlin.g.a.a)new b(this));
    this.wjS = ' ';
    this.wjT = ' ';
    aa.jQ(getContext()).inflate(2131494566, (ViewGroup)this, true);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramInt = paramContext.getResources().getDimensionPixelSize(2131165296);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new SpannableString((CharSequence)paramContext.getResources().getString(2131760548));
    Object localObject = ar.m(getContext(), 2131690822, com.tencent.mm.cb.a.n(getContext(), 2131099749));
    paramAttributeSet = ar.m(getContext(), 2131690803, com.tencent.mm.cb.a.n(getContext(), 2131099749));
    ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
    paramAttributeSet.setBounds(0, 0, paramInt, paramInt);
    localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
    paramAttributeSet = new com.tencent.mm.ui.widget.a(paramAttributeSet);
    paramInt = n.a((CharSequence)paramContext, this.wjS, 0, false, 6);
    int i = n.a((CharSequence)paramContext, this.wjT, 0, false, 6);
    paramContext.setSpan(localObject, paramInt, paramInt + 1, 34);
    paramContext.setSpan(paramAttributeSet, i, i + 1, 34);
    paramAttributeSet = getDescText();
    p.g(paramAttributeSet, "descText");
    paramAttributeSet.setText((CharSequence)paramContext);
    AppMethodBeat.o(254678);
  }
  
  private final CheckBox getCheckBox()
  {
    AppMethodBeat.i(254674);
    CheckBox localCheckBox = (CheckBox)this.vaQ.getValue();
    AppMethodBeat.o(254674);
    return localCheckBox;
  }
  
  private final TextView getDescText()
  {
    AppMethodBeat.i(254675);
    TextView localTextView = (TextView)this.wjR.getValue();
    AppMethodBeat.o(254675);
    return localTextView;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(254679);
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
    AppMethodBeat.o(254679);
    return localView1;
  }
  
  public final boolean isChecked()
  {
    AppMethodBeat.i(254676);
    CheckBox localCheckBox = getCheckBox();
    p.g(localCheckBox, "checkBox");
    boolean bool = localCheckBox.isChecked();
    AppMethodBeat.o(254676);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<CheckBox>
  {
    a(FinderChooseNewsView paramFinderChooseNewsView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
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