package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.eqk;
import com.tencent.mm.protocal.protobuf.eyt;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static void a(CardInfo paramCardInfo, String paramString)
  {
    AppMethodBeat.i(113783);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
      AppMethodBeat.o(113783);
      return;
    }
    try
    {
      a(paramCardInfo, new JSONObject(paramString));
      AppMethodBeat.o(113783);
      return;
    }
    catch (JSONException paramCardInfo)
    {
      Log.printErrStackTrace("MicroMsg.CardInfoParser", paramCardInfo, "", new Object[0]);
      AppMethodBeat.o(113783);
    }
  }
  
  private static void a(CardInfo paramCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113784);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
      AppMethodBeat.o(113784);
      return;
    }
    paramCardInfo.field_card_id = arL(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = arL(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.toa = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.tpj = aB(localJSONObject1);
    paramCardInfo.tpi = aC(localJSONObject2);
    paramCardInfo.tpk = aD(paramJSONObject);
    if (paramCardInfo.tpi != null)
    {
      paramCardInfo.a(paramCardInfo.tpi);
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.tpi.SfV);
      paramCardInfo.field_card_type = paramCardInfo.tpi.qJt;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.tpi.tnX;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_begin_time = localJSONObject2.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_end_time = localJSONObject2.optLong("end_time");
      }
      if (paramCardInfo.tpi.Sgt != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.tpi.Sgt.Sti;
      }
    }
    if (paramCardInfo.tpj != null)
    {
      paramCardInfo.a(paramCardInfo.tpj);
      paramCardInfo.field_status = paramCardInfo.tpj.status;
    }
    if (paramCardInfo.tpk != null) {
      paramCardInfo.a(paramCardInfo.tpk);
    }
    paramCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113784);
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, String paramString)
  {
    AppMethodBeat.i(113780);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
      AppMethodBeat.o(113780);
      return;
    }
    try
    {
      a(paramShareCardInfo, new JSONObject(paramString).optJSONObject("share_card"));
      AppMethodBeat.o(113780);
      return;
    }
    catch (JSONException paramShareCardInfo)
    {
      Log.printErrStackTrace("MicroMsg.CardInfoParser", paramShareCardInfo, "", new Object[0]);
      Log.e("MicroMsg.CardInfoParser", paramShareCardInfo.getMessage());
      AppMethodBeat.o(113780);
    }
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113781);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
      AppMethodBeat.o(113781);
      return;
    }
    paramShareCardInfo.field_card_id = arL(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = arL(paramJSONObject.optString("card_tp_id"));
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
    paramShareCardInfo.tpj = aB(localJSONObject1);
    paramShareCardInfo.tpi = aC(localJSONObject2);
    paramShareCardInfo.tpk = aD(paramJSONObject);
    if (paramShareCardInfo.tpj != null) {
      paramShareCardInfo.a(paramShareCardInfo.tpj);
    }
    if (paramShareCardInfo.tpi != null)
    {
      paramShareCardInfo.a(paramShareCardInfo.tpi);
      paramShareCardInfo.field_end_time = localJSONObject2.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject2.optInt("begin_time");
    }
    if (paramShareCardInfo.tpk != null) {
      paramShareCardInfo.a(paramShareCardInfo.tpk);
    }
    paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113781);
  }
  
  private static ua aB(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113786);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      AppMethodBeat.o(113786);
      return null;
    }
    ua localua = new ua();
    for (;;)
    {
      try
      {
        localua.status = paramJSONObject.optInt("status");
        localua.Sdx = paramJSONObject.optInt("init_balance");
        localua.Sdy = paramJSONObject.optInt("init_bonus");
        localObject1 = paramJSONObject.optJSONArray("cell_list0");
        if (localObject1 != null) {
          localua.Sdz = t((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list1");
        if (localObject1 != null) {
          localua.SdA = t((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list2");
        if (localObject1 != null) {
          localua.SdB = t((JSONArray)localObject1);
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
          localua.SdC = ((LinkedList)localObject1);
        }
        localua.SdD = paramJSONObject.optInt("avail_num");
        localua.SdE = paramJSONObject.optInt("code_type");
        localua.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          localua.SdF = u((JSONArray)localObject1);
        }
        localua.SdG = paramJSONObject.optLong("stock_num");
        localua.SdH = paramJSONObject.optInt("limit_num");
        localua.SdI = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          localua.SdJ = aE((JSONObject)localObject1);
        }
        localua.SdK = v(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          localua.SdL = aE((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          localua.SdM = aE((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          localua.SdN = aE((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          localua.SdO = aI((JSONObject)localObject1);
        }
        localua.SdP = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          localua.SdQ = aE((JSONObject)localObject1);
        }
        localua.SdR = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          localua.SdS = aE((JSONObject)localObject1);
        }
        localua.SdT = paramJSONObject.optBoolean("is_commom_card");
        localua.SdU = paramJSONObject.optBoolean("is_location_authorized");
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject1;
        JSONArray localJSONArray;
        int i;
        Log.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(113786);
      return localua;
      localObject1 = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        ((LinkedList)localObject1).add((String)localJSONArray.get(i));
        i += 1;
      }
    }
  }
  
  public static vb aC(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113788);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      AppMethodBeat.o(113788);
      return null;
    }
    vb localvb = new vb();
    Object localObject1;
    Object localObject3;
    label525:
    label555:
    label720:
    int i;
    label803:
    label1017:
    eqk localeqk;
    for (;;)
    {
      try
      {
        localvb.tnX = paramJSONObject.optString("card_tp_id");
        localvb.llI = paramJSONObject.optString("logo_url");
        localvb.appid = paramJSONObject.optString("appid");
        localvb.Sba = paramJSONObject.optString("app_username");
        localvb.SfN = paramJSONObject.optInt("card_category");
        localvb.qJt = paramJSONObject.optInt("card_type");
        localvb.jEi = paramJSONObject.optString("brand_name");
        localvb.title = paramJSONObject.optString("title");
        localvb.tnY = paramJSONObject.optString("sub_title");
        localvb.lmL = paramJSONObject.optString("color");
        localvb.mKL = paramJSONObject.optString("notice");
        localvb.SfO = paramJSONObject.optString("service_phone");
        localvb.SfR = paramJSONObject.optString("image_text_url");
        localvb.SfS = paramJSONObject.optString("source_icon");
        localvb.source = paramJSONObject.optString("source");
        localObject1 = paramJSONObject.optJSONArray("primary_fields");
        if (localObject1 != null) {
          localvb.SfP = u((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("introduce_fields");
        if (localObject1 != null) {
          localvb.SfQ = u((JSONArray)localObject1);
        }
        localvb.SfT = paramJSONObject.optInt("shop_count");
        localvb.oDU = paramJSONObject.optString("limit_wording");
        localvb.tpo = paramJSONObject.optString("card_type_name");
        localvb.SfU = paramJSONObject.optString("h5_show_url");
        localvb.SfV = paramJSONObject.optInt("block_mask");
        localvb.SfW = paramJSONObject.optString("middle_icon");
        localvb.SfX = paramJSONObject.optString("accept_wording");
        localvb.SfY = paramJSONObject.optLong("control_flag");
        localvb.SfZ = paramJSONObject.optString("advertise_wording");
        localvb.Sga = paramJSONObject.optString("advertise_url");
        localvb.Sgb = paramJSONObject.optString("public_service_name");
        localObject3 = paramJSONObject.optJSONObject("announcement");
        if (localObject3 != null) {
          continue;
        }
        Log.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
        localvb.Sgc = ((uq)localObject1);
        localvb.Sgd = paramJSONObject.optString("public_service_tip");
        localvb.Sge = paramJSONObject.optString("primary_sub_title");
        localvb.Sgf = paramJSONObject.optInt("gen_type");
        localvb.Sgg = aG(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          continue;
        }
        Log.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localvb.Sgh = ((eyt)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1191;
        }
        Log.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        localvb.Sgi = ((blx)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1264;
        }
        Log.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        localvb.Sgj = ((be)localObject1);
        localvb.Sgk = paramJSONObject.optInt("need_direct_jump", 0);
        localvb.Sgl = paramJSONObject.optInt("is_acceptable", 0);
        localvb.Sgm = paramJSONObject.optString("unacceptable_wording");
        localvb.Sgn = paramJSONObject.optInt("has_hongbao", 0);
        localvb.Sgo = paramJSONObject.optString("accept_ui_title");
        localvb.Sgp = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localvb.Sgq = aE((JSONObject)localObject1);
        }
        localvb.Sgr = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localvb.Sgs = aE((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1299;
          }
          Log.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          localvb.Sgt = ((aip)localObject1);
        }
        localvb.Sgu = paramJSONObject.optBoolean("is_card_code_exposed");
        localvb.Sgv = paramJSONObject.optInt("qrcode_correct_level");
        localvb.Sgw = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localvb.Sgx = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1397;
          }
          Log.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          localvb.Sgy = ((qk)localObject1);
        }
        localvb.RVI = paramJSONObject.optString("biz_nickname");
        localvb.Sgz = paramJSONObject.optString("gift_title");
        Log.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localvb.Sgz });
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
        localObject1 = new eyt();
        ((eyt)localObject1).title = ((JSONObject)localObject3).optString("title");
        localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
        if (localJSONArray == null) {
          break;
        }
      }
      AppMethodBeat.o(113788);
      return localvb;
      localObject1 = new uq();
      ((uq)localObject1).type = ((JSONObject)localObject3).optInt("type");
      ((uq)localObject1).text = ((JSONObject)localObject3).optString("text");
      ((uq)localObject1).url = ((JSONObject)localObject3).optString("url");
      ((uq)localObject1).Jnj = ((JSONObject)localObject3).optInt("endtime");
      ((uq)localObject1).ChC = ((JSONObject)localObject3).optInt("create_time");
      ((uq)localObject1).jEd = ((JSONObject)localObject3).optString("thumb_url");
      continue;
      if (localJSONArray.length() > 0)
      {
        ((eyt)localObject1).UyW = new LinkedList();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label1063;
        }
        localeqk = aH(localJSONArray.optJSONObject(i));
        if (localeqk == null) {
          break label1452;
        }
        ((eyt)localObject1).UyW.add(localeqk);
        break label1452;
      }
    }
    Log.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    label1063:
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((eyt)localObject1).UyX = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localeqk = aH(localJSONArray.optJSONObject(i));
        if (localeqk != null)
        {
          ((eyt)localObject1).UyX.add(localeqk);
          break label1459;
          Log.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((eyt)localObject1).UyY = u((JSONArray)localObject3);
          break;
        }
        Log.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1191:
        localObject1 = new blx();
        ((blx)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((blx)localObject1).SWY = ((JSONObject)localObject3).optInt("follow");
        Log.i("MicroMsg.CardInfoParser", "follow:" + ((blx)localObject1).SWY + "　text:" + ((blx)localObject1).text);
        break label525;
        label1264:
        localObject1 = new be();
        ((be)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((be)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label555;
        label1299:
        localObject1 = new aip();
        ((aip)localObject1).Sti = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((aip)localObject1).Stj = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((aip)localObject1).Stk = ((JSONObject)localObject3).optString("refresh_wording");
        Log.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((aip)localObject1).Sti + "　can_refresh:" + ((aip)localObject1).Stj + "　refresh_wording:" + ((aip)localObject1).Stk);
        break label720;
        label1397:
        localObject1 = new qk();
        ((qk)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((qk)localObject1).RYG = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        Log.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((qk)localObject1).name });
        break label803;
        label1452:
        i += 1;
        break label1017;
      }
      label1459:
      i += 1;
    }
  }
  
  private static ehs aD(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113790);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      AppMethodBeat.o(113790);
      return null;
    }
    ehs localehs = new ehs();
    localehs.UjL = paramJSONObject.optString("gift_msg_title");
    AppMethodBeat.o(113790);
    return localehs;
  }
  
  private static acg aE(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113792);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      AppMethodBeat.o(113792);
      return null;
    }
    acg localacg = new acg();
    localacg.title = paramJSONObject.optString("title");
    localacg.tnZ = paramJSONObject.optString("aux_title");
    localacg.tnY = paramJSONObject.optString("sub_title");
    localacg.url = paramJSONObject.optString("url");
    localacg.SgR = paramJSONObject.optLong("show_flag");
    localacg.SgS = paramJSONObject.optString("primary_color");
    localacg.SgT = paramJSONObject.optString("secondary_color");
    localacg.ufC = paramJSONObject.optString("icon_url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null) {
      localacg.SnP = aF(localJSONObject);
    }
    localacg.SfB = paramJSONObject.optString("app_brand_user_name");
    localacg.SfC = paramJSONObject.optString("app_brand_pass");
    AppMethodBeat.o(113792);
    return localacg;
  }
  
  private static chl aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113793);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
      AppMethodBeat.o(113793);
      return null;
    }
    Log.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { paramJSONObject });
    chl localchl = new chl();
    localchl.REC = p.fT(paramJSONObject.optString("biz_uin"));
    localchl.REE = paramJSONObject.optString("order_id");
    AppMethodBeat.o(113793);
    return localchl;
  }
  
  private static ahk aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113794);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      AppMethodBeat.o(113794);
      return null;
    }
    ahk localahk = new ahk();
    localahk.title = paramJSONObject.optString("title");
    localahk.url = paramJSONObject.optString("url");
    localahk.desc = paramJSONObject.optString("abstract");
    localahk.detail = paramJSONObject.optString("detail");
    localahk.Ssa = paramJSONObject.optString("ad_title");
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
            Log.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            Log.e("MicroMsg.CardInfoParser", "getMessage:" + localJSONException.getMessage());
          }
        }
        localLinkedList.add(paramJSONObject);
        i += 1;
      }
      label198:
      localahk.SrZ = localLinkedList;
    }
    for (;;)
    {
      AppMethodBeat.o(113794);
      return localahk;
      Log.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static eqk aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113795);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      AppMethodBeat.o(113795);
      return null;
    }
    eqk localeqk = new eqk();
    localeqk.tag = paramJSONObject.optString("tag");
    localeqk.lmL = paramJSONObject.optString("color");
    AppMethodBeat.o(113795);
    return localeqk;
  }
  
  private static ahl aI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113796);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      AppMethodBeat.o(113796);
      return null;
    }
    ahl localahl = new ahl();
    localahl.title = paramJSONObject.optString("title");
    localahl.tnY = paramJSONObject.optString("sub_title");
    localahl.Ssb = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
    for (;;)
    {
      try
      {
        localahl.Ssc = u(paramJSONObject);
        AppMethodBeat.o(113796);
        return localahl;
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        Log.e("MicroMsg.CardInfoParser", paramJSONObject.getMessage());
        continue;
      }
      Log.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
    }
  }
  
  public static ArrayList<ShareCardInfo> arJ(String paramString)
  {
    AppMethodBeat.i(113779);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
      AppMethodBeat.o(113779);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        Log.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
        AppMethodBeat.o(113779);
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
      AppMethodBeat.o(113779);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113779);
    }
    return null;
  }
  
  public static ArrayList<CardInfo> arK(String paramString)
  {
    AppMethodBeat.i(113782);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
      AppMethodBeat.o(113782);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_array");
      if ((paramString == null) || (paramString.length() == 0))
      {
        Log.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
        AppMethodBeat.o(113782);
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
      AppMethodBeat.o(113782);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113782);
    }
    return null;
  }
  
  private static String arL(String paramString)
  {
    AppMethodBeat.i(113785);
    if ((TextUtils.isEmpty(paramString)) || ("null".equals(paramString)))
    {
      AppMethodBeat.o(113785);
      return "";
    }
    AppMethodBeat.o(113785);
    return paramString;
  }
  
  private static LinkedList<vl> t(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(113787);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(113787);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      vl localvl = new vl();
      localvl.title = localJSONObject.optString("title");
      localvl.tnY = localJSONObject.optString("sub_title");
      localvl.tsf = localJSONObject.optString("tips");
      localvl.url = localJSONObject.optString("url");
      localvl.SgR = localJSONObject.optLong("show_flag");
      localvl.SgS = localJSONObject.optString("primary_color");
      localvl.SgT = localJSONObject.optString("secondary_color");
      localvl.ufC = localJSONObject.optString("icon_url");
      localvl.SfB = localJSONObject.optString("app_brand_user_name");
      localvl.SfC = localJSONObject.optString("app_brand_pass");
      localLinkedList.add(localvl);
      i += 1;
    }
    AppMethodBeat.o(113787);
    return localLinkedList;
  }
  
  private static LinkedList<acg> u(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(113789);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(113789);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      acg localacg = aE(paramJSONArray.getJSONObject(i));
      if (localacg != null) {
        localLinkedList.add(localacg);
      }
      i += 1;
    }
    AppMethodBeat.o(113789);
    return localLinkedList;
  }
  
  private static LinkedList<be> v(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(113791);
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray.length()) {
          try
          {
            be localbe = new be();
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            localbe.text = localJSONObject.optString("text");
            localbe.url = localJSONObject.optString("url");
            localLinkedList.add(localbe);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            }
          }
        }
      }
    }
    AppMethodBeat.o(113791);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.f
 * JD-Core Version:    0.7.0.1
 */