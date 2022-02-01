package com.tencent.mm.model;

import android.app.Activity;
import android.content.Intent;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.c.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.a;
import com.tencent.mm.api.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e.d;
import java.util.ArrayList;
import org.json.JSONObject;

public final class k
  implements n
{
  private LruCache<String, b> iBU;
  
  public k()
  {
    AppMethodBeat.i(212151);
    this.iBU = new LruCache(3);
    AppMethodBeat.o(212151);
  }
  
  private b HP(String paramString)
  {
    AppMethodBeat.i(212152);
    b localb2 = (b)this.iBU.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      this.iBU.put(paramString, localb1);
    }
    AppMethodBeat.o(212152);
    return localb1;
  }
  
  public final void a(Intent paramIntent, drr paramdrr, int paramInt)
  {
    AppMethodBeat.i(123964);
    String str = z.a(paramdrr.Lqk);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramdrr.Mjj));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramdrr.LpA));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramdrr.LpB));
    paramIntent.putExtra("Contact_Alias", paramdrr.ked);
    paramIntent.putExtra("Contact_Sex", paramdrr.kdY);
    paramIntent.putExtra("Contact_VUser_Info", paramdrr.MmL);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramdrr.MmK);
    paramIntent.putExtra("Contact_KWeibo_flag", paramdrr.MmO);
    paramIntent.putExtra("Contact_KWeibo", paramdrr.MmM);
    paramIntent.putExtra("Contact_KWeiboNick", paramdrr.MmN);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(paramdrr.keh, paramdrr.kdZ, paramdrr.kea));
    paramIntent.putExtra("Contact_Signature", paramdrr.keb);
    paramIntent.putExtra("Contact_BrandList", paramdrr.kei);
    paramIntent.putExtra("Contact_KSnsIFlag", paramdrr.MmQ.kej);
    paramIntent.putExtra("Contact_KSnsBgId", paramdrr.MmQ.kel);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramdrr.MmQ.kek);
    paramIntent.putExtra(e.d.OyT, paramdrr.LRO);
    Log.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramdrr.LRO });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramdrr.kei;
    paramdrr = paramdrr.MmR;
    if (paramdrr != null)
    {
      paramIntent.field_brandFlag = paramdrr.kem;
      paramIntent.field_brandInfo = paramdrr.keo;
      paramIntent.field_extInfo = paramdrr.ken;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramdrr.kep;
    }
    if (!ag.bah().h(paramIntent)) {
      ag.bah().g(paramIntent);
    }
    AppMethodBeat.o(123964);
  }
  
  public final void a(Intent paramIntent, drt paramdrt, int paramInt)
  {
    AppMethodBeat.i(123963);
    String str = z.a(paramdrt.Lqk);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramdrt.Mjj));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramdrt.LpA));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramdrt.LpB));
    paramIntent.putExtra("Contact_Alias", paramdrt.ked);
    paramIntent.putExtra("Contact_Sex", paramdrt.kdY);
    paramIntent.putExtra("Contact_VUser_Info", paramdrt.MmL);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramdrt.MmK);
    paramIntent.putExtra("Contact_KWeibo_flag", paramdrt.MmO);
    paramIntent.putExtra("Contact_KWeibo", paramdrt.MmM);
    paramIntent.putExtra("Contact_KWeiboNick", paramdrt.MmN);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(paramdrt.keh, paramdrt.kdZ, paramdrt.kea));
    paramIntent.putExtra("Contact_Signature", paramdrt.keb);
    paramIntent.putExtra("Contact_BrandList", paramdrt.kei);
    paramIntent.putExtra("Contact_KSnsIFlag", paramdrt.MmQ.kej);
    paramIntent.putExtra("Contact_KSnsBgId", paramdrt.MmQ.kel);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramdrt.MmQ.kek);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramdrt.MUn);
    paramIntent.putExtra(e.d.OyT, paramdrt.LRO);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", paramdrt.MUo);
    Log.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramdrt.LRO });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramdrt.kei;
    paramIntent.field_kfWorkerId = paramdrt.MUn;
    paramdrt = paramdrt.MmR;
    if (paramdrt != null)
    {
      paramIntent.field_brandFlag = paramdrt.kem;
      paramIntent.field_brandInfo = paramdrt.keo;
      paramIntent.field_extInfo = paramdrt.ken;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramdrt.kep;
    }
    if (!ag.bah().h(paramIntent)) {
      ag.bah().g(paramIntent);
    }
    AppMethodBeat.o(123963);
  }
  
  public final void b(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(212157);
    HP(paramString).z(paramActivity);
    AppMethodBeat.o(212157);
  }
  
  public final boolean fD(String paramString)
  {
    AppMethodBeat.i(123961);
    if (ag.bah().MT(paramString).Uz())
    {
      AppMethodBeat.o(123961);
      return true;
    }
    AppMethodBeat.o(123961);
    return false;
  }
  
  public final ArrayList<String> fE(String paramString)
  {
    AppMethodBeat.i(123962);
    try
    {
      paramString = ag.bah().MT(paramString).cG(false);
      if ((paramString.dic == null) && (paramString.dhz != null)) {
        paramString.dic = c.b.a.fq(paramString.dhz.optString("AcctTransferInfo"));
      }
      paramString = paramString.dic.die;
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
  
  public final boolean fF(String paramString)
  {
    AppMethodBeat.i(212153);
    boolean bool = g.fF(paramString);
    AppMethodBeat.o(212153);
    return bool;
  }
  
  public final String fG(String paramString)
  {
    AppMethodBeat.i(212154);
    paramString = g.fG(paramString);
    AppMethodBeat.o(212154);
    return paramString;
  }
  
  public final String fH(String paramString)
  {
    AppMethodBeat.i(212155);
    paramString = g.fH(paramString);
    AppMethodBeat.o(212155);
    return paramString;
  }
  
  public final void fI(String paramString)
  {
    AppMethodBeat.i(212156);
    HP(paramString).fI(paramString);
    AppMethodBeat.o(212156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */