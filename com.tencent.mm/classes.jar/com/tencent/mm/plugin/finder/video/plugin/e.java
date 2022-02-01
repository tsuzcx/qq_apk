package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "postId", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "subVideoPaths", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoIsBeauty", "", "addVideoPath", "", "path", "isBeauty", "getMediaItems", "Landroid/os/Bundle;", "getSize", "", "getVideoList", "initConfig", "isVideoEmpty", "release", "removeTopVideo", "Companion", "plugin-finder_release"})
public final class e
  implements t
{
  public static final a Ldo;
  public ArrayList<String> Ldm;
  private ArrayList<Boolean> Ldn;
  private String postId;
  private RecordConfigProvider vcC;
  private d vjo;
  
  static
  {
    AppMethodBeat.i(199921);
    Ldo = new a((byte)0);
    AppMethodBeat.o(199921);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(199920);
    this.vjo = paramd;
    this.Ldm = new ArrayList();
    this.Ldn = new ArrayList();
    this.postId = "";
    AppMethodBeat.o(199920);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(199914);
    k.h(paramRecordConfigProvider, "configProvider");
    this.vcC = paramRecordConfigProvider;
    paramRecordConfigProvider = paramRecordConfigProvider.hsl;
    if (paramRecordConfigProvider != null)
    {
      String str = paramRecordConfigProvider.getString("post_id");
      paramRecordConfigProvider = str;
      if (str != null) {}
    }
    else
    {
      paramRecordConfigProvider = new StringBuilder();
      k.g(g.afz(), "MMKernel.account()");
      paramRecordConfigProvider = com.tencent.mm.kernel.a.aeo() + '_' + bt.eGO();
    }
    this.postId = paramRecordConfigProvider;
    paramRecordConfigProvider = com.tencent.mm.plugin.finder.report.a.qFo;
    com.tencent.mm.plugin.finder.report.a.aVu(this.postId);
    AppMethodBeat.o(199914);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final void dn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(199915);
    k.h(paramString, "path");
    this.Ldm.add(paramString);
    this.Ldn.add(Boolean.valueOf(paramBoolean));
    ad.i("MicroMsg.FinderSubVideoFilePlugin", "current video size:" + this.Ldm.size() + " add path:" + paramString + ", " + paramBoolean);
    AppMethodBeat.o(199915);
  }
  
  public final void fWB()
  {
    AppMethodBeat.i(199916);
    if (!((Collection)this.Ldm).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        String str = (String)j.iA((List)this.Ldm);
        this.Ldm.remove(this.Ldm.size() - 1);
        h.Iye.aR((Runnable)new c(str));
      }
      if (((Collection)this.Ldn).isEmpty()) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Ldn.remove(this.Ldn.size() - 1);
      }
      ad.i("MicroMsg.FinderSubVideoFilePlugin", "current file list size:" + this.Ldm.size());
      AppMethodBeat.o(199916);
      return;
      i = 0;
      break;
    }
  }
  
  public final Bundle fWC()
  {
    AppMethodBeat.i(199917);
    Object localObject2 = new ArrayList();
    int j = this.Ldm.size();
    int i = 0;
    if (i < j)
    {
      GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(2, 0L, (String)this.Ldm.get(i), "", "");
      localObject1 = (List)this.Ldn;
      if ((i >= 0) && (i <= j.iw((List)localObject1))) {}
      for (localObject1 = ((List)localObject1).get(i);; localObject1 = Boolean.FALSE)
      {
        localMediaItem.D("KEY_MEDIA_IS_BEAUTY", localObject1);
        ad.i("MicroMsg.FinderSubVideoFilePlugin", "add sub video path:" + (String)this.Ldm.get(i));
        ((ArrayList)localObject2).add(localMediaItem);
        i += 1;
        break;
      }
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putParcelableArrayList("media_list", (ArrayList)localObject2);
    ((Bundle)localObject1).putString("post_id", this.postId);
    localObject2 = aj.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    k.g(localObject2, "MMApplicationContext.getContext().resources");
    i = ((Resources)localObject2).getDisplayMetrics().widthPixels;
    float f = i;
    localObject2 = this.vcC;
    if (localObject2 == null) {
      k.fvU();
    }
    j = (int)(f / ((RecordConfigProvider)localObject2).vhI.fGZ);
    ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", i);
    ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", j);
    AppMethodBeat.o(199917);
    return localObject1;
  }
  
  public final ArrayList<String> fWD()
  {
    AppMethodBeat.i(199918);
    ArrayList localArrayList = new ArrayList((Collection)this.Ldm);
    AppMethodBeat.o(199918);
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
    AppMethodBeat.i(199919);
    ad.i("MicroMsg.FinderSubVideoFilePlugin", "release");
    h.Iye.aP((Runnable)new b(this));
    AppMethodBeat.o(199919);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(199912);
      Iterator localIterator = ((Iterable)e.a(this.Ldp)).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        b localb = b.vtE;
        b.aVM(str);
      }
      e.a(this.Ldp).clear();
      AppMethodBeat.o(199912);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(199913);
      com.tencent.mm.vfs.i.deleteFile(this.yic);
      AppMethodBeat.o(199913);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.e
 * JD-Core Version:    0.7.0.1
 */