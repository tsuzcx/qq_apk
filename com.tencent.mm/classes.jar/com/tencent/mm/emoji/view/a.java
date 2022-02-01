package com.tencent.mm.emoji.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.aa;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a
{
  private final Context context;
  public final FrameLayout fSX;
  public final ChatFooterPanel fSY;
  private final ViewGroup fSZ;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105798);
    this.context = paramContext;
    this.fSZ = paramViewGroup;
    this.fSX = new FrameLayout(this.context);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.fSZ.addView((View)this.fSX, paramContext);
    this.fSX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105794);
        this.fTa.dismiss();
        AppMethodBeat.o(105794);
      }
    });
    paramContext = aa.k(this.context, false);
    k.g(paramContext, "SmileyPanelFactory.getSm…yPanel(context, darkMode)");
    this.fSY = ((ChatFooterPanel)paramContext);
    this.fSY.setEntranceScene(ChatFooterPanel.BUV);
    this.fSY.setShowSmiley(false);
    this.fSY.setShowClose(true);
    this.fSY.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, aa.bh(this.context));
    paramContext.gravity = 80;
    this.fSX.setPadding(0, 0, 0, ap.eb(this.context));
    this.fSX.addView((View)this.fSY, (ViewGroup.LayoutParams)paramContext);
    this.fSX.setVisibility(8);
    ((SmileyPanel)this.fSY).setVisibility(8);
    ((SmileyPanel)this.fSY).setTranslationY(paramContext.height);
    AppMethodBeat.o(105798);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(105797);
    float f = this.fSY.getLayoutParams().height;
    this.fSY.animate().translationY(f).withEndAction((Runnable)new a(this));
    AppMethodBeat.o(105797);
  }
  
  public void show()
  {
    AppMethodBeat.i(105796);
    this.fSX.setVisibility(0);
    this.fSY.setVisibility(0);
    this.fSY.animate().translationY(0.0F).start();
    AppMethodBeat.o(105796);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(105795);
      this.fTa.fSX.setVisibility(8);
      this.fTa.fSY.setVisibility(8);
      AppMethodBeat.o(105795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.a
 * JD-Core Version:    0.7.0.1
 */