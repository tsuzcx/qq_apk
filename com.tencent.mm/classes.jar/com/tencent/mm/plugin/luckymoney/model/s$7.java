package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class s$7
  implements ai.a
{
  public s$7(boolean paramBoolean, String paramString) {}
  
  public final int a(d paramd, m paramm)
  {
    AppMethodBeat.i(163576);
    ckc localckc = s.i(paramd);
    String str1 = MMApplicationContext.getContext().getString(a.i.lucky_money_default_wish);
    Object localObject = MMApplicationContext.getContext().getString(a.i.lucky_money_preview_tips);
    String str2 = MMApplicationContext.getContext().getString(a.i.lucky_money_preview_about_text);
    if (this.EAg) {}
    for (str1 = String.format("{\"retcode\":0,\"retmsg\":\"ok\",\"sendId\":\"1000039401201911277000281247819\",\"amount\":888,\"recNum\":1,\"recAmount\":1,\"totalNum\":1,\"totalAmount\":888,\"hasWriteAnswer\":0,\"hbType\":0,\"isSender\":0,\"isContinue\":0,\"receiveStatus\":2,\"hbStatus\":4,\"statusMess\":\"\",\"wishing\":\"%s\",\"receiveId\":\"1000039401000911277000281247819\",\"headTitle\":\"\",\"canShare\":0,\"operationHeader\":[],\"record\":[],\"watermark\":\"\",\"jumpChange\":1,\"changeWording\":\"%s\",\"sendUserName\":\"1@fackuser\",\"changeUrl\":\"weixin:\\/\\/wxpay\\/change\",\"real_name_info\":{\"guide_flag\":0},\"sessionUserName\":\"1@fackuser\",\"jumpChangeType\":1,\"changeIconUrl\":\"\",\"showSourceOpen\":{\"source\":{\"subType\":0,\"sourceObject\":{\"detailImage\":\"\",\"detailImageMd5\":\"\"}, \"detail_link_type\":\"%s\",\"detail_link_appname\":\"%s\",\"detail_link_url\":\"%s\",\"detail_link_title\":\"%s\"},\"operation\":{\"name\":\"%s\",\"type\":\"Text\",\"content\":\"%s\",\"enable\":1,\"iconUrl\":\"\",\"ossKey\":4294967295}},\"expression_md5\":\"%s\",\"expression_type\":0,\"showYearExpression\":1,\"showOpenNormalExpression\":1,\"enableAnswerByExpression\":1,\"enableAnswerBySelfie\":0}", new Object[] { str1, localObject, "0", "", "", "", str2, "", this.EAh });; str1 = String.format("{\"retcode\":0,\"retmsg\":\"ok\",\"sendId\":\"1000039401201911277000281247819\",\"amount\":888,\"recNum\":1,\"recAmount\":1,\"totalNum\":1,\"totalAmount\":888,\"hasWriteAnswer\":0,\"hbType\":0,\"isSender\":0,\"isContinue\":0,\"receiveStatus\":2,\"hbStatus\":4,\"statusMess\":\"\",\"wishing\":\"%s\",\"receiveId\":\"1000039401000911277000281247819\",\"headTitle\":\"\",\"canShare\":0,\"operationHeader\":[],\"record\":[],\"watermark\":\"\",\"jumpChange\":1,\"changeWording\":\"%s\",\"sendUserName\":\"1@fackuser\",\"changeUrl\":\"weixin:\\/\\/wxpay\\/change\",\"real_name_info\":{\"guide_flag\":0},\"sessionUserName\":\"1@fackuser\",\"jumpChangeType\":1,\"changeIconUrl\":\"\",\"showSourceOpen\":{\"source\":{\"subType\":0,\"sourceObject\":{\"detailImage\":\"\",\"detailImageMd5\":\"\"},\"detail_link_type\":\"%s\",\"detail_link_appname\":\"%s\",\"detail_link_url\":\"%s\",\"detail_link_title\":\"%s\"},\"operation\":{\"name\":\"%s\",\"type\":\"Text\",\"content\":\"%s\",\"enable\":1,\"iconUrl\":\"\",\"ossKey\":4294967295}},\"expression_md5\":\"\",\"expression_type\":0,\"showYearExpression\":1,\"showOpenNormalExpression\":1,\"enableAnswerByExpression\":1,\"enableAnswerBySelfie\":0}", new Object[] { str1, localObject, "0", "", "", "", str2, "" }))
    {
      localObject = new eae();
      ((eae)localObject).dc(str1.getBytes());
      localckc.TrG = ((eae)localObject);
      paramm.onGYNetEnd(0, 0, 0, "", paramd, null);
      AppMethodBeat.o(163576);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s.7
 * JD-Core Version:    0.7.0.1
 */