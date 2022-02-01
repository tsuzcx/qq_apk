package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class j
{
  public static b a(a parama)
  {
    AppMethodBeat.i(211721);
    parama = new b(1, parama, (byte)0);
    AppMethodBeat.o(211721);
    return parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(211724);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.cUz).append(',').append(bu.nullAsNil(paramb.cUA)).append(',').append(bu.nullAsNil(paramb.cUB)).append(',').append(paramb.msgId).append(',').append(paramb.mediaType).append(',').append(bu.nullAsNil(fo(paramb.cUC))).append(',').append(paramb.cUD).append(',').append(paramb.cUE).append(',').append(bu.nullAsNil(fo(paramb.cUF))).append(',').append(paramb.cUG).append(',').append(bu.nullAsNil(paramb.fileId)).append(',').append(bu.nullAsNil(paramb.fileKey)).append(',').append(bu.nullAsNil(paramb.md5)).append(',').append(bu.nullAsNil(fo(paramb.cUH))).append(',').append(paramb.cUI);
    paramb = localStringBuilder.toString();
    ae.i("MicroMsg.ExportMediaReporter", "[+] Report content: %s", new Object[] { paramb });
    e.ywz.a(20966, paramb, true, true);
    AppMethodBeat.o(211724);
  }
  
  public static b b(a parama)
  {
    AppMethodBeat.i(211722);
    parama = new b(2, parama, (byte)0);
    AppMethodBeat.o(211722);
    return parama;
  }
  
  public static b c(a parama)
  {
    AppMethodBeat.i(211723);
    parama = new b(3, parama, (byte)0);
    AppMethodBeat.o(211723);
    return parama;
  }
  
  private static String fo(String paramString)
  {
    AppMethodBeat.i(211725);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(211725);
      return paramString;
    }
    try
    {
      String str = URLEncoder.encode(paramString, "utf-8");
      AppMethodBeat.o(211725);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(211725);
    }
    return paramString;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(211720);
      cUv = new a("NONE", 0, 0);
      cUw = new a("IMAGE", 1, 1);
      cUx = new a("VIDEO", 2, 2);
      cUy = new a[] { cUv, cUw, cUx };
      AppMethodBeat.o(211720);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
  {
    public String cUA = "";
    public String cUB = "";
    public String cUC = "";
    public int cUD = 0;
    public int cUE = 0;
    public String cUF = "";
    public int cUG = 0;
    public String cUH = "";
    public int cUI = 0;
    public final int cUz;
    public String fileId = "";
    public String fileKey = "";
    public String md5 = "";
    public int mediaType = j.a.cUv.value;
    public long msgId = 0L;
    
    private b(int paramInt, j.a parama)
    {
      this.cUz = paramInt;
      this.mediaType = parama.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.j
 * JD-Core Version:    0.7.0.1
 */