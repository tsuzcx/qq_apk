package com.tencent.mm.loader.g;

import a.f.b.j;
import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/loader/LoaderPair;", "A", "B", "", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "setSecond", "(Ljava/lang/Object;)V", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/loader/loader/LoaderPair;", "equals", "", "other", "hashCode", "", "toString", "", "libimageloader_release"})
public final class g<A, B>
{
  final A first;
  B second;
  
  public g(A paramA, B paramB)
  {
    this.first = paramA;
    this.second = paramB;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!j.e(this.first, paramObject.first)) || (!j.e(this.second, paramObject.second))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    Object localObject = this.first;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.second;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    return "LoaderPair(first=" + this.first + ", second=" + this.second + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.g
 * JD-Core Version:    0.7.0.1
 */