package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class j
{
  public static b a(a parama)
  {
    AppMethodBeat.i(249111);
    parama = new b(1, parama, (byte)0);
    AppMethodBeat.o(249111);
    return parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(249114);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.fcB).append(',').append(Util.nullAsNil(paramb.fcC)).append(',').append(Util.nullAsNil(paramb.fcD)).append(',').append(paramb.msgId).append(',').append(paramb.mediaType).append(',').append(Util.nullAsNil(gM(paramb.fcE))).append(',').append(paramb.mediaWidth).append(',').append(paramb.mediaHeight).append(',').append(Util.nullAsNil(gM(paramb.fcF))).append(',').append(paramb.fcG).append(',').append(Util.nullAsNil(paramb.fileId)).append(',').append(Util.nullAsNil(paramb.fileKey)).append(',').append(Util.nullAsNil(paramb.md5)).append(',').append(Util.nullAsNil(gM(paramb.fcH))).append(',').append(paramb.fcI);
    paramb = localStringBuilder.toString();
    Log.i("MicroMsg.ExportMediaReporter", "[+] Report content: %s", new Object[] { paramb });
    f.Iyx.b(20966, paramb, true, true);
    AppMethodBeat.o(249114);
  }
  
  public static b b(a parama)
  {
    AppMethodBeat.i(249112);
    parama = new b(2, parama, (byte)0);
    AppMethodBeat.o(249112);
    return parama;
  }
  
  public static b c(a parama)
  {
    AppMethodBeat.i(249113);
    parama = new b(3, parama, (byte)0);
    AppMethodBeat.o(249113);
    return parama;
  }
  
  private static String gM(String paramString)
  {
    AppMethodBeat.i(249116);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(249116);
      return paramString;
    }
    try
    {
      String str = URLEncoder.encode(paramString, "utf-8");
      AppMethodBeat.o(249116);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(249116);
    }
    return paramString;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(249004);
      fcx = new a("NONE", 0, 0);
      fcy = new a("IMAGE", 1, 1);
      fcz = new a("VIDEO", 2, 2);
      fcA = new a[] { fcx, fcy, fcz };
      AppMethodBeat.o(249004);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
  {
    public final int fcB;
    public String fcC = "";
    public String fcD = "";
    public String fcE = "";
    public String fcF = "";
    public int fcG = 0;
    public String fcH = "";
    public int fcI = 0;
    public String fileId = "";
    public String fileKey = "";
    public String md5 = "";
    public int mediaHeight = 0;
    public int mediaType = j.a.fcx.value;
    public int mediaWidth = 0;
    public long msgId = 0L;
    
    private b(int paramInt, j.a parama)
    {
      this.fcB = paramInt;
      this.mediaType = parama.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.j
 * JD-Core Version:    0.7.0.1
 */