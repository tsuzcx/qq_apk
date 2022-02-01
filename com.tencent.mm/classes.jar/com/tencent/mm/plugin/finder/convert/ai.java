package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "layoutResId", "", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;I)V", "getController", "()Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ai
  extends f<BaseFinderFeed>
{
  private final FinderFoldedScrollLayout.b AKW;
  private final int AKy;
  
  public ai(FinderFoldedScrollLayout.b paramb, int paramInt)
  {
    this.AKW = paramb;
    this.AKy = paramInt;
  }
  
  private static final void a(ImageView paramImageView, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramImageView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramImageView.callOnClick();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(ai paramai, j paramj, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramai);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramai, "this$0");
    s.u(paramj, "$holder");
    paramai.AKW.p(paramj);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void e(j paramj, View paramView)
  {
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramj, "$holder");
    paramView = new Intent();
    localObject1 = (BaseFinderFeed)paramj.CSA;
    paramView.putExtra("finder_username", ((BaseFinderFeed)localObject1).feedObject.getUserName());
    localObject2 = as.GSQ;
    localObject2 = paramj.context;
    s.s(localObject2, "holder.context");
    as.a.a((Context)localObject2, paramView, ((BaseFinderFeed)localObject1).bZA(), 5, false, 64);
    localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    ((com.tencent.mm.plugin.finder.utils.a)localObject1).enterFinderProfileUI(paramj, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramj.caK.setOnClickListener(new ai..ExternalSyntheticLambda1(this, paramj));
    paramRecyclerView = this.AKW.dXB();
    if (paramRecyclerView != null)
    {
      ((ImageView)paramj.caK.findViewById(e.e.thumb_iv)).getLayoutParams().height = paramRecyclerView.height;
      ((ImageView)paramj.caK.findViewById(e.e.thumb_iv)).getLayoutParams().width = paramRecyclerView.width;
      paramj.caK.requestLayout();
    }
    paramRecyclerView = (ImageView)paramj.UH(e.e.finder_avatar);
    TextView localTextView = (TextView)paramj.UH(e.e.finder_nickname);
    if (localTextView != null) {
      localTextView.setOnClickListener(new ai..ExternalSyntheticLambda0(paramRecyclerView));
    }
    if (paramRecyclerView != null) {
      paramRecyclerView.setOnClickListener(new ai..ExternalSyntheticLambda2(paramj));
    }
  }
  
  public void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "item");
    Object localObject1 = (ImageView)paramj.UH(e.e.finder_avatar);
    Object localObject2 = (TextView)paramj.UH(e.e.finder_nickname);
    TextView localTextView = (TextView)paramj.UH(e.e.like_count_tv);
    if (this.AKW.dXD() == 1)
    {
      ((ImageView)localObject1).setVisibility(0);
      paramList = p.ExI;
      d locald = p.eCp();
      paramList = paramBaseFinderFeed.contact;
      if (paramList == null)
      {
        paramList = null;
        paramList = new com.tencent.mm.plugin.finder.loader.b(Util.nullAsNil(paramList));
        s.s(localObject1, "avatar");
        p localp = p.ExI;
        locald.a(paramList, (ImageView)localObject1, p.a(p.a.ExM));
        if (localObject2 != null)
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
          aw.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
        }
        paramList = (ImageView)paramj.UH(e.e.auth_icon);
        if (paramList != null)
        {
          localObject1 = paramBaseFinderFeed.contact;
          if (localObject1 != null)
          {
            localObject2 = av.GiL;
            av.a(paramList, ((m)localObject1).field_authInfo, 0, c.a((m)localObject1, false), 4);
          }
        }
        label224:
        paramList = paramj.UH(e.e.finder_like_container);
        if (paramList != null)
        {
          paramInt2 = paramBaseFinderFeed.feedObject.getLikeCount();
          if ((!this.AKW.dXC()) || (paramInt2 <= 0)) {
            break label430;
          }
        }
      }
    }
    label430:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      paramList.setVisibility(paramInt1);
      if ((this.AKW.dXC()) && (paramInt2 > 0))
      {
        paramList = r.ip(2, paramInt2);
        aw.a((Paint)localTextView.getPaint(), 0.8F);
        localTextView.setText((CharSequence)paramList);
      }
      paramj = (TextView)paramj.UH(e.e.finder_desc);
      if (paramj != null)
      {
        if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
          break label436;
        }
        paramj.setVisibility(0);
        paramj.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
      }
      return;
      paramList = paramList.amx();
      break;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      paramList = (ImageView)paramj.UH(e.e.auth_icon);
      if (paramList == null) {
        break label224;
      }
      paramList.setVisibility(8);
      break label224;
    }
    label436:
    paramj.setText((CharSequence)"");
  }
  
  public final int getLayoutId()
  {
    return this.AKy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ai
 * JD-Core Version:    0.7.0.1
 */