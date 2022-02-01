package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "", "feedId", "", "topicType", "", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(JILjava/lang/ref/WeakReference;)V", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "getFeedId", "()J", "getTopicType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class m$a
{
  public WeakReference<Context> aMw;
  final long dig;
  final int rPI;
  
  private m$a(long paramLong)
  {
    this.dig = paramLong;
    this.rPI = 1;
    this.aMw = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203631);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.dig != paramObject.dig) || (this.rPI != paramObject.rPI) || (!k.g(this.aMw, paramObject.aMw))) {}
      }
    }
    else
    {
      AppMethodBeat.o(203631);
      return true;
    }
    AppMethodBeat.o(203631);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203630);
    long l = this.dig;
    int j = (int)(l ^ l >>> 32);
    int k = this.rPI;
    WeakReference localWeakReference = this.aMw;
    if (localWeakReference != null) {}
    for (int i = localWeakReference.hashCode();; i = 0)
    {
      AppMethodBeat.o(203630);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167910);
    String str = "ClickExtra(feedId=" + this.dig + ", topicType=" + this.rPI + ", contextRef=" + this.aMw + ")";
    AppMethodBeat.o(167910);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m.a
 * JD-Core Version:    0.7.0.1
 */