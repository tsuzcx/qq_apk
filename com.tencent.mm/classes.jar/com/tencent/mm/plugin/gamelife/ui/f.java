package com.tencent.mm.plugin.gamelife.ui;

import android.view.ViewGroup;
import com.tencent.mm.plugin.gamelife.e.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "getDelegate", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "pos", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "Delegate", "plugin-gamelife_release"})
public abstract class f
{
  final a ydp;
  
  public f(a parama)
  {
    this.ydp = parama;
  }
  
  public abstract void a(b.b paramb, int paramInt);
  
  public abstract b.b y(ViewGroup paramViewGroup);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "", "getDataListNum", "", "getItem", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "plugin-gamelife_release"})
  public static abstract interface a
  {
    public abstract a OD(int paramInt);
    
    public abstract int dXo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.f
 * JD-Core Version:    0.7.0.1
 */