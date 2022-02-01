package com.tencent.mm.plugin.finder.nearby.live.convert;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.a.b.a.f.a;
import com.tencent.d.a.b.a.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderSquareLiveFeedConvert;", "Lcom/tencent/mm/plugin/finder/convert/live/FinderLiveSquareLiveFeedConvert;", "commentScene", "", "dividerWidth", "", "forceNightMode", "", "isLocalCityPage", "baseContext", "Landroid/content/Context;", "(IFZZLandroid/content/Context;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "bindActivityIcon", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindLive", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends com.tencent.mm.plugin.finder.convert.live.a
{
  public static final a EJL;
  private aq coroutineScope;
  
  static
  {
    AppMethodBeat.i(340914);
    EJL = new a((byte)0);
    AppMethodBeat.o(340914);
  }
  
  public b(final int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    super(paramFloat, paramBoolean1, paramBoolean2, (m)new u(paramContext) {});
    AppMethodBeat.i(340882);
    this.coroutineScope = ar.kBZ();
    AppMethodBeat.o(340882);
  }
  
  private static final void gy(View paramView)
  {
    AppMethodBeat.i(340891);
    paramView = paramView.getTag(f.d.EFT);
    if ((paramView instanceof cb)) {
      ((cb)paramView).a(null);
    }
    AppMethodBeat.o(340891);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, final BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, final List<Object> paramList)
  {
    AppMethodBeat.i(340932);
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "item");
    super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    j(paramj, paramBaseFinderFeed);
    if (((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isFinderLiveActivityIconEntranceEnable())
    {
      Object localObject = com.tencent.mm.ae.d.hF(paramBaseFinderFeed.feedObject.field_id);
      Log.i("NearbyLiveViewCallback", s.X("#bindActivityIcon feedId=", localObject));
      paramList = (ImageView)paramj.UH(f.d.iv_live_activity_info_icon);
      if (paramList == null)
      {
        Log.i("NearbyLiveViewCallback", "#bindActivityIcon feedId=" + (String)localObject + " iconView is null!");
        AppMethodBeat.o(340932);
        return;
      }
      gy((View)paramList);
      localObject = paramj.caK;
      s.s(localObject, "holder.itemView");
      f.a((View)localObject, (e.b)new b(paramList));
      paramj = kotlinx.coroutines.j.a(this.coroutineScope, null, null, (m)new c(paramj, paramBaseFinderFeed, paramList, null), 3);
      paramList.setTag(f.d.EFT, paramj);
    }
    AppMethodBeat.o(340932);
  }
  
  public void j(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(340953);
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "item");
    ViewGroup localViewGroup = (ViewGroup)paramj.caK.findViewById(f.d.nearby_live_convert_root);
    View localView = paramj.UH(f.d.finder_live_online_layout);
    TextView localTextView2 = (TextView)paramj.UH(f.d.rec_reason_tv);
    TextView localTextView1 = (TextView)paramj.UH(f.d.watch_count_history_tv);
    Object localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
    Object localObject2;
    if ((localObject1 != null) && (((bip)localObject1).liveStatus == 1))
    {
      i = 1;
      if (i != 0)
      {
        localView.setVisibility(0);
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label458;
        }
        localView.setVisibility(8);
        label144:
        localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (localObject1 == null) {
          break label539;
        }
      }
    }
    label528:
    label534:
    label539:
    for (int i = ((bip)localObject1).EOg;; i = 0)
    {
      localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
      label181:
      int j;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.i("NearbyFinderSquareLiveF.NearbyLiveViewCallback", "participantCountString: " + localObject1 + " participantCount: " + i);
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label497;
        }
        j = 1;
        label240:
        localObject2 = localObject1;
        if (j != 0)
        {
          localObject2 = localObject1;
          if (i > 0) {
            localObject2 = String.valueOf(r.TT(i));
          }
        }
        localObject1 = (CharSequence)localObject2;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label503;
        }
        i = 1;
        label290:
        if (i != 0) {
          break label508;
        }
        localTextView1.setText((CharSequence)localObject2);
        localTextView1.setVisibility(0);
        localViewGroup.setTag(f.d.finder_accessibility_live_participant_count_tag, localTextView1.getText());
        label323:
        ((TextView)paramj.UH(f.d.finder_desc)).setVisibility(8);
        if (!((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isFinderLiveActivityIconEntranceEnable()) {
          break label528;
        }
        paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (paramBaseFinderFeed == null) {
          break label534;
        }
        paramBaseFinderFeed = paramBaseFinderFeed.ZSd;
        if (paramBaseFinderFeed == null) {
          break label534;
        }
        paramBaseFinderFeed = (Integer)p.ae((List)paramBaseFinderFeed, 0);
        if (paramBaseFinderFeed == null) {
          break label534;
        }
      }
      for (i = ((Number)paramBaseFinderFeed).intValue();; i = 0)
      {
        Log.i("NearbyLiveViewCallback", s.X("#bindIconToActivityImageView activityInfoIcon=", Integer.valueOf(i)));
        paramBaseFinderFeed = f.a.ahpZ;
        i = f.a.a.getImageResFromActivityType(i);
        paramj = (ImageView)paramj.UH(f.d.iv_live_activity_info_icon);
        if (paramj != null)
        {
          if (i == 0)
          {
            paramj.setVisibility(4);
            AppMethodBeat.o(340953);
            return;
            i = 0;
            break;
            label458:
            localTextView2.setText((CharSequence)localObject1);
            localViewGroup.setTag(f.d.finder_accessibility_live_rec_reason_tag, localObject1);
            localView.setVisibility(0);
            break label144;
            localObject1 = ((bip)localObject1).ZSo;
            break label181;
            label497:
            j = 0;
            break label240;
            label503:
            i = 0;
            break label290;
            label508:
            localTextView1.setVisibility(8);
            break label323;
          }
          paramj.setImageResource(i);
          paramj.setVisibility(0);
        }
        AppMethodBeat.o(340953);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderSquareLiveFeedConvert$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderSquareLiveFeedConvert$bindActivityIcon$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e.b
  {
    b(ImageView paramImageView) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(340881);
      s.u(paramView, "view");
      if (!paramBoolean)
      {
        Log.i("NearbyLiveViewCallback", "#bindActivityIcon onViewExposedListener false, cancel it");
        paramView = this.Byq;
        s.s(paramView, "iconView");
        b.gz((View)paramView);
      }
      AppMethodBeat.o(340881);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(com.tencent.mm.view.recyclerview.j paramj, BaseFinderFeed paramBaseFinderFeed, ImageView paramImageView, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(340904);
      paramObject = (kotlin.d.d)new c(this.wHm, paramBaseFinderFeed, paramList, paramd);
      AppMethodBeat.o(340904);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(340892);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(340892);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
        Context localContext = this.wHm.context;
        s.s(localContext, "holder.context");
        long l = paramBaseFinderFeed.feedObject.field_id;
        String str = paramBaseFinderFeed.feedObject.getObjectNonceId();
        ImageView localImageView = paramList;
        s.s(localImageView, "iconView");
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.executeCirculationFillingActivityIcon(localContext, l, str, localImageView, 1, locald) == locala)
        {
          AppMethodBeat.o(340892);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(340892);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.convert.b
 * JD-Core Version:    0.7.0.1
 */