package com.tencent.mm.loader.f;

import java.util.Queue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/LoaderPair;", "A", "B", "", "first", "second", "Ljava/util/Queue;", "(Ljava/lang/Object;Ljava/util/Queue;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "()Ljava/util/Queue;", "setSecond", "(Ljava/util/Queue;)V", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/util/Queue;)Lcom/tencent/mm/loader/loader/LoaderPair;", "equals", "", "other", "hashCode", "", "toString", "", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<A, B>
{
  public final A bsC;
  Queue<B> nru;
  
  public f(A paramA, Queue<B> paramQueue)
  {
    this.bsC = paramA;
    this.nru = paramQueue;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        return false;
      }
      paramObject = (f)paramObject;
      if (!s.p(this.bsC, paramObject.bsC)) {
        return false;
      }
    } while (s.p(this.nru, paramObject.nru));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.bsC == null) {}
    for (int i = 0;; i = this.bsC.hashCode()) {
      return i * 31 + this.nru.hashCode();
    }
  }
  
  public final String toString()
  {
    return "LoaderPair(first=" + this.bsC + ", second=" + this.nru + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f.f
 * JD-Core Version:    0.7.0.1
 */