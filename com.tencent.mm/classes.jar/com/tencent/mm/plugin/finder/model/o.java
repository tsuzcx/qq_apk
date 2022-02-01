package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderCommentInfoEx;", "", "()V", "spanCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/text/SpannableString;", "getSpanCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "release", "", "update", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o ECp;
  private static final h<String, SpannableString> ECq;
  
  static
  {
    AppMethodBeat.i(166377);
    ECp = new o();
    ECq = new h(200);
    AppMethodBeat.o(166377);
  }
  
  public static void f(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166376);
    s.u(paramFinderItem, "item");
    Object localObject4 = ((Iterable)paramFinderItem.getCommentList()).iterator();
    Object localObject1;
    Object localObject2;
    while (((Iterator)localObject4).hasNext())
    {
      FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)((Iterator)localObject4).next();
      if (!ECq.check(localFinderCommentInfo.username))
      {
        localObject1 = av.GiL;
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
        localObject1 = av.k((String)localObject1, (String)localObject2, false);
        ECq.put(localFinderCommentInfo.username, p.b(MMApplicationContext.getContext(), (CharSequence)localObject1));
      }
      if (!ECq.check(localFinderCommentInfo.reply_username))
      {
        localObject1 = av.GiL;
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
        localObject1 = av.k((String)localObject1, (String)localObject2, false);
        ECq.put(localFinderCommentInfo.reply_username, p.b(MMApplicationContext.getContext(), (CharSequence)localObject1));
      }
      if (!ECq.check(localFinderCommentInfo.content)) {
        ECq.put(localFinderCommentInfo.content, p.b(MMApplicationContext.getContext(), (CharSequence)localFinderCommentInfo.content));
      }
    }
    Object localObject3 = ((Iterable)paramFinderItem.getLikeList()).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (FinderCommentInfo)((Iterator)localObject3).next();
      if (!ECq.check(((FinderCommentInfo)localObject4).username))
      {
        paramFinderItem = av.GiL;
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
        paramFinderItem = av.k(paramFinderItem, (String)localObject1, false);
        ECq.put(((FinderCommentInfo)localObject4).username, p.b(MMApplicationContext.getContext(), (CharSequence)paramFinderItem));
      }
    }
    AppMethodBeat.o(166376);
  }
  
  public static void release()
  {
    AppMethodBeat.i(166375);
    ECq.clear();
    AppMethodBeat.o(166375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.o
 * JD-Core Version:    0.7.0.1
 */