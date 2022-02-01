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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "", "data", "Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "(Lcom/tencent/mm/plugin/finder/gallery/ConfigData;)V", "getData", "()Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "tabType", "", "enableGalleryTimelinePage", "", "forceDarkMode", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getRequestCode", "getTabFragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "defaultSelected", "getTabTitle", "", "onActivityResult", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "resultCode", "Landroid/content/Intent;", "curActivity", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "onFeedSelected", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "fromSeach", "onFinish", "Companion", "UI", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  public static final a Bus = new a((byte)0);
  private static final String TAG = "Finder.FinderGalleryConfig";
  public final a But;
  
  public b(a parama)
  {
    this.But = parama;
  }
  
  public abstract com.tencent.mm.view.recyclerview.g Os(int paramInt);
  
  public abstract RecyclerView.h Ot(int paramInt);
  
  public abstract void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, b paramb);
  
  public abstract void a(MMActivity paramMMActivity, int paramInt, BaseFinderFeed paramBaseFinderFeed, List<? extends BaseFinderFeed> paramList);
  
  public abstract String ap(Context paramContext, int paramInt);
  
  public abstract RecyclerView.LayoutManager aq(Context paramContext, int paramInt);
  
  public abstract MMFinderFragment c(Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract boolean egw();
  
  public abstract boolean egx();
  
  public abstract int egy();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$Companion;", "", "()V", "TAG", "", "createGalleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "intent", "Landroid/content/Intent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b au(Intent paramIntent)
    {
      AppMethodBeat.i(334360);
      s.u(paramIntent, "intent");
      ArrayList localArrayList = paramIntent.getIntegerArrayListExtra("TAB_LIST");
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      int i;
      byte[] arrayOfByte;
      for (;;)
      {
        i = paramIntent.getIntExtra("BIZ_SCENE", 0);
        arrayOfByte = paramIntent.getByteArrayExtra("EXT_BUFF");
        com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)new FinderObject();
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
          AppMethodBeat.o(334360);
          return paramIntent;
        }
        paramIntent = (FinderObject)paramIntent;
        Log.i(b.access$getTAG$cp(), "createGalleryConfig, bizScene:" + i + ", tabList size:" + localArrayList.size() + ", extBuff:" + arrayOfByte);
        switch (i)
        {
        default: 
          paramIntent = (b)new d(new a(localArrayList, i, arrayOfByte, paramIntent));
          AppMethodBeat.o(334360);
          return paramIntent;
        }
      }
      paramIntent = (b)new g(new a(localArrayList, i, arrayOfByte, paramIntent));
      AppMethodBeat.o(334360);
      return paramIntent;
      paramIntent = (b)new h(new a(localArrayList, i, arrayOfByte, paramIntent));
      AppMethodBeat.o(334360);
      return paramIntent;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "", "(Ljava/lang/String;I)V", "GALLERY", "SEARCH", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(334354);
      Buu = new b("GALLERY", 0);
      Buv = new b("SEARCH", 1);
      Buw = new b[] { Buu, Buv };
      AppMethodBeat.o(334354);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.b
 * JD-Core Version:    0.7.0.1
 */