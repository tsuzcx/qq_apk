package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.a.rc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.d;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static boolean Jj()
  {
    if (!g.DK()) {}
    com.tencent.mm.storage.c localc;
    do
    {
      return false;
      localc = com.tencent.mm.model.c.c.IX().fJ("100360");
    } while ((!localc.isValid()) || (!"1".equals(localc.ctr().get("isOpenFTSSearchMiniGameEntry"))));
    return true;
  }
  
  private static void a(rc paramrc, g.a parama)
  {
    paramrc.caq.appId = parama.dSZ;
    paramrc.caq.userName = parama.dSY;
    paramrc.caq.cas = parama.dSX;
    paramrc.caq.cat = parama.dTf;
    paramrc.caq.caw = parama.dTb;
    paramrc.caq.cau = parama.dTg;
    paramrc = paramrc.caq;
    if (parama.dTf != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramrc.cax = bool;
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, g.a parama, Bundle paramBundle)
  {
    rc localrc = new rc();
    a(localrc, parama);
    b(localrc, parama);
    localrc.caq.scene = paramInt;
    if (paramInt == 1074) {
      localrc.caq.bFv = paramString;
    }
    localrc.caq.bIo = paramBundle;
    com.tencent.mm.sdk.b.a.udP.m(localrc);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, g.a parama, Bundle paramBundle)
  {
    rc localrc = new rc();
    a(localrc, parama);
    b(localrc, parama);
    rc.a locala = localrc.caq;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localrc.caq;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label139;
      }
    }
    label139:
    for (paramString1 = ":" + paramString2;; paramString1 = "")
    {
      locala.bFv = (paramString1 + ":" + parama.dTd);
      localrc.caq.bIo = paramBundle;
      com.tencent.mm.sdk.b.a.udP.m(localrc);
      return;
      i = 1007;
      break;
    }
  }
  
  private static void b(rc paramrc, g.a parama)
  {
    if (parama != null)
    {
      parama = (com.tencent.mm.ae.a)parama.A(com.tencent.mm.ae.a.class);
      if ((parama != null) && (!bk.bl(parama.dPP))) {
        paramrc.caq.caG = parama.dPP;
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, g.a parama, Bundle paramBundle)
  {
    rc localrc = new rc();
    a(localrc, parama);
    b(localrc, parama);
    localrc.caq.scene = 1044;
    localrc.caq.bFv = parama.dTd;
    rc.a locala = localrc.caq;
    int i;
    if (paramBoolean)
    {
      i = 2;
      locala.caB = i;
      locala = localrc.caq;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.caC = paramString2;
      localrc.caq.caz.dTX = parama.dTe;
      if (bk.bl(parama.dTe)) {
        break label147;
      }
    }
    label147:
    for (localrc.caq.caz.dZN = paramString1;; localrc.caq.caz.dZN = null)
    {
      localrc.caq.bIo = paramBundle;
      com.tencent.mm.sdk.b.a.udP.m(localrc);
      return;
      i = 1;
      break;
    }
  }
  
  public static boolean jq(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("BindWxaInfo");
        if (paramString != null)
        {
          int i = paramString.optInt("openWxaByBizQRCode", 0);
          if (i > 0) {
            return true;
          }
        }
      }
      catch (JSONException paramString) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a
 * JD-Core Version:    0.7.0.1
 */