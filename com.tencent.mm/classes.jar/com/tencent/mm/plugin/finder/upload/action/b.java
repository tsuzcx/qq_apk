package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.mm.model.ce;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;)V", "postTime", "", "getPostTime", "()J", "setPostTime", "(J)V", "trycount", "", "getTrycount", "()I", "setTrycount", "(I)V", "getUicallback", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "setUicallback", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "isValid", "", "uniqueId", "", "plugin-finder_release"})
public abstract class b
{
  private int qRG;
  long qRH = ce.asQ();
  private d.b qRI = null;
  
  public void a(e.b paramb)
  {
    k.h(paramb, "callback");
    this.qRG += 1;
  }
  
  public abstract String abi();
  
  public final boolean isValid()
  {
    long l1 = ce.asQ();
    long l2 = this.qRH;
    int i = this.qRG;
    a.a locala = a.qRF;
    if (i < a.crI()) {
      locala = a.qRF;
    }
    return l1 - l2 <= a.crH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.b
 * JD-Core Version:    0.7.0.1
 */