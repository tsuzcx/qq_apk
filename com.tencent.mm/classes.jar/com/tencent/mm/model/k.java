package com.tencent.mm.model;

import android.app.Activity;
import android.content.Intent;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.al.c.b;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.a;
import com.tencent.mm.api.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import org.json.JSONObject;

public final class k
  implements m
{
  private LruCache<String, b> hmE;
  
  public k()
  {
    AppMethodBeat.i(209513);
    this.hmE = new LruCache(3);
    AppMethodBeat.o(209513);
  }
  
  private b vM(String paramString)
  {
    AppMethodBeat.i(209514);
    b localb2 = (b)this.hmE.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      this.hmE.put(paramString, localb1);
    }
    AppMethodBeat.o(209514);
    return localb1;
  }
  
  public final void a(Intent paramIntent, csq paramcsq, int paramInt)
  {
    AppMethodBeat.i(123964);
    String str = z.a(paramcsq.EuE);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramcsq.Fbd));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramcsq.EtY));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramcsq.EtZ));
    paramIntent.putExtra("Contact_Alias", paramcsq.iJY);
    paramIntent.putExtra("Contact_Sex", paramcsq.iJT);
    paramIntent.putExtra("Contact_VUser_Info", paramcsq.Fer);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramcsq.Feq);
    paramIntent.putExtra("Contact_KWeibo_flag", paramcsq.Feu);
    paramIntent.putExtra("Contact_KWeibo", paramcsq.Fes);
    paramIntent.putExtra("Contact_KWeiboNick", paramcsq.Fet);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aW(paramcsq.iKc, paramcsq.iJU, paramcsq.iJV));
    paramIntent.putExtra("Contact_Signature", paramcsq.iJW);
    paramIntent.putExtra("Contact_BrandList", paramcsq.iKd);
    paramIntent.putExtra("Contact_KSnsIFlag", paramcsq.Few.iKe);
    paramIntent.putExtra("Contact_KSnsBgId", paramcsq.Few.iKg);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramcsq.Few.iKf);
    paramIntent.putExtra(e.c.HgZ, paramcsq.ELg);
    ac.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramcsq.ELg });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramcsq.iKd;
    paramcsq = paramcsq.Fex;
    if (paramcsq != null)
    {
      paramIntent.field_brandFlag = paramcsq.iKh;
      paramIntent.field_brandInfo = paramcsq.iKj;
      paramIntent.field_extInfo = paramcsq.iKi;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramcsq.iKk;
    }
    if (!af.aCW().g(paramIntent)) {
      af.aCW().f(paramIntent);
    }
    AppMethodBeat.o(123964);
  }
  
  public final void a(Intent paramIntent, css paramcss, int paramInt)
  {
    AppMethodBeat.i(123963);
    String str = z.a(paramcss.EuE);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramcss.Fbd));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramcss.EtY));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramcss.EtZ));
    paramIntent.putExtra("Contact_Alias", paramcss.iJY);
    paramIntent.putExtra("Contact_Sex", paramcss.iJT);
    paramIntent.putExtra("Contact_VUser_Info", paramcss.Fer);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramcss.Feq);
    paramIntent.putExtra("Contact_KWeibo_flag", paramcss.Feu);
    paramIntent.putExtra("Contact_KWeibo", paramcss.Fes);
    paramIntent.putExtra("Contact_KWeiboNick", paramcss.Fet);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aW(paramcss.iKc, paramcss.iJU, paramcss.iJV));
    paramIntent.putExtra("Contact_Signature", paramcss.iJW);
    paramIntent.putExtra("Contact_BrandList", paramcss.iKd);
    paramIntent.putExtra("Contact_KSnsIFlag", paramcss.Few.iKe);
    paramIntent.putExtra("Contact_KSnsBgId", paramcss.Few.iKg);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramcss.Few.iKf);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramcss.FER);
    paramIntent.putExtra(e.c.HgZ, paramcss.ELg);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", paramcss.FES);
    ac.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramcss.ELg });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramcss.iKd;
    paramIntent.field_kfWorkerId = paramcss.FER;
    paramcss = paramcss.Fex;
    if (paramcss != null)
    {
      paramIntent.field_brandFlag = paramcss.iKh;
      paramIntent.field_brandInfo = paramcss.iKj;
      paramIntent.field_extInfo = paramcss.iKi;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramcss.iKk;
    }
    if (!af.aCW().g(paramIntent)) {
      af.aCW().f(paramIntent);
    }
    AppMethodBeat.o(123963);
  }
  
  public final void b(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(209519);
    vM(paramString).z(paramActivity);
    AppMethodBeat.o(209519);
  }
  
  public final boolean dR(String paramString)
  {
    AppMethodBeat.i(123961);
    if (af.aCW().AE(paramString).IH())
    {
      AppMethodBeat.o(123961);
      return true;
    }
    AppMethodBeat.o(123961);
    return false;
  }
  
  public final ArrayList<String> dS(String paramString)
  {
    AppMethodBeat.i(123962);
    try
    {
      paramString = af.aCW().AE(paramString).bV(false);
      if ((paramString.cFU == null) && (paramString.cFq != null)) {
        paramString.cFU = c.b.a.dD(paramString.cFq.optString("AcctTransferInfo"));
      }
      paramString = paramString.cFU.cFW;
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
  
  public final boolean dT(String paramString)
  {
    AppMethodBeat.i(209515);
    boolean bool = f.dT(paramString);
    AppMethodBeat.o(209515);
    return bool;
  }
  
  public final String dU(String paramString)
  {
    AppMethodBeat.i(209516);
    paramString = f.dU(paramString);
    AppMethodBeat.o(209516);
    return paramString;
  }
  
  public final String dV(String paramString)
  {
    AppMethodBeat.i(209517);
    paramString = f.dV(paramString);
    AppMethodBeat.o(209517);
    return paramString;
  }
  
  public final void dW(String paramString)
  {
    AppMethodBeat.i(209518);
    vM(paramString).dW(paramString);
    AppMethodBeat.o(209518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */