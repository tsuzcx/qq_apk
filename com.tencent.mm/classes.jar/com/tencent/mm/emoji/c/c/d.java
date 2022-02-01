package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestIDKey;", "", "()V", "id", "", "getRemoteStart", "", "getRemoteSuccess", "hasPersonalWords", "hasRemoteCache", "hasRemoteShuffle", "config", "", "localResultTooMuch", "report", "key", "", "reportMatch", "local", "remote", "reportResult", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "reportSearchSlow", "reportStart", "resultTooMuch", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d mjQ;
  
  static
  {
    AppMethodBeat.i(242693);
    mjQ = new d();
    AppMethodBeat.o(242693);
  }
  
  public static void by(List<l> paramList)
  {
    AppMethodBeat.i(242684);
    s.u(paramList, "emojiList");
    int i;
    int j;
    Object localObject1;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        j = paramList.size();
        localObject1 = (Iterable)paramList;
        paramList = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
      }
    }
    else
    {
      label59:
      label113:
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label115;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if (((l)localObject2).type == 0) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label113;
          }
          paramList.add(localObject2);
          break label59;
          i = 0;
          break;
        }
      }
      label115:
      i = ((List)paramList).size();
      rG(1);
      if (j <= 2) {
        rG(2);
      }
      while (i > 0)
      {
        rG(11);
        if (i <= 2)
        {
          rG(12);
          AppMethodBeat.o(242684);
          return;
          if (j <= 5) {
            rG(3);
          } else if (j <= 10) {
            rG(4);
          } else if (j <= 50) {
            rG(5);
          } else {
            rG(9);
          }
        }
        else
        {
          if (i <= 5)
          {
            rG(13);
            AppMethodBeat.o(242684);
            return;
          }
          if (i <= 10)
          {
            rG(14);
            AppMethodBeat.o(242684);
            return;
          }
          if (i <= 50)
          {
            rG(15);
            AppMethodBeat.o(242684);
            return;
          }
          rG(19);
        }
      }
    }
    AppMethodBeat.o(242684);
  }
  
  public static void rG(int paramInt)
  {
    AppMethodBeat.i(242690);
    h.OAn.p(1418L, paramInt, 1L);
    AppMethodBeat.o(242690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.d
 * JD-Core Version:    0.7.0.1
 */