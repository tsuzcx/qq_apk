package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "", "data", "Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "(Lcom/tencent/mm/plugin/finder/gallery/ConfigData;)V", "getData", "()Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "tabType", "", "forceDarkMode", "", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getTabFragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "defaultSelected", "getTabTitle", "", "onActivityResult", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "resultCode", "Landroid/content/Intent;", "curActivity", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "onFeedSelected", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "fromSeach", "Companion", "UI", "plugin-finder_release"})
public abstract class b
{
  private static final String TAG = "Finder.FinderGalleryConfig";
  public static final a xTy = new a((byte)0);
  public final a xTx;
  
  public b(a parama)
  {
    this.xTx = parama;
  }
  
  public abstract void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, b paramb);
  
  public abstract void a(MMActivity paramMMActivity, int paramInt, BaseFinderFeed paramBaseFinderFeed, List<? extends BaseFinderFeed> paramList, boolean paramBoolean);
  
  public abstract String ag(Context paramContext, int paramInt);
  
  public abstract MMFinderFragment c(Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract f dwa();
  
  public abstract boolean dwb();
  
  public abstract RecyclerView.h dwc();
  
  public abstract RecyclerView.LayoutManager ft(Context paramContext);
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$Companion;", "", "()V", "TAG", "", "createGalleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "intent", "Landroid/content/Intent;", "plugin-finder_release"})
  public static final class a
  {
    public static b aj(Intent paramIntent)
    {
      AppMethodBeat.i(282093);
      p.k(paramIntent, "intent");
      ArrayList localArrayList = paramIntent.getIntegerArrayListExtra("TAB_LIST");
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        int i = paramIntent.getIntExtra("BIZ_SCENE", 0);
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("EXT_BUFF");
        com.tencent.mm.cd.a locala = (com.tencent.mm.cd.a)new FinderObject();
        paramIntent = paramIntent.getByteArrayExtra("LAST_SELECTED_OBJECT");
        try
        {
          locala.parseFrom(paramIntent);
          paramIntent = locala;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramIntent });
            paramIntent = null;
          }
          paramIntent = (b)new l(new a(localArrayList, i, arrayOfByte, paramIntent));
          AppMethodBeat.o(282093);
          return paramIntent;
        }
        paramIntent = (FinderObject)paramIntent;
        Log.i(b.access$getTAG$cp(), "createGalleryConfig, bizScene:" + i + ", tabList size:" + localArrayList.size() + ", extBuff:" + arrayOfByte);
        switch (i)
        {
        default: 
          paramIntent = (b)new d(new a(localArrayList, i, arrayOfByte, paramIntent));
          AppMethodBeat.o(282093);
          return paramIntent;
        }
        paramIntent = (b)new g(new a(localArrayList, i, arrayOfByte, paramIntent));
        AppMethodBeat.o(282093);
        return paramIntent;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "", "(Ljava/lang/String;I)V", "GALLERY", "SEARCH", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(271079);
      b localb1 = new b("GALLERY", 0);
      xTz = localb1;
      b localb2 = new b("SEARCH", 1);
      xTA = localb2;
      xTB = new b[] { localb1, localb2 };
      AppMethodBeat.o(271079);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.b
 * JD-Core Version:    0.7.0.1
 */