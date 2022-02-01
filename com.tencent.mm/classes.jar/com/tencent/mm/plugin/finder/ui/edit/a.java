package com.tencent.mm.plugin.finder.ui.edit;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorFollowMusicPluginLayout;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/edit/FinderVideoEditorConfig;", "", "()V", "TAG", "", "getAlbumProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getRecordProvider", "loadProviderRouter", "", "provider", "plugin-finder_release"})
public final class a
{
  public static final a Aya;
  
  static
  {
    AppMethodBeat.i(270092);
    Aya = new a();
    AppMethodBeat.o(270092);
  }
  
  private static void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(270091);
    Object localObject = new StringBuilder("isAnyEnableFullScreenEnjoy: ");
    aj localaj = aj.AGc;
    Log.i("Finder.FinderVideoEditorConfig", aj.isAnyEnableFullScreenEnjoy());
    localObject = aj.AGc;
    if (aj.isAnyEnableFullScreenEnjoy())
    {
      boolean bool = ((b)h.ae(b.class)).a(b.a.vMS, true);
      Log.i("Finder.FinderVideoEditorConfig", "useTimelineEditor: ".concat(String.valueOf(bool)));
      if (bool)
      {
        paramRecordConfigProvider.G(4, TimelineEditorFollowMusicPluginLayout.class.getName());
        paramRecordConfigProvider.G(3, MultiVideoFullScreenPluginLayout.class.getName());
        paramRecordConfigProvider.G(1, MultiVideoFullScreenPluginLayout.class.getName());
      }
    }
    for (;;)
    {
      paramRecordConfigProvider.G(0, FinderRecordPluginLayout.class.getName());
      AppMethodBeat.o(270091);
      return;
      paramRecordConfigProvider.G(4, MultiVideoFullScreenPluginLayout.class.getName());
      break;
      paramRecordConfigProvider.G(4, MultiVideoPluginLayout.class.getName());
      paramRecordConfigProvider.G(3, MultiVideoPluginLayout.class.getName());
      paramRecordConfigProvider.G(1, MultiVideoPluginLayout.class.getName());
    }
  }
  
  public static RecordConfigProvider ebG()
  {
    AppMethodBeat.i(270088);
    Log.i("Finder.FinderVideoEditorConfig", "getAlbumProvider");
    UICustomParam.a locala = new UICustomParam.a();
    locala.avX();
    locala.avW();
    locala.dZ(false);
    locala.avY();
    locala.a(b.e.btn_solid_orange, 0, "", 0);
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.jP("", "");
    localRecordConfigProvider.scene = 11;
    localRecordConfigProvider.HKT = locala.avZ();
    d locald = d.AjH;
    localRecordConfigProvider.mfk = d.dRJ();
    localRecordConfigProvider.HKV = 3;
    localRecordConfigProvider.HLb = (localRecordConfigProvider.mfk.duration * 1000);
    locala.dY(false);
    p.j(localRecordConfigProvider, "provider");
    a(localRecordConfigProvider);
    AppMethodBeat.o(270088);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider ebH()
  {
    AppMethodBeat.i(270089);
    Log.i("Finder.FinderVideoEditorConfig", "getRecordProvider");
    Object localObject1 = d.AjH;
    localObject1 = d.dRI();
    Object localObject2 = e.NuX;
    if (e.gvk()) {
      ((VideoTransPara)localObject1).height = ((int)(((VideoTransPara)localObject1).width / 0.75F));
    }
    Log.i("Finder.FinderVideoEditorConfig", "videoParams ".concat(String.valueOf(localObject1)));
    localObject2 = av.AJz;
    localObject1 = RecordConfigProvider.a(av.egp(), "", (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 11);
    ((RecordConfigProvider)localObject1).HLa = Boolean.FALSE;
    boolean bool;
    Object localObject3;
    if (!w.gtt())
    {
      bool = true;
      ((RecordConfigProvider)localObject1).HKX = Boolean.valueOf(bool);
      ((RecordConfigProvider)localObject1).HLp.QPr = ((b)h.ae(b.class)).a(b.a.vVZ, true);
      ((RecordConfigProvider)localObject1).HLp.QPt = ((b)h.ae(b.class)).a(b.a.vWa, -1);
      ((RecordConfigProvider)localObject1).HLp.QPu = ((b)h.ae(b.class)).a(b.a.vWb, -1);
      ((RecordConfigProvider)localObject1).HLp.QPv = ((b)h.ae(b.class)).a(b.a.vWc, -1);
      ((RecordConfigProvider)localObject1).HLp.QPw = ((b)h.ae(b.class)).a(b.a.vWd, -1);
      ((RecordConfigProvider)localObject1).HLp.QPx = ((b)h.ae(b.class)).a(b.a.vWe, -1);
      ((RecordConfigProvider)localObject1).HKU = i.e.RcG;
      localObject2 = new UICustomParam.a();
      localObject3 = e.NuX;
      if (!e.gvk()) {
        break label374;
      }
      ((UICustomParam.a)localObject2).ah(0.75F);
    }
    for (;;)
    {
      localObject3 = MMApplicationContext.getContext();
      p.j(localObject3, "MMApplicationContext.getContext()");
      ((UICustomParam.a)localObject2).qY(((Context)localObject3).getResources().getColor(b.c.orange_100));
      ((UICustomParam.a)localObject2).a(b.e.btn_solid_orange, 0, "", 0);
      ((RecordConfigProvider)localObject1).HKT = ((UICustomParam.a)localObject2).avZ();
      ((UICustomParam.a)localObject2).avX();
      ((UICustomParam.a)localObject2).avW();
      ((UICustomParam.a)localObject2).avV();
      ((UICustomParam.a)localObject2).dZ(false);
      ((UICustomParam.a)localObject2).avY();
      p.j(localObject1, "provider");
      a((RecordConfigProvider)localObject1);
      AppMethodBeat.o(270089);
      return localObject1;
      bool = false;
      break;
      label374:
      ((UICustomParam.a)localObject2).ah(0.8571429F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.edit.a
 * JD-Core Version:    0.7.0.1
 */