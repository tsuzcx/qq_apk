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
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "Lcom/tencent/mm/ui/widget/InputPanelLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "alignBtn", "Landroid/widget/ImageButton;", "alignModeChangeListener", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "curAlignMode", "curEditMode", "emojiBtn", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyTextListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getCurrentAlignMode", "hideSmileyPanel", "", "init", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "setAlignModeChangeListener", "setSmileyTextOperationListener", "showSmileyPanel", "switchAlignMode", "AlignModeChangeListener", "Companion", "plugin-finder_release"})
public final class FinderEditFooter
  extends InputPanelLinearLayout
{
  private static final int BsD = 101;
  private static final int BsE = 102;
  private static final int BsF = 201;
  private static final int BsG = 202;
  public static final b BsH;
  private a BsA;
  private ChatFooterPanel.a BsB;
  private int BsC;
  private ImageButton Bsx;
  private ImageButton Bsy;
  private int Bsz;
  private String TAG;
  private ChatFooterPanel jPN;
  
  static
  {
    AppMethodBeat.i(168575);
    BsH = new b((byte)0);
    BsD = 101;
    BsE = 102;
    BsF = 201;
    BsG = 202;
    AppMethodBeat.o(168575);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168573);
    this.TAG = "Finder.FinderEditFooter";
    this.Bsz = BsD;
    this.BsC = BsF;
    init();
    AppMethodBeat.o(168573);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168574);
    this.TAG = "Finder.FinderEditFooter";
    this.Bsz = BsD;
    this.BsC = BsF;
    init();
    AppMethodBeat.o(168574);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168569);
    View.inflate(getContext(), b.g.finder_edit_footer, (ViewGroup)this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(b.f.root_layout);
    Object localObject = findViewById(b.f.emoji_btn);
    p.j(localObject, "findViewById(R.id.emoji_btn)");
    this.Bsx = ((ImageButton)localObject);
    localObject = this.Bsx;
    if (localObject == null) {
      p.bGy("emojiBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new c(this));
    localObject = findViewById(b.f.alignment_btn);
    p.j(localObject, "findViewById(R.id.alignment_btn)");
    this.Bsy = ((ImageButton)localObject);
    localObject = this.Bsy;
    if (localObject == null) {
      p.bGy("alignBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new d(this));
    localObject = e.hmu().fd(getContext());
    p.j(localObject, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
    this.jPN = ((ChatFooterPanel)localObject);
    localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setEntranceScene(ChatFooterPanel.xde);
    localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setVisibility(8);
    localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setBackgroundResource(b.e.chat_footer_bg);
    localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((ChatFooterPanel)localObject).hjp();
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    localLinearLayout.addView((View)localObject, -1, i);
    AppMethodBeat.o(168569);
  }
  
  public final int getCurrentAlignMode()
  {
    return this.Bsz;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(168570);
    super.h(paramBoolean, paramInt);
    Log.d(this.TAG, "isKeyboardShow " + paramBoolean + " keyboardHeight " + paramInt);
    Object localObject;
    if (paramBoolean)
    {
      this.BsC = BsF;
      localObject = this.Bsx;
      if (localObject == null) {
        p.bGy("emojiBtn");
      }
      ((ImageButton)localObject).setImageResource(b.i.icons_outlined_emoji);
      localObject = this.jPN;
      if (localObject == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(0);
      AppMethodBeat.o(168570);
      return;
    }
    if (this.BsC == BsF)
    {
      localObject = this.jPN;
      if (localObject == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    AppMethodBeat.o(168570);
  }
  
  public final void setAlignModeChangeListener(a parama)
  {
    AppMethodBeat.i(168571);
    p.k(parama, "alignModeChangeListener");
    this.BsA = parama;
    AppMethodBeat.o(168571);
  }
  
  public final void setSmileyTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(168572);
    p.k(parama, "smileyTextListener");
    this.BsB = parama;
    ChatFooterPanel localChatFooterPanel = this.jPN;
    if (localChatFooterPanel == null) {
      p.bGy("smileyPanel");
    }
    localChatFooterPanel.setOnTextOperationListener(parama);
    AppMethodBeat.o(168572);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void Qw(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$Companion;", "", "()V", "ALIGN_MODE_CENTER", "", "getALIGN_MODE_CENTER", "()I", "ALIGN_MODE_LEFT", "getALIGN_MODE_LEFT", "EDIT_MODE_EMOJI", "getEDIT_MODE_EMOJI", "EDIT_MODE_KEYBOARD", "getEDIT_MODE_KEYBOARD", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168567);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      int i = FinderEditFooter.a(this.BsI);
      paramView = FinderEditFooter.BsH;
      if (i == FinderEditFooter.emn())
      {
        FinderEditFooter.b(this.BsI);
        paramView = this.BsI.getContext();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).showVKB();
        paramView = this.BsI;
        localObject = FinderEditFooter.BsH;
        FinderEditFooter.a(paramView, FinderEditFooter.emm());
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168567);
        return;
        paramView = this.BsI.getContext();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).hideVKB();
        FinderEditFooter.c(this.BsI);
        paramView = this.BsI;
        localObject = FinderEditFooter.BsH;
        FinderEditFooter.a(paramView, FinderEditFooter.emn());
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168568);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderEditFooter.d(this.BsI);
      paramView = FinderEditFooter.e(this.BsI);
      if (paramView != null) {
        paramView.Qw(FinderEditFooter.f(this.BsI));
      }
      a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter
 * JD-Core Version:    0.7.0.1
 */