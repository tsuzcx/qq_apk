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
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "Lcom/tencent/mm/ui/widget/InputPanelLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "alignBtn", "Landroid/widget/ImageButton;", "alignModeChangeListener", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "curAlignMode", "curEditMode", "emojiBtn", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyTextListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getCurrentAlignMode", "hideSmileyPanel", "", "init", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "setAlignModeChangeListener", "setSmileyTextOperationListener", "showSmileyPanel", "switchAlignMode", "AlignModeChangeListener", "Companion", "plugin-finder_release"})
public final class FinderEditFooter
  extends InputPanelLinearLayout
{
  private static final int wBV = 101;
  private static final int wBW = 102;
  private static final int wBX = 201;
  private static final int wBY = 202;
  public static final b wBZ;
  private String TAG;
  private ChatFooterPanel rum;
  private ImageButton wBP;
  private ImageButton wBQ;
  private int wBR;
  private a wBS;
  private ChatFooterPanel.a wBT;
  private int wBU;
  
  static
  {
    AppMethodBeat.i(168575);
    wBZ = new b((byte)0);
    wBV = 101;
    wBW = 102;
    wBX = 201;
    wBY = 202;
    AppMethodBeat.o(168575);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168573);
    this.TAG = "Finder.FinderEditFooter";
    this.wBR = wBV;
    this.wBU = wBX;
    init();
    AppMethodBeat.o(168573);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168574);
    this.TAG = "Finder.FinderEditFooter";
    this.wBR = wBV;
    this.wBU = wBX;
    init();
    AppMethodBeat.o(168574);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168569);
    View.inflate(getContext(), 2131494236, (ViewGroup)this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131307165);
    Object localObject = findViewById(2131299945);
    p.g(localObject, "findViewById(R.id.emoji_btn)");
    this.wBP = ((ImageButton)localObject);
    localObject = this.wBP;
    if (localObject == null) {
      p.btv("emojiBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new c(this));
    localObject = findViewById(2131296719);
    p.g(localObject, "findViewById(R.id.alignment_btn)");
    this.wBQ = ((ImageButton)localObject);
    localObject = this.wBQ;
    if (localObject == null) {
      p.btv("alignBtn");
    }
    ((ImageButton)localObject).setOnClickListener((View.OnClickListener)new d(this));
    localObject = e.grv().eZ(getContext());
    p.g(localObject, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
    this.rum = ((ChatFooterPanel)localObject);
    localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setEntranceScene(ChatFooterPanel.tvw);
    localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setVisibility(8);
    localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setBackgroundResource(2131231612);
    localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((ChatFooterPanel)localObject).goD();
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    localLinearLayout.addView((View)localObject, -1, i);
    AppMethodBeat.o(168569);
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(168570);
    super.f(paramBoolean, paramInt);
    Log.d(this.TAG, "isKeyboardShow " + paramBoolean + " keyboardHeight " + paramInt);
    Object localObject;
    if (paramBoolean)
    {
      this.wBU = wBX;
      localObject = this.wBP;
      if (localObject == null) {
        p.btv("emojiBtn");
      }
      ((ImageButton)localObject).setImageResource(2131690793);
      localObject = this.rum;
      if (localObject == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(0);
      AppMethodBeat.o(168570);
      return;
    }
    if (this.wBU == wBX)
    {
      localObject = this.rum;
      if (localObject == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject).setVisibility(8);
    }
    AppMethodBeat.o(168570);
  }
  
  public final int getCurrentAlignMode()
  {
    return this.wBR;
  }
  
  public final void setAlignModeChangeListener(a parama)
  {
    AppMethodBeat.i(168571);
    p.h(parama, "alignModeChangeListener");
    this.wBS = parama;
    AppMethodBeat.o(168571);
  }
  
  public final void setSmileyTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(168572);
    p.h(parama, "smileyTextListener");
    this.wBT = parama;
    ChatFooterPanel localChatFooterPanel = this.rum;
    if (localChatFooterPanel == null) {
      p.btv("smileyPanel");
    }
    localChatFooterPanel.setOnTextOperationListener(parama);
    AppMethodBeat.o(168572);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void Lm(int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$Companion;", "", "()V", "ALIGN_MODE_CENTER", "", "getALIGN_MODE_CENTER", "()I", "ALIGN_MODE_LEFT", "getALIGN_MODE_LEFT", "EDIT_MODE_EMOJI", "getEDIT_MODE_EMOJI", "EDIT_MODE_KEYBOARD", "getEDIT_MODE_KEYBOARD", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168567);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      int i = FinderEditFooter.a(this.wCa);
      paramView = FinderEditFooter.wBZ;
      if (i == FinderEditFooter.dIW())
      {
        FinderEditFooter.b(this.wCa);
        paramView = this.wCa.getContext();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).showVKB();
        paramView = this.wCa;
        localObject = FinderEditFooter.wBZ;
        FinderEditFooter.a(paramView, FinderEditFooter.dIV());
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168567);
        return;
        paramView = this.wCa.getContext();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168567);
          throw paramView;
        }
        ((MMActivity)paramView).hideVKB();
        FinderEditFooter.c(this.wCa);
        paramView = this.wCa;
        localObject = FinderEditFooter.wBZ;
        FinderEditFooter.a(paramView, FinderEditFooter.dIW());
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderEditFooter paramFinderEditFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168568);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderEditFooter.d(this.wCa);
      paramView = FinderEditFooter.e(this.wCa);
      if (paramView != null) {
        paramView.Lm(FinderEditFooter.f(this.wCa));
      }
      a.a(this, "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter
 * JD-Core Version:    0.7.0.1
 */