package com.tencent.mm.plugin.finder.megavideo.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.v.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert;", "Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoListItemConvert;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "deleteItem", "", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "posting", "", "getLayoutId", "", "initLockIcon", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "refreshPostingLayout", "plugin-finder_release"})
public final class d
  extends b
{
  private final com.tencent.mm.plugin.finder.megavideo.ui.d.a zwi;
  
  public d(com.tencent.mm.plugin.finder.megavideo.ui.d.a parama)
  {
    AppMethodBeat.i(286703);
    this.zwi = parama;
    AppMethodBeat.o(286703);
  }
  
  private final void d(i parami, bs parambs)
  {
    AppMethodBeat.i(286701);
    if (!this.zwi.isSelf())
    {
      AppMethodBeat.o(286701);
      return;
    }
    Context localContext = parami.getContext();
    p.j(localContext, "holder.context");
    int i = localContext.getResources().getDimensionPixelOffset(b.d.Edge_A);
    if (parambs.isPrivate())
    {
      parambs = parami.RD(b.f.video_duration_layout);
      p.j(parambs, "it");
      parambs.setPadding(i, parambs.getPaddingTop(), 0, parambs.getPaddingBottom());
      parambs = parami.RD(b.f.divider);
      p.j(parambs, "holder.getView<View>(R.id.divider)");
      parambs.setVisibility(0);
      parami = parami.RD(b.f.private_lock_icon);
      p.j(parami, "holder.getView<View>(R.id.private_lock_icon)");
      parami.setVisibility(0);
      AppMethodBeat.o(286701);
      return;
    }
    parambs = parami.RD(b.f.video_duration_layout);
    p.j(parambs, "it");
    parambs.setPadding(i, parambs.getPaddingTop(), i, parambs.getPaddingBottom());
    parambs = parami.RD(b.f.divider);
    p.j(parambs, "holder.getView<View>(R.id.divider)");
    parambs.setVisibility(8);
    parami = parami.RD(b.f.private_lock_icon);
    p.j(parami, "holder.getView<View>(R.id.private_lock_icon)");
    parami.setVisibility(8);
    AppMethodBeat.o(286701);
  }
  
  private final void e(final i parami, final bs parambs)
  {
    AppMethodBeat.i(286702);
    FinderItem localFinderItem = parambs.zBs;
    Object localObject;
    if (localFinderItem != null)
    {
      if ((!localFinderItem.isPostFinish()) && (localFinderItem.getPostInfo().TAi < 100)) {
        break label217;
      }
      localObject = parami.RD(b.f.post_status_layout);
      p.j(localObject, "holder.getView<View>(R.id.post_status_layout)");
      ((View)localObject).setVisibility(8);
      localObject = parami.RD(b.f.video_expose_times_tv);
      p.j(localObject, "holder.getView<View>(R.id.video_expose_times_tv)");
      ((View)localObject).setVisibility(0);
      localObject = parami.RD(b.f.video_create_time_tv);
      p.j(localObject, "holder.getView<View>(R.id.video_create_time_tv)");
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      parami.RD(b.f.profile_retry).setOnClickListener((View.OnClickListener)new c(localFinderItem));
      parami.RD(b.f.profile_del).setOnClickListener((View.OnClickListener)new a(localFinderItem, this, parami, parambs));
      if (localFinderItem == null)
      {
        parambs = parami.RD(b.f.post_status_layout);
        p.j(parambs, "holder.getView<View>(R.id.post_status_layout)");
        parambs.setVisibility(8);
        parambs = parami.RD(b.f.video_expose_times_tv);
        p.j(parambs, "holder.getView<View>(R.id.video_expose_times_tv)");
        parambs.setVisibility(0);
        parami = parami.RD(b.f.video_create_time_tv);
        p.j(parami, "holder.getView<View>(R.id.video_create_time_tv)");
        parami.setVisibility(0);
        parami = x.aazN;
      }
      AppMethodBeat.o(286702);
      return;
      label217:
      if (localFinderItem.isPostFailed())
      {
        localObject = parami.RD(b.f.video_expose_times_tv);
        p.j(localObject, "holder.getView<View>(R.id.video_expose_times_tv)");
        ((View)localObject).setVisibility(8);
        localObject = parami.RD(b.f.video_create_time_tv);
        p.j(localObject, "holder.getView<View>(R.id.video_create_time_tv)");
        ((View)localObject).setVisibility(8);
        localObject = parami.RD(b.f.post_status_layout);
        p.j(localObject, "holder.getView<View>(R.id.post_status_layout)");
        ((View)localObject).setVisibility(0);
        localObject = parami.RD(b.f.posting_container);
        p.j(localObject, "holder.getView<View>(R.id.posting_container)");
        ((View)localObject).setVisibility(8);
        localObject = parami.RD(b.f.posting_failed_container);
        p.j(localObject, "holder.getView<View>(R.i…posting_failed_container)");
        ((View)localObject).setVisibility(0);
        localObject = parami.RD(b.f.profile_del);
        p.j(localObject, "holder.getView<View>(R.id.profile_del)");
        ((View)localObject).setVisibility(0);
        localObject = parami.RD(b.f.profile_retry);
        p.j(localObject, "holder.getView<View>(R.id.profile_retry)");
        ((View)localObject).setVisibility(0);
      }
      else
      {
        localObject = parami.RD(b.f.video_expose_times_tv);
        p.j(localObject, "holder.getView<View>(R.id.video_expose_times_tv)");
        ((View)localObject).setVisibility(8);
        localObject = parami.RD(b.f.video_create_time_tv);
        p.j(localObject, "holder.getView<View>(R.id.video_create_time_tv)");
        ((View)localObject).setVisibility(8);
        localObject = parami.RD(b.f.post_status_layout);
        p.j(localObject, "holder.getView<View>(R.id.post_status_layout)");
        ((View)localObject).setVisibility(0);
        localObject = parami.RD(b.f.posting_container);
        p.j(localObject, "holder.getView<View>(R.id.posting_container)");
        ((View)localObject).setVisibility(0);
        localObject = parami.RD(b.f.posting_failed_container);
        p.j(localObject, "holder.getView<View>(R.i…posting_failed_container)");
        ((View)localObject).setVisibility(8);
        localObject = parami.RD(b.f.profile_del);
        p.j(localObject, "holder.getView<View>(R.id.profile_del)");
        ((View)localObject).setVisibility(0);
        localObject = parami.RD(b.f.profile_retry);
        p.j(localObject, "holder.getView<View>(R.id.profile_retry)");
        ((View)localObject).setVisibility(8);
        localObject = (FinderPostProgressView)parami.RD(b.f.profile_upload_progress);
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject).getProgress(), localFinderItem.getPostInfo().TAi });
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b((FinderPostProgressView)localObject));
        localObject = localValueAnimator.setDuration(400L);
        if (localObject != null) {
          ((ValueAnimator)localObject).start();
        }
      }
    }
  }
  
  public final void a(i parami, bs parambs, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(286699);
    p.k(parami, "holder");
    p.k(parambs, "item");
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
          if ((localObject2 instanceof o)) {
            switch (((Number)((o)localObject2).Mx).intValue())
            {
            default: 
              break;
            case 0: 
              d(parami, parambs);
              AppMethodBeat.o(286699);
              return;
              i = 0;
              break;
            case 4: 
              e(parami, parambs);
              AppMethodBeat.o(286699);
              return;
            }
          }
        }
      }
    }
    super.a(parami, parambs, paramInt1, paramInt2, paramBoolean, paramList);
    e(parami, parambs);
    paramInt2 = b.e.feed_mega_video_list_item_time_bg;
    if (this.zwi.isSelf())
    {
      paramList = parami.getContext();
      p.j(paramList, "holder.context");
      paramInt1 = paramList.getResources().getColor(b.c.finder_mega_video_list_self_item_time_text_color);
      paramInt2 = b.e.feed_mega_video_list_self_item_time_bg;
    }
    for (;;)
    {
      paramList = (TextView)parami.RD(b.f.video_duration_tv);
      if (paramList != null) {
        paramList.setTextColor(paramInt1);
      }
      paramList = parami.RD(b.f.video_duration_layout);
      if (paramList != null) {
        paramList.setBackgroundResource(paramInt2);
      }
      d(parami, parambs);
      paramList = (TextView)parami.RD(b.f.video_expose_times_tv);
      if (paramList != null)
      {
        if (this.zwi.isSelf()) {}
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          parambs = m.gY(paramInt1, parambs.getFeedObject().likeCount);
          parami = parami.getContext();
          p.j(parami, "holder.context");
          paramList.setText((CharSequence)parami.getResources().getString(b.j.finder_mega_video_list_item_like_count_text, new Object[] { parambs }));
          AppMethodBeat.o(286699);
          return;
        }
      }
      AppMethodBeat.o(286699);
      return;
      paramInt1 = -1;
    }
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_mega_video_profile_list_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$3"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderItem paramFinderItem, d paramd, i parami, bs parambs) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(267082);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      if (parambs.xcy == null) {
        p.iCn();
      }
      paramView = this.zwj;
      boolean bool;
      if (!this.zwj.isPostFailed())
      {
        bool = true;
        if (paramView.getId() == 0L) {
          break label164;
        }
        localObject1 = c.AnK;
        if (!c.a.MT(paramView.getId())) {
          break label164;
        }
        localObject1 = new hn();
        ((hn)localObject1).fEy.id = paramView.getId();
        EventCenter.instance.publish((IEvent)localObject1);
        Log.i("Finder.FeedConvert", "deleteItem by finder video id " + paramView.getId());
      }
      label164:
      while (paramView.getLocalId() < 0L)
      {
        a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267082);
        return;
        bool = false;
        break;
      }
      localObject1 = c.AnK;
      localObject1 = c.a.MS(paramView.getLocalId());
      Object localObject2 = c.AnK;
      c.a.MV(paramView.getLocalId());
      if (bool)
      {
        localObject2 = v.d.zYG;
        v.d.qw(paramView.isLongVideo());
        localObject2 = v.d.zYG;
        v.d.dQe();
        if (localObject1 != null)
        {
          localObject1 = k.zWs;
          k.f(paramView);
        }
      }
      for (;;)
      {
        localObject1 = new hn();
        ((hn)localObject1).fEy.localId = paramView.getLocalId();
        EventCenter.instance.publish((IEvent)localObject1);
        Log.i("Finder.FeedConvert", "deleteItem by localId " + paramView.getLocalId() + ", posting:" + bool);
        break;
        localObject1 = v.d.zYG;
        v.d.qx(paramView.isLongVideo());
        localObject1 = v.d.zYG;
        v.d.dQf();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(286548);
      FinderPostProgressView localFinderPostProgressView = this.xiI;
      p.j(paramValueAnimator, "animator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(286548);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.xiI.invalidate();
      AppMethodBeat.o(286548);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderItem paramFinderItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(292237);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.AAk;
      g.ecj().v(this.zwj);
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.d
 * JD-Core Version:    0.7.0.1
 */