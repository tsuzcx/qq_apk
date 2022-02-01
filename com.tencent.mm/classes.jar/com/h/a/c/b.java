package com.h.a.c;

public abstract class b
  implements Cloneable
{
  protected transient int _size;
  protected transient int ecb;
  protected transient int ecc;
  protected final float ecd = 0.8F;
  protected int ece;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    lU(6);
  }
  
  private void lW(int paramInt)
  {
    this.ece = Math.min(paramInt - 1, (int)(paramInt * this.ecd));
    this.ecb = (paramInt - this._size);
    this.ecc = 0;
  }
  
  protected abstract int UG();
  
  public final void aln()
  {
    if (this.ecc < 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.ecc -= UG();
  }
  
  public final void alo()
  {
    if (this.ecc >= 0) {
      throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
    }
    this.ecc += UG();
  }
  
  protected void bj(int paramInt)
  {
    this._size -= 1;
    this.ecc += 1;
    if ((this.ecc > this._size) && (UG() > 42))
    {
      lV(a.lT((int)(size() / this.ecd) + 2));
      lW(UG());
    }
  }
  
  protected final void cD(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.ecb -= 1;
    }
    for (;;)
    {
      int i = this._size + 1;
      this._size = i;
      if ((i > this.ece) || (this.ecb == 0))
      {
        lV(a.lT(UG() << 1));
        lW(UG());
      }
      return;
      this.ecc -= 1;
    }
  }
  
  public void clear()
  {
    this._size = 0;
    this.ecb = UG();
    this.ecc = 0;
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
    if (paramInt > this.ece - size())
    {
      lV(a.lT((int)(paramInt + size() / this.ecd) + 2));
      lW(UG());
    }
  }
  
  public boolean isEmpty()
  {
    return this._size == 0;
  }
  
  protected int lU(int paramInt)
  {
    paramInt = a.lT(paramInt);
    lW(paramInt);
    return paramInt;
  }
  
  protected abstract void lV(int paramInt);
  
  public int size()
  {
    return this._size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.h.a.c.b
 * JD-Core Version:    0.7.0.1
 */