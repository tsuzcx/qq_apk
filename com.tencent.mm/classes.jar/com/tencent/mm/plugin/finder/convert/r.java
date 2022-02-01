package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "layoutResId", "", "(I)V", "getLayoutId", "jumpProfile", "", "context", "Landroid/content/Context;", "feedId", "", "username", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class r
  extends com.tencent.mm.view.recyclerview.b<BaseFinderFeed>
{
  private final int rWE;
  
  public r(int paramInt)
  {
    this.rWE = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    paramRecyclerView = (ImageView)parame.GD(2131307492);
    Context localContext = parame.getContext();
    parame = parame.getContext();
    d.g.b.p.g(parame, "holder.context");
    paramRecyclerView.setImageDrawable(ao.k(localContext, 2131690326, parame.getResources().getColor(2131099828)));
  }
  
  public void a(final e parame, final BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramBaseFinderFeed, "item");
    ImageView localImageView = (ImageView)parame.GD(2131299971);
    paramList = i.srW;
    Object localObject1 = i.cEo();
    paramList = paramBaseFinderFeed.contact;
    Object localObject2;
    if (paramList != null)
    {
      paramList = paramList.czm();
      paramList = new com.tencent.mm.plugin.finder.loader.a(bu.nullAsNil(paramList));
      d.g.b.p.g(localImageView, "avatar");
      localObject2 = i.srW;
      ((d)localObject1).a(paramList, localImageView, i.a(i.a.srZ));
      localObject1 = (TextView)parame.GD(2131300017);
      d.g.b.p.g(localObject1, "nickname");
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject2 = (TextView)parame.GD(2131301416);
      d.g.b.p.g(localObject2, "likeTv");
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label341;
      }
      paramList = (CharSequence)h.fR(2, paramBaseFinderFeed.feedObject.getLikeCount());
      label182:
      ((TextView)localObject2).setText(paramList);
      paramList = (TextView)parame.GD(2131299988);
      if (bu.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label352;
      }
      d.g.b.p.g(paramList, "descTv");
      paramList.setVisibility(0);
      paramList.setText((CharSequence)k.c(parame.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription()));
    }
    for (;;)
    {
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject2 = parame.GD(2131296977);
        d.g.b.p.g(localObject2, "holder.getView<ImageView>(R.id.auth_icon)");
        com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject2, paramList.field_authInfo);
      }
      localImageView.setOnClickListener((View.OnClickListener)new a(this, parame, paramBaseFinderFeed));
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new b(this, parame, paramBaseFinderFeed));
      return;
      paramList = null;
      break;
      label341:
      paramList = (CharSequence)"0";
      break label182;
      label352:
      d.g.b.p.g(paramList, "descTv");
      paramList.setVisibility(8);
    }
  }
  
  public final int getLayoutId()
  {
    return this.rWE;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(r paramr, e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201825);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = parame.getContext();
      d.g.b.p.g(paramView, "holder.context");
      r.a(paramView, paramBaseFinderFeed.lP(), paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201825);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(r paramr, e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201826);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = parame.getContext();
      d.g.b.p.g(paramView, "holder.context");
      r.a(paramView, paramBaseFinderFeed.lP(), paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.r
 * JD-Core Version:    0.7.0.1
 */