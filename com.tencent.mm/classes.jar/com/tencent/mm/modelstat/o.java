package com.tencent.mm.modelstat;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.fhl;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class o
{
  public static fho Pt(String paramString)
  {
    AppMethodBeat.i(94880);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(94880);
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = new fhn();
    try
    {
      paramString.parseFrom(arrayOfByte);
      paramString = paramString.abIc;
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
  
  public static String a(atg paramatg)
  {
    AppMethodBeat.i(242908);
    if ((TextUtils.isEmpty(paramatg.ZDL)) || ((paramatg.FOi & 1L) == 1L)) {}
    for (paramatg = paramatg.ZDK;; paramatg = MMApplicationContext.getContext().getString(b.j.sns_share_finder_activity_card, new Object[] { paramatg.ZDL, paramatg.ZDK }))
    {
      AppMethodBeat.o(242908);
      return paramatg;
    }
  }
  
  public static String a(fho paramfho)
  {
    AppMethodBeat.i(94882);
    if (paramfho != null)
    {
      Object localObject = paramfho.Ywb;
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
        paramfho = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[] { Integer.valueOf(paramfho.abIg), URLEncoder.encode(str1, "UTF-8"), paramfho.abIf });
        AppMethodBeat.o(94882);
        return paramfho;
      }
      catch (UnsupportedEncodingException paramfho)
      {
        Log.e("MicroMsg.SnsStatExtUtil", "", new Object[] { paramfho });
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
    paramString = new fhn();
    try
    {
      paramString.parseFrom((byte[])localObject);
      localObject = paramString.abIc.Ywb;
      String str = paramString.abIc.abIf;
      localObject = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[] { URLEncoder.encode((String)localObject, "UTF-8"), URLEncoder.encode(str, "UTF-8"), Integer.valueOf(paramString.abIc.source), URLEncoder.encode(a(paramString.abIc), "UTF-8") });
      if (paramString.abIe == null) {}
      for (paramString = "";; paramString = paramString.abIe.ICZ)
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
    paramString = Pt(paramString);
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
  
  public static String at(cc paramcc)
  {
    AppMethodBeat.i(94883);
    if (paramcc == null)
    {
      AppMethodBeat.o(94883);
      return "";
    }
    Object localObject = null;
    if (paramcc.fxR())
    {
      localObject = k.b.Hf(paramcc.field_content);
      if ((localObject == null) || (Util.isNullOrNil(((k.b)localObject).iah)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = ((k.b)localObject).iah;
    }
    if (paramcc.dSJ())
    {
      paramcc = ab.Qo(paramcc.field_imgPath);
      if ((paramcc == null) || (Util.isNullOrNil(paramcc.iah)))
      {
        AppMethodBeat.o(94883);
        return "";
      }
      localObject = paramcc.iah;
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
    paramString = Pt(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {}
    for (int i = -1;; i = paramString.source)
    {
      paramn.s("Source", i + ",");
      paramn.s("SnsStatExt", a(paramString));
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
      oXw = new a("Chat", 0, 1);
      oXx = new a("TalkChat", 1, 2);
      oXy = new a("Sns", 2, 3);
      oXz = new a[] { oXw, oXx, oXy };
      AppMethodBeat.o(94876);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelstat.o
 * JD-Core Version:    0.7.0.1
 */