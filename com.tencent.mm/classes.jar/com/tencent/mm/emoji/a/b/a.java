package com.tencent.mm.emoji.a.b;

import com.tencent.mm.vending.e.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "isAlive", "", "()Z", "setAlive", "(Z)V", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "dead", "", "plugin-emojisdk_release"})
public abstract class a
  implements j, com.tencent.mm.vending.e.a
{
  boolean czg;
  private final b<com.tencent.mm.vending.e.a> fSt;
  
  public a(b<com.tencent.mm.vending.e.a> paramb)
  {
    this.fSt = paramb;
    this.czg = true;
    paramb = this.fSt;
    if (paramb != null) {
      paramb.keep((com.tencent.mm.vending.e.a)this);
    }
  }
  
  public void dead()
  {
    this.czg = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.a
 * JD-Core Version:    0.7.0.1
 */