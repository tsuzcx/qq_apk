package com.tencent.mm.emoji.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ae;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getPanelRoot", "()Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/view/SmileyPanelImpl;", "getSmileyPanel", "()Lcom/tencent/mm/view/SmileyPanelImpl;", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "destroy", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
{
  private final Context context;
  public final FrameLayout moA;
  public final SmileyPanelImpl moB;
  private final ViewGroup parent;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105798);
    this.context = paramContext;
    this.parent = paramViewGroup;
    this.moA = new FrameLayout(this.context);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.parent.addView((View)this.moA, paramContext);
    this.moA.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    paramContext = ae.m(this.context, true);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.SmileyPanelImpl");
      AppMethodBeat.o(105798);
      throw paramContext;
    }
    this.moB = ((SmileyPanelImpl)paramContext);
    this.moB.setEntranceScene(ChatFooterPanel.XYn);
    this.moB.setShowSmiley(false);
    this.moB.setShowClose(true);
    this.moB.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, ae.cp(this.context));
    paramContext.gravity = 80;
    this.moA.addView((View)this.moB, (ViewGroup.LayoutParams)paramContext);
    this.moA.setVisibility(8);
    this.moB.setVisibility(8);
    this.moB.setTranslationY(paramContext.height);
    AppMethodBeat.o(105798);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(242508);
    s.u(parama, "this$0");
    parama.moA.setVisibility(8);
    parama.moB.setVisibility(8);
    AppMethodBeat.o(242508);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(242505);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/view/EmojiPanelBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/emoji/view/EmojiPanelBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242505);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(105797);
    float f = this.moB.getLayoutParams().height;
    this.moB.animate().translationY(f).withEndAction(new a..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(105797);
  }
  
  public void show()
  {
    AppMethodBeat.i(105796);
    this.moB.setPadding(0, 0, 0, bf.bk(this.context));
    this.moA.setVisibility(0);
    this.moB.setVisibility(0);
    this.moB.animate().translationY(0.0F).start();
    AppMethodBeat.o(105796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.view.a
 * JD-Core Version:    0.7.0.1
 */