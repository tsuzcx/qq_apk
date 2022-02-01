package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.mm.model.ch;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;)V", "postTime", "", "getPostTime", "()J", "setPostTime", "(J)V", "trycount", "", "getTrycount", "()I", "setTrycount", "(I)V", "getUicallback", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "setUicallback", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "isValid", "", "uniqueId", "", "plugin-finder_release"})
public abstract class e
{
  private int sVm;
  long sVn = ch.aDa();
  private g.b sVo = null;
  
  public void a(h.b paramb)
  {
    p.h(paramb, "callback");
    this.sVm += 1;
  }
  
  public abstract String aeW();
  
  public final boolean isValid()
  {
    long l1 = ch.aDa();
    long l2 = this.sVn;
    int i = this.sVm;
    a.a locala = a.sUX;
    if (i < a.cNu()) {
      locala = a.sUX;
    }
    return l1 - l2 <= a.cNt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.e
 * JD-Core Version:    0.7.0.1
 */