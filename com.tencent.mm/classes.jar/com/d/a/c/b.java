package com.d.a.c;

public abstract class b
  implements Cloneable
{
  private transient int _size;
  private transient int bVq;
  private transient int bVr;
  private float bVs = 0.8F;
  private int bVt;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    gi(6);
  }
  
  private void gk(int paramInt)
  {
    this.bVt = Math.min(paramInt - 1, (int)(paramInt * this.bVs));
    this.bVq = (paramInt - this._size);
    this.bVr = 0;
  }
  
  public final void Ab()
  {
    if (this.bVr < 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.bVr -= capacity();
  }
  
  public final void Ac()
  {
    if (this.bVr >= 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.bVr += capacity();
  }
  
  protected final void bn(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.bVq -= 1;
    }
    for (;;)
    {
      int i = this._size + 1;
      this._size = i;
      if ((i > this.bVt) || (this.bVq == 0))
      {
        gj(a.gh(capacity() << 1));
        gk(capacity());
      }
      return;
      this.bVr -= 1;
    }
  }
  
  protected abstract int capacity();
  
  public void clear()
  {
    this._size = 0;
    this.bVq = capacity();
    this.bVr = 0;
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
    if (paramInt > this.bVt - size())
    {
      gj(a.gh((int)(paramInt + size() / this.bVs) + 2));
      gk(capacity());
    }
  }
  
  protected int gi(int paramInt)
  {
    paramInt = a.gh(paramInt);
    gk(paramInt);
    return paramInt;
  }
  
  protected abstract void gj(int paramInt);
  
  public boolean isEmpty()
  {
    return this._size == 0;
  }
  
  protected void removeAt(int paramInt)
  {
    this._size -= 1;
    this.bVr += 1;
    if ((this.bVr > this._size) && (capacity() > 42))
    {
      gj(a.gh((int)(size() / this.bVs) + 2));
      gk(capacity());
    }
  }
  
  public int size()
  {
    return this._size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */