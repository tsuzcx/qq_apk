package com.tencent.mm.plugin.finder.gallery;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.convert.an;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryRingToneConfig;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig;", "data", "Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "(Lcom/tencent/mm/plugin/finder/gallery/ConfigData;)V", "lastSelectFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLastSelectFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setLastSelectFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "tabType", "", "dealPreviewResult", "", "requestCode", "resultCode", "activity", "Lcom/tencent/mm/ui/MMActivity;", "inSearch", "onActivityResult", "", "Landroid/content/Intent;", "curActivity", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "onFeedSelected", "feed", "dataList", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "fromSearch", "plugin-finder_release"})
public final class g
  extends d
{
  private BaseFinderFeed xUb;
  
  public g(a parama)
  {
    super(parama);
    AppMethodBeat.i(264127);
    AppMethodBeat.o(264127);
  }
  
  private final boolean a(int paramInt1, int paramInt2, MMActivity paramMMActivity, boolean paramBoolean)
  {
    long l = 0L;
    AppMethodBeat.i(264123);
    BaseFinderFeed localBaseFinderFeed = this.xUb;
    if ((paramInt1 == 10002) && (paramInt2 == -1) && (localBaseFinderFeed != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("SELECT_OBJECT", localBaseFinderFeed.feedObject.getFeedObject().toByteArray());
      paramMMActivity.setResult(-1, localIntent);
      paramMMActivity.finish();
      if (!paramBoolean)
      {
        paramMMActivity = f.xUa;
        paramMMActivity = this.xUb;
        if (paramMMActivity != null) {
          l = paramMMActivity.mf();
        }
        f.Lc(l);
      }
      for (;;)
      {
        AppMethodBeat.o(264123);
        return true;
        paramMMActivity = f.xUa;
        paramMMActivity = this.xUb;
        if (paramMMActivity != null) {
          l = paramMMActivity.mf();
        }
        f.Le(l);
      }
    }
    if (paramInt1 == 10002)
    {
      if (paramBoolean) {
        break label176;
      }
      paramMMActivity = f.xUa;
      paramMMActivity = this.xUb;
      if (paramMMActivity != null) {
        l = paramMMActivity.mf();
      }
      f.Ld(l);
    }
    for (;;)
    {
      AppMethodBeat.o(264123);
      return false;
      label176:
      paramMMActivity = f.xUa;
      paramMMActivity = this.xUb;
      if (paramMMActivity != null) {
        l = paramMMActivity.mf();
      }
      f.Lf(l);
    }
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, b.b paramb)
  {
    AppMethodBeat.i(264121);
    p.k(paramMMActivity, "activity");
    p.k(paramb, "curActivity");
    switch (h.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(264121);
      return;
      if ((!a(paramInt1, paramInt2, paramMMActivity, false)) && (paramInt1 == 20000) && (paramInt2 == -1))
      {
        paramMMActivity.setResult(-1, paramIntent);
        paramMMActivity.finish();
        AppMethodBeat.o(264121);
        return;
        a(paramInt1, paramInt2, paramMMActivity, true);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, BaseFinderFeed paramBaseFinderFeed, List<? extends BaseFinderFeed> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(264119);
    p.k(paramMMActivity, "activity");
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramList, "dataList");
    if (paramBaseFinderFeed.feedObject.getMediaType() != 4)
    {
      AppMethodBeat.o(264119);
      return;
    }
    atl localatl;
    if (!paramBoolean)
    {
      localatl = new atl();
      localatl.tab_type = paramInt;
      localatl.scene = this.xTx.kqZ;
      if (this.xTx.xTv != null) {
        break label135;
      }
    }
    label135:
    for (paramMMActivity = null;; paramMMActivity = com.tencent.mm.cd.b.cU(this.xTx.xTv))
    {
      localatl.SDH = paramMMActivity;
      paramMMActivity = paramList.iterator();
      while ((paramMMActivity.hasNext()) && (!p.h((BaseFinderFeed)paramMMActivity.next(), paramBaseFinderFeed))) {}
      this.xUb = paramBaseFinderFeed;
      AppMethodBeat.o(264119);
      return;
    }
  }
  
  public final com.tencent.mm.view.recyclerview.f dwa()
  {
    AppMethodBeat.i(264125);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(264125);
    return localf;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryRingToneConfig$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(282490);
      switch (paramInt)
      {
      default: 
        localObject = aj.AGc;
        aj.em("FinderStaggeredConfig", paramInt);
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(282490);
        return localObject;
      case 4: 
      case 9: 
        localObject = (e)new a(this);
        AppMethodBeat.o(282490);
        return localObject;
      }
      Object localObject = (e)new b(this);
      AppMethodBeat.o(282490);
      return localObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryRingToneConfig$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends an
    {
      public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(279464);
        p.k(parami, "holder");
        p.k(paramBaseFinderFeed, "item");
        super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = com.tencent.mm.plugin.finder.gallery.convert.b.xUn;
        paramList = parami.amk;
        p.j(paramList, "holder.itemView");
        com.tencent.mm.plugin.finder.gallery.convert.b.a(paramList, paramBaseFinderFeed, true, this.xUd.xUc.dwb());
        paramBaseFinderFeed = parami.amk.findViewById(b.f.finder_like_container);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(8);
        }
        paramBaseFinderFeed = parami.amk.findViewById(b.f.profile_upload_area);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(8);
        }
        parami = parami.amk.findViewById(b.f.profile_item_failed_area);
        if (parami != null)
        {
          parami.setVisibility(8);
          AppMethodBeat.o(279464);
          return;
        }
        AppMethodBeat.o(279464);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryRingToneConfig$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends w
    {
      public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(290113);
        p.k(parami, "holder");
        p.k(paramBaseFinderFeed, "item");
        super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = com.tencent.mm.plugin.finder.gallery.convert.b.xUn;
        paramList = parami.amk;
        p.j(paramList, "holder.itemView");
        com.tencent.mm.plugin.finder.gallery.convert.b.a(paramList, paramBaseFinderFeed, false, this.xUd.xUc.dwb());
        paramBaseFinderFeed = parami.amk.findViewById(b.f.finder_like_container);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(8);
        }
        paramBaseFinderFeed = parami.amk.findViewById(b.f.profile_upload_area);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setVisibility(8);
        }
        parami = parami.amk.findViewById(b.f.profile_item_failed_area);
        if (parami != null)
        {
          parami.setVisibility(8);
          AppMethodBeat.o(290113);
          return;
        }
        AppMethodBeat.o(290113);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.g
 * JD-Core Version:    0.7.0.1
 */