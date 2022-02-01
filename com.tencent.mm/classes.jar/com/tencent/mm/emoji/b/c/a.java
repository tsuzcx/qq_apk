package com.tencent.mm.emoji.b.c;

import com.tencent.mm.vending.e.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "isAlive", "", "()Z", "setAlive", "(Z)V", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "dead", "", "plugin-emojisdk_release"})
public abstract class a
  implements j, com.tencent.mm.vending.e.a
{
  boolean dbi;
  private final b<com.tencent.mm.vending.e.a> gZm;
  
  public a(b<com.tencent.mm.vending.e.a> paramb)
  {
    this.gZm = paramb;
    this.dbi = true;
    paramb = this.gZm;
    if (paramb != null) {
      paramb.keep((com.tencent.mm.vending.e.a)this);
    }
  }
  
  public void dead()
  {
    this.dbi = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.a
 * JD-Core Version:    0.7.0.1
 */