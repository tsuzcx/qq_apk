package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "", "feedId", "", "topicType", "", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(JILjava/lang/ref/WeakReference;)V", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "getFeedId", "()J", "getTopicType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-base_release"})
public final class c
{
  public WeakReference<Context> aFX;
  final long feedId;
  final int wXA;
  
  public c(long paramLong, int paramInt, WeakReference<Context> paramWeakReference)
  {
    this.feedId = paramLong;
    this.wXA = paramInt;
    this.aFX = paramWeakReference;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(259669);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.feedId != paramObject.feedId) || (this.wXA != paramObject.wXA) || (!p.h(this.aFX, paramObject.aFX))) {}
      }
    }
    else
    {
      AppMethodBeat.o(259669);
      return true;
    }
    AppMethodBeat.o(259669);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(259668);
    long l = this.feedId;
    int j = (int)(l ^ l >>> 32);
    int k = this.wXA;
    WeakReference localWeakReference = this.aFX;
    if (localWeakReference != null) {}
    for (int i = localWeakReference.hashCode();; i = 0)
    {
      AppMethodBeat.o(259668);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(259666);
    String str = "ClickExtra(feedId=" + this.feedId + ", topicType=" + this.wXA + ", contextRef=" + this.aFX + ")";
    AppMethodBeat.o(259666);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.c
 * JD-Core Version:    0.7.0.1
 */