package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "postId", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "subVideoPaths", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoIsBeauty", "", "addVideoPath", "", "path", "isBeauty", "getMediaItems", "Landroid/os/Bundle;", "getSize", "", "getVideoList", "initConfig", "isVideoEmpty", "release", "removeTopVideo", "Companion", "plugin-finder_release"})
public final class e
  implements t
{
  public static final e.a rUe;
  private String postId;
  private RecordConfigProvider rRi;
  private d rTT;
  public ArrayList<String> rUc;
  private ArrayList<Boolean> rUd;
  
  static
  {
    AppMethodBeat.i(203989);
    rUe = new e.a((byte)0);
    AppMethodBeat.o(203989);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(203988);
    this.rTT = paramd;
    this.rUc = new ArrayList();
    this.rUd = new ArrayList();
    this.postId = "";
    AppMethodBeat.o(203988);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(203982);
    k.h(paramRecordConfigProvider, "configProvider");
    this.rRi = paramRecordConfigProvider;
    paramRecordConfigProvider = paramRecordConfigProvider.hSN;
    if (paramRecordConfigProvider != null)
    {
      String str = paramRecordConfigProvider.getString("post_id");
      paramRecordConfigProvider = str;
      if (str != null) {}
    }
    else
    {
      paramRecordConfigProvider = new StringBuilder();
      k.g(g.agP(), "MMKernel.account()");
      paramRecordConfigProvider = a.afE() + '_' + bs.eWj();
    }
    this.postId = paramRecordConfigProvider;
    paramRecordConfigProvider = c.rxi;
    c.adN(this.postId);
    AppMethodBeat.o(203982);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final void bb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203983);
    k.h(paramString, "path");
    this.rUc.add(paramString);
    this.rUd.add(Boolean.valueOf(paramBoolean));
    ac.i("MicroMsg.FinderSubVideoFilePlugin", "current video size:" + this.rUc.size() + " add path:" + paramString + ", " + paramBoolean);
    AppMethodBeat.o(203983);
  }
  
  public final void cEs()
  {
    AppMethodBeat.i(203984);
    if (!((Collection)this.rUc).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        String str = (String)j.iQ((List)this.rUc);
        this.rUc.remove(this.rUc.size() - 1);
        h.JZN.aU((Runnable)new e.c(str));
      }
      if (((Collection)this.rUd).isEmpty()) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.rUd.remove(this.rUd.size() - 1);
      }
      ac.i("MicroMsg.FinderSubVideoFilePlugin", "current file list size:" + this.rUc.size());
      AppMethodBeat.o(203984);
      return;
      i = 0;
      break;
    }
  }
  
  public final Bundle cEt()
  {
    AppMethodBeat.i(203985);
    Object localObject2 = new ArrayList();
    int j = this.rUc.size();
    int i = 0;
    if (i < j)
    {
      GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(2, 0L, (String)this.rUc.get(i), "", "");
      localObject1 = (List)this.rUd;
      if ((i >= 0) && (i <= j.iM((List)localObject1))) {}
      for (localObject1 = ((List)localObject1).get(i);; localObject1 = Boolean.FALSE)
      {
        localMediaItem.u("KEY_MEDIA_IS_BEAUTY", localObject1);
        ac.i("MicroMsg.FinderSubVideoFilePlugin", "add sub video path:" + (String)this.rUc.get(i));
        ((ArrayList)localObject2).add(localMediaItem);
        i += 1;
        break;
      }
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putParcelableArrayList("media_list", (ArrayList)localObject2);
    ((Bundle)localObject1).putString("post_id", this.postId);
    localObject2 = ai.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    k.g(localObject2, "MMApplicationContext.getContext().resources");
    i = ((Resources)localObject2).getDisplayMetrics().widthPixels;
    float f = i;
    localObject2 = this.rRi;
    if (localObject2 == null) {
      k.fOy();
    }
    j = (int)(f / ((RecordConfigProvider)localObject2).wqu.fKG);
    ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", i);
    ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", j);
    AppMethodBeat.o(203985);
    return localObject1;
  }
  
  public final ArrayList<String> cEu()
  {
    AppMethodBeat.i(203986);
    ArrayList localArrayList = new ArrayList((Collection)this.rUc);
    AppMethodBeat.o(203986);
    return localArrayList;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(203987);
    ac.i("MicroMsg.FinderSubVideoFilePlugin", "release");
    h.JZN.aS((Runnable)new b(this));
    AppMethodBeat.o(203987);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(203980);
      Iterator localIterator = ((Iterable)e.a(this.rUf)).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        b localb = b.wDE;
        b.aqP(str);
      }
      e.a(this.rUf).clear();
      AppMethodBeat.o(203980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.e
 * JD-Core Version:    0.7.0.1
 */