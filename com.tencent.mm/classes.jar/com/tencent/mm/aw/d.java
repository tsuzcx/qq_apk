package com.tencent.mm.aw;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bxw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;

public final class d
  implements f
{
  public d.a evv = null;
  
  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    bm localbm = com.tencent.mm.plugin.y.a.bou().Fr(paramInt1);
    if (localbm == null)
    {
      localbm = new bm();
      localbm.field_tipId = paramInt1;
      localbm.field_tipVersion = 1;
      localbm.field_tipkey = paramString1;
      localbm.field_tipType = paramInt2;
      if (localbm.field_tipsShowInfo == null) {
        localbm.field_tipsShowInfo = new bxw();
      }
      localbm.field_tipsShowInfo.path = paramString2;
      com.tencent.mm.plugin.y.a.bou().f(localbm);
      if ((paramInt2 == b.evd) && ((!localbm.field_isExit) || (1 != localbm.field_tipVersion)))
      {
        paramString1 = new a(paramInt1, paramString1);
        g.Dk().a(paramString1, 0);
        y.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
      }
    }
    do
    {
      return;
      if ((paramInt2 == b.evd) && ((!localbm.field_isExit) || (1 != localbm.field_tipVersion)))
      {
        a locala = new a(paramInt1, paramString1);
        g.Dk().a(locala, 0);
        y.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
      }
    } while (((paramInt2 != b.evd) || (1 == localbm.field_tipVersion)) && ((paramInt2 != b.eve) || (localbm.field_tipVersion > 0)));
    localbm.field_tipId = paramInt1;
    localbm.field_tipVersion = 1;
    localbm.field_tipkey = paramString1;
    localbm.field_tipType = paramInt2;
    localbm.field_isExit = false;
    if (localbm.field_tipsShowInfo == null) {
      localbm.field_tipsShowInfo = new bxw();
    }
    localbm.field_tipsShowInfo.path = paramString2;
    com.tencent.mm.plugin.y.a.bou().a(localbm, new String[0]);
  }
  
  public static void iX(int paramInt)
  {
    bm localbm = com.tencent.mm.plugin.y.a.bou().Fr(paramInt);
    if (localbm == null)
    {
      y.e("MicroMsg.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
      return;
    }
    y.i("MicroMsg.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true) });
    if (localbm.field_tipType == b.evd)
    {
      localbm.field_hadRead = true;
      com.tencent.mm.plugin.y.a.bou().a(localbm, new String[0]);
    }
    if (localbm.field_tipType == b.eve)
    {
      localbm.field_hadRead = true;
      com.tencent.mm.plugin.y.a.bou().a(localbm, new String[0]);
    }
    long l = bk.UY();
    ae.getContext().getSharedPreferences(ae.cqR() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l).commit();
  }
  
  public static void l(int paramInt, long paramLong)
  {
    bm localbm = com.tencent.mm.plugin.y.a.bou().Fr(paramInt);
    if (localbm == null)
    {
      y.e("MicroMsg.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
      return;
    }
    localbm.field_pagestaytime = paramLong;
    com.tencent.mm.plugin.y.a.bou().a(localbm, new String[0]);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.NewTipsManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramm.getType() != 597) || (paramInt1 != 0) || (paramInt2 != 0)) {}
    boolean bool;
    do
    {
      return;
      bool = ((a)paramm).evb;
      paramInt1 = ((a)paramm).evc;
      paramString = com.tencent.mm.plugin.y.a.bou().Fr(paramInt1);
    } while (paramString == null);
    paramString.field_isReject = bool;
    y.i("MicroMsg.NewTipsManager", "Newtips push is reject: %s", new Object[] { Boolean.valueOf(bool) });
    com.tencent.mm.plugin.y.a.bou().a(paramString, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aw.d
 * JD-Core Version:    0.7.0.1
 */