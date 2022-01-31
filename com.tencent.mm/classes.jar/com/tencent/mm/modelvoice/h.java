package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class h
  implements b
{
  private RandomAccessFile aRL = null;
  private String fileName = "";
  
  public h(String paramString)
  {
    this.fileName = paramString;
  }
  
  private boolean ch(boolean paramBoolean)
  {
    if (this.fileName.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.aRL != null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      y.d("MicroMsg.SilkFileOperator", "Open file:" + this.aRL + " forWrite:" + paramBoolean);
      try
      {
        this.aRL = e.bP(this.fileName, paramBoolean);
        return true;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.SilkFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
        this.aRL = null;
      }
      bool = false;
      break;
    }
    return false;
  }
  
  public final void SW()
  {
    if (this.aRL != null) {}
    try
    {
      this.aRL.close();
      this.aRL = null;
      y.d("MicroMsg.SilkFileOperator", "Close :" + this.fileName);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final g bz(int paramInt1, int paramInt2)
  {
    g localg = new g();
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      localg.ret = -3;
      return localg;
    }
    if ((this.aRL == null) && (!ch(false)))
    {
      localg.ret = -2;
      return localg;
    }
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.aRL.length();
      this.aRL.seek(paramInt1);
      int i = this.aRL.read(localg.buf, 0, paramInt2);
      y.d("MicroMsg.SilkFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + paramInt1 + " readRet:" + i + " fileNow:" + this.aRL.getFilePointer() + " fileSize:" + l);
      paramInt2 = i;
      if (i < 0) {
        paramInt2 = 0;
      }
      localg.bDu = paramInt2;
      localg.eIh = (paramInt2 + paramInt1);
      localg.ret = 0;
      return localg;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SilkFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + paramInt1 + "  failed:[" + localException.getMessage() + "] ");
      SW();
      localg.ret = -1;
    }
    return localg;
  }
  
  public final int getFormat()
  {
    return 4;
  }
  
  public final int write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if ((paramArrayOfByte.length > 0) && (paramInt1 > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      if ((this.aRL != null) || (ch(true))) {
        break;
      }
      return -1;
    }
    for (;;)
    {
      try
      {
        this.aRL.seek(paramInt2);
        this.aRL.write(paramArrayOfByte, 0, paramInt1);
        long l = this.aRL.getFilePointer();
        int i = (int)l;
        paramInt1 = paramInt2 + paramInt1;
        if (i == paramInt1)
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          if (paramInt1 < 0) {
            break label173;
          }
          bool1 = bool2;
          Assert.assertTrue(bool1);
          return paramInt1;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        y.e("MicroMsg.SilkFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + paramInt2 + " failed:[" + paramArrayOfByte.getMessage() + "]");
        SW();
        return -3;
      }
      bool1 = false;
      continue;
      label173:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.h
 * JD-Core Version:    0.7.0.1
 */