package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p
{
  public static ecp PU(String paramString)
  {
    AppMethodBeat.i(94880);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94880);
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = new eco();
    try
    {
      paramString.parseFrom(arrayOfByte);
      paramString = paramString.NcH;
      AppMethodBeat.o(94880);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsStatExtUtil", "", new Object[] { localException });
      }
    }
  }
  
  public static String a(ecp paramecp)
  {
    AppMethodBeat.i(94882);
    if (paramecp != null)
    {
      Object localObject = paramecp.KxO;
      String str2 = "";
      String str1 = str2;
      if (!Util.isNullOrNil((String)localObject))
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
        paramecp = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[] { Integer.valueOf(paramecp.NcL), URLEncoder.encode(str1, "UTF-8"), paramecp.NcK });
        AppMethodBeat.o(94882);
        return paramecp;
      }
      catch (UnsupportedEncodingException paramecp)
      {
        Log.e("MicroMsg.SnsStatExtUtil", "", new Object[] { paramecp });
      }
    }
    AppMethodBeat.o(94882);
    return "";
  }
  
  public static String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94881);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94881);
      return "";
    }
    Object localObject = Base64.decode(paramString, 0);
    paramString = new eco();
    try
    {
      paramString.parseFrom((byte[])localObject);
      localObject = paramString.NcH.KxO;
      String str = paramString.NcH.NcK;
      localObject = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[] { URLEncoder.encode((String)localObject, "UTF-8"), URLEncoder.encode(str, "UTF-8"), Integer.valueOf(paramString.NcH.source), URLEncoder.encode(a(paramString.NcH), "UTF-8") });
      if (paramString.NcJ == null) {}
      for (paramString = "";; paramString = paramString.NcJ.xEN)
      {
        paramPString.value = paramString;
        AppMethodBeat.o(94881);
        return localObject;
      }
      return "";
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(94881);
    }
  }
  
  public static void a(String paramString, m paramm)
  {
    AppMethodBeat.i(94877);
    if (paramm == null)
    {
      AppMethodBeat.o(94877);
      return;
    }
    b(paramString, paramm);
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
    paramString = PU(paramString);
    StringBuilder localStringBuilder = paramStringBuilder.append(",");
    if (paramString == null) {}
    for (int i = -1;; i = paramString.source)
    {
      localStringBuilder.append(i);
      paramStringBuilder.append(",").append(a(paramString));
      AppMethodBeat.o(94879);
      return;
    }
  }
  
  public static String ag(ca paramca)
  {
    AppMethodBeat.i(94883);
    if (paramca == null)
    {
      AppMethodBeat.o(94883);
      return "";
    }
    Object localObject = null;
    if (paramca.dOQ())
    {
      localObject = k.b.HD(paramca.field_content);
      if ((localObject == null) || (Util.isNullOrNil(((k.b)localObject).ean)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = ((k.b)localObject).ean;
    }
    if (paramca.cWL())
    {
      paramca = u.QN(paramca.field_imgPath);
      if ((paramca == null) || (Util.isNullOrNil(paramca.ean)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = paramca.ean;
    }
    AppMethodBeat.o(94883);
    return localObject;
  }
  
  public static void b(String paramString, m paramm)
  {
    AppMethodBeat.i(94878);
    if ((Util.isNullOrNil(paramString)) || (paramm == null))
    {
      AppMethodBeat.o(94878);
      return;
    }
    paramString = PU(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {}
    for (int i = -1;; i = paramString.source)
    {
      paramm.n("Source", i + ",");
      paramm.n("SnsStatExt", a(paramString));
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
      jpm = new a("Chat", 0, 1);
      jpn = new a("TalkChat", 1, 2);
      jpo = new a("Sns", 2, 3);
      jpp = new a[] { jpm, jpn, jpo };
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