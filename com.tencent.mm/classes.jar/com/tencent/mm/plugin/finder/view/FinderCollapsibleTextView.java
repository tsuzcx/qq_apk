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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.f;
import d.g;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapseTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCollapseTextView", "()Landroid/widget/TextView;", "collapseTextView$delegate", "Lkotlin/Lazy;", "contentTextView", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTextView", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "contentTextView$delegate", "value", "", "isCollapse", "()Z", "setCollapse", "(Z)V", "limitLine", "getLimitLine", "()I", "setLimitLine", "(I)V", "onCollapse", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function1;", "setOnCollapse", "(Lkotlin/jvm/functions/Function1;)V", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "getTextColor", "setTextColor", "tipsTv", "Landroid/view/View;", "getTipsTv", "()Landroid/view/View;", "tipsTv$delegate", "checkCollapseVisible", "checkCollapseVisibleSync", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enableContentTextViewClick", "enable", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "showTips", "isShow", "Companion", "plugin-finder_release"})
public final class FinderCollapsibleTextView
  extends LinearLayout
{
  public static final a qVA;
  private final f Lez;
  private final f qVv;
  private final f qVw;
  public boolean qVx;
  private b<? super Boolean, d.y> qVy;
  private int qVz;
  private CharSequence text;
  
  static
  {
    AppMethodBeat.i(168229);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderCollapsibleTextView.class), "contentTextView", "getContentTextView()Lcom/tencent/neattextview/textview/view/NeatTextView;")), (d.l.k)w.a(new u(w.bk(FinderCollapsibleTextView.class), "collapseTextView", "getCollapseTextView()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bk(FinderCollapsibleTextView.class), "tipsTv", "getTipsTv()Landroid/view/View;")) };
    qVA = new a((byte)0);
    AppMethodBeat.o(168229);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168241);
    this.qVv = g.E((d.g.a.a)new c(this));
    this.qVw = g.E((d.g.a.a)new b(this));
    this.Lez = g.E((d.g.a.a)new FinderCollapsibleTextView.f(this));
    setOrientation(1);
    com.tencent.mm.ui.y.js(getContext()).inflate(2131494013, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(2131165274));
    lk(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        paramAnonymousView = this.qVB;
        if (!this.qVB.qVx) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setCollapse(bool);
          if (!this.qVB.qVx)
          {
            paramAnonymousView = com.tencent.mm.ui.component.a.LCX;
            com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
            FinderHomeTabStateVM.fXj();
          }
          paramAnonymousView = this.qVB.getOnCollapse();
          if (paramAnonymousView == null) {
            break;
          }
          paramAnonymousView.aA(Boolean.valueOf(this.qVB.qVx));
          AppMethodBeat.o(168223);
          return;
        }
        AppMethodBeat.o(168223);
      }
    });
    this.qVx = true;
    this.qVz = 3;
    AppMethodBeat.o(168241);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168242);
    this.qVv = g.E((d.g.a.a)new c(this));
    this.qVw = g.E((d.g.a.a)new b(this));
    this.Lez = g.E((d.g.a.a)new FinderCollapsibleTextView.f(this));
    setOrientation(1);
    com.tencent.mm.ui.y.js(getContext()).inflate(2131494013, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(2131165274));
    lk(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        paramAnonymousView = this.qVB;
        if (!this.qVB.qVx) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setCollapse(bool);
          if (!this.qVB.qVx)
          {
            paramAnonymousView = com.tencent.mm.ui.component.a.LCX;
            com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
            FinderHomeTabStateVM.fXj();
          }
          paramAnonymousView = this.qVB.getOnCollapse();
          if (paramAnonymousView == null) {
            break;
          }
          paramAnonymousView.aA(Boolean.valueOf(this.qVB.qVx));
          AppMethodBeat.o(168223);
          return;
        }
        AppMethodBeat.o(168223);
      }
    });
    this.qVx = true;
    this.qVz = 3;
    AppMethodBeat.o(168242);
  }
  
  private boolean csH()
  {
    AppMethodBeat.i(168240);
    Object localObject = getContentTextView();
    d.g.b.k.g(localObject, "contentTextView");
    localObject = ((NeatTextView)localObject).getLayout();
    try
    {
      i = this.qVz;
      d.g.b.k.g(localObject, "layout");
      i = ((com.tencent.neattextview.textview.layout.a)localObject).getOffsetForHorizontal(d.k.h.kL(i, ((com.tencent.neattextview.textview.layout.a)localObject).fkV()) - 1, 10000.0F);
      TextView localTextView = getCollapseTextView();
      d.g.b.k.g(localTextView, "collapseTextView");
      int j = localTextView.getVisibility();
      if ((localObject != null) && (i > 0) && (i < getContentTextView().fli().length()))
      {
        localObject = getCollapseTextView();
        d.g.b.k.g(localObject, "collapseTextView");
        ((TextView)localObject).setVisibility(0);
        localObject = getCollapseTextView();
        d.g.b.k.g(localObject, "collapseTextView");
        if (j == ((TextView)localObject).getVisibility()) {
          break label203;
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
      label203:
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
    TextView localTextView = (TextView)this.qVw.getValue();
    AppMethodBeat.o(168231);
    return localTextView;
  }
  
  public final NeatTextView getContentTextView()
  {
    AppMethodBeat.i(168230);
    NeatTextView localNeatTextView = (NeatTextView)this.qVv.getValue();
    AppMethodBeat.o(168230);
    return localNeatTextView;
  }
  
  public final int getLimitLine()
  {
    return this.qVz;
  }
  
  public final b<Boolean, d.y> getOnCollapse()
  {
    return this.qVy;
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
    AppMethodBeat.i(200038);
    View localView = (View)this.Lez.getValue();
    AppMethodBeat.o(200038);
    return localView;
  }
  
  public final void lk(boolean paramBoolean)
  {
    AppMethodBeat.i(168239);
    if (paramBoolean)
    {
      getContentTextView().setOnLongClickListener((View.OnLongClickListener)new d(this));
      getContentTextView().setOnClickListener((View.OnClickListener)new FinderCollapsibleTextView.e(this));
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
    if (csH()) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(168234);
  }
  
  public final void setCollapse(boolean paramBoolean)
  {
    AppMethodBeat.i(168233);
    this.qVx = paramBoolean;
    if (paramBoolean)
    {
      localObject = getContentTextView();
      d.g.b.k.g(localObject, "contentTextView");
      if (((NeatTextView)localObject).getMaxLines() != this.qVz)
      {
        localObject = getContentTextView();
        d.g.b.k.g(localObject, "contentTextView");
        ((NeatTextView)localObject).setMaxLines(this.qVz);
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
    this.qVz = paramInt;
  }
  
  public final void setOnCollapse(b<? super Boolean, d.y> paramb)
  {
    this.qVy = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(168236);
    this.text = paramCharSequence;
    getContentTextView().aq(paramCharSequence);
    AppMethodBeat.o(168236);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(168238);
    getContentTextView().setTextColor(paramInt);
    AppMethodBeat.o(168238);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    b(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<NeatTextView>
  {
    c(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class d
    implements View.OnLongClickListener
  {
    d(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168228);
      paramView = new com.tencent.mm.ui.widget.b.a(this.qVB.getContext());
      paramView.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(168226);
          paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.qVC.qVB.getContext().getString(2131755701));
          AppMethodBeat.o(168226);
        }
      });
      paramView.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(168227);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousMenuItem = aj.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(168227);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(this.qVC.qVB.getContentTextView().fli());
          }
          AppMethodBeat.o(168227);
        }
      });
      paramView.setOnDismissListener((PopupWindow.OnDismissListener)new FinderCollapsibleTextView.d.3(this));
      this.qVB.getContentTextView().setBackgroundResource(2131100551);
      View localView = (View)this.qVB.getContentTextView();
      View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new FinderCollapsibleTextView.d.4(this);
      n.d locald = (n.d)new FinderCollapsibleTextView.d.5(this);
      TouchableLayout.a locala = TouchableLayout.HYe;
      int i = TouchableLayout.fiK();
      locala = TouchableLayout.HYe;
      paramView.a(localView, localOnCreateContextMenuListener, locald, i, TouchableLayout.fiL());
      AppMethodBeat.o(168228);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */