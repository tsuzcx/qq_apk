package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.emq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class o
{
  public static emq Xr(String paramString)
  {
    AppMethodBeat.i(94880);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94880);
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = new emp();
    try
    {
      paramString.parseFrom(arrayOfByte);
      paramString = paramString.Upe;
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
  
  public static String a(emq paramemq)
  {
    AppMethodBeat.i(94882);
    if (paramemq != null)
    {
      Object localObject = paramemq.RzC;
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
        paramemq = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[] { Integer.valueOf(paramemq.Upi), URLEncoder.encode(str1, "UTF-8"), paramemq.Uph });
        AppMethodBeat.o(94882);
        return paramemq;
      }
      catch (UnsupportedEncodingException paramemq)
      {
        Log.e("MicroMsg.SnsStatExtUtil", "", new Object[] { paramemq });
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
    paramString = new emp();
    try
    {
      paramString.parseFrom((byte[])localObject);
      localObject = paramString.Upe.RzC;
      String str = paramString.Upe.Uph;
      localObject = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[] { URLEncoder.encode((String)localObject, "UTF-8"), URLEncoder.encode(str, "UTF-8"), Integer.valueOf(paramString.Upe.source), URLEncoder.encode(a(paramString.Upe), "UTF-8") });
      if (paramString.Upg == null) {}
      for (paramString = "";; paramString = paramString.Upg.CIO)
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
  
  public static void a(String paramString, n paramn)
  {
    AppMethodBeat.i(94877);
    if (paramn == null)
    {
      AppMethodBeat.o(94877);
      return;
    }
    b(paramString, paramn);
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
    paramString = Xr(paramString);
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
  
  public static String ao(ca paramca)
  {
    AppMethodBeat.i(94883);
    if (paramca == null)
    {
      AppMethodBeat.o(94883);
      return "";
    }
    Object localObject = null;
    if (paramca.erk())
    {
      localObject = k.b.OQ(paramca.field_content);
      if ((localObject == null) || (Util.isNullOrNil(((k.b)localObject).fUk)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = ((k.b)localObject).fUk;
    }
    if (paramca.dlT())
    {
      paramca = y.Yk(paramca.field_imgPath);
      if ((paramca == null) || (Util.isNullOrNil(paramca.fUk)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = paramca.fUk;
    }
    AppMethodBeat.o(94883);
    return localObject;
  }
  
  public static void b(String paramString, n paramn)
  {
    AppMethodBeat.i(94878);
    if ((Util.isNullOrNil(paramString)) || (paramn == null))
    {
      AppMethodBeat.o(94878);
      return;
    }
    paramString = Xr(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {}
    for (int i = -1;; i = paramString.source)
    {
      paramn.m("Source", i + ",");
      paramn.m("SnsStatExt", a(paramString));
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
      meE = new a("Chat", 0, 1);
      meF = new a("TalkChat", 1, 2);
      meG = new a("Sns", 2, 3);
      meH = new a[] { meE, meF, meG };
      AppMethodBeat.o(94876);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.o
 * JD-Core Version:    0.7.0.1
 */