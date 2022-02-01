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
import com.tencent.mm.api.ad;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.ui.ax;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getPanelRoot", "()Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/view/SmileyPanelImpl;", "getSmileyPanel", "()Lcom/tencent/mm/view/SmileyPanelImpl;", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "destroy", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a
{
  private final Context context;
  public final FrameLayout jPJ;
  public final SmileyPanelImpl jPK;
  private final ViewGroup parent;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105798);
    this.context = paramContext;
    this.parent = paramViewGroup;
    this.jPJ = new FrameLayout(this.context);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.parent.addView((View)this.jPJ, paramContext);
    this.jPJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105794);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.jPL.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105794);
      }
    });
    paramContext = ad.m(this.context, true);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.view.SmileyPanelImpl");
      AppMethodBeat.o(105798);
      throw paramContext;
    }
    this.jPK = ((SmileyPanelImpl)paramContext);
    this.jPK.setEntranceScene(ChatFooterPanel.Rci);
    this.jPK.setShowSmiley(false);
    this.jPK.setShowClose(true);
    this.jPK.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, ad.bC(this.context));
    paramContext.gravity = 80;
    this.jPJ.addView((View)this.jPK, (ViewGroup.LayoutParams)paramContext);
    this.jPJ.setVisibility(8);
    this.jPK.setVisibility(8);
    this.jPK.setTranslationY(paramContext.height);
    AppMethodBeat.o(105798);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(105797);
    float f = this.jPK.getLayoutParams().height;
    this.jPK.animate().translationY(f).withEndAction((Runnable)new a(this));
    AppMethodBeat.o(105797);
  }
  
  public void show()
  {
    AppMethodBeat.i(105796);
    this.jPK.setPadding(0, 0, 0, ax.aB(this.context));
    this.jPJ.setVisibility(0);
    this.jPK.setVisibility(0);
    this.jPK.animate().translationY(0.0F).start();
    AppMethodBeat.o(105796);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(105795);
      this.jPL.jPJ.setVisibility(8);
      this.jPL.jPK.setVisibility(8);
      AppMethodBeat.o(105795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.a
 * JD-Core Version:    0.7.0.1
 */