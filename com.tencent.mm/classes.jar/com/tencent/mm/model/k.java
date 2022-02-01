package com.tencent.mm.model;

import android.app.Activity;
import android.content.Intent;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.e;
import com.tencent.mm.am.f;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.a;
import com.tencent.mm.api.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import org.json.JSONObject;

public final class k
  implements m
{
  private LruCache<String, b> gMe;
  
  public k()
  {
    AppMethodBeat.i(191036);
    this.gMe = new LruCache(3);
    AppMethodBeat.o(191036);
  }
  
  private b rJ(String paramString)
  {
    AppMethodBeat.i(191037);
    b localb2 = (b)this.gMe.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      this.gMe.put(paramString, localb1);
    }
    AppMethodBeat.o(191037);
    return localb1;
  }
  
  public final void a(Intent paramIntent, cnj paramcnj, int paramInt)
  {
    AppMethodBeat.i(123964);
    String str = z.a(paramcnj.Dby);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramcnj.DFJ));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramcnj.Dbb));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramcnj.Dbc));
    paramIntent.putExtra("Contact_Alias", paramcnj.ijR);
    paramIntent.putExtra("Contact_Sex", paramcnj.ijM);
    paramIntent.putExtra("Contact_VUser_Info", paramcnj.DIW);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramcnj.DIV);
    paramIntent.putExtra("Contact_KWeibo_flag", paramcnj.DIZ);
    paramIntent.putExtra("Contact_KWeibo", paramcnj.DIX);
    paramIntent.putExtra("Contact_KWeiboNick", paramcnj.DIY);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aT(paramcnj.ijV, paramcnj.ijN, paramcnj.ijO));
    paramIntent.putExtra("Contact_Signature", paramcnj.ijP);
    paramIntent.putExtra("Contact_BrandList", paramcnj.ijW);
    paramIntent.putExtra("Contact_KSnsIFlag", paramcnj.DJb.ijX);
    paramIntent.putExtra("Contact_KSnsBgId", paramcnj.DJb.ijZ);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramcnj.DJb.ijY);
    paramIntent.putExtra(e.c.FHR, paramcnj.Dqd);
    ad.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramcnj.Dqd });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramcnj.ijW;
    paramcnj = paramcnj.DJc;
    if (paramcnj != null)
    {
      paramIntent.field_brandFlag = paramcnj.ika;
      paramIntent.field_brandInfo = paramcnj.ikc;
      paramIntent.field_extInfo = paramcnj.ikb;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramcnj.ikd;
    }
    if (!af.awe().g(paramIntent)) {
      af.awe().f(paramIntent);
    }
    AppMethodBeat.o(123964);
  }
  
  public final void a(Intent paramIntent, cnl paramcnl, int paramInt)
  {
    AppMethodBeat.i(123963);
    String str = z.a(paramcnl.Dby);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramcnl.DFJ));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramcnl.Dbb));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramcnl.Dbc));
    paramIntent.putExtra("Contact_Alias", paramcnl.ijR);
    paramIntent.putExtra("Contact_Sex", paramcnl.ijM);
    paramIntent.putExtra("Contact_VUser_Info", paramcnl.DIW);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramcnl.DIV);
    paramIntent.putExtra("Contact_KWeibo_flag", paramcnl.DIZ);
    paramIntent.putExtra("Contact_KWeibo", paramcnl.DIX);
    paramIntent.putExtra("Contact_KWeiboNick", paramcnl.DIY);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aT(paramcnl.ijV, paramcnl.ijN, paramcnl.ijO));
    paramIntent.putExtra("Contact_Signature", paramcnl.ijP);
    paramIntent.putExtra("Contact_BrandList", paramcnl.ijW);
    paramIntent.putExtra("Contact_KSnsIFlag", paramcnl.DJb.ijX);
    paramIntent.putExtra("Contact_KSnsBgId", paramcnl.DJb.ijZ);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramcnl.DJb.ijY);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramcnl.EhT);
    paramIntent.putExtra(e.c.FHR, paramcnl.Dqd);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", paramcnl.EhU);
    ad.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramcnl.Dqd });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramcnl.ijW;
    paramIntent.field_kfWorkerId = paramcnl.EhT;
    paramcnl = paramcnl.DJc;
    if (paramcnl != null)
    {
      paramIntent.field_brandFlag = paramcnl.ika;
      paramIntent.field_brandInfo = paramcnl.ikc;
      paramIntent.field_extInfo = paramcnl.ikb;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramcnl.ikd;
    }
    if (!af.awe().g(paramIntent)) {
      af.awe().f(paramIntent);
    }
    AppMethodBeat.o(123963);
  }
  
  public final void b(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(191042);
    rJ(paramString).z(paramActivity);
    AppMethodBeat.o(191042);
  }
  
  public final boolean ec(String paramString)
  {
    AppMethodBeat.i(123961);
    if (af.awe().wy(paramString).IY())
    {
      AppMethodBeat.o(123961);
      return true;
    }
    AppMethodBeat.o(123961);
    return false;
  }
  
  public final ArrayList<String> ed(String paramString)
  {
    AppMethodBeat.i(123962);
    try
    {
      paramString = af.awe().wy(paramString).bU(false);
      if ((paramString.cIN == null) && (paramString.cIj != null)) {
        paramString.cIN = c.b.a.dO(paramString.cIj.optString("AcctTransferInfo"));
      }
      paramString = paramString.cIN.cIP;
      AppMethodBeat.o(123962);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(123962);
    }
    return paramString;
  }
  
  public final boolean ee(String paramString)
  {
    AppMethodBeat.i(191038);
    boolean bool = f.ee(paramString);
    AppMethodBeat.o(191038);
    return bool;
  }
  
  public final String ef(String paramString)
  {
    AppMethodBeat.i(191039);
    paramString = f.ef(paramString);
    AppMethodBeat.o(191039);
    return paramString;
  }
  
  public final String eg(String paramString)
  {
    AppMethodBeat.i(191040);
    paramString = f.eg(paramString);
    AppMethodBeat.o(191040);
    return paramString;
  }
  
  public final void eh(String paramString)
  {
    AppMethodBeat.i(191041);
    rJ(paramString).eh(paramString);
    AppMethodBeat.o(191041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */