package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderCommentInfoEx;", "", "()V", "spanCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/text/SpannableString;", "getSpanCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "release", "", "update", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class j
{
  private static final h<String, SpannableString> sjW;
  public static final j sjX;
  
  static
  {
    AppMethodBeat.i(166377);
    sjX = new j();
    sjW = new h(200);
    AppMethodBeat.o(166377);
  }
  
  public static void b(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166376);
    d.g.b.p.h(paramFinderItem, "item");
    Object localObject4 = ((Iterable)paramFinderItem.getCommentList()).iterator();
    Object localObject1;
    Object localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)((Iterator)localObject4).next();
      if (!sjW.aM(localFinderCommentInfo.username))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
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
        localObject1 = com.tencent.mm.plugin.finder.utils.p.gw((String)localObject1, (String)localObject2);
        sjW.put(localFinderCommentInfo.username, k.c(aj.getContext(), (CharSequence)localObject1));
      }
      if (!sjW.aM(localFinderCommentInfo.reply_username))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
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
        localObject1 = com.tencent.mm.plugin.finder.utils.p.gw((String)localObject1, (String)localObject2);
        sjW.put(localFinderCommentInfo.reply_username, k.c(aj.getContext(), (CharSequence)localObject1));
      }
      if (!sjW.aM(localFinderCommentInfo.content)) {
        sjW.put(localFinderCommentInfo.content, k.c(aj.getContext(), (CharSequence)localFinderCommentInfo.content));
      }
    }
    Object localObject3 = ((Iterable)paramFinderItem.getLikeList()).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (FinderCommentInfo)((Iterator)localObject3).next();
      if (!sjW.aM(((FinderCommentInfo)localObject4).username))
      {
        paramFinderItem = com.tencent.mm.plugin.finder.utils.p.sMo;
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
        paramFinderItem = com.tencent.mm.plugin.finder.utils.p.gw(paramFinderItem, (String)localObject1);
        sjW.put(((FinderCommentInfo)localObject4).username, k.c(aj.getContext(), (CharSequence)paramFinderItem));
      }
    }
    AppMethodBeat.o(166376);
  }
  
  public static h<String, SpannableString> cCI()
  {
    return sjW;
  }
  
  public static void release()
  {
    AppMethodBeat.i(166375);
    sjW.clear();
    AppMethodBeat.o(166375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.j
 * JD-Core Version:    0.7.0.1
 */