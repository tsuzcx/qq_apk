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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "Lcom/tencent/mm/ui/widget/InputPanelLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "alignBtn", "Landroid/widget/ImageButton;", "alignModeChangeListener", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "curAlignMode", "curEditMode", "emojiBtn", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyTextListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getCurrentAlignMode", "hideSmileyPanel", "", "init", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "setAlignModeChangeListener", "setSmileyTextOperationListener", "showSmileyPanel", "switchAlignMode", "AlignModeChangeListener", "Companion", "plugin-finder_release"})
public final class FinderEditFooter
  extends InputPanelLinearLayout
{
  private static final int tel = 101;
  private static final int tem = 102;
  private static final int ten = 201;
  private static final int teo = 202;
  public static final FinderEditFooter.b tep;
  private String TAG;
  private ChatFooterPanel pWJ;
  private ImageButton tef;
  private ImageButton teg;
  private int teh;
  private a tei;
  private ChatFooterPanel.a tej;
  private int tek;
  
  static
  {
    AppMethodBeat.i(168575);
    tep = new FinderEditFooter.b((byte)0);
    tel = 101;
    tem = 102;
    ten = 201;
    teo = 202;
    AppMethodBeat.o(168575);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168573);
    this.TAG = "Finder.FinderEditFooter";
    this.teh = tel;
    this.tek = ten;
    init();
    AppMethodBeat.o(168573);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168574);
    this.TAG = "Finder.FinderEditFooter";
    this.teh = tel;
    this.tek = ten;
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
    this.tef = ((ImageButton)localObject);
    localObject = this.tef;
    if (localObject == null) {
      p.bcb("emojiBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new c(this));
    localObject = findViewById(2131296642);
    p.g(localObject, "findViewById(R.id.alignment_btn)");
    this.teg = ((ImageButton)localObject);
    localObject = this.teg;
    if (localObject == null) {
      p.bcb("alignBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new d(this));
    localObject = e.fet().eA(getContext());
    p.g(localObject, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
    this.pWJ = ((ChatFooterPanel)localObject);
    localObject = this.pWJ;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setEntranceScene(ChatFooterPanel.rJs);
    localObject = this.pWJ;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setVisibility(8);
    localObject = this.pWJ;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setBackgroundResource(2131231548);
    localObject = this.pWJ;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((ChatFooterPanel)localObject).fbF();
    int i = z.iI(getContext());
    localObject = this.pWJ;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    localLinearLayout.addView((View)localObject, -1, i);
    AppMethodBeat.o(168569);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(168570);
    super.g(paramBoolean, paramInt);
    ad.d(this.TAG, "isKeyboardShow " + paramBoolean + " keyboardHeight " + paramInt);
    Object localObject;
    if (paramBoolean)
    {
      this.tek = ten;
      localObject = this.tef;
      if (localObject == null) {
        p.bcb("emojiBtn");
      }
      ((ImageButton)localObject).setImageResource(2131690564);
      localObject = this.pWJ;
      if (localObject == null) {
        p.bcb("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(0);
      AppMethodBeat.o(168570);
      return;
    }
    if (this.tek == ten)
    {
      localObject = this.pWJ;
      if (localObject == null) {
        p.bcb("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    AppMethodBeat.o(168570);
  }
  
  public final int getCurrentAlignMode()
  {
    return this.teh;
  }
  
  public final void setAlignModeChangeListener(a parama)
  {
    AppMethodBeat.i(168571);
    p.h(parama, "alignModeChangeListener");
    this.tei = parama;
    AppMethodBeat.o(168571);
  }
  
  public final void setSmileyTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(168572);
    p.h(parama, "smileyTextListener");
    this.tej = parama;
    ChatFooterPanel localChatFooterPanel = this.pWJ;
    if (localChatFooterPanel == null) {
      p.bcb("smileyPanel");
    }
    localChatFooterPanel.setOnTextOperationListener(parama);
    AppMethodBeat.o(168572);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void FB(int paramInt);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168567);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      int i = FinderEditFooter.a(this.teq);
      paramView = FinderEditFooter.tep;
      if (i == FinderEditFooter.cOG())
      {
        FinderEditFooter.b(this.teq);
        paramView = this.teq.getContext();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).showVKB();
        paramView = this.teq;
        localObject = FinderEditFooter.tep;
        FinderEditFooter.a(paramView, FinderEditFooter.cOF());
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168567);
        return;
        paramView = this.teq.getContext();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).hideVKB();
        FinderEditFooter.c(this.teq);
        paramView = this.teq;
        localObject = FinderEditFooter.tep;
        FinderEditFooter.a(paramView, FinderEditFooter.cOG());
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168568);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderEditFooter.d(this.teq);
      paramView = FinderEditFooter.e(this.teq);
      if (paramView != null) {
        paramView.FB(FinderEditFooter.f(this.teq));
      }
      a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter
 * JD-Core Version:    0.7.0.1
 */