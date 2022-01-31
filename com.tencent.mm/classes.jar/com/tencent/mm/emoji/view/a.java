package com.tencent.mm.emoji.view;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.api.t;
import com.tencent.mm.api.t.a;
import com.tencent.mm.api.u;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a
{
  private final Context context;
  final FrameLayout eyr;
  public final ChatFooterPanel eys;
  private final ViewGroup eyt;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(63310);
    this.context = paramContext;
    this.eyt = paramViewGroup;
    this.eyr = new FrameLayout(this.context);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.eyt.addView((View)this.eyr, paramContext);
    this.eyr.setOnClickListener((View.OnClickListener)new a.1(this));
    paramContext = u.j(this.context, false);
    j.p(paramContext, "SmileyPanelFactory.getSm…yPanel(context, darkMode)");
    this.eys = ((ChatFooterPanel)paramContext);
    this.eys.AA();
    this.eys.bo(true);
    this.eys.j(true, true);
    this.eys.setBackgroundColor(-1);
    this.eys.setEntranceScene(ChatFooterPanel.vQp);
    this.eys.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(this.context, 230));
    paramContext.gravity = 80;
    this.eyr.setPadding(0, 0, 0, am.fx(this.context));
    this.eyr.addView((View)this.eys, (ViewGroup.LayoutParams)paramContext);
    this.eyr.setVisibility(8);
    ((SmileyPanel)this.eys).setVisibility(8);
    ((SmileyPanel)this.eys).setTranslationY(paramContext.height);
    AppMethodBeat.o(63310);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(151778);
    if (this.eyr.getVisibility() == 0)
    {
      AppMethodBeat.o(151778);
      return true;
    }
    AppMethodBeat.o(151778);
    return false;
  }
  
  public final void a(t.a parama)
  {
    AppMethodBeat.i(151779);
    j.q(parama, "callback");
    t localt = u.AF();
    j.p(localt, "callbackWrapper");
    localt.a(parama);
    this.eys.setCallback((f)localt);
    AppMethodBeat.o(151779);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(63309);
    float f = this.eys.getLayoutParams().height;
    this.eys.animate().translationY(f).withEndAction((Runnable)new a.a(this));
    AppMethodBeat.o(63309);
  }
  
  public void show()
  {
    AppMethodBeat.i(63308);
    this.eyr.setVisibility(0);
    this.eys.setVisibility(0);
    this.eys.animate().translationY(0.0F).start();
    AppMethodBeat.o(63308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.view.a
 * JD-Core Version:    0.7.0.1
 */