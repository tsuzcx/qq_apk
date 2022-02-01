package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.mm.model.cm;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;)V", "postTime", "", "getPostTime", "()J", "setPostTime", "(J)V", "trycount", "", "getTrycount", "()I", "setTrycount", "(I)V", "getUicallback", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "setUicallback", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "isValid", "", "uniqueId", "", "plugin-finder_release"})
public abstract class e
{
  private int ABK;
  long ABL = cm.bfC();
  private l.b ABM = null;
  
  public e(l.b paramb) {}
  
  public void a(m.b paramb)
  {
    p.k(paramb, "callback");
    this.ABK += 1;
  }
  
  public abstract String aBG();
  
  public final boolean isValid()
  {
    long l1 = cm.bfC();
    long l2 = this.ABL;
    int i = this.ABK;
    a.a locala = a.ABu;
    if (i < a.ecv()) {
      locala = a.ABu;
    }
    return l1 - l2 <= a.ecu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.e
 * JD-Core Version:    0.7.0.1
 */