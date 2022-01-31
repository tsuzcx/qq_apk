package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p
{
  public static String I(bi parambi)
  {
    AppMethodBeat.i(35595);
    if (parambi == null)
    {
      AppMethodBeat.o(35595);
      return "";
    }
    Object localObject = null;
    if (parambi.bCn())
    {
      localObject = j.b.mY(parambi.field_content);
      if ((localObject == null) || (bo.isNullOrNil(((j.b)localObject).cGU)))
      {
        AppMethodBeat.o(35595);
        return "";
      }
      localObject = ((j.b)localObject).cGU;
    }
    if (parambi.byk())
    {
      parambi = u.vr(parambi.field_imgPath);
      if ((parambi == null) || (bo.isNullOrNil(parambi.cGU)))
      {
        AppMethodBeat.o(35595);
        return "";
      }
      localObject = parambi.cGU;
    }
    AppMethodBeat.o(35595);
    return localObject;
  }
  
  public static String a(cgi paramcgi)
  {
    AppMethodBeat.i(35594);
    if (paramcgi != null)
    {
      Object localObject = paramcgi.xRc;
      String str2 = "";
      String str1 = str2;
      if (!bo.isNullOrNil((String)localObject))
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
        paramcgi = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[] { Integer.valueOf(paramcgi.xRd), URLEncoder.encode(str1, "UTF-8"), paramcgi.xRb });
        AppMethodBeat.o(35594);
        return paramcgi;
      }
      catch (UnsupportedEncodingException paramcgi)
      {
        ab.e("MicroMsg.SnsStatExtUtil", "", new Object[] { paramcgi });
      }
    }
    AppMethodBeat.o(35594);
    return "";
  }
  
  public static String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(35593);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(35593);
      return "";
    }
    Object localObject = Base64.decode(paramString, 0);
    paramString = new cgh();
    try
    {
      paramString.parseFrom((byte[])localObject);
      localObject = paramString.xQY.xRc;
      String str = paramString.xQY.xRb;
      localObject = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[] { URLEncoder.encode((String)localObject, "UTF-8"), URLEncoder.encode(str, "UTF-8"), Integer.valueOf(paramString.xQY.cpt), URLEncoder.encode(a(paramString.xQY), "UTF-8") });
      if (paramString.xRa == null) {}
      for (paramString = "";; paramString = paramString.xRa.nmH)
      {
        paramPString.value = paramString;
        AppMethodBeat.o(35593);
        return localObject;
      }
      return "";
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(35593);
    }
  }
  
  public static void a(String paramString, d paramd)
  {
    AppMethodBeat.i(35589);
    if (paramd == null)
    {
      AppMethodBeat.o(35589);
      return;
    }
    b(paramString, paramd);
    AppMethodBeat.o(35589);
  }
  
  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(35591);
    if (paramStringBuilder == null)
    {
      AppMethodBeat.o(35591);
      return;
    }
    paramString = uI(paramString);
    StringBuilder localStringBuilder = paramStringBuilder.append(",");
    if (paramString == null) {}
    for (int i = -1;; i = paramString.cpt)
    {
      localStringBuilder.append(i);
      paramStringBuilder.append(",").append(a(paramString));
      AppMethodBeat.o(35591);
      return;
    }
  }
  
  public static void b(String paramString, d paramd)
  {
    AppMethodBeat.i(35590);
    if ((bo.isNullOrNil(paramString)) || (paramd == null))
    {
      AppMethodBeat.o(35590);
      return;
    }
    paramString = uI(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {}
    for (int i = -1;; i = paramString.cpt)
    {
      paramd.k("Source", i + ",");
      paramd.k("SnsStatExt", a(paramString));
      AppMethodBeat.o(35590);
      return;
    }
  }
  
  public static cgi uI(String paramString)
  {
    AppMethodBeat.i(35592);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(35592);
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = new cgh();
    try
    {
      paramString.parseFrom(arrayOfByte);
      paramString = paramString.xQY;
      AppMethodBeat.o(35592);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SnsStatExtUtil", "", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.p
 * JD-Core Version:    0.7.0.1
 */