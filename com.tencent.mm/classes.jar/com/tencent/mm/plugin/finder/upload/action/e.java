package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.mm.model.ce;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;)V", "postTime", "", "getPostTime", "()J", "setPostTime", "(J)V", "trycount", "", "getTrycount", "()I", "setTrycount", "(I)V", "getUicallback", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "setUicallback", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "isValid", "", "uniqueId", "", "plugin-finder_release"})
public abstract class e
{
  private int rNU;
  long rNV = ce.azH();
  private g.b rNW = null;
  
  public void a(h.b paramb)
  {
    k.h(paramb, "callback");
    this.rNU += 1;
  }
  
  public abstract String acg();
  
  public final boolean isValid()
  {
    long l1 = ce.azH();
    long l2 = this.rNV;
    int i = this.rNU;
    a.a locala = a.rNF;
    if (i < a.cCD()) {
      locala = a.rNF;
    }
    return l1 - l2 <= a.cCC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.e
 * JD-Core Version:    0.7.0.1
 */