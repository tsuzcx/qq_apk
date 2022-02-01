package com.tencent.mm.plugin.gamelife.ui;

import android.view.ViewGroup;
import com.tencent.mm.plugin.gamelife.f.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "getDelegate", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "pos", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "Delegate", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  private final a JcB;
  
  public f(a parama)
  {
    this.JcB = parama;
  }
  
  public abstract b.b O(ViewGroup paramViewGroup);
  
  public abstract void a(b.b paramb, int paramInt);
  
  protected final a fIE()
  {
    return this.JcB;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "", "getDataListNum", "", "getItem", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract a XT(int paramInt);
    
    public abstract int fIy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.f
 * JD-Core Version:    0.7.0.1
 */