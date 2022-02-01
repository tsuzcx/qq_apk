package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.mm.model.cn;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;)V", "postTime", "", "getPostTime", "()J", "setPostTime", "(J)V", "trycount", "", "getTrycount", "()I", "setTrycount", "(I)V", "getUicallback", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "setUicallback", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "isValid", "", "uniqueId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
{
  private int Gad;
  long Gae = cn.bDu();
  private l.b GcQ = null;
  
  public e(l.b paramb) {}
  
  public void a(m.b paramb)
  {
    s.u(paramb, "callback");
    this.Gad += 1;
  }
  
  public abstract String aUE();
  
  public final boolean isValid()
  {
    long l1 = cn.bDu();
    long l2 = this.Gae;
    int i = this.Gad;
    a.a locala = a.GcD;
    if (i < a.feb()) {
      locala = a.GcD;
    }
    return l1 - l2 <= a.fea();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.e
 * JD-Core Version:    0.7.0.1
 */