package com.tencent.mm.plugin.finder.megavideo.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hy;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.publish.f;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert;", "Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoListItemConvert;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "deleteItem", "", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "posting", "", "getLayoutId", "", "initLockIcon", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "refreshPostingLayout", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  public static final a Ezw;
  private final com.tencent.mm.plugin.finder.megavideo.ui.d.a Ezx;
  
  static
  {
    AppMethodBeat.i(342341);
    Ezw = new a((byte)0);
    AppMethodBeat.o(342341);
  }
  
  public d(com.tencent.mm.plugin.finder.megavideo.ui.d.a parama)
  {
    AppMethodBeat.i(342297);
    this.Ezx = parama;
    AppMethodBeat.o(342297);
  }
  
  private static final void a(d paramd, ca paramca, FinderItem paramFinderItem, View paramView)
  {
    AppMethodBeat.i(342339);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramca);
    localb.cH(paramFinderItem);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(paramca, "$item");
    s.u(paramFinderItem, "$it");
    s.checkNotNull(paramca.ABK);
    boolean bool;
    if (!paramFinderItem.isPostFailed())
    {
      bool = true;
      if (paramFinderItem.getId() == 0L) {
        break label194;
      }
      paramd = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      if (!com.tencent.mm.plugin.finder.storage.logic.d.a.qs(paramFinderItem.getId())) {
        break label194;
      }
      paramd = new hy();
      paramd.hJo.id = paramFinderItem.getId();
      paramd.publish();
      Log.i("Finder.MegaVideoProfileConvert", s.X("deleteItem by finder video id ", Long.valueOf(paramFinderItem.getId())));
    }
    label194:
    do
    {
      do
      {
        a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(342339);
        return;
        bool = false;
        break;
      } while (paramFinderItem.getLocalId() < 0L);
      paramd = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      paramd = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(paramFinderItem.getLocalId());
      paramca = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    } while (!com.tencent.mm.plugin.finder.storage.logic.d.a.qu(paramFinderItem.getLocalId()));
    if (bool)
    {
      ((c)h.az(c.class)).publishStatApi().tl(paramFinderItem.isLongVideo());
      ((c)h.az(c.class)).publishStatApi().eLb();
      if (paramd != null)
      {
        paramd = v.FrN;
        v.i(paramFinderItem);
      }
    }
    for (;;)
    {
      paramd = new hy();
      paramd.hJo.localId = paramFinderItem.getLocalId();
      paramd.publish();
      Log.i("Finder.MegaVideoProfileConvert", "deleteItem by localId " + paramFinderItem.getLocalId() + ", posting:" + bool);
      break;
      ((c)h.az(c.class)).publishStatApi().tm(paramFinderItem.isLongVideo());
      ((c)h.az(c.class)).publishStatApi().eLc();
    }
  }
  
  private static final void a(FinderItem paramFinderItem, View paramView)
  {
    AppMethodBeat.i(342331);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderItem);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderItem, "$it");
    ((c)h.az(c.class)).finderPostManager().fy(paramFinderItem);
    a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342331);
  }
  
  private static final void e(FinderPostProgressView paramFinderPostProgressView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(342325);
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderPostProgressView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(342325);
      throw paramFinderPostProgressView;
    }
    paramFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
    paramFinderPostProgressView.invalidate();
    AppMethodBeat.o(342325);
  }
  
  private final void e(j paramj, ca paramca)
  {
    AppMethodBeat.i(342304);
    if (!this.Ezx.isSelf())
    {
      AppMethodBeat.o(342304);
      return;
    }
    int i = paramj.context.getResources().getDimensionPixelOffset(e.c.Edge_A);
    if (paramca.isPrivate())
    {
      paramca = paramj.UH(e.e.video_duration_layout);
      paramca.setPadding(i, paramca.getPaddingTop(), 0, paramca.getPaddingBottom());
      paramj.UH(e.e.divider).setVisibility(0);
      paramj.UH(e.e.private_lock_icon).setVisibility(0);
      AppMethodBeat.o(342304);
      return;
    }
    paramca = paramj.UH(e.e.video_duration_layout);
    paramca.setPadding(i, paramca.getPaddingTop(), i, paramca.getPaddingBottom());
    paramj.UH(e.e.divider).setVisibility(8);
    paramj.UH(e.e.private_lock_icon).setVisibility(8);
    AppMethodBeat.o(342304);
  }
  
  private final void f(j paramj, ca paramca)
  {
    AppMethodBeat.i(342318);
    FinderItem localFinderItem = paramca.EDG;
    if (localFinderItem == null)
    {
      paramca = null;
      if (paramca == null)
      {
        paramj.UH(e.e.post_status_layout).setVisibility(8);
        paramj.UH(e.e.video_expose_times_tv).setVisibility(0);
        paramj.UH(e.e.video_create_time_tv).setVisibility(0);
      }
      AppMethodBeat.o(342318);
      return;
    }
    if ((localFinderItem.isPostFinish()) || (localFinderItem.getPostInfo().aaPw >= 100))
    {
      paramj.UH(e.e.post_status_layout).setVisibility(8);
      paramj.UH(e.e.video_expose_times_tv).setVisibility(0);
      paramj.UH(e.e.video_create_time_tv).setVisibility(0);
    }
    for (;;)
    {
      paramj.UH(e.e.profile_retry).setOnClickListener(new d..ExternalSyntheticLambda2(localFinderItem));
      paramj.UH(e.e.profile_del).setOnClickListener(new d..ExternalSyntheticLambda1(this, paramca, localFinderItem));
      paramca = localFinderItem;
      break;
      if (localFinderItem.isPostFailed())
      {
        paramj.UH(e.e.video_expose_times_tv).setVisibility(8);
        paramj.UH(e.e.video_create_time_tv).setVisibility(8);
        paramj.UH(e.e.post_status_layout).setVisibility(0);
        paramj.UH(e.e.posting_container).setVisibility(8);
        paramj.UH(e.e.posting_failed_container).setVisibility(0);
        paramj.UH(e.e.profile_del).setVisibility(0);
        paramj.UH(e.e.profile_retry).setVisibility(0);
      }
      else
      {
        paramj.UH(e.e.video_expose_times_tv).setVisibility(8);
        paramj.UH(e.e.video_create_time_tv).setVisibility(8);
        paramj.UH(e.e.post_status_layout).setVisibility(0);
        paramj.UH(e.e.posting_container).setVisibility(0);
        paramj.UH(e.e.posting_failed_container).setVisibility(8);
        paramj.UH(e.e.profile_del).setVisibility(0);
        paramj.UH(e.e.profile_retry).setVisibility(8);
        Object localObject = (FinderPostProgressView)paramj.UH(e.e.profile_upload_progress);
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject).getProgress(), localFinderItem.getPostInfo().aaPw });
        localValueAnimator.addUpdateListener(new d..ExternalSyntheticLambda0((FinderPostProgressView)localObject));
        localObject = localValueAnimator.setDuration(400L);
        if (localObject != null) {
          ((ValueAnimator)localObject).start();
        }
      }
    }
  }
  
  public final void a(j paramj, ca paramca, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(342378);
    s.u(paramj, "holder");
    s.u(paramca, "item");
    Object localObject1 = (Collection)paramList;
    int i;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      localObject1 = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof kotlin.r)) {
            switch (((Number)((kotlin.r)localObject2).bsC).intValue())
            {
            default: 
              break;
            case 0: 
              e(paramj, paramca);
              AppMethodBeat.o(342378);
              return;
              i = 0;
              break;
            case 4: 
              f(paramj, paramca);
              AppMethodBeat.o(342378);
              return;
            }
          }
        }
      }
    }
    super.a(paramj, paramca, paramInt1, paramInt2, paramBoolean, paramList);
    f(paramj, paramca);
    paramInt2 = e.d.feed_mega_video_list_item_time_bg;
    if (this.Ezx.isSelf())
    {
      paramInt1 = paramj.context.getResources().getColor(e.b.finder_mega_video_list_self_item_time_text_color);
      paramInt2 = e.d.feed_mega_video_list_self_item_time_bg;
    }
    for (;;)
    {
      paramList = (TextView)paramj.UH(e.e.video_duration_tv);
      if (paramList != null) {
        paramList.setTextColor(paramInt1);
      }
      paramList = paramj.UH(e.e.video_duration_layout);
      if (paramList != null) {
        paramList.setBackgroundResource(paramInt2);
      }
      e(paramj, paramca);
      paramList = (TextView)paramj.UH(e.e.video_expose_times_tv);
      if (paramList != null) {
        if (!this.Ezx.isSelf()) {
          break label343;
        }
      }
      label343:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        paramca = com.tencent.mm.plugin.finder.utils.r.ip(paramInt1, paramca.getFeedObject().likeCount);
        paramList.setText((CharSequence)paramj.context.getResources().getString(e.h.finder_mega_video_list_item_like_count_text, new Object[] { paramca }));
        AppMethodBeat.o(342378);
        return;
      }
      paramInt1 = -1;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_mega_video_profile_list_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.d
 * JD-Core Version:    0.7.0.1
 */