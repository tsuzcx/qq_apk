package com.tencent.mm.plugin.finder.view;

import android.annotation.SuppressLint;
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
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.f;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapseTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCollapseTextView", "()Landroid/widget/TextView;", "collapseTextView$delegate", "Lkotlin/Lazy;", "collapseTextViewRight", "", "getCollapseTextViewRight", "()F", "setCollapseTextViewRight", "(F)V", "collapseTextWidth", "contentTextView", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTextView", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "contentTextView$delegate", "expanText", "getExpanText", "()I", "setExpanText", "(I)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "value", "", "isCollapse", "()Z", "setCollapse", "(Z)V", "isTopicExpand", "setTopicExpand", "limitLine", "getLimitLine", "setLimitLine", "onCollapse", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function1;", "setOnCollapse", "(Lkotlin/jvm/functions/Function1;)V", "realContent", "", "getRealContent", "()Ljava/lang/CharSequence;", "setRealContent", "(Ljava/lang/CharSequence;)V", "text", "getText", "setText", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "_setText", "content", "callBack", "backToDefaultLogic", "source", "", "checkCollapseVisible", "checkCollapseVisibleSync", "checkIfAllRestTextTopic", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enableContentTextViewClick", "enable", "onClickFun", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshCollapseText", "tryExpand", "Companion", "plugin-finder_release"})
@SuppressLint({"ClickableViewAccessibility"})
public final class FinderCollapsibleTextView
  extends RelativeLayout
{
  public static final FinderCollapsibleTextView.a AVd;
  private final f AUS;
  private final f AUT;
  private float AUU;
  private int AUV;
  private View AUW;
  boolean AUX;
  boolean AUY;
  private float AUZ;
  private kotlin.g.a.b<? super Boolean, x> AVa;
  private int AVb;
  private CharSequence AVc;
  private CharSequence LV;
  
  static
  {
    AppMethodBeat.i(168229);
    AVd = new FinderCollapsibleTextView.a((byte)0);
    AppMethodBeat.o(168229);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168241);
    this.AUS = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.AUT = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.AUV = b.j.finder_all_text;
    ad.kS(getContext()).inflate(b.g.finder_collapsible_layout, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(b.d.Edge_0_5_A));
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    getCollapseTextView().setLineSpacing(getResources().getDimension(b.d.Edge_0_5_A), 1.0F);
    getContentTextView().setOnTouchListener((View.OnTouchListener)new h(getContentTextView(), (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o()));
    rp(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FinderCollapsibleTextView.c(this.AVe);
        paramAnonymousView = n.zWF;
        paramAnonymousView = this.AVe.getContext();
        p.j(paramAnonymousView, "context");
        n.a(paramAnonymousView, false, 1, this.AVe.AUY, this.AVe.AUX);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168223);
      }
    });
    this.AUY = true;
    this.AVb = 3;
    AppMethodBeat.o(168241);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168242);
    this.AUS = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.AUT = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.AUV = b.j.finder_all_text;
    ad.kS(getContext()).inflate(b.g.finder_collapsible_layout, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(b.d.Edge_0_5_A));
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    getCollapseTextView().setLineSpacing(getResources().getDimension(b.d.Edge_0_5_A), 1.0F);
    getContentTextView().setOnTouchListener((View.OnTouchListener)new h(getContentTextView(), (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o()));
    rp(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FinderCollapsibleTextView.c(this.AVe);
        paramAnonymousView = n.zWF;
        paramAnonymousView = this.AVe.getContext();
        p.j(paramAnonymousView, "context");
        n.a(paramAnonymousView, false, 1, this.AVe.AUY, this.AVe.AUX);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168223);
      }
    });
    this.AUY = true;
    this.AVb = 3;
    AppMethodBeat.o(168242);
  }
  
  private final void ein()
  {
    AppMethodBeat.i(271379);
    if (!this.AUY) {}
    for (boolean bool = true;; bool = false)
    {
      setCollapse(bool);
      if (!this.AUY)
      {
        localObject = com.tencent.mm.ui.component.g.Xox;
        com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
        com.tencent.mm.plugin.finder.viewmodel.b.ekc();
      }
      ro(this.AUY);
      Object localObject = this.AVa;
      if (localObject == null) {
        break;
      }
      ((kotlin.g.a.b)localObject).invoke(Boolean.valueOf(this.AUY));
      AppMethodBeat.o(271379);
      return;
    }
    AppMethodBeat.o(271379);
  }
  
  private final void eio()
  {
    AppMethodBeat.i(271381);
    CharSequence localCharSequence = this.LV;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(271381);
      return;
    }
    localCharSequence = this.LV;
    if (localCharSequence != null)
    {
      post((Runnable)new d(localCharSequence, this));
      AppMethodBeat.o(271381);
      return;
    }
    AppMethodBeat.o(271381);
  }
  
  private boolean eip()
  {
    AppMethodBeat.i(168240);
    Object localObject = getContentTextView();
    p.j(localObject, "contentTextView");
    localObject = ((NeatTextView)localObject).getLayout();
    for (;;)
    {
      try
      {
        i = this.AVb;
        p.j(localObject, "layout");
        i = i.ow(i, ((com.tencent.neattextview.textview.layout.a)localObject).ikp()) - 1;
        if (i < 0) {
          continue;
        }
        i = ((com.tencent.neattextview.textview.layout.a)localObject).E(i, 10000.0F);
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
        p.j(localObject, "collapseTextView");
        ((TextView)localObject).setVisibility(8);
        continue;
        AppMethodBeat.o(168240);
      }
      localTextView = getCollapseTextView();
      p.j(localTextView, "collapseTextView");
      j = localTextView.getVisibility();
      if ((localObject == null) || (i <= 0) || (i >= getContentTextView().ikC().length())) {
        continue;
      }
      localObject = getCollapseTextView();
      p.j(localObject, "collapseTextView");
      ((TextView)localObject).setVisibility(0);
      localObject = getCollapseTextView();
      p.j(localObject, "collapseTextView");
      if (j == ((TextView)localObject).getVisibility()) {
        continue;
      }
      AppMethodBeat.o(168240);
      return true;
      i = 0;
    }
    return false;
  }
  
  private final void ro(boolean paramBoolean)
  {
    AppMethodBeat.i(271380);
    Object localObject1 = getCollapseTextView();
    p.j(localObject1, "collapseTextView");
    if (((TextView)localObject1).getVisibility() == 0)
    {
      if (paramBoolean)
      {
        localObject1 = getCollapseTextView();
        p.j(localObject1, "collapseTextView");
        localObject1 = ((TextView)localObject1).getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(271380);
          throw ((Throwable)localObject1);
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        ((RelativeLayout.LayoutParams)localObject1).addRule(11);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, b.f.collapse_content_tv);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject1).removeRule(5);
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd((int)this.AUU);
        localObject2 = getCollapseTextView();
        p.j(localObject2, "collapseTextView");
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = getCollapseTextView();
        localObject2 = getContentTextView();
        p.j(localObject2, "contentTextView");
        ((TextView)localObject1).setTextSize(0, ((NeatTextView)localObject2).getTextSize());
        localObject1 = new StringBuilder("isSpecialText:");
        localObject2 = getContentTextView();
        p.j(localObject2, "contentTextView");
        Log.i("Finder.CollapsibleTextView", ((NeatTextView)localObject2).ikB());
        post((Runnable)new i(this));
        AppMethodBeat.o(271380);
        return;
      }
      getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
      localObject1 = getCollapseTextView();
      p.j(localObject1, "collapseTextView");
      localObject1 = ((TextView)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(271380);
        throw ((Throwable)localObject1);
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(11);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(8);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, b.f.collapse_content_tv);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, b.f.collapse_content_tv);
      ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
      Object localObject2 = getCollapseTextView();
      p.j(localObject2, "collapseTextView");
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(271380);
      return;
    }
    getContentTextView().aL(this.LV);
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    AppMethodBeat.o(271380);
  }
  
  public final void a(final CharSequence paramCharSequence, final View paramView, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(271382);
    p.k(paramb, "callBack");
    setText(paramCharSequence);
    if (paramView != null)
    {
      paramView.post((Runnable)new c(this, paramView, paramCharSequence, paramb));
      AppMethodBeat.o(271382);
      return;
    }
    AppMethodBeat.o(271382);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168232);
    p.k(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      getContentTextView().setTag(b.f.touch_loc, new int[] { i, j });
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(168232);
    return bool;
  }
  
  public final boolean eiq()
  {
    AppMethodBeat.i(271390);
    try
    {
      NeatTextView localNeatTextView = getContentTextView();
      p.j(localNeatTextView, "contentTextView");
      i = localNeatTextView.getLayout().aAa(this.AVb - 1);
      if ((this.AUY) && (i > 0))
      {
        ein();
        AppMethodBeat.o(271390);
        return true;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        int i = -1;
      }
      AppMethodBeat.o(271390);
    }
    return false;
  }
  
  public final TextView getCollapseTextView()
  {
    AppMethodBeat.i(168231);
    TextView localTextView = (TextView)this.AUT.getValue();
    AppMethodBeat.o(168231);
    return localTextView;
  }
  
  public final float getCollapseTextViewRight()
  {
    return this.AUU;
  }
  
  public final NeatTextView getContentTextView()
  {
    AppMethodBeat.i(168230);
    NeatTextView localNeatTextView = (NeatTextView)this.AUS.getValue();
    AppMethodBeat.o(168230);
    return localNeatTextView;
  }
  
  public final int getExpanText()
  {
    return this.AUV;
  }
  
  public final View getExtraView()
  {
    return this.AUW;
  }
  
  public final int getLimitLine()
  {
    return this.AVb;
  }
  
  public final kotlin.g.a.b<Boolean, x> getOnCollapse()
  {
    return this.AVa;
  }
  
  public final CharSequence getRealContent()
  {
    return this.AVc;
  }
  
  public final CharSequence getText()
  {
    return this.LV;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(168237);
    NeatTextView localNeatTextView = getContentTextView();
    p.j(localNeatTextView, "contentTextView");
    int i = localNeatTextView.getCurrentTextColor();
    AppMethodBeat.o(168237);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(271388);
    NeatTextView localNeatTextView = getContentTextView();
    p.j(localNeatTextView, "contentTextView");
    float f = localNeatTextView.getTextSize();
    AppMethodBeat.o(271388);
    return f;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168234);
    super.onMeasure(paramInt1, paramInt2);
    if (eip()) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(168234);
  }
  
  public final void rp(boolean paramBoolean)
  {
    AppMethodBeat.i(168239);
    if (paramBoolean)
    {
      getContentTextView().setOnLongClickListener((View.OnLongClickListener)new g(this));
      getContentTextView().setOnClickListener((View.OnClickListener)new h(this));
      getContentTextView().setBackgroundResource(b.c.transparent);
      localNeatTextView = getContentTextView();
      p.j(localNeatTextView, "contentTextView");
      localNeatTextView.setClickable(true);
      localNeatTextView = getContentTextView();
      p.j(localNeatTextView, "contentTextView");
      localNeatTextView.setLongClickable(true);
      AppMethodBeat.o(168239);
      return;
    }
    getContentTextView().setOnLongClickListener(null);
    getContentTextView().setOnClickListener(null);
    getContentTextView().setBackgroundResource(b.e.transparent_background);
    NeatTextView localNeatTextView = getContentTextView();
    p.j(localNeatTextView, "contentTextView");
    localNeatTextView.setClickable(false);
    localNeatTextView = getContentTextView();
    p.j(localNeatTextView, "contentTextView");
    localNeatTextView.setLongClickable(false);
    AppMethodBeat.o(168239);
  }
  
  public final void setCollapse(boolean paramBoolean)
  {
    AppMethodBeat.i(168233);
    this.AUY = paramBoolean;
    if (paramBoolean)
    {
      localNeatTextView = getContentTextView();
      p.j(localNeatTextView, "contentTextView");
      if (localNeatTextView.getMaxLines() != this.AVb)
      {
        localNeatTextView = getContentTextView();
        p.j(localNeatTextView, "contentTextView");
        localNeatTextView.setMaxLines(this.AVb);
      }
      getCollapseTextView().setText(this.AUV);
      AppMethodBeat.o(168233);
      return;
    }
    NeatTextView localNeatTextView = getContentTextView();
    p.j(localNeatTextView, "contentTextView");
    if (localNeatTextView.getMaxLines() != 2147483647)
    {
      localNeatTextView = getContentTextView();
      p.j(localNeatTextView, "contentTextView");
      localNeatTextView.setMaxLines(2147483647);
    }
    getCollapseTextView().setText(b.j.collapse);
    AppMethodBeat.o(168233);
  }
  
  public final void setCollapseTextViewRight(float paramFloat)
  {
    this.AUU = paramFloat;
  }
  
  public final void setExpanText(int paramInt)
  {
    this.AUV = paramInt;
  }
  
  public final void setExtraView(View paramView)
  {
    this.AUW = paramView;
  }
  
  public final void setLimitLine(int paramInt)
  {
    AppMethodBeat.i(271385);
    this.AVb = paramInt;
    NeatTextView localNeatTextView = getContentTextView();
    p.j(localNeatTextView, "contentTextView");
    if (localNeatTextView.getMaxLines() != paramInt)
    {
      localNeatTextView = getContentTextView();
      p.j(localNeatTextView, "contentTextView");
      localNeatTextView.setMaxLines(paramInt);
    }
    AppMethodBeat.o(271385);
  }
  
  public final void setOnCollapse(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.AVa = paramb;
  }
  
  public final void setRealContent(CharSequence paramCharSequence)
  {
    this.AVc = paramCharSequence;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(168236);
    this.LV = paramCharSequence;
    getContentTextView().aL(paramCharSequence);
    post((Runnable)new j(this));
    AppMethodBeat.o(168236);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(168238);
    getContentTextView().setTextColor(paramInt);
    AppMethodBeat.o(168238);
  }
  
  public final void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(271389);
    NeatTextView localNeatTextView = getContentTextView();
    p.j(localNeatTextView, "contentTextView");
    localNeatTextView.setTextSize(paramFloat);
    AppMethodBeat.o(271389);
  }
  
  public final void setTopicExpand(boolean paramBoolean)
  {
    this.AUX = paramBoolean;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderCollapsibleTextView paramFinderCollapsibleTextView, View paramView, CharSequence paramCharSequence, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(282497);
      int i = paramView.getWidth();
      if (i > 0) {
        this.AVe.getContentTextView().setLineEndExtraWidths(new float[] { i });
      }
      this.AVe.setText(paramCharSequence);
      Object localObject = paramb;
      NeatTextView localNeatTextView = this.AVe.getContentTextView();
      p.j(localNeatTextView, "contentTextView");
      ((kotlin.g.a.b)localObject).invoke(Boolean.valueOf(localNeatTextView.ikB()));
      localObject = n.zWF;
      localObject = this.AVe.getContext();
      p.j(localObject, "context");
      n.a((Context)localObject, true, 0, this.AVe.AUY, this.AVe.AUX);
      AppMethodBeat.o(282497);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$checkIfAllRestTextTopic$1$1"})
  static final class d
    implements Runnable
  {
    d(CharSequence paramCharSequence, FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(281470);
      Log.i("Finder.CollapsibleTextView", "[checkIfAllRestTextTopic] start timeStamp:" + System.currentTimeMillis());
      boolean bool2;
      try
      {
        NeatTextView localNeatTextView = jdField_this.getContentTextView();
        p.j(localNeatTextView, "contentTextView");
        i = localNeatTextView.getLayout().azW(jdField_this.getLimitLine() - 1);
        localNeatTextView = jdField_this.getContentTextView();
        p.j(localNeatTextView, "contentTextView");
        j = localNeatTextView.getLayout().azZ(jdField_this.getLimitLine() - 1);
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
        Object localObject1 = this.AVj;
        localObject1 = ((CharSequence)localObject1).subSequence(i, ((CharSequence)localObject1).length());
        if ((!(this.AVj instanceof SpannableString)) || (i <= 0)) {
          break label424;
        }
        int k = 0;
        int j = 0;
        for (boolean bool1 = true;; bool1 = bool2)
        {
          bool2 = bool1;
          if (k >= ((CharSequence)localObject1).length()) {
            break;
          }
          int m = ((CharSequence)localObject1).charAt(k);
          bool2 = bool1;
          if (m != 32)
          {
            bool2 = bool1;
            if (m != 10)
            {
              Object localObject2 = (o[])((SpannableString)this.AVj).getSpans(j + i, j + i, o.class);
              if (localObject2 != null)
              {
                if (localObject2.length == 0)
                {
                  m = 1;
                  if (m == 0) {
                    break label388;
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
                    AppMethodBeat.o(281470);
                    throw ((Throwable)localObject1);
                    m = 0;
                    break;
                    label388:
                    m = 0;
                    continue;
                  }
                  bool2 = bool1;
                  if (((o)localObject2).BaS) {
                    break label409;
                  }
                }
              }
              bool2 = false;
            }
          }
          label409:
          k += 1;
          j += 1;
        }
        label424:
        bool2 = false;
        if (!bool2) {
          break label497;
        }
      }
      if ((i < 0) || (i > this.AVj.length()))
      {
        Log.i("Finder.CollapsibleTextView", "[checkIfAllRestTextTopic] offset:" + i + " , length:" + this.AVj.length() + ",text:" + this.AVj);
        AppMethodBeat.o(281470);
        return;
      }
      jdField_this.setExpanText(b.j.finder_collpase_topic);
      for (;;)
      {
        jdField_this.getCollapseTextView().setText(jdField_this.getExpanText());
        jdField_this.setTopicExpand(bool2);
        Log.i("Finder.CollapsibleTextView", "[checkIfAllRestTextTopic] end timeStamp:" + System.currentTimeMillis());
        AppMethodBeat.o(281470);
        return;
        label497:
        jdField_this.setExpanText(b.j.finder_all_text);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<NeatTextView>
  {
    f(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    g(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168228);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      try
      {
        paramView = new com.tencent.mm.ui.widget.b.a(this.AVe.getContext());
        paramView.a((q.g)new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(289166);
            if (paramAnonymousInt == 0) {
              ClipboardHelper.setText(this.AVk.AVe.getContentTextView().ikC());
            }
            AppMethodBeat.o(289166);
          }
        });
        paramView.setOnDismissListener((PopupWindow.OnDismissListener)new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(288168);
            this.AVk.AVe.getContentTextView().setBackgroundResource(b.c.transparent);
            AppMethodBeat.o(288168);
          }
        });
        this.AVe.getContentTextView().setBackgroundResource(b.c.list_devider_color);
        localObject = (View)this.AVe.getContentTextView();
        View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(282246);
            paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.AVk.AVe.getContext().getString(b.j.app_copy));
            AppMethodBeat.o(282246);
          }
        };
        q.g localg = (q.g)new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(279523);
            if (paramAnonymousInt == 0)
            {
              if (this.AVk.AVe.getRealContent() == null)
              {
                ClipboardHelper.setText(this.AVk.AVe.getContentTextView().ikC());
                AppMethodBeat.o(279523);
                return;
              }
              ClipboardHelper.setText(this.AVk.AVe.getRealContent());
            }
            AppMethodBeat.o(279523);
          }
        };
        TouchableLayout.a locala = TouchableLayout.YOD;
        int i = TouchableLayout.igZ();
        locala = TouchableLayout.YOD;
        paramView.a((View)localObject, localOnCreateContextMenuListener, localg, i, TouchableLayout.iha());
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281831);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.neattextview.textview.view.NeatTextView");
        AppMethodBeat.o(281831);
        throw paramView;
      }
      try
      {
        i = ((NeatTextView)paramView).getLayout().aAa(this.AVe.getLimitLine() - 1);
        if (((this.AVe.AUY) && (i > 0)) || (!this.AVe.AUY))
        {
          FinderCollapsibleTextView.c(this.AVe);
          paramView = n.zWF;
          paramView = this.AVe.getContext();
          p.j(paramView, "context");
          n.a(paramView, false, 2, this.AVe.AUY, this.AVe.AUX);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(281831);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(221558);
      try
      {
        final aa.d locald = new aa.d();
        Object localObject1 = this.AVe.getContentTextView();
        p.j(localObject1, "contentTextView");
        localObject1 = ((NeatTextView)localObject1).getLayout();
        final int i = this.AVe.getLimitLine();
        Object localObject2 = kotlin.g.b.l.aaBt;
        locald.aaBA = ((com.tencent.neattextview.textview.layout.a)localObject1).E(i - 1, kotlin.g.b.l.iCk());
        localObject1 = this.AVe.getContentTextView();
        p.j(localObject1, "contentTextView");
        float f1 = ((NeatTextView)localObject1).getLayout().azU(locald.aaBA);
        localObject1 = this.AVe.getContentTextView();
        p.j(localObject1, "contentTextView");
        i = ((NeatTextView)localObject1).getWidth();
        if (FinderCollapsibleTextView.a(this.AVe) == 0.0F)
        {
          localObject1 = this.AVe;
          localObject2 = this.AVe.getCollapseTextView();
          p.j(localObject2, "collapseTextView");
          localObject2 = ((TextView)localObject2).getPaint();
          Context localContext = this.AVe.getContext();
          p.j(localContext, "context");
          FinderCollapsibleTextView.a((FinderCollapsibleTextView)localObject1, ((TextPaint)localObject2).measureText(localContext.getResources().getString(b.j.finder_all_text)));
        }
        final float f2 = FinderCollapsibleTextView.a(this.AVe) + 3.0F;
        localObject1 = this.AVe.getContentTextView();
        p.j(localObject1, "contentTextView");
        if ((((NeatTextView)localObject1).ikB()) && (i - f1 <= f2))
        {
          FinderCollapsibleTextView.a(this.AVe, "#1");
          AppMethodBeat.o(221558);
          return;
        }
        if (f1 + f2 > i) {
          this.AVe.getContentTextView().a(TextUtils.TruncateAt.END, f2);
        }
        for (;;)
        {
          this.AVe.post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(272604);
              Object localObject1 = locald;
              Object localObject2 = this.AVl.AVe.getContentTextView();
              p.j(localObject2, "contentTextView");
              localObject2 = ((NeatTextView)localObject2).getLayout();
              int i = this.AVl.AVe.getLimitLine();
              kotlin.g.b.l locall = kotlin.g.b.l.aaBt;
              ((aa.d)localObject1).aaBA = ((com.tencent.neattextview.textview.layout.a)localObject2).E(i - 1, kotlin.g.b.l.iCk());
              localObject1 = this.AVl.AVe.getContentTextView();
              p.j(localObject1, "contentTextView");
              float f1 = ((NeatTextView)localObject1).getLayout().azU(locald.aaBA);
              float f2 = f2;
              localObject1 = this.AVl.AVe.getCollapseTextView();
              p.j(localObject1, "collapseTextView");
              float f3 = ((TextView)localObject1).getPaint().measureText("…");
              this.AVl.AVe.setCollapseTextViewRight(i - (f1 + f2 + f3));
              this.AVl.AVe.setCollapseTextViewRight(i.aP(0.0F, this.AVl.AVe.getCollapseTextViewRight()));
              localObject1 = this.AVl.AVe.getCollapseTextView();
              p.j(localObject1, "collapseTextView");
              localObject1 = ((TextView)localObject1).getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(272604);
                throw ((Throwable)localObject1);
              }
              localObject1 = (RelativeLayout.LayoutParams)localObject1;
              ((RelativeLayout.LayoutParams)localObject1).setMarginEnd((int)this.AVl.AVe.getCollapseTextViewRight());
              localObject2 = this.AVl.AVe.getCollapseTextView();
              p.j(localObject2, "collapseTextView");
              ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              FinderCollapsibleTextView.b(this.AVl.AVe);
              AppMethodBeat.o(272604);
            }
          });
          AppMethodBeat.o(221558);
          return;
          localObject1 = this.AVe.getContentTextView();
          p.j(localObject1, "contentTextView");
          if (((NeatTextView)localObject1).getExtraEllipsizeWidth() <= 0.0F) {
            this.AVe.getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        FinderCollapsibleTextView.a(this.AVe, "#2:Exception:" + localException.getMessage());
        AppMethodBeat.o(221558);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void run()
    {
      AppMethodBeat.i(267595);
      FinderCollapsibleTextView.a(this.AVe, this.AVe.AUY);
      AppMethodBeat.o(267595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */