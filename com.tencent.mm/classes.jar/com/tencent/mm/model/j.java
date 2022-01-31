package com.tencent.mm.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.a;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e.b;
import java.util.ArrayList;
import org.json.JSONObject;

public final class j
  implements com.tencent.mm.api.j
{
  public final void a(Intent paramIntent, bxf parambxf, int paramInt)
  {
    AppMethodBeat.i(11233);
    String str = aa.a(parambxf.wOT);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", aa.a(parambxf.xmi));
    paramIntent.putExtra("Contact_PyInitial", aa.a(parambxf.wOv));
    paramIntent.putExtra("Contact_QuanPin", aa.a(parambxf.wOw));
    paramIntent.putExtra("Contact_Alias", parambxf.gwU);
    paramIntent.putExtra("Contact_Sex", parambxf.gwP);
    paramIntent.putExtra("Contact_VUser_Info", parambxf.xpf);
    paramIntent.putExtra("Contact_VUser_Info_Flag", parambxf.xpe);
    paramIntent.putExtra("Contact_KWeibo_flag", parambxf.xpi);
    paramIntent.putExtra("Contact_KWeibo", parambxf.xpg);
    paramIntent.putExtra("Contact_KWeiboNick", parambxf.xph);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aF(parambxf.gwY, parambxf.gwQ, parambxf.gwR));
    paramIntent.putExtra("Contact_Signature", parambxf.gwS);
    paramIntent.putExtra("Contact_BrandList", parambxf.gwZ);
    paramIntent.putExtra("Contact_KSnsIFlag", parambxf.xpk.gxa);
    paramIntent.putExtra("Contact_KSnsBgId", parambxf.xpk.gxc);
    paramIntent.putExtra("Contact_KSnsBgUrl", parambxf.xpk.gxb);
    paramIntent.putExtra(e.b.yUZ, parambxf.wYu);
    ab.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { parambxf.wYu });
    paramIntent = new d();
    paramIntent.field_username = str;
    paramIntent.field_brandList = parambxf.gwZ;
    parambxf = parambxf.xpl;
    if (parambxf != null)
    {
      paramIntent.field_brandFlag = parambxf.gxd;
      paramIntent.field_brandInfo = parambxf.gxf;
      paramIntent.field_extInfo = parambxf.gxe;
      paramIntent.field_brandIconURL = parambxf.gxg;
    }
    if (!z.afi().e(paramIntent)) {
      z.afi().d(paramIntent);
    }
    AppMethodBeat.o(11233);
  }
  
  public final void a(Intent paramIntent, bxh parambxh, int paramInt)
  {
    AppMethodBeat.i(11232);
    String str = aa.a(parambxh.wOT);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", aa.a(parambxh.xmi));
    paramIntent.putExtra("Contact_PyInitial", aa.a(parambxh.wOv));
    paramIntent.putExtra("Contact_QuanPin", aa.a(parambxh.wOw));
    paramIntent.putExtra("Contact_Alias", parambxh.gwU);
    paramIntent.putExtra("Contact_Sex", parambxh.gwP);
    paramIntent.putExtra("Contact_VUser_Info", parambxh.xpf);
    paramIntent.putExtra("Contact_VUser_Info_Flag", parambxh.xpe);
    paramIntent.putExtra("Contact_KWeibo_flag", parambxh.xpi);
    paramIntent.putExtra("Contact_KWeibo", parambxh.xpg);
    paramIntent.putExtra("Contact_KWeiboNick", parambxh.xph);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aF(parambxh.gwY, parambxh.gwQ, parambxh.gwR));
    paramIntent.putExtra("Contact_Signature", parambxh.gwS);
    paramIntent.putExtra("Contact_BrandList", parambxh.gwZ);
    paramIntent.putExtra("Contact_KSnsIFlag", parambxh.xpk.gxa);
    paramIntent.putExtra("Contact_KSnsBgId", parambxh.xpk.gxc);
    paramIntent.putExtra("Contact_KSnsBgUrl", parambxh.xpk.gxb);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", parambxh.xKi);
    paramIntent.putExtra(e.b.yUZ, parambxh.wYu);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", parambxh.xKj);
    ab.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { parambxh.wYu });
    paramIntent = new d();
    paramIntent.field_username = str;
    paramIntent.field_brandList = parambxh.gwZ;
    paramIntent.field_kfWorkerId = parambxh.xKi;
    parambxh = parambxh.xpl;
    if (parambxh != null)
    {
      paramIntent.field_brandFlag = parambxh.gxd;
      paramIntent.field_brandInfo = parambxh.gxf;
      paramIntent.field_extInfo = parambxh.gxe;
      paramIntent.field_brandIconURL = parambxh.gxg;
    }
    if (!z.afi().e(paramIntent)) {
      z.afi().d(paramIntent);
    }
    AppMethodBeat.o(11232);
  }
  
  public final boolean dk(String paramString)
  {
    AppMethodBeat.i(11230);
    if (z.afi().rK(paramString).aea())
    {
      AppMethodBeat.o(11230);
      return true;
    }
    AppMethodBeat.o(11230);
    return false;
  }
  
  public final ArrayList<String> dl(String paramString)
  {
    AppMethodBeat.i(11231);
    try
    {
      paramString = z.afi().rK(paramString).cU(false);
      if ((paramString.fvE == null) && (paramString.fvc != null)) {
        paramString.fvE = d.b.a.rD(paramString.fvc.optString("AcctTransferInfo"));
      }
      paramString = paramString.fvE.fvG;
      AppMethodBeat.o(11231);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(11231);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.j
 * JD-Core Version:    0.7.0.1
 */