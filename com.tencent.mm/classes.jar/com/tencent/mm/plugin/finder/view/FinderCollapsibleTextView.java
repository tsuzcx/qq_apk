package com.tencent.mm.plugin.finder.view;

import android.arch.lifecycle.ViewModelProvider;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
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
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.f;
import d.g;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapseTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCollapseTextView", "()Landroid/widget/TextView;", "collapseTextView$delegate", "Lkotlin/Lazy;", "contentTextView", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTextView", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "contentTextView$delegate", "value", "", "isCollapse", "()Z", "setCollapse", "(Z)V", "limitLine", "getLimitLine", "()I", "setLimitLine", "(I)V", "onCollapse", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function1;", "setOnCollapse", "(Lkotlin/jvm/functions/Function1;)V", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "getTextColor", "setTextColor", "tipsTv", "Landroid/view/View;", "getTipsTv", "()Landroid/view/View;", "tipsTv$delegate", "checkCollapseVisible", "checkCollapseVisibleSync", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enableContentTextViewClick", "enable", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "showTips", "isShow", "Companion", "plugin-finder_release"})
public final class FinderCollapsibleTextView
  extends LinearLayout
{
  public static final FinderCollapsibleTextView.a rVK;
  private final f rVE;
  private final f rVF;
  private final f rVG;
  public boolean rVH;
  private b<? super Boolean, y> rVI;
  private int rVJ;
  private CharSequence text;
  
  static
  {
    AppMethodBeat.i(168229);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderCollapsibleTextView.class), "contentTextView", "getContentTextView()Lcom/tencent/neattextview/textview/view/NeatTextView;")), (d.l.k)w.a(new u(w.bn(FinderCollapsibleTextView.class), "collapseTextView", "getCollapseTextView()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bn(FinderCollapsibleTextView.class), "tipsTv", "getTipsTv()Landroid/view/View;")) };
    rVK = new FinderCollapsibleTextView.a((byte)0);
    AppMethodBeat.o(168229);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168241);
    this.rVE = g.K((d.g.a.a)new c(this));
    this.rVF = g.K((d.g.a.a)new b(this));
    this.rVG = g.K((d.g.a.a)new f(this));
    setOrientation(1);
    z.jD(getContext()).inflate(2131494013, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(2131165274));
    lV(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        paramAnonymousView = this.rVL;
        if (!this.rVL.rVH) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setCollapse(bool);
          if (!this.rVL.rVH)
          {
            paramAnonymousView = com.tencent.mm.ui.component.a.IrY;
            com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
            FinderHomeTabStateVM.cFL();
          }
          paramAnonymousView = this.rVL.getOnCollapse();
          if (paramAnonymousView == null) {
            break;
          }
          paramAnonymousView.ay(Boolean.valueOf(this.rVL.rVH));
          AppMethodBeat.o(168223);
          return;
        }
        AppMethodBeat.o(168223);
      }
    });
    this.rVH = true;
    this.rVJ = 3;
    AppMethodBeat.o(168241);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168242);
    this.rVE = g.K((d.g.a.a)new c(this));
    this.rVF = g.K((d.g.a.a)new b(this));
    this.rVG = g.K((d.g.a.a)new f(this));
    setOrientation(1);
    z.jD(getContext()).inflate(2131494013, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(2131165274));
    lV(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        paramAnonymousView = this.rVL;
        if (!this.rVL.rVH) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setCollapse(bool);
          if (!this.rVL.rVH)
          {
            paramAnonymousView = com.tencent.mm.ui.component.a.IrY;
            com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
            FinderHomeTabStateVM.cFL();
          }
          paramAnonymousView = this.rVL.getOnCollapse();
          if (paramAnonymousView == null) {
            break;
          }
          paramAnonymousView.ay(Boolean.valueOf(this.rVL.rVH));
          AppMethodBeat.o(168223);
          return;
        }
        AppMethodBeat.o(168223);
      }
    });
    this.rVH = true;
    this.rVJ = 3;
    AppMethodBeat.o(168242);
  }
  
  private boolean cEE()
  {
    AppMethodBeat.i(168240);
    Object localObject = getContentTextView();
    d.g.b.k.g(localObject, "contentTextView");
    localObject = ((NeatTextView)localObject).getLayout();
    try
    {
      i = this.rVJ;
      d.g.b.k.g(localObject, "layout");
      i = ((com.tencent.neattextview.textview.layout.a)localObject).getOffsetForHorizontal(d.k.h.lb(i, ((com.tencent.neattextview.textview.layout.a)localObject).fBm()) - 1, 10000.0F);
      TextView localTextView = getCollapseTextView();
      d.g.b.k.g(localTextView, "collapseTextView");
      int j = localTextView.getVisibility();
      if ((localObject != null) && (i > 0) && (i < getContentTextView().fBz().length()))
      {
        localObject = getCollapseTextView();
        d.g.b.k.g(localObject, "collapseTextView");
        ((TextView)localObject).setVisibility(0);
        localObject = getCollapseTextView();
        d.g.b.k.g(localObject, "collapseTextView");
        if (j == ((TextView)localObject).getVisibility()) {
          break label206;
        }
        AppMethodBeat.o(168240);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (com.tencent.mm.sdk.platformtools.h.DEBUG)
        {
          localObject = (Throwable)localException;
          AppMethodBeat.o(168240);
          throw ((Throwable)localObject);
        }
        int i = 0;
        continue;
        localObject = getTipsTv();
        d.g.b.k.g(localObject, "tipsTv");
        ((View)localObject).setVisibility(8);
        localObject = getCollapseTextView();
        d.g.b.k.g(localObject, "collapseTextView");
        ((TextView)localObject).setVisibility(8);
      }
      label206:
      AppMethodBeat.o(168240);
    }
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168232);
    d.g.b.k.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      getContentTextView().setTag(2131306044, new int[] { i, j });
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(168232);
    return bool;
  }
  
  public final TextView getCollapseTextView()
  {
    AppMethodBeat.i(168231);
    TextView localTextView = (TextView)this.rVF.getValue();
    AppMethodBeat.o(168231);
    return localTextView;
  }
  
  public final NeatTextView getContentTextView()
  {
    AppMethodBeat.i(168230);
    NeatTextView localNeatTextView = (NeatTextView)this.rVE.getValue();
    AppMethodBeat.o(168230);
    return localNeatTextView;
  }
  
  public final int getLimitLine()
  {
    return this.rVJ;
  }
  
  public final b<Boolean, y> getOnCollapse()
  {
    return this.rVI;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(168237);
    NeatTextView localNeatTextView = getContentTextView();
    d.g.b.k.g(localNeatTextView, "contentTextView");
    int i = localNeatTextView.getCurrentTextColor();
    AppMethodBeat.o(168237);
    return i;
  }
  
  public final View getTipsTv()
  {
    AppMethodBeat.i(204106);
    View localView = (View)this.rVG.getValue();
    AppMethodBeat.o(204106);
    return localView;
  }
  
  public final void lV(boolean paramBoolean)
  {
    AppMethodBeat.i(168239);
    if (paramBoolean)
    {
      getContentTextView().setOnLongClickListener((View.OnLongClickListener)new d(this));
      getContentTextView().setOnClickListener((View.OnClickListener)new e(this));
      getContentTextView().setBackgroundResource(2131101053);
      localNeatTextView = getContentTextView();
      d.g.b.k.g(localNeatTextView, "contentTextView");
      localNeatTextView.setClickable(true);
      localNeatTextView = getContentTextView();
      d.g.b.k.g(localNeatTextView, "contentTextView");
      localNeatTextView.setLongClickable(true);
      AppMethodBeat.o(168239);
      return;
    }
    getContentTextView().setOnLongClickListener(null);
    getContentTextView().setOnClickListener(null);
    getContentTextView().setBackgroundResource(2131234429);
    NeatTextView localNeatTextView = getContentTextView();
    d.g.b.k.g(localNeatTextView, "contentTextView");
    localNeatTextView.setClickable(false);
    localNeatTextView = getContentTextView();
    d.g.b.k.g(localNeatTextView, "contentTextView");
    localNeatTextView.setLongClickable(false);
    AppMethodBeat.o(168239);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168234);
    super.onMeasure(paramInt1, paramInt2);
    if (cEE()) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(168234);
  }
  
  public final void setCollapse(boolean paramBoolean)
  {
    AppMethodBeat.i(168233);
    this.rVH = paramBoolean;
    if (paramBoolean)
    {
      localObject = getContentTextView();
      d.g.b.k.g(localObject, "contentTextView");
      if (((NeatTextView)localObject).getMaxLines() != this.rVJ)
      {
        localObject = getContentTextView();
        d.g.b.k.g(localObject, "contentTextView");
        ((NeatTextView)localObject).setMaxLines(this.rVJ);
      }
      getCollapseTextView().setText(2131759150);
      AppMethodBeat.o(168233);
      return;
    }
    Object localObject = getContentTextView();
    d.g.b.k.g(localObject, "contentTextView");
    if (((NeatTextView)localObject).getMaxLines() != 2147483647)
    {
      localObject = getContentTextView();
      d.g.b.k.g(localObject, "contentTextView");
      ((NeatTextView)localObject).setMaxLines(2147483647);
    }
    localObject = getTipsTv();
    d.g.b.k.g(localObject, "tipsTv");
    ((View)localObject).setVisibility(8);
    getCollapseTextView().setText(2131757431);
    AppMethodBeat.o(168233);
  }
  
  public final void setLimitLine(int paramInt)
  {
    this.rVJ = paramInt;
  }
  
  public final void setOnCollapse(b<? super Boolean, y> paramb)
  {
    this.rVI = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(168236);
    this.text = paramCharSequence;
    getContentTextView().ar(paramCharSequence);
    AppMethodBeat.o(168236);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(168238);
    getContentTextView().setTextColor(paramInt);
    AppMethodBeat.o(168238);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    b(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<NeatTextView>
  {
    c(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class d
    implements View.OnLongClickListener
  {
    d(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168228);
      paramView = new com.tencent.mm.ui.widget.b.a(this.rVL.getContext());
      paramView.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(210208);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousMenuItem = ai.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(210208);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(this.rVM.rVL.getContentTextView().fBz());
          }
          AppMethodBeat.o(210208);
        }
      });
      paramView.setOnDismissListener((PopupWindow.OnDismissListener)new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(210209);
          this.rVM.rVL.getContentTextView().setBackgroundResource(2131101053);
          AppMethodBeat.o(210209);
        }
      });
      this.rVL.getContentTextView().setBackgroundResource(2131100551);
      View localView = (View)this.rVL.getContentTextView();
      View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(210210);
          paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.rVM.rVL.getContext().getString(2131755701));
          AppMethodBeat.o(210210);
        }
      };
      n.d locald = (n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(210211);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousMenuItem = ai.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(210211);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(this.rVM.rVL.getContentTextView().fBz());
          }
          AppMethodBeat.o(210211);
        }
      };
      TouchableLayout.a locala = TouchableLayout.JyS;
      int i = TouchableLayout.fyY();
      locala = TouchableLayout.JyS;
      paramView.a(localView, localOnCreateContextMenuListener, locald, i, TouchableLayout.fyZ());
      AppMethodBeat.o(168228);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204104);
      this.rVL.getCollapseTextView().callOnClick();
      AppMethodBeat.o(204104);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    f(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */