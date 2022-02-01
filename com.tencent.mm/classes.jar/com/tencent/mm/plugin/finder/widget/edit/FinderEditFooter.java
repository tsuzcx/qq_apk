package com.tencent.mm.plugin.finder.widget.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "Lcom/tencent/mm/ui/widget/InputPanelLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "alignBtn", "Landroid/widget/ImageButton;", "alignModeChangeListener", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "curAlignMode", "curEditMode", "emojiBtn", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyTextListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getCurrentAlignMode", "hideSmileyPanel", "", "init", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "setAlignModeChangeListener", "setSmileyTextOperationListener", "showSmileyPanel", "switchAlignMode", "AlignModeChangeListener", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEditFooter
  extends InputPanelLinearLayout
{
  private static final int GZA;
  public static final FinderEditFooter.b GZq;
  private static final int GZx;
  private static final int GZy;
  private static final int GZz;
  private ImageButton GZr;
  private ImageButton GZs;
  private int GZt;
  private a GZu;
  private ChatFooterPanel.a GZv;
  private int GZw;
  private String TAG;
  private ChatFooterPanel moD;
  
  static
  {
    AppMethodBeat.i(168575);
    GZq = new FinderEditFooter.b((byte)0);
    GZx = 101;
    GZy = 102;
    GZz = 201;
    GZA = 202;
    AppMethodBeat.o(168575);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168573);
    this.TAG = "Finder.FinderEditFooter";
    this.GZt = GZx;
    this.GZw = GZz;
    init();
    AppMethodBeat.o(168573);
  }
  
  public FinderEditFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168574);
    this.TAG = "Finder.FinderEditFooter";
    this.GZt = GZx;
    this.GZw = GZz;
    init();
    AppMethodBeat.o(168574);
  }
  
  private static final void a(FinderEditFooter paramFinderEditFooter, View paramView)
  {
    ImageButton localImageButton = null;
    Object localObject1 = null;
    AppMethodBeat.i(330779);
    Object localObject2 = new Object();
    b localb = new b();
    localb.cH(paramFinderEditFooter);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramFinderEditFooter, "this$0");
    if (paramFinderEditFooter.GZw == GZA)
    {
      localImageButton = paramFinderEditFooter.GZr;
      paramView = localImageButton;
      if (localImageButton == null)
      {
        s.bIx("emojiBtn");
        paramView = null;
      }
      paramView.setImageResource(e.g.icons_outlined_emoji);
      paramView = paramFinderEditFooter.moD;
      if (paramView == null)
      {
        s.bIx("smileyPanel");
        paramView = (View)localObject1;
      }
      for (;;)
      {
        paramView.onPause();
        paramView = paramFinderEditFooter.getContext();
        if (paramView != null) {
          break;
        }
        paramFinderEditFooter = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(330779);
        throw paramFinderEditFooter;
      }
      ((MMActivity)paramView).showVKB();
      paramFinderEditFooter.GZw = GZz;
      a.a(new Object(), "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(330779);
      return;
    }
    paramView = paramFinderEditFooter.getContext();
    if (paramView == null)
    {
      paramFinderEditFooter = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(330779);
      throw paramFinderEditFooter;
    }
    ((MMActivity)paramView).hideVKB();
    localObject1 = paramFinderEditFooter.GZr;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      s.bIx("emojiBtn");
      paramView = null;
    }
    paramView.setImageResource(e.g.icons_outlined_keyboard);
    localObject1 = paramFinderEditFooter.moD;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      s.bIx("smileyPanel");
      paramView = null;
    }
    paramView.setVisibility(0);
    paramView = paramFinderEditFooter.moD;
    if (paramView == null)
    {
      s.bIx("smileyPanel");
      paramView = localImageButton;
    }
    for (;;)
    {
      paramView.onResume();
      paramFinderEditFooter.GZw = GZA;
      break;
    }
  }
  
  private static final void b(FinderEditFooter paramFinderEditFooter, View paramView)
  {
    ImageButton localImageButton = null;
    AppMethodBeat.i(330792);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderEditFooter);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderEditFooter, "this$0");
    int i = paramFinderEditFooter.GZt;
    if (i == GZy)
    {
      paramFinderEditFooter.GZt = GZx;
      localImageButton = paramFinderEditFooter.GZs;
      paramView = localImageButton;
      if (localImageButton == null)
      {
        s.bIx("alignBtn");
        paramView = null;
      }
      paramView.setImageResource(e.g.icons_outlined_alignment_left);
    }
    while (i != GZx)
    {
      paramView = paramFinderEditFooter.GZu;
      if (paramView != null) {
        paramView.TE(paramFinderEditFooter.GZt);
      }
      a.a(new Object(), "com/tencent/mm/plugin/finder/widget/edit/FinderEditFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(330792);
      return;
    }
    paramFinderEditFooter.GZt = GZy;
    paramView = paramFinderEditFooter.GZs;
    if (paramView == null)
    {
      s.bIx("alignBtn");
      paramView = localImageButton;
    }
    for (;;)
    {
      paramView.setImageResource(e.g.icons_outlined_alignment_center);
      break;
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(168569);
    View.inflate(getContext(), e.f.finder_edit_footer, (ViewGroup)this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(e.e.root_layout);
    Object localObject1 = findViewById(e.e.emoji_btn);
    s.s(localObject1, "findViewById(R.id.emoji_btn)");
    this.GZr = ((ImageButton)localObject1);
    Object localObject2 = this.GZr;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("emojiBtn");
      localObject1 = null;
    }
    ((ImageButton)localObject1).setOnClickListener(new FinderEditFooter..ExternalSyntheticLambda1(this));
    localObject1 = findViewById(e.e.alignment_btn);
    s.s(localObject1, "findViewById(R.id.alignment_btn)");
    this.GZs = ((ImageButton)localObject1);
    localObject2 = this.GZs;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("alignBtn");
      localObject1 = null;
    }
    ((ImageButton)localObject1).setOnClickListener(new FinderEditFooter..ExternalSyntheticLambda0(this));
    localObject1 = e.Ykf.fZ(getContext());
    s.s(localObject1, "getSmileyPanel().getSmileyPanel(context)");
    this.moD = ((ChatFooterPanel)localObject1);
    localObject2 = this.moD;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setEntranceScene(ChatFooterPanel.ACC);
    localObject2 = this.moD;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setVisibility(8);
    localObject2 = this.moD;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setBackgroundResource(e.d.chat_footer_bg);
    localObject2 = this.moD;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).iKh();
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    localObject2 = this.moD;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    localLinearLayout.addView((View)localObject1, -1, i);
    AppMethodBeat.o(168569);
  }
  
  public final int getCurrentAlignMode()
  {
    return this.GZt;
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    Object localObject = null;
    ChatFooterPanel localChatFooterPanel = null;
    AppMethodBeat.i(168570);
    super.onInputPanelChange(paramBoolean, paramInt);
    Log.d(this.TAG, "isKeyboardShow " + paramBoolean + " keyboardHeight " + paramInt);
    if (paramBoolean)
    {
      this.GZw = GZz;
      ImageButton localImageButton = this.GZr;
      localObject = localImageButton;
      if (localImageButton == null)
      {
        s.bIx("emojiBtn");
        localObject = null;
      }
      ((ImageButton)localObject).setImageResource(e.g.icons_outlined_emoji);
      localObject = this.moD;
      if (localObject == null)
      {
        s.bIx("smileyPanel");
        localObject = localChatFooterPanel;
      }
      for (;;)
      {
        ((ChatFooterPanel)localObject).setVisibility(0);
        AppMethodBeat.o(168570);
        return;
      }
    }
    if (this.GZw == GZz)
    {
      localChatFooterPanel = this.moD;
      if (localChatFooterPanel != null) {
        break label161;
      }
      s.bIx("smileyPanel");
    }
    for (;;)
    {
      ((ChatFooterPanel)localObject).setVisibility(8);
      AppMethodBeat.o(168570);
      return;
      label161:
      localObject = localChatFooterPanel;
    }
  }
  
  public final void setAlignModeChangeListener(a parama)
  {
    AppMethodBeat.i(168571);
    s.u(parama, "alignModeChangeListener");
    this.GZu = parama;
    AppMethodBeat.o(168571);
  }
  
  public final void setSmileyTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(168572);
    s.u(parama, "smileyTextListener");
    this.GZv = parama;
    ChatFooterPanel localChatFooterPanel2 = this.moD;
    ChatFooterPanel localChatFooterPanel1 = localChatFooterPanel2;
    if (localChatFooterPanel2 == null)
    {
      s.bIx("smileyPanel");
      localChatFooterPanel1 = null;
    }
    localChatFooterPanel1.setOnTextOperationListener(parama);
    AppMethodBeat.o(168572);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void TE(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter
 * JD-Core Version:    0.7.0.1
 */