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
import com.tencent.mm.ui.au;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getPanelRoot", "()Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/view/SmileyPanelImpl;", "getSmileyPanel", "()Lcom/tencent/mm/view/SmileyPanelImpl;", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "destroy", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a
{
  private final Context context;
  public final FrameLayout hed;
  public final SmileyPanelImpl hee;
  private final ViewGroup parent;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105798);
    this.context = paramContext;
    this.parent = paramViewGroup;
    this.hed = new FrameLayout(this.context);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.parent.addView((View)this.hed, paramContext);
    this.hed.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105794);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.hef.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105794);
      }
    });
    paramContext = ad.l(this.context, true);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.view.SmileyPanelImpl");
      AppMethodBeat.o(105798);
      throw paramContext;
    }
    this.hee = ((SmileyPanelImpl)paramContext);
    this.hee.setEntranceScene(ChatFooterPanel.KbD);
    this.hee.setShowSmiley(false);
    this.hee.setShowClose(true);
    this.hee.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, ad.bD(this.context));
    paramContext.gravity = 80;
    this.hed.addView((View)this.hee, (ViewGroup.LayoutParams)paramContext);
    this.hed.setVisibility(8);
    this.hee.setVisibility(8);
    this.hee.setTranslationY(paramContext.height);
    AppMethodBeat.o(105798);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(105797);
    float f = this.hee.getLayoutParams().height;
    this.hee.animate().translationY(f).withEndAction((Runnable)new a(this));
    AppMethodBeat.o(105797);
  }
  
  public void show()
  {
    AppMethodBeat.i(105796);
    this.hee.setPadding(0, 0, 0, au.aD(this.context));
    this.hed.setVisibility(0);
    this.hee.setVisibility(0);
    this.hee.animate().translationY(0.0F).start();
    AppMethodBeat.o(105796);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(105795);
      this.hef.hed.setVisibility(8);
      this.hef.hee.setVisibility(8);
      AppMethodBeat.o(105795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.view.a
 * JD-Core Version:    0.7.0.1
 */