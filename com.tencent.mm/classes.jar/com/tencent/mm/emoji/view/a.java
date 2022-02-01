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
import com.tencent.mm.api.aa;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.SmileyPanelImpl;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/view/SmileyPanelImpl;", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "destroy", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a
{
  private final Context context;
  public final FrameLayout gsT;
  public final SmileyPanelImpl gsU;
  private final ViewGroup gsV;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105798);
    this.context = paramContext;
    this.gsV = paramViewGroup;
    this.gsT = new FrameLayout(this.context);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.gsV.addView((View)this.gsT, paramContext);
    this.gsT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105794);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.gsW.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105794);
      }
    });
    paramContext = aa.k(this.context, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.view.SmileyPanelImpl");
      AppMethodBeat.o(105798);
      throw paramContext;
    }
    this.gsU = ((SmileyPanelImpl)paramContext);
    this.gsU.setEntranceScene(ChatFooterPanel.FkL);
    this.gsU.setShowSmiley(false);
    this.gsU.setShowClose(true);
    this.gsU.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, aa.bj(this.context));
    paramContext.gravity = 80;
    this.gsT.setPadding(0, 0, 0, ar.en(this.context));
    this.gsT.addView((View)this.gsU, (ViewGroup.LayoutParams)paramContext);
    this.gsT.setVisibility(8);
    this.gsU.setVisibility(8);
    this.gsU.setTranslationY(paramContext.height);
    AppMethodBeat.o(105798);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(105797);
    float f = this.gsU.getLayoutParams().height;
    this.gsU.animate().translationY(f).withEndAction((Runnable)new a(this));
    AppMethodBeat.o(105797);
  }
  
  public void show()
  {
    AppMethodBeat.i(105796);
    this.gsT.setVisibility(0);
    this.gsU.setVisibility(0);
    this.gsU.animate().translationY(0.0F).start();
    AppMethodBeat.o(105796);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(105795);
      this.gsW.gsT.setVisibility(8);
      this.gsW.gsU.setVisibility(8);
      AppMethodBeat.o(105795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.view.a
 * JD-Core Version:    0.7.0.1
 */