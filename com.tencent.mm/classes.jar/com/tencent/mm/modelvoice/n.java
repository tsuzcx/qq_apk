package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class n
  implements b
{
  private RandomAccessFile aZl = null;
  private String fileName = "";
  
  public n(String paramString)
  {
    this.fileName = paramString;
  }
  
  private boolean dk(boolean paramBoolean)
  {
    AppMethodBeat.i(55834);
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
      ab.d("MicroMsg.SpxFileOperator", "Open file:" + this.aZl + " forWrite:" + paramBoolean);
      try
      {
        this.aZl = e.cr(this.fileName, paramBoolean);
        AppMethodBeat.o(55834);
        return true;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
        this.aZl = null;
        AppMethodBeat.o(55834);
      }
      bool = false;
      break;
    }
    return false;
  }
  
  public final void amh()
  {
    AppMethodBeat.i(55833);
    if (this.aZl != null) {
      try
      {
        this.aZl.close();
        this.aZl = null;
        ab.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
        AppMethodBeat.o(55833);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(55833);
  }
  
  public final g cJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55835);
    g localg = new g();
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      localg.ret = -3;
      AppMethodBeat.o(55835);
      return localg;
    }
    if ((this.aZl == null) && (!dk(false)))
    {
      localg.ret = -2;
      AppMethodBeat.o(55835);
      return localg;
    }
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.aZl.length();
      this.aZl.seek(paramInt1);
      int i = this.aZl.read(localg.buf, 0, paramInt2);
      ab.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + paramInt1 + " readRet:" + i + " fileNow:" + this.aZl.getFilePointer() + " fileSize:" + l);
      paramInt2 = i;
      if (i < 0) {
        paramInt2 = 0;
      }
      localg.ckj = paramInt2;
      localg.fXX = (paramInt2 + paramInt1);
      localg.ret = 0;
      AppMethodBeat.o(55835);
      return localg;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + paramInt1 + "  failed:[" + localException.getMessage() + "] ");
      amh();
      localg.ret = -1;
      AppMethodBeat.o(55835);
    }
    return localg;
  }
  
  public final int getFormat()
  {
    return 1;
  }
  
  public final int write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(55836);
    if ((paramArrayOfByte.length > 0) && (paramInt1 > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      if ((this.aZl != null) || (dk(true))) {
        break;
      }
      AppMethodBeat.o(55836);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.aZl.seek(paramInt2);
        this.aZl.write(paramArrayOfByte, 0, paramInt1);
        long l = this.aZl.getFilePointer();
        int i = (int)l;
        paramInt1 = paramInt2 + paramInt1;
        if (i == paramInt1)
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          if (paramInt1 < 0) {
            break label193;
          }
          bool1 = bool2;
          Assert.assertTrue(bool1);
          AppMethodBeat.o(55836);
          return paramInt1;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ab.e("MicroMsg.SpxFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + paramInt2 + " failed:[" + paramArrayOfByte.getMessage() + "]");
        amh();
        AppMethodBeat.o(55836);
        return -3;
      }
      bool1 = false;
      continue;
      label193:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.n
 * JD-Core Version:    0.7.0.1
 */