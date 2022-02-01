package com.tencent.mm.plugin.gamelife.ui;

import android.view.ViewGroup;
import com.tencent.mm.plugin.gamelife.e.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "getDelegate", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "pos", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "Delegate", "plugin-gamelife_release"})
public abstract class f
{
  final a uKV;
  
  public f(a parama)
  {
    this.uKV = parama;
  }
  
  public abstract void a(b.b paramb, int paramInt);
  
  public abstract b.b t(ViewGroup paramViewGroup);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "", "getDataListNum", "", "getItem", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "plugin-gamelife_release"})
  public static abstract interface a
  {
    public abstract a IC(int paramInt);
    
    public abstract int ddD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.f
 * JD-Core Version:    0.7.0.1
 */