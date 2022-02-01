package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static ArrayList<ShareCardInfo> Vq(String paramString)
  {
    AppMethodBeat.i(113779);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
      AppMethodBeat.o(113779);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ac.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
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
      ac.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113779);
    }
    return null;
  }
  
  public static ArrayList<CardInfo> Vr(String paramString)
  {
    AppMethodBeat.i(113782);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
      AppMethodBeat.o(113782);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_array");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ac.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
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
      ac.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113782);
    }
    return null;
  }
  
  private static String Vs(String paramString)
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
      ac.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
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
      ac.printErrStackTrace("MicroMsg.CardInfoParser", paramCardInfo, "", new Object[0]);
      AppMethodBeat.o(113783);
    }
  }
  
  private static void a(CardInfo paramCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113784);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
      AppMethodBeat.o(113784);
      return;
    }
    paramCardInfo.field_card_id = Vs(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = Vs(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.nUu = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.nVD = ac(localJSONObject1);
    paramCardInfo.nVC = ad(localJSONObject2);
    paramCardInfo.nVE = ae(paramJSONObject);
    if (paramCardInfo.nVC != null)
    {
      paramCardInfo.a(paramCardInfo.nVC);
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.nVC.Ekw);
      paramCardInfo.field_card_type = paramCardInfo.nVC.lRv;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.nVC.nUr;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_begin_time = localJSONObject2.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_end_time = localJSONObject2.optLong("end_time");
      }
      if (paramCardInfo.nVC.EkU != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.nVC.EkU.Ewc;
      }
    }
    if (paramCardInfo.nVD != null)
    {
      paramCardInfo.a(paramCardInfo.nVD);
      paramCardInfo.field_status = paramCardInfo.nVD.status;
    }
    if (paramCardInfo.nVE != null) {
      paramCardInfo.a(paramCardInfo.nVE);
    }
    paramCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113784);
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, String paramString)
  {
    AppMethodBeat.i(113780);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
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
      ac.printErrStackTrace("MicroMsg.CardInfoParser", paramShareCardInfo, "", new Object[0]);
      ac.e("MicroMsg.CardInfoParser", paramShareCardInfo.getMessage());
      AppMethodBeat.o(113780);
    }
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113781);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
      AppMethodBeat.o(113781);
      return;
    }
    paramShareCardInfo.field_card_id = Vs(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = Vs(paramJSONObject.optString("card_tp_id"));
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
    paramShareCardInfo.nVD = ac(localJSONObject1);
    paramShareCardInfo.nVC = ad(localJSONObject2);
    paramShareCardInfo.nVE = ae(paramJSONObject);
    if (paramShareCardInfo.nVD != null) {
      paramShareCardInfo.a(paramShareCardInfo.nVD);
    }
    if (paramShareCardInfo.nVC != null)
    {
      paramShareCardInfo.a(paramShareCardInfo.nVC);
      paramShareCardInfo.field_end_time = localJSONObject2.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject2.optInt("begin_time");
    }
    if (paramShareCardInfo.nVE != null) {
      paramShareCardInfo.a(paramShareCardInfo.nVE);
    }
    paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113781);
  }
  
  private static qy ac(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113786);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      AppMethodBeat.o(113786);
      return null;
    }
    qy localqy = new qy();
    for (;;)
    {
      try
      {
        localqy.status = paramJSONObject.optInt("status");
        localqy.EhY = paramJSONObject.optInt("init_balance");
        localqy.EhZ = paramJSONObject.optInt("init_bonus");
        localObject1 = paramJSONObject.optJSONArray("cell_list0");
        if (localObject1 != null) {
          localqy.Eia = r((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list1");
        if (localObject1 != null) {
          localqy.Eib = r((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list2");
        if (localObject1 != null) {
          localqy.Eic = r((JSONArray)localObject1);
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
          localqy.Eid = ((LinkedList)localObject1);
        }
        localqy.Eie = paramJSONObject.optInt("avail_num");
        localqy.Eif = paramJSONObject.optInt("code_type");
        localqy.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          localqy.Eig = s((JSONArray)localObject1);
        }
        localqy.Eih = paramJSONObject.optLong("stock_num");
        localqy.Eii = paramJSONObject.optInt("limit_num");
        localqy.Eij = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          localqy.Eik = af((JSONObject)localObject1);
        }
        localqy.Eil = t(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          localqy.Eim = af((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          localqy.Ein = af((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          localqy.Eio = af((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          localqy.Eip = aj((JSONObject)localObject1);
        }
        localqy.Eiq = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          localqy.Eir = af((JSONObject)localObject1);
        }
        localqy.Eis = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          localqy.Eit = af((JSONObject)localObject1);
        }
        localqy.Eiu = paramJSONObject.optBoolean("is_commom_card");
        localqy.Eiv = paramJSONObject.optBoolean("is_location_authorized");
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject1;
        JSONArray localJSONArray;
        int i;
        ac.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(113786);
      return localqy;
      localObject1 = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        ((LinkedList)localObject1).add((String)localJSONArray.get(i));
        i += 1;
      }
    }
  }
  
  public static ry ad(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113788);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      AppMethodBeat.o(113788);
      return null;
    }
    ry localry = new ry();
    Object localObject1;
    Object localObject3;
    label525:
    label555:
    label720:
    int i;
    label803:
    label1017:
    dgj localdgj;
    for (;;)
    {
      try
      {
        localry.nUr = paramJSONObject.optString("card_tp_id");
        localry.hhs = paramJSONObject.optString("logo_url");
        localry.djj = paramJSONObject.optString("appid");
        localry.Ekn = paramJSONObject.optString("app_username");
        localry.Eko = paramJSONObject.optInt("card_category");
        localry.lRv = paramJSONObject.optInt("card_type");
        localry.nVK = paramJSONObject.optString("brand_name");
        localry.title = paramJSONObject.optString("title");
        localry.nUs = paramJSONObject.optString("sub_title");
        localry.hiu = paramJSONObject.optString("color");
        localry.iAx = paramJSONObject.optString("notice");
        localry.Ekp = paramJSONObject.optString("service_phone");
        localry.Eks = paramJSONObject.optString("image_text_url");
        localry.Ekt = paramJSONObject.optString("source_icon");
        localry.source = paramJSONObject.optString("source");
        localObject1 = paramJSONObject.optJSONArray("primary_fields");
        if (localObject1 != null) {
          localry.Ekq = s((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("introduce_fields");
        if (localObject1 != null) {
          localry.Ekr = s((JSONArray)localObject1);
        }
        localry.Eku = paramJSONObject.optInt("shop_count");
        localry.kfh = paramJSONObject.optString("limit_wording");
        localry.nVJ = paramJSONObject.optString("card_type_name");
        localry.Ekv = paramJSONObject.optString("h5_show_url");
        localry.Ekw = paramJSONObject.optInt("block_mask");
        localry.Ekx = paramJSONObject.optString("middle_icon");
        localry.Eky = paramJSONObject.optString("accept_wording");
        localry.Ekz = paramJSONObject.optLong("control_flag");
        localry.EkA = paramJSONObject.optString("advertise_wording");
        localry.EkB = paramJSONObject.optString("advertise_url");
        localry.EkC = paramJSONObject.optString("public_service_name");
        localObject3 = paramJSONObject.optJSONObject("announcement");
        if (localObject3 != null) {
          continue;
        }
        ac.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
        localry.EkD = ((rn)localObject1);
        localry.EkE = paramJSONObject.optString("public_service_tip");
        localry.EkF = paramJSONObject.optString("primary_sub_title");
        localry.EkG = paramJSONObject.optInt("gen_type");
        localry.EkH = ah(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          continue;
        }
        ac.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localry.EkI = ((dny)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1191;
        }
        ac.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        localry.EkJ = ((apj)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1264;
        }
        ac.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        localry.EkK = ((bc)localObject1);
        localry.EkL = paramJSONObject.optInt("need_direct_jump", 0);
        localry.EkM = paramJSONObject.optInt("is_acceptable", 0);
        localry.EkN = paramJSONObject.optString("unacceptable_wording");
        localry.EkO = paramJSONObject.optInt("has_hongbao", 0);
        localry.EkP = paramJSONObject.optString("accept_ui_title");
        localry.EkQ = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localry.EkR = af((JSONObject)localObject1);
        }
        localry.EkS = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localry.EkT = af((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1299;
          }
          ac.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          localry.EkU = ((adn)localObject1);
        }
        localry.EkV = paramJSONObject.optBoolean("is_card_code_exposed");
        localry.EkW = paramJSONObject.optInt("qrcode_correct_level");
        localry.EkX = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localry.EkY = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1397;
          }
          ac.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          localry.EkZ = ((oj)localObject1);
        }
        localry.Ela = paramJSONObject.optString("biz_nickname");
        localry.Elb = paramJSONObject.optString("gift_title");
        ac.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localry.Elb });
      }
      catch (JSONException paramJSONObject)
      {
        ac.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
        localObject1 = new dny();
        ((dny)localObject1).title = ((JSONObject)localObject3).optString("title");
        localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
        if (localJSONArray == null) {
          break;
        }
      }
      AppMethodBeat.o(113788);
      return localry;
      localObject1 = new rn();
      ((rn)localObject1).type = ((JSONObject)localObject3).optInt("type");
      ((rn)localObject1).text = ((JSONObject)localObject3).optString("text");
      ((rn)localObject1).url = ((JSONObject)localObject3).optString("url");
      ((rn)localObject1).xxQ = ((JSONObject)localObject3).optInt("endtime");
      ((rn)localObject1).EbF = ((JSONObject)localObject3).optInt("create_time");
      ((rn)localObject1).EjH = ((JSONObject)localObject3).optString("thumb_url");
      continue;
      if (localJSONArray.length() > 0)
      {
        ((dny)localObject1).FVC = new LinkedList();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label1063;
        }
        localdgj = ai(localJSONArray.optJSONObject(i));
        if (localdgj == null) {
          break label1452;
        }
        ((dny)localObject1).FVC.add(localdgj);
        break label1452;
      }
    }
    ac.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    label1063:
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((dny)localObject1).FVD = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localdgj = ai(localJSONArray.optJSONObject(i));
        if (localdgj != null)
        {
          ((dny)localObject1).FVD.add(localdgj);
          break label1459;
          ac.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((dny)localObject1).FVE = s((JSONArray)localObject3);
          break;
        }
        ac.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1191:
        localObject1 = new apj();
        ((apj)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((apj)localObject1).EIr = ((JSONObject)localObject3).optInt("follow");
        ac.i("MicroMsg.CardInfoParser", "follow:" + ((apj)localObject1).EIr + "　text:" + ((apj)localObject1).text);
        break label525;
        label1264:
        localObject1 = new bc();
        ((bc)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((bc)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label555;
        label1299:
        localObject1 = new adn();
        ((adn)localObject1).Ewc = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((adn)localObject1).Ewd = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((adn)localObject1).Ewe = ((JSONObject)localObject3).optString("refresh_wording");
        ac.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((adn)localObject1).Ewc + "　can_refresh:" + ((adn)localObject1).Ewd + "　refresh_wording:" + ((adn)localObject1).Ewe);
        break label720;
        label1397:
        localObject1 = new oj();
        ((oj)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((oj)localObject1).Eei = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        ac.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((oj)localObject1).name });
        break label803;
        label1452:
        i += 1;
        break label1017;
      }
      label1459:
      i += 1;
    }
  }
  
  private static cyg ae(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113790);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      AppMethodBeat.o(113790);
      return null;
    }
    cyg localcyg = new cyg();
    localcyg.FHx = paramJSONObject.optString("gift_msg_title");
    AppMethodBeat.o(113790);
    return localcyg;
  }
  
  private static yg af(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113792);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      AppMethodBeat.o(113792);
      return null;
    }
    yg localyg = new yg();
    localyg.title = paramJSONObject.optString("title");
    localyg.nUt = paramJSONObject.optString("aux_title");
    localyg.nUs = paramJSONObject.optString("sub_title");
    localyg.url = paramJSONObject.optString("url");
    localyg.Els = paramJSONObject.optLong("show_flag");
    localyg.Elt = paramJSONObject.optString("primary_color");
    localyg.Elu = paramJSONObject.optString("secondary_color");
    localyg.oGN = paramJSONObject.optString("icon_url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null) {
      localyg.ErU = ag(localJSONObject);
    }
    localyg.Ekb = paramJSONObject.optString("app_brand_user_name");
    localyg.Ekc = paramJSONObject.optString("app_brand_pass");
    AppMethodBeat.o(113792);
    return localyg;
  }
  
  private static bhz ag(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113793);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
      AppMethodBeat.o(113793);
      return null;
    }
    ac.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { paramJSONObject });
    bhz localbhz = new bhz();
    localbhz.DMq = p.dv(paramJSONObject.optString("biz_uin"));
    localbhz.DMr = paramJSONObject.optString("order_id");
    AppMethodBeat.o(113793);
    return localbhz;
  }
  
  private static acl ah(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113794);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      AppMethodBeat.o(113794);
      return null;
    }
    acl localacl = new acl();
    localacl.title = paramJSONObject.optString("title");
    localacl.url = paramJSONObject.optString("url");
    localacl.desc = paramJSONObject.optString("abstract");
    localacl.detail = paramJSONObject.optString("detail");
    localacl.EuW = paramJSONObject.optString("ad_title");
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
            ac.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            ac.e("MicroMsg.CardInfoParser", "getMessage:" + localJSONException.getMessage());
          }
        }
        localLinkedList.add(paramJSONObject);
        i += 1;
      }
      label198:
      localacl.EuV = localLinkedList;
    }
    for (;;)
    {
      AppMethodBeat.o(113794);
      return localacl;
      ac.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static dgj ai(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113795);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      AppMethodBeat.o(113795);
      return null;
    }
    dgj localdgj = new dgj();
    localdgj.tag = paramJSONObject.optString("tag");
    localdgj.hiu = paramJSONObject.optString("color");
    AppMethodBeat.o(113795);
    return localdgj;
  }
  
  private static acm aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113796);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      AppMethodBeat.o(113796);
      return null;
    }
    acm localacm = new acm();
    localacm.title = paramJSONObject.optString("title");
    localacm.nUs = paramJSONObject.optString("sub_title");
    localacm.EuX = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
    for (;;)
    {
      try
      {
        localacm.EuY = s(paramJSONObject);
        AppMethodBeat.o(113796);
        return localacm;
      }
      catch (JSONException paramJSONObject)
      {
        ac.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        ac.e("MicroMsg.CardInfoParser", paramJSONObject.getMessage());
        continue;
      }
      ac.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
    }
  }
  
  private static LinkedList<sg> r(JSONArray paramJSONArray)
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
      sg localsg = new sg();
      localsg.title = localJSONObject.optString("title");
      localsg.nUs = localJSONObject.optString("sub_title");
      localsg.nYv = localJSONObject.optString("tips");
      localsg.url = localJSONObject.optString("url");
      localsg.Els = localJSONObject.optLong("show_flag");
      localsg.Elt = localJSONObject.optString("primary_color");
      localsg.Elu = localJSONObject.optString("secondary_color");
      localsg.oGN = localJSONObject.optString("icon_url");
      localsg.Ekb = localJSONObject.optString("app_brand_user_name");
      localsg.Ekc = localJSONObject.optString("app_brand_pass");
      localLinkedList.add(localsg);
      i += 1;
    }
    AppMethodBeat.o(113787);
    return localLinkedList;
  }
  
  private static LinkedList<yg> s(JSONArray paramJSONArray)
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
      yg localyg = af(paramJSONArray.getJSONObject(i));
      if (localyg != null) {
        localLinkedList.add(localyg);
      }
      i += 1;
    }
    AppMethodBeat.o(113789);
    return localLinkedList;
  }
  
  private static LinkedList<bc> t(JSONArray paramJSONArray)
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
            bc localbc = new bc();
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            localbc.text = localJSONObject.optString("text");
            localbc.url = localJSONObject.optString("url");
            localLinkedList.add(localbc);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
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