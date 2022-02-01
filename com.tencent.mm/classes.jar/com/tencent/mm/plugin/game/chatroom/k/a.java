package com.tencent.mm.plugin.game.chatroom.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.chatroom.d.c;
import com.tencent.mm.plugin.game.protobuf.k;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/utils/ChatroomMentionUtils;", "", "()V", "AT_ALL_USERNAME", "", "AT_REPORT_POSITION_ADMIN", "", "AT_REPORT_POSITION_AT_ALL", "AT_REPORT_POSITION_OTHER", "AT_REPORT_POSITION_RECENTLY", "AT_REPORT_POSITION_ROBOT", "AT_REPORT_POSITION_SEARCH", "", "AT_REPORT_POSITION_SEARCH_RESULT", "CHATROOM_AT_ALL_TIME_IN_DB", "TAG", "getAtAllInfo", "Lkotlin/Pair;", "", "chatroomName", "mapListForReport", "", "Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserWrapper;", "list", "saveAtAllTime", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Iod;
  
  static
  {
    AppMethodBeat.i(275742);
    Iod = new a();
    AppMethodBeat.o(275742);
  }
  
  public static final void aFF(String paramString)
  {
    AppMethodBeat.i(275708);
    s.u(paramString, "chatroomName");
    long l = System.currentTimeMillis();
    ((g)h.ax(g.class)).w(s.X(paramString, "atAllTime"), d.rC(l));
    AppMethodBeat.o(275708);
  }
  
  public static kotlin.r<Boolean, String> aFG(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(275723);
    s.u(paramString, "chatroomName");
    Object localObject = s.X(paramString, "atAllTime");
    localObject = ((g)h.ax(g.class)).aFm((String)localObject);
    if (localObject != null)
    {
      long l2 = System.currentTimeMillis();
      long l1 = d.bW((byte[])localObject);
      l2 = (l2 - l1) / 1000L;
      localObject = com.tencent.mm.plugin.game.commlib.a.fDY();
      int i;
      if (localObject == null) {
        i = 0;
      }
      for (;;)
      {
        Log.i("ChatroomMentionUtils.ChatroomMemberPreloadManager", "preload  chatroomName = " + paramString + " lastAtAllTime = " + l1 + "   diffSeconds = " + l2 + " 秒  atAllFreq =" + i + ' ');
        if (l2 >= i) {
          j = 1;
        }
        if (j == 0) {
          break;
        }
        paramString = new kotlin.r(Boolean.TRUE, null);
        AppMethodBeat.o(275723);
        return paramString;
        localObject = ((com.tencent.mm.plugin.game.protobuf.r)localObject).IHT;
        if (localObject == null) {
          i = 0;
        } else {
          i = ((k)localObject).IHu;
        }
      }
      l1 = i - l2;
      if (l1 / 3600L > 0L) {
        paramString = l1 / 3600L + "小时后可再次使用";
      }
      for (;;)
      {
        paramString = new kotlin.r(Boolean.FALSE, paramString);
        AppMethodBeat.o(275723);
        return paramString;
        if (l1 / 60L > 0L) {
          paramString = l1 / 60L + "分钟后可再次使用";
        } else if (l1 / 60L > 0L) {
          paramString = l1 / 60L + "秒后可再次使用";
        } else {
          paramString = "";
        }
      }
    }
    paramString = new kotlin.r(Boolean.TRUE, null);
    AppMethodBeat.o(275723);
    return paramString;
  }
  
  public static List<c> ik(List<c> paramList)
  {
    AppMethodBeat.i(275736);
    s.u(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    while (paramList.hasNext())
    {
      c localc = (c)paramList.next();
      Object localObject = (CharSequence)localc.Ikl.nickName;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        label90:
        if (i != 0) {
          continue;
        }
        switch (localc.mkb)
        {
        default: 
          i = localc.mkb;
        }
      }
      for (;;)
      {
        localObject = localc.Ikk;
        com.tencent.mm.plugin.game.chatroom.d.d locald = localc.Ikl;
        boolean bool = localc.FYI;
        s.u(localObject, "topTip");
        s.u(locald, "user");
        localArrayList.add(new c((kotlin.r)localObject, locald, bool, i));
        break;
        i = 0;
        break label90;
        i = j + 701;
        j += 1;
        continue;
        i = k + 101;
        k += 1;
        continue;
        i = m + 201;
        m += 1;
        continue;
        i = n + 1;
        n += 1;
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(275736);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.k.a
 * JD-Core Version:    0.7.0.1
 */