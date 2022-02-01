package android.arch.b;

import android.support.v7.h.c.a;
import android.support.v7.h.c.c;

final class k$1
  extends c.a
{
  k$1(j paramj1, int paramInt1, j paramj2, c.c paramc, int paramInt2, int paramInt3) {}
  
  public final int aA()
  {
    return this.fp;
  }
  
  public final int az()
  {
    return this.fo;
  }
  
  public final Object h(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.fj.get(this.fk + paramInt1);
    Object localObject2 = this.fl;
    localObject2 = ((j)localObject2).get(((j)localObject2).fb + paramInt2);
    if ((localObject1 != null) && (localObject2 == null)) {}
    return null;
  }
  
  public final boolean i(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.fj.get(this.fk + paramInt1);
    Object localObject2 = this.fl;
    localObject2 = ((j)localObject2).get(((j)localObject2).fb + paramInt2);
    if (localObject1 == localObject2) {
      return true;
    }
    if ((localObject1 == null) || (localObject2 == null)) {
      return false;
    }
    return this.fn.c(localObject1, localObject2);
  }
  
  public final boolean j(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.fj.get(this.fk + paramInt1);
    Object localObject2 = this.fl;
    localObject2 = ((j)localObject2).get(((j)localObject2).fb + paramInt2);
    if (localObject1 == localObject2) {
      return true;
    }
    if ((localObject1 == null) || (localObject2 == null)) {
      return false;
    }
    return this.fn.d(localObject1, localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.b.k.1
 * JD-Core Version:    0.7.0.1
 */