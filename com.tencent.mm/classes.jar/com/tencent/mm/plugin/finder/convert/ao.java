package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "layoutResId", "", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;I)V", "getController", "()Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public abstract class ao
  extends com.tencent.mm.view.recyclerview.e<BaseFinderFeed>
{
  final FinderFoldedScrollLayout.b xmL;
  private final int xmc;
  
  public ao(FinderFoldedScrollLayout.b paramb, int paramInt)
  {
    this.xmL = paramb;
    this.xmc = paramInt;
  }
  
  public void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    parami.amk.setOnClickListener((View.OnClickListener)new a(this, parami));
    this.xmL.dpx();
    paramRecyclerView = (ImageView)parami.RD(b.f.finder_avatar);
    TextView localTextView = (TextView)parami.RD(b.f.finder_nickname);
    if (localTextView != null) {
      localTextView.setOnClickListener((View.OnClickListener)new ao.b(paramRecyclerView));
    }
    if (paramRecyclerView != null) {
      paramRecyclerView.setOnClickListener((View.OnClickListener)new c(parami));
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    Object localObject1 = (ImageView)parami.RD(b.f.finder_avatar);
    Object localObject2 = (TextView)parami.RD(b.f.finder_nickname);
    parami.RD(b.f.like_count_tv);
    if (this.xmL.dpz() == 1)
    {
      p.j(localObject1, "avatar");
      ((ImageView)localObject1).setVisibility(0);
      paramList = t.ztT;
      d locald = t.dJh();
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        paramList = paramList.Mm();
        paramList = new com.tencent.mm.plugin.finder.loader.e(Util.nullAsNil(paramList));
        t localt = t.ztT;
        locald.a(paramList, (ImageView)localObject1, t.a(t.a.ztX));
        if (localObject2 != null)
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
          ar.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
        }
        paramList = (ImageView)parami.RD(b.f.auth_icon);
        if (paramList != null)
        {
          localObject1 = paramBaseFinderFeed.contact;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            com.tencent.mm.plugin.finder.utils.aj.a(paramList, ((com.tencent.mm.plugin.finder.api.i)localObject1).field_authInfo);
          }
        }
      }
    }
    for (;;)
    {
      paramList = parami.RD(b.f.finder_like_container);
      if (paramList != null)
      {
        paramBaseFinderFeed.feedObject.getLikeCount();
        this.xmL.dpy();
        paramList.setVisibility(8);
        this.xmL.dpy();
      }
      parami = (TextView)parami.RD(b.f.finder_desc);
      if (parami != null)
      {
        if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
          break label368;
        }
        parami.setVisibility(0);
        parami.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
      }
      return;
      paramList = null;
      break;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      paramList = (ImageView)parami.RD(b.f.auth_icon);
      if (paramList != null) {
        paramList.setVisibility(8);
      }
    }
    label368:
    parami.setText((CharSequence)"");
  }
  
  public final int getLayoutId()
  {
    return this.xmc;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(ao paramao, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279514);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xmM.xmL.j(parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279514);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288152);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      paramView = new Intent();
      localObject1 = (BaseFinderFeed)this.tDl.ihX();
      paramView.putExtra("finder_username", ((BaseFinderFeed)localObject1).feedObject.getUserName());
      Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject2 = this.tDl.getContext();
      p.j(localObject2, "holder.context");
      aj.a.a((Context)localObject2, paramView, ((BaseFinderFeed)localObject1).mf(), 5, false, 64);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = this.tDl.getContext();
      p.j(localObject1, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject1, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ao
 * JD-Core Version:    0.7.0.1
 */