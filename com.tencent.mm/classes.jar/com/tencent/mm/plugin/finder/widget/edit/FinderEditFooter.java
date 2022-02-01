package com.tencent.mm.plugin.finder.widget.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "Lcom/tencent/mm/ui/widget/InputPanelLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "alignBtn", "Landroid/widget/ImageButton;", "alignModeChangeListener", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "curAlignMode", "curEditMode", "emojiBtn", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyTextListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getCurrentAlignMode", "hideSmileyPanel", "", "init", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "setAlignModeChangeListener", "setSmileyTextOperationListener", "showSmileyPanel", "switchAlignMode", "AlignModeChangeListener", "Companion", "plugin-finder_release"})
public final class FinderEditFooter
  extends InputPanelLinearLayout
{
  private static final int tpe = 101;
  private static final int tpf = 102;
  private static final int tpg = 201;
  private static final int tph = 202;
  public static final FinderEditFooter.b tpi;
  private String TAG;
  private ChatFooterPanel qdo;
  private ImageButton toY;
  private ImageButton toZ;
  private int tpa;
  private a tpb;
  private ChatFooterPanel.a tpc;
  private int tpd;
  
  static
  {
    AppMethodBeat.i(168575);
    tpi = new FinderEditFooter.b((byte)0);
    tpe = 101;
    tpf = 102;
    tpg = 201;
    tph = 202;
    AppMethodBeat.o(168575);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168573);
    this.TAG = "Finder.FinderEditFooter";
    this.tpa = tpe;
    this.tpd = tpg;
    init();
    AppMethodBeat.o(168573);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168574);
    this.TAG = "Finder.FinderEditFooter";
    this.tpa = tpe;
    this.tpd = tpg;
    init();
    AppMethodBeat.o(168574);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168569);
    View.inflate(getContext(), 2131494027, (ViewGroup)this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131304246);
    Object localObject = findViewById(2131299333);
    p.g(localObject, "findViewById(R.id.emoji_btn)");
    this.toY = ((ImageButton)localObject);
    localObject = this.toY;
    if (localObject == null) {
      p.bdF("emojiBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new c(this));
    localObject = findViewById(2131296642);
    p.g(localObject, "findViewById(R.id.alignment_btn)");
    this.toZ = ((ImageButton)localObject);
    localObject = this.toZ;
    if (localObject == null) {
      p.bdF("alignBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new d(this));
    localObject = e.fij().eE(getContext());
    p.g(localObject, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
    this.qdo = ((ChatFooterPanel)localObject);
    localObject = this.qdo;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setEntranceScene(ChatFooterPanel.rRG);
    localObject = this.qdo;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setVisibility(8);
    localObject = this.qdo;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setBackgroundResource(2131231548);
    localObject = this.qdo;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((ChatFooterPanel)localObject).fft();
    int i = aa.iN(getContext());
    localObject = this.qdo;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    localLinearLayout.addView((View)localObject, -1, i);
    AppMethodBeat.o(168569);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(168570);
    super.g(paramBoolean, paramInt);
    ae.d(this.TAG, "isKeyboardShow " + paramBoolean + " keyboardHeight " + paramInt);
    Object localObject;
    if (paramBoolean)
    {
      this.tpd = tpg;
      localObject = this.toY;
      if (localObject == null) {
        p.bdF("emojiBtn");
      }
      ((ImageButton)localObject).setImageResource(2131690564);
      localObject = this.qdo;
      if (localObject == null) {
        p.bdF("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(0);
      AppMethodBeat.o(168570);
      return;
    }
    if (this.tpd == tpg)
    {
      localObject = this.qdo;
      if (localObject == null) {
        p.bdF("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    AppMethodBeat.o(168570);
  }
  
  public final int getCurrentAlignMode()
  {
    return this.tpa;
  }
  
  public final void setAlignModeChangeListener(a parama)
  {
    AppMethodBeat.i(168571);
    p.h(parama, "alignModeChangeListener");
    this.tpb = parama;
    AppMethodBeat.o(168571);
  }
  
  public final void setSmileyTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(168572);
    p.h(parama, "smileyTextListener");
    this.tpc = parama;
    ChatFooterPanel localChatFooterPanel = this.qdo;
    if (localChatFooterPanel == null) {
      p.bdF("smileyPanel");
    }
    localChatFooterPanel.setOnTextOperationListener(parama);
    AppMethodBeat.o(168572);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void FZ(int paramInt);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168567);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      int i = FinderEditFooter.a(this.tpj);
      paramView = FinderEditFooter.tpi;
      if (i == FinderEditFooter.cRl())
      {
        FinderEditFooter.b(this.tpj);
        paramView = this.tpj.getContext();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).showVKB();
        paramView = this.tpj;
        localObject = FinderEditFooter.tpi;
        FinderEditFooter.a(paramView, FinderEditFooter.cRk());
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168567);
        return;
        paramView = this.tpj.getContext();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).hideVKB();
        FinderEditFooter.c(this.tpj);
        paramView = this.tpj;
        localObject = FinderEditFooter.tpi;
        FinderEditFooter.a(paramView, FinderEditFooter.cRl());
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168568);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      FinderEditFooter.d(this.tpj);
      paramView = FinderEditFooter.e(this.tpj);
      if (paramView != null) {
        paramView.FZ(FinderEditFooter.f(this.tpj));
      }
      a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter
 * JD-Core Version:    0.7.0.1
 */