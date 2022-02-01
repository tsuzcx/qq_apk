package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderCommentInfoEx;", "", "()V", "spanCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/text/SpannableString;", "getSpanCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "release", "", "update", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class f
{
  private static final h<String, SpannableString> qDt;
  public static final f qDu;
  
  static
  {
    AppMethodBeat.i(166377);
    qDu = new f();
    qDt = new h(200);
    AppMethodBeat.o(166377);
  }
  
  public static void b(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166376);
    d.g.b.k.h(paramFinderItem, "item");
    Object localObject4 = ((Iterable)paramFinderItem.getCommentList()).iterator();
    Object localObject1;
    Object localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)((Iterator)localObject4).next();
      if (!qDt.aN(localFinderCommentInfo.username))
      {
        localObject1 = i.qTa;
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
        localObject1 = i.fW((String)localObject1, (String)localObject2);
        qDt.put(localFinderCommentInfo.username, com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)localObject1));
      }
      if (!qDt.aN(localFinderCommentInfo.reply_username))
      {
        localObject1 = i.qTa;
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
        localObject1 = i.fW((String)localObject1, (String)localObject2);
        qDt.put(localFinderCommentInfo.reply_username, com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)localObject1));
      }
      if (!qDt.aN(localFinderCommentInfo.content)) {
        qDt.put(localFinderCommentInfo.content, com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)localFinderCommentInfo.content));
      }
    }
    Object localObject3 = ((Iterable)paramFinderItem.getLikeList()).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (FinderCommentInfo)((Iterator)localObject3).next();
      if (!qDt.aN(((FinderCommentInfo)localObject4).username))
      {
        paramFinderItem = i.qTa;
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
        paramFinderItem = i.fW(paramFinderItem, (String)localObject1);
        qDt.put(((FinderCommentInfo)localObject4).username, com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)paramFinderItem));
      }
    }
    AppMethodBeat.o(166376);
  }
  
  public static h<String, SpannableString> cmX()
  {
    return qDt;
  }
  
  public static void release()
  {
    AppMethodBeat.i(166375);
    qDt.clear();
    AppMethodBeat.o(166375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.f
 * JD-Core Version:    0.7.0.1
 */