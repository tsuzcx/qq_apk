package android.support.v4.f;

public class k$b<T>
  implements k.a<T>
{
  private final Object[] Eq;
  private int Er;
  
  public k$b(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    this.Eq = new Object[paramInt];
  }
  
  public boolean D(T paramT)
  {
    boolean bool = false;
    int i = 0;
    if (i < this.Er) {
      if (this.Eq[i] != paramT) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label50;
      }
      throw new IllegalStateException("Already in the pool!");
      i += 1;
      break;
    }
    label50:
    if (this.Er < this.Eq.length)
    {
      this.Eq[this.Er] = paramT;
      this.Er += 1;
      bool = true;
    }
    return bool;
  }
  
  public T de()
  {
    if (this.Er > 0)
    {
      int i = this.Er - 1;
      Object localObject = this.Eq[i];
      this.Eq[i] = null;
      this.Er -= 1;
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.f.k.b
 * JD-Core Version:    0.7.0.1
 */