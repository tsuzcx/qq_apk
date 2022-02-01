package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "subVideoPaths", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "videoIsBeauty", "", "addVideoPath", "", "path", "isBeauty", "getMediaItems", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSize", "", "getVideoList", "initConfig", "isVideoEmpty", "release", "removeTopVideo", "Companion", "plugin-finder_release"})
public final class f
  implements t
{
  public static final f.a whc;
  private RecordConfigProvider wdm;
  private d wgr;
  public ArrayList<String> wha;
  private ArrayList<Boolean> whb;
  
  static
  {
    AppMethodBeat.i(254493);
    whc = new f.a((byte)0);
    AppMethodBeat.o(254493);
  }
  
  public f(d paramd)
  {
    AppMethodBeat.i(254492);
    this.wgr = paramd;
    this.wha = new ArrayList();
    this.whb = new ArrayList();
    AppMethodBeat.o(254492);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(254486);
    p.h(paramRecordConfigProvider, "configProvider");
    this.wdm = paramRecordConfigProvider;
    AppMethodBeat.o(254486);
  }
  
  public final void aSs() {}
  
  public final void bw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(254487);
    p.h(paramString, "path");
    this.wha.add(paramString);
    this.whb.add(Boolean.valueOf(paramBoolean));
    Log.i("MicroMsg.FinderSubVideoFilePlugin", "current video size:" + this.wha.size() + " add path:" + paramString + ", " + paramBoolean);
    AppMethodBeat.o(254487);
  }
  
  public final void dFT()
  {
    AppMethodBeat.i(254488);
    if (!((Collection)this.wha).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        String str = (String)j.ku((List)this.wha);
        this.wha.remove(this.wha.size() - 1);
        h.RTc.aZ((Runnable)new f.c(str));
      }
      if (((Collection)this.whb).isEmpty()) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.whb.remove(this.whb.size() - 1);
      }
      Log.i("MicroMsg.FinderSubVideoFilePlugin", "current file list size:" + this.wha.size());
      AppMethodBeat.o(254488);
      return;
      i = 0;
      break;
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> dFU()
  {
    AppMethodBeat.i(254489);
    ArrayList localArrayList = new ArrayList();
    int j = this.wha.size();
    int i = 0;
    if (i < j)
    {
      GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(2, 0L, (String)this.wha.get(i), "", "");
      Object localObject = (List)this.whb;
      if ((i >= 0) && (i <= j.kq((List)localObject))) {}
      for (localObject = ((List)localObject).get(i);; localObject = Boolean.FALSE)
      {
        localMediaItem.u("KEY_MEDIA_IS_BEAUTY", localObject);
        Log.i("MicroMsg.FinderSubVideoFilePlugin", "add sub video path:" + (String)this.wha.get(i));
        localArrayList.add(localMediaItem);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(254489);
    return localArrayList;
  }
  
  public final ArrayList<String> dFV()
  {
    AppMethodBeat.i(254490);
    ArrayList localArrayList = new ArrayList((Collection)this.wha);
    AppMethodBeat.o(254490);
    return localArrayList;
  }
  
  public final String name()
  {
    return null;
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
    AppMethodBeat.i(254494);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(254494);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(254491);
    Log.i("MicroMsg.FinderSubVideoFilePlugin", "release");
    h.RTc.aX((Runnable)new f.b(this));
    AppMethodBeat.o(254491);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.f
 * JD-Core Version:    0.7.0.1
 */