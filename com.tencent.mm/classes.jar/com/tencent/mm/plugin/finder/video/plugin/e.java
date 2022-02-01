package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "subVideoPaths", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "videoIsBeauty", "", "addVideoPath", "", "path", "isBeauty", "getMediaItems", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSize", "", "getVideoList", "initConfig", "isVideoEmpty", "release", "removeTopVideo", "Companion", "plugin-finder_release"})
public final class e
  implements t
{
  public static final e.a sQP;
  private RecordConfigProvider sNI;
  private d sQE;
  public ArrayList<String> sQN;
  private ArrayList<Boolean> sQO;
  
  static
  {
    AppMethodBeat.i(204949);
    sQP = new e.a((byte)0);
    AppMethodBeat.o(204949);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(204948);
    this.sQE = paramd;
    this.sQN = new ArrayList();
    this.sQO = new ArrayList();
    AppMethodBeat.o(204948);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(204942);
    p.h(paramRecordConfigProvider, "configProvider");
    this.sNI = paramRecordConfigProvider;
    AppMethodBeat.o(204942);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final void bg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(204943);
    p.h(paramString, "path");
    this.sQN.add(paramString);
    this.sQO.add(Boolean.valueOf(paramBoolean));
    ad.i("MicroMsg.FinderSubVideoFilePlugin", "current video size:" + this.sQN.size() + " add path:" + paramString + ", " + paramBoolean);
    AppMethodBeat.o(204943);
  }
  
  public final void cMM()
  {
    AppMethodBeat.i(204944);
    if (!((Collection)this.sQN).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        String str = (String)j.je((List)this.sQN);
        this.sQN.remove(this.sQN.size() - 1);
        h.LTJ.aT((Runnable)new c(str));
      }
      if (((Collection)this.sQO).isEmpty()) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.sQO.remove(this.sQO.size() - 1);
      }
      ad.i("MicroMsg.FinderSubVideoFilePlugin", "current file list size:" + this.sQN.size());
      AppMethodBeat.o(204944);
      return;
      i = 0;
      break;
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> cMN()
  {
    AppMethodBeat.i(204945);
    ArrayList localArrayList = new ArrayList();
    int j = this.sQN.size();
    int i = 0;
    if (i < j)
    {
      GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(2, 0L, (String)this.sQN.get(i), "", "");
      Object localObject = (List)this.sQO;
      if ((i >= 0) && (i <= j.ja((List)localObject))) {}
      for (localObject = ((List)localObject).get(i);; localObject = Boolean.FALSE)
      {
        localMediaItem.s("KEY_MEDIA_IS_BEAUTY", localObject);
        ad.i("MicroMsg.FinderSubVideoFilePlugin", "add sub video path:" + (String)this.sQN.get(i));
        localArrayList.add(localMediaItem);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(204945);
    return localArrayList;
  }
  
  public final ArrayList<String> cMO()
  {
    AppMethodBeat.i(204946);
    ArrayList localArrayList = new ArrayList((Collection)this.sQN);
    AppMethodBeat.o(204946);
    return localArrayList;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(204950);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(204950);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(204947);
    ad.i("MicroMsg.FinderSubVideoFilePlugin", "release");
    h.LTJ.aR((Runnable)new b(this));
    AppMethodBeat.o(204947);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(204940);
      Iterator localIterator = ((Iterable)e.a(this.sQQ)).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        b localb = b.xRl;
        b.avP(str);
      }
      e.a(this.sQQ).clear();
      AppMethodBeat.o(204940);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(204941);
      com.tencent.mm.vfs.i.deleteFile(this.sQR);
      AppMethodBeat.o(204941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.e
 * JD-Core Version:    0.7.0.1
 */