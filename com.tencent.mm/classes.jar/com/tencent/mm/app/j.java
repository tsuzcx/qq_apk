package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class j
{
  public static b a(a parama)
  {
    AppMethodBeat.i(200797);
    parama = new b(1, parama, (byte)0);
    AppMethodBeat.o(200797);
    return parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(200800);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.dkT).append(',').append(Util.nullAsNil(paramb.dkU)).append(',').append(Util.nullAsNil(paramb.dkV)).append(',').append(paramb.msgId).append(',').append(paramb.mediaType).append(',').append(Util.nullAsNil(gc(paramb.dkW))).append(',').append(paramb.dkX).append(',').append(paramb.dkY).append(',').append(Util.nullAsNil(gc(paramb.dkZ))).append(',').append(paramb.dla).append(',').append(Util.nullAsNil(paramb.fileId)).append(',').append(Util.nullAsNil(paramb.fileKey)).append(',').append(Util.nullAsNil(paramb.md5)).append(',').append(Util.nullAsNil(gc(paramb.dlb))).append(',').append(paramb.dlc);
    paramb = localStringBuilder.toString();
    Log.i("MicroMsg.ExportMediaReporter", "[+] Report content: %s", new Object[] { paramb });
    e.Cxv.a(20966, paramb, true, true);
    AppMethodBeat.o(200800);
  }
  
  public static b b(a parama)
  {
    AppMethodBeat.i(200798);
    parama = new b(2, parama, (byte)0);
    AppMethodBeat.o(200798);
    return parama;
  }
  
  public static b c(a parama)
  {
    AppMethodBeat.i(200799);
    parama = new b(3, parama, (byte)0);
    AppMethodBeat.o(200799);
    return parama;
  }
  
  private static String gc(String paramString)
  {
    AppMethodBeat.i(200801);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(200801);
      return paramString;
    }
    try
    {
      String str = URLEncoder.encode(paramString, "utf-8");
      AppMethodBeat.o(200801);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(200801);
    }
    return paramString;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(200796);
      dkP = new a("NONE", 0, 0);
      dkQ = new a("IMAGE", 1, 1);
      dkR = new a("VIDEO", 2, 2);
      dkS = new a[] { dkP, dkQ, dkR };
      AppMethodBeat.o(200796);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
  {
    public final int dkT;
    public String dkU = "";
    public String dkV = "";
    public String dkW = "";
    public int dkX = 0;
    public int dkY = 0;
    public String dkZ = "";
    public int dla = 0;
    public String dlb = "";
    public int dlc = 0;
    public String fileId = "";
    public String fileKey = "";
    public String md5 = "";
    public int mediaType = j.a.dkP.value;
    public long msgId = 0L;
    
    private b(int paramInt, j.a parama)
    {
      this.dkT = paramInt;
      this.mediaType = parama.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.j
 * JD-Core Version:    0.7.0.1
 */