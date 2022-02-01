package com.tencent.mm.emoji.a.c;

import com.tencent.mm.vending.e.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "isAlive", "", "()Z", "setAlive", "(Z)V", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "dead", "", "plugin-emojisdk_release"})
public abstract class a
  implements j, com.tencent.mm.vending.e.a
{
  boolean cKL;
  private final b<com.tencent.mm.vending.e.a> got;
  
  public a(b<com.tencent.mm.vending.e.a> paramb)
  {
    this.got = paramb;
    this.cKL = true;
    paramb = this.got;
    if (paramb != null) {
      paramb.keep((com.tencent.mm.vending.e.a)this);
    }
  }
  
  public void dead()
  {
    this.cKL = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c.a
 * JD-Core Version:    0.7.0.1
 */