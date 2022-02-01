package com.tencent.mm.plugin.finder.live.olympic;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.d.a.a.a.b.b.b;
import com.tencent.d.a.a.a.b.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.olympic.data.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/live/olympic/data/RunnerPannelFeed;", "boardScene", "", "(I)V", "getBoardScene", "()I", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f<b>
{
  public static final a CNF;
  private final int CNG;
  
  static
  {
    AppMethodBeat.i(360488);
    CNF = new a((byte)0);
    AppMethodBeat.o(360488);
  }
  
  public e(int paramInt)
  {
    this.CNG = paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(360501);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    AppMethodBeat.o(360501);
  }
  
  public final int getLayoutId()
  {
    return p.f.CeR;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerConvert$Companion;", "", "()V", "RV_ITEM_START_OFFSET", "", "TAG", "", "fillItem", "", "itemView", "Landroid/view/View;", "rankTv", "Landroid/widget/TextView;", "avatarIv", "Landroid/widget/ImageView;", "nickNameTv", "stepsTv", "boardScene", "item", "Lcom/tencent/mm/plugin/finder/live/olympic/data/RunnerPannelFeed;", "boardMaxCount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(View paramView, TextView paramTextView1, ImageView paramImageView, TextView paramTextView2, TextView paramTextView3, int paramInt1, b paramb, int paramInt2)
    {
      AppMethodBeat.i(360402);
      kotlin.g.b.s.u(paramView, "itemView");
      kotlin.g.b.s.u(paramTextView1, "rankTv");
      kotlin.g.b.s.u(paramImageView, "avatarIv");
      kotlin.g.b.s.u(paramTextView2, "nickNameTv");
      kotlin.g.b.s.u(paramTextView3, "stepsTv");
      kotlin.g.b.s.u(paramb, "item");
      label105:
      Object localObject;
      if (paramInt2 <= 0)
      {
        if (paramb.CRB) {
          break label259;
        }
        k(paramTextView1, paramb.CRz.YDk);
        paramTextView1 = b.b.ahnZ;
        if (paramInt1 != b.b.a.jVS()) {
          break label286;
        }
        paramTextView1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        d locald = com.tencent.mm.plugin.finder.loader.p.eCn();
        paramTextView1 = paramb.CRz.YDj;
        if (paramTextView1 != null) {
          break label266;
        }
        paramTextView1 = "";
        paramTextView1 = new com.tencent.mm.plugin.finder.loader.s(paramTextView1, v.FKZ);
        localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
        locald.a(paramTextView1, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExW));
        paramImageView.setVisibility(0);
        paramView.getLayoutParams().height = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_9A);
        label159:
        paramImageView = MMApplicationContext.getContext();
        paramView = paramb.CRz.YDj;
        if (paramView != null) {
          break label314;
        }
        paramView = "";
      }
      for (;;)
      {
        paramTextView2.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramImageView, (CharSequence)paramView, paramTextView2.getTextSize()));
        paramTextView3.setText((CharSequence)String.valueOf(paramb.CRz.ihV));
        AppMethodBeat.o(360402);
        return;
        if ((paramb.CRz.YDk <= paramInt2) && (!paramb.CRB))
        {
          k(paramTextView1, paramb.CRz.YDk);
          break;
        }
        label259:
        t(paramTextView1);
        break;
        label266:
        localObject = paramTextView1.xkY;
        paramTextView1 = (TextView)localObject;
        if (localObject != null) {
          break label105;
        }
        paramTextView1 = "";
        break label105;
        label286:
        paramImageView.setVisibility(8);
        paramView.getLayoutParams().height = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_7A);
        break label159;
        label314:
        paramTextView1 = paramView.nickname;
        paramView = paramTextView1;
        if (paramTextView1 == null) {
          paramView = "";
        }
      }
    }
    
    private static final void k(TextView paramTextView, int paramInt)
    {
      AppMethodBeat.i(360411);
      paramTextView.setText((CharSequence)String.valueOf(paramInt));
      switch (paramInt)
      {
      default: 
        paramTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_3));
        paramTextView.setTypeface(null, 0);
      }
      while (paramInt >= 1000)
      {
        paramTextView.setTextSize(0, MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.SmallTextSize));
        AppMethodBeat.o(360411);
        return;
        paramTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Bzc));
        paramTextView.setTypeface(null, 2);
        continue;
        paramTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Bze));
        paramTextView.setTypeface(null, 2);
        continue;
        paramTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Bzd));
        paramTextView.setTypeface(null, 2);
      }
      paramTextView.setTextSize(0, MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.NormalTextSize));
      AppMethodBeat.o(360411);
    }
    
    private static final void t(TextView paramTextView)
    {
      AppMethodBeat.i(360417);
      paramTextView.setText((CharSequence)"-");
      paramTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_3));
      paramTextView.setTypeface(null, 0);
      paramTextView.setTextSize(0, MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.NormalTextSize));
      AppMethodBeat.o(360417);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.e
 * JD-Core Version:    0.7.0.1
 */