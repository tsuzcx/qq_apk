package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "subVideoPaths", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "videoIsBeauty", "", "addVideoPath", "", "path", "isBeauty", "getMediaItems", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSize", "", "getVideoList", "initConfig", "isVideoEmpty", "release", "removeTopVideo", "Companion", "plugin-finder_release"})
public final class f
  implements u
{
  public static final a AQS;
  private RecordConfigProvider ALV;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  public ArrayList<String> AQQ;
  private ArrayList<Boolean> AQR;
  
  static
  {
    AppMethodBeat.i(287914);
    AQS = new a((byte)0);
    AppMethodBeat.o(287914);
  }
  
  public f(com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(287913);
    this.APl = paramd;
    this.AQQ = new ArrayList();
    this.AQR = new ArrayList();
    AppMethodBeat.o(287913);
  }
  
  public final void bD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(287907);
    p.k(paramString, "path");
    this.AQQ.add(paramString);
    this.AQR.add(Boolean.valueOf(paramBoolean));
    Log.i("MicroMsg.FinderSubVideoFilePlugin", "current video size:" + this.AQQ.size() + " add path:" + paramString + ", " + paramBoolean);
    AppMethodBeat.o(287907);
  }
  
  public final void bbp() {}
  
  public final void c(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(287906);
    p.k(paramRecordConfigProvider, "configProvider");
    this.ALV = paramRecordConfigProvider;
    AppMethodBeat.o(287906);
  }
  
  public final void ehK()
  {
    AppMethodBeat.i(287909);
    if (!((Collection)this.AQQ).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        String str = (String)j.lq((List)this.AQQ);
        this.AQQ.remove(this.AQQ.size() - 1);
        com.tencent.mm.plugin.recordvideo.e.d locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        com.tencent.mm.plugin.recordvideo.e.d.aRR(str);
      }
      if (((Collection)this.AQR).isEmpty()) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.AQR.remove(this.AQR.size() - 1);
      }
      Log.i("MicroMsg.FinderSubVideoFilePlugin", "current file list size:" + this.AQQ.size());
      AppMethodBeat.o(287909);
      return;
      i = 0;
      break;
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> ehL()
  {
    AppMethodBeat.i(287910);
    ArrayList localArrayList = new ArrayList();
    int j = this.AQQ.size();
    int i = 0;
    if (i < j)
    {
      GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(2, 0L, (String)this.AQQ.get(i), "", "");
      Object localObject = (List)this.AQR;
      if ((i >= 0) && (i <= j.lk((List)localObject))) {}
      for (localObject = ((List)localObject).get(i);; localObject = Boolean.FALSE)
      {
        localMediaItem.t("KEY_MEDIA_IS_BEAUTY", localObject);
        Log.i("MicroMsg.FinderSubVideoFilePlugin", "add sub video path:" + (String)this.AQQ.get(i));
        localArrayList.add(localMediaItem);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(287910);
    return localArrayList;
  }
  
  public final ArrayList<String> ehM()
  {
    AppMethodBeat.i(287911);
    ArrayList localArrayList = new ArrayList((Collection)this.AQQ);
    AppMethodBeat.o(287911);
    return localArrayList;
  }
  
  public final String name()
  {
    AppMethodBeat.i(287915);
    String str = getClass().getName();
    AppMethodBeat.o(287915);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(287916);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(287916);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(287912);
    Log.i("MicroMsg.FinderSubVideoFilePlugin", "release");
    h.ZvG.be((Runnable)new b(this));
    AppMethodBeat.o(287912);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(287226);
      Iterator localIterator = ((Iterable)f.a(this.AQT)).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        com.tencent.mm.plugin.recordvideo.e.d locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        com.tencent.mm.plugin.recordvideo.e.d.aWg(str);
      }
      f.a(this.AQT).clear();
      AppMethodBeat.o(287226);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.f
 * JD-Core Version:    0.7.0.1
 */