package com.e.a.c;

public abstract class b
  implements Cloneable
{
  private transient int _size;
  private transient int cfE;
  private transient int cfF;
  private float cfG = 0.8F;
  private int cfH;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    gl(6);
  }
  
  private void gn(int paramInt)
  {
    this.cfH = Math.min(paramInt - 1, (int)(paramInt * this.cfG));
    this.cfE = (paramInt - this._size);
    this.cfF = 0;
  }
  
  public final void By()
  {
    if (this.cfF < 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.cfF -= capacity();
  }
  
  public final void Bz()
  {
    if (this.cfF >= 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.cfF += capacity();
  }
  
  protected final void bo(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.cfE -= 1;
    }
    for (;;)
    {
      int i = this._size + 1;
      this._size = i;
      if ((i > this.cfH) || (this.cfE == 0))
      {
        gm(a.gk(capacity() << 1));
        gn(capacity());
      }
      return;
      this.cfF -= 1;
    }
  }
  
  protected abstract int capacity();
  
  public void clear()
  {
    this._size = 0;
    this.cfE = capacity();
    this.cfF = 0;
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
    if (paramInt > this.cfH - size())
    {
      gm(a.gk((int)(paramInt + size() / this.cfG) + 2));
      gn(capacity());
    }
  }
  
  protected int gl(int paramInt)
  {
    paramInt = a.gk(paramInt);
    gn(paramInt);
    return paramInt;
  }
  
  protected abstract void gm(int paramInt);
  
  public boolean isEmpty()
  {
    return this._size == 0;
  }
  
  protected void removeAt(int paramInt)
  {
    this._size -= 1;
    this.cfF += 1;
    if ((this.cfF > this._size) && (capacity() > 42))
    {
      gm(a.gk((int)(size() / this.cfG) + 2));
      gn(capacity());
    }
  }
  
  public int size()
  {
    return this._size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.c.b
 * JD-Core Version:    0.7.0.1
 */