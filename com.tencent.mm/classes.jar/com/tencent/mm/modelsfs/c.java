package com.tencent.mm.modelsfs;

import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.FilterOutputStream;

public final class c
  extends FilterOutputStream
{
  private a eyu;
  
  public c(b paramb, long paramLong)
  {
    super(e.q(paramb));
    this.eyu = new a(paramLong);
  }
  
  public c(String paramString1, String paramString2)
  {
    super(e.I(paramString1, false));
    this.eyu = new a(paramString2);
  }
  
  public final void close()
  {
    super.close();
    if (this.eyu != null) {
      this.eyu.free();
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.eyu.x(paramArrayOfByte, paramInt2);
    super.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsfs.c
 * JD-Core Version:    0.7.0.1
 */