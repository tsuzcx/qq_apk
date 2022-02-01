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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a
{
  private final Context context;
  public final FrameLayout fWS;
  public final ChatFooterPanel fWT;
  private final ViewGroup fWU;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105798);
    this.context = paramContext;
    this.fWU = paramViewGroup;
    this.fWS = new FrameLayout(this.context);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.fWU.addView((View)this.fWS, paramContext);
    this.fWS.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105794);
        this.fWV.dismiss();
        AppMethodBeat.o(105794);
      }
    });
    paramContext = aa.k(this.context, false);
    k.g(paramContext, "SmileyPanelFactory.getSm…yPanel(context, darkMode)");
    this.fWT = ((ChatFooterPanel)paramContext);
    this.fWT.setEntranceScene(ChatFooterPanel.Dnl);
    this.fWT.setShowSmiley(false);
    this.fWT.setShowClose(true);
    this.fWT.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, aa.bi(this.context));
    paramContext.gravity = 80;
    this.fWS.setPadding(0, 0, 0, ap.ej(this.context));
    this.fWS.addView((View)this.fWT, (ViewGroup.LayoutParams)paramContext);
    this.fWS.setVisibility(8);
    ((SmileyPanel)this.fWT).setVisibility(8);
    ((SmileyPanel)this.fWT).setTranslationY(paramContext.height);
    AppMethodBeat.o(105798);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(105797);
    float f = this.fWT.getLayoutParams().height;
    this.fWT.animate().translationY(f).withEndAction((Runnable)new a(this));
    AppMethodBeat.o(105797);
  }
  
  public void show()
  {
    AppMethodBeat.i(105796);
    this.fWS.setVisibility(0);
    this.fWT.setVisibility(0);
    this.fWT.animate().translationY(0.0F).start();
    AppMethodBeat.o(105796);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(105795);
      this.fWV.fWS.setVisibility(8);
      this.fWV.fWT.setVisibility(8);
      AppMethodBeat.o(105795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.a
 * JD-Core Version:    0.7.0.1
 */