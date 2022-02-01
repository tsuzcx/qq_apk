package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p
{
  public static dcv DA(String paramString)
  {
    AppMethodBeat.i(94880);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94880);
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = new dcu();
    try
    {
      paramString.parseFrom(arrayOfByte);
      paramString = paramString.FMs;
      AppMethodBeat.o(94880);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.SnsStatExtUtil", "", new Object[] { localException });
      }
    }
  }
  
  public static String U(bo parambo)
  {
    AppMethodBeat.i(94883);
    if (parambo == null)
    {
      AppMethodBeat.o(94883);
      return "";
    }
    Object localObject = null;
    if (parambo.cKN())
    {
      localObject = k.b.vA(parambo.field_content);
      if ((localObject == null) || (bs.isNullOrNil(((k.b)localObject).dvs)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = ((k.b)localObject).dvs;
    }
    if (parambo.crv())
    {
      parambo = u.Ej(parambo.field_imgPath);
      if ((parambo == null) || (bs.isNullOrNil(parambo.dvs)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = parambo.dvs;
    }
    AppMethodBeat.o(94883);
    return localObject;
  }
  
  public static String a(dcv paramdcv)
  {
    AppMethodBeat.i(94882);
    if (paramdcv != null)
    {
      Object localObject = paramdcv.DHe;
      String str2 = "";
      String str1 = str2;
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        str1 = str2;
        if (localObject != null)
        {
          str1 = str2;
          if (localObject.length > 0) {
            str1 = localObject[0];
          }
        }
      }
      try
      {
        paramdcv = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[] { Integer.valueOf(paramdcv.FMw), URLEncoder.encode(str1, "UTF-8"), paramdcv.FMv });
        AppMethodBeat.o(94882);
        return paramdcv;
      }
      catch (UnsupportedEncodingException paramdcv)
      {
        ac.e("MicroMsg.SnsStatExtUtil", "", new Object[] { paramdcv });
      }
    }
    AppMethodBeat.o(94882);
    return "";
  }
  
  public static String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94881);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94881);
      return "";
    }
    Object localObject = Base64.decode(paramString, 0);
    paramString = new dcu();
    try
    {
      paramString.parseFrom((byte[])localObject);
      localObject = paramString.FMs.DHe;
      String str = paramString.FMs.FMv;
      localObject = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[] { URLEncoder.encode((String)localObject, "UTF-8"), URLEncoder.encode(str, "UTF-8"), Integer.valueOf(paramString.FMs.dbL), URLEncoder.encode(a(paramString.FMs), "UTF-8") });
      if (paramString.FMu == null) {}
      for (paramString = "";; paramString = paramString.FMu.tdD)
      {
        paramPString.value = paramString;
        AppMethodBeat.o(94881);
        return localObject;
      }
      return "";
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(94881);
    }
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(94877);
    if (paramf == null)
    {
      AppMethodBeat.o(94877);
      return;
    }
    b(paramString, paramf);
    AppMethodBeat.o(94877);
  }
  
  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(94879);
    if (paramStringBuilder == null)
    {
      AppMethodBeat.o(94879);
      return;
    }
    paramString = DA(paramString);
    StringBuilder localStringBuilder = paramStringBuilder.append(",");
    if (paramString == null) {}
    for (int i = -1;; i = paramString.dbL)
    {
      localStringBuilder.append(i);
      paramStringBuilder.append(",").append(a(paramString));
      AppMethodBeat.o(94879);
      return;
    }
  }
  
  public static void b(String paramString, f paramf)
  {
    AppMethodBeat.i(94878);
    if ((bs.isNullOrNil(paramString)) || (paramf == null))
    {
      AppMethodBeat.o(94878);
      return;
    }
    paramString = DA(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {}
    for (int i = -1;; i = paramString.dbL)
    {
      paramf.n("Source", i + ",");
      paramf.n("SnsStatExt", a(paramString));
      AppMethodBeat.o(94878);
      return;
    }
  }
  
  public static enum a
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(94876);
      hXK = new a("Chat", 0, 1);
      hXL = new a("TalkChat", 1, 2);
      hXM = new a("Sns", 2, 3);
      hXN = new a[] { hXK, hXL, hXM };
      AppMethodBeat.o(94876);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.p
 * JD-Core Version:    0.7.0.1
 */