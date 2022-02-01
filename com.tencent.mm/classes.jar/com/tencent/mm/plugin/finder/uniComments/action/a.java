package com.tencent.mm.plugin.finder.uniComments.action;

import com.tencent.mm.model.cn;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniAction;", "", "uicallback", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$ILikeActionCallback;)V", "postTime", "", "getPostTime", "()J", "setPostTime", "(J)V", "trycount", "", "getTrycount", "()I", "setTrycount", "(I)V", "getUicallback", "()Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$ILikeActionCallback;", "setUicallback", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask$ICallback;", "isValid", "", "uniqueId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  private d.b Gac = null;
  int Gad;
  long Gae = cn.bDu();
  
  public void a(e.b paramb)
  {
    s.u(paramb, "callback");
    this.Gad += 1;
  }
  
  public abstract String aUE();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.action.a
 * JD-Core Version:    0.7.0.1
 */