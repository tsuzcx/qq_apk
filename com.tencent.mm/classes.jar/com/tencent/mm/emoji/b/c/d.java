package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestIDKey;", "", "()V", "id", "", "getRemoteStart", "", "getRemoteSuccess", "hasPersonalWords", "hasRemoteCache", "hasRemoteShuffle", "config", "", "localResultTooMuch", "report", "key", "", "reportMatch", "local", "remote", "reportResult", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "reportSearchSlow", "reportStart", "resultTooMuch", "plugin-emojisdk_release"})
public final class d
{
  public static final d gZA;
  
  static
  {
    AppMethodBeat.i(199940);
    gZA = new d();
    AppMethodBeat.o(199940);
  }
  
  public static void ac(List<l> paramList)
  {
    AppMethodBeat.i(199938);
    p.h(paramList, "emojiList");
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
      pl(1);
      if (j <= 2) {
        pl(2);
      }
      while (i > 0)
      {
        pl(11);
        if (i <= 2)
        {
          pl(12);
          AppMethodBeat.o(199938);
          return;
          if (j <= 5) {
            pl(3);
          } else if (j <= 10) {
            pl(4);
          } else if (j <= 50) {
            pl(5);
          } else {
            pl(9);
          }
        }
        else
        {
          if (i <= 5)
          {
            pl(13);
            AppMethodBeat.o(199938);
            return;
          }
          if (i <= 10)
          {
            pl(14);
            AppMethodBeat.o(199938);
            return;
          }
          if (i <= 50)
          {
            pl(15);
            AppMethodBeat.o(199938);
            return;
          }
          pl(19);
        }
      }
    }
    AppMethodBeat.o(199938);
  }
  
  public static void pl(int paramInt)
  {
    AppMethodBeat.i(199939);
    h.CyF.n(1418L, paramInt, 1L);
    AppMethodBeat.o(199939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.d
 * JD-Core Version:    0.7.0.1
 */