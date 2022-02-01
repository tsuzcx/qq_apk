package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.dax;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.rw;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static ArrayList<ShareCardInfo> Re(String paramString)
  {
    AppMethodBeat.i(113779);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
      AppMethodBeat.o(113779);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ad.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
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
      ad.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113779);
    }
    return null;
  }
  
  public static ArrayList<CardInfo> Rf(String paramString)
  {
    AppMethodBeat.i(113782);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
      AppMethodBeat.o(113782);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_array");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ad.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
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
      ad.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113782);
    }
    return null;
  }
  
  private static String Rg(String paramString)
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
  
  public static void a(CardInfo paramCardInfo, String paramString)
  {
    AppMethodBeat.i(113783);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
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
      ad.printErrStackTrace("MicroMsg.CardInfoParser", paramCardInfo, "", new Object[0]);
      AppMethodBeat.o(113783);
    }
  }
  
  private static void a(CardInfo paramCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113784);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
      AppMethodBeat.o(113784);
      return;
    }
    paramCardInfo.field_card_id = Rg(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = Rg(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.nru = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.nsD = ac(localJSONObject1);
    paramCardInfo.nsC = ad(localJSONObject2);
    paramCardInfo.nsE = ae(paramJSONObject);
    if (paramCardInfo.nsC != null)
    {
      paramCardInfo.a(paramCardInfo.nsC);
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.nsC.CRL);
      paramCardInfo.field_card_type = paramCardInfo.nsC.lpz;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.nsC.nrr;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_begin_time = localJSONObject2.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_end_time = localJSONObject2.optLong("end_time");
      }
      if (paramCardInfo.nsC.CSj != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.nsC.CSj.DcV;
      }
    }
    if (paramCardInfo.nsD != null)
    {
      paramCardInfo.a(paramCardInfo.nsD);
      paramCardInfo.field_status = paramCardInfo.nsD.status;
    }
    if (paramCardInfo.nsE != null) {
      paramCardInfo.a(paramCardInfo.nsE);
    }
    paramCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113784);
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, String paramString)
  {
    AppMethodBeat.i(113780);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
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
      ad.printErrStackTrace("MicroMsg.CardInfoParser", paramShareCardInfo, "", new Object[0]);
      ad.e("MicroMsg.CardInfoParser", paramShareCardInfo.getMessage());
      AppMethodBeat.o(113780);
    }
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113781);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
      AppMethodBeat.o(113781);
      return;
    }
    paramShareCardInfo.field_card_id = Rg(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = Rg(paramJSONObject.optString("card_tp_id"));
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
    paramShareCardInfo.nsD = ac(localJSONObject1);
    paramShareCardInfo.nsC = ad(localJSONObject2);
    paramShareCardInfo.nsE = ae(paramJSONObject);
    if (paramShareCardInfo.nsD != null) {
      paramShareCardInfo.a(paramShareCardInfo.nsD);
    }
    if (paramShareCardInfo.nsC != null)
    {
      paramShareCardInfo.a(paramShareCardInfo.nsC);
      paramShareCardInfo.field_end_time = localJSONObject2.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject2.optInt("begin_time");
    }
    if (paramShareCardInfo.nsE != null) {
      paramShareCardInfo.a(paramShareCardInfo.nsE);
    }
    paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113781);
  }
  
  private static qo ac(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113786);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      AppMethodBeat.o(113786);
      return null;
    }
    qo localqo = new qo();
    for (;;)
    {
      try
      {
        localqo.status = paramJSONObject.optInt("status");
        localqo.CPn = paramJSONObject.optInt("init_balance");
        localqo.CPo = paramJSONObject.optInt("init_bonus");
        localObject1 = paramJSONObject.optJSONArray("cell_list0");
        if (localObject1 != null) {
          localqo.CPp = r((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list1");
        if (localObject1 != null) {
          localqo.CPq = r((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list2");
        if (localObject1 != null) {
          localqo.CPr = r((JSONArray)localObject1);
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
          localqo.CPs = ((LinkedList)localObject1);
        }
        localqo.CPt = paramJSONObject.optInt("avail_num");
        localqo.CPu = paramJSONObject.optInt("code_type");
        localqo.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          localqo.CPv = s((JSONArray)localObject1);
        }
        localqo.CPw = paramJSONObject.optLong("stock_num");
        localqo.CPx = paramJSONObject.optInt("limit_num");
        localqo.CPy = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          localqo.CPz = af((JSONObject)localObject1);
        }
        localqo.CPA = t(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          localqo.CPB = af((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          localqo.CPC = af((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          localqo.CPD = af((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          localqo.CPE = aj((JSONObject)localObject1);
        }
        localqo.CPF = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          localqo.CPG = af((JSONObject)localObject1);
        }
        localqo.CPH = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          localqo.CPI = af((JSONObject)localObject1);
        }
        localqo.CPJ = paramJSONObject.optBoolean("is_commom_card");
        localqo.CPK = paramJSONObject.optBoolean("is_location_authorized");
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject1;
        JSONArray localJSONArray;
        int i;
        ad.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(113786);
      return localqo;
      localObject1 = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        ((LinkedList)localObject1).add((String)localJSONArray.get(i));
        i += 1;
      }
    }
  }
  
  public static ro ad(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113788);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      AppMethodBeat.o(113788);
      return null;
    }
    ro localro = new ro();
    Object localObject1;
    Object localObject3;
    label525:
    label555:
    label720:
    int i;
    label803:
    label1017:
    dax localdax;
    for (;;)
    {
      try
      {
        localro.nrr = paramJSONObject.optString("card_tp_id");
        localro.gGR = paramJSONObject.optString("logo_url");
        localro.dlB = paramJSONObject.optString("appid");
        localro.CRC = paramJSONObject.optString("app_username");
        localro.CRD = paramJSONObject.optInt("card_category");
        localro.lpz = paramJSONObject.optInt("card_type");
        localro.nsK = paramJSONObject.optString("brand_name");
        localro.title = paramJSONObject.optString("title");
        localro.nrs = paramJSONObject.optString("sub_title");
        localro.gHT = paramJSONObject.optString("color");
        localro.iau = paramJSONObject.optString("notice");
        localro.CRE = paramJSONObject.optString("service_phone");
        localro.CRH = paramJSONObject.optString("image_text_url");
        localro.CRI = paramJSONObject.optString("source_icon");
        localro.source = paramJSONObject.optString("source");
        localObject1 = paramJSONObject.optJSONArray("primary_fields");
        if (localObject1 != null) {
          localro.CRF = s((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("introduce_fields");
        if (localObject1 != null) {
          localro.CRG = s((JSONArray)localObject1);
        }
        localro.CRJ = paramJSONObject.optInt("shop_count");
        localro.jEK = paramJSONObject.optString("limit_wording");
        localro.nsJ = paramJSONObject.optString("card_type_name");
        localro.CRK = paramJSONObject.optString("h5_show_url");
        localro.CRL = paramJSONObject.optInt("block_mask");
        localro.CRM = paramJSONObject.optString("middle_icon");
        localro.CRN = paramJSONObject.optString("accept_wording");
        localro.CRO = paramJSONObject.optLong("control_flag");
        localro.CRP = paramJSONObject.optString("advertise_wording");
        localro.CRQ = paramJSONObject.optString("advertise_url");
        localro.CRR = paramJSONObject.optString("public_service_name");
        localObject3 = paramJSONObject.optJSONObject("announcement");
        if (localObject3 != null) {
          continue;
        }
        ad.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
        localro.CRS = ((rd)localObject1);
        localro.CRT = paramJSONObject.optString("public_service_tip");
        localro.CRU = paramJSONObject.optString("primary_sub_title");
        localro.CRV = paramJSONObject.optInt("gen_type");
        localro.CRW = ah(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          continue;
        }
        ad.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localro.CRX = ((dij)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1191;
        }
        ad.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        localro.CRY = ((amg)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1264;
        }
        ad.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        localro.CRZ = ((ba)localObject1);
        localro.CSa = paramJSONObject.optInt("need_direct_jump", 0);
        localro.CSb = paramJSONObject.optInt("is_acceptable", 0);
        localro.CSc = paramJSONObject.optString("unacceptable_wording");
        localro.CSd = paramJSONObject.optInt("has_hongbao", 0);
        localro.CSe = paramJSONObject.optString("accept_ui_title");
        localro.CSf = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localro.CSg = af((JSONObject)localObject1);
        }
        localro.CSh = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localro.CSi = af((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1299;
          }
          ad.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          localro.CSj = ((aco)localObject1);
        }
        localro.CSk = paramJSONObject.optBoolean("is_card_code_exposed");
        localro.CSl = paramJSONObject.optInt("qrcode_correct_level");
        localro.CSm = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localro.CSn = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1397;
          }
          ad.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          localro.CSo = ((oc)localObject1);
        }
        localro.CSp = paramJSONObject.optString("biz_nickname");
        localro.CSq = paramJSONObject.optString("gift_title");
        ad.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localro.CSq });
      }
      catch (JSONException paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
        localObject1 = new dij();
        ((dij)localObject1).title = ((JSONObject)localObject3).optString("title");
        localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
        if (localJSONArray == null) {
          break;
        }
      }
      AppMethodBeat.o(113788);
      return localro;
      localObject1 = new rd();
      ((rd)localObject1).type = ((JSONObject)localObject3).optInt("type");
      ((rd)localObject1).text = ((JSONObject)localObject3).optString("text");
      ((rd)localObject1).url = ((JSONObject)localObject3).optString("url");
      ((rd)localObject1).wmA = ((JSONObject)localObject3).optInt("endtime");
      ((rd)localObject1).CJd = ((JSONObject)localObject3).optInt("create_time");
      ((rd)localObject1).CQW = ((JSONObject)localObject3).optString("thumb_url");
      continue;
      if (localJSONArray.length() > 0)
      {
        ((dij)localObject1).EyA = new LinkedList();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label1063;
        }
        localdax = ai(localJSONArray.optJSONObject(i));
        if (localdax == null) {
          break label1452;
        }
        ((dij)localObject1).EyA.add(localdax);
        break label1452;
      }
    }
    ad.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    label1063:
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((dij)localObject1).EyB = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localdax = ai(localJSONArray.optJSONObject(i));
        if (localdax != null)
        {
          ((dij)localObject1).EyB.add(localdax);
          break label1459;
          ad.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((dij)localObject1).EyC = s((JSONArray)localObject3);
          break;
        }
        ad.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1191:
        localObject1 = new amg();
        ((amg)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((amg)localObject1).Dnr = ((JSONObject)localObject3).optInt("follow");
        ad.i("MicroMsg.CardInfoParser", "follow:" + ((amg)localObject1).Dnr + "　text:" + ((amg)localObject1).text);
        break label525;
        label1264:
        localObject1 = new ba();
        ((ba)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((ba)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label555;
        label1299:
        localObject1 = new aco();
        ((aco)localObject1).DcV = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((aco)localObject1).DcW = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((aco)localObject1).DcX = ((JSONObject)localObject3).optString("refresh_wording");
        ad.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((aco)localObject1).DcV + "　can_refresh:" + ((aco)localObject1).DcW + "　refresh_wording:" + ((aco)localObject1).DcX);
        break label720;
        label1397:
        localObject1 = new oc();
        ((oc)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((oc)localObject1).CLF = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        ad.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((oc)localObject1).name });
        break label803;
        label1452:
        i += 1;
        break label1017;
      }
      label1459:
      i += 1;
    }
  }
  
  private static csx ae(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113790);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      AppMethodBeat.o(113790);
      return null;
    }
    csx localcsx = new csx();
    localcsx.Ekz = paramJSONObject.optString("gift_msg_title");
    AppMethodBeat.o(113790);
    return localcsx;
  }
  
  private static xo af(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113792);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      AppMethodBeat.o(113792);
      return null;
    }
    xo localxo = new xo();
    localxo.title = paramJSONObject.optString("title");
    localxo.nrt = paramJSONObject.optString("aux_title");
    localxo.nrs = paramJSONObject.optString("sub_title");
    localxo.url = paramJSONObject.optString("url");
    localxo.CSH = paramJSONObject.optLong("show_flag");
    localxo.CSI = paramJSONObject.optString("primary_color");
    localxo.CSJ = paramJSONObject.optString("secondary_color");
    localxo.odo = paramJSONObject.optString("icon_url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null) {
      localxo.CZh = ag(localJSONObject);
    }
    localxo.CRq = paramJSONObject.optString("app_brand_user_name");
    localxo.CRr = paramJSONObject.optString("app_brand_pass");
    AppMethodBeat.o(113792);
    return localxo;
  }
  
  private static beh ag(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113793);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
      AppMethodBeat.o(113793);
      return null;
    }
    ad.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { paramJSONObject });
    beh localbeh = new beh();
    localbeh.CtZ = p.dG(paramJSONObject.optString("biz_uin"));
    localbeh.Cua = paramJSONObject.optString("order_id");
    AppMethodBeat.o(113793);
    return localbeh;
  }
  
  private static abm ah(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113794);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      AppMethodBeat.o(113794);
      return null;
    }
    abm localabm = new abm();
    localabm.title = paramJSONObject.optString("title");
    localabm.url = paramJSONObject.optString("url");
    localabm.desc = paramJSONObject.optString("abstract");
    localabm.detail = paramJSONObject.optString("detail");
    localabm.DbP = paramJSONObject.optString("ad_title");
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
            ad.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            ad.e("MicroMsg.CardInfoParser", "getMessage:" + localJSONException.getMessage());
          }
        }
        localLinkedList.add(paramJSONObject);
        i += 1;
      }
      label198:
      localabm.DbO = localLinkedList;
    }
    for (;;)
    {
      AppMethodBeat.o(113794);
      return localabm;
      ad.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static dax ai(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113795);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      AppMethodBeat.o(113795);
      return null;
    }
    dax localdax = new dax();
    localdax.tag = paramJSONObject.optString("tag");
    localdax.gHT = paramJSONObject.optString("color");
    AppMethodBeat.o(113795);
    return localdax;
  }
  
  private static abn aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113796);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      AppMethodBeat.o(113796);
      return null;
    }
    abn localabn = new abn();
    localabn.title = paramJSONObject.optString("title");
    localabn.nrs = paramJSONObject.optString("sub_title");
    localabn.DbQ = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
    for (;;)
    {
      try
      {
        localabn.DbR = s(paramJSONObject);
        AppMethodBeat.o(113796);
        return localabn;
      }
      catch (JSONException paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        ad.e("MicroMsg.CardInfoParser", paramJSONObject.getMessage());
        continue;
      }
      ad.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
    }
  }
  
  private static LinkedList<rw> r(JSONArray paramJSONArray)
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
      rw localrw = new rw();
      localrw.title = localJSONObject.optString("title");
      localrw.nrs = localJSONObject.optString("sub_title");
      localrw.nvv = localJSONObject.optString("tips");
      localrw.url = localJSONObject.optString("url");
      localrw.CSH = localJSONObject.optLong("show_flag");
      localrw.CSI = localJSONObject.optString("primary_color");
      localrw.CSJ = localJSONObject.optString("secondary_color");
      localrw.odo = localJSONObject.optString("icon_url");
      localrw.CRq = localJSONObject.optString("app_brand_user_name");
      localrw.CRr = localJSONObject.optString("app_brand_pass");
      localLinkedList.add(localrw);
      i += 1;
    }
    AppMethodBeat.o(113787);
    return localLinkedList;
  }
  
  private static LinkedList<xo> s(JSONArray paramJSONArray)
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
      xo localxo = af(paramJSONArray.getJSONObject(i));
      if (localxo != null) {
        localLinkedList.add(localxo);
      }
      i += 1;
    }
    AppMethodBeat.o(113789);
    return localLinkedList;
  }
  
  private static LinkedList<ba> t(JSONArray paramJSONArray)
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
            ba localba = new ba();
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            localba.text = localJSONObject.optString("text");
            localba.url = localJSONObject.optString("url");
            localLinkedList.add(localba);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            }
          }
        }
      }
    }
    AppMethodBeat.o(113791);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.f
 * JD-Core Version:    0.7.0.1
 */