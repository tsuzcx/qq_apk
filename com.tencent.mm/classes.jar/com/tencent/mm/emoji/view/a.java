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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/view/SmileyPanelImpl;", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "destroy", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a
{
  private final Context context;
  public final FrameLayout gqt;
  public final SmileyPanelImpl gqu;
  private final ViewGroup gqv;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105798);
    this.context = paramContext;
    this.gqv = paramViewGroup;
    this.gqt = new FrameLayout(this.context);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.gqv.addView((View)this.gqt, paramContext);
    this.gqt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105794);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.gqw.dismiss();
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
    this.gqu = ((SmileyPanelImpl)paramContext);
    this.gqu.setEntranceScene(ChatFooterPanel.ESq);
    this.gqu.setShowSmiley(false);
    this.gqu.setShowClose(true);
    this.gqu.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, aa.bi(this.context));
    paramContext.gravity = 80;
    this.gqt.setPadding(0, 0, 0, ar.ej(this.context));
    this.gqt.addView((View)this.gqu, (ViewGroup.LayoutParams)paramContext);
    this.gqt.setVisibility(8);
    this.gqu.setVisibility(8);
    this.gqu.setTranslationY(paramContext.height);
    AppMethodBeat.o(105798);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(105797);
    float f = this.gqu.getLayoutParams().height;
    this.gqu.animate().translationY(f).withEndAction((Runnable)new a(this));
    AppMethodBeat.o(105797);
  }
  
  public void show()
  {
    AppMethodBeat.i(105796);
    this.gqt.setVisibility(0);
    this.gqu.setVisibility(0);
    this.gqu.animate().translationY(0.0F).start();
    AppMethodBeat.o(105796);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(105795);
      this.gqw.gqt.setVisibility(8);
      this.gqw.gqu.setVisibility(8);
      AppMethodBeat.o(105795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.view.a
 * JD-Core Version:    0.7.0.1
 */