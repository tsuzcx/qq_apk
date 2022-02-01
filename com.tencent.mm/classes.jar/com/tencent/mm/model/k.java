package com.tencent.mm.model;

import android.app.Activity;
import android.content.Intent;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.c.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.a;
import com.tencent.mm.api.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.f.d;
import java.util.ArrayList;
import org.json.JSONObject;

public final class k
  implements n
{
  private LruCache<String, b> lrz;
  
  public k()
  {
    AppMethodBeat.i(205731);
    this.lrz = new LruCache(3);
    AppMethodBeat.o(205731);
  }
  
  private b Pe(String paramString)
  {
    AppMethodBeat.i(205732);
    b localb2 = (b)this.lrz.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      this.lrz.put(paramString, localb1);
    }
    AppMethodBeat.o(205732);
    return localb1;
  }
  
  public final void a(Intent paramIntent, ebn paramebn, int paramInt)
  {
    AppMethodBeat.i(123964);
    String str = z.a(paramebn.SrH);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramebn.TtX));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramebn.SqW));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramebn.SqX));
    paramIntent.putExtra("Contact_Alias", paramebn.mVD);
    paramIntent.putExtra("Contact_Sex", paramebn.mVy);
    paramIntent.putExtra("Contact_VUser_Info", paramebn.TxG);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramebn.TxF);
    paramIntent.putExtra("Contact_KWeibo_flag", paramebn.TxJ);
    paramIntent.putExtra("Contact_KWeibo", paramebn.TxH);
    paramIntent.putExtra("Contact_KWeiboNick", paramebn.TxI);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bl(paramebn.mVH, paramebn.mVz, paramebn.mVA));
    paramIntent.putExtra("Contact_Signature", paramebn.mVB);
    paramIntent.putExtra("Contact_BrandList", paramebn.mVI);
    paramIntent.putExtra("Contact_KSnsIFlag", paramebn.TxL.mVJ);
    paramIntent.putExtra("Contact_KSnsBgId", paramebn.TxL.mVL);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramebn.TxL.mVK);
    paramIntent.putExtra(f.d.VRW, paramebn.Tav);
    Log.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramebn.Tav });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramebn.mVI;
    paramebn = paramebn.TxM;
    if (paramebn != null)
    {
      paramIntent.field_brandFlag = paramebn.mVM;
      paramIntent.field_brandInfo = paramebn.mVO;
      paramIntent.field_extInfo = paramebn.mVN;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramebn.mVP;
    }
    if (!af.bjv().h(paramIntent)) {
      af.bjv().g(paramIntent);
    }
    AppMethodBeat.o(123964);
  }
  
  public final void a(Intent paramIntent, ebp paramebp, int paramInt)
  {
    AppMethodBeat.i(123963);
    String str = z.a(paramebp.SrH);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramebp.TtX));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramebp.SqW));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramebp.SqX));
    paramIntent.putExtra("Contact_Alias", paramebp.mVD);
    paramIntent.putExtra("Contact_Sex", paramebp.mVy);
    paramIntent.putExtra("Contact_VUser_Info", paramebp.TxG);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramebp.TxF);
    paramIntent.putExtra("Contact_KWeibo_flag", paramebp.TxJ);
    paramIntent.putExtra("Contact_KWeibo", paramebp.TxH);
    paramIntent.putExtra("Contact_KWeiboNick", paramebp.TxI);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bl(paramebp.mVH, paramebp.mVz, paramebp.mVA));
    paramIntent.putExtra("Contact_Signature", paramebp.mVB);
    paramIntent.putExtra("Contact_BrandList", paramebp.mVI);
    paramIntent.putExtra("Contact_KSnsIFlag", paramebp.TxL.mVJ);
    paramIntent.putExtra("Contact_KSnsBgId", paramebp.TxL.mVL);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramebp.TxL.mVK);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramebp.Ugw);
    paramIntent.putExtra(f.d.VRW, paramebp.Tav);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", paramebp.Ugx);
    Log.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramebp.Tav });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramebp.mVI;
    paramIntent.field_kfWorkerId = paramebp.Ugw;
    paramebp = paramebp.TxM;
    if (paramebp != null)
    {
      paramIntent.field_brandFlag = paramebp.mVM;
      paramIntent.field_brandInfo = paramebp.mVO;
      paramIntent.field_extInfo = paramebp.mVN;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramebp.mVP;
    }
    if (!af.bjv().h(paramIntent)) {
      af.bjv().g(paramIntent);
    }
    AppMethodBeat.o(123963);
  }
  
  public final void b(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(205741);
    Pe(paramString).y(paramActivity);
    AppMethodBeat.o(205741);
  }
  
  public final boolean go(String paramString)
  {
    AppMethodBeat.i(123961);
    if (af.bjv().Uo(paramString).YR())
    {
      AppMethodBeat.o(123961);
      return true;
    }
    AppMethodBeat.o(123961);
    return false;
  }
  
  public final ArrayList<String> gp(String paramString)
  {
    AppMethodBeat.i(123962);
    try
    {
      paramString = af.bjv().Uo(paramString).dc(false);
      if ((paramString.eZJ == null) && (paramString.eZg != null)) {
        paramString.eZJ = c.b.a.gb(paramString.eZg.optString("AcctTransferInfo"));
      }
      paramString = paramString.eZJ.eZL;
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
  
  public final boolean gq(String paramString)
  {
    AppMethodBeat.i(205733);
    boolean bool = g.gq(paramString);
    AppMethodBeat.o(205733);
    return bool;
  }
  
  public final String gr(String paramString)
  {
    AppMethodBeat.i(205734);
    paramString = g.gr(paramString);
    AppMethodBeat.o(205734);
    return paramString;
  }
  
  public final String gs(String paramString)
  {
    AppMethodBeat.i(205737);
    paramString = g.gs(paramString);
    AppMethodBeat.o(205737);
    return paramString;
  }
  
  public final void gt(String paramString)
  {
    AppMethodBeat.i(205738);
    Pe(paramString).gt(paramString);
    AppMethodBeat.o(205738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */