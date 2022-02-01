package com.tencent.mm.plugin.finder.megavideo.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.r.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert;", "Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoListItemConvert;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "deleteItem", "", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "posting", "", "getLayoutId", "", "initLockIcon", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "refreshPostingLayout", "plugin-finder_release"})
public final class d
  extends b
{
  private final com.tencent.mm.plugin.finder.megavideo.ui.d.a uKA;
  
  public d(com.tencent.mm.plugin.finder.megavideo.ui.d.a parama)
  {
    AppMethodBeat.i(248356);
    this.uKA = parama;
    AppMethodBeat.o(248356);
  }
  
  private final void c(h paramh, bm parambm)
  {
    AppMethodBeat.i(248354);
    if (!this.uKA.isSelf())
    {
      AppMethodBeat.o(248354);
      return;
    }
    Context localContext = paramh.getContext();
    p.g(localContext, "holder.context");
    int i = localContext.getResources().getDimensionPixelOffset(2131165314);
    if (parambm.isPrivate())
    {
      parambm = paramh.Mn(2131309755);
      p.g(parambm, "it");
      parambm.setPadding(i, parambm.getPaddingTop(), 0, parambm.getPaddingBottom());
      parambm = paramh.Mn(2131299682);
      p.g(parambm, "holder.getView<View>(R.id.divider)");
      parambm.setVisibility(0);
      paramh = paramh.Mn(2131306141);
      p.g(paramh, "holder.getView<View>(R.id.private_lock_icon)");
      paramh.setVisibility(0);
      AppMethodBeat.o(248354);
      return;
    }
    parambm = paramh.Mn(2131309755);
    p.g(parambm, "it");
    parambm.setPadding(i, parambm.getPaddingTop(), i, parambm.getPaddingBottom());
    parambm = paramh.Mn(2131299682);
    p.g(parambm, "holder.getView<View>(R.id.divider)");
    parambm.setVisibility(8);
    paramh = paramh.Mn(2131306141);
    p.g(paramh, "holder.getView<View>(R.id.private_lock_icon)");
    paramh.setVisibility(8);
    AppMethodBeat.o(248354);
  }
  
  private final void d(final h paramh, final bm parambm)
  {
    AppMethodBeat.i(248355);
    FinderItem localFinderItem = parambm.uOW;
    Object localObject;
    if (localFinderItem != null)
    {
      if ((!localFinderItem.isPostFinish()) && (localFinderItem.getPostInfo().Mpc < 100)) {
        break label209;
      }
      localObject = paramh.Mn(2131306077);
      p.g(localObject, "holder.getView<View>(R.id.post_status_layout)");
      ((View)localObject).setVisibility(8);
      localObject = paramh.Mn(2131309765);
      p.g(localObject, "holder.getView<View>(R.id.video_expose_times_tv)");
      ((View)localObject).setVisibility(0);
      localObject = paramh.Mn(2131309742);
      p.g(localObject, "holder.getView<View>(R.id.video_create_time_tv)");
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      paramh.Mn(2131306253).setOnClickListener((View.OnClickListener)new c(localFinderItem));
      paramh.Mn(2131306193).setOnClickListener((View.OnClickListener)new a(localFinderItem, this, paramh, parambm));
      if (localFinderItem == null)
      {
        parambm = paramh.Mn(2131306077);
        p.g(parambm, "holder.getView<View>(R.id.post_status_layout)");
        parambm.setVisibility(8);
        parambm = paramh.Mn(2131309765);
        p.g(parambm, "holder.getView<View>(R.id.video_expose_times_tv)");
        parambm.setVisibility(0);
        paramh = paramh.Mn(2131309742);
        p.g(paramh, "holder.getView<View>(R.id.video_create_time_tv)");
        paramh.setVisibility(0);
        paramh = x.SXb;
      }
      AppMethodBeat.o(248355);
      return;
      label209:
      if (localFinderItem.isPostFailed())
      {
        localObject = paramh.Mn(2131309765);
        p.g(localObject, "holder.getView<View>(R.id.video_expose_times_tv)");
        ((View)localObject).setVisibility(8);
        localObject = paramh.Mn(2131309742);
        p.g(localObject, "holder.getView<View>(R.id.video_create_time_tv)");
        ((View)localObject).setVisibility(8);
        localObject = paramh.Mn(2131306077);
        p.g(localObject, "holder.getView<View>(R.id.post_status_layout)");
        ((View)localObject).setVisibility(0);
        localObject = paramh.Mn(2131306083);
        p.g(localObject, "holder.getView<View>(R.id.posting_container)");
        ((View)localObject).setVisibility(8);
        localObject = paramh.Mn(2131306084);
        p.g(localObject, "holder.getView<View>(R.i…posting_failed_container)");
        ((View)localObject).setVisibility(0);
        localObject = paramh.Mn(2131306193);
        p.g(localObject, "holder.getView<View>(R.id.profile_del)");
        ((View)localObject).setVisibility(0);
        localObject = paramh.Mn(2131306253);
        p.g(localObject, "holder.getView<View>(R.id.profile_retry)");
        ((View)localObject).setVisibility(0);
      }
      else
      {
        localObject = paramh.Mn(2131309765);
        p.g(localObject, "holder.getView<View>(R.id.video_expose_times_tv)");
        ((View)localObject).setVisibility(8);
        localObject = paramh.Mn(2131309742);
        p.g(localObject, "holder.getView<View>(R.id.video_create_time_tv)");
        ((View)localObject).setVisibility(8);
        localObject = paramh.Mn(2131306077);
        p.g(localObject, "holder.getView<View>(R.id.post_status_layout)");
        ((View)localObject).setVisibility(0);
        localObject = paramh.Mn(2131306083);
        p.g(localObject, "holder.getView<View>(R.id.posting_container)");
        ((View)localObject).setVisibility(0);
        localObject = paramh.Mn(2131306084);
        p.g(localObject, "holder.getView<View>(R.i…posting_failed_container)");
        ((View)localObject).setVisibility(8);
        localObject = paramh.Mn(2131306193);
        p.g(localObject, "holder.getView<View>(R.id.profile_del)");
        ((View)localObject).setVisibility(0);
        localObject = paramh.Mn(2131306253);
        p.g(localObject, "holder.getView<View>(R.id.profile_retry)");
        ((View)localObject).setVisibility(8);
        localObject = (FinderPostProgressView)paramh.Mn(2131306271);
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject).getProgress(), localFinderItem.getPostInfo().Mpc });
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b((FinderPostProgressView)localObject));
        localObject = localValueAnimator.setDuration(400L);
        if (localObject != null) {
          ((ValueAnimator)localObject).start();
        }
      }
    }
  }
  
  public final void a(h paramh, bm parambm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(248352);
    p.h(paramh, "holder");
    p.h(parambm, "item");
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
            switch (((Number)((o)localObject2).first).intValue())
            {
            default: 
              break;
            case 0: 
              c(paramh, parambm);
              AppMethodBeat.o(248352);
              return;
              i = 0;
              break;
            case 4: 
              d(paramh, parambm);
              AppMethodBeat.o(248352);
              return;
            }
          }
        }
      }
    }
    super.a(paramh, parambm, paramInt1, paramInt2, paramBoolean, paramList);
    d(paramh, parambm);
    paramInt2 = 2131232424;
    if (this.uKA.isSelf())
    {
      paramList = paramh.getContext();
      p.g(paramList, "holder.context");
      paramInt1 = paramList.getResources().getColor(2131100455);
      paramInt2 = 2131232425;
    }
    for (;;)
    {
      paramList = (TextView)paramh.Mn(2131309756);
      if (paramList != null) {
        paramList.setTextColor(paramInt1);
      }
      paramList = paramh.Mn(2131309755);
      if (paramList != null) {
        paramList.setBackgroundResource(paramInt2);
      }
      c(paramh, parambm);
      paramList = (TextView)paramh.Mn(2131309765);
      if (paramList != null)
      {
        if (this.uKA.isSelf()) {}
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          parambm = k.gm(paramInt1, parambm.getFeedObject().likeCount);
          paramh = paramh.getContext();
          p.g(paramh, "holder.context");
          paramList.setText((CharSequence)paramh.getResources().getString(2131760247, new Object[] { parambm }));
          AppMethodBeat.o(248352);
          return;
        }
      }
      AppMethodBeat.o(248352);
      return;
      paramInt1 = -1;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494510;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$3"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderItem paramFinderItem, d paramd, h paramh, bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248349);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      if (parambm.tuP == null) {
        p.hyc();
      }
      paramView = this.uKB;
      boolean bool;
      if (!this.uKB.isPostFailed())
      {
        bool = true;
        if (paramView.getId() == 0L) {
          break label164;
        }
        localObject1 = c.vGN;
        if (!c.a.FT(paramView.getId())) {
          break label164;
        }
        localObject1 = new hg();
        ((hg)localObject1).dLJ.id = paramView.getId();
        EventCenter.instance.publish((IEvent)localObject1);
        Log.i("Finder.FeedConvert", "deleteItem by finder video id " + paramView.getId());
      }
      label164:
      while (paramView.getLocalId() < 0L)
      {
        a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248349);
        return;
        bool = false;
        break;
      }
      localObject1 = c.vGN;
      localObject1 = c.a.FS(paramView.getLocalId());
      Object localObject2 = c.vGN;
      c.a.FV(paramView.getLocalId());
      if (bool)
      {
        localObject2 = r.d.vhx;
        r.d.ol(paramView.isLongVideo());
        localObject2 = r.d.vhx;
        r.d.dow();
        if (localObject1 != null)
        {
          localObject1 = i.vfo;
          i.e(paramView);
        }
      }
      for (;;)
      {
        localObject1 = new hg();
        ((hg)localObject1).dLJ.localId = paramView.getLocalId();
        EventCenter.instance.publish((IEvent)localObject1);
        Log.i("Finder.FeedConvert", "deleteItem by localId " + paramView.getLocalId() + ", posting:" + bool);
        break;
        localObject1 = r.d.vhx;
        r.d.om(paramView.isLongVideo());
        localObject1 = r.d.vhx;
        r.d.dox();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(248350);
      FinderPostProgressView localFinderPostProgressView = this.tAY;
      p.g(paramValueAnimator, "animator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(248350);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.tAY.invalidate();
      AppMethodBeat.o(248350);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderItem paramFinderItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248351);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = g.vSJ;
      g.dBa().t(this.uKB);
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248351);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.d
 * JD-Core Version:    0.7.0.1
 */