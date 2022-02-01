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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapseTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCollapseTextView", "()Landroid/widget/TextView;", "collapseTextView$delegate", "Lkotlin/Lazy;", "contentTextView", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTextView", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "contentTextView$delegate", "value", "", "isCollapse", "()Z", "setCollapse", "(Z)V", "limitLine", "getLimitLine", "()I", "setLimitLine", "(I)V", "onCollapse", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function1;", "setOnCollapse", "(Lkotlin/jvm/functions/Function1;)V", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "getTextColor", "setTextColor", "tipsTv", "Landroid/view/View;", "getTipsTv", "()Landroid/view/View;", "tipsTv$delegate", "checkCollapseVisible", "checkCollapseVisibleSync", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enableContentTextViewClick", "enable", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "showTips", "isShow", "Companion", "plugin-finder_release"})
public final class FinderCollapsibleTextView
  extends LinearLayout
{
  public static final FinderCollapsibleTextView.a tdF;
  private final f tdA;
  private final f tdB;
  public boolean tdC;
  private d.g.a.b<? super Boolean, d.z> tdD;
  private int tdE;
  private final f tdz;
  private CharSequence text;
  
  static
  {
    AppMethodBeat.i(168229);
    tdF = new FinderCollapsibleTextView.a((byte)0);
    AppMethodBeat.o(168229);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168241);
    this.tdz = g.O((d.g.a.a)new c(this));
    this.tdA = g.O((d.g.a.a)new b(this));
    this.tdB = g.O((d.g.a.a)new f(this));
    setOrientation(1);
    com.tencent.mm.ui.z.jV(getContext()).inflate(2131494013, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(2131165274));
    ms(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.tdG;
        if (!this.tdG.tdC) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setCollapse(bool);
          if (!this.tdG.tdC)
          {
            paramAnonymousView = com.tencent.mm.ui.component.a.KEX;
            com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
            FinderHomeTabStateVM.cQP();
          }
          paramAnonymousView = this.tdG.getOnCollapse();
          if (paramAnonymousView != null) {
            paramAnonymousView.invoke(Boolean.valueOf(this.tdG.tdC));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(168223);
          return;
        }
      }
    });
    this.tdC = true;
    this.tdE = 3;
    AppMethodBeat.o(168241);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168242);
    this.tdz = g.O((d.g.a.a)new c(this));
    this.tdA = g.O((d.g.a.a)new b(this));
    this.tdB = g.O((d.g.a.a)new f(this));
    setOrientation(1);
    com.tencent.mm.ui.z.jV(getContext()).inflate(2131494013, (ViewGroup)this, true);
    getContentTextView().setSpacingAdd((int)getResources().getDimension(2131165274));
    ms(true);
    getCollapseTextView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168223);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.tdG;
        if (!this.tdG.tdC) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setCollapse(bool);
          if (!this.tdG.tdC)
          {
            paramAnonymousView = com.tencent.mm.ui.component.a.KEX;
            com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
            FinderHomeTabStateVM.cQP();
          }
          paramAnonymousView = this.tdG.getOnCollapse();
          if (paramAnonymousView != null) {
            paramAnonymousView.invoke(Boolean.valueOf(this.tdG.tdC));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(168223);
          return;
        }
      }
    });
    this.tdC = true;
    this.tdE = 3;
    AppMethodBeat.o(168242);
  }
  
  private boolean cPG()
  {
    AppMethodBeat.i(168240);
    Object localObject = getContentTextView();
    p.g(localObject, "contentTextView");
    localObject = ((NeatTextView)localObject).getLayout();
    try
    {
      i = this.tdE;
      p.g(localObject, "layout");
      i = ((com.tencent.neattextview.textview.layout.a)localObject).getOffsetForHorizontal(d.k.j.lx(i, ((com.tencent.neattextview.textview.layout.a)localObject).fXb()) - 1, 10000.0F);
      TextView localTextView = getCollapseTextView();
      p.g(localTextView, "collapseTextView");
      int j = localTextView.getVisibility();
      if ((localObject != null) && (i > 0) && (i < getContentTextView().fXo().length()))
      {
        localObject = getCollapseTextView();
        p.g(localObject, "collapseTextView");
        ((TextView)localObject).setVisibility(0);
        localObject = getCollapseTextView();
        p.g(localObject, "collapseTextView");
        if (j == ((TextView)localObject).getVisibility()) {
          break label202;
        }
        AppMethodBeat.o(168240);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (com.tencent.mm.sdk.platformtools.j.DEBUG)
        {
          localObject = (Throwable)localException;
          AppMethodBeat.o(168240);
          throw ((Throwable)localObject);
        }
        int i = 0;
        continue;
        localObject = getTipsTv();
        p.g(localObject, "tipsTv");
        ((View)localObject).setVisibility(8);
        localObject = getCollapseTextView();
        p.g(localObject, "collapseTextView");
        ((TextView)localObject).setVisibility(8);
      }
      label202:
      AppMethodBeat.o(168240);
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
      getContentTextView().setTag(2131306044, new int[] { i, j });
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(168232);
    return bool;
  }
  
  public final TextView getCollapseTextView()
  {
    AppMethodBeat.i(168231);
    TextView localTextView = (TextView)this.tdA.getValue();
    AppMethodBeat.o(168231);
    return localTextView;
  }
  
  public final NeatTextView getContentTextView()
  {
    AppMethodBeat.i(168230);
    NeatTextView localNeatTextView = (NeatTextView)this.tdz.getValue();
    AppMethodBeat.o(168230);
    return localNeatTextView;
  }
  
  public final int getLimitLine()
  {
    return this.tdE;
  }
  
  public final d.g.a.b<Boolean, d.z> getOnCollapse()
  {
    return this.tdD;
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
  
  public final View getTipsTv()
  {
    AppMethodBeat.i(205694);
    View localView = (View)this.tdB.getValue();
    AppMethodBeat.o(205694);
    return localView;
  }
  
  public final void ms(boolean paramBoolean)
  {
    AppMethodBeat.i(168239);
    if (paramBoolean)
    {
      getContentTextView().setOnLongClickListener((View.OnLongClickListener)new d(this));
      getContentTextView().setOnClickListener((View.OnClickListener)new e(this));
      getContentTextView().setBackgroundResource(2131101053);
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
    getContentTextView().setBackgroundResource(2131234429);
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
    if (cPG()) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(168234);
  }
  
  public final void setCollapse(boolean paramBoolean)
  {
    AppMethodBeat.i(168233);
    this.tdC = paramBoolean;
    if (paramBoolean)
    {
      localObject = getContentTextView();
      p.g(localObject, "contentTextView");
      if (((NeatTextView)localObject).getMaxLines() != this.tdE)
      {
        localObject = getContentTextView();
        p.g(localObject, "contentTextView");
        ((NeatTextView)localObject).setMaxLines(this.tdE);
      }
      getCollapseTextView().setText(2131759150);
      AppMethodBeat.o(168233);
      return;
    }
    Object localObject = getContentTextView();
    p.g(localObject, "contentTextView");
    if (((NeatTextView)localObject).getMaxLines() != 2147483647)
    {
      localObject = getContentTextView();
      p.g(localObject, "contentTextView");
      ((NeatTextView)localObject).setMaxLines(2147483647);
    }
    localObject = getTipsTv();
    p.g(localObject, "tipsTv");
    ((View)localObject).setVisibility(8);
    getCollapseTextView().setText(2131757431);
    AppMethodBeat.o(168233);
  }
  
  public final void setLimitLine(int paramInt)
  {
    this.tdE = paramInt;
  }
  
  public final void setOnCollapse(d.g.a.b<? super Boolean, d.z> paramb)
  {
    this.tdD = paramb;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<TextView>
  {
    b(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<NeatTextView>
  {
    c(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class d
    implements View.OnLongClickListener
  {
    d(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(168228);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = new com.tencent.mm.ui.widget.b.a(this.tdG.getContext());
      paramView.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(205688);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousMenuItem = ak.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(205688);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(this.tdH.tdG.getContentTextView().fXo());
          }
          AppMethodBeat.o(205688);
        }
      });
      paramView.setOnDismissListener((PopupWindow.OnDismissListener)new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(205689);
          this.tdH.tdG.getContentTextView().setBackgroundResource(2131101053);
          AppMethodBeat.o(205689);
        }
      });
      this.tdG.getContentTextView().setBackgroundResource(2131100551);
      localObject = (View)this.tdG.getContentTextView();
      View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(205690);
          paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.tdH.tdG.getContext().getString(2131755701));
          AppMethodBeat.o(205690);
        }
      };
      n.e locale = (n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(205691);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousMenuItem = ak.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(205691);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(this.tdH.tdG.getContentTextView().fXo());
          }
          AppMethodBeat.o(205691);
        }
      };
      TouchableLayout.a locala = TouchableLayout.LOL;
      int i = TouchableLayout.fUD();
      locala = TouchableLayout.LOL;
      paramView.a((View)localObject, localOnCreateContextMenuListener, locale, i, TouchableLayout.fUE());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(168228);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderCollapsibleTextView paramFinderCollapsibleTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205692);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.tdG.getCollapseTextView().callOnClick();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView$enableContentTextViewClick$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205692);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<View>
  {
    f(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */