package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFoldTextView;", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "foldListener", "Lkotlin/Function0;", "", "getFoldListener", "()Lkotlin/jvm/functions/Function0;", "setFoldListener", "(Lkotlin/jvm/functions/Function0;)V", "foldingMaxLines", "", "foldingTextSSB", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "fullTextSSB", "isFolding", "", "()Z", "setFolding", "(Z)V", "unFoldListener", "getUnFoldListener", "setUnFoldListener", "fold", "foldInternal", "makeCanFoldFullText", "fullText", "", "makeSpanDelegate", "Lkotlin/Function1;", "makeFoldingText", "clipText", "Landroid/text/SpannableStringBuilder;", "setFoldText", "originalText", "foldingMaxLinesNum", "maxContentWidth", "initIsFolding", "unFoldInternal", "unfold", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFoldTextView
  extends MMNeat7extView
{
  private static final FinderLiveFoldTextView.a DNb;
  @Deprecated
  private static final String DNi;
  @Deprecated
  private static final String DNj;
  public boolean DNc;
  kotlin.g.a.a<ah> DNd;
  kotlin.g.a.a<ah> DNe;
  private q DNf;
  private q DNg;
  private int DNh;
  
  static
  {
    AppMethodBeat.i(358156);
    DNb = new FinderLiveFoldTextView.a((byte)0);
    DNi = kotlin.g.b.s.X(" ", MMApplicationContext.getContext().getResources().getString(p.h.Ctm));
    DNj = kotlin.g.b.s.X(" ", MMApplicationContext.getContext().getResources().getString(p.h.Ckp));
    AppMethodBeat.o(358156);
  }
  
  public FinderLiveFoldTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(358129);
    this.DNc = true;
    this.DNf = new q();
    this.DNg = new q();
    this.DNh = 5;
    AppMethodBeat.o(358129);
  }
  
  private final void a(SpannableStringBuilder paramSpannableStringBuilder, b<? super CharSequence, ? extends q> paramb)
  {
    AppMethodBeat.i(358151);
    if (paramb == null) {}
    for (paramb = null;; paramb = (q)paramb.invoke(paramSpannableStringBuilder))
    {
      Object localObject = paramb;
      if (paramb == null) {
        localObject = new q((Spannable)paramSpannableStringBuilder);
      }
      this.DNf = ((q)localObject);
      if (this.DNf.length() - DNi.length() >= 0) {
        break;
      }
      AppMethodBeat.o(358151);
      return;
    }
    this.DNf.setSpan(new c(this), this.DNf.length() - DNi.length(), this.DNf.length(), 17);
    AppMethodBeat.o(358151);
  }
  
  private final void a(CharSequence paramCharSequence, b<? super CharSequence, ? extends q> paramb)
  {
    AppMethodBeat.i(358138);
    if (paramb == null) {}
    for (paramb = null;; paramb = (q)paramb.invoke(paramCharSequence + DNj))
    {
      Object localObject = paramb;
      if (paramb == null) {
        localObject = new q(paramCharSequence + DNj);
      }
      this.DNg = ((q)localObject);
      if (this.DNg.length() - DNj.length() >= 0) {
        break;
      }
      AppMethodBeat.o(358138);
      return;
    }
    this.DNg.setSpan(new b(this), this.DNg.length() - DNj.length(), this.DNg.length(), 17);
    AppMethodBeat.o(358138);
  }
  
  public final void a(final CharSequence paramCharSequence, int paramInt, boolean paramBoolean, final b<? super CharSequence, ? extends q> paramb)
  {
    AppMethodBeat.i(358187);
    kotlin.g.b.s.u(paramCharSequence, "originalText");
    kotlin.g.a.a locala = (kotlin.g.a.a)new d(this, paramb, paramCharSequence);
    if (this.DNh <= 0)
    {
      locala.invoke();
      AppMethodBeat.o(358187);
      return;
    }
    int i = paramInt - getPaddingLeft() - getPaddingRight();
    setMaxWidth(i);
    this.DNh = 5;
    MMNeat7extView localMMNeat7extView = new MMNeat7extView(MMApplicationContext.getContext());
    localMMNeat7extView.aZ(paramCharSequence);
    Object localObject = localMMNeat7extView.pE(i, 2147483647);
    if (((com.tencent.neattextview.textview.layout.a)localObject).jQH() > this.DNh) {}
    for (paramInt = 1;; paramInt = 0)
    {
      Log.v("Finder.FinderLiveFoldTextView", "layout.lineCount: " + ((com.tencent.neattextview.textview.layout.a)localObject).jQH() + " contentWidth:" + i + " foldingMaxLines:" + this.DNh);
      if (paramInt != 0) {
        break;
      }
      locala.invoke();
      AppMethodBeat.o(358187);
      return;
    }
    localObject = paramCharSequence.subSequence(0, ((com.tencent.neattextview.textview.layout.a)localObject).H(this.DNh - 1, 100000.0F));
    paramInt = 0;
    for (;;)
    {
      if (((CharSequence)localObject).length() > paramInt)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)((CharSequence)localObject).subSequence(0, ((CharSequence)localObject).length() - paramInt).toString());
        localSpannableStringBuilder.append((CharSequence)DNi);
        localMMNeat7extView.aZ((CharSequence)localSpannableStringBuilder);
        if (localMMNeat7extView.pE(i, 2147483647).jQH() > this.DNh) {
          break label396;
        }
        setNeatEnable(false);
        a(localSpannableStringBuilder, paramb);
        a(paramCharSequence, paramb);
        setOnTouchListener((View.OnTouchListener)new l((NeatTextView)this, (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s(getContext())));
        if (!paramBoolean) {
          break label389;
        }
        evn();
      }
      for (;;)
      {
        if (((CharSequence)localObject).length() == paramInt) {
          locala.invoke();
        }
        AppMethodBeat.o(358187);
        return;
        label389:
        evo();
      }
      label396:
      paramInt += 1;
    }
  }
  
  final void evn()
  {
    AppMethodBeat.i(358192);
    setMaxLines(this.DNh);
    aZ((CharSequence)this.DNf);
    this.DNc = true;
    setScrollY(0);
    AppMethodBeat.o(358192);
  }
  
  final void evo()
  {
    AppMethodBeat.i(358196);
    setMaxLines(88);
    aZ((CharSequence)this.DNg);
    this.DNc = false;
    AppMethodBeat.o(358196);
  }
  
  public final kotlin.g.a.a<ah> getFoldListener()
  {
    return this.DNe;
  }
  
  public final kotlin.g.a.a<ah> getUnFoldListener()
  {
    return this.DNd;
  }
  
  public final void setFoldListener(kotlin.g.a.a<ah> parama)
  {
    this.DNe = parama;
  }
  
  public final void setFolding(boolean paramBoolean)
  {
    this.DNc = paramBoolean;
  }
  
  public final void setUnFoldListener(kotlin.g.a.a<ah> parama)
  {
    this.DNd = parama;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveFoldTextView$makeCanFoldFullText$2$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ClickableSpan
  {
    b(FinderLiveFoldTextView paramFinderLiveFoldTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(357610);
      kotlin.g.b.s.u(paramView, "widget");
      paramView = this.DNk;
      paramView.evn();
      paramView = paramView.DNe;
      if (paramView != null) {
        paramView.invoke();
      }
      AppMethodBeat.o(357610);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(357616);
      kotlin.g.b.s.u(paramTextPaint, "ds");
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.setColor(this.DNk.getContext().getResources().getColor(p.b.ByZ));
      AppMethodBeat.o(357616);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveFoldTextView$makeFoldingText$2$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ClickableSpan
  {
    c(FinderLiveFoldTextView paramFinderLiveFoldTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(357613);
      kotlin.g.b.s.u(paramView, "widget");
      paramView = this.DNk;
      paramView.evo();
      paramView = paramView.DNd;
      if (paramView != null) {
        paramView.invoke();
      }
      AppMethodBeat.o(357613);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(357617);
      kotlin.g.b.s.u(paramTextPaint, "ds");
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.setColor(this.DNk.getContext().getResources().getColor(p.b.ByZ));
      AppMethodBeat.o(357617);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(FinderLiveFoldTextView paramFinderLiveFoldTextView, b<? super CharSequence, ? extends q> paramb, CharSequence paramCharSequence)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveFoldTextView
 * JD-Core Version:    0.7.0.1
 */