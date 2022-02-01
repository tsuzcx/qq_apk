package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestIDKey;", "", "()V", "id", "", "getRemoteStart", "", "getRemoteSuccess", "hasPersonalWords", "hasRemoteCache", "hasRemoteShuffle", "config", "", "localResultTooMuch", "report", "key", "", "reportMatch", "local", "remote", "reportResult", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "reportSearchSlow", "reportStart", "resultTooMuch", "plugin-emojisdk_release"})
public final class d
{
  public static final d gml;
  
  static
  {
    AppMethodBeat.i(218965);
    gml = new d();
    AppMethodBeat.o(218965);
  }
  
  public static void U(List<l> paramList)
  {
    AppMethodBeat.i(218963);
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
      ma(1);
      if (j <= 2) {
        ma(2);
      }
      while (i > 0)
      {
        ma(11);
        if (i <= 2)
        {
          ma(12);
          AppMethodBeat.o(218963);
          return;
          if (j <= 5) {
            ma(3);
          } else if (j <= 10) {
            ma(4);
          } else if (j <= 50) {
            ma(5);
          } else {
            ma(9);
          }
        }
        else
        {
          if (i <= 5)
          {
            ma(13);
            AppMethodBeat.o(218963);
            return;
          }
          if (i <= 10)
          {
            ma(14);
            AppMethodBeat.o(218963);
            return;
          }
          if (i <= 50)
          {
            ma(15);
            AppMethodBeat.o(218963);
            return;
          }
          ma(19);
        }
      }
    }
    AppMethodBeat.o(218963);
  }
  
  public static void ma(int paramInt)
  {
    AppMethodBeat.i(218964);
    g.yhR.n(1418L, paramInt, 1L);
    AppMethodBeat.o(218964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.d
 * JD-Core Version:    0.7.0.1
 */