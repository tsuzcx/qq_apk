package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a
  implements b
{
  private RandomAccessFile aZl = null;
  private String fileName = "";
  
  public a(String paramString)
  {
    this.fileName = paramString;
  }
  
  private boolean dk(boolean paramBoolean)
  {
    AppMethodBeat.i(55785);
    if (this.fileName.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.aZl != null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ab.d("MicroMsg.AmrFileOperator", "Open file:" + this.aZl + " forWrite:" + paramBoolean);
      try
      {
        this.aZl = e.cr(this.fileName, paramBoolean);
        AppMethodBeat.o(55785);
        return true;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
        this.aZl = null;
        AppMethodBeat.o(55785);
      }
      bool = false;
      break;
    }
    return false;
  }
  
  public final void amh()
  {
    AppMethodBeat.i(55784);
    if (this.aZl != null) {
      try
      {
        this.aZl.close();
        this.aZl = null;
        ab.d("MicroMsg.AmrFileOperator", "Close :" + this.fileName);
        AppMethodBeat.o(55784);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(55784);
  }
  
  public final g cJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55786);
    g localg = new g();
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      localg.ret = -3;
      AppMethodBeat.o(55786);
      return localg;
    }
    if ((this.aZl == null) && (!dk(false)))
    {
      localg.ret = -2;
      AppMethodBeat.o(55786);
      return localg;
    }
    int i = paramInt1 + 6;
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.aZl.length();
      this.aZl.seek(i);
      paramInt2 = this.aZl.read(localg.buf, 0, paramInt2);
      ab.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + paramInt2 + " fileNow:" + this.aZl.getFilePointer() + " fileSize:" + l);
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      localg.ckj = paramInt1;
      localg.fXX = (paramInt1 + i - 6);
      localg.ret = 0;
      AppMethodBeat.o(55786);
      return localg;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + localException.getMessage() + "] ");
      amh();
      localg.ret = -1;
      AppMethodBeat.o(55786);
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
    AppMethodBeat.i(55787);
    if ((paramArrayOfByte.length > 0) && (paramInt1 > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      if ((this.aZl != null) || (dk(true))) {
        break;
      }
      AppMethodBeat.o(55787);
      return -1;
    }
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        this.aZl.write("#!AMR\n".getBytes(), 0, 6);
        int i = paramInt2 + 6;
        long l;
        bool1 = false;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          this.aZl.seek(i);
          this.aZl.write(paramArrayOfByte, 0, paramInt1);
          l = this.aZl.getFilePointer();
          paramInt2 = (int)l;
          paramInt1 = i + paramInt1;
          if (paramInt2 != paramInt1) {
            break label272;
          }
          bool1 = true;
          Assert.assertTrue(bool1);
          paramInt1 -= 6;
          if (paramInt1 < 0) {
            break label278;
          }
          bool1 = bool2;
          Assert.assertTrue(bool1);
          AppMethodBeat.o(55787);
          return paramInt1;
        }
        catch (Exception paramArrayOfByte)
        {
          ab.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i + " failed:[" + paramArrayOfByte.getMessage() + "]");
          amh();
          AppMethodBeat.o(55787);
          return -3;
        }
        paramArrayOfByte = paramArrayOfByte;
        ab.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fileName + "] failed:[" + paramArrayOfByte.getMessage() + "]");
        amh();
        AppMethodBeat.o(55787);
        return -2;
      }
      label272:
      continue;
      label278:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.a
 * JD-Core Version:    0.7.0.1
 */