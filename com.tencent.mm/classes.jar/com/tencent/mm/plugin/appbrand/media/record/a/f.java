package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class f
  extends c
{
  protected e fKs;
  private OutputStream xw;
  
  private boolean OW(String paramString)
  {
    AppMethodBeat.i(146353);
    try
    {
      this.fKs = new e(paramString);
      if (this.fKs.exists()) {
        this.fKs.delete();
      }
      this.fKs.createNewFile();
      this.xw = new DataOutputStream(i.cS(paramString, false));
      AppMethodBeat.o(146353);
      return true;
    }
    catch (Exception paramString)
    {
      ac.m("Luggage.PCMAudioEncoder", "", new Object[] { paramString });
      AppMethodBeat.o(146353);
    }
    return false;
  }
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(146350);
    d(paramArrayOfByte, paramInt, paramBoolean);
    try
    {
      if (this.xw != null) {
        this.xw.write(paramArrayOfByte);
      }
      label27:
      AppMethodBeat.o(146350);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      break label27;
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(146352);
    if (this.xw != null) {}
    try
    {
      this.xw.flush();
      this.xw.close();
      label26:
      this.xw = null;
      AppMethodBeat.o(146352);
      return;
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(146351);
    d(new byte[0], 0, true);
    AppMethodBeat.o(146351);
  }
  
  public boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146349);
    OW(paramString);
    AppMethodBeat.o(146349);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.f
 * JD-Core Version:    0.7.0.1
 */