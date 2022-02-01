package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p
{
  public static String U(bl parambl)
  {
    AppMethodBeat.i(94883);
    if (parambl == null)
    {
      AppMethodBeat.o(94883);
      return "";
    }
    Object localObject = null;
    if (parambl.cxB())
    {
      localObject = k.b.rx(parambl.field_content);
      if ((localObject == null) || (bt.isNullOrNil(((k.b)localObject).dxG)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = ((k.b)localObject).dxG;
    }
    if (parambl.cjO())
    {
      parambl = u.Ae(parambl.field_imgPath);
      if ((parambl == null) || (bt.isNullOrNil(parambl.dxG)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = parambl.dxG;
    }
    AppMethodBeat.o(94883);
    return localObject;
  }
  
  public static String a(cxj paramcxj)
  {
    AppMethodBeat.i(94882);
    if (paramcxj != null)
    {
      Object localObject = paramcxj.CoM;
      String str2 = "";
      String str1 = str2;
      if (!bt.isNullOrNil((String)localObject))
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
        paramcxj = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[] { Integer.valueOf(paramcxj.Epx), URLEncoder.encode(str1, "UTF-8"), paramcxj.Epw });
        AppMethodBeat.o(94882);
        return paramcxj;
      }
      catch (UnsupportedEncodingException paramcxj)
      {
        ad.e("MicroMsg.SnsStatExtUtil", "", new Object[] { paramcxj });
      }
    }
    AppMethodBeat.o(94882);
    return "";
  }
  
  public static String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94881);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94881);
      return "";
    }
    Object localObject = Base64.decode(paramString, 0);
    paramString = new cxi();
    try
    {
      paramString.parseFrom((byte[])localObject);
      localObject = paramString.Ept.CoM;
      String str = paramString.Ept.Epw;
      localObject = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[] { URLEncoder.encode((String)localObject, "UTF-8"), URLEncoder.encode(str, "UTF-8"), Integer.valueOf(paramString.Ept.dep), URLEncoder.encode(a(paramString.Ept), "UTF-8") });
      if (paramString.Epv == null) {}
      for (paramString = "";; paramString = paramString.Epv.rVL)
      {
        paramPString.value = paramString;
        AppMethodBeat.o(94881);
        return localObject;
      }
      return "";
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramString, "", new Object[0]);
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
    paramString = zv(paramString);
    StringBuilder localStringBuilder = paramStringBuilder.append(",");
    if (paramString == null) {}
    for (int i = -1;; i = paramString.dep)
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
    if ((bt.isNullOrNil(paramString)) || (paramf == null))
    {
      AppMethodBeat.o(94878);
      return;
    }
    paramString = zv(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {}
    for (int i = -1;; i = paramString.dep)
    {
      paramf.o("Source", i + ",");
      paramf.o("SnsStatExt", a(paramString));
      AppMethodBeat.o(94878);
      return;
    }
  }
  
  public static cxj zv(String paramString)
  {
    AppMethodBeat.i(94880);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94880);
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = new cxi();
    try
    {
      paramString.parseFrom(arrayOfByte);
      paramString = paramString.Ept;
      AppMethodBeat.o(94880);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsStatExtUtil", "", new Object[] { localException });
      }
    }
  }
  
  public static enum a
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(94876);
      hxj = new a("Chat", 0, 1);
      hxk = new a("TalkChat", 1, 2);
      hxl = new a("Sns", 2, 3);
      hxm = new a[] { hxj, hxk, hxl };
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