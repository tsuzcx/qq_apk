package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.FilterInputStream;

public final class b
  extends FilterInputStream
{
  private boolean eyq = false;
  private a eyu;
  
  public b(String paramString, long paramLong)
  {
    super(e.openRead(paramString));
    this.eyu = new a(paramLong);
  }
  
  public final void close()
  {
    super.close();
    if (this.eyu != null) {
      this.eyu.free();
    }
    y.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
  }
  
  public final void mark(int paramInt)
  {
    super.mark(paramInt);
    this.eyu.Qa();
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eyq) {
      y.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + bk.csb().toString());
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsfs.b
 * JD-Core Version:    0.7.0.1
 */