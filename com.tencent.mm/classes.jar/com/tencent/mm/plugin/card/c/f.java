package com.tencent.mm.plugin.card.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.flo;
import com.tencent.mm.protocal.protobuf.fum;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.xd;
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
    paramCardInfo.field_card_id = alp(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = alp(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.wsB = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.wtI = aM(localJSONObject1);
    paramCardInfo.wtH = aN(localJSONObject2);
    paramCardInfo.wtJ = aO(paramJSONObject);
    if (paramCardInfo.wtH != null)
    {
      paramCardInfo.a(paramCardInfo.wtH);
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.wtH.ZdQ);
      paramCardInfo.field_card_type = paramCardInfo.wtH.tNW;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.wtH.wsy;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_begin_time = localJSONObject2.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_end_time = localJSONObject2.optLong("end_time");
      }
      if (paramCardInfo.wtH.Zeo != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.wtH.Zeo.Zsw;
      }
    }
    if (paramCardInfo.wtI != null)
    {
      paramCardInfo.a(paramCardInfo.wtI);
      paramCardInfo.field_status = paramCardInfo.wtI.status;
    }
    if (paramCardInfo.wtJ != null) {
      paramCardInfo.a(paramCardInfo.wtJ);
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
    paramShareCardInfo.field_card_id = alp(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = alp(paramJSONObject.optString("card_tp_id"));
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
    paramShareCardInfo.wtI = aM(localJSONObject1);
    paramShareCardInfo.wtH = aN(localJSONObject2);
    paramShareCardInfo.wtJ = aO(paramJSONObject);
    if (paramShareCardInfo.wtI != null) {
      paramShareCardInfo.a(paramShareCardInfo.wtI);
    }
    if (paramShareCardInfo.wtH != null)
    {
      paramShareCardInfo.a(paramShareCardInfo.wtH);
      paramShareCardInfo.field_end_time = localJSONObject2.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject2.optInt("begin_time");
    }
    if (paramShareCardInfo.wtJ != null) {
      paramShareCardInfo.a(paramShareCardInfo.wtJ);
    }
    paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113781);
  }
  
  private static vr aM(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113786);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      AppMethodBeat.o(113786);
      return null;
    }
    vr localvr = new vr();
    for (;;)
    {
      try
      {
        localvr.status = paramJSONObject.optInt("status");
        localvr.Zbr = paramJSONObject.optInt("init_balance");
        localvr.Zbs = paramJSONObject.optInt("init_bonus");
        localObject1 = paramJSONObject.optJSONArray("cell_list0");
        if (localObject1 != null) {
          localvr.Zbt = w((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list1");
        if (localObject1 != null) {
          localvr.Zbu = w((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list2");
        if (localObject1 != null) {
          localvr.Zbv = w((JSONArray)localObject1);
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
          localvr.Zbw = ((LinkedList)localObject1);
        }
        localvr.Zbx = paramJSONObject.optInt("avail_num");
        localvr.Zby = paramJSONObject.optInt("code_type");
        localvr.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          localvr.Zbz = x((JSONArray)localObject1);
        }
        localvr.ZbA = paramJSONObject.optLong("stock_num");
        localvr.ZbB = paramJSONObject.optInt("limit_num");
        localvr.ZbC = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          localvr.ZbD = aP((JSONObject)localObject1);
        }
        localvr.ZbE = y(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          localvr.ZbF = aP((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          localvr.ZbG = aP((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          localvr.ZbH = aP((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          localvr.ZbI = aT((JSONObject)localObject1);
        }
        localvr.ZbJ = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          localvr.ZbK = aP((JSONObject)localObject1);
        }
        localvr.ZbL = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          localvr.ZbM = aP((JSONObject)localObject1);
        }
        localvr.ZbN = paramJSONObject.optBoolean("is_commom_card");
        localvr.ZbO = paramJSONObject.optBoolean("is_location_authorized");
        localvr.ZbP = aP(paramJSONObject.optJSONObject("finder_field"));
        localvr.ZbQ = aP(paramJSONObject.optJSONObject("feed_field"));
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
      return localvr;
      localObject1 = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        ((LinkedList)localObject1).add((String)localJSONArray.get(i));
        i += 1;
      }
    }
  }
  
  public static ws aN(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113788);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      AppMethodBeat.o(113788);
      return null;
    }
    ws localws = new ws();
    Object localObject1;
    Object localObject3;
    label537:
    label567:
    label732:
    int i;
    label815:
    flo localflo;
    for (;;)
    {
      try
      {
        localws.wsy = paramJSONObject.optString("card_tp_id");
        localws.nQG = paramJSONObject.optString("logo_url");
        localws.appid = paramJSONObject.optString("appid");
        localws.YYZ = paramJSONObject.optString("app_username");
        localws.ZdI = paramJSONObject.optInt("card_category");
        localws.tNW = paramJSONObject.optInt("card_type");
        localws.mee = paramJSONObject.optString("brand_name");
        localws.title = paramJSONObject.optString("title");
        localws.wsz = paramJSONObject.optString("sub_title");
        localws.nRQ = paramJSONObject.optString("color");
        localws.pHt = paramJSONObject.optString("notice");
        localws.ZdJ = paramJSONObject.optString("service_phone");
        localws.ZdM = paramJSONObject.optString("image_text_url");
        localws.ZdN = paramJSONObject.optString("source_icon");
        localws.source = paramJSONObject.optString("source");
        localws.Zev = paramJSONObject.optString("brand_icon_url");
        localObject1 = paramJSONObject.optJSONArray("primary_fields");
        if (localObject1 != null) {
          localws.ZdK = x((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("introduce_fields");
        if (localObject1 != null) {
          localws.ZdL = x((JSONArray)localObject1);
        }
        localws.ZdO = paramJSONObject.optInt("shop_count");
        localws.rHe = paramJSONObject.optString("limit_wording");
        localws.wtN = paramJSONObject.optString("card_type_name");
        localws.ZdP = paramJSONObject.optString("h5_show_url");
        localws.ZdQ = paramJSONObject.optInt("block_mask");
        localws.ZdR = paramJSONObject.optString("middle_icon");
        localws.ZdS = paramJSONObject.optString("accept_wording");
        localws.ZdT = paramJSONObject.optLong("control_flag");
        localws.ZdU = paramJSONObject.optString("advertise_wording");
        localws.ZdV = paramJSONObject.optString("advertise_url");
        localws.ZdW = paramJSONObject.optString("public_service_name");
        localObject3 = paramJSONObject.optJSONObject("announcement");
        if (localObject3 != null) {
          continue;
        }
        Log.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
        localws.ZdX = ((wh)localObject1);
        localws.ZdY = paramJSONObject.optString("public_service_tip");
        localws.ZdZ = paramJSONObject.optString("primary_sub_title");
        localws.Zea = paramJSONObject.optInt("gen_type");
        localws.Zeb = aR(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          continue;
        }
        Log.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localws.Zec = ((fum)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1239;
        }
        Log.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        localws.Zed = ((bzp)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1312;
        }
        Log.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        localws.Zee = ((bj)localObject1);
        localws.Zef = paramJSONObject.optInt("need_direct_jump", 0);
        localws.Zeg = paramJSONObject.optInt("is_acceptable", 0);
        localws.Zeh = paramJSONObject.optString("unacceptable_wording");
        localws.Zei = paramJSONObject.optInt("has_hongbao", 0);
        localws.Zej = paramJSONObject.optString("accept_ui_title");
        localws.Zek = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localws.Zel = aP((JSONObject)localObject1);
        }
        localws.Zem = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localws.Zen = aP((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1347;
          }
          Log.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          localws.Zeo = ((alk)localObject1);
        }
        localws.Zep = paramJSONObject.optBoolean("is_card_code_exposed");
        localws.Zeq = paramJSONObject.optInt("qrcode_correct_level");
        localws.Zer = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localws.Zes = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1445;
          }
          Log.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          localws.Zet = ((ru)localObject1);
        }
        localws.YTl = paramJSONObject.optString("biz_nickname");
        localws.Zeu = paramJSONObject.optString("gift_title");
        localws.Zev = paramJSONObject.optString("brand_icon_url");
        localws.Zex = paramJSONObject.optString("advertise_tinyapp_path");
        localws.Zew = paramJSONObject.optString("advertise_tinyapp_username");
        Log.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localws.Zeu });
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
        localObject1 = new fum();
        ((fum)localObject1).title = ((JSONObject)localObject3).optString("title");
        localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
        if (localJSONArray == null) {
          break;
        }
      }
      AppMethodBeat.o(113788);
      return localws;
      localObject1 = new wh();
      ((wh)localObject1).type = ((JSONObject)localObject3).optInt("type");
      ((wh)localObject1).text = ((JSONObject)localObject3).optString("text");
      ((wh)localObject1).url = ((JSONObject)localObject3).optString("url");
      ((wh)localObject1).PzZ = ((JSONObject)localObject3).optInt("endtime");
      ((wh)localObject1).HTK = ((JSONObject)localObject3).optInt("create_time");
      ((wh)localObject1).mdZ = ((JSONObject)localObject3).optString("thumb_url");
      continue;
      if (localJSONArray.length() > 0)
      {
        ((fum)localObject1).abSG = new LinkedList();
        i = 0;
        label1065:
        if (i >= localJSONArray.length()) {
          break label1111;
        }
        localflo = aS(localJSONArray.optJSONObject(i));
        if (localflo == null) {
          break label1500;
        }
        ((fum)localObject1).abSG.add(localflo);
        break label1500;
      }
    }
    Log.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    label1111:
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((fum)localObject1).abSH = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localflo = aS(localJSONArray.optJSONObject(i));
        if (localflo != null)
        {
          ((fum)localObject1).abSH.add(localflo);
          break label1507;
          Log.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((fum)localObject1).abSI = x((JSONArray)localObject3);
          break;
        }
        Log.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1239:
        localObject1 = new bzp();
        ((bzp)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((bzp)localObject1).aaiP = ((JSONObject)localObject3).optInt("follow");
        Log.i("MicroMsg.CardInfoParser", "follow:" + ((bzp)localObject1).aaiP + "　text:" + ((bzp)localObject1).text);
        break label537;
        label1312:
        localObject1 = new bj();
        ((bj)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((bj)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label567;
        label1347:
        localObject1 = new alk();
        ((alk)localObject1).Zsw = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((alk)localObject1).Zsx = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((alk)localObject1).Zsy = ((JSONObject)localObject3).optString("refresh_wording");
        Log.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((alk)localObject1).Zsw + "　can_refresh:" + ((alk)localObject1).Zsx + "　refresh_wording:" + ((alk)localObject1).Zsy);
        break label732;
        label1445:
        localObject1 = new ru();
        ((ru)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((ru)localObject1).YWF = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        Log.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((ru)localObject1).name });
        break label815;
        label1500:
        i += 1;
        break label1065;
      }
      label1507:
      i += 1;
    }
  }
  
  private static fbs aO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113790);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      AppMethodBeat.o(113790);
      return null;
    }
    fbs localfbs = new fbs();
    localfbs.abBp = paramJSONObject.optString("gift_msg_title");
    AppMethodBeat.o(113790);
    return localfbs;
  }
  
  private static aek aP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113792);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      AppMethodBeat.o(113792);
      return null;
    }
    aek localaek = new aek();
    localaek.title = paramJSONObject.optString("title");
    localaek.wsA = paramJSONObject.optString("aux_title");
    localaek.wsz = paramJSONObject.optString("sub_title");
    localaek.url = paramJSONObject.optString("url");
    localaek.ZeU = paramJSONObject.optLong("show_flag");
    localaek.ZeV = paramJSONObject.optString("primary_color");
    localaek.ZeW = paramJSONObject.optString("secondary_color");
    localaek.icon_url = paramJSONObject.optString("icon_url");
    localaek.Zmo = paramJSONObject.optString("cell_icon_url");
    localaek.Zmp = paramJSONObject.optString("cell_link_icon_url");
    localaek.YIZ = paramJSONObject.optString("finder_username");
    localaek.Zmq = paramJSONObject.optString("cell_cover_url");
    localaek.Zmr = paramJSONObject.optString("cell_center_icon_url");
    localaek.ZeX = paramJSONObject.optString("feed_id");
    localaek.mdD = paramJSONObject.optString("nonce_id");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null) {
      localaek.Zmn = aQ(localJSONObject);
    }
    localaek.Zdw = paramJSONObject.optString("app_brand_user_name");
    localaek.Zdx = paramJSONObject.optString("app_brand_pass");
    AppMethodBeat.o(113792);
    return localaek;
  }
  
  private static cxm aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113793);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
      AppMethodBeat.o(113793);
      return null;
    }
    Log.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { paramJSONObject });
    cxm localcxm = new cxm();
    localcxm.YBh = p.hw(paramJSONObject.optString("biz_uin"));
    localcxm.YBi = paramJSONObject.optString("order_id");
    AppMethodBeat.o(113793);
    return localcxm;
  }
  
  private static akb aR(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113794);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      AppMethodBeat.o(113794);
      return null;
    }
    akb localakb = new akb();
    localakb.title = paramJSONObject.optString("title");
    localakb.url = paramJSONObject.optString("url");
    localakb.desc = paramJSONObject.optString("abstract");
    localakb.detail = paramJSONObject.optString("detail");
    localakb.Zri = paramJSONObject.optString("ad_title");
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
      localakb.Zrh = localLinkedList;
    }
    for (;;)
    {
      AppMethodBeat.o(113794);
      return localakb;
      Log.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static flo aS(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113795);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      AppMethodBeat.o(113795);
      return null;
    }
    flo localflo = new flo();
    localflo.tag = paramJSONObject.optString("tag");
    localflo.nRQ = paramJSONObject.optString("color");
    AppMethodBeat.o(113795);
    return localflo;
  }
  
  private static akc aT(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113796);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      AppMethodBeat.o(113796);
      return null;
    }
    akc localakc = new akc();
    localakc.title = paramJSONObject.optString("title");
    localakc.wsz = paramJSONObject.optString("sub_title");
    localakc.Zrj = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
    for (;;)
    {
      try
      {
        localakc.Zrk = x(paramJSONObject);
        AppMethodBeat.o(113796);
        return localakc;
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
  
  public static ArrayList<ShareCardInfo> aln(String paramString)
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
  
  public static ArrayList<CardInfo> alo(String paramString)
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
  
  private static String alp(String paramString)
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
  
  private static LinkedList<xd> w(JSONArray paramJSONArray)
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
      xd localxd = new xd();
      localxd.title = localJSONObject.optString("title");
      localxd.wsz = localJSONObject.optString("sub_title");
      localxd.lym = localJSONObject.optString("tips");
      localxd.url = localJSONObject.optString("url");
      localxd.ZeU = localJSONObject.optLong("show_flag");
      localxd.ZeV = localJSONObject.optString("primary_color");
      localxd.ZeW = localJSONObject.optString("secondary_color");
      localxd.icon_url = localJSONObject.optString("icon_url");
      localxd.Zdw = localJSONObject.optString("app_brand_user_name");
      localxd.Zdx = localJSONObject.optString("app_brand_pass");
      localxd.YIZ = localJSONObject.optString("finder_username");
      localxd.ZeX = localJSONObject.optString("feed_id");
      localxd.mdD = localJSONObject.optString("nonce_id");
      localLinkedList.add(localxd);
      i += 1;
    }
    AppMethodBeat.o(113787);
    return localLinkedList;
  }
  
  private static LinkedList<aek> x(JSONArray paramJSONArray)
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
      aek localaek = aP(paramJSONArray.getJSONObject(i));
      if (localaek != null) {
        localLinkedList.add(localaek);
      }
      i += 1;
    }
    AppMethodBeat.o(113789);
    return localLinkedList;
  }
  
  private static LinkedList<bj> y(JSONArray paramJSONArray)
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
            bj localbj = new bj();
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            localbj.text = localJSONObject.optString("text");
            localbj.url = localJSONObject.optString("url");
            localbj.VcV = localJSONObject.optString("tinyapp_path");
            localbj.VcU = localJSONObject.optString("tinyapp_username");
            localLinkedList.add(localbj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.f
 * JD-Core Version:    0.7.0.1
 */