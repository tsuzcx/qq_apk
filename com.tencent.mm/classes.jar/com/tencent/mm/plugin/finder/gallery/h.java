package com.tencent.mm.plugin.finder.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGallerySnsCoverConfig;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig;", "data", "Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "(Lcom/tencent/mm/plugin/finder/gallery/ConfigData;)V", "lastFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLastFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setLastFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "lastSelectFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLastSelectFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setLastSelectFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "selectTabType", "", "getSelectTabType", "()I", "setSelectTabType", "(I)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "tabType", "dealPreviewResult", "", "requestCode", "resultCode", "activity", "Lcom/tencent/mm/ui/MMActivity;", "inSearch", "enableGalleryTimelinePage", "forceDarkMode", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getRequestCode", "onActivityResult", "", "Landroid/content/Intent;", "curActivity", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "onFeedSelected", "feed", "dataList", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "fromSeach", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends d
{
  private BaseFinderFeed BuW;
  private int BuY;
  private FinderObject BuZ;
  
  public h(a parama)
  {
    super(parama);
    AppMethodBeat.i(334278);
    AppMethodBeat.o(334278);
  }
  
  private final boolean a(int paramInt1, int paramInt2, MMActivity paramMMActivity, boolean paramBoolean)
  {
    long l = 0L;
    AppMethodBeat.i(334289);
    FinderObject localFinderObject = null;
    Object localObject = this.BuW;
    if (this.BuZ != null)
    {
      localFinderObject = this.BuZ;
      if ((paramInt1 != 10003) || (paramInt2 != -1) || (localFinderObject == null)) {
        break label149;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("SELECT_OBJECT", localFinderObject.toByteArray());
      ((Intent)localObject).putExtra("SELECT_TAB_TYPE", this.BuY);
      paramMMActivity.setResult(-1, (Intent)localObject);
      paramMMActivity.finish();
      if (paramBoolean) {
        break label134;
      }
      paramMMActivity = f.BuT;
      f.nP(localFinderObject.id);
    }
    for (;;)
    {
      AppMethodBeat.o(334289);
      return true;
      if (localObject == null) {
        break;
      }
      localFinderObject = ((BaseFinderFeed)localObject).feedObject.getFeedObject();
      break;
      label134:
      paramMMActivity = f.BuT;
      f.nR(localFinderObject.id);
    }
    label149:
    if (paramInt1 == 10003)
    {
      if (paramBoolean) {
        break label192;
      }
      paramMMActivity = f.BuT;
      if (localFinderObject != null) {
        break label182;
      }
    }
    for (;;)
    {
      f.nQ(l);
      AppMethodBeat.o(334289);
      return false;
      label182:
      l = localFinderObject.id;
    }
    label192:
    paramMMActivity = f.BuT;
    if (localFinderObject == null) {}
    for (;;)
    {
      f.nS(l);
      break;
      l = localFinderObject.id;
    }
  }
  
  public final com.tencent.mm.view.recyclerview.g Os(int paramInt)
  {
    AppMethodBeat.i(334321);
    if (!egz())
    {
      localg = (com.tencent.mm.view.recyclerview.g)new b();
      AppMethodBeat.o(334321);
      return localg;
    }
    com.tencent.mm.view.recyclerview.g localg = super.Os(paramInt);
    AppMethodBeat.o(334321);
    return localg;
  }
  
  public final RecyclerView.h Ot(int paramInt)
  {
    AppMethodBeat.i(334353);
    if (!egz())
    {
      localh = (RecyclerView.h)new c();
      AppMethodBeat.o(334353);
      return localh;
    }
    RecyclerView.h localh = super.Ot(paramInt);
    AppMethodBeat.o(334353);
    return localh;
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, b.b paramb)
  {
    AppMethodBeat.i(334311);
    s.u(paramMMActivity, "activity");
    s.u(paramb, "curActivity");
    if (paramIntent != null) {
      this.BuY = paramIntent.getIntExtra("TAB_TYPE", 0);
    }
    Object localObject;
    if (paramIntent == null)
    {
      localObject = null;
      if (localObject != null)
      {
        FinderObject localFinderObject = new FinderObject();
        localFinderObject.parseFrom((byte[])localObject);
        localObject = ah.aiuX;
        this.BuZ = localFinderObject;
      }
      switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(334311);
      return;
      localObject = paramIntent.getByteArrayExtra("SELECT_OBJECT");
      break;
      if ((!a(paramInt1, paramInt2, paramMMActivity, false)) && (paramInt1 == 20000) && (paramInt2 == -1))
      {
        paramMMActivity.setResult(-1, paramIntent);
        paramMMActivity.finish();
        AppMethodBeat.o(334311);
        return;
        a(paramInt1, paramInt2, paramMMActivity, true);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, BaseFinderFeed paramBaseFinderFeed, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(334299);
    s.u(paramMMActivity, "activity");
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramList, "dataList");
    this.BuW = paramBaseFinderFeed;
    paramList = new Intent();
    this.BuY = paramInt;
    paramList.putExtra("SELECT_OBJECT", paramBaseFinderFeed.feedObject.getFeedObject().toByteArray());
    ((n)com.tencent.mm.kernel.h.ax(n.class)).g((Activity)paramMMActivity, paramList, 10003);
    AppMethodBeat.o(334299);
  }
  
  public final RecyclerView.LayoutManager aq(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(334350);
    s.u(paramContext, "context");
    if (!egz())
    {
      paramContext = new GridLayoutManager(3);
      paramContext.setItemPrefetchEnabled(true);
      paramContext = (RecyclerView.LayoutManager)paramContext;
      AppMethodBeat.o(334350);
      return paramContext;
    }
    paramContext = super.aq(paramContext, paramInt);
    AppMethodBeat.o(334350);
    return paramContext;
  }
  
  public final boolean egw()
  {
    AppMethodBeat.i(334334);
    if (!egz())
    {
      AppMethodBeat.o(334334);
      return true;
    }
    AppMethodBeat.o(334334);
    return false;
  }
  
  public final boolean egx()
  {
    AppMethodBeat.i(334329);
    boolean bool = egz();
    AppMethodBeat.o(334329);
    return bool;
  }
  
  public final int egy()
  {
    return 10003;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGallerySnsCoverConfig$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(334267);
      switch (paramInt)
      {
      default: 
        localObject = av.GiL;
        av.eY("FinderStaggeredConfig", paramInt);
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(334267);
        return localObject;
      case 4: 
      case 9: 
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.gallery.convert.a();
        AppMethodBeat.o(334267);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.gallery.convert.a();
      AppMethodBeat.o(334267);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGallerySnsCoverConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(334273);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof GridLayoutManager.LayoutParams)) {}
      for (paramView = (GridLayoutManager.LayoutParams)paramView;; paramView = null)
      {
        if (paramView != null)
        {
          if (paramView.bWs % 3 == 1)
          {
            paramRect.left = 1;
            paramRect.right = 1;
          }
          paramRect.bottom = 1;
          paramRect.top = 0;
        }
        AppMethodBeat.o(334273);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.h
 * JD-Core Version:    0.7.0.1
 */