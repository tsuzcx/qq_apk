package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice$Companion;", "", "()V", "LIVE_STATE_DEFAULT", "", "LIVE_STATE_FINISHED", "LIVE_STATE_PREPARE", "LIVE_STATE_STARTED", "SUPPORT_SCREEN_ROTATION", "UI_STATE_ANCHOR_EXIT", "UI_STATE_ANCHOR_PAUSE", "UI_STATE_ANCHOR_POST", "UI_STATE_ANCHOR_STATUS_EXCEPTION", "UI_STATE_CAMERA_OPT", "UI_STATE_COMMENT", "UI_STATE_DEFAULT", "UI_STATE_DISCONNECTION", "UI_STATE_DISPLAY_LINK_APPLY_LISENCE", "UI_STATE_DISPLAY_LINK_APPLY_LIST", "UI_STATE_EXPLAIN_WECOIN_HOT", "UI_STATE_GIFT", "UI_STATE_KICKED", "UI_STATE_MEMBER_LIST", "UI_STATE_MINI_WINDOW_PERMISSION", "UI_STATE_MORE_ACTION", "UI_STATE_NORMAL", "UI_STATE_OVERLOAD", "UI_STATE_PRIVATE_PERMISSION", "UI_STATE_REAL_NAME_COMMENT", "UI_STATE_RECONNECTING", "UI_STATE_SHOPPING_PANEL", "getBadgeListStr", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "printBadgeList", "", "prefix", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$b
{
  public static String gW(List<? extends bfl> paramList)
  {
    AppMethodBeat.i(356682);
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(356682);
      return "";
    }
    localObject = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      bfl localbfl = (bfl)paramList.next();
      ((StringBuilder)localObject).append("[" + f.dg(localbfl) + ']');
    }
    paramList = ((StringBuilder)localObject).toString();
    s.s(paramList, "badgeList.toString()");
    AppMethodBeat.o(356682);
    return paramList;
  }
  
  public static void n(List<? extends bfl> paramList, String paramString)
  {
    AppMethodBeat.i(356673);
    s.u(paramString, "prefix");
    Log.i("BadgeInfoList", paramString + ':' + gW(paramList));
    AppMethodBeat.o(356673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.b
 * JD-Core Version:    0.7.0.1
 */