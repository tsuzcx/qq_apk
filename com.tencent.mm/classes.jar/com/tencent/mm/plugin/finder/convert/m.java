package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "layoutResId", "", "(I)V", "getLayoutId", "jumpProfile", "", "context", "Landroid/content/Context;", "feedId", "", "username", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class m
  extends b<BaseFinderFeed>
{
  private final int qru;
  
  public m(int paramInt)
  {
    this.qru = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramBaseFinderFeed, "item");
    ImageView localImageView = (ImageView)parame.abq(2131299971);
    paramList = h.qCF;
    Object localObject = h.cmV();
    paramList = paramBaseFinderFeed.contact;
    if (paramList != null)
    {
      paramList = paramList.cks();
      paramList = new com.tencent.mm.plugin.finder.loader.a(bt.nullAsNil(paramList));
      d.g.b.k.g(localImageView, "avatar");
      h localh = h.qCF;
      ((d)localObject).a(paramList, localImageView, h.a(h.a.qCI));
      paramList = (TextView)parame.abq(2131300017);
      d.g.b.k.g(paramList, "nickname");
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      ai.a((Paint)paramList.getPaint(), 0.8F);
      localObject = (TextView)parame.abq(2131301416);
      d.g.b.k.g(localObject, "likeTv");
      ((TextView)localObject).setText((CharSequence)String.valueOf(paramBaseFinderFeed.feedObject.getLikeCount()));
      localObject = (TextView)parame.abq(2131299988);
      if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
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
          parame.jY(2131296977, 8);
        }
      }
    }
    for (;;)
    {
      localImageView.setOnClickListener((View.OnClickListener)new m.a(this, parame, paramBaseFinderFeed));
      paramList.setOnClickListener((View.OnClickListener)new m.b(this, parame, paramBaseFinderFeed));
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
      parame.jY(2131296977, 0);
      ((ImageView)parame.abq(2131296977)).setImageDrawable(am.i(parame.getContext(), 2131690481, com.tencent.mm.cd.a.n(parame.getContext(), 2131100725)));
      continue;
      parame.jY(2131296977, 0);
      ((ImageView)parame.abq(2131296977)).setImageDrawable(am.i(parame.getContext(), 2131690481, com.tencent.mm.cd.a.n(parame.getContext(), 2131099748)));
      continue;
      parame.jY(2131296977, 8);
      continue;
      label476:
      parame.jY(2131296977, 8);
    }
  }
  
  public final int getLayoutId()
  {
    return this.qru;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m
 * JD-Core Version:    0.7.0.1
 */