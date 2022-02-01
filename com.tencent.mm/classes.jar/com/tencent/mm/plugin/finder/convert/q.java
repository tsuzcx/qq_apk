package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "layoutResId", "", "(I)V", "getLayoutId", "jumpProfile", "", "context", "Landroid/content/Context;", "feedId", "", "username", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class q
  extends b<BaseFinderFeed>
{
  private final int rbr;
  
  public q(int paramInt)
  {
    this.rbr = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
  }
  
  public void a(final e parame, final BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramBaseFinderFeed, "item");
    ImageView localImageView = (ImageView)parame.adJ(2131299971);
    paramList = h.rtK;
    Object localObject = h.cwo();
    paramList = paramBaseFinderFeed.contact;
    if (paramList != null)
    {
      paramList = paramList.crZ();
      paramList = new com.tencent.mm.plugin.finder.loader.a(bs.nullAsNil(paramList));
      d.g.b.k.g(localImageView, "avatar");
      h localh = h.rtK;
      ((d)localObject).a(paramList, localImageView, h.a(h.a.rtN));
      paramList = (TextView)parame.adJ(2131300017);
      d.g.b.k.g(paramList, "nickname");
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      aj.a((Paint)paramList.getPaint(), 0.8F);
      localObject = (TextView)parame.adJ(2131301416);
      d.g.b.k.g(localObject, "likeTv");
      ((TextView)localObject).setText((CharSequence)String.valueOf(paramBaseFinderFeed.feedObject.getLikeCount()));
      localObject = (TextView)parame.adJ(2131299988);
      if (bs.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label356;
      }
      d.g.b.k.g(localObject, "descTv");
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription()));
      label236:
      localObject = paramBaseFinderFeed.contact;
      if (localObject != null)
      {
        localObject = ((f)localObject).field_authInfo;
        if (localObject == null) {
          break label373;
        }
        paramInt1 = ((FinderAuthInfo)localObject).authIconType;
        label265:
        if (paramInt1 <= 0) {
          break label476;
        }
        switch (paramInt1)
        {
        default: 
          parame.kl(2131296977, 8);
        }
      }
    }
    for (;;)
    {
      localImageView.setOnClickListener((View.OnClickListener)new a(this, parame, paramBaseFinderFeed));
      paramList.setOnClickListener((View.OnClickListener)new b(this, parame, paramBaseFinderFeed));
      return;
      paramList = null;
      break;
      label356:
      d.g.b.k.g(localObject, "descTv");
      ((TextView)localObject).setVisibility(8);
      break label236;
      label373:
      paramInt1 = 0;
      break label265;
      parame.kl(2131296977, 0);
      ((ImageView)parame.adJ(2131296977)).setImageDrawable(am.k(parame.getContext(), 2131690481, com.tencent.mm.cc.a.n(parame.getContext(), 2131100725)));
      continue;
      parame.kl(2131296977, 0);
      ((ImageView)parame.adJ(2131296977)).setImageDrawable(am.k(parame.getContext(), 2131690481, com.tencent.mm.cc.a.n(parame.getContext(), 2131099748)));
      continue;
      parame.kl(2131296977, 8);
      continue;
      label476:
      parame.kl(2131296977, 8);
    }
  }
  
  public final int getLayoutId()
  {
    return this.rbr;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(q paramq, e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201301);
      paramView = parame.getContext();
      d.g.b.k.g(paramView, "holder.context");
      q.a(paramView, paramBaseFinderFeed.lx(), paramBaseFinderFeed.feedObject.getUserName());
      AppMethodBeat.o(201301);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(q paramq, e parame, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201302);
      paramView = parame.getContext();
      d.g.b.k.g(paramView, "holder.context");
      q.a(paramView, paramBaseFinderFeed.lx(), paramBaseFinderFeed.feedObject.getUserName());
      AppMethodBeat.o(201302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.q
 * JD-Core Version:    0.7.0.1
 */