package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderMixFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "layoutResId", "", "(I)V", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "baseItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class ab
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.b>
{
  private final int rbr = 2131494051;
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    parame.asD.setOnClickListener((View.OnClickListener)new a(parame));
  }
  
  public void a(e parame, com.tencent.mm.plugin.finder.model.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramb, "baseItem");
    paramList = paramb.rux;
    if (paramList != null)
    {
      ImageView localImageView = (ImageView)parame.adJ(2131299971);
      paramb = h.rtK;
      d locald = h.cwo();
      paramb = paramList.contact;
      if (paramb == null) {
        break label306;
      }
      paramb = paramb.crZ();
      paramb = new com.tencent.mm.plugin.finder.loader.a(bs.nullAsNil(paramb));
      d.g.b.k.g(localImageView, "avatar");
      h localh = h.rtK;
      locald.a(paramb, localImageView, h.a(h.a.rtN));
      paramb = (TextView)parame.adJ(2131300017);
      d.g.b.k.g(paramb, "nickname");
      paramb.setText((CharSequence)paramList.feedObject.getNickNameSpan());
      aj.a((Paint)paramb.getPaint(), 0.8F);
      paramb = (TextView)parame.adJ(2131301416);
      d.g.b.k.g(paramb, "likeTv");
      paramb.setText((CharSequence)String.valueOf(paramList.feedObject.getLikeCount()));
      paramb = (TextView)parame.adJ(2131299988);
      if (bs.isNullOrNil(paramList.feedObject.getDescription())) {
        break label311;
      }
      d.g.b.k.g(paramb, "descTv");
      paramb.setVisibility(0);
      paramb.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)paramList.feedObject.getDescription()));
      label233:
      paramb = paramList.contact;
      if (paramb != null)
      {
        paramb = paramb.field_authInfo;
        if (paramb == null) {
          break label326;
        }
        paramInt1 = paramb.authIconType;
      }
    }
    for (;;)
    {
      if (paramInt1 > 0) {
        switch (paramInt1)
        {
        default: 
          parame.kl(2131296977, 8);
          return;
          paramb = null;
          break;
          d.g.b.k.g(paramb, "descTv");
          paramb.setVisibility(8);
          break label233;
          paramInt1 = 0;
          break;
        case 1: 
          parame.kl(2131296977, 0);
          ((ImageView)parame.adJ(2131296977)).setImageDrawable(am.k(parame.getContext(), 2131690481, com.tencent.mm.cc.a.n(parame.getContext(), 2131100725)));
          return;
        case 2: 
          parame.kl(2131296977, 0);
          ((ImageView)parame.adJ(2131296977)).setImageDrawable(am.k(parame.getContext(), 2131690481, com.tencent.mm.cc.a.n(parame.getContext(), 2131099748)));
          return;
        case 100: 
          label306:
          label311:
          label326:
          parame.kl(2131296977, 8);
          return;
        }
      }
    }
    parame.kl(2131296977, 8);
  }
  
  public final int getLayoutId()
  {
    return this.rbr;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201336);
      paramView = (com.tencent.mm.plugin.finder.model.b)this.ojH.fzs();
      if (paramView != null)
      {
        Object localObject = paramView.rux;
        if (localObject != null)
        {
          paramView = new Intent();
          paramView.putExtra("FEED_ID", ((BaseFinderFeed)localObject).feedObject.getId());
          paramView.putExtra("ENTER_COMMENT_SCENE", 15);
          paramView.putExtra("TAB_TYPE", 2);
          localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
          localObject = this.ojH.getContext();
          d.g.b.k.g(localObject, "holder.context");
          com.tencent.mm.plugin.finder.utils.a.S((Context)localObject, paramView);
          AppMethodBeat.o(201336);
          return;
        }
      }
      AppMethodBeat.o(201336);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ab
 * JD-Core Version:    0.7.0.1
 */