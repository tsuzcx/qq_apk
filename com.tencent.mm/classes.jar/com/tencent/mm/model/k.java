package com.tencent.mm.model;

import android.app.Activity;
import android.content.Intent;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.an.c.b;
import com.tencent.mm.an.f;
import com.tencent.mm.an.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.a;
import com.tencent.mm.api.o;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.f.e;
import java.util.ArrayList;
import org.json.JSONObject;

public final class k
  implements o
{
  private LruCache<String, b> oja;
  
  public k()
  {
    AppMethodBeat.i(241874);
    this.oja = new LruCache(3);
    AppMethodBeat.o(241874);
  }
  
  private b HX(String paramString)
  {
    AppMethodBeat.i(241879);
    b localb2 = (b)this.oja.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      this.oja.put(paramString, localb1);
    }
    AppMethodBeat.o(241879);
    return localb1;
  }
  
  public final void a(Intent paramIntent, eve parameve, int paramInt)
  {
    AppMethodBeat.i(123964);
    String str = w.a(parameve.ZqL);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", w.a(parameve.aaIz));
    paramIntent.putExtra("Contact_PyInitial", w.a(parameve.ZpX));
    paramIntent.putExtra("Contact_QuanPin", w.a(parameve.ZpY));
    paramIntent.putExtra("Contact_Alias", parameve.pSk);
    paramIntent.putExtra("Contact_Sex", parameve.pSf);
    paramIntent.putExtra("Contact_VUser_Info", parameve.aaMn);
    paramIntent.putExtra("Contact_VUser_Info_Flag", parameve.aaMm);
    paramIntent.putExtra("Contact_KWeibo_flag", parameve.aaMq);
    paramIntent.putExtra("Contact_KWeibo", parameve.aaMo);
    paramIntent.putExtra("Contact_KWeiboNick", parameve.aaMp);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bI(parameve.pSo, parameve.pSg, parameve.pSh));
    paramIntent.putExtra("Contact_Signature", parameve.pSi);
    paramIntent.putExtra("Contact_BrandList", parameve.pSp);
    paramIntent.putExtra("Contact_KSnsIFlag", parameve.aaMs.pSq);
    paramIntent.putExtra("Contact_KSnsBgId", parameve.aaMs.pSs);
    paramIntent.putExtra("Contact_KSnsBgUrl", parameve.aaMs.pSr);
    paramIntent.putExtra(f.e.adwe, parameve.aant);
    Log.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { parameve.aant });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = parameve.pSp;
    parameve = parameve.aaMt;
    if (parameve != null)
    {
      paramIntent.field_brandFlag = parameve.pSt;
      paramIntent.field_brandInfo = parameve.pSv;
      paramIntent.field_extInfo = parameve.pSu;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = parameve.pSw;
    }
    if (!af.bHf().h(paramIntent)) {
      af.bHf().g(paramIntent);
    }
    AppMethodBeat.o(123964);
  }
  
  public final void a(Intent paramIntent, evg paramevg, int paramInt)
  {
    AppMethodBeat.i(123963);
    String str = w.a(paramevg.ZqL);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", w.a(paramevg.aaIz));
    paramIntent.putExtra("Contact_PyInitial", w.a(paramevg.ZpX));
    paramIntent.putExtra("Contact_QuanPin", w.a(paramevg.ZpY));
    paramIntent.putExtra("Contact_Alias", paramevg.pSk);
    paramIntent.putExtra("Contact_Sex", paramevg.pSf);
    paramIntent.putExtra("Contact_VUser_Info", paramevg.aaMn);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramevg.aaMm);
    paramIntent.putExtra("Contact_KWeibo_flag", paramevg.aaMq);
    paramIntent.putExtra("Contact_KWeibo", paramevg.aaMo);
    paramIntent.putExtra("Contact_KWeiboNick", paramevg.aaMp);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bI(paramevg.pSo, paramevg.pSg, paramevg.pSh));
    paramIntent.putExtra("Contact_Signature", paramevg.pSi);
    paramIntent.putExtra("Contact_BrandList", paramevg.pSp);
    paramIntent.putExtra("Contact_KSnsIFlag", paramevg.aaMs.pSq);
    paramIntent.putExtra("Contact_KSnsBgId", paramevg.aaMs.pSs);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramevg.aaMs.pSr);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramevg.abxX);
    paramIntent.putExtra(f.e.adwe, paramevg.aant);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", paramevg.abxY);
    paramIntent.putExtra("Contact_Ext_Flag", paramevg.ExtFlag);
    Log.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramevg.aant });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramevg.pSp;
    paramIntent.field_kfWorkerId = paramevg.abxX;
    paramevg = paramevg.aaMt;
    if (paramevg != null)
    {
      paramIntent.field_brandFlag = paramevg.pSt;
      paramIntent.field_brandInfo = paramevg.pSv;
      paramIntent.field_extInfo = paramevg.pSu;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramevg.pSw;
    }
    if (!af.bHf().h(paramIntent)) {
      af.bHf().g(paramIntent);
    }
    AppMethodBeat.o(123963);
  }
  
  public final void b(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(241915);
    HX(paramString).B(paramActivity);
    AppMethodBeat.o(241915);
  }
  
  public final boolean hO(String paramString)
  {
    AppMethodBeat.i(123961);
    paramString = af.bHf().Mn(paramString);
    if ((paramString != null) && (paramString.aAJ()))
    {
      AppMethodBeat.o(123961);
      return true;
    }
    AppMethodBeat.o(123961);
    return false;
  }
  
  public final ArrayList<String> hP(String paramString)
  {
    AppMethodBeat.i(123962);
    try
    {
      paramString = af.bHf().Mn(paramString).dO(false);
      if ((paramString.hdj == null) && (paramString.hcG != null)) {
        paramString.hdj = c.b.a.hE(paramString.hcG.optString("AcctTransferInfo"));
      }
      paramString = paramString.hdj.hdl;
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
  
  public final boolean hQ(String paramString)
  {
    AppMethodBeat.i(241896);
    boolean bool = g.hQ(paramString);
    AppMethodBeat.o(241896);
    return bool;
  }
  
  public final String hR(String paramString)
  {
    AppMethodBeat.i(241901);
    paramString = g.hR(paramString);
    AppMethodBeat.o(241901);
    return paramString;
  }
  
  public final String hS(String paramString)
  {
    AppMethodBeat.i(241906);
    paramString = g.hS(paramString);
    AppMethodBeat.o(241906);
    return paramString;
  }
  
  public final void hT(String paramString)
  {
    AppMethodBeat.i(241911);
    HX(paramString).hT(paramString);
    AppMethodBeat.o(241911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */