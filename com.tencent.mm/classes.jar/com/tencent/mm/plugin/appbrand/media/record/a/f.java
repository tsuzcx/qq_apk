package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class f
  extends c
{
  protected k ggb;
  private OutputStream zp;
  
  private boolean Ti(String paramString)
  {
    AppMethodBeat.i(146353);
    try
    {
      this.ggb = new k(paramString);
      if (this.ggb.exists()) {
        this.ggb.delete();
      }
      this.ggb.createNewFile();
      this.zp = new DataOutputStream(o.db(paramString, false));
      AppMethodBeat.o(146353);
      return true;
    }
    catch (Exception paramString)
    {
      ae.m("Luggage.PCMAudioEncoder", "", new Object[] { paramString });
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
      if (this.zp != null) {
        this.zp.write(paramArrayOfByte);
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
    if (this.zp != null) {}
    try
    {
      this.zp.flush();
      this.zp.close();
      label26:
      this.zp = null;
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
    Ti(paramString);
    AppMethodBeat.o(146349);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.f
 * JD-Core Version:    0.7.0.1
 */