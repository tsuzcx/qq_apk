package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static ArrayList<ShareCardInfo> ZQ(String paramString)
  {
    AppMethodBeat.i(113779);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
      AppMethodBeat.o(113779);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ae.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
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
      ae.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113779);
    }
    return null;
  }
  
  public static ArrayList<CardInfo> ZR(String paramString)
  {
    AppMethodBeat.i(113782);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
      AppMethodBeat.o(113782);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_array");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ae.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
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
      ae.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113782);
    }
    return null;
  }
  
  private static String ZS(String paramString)
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
      ae.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
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
      ae.printErrStackTrace("MicroMsg.CardInfoParser", paramCardInfo, "", new Object[0]);
      AppMethodBeat.o(113783);
    }
  }
  
  private static void a(CardInfo paramCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113784);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
      AppMethodBeat.o(113784);
      return;
    }
    paramCardInfo.field_card_id = ZS(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = ZS(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.oEr = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.oFA = af(localJSONObject1);
    paramCardInfo.oFz = ag(localJSONObject2);
    paramCardInfo.oFB = ah(paramJSONObject);
    if (paramCardInfo.oFz != null)
    {
      paramCardInfo.a(paramCardInfo.oFz);
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.oFz.Gke);
      paramCardInfo.field_card_type = paramCardInfo.oFz.mwj;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.oFz.oEo;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_begin_time = localJSONObject2.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_end_time = localJSONObject2.optLong("end_time");
      }
      if (paramCardInfo.oFz.GkC != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.oFz.GkC.Gwf;
      }
    }
    if (paramCardInfo.oFA != null)
    {
      paramCardInfo.a(paramCardInfo.oFA);
      paramCardInfo.field_status = paramCardInfo.oFA.status;
    }
    if (paramCardInfo.oFB != null) {
      paramCardInfo.a(paramCardInfo.oFB);
    }
    paramCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113784);
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, String paramString)
  {
    AppMethodBeat.i(113780);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
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
      ae.printErrStackTrace("MicroMsg.CardInfoParser", paramShareCardInfo, "", new Object[0]);
      ae.e("MicroMsg.CardInfoParser", paramShareCardInfo.getMessage());
      AppMethodBeat.o(113780);
    }
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113781);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
      AppMethodBeat.o(113781);
      return;
    }
    paramShareCardInfo.field_card_id = ZS(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = ZS(paramJSONObject.optString("card_tp_id"));
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
    paramShareCardInfo.oFA = af(localJSONObject1);
    paramShareCardInfo.oFz = ag(localJSONObject2);
    paramShareCardInfo.oFB = ah(paramJSONObject);
    if (paramShareCardInfo.oFA != null) {
      paramShareCardInfo.a(paramShareCardInfo.oFA);
    }
    if (paramShareCardInfo.oFz != null)
    {
      paramShareCardInfo.a(paramShareCardInfo.oFz);
      paramShareCardInfo.field_end_time = localJSONObject2.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject2.optInt("begin_time");
    }
    if (paramShareCardInfo.oFB != null) {
      paramShareCardInfo.a(paramShareCardInfo.oFB);
    }
    paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113781);
  }
  
  private static st af(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113786);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      AppMethodBeat.o(113786);
      return null;
    }
    st localst = new st();
    for (;;)
    {
      try
      {
        localst.status = paramJSONObject.optInt("status");
        localst.GhH = paramJSONObject.optInt("init_balance");
        localst.GhI = paramJSONObject.optInt("init_bonus");
        localObject1 = paramJSONObject.optJSONArray("cell_list0");
        if (localObject1 != null) {
          localst.GhJ = t((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list1");
        if (localObject1 != null) {
          localst.GhK = t((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list2");
        if (localObject1 != null) {
          localst.GhL = t((JSONArray)localObject1);
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
          localst.GhM = ((LinkedList)localObject1);
        }
        localst.GhN = paramJSONObject.optInt("avail_num");
        localst.GhO = paramJSONObject.optInt("code_type");
        localst.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          localst.GhP = u((JSONArray)localObject1);
        }
        localst.GhQ = paramJSONObject.optLong("stock_num");
        localst.GhR = paramJSONObject.optInt("limit_num");
        localst.GhS = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          localst.GhT = ai((JSONObject)localObject1);
        }
        localst.GhU = v(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          localst.GhV = ai((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          localst.GhW = ai((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          localst.GhX = ai((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          localst.GhY = am((JSONObject)localObject1);
        }
        localst.GhZ = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          localst.Gia = ai((JSONObject)localObject1);
        }
        localst.Gib = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          localst.Gic = ai((JSONObject)localObject1);
        }
        localst.Gid = paramJSONObject.optBoolean("is_commom_card");
        localst.Gie = paramJSONObject.optBoolean("is_location_authorized");
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject1;
        JSONArray localJSONArray;
        int i;
        ae.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(113786);
      return localst;
      localObject1 = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        ((LinkedList)localObject1).add((String)localJSONArray.get(i));
        i += 1;
      }
    }
  }
  
  public static tu ag(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113788);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      AppMethodBeat.o(113788);
      return null;
    }
    tu localtu = new tu();
    Object localObject1;
    Object localObject3;
    label525:
    label555:
    label720:
    int i;
    label803:
    label1017:
    dmt localdmt;
    for (;;)
    {
      try
      {
        localtu.oEo = paramJSONObject.optString("card_tp_id");
        localtu.hCp = paramJSONObject.optString("logo_url");
        localtu.dwb = paramJSONObject.optString("appid");
        localtu.GjV = paramJSONObject.optString("app_username");
        localtu.GjW = paramJSONObject.optInt("card_category");
        localtu.mwj = paramJSONObject.optInt("card_type");
        localtu.oFG = paramJSONObject.optString("brand_name");
        localtu.title = paramJSONObject.optString("title");
        localtu.oEp = paramJSONObject.optString("sub_title");
        localtu.hDr = paramJSONObject.optString("color");
        localtu.iWA = paramJSONObject.optString("notice");
        localtu.GjX = paramJSONObject.optString("service_phone");
        localtu.Gka = paramJSONObject.optString("image_text_url");
        localtu.Gkb = paramJSONObject.optString("source_icon");
        localtu.source = paramJSONObject.optString("source");
        localObject1 = paramJSONObject.optJSONArray("primary_fields");
        if (localObject1 != null) {
          localtu.GjY = u((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("introduce_fields");
        if (localObject1 != null) {
          localtu.GjZ = u((JSONArray)localObject1);
        }
        localtu.Gkc = paramJSONObject.optInt("shop_count");
        localtu.kDk = paramJSONObject.optString("limit_wording");
        localtu.oFF = paramJSONObject.optString("card_type_name");
        localtu.Gkd = paramJSONObject.optString("h5_show_url");
        localtu.Gke = paramJSONObject.optInt("block_mask");
        localtu.Gkf = paramJSONObject.optString("middle_icon");
        localtu.Gkg = paramJSONObject.optString("accept_wording");
        localtu.Gkh = paramJSONObject.optLong("control_flag");
        localtu.Gki = paramJSONObject.optString("advertise_wording");
        localtu.Gkj = paramJSONObject.optString("advertise_url");
        localtu.Gkk = paramJSONObject.optString("public_service_name");
        localObject3 = paramJSONObject.optJSONObject("announcement");
        if (localObject3 != null) {
          continue;
        }
        ae.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
        localtu.Gkl = ((tj)localObject1);
        localtu.Gkm = paramJSONObject.optString("public_service_tip");
        localtu.Gkn = paramJSONObject.optString("primary_sub_title");
        localtu.Gko = paramJSONObject.optInt("gen_type");
        localtu.Gkp = ak(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          continue;
        }
        ae.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localtu.Gkq = ((dum)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1191;
        }
        ae.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        localtu.Gkr = ((att)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1264;
        }
        ae.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        localtu.Gks = ((bc)localObject1);
        localtu.Gkt = paramJSONObject.optInt("need_direct_jump", 0);
        localtu.Gku = paramJSONObject.optInt("is_acceptable", 0);
        localtu.Gkv = paramJSONObject.optString("unacceptable_wording");
        localtu.Gkw = paramJSONObject.optInt("has_hongbao", 0);
        localtu.Gkx = paramJSONObject.optString("accept_ui_title");
        localtu.Gky = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localtu.Gkz = ai((JSONObject)localObject1);
        }
        localtu.GkA = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localtu.GkB = ai((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1299;
          }
          ae.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          localtu.GkC = ((afx)localObject1);
        }
        localtu.GkD = paramJSONObject.optBoolean("is_card_code_exposed");
        localtu.GkE = paramJSONObject.optInt("qrcode_correct_level");
        localtu.GkF = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localtu.GkG = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1397;
          }
          ae.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          localtu.GkH = ((pq)localObject1);
        }
        localtu.GkI = paramJSONObject.optString("biz_nickname");
        localtu.GkJ = paramJSONObject.optString("gift_title");
        ae.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localtu.GkJ });
      }
      catch (JSONException paramJSONObject)
      {
        ae.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
        localObject1 = new dum();
        ((dum)localObject1).title = ((JSONObject)localObject3).optString("title");
        localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
        if (localJSONArray == null) {
          break;
        }
      }
      AppMethodBeat.o(113788);
      return localtu;
      localObject1 = new tj();
      ((tj)localObject1).type = ((JSONObject)localObject3).optInt("type");
      ((tj)localObject1).text = ((JSONObject)localObject3).optString("text");
      ((tj)localObject1).url = ((JSONObject)localObject3).optString("url");
      ((tj)localObject1).zcL = ((JSONObject)localObject3).optInt("endtime");
      ((tj)localObject1).FZN = ((JSONObject)localObject3).optInt("create_time");
      ((tj)localObject1).GfZ = ((JSONObject)localObject3).optString("thumb_url");
      continue;
      if (localJSONArray.length() > 0)
      {
        ((dum)localObject1).Iad = new LinkedList();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label1063;
        }
        localdmt = al(localJSONArray.optJSONObject(i));
        if (localdmt == null) {
          break label1452;
        }
        ((dum)localObject1).Iad.add(localdmt);
        break label1452;
      }
    }
    ae.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    label1063:
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((dum)localObject1).Iae = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localdmt = al(localJSONArray.optJSONObject(i));
        if (localdmt != null)
        {
          ((dum)localObject1).Iae.add(localdmt);
          break label1459;
          ae.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((dum)localObject1).Iaf = u((JSONArray)localObject3);
          break;
        }
        ae.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1191:
        localObject1 = new att();
        ((att)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((att)localObject1).GKG = ((JSONObject)localObject3).optInt("follow");
        ae.i("MicroMsg.CardInfoParser", "follow:" + ((att)localObject1).GKG + "　text:" + ((att)localObject1).text);
        break label525;
        label1264:
        localObject1 = new bc();
        ((bc)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((bc)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label555;
        label1299:
        localObject1 = new afx();
        ((afx)localObject1).Gwf = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((afx)localObject1).Gwg = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((afx)localObject1).Gwh = ((JSONObject)localObject3).optString("refresh_wording");
        ae.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((afx)localObject1).Gwf + "　can_refresh:" + ((afx)localObject1).Gwg + "　refresh_wording:" + ((afx)localObject1).Gwh);
        break label720;
        label1397:
        localObject1 = new pq();
        ((pq)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((pq)localObject1).Gdg = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        ae.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((pq)localObject1).name });
        break label803;
        label1452:
        i += 1;
        break label1017;
      }
      label1459:
      i += 1;
    }
  }
  
  private static den ah(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113790);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      AppMethodBeat.o(113790);
      return null;
    }
    den localden = new den();
    localden.HLH = paramJSONObject.optString("gift_msg_title");
    AppMethodBeat.o(113790);
    return localden;
  }
  
  private static aai ai(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113792);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      AppMethodBeat.o(113792);
      return null;
    }
    aai localaai = new aai();
    localaai.title = paramJSONObject.optString("title");
    localaai.oEq = paramJSONObject.optString("aux_title");
    localaai.oEp = paramJSONObject.optString("sub_title");
    localaai.url = paramJSONObject.optString("url");
    localaai.GkZ = paramJSONObject.optLong("show_flag");
    localaai.Gla = paramJSONObject.optString("primary_color");
    localaai.Glb = paramJSONObject.optString("secondary_color");
    localaai.pqW = paramJSONObject.optString("icon_url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null) {
      localaai.GrD = aj(localJSONObject);
    }
    localaai.GjJ = paramJSONObject.optString("app_brand_user_name");
    localaai.GjK = paramJSONObject.optString("app_brand_pass");
    AppMethodBeat.o(113792);
    return localaai;
  }
  
  private static bmz aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113793);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
      AppMethodBeat.o(113793);
      return null;
    }
    ae.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { paramJSONObject });
    bmz localbmz = new bmz();
    localbmz.FJT = p.ew(paramJSONObject.optString("biz_uin"));
    localbmz.FJU = paramJSONObject.optString("order_id");
    AppMethodBeat.o(113793);
    return localbmz;
  }
  
  private static aeu ak(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113794);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      AppMethodBeat.o(113794);
      return null;
    }
    aeu localaeu = new aeu();
    localaeu.title = paramJSONObject.optString("title");
    localaeu.url = paramJSONObject.optString("url");
    localaeu.desc = paramJSONObject.optString("abstract");
    localaeu.detail = paramJSONObject.optString("detail");
    localaeu.GuX = paramJSONObject.optString("ad_title");
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
            ae.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            ae.e("MicroMsg.CardInfoParser", "getMessage:" + localJSONException.getMessage());
          }
        }
        localLinkedList.add(paramJSONObject);
        i += 1;
      }
      label198:
      localaeu.GuW = localLinkedList;
    }
    for (;;)
    {
      AppMethodBeat.o(113794);
      return localaeu;
      ae.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static dmt al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113795);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      AppMethodBeat.o(113795);
      return null;
    }
    dmt localdmt = new dmt();
    localdmt.tag = paramJSONObject.optString("tag");
    localdmt.hDr = paramJSONObject.optString("color");
    AppMethodBeat.o(113795);
    return localdmt;
  }
  
  private static aev am(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113796);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      AppMethodBeat.o(113796);
      return null;
    }
    aev localaev = new aev();
    localaev.title = paramJSONObject.optString("title");
    localaev.oEp = paramJSONObject.optString("sub_title");
    localaev.GuY = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
    for (;;)
    {
      try
      {
        localaev.GuZ = u(paramJSONObject);
        AppMethodBeat.o(113796);
        return localaev;
      }
      catch (JSONException paramJSONObject)
      {
        ae.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        ae.e("MicroMsg.CardInfoParser", paramJSONObject.getMessage());
        continue;
      }
      ae.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
    }
  }
  
  private static LinkedList<uc> t(JSONArray paramJSONArray)
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
      uc localuc = new uc();
      localuc.title = localJSONObject.optString("title");
      localuc.oEp = localJSONObject.optString("sub_title");
      localuc.oIr = localJSONObject.optString("tips");
      localuc.url = localJSONObject.optString("url");
      localuc.GkZ = localJSONObject.optLong("show_flag");
      localuc.Gla = localJSONObject.optString("primary_color");
      localuc.Glb = localJSONObject.optString("secondary_color");
      localuc.pqW = localJSONObject.optString("icon_url");
      localuc.GjJ = localJSONObject.optString("app_brand_user_name");
      localuc.GjK = localJSONObject.optString("app_brand_pass");
      localLinkedList.add(localuc);
      i += 1;
    }
    AppMethodBeat.o(113787);
    return localLinkedList;
  }
  
  private static LinkedList<aai> u(JSONArray paramJSONArray)
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
      aai localaai = ai(paramJSONArray.getJSONObject(i));
      if (localaai != null) {
        localLinkedList.add(localaai);
      }
      i += 1;
    }
    AppMethodBeat.o(113789);
    return localLinkedList;
  }
  
  private static LinkedList<bc> v(JSONArray paramJSONArray)
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
              ae.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            }
          }
        }
      }
    }
    AppMethodBeat.o(113791);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.f
 * JD-Core Version:    0.7.0.1
 */