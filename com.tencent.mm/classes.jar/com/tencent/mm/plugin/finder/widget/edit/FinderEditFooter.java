package com.tencent.mm.plugin.finder.widget.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "Lcom/tencent/mm/ui/widget/InputPanelLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "alignBtn", "Landroid/widget/ImageButton;", "alignModeChangeListener", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "curAlignMode", "curEditMode", "emojiBtn", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyTextListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getCurrentAlignMode", "hideSmileyPanel", "", "init", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "setAlignModeChangeListener", "setSmileyTextOperationListener", "showSmileyPanel", "switchAlignMode", "AlignModeChangeListener", "Companion", "plugin-finder_release"})
public final class FinderEditFooter
  extends InputPanelLinearLayout
{
  private static final int shP = 101;
  private static final int shQ = 102;
  private static final int shR = 201;
  private static final int shS = 202;
  public static final FinderEditFooter.b shT;
  private String TAG;
  private ChatFooterPanel fWT;
  private ImageButton shJ;
  private ImageButton shK;
  private int shL;
  private a shM;
  private ChatFooterPanel.a shN;
  private int shO;
  
  static
  {
    AppMethodBeat.i(168575);
    shT = new FinderEditFooter.b((byte)0);
    shP = 101;
    shQ = 102;
    shR = 201;
    shS = 202;
    AppMethodBeat.o(168575);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168573);
    this.TAG = "Finder.FinderEditFooter";
    this.shL = shP;
    this.shO = shR;
    init();
    AppMethodBeat.o(168573);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168574);
    this.TAG = "Finder.FinderEditFooter";
    this.shL = shP;
    this.shO = shR;
    init();
    AppMethodBeat.o(168574);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168569);
    View.inflate(getContext(), 2131494027, (ViewGroup)this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131304246);
    Object localObject = findViewById(2131299333);
    k.g(localObject, "findViewById(R.id.emoji_btn)");
    this.shJ = ((ImageButton)localObject);
    localObject = this.shJ;
    if (localObject == null) {
      k.aVY("emojiBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new c(this));
    localObject = findViewById(2131296642);
    k.g(localObject, "findViewById(R.id.alignment_btn)");
    this.shK = ((ImageButton)localObject);
    localObject = this.shK;
    if (localObject == null) {
      k.aVY("alignBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new d(this));
    localObject = e.ePr().eA(getContext());
    k.g(localObject, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
    this.fWT = ((ChatFooterPanel)localObject);
    localObject = this.fWT;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setEntranceScene(ChatFooterPanel.qYg);
    localObject = this.fWT;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setVisibility(8);
    localObject = this.fWT;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setBackgroundResource(2131231548);
    localObject = this.fWT;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((ChatFooterPanel)localObject).eMH();
    int i = y.iy(getContext());
    localObject = this.fWT;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    localLinearLayout.addView((View)localObject, -1, i);
    AppMethodBeat.o(168569);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(168570);
    super.g(paramBoolean, paramInt);
    ac.d(this.TAG, "isKeyboardShow " + paramBoolean + " keyboardHeight " + paramInt);
    Object localObject;
    if (paramBoolean)
    {
      this.shO = shR;
      localObject = this.shJ;
      if (localObject == null) {
        k.aVY("emojiBtn");
      }
      ((ImageButton)localObject).setImageResource(2131690564);
      localObject = this.fWT;
      if (localObject == null) {
        k.aVY("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(0);
      AppMethodBeat.o(168570);
      return;
    }
    if (this.shO == shR)
    {
      localObject = this.fWT;
      if (localObject == null) {
        k.aVY("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    AppMethodBeat.o(168570);
  }
  
  public final int getCurrentAlignMode()
  {
    return this.shL;
  }
  
  public final void setAlignModeChangeListener(a parama)
  {
    AppMethodBeat.i(168571);
    k.h(parama, "alignModeChangeListener");
    this.shM = parama;
    AppMethodBeat.o(168571);
  }
  
  public final void setSmileyTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(168572);
    k.h(parama, "smileyTextListener");
    this.shN = parama;
    ChatFooterPanel localChatFooterPanel = this.fWT;
    if (localChatFooterPanel == null) {
      k.aVY("smileyPanel");
    }
    localChatFooterPanel.setOnTextOperationListener(parama);
    AppMethodBeat.o(168572);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void Et(int paramInt);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168567);
      int i = FinderEditFooter.a(this.shU);
      paramView = FinderEditFooter.shT;
      if (i == FinderEditFooter.cGt())
      {
        FinderEditFooter.b(this.shU);
        paramView = this.shU.getContext();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).showVKB();
        paramView = this.shU;
        localb = FinderEditFooter.shT;
        FinderEditFooter.a(paramView, FinderEditFooter.cGs());
        AppMethodBeat.o(168567);
        return;
      }
      paramView = this.shU.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(168567);
        throw paramView;
      }
      ((MMActivity)paramView).hideVKB();
      FinderEditFooter.c(this.shU);
      paramView = this.shU;
      FinderEditFooter.b localb = FinderEditFooter.shT;
      FinderEditFooter.a(paramView, FinderEditFooter.cGt());
      AppMethodBeat.o(168567);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168568);
      FinderEditFooter.d(this.shU);
      paramView = FinderEditFooter.e(this.shU);
      if (paramView != null)
      {
        paramView.Et(FinderEditFooter.f(this.shU));
        AppMethodBeat.o(168568);
        return;
      }
      AppMethodBeat.o(168568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter
 * JD-Core Version:    0.7.0.1
 */