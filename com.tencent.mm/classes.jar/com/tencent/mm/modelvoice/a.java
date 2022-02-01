package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a
  implements b
{
  private RandomAccessFile file = null;
  private String fileName = "";
  
  public a(String paramString)
  {
    this.fileName = paramString;
  }
  
  private boolean eD(boolean paramBoolean)
  {
    AppMethodBeat.i(130034);
    if (this.fileName.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.file != null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad.d("MicroMsg.AmrFileOperator", "Open file:" + this.file + " forWrite:" + paramBoolean);
      try
      {
        this.file = i.cS(this.fileName, paramBoolean);
        AppMethodBeat.o(130034);
        return true;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
        this.file = null;
        AppMethodBeat.o(130034);
      }
      bool = false;
      break;
    }
    return false;
  }
  
  public final void aDm()
  {
    AppMethodBeat.i(130033);
    if (this.file != null) {
      try
      {
        this.file.close();
        this.file = null;
        ad.d("MicroMsg.AmrFileOperator", "Close :" + this.fileName);
        AppMethodBeat.o(130033);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(130033);
  }
  
  public final g dp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130035);
    g localg = new g();
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      localg.ret = -3;
      AppMethodBeat.o(130035);
      return localg;
    }
    if ((this.file == null) && (!eD(false)))
    {
      localg.ret = -2;
      AppMethodBeat.o(130035);
      return localg;
    }
    int i = paramInt1 + 6;
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.file.length();
      this.file.seek(i);
      paramInt2 = this.file.read(localg.buf, 0, paramInt2);
      ad.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + paramInt2 + " fileNow:" + this.file.getFilePointer() + " fileSize:" + l);
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      localg.cZc = paramInt1;
      localg.hAL = (paramInt1 + i - 6);
      localg.ret = 0;
      AppMethodBeat.o(130035);
      return localg;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + localException.getMessage() + "] ");
      aDm();
      localg.ret = -1;
      AppMethodBeat.o(130035);
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
    AppMethodBeat.i(130036);
    if ((paramArrayOfByte.length > 0) && (paramInt1 > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      if ((this.file != null) || (eD(true))) {
        break;
      }
      AppMethodBeat.o(130036);
      return -1;
    }
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        this.file.write("#!AMR\n".getBytes(), 0, 6);
        int i = paramInt2 + 6;
        long l;
        bool1 = false;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          this.file.seek(i);
          this.file.write(paramArrayOfByte, 0, paramInt1);
          l = this.file.getFilePointer();
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
          AppMethodBeat.o(130036);
          return paramInt1;
        }
        catch (Exception paramArrayOfByte)
        {
          ad.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i + " failed:[" + paramArrayOfByte.getMessage() + "]");
          aDm();
          AppMethodBeat.o(130036);
          return -3;
        }
        paramArrayOfByte = paramArrayOfByte;
        ad.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fileName + "] failed:[" + paramArrayOfByte.getMessage() + "]");
        aDm();
        AppMethodBeat.o(130036);
        return -2;
      }
      label272:
      continue;
      label278:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.a
 * JD-Core Version:    0.7.0.1
 */