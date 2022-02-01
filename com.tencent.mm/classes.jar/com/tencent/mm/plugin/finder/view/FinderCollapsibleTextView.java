package com.tencent.mm.plugin.finder.view;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.k.j;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapseTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCollapseTextView", "()Landroid/widget/TextView;", "collapseTextView$delegate", "Lkotlin/Lazy;", "collapseTextViewRight", "", "getCollapseTextViewRight", "()F", "setCollapseTextViewRight", "(F)V", "collapseTextWidth", "contentTextView", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTextView", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "contentTextView$delegate", "expanText", "getExpanText", "()I", "setExpanText", "(I)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "value", "", "isCollapse", "()Z", "setCollapse", "(Z)V", "isTopicExpand", "setTopicExpand", "limitLine", "getLimitLine", "setLimitLine", "onCollapse", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function1;", "setOnCollapse", "(Lkotlin/jvm/functions/Function1;)V", "realContent", "", "getRealContent", "()Ljava/lang/CharSequence;", "setRealContent", "(Ljava/lang/CharSequence;)V", "text", "getText", "setText", "textColor", "getTextColor", "setTextColor", "_setText", "content", "callBack", "backToDefaultLogic", "source", "", "checkCollapseVisible", "checkCollapseVisibleSync", "checkIfAllRestTextTopic", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enableContentTextViewClick", "enable", "onClickFun", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshCollapseText", "tryExpand", "Companion", "plugin-finder_release"})
@SuppressLint({"ClickableViewAccessibility"})
public final class FinderCollapsibleTextView
  extends RelativeLayout
{
  public static final FinderCollapsibleTextView.a wkj;
  private CharSequence text;
  private final f wjY;
  private final f wjZ;
  private float wka;
  private int wkb;
  private View wkc;
  boolean wkd;
  boolean wke;
  private float wkf;
  private kotlin.g.a.b<? super Boolean, x> wkg;
  private int wkh;
  private CharSequence wki;
  
  static
  {
    AppMethodBeat.i(168229);
    wkj = new FinderCollapsibleTextView.a((byte)0);
    AppMethodBeat.o(168229);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168241);
    this.wjY = g.ah((kotlin.g.a.a)new e(this));
    this.wjZ = g.ah((kotlin.g.a.a)new d(this));
    this.wkb = 2131759536;
    aa.jQ(getContext()).inflate(2131494217, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(2131165277));
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    getCollapseTextView().setLineSpacing(getResources().getDimension(2131165277), 1.0F);
    getContentTextView().setOnTouchListener((View.OnTouchListener)new h(getContentTextView(), (View.OnTouchListener)new o()));
    oV(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FinderCollapsibleTextView.c(this.wkk);
        paramAnonymousView = k.vfA;
        paramAnonymousView = this.wkk.getContext();
        p.g(paramAnonymousView, "context");
        k.a(paramAnonymousView, false, 1, this.wkk.wke, this.wkk.wkd);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168223);
      }
    });
    this.wke = true;
    this.wkh = 3;
    AppMethodBeat.o(168241);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168242);
    this.wjY = g.ah((kotlin.g.a.a)new e(this));
    this.wjZ = g.ah((kotlin.g.a.a)new d(this));
    this.wkb = 2131759536;
    aa.jQ(getContext()).inflate(2131494217, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(2131165277));
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    getCollapseTextView().setLineSpacing(getResources().getDimension(2131165277), 1.0F);
    getContentTextView().setOnTouchListener((View.OnTouchListener)new h(getContentTextView(), (View.OnTouchListener)new o()));
    oV(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FinderCollapsibleTextView.c(this.wkk);
        paramAnonymousView = k.vfA;
        paramAnonymousView = this.wkk.getContext();
        p.g(paramAnonymousView, "context");
        k.a(paramAnonymousView, false, 1, this.wkk.wke, this.wkk.wkd);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168223);
      }
    });
    this.wke = true;
    this.wkh = 3;
    AppMethodBeat.o(168242);
  }
  
  private final void dGn()
  {
    AppMethodBeat.i(254699);
    if (!this.wke) {}
    for (boolean bool = true;; bool = false)
    {
      setCollapse(bool);
      if (!this.wke)
      {
        localObject = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        FinderHomeTabStateVM.dHS();
      }
      oU(this.wke);
      Object localObject = this.wkg;
      if (localObject == null) {
        break;
      }
      ((kotlin.g.a.b)localObject).invoke(Boolean.valueOf(this.wke));
      AppMethodBeat.o(254699);
      return;
    }
    AppMethodBeat.o(254699);
  }
  
  private final void dGo()
  {
    AppMethodBeat.i(254701);
    CharSequence localCharSequence = this.text;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(254701);
      return;
    }
    localCharSequence = this.text;
    if (localCharSequence != null)
    {
      post((Runnable)new c(localCharSequence, this));
      AppMethodBeat.o(254701);
      return;
    }
    AppMethodBeat.o(254701);
  }
  
  private boolean dGp()
  {
    AppMethodBeat.i(168240);
    Object localObject = getContentTextView();
    p.g(localObject, "contentTextView");
    localObject = ((NeatTextView)localObject).getLayout();
    for (;;)
    {
      try
      {
        i = this.wkh;
        p.g(localObject, "layout");
        i = j.na(i, ((com.tencent.neattextview.textview.layout.a)localObject).hiG()) - 1;
        if (i < 0) {
          continue;
        }
        i = ((com.tencent.neattextview.textview.layout.a)localObject).getOffsetForHorizontal(i, 10000.0F);
      }
      catch (Exception localException)
      {
        TextView localTextView;
        int j;
        if (!BuildInfo.DEBUG) {
          continue;
        }
        localObject = (Throwable)localException;
        AppMethodBeat.o(168240);
        throw ((Throwable)localObject);
        int i = 0;
        continue;
        localObject = getCollapseTextView();
        p.g(localObject, "collapseTextView");
        ((TextView)localObject).setVisibility(8);
        continue;
        AppMethodBeat.o(168240);
      }
      localTextView = getCollapseTextView();
      p.g(localTextView, "collapseTextView");
      j = localTextView.getVisibility();
      if ((localObject == null) || (i <= 0) || (i >= getContentTextView().hiT().length())) {
        continue;
      }
      localObject = getCollapseTextView();
      p.g(localObject, "collapseTextView");
      ((TextView)localObject).setVisibility(0);
      localObject = getCollapseTextView();
      p.g(localObject, "collapseTextView");
      if (j == ((TextView)localObject).getVisibility()) {
        continue;
      }
      AppMethodBeat.o(168240);
      return true;
      i = 0;
    }
    return false;
  }
  
  private final void oU(boolean paramBoolean)
  {
    AppMethodBeat.i(254700);
    Object localObject1 = getCollapseTextView();
    p.g(localObject1, "collapseTextView");
    if (((TextView)localObject1).getVisibility() == 0)
    {
      if (paramBoolean)
      {
        localObject1 = getCollapseTextView();
        p.g(localObject1, "collapseTextView");
        localObject1 = ((TextView)localObject1).getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(254700);
          throw ((Throwable)localObject1);
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        ((RelativeLayout.LayoutParams)localObject1).addRule(11);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131298828);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(5);
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd((int)this.wka);
        localObject2 = getCollapseTextView();
        p.g(localObject2, "collapseTextView");
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = getCollapseTextView();
        localObject2 = getContentTextView();
        p.g(localObject2, "contentTextView");
        ((TextView)localObject1).setTextSize(0, ((NeatTextView)localObject2).getTextSize());
        localObject1 = new StringBuilder("isSpecialText:");
        localObject2 = getContentTextView();
        p.g(localObject2, "contentTextView");
        Log.i("Finder.CollapsibleTextView", ((NeatTextView)localObject2).hiS());
        post((Runnable)new h(this));
        AppMethodBeat.o(254700);
        return;
      }
      getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
      localObject1 = getCollapseTextView();
      p.g(localObject1, "collapseTextView");
      localObject1 = ((TextView)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(254700);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(11);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(8);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131298828);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131298828);
      ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
      Object localObject2 = getCollapseTextView();
      p.g(localObject2, "collapseTextView");
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(254700);
      return;
    }
    getContentTextView().aw(this.text);
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    AppMethodBeat.o(254700);
  }
  
  public final void a(final CharSequence paramCharSequence, final View paramView, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(254702);
    p.h(paramb, "callBack");
    setText(paramCharSequence);
    if (paramView != null)
    {
      paramView.post((Runnable)new b(this, paramView, paramCharSequence, paramb));
      AppMethodBeat.o(254702);
      return;
    }
    AppMethodBeat.o(254702);
  }
  
  public final boolean dGq()
  {
    AppMethodBeat.i(254704);
    try
    {
      NeatTextView localNeatTextView = getContentTextView();
      p.g(localNeatTextView, "contentTextView");
      i = localNeatTextView.getLayout().getEllipsisCount(this.wkh - 1);
      if ((this.wke) && (i > 0))
      {
        dGn();
        AppMethodBeat.o(254704);
        return true;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        int i = -1;
      }
      AppMethodBeat.o(254704);
    }
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168232);
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      getContentTextView().setTag(2131309367, new int[] { i, j });
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(168232);
    return bool;
  }
  
  public final TextView getCollapseTextView()
  {
    AppMethodBeat.i(168231);
    TextView localTextView = (TextView)this.wjZ.getValue();
    AppMethodBeat.o(168231);
    return localTextView;
  }
  
  public final float getCollapseTextViewRight()
  {
    return this.wka;
  }
  
  public final NeatTextView getContentTextView()
  {
    AppMethodBeat.i(168230);
    NeatTextView localNeatTextView = (NeatTextView)this.wjY.getValue();
    AppMethodBeat.o(168230);
    return localNeatTextView;
  }
  
  public final int getExpanText()
  {
    return this.wkb;
  }
  
  public final View getExtraView()
  {
    return this.wkc;
  }
  
  public final int getLimitLine()
  {
    return this.wkh;
  }
  
  public final kotlin.g.a.b<Boolean, x> getOnCollapse()
  {
    return this.wkg;
  }
  
  public final CharSequence getRealContent()
  {
    return this.wki;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(168237);
    NeatTextView localNeatTextView = getContentTextView();
    p.g(localNeatTextView, "contentTextView");
    int i = localNeatTextView.getCurrentTextColor();
    AppMethodBeat.o(168237);
    return i;
  }
  
  public final void oV(boolean paramBoolean)
  {
    AppMethodBeat.i(168239);
    if (paramBoolean)
    {
      getContentTextView().setOnLongClickListener((View.OnLongClickListener)new f(this));
      getContentTextView().setOnClickListener((View.OnClickListener)new g(this));
      getContentTextView().setBackgroundResource(2131101287);
      localNeatTextView = getContentTextView();
      p.g(localNeatTextView, "contentTextView");
      localNeatTextView.setClickable(true);
      localNeatTextView = getContentTextView();
      p.g(localNeatTextView, "contentTextView");
      localNeatTextView.setLongClickable(true);
      AppMethodBeat.o(168239);
      return;
    }
    getContentTextView().setOnLongClickListener(null);
    getContentTextView().setOnClickListener(null);
    getContentTextView().setBackgroundResource(2131235359);
    NeatTextView localNeatTextView = getContentTextView();
    p.g(localNeatTextView, "contentTextView");
    localNeatTextView.setClickable(false);
    localNeatTextView = getContentTextView();
    p.g(localNeatTextView, "contentTextView");
    localNeatTextView.setLongClickable(false);
    AppMethodBeat.o(168239);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168234);
    super.onMeasure(paramInt1, paramInt2);
    if (dGp()) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(168234);
  }
  
  public final void setCollapse(boolean paramBoolean)
  {
    AppMethodBeat.i(168233);
    this.wke = paramBoolean;
    if (paramBoolean)
    {
      localNeatTextView = getContentTextView();
      p.g(localNeatTextView, "contentTextView");
      if (localNeatTextView.getMaxLines() != this.wkh)
      {
        localNeatTextView = getContentTextView();
        p.g(localNeatTextView, "contentTextView");
        localNeatTextView.setMaxLines(this.wkh);
      }
      getCollapseTextView().setText(this.wkb);
      AppMethodBeat.o(168233);
      return;
    }
    NeatTextView localNeatTextView = getContentTextView();
    p.g(localNeatTextView, "contentTextView");
    if (localNeatTextView.getMaxLines() != 2147483647)
    {
      localNeatTextView = getContentTextView();
      p.g(localNeatTextView, "contentTextView");
      localNeatTextView.setMaxLines(2147483647);
    }
    getCollapseTextView().setText(2131757650);
    AppMethodBeat.o(168233);
  }
  
  public final void setCollapseTextViewRight(float paramFloat)
  {
    this.wka = paramFloat;
  }
  
  public final void setExpanText(int paramInt)
  {
    this.wkb = paramInt;
  }
  
  public final void setExtraView(View paramView)
  {
    this.wkc = paramView;
  }
  
  public final void setLimitLine(int paramInt)
  {
    AppMethodBeat.i(254703);
    this.wkh = paramInt;
    NeatTextView localNeatTextView = getContentTextView();
    p.g(localNeatTextView, "contentTextView");
    if (localNeatTextView.getMaxLines() != paramInt)
    {
      localNeatTextView = getContentTextView();
      p.g(localNeatTextView, "contentTextView");
      localNeatTextView.setMaxLines(paramInt);
    }
    AppMethodBeat.o(254703);
  }
  
  public final void setOnCollapse(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.wkg = paramb;
  }
  
  public final void setRealContent(CharSequence paramCharSequence)
  {
    this.wki = paramCharSequence;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(168236);
    this.text = paramCharSequence;
    getContentTextView().aw(paramCharSequence);
    post((Runnable)new i(this));
    AppMethodBeat.o(168236);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(168238);
    getContentTextView().setTextColor(paramInt);
    AppMethodBeat.o(168238);
  }
  
  public final void setTopicExpand(boolean paramBoolean)
  {
    this.wkd = paramBoolean;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderCollapsibleTextView paramFinderCollapsibleTextView, View paramView, CharSequence paramCharSequence, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(254689);
      int i = paramView.getWidth();
      if (i > 0) {
        this.wkk.getContentTextView().setLineEndExtraWidths(new float[] { i });
      }
      this.wkk.setText(paramCharSequence);
      Object localObject = paramb;
      NeatTextView localNeatTextView = this.wkk.getContentTextView();
      p.g(localNeatTextView, "contentTextView");
      ((kotlin.g.a.b)localObject).invoke(Boolean.valueOf(localNeatTextView.hiS()));
      localObject = k.vfA;
      localObject = this.wkk.getContext();
      p.g(localObject, "context");
      k.a((Context)localObject, true, 0, this.wkk.wke, this.wkk.wkd);
      AppMethodBeat.o(254689);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$checkIfAllRestTextTopic$1$1"})
  static final class c
    implements Runnable
  {
    c(CharSequence paramCharSequence, FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      boolean bool2 = true;
      AppMethodBeat.i(254690);
      Log.i("Finder.CollapsibleTextView", "[checkIfAllRestTextTopic] start timeStamp:" + System.currentTimeMillis());
      boolean bool1;
      try
      {
        NeatTextView localNeatTextView = jdField_this.getContentTextView();
        p.g(localNeatTextView, "contentTextView");
        i = localNeatTextView.getLayout().getLineStart(jdField_this.getLimitLine() - 1);
        localNeatTextView = jdField_this.getContentTextView();
        p.g(localNeatTextView, "contentTextView");
        j = localNeatTextView.getLayout().getEllipsisStart(jdField_this.getLimitLine() - 1);
        i = i + j + 2;
      }
      catch (Exception localException)
      {
        int i;
        for (;;)
        {
          Log.i("Finder.CollapsibleTextView", "[checkIfAllRestTextTopic] " + localException.getMessage());
          i = -1;
        }
        Object localObject1 = this.wkn;
        localObject1 = ((CharSequence)localObject1).subSequence(i, ((CharSequence)localObject1).length());
        bool1 = bool2;
        if (!(this.wkn instanceof SpannableString)) {
          break label431;
        }
        bool1 = bool2;
        if (i <= 0) {
          break label431;
        }
        int k = 0;
        int j = 0;
        for (bool1 = true; k < ((CharSequence)localObject1).length(); bool1 = bool2)
        {
          int m = ((CharSequence)localObject1).charAt(k);
          bool2 = bool1;
          if (m != 32)
          {
            bool2 = bool1;
            if (m != 10)
            {
              Object localObject2 = (l[])((SpannableString)this.wkn).getSpans(j + i, j + i, l.class);
              if (localObject2 != null)
              {
                if (localObject2.length == 0)
                {
                  m = 1;
                  if (m == 0) {
                    break label395;
                  }
                }
              }
              else {
                m = 1;
              }
              for (;;)
              {
                if (m == 0)
                {
                  localObject2 = localObject2[0];
                  if (localObject2 == null)
                  {
                    localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.FinderTextClickSpan");
                    AppMethodBeat.o(254690);
                    throw ((Throwable)localObject1);
                    m = 0;
                    break;
                    m = 0;
                    continue;
                  }
                  bool2 = bool1;
                  if (((l)localObject2).wpF) {
                    break label416;
                  }
                }
              }
              bool2 = false;
            }
          }
          k += 1;
          j += 1;
        }
        if (!bool1) {
          break label500;
        }
      }
      if ((i < 0) || (i > this.wkn.length()))
      {
        Log.i("Finder.CollapsibleTextView", "[checkIfAllRestTextTopic] offset:" + i + " , length:" + this.wkn.length() + ",text:" + this.wkn);
        AppMethodBeat.o(254690);
        return;
      }
      label395:
      label416:
      label431:
      jdField_this.setExpanText(2131759588);
      for (;;)
      {
        jdField_this.getCollapseTextView().setText(jdField_this.getExpanText());
        jdField_this.setTopicExpand(bool1);
        Log.i("Finder.CollapsibleTextView", "[checkIfAllRestTextTopic] end timeStamp:" + System.currentTimeMillis());
        AppMethodBeat.o(254690);
        return;
        label500:
        jdField_this.setExpanText(2131759536);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextView>
  {
    d(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<NeatTextView>
  {
    e(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class f
    implements View.OnLongClickListener
  {
    f(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168228);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      try
      {
        paramView = new com.tencent.mm.ui.widget.b.a(this.wkk.getContext());
        paramView.a((o.g)new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(254691);
            if (paramAnonymousInt == 0) {
              ClipboardHelper.setText(this.wko.wkk.getContentTextView().hiT());
            }
            AppMethodBeat.o(254691);
          }
        });
        paramView.setOnDismissListener((PopupWindow.OnDismissListener)new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(254692);
            this.wko.wkk.getContentTextView().setBackgroundResource(2131101287);
            AppMethodBeat.o(254692);
          }
        });
        this.wkk.getContentTextView().setBackgroundResource(2131100690);
        localObject = (View)this.wkk.getContentTextView();
        View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(254693);
            paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.wko.wkk.getContext().getString(2131755772));
            AppMethodBeat.o(254693);
          }
        };
        o.g localg = (o.g)new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(254694);
            if (paramAnonymousInt == 0)
            {
              if (this.wko.wkk.getRealContent() == null)
              {
                ClipboardHelper.setText(this.wko.wkk.getContentTextView().hiT());
                AppMethodBeat.o(254694);
                return;
              }
              ClipboardHelper.setText(this.wko.wkk.getRealContent());
            }
            AppMethodBeat.o(254694);
          }
        };
        TouchableLayout.a locala = TouchableLayout.Rni;
        int i = TouchableLayout.hfC();
        locala = TouchableLayout.Rni;
        paramView.a((View)localObject, localOnCreateContextMenuListener, localg, i, TouchableLayout.hfD());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(168228);
        return true;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.i("Finder.CollapsibleTextView", "[enableContentTextViewClick] errMsg:" + paramView.getMessage());
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254695);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.neattextview.textview.view.NeatTextView");
        AppMethodBeat.o(254695);
        throw paramView;
      }
      try
      {
        i = ((NeatTextView)paramView).getLayout().getEllipsisCount(this.wkk.getLimitLine() - 1);
        if (((this.wkk.wke) && (i > 0)) || (!this.wkk.wke))
        {
          FinderCollapsibleTextView.c(this.wkk);
          paramView = k.vfA;
          paramView = this.wkk.getContext();
          p.g(paramView, "context");
          k.a(paramView, false, 2, this.wkk.wke, this.wkk.wkd);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254695);
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramView)
      {
        for (;;)
        {
          int i = -1;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(254697);
      try
      {
        final z.d locald = new z.d();
        Object localObject1 = this.wkk.getContentTextView();
        p.g(localObject1, "contentTextView");
        localObject1 = ((NeatTextView)localObject1).getLayout();
        final int i = this.wkk.getLimitLine();
        Object localObject2 = kotlin.g.b.l.SYx;
        locald.SYE = ((com.tencent.neattextview.textview.layout.a)localObject1).getOffsetForHorizontal(i - 1, kotlin.g.b.l.hxZ());
        localObject1 = this.wkk.getContentTextView();
        p.g(localObject1, "contentTextView");
        float f1 = ((NeatTextView)localObject1).getLayout().getPrimaryHorizontal(locald.SYE);
        localObject1 = this.wkk.getContentTextView();
        p.g(localObject1, "contentTextView");
        i = ((NeatTextView)localObject1).getWidth();
        if (FinderCollapsibleTextView.a(this.wkk) == 0.0F)
        {
          localObject1 = this.wkk;
          localObject2 = this.wkk.getCollapseTextView();
          p.g(localObject2, "collapseTextView");
          localObject2 = ((TextView)localObject2).getPaint();
          Context localContext = this.wkk.getContext();
          p.g(localContext, "context");
          FinderCollapsibleTextView.a((FinderCollapsibleTextView)localObject1, ((TextPaint)localObject2).measureText(localContext.getResources().getString(2131759536)));
        }
        final float f2 = FinderCollapsibleTextView.a(this.wkk) + 3.0F;
        localObject1 = this.wkk.getContentTextView();
        p.g(localObject1, "contentTextView");
        if ((((NeatTextView)localObject1).hiS()) && (i - f1 <= f2))
        {
          FinderCollapsibleTextView.a(this.wkk, "#1");
          AppMethodBeat.o(254697);
          return;
        }
        if (f1 + f2 > i) {
          this.wkk.getContentTextView().a(TextUtils.TruncateAt.END, f2);
        }
        for (;;)
        {
          this.wkk.post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(254696);
              Object localObject1 = locald;
              Object localObject2 = this.wkp.wkk.getContentTextView();
              p.g(localObject2, "contentTextView");
              localObject2 = ((NeatTextView)localObject2).getLayout();
              int i = this.wkp.wkk.getLimitLine();
              kotlin.g.b.l locall = kotlin.g.b.l.SYx;
              ((z.d)localObject1).SYE = ((com.tencent.neattextview.textview.layout.a)localObject2).getOffsetForHorizontal(i - 1, kotlin.g.b.l.hxZ());
              localObject1 = this.wkp.wkk.getContentTextView();
              p.g(localObject1, "contentTextView");
              float f1 = ((NeatTextView)localObject1).getLayout().getPrimaryHorizontal(locald.SYE);
              float f2 = f2;
              localObject1 = this.wkp.wkk.getCollapseTextView();
              p.g(localObject1, "collapseTextView");
              float f3 = ((TextView)localObject1).getPaint().measureText("…");
              this.wkp.wkk.setCollapseTextViewRight(i - (f1 + f2 + f3));
              this.wkp.wkk.setCollapseTextViewRight(j.aI(0.0F, this.wkp.wkk.getCollapseTextViewRight()));
              localObject1 = this.wkp.wkk.getCollapseTextView();
              p.g(localObject1, "collapseTextView");
              localObject1 = ((TextView)localObject1).getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(254696);
                throw ((Throwable)localObject1);
              }
              localObject1 = (RelativeLayout.LayoutParams)localObject1;
              ((RelativeLayout.LayoutParams)localObject1).setMarginEnd((int)this.wkp.wkk.getCollapseTextViewRight());
              localObject2 = this.wkp.wkk.getCollapseTextView();
              p.g(localObject2, "collapseTextView");
              ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              FinderCollapsibleTextView.b(this.wkp.wkk);
              AppMethodBeat.o(254696);
            }
          });
          AppMethodBeat.o(254697);
          return;
          localObject1 = this.wkk.getContentTextView();
          p.g(localObject1, "contentTextView");
          if (((NeatTextView)localObject1).getExtraEllipsizeWidth() <= 0.0F) {
            this.wkk.getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        FinderCollapsibleTextView.a(this.wkk, "#2:Exception:" + localException.getMessage());
        AppMethodBeat.o(254697);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(254698);
      FinderCollapsibleTextView.a(this.wkk, this.wkk.wke);
      AppMethodBeat.o(254698);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */