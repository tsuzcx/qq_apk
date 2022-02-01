package com.d.a.c;

public abstract class b
  implements Cloneable
{
  private transient int _size;
  private transient int bXI;
  private transient int bXJ;
  private float bXK = 0.8F;
  private int bXL;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    gx(6);
  }
  
  private void gz(int paramInt)
  {
    this.bXL = Math.min(paramInt - 1, (int)(paramInt * this.bXK));
    this.bXI = (paramInt - this._size);
    this.bXJ = 0;
  }
  
  public final void Ao()
  {
    if (this.bXJ < 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.bXJ -= capacity();
  }
  
  public final void Ap()
  {
    if (this.bXJ >= 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.bXJ += capacity();
  }
  
  protected final void bo(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.bXI -= 1;
    }
    for (;;)
    {
      int i = this._size + 1;
      this._size = i;
      if ((i > this.bXL) || (this.bXI == 0))
      {
        gy(a.gw(capacity() << 1));
        gz(capacity());
      }
      return;
      this.bXJ -= 1;
    }
  }
  
  protected abstract int capacity();
  
  public void clear()
  {
    this._size = 0;
    this.bXI = capacity();
    this.bXJ = 0;
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
    if (paramInt > this.bXL - size())
    {
      gy(a.gw((int)(paramInt + size() / this.bXK) + 2));
      gz(capacity());
    }
  }
  
  protected int gx(int paramInt)
  {
    paramInt = a.gw(paramInt);
    gz(paramInt);
    return paramInt;
  }
  
  protected abstract void gy(int paramInt);
  
  public boolean isEmpty()
  {
    return this._size == 0;
  }
  
  protected void removeAt(int paramInt)
  {
    this._size -= 1;
    this.bXJ += 1;
    if ((this.bXJ > this._size) && (capacity() > 42))
    {
      gy(a.gw((int)(size() / this.bXK) + 2));
      gz(capacity());
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