package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestIDKey;", "", "()V", "id", "", "getRemoteStart", "", "getRemoteSuccess", "hasPersonalWords", "hasRemoteCache", "hasRemoteShuffle", "config", "", "localResultTooMuch", "report", "key", "", "reportMatch", "local", "remote", "reportResult", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "reportSearchSlow", "reportStart", "resultTooMuch", "plugin-emojisdk_release"})
public final class d
{
  public static final d jKB;
  
  static
  {
    AppMethodBeat.i(227870);
    jKB = new d();
    AppMethodBeat.o(227870);
  }
  
  public static void Z(List<l> paramList)
  {
    AppMethodBeat.i(227861);
    p.k(paramList, "emojiList");
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
      rE(1);
      if (j <= 2) {
        rE(2);
      }
      while (i > 0)
      {
        rE(11);
        if (i <= 2)
        {
          rE(12);
          AppMethodBeat.o(227861);
          return;
          if (j <= 5) {
            rE(3);
          } else if (j <= 10) {
            rE(4);
          } else if (j <= 50) {
            rE(5);
          } else {
            rE(9);
          }
        }
        else
        {
          if (i <= 5)
          {
            rE(13);
            AppMethodBeat.o(227861);
            return;
          }
          if (i <= 10)
          {
            rE(14);
            AppMethodBeat.o(227861);
            return;
          }
          if (i <= 50)
          {
            rE(15);
            AppMethodBeat.o(227861);
            return;
          }
          rE(19);
        }
      }
    }
    AppMethodBeat.o(227861);
  }
  
  public static void rE(int paramInt)
  {
    AppMethodBeat.i(227864);
    h.IzE.p(1418L, paramInt, 1L);
    AppMethodBeat.o(227864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.d
 * JD-Core Version:    0.7.0.1
 */