package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static ArrayList<ShareCardInfo> YZ(String paramString)
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
  
  public static ArrayList<CardInfo> Za(String paramString)
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
  
  private static String Zb(String paramString)
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
    paramCardInfo.field_card_id = Zb(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = Zb(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.oxP = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.oyY = af(localJSONObject1);
    paramCardInfo.oyX = ag(localJSONObject2);
    paramCardInfo.oyZ = ah(paramJSONObject);
    if (paramCardInfo.oyX != null)
    {
      paramCardInfo.a(paramCardInfo.oyX);
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.oyX.FRF);
      paramCardInfo.field_card_type = paramCardInfo.oyX.mrl;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.oyX.oxM;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_begin_time = localJSONObject2.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_end_time = localJSONObject2.optLong("end_time");
      }
      if (paramCardInfo.oyX.FSd != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.oyX.FSd.Gdy;
      }
    }
    if (paramCardInfo.oyY != null)
    {
      paramCardInfo.a(paramCardInfo.oyY);
      paramCardInfo.field_status = paramCardInfo.oyY.status;
    }
    if (paramCardInfo.oyZ != null) {
      paramCardInfo.a(paramCardInfo.oyZ);
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
    paramShareCardInfo.field_card_id = Zb(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = Zb(paramJSONObject.optString("card_tp_id"));
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
    paramShareCardInfo.oyY = af(localJSONObject1);
    paramShareCardInfo.oyX = ag(localJSONObject2);
    paramShareCardInfo.oyZ = ah(paramJSONObject);
    if (paramShareCardInfo.oyY != null) {
      paramShareCardInfo.a(paramShareCardInfo.oyY);
    }
    if (paramShareCardInfo.oyX != null)
    {
      paramShareCardInfo.a(paramShareCardInfo.oyX);
      paramShareCardInfo.field_end_time = localJSONObject2.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject2.optInt("begin_time");
    }
    if (paramShareCardInfo.oyZ != null) {
      paramShareCardInfo.a(paramShareCardInfo.oyZ);
    }
    paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113781);
  }
  
  private static sr af(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113786);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      AppMethodBeat.o(113786);
      return null;
    }
    sr localsr = new sr();
    for (;;)
    {
      try
      {
        localsr.status = paramJSONObject.optInt("status");
        localsr.FPi = paramJSONObject.optInt("init_balance");
        localsr.FPj = paramJSONObject.optInt("init_bonus");
        localObject1 = paramJSONObject.optJSONArray("cell_list0");
        if (localObject1 != null) {
          localsr.FPk = s((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list1");
        if (localObject1 != null) {
          localsr.FPl = s((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list2");
        if (localObject1 != null) {
          localsr.FPm = s((JSONArray)localObject1);
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
          localsr.FPn = ((LinkedList)localObject1);
        }
        localsr.FPo = paramJSONObject.optInt("avail_num");
        localsr.FPp = paramJSONObject.optInt("code_type");
        localsr.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          localsr.FPq = t((JSONArray)localObject1);
        }
        localsr.FPr = paramJSONObject.optLong("stock_num");
        localsr.FPs = paramJSONObject.optInt("limit_num");
        localsr.FPt = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          localsr.FPu = ai((JSONObject)localObject1);
        }
        localsr.FPv = u(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          localsr.FPw = ai((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          localsr.FPx = ai((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          localsr.FPy = ai((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          localsr.FPz = am((JSONObject)localObject1);
        }
        localsr.FPA = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          localsr.FPB = ai((JSONObject)localObject1);
        }
        localsr.FPC = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          localsr.FPD = ai((JSONObject)localObject1);
        }
        localsr.FPE = paramJSONObject.optBoolean("is_commom_card");
        localsr.FPF = paramJSONObject.optBoolean("is_location_authorized");
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
      return localsr;
      localObject1 = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        ((LinkedList)localObject1).add((String)localJSONArray.get(i));
        i += 1;
      }
    }
  }
  
  public static ts ag(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113788);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      AppMethodBeat.o(113788);
      return null;
    }
    ts localts = new ts();
    Object localObject1;
    Object localObject3;
    label525:
    label555:
    label720:
    int i;
    label803:
    label1017:
    dlw localdlw;
    for (;;)
    {
      try
      {
        localts.oxM = paramJSONObject.optString("card_tp_id");
        localts.hzB = paramJSONObject.optString("logo_url");
        localts.duW = paramJSONObject.optString("appid");
        localts.FRw = paramJSONObject.optString("app_username");
        localts.FRx = paramJSONObject.optInt("card_category");
        localts.mrl = paramJSONObject.optInt("card_type");
        localts.oze = paramJSONObject.optString("brand_name");
        localts.title = paramJSONObject.optString("title");
        localts.oxN = paramJSONObject.optString("sub_title");
        localts.hAD = paramJSONObject.optString("color");
        localts.iTH = paramJSONObject.optString("notice");
        localts.FRy = paramJSONObject.optString("service_phone");
        localts.FRB = paramJSONObject.optString("image_text_url");
        localts.FRC = paramJSONObject.optString("source_icon");
        localts.source = paramJSONObject.optString("source");
        localObject1 = paramJSONObject.optJSONArray("primary_fields");
        if (localObject1 != null) {
          localts.FRz = t((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("introduce_fields");
        if (localObject1 != null) {
          localts.FRA = t((JSONArray)localObject1);
        }
        localts.FRD = paramJSONObject.optInt("shop_count");
        localts.kzV = paramJSONObject.optString("limit_wording");
        localts.ozd = paramJSONObject.optString("card_type_name");
        localts.FRE = paramJSONObject.optString("h5_show_url");
        localts.FRF = paramJSONObject.optInt("block_mask");
        localts.FRG = paramJSONObject.optString("middle_icon");
        localts.FRH = paramJSONObject.optString("accept_wording");
        localts.FRI = paramJSONObject.optLong("control_flag");
        localts.FRJ = paramJSONObject.optString("advertise_wording");
        localts.FRK = paramJSONObject.optString("advertise_url");
        localts.FRL = paramJSONObject.optString("public_service_name");
        localObject3 = paramJSONObject.optJSONObject("announcement");
        if (localObject3 != null) {
          continue;
        }
        ad.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
        localts.FRM = ((th)localObject1);
        localts.FRN = paramJSONObject.optString("public_service_tip");
        localts.FRO = paramJSONObject.optString("primary_sub_title");
        localts.FRP = paramJSONObject.optInt("gen_type");
        localts.FRQ = ak(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          continue;
        }
        ad.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localts.FRR = ((dtp)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1191;
        }
        ad.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        localts.FRS = ((atd)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1264;
        }
        ad.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        localts.FRT = ((bc)localObject1);
        localts.FRU = paramJSONObject.optInt("need_direct_jump", 0);
        localts.FRV = paramJSONObject.optInt("is_acceptable", 0);
        localts.FRW = paramJSONObject.optString("unacceptable_wording");
        localts.FRX = paramJSONObject.optInt("has_hongbao", 0);
        localts.FRY = paramJSONObject.optString("accept_ui_title");
        localts.FRZ = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localts.FSa = ai((JSONObject)localObject1);
        }
        localts.FSb = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localts.FSc = ai((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1299;
          }
          ad.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          localts.FSd = ((afo)localObject1);
        }
        localts.FSe = paramJSONObject.optBoolean("is_card_code_exposed");
        localts.FSf = paramJSONObject.optInt("qrcode_correct_level");
        localts.FSg = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localts.FSh = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1397;
          }
          ad.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          localts.FSi = ((po)localObject1);
        }
        localts.FSj = paramJSONObject.optString("biz_nickname");
        localts.FSk = paramJSONObject.optString("gift_title");
        ad.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localts.FSk });
      }
      catch (JSONException paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
        localObject1 = new dtp();
        ((dtp)localObject1).title = ((JSONObject)localObject3).optString("title");
        localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
        if (localJSONArray == null) {
          break;
        }
      }
      AppMethodBeat.o(113788);
      return localts;
      localObject1 = new th();
      ((th)localObject1).type = ((JSONObject)localObject3).optInt("type");
      ((th)localObject1).text = ((JSONObject)localObject3).optString("text");
      ((th)localObject1).url = ((JSONObject)localObject3).optString("url");
      ((th)localObject1).yMB = ((JSONObject)localObject3).optInt("endtime");
      ((th)localObject1).FHr = ((JSONObject)localObject3).optInt("create_time");
      ((th)localObject1).FNA = ((JSONObject)localObject3).optString("thumb_url");
      continue;
      if (localJSONArray.length() > 0)
      {
        ((dtp)localObject1).HGq = new LinkedList();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label1063;
        }
        localdlw = al(localJSONArray.optJSONObject(i));
        if (localdlw == null) {
          break label1452;
        }
        ((dtp)localObject1).HGq.add(localdlw);
        break label1452;
      }
    }
    ad.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    label1063:
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((dtp)localObject1).HGr = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localdlw = al(localJSONArray.optJSONObject(i));
        if (localdlw != null)
        {
          ((dtp)localObject1).HGr.add(localdlw);
          break label1459;
          ad.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((dtp)localObject1).HGs = t((JSONArray)localObject3);
          break;
        }
        ad.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1191:
        localObject1 = new atd();
        ((atd)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((atd)localObject1).Gri = ((JSONObject)localObject3).optInt("follow");
        ad.i("MicroMsg.CardInfoParser", "follow:" + ((atd)localObject1).Gri + "　text:" + ((atd)localObject1).text);
        break label525;
        label1264:
        localObject1 = new bc();
        ((bc)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((bc)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label555;
        label1299:
        localObject1 = new afo();
        ((afo)localObject1).Gdy = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((afo)localObject1).Gdz = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((afo)localObject1).GdA = ((JSONObject)localObject3).optString("refresh_wording");
        ad.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((afo)localObject1).Gdy + "　can_refresh:" + ((afo)localObject1).Gdz + "　refresh_wording:" + ((afo)localObject1).GdA);
        break label720;
        label1397:
        localObject1 = new po();
        ((po)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((po)localObject1).FKH = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        ad.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((po)localObject1).name });
        break label803;
        label1452:
        i += 1;
        break label1017;
      }
      label1459:
      i += 1;
    }
  }
  
  private static ddt ah(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113790);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      AppMethodBeat.o(113790);
      return null;
    }
    ddt localddt = new ddt();
    localddt.Hsf = paramJSONObject.optString("gift_msg_title");
    AppMethodBeat.o(113790);
    return localddt;
  }
  
  private static aaf ai(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113792);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      AppMethodBeat.o(113792);
      return null;
    }
    aaf localaaf = new aaf();
    localaaf.title = paramJSONObject.optString("title");
    localaaf.oxO = paramJSONObject.optString("aux_title");
    localaaf.oxN = paramJSONObject.optString("sub_title");
    localaaf.url = paramJSONObject.optString("url");
    localaaf.FSA = paramJSONObject.optLong("show_flag");
    localaaf.FSB = paramJSONObject.optString("primary_color");
    localaaf.FSC = paramJSONObject.optString("secondary_color");
    localaaf.pkr = paramJSONObject.optString("icon_url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null) {
      localaaf.FZd = aj(localJSONObject);
    }
    localaaf.FRk = paramJSONObject.optString("app_brand_user_name");
    localaaf.FRl = paramJSONObject.optString("app_brand_pass");
    AppMethodBeat.o(113792);
    return localaaf;
  }
  
  private static bmh aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113793);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
      AppMethodBeat.o(113793);
      return null;
    }
    ad.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { paramJSONObject });
    bmh localbmh = new bmh();
    localbmh.Frv = p.er(paramJSONObject.optString("biz_uin"));
    localbmh.Frw = paramJSONObject.optString("order_id");
    AppMethodBeat.o(113793);
    return localbmh;
  }
  
  private static ael ak(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113794);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      AppMethodBeat.o(113794);
      return null;
    }
    ael localael = new ael();
    localael.title = paramJSONObject.optString("title");
    localael.url = paramJSONObject.optString("url");
    localael.desc = paramJSONObject.optString("abstract");
    localael.detail = paramJSONObject.optString("detail");
    localael.Gcq = paramJSONObject.optString("ad_title");
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
      localael.Gcp = localLinkedList;
    }
    for (;;)
    {
      AppMethodBeat.o(113794);
      return localael;
      ad.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static dlw al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113795);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      AppMethodBeat.o(113795);
      return null;
    }
    dlw localdlw = new dlw();
    localdlw.tag = paramJSONObject.optString("tag");
    localdlw.hAD = paramJSONObject.optString("color");
    AppMethodBeat.o(113795);
    return localdlw;
  }
  
  private static aem am(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113796);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      AppMethodBeat.o(113796);
      return null;
    }
    aem localaem = new aem();
    localaem.title = paramJSONObject.optString("title");
    localaem.oxN = paramJSONObject.optString("sub_title");
    localaem.Gcr = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
    for (;;)
    {
      try
      {
        localaem.Gcs = t(paramJSONObject);
        AppMethodBeat.o(113796);
        return localaem;
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
  
  private static LinkedList<ua> s(JSONArray paramJSONArray)
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
      ua localua = new ua();
      localua.title = localJSONObject.optString("title");
      localua.oxN = localJSONObject.optString("sub_title");
      localua.oBP = localJSONObject.optString("tips");
      localua.url = localJSONObject.optString("url");
      localua.FSA = localJSONObject.optLong("show_flag");
      localua.FSB = localJSONObject.optString("primary_color");
      localua.FSC = localJSONObject.optString("secondary_color");
      localua.pkr = localJSONObject.optString("icon_url");
      localua.FRk = localJSONObject.optString("app_brand_user_name");
      localua.FRl = localJSONObject.optString("app_brand_pass");
      localLinkedList.add(localua);
      i += 1;
    }
    AppMethodBeat.o(113787);
    return localLinkedList;
  }
  
  private static LinkedList<aaf> t(JSONArray paramJSONArray)
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
      aaf localaaf = ai(paramJSONArray.getJSONObject(i));
      if (localaaf != null) {
        localLinkedList.add(localaaf);
      }
      i += 1;
    }
    AppMethodBeat.o(113789);
    return localLinkedList;
  }
  
  private static LinkedList<bc> u(JSONArray paramJSONArray)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.f
 * JD-Core Version:    0.7.0.1
 */