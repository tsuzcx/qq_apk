package com.tencent.mm.emoji.c.c;

import com.tencent.mm.vending.e.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "isAlive", "", "()Z", "setAlive", "(Z)V", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "dead", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements j, com.tencent.mm.vending.e.a
{
  boolean fez;
  private final b<com.tencent.mm.vending.e.a> mjD;
  
  public a(b<com.tencent.mm.vending.e.a> paramb)
  {
    this.mjD = paramb;
    this.fez = true;
    paramb = this.mjD;
    if (paramb != null) {
      paramb.keep((com.tencent.mm.vending.e.a)this);
    }
  }
  
  public void dead()
  {
    this.fez = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.a
 * JD-Core Version:    0.7.0.1
 */