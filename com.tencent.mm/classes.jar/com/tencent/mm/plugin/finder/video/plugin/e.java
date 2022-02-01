package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "subVideoPaths", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "videoIsBeauty", "", "addVideoPath", "", "path", "isBeauty", "getMediaItems", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSize", "", "getVideoList", "initConfig", "isVideoEmpty", "release", "removeTopVideo", "Companion", "plugin-finder_release"})
public final class e
  implements t
{
  public static final e.a tca;
  private RecordConfigProvider sYT;
  private d tbP;
  public ArrayList<String> tbY;
  private ArrayList<Boolean> tbZ;
  
  static
  {
    AppMethodBeat.i(205574);
    tca = new e.a((byte)0);
    AppMethodBeat.o(205574);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(205573);
    this.tbP = paramd;
    this.tbY = new ArrayList();
    this.tbZ = new ArrayList();
    AppMethodBeat.o(205573);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(205567);
    p.h(paramRecordConfigProvider, "configProvider");
    this.sYT = paramRecordConfigProvider;
    AppMethodBeat.o(205567);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final void bj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205568);
    p.h(paramString, "path");
    this.tbY.add(paramString);
    this.tbZ.add(Boolean.valueOf(paramBoolean));
    ae.i("MicroMsg.FinderSubVideoFilePlugin", "current video size:" + this.tbY.size() + " add path:" + paramString + ", " + paramBoolean);
    AppMethodBeat.o(205568);
  }
  
  public final void cPv()
  {
    AppMethodBeat.i(205569);
    if (!((Collection)this.tbY).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        String str = (String)j.jn((List)this.tbY);
        this.tbY.remove(this.tbY.size() - 1);
        h.MqF.aQ((Runnable)new e.c(str));
      }
      if (((Collection)this.tbZ).isEmpty()) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.tbZ.remove(this.tbZ.size() - 1);
      }
      ae.i("MicroMsg.FinderSubVideoFilePlugin", "current file list size:" + this.tbY.size());
      AppMethodBeat.o(205569);
      return;
      i = 0;
      break;
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> cPw()
  {
    AppMethodBeat.i(205570);
    ArrayList localArrayList = new ArrayList();
    int j = this.tbY.size();
    int i = 0;
    if (i < j)
    {
      GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(2, 0L, (String)this.tbY.get(i), "", "");
      Object localObject = (List)this.tbZ;
      if ((i >= 0) && (i <= j.jj((List)localObject))) {}
      for (localObject = ((List)localObject).get(i);; localObject = Boolean.FALSE)
      {
        localMediaItem.s("KEY_MEDIA_IS_BEAUTY", localObject);
        ae.i("MicroMsg.FinderSubVideoFilePlugin", "add sub video path:" + (String)this.tbY.get(i));
        localArrayList.add(localMediaItem);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(205570);
    return localArrayList;
  }
  
  public final ArrayList<String> cPx()
  {
    AppMethodBeat.i(205571);
    ArrayList localArrayList = new ArrayList((Collection)this.tbY);
    AppMethodBeat.o(205571);
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
    AppMethodBeat.i(205575);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(205575);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(205572);
    ae.i("MicroMsg.FinderSubVideoFilePlugin", "release");
    h.MqF.aO((Runnable)new b(this));
    AppMethodBeat.o(205572);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(205565);
      Iterator localIterator = ((Iterable)e.a(this.tcb)).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        b localb = b.yhe;
        b.axe(str);
      }
      e.a(this.tcb).clear();
      AppMethodBeat.o(205565);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.e
 * JD-Core Version:    0.7.0.1
 */