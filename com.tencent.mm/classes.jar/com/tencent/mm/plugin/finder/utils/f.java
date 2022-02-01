package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "", "feedId", "", "topicType", "", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "isTopicTag", "", "(JILjava/lang/ref/WeakReference;Ljava/lang/Boolean;)V", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "getFeedId", "()J", "()Ljava/lang/Boolean;", "setTopicTag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTopicType", "()I", "component1", "component2", "component3", "component4", "copy", "(JILjava/lang/ref/WeakReference;Ljava/lang/Boolean;)Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "equals", "other", "hashCode", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  final int Auy;
  public Boolean GfY;
  public WeakReference<Context> contextRef;
  final long feedId;
  
  private f(long paramLong, int paramInt, WeakReference<Context> paramWeakReference, Boolean paramBoolean)
  {
    this.feedId = paramLong;
    this.Auy = paramInt;
    this.contextRef = paramWeakReference;
    this.GfY = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(333818);
    if (this == paramObject)
    {
      AppMethodBeat.o(333818);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(333818);
      return false;
    }
    paramObject = (f)paramObject;
    if (this.feedId != paramObject.feedId)
    {
      AppMethodBeat.o(333818);
      return false;
    }
    if (this.Auy != paramObject.Auy)
    {
      AppMethodBeat.o(333818);
      return false;
    }
    if (!s.p(this.contextRef, paramObject.contextRef))
    {
      AppMethodBeat.o(333818);
      return false;
    }
    if (!s.p(this.GfY, paramObject.GfY))
    {
      AppMethodBeat.o(333818);
      return false;
    }
    AppMethodBeat.o(333818);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(333811);
    int k = q.a..ExternalSyntheticBackport0.m(this.feedId);
    int m = this.Auy;
    int i;
    if (this.contextRef == null)
    {
      i = 0;
      if (this.GfY != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(333811);
      return (i + (k * 31 + m) * 31) * 31 + j;
      i = this.contextRef.hashCode();
      break;
      label71:
      j = this.GfY.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(333808);
    String str = "ClickExtra(feedId=" + this.feedId + ", topicType=" + this.Auy + ", contextRef=" + this.contextRef + ", isTopicTag=" + this.GfY + ')';
    AppMethodBeat.o(333808);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.f
 * JD-Core Version:    0.7.0.1
 */