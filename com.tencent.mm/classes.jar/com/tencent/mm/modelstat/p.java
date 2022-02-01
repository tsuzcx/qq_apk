package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p
{
  public static djd Hh(String paramString)
  {
    AppMethodBeat.i(94880);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94880);
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = new djc();
    try
    {
      paramString.parseFrom(arrayOfByte);
      paramString = paramString.HQJ;
      AppMethodBeat.o(94880);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsStatExtUtil", "", new Object[] { localException });
      }
    }
  }
  
  public static String W(bv parambv)
  {
    AppMethodBeat.i(94883);
    if (parambv == null)
    {
      AppMethodBeat.o(94883);
      return "";
    }
    Object localObject = null;
    if (parambv.cVH())
    {
      localObject = k.b.zb(parambv.field_content);
      if ((localObject == null) || (bu.isNullOrNil(((k.b)localObject).dIA)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = ((k.b)localObject).dIA;
    }
    if (parambv.cyI())
    {
      parambv = u.Ia(parambv.field_imgPath);
      if ((parambv == null) || (bu.isNullOrNil(parambv.dIA)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = parambv.dIA;
    }
    AppMethodBeat.o(94883);
    return localObject;
  }
  
  public static String a(djd paramdjd)
  {
    AppMethodBeat.i(94882);
    if (paramdjd != null)
    {
      Object localObject = paramdjd.FEJ;
      String str2 = "";
      String str1 = str2;
      if (!bu.isNullOrNil((String)localObject))
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
        paramdjd = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[] { Integer.valueOf(paramdjd.HQN), URLEncoder.encode(str1, "UTF-8"), paramdjd.HQM });
        AppMethodBeat.o(94882);
        return paramdjd;
      }
      catch (UnsupportedEncodingException paramdjd)
      {
        ae.e("MicroMsg.SnsStatExtUtil", "", new Object[] { paramdjd });
      }
    }
    AppMethodBeat.o(94882);
    return "";
  }
  
  public static String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94881);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94881);
      return "";
    }
    Object localObject = Base64.decode(paramString, 0);
    paramString = new djc();
    try
    {
      paramString.parseFrom((byte[])localObject);
      localObject = paramString.HQJ.FEJ;
      String str = paramString.HQJ.HQM;
      localObject = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[] { URLEncoder.encode((String)localObject, "UTF-8"), URLEncoder.encode(str, "UTF-8"), Integer.valueOf(paramString.HQJ.doj), URLEncoder.encode(a(paramString.HQJ), "UTF-8") });
      if (paramString.HQL == null) {}
      for (paramString = "";; paramString = paramString.HQL.umv)
      {
        paramPString.value = paramString;
        AppMethodBeat.o(94881);
        return localObject;
      }
      return "";
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(94881);
    }
  }
  
  public static void a(String paramString, g paramg)
  {
    AppMethodBeat.i(94877);
    if (paramg == null)
    {
      AppMethodBeat.o(94877);
      return;
    }
    b(paramString, paramg);
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
    paramString = Hh(paramString);
    StringBuilder localStringBuilder = paramStringBuilder.append(",");
    if (paramString == null) {}
    for (int i = -1;; i = paramString.doj)
    {
      localStringBuilder.append(i);
      paramStringBuilder.append(",").append(a(paramString));
      AppMethodBeat.o(94879);
      return;
    }
  }
  
  public static void b(String paramString, g paramg)
  {
    AppMethodBeat.i(94878);
    if ((bu.isNullOrNil(paramString)) || (paramg == null))
    {
      AppMethodBeat.o(94878);
      return;
    }
    paramString = Hh(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {}
    for (int i = -1;; i = paramString.doj)
    {
      paramg.m("Source", i + ",");
      paramg.m("SnsStatExt", a(paramString));
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
      iua = new a("Chat", 0, 1);
      iub = new a("TalkChat", 1, 2);
      iuc = new a("Sns", 2, 3);
      iud = new a[] { iua, iub, iuc };
      AppMethodBeat.o(94876);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.p
 * JD-Core Version:    0.7.0.1
 */