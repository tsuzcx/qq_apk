package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.live.a;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderConfigForNewLiveCardStyle;", "Lcom/tencent/mm/plugin/finder/storage/FinderStaggeredConfig;", "baseContext", "Landroid/content/Context;", "commentScene", "", "(Landroid/content/Context;I)V", "getBaseContext", "()Landroid/content/Context;", "getCommentScene", "()I", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "extraMap", "Lkotlin/Function1;", "onBind", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "position", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "jumpProfile", "context", "feedId", "", "username", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends ao
{
  final int AJo;
  final Context FJU;
  
  public e(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(339170);
    this.FJU = paramContext;
    this.AJo = paramInt;
    AppMethodBeat.o(339170);
  }
  
  public final f<?> a(int paramInt, b<? super Integer, ? extends f<?>> paramb, final q<? super j, ? super BaseFinderFeed, ? super Integer, kotlin.ah> paramq)
  {
    AppMethodBeat.i(339185);
    switch (paramInt)
    {
    default: 
      if (paramb != null) {
        break;
      }
    }
    for (paramb = null; paramb == null; paramb = (f)paramb.invoke(Integer.valueOf(paramInt)))
    {
      paramb = Ts(paramInt);
      AppMethodBeat.o(339185);
      return paramb;
      paramb = (f)new a(paramq);
      AppMethodBeat.o(339185);
      return paramb;
      paramb = (f)new b(this, paramq, MMApplicationContext.getContext().getResources().getDimension(com.tencent.mm.plugin.finder.e.c.Edge_1_5_A), new c(this));
      AppMethodBeat.o(339185);
      return paramb;
      paramb = (f)new d(paramq);
      AppMethodBeat.o(339185);
      return paramb;
      paramb = (f)new ae();
      AppMethodBeat.o(339185);
      return paramb;
      paramb = (f)new z();
      AppMethodBeat.o(339185);
      return paramb;
    }
    AppMethodBeat.o(339185);
    return paramb;
  }
  
  public final g au(final b<? super Integer, ? extends f<?>> paramb)
  {
    AppMethodBeat.i(339174);
    paramb = (g)new e(this, paramb);
    AppMethodBeat.o(339174);
    return paramb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderConfigForNewLiveCardStyle$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.finder.convert.ah
  {
    a(q<? super j, ? super BaseFinderFeed, ? super Integer, kotlin.ah> paramq) {}
    
    public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
    {
      AppMethodBeat.i(339020);
      s.u(paramj, "holder");
      s.u(paramBaseFinderFeed, "item");
      super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
      paramList = this.Bbi;
      if (paramList != null) {
        paramList.invoke(paramj, paramBaseFinderFeed, Integer.valueOf(paramInt1));
      }
      AppMethodBeat.o(339020);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderConfigForNewLiveCardStyle$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/live/FinderLiveSquareLiveFeedConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends a
  {
    b(e parame, q<? super j, ? super BaseFinderFeed, ? super Integer, kotlin.ah> paramq, float paramFloat, e.c paramc)
    {
      super(false, false, (m)paramc);
      AppMethodBeat.i(339015);
      AppMethodBeat.o(339015);
    }
    
    public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
    {
      AppMethodBeat.i(339025);
      s.u(paramj, "holder");
      s.u(paramBaseFinderFeed, "item");
      super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
      View localView = paramj.UH(com.tencent.mm.plugin.finder.e.e.finder_live_online_layout);
      TextView localTextView2 = (TextView)paramj.UH(com.tencent.mm.plugin.finder.e.e.rec_reason_tv);
      TextView localTextView1 = (TextView)paramj.UH(com.tencent.mm.plugin.finder.e.e.watch_count_history_tv);
      paramList = paramj.UH(com.tencent.mm.plugin.finder.e.e.finder_live_onlive_widget);
      Object localObject = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((localObject != null) && (((bip)localObject).liveStatus == 1))
      {
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label347;
        }
        localView.setVisibility(0);
        paramList.setVisibility(0);
        localObject = paramBaseFinderFeed.feedObject.getFeedObject().recommendReason;
        paramList = (List<Object>)localObject;
        if (localObject == null) {
          paramList = "";
        }
        if (!TextUtils.isEmpty((CharSequence)paramList)) {
          break label308;
        }
        localView.setVisibility(8);
        label158:
        paramList = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (paramList != null) {
          break label327;
        }
        paramInt2 = 0;
        label175:
        if (paramInt2 <= 0) {
          break label337;
        }
        localTextView1.setText((CharSequence)String.valueOf(r.TS(paramInt2)));
        localTextView1.setVisibility(0);
        localTextView1.setBackground(paramj.context.getDrawable(com.tencent.mm.plugin.finder.e.d.finder_stagged_feed_float_bg));
        localTextView1.setPadding(d.e(paramj.context, 6.0F), d.e(paramj.context, 1.0F), d.e(paramj.context, 6.0F), d.e(paramj.context, 1.0F));
      }
      for (;;)
      {
        ((TextView)paramj.UH(com.tencent.mm.plugin.finder.e.e.finder_desc)).setVisibility(8);
        paramList = paramq;
        if (paramList != null) {
          paramList.invoke(paramj, paramBaseFinderFeed, Integer.valueOf(paramInt1));
        }
        AppMethodBeat.o(339025);
        return;
        paramInt2 = 0;
        break;
        label308:
        localTextView2.setText((CharSequence)paramList);
        localView.setVisibility(0);
        break label158;
        label327:
        paramInt2 = paramList.EOg;
        break label175;
        label337:
        localTextView1.setVisibility(8);
        continue;
        label347:
        paramList.setVisibility(8);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "feedId", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements m<Long, String, kotlin.ah>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderConfigForNewLiveCardStyle$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.finder.convert.u
  {
    d(q<? super j, ? super BaseFinderFeed, ? super Integer, kotlin.ah> paramq) {}
    
    public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
    {
      AppMethodBeat.i(339014);
      s.u(paramj, "holder");
      s.u(paramBaseFinderFeed, "item");
      super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
      paramList = this.Bbi;
      if (paramList != null) {
        paramList.invoke(paramj, paramBaseFinderFeed, Integer.valueOf(paramInt1));
      }
      AppMethodBeat.o(339014);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderConfigForNewLiveCardStyle$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements g
  {
    e(e parame, b<? super Integer, ? extends f<?>> paramb) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(339012);
      f localf = this.FJV.a(paramInt, paramb, null);
      AppMethodBeat.o(339012);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.e
 * JD-Core Version:    0.7.0.1
 */