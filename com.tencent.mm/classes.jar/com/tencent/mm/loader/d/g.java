package com.tencent.mm.loader.d;

import com.tencent.mm.loader.e.e;
import com.tencent.mm.loader.g.a.a;

public final class g<T, R>
  implements e<T, R>
{
  private e<T, R> nqA = null;
  
  public final void onImageLoadComplete(a<T> parama, com.tencent.mm.loader.d.b.g<?> paramg, R paramR)
  {
    if (this.nqA != null) {
      this.nqA.onImageLoadComplete(parama, paramg, paramR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.g
 * JD-Core Version:    0.7.0.1
 */