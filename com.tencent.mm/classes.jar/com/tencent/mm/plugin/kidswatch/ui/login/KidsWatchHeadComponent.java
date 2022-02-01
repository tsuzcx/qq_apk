package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeBtnCallBack", "Lkotlin/Function0;", "", "getCloseBtnCallBack", "()Lkotlin/jvm/functions/Function0;", "setCloseBtnCallBack", "(Lkotlin/jvm/functions/Function0;)V", "prepareViews", "setCloseIconResId", "resId", "setTitle", "title", "", "showHelpIcon", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchHeadComponent
  extends RelativeLayout
{
  public static final a yBe;
  private HashMap _$_findViewCache;
  private kotlin.g.a.a<x> yBd;
  
  static
  {
    AppMethodBeat.i(256227);
    yBe = new a((byte)0);
    AppMethodBeat.o(256227);
  }
  
  public KidsWatchHeadComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(256226);
    AppMethodBeat.o(256226);
  }
  
  public KidsWatchHeadComponent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(256225);
    setNestedScrollingEnabled(true);
    View.inflate(paramContext, 2131495130, (ViewGroup)this);
    paramContext = (TextView)_$_findCachedViewById(2131309198);
    p.g(paramContext, "titleTV");
    paramContext.setVisibility(4);
    paramContext = (WeImageView)_$_findCachedViewById(2131302320);
    p.g(paramContext, "helpIcon");
    paramContext.setVisibility(4);
    paramContext = (WeImageView)_$_findCachedViewById(2131298764);
    p.g(paramContext, "closeBtn");
    paramContext.setBackground(getContext().getDrawable(2131690761));
    ((WeImageView)_$_findCachedViewById(2131298764)).setOnClickListener((View.OnClickListener)new b(this));
    ((WeImageView)_$_findCachedViewById(2131302320)).setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(256225);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256228);
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
    AppMethodBeat.o(256228);
    return localView1;
  }
  
  public final void ebW()
  {
    AppMethodBeat.i(256224);
    WeImageView localWeImageView = (WeImageView)_$_findCachedViewById(2131302320);
    p.g(localWeImageView, "helpIcon");
    localWeImageView.setVisibility(0);
    AppMethodBeat.o(256224);
  }
  
  public final kotlin.g.a.a<x> getCloseBtnCallBack()
  {
    return this.yBd;
  }
  
  public final void setCloseBtnCallBack(kotlin.g.a.a<x> parama)
  {
    this.yBd = parama;
  }
  
  public final void setCloseIconResId(int paramInt)
  {
    AppMethodBeat.i(256223);
    WeImageView localWeImageView = (WeImageView)_$_findCachedViewById(2131298764);
    p.g(localWeImageView, "closeBtn");
    localWeImageView.setBackground(getContext().getDrawable(paramInt));
    AppMethodBeat.o(256223);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(256222);
    p.h(paramString, "title");
    TextView localTextView = (TextView)_$_findCachedViewById(2131309198);
    p.g(localTextView, "titleTV");
    localTextView.setText((CharSequence)paramString);
    paramString = (TextView)_$_findCachedViewById(2131309198);
    p.g(paramString, "titleTV");
    paramString.setVisibility(0);
    AppMethodBeat.o(256222);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$Companion;", "", "()V", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(KidsWatchHeadComponent paramKidsWatchHeadComponent) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256220);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.d("KidsWatchHeadComponent", "close clicked");
      paramView = this.yBf.getCloseBtnCallBack();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256220);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(KidsWatchHeadComponent paramKidsWatchHeadComponent) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256221);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("KidsWatchHeadComponent", "click help icon");
      paramView = com.tencent.mm.plugin.kidswatch.b.a.yBL;
      paramView = this.yBf.getContext();
      p.g(paramView, "context");
      com.tencent.mm.plugin.kidswatch.b.a.f(paramView, "wxaaff6b96fc2cd3c6", "pages/help/help.html", "1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent
 * JD-Core Version:    0.7.0.1
 */