package com.tencent.mm.ai;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.5;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.List;

public final class f
{
  public static boolean Mh()
  {
    return z.My().io(1) > 0;
  }
  
  public static boolean Mi()
  {
    return z.My().io(4) > 0;
  }
  
  public static boolean Mj()
  {
    return z.My().io(8) > 0;
  }
  
  public static boolean Mk()
  {
    return z.My().io(16) > 0;
  }
  
  public static boolean Ml()
  {
    return z.My().io(64) > 0;
  }
  
  public static List<String> Mm()
  {
    return z.My().in(128);
  }
  
  public static boolean Mn()
  {
    return z.My().io(128) > 0;
  }
  
  public static boolean Mo()
  {
    return z.My().io(256) > 0;
  }
  
  public static boolean Mp()
  {
    return z.My().io(512) > 0;
  }
  
  public static boolean eW(String paramString)
  {
    paramString = kX(paramString);
    if (paramString == null) {}
    while (!paramString.LA()) {
      return false;
    }
    return true;
  }
  
  public static void f(d paramd)
  {
    if (paramd == null)
    {
      y.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
      return;
    }
    aww localaww = new aww();
    localaww.ffv = paramd.field_brandFlag;
    localaww.hPY = paramd.field_username;
    ad localad = ((j)g.r(j.class)).Fw().abk(paramd.field_username);
    if ((localad != null) && (a.gR(localad.field_type))) {
      ((j)g.r(j.class)).Fv().b(new i.a(47, localaww));
    }
    for (;;)
    {
      y.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[] { Boolean.valueOf(z.My().c(paramd, new String[0])), Integer.valueOf(paramd.field_brandFlag) });
      return;
      ((j)g.r(j.class)).Fv().b(new i.a(58, localaww));
    }
  }
  
  public static void g(d paramd)
  {
    if (paramd != null)
    {
      aww localaww = new aww();
      localaww.ffv = paramd.field_brandFlag;
      localaww.hPY = paramd.field_username;
      ((j)g.r(j.class)).Fv().b(new i.a(47, localaww));
      z.My().c(paramd, new String[0]);
    }
  }
  
  public static d kX(String paramString)
  {
    paramString = z.My().kQ(paramString);
    if (paramString.field_updateTime > 0L) {
      return paramString;
    }
    return null;
  }
  
  public static boolean kY(String paramString)
  {
    paramString = kX(paramString);
    if (paramString == null) {}
    while (!paramString.Lv()) {
      return false;
    }
    return true;
  }
  
  public static boolean kZ(String paramString)
  {
    paramString = kX(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.Lw();
  }
  
  public static boolean la(String paramString)
  {
    paramString = kX(paramString);
    if (paramString == null) {}
    while (!paramString.Lx()) {
      return false;
    }
    return true;
  }
  
  public static boolean lb(String paramString)
  {
    paramString = kX(paramString);
    if (paramString == null) {}
    while (!paramString.Lz()) {
      return false;
    }
    return true;
  }
  
  public static boolean lc(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = kX(paramString);
    } while ((paramString == null) || (!paramString.Ly()));
    return true;
  }
  
  public static boolean ld(String paramString)
  {
    paramString = kX(paramString);
    if (paramString == null) {}
    while (!paramString.LB()) {
      return false;
    }
    return true;
  }
  
  public static boolean le(String paramString)
  {
    paramString = kX(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.Lq();
  }
  
  public static void lf(String paramString)
  {
    int i = 0;
    z.My();
    Object localObject = e.kT(paramString);
    if (localObject != null) {
      ((o)g.r(o.class)).Fz().HG((String)localObject);
    }
    ((j)g.r(j.class)).FB().abu(paramString);
    localObject = kX(paramString);
    if (localObject == null)
    {
      z.MH().jJ(paramString);
      return;
    }
    if (((d)localObject).Ly())
    {
      ((j)g.r(j.class)).FB().abN(paramString);
      z.My();
      List localList = e.kS(paramString);
      if ((localList == null) || (localList.size() <= 0)) {
        y.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
      }
      while (i < localList.size())
      {
        String str = (String)localList.get(i);
        if (eW(str)) {
          com.tencent.mm.ai.a.e.D(str, true);
        }
        z.My().delete(str);
        i += 1;
        continue;
        y.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", new Object[] { bk.csb() });
        com.tencent.mm.sdk.f.e.post(new bd.5(localList), "deleteMsgByTalkers");
      }
    }
    if (((d)localObject).LA()) {
      com.tencent.mm.ai.a.e.D(paramString, true);
    }
    z.My().c((d)localObject);
    z.MH().jJ(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.f
 * JD-Core Version:    0.7.0.1
 */