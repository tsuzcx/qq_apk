package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestIDKey;", "", "()V", "id", "", "getRemoteStart", "", "getRemoteSuccess", "hasPersonalWords", "hasRemoteCache", "hasRemoteShuffle", "config", "", "localResultTooMuch", "report", "key", "", "reportMatch", "local", "remote", "reportResult", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "reportSearchSlow", "reportStart", "resultTooMuch", "plugin-emojisdk_release"})
public final class d
{
  public static final d fSH;
  
  static
  {
    AppMethodBeat.i(209840);
    fSH = new d();
    AppMethodBeat.o(209840);
  }
  
  public static void T(List<l> paramList)
  {
    AppMethodBeat.i(209838);
    k.h(paramList, "emojiList");
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
      lA(1);
      if (j <= 2) {
        lA(2);
      }
      while (i > 0)
      {
        lA(11);
        if (i <= 2)
        {
          lA(12);
          AppMethodBeat.o(209838);
          return;
          if (j <= 5) {
            lA(3);
          } else if (j <= 10) {
            lA(4);
          } else if (j <= 50) {
            lA(5);
          } else {
            lA(9);
          }
        }
        else
        {
          if (i <= 5)
          {
            lA(13);
            AppMethodBeat.o(209838);
            return;
          }
          if (i <= 10)
          {
            lA(14);
            AppMethodBeat.o(209838);
            return;
          }
          if (i <= 50)
          {
            lA(15);
            AppMethodBeat.o(209838);
            return;
          }
          lA(19);
        }
      }
    }
    AppMethodBeat.o(209838);
  }
  
  public static void lA(int paramInt)
  {
    AppMethodBeat.i(209839);
    h.wUl.n(1418L, paramInt, 1L);
    AppMethodBeat.o(209839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.d
 * JD-Core Version:    0.7.0.1
 */