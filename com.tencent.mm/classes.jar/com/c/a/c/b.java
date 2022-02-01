package com.c.a.c;

public abstract class b
  implements Cloneable
{
  private transient int _size;
  private transient int cqg;
  private transient int cqh;
  private float cqi = 0.8F;
  private int cqj;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    hw(6);
  }
  
  private void hy(int paramInt)
  {
    this.cqj = Math.min(paramInt - 1, (int)(paramInt * this.cqi));
    this.cqg = (paramInt - this._size);
    this.cqh = 0;
  }
  
  public final void Kr()
  {
    if (this.cqh < 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.cqh -= capacity();
  }
  
  public final void Ks()
  {
    if (this.cqh >= 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.cqh += capacity();
  }
  
  protected final void bO(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.cqg -= 1;
    }
    for (;;)
    {
      int i = this._size + 1;
      this._size = i;
      if ((i > this.cqj) || (this.cqg == 0))
      {
        hx(a.hv(capacity() << 1));
        hy(capacity());
      }
      return;
      this.cqh -= 1;
    }
  }
  
  protected abstract int capacity();
  
  public void clear()
  {
    this._size = 0;
    this.cqg = capacity();
    this.cqh = 0;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public final void ensureCapacity(int paramInt)
  {
    if (paramInt > this.cqj - size())
    {
      hx(a.hv((int)(paramInt + size() / this.cqi) + 2));
      hy(capacity());
    }
  }
  
  protected int hw(int paramInt)
  {
    paramInt = a.hv(paramInt);
    hy(paramInt);
    return paramInt;
  }
  
  protected abstract void hx(int paramInt);
  
  public boolean isEmpty()
  {
    return this._size == 0;
  }
  
  protected void removeAt(int paramInt)
  {
    this._size -= 1;
    this.cqh += 1;
    if ((this.cqh > this._size) && (capacity() > 42))
    {
      hx(a.hv((int)(size() / this.cqi) + 2));
      hy(capacity());
    }
  }
  
  public int size()
  {
    return this._size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.c.b
 * JD-Core Version:    0.7.0.1
 */