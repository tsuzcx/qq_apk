package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "", "feedId", "", "topicType", "", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(JILjava/lang/ref/WeakReference;)V", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "getFeedId", "()J", "getTopicType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class o$a
{
  public WeakReference<Context> aWN;
  final long duw;
  final int sXu;
  
  private o$a(long paramLong)
  {
    this.duw = paramLong;
    this.sXu = 1;
    this.aWN = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205131);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.duw != paramObject.duw) || (this.sXu != paramObject.sXu) || (!p.i(this.aWN, paramObject.aWN))) {}
      }
    }
    else
    {
      AppMethodBeat.o(205131);
      return true;
    }
    AppMethodBeat.o(205131);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205130);
    long l = this.duw;
    int j = (int)(l ^ l >>> 32);
    int k = this.sXu;
    WeakReference localWeakReference = this.aWN;
    if (localWeakReference != null) {}
    for (int i = localWeakReference.hashCode();; i = 0)
    {
      AppMethodBeat.o(205130);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167910);
    String str = "ClickExtra(feedId=" + this.duw + ", topicType=" + this.sXu + ", contextRef=" + this.aWN + ")";
    AppMethodBeat.o(167910);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.o.a
 * JD-Core Version:    0.7.0.1
 */