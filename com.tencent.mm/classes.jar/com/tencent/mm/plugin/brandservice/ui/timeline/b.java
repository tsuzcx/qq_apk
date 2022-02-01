package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.s;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizFastRejectTool;", "", "()V", "KEY_MSG_ID", "", "KEY_MSG_RANK", "SCENE_BIZ_REJECT_FAST_REJECT", "", "SCENE_BIZ_REJECT_PROFILE_SET", "SCENE_TYPE_BIZ_SESSION", "SCENE_TYPE_TIME_LINE", "TAG", "TYPE_BIZ_ITEM_NORMAL", "TYPE_BIZ_ITEM_REJECT", "TYPE_BIZ_NEW_MSG_CLICK", "TYPE_BIZ_NEW_MSG_DELETE", "TYPE_BIZ_NEW_MSG_SHOW", "TYPE_BIZ_REJECT_DO_REJECT", "TYPE_BIZ_REJECT_GO_PROFILE", "TYPE_BIZ_REJECT_MSG_SHOW", "TYPE_BIZ_REJECT_TYPE_ALERT", "TYPE_BIZ_REJECT_TYPE_REJECT", "parseAccountInfoFromMap", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/RejectBizAccount;", "values", "", "maxCount", "parseAccountInfoFromXml", "sysXml", "reportBizNewMsgItemAction", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "actionType", "notificationIndexPathRow", "brandTimelineSessionId", "fromScene", "enterId", "", "reportBizReject", "brandUserName", "actionTime", "scene", "sceneNote", "reportFastRejectUiOpen", "enterSourceMsgRank", "clientMsgId", "reportRejectUiOperation", "brandRejectInfo", "brandRejectRank", "brandRejectMsgId", "brandRejectAction", "brandTimeLineSessionId", "brandRejectAccountCount", "plugin-brandservice_release"})
public final class b
{
  public static final b mWx;
  
  static
  {
    AppMethodBeat.i(6535);
    mWx = new b();
    AppMethodBeat.o(6535);
  }
  
  public static void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(6531);
    h.vKh.f(17747, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Long.valueOf(paramLong2) });
    AppMethodBeat.o(6531);
  }
  
  public static void a(s params, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(6533);
    k.h(params, "info");
    long l = System.currentTimeMillis() / 1000L;
    int i;
    if (params.eJP())
    {
      i = 1;
      if (paramInt4 != 2) {
        break label140;
      }
    }
    label140:
    for (paramInt4 = 1;; paramInt4 = 0)
    {
      h.vKh.f(17750, new Object[] { params.field_talker, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(i), Long.valueOf(params.field_msgId), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong) });
      AppMethodBeat.o(6533);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(6534);
    k.h(paramString, "brandUserName");
    h.vKh.f(17748, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(6534);
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(6532);
    k.h(paramString1, "brandUserName");
    k.h(paramString2, "brandRejectInfo");
    long l = System.currentTimeMillis() / 1000L;
    h.vKh.f(17616, new Object[] { paramString1, Long.valueOf(paramLong1), paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(6532);
  }
  
  public static List<a> d(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(6530);
    List localList = (List)new ArrayList();
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      ad.i("MicroMsg.BizFastRejectTool", "parse AccountInfo failed , map is null");
      AppMethodBeat.o(6530);
      return localList;
    }
    if ((String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount.UserName") == null)
    {
      ad.i("MicroMsg.BizFastRejectTool", "no msg in map");
      AppMethodBeat.o(6530);
      return localList;
    }
    Object localObject = new a();
    ((a)localObject).gLg = ((String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount.HeadImgUrl"));
    ((a)localObject).bNK = ((String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount.NickName"));
    ((a)localObject).recommendReason = ((String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount.RecommendReason"));
    ((a)localObject).userName = ((String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount.UserName"));
    localList.add(localObject);
    int i = 1;
    for (;;)
    {
      if (i < paramInt)
      {
        localObject = (String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount" + i + ".UserName");
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(6530);
        return localList;
      }
      a locala = new a();
      locala.userName = ((String)localObject);
      locala.gLg = ((String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount" + i + ".HeadImgUrl"));
      locala.bNK = ((String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount" + i + ".NickName"));
      locala.recommendReason = ((String)paramMap.get(".sysmsg.BizMsgRejectRecommend.BizAccount" + i + ".RecommendReason"));
      localList.add(locala);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b
 * JD-Core Version:    0.7.0.1
 */