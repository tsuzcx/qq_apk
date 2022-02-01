package com.tencent.mm.plugin.car_license_plate.api.entity;

import com.tencent.luggage.l.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.car_license_plate.a.g;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.fvl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.z;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateWordings;", "", "()V", "<set-?>", "", "createPlatePrivacyDesc", "getCreatePlatePrivacyDesc", "()Ljava/lang/String;", "setCreatePlatePrivacyDesc", "(Ljava/lang/String;)V", "createPlatePrivacyDesc$delegate", "Lcom/tencent/luggage/util/LuggageMMKVProperty;", "halfScreenAuthPrivacySubDesc", "getHalfScreenAuthPrivacySubDesc", "setHalfScreenAuthPrivacySubDesc", "halfScreenAuthPrivacySubDesc$delegate", "Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "halfScreenAuthPrivacyThirdPartyDeclaration", "getHalfScreenAuthPrivacyThirdPartyDeclaration", "()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "setHalfScreenAuthPrivacyThirdPartyDeclaration", "(Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;)V", "halfScreenAuthPrivacyThirdPartyDeclaration$delegate", "userPrivacyProtectInfo", "Lcom/tencent/mm/protocal/protobuf/UserPrivacyProtectInfo;", "getUserPrivacyProtectInfo", "()Lcom/tencent/mm/protocal/protobuf/UserPrivacyProtectInfo;", "setUserPrivacyProtectInfo", "(Lcom/tencent/mm/protocal/protobuf/UserPrivacyProtectInfo;)V", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a wbN;
  public static final g wbO;
  public static final g wbP;
  public static final g wbQ;
  private static fvl wbR;
  
  static
  {
    AppMethodBeat.i(277600);
    aYe = new o[] { (o)ai.a((z)new aa(a.class, "halfScreenAuthPrivacySubDesc", "getHalfScreenAuthPrivacySubDesc()Ljava/lang/String;", 0)), (o)ai.a((z)new aa(a.class, "halfScreenAuthPrivacyThirdPartyDeclaration", "getHalfScreenAuthPrivacyThirdPartyDeclaration()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", 0)), (o)ai.a((z)new aa(a.class, "createPlatePrivacyDesc", "getCreatePlatePrivacyDesc()Ljava/lang/String;", 0)) };
    wbN = new a();
    Object localObject = MMApplicationContext.getString(a.g.car_license_plate_choose_sub_description);
    s.s(localObject, "getString(R.string.car_l…e_choose_sub_description)");
    wbO = new g(localObject, "MMCarLicensePlateWordings");
    localObject = new eq();
    if (BuildInfo.DEBUG)
    {
      ((eq)localObject).YGH = true;
      ((eq)localObject).YGI = "你授权后，小程序开发者将获得你微信绑定的包含昵称、头像、地区及性别等用户信息，为你提供相关服务。小程序开发者严格按照<a href=\"https://mp.weixin.qq.com/wxawap/waprivacyinfo?action=show&appid=wx40f8626ddf43d362#wechat_redirect\">《广州store商城阳光旗舰店--1号店小程序隐私保护指引》</a>收集、使用你的信息，如你发现开发者不当收集、使用你的信息，可进行<a href=\"https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=wx40f8626ddf43d362&from=6#wechat_redirect\">投诉</a>。";
    }
    for (;;)
    {
      ah localah = ah.aiuX;
      wbP = new g(localObject, "MMCarLicensePlateWordings");
      localObject = MMApplicationContext.getString(a.g.car_license_plate_create_privacy_description);
      s.s(localObject, "getString(R.string.car_l…eate_privacy_description)");
      wbQ = new g(localObject, "MMCarLicensePlateWordings");
      AppMethodBeat.o(277600);
      return;
      ((eq)localObject).YGH = false;
    }
  }
  
  public static void a(fvl paramfvl)
  {
    wbR = paramfvl;
  }
  
  public static fvl diN()
  {
    return wbR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.api.entity.a
 * JD-Core Version:    0.7.0.1
 */