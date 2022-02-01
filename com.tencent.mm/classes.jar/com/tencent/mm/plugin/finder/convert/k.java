package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "()V", "getCommentDetail", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedId", "", "objectNonceId", "", "getLayoutId", "", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.model.f>
{
  public static final a AHN;
  
  static
  {
    AppMethodBeat.i(165333);
    AHN = new a((byte)0);
    AppMethodBeat.o(165333);
  }
  
  private static final Object a(j paramj, long paramLong, b.a parama)
  {
    Object localObject1 = null;
    AppMethodBeat.i(350463);
    s.u(paramj, "$holder");
    if (parama == null)
    {
      Log.i("Finder.FeedMsgNotifyConvert", "get feed detail result is null");
      paramj = com.tencent.mm.ui.base.k.s(paramj.context, e.h.finder_feed_self_see_tip, 0);
      AppMethodBeat.o(350463);
      return paramj;
    }
    Object localObject2;
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if (!com.tencent.mm.plugin.finder.utils.aw.iv(parama.errType, parama.errCode)) {}
    }
    else
    {
      localObject2 = ((ayl)parama.ott).feedObject;
      if (localObject2 == null)
      {
        AppMethodBeat.o(350463);
        return null;
      }
      Log.i("Finder.FeedMsgNotifyConvert", "get feed detail success");
      parama = d.AwY;
      if (!d.a.auV(((FinderObject)localObject2).username))
      {
        FinderContact localFinderContact = new FinderContact();
        parama = ((FinderObject)localObject2).contact;
        if (parama == null)
        {
          parama = null;
          localFinderContact.username = parama;
          parama = ((FinderObject)localObject2).contact;
          if (parama != null) {
            break label301;
          }
          parama = null;
          label162:
          localFinderContact.nickname = parama;
          parama = ((FinderObject)localObject2).contact;
          if (parama != null) {
            break label309;
          }
          parama = (b.a)localObject1;
          label181:
          localFinderContact.headUrl = parama;
          parama = d.AwY;
          d.a.e(localFinderContact);
        }
      }
      else
      {
        parama = e.FMN;
        parama = FinderItem.Companion;
        e.a.s(FinderItem.a.e((FinderObject)localObject2, 32));
        parama = new Intent();
        parama.putExtra("feed_object_id", paramLong);
        localObject1 = as.GSQ;
        localObject1 = paramj.context;
        s.s(localObject1, "holder.context");
        as.a.a((Context)localObject1, parama, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.ab(paramj, parama);
      }
    }
    label301:
    label309:
    do
    {
      paramj = ah.aiuX;
      AppMethodBeat.o(350463);
      return paramj;
      parama = parama.username;
      break;
      parama = parama.nickname;
      break label162;
      parama = parama.headUrl;
      break label181;
      if (parama.errCode == -4011)
      {
        paramj = com.tencent.mm.ui.base.k.s(paramj.context, e.h.finder_feed_deleted_tip, 0);
        AppMethodBeat.o(350463);
        return paramj;
      }
    } while (parama.errCode != -4033);
    paramj = com.tencent.mm.ui.base.k.s(paramj.context, e.h.finder_feed_self_see_tip, 0);
    AppMethodBeat.o(350463);
    return paramj;
  }
  
  private static final void a(com.tencent.mm.plugin.finder.model.f paramf, k paramk, j paramj, View paramView)
  {
    AppMethodBeat.i(350452);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramf);
    localb.cH(paramk);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "$item");
    s.u(paramk, "this$0");
    s.u(paramj, "$holder");
    ((PluginFinder)h.az(PluginFinder.class)).getFinderActionStorage().pT(paramf.feedId);
    paramf.ECj = 1;
    long l = paramf.feedId;
    paramk = paramf.objectNonceId;
    paramf = as.GSQ;
    paramf = paramj.context;
    s.s(paramf, "holder.context");
    paramf = as.a.hu(paramf);
    if (paramf == null) {}
    for (paramf = null;; paramf = paramf.fou())
    {
      new az(l, paramk, 5, 2, "", true, null, null, 0L, null, false, false, null, paramf, 0, null, 57280).bFJ().b(new k..ExternalSyntheticLambda1(paramj, l));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350452);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350505);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350505);
  }
  
  public final void a(j paramj, com.tencent.mm.plugin.finder.model.f paramf)
  {
    AppMethodBeat.i(350499);
    s.u(paramj, "holder");
    s.u(paramf, "item");
    if (paramf.ECj == 1) {
      paramj.pt(e.e.msg_layout, 8);
    }
    for (;;)
    {
      paramj.UH(e.e.msg_layout).setOnClickListener(new k..ExternalSyntheticLambda0(paramf, this, paramj));
      AppMethodBeat.o(350499);
      return;
      paramj.pt(e.e.msg_layout, 0);
      View localView = paramj.UH(e.e.msg_layout);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      com.tencent.mm.ui.aw.a((Paint)((TextView)paramj.UH(e.e.message_count)).getPaint(), 0.8F);
      int i = ar.Giw.ffL();
      if (localLayoutParams.width < i)
      {
        localLayoutParams.width = i;
        localView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_header_comment_failed_notify_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.k
 * JD-Core Version:    0.7.0.1
 */