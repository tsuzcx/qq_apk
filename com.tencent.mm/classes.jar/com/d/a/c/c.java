package com.d.a.c;

public abstract class c
  implements Cloneable
{
  protected transient int _size;
  protected transient int clJ;
  protected transient int clK;
  protected final float clL = 0.8F;
  protected int clM;
  
  public c()
  {
    this((byte)0);
  }
  
  private c(byte paramByte)
  {
    ip(6);
  }
  
  private void ir(int paramInt)
  {
    this.clM = Math.min(paramInt - 1, (int)(paramInt * this.clL));
    this.clJ = (paramInt - this._size);
    this.clK = 0;
  }
  
  public final void Lm()
  {
    if (this.clK < 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.clK -= vh();
  }
  
  public final void Ln()
  {
    if (this.clK >= 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.clK += vh();
  }
  
  protected void aK(int paramInt)
  {
    this._size -= 1;
    this.clK += 1;
    if ((this.clK > this._size) && (vh() > 42))
    {
      iq(a.io((int)(size() / this.clL) + 2));
      ir(vh());
    }
  }
  
  protected final void bY(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.clJ -= 1;
    }
    for (;;)
    {
      int i = this._size + 1;
      this._size = i;
      if ((i > this.clM) || (this.clJ == 0))
      {
        iq(a.io(vh() << 1));
        ir(vh());
      }
      return;
      this.clK -= 1;
    }
  }
  
  public void clear()
  {
    this._size = 0;
    this.clJ = vh();
    this.clK = 0;
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
    if (paramInt > this.clM - size())
    {
      iq(a.io((int)(paramInt + size() / this.clL) + 2));
      ir(vh());
    }
  }
  
  protected int ip(int paramInt)
  {
    paramInt = a.io(paramInt);
    ir(paramInt);
    return paramInt;
  }
  
  protected abstract void iq(int paramInt);
  
  public boolean isEmpty()
  {
    return this._size == 0;
  }
  
  public int size()
  {
    return this._size;
  }
  
  protected abstract int vh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.c
 * JD-Core Version:    0.7.0.1
 */