package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class j
  implements b
{
  private RandomAccessFile file = null;
  private String fileName = "";
  
  public j(String paramString)
  {
    this.fileName = paramString;
  }
  
  private boolean eZ(boolean paramBoolean)
  {
    AppMethodBeat.i(130042);
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
      ad.d("MicroMsg.SilkFileOperator", "Open file:" + this.file + " forWrite:" + paramBoolean);
      try
      {
        this.file = i.dd(this.fileName, paramBoolean);
        AppMethodBeat.o(130042);
        return true;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.SilkFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
        this.file = null;
        AppMethodBeat.o(130042);
      }
      bool = false;
      break;
    }
    return false;
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(130041);
    if (this.file != null) {
      try
      {
        this.file.close();
        this.file = null;
        ad.d("MicroMsg.SilkFileOperator", "Close :" + this.fileName);
        AppMethodBeat.o(130041);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(130041);
  }
  
  public final g dr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130043);
    g localg = new g();
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      localg.ret = -3;
      AppMethodBeat.o(130043);
      return localg;
    }
    if ((this.file == null) && (!eZ(false)))
    {
      localg.ret = -2;
      AppMethodBeat.o(130043);
      return localg;
    }
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.file.length();
      this.file.seek(paramInt1);
      int i = this.file.read(localg.buf, 0, paramInt2);
      ad.d("MicroMsg.SilkFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + paramInt1 + " readRet:" + i + " fileNow:" + this.file.getFilePointer() + " fileSize:" + l);
      paramInt2 = i;
      if (i < 0) {
        paramInt2 = 0;
      }
      localg.dhO = paramInt2;
      localg.iuI = (paramInt2 + paramInt1);
      localg.ret = 0;
      AppMethodBeat.o(130043);
      return localg;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SilkFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + paramInt1 + "  failed:[" + localException.getMessage() + "] ");
      aNm();
      localg.ret = -1;
      AppMethodBeat.o(130043);
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
    AppMethodBeat.i(130044);
    if ((paramArrayOfByte.length > 0) && (paramInt1 > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      if ((this.file != null) || (eZ(true))) {
        break;
      }
      AppMethodBeat.o(130044);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.file.seek(paramInt2);
        this.file.write(paramArrayOfByte, 0, paramInt1);
        long l = this.file.getFilePointer();
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
          AppMethodBeat.o(130044);
          return paramInt1;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ad.e("MicroMsg.SilkFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + paramInt2 + " failed:[" + paramArrayOfByte.getMessage() + "]");
        aNm();
        AppMethodBeat.o(130044);
        return -3;
      }
      bool1 = false;
      continue;
      label193:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.j
 * JD-Core Version:    0.7.0.1
 */