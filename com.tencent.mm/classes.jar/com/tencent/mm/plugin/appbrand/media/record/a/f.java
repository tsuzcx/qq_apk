package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class f
  extends c
{
  protected File gVL;
  private OutputStream pU;
  
  private boolean eL(String paramString)
  {
    AppMethodBeat.i(140662);
    try
    {
      this.gVL = new File(paramString);
      if (this.gVL.exists()) {
        this.gVL.delete();
      }
      this.gVL.createNewFile();
      this.pU = new DataOutputStream(new FileOutputStream(paramString));
      AppMethodBeat.o(140662);
      return true;
    }
    catch (Exception paramString)
    {
      ab.b("Luggage.PCMAudioEncoder", "", new Object[] { paramString });
      AppMethodBeat.o(140662);
    }
    return false;
  }
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(140659);
    f(paramArrayOfByte, paramInt, paramBoolean);
    try
    {
      if (this.pU != null) {
        this.pU.write(paramArrayOfByte);
      }
      label27:
      AppMethodBeat.o(140659);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      break label27;
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(140661);
    if (this.pU != null) {}
    try
    {
      this.pU.flush();
      this.pU.close();
      label26:
      this.pU = null;
      AppMethodBeat.o(140661);
      return;
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(140660);
    f(new byte[0], 0, true);
    AppMethodBeat.o(140660);
  }
  
  public boolean h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140658);
    eL(paramString);
    AppMethodBeat.o(140658);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.f
 * JD-Core Version:    0.7.0.1
 */