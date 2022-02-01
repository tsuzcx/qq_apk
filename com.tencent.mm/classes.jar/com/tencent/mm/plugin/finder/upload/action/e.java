package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.mm.model.cl;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;)V", "postTime", "", "getPostTime", "()J", "setPostTime", "(J)V", "trycount", "", "getTrycount", "()I", "setTrycount", "(I)V", "getUicallback", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "setUicallback", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "isValid", "", "uniqueId", "", "plugin-finder_release"})
public abstract class e
{
  private int vUh;
  long vUi = cl.aWy();
  private j.b vUj = null;
  
  public e(j.b paramb) {}
  
  public void a(k.b paramb)
  {
    p.h(paramb, "callback");
    this.vUh += 1;
  }
  
  public abstract String auK();
  
  public final boolean isValid()
  {
    long l1 = cl.aWy();
    long l2 = this.vUi;
    int i = this.vUh;
    a.a locala = a.vTR;
    if (i < a.dBn()) {
      locala = a.vTR;
    }
    return l1 - l2 <= a.dBm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.e
 * JD-Core Version:    0.7.0.1
 */