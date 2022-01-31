package com.tencent.mm.model;

import android.content.Intent;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.a;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.api.i;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e.a;
import java.util.ArrayList;
import org.json.JSONObject;

public final class j
  implements i
{
  public final void a(Intent paramIntent, bnk parambnk, int paramInt)
  {
    String str = aa.a(parambnk.sQs);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", aa.a(parambnk.tmw));
    paramIntent.putExtra("Contact_PyInitial", aa.a(parambnk.sQa));
    paramIntent.putExtra("Contact_QuanPin", aa.a(parambnk.sQb));
    paramIntent.putExtra("Contact_Alias", parambnk.ffm);
    paramIntent.putExtra("Contact_Sex", parambnk.ffh);
    paramIntent.putExtra("Contact_VUser_Info", parambnk.tph);
    paramIntent.putExtra("Contact_VUser_Info_Flag", parambnk.tpg);
    paramIntent.putExtra("Contact_KWeibo_flag", parambnk.tpk);
    paramIntent.putExtra("Contact_KWeibo", parambnk.tpi);
    paramIntent.putExtra("Contact_KWeiboNick", parambnk.tpj);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.ao(parambnk.ffq, parambnk.ffi, parambnk.ffj));
    paramIntent.putExtra("Contact_Signature", parambnk.ffk);
    paramIntent.putExtra("Contact_BrandList", parambnk.ffr);
    paramIntent.putExtra("Contact_KSnsIFlag", parambnk.tpm.ffs);
    paramIntent.putExtra("Contact_KSnsBgId", parambnk.tpm.ffu);
    paramIntent.putExtra("Contact_KSnsBgUrl", parambnk.tpm.fft);
    paramIntent.putExtra(e.a.uHO, parambnk.tac);
    y.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { parambnk.tac });
    paramIntent = new d();
    paramIntent.field_username = str;
    paramIntent.field_brandList = parambnk.ffr;
    parambnk = parambnk.tpn;
    if (parambnk != null)
    {
      paramIntent.field_brandFlag = parambnk.ffv;
      paramIntent.field_brandInfo = parambnk.ffx;
      paramIntent.field_extInfo = parambnk.ffw;
      paramIntent.field_brandIconURL = parambnk.ffy;
    }
    if (!z.My().e(paramIntent)) {
      z.My().d(paramIntent);
    }
  }
  
  public final void a(Intent paramIntent, bnm parambnm, int paramInt)
  {
    String str = aa.a(parambnm.sQs);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", aa.a(parambnm.tmw));
    paramIntent.putExtra("Contact_PyInitial", aa.a(parambnm.sQa));
    paramIntent.putExtra("Contact_QuanPin", aa.a(parambnm.sQb));
    paramIntent.putExtra("Contact_Alias", parambnm.ffm);
    paramIntent.putExtra("Contact_Sex", parambnm.ffh);
    paramIntent.putExtra("Contact_VUser_Info", parambnm.tph);
    paramIntent.putExtra("Contact_VUser_Info_Flag", parambnm.tpg);
    paramIntent.putExtra("Contact_KWeibo_flag", parambnm.tpk);
    paramIntent.putExtra("Contact_KWeibo", parambnm.tpi);
    paramIntent.putExtra("Contact_KWeiboNick", parambnm.tpj);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.ao(parambnm.ffq, parambnm.ffi, parambnm.ffj));
    paramIntent.putExtra("Contact_Signature", parambnm.ffk);
    paramIntent.putExtra("Contact_BrandList", parambnm.ffr);
    paramIntent.putExtra("Contact_KSnsIFlag", parambnm.tpm.ffs);
    paramIntent.putExtra("Contact_KSnsBgId", parambnm.tpm.ffu);
    paramIntent.putExtra("Contact_KSnsBgUrl", parambnm.tpm.fft);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", parambnm.tGt);
    paramIntent.putExtra(e.a.uHO, parambnm.tac);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", parambnm.tGu);
    y.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { parambnm.tac });
    paramIntent = new d();
    paramIntent.field_username = str;
    paramIntent.field_brandList = parambnm.ffr;
    paramIntent.field_kfWorkerId = parambnm.tGt;
    parambnm = parambnm.tpn;
    if (parambnm != null)
    {
      paramIntent.field_brandFlag = parambnm.ffv;
      paramIntent.field_brandInfo = parambnm.ffx;
      paramIntent.field_extInfo = parambnm.ffw;
      paramIntent.field_brandIconURL = parambnm.ffy;
    }
    if (!z.My().e(paramIntent)) {
      z.My().d(paramIntent);
    }
  }
  
  public final boolean ca(String paramString)
  {
    return z.My().kQ(paramString).Ls();
  }
  
  public final ArrayList<String> cb(String paramString)
  {
    try
    {
      paramString = z.My().kQ(paramString).bS(false);
      if ((paramString.efC == null) && (paramString.efa != null)) {
        paramString.efC = d.b.a.kJ(paramString.efa.optString("AcctTransferInfo"));
      }
      paramString = paramString.efC.efE;
      return paramString;
    }
    catch (Exception paramString) {}
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.j
 * JD-Core Version:    0.7.0.1
 */