package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeBtnCallBack", "Lkotlin/Function0;", "", "getCloseBtnCallBack", "()Lkotlin/jvm/functions/Function0;", "setCloseBtnCallBack", "(Lkotlin/jvm/functions/Function0;)V", "prepareViews", "setCloseIconResId", "resId", "setTitle", "title", "", "showHelpIcon", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchHeadComponent
  extends RelativeLayout
{
  public static final a Ect;
  private a<x> Ecs;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(252230);
    Ect = new a((byte)0);
    AppMethodBeat.o(252230);
  }
  
  public KidsWatchHeadComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(252228);
    AppMethodBeat.o(252228);
  }
  
  public KidsWatchHeadComponent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(252227);
    setNestedScrollingEnabled(true);
    View.inflate(paramContext, b.f.Ebg, (ViewGroup)this);
    paramContext = (TextView)_$_findCachedViewById(b.e.dXx);
    p.j(paramContext, "titleTV");
    paramContext.setVisibility(4);
    paramContext = (WeImageView)_$_findCachedViewById(b.e.EaH);
    p.j(paramContext, "helpIcon");
    paramContext.setVisibility(4);
    paramContext = (WeImageView)_$_findCachedViewById(b.e.EaA);
    p.j(paramContext, "closeBtn");
    paramContext.setBackground(getContext().getDrawable(b.g.icons_outlined_close));
    ((WeImageView)_$_findCachedViewById(b.e.EaA)).setOnClickListener((View.OnClickListener)new KidsWatchHeadComponent.b(this));
    ((WeImageView)_$_findCachedViewById(b.e.EaH)).setOnClickListener((View.OnClickListener)new KidsWatchHeadComponent.c(this));
    AppMethodBeat.o(252227);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252231);
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
    AppMethodBeat.o(252231);
    return localView1;
  }
  
  public final void eKU()
  {
    AppMethodBeat.i(252225);
    WeImageView localWeImageView = (WeImageView)_$_findCachedViewById(b.e.EaH);
    p.j(localWeImageView, "helpIcon");
    localWeImageView.setVisibility(0);
    AppMethodBeat.o(252225);
  }
  
  public final a<x> getCloseBtnCallBack()
  {
    return this.Ecs;
  }
  
  public final void setCloseBtnCallBack(a<x> parama)
  {
    this.Ecs = parama;
  }
  
  public final void setCloseIconResId(int paramInt)
  {
    AppMethodBeat.i(252224);
    WeImageView localWeImageView = (WeImageView)_$_findCachedViewById(b.e.EaA);
    p.j(localWeImageView, "closeBtn");
    localWeImageView.setBackground(getContext().getDrawable(paramInt));
    AppMethodBeat.o(252224);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(252222);
    p.k(paramString, "title");
    TextView localTextView = (TextView)_$_findCachedViewById(b.e.dXx);
    p.j(localTextView, "titleTV");
    localTextView.setText((CharSequence)paramString);
    paramString = (TextView)_$_findCachedViewById(b.e.dXx);
    p.j(paramString, "titleTV");
    paramString.setVisibility(0);
    AppMethodBeat.o(252222);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent
 * JD-Core Version:    0.7.0.1
 */