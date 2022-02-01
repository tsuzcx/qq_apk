package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class n
  implements b
{
  private RandomAccessFile file = null;
  private String fileName = "";
  
  public n(String paramString)
  {
    this.fileName = paramString;
  }
  
  private boolean hs(boolean paramBoolean)
  {
    AppMethodBeat.i(130088);
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
      Log.d("MicroMsg.SpxFileOperator", "Open file:" + this.file + " forWrite:" + paramBoolean);
      try
      {
        this.file = y.eA(this.fileName, paramBoolean);
        AppMethodBeat.o(130088);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
        this.file = null;
        AppMethodBeat.o(130088);
      }
      bool = false;
      break;
    }
    return false;
  }
  
  public final void bOT()
  {
    AppMethodBeat.i(130087);
    if (this.file != null) {
      try
      {
        this.file.close();
        this.file = null;
        Log.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
        AppMethodBeat.o(130087);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(130087);
  }
  
  public final g eQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130089);
    g localg = new g();
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      localg.ret = -3;
      AppMethodBeat.o(130089);
      return localg;
    }
    if ((this.file == null) && (!hs(false)))
    {
      localg.ret = -2;
      AppMethodBeat.o(130089);
      return localg;
    }
    localg.buf = new byte[paramInt2];
    try
    {
      long l = this.file.length();
      this.file.seek(paramInt1);
      int i = this.file.read(localg.buf, 0, paramInt2);
      Log.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + paramInt1 + " readRet:" + i + " fileNow:" + this.file.getFilePointer() + " fileSize:" + l);
      paramInt2 = i;
      if (i < 0) {
        paramInt2 = 0;
      }
      localg.hxg = paramInt2;
      localg.pbK = (paramInt2 + paramInt1);
      localg.ret = 0;
      AppMethodBeat.o(130089);
      return localg;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + paramInt1 + "  failed:[" + localException.getMessage() + "] ");
      bOT();
      localg.ret = -1;
      AppMethodBeat.o(130089);
    }
    return localg;
  }
  
  public final int getFormat()
  {
    return 1;
  }
  
  public final int y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(130090);
    if ((paramArrayOfByte.length > 0) && (paramInt1 > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      if ((this.file != null) || (hs(true))) {
        break;
      }
      AppMethodBeat.o(130090);
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
          AppMethodBeat.o(130090);
          return paramInt1;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.SpxFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + paramInt2 + " failed:[" + paramArrayOfByte.getMessage() + "]");
        bOT();
        AppMethodBeat.o(130090);
        return -3;
      }
      bool1 = false;
      continue;
      label193:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.n
 * JD-Core Version:    0.7.0.1
 */