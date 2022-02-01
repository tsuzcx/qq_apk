package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubTagWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "clickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "hideTagTask", "Ljava/lang/Runnable;", "isAnchor", "", "()Z", "setAnchor", "(Z)V", "tagTv", "Landroid/widget/TextView;", "getTagTv", "()Landroid/widget/TextView;", "setTagTv", "(Landroid/widget/TextView;)V", "init", "isFolded", "showTag", "tag", "", "haveShowTag", "updateTag", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFansClubTagWidget
  extends FrameLayout
{
  public static final FinderLiveFansClubTagWidget.a Epl;
  private kotlin.g.a.b<? super View, ah> Epm;
  private final Runnable Epn;
  private boolean hKC;
  public TextView rpu;
  
  static
  {
    AppMethodBeat.i(362222);
    Epl = new FinderLiveFansClubTagWidget.a((byte)0);
    AppMethodBeat.o(362222);
  }
  
  public FinderLiveFansClubTagWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(362187);
    this.Epn = new FinderLiveFansClubTagWidget..ExternalSyntheticLambda2(this);
    LayoutInflater.from(getContext()).inflate(p.f.CdC, (ViewGroup)this, true);
    paramContext = findViewById(p.e.BDM);
    s.s(paramContext, "findViewById(R.id.fans_name)");
    setTagTv((TextView)paramContext);
    getTagTv().setTextSize(1, 12.0F);
    com.tencent.mm.ui.aw.a((Paint)getTagTv().getPaint(), 0.8F);
    setOnClickListener(new FinderLiveFansClubTagWidget..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(362187);
  }
  
  private static final void a(FinderLiveFansClubTagWidget paramFinderLiveFansClubTagWidget)
  {
    AppMethodBeat.i(362204);
    s.u(paramFinderLiveFansClubTagWidget, "this$0");
    Rect localRect = new Rect();
    paramFinderLiveFansClubTagWidget.getHitRect(localRect);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    localRect.inset(-i, -i);
    ViewParent localViewParent = paramFinderLiveFansClubTagWidget.getParent();
    if (localViewParent == null)
    {
      paramFinderLiveFansClubTagWidget = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(362204);
      throw paramFinderLiveFansClubTagWidget;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, (View)paramFinderLiveFansClubTagWidget));
    AppMethodBeat.o(362204);
  }
  
  private static final void a(FinderLiveFansClubTagWidget paramFinderLiveFansClubTagWidget, View paramView)
  {
    AppMethodBeat.i(362197);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveFansClubTagWidget);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubTagWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveFansClubTagWidget, "this$0");
    paramFinderLiveFansClubTagWidget = paramFinderLiveFansClubTagWidget.getClickListener();
    if (paramFinderLiveFansClubTagWidget != null)
    {
      s.s(paramView, "it");
      paramFinderLiveFansClubTagWidget.invoke(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubTagWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362197);
  }
  
  private static final void b(FinderLiveFansClubTagWidget paramFinderLiveFansClubTagWidget)
  {
    AppMethodBeat.i(362213);
    s.u(paramFinderLiveFansClubTagWidget, "this$0");
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    com.tencent.mm.plugin.finder.utils.aw.a((View)paramFinderLiveFansClubTagWidget.getTagTv(), paramFinderLiveFansClubTagWidget.getTagTv().getMeasuredWidth(), 0, 0L, (kotlin.g.a.a)new b(paramFinderLiveFansClubTagWidget), 8);
    paramFinderLiveFansClubTagWidget.getTagTv().setTag(null);
    Log.i("FinderLiveFansClubTagWidget", "showTag reset tag!");
    paramFinderLiveFansClubTagWidget.post(new FinderLiveFansClubTagWidget..ExternalSyntheticLambda1(paramFinderLiveFansClubTagWidget));
    AppMethodBeat.o(362213);
  }
  
  public final void ayz(String paramString)
  {
    AppMethodBeat.i(362297);
    s.u(paramString, "tag");
    getTagTv().setText((CharSequence)paramString);
    AppMethodBeat.o(362297);
  }
  
  public final boolean eAI()
  {
    AppMethodBeat.i(362304);
    if (getTagTv().getVisibility() == 8)
    {
      AppMethodBeat.o(362304);
      return true;
    }
    AppMethodBeat.o(362304);
    return false;
  }
  
  public final void f(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(362287);
    s.u(paramString, "tag");
    this.hKC = paramBoolean1;
    getTagTv().setText((CharSequence)paramString);
    if (paramBoolean2)
    {
      Log.i("FinderLiveFansClubTagWidget", "showTag haveShowTag tag:" + getTagTv().getTag() + '!');
      if (!s.p(getTagTv().getTag(), Boolean.TRUE))
      {
        getTagTv().setVisibility(8);
        AppMethodBeat.o(362287);
      }
    }
    else if (!paramBoolean1)
    {
      getTagTv().postDelayed(this.Epn, 5000L);
      getTagTv().setTag(Boolean.TRUE);
      Log.i("FinderLiveFansClubTagWidget", "showTag set tag!");
    }
    AppMethodBeat.o(362287);
  }
  
  public final kotlin.g.a.b<View, ah> getClickListener()
  {
    return this.Epm;
  }
  
  public final TextView getTagTv()
  {
    AppMethodBeat.i(362250);
    TextView localTextView = this.rpu;
    if (localTextView != null)
    {
      AppMethodBeat.o(362250);
      return localTextView;
    }
    s.bIx("tagTv");
    AppMethodBeat.o(362250);
    return null;
  }
  
  public final void setAnchor(boolean paramBoolean)
  {
    this.hKC = paramBoolean;
  }
  
  public final void setClickListener(kotlin.g.a.b<? super View, ah> paramb)
  {
    this.Epm = paramb;
  }
  
  public final void setTagTv(TextView paramTextView)
  {
    AppMethodBeat.i(362260);
    s.u(paramTextView, "<set-?>");
    this.rpu = paramTextView;
    AppMethodBeat.o(362260);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderLiveFansClubTagWidget paramFinderLiveFansClubTagWidget)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveFansClubTagWidget
 * JD-Core Version:    0.7.0.1
 */