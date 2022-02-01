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
import com.tencent.mm.api.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import org.json.JSONObject;

public final class k
  implements m
{
  private LruCache<String, b> hHK;
  
  public k()
  {
    AppMethodBeat.i(188860);
    this.hHK = new LruCache(3);
    AppMethodBeat.o(188860);
  }
  
  private b zn(String paramString)
  {
    AppMethodBeat.i(188861);
    b localb2 = (b)this.hHK.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      this.hHK.put(paramString, localb1);
    }
    AppMethodBeat.o(188861);
    return localb1;
  }
  
  public final void a(Intent paramIntent, cyu paramcyu, int paramInt)
  {
    AppMethodBeat.i(123964);
    String str = z.a(paramcyu.GuF);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramcyu.Hed));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramcyu.GtY));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramcyu.GtZ));
    paramIntent.putExtra("Contact_Alias", paramcyu.jga);
    paramIntent.putExtra("Contact_Sex", paramcyu.jfV);
    paramIntent.putExtra("Contact_VUser_Info", paramcyu.Hhv);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramcyu.Hhu);
    paramIntent.putExtra("Contact_KWeibo_flag", paramcyu.Hhy);
    paramIntent.putExtra("Contact_KWeibo", paramcyu.Hhw);
    paramIntent.putExtra("Contact_KWeiboNick", paramcyu.Hhx);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bg(paramcyu.jge, paramcyu.jfW, paramcyu.jfX));
    paramIntent.putExtra("Contact_Signature", paramcyu.jfY);
    paramIntent.putExtra("Contact_BrandList", paramcyu.jgf);
    paramIntent.putExtra("Contact_KSnsIFlag", paramcyu.HhA.jgg);
    paramIntent.putExtra("Contact_KSnsBgId", paramcyu.HhA.jgi);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramcyu.HhA.jgh);
    paramIntent.putExtra(e.c.JoX, paramcyu.GNI);
    ae.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramcyu.GNI });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramcyu.jgf;
    paramcyu = paramcyu.HhB;
    if (paramcyu != null)
    {
      paramIntent.field_brandFlag = paramcyu.jgj;
      paramIntent.field_brandInfo = paramcyu.jgl;
      paramIntent.field_extInfo = paramcyu.jgk;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramcyu.jgm;
    }
    if (!ag.aGp().g(paramIntent)) {
      ag.aGp().f(paramIntent);
    }
    AppMethodBeat.o(123964);
  }
  
  public final void a(Intent paramIntent, cyw paramcyw, int paramInt)
  {
    AppMethodBeat.i(123963);
    String str = z.a(paramcyw.GuF);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", z.a(paramcyw.Hed));
    paramIntent.putExtra("Contact_PyInitial", z.a(paramcyw.GtY));
    paramIntent.putExtra("Contact_QuanPin", z.a(paramcyw.GtZ));
    paramIntent.putExtra("Contact_Alias", paramcyw.jga);
    paramIntent.putExtra("Contact_Sex", paramcyw.jfV);
    paramIntent.putExtra("Contact_VUser_Info", paramcyw.Hhv);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramcyw.Hhu);
    paramIntent.putExtra("Contact_KWeibo_flag", paramcyw.Hhy);
    paramIntent.putExtra("Contact_KWeibo", paramcyw.Hhw);
    paramIntent.putExtra("Contact_KWeiboNick", paramcyw.Hhx);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bg(paramcyw.jge, paramcyw.jfW, paramcyw.jfX));
    paramIntent.putExtra("Contact_Signature", paramcyw.jfY);
    paramIntent.putExtra("Contact_BrandList", paramcyw.jgf);
    paramIntent.putExtra("Contact_KSnsIFlag", paramcyw.HhA.jgg);
    paramIntent.putExtra("Contact_KSnsBgId", paramcyw.HhA.jgi);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramcyw.HhA.jgh);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramcyw.HIS);
    paramIntent.putExtra(e.c.JoX, paramcyw.GNI);
    paramIntent.putExtra("Contact_BIZ_PopupInfoMsg", paramcyw.HIT);
    ae.i("MicroMsg.BizInfoLogicImp", "[tomys] anti, content: %s", new Object[] { paramcyw.GNI });
    paramIntent = new c();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramcyw.jgf;
    paramIntent.field_kfWorkerId = paramcyw.HIS;
    paramcyw = paramcyw.HhB;
    if (paramcyw != null)
    {
      paramIntent.field_brandFlag = paramcyw.jgj;
      paramIntent.field_brandInfo = paramcyw.jgl;
      paramIntent.field_extInfo = paramcyw.jgk;
      paramIntent.field_attrSyncVersion = null;
      paramIntent.field_brandIconURL = paramcyw.jgm;
    }
    if (!ag.aGp().g(paramIntent)) {
      ag.aGp().f(paramIntent);
    }
    AppMethodBeat.o(123963);
  }
  
  public final void b(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(188866);
    zn(paramString).z(paramActivity);
    AppMethodBeat.o(188866);
  }
  
  public final boolean eR(String paramString)
  {
    AppMethodBeat.i(123961);
    if (ag.aGp().Ef(paramString).Kp())
    {
      AppMethodBeat.o(123961);
      return true;
    }
    AppMethodBeat.o(123961);
    return false;
  }
  
  public final ArrayList<String> eS(String paramString)
  {
    AppMethodBeat.i(123962);
    try
    {
      paramString = ag.aGp().Ef(paramString).bX(false);
      if ((paramString.cRJ == null) && (paramString.cRf != null)) {
        paramString.cRJ = c.b.a.eE(paramString.cRf.optString("AcctTransferInfo"));
      }
      paramString = paramString.cRJ.cRL;
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
  
  public final boolean eT(String paramString)
  {
    AppMethodBeat.i(188862);
    boolean bool = g.eT(paramString);
    AppMethodBeat.o(188862);
    return bool;
  }
  
  public final String eU(String paramString)
  {
    AppMethodBeat.i(188863);
    paramString = g.eU(paramString);
    AppMethodBeat.o(188863);
    return paramString;
  }
  
  public final String eV(String paramString)
  {
    AppMethodBeat.i(188864);
    paramString = g.eV(paramString);
    AppMethodBeat.o(188864);
    return paramString;
  }
  
  public final void eW(String paramString)
  {
    AppMethodBeat.i(188865);
    zn(paramString).eW(paramString);
    AppMethodBeat.o(188865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */