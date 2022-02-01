package com.tencent.mm.model;

import android.app.Activity;
import android.content.Intent;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.f;
import com.tencent.mm.am.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.a;
import com.tencent.mm.api.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import org.json.JSONObject;

public final class k
  implements m
{
  private LruCache<String, b> hES;
  
  public k()
  {
    AppMethodBeat.i(207162);
    this.hES = new LruCache(3);
    AppMethodBeat.o(207162);
  }
  
  private b yD(String paramString)
  {
    AppMethodBeat.i(207163);
    b localb2 = (b)this.hES.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      this.hES.put(paramString, localb1);
    }
    AppMethodBeat.o(207163);
    return localb1;
  }
  
  public final void a(Intent paramIntent, cya paramcya, int paramInt)
  {
    AppMethodBeat.i(123964);
    String str = z.a(paramcya.GbY);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramcya.GKC));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramcya.Gbr));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramcya.Gbs));
    paramIntent.putExtra("Contact_Alias", paramcya.jdh);
    paramIntent.putExtra("Contact_Sex", paramcya.jdc);
    paramIntent.putExtra("Contact_VUser_Info", paramcya.GNV);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramcya.GNU);
    paramIntent.putExtra("Contact_KWeibo_flag", paramcya.GNY);
    paramIntent.putExtra("Contact_KWeibo", paramcya.GNW);
    paramIntent.putExtra("Contact_KWeiboNick", paramcya.GNX);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bf(paramcya.jdl, paramcya.jdd, paramcya.jde));
    paramIntent.putExtra("Contact_Signature", paramcya.jdf);
    paramIntent.putExtra("Contact_BrandList", paramcya.jdm);
    paramIntent.putExtra("Contact_KSnsIFlag", paramcya.GOa.jdn);
    paramIntent.putExtra("Contact_KSnsBgId", paramcya.GOa.jdp);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramcya.GOa.jdo);
    paramIntent.putExtra(e.c.IUp, paramcya.Guj);
    ad.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramcya.Guj });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramcya.jdm;
    paramcya = paramcya.GOb;
    if (paramcya != null)
    {
      paramIntent.field_brandFlag = paramcya.jdq;
      paramIntent.field_brandInfo = paramcya.jds;
      paramIntent.field_extInfo = paramcya.jdr;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramcya.jdt;
    }
    if (!ag.aFZ().g(paramIntent)) {
      ag.aFZ().f(paramIntent);
    }
    AppMethodBeat.o(123964);
  }
  
  public final void a(Intent paramIntent, cyc paramcyc, int paramInt)
  {
    AppMethodBeat.i(123963);
    String str = z.a(paramcyc.GbY);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramcyc.GKC));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramcyc.Gbr));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramcyc.Gbs));
    paramIntent.putExtra("Contact_Alias", paramcyc.jdh);
    paramIntent.putExtra("Contact_Sex", paramcyc.jdc);
    paramIntent.putExtra("Contact_VUser_Info", paramcyc.GNV);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramcyc.GNU);
    paramIntent.putExtra("Contact_KWeibo_flag", paramcyc.GNY);
    paramIntent.putExtra("Contact_KWeibo", paramcyc.GNW);
    paramIntent.putExtra("Contact_KWeiboNick", paramcyc.GNX);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bf(paramcyc.jdl, paramcyc.jdd, paramcyc.jde));
    paramIntent.putExtra("Contact_Signature", paramcyc.jdf);
    paramIntent.putExtra("Contact_BrandList", paramcyc.jdm);
    paramIntent.putExtra("Contact_KSnsIFlag", paramcyc.GOa.jdn);
    paramIntent.putExtra("Contact_KSnsBgId", paramcyc.GOa.jdp);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramcyc.GOa.jdo);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramcyc.Hpq);
    paramIntent.putExtra(e.c.IUp, paramcyc.Guj);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", paramcyc.Hpr);
    ad.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramcyc.Guj });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramcyc.jdm;
    paramIntent.field_kfWorkerId = paramcyc.Hpq;
    paramcyc = paramcyc.GOb;
    if (paramcyc != null)
    {
      paramIntent.field_brandFlag = paramcyc.jdq;
      paramIntent.field_brandInfo = paramcyc.jds;
      paramIntent.field_extInfo = paramcyc.jdr;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramcyc.jdt;
    }
    if (!ag.aFZ().g(paramIntent)) {
      ag.aFZ().f(paramIntent);
    }
    AppMethodBeat.o(123963);
  }
  
  public final void b(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(207168);
    yD(paramString).z(paramActivity);
    AppMethodBeat.o(207168);
  }
  
  public final boolean eM(String paramString)
  {
    AppMethodBeat.i(123961);
    if (ag.aFZ().DD(paramString).Kh())
    {
      AppMethodBeat.o(123961);
      return true;
    }
    AppMethodBeat.o(123961);
    return false;
  }
  
  public final ArrayList<String> eN(String paramString)
  {
    AppMethodBeat.i(123962);
    try
    {
      paramString = ag.aFZ().DD(paramString).bX(false);
      if ((paramString.cQZ == null) && (paramString.cQv != null)) {
        paramString.cQZ = c.b.a.ez(paramString.cQv.optString("AcctTransferInfo"));
      }
      paramString = paramString.cQZ.cRb;
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
  
  public final boolean eO(String paramString)
  {
    AppMethodBeat.i(207164);
    boolean bool = g.eO(paramString);
    AppMethodBeat.o(207164);
    return bool;
  }
  
  public final String eP(String paramString)
  {
    AppMethodBeat.i(207165);
    paramString = g.eP(paramString);
    AppMethodBeat.o(207165);
    return paramString;
  }
  
  public final String eQ(String paramString)
  {
    AppMethodBeat.i(207166);
    paramString = g.eQ(paramString);
    AppMethodBeat.o(207166);
    return paramString;
  }
  
  public final void eR(String paramString)
  {
    AppMethodBeat.i(207167);
    yD(paramString).eR(paramString);
    AppMethodBeat.o(207167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */