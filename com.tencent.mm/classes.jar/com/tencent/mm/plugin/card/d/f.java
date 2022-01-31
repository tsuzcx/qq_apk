package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.protocal.c.bwv;
import com.tencent.mm.protocal.c.cbx;
import com.tencent.mm.protocal.c.jq;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.protocal.c.tx;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static lv G(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      return null;
    }
    locallv = new lv();
    try
    {
      locallv.status = paramJSONObject.optInt("status");
      locallv.sHq = paramJSONObject.optInt("init_balance");
      locallv.sHr = paramJSONObject.optInt("init_bonus");
      Object localObject1 = paramJSONObject.optJSONArray("cell_list0");
      if (localObject1 != null) {
        locallv.sHs = n((JSONArray)localObject1);
      }
      localObject1 = paramJSONObject.optJSONArray("cell_list1");
      if (localObject1 != null) {
        locallv.sHt = n((JSONArray)localObject1);
      }
      localObject1 = paramJSONObject.optJSONArray("cell_list2");
      if (localObject1 != null) {
        locallv.sHu = n((JSONArray)localObject1);
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("acceptors");
      if (localJSONArray != null)
      {
        localObject1 = localObject2;
        if (localJSONArray != null)
        {
          if (localJSONArray.length() != 0) {
            break label440;
          }
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        locallv.sHv = ((LinkedList)localObject1);
        locallv.sHw = paramJSONObject.optInt("avail_num");
        locallv.sHx = paramJSONObject.optInt("code_type");
        locallv.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          locallv.sHy = o((JSONArray)localObject1);
        }
        locallv.sHz = paramJSONObject.optLong("stock_num");
        locallv.sHA = paramJSONObject.optInt("limit_num");
        locallv.sHB = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          locallv.sHC = J((JSONObject)localObject1);
        }
        locallv.sHD = p(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          locallv.sHE = J((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          locallv.sHF = J((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          locallv.sHG = J((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          locallv.sHH = M((JSONObject)localObject1);
        }
        locallv.sHI = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          locallv.sHJ = J((JSONObject)localObject1);
        }
        locallv.sHK = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          locallv.sHL = J((JSONObject)localObject1);
        }
        locallv.sHM = paramJSONObject.optBoolean("is_commom_card");
        locallv.sHN = paramJSONObject.optBoolean("is_location_authorized");
        break;
        label440:
        localObject1 = new LinkedList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          ((LinkedList)localObject1).add((String)localJSONArray.get(i));
          i += 1;
        }
      }
      return locallv;
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
    }
  }
  
  public static mg H(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      return null;
    }
    mg localmg = new mg();
    Object localObject1;
    Object localObject3;
    try
    {
      localmg.iln = paramJSONObject.optString("card_tp_id");
      localmg.ilp = paramJSONObject.optString("logo_url");
      localmg.bOL = paramJSONObject.optString("appid");
      localmg.sIn = paramJSONObject.optString("app_username");
      localmg.sIo = paramJSONObject.optInt("card_category");
      localmg.ilo = paramJSONObject.optInt("card_type");
      localmg.imA = paramJSONObject.optString("brand_name");
      localmg.title = paramJSONObject.optString("title");
      localmg.ilq = paramJSONObject.optString("sub_title");
      localmg.color = paramJSONObject.optString("color");
      localmg.iHC = paramJSONObject.optString("notice");
      localmg.sIp = paramJSONObject.optString("service_phone");
      localmg.sIs = paramJSONObject.optString("image_text_url");
      localmg.sIt = paramJSONObject.optString("source_icon");
      localmg.aWf = paramJSONObject.optString("source");
      localObject1 = paramJSONObject.optJSONArray("primary_fields");
      if (localObject1 != null) {
        localmg.sIq = o((JSONArray)localObject1);
      }
      localObject1 = paramJSONObject.optJSONArray("introduce_fields");
      if (localObject1 != null) {
        localmg.sIr = o((JSONArray)localObject1);
      }
      localmg.sIu = paramJSONObject.optInt("shop_count");
      localmg.sIv = paramJSONObject.optString("limit_wording");
      localmg.imz = paramJSONObject.optString("card_type_name");
      localmg.sIw = paramJSONObject.optString("h5_show_url");
      localmg.sIx = paramJSONObject.optInt("block_mask");
      localmg.sIy = paramJSONObject.optString("middle_icon");
      localmg.sIz = paramJSONObject.optString("accept_wording");
      localmg.sIA = paramJSONObject.optLong("control_flag");
      localmg.sIB = paramJSONObject.optString("advertise_wording");
      localmg.sIC = paramJSONObject.optString("advertise_url");
      localmg.sID = paramJSONObject.optString("public_service_name");
      localObject3 = paramJSONObject.optJSONObject("announcement");
      if (localObject3 == null)
      {
        y.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
      }
      for (;;)
      {
        localmg.sIE = ((ly)localObject1);
        localmg.sIF = paramJSONObject.optString("public_service_tip");
        localmg.sIG = paramJSONObject.optString("primary_sub_title");
        localmg.sIH = paramJSONObject.optInt("gen_type");
        localmg.sII = K(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          break;
        }
        y.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localmg.sIJ = ((cbx)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1169;
        }
        y.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        label509:
        localmg.sIK = ((zi)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1242;
        }
        y.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        label539:
        localmg.sIL = ((ax)localObject1);
        localmg.sIM = paramJSONObject.optInt("need_direct_jump", 0);
        localmg.sIN = paramJSONObject.optInt("is_acceptable", 0);
        localmg.sIO = paramJSONObject.optString("unacceptable_wording");
        localmg.sIP = paramJSONObject.optInt("has_hongbao", 0);
        localmg.sIQ = paramJSONObject.optString("accept_ui_title");
        localmg.sIR = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localmg.sIS = J((JSONObject)localObject1);
        }
        localmg.sIT = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localmg.sIU = J((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1277;
          }
          y.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          label704:
          localmg.sIV = ((up)localObject1);
        }
        localmg.sIW = paramJSONObject.optBoolean("is_card_code_exposed");
        localmg.sIX = paramJSONObject.optInt("qrcode_correct_level");
        localmg.sIY = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localmg.sIZ = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1375;
          }
          y.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          label787:
          localmg.sJa = ((jq)localObject1);
        }
        localmg.sJb = paramJSONObject.optString("biz_nickname");
        localmg.sJc = paramJSONObject.optString("gift_title");
        y.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localmg.sJc });
        break label1430;
        localObject1 = new ly();
        ((ly)localObject1).type = ((JSONObject)localObject3).optInt("type");
        ((ly)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((ly)localObject1).url = ((JSONObject)localObject3).optString("url");
        ((ly)localObject1).nZA = ((JSONObject)localObject3).optInt("endtime");
        ((ly)localObject1).create_time = ((JSONObject)localObject3).optInt("create_time");
        ((ly)localObject1).sHO = ((JSONObject)localObject3).optString("thumb_url");
      }
      localObject1 = new cbx();
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
    }
    ((cbx)localObject1).title = ((JSONObject)localObject3).optString("title");
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
    int i;
    label995:
    bwv localbwv;
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((cbx)localObject1).tQZ = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        localbwv = L(localJSONArray.optJSONObject(i));
        if (localbwv == null) {
          break label1433;
        }
        ((cbx)localObject1).tQZ.add(localbwv);
        break label1433;
      }
    }
    else
    {
      y.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    }
    localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((cbx)localObject1).tRa = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localbwv = L(localJSONArray.optJSONObject(i));
        if (localbwv != null)
        {
          ((cbx)localObject1).tRa.add(localbwv);
          break label1440;
          y.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((cbx)localObject1).tRb = o((JSONArray)localObject3);
          break;
        }
        y.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1169:
        localObject1 = new zi();
        ((zi)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((zi)localObject1).sYH = ((JSONObject)localObject3).optInt("follow");
        y.i("MicroMsg.CardInfoParser", "follow:" + ((zi)localObject1).sYH + "　text:" + ((zi)localObject1).text);
        break label509;
        label1242:
        localObject1 = new ax();
        ((ax)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((ax)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label539;
        label1277:
        localObject1 = new up();
        ((up)localObject1).sRk = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((up)localObject1).sRl = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((up)localObject1).sRm = ((JSONObject)localObject3).optString("refresh_wording");
        y.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((up)localObject1).sRk + "　can_refresh:" + ((up)localObject1).sRl + "　refresh_wording:" + ((up)localObject1).sRm);
        break label704;
        label1375:
        localObject1 = new jq();
        ((jq)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((jq)localObject1).sEq = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        y.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((jq)localObject1).name });
        break label787;
        label1430:
        return localmg;
        label1433:
        i += 1;
        break label995;
      }
      label1440:
      i += 1;
    }
  }
  
  private static bru I(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      return null;
    }
    bru localbru = new bru();
    localbru.tIn = paramJSONObject.optString("gift_msg_title");
    return localbru;
  }
  
  private static ra J(JSONObject paramJSONObject)
  {
    anr localanr = null;
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      return null;
    }
    ra localra = new ra();
    localra.title = paramJSONObject.optString("title");
    localra.ilr = paramJSONObject.optString("aux_title");
    localra.ilq = paramJSONObject.optString("sub_title");
    localra.url = paramJSONObject.optString("url");
    localra.sJq = paramJSONObject.optLong("show_flag");
    localra.sJr = paramJSONObject.optString("primary_color");
    localra.sJs = paramJSONObject.optString("secondary_color");
    localra.iQn = paramJSONObject.optString("icon_url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null)
    {
      if (localJSONObject != null) {
        break label165;
      }
      y.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
    }
    for (;;)
    {
      localra.sOH = localanr;
      localra.sIf = paramJSONObject.optString("app_brand_user_name");
      localra.sIg = paramJSONObject.optString("app_brand_pass");
      return localra;
      label165:
      y.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { localJSONObject });
      localanr = new anr();
      localanr.sth = o.bS(localJSONObject.optString("biz_uin"));
      localanr.sti = localJSONObject.optString("order_id");
    }
  }
  
  private static tw K(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      return null;
    }
    tw localtw = new tw();
    localtw.title = paramJSONObject.optString("title");
    localtw.url = paramJSONObject.optString("url");
    localtw.desc = paramJSONObject.optString("abstract");
    localtw.detail = paramJSONObject.optString("detail");
    localtw.sQJ = paramJSONObject.optString("ad_title");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("icon_url_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      for (;;)
      {
        if (i >= localJSONArray.length()) {
          break label186;
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
            y.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            y.e("MicroMsg.CardInfoParser", "getMessage:" + localJSONException.getMessage());
          }
        }
        localLinkedList.add(paramJSONObject);
        i += 1;
      }
      label186:
      localtw.sQI = localLinkedList;
    }
    for (;;)
    {
      return localtw;
      y.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static bwv L(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      return null;
    }
    bwv localbwv = new bwv();
    localbwv.tag = paramJSONObject.optString("tag");
    localbwv.color = paramJSONObject.optString("color");
    return localbwv;
  }
  
  private static tx M(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      return null;
    }
    tx localtx = new tx();
    localtx.title = paramJSONObject.optString("title");
    localtx.ilq = paramJSONObject.optString("sub_title");
    localtx.sQK = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      try
      {
        localtx.sQL = o(paramJSONObject);
        return localtx;
      }
      catch (JSONException paramJSONObject)
      {
        y.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        y.e("MicroMsg.CardInfoParser", paramJSONObject.getMessage());
        return localtx;
      }
    }
    y.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
    return localtx;
  }
  
  public static void a(CardInfo paramCardInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
      return;
    }
    try
    {
      a(paramCardInfo, new JSONObject(paramString));
      return;
    }
    catch (JSONException paramCardInfo)
    {
      y.printErrStackTrace("MicroMsg.CardInfoParser", paramCardInfo, "", new Object[0]);
    }
  }
  
  private static void a(CardInfo paramCardInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
      return;
    }
    paramCardInfo.field_card_id = yL(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = yL(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.ils = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.imt = G(localJSONObject2);
    paramCardInfo.ims = H(localJSONObject1);
    paramCardInfo.imu = I(paramJSONObject);
    if (paramCardInfo.ims != null)
    {
      paramJSONObject = paramCardInfo.ims;
      paramCardInfo.ims = paramJSONObject;
      if (paramJSONObject == null) {}
    }
    try
    {
      paramCardInfo.field_cardTpInfoData = paramJSONObject.toByteArray();
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.ims.sIx);
      paramCardInfo.field_card_type = paramCardInfo.ims.ilo;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.ims.iln;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject1 != null)) {
        paramCardInfo.field_begin_time = localJSONObject1.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject1 != null)) {
        paramCardInfo.field_end_time = localJSONObject1.optLong("end_time");
      }
      if (paramCardInfo.ims.sIV != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.ims.sIV.sRk;
      }
      if (paramCardInfo.imt != null)
      {
        paramCardInfo.a(paramCardInfo.imt);
        paramCardInfo.field_status = paramCardInfo.imt.status;
      }
      if (paramCardInfo.imu != null)
      {
        paramJSONObject = paramCardInfo.imu;
        paramCardInfo.imu = paramJSONObject;
        if (paramJSONObject == null) {}
      }
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        paramCardInfo.field_shareInfoData = paramJSONObject.toByteArray();
        paramCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
        return;
        paramJSONObject = paramJSONObject;
        y.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramJSONObject.getMessage() });
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          y.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramJSONObject.getMessage() });
          y.printErrStackTrace("MicroMsg.CardInfo", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
      return;
    }
    try
    {
      a(paramShareCardInfo, new JSONObject(paramString).optJSONObject("share_card"));
      return;
    }
    catch (JSONException paramShareCardInfo)
    {
      y.printErrStackTrace("MicroMsg.CardInfoParser", paramShareCardInfo, "", new Object[0]);
      y.e("MicroMsg.CardInfoParser", paramShareCardInfo.getMessage());
    }
  }
  
  public static void a(ShareCardInfo paramShareCardInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
      return;
    }
    paramShareCardInfo.field_card_id = yL(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = yL(paramJSONObject.optString("card_tp_id"));
    paramShareCardInfo.field_app_id = paramJSONObject.optString("app_id");
    paramShareCardInfo.field_consumer = paramJSONObject.optString("consumer");
    paramShareCardInfo.field_share_time = paramJSONObject.optInt("share_time");
    paramShareCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramShareCardInfo.field_status = paramJSONObject.optInt("state_flag");
    paramShareCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramShareCardInfo.field_from_username = paramJSONObject.optString("from_user_name");
    paramShareCardInfo.field_begin_time = paramJSONObject.optLong("begin_time");
    paramShareCardInfo.field_end_time = paramJSONObject.optInt("end_time");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramShareCardInfo.imt = G(localJSONObject2);
    paramShareCardInfo.ims = H(localJSONObject1);
    paramShareCardInfo.imu = I(paramJSONObject);
    if (paramShareCardInfo.imt != null) {
      paramShareCardInfo.a(paramShareCardInfo.imt);
    }
    if (paramShareCardInfo.ims != null)
    {
      paramJSONObject = paramShareCardInfo.ims;
      paramShareCardInfo.ims = paramJSONObject;
    }
    try
    {
      paramShareCardInfo.field_cardTpInfoData = paramJSONObject.toByteArray();
      paramShareCardInfo.field_end_time = localJSONObject1.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject1.optInt("begin_time");
      if (paramShareCardInfo.imu != null)
      {
        paramJSONObject = paramShareCardInfo.imu;
        paramShareCardInfo.imu = paramJSONObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        paramShareCardInfo.field_shareInfoData = paramJSONObject.toByteArray();
        paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
        return;
        paramJSONObject = paramJSONObject;
        y.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramJSONObject.getMessage() });
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          y.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramJSONObject.getMessage() });
          y.printErrStackTrace("MicroMsg.ShareCardInfo", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
  
  private static LinkedList<mn> n(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      mn localmn = new mn();
      localmn.title = localJSONObject.optString("title");
      localmn.ilq = localJSONObject.optString("sub_title");
      localmn.ioU = localJSONObject.optString("tips");
      localmn.url = localJSONObject.optString("url");
      localmn.sJq = localJSONObject.optLong("show_flag");
      localmn.sJr = localJSONObject.optString("primary_color");
      localmn.sJs = localJSONObject.optString("secondary_color");
      localmn.iQn = localJSONObject.optString("icon_url");
      localmn.sIf = localJSONObject.optString("app_brand_user_name");
      localmn.sIg = localJSONObject.optString("app_brand_pass");
      localLinkedList.add(localmn);
      i += 1;
    }
    return localLinkedList;
  }
  
  private static LinkedList<ra> o(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      ra localra = J(paramJSONArray.getJSONObject(i));
      if (localra != null) {
        localLinkedList.add(localra);
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  private static LinkedList<ax> p(JSONArray paramJSONArray)
  {
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
              y.printErrStackTrace("MicroMsg.CardInfoParser", localJSONException, "", new Object[0]);
            }
          }
        }
      }
    }
    return localLinkedList;
  }
  
  public static ArrayList<ShareCardInfo> yJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        y.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
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
    return localArrayList;
  }
  
  public static ArrayList<CardInfo> yK(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_array");
      if ((paramString == null) || (paramString.length() == 0))
      {
        y.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
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
    return localArrayList;
  }
  
  private static String yL(String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!"null".equals(paramString)) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.f
 * JD-Core Version:    0.7.0.1
 */