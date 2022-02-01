package com.tencent.mm.plugin.finder.gallery;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.gallery.convert.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryRingToneConfig;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig;", "data", "Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "(Lcom/tencent/mm/plugin/finder/gallery/ConfigData;)V", "lastSelectFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLastSelectFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setLastSelectFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "tabType", "", "dealPreviewResult", "", "requestCode", "resultCode", "activity", "Lcom/tencent/mm/ui/MMActivity;", "inSearch", "onActivityResult", "", "Landroid/content/Intent;", "curActivity", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "onFeedSelected", "feed", "dataList", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "fromSearch", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends d
{
  private BaseFinderFeed BuW;
  
  public g(a parama)
  {
    super(parama);
    AppMethodBeat.i(334298);
    AppMethodBeat.o(334298);
  }
  
  private final boolean a(int paramInt1, int paramInt2, MMActivity paramMMActivity, boolean paramBoolean)
  {
    long l = 0L;
    AppMethodBeat.i(334313);
    BaseFinderFeed localBaseFinderFeed = this.BuW;
    if ((paramInt1 == 10002) && (paramInt2 == -1) && (localBaseFinderFeed != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("SELECT_OBJECT", localBaseFinderFeed.feedObject.getFeedObject().toByteArray());
      paramMMActivity.setResult(-1, localIntent);
      paramMMActivity.finish();
      if (!paramBoolean)
      {
        paramMMActivity = f.BuT;
        paramMMActivity = this.BuW;
        if (paramMMActivity == null) {}
        for (;;)
        {
          f.nP(l);
          AppMethodBeat.o(334313);
          return true;
          l = paramMMActivity.bZA();
        }
      }
      paramMMActivity = f.BuT;
      paramMMActivity = this.BuW;
      if (paramMMActivity == null) {}
      for (;;)
      {
        f.nR(l);
        break;
        l = paramMMActivity.bZA();
      }
    }
    if (paramInt1 == 10002)
    {
      if (paramBoolean) {
        break label185;
      }
      paramMMActivity = f.BuT;
      paramMMActivity = this.BuW;
      if (paramMMActivity != null) {
        break label176;
      }
    }
    for (;;)
    {
      f.nQ(l);
      AppMethodBeat.o(334313);
      return false;
      label176:
      l = paramMMActivity.bZA();
    }
    label185:
    paramMMActivity = f.BuT;
    paramMMActivity = this.BuW;
    if (paramMMActivity == null) {}
    for (;;)
    {
      f.nS(l);
      break;
      l = paramMMActivity.bZA();
    }
  }
  
  public final com.tencent.mm.view.recyclerview.g Os(int paramInt)
  {
    AppMethodBeat.i(334340);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new b(this);
    AppMethodBeat.o(334340);
    return localg;
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, b.b paramb)
  {
    AppMethodBeat.i(334332);
    s.u(paramMMActivity, "activity");
    s.u(paramb, "curActivity");
    switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(334332);
      return;
      if ((!a(paramInt1, paramInt2, paramMMActivity, false)) && (paramInt1 == 20000) && (paramInt2 == -1))
      {
        paramMMActivity.setResult(-1, paramIntent);
        paramMMActivity.finish();
        AppMethodBeat.o(334332);
        return;
        a(paramInt1, paramInt2, paramMMActivity, true);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, BaseFinderFeed paramBaseFinderFeed, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(334324);
    s.u(paramMMActivity, "activity");
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramList, "dataList");
    if (paramBaseFinderFeed.feedObject.getMediaType() != 4)
    {
      AppMethodBeat.o(334324);
      return;
    }
    this.BuW = paramBaseFinderFeed;
    h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class);
    paramBaseFinderFeed.feedObject.getFinderObject();
    AppMethodBeat.o(334324);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryRingToneConfig$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(g paramg) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(334145);
      switch (paramInt)
      {
      default: 
        localObject = av.GiL;
        av.eY("FinderStaggeredConfig", paramInt);
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(334145);
        return localObject;
      case 4: 
      case 9: 
        localObject = (com.tencent.mm.view.recyclerview.f)new a(this.BuX);
        AppMethodBeat.o(334145);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.f)new b(this.BuX);
      AppMethodBeat.o(334145);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryRingToneConfig$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends ah
    {
      a(g paramg) {}
      
      public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(334137);
        s.u(paramj, "holder");
        s.u(paramBaseFinderFeed, "item");
        super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = b.Bvm;
        paramList = paramj.caK;
        s.s(paramList, "holder.itemView");
        b.a(paramList, paramBaseFinderFeed, true, this.BuX.egw());
        paramBaseFinderFeed = paramj.caK.findViewById(e.e.finder_like_container);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(8);
        }
        paramBaseFinderFeed = paramj.caK.findViewById(e.e.profile_upload_area);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(8);
        }
        paramj = paramj.caK.findViewById(e.e.profile_item_failed_area);
        if (paramj != null) {
          paramj.setVisibility(8);
        }
        AppMethodBeat.o(334137);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryRingToneConfig$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends u
    {
      b(g paramg) {}
      
      public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(334133);
        s.u(paramj, "holder");
        s.u(paramBaseFinderFeed, "item");
        super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = b.Bvm;
        paramList = paramj.caK;
        s.s(paramList, "holder.itemView");
        b.a(paramList, paramBaseFinderFeed, false, this.BuX.egw());
        paramBaseFinderFeed = paramj.caK.findViewById(e.e.finder_like_container);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(8);
        }
        paramBaseFinderFeed = paramj.caK.findViewById(e.e.profile_upload_area);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(8);
        }
        paramj = paramj.caK.findViewById(e.e.profile_item_failed_area);
        if (paramj != null) {
          paramj.setVisibility(8);
        }
        AppMethodBeat.o(334133);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.g
 * JD-Core Version:    0.7.0.1
 */