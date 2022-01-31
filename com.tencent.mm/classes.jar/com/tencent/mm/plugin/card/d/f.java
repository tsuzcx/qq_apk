package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.adv;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static ArrayList<ShareCardInfo> It(String paramString)
  {
    AppMethodBeat.i(88851);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
      AppMethodBeat.o(88851);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ab.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
        AppMethodBeat.o(88851);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        ShareCardInfo localShareCardInfo = new ShareCardInfo();
        a(localShareCardInfo, localJSONObject);
        localArrayList.add(localShareCardInfo);
        i += 1;
      }
      AppMethodBeat.o(88851);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(88851);
    }
    return null;
  }
  
  public static ArrayList<CardInfo> Iu(String paramString)
  {
    AppMethodBeat.i(88854);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
      AppMethodBeat.o(88854);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_array");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ab.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
        AppMethodBeat.o(88854);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        CardInfo localCardInfo = new CardInfo();
        a(localCardInfo, localJSONObject);
        localArrayList.add(localCardInfo);
        i += 1;
      }
      AppMethodBeat.o(88854);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(88854);
    }
    return null;
  }
  
  private static String Iv(String paramString)
  {
    AppMethodBeat.i(88857);
    if ((TextUtils.isEmpty(paramString)) || ("null".equals(paramString)))
    {
      AppMethodBeat.o(88857);
      return "";
    }
    AppMethodBeat.o(88857);
    return paramString;
  }
  
  private static oj M(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(88858);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      AppMethodBeat.o(88858);
      return null;
    }
    oj localoj = new oj();
    for (;;)
    {
      try
      {
        localoj.status = paramJSONObject.optInt("status");
        localoj.wDM = paramJSONObject.optInt("init_balance");
        localoj.wDN = paramJSONObject.optInt("init_bonus");
        localObject1 = paramJSONObject.optJSONArray("cell_list0");
        if (localObject1 != null) {
          localoj.wDO = q((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list1");
        if (localObject1 != null) {
          localoj.wDP = q((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list2");
        if (localObject1 != null) {
          localoj.wDQ = q((JSONArray)localObject1);
        }
        localJSONArray = paramJSONObject.optJSONArray("acceptors");
        if (localJSONArray != null)
        {
          localObject1 = localObject2;
          if (localJSONArray != null)
          {
            if (localJSONArray.length() != 0) {
              continue;
            }
            localObject1 = localObject2;
          }
          localoj.wDR = ((LinkedList)localObject1);
        }
        localoj.wDS = paramJSONObject.optInt("avail_num");
        localoj.wDT = paramJSONObject.optInt("code_type");
        localoj.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          localoj.wDU = r((JSONArray)localObject1);
        }
        localoj.wDV = paramJSONObject.optLong("stock_num");
        localoj.wDW = paramJSONObject.optInt("limit_num");
        localoj.wDX = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          localoj.wDY = P((JSONObject)localObject1);
        }
        localoj.wDZ = s(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          localoj.wEa = P((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          localoj.wEb = P((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          localoj.wEc = P((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          localoj.wEd = T((JSONObject)localObject1);
        }
        localoj.wEe = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          localoj.wEf = P((JSONObject)localObject1);
        }
        localoj.wEg = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          localoj.wEh = P((JSONObject)localObject1);
        }
        localoj.wEi = paramJSONObject.optBoolean("is_commom_card");
        localoj.wEj = paramJSONObject.optBoolean("is_location_authorized");
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject1;
        JSONArray localJSONArray;
        int i;
        ab.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(88858);
      return localoj;
      localObject1 = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        ((LinkedList)localObject1).add((String)localJSONArray.get(i));
        i += 1;
      }
    }
  }
  
  public static pg N(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(88860);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      AppMethodBeat.o(88860);
      return null;
    }
    pg localpg = new pg();
    Object localObject1;
    Object localObject3;
    label526:
    label556:
    label721:
    int i;
    label804:
    label1018:
    cjg localcjg;
    for (;;)
    {
      try
      {
        localpg.kml = paramJSONObject.optString("card_tp_id");
        localpg.kmm = paramJSONObject.optString("logo_url");
        localpg.cwc = paramJSONObject.optString("appid");
        localpg.wFW = paramJSONObject.optString("app_username");
        localpg.wFX = paramJSONObject.optInt("card_category");
        localpg.iFL = paramJSONObject.optInt("card_type");
        localpg.knw = paramJSONObject.optString("brand_name");
        localpg.title = paramJSONObject.optString("title");
        localpg.kmn = paramJSONObject.optString("sub_title");
        localpg.color = paramJSONObject.optString("color");
        localpg.kNG = paramJSONObject.optString("notice");
        localpg.wFY = paramJSONObject.optString("service_phone");
        localpg.wGb = paramJSONObject.optString("image_text_url");
        localpg.wGc = paramJSONObject.optString("source_icon");
        localpg.source = paramJSONObject.optString("source");
        localObject1 = paramJSONObject.optJSONArray("primary_fields");
        if (localObject1 != null) {
          localpg.wFZ = r((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("introduce_fields");
        if (localObject1 != null) {
          localpg.wGa = r((JSONArray)localObject1);
        }
        localpg.wGd = paramJSONObject.optInt("shop_count");
        localpg.wGe = paramJSONObject.optString("limit_wording");
        localpg.knv = paramJSONObject.optString("card_type_name");
        localpg.wGf = paramJSONObject.optString("h5_show_url");
        localpg.wGg = paramJSONObject.optInt("block_mask");
        localpg.wGh = paramJSONObject.optString("middle_icon");
        localpg.wGi = paramJSONObject.optString("accept_wording");
        localpg.wGj = paramJSONObject.optLong("control_flag");
        localpg.wGk = paramJSONObject.optString("advertise_wording");
        localpg.wGl = paramJSONObject.optString("advertise_url");
        localpg.wGm = paramJSONObject.optString("public_service_name");
        localObject3 = paramJSONObject.optJSONObject("announcement");
        if (localObject3 != null) {
          continue;
        }
        ab.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
        localpg.wGn = ((ov)localObject1);
        localpg.wGo = paramJSONObject.optString("public_service_tip");
        localpg.wGp = paramJSONObject.optString("primary_sub_title");
        localpg.wGq = paramJSONObject.optInt("gen_type");
        localpg.wGr = R(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          continue;
        }
        ab.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localpg.wGs = ((cpd)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1192;
        }
        ab.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        localpg.wGt = ((adv)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1265;
        }
        ab.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        localpg.wGu = ((ax)localObject1);
        localpg.wGv = paramJSONObject.optInt("need_direct_jump", 0);
        localpg.wGw = paramJSONObject.optInt("is_acceptable", 0);
        localpg.wGx = paramJSONObject.optString("unacceptable_wording");
        localpg.wGy = paramJSONObject.optInt("has_hongbao", 0);
        localpg.wGz = paramJSONObject.optString("accept_ui_title");
        localpg.wGA = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localpg.wGB = P((JSONObject)localObject1);
        }
        localpg.wGC = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localpg.wGD = P((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1300;
          }
          ab.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          localpg.wGE = ((zc)localObject1);
        }
        localpg.wGF = paramJSONObject.optBoolean("is_card_code_exposed");
        localpg.wGG = paramJSONObject.optInt("qrcode_correct_level");
        localpg.wGH = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localpg.wGI = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1398;
          }
          ab.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          localpg.wGJ = ((mb)localObject1);
        }
        localpg.wGK = paramJSONObject.optString("biz_nickname");
        localpg.wGL = paramJSONObject.optString("gift_title");
        ab.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localpg.wGL });
      }
      catch (JSONException paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
        localObject1 = new cpd();
        ((cpd)localObject1).title = ((JSONObject)localObject3).optString("title");
        localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
        if (localJSONArray == null) {
          break;
        }
      }
      AppMethodBeat.o(88860);
      return localpg;
      localObject1 = new ov();
      ((ov)localObject1).type = ((JSONObject)localObject3).optInt("type");
      ((ov)localObject1).text = ((JSONObject)localObject3).optString("text");
      ((ov)localObject1).url = ((JSONObject)localObject3).optString("url");
      ((ov)localObject1).qNK = ((JSONObject)localObject3).optInt("endtime");
      ((ov)localObject1).wyt = ((JSONObject)localObject3).optInt("create_time");
      ((ov)localObject1).wFr = ((JSONObject)localObject3).optString("thumb_url");
      continue;
      if (localJSONArray.length() > 0)
      {
        ((cpd)localObject1).xXT = new LinkedList();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label1064;
        }
        localcjg = S(localJSONArray.optJSONObject(i));
        if (localcjg == null) {
          break label1453;
        }
        ((cpd)localObject1).xXT.add(localcjg);
        break label1453;
      }
    }
    ab.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    label1064:
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((cpd)localObject1).xXU = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localcjg = S(localJSONArray.optJSONObject(i));
        if (localcjg != null)
        {
          ((cpd)localObject1).xXU.add(localcjg);
          break label1460;
          ab.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((cpd)localObject1).xXV = r((JSONArray)localObject3);
          break;
        }
        ab.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1192:
        localObject1 = new adv();
        ((adv)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((adv)localObject1).wWN = ((JSONObject)localObject3).optInt("follow");
        ab.i("MicroMsg.CardInfoParser", "follow:" + ((adv)localObject1).wWN + "　text:" + ((adv)localObject1).text);
        break label526;
        label1265:
        localObject1 = new ax();
        ((ax)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((ax)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label556;
        label1300:
        localObject1 = new zc();
        ((zc)localObject1).wPY = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((zc)localObject1).wPZ = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((zc)localObject1).wQa = ((JSONObject)localObject3).optString("refresh_wording");
        ab.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((zc)localObject1).wPY + "　can_refresh:" + ((zc)localObject1).wPZ + "　refresh_wording:" + ((zc)localObject1).wQa);
        break label721;
        label1398:
        localObject1 = new mb();
        ((mb)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((mb)localObject1).wAw = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        ab.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((mb)localObject1).name });
        break label804;
        label1453:
        i += 1;
        break label1018;
      }
      label1460:
      i += 1;
    }
  }
  
  private static ccf O(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88862);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      AppMethodBeat.o(88862);
      return null;
    }
    ccf localccf = new ccf();
    localccf.xMB = paramJSONObject.optString("gift_msg_title");
    AppMethodBeat.o(88862);
    return localccf;
  }
  
  private static uo P(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88864);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      AppMethodBeat.o(88864);
      return null;
    }
    uo localuo = new uo();
    localuo.title = paramJSONObject.optString("title");
    localuo.kmo = paramJSONObject.optString("aux_title");
    localuo.kmn = paramJSONObject.optString("sub_title");
    localuo.url = paramJSONObject.optString("url");
    localuo.wGZ = paramJSONObject.optLong("show_flag");
    localuo.wHa = paramJSONObject.optString("primary_color");
    localuo.wHb = paramJSONObject.optString("secondary_color");
    localuo.kWy = paramJSONObject.optString("icon_url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null) {
      localuo.wML = Q(localJSONObject);
    }
    localuo.wFL = paramJSONObject.optString("app_brand_user_name");
    localuo.wFM = paramJSONObject.optString("app_brand_pass");
    AppMethodBeat.o(88864);
    return localuo;
  }
  
  private static atg Q(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88865);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
      AppMethodBeat.o(88865);
      return null;
    }
    ab.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { paramJSONObject });
    atg localatg = new atg();
    localatg.wlL = p.cU(paramJSONObject.optString("biz_uin"));
    localatg.wlM = paramJSONObject.optString("order_id");
    AppMethodBeat.o(88865);
    return localatg;
  }
  
  private static ye R(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88866);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      AppMethodBeat.o(88866);
      return null;
    }
    ye localye = new ye();
    localye.title = paramJSONObject.optString("title");
    localye.url = paramJSONObject.optString("url");
    localye.desc = paramJSONObject.optString("abstract");
    localye.detail = paramJSONObject.optString("detail");
    localye.wPl = paramJSONObject.optString("ad_title");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("icon_url_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      for (;;)
      {
        if (i >= localJSONArray.length()) {
          break label198;
        }
        paramJSONObject = "";
        try
        {
          String str = localJSONArray.getString(i);
          paramJSONObject = str;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            ab.e("MicroMsg.CardInfoParser", "getMessage:" + localJSONException.getMessage());
          }
        }
        localLinkedList.add(paramJSONObject);
        i += 1;
      }
      label198:
      localye.wPk = localLinkedList;
    }
    for (;;)
    {
      AppMethodBeat.o(88866);
      return localye;
      ab.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static cjg S(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88867);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      AppMethodBeat.o(88867);
      return null;
    }
    cjg localcjg = new cjg();
    localcjg.tag = paramJSONObject.optString("tag");
    localcjg.color = paramJSONObject.optString("color");
    AppMethodBeat.o(88867);
    return localcjg;
  }
  
  private static yf T(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88868);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      AppMethodBeat.o(88868);
      return null;
    }
    yf localyf = new yf();
    localyf.title = paramJSONObject.optString("title");
    localyf.kmn = paramJSONObject.optString("sub_title");
    localyf.wPm = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
    for (;;)
    {
      try
      {
        localyf.wPn = r(paramJSONObject);
        AppMethodBeat.o(88868);
        return localyf;
      }
      catch (JSONException paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        ab.e("MicroMsg.CardInfoParser", paramJSONObject.getMessage());
        continue;
      }
      ab.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
    }
  }
  
  public static void a(CardInfo paramCardInfo, String paramString)
  {
    AppMethodBeat.i(88855);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
      AppMethodBeat.o(88855);
      return;
    }
    try
    {
      a(paramCardInfo, new JSONObject(paramString));
      AppMethodBeat.o(88855);
      return;
    }
    catch (JSONException paramCardInfo)
    {
      ab.printErrStackTrace("MicroMsg.CardInfoParser", paramCardInfo, "", new Object[0]);
      AppMethodBeat.o(88855);
    }
  }
  
  private static void a(CardInfo paramCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88856);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
      AppMethodBeat.o(88856);
      return;
    }
    paramCardInfo.field_card_id = Iv(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = Iv(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.kmp = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.knp = M(localJSONObject1);
    paramCardInfo.kno = N(localJSONObject2);
    paramCardInfo.knq = O(paramJSONObject);
    if (paramCardInfo.kno != null)
    {
      paramCardInfo.a(paramCardInfo.kno);
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.kno.wGg);
      paramCardInfo.field_card_type = paramCardInfo.kno.iFL;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.kno.kml;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_begin_time = localJSONObject2.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_end_time = localJSONObject2.optLong("end_time");
      }
      if (paramCardInfo.kno.wGE != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.kno.wGE.wPY;
      }
    }
    if (paramCardInfo.knp != null)
    {
      paramCardInfo.a(paramCardInfo.knp);
      paramCardInfo.field_status = paramCardInfo.knp.status;
    }
    if (paramCardInfo.knq != null) {
      paramCardInfo.a(paramCardInfo.knq);
    }
    paramCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(88856);
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, String paramString)
  {
    AppMethodBeat.i(88852);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
      AppMethodBeat.o(88852);
      return;
    }
    try
    {
      a(paramShareCardInfo, new JSONObject(paramString).optJSONObject("share_card"));
      AppMethodBeat.o(88852);
      return;
    }
    catch (JSONException paramShareCardInfo)
    {
      ab.printErrStackTrace("MicroMsg.CardInfoParser", paramShareCardInfo, "", new Object[0]);
      ab.e("MicroMsg.CardInfoParser", paramShareCardInfo.getMessage());
      AppMethodBeat.o(88852);
    }
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88853);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
      AppMethodBeat.o(88853);
      return;
    }
    paramShareCardInfo.field_card_id = Iv(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = Iv(paramJSONObject.optString("card_tp_id"));
    paramShareCardInfo.field_app_id = paramJSONObject.optString("app_id");
    paramShareCardInfo.field_consumer = paramJSONObject.optString("consumer");
    paramShareCardInfo.field_share_time = paramJSONObject.optInt("share_time");
    paramShareCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramShareCardInfo.field_status = paramJSONObject.optInt("state_flag");
    paramShareCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramShareCardInfo.field_from_username = paramJSONObject.optString("from_user_name");
    paramShareCardInfo.field_begin_time = paramJSONObject.optLong("begin_time");
    paramShareCardInfo.field_end_time = paramJSONObject.optInt("end_time");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramShareCardInfo.knp = M(localJSONObject1);
    paramShareCardInfo.kno = N(localJSONObject2);
    paramShareCardInfo.knq = O(paramJSONObject);
    if (paramShareCardInfo.knp != null) {
      paramShareCardInfo.a(paramShareCardInfo.knp);
    }
    if (paramShareCardInfo.kno != null)
    {
      paramShareCardInfo.a(paramShareCardInfo.kno);
      paramShareCardInfo.field_end_time = localJSONObject2.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject2.optInt("begin_time");
    }
    if (paramShareCardInfo.knq != null) {
      paramShareCardInfo.a(paramShareCardInfo.knq);
    }
    paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(88853);
  }
  
  private static LinkedList<pn> q(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(88859);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(88859);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      pn localpn = new pn();
      localpn.title = localJSONObject.optString("title");
      localpn.kmn = localJSONObject.optString("sub_title");
      localpn.kqb = localJSONObject.optString("tips");
      localpn.url = localJSONObject.optString("url");
      localpn.wGZ = localJSONObject.optLong("show_flag");
      localpn.wHa = localJSONObject.optString("primary_color");
      localpn.wHb = localJSONObject.optString("secondary_color");
      localpn.kWy = localJSONObject.optString("icon_url");
      localpn.wFL = localJSONObject.optString("app_brand_user_name");
      localpn.wFM = localJSONObject.optString("app_brand_pass");
      localLinkedList.add(localpn);
      i += 1;
    }
    AppMethodBeat.o(88859);
    return localLinkedList;
  }
  
  private static LinkedList<uo> r(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(88861);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(88861);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      uo localuo = P(paramJSONArray.getJSONObject(i));
      if (localuo != null) {
        localLinkedList.add(localuo);
      }
      i += 1;
    }
    AppMethodBeat.o(88861);
    return localLinkedList;
  }
  
  private static LinkedList<ax> s(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(88863);
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray.length()) {
          try
          {
            ax localax = new ax();
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            localax.text = localJSONObject.optString("text");
            localax.url = localJSONObject.optString("url");
            localLinkedList.add(localax);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            }
          }
        }
      }
    }
    AppMethodBeat.o(88863);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.f
 * JD-Core Version:    0.7.0.1
 */