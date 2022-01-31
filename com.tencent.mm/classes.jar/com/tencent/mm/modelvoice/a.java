package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a
  implements b
{
  private RandomAccessFile aRL = null;
  private String fileName = "";
  
  public a(String paramString)
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
      y.d("MicroMsg.AmrFileOperator", "Open file:" + this.aRL + " forWrite:" + paramBoolean);
      try
      {
        this.aRL = e.bP(this.fileName, paramBoolean);
        return true;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
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
      y.d("MicroMsg.AmrFileOperator", "Close :" + this.fileName);
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
    int i = paramInt1 + 6;
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.aRL.length();
      this.aRL.seek(i);
      paramInt2 = this.aRL.read(localg.buf, 0, paramInt2);
      y.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + paramInt2 + " fileNow:" + this.aRL.getFilePointer() + " fileSize:" + l);
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      localg.bDu = paramInt1;
      localg.eIh = (paramInt1 + i - 6);
      localg.ret = 0;
      return localg;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + localException.getMessage() + "] ");
      SW();
      localg.ret = -1;
    }
    return localg;
  }
  
  public final int getFormat()
  {
    return 0;
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
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        this.aRL.write("#!AMR\n".getBytes(), 0, 6);
        int i = paramInt2 + 6;
        long l;
        bool1 = false;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          this.aRL.seek(i);
          this.aRL.write(paramArrayOfByte, 0, paramInt1);
          l = this.aRL.getFilePointer();
          paramInt2 = (int)l;
          paramInt1 = i + paramInt1;
          if (paramInt2 != paramInt1) {
            break label247;
          }
          bool1 = true;
          Assert.assertTrue(bool1);
          paramInt1 -= 6;
          if (paramInt1 < 0) {
            break label253;
          }
          bool1 = bool2;
          Assert.assertTrue(bool1);
          return paramInt1;
        }
        catch (Exception paramArrayOfByte)
        {
          y.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i + " failed:[" + paramArrayOfByte.getMessage() + "]");
          SW();
          return -3;
        }
        paramArrayOfByte = paramArrayOfByte;
        y.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fileName + "] failed:[" + paramArrayOfByte.getMessage() + "]");
        SW();
        return -2;
      }
      label247:
      continue;
      label253:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.a
 * JD-Core Version:    0.7.0.1
 */