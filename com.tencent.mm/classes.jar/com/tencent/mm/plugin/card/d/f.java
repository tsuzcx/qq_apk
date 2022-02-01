package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.protocal.protobuf.vj;
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
    paramCardInfo.field_card_id = ajY(paramJSONObject.optString("card_id"));
    paramCardInfo.field_card_tp_id = ajY(paramJSONObject.optString("card_tp_id"));
    paramCardInfo.field_delete_state_flag = paramJSONObject.optInt("state_flag");
    paramCardInfo.field_updateTime = paramJSONObject.optInt("update_time");
    paramCardInfo.field_updateSeq = paramJSONObject.optLong("sequence");
    paramCardInfo.field_from_username = paramJSONObject.optString("from_username");
    paramCardInfo.field_begin_time = paramJSONObject.optLong("begin_time", 0L);
    paramCardInfo.field_end_time = paramJSONObject.optLong("end_time", 0L);
    paramCardInfo.pSa = paramJSONObject.optString("encrypt_code");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("card_data_info");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_tp_info");
    paramJSONObject = paramJSONObject.optJSONObject("share_info");
    paramCardInfo.pTi = ax(localJSONObject1);
    paramCardInfo.pTh = ay(localJSONObject2);
    paramCardInfo.pTj = az(paramJSONObject);
    if (paramCardInfo.pTh != null)
    {
      paramCardInfo.a(paramCardInfo.pTh);
      paramCardInfo.field_block_mask = Integer.toString(paramCardInfo.pTh.LeH);
      paramCardInfo.field_card_type = paramCardInfo.pTh.nHh;
      if (TextUtils.isEmpty(paramCardInfo.field_card_tp_id)) {
        paramCardInfo.field_card_tp_id = paramCardInfo.pTh.pRX;
      }
      if ((paramCardInfo.field_begin_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_begin_time = localJSONObject2.optLong("begin_time");
      }
      if ((paramCardInfo.field_end_time == 0L) && (localJSONObject2 != null)) {
        paramCardInfo.field_end_time = localJSONObject2.optLong("end_time");
      }
      if (paramCardInfo.pTh.Lff != null) {
        paramCardInfo.field_is_dynamic = paramCardInfo.pTh.Lff.LrL;
      }
    }
    if (paramCardInfo.pTi != null)
    {
      paramCardInfo.a(paramCardInfo.pTi);
      paramCardInfo.field_status = paramCardInfo.pTi.status;
    }
    if (paramCardInfo.pTj != null) {
      paramCardInfo.a(paramCardInfo.pTj);
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
    paramShareCardInfo.field_card_id = ajY(paramJSONObject.optString("card_id"));
    paramShareCardInfo.field_card_tp_id = ajY(paramJSONObject.optString("card_tp_id"));
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
    paramShareCardInfo.pTi = ax(localJSONObject1);
    paramShareCardInfo.pTh = ay(localJSONObject2);
    paramShareCardInfo.pTj = az(paramJSONObject);
    if (paramShareCardInfo.pTi != null) {
      paramShareCardInfo.a(paramShareCardInfo.pTi);
    }
    if (paramShareCardInfo.pTh != null)
    {
      paramShareCardInfo.a(paramShareCardInfo.pTh);
      paramShareCardInfo.field_end_time = localJSONObject2.optInt("end_time");
      paramShareCardInfo.field_begin_time = localJSONObject2.optInt("begin_time");
    }
    if (paramShareCardInfo.pTj != null) {
      paramShareCardInfo.a(paramShareCardInfo.pTj);
    }
    paramShareCardInfo.field_local_updateTime = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(113781);
  }
  
  private static abz aA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113792);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
      AppMethodBeat.o(113792);
      return null;
    }
    abz localabz = new abz();
    localabz.title = paramJSONObject.optString("title");
    localabz.pRZ = paramJSONObject.optString("aux_title");
    localabz.pRY = paramJSONObject.optString("sub_title");
    localabz.url = paramJSONObject.optString("url");
    localabz.LfD = paramJSONObject.optLong("show_flag");
    localabz.LfE = paramJSONObject.optString("primary_color");
    localabz.LfF = paramJSONObject.optString("secondary_color");
    localabz.qGB = paramJSONObject.optString("icon_url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("gifting_info");
    if (localJSONObject != null) {
      localabz.LmB = aB(localJSONObject);
    }
    localabz.Leo = paramJSONObject.optString("app_brand_user_name");
    localabz.Lep = paramJSONObject.optString("app_brand_pass");
    AppMethodBeat.o(113792);
    return localabz;
  }
  
  private static bzq aB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113793);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
      AppMethodBeat.o(113793);
      return null;
    }
    Log.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[] { paramJSONObject });
    bzq localbzq = new bzq();
    localbzq.KDl = p.fd(paramJSONObject.optString("biz_uin"));
    localbzq.KDm = paramJSONObject.optString("order_id");
    AppMethodBeat.o(113793);
    return localbzq;
  }
  
  private static agy aC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113794);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
      AppMethodBeat.o(113794);
      return null;
    }
    agy localagy = new agy();
    localagy.title = paramJSONObject.optString("title");
    localagy.url = paramJSONObject.optString("url");
    localagy.desc = paramJSONObject.optString("abstract");
    localagy.detail = paramJSONObject.optString("detail");
    localagy.LqC = paramJSONObject.optString("ad_title");
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
      localagy.LqB = localLinkedList;
    }
    for (;;)
    {
      AppMethodBeat.o(113794);
      return localagy;
      Log.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
    }
  }
  
  private static egi aD(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113795);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
      AppMethodBeat.o(113795);
      return null;
    }
    egi localegi = new egi();
    localegi.tag = paramJSONObject.optString("tag");
    localegi.ixw = paramJSONObject.optString("color");
    AppMethodBeat.o(113795);
    return localegi;
  }
  
  private static agz aE(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113796);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
      AppMethodBeat.o(113796);
      return null;
    }
    agz localagz = new agz();
    localagz.title = paramJSONObject.optString("title");
    localagz.pRY = paramJSONObject.optString("sub_title");
    localagz.LqD = paramJSONObject.optInt("show_num", 0);
    paramJSONObject = paramJSONObject.optJSONArray("rows");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
    for (;;)
    {
      try
      {
        localagz.LqE = u(paramJSONObject);
        AppMethodBeat.o(113796);
        return localagz;
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
  
  public static ArrayList<ShareCardInfo> ajW(String paramString)
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
  
  public static ArrayList<CardInfo> ajX(String paramString)
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
  
  private static String ajY(String paramString)
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
  
  private static ty ax(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113786);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
      AppMethodBeat.o(113786);
      return null;
    }
    ty localty = new ty();
    for (;;)
    {
      try
      {
        localty.status = paramJSONObject.optInt("status");
        localty.Lck = paramJSONObject.optInt("init_balance");
        localty.Lcl = paramJSONObject.optInt("init_bonus");
        localObject1 = paramJSONObject.optJSONArray("cell_list0");
        if (localObject1 != null) {
          localty.Lcm = t((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list1");
        if (localObject1 != null) {
          localty.Lcn = t((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("cell_list2");
        if (localObject1 != null) {
          localty.Lco = t((JSONArray)localObject1);
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
          localty.Lcp = ((LinkedList)localObject1);
        }
        localty.Lcq = paramJSONObject.optInt("avail_num");
        localty.Lcr = paramJSONObject.optInt("code_type");
        localty.code = paramJSONObject.optString("code");
        localObject1 = paramJSONObject.optJSONArray("secondary_fields");
        if (localObject1 != null) {
          localty.Lcs = u((JSONArray)localObject1);
        }
        localty.Lct = paramJSONObject.optLong("stock_num");
        localty.Lcu = paramJSONObject.optInt("limit_num");
        localty.Lcv = paramJSONObject.optString("user_report_url");
        localObject1 = paramJSONObject.optJSONObject("third_field");
        if (localObject1 != null) {
          localty.Lcw = aA((JSONObject)localObject1);
        }
        localty.Lcx = v(paramJSONObject.optJSONArray("action_sheets"));
        localObject1 = paramJSONObject.optJSONObject("card_list_field");
        if (localObject1 != null) {
          localty.Lcy = aA((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("operate_field");
        if (localObject1 != null) {
          localty.Lcz = aA((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("limit_field");
        if (localObject1 != null) {
          localty.LcA = aA((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONObject("detail_table");
        if (localObject1 != null) {
          localty.LcB = aE((JSONObject)localObject1);
        }
        localty.LcC = paramJSONObject.optString("background_pic_url");
        localObject1 = paramJSONObject.optJSONObject("gifting_info_cell");
        if (localObject1 != null) {
          localty.LcD = aA((JSONObject)localObject1);
        }
        localty.LcE = paramJSONObject.optString("sign_number");
        localObject1 = paramJSONObject.optJSONObject("unavailable_qrcode_field");
        if (localObject1 != null) {
          localty.LcF = aA((JSONObject)localObject1);
        }
        localty.LcG = paramJSONObject.optBoolean("is_commom_card");
        localty.LcH = paramJSONObject.optBoolean("is_location_authorized");
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
      return localty;
      localObject1 = new LinkedList();
      i = 0;
      if (i < localJSONArray.length())
      {
        ((LinkedList)localObject1).add((String)localJSONArray.get(i));
        i += 1;
      }
    }
  }
  
  public static uz ay(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(113788);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
      AppMethodBeat.o(113788);
      return null;
    }
    uz localuz = new uz();
    Object localObject1;
    Object localObject3;
    label525:
    label555:
    label720:
    int i;
    label803:
    label1017:
    egi localegi;
    for (;;)
    {
      try
      {
        localuz.pRX = paramJSONObject.optString("card_tp_id");
        localuz.iwv = paramJSONObject.optString("logo_url");
        localuz.dNI = paramJSONObject.optString("appid");
        localuz.KZR = paramJSONObject.optString("app_username");
        localuz.LeA = paramJSONObject.optInt("card_category");
        localuz.nHh = paramJSONObject.optInt("card_type");
        localuz.gTG = paramJSONObject.optString("brand_name");
        localuz.title = paramJSONObject.optString("title");
        localuz.pRY = paramJSONObject.optString("sub_title");
        localuz.ixw = paramJSONObject.optString("color");
        localuz.jTx = paramJSONObject.optString("notice");
        localuz.LeB = paramJSONObject.optString("service_phone");
        localuz.LeE = paramJSONObject.optString("image_text_url");
        localuz.Gam = paramJSONObject.optString("source_icon");
        localuz.source = paramJSONObject.optString("source");
        localObject1 = paramJSONObject.optJSONArray("primary_fields");
        if (localObject1 != null) {
          localuz.LeC = u((JSONArray)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("introduce_fields");
        if (localObject1 != null) {
          localuz.LeD = u((JSONArray)localObject1);
        }
        localuz.LeF = paramJSONObject.optInt("shop_count");
        localuz.lHL = paramJSONObject.optString("limit_wording");
        localuz.pTn = paramJSONObject.optString("card_type_name");
        localuz.LeG = paramJSONObject.optString("h5_show_url");
        localuz.LeH = paramJSONObject.optInt("block_mask");
        localuz.LeI = paramJSONObject.optString("middle_icon");
        localuz.LeJ = paramJSONObject.optString("accept_wording");
        localuz.LeK = paramJSONObject.optLong("control_flag");
        localuz.LeL = paramJSONObject.optString("advertise_wording");
        localuz.LeM = paramJSONObject.optString("advertise_url");
        localuz.LeN = paramJSONObject.optString("public_service_name");
        localObject3 = paramJSONObject.optJSONObject("announcement");
        if (localObject3 != null) {
          continue;
        }
        Log.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
        localObject1 = null;
        localuz.LeO = ((uo)localObject1);
        localuz.LeP = paramJSONObject.optString("public_service_tip");
        localuz.LeQ = paramJSONObject.optString("primary_sub_title");
        localuz.LeR = paramJSONObject.optInt("gen_type");
        localuz.LeS = aC(paramJSONObject.optJSONObject("detail_struct"));
        localObject3 = paramJSONObject.optJSONObject("use_condition");
        if (localObject3 != null) {
          continue;
        }
        Log.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
        localObject1 = null;
        localuz.LeT = ((eol)localObject1);
        localObject3 = paramJSONObject.optJSONObject("follow_box");
        if (localObject3 != null) {
          break label1191;
        }
        Log.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
        localObject1 = null;
        localuz.LeU = ((bet)localObject1);
        localObject3 = paramJSONObject.optJSONObject("guidance");
        if (localObject3 != null) {
          break label1264;
        }
        Log.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
        localObject1 = null;
        localuz.LeV = ((bg)localObject1);
        localuz.LeW = paramJSONObject.optInt("need_direct_jump", 0);
        localuz.LeX = paramJSONObject.optInt("is_acceptable", 0);
        localuz.LeY = paramJSONObject.optString("unacceptable_wording");
        localuz.LeZ = paramJSONObject.optInt("has_hongbao", 0);
        localuz.Lfa = paramJSONObject.optString("accept_ui_title");
        localuz.Lfb = paramJSONObject.optInt("show_accept_view", 0);
        localObject1 = paramJSONObject.optJSONObject("brand_field");
        if (localObject1 != null) {
          localuz.Lfc = aA((JSONObject)localObject1);
        }
        localuz.Lfd = paramJSONObject.optString("shop_name");
        localObject1 = paramJSONObject.optJSONObject("pay_and_qrcode_field");
        if (localObject1 != null) {
          localuz.Lfe = aA((JSONObject)localObject1);
        }
        localObject3 = paramJSONObject.optJSONObject("dynamic_qr_code_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1299;
          }
          Log.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
          localObject1 = null;
          localuz.Lff = ((aie)localObject1);
        }
        localuz.Lfg = paramJSONObject.optBoolean("is_card_code_exposed");
        localuz.Lfh = paramJSONObject.optInt("qrcode_correct_level");
        localuz.Lfi = paramJSONObject.optBoolean("dismiss_qrcode_icon_on_card");
        localuz.Lfj = paramJSONObject.optBoolean("need_location");
        localObject3 = paramJSONObject.optJSONObject("bluetooth_info");
        if (localObject3 != null)
        {
          if (localObject3 != null) {
            break label1397;
          }
          Log.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
          localObject1 = localObject2;
          localuz.Lfk = ((qr)localObject1);
        }
        localuz.KUD = paramJSONObject.optString("biz_nickname");
        localuz.Lfl = paramJSONObject.optString("gift_title");
        Log.d("MicroMsg.CardInfoParser", "parse gift title: %s", new Object[] { localuz.Lfl });
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.CardInfoParser", paramJSONObject, "", new Object[0]);
        continue;
        localObject1 = new eol();
        ((eol)localObject1).title = ((JSONObject)localObject3).optString("title");
        localJSONArray = ((JSONObject)localObject3).optJSONArray("outer_tag_list");
        if (localJSONArray == null) {
          break;
        }
      }
      AppMethodBeat.o(113788);
      return localuz;
      localObject1 = new uo();
      ((uo)localObject1).type = ((JSONObject)localObject3).optInt("type");
      ((uo)localObject1).text = ((JSONObject)localObject3).optString("text");
      ((uo)localObject1).url = ((JSONObject)localObject3).optString("url");
      ((uo)localObject1).DhD = ((JSONObject)localObject3).optInt("endtime");
      ((uo)localObject1).Gaz = ((JSONObject)localObject3).optInt("create_time");
      ((uo)localObject1).gTB = ((JSONObject)localObject3).optString("thumb_url");
      continue;
      if (localJSONArray.length() > 0)
      {
        ((eol)localObject1).Nmk = new LinkedList();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label1063;
        }
        localegi = aD(localJSONArray.optJSONObject(i));
        if (localegi == null) {
          break label1452;
        }
        ((eol)localObject1).Nmk.add(localegi);
        break label1452;
      }
    }
    Log.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
    label1063:
    JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("inner_tag_list");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ((eol)localObject1).Nml = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        localegi = aD(localJSONArray.optJSONObject(i));
        if (localegi != null)
        {
          ((eol)localObject1).Nml.add(localegi);
          break label1459;
          Log.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
        }
      }
      else
      {
        localObject3 = ((JSONObject)localObject3).optJSONArray("detail_field");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          ((eol)localObject1).Nmm = u((JSONArray)localObject3);
          break;
        }
        Log.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
        break;
        label1191:
        localObject1 = new bet();
        ((bet)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((bet)localObject1).LOA = ((JSONObject)localObject3).optInt("follow");
        Log.i("MicroMsg.CardInfoParser", "follow:" + ((bet)localObject1).LOA + "　text:" + ((bet)localObject1).text);
        break label525;
        label1264:
        localObject1 = new bg();
        ((bg)localObject1).text = ((JSONObject)localObject3).optString("text");
        ((bg)localObject1).url = ((JSONObject)localObject3).optString("url");
        break label555;
        label1299:
        localObject1 = new aie();
        ((aie)localObject1).LrL = ((JSONObject)localObject3).optBoolean("is_dynamic");
        ((aie)localObject1).LrM = ((JSONObject)localObject3).optBoolean("can_refresh");
        ((aie)localObject1).LrN = ((JSONObject)localObject3).optString("refresh_wording");
        Log.i("MicroMsg.CardInfoParser", "is_dynamic:" + ((aie)localObject1).LrL + "　can_refresh:" + ((aie)localObject1).LrM + "　refresh_wording:" + ((aie)localObject1).LrN);
        break label720;
        label1397:
        localObject1 = new qr();
        ((qr)localObject1).name = ((JSONObject)localObject3).optString("name");
        ((qr)localObject1).KXx = ((JSONObject)localObject3).optInt("report_time_interval", 0);
        Log.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[] { ((qr)localObject1).name });
        break label803;
        label1452:
        i += 1;
        break label1017;
      }
      label1459:
      i += 1;
    }
  }
  
  private static dxr az(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113790);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
      AppMethodBeat.o(113790);
      return null;
    }
    dxr localdxr = new dxr();
    localdxr.MXq = paramJSONObject.optString("gift_msg_title");
    AppMethodBeat.o(113790);
    return localdxr;
  }
  
  private static LinkedList<vj> t(JSONArray paramJSONArray)
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
      vj localvj = new vj();
      localvj.title = localJSONObject.optString("title");
      localvj.pRY = localJSONObject.optString("sub_title");
      localvj.pWf = localJSONObject.optString("tips");
      localvj.url = localJSONObject.optString("url");
      localvj.LfD = localJSONObject.optLong("show_flag");
      localvj.LfE = localJSONObject.optString("primary_color");
      localvj.LfF = localJSONObject.optString("secondary_color");
      localvj.qGB = localJSONObject.optString("icon_url");
      localvj.Leo = localJSONObject.optString("app_brand_user_name");
      localvj.Lep = localJSONObject.optString("app_brand_pass");
      localLinkedList.add(localvj);
      i += 1;
    }
    AppMethodBeat.o(113787);
    return localLinkedList;
  }
  
  private static LinkedList<abz> u(JSONArray paramJSONArray)
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
      abz localabz = aA(paramJSONArray.getJSONObject(i));
      if (localabz != null) {
        localLinkedList.add(localabz);
      }
      i += 1;
    }
    AppMethodBeat.o(113789);
    return localLinkedList;
  }
  
  private static LinkedList<bg> v(JSONArray paramJSONArray)
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
            bg localbg = new bg();
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            localbg.text = localJSONObject.optString("text");
            localbg.url = localJSONObject.optString("url");
            localLinkedList.add(localbg);
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