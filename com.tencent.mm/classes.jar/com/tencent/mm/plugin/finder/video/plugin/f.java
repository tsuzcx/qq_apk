package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "subVideoPaths", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "videoIsBeauty", "", "addVideoPath", "", "path", "isBeauty", "getMediaItems", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSize", "", "getVideoList", "initConfig", "isVideoEmpty", "release", "removeTopVideo", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements v
{
  public static final f.a GsW;
  private a GrC;
  public ArrayList<String> GsX;
  private ArrayList<Boolean> GsY;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(335487);
    GsW = new f.a((byte)0);
    AppMethodBeat.o(335487);
  }
  
  public f(a parama)
  {
    AppMethodBeat.i(335468);
    this.GrC = parama;
    this.GsX = new ArrayList();
    this.GsY = new ArrayList();
    AppMethodBeat.o(335468);
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(335475);
    s.u(paramf, "this$0");
    Iterator localIterator = ((Iterable)paramf.GsX).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      com.tencent.mm.plugin.recordvideo.util.f localf = com.tencent.mm.plugin.recordvideo.util.f.Obq;
      com.tencent.mm.plugin.recordvideo.util.f.aTp(str);
    }
    paramf.GsX.clear();
    AppMethodBeat.o(335475);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335564);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(335564);
  }
  
  public final void bV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(335513);
    s.u(paramString, "path");
    this.GsX.add(paramString);
    this.GsY.add(Boolean.valueOf(paramBoolean));
    Log.i("MicroMsg.FinderSubVideoFilePlugin", "current video size:" + this.GsX.size() + " add path:" + paramString + ", " + paramBoolean);
    AppMethodBeat.o(335513);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(335587);
    s.u(this, "this");
    AppMethodBeat.o(335587);
  }
  
  public final void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335503);
    s.u(paramRecordConfigProvider, "configProvider");
    this.oaV = paramRecordConfigProvider;
    AppMethodBeat.o(335503);
  }
  
  public final void fjP()
  {
    AppMethodBeat.i(335527);
    if (!((Collection)this.GsX).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        String str = (String)p.oM((List)this.GsX);
        this.GsX.remove(this.GsX.size() - 1);
        com.tencent.mm.plugin.recordvideo.util.f localf = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.aOJ(str);
      }
      if (((Collection)this.GsY).isEmpty()) {
        break label134;
      }
    }
    label134:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.GsY.remove(this.GsY.size() - 1);
      }
      Log.i("MicroMsg.FinderSubVideoFilePlugin", s.X("current file list size:", Integer.valueOf(this.GsX.size())));
      AppMethodBeat.o(335527);
      return;
      i = 0;
      break;
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> fjQ()
  {
    AppMethodBeat.i(335537);
    ArrayList localArrayList = new ArrayList();
    int k = this.GsX.size();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(2, 0L, (String)this.GsX.get(i), "", "");
      Object localObject = (List)this.GsY;
      if ((i >= 0) && (i <= p.oE((List)localObject))) {}
      for (localObject = ((List)localObject).get(i);; localObject = Boolean.FALSE)
      {
        localMediaItem.G("KEY_MEDIA_IS_BEAUTY", localObject);
        Log.i("MicroMsg.FinderSubVideoFilePlugin", s.X("add sub video path:", this.GsX.get(i)));
        localArrayList.add(localMediaItem);
        if (j < k) {
          break;
        }
        AppMethodBeat.o(335537);
        return localArrayList;
      }
    }
  }
  
  public final ArrayList<String> fjR()
  {
    AppMethodBeat.i(335547);
    ArrayList localArrayList = new ArrayList((Collection)this.GsX);
    AppMethodBeat.o(335547);
    return localArrayList;
  }
  
  public final String name()
  {
    AppMethodBeat.i(335571);
    String str = v.a.b(this);
    AppMethodBeat.o(335571);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(335580);
    s.u(this, "this");
    AppMethodBeat.o(335580);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(335592);
    s.u(this, "this");
    AppMethodBeat.o(335592);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(335596);
    s.u(this, "this");
    AppMethodBeat.o(335596);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(335603);
    s.u(this, "this");
    AppMethodBeat.o(335603);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(335612);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(335612);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(335617);
    s.u(this, "this");
    AppMethodBeat.o(335617);
  }
  
  public final void release()
  {
    AppMethodBeat.i(335555);
    Log.i("MicroMsg.FinderSubVideoFilePlugin", "release");
    s.u((v)this, "this");
    h.ahAA.bm(new f..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(335555);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(335623);
    s.u(this, "this");
    AppMethodBeat.o(335623);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(335633);
    s.u(this, "this");
    AppMethodBeat.o(335633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.f
 * JD-Core Version:    0.7.0.1
 */