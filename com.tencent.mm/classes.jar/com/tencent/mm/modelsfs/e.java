package com.tencent.mm.modelsfs;

public final class e
  extends SFSOutputStream
{
  private a eyu;
  
  public e(long paramLong, String paramString)
  {
    super(paramLong);
    this.eyu = new a(paramString);
  }
  
  public final void close()
  {
    super.close();
    if (this.eyu != null) {
      this.eyu.free();
    }
  }
  
  protected final void finalize()
  {
    super.finalize();
  }
  
  public final void write(int paramInt)
  {
    super.write(paramInt);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.eyu.x(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.e
 * JD-Core Version:    0.7.0.1
 */