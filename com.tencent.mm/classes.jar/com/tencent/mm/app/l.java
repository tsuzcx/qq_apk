package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class l
{
  public static b a(a parama)
  {
    AppMethodBeat.i(239283);
    parama = new b(1, parama, (byte)0);
    AppMethodBeat.o(239283);
    return parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(239297);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.hgj).append(',').append(Util.nullAsNil(paramb.hgk)).append(',').append(Util.nullAsNil(paramb.hgl)).append(',').append(paramb.msgId).append(',').append(paramb.mediaType).append(',').append(Util.nullAsNil(im(paramb.hgm))).append(',').append(paramb.mediaWidth).append(',').append(paramb.mediaHeight).append(',').append(Util.nullAsNil(im(paramb.hgn))).append(',').append(paramb.hgo).append(',').append(Util.nullAsNil(paramb.fileId)).append(',').append(Util.nullAsNil(paramb.fileKey)).append(',').append(Util.nullAsNil(paramb.md5)).append(',').append(Util.nullAsNil(im(paramb.hgp))).append(',').append(paramb.hgq);
    paramb = localStringBuilder.toString();
    Log.i("MicroMsg.ExportMediaReporter", "[+] Report content: %s", new Object[] { paramb });
    f.Ozc.b(20966, paramb, true, true);
    AppMethodBeat.o(239297);
  }
  
  public static b b(a parama)
  {
    AppMethodBeat.i(239288);
    parama = new b(2, parama, (byte)0);
    AppMethodBeat.o(239288);
    return parama;
  }
  
  public static b c(a parama)
  {
    AppMethodBeat.i(239291);
    parama = new b(3, parama, (byte)0);
    AppMethodBeat.o(239291);
    return parama;
  }
  
  private static String im(String paramString)
  {
    AppMethodBeat.i(239305);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(239305);
      return paramString;
    }
    try
    {
      String str = URLEncoder.encode(paramString, "utf-8");
      AppMethodBeat.o(239305);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(239305);
    }
    return paramString;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(239040);
      hgf = new a("NONE", 0, 0);
      hgg = new a("IMAGE", 1, 1);
      hgh = new a("VIDEO", 2, 2);
      hgi = new a[] { hgf, hgg, hgh };
      AppMethodBeat.o(239040);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
  {
    public String fileId = "";
    public String fileKey = "";
    public final int hgj;
    public String hgk = "";
    public String hgl = "";
    public String hgm = "";
    public String hgn = "";
    public int hgo = 0;
    public String hgp = "";
    public int hgq = 0;
    public String md5 = "";
    public int mediaHeight = 0;
    public int mediaType = l.a.hgf.value;
    public int mediaWidth = 0;
    public long msgId = 0L;
    
    private b(int paramInt, l.a parama)
    {
      this.hgj = paramInt;
      this.mediaType = parama.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.l
 * JD-Core Version:    0.7.0.1
 */