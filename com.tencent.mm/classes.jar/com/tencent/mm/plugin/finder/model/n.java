package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderCommentInfoEx;", "", "()V", "spanCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/text/SpannableString;", "getSpanCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "release", "", "update", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class n
{
  private static final h<String, SpannableString> zAh;
  public static final n zAi;
  
  static
  {
    AppMethodBeat.i(166377);
    zAi = new n();
    zAh = new h(200);
    AppMethodBeat.o(166377);
  }
  
  public static h<String, SpannableString> dKs()
  {
    return zAh;
  }
  
  public static void e(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166376);
    p.k(paramFinderItem, "item");
    Object localObject4 = ((Iterable)paramFinderItem.getCommentList()).iterator();
    Object localObject1;
    Object localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)((Iterator)localObject4).next();
      if (!zAh.check(localFinderCommentInfo.username))
      {
        localObject1 = aj.AGc;
        localObject2 = localFinderCommentInfo.username;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = localFinderCommentInfo.nickname;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject1 = aj.hs((String)localObject1, (String)localObject2);
        zAh.put(localFinderCommentInfo.username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)localObject1));
      }
      if (!zAh.check(localFinderCommentInfo.reply_username))
      {
        localObject1 = aj.AGc;
        localObject2 = localFinderCommentInfo.reply_username;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = localFinderCommentInfo.replyNickname;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject1 = aj.hs((String)localObject1, (String)localObject2);
        zAh.put(localFinderCommentInfo.reply_username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)localObject1));
      }
      if (!zAh.check(localFinderCommentInfo.content)) {
        zAh.put(localFinderCommentInfo.content, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)localFinderCommentInfo.content));
      }
    }
    Object localObject3 = ((Iterable)paramFinderItem.getLikeList()).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (FinderCommentInfo)((Iterator)localObject3).next();
      if (!zAh.check(((FinderCommentInfo)localObject4).username))
      {
        paramFinderItem = aj.AGc;
        localObject1 = ((FinderCommentInfo)localObject4).username;
        paramFinderItem = (FinderItem)localObject1;
        if (localObject1 == null) {
          paramFinderItem = "";
        }
        localObject2 = ((FinderCommentInfo)localObject4).nickname;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        paramFinderItem = aj.hs(paramFinderItem, (String)localObject1);
        zAh.put(((FinderCommentInfo)localObject4).username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramFinderItem));
      }
    }
    AppMethodBeat.o(166376);
  }
  
  public static void release()
  {
    AppMethodBeat.i(166375);
    zAh.clear();
    AppMethodBeat.o(166375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.n
 * JD-Core Version:    0.7.0.1
 */