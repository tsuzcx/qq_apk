package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderCommentInfoEx;", "", "()V", "spanCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/text/SpannableString;", "getSpanCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "release", "", "update", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class n
{
  private static final h<String, SpannableString> uNT;
  public static final n uNU;
  
  static
  {
    AppMethodBeat.i(166377);
    uNU = new n();
    uNT = new h(200);
    AppMethodBeat.o(166377);
  }
  
  public static void d(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166376);
    p.h(paramFinderItem, "item");
    Object localObject4 = ((Iterable)paramFinderItem.getCommentList()).iterator();
    Object localObject1;
    Object localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)((Iterator)localObject4).next();
      if (!uNT.check(localFinderCommentInfo.username))
      {
        localObject1 = y.vXH;
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
        localObject1 = y.he((String)localObject1, (String)localObject2);
        uNT.put(localFinderCommentInfo.username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)localObject1));
      }
      if (!uNT.check(localFinderCommentInfo.reply_username))
      {
        localObject1 = y.vXH;
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
        localObject1 = y.he((String)localObject1, (String)localObject2);
        uNT.put(localFinderCommentInfo.reply_username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)localObject1));
      }
      if (!uNT.check(localFinderCommentInfo.content)) {
        uNT.put(localFinderCommentInfo.content, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)localFinderCommentInfo.content));
      }
    }
    Object localObject3 = ((Iterable)paramFinderItem.getLikeList()).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (FinderCommentInfo)((Iterator)localObject3).next();
      if (!uNT.check(((FinderCommentInfo)localObject4).username))
      {
        paramFinderItem = y.vXH;
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
        paramFinderItem = y.he(paramFinderItem, (String)localObject1);
        uNT.put(((FinderCommentInfo)localObject4).username, com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramFinderItem));
      }
    }
    AppMethodBeat.o(166376);
  }
  
  public static h<String, SpannableString> dkv()
  {
    return uNT;
  }
  
  public static void release()
  {
    AppMethodBeat.i(166375);
    uNT.clear();
    AppMethodBeat.o(166375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.n
 * JD-Core Version:    0.7.0.1
 */