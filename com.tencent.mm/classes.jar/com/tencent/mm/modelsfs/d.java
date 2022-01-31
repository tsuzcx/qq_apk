package com.tencent.mm.modelsfs;

public final class d
  extends SFSInputStream
{
  private a eyu;
  
  public d(long paramLong1, long paramLong2)
  {
    super(paramLong1);
    this.eyu = new a(paramLong2);
  }
  
  public final void close()
  {
    super.close();
    if (this.eyu != null) {
      this.eyu.free();
    }
  }
  
  public final void mark(int paramInt)
  {
    super.mark(paramInt);
    this.eyu.Qa();
  }
  
  public final int read()
  {
    return super.read();
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < 0) {
      return paramInt1;
    }
    this.eyu.x(paramArrayOfByte, paramInt2);
    return paramInt1;
  }
  
  public final void reset()
  {
    super.reset();
    this.eyu.reset();
  }
  
  public final long skip(long paramLong)
  {
    long l = super.skip(paramLong);
    this.eyu.seek(paramLong);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsfs.d
 * JD-Core Version:    0.7.0.1
 */