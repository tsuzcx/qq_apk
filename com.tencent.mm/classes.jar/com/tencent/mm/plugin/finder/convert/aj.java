package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.j;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedFullConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  extends ai
{
  public aj(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb, e.f.finder_full_item_folded_item);
    AppMethodBeat.i(350223);
    AppMethodBeat.o(350223);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350229);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    super.a(paramRecyclerView, paramj, paramInt);
    float f = a.fromDPToPix(MMApplicationContext.getContext(), 164.0F);
    paramj.caK.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, (int)(2.0F * f)));
    AppMethodBeat.o(350229);
  }
  
  public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(350239);
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "item");
    super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    ((TextView)paramj.UH(e.e.nickname_tv)).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
    paramList = paramBaseFinderFeed.contact;
    Object localObject1;
    if (paramList == null)
    {
      paramList = null;
      localObject1 = (CharSequence)paramList;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label289;
      }
      paramInt1 = 1;
      label91:
      if (paramInt1 == 0) {
        break label304;
      }
      paramList = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      if (paramList != null) {
        break label294;
      }
      paramList = null;
    }
    label289:
    label294:
    label304:
    for (;;)
    {
      localObject1 = p.ExI;
      localObject1 = p.eCp();
      paramList = new com.tencent.mm.plugin.finder.loader.b(paramList);
      Object localObject2 = paramj.UH(e.e.avatar_iv);
      s.s(localObject2, "holder.getView(R.id.avatar_iv)");
      localObject2 = (ImageView)localObject2;
      p localp = p.ExI;
      ((d)localObject1).a(paramList, (ImageView)localObject2, p.a(p.a.ExM));
      paramList = p.ExI;
      paramList = p.eCl();
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getMediaList().getFirst();
      s.s(paramBaseFinderFeed, "item.feedObject.mediaList.first");
      paramBaseFinderFeed = paramList.dk(new n((dji)paramBaseFinderFeed, v.FKZ, null, null, 12));
      paramList = p.ExI;
      paramBaseFinderFeed = paramBaseFinderFeed.a(p.a(p.a.ExK));
      paramj = (ImageView)paramj.caK.findViewById(e.e.thumb_iv);
      s.s(paramj, "holder.itemView.thumb_iv");
      paramBaseFinderFeed.d(paramj);
      AppMethodBeat.o(350239);
      return;
      paramList = paramList.amx();
      break;
      paramInt1 = 0;
      break label91;
      paramList = paramList.headUrl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aj
 * JD-Core Version:    0.7.0.1
 */