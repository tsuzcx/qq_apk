package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p
{
  public static String C(bi parambi)
  {
    Object localObject;
    if (parambi == null) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = null;
      if (parambi.aVK())
      {
        localObject = g.a.gp(parambi.field_content);
        if ((localObject == null) || (bk.bl(((g.a)localObject).bYN))) {
          return "";
        }
        localObject = ((g.a)localObject).bYN;
      }
    } while (!parambi.aRR());
    parambi = u.oe(parambi.field_imgPath);
    if ((parambi == null) || (bk.bl(parambi.bYN))) {
      return "";
    }
    return parambi.bYN;
  }
  
  public static String a(bvp parambvp)
  {
    if (parambvp != null)
    {
      Object localObject = parambvp.tMq;
      String str2 = "";
      String str1 = str2;
      if (!bk.bl((String)localObject))
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
        parambvp = String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[] { Integer.valueOf(parambvp.tMr), URLEncoder.encode(str1, "UTF-8"), parambvp.tMp });
        return parambvp;
      }
      catch (UnsupportedEncodingException parambvp)
      {
        y.e("MicroMsg.SnsStatExtUtil", "", new Object[] { parambvp });
      }
    }
    return "";
  }
  
  public static String a(String paramString, PString paramPString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    Object localObject = Base64.decode(paramString, 0);
    for (paramString = new bvo();; paramString = paramString.tMo.kOK) {
      try
      {
        paramString.aH((byte[])localObject);
        localObject = paramString.tMm.tMq;
        String str = paramString.tMm.tMp;
        localObject = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[] { URLEncoder.encode((String)localObject, "UTF-8"), URLEncoder.encode(str, "UTF-8"), Integer.valueOf(paramString.tMm.source), URLEncoder.encode(a(paramString.tMm), "UTF-8") });
        if (paramString.tMo == null)
        {
          paramString = "";
          paramPString.value = paramString;
          return localObject;
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramString, "", new Object[0]);
        return "";
      }
    }
  }
  
  public static void a(String paramString, d paramd)
  {
    if (paramd == null) {
      return;
    }
    b(paramString, paramd);
  }
  
  public static void b(String paramString, d paramd)
  {
    if ((bk.bl(paramString)) || (paramd == null)) {
      return;
    }
    paramString = nu(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {}
    for (int i = -1;; i = paramString.source)
    {
      paramd.j("Source", i + ",");
      paramd.j("SnsStatExt", a(paramString));
      return;
    }
  }
  
  public static bvp nu(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    paramString = new bvo();
    try
    {
      paramString.aH(arrayOfByte);
      return paramString.tMm;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SnsStatExtUtil", "", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.p
 * JD-Core Version:    0.7.0.1
 */