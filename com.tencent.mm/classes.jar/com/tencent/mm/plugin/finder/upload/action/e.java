package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.mm.model.cf;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;)V", "postTime", "", "getPostTime", "()J", "setPostTime", "(J)V", "trycount", "", "getTrycount", "()I", "setTrycount", "(I)V", "getUicallback", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "setUicallback", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "isValid", "", "uniqueId", "", "plugin-finder_release"})
public abstract class e
{
  private int sJZ;
  long sKa = cf.aCK();
  private g.b sKb = null;
  
  public void a(h.b paramb)
  {
    p.h(paramb, "callback");
    this.sJZ += 1;
  }
  
  public abstract String aeK();
  
  public final boolean isValid()
  {
    long l1 = cf.aCK();
    long l2 = this.sKa;
    int i = this.sJZ;
    a.a locala = a.sJK;
    if (i < a.cKQ()) {
      locala = a.sJK;
    }
    return l1 - l2 <= a.cKP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.e
 * JD-Core Version:    0.7.0.1
 */