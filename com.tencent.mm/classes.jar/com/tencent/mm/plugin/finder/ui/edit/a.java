package com.tencent.mm.plugin.finder.ui.edit;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.d;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorFollowMusicPluginLayout;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tav.decoder.CodecHelper;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/edit/FinderVideoEditorConfig;", "", "()V", "RecordDegradeConfig", "", "TAG", "getAlbumProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getRecordProvider", "supportTemplate", "", "loadProviderRouter", "", "provider", "recordDegradeCheck", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a FXw;
  
  static
  {
    AppMethodBeat.i(346923);
    FXw = new a();
    AppMethodBeat.o(346923);
  }
  
  private static void a(RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean)
  {
    AppMethodBeat.i(346918);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zdz, true);
    Log.i("Finder.FinderVideoEditorConfig", s.X("useTimelineEditor: ", Boolean.valueOf(bool)));
    if (bool) {
      paramRecordConfigProvider.cD(4, TimelineEditorFollowMusicPluginLayout.class.getName());
    }
    for (;;)
    {
      paramRecordConfigProvider.cD(3, MultiVideoFullScreenPluginLayout.class.getName());
      paramRecordConfigProvider.cD(1, MultiVideoFullScreenPluginLayout.class.getName());
      paramRecordConfigProvider.cD(0, FinderRecordPluginLayout.class.getName());
      if (paramBoolean)
      {
        com.tencent.mm.plugin.finder.record.config.a locala = com.tencent.mm.plugin.finder.record.config.a.Fix;
        com.tencent.mm.plugin.finder.record.config.a.b(paramRecordConfigProvider);
      }
      AppMethodBeat.o(346918);
      return;
      paramRecordConfigProvider.cD(4, MultiVideoFullScreenPluginLayout.class.getName());
    }
  }
  
  public static RecordConfigProvider fcN()
  {
    AppMethodBeat.i(346897);
    Log.i("Finder.FinderVideoEditorConfig", "getAlbumProvider");
    UICustomParam.a locala = new UICustomParam.a();
    locala.aQw();
    locala.aQv();
    locala.eL(false);
    locala.aQx();
    locala.a(l.d.btn_solid_orange, 0, "", 0);
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.lk("", "");
    localRecordConfigProvider.scene = 11;
    localRecordConfigProvider.NHR = locala.lZB;
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    localRecordConfigProvider.oXZ = com.tencent.mm.plugin.finder.storage.d.ePV();
    localRecordConfigProvider.NHT = 3;
    localRecordConfigProvider.NHZ = (localRecordConfigProvider.oXZ.duration * 1000);
    locala.eK(false);
    s.s(localRecordConfigProvider, "provider");
    a(localRecordConfigProvider, false);
    AppMethodBeat.o(346897);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider uo(boolean paramBoolean)
  {
    AppMethodBeat.i(346912);
    Log.i("Finder.FinderVideoEditorConfig", "getRecordProvider");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    localObject1 = com.tencent.mm.plugin.finder.storage.d.ePU();
    Object localObject2 = e.Uio;
    if (e.hTa()) {
      ((VideoTransPara)localObject1).height = ((int)(((VideoTransPara)localObject1).width / 0.75F));
    }
    Log.i("Finder.FinderVideoEditorConfig", s.X("videoParams ", localObject1));
    localObject2 = bm.GlZ;
    localObject1 = RecordConfigProvider.a(bm.fip(), "", (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 11);
    s.s(localObject1, "provider");
    bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVA, true);
    Log.i("Finder.FinderVideoEditorConfig", s.X("recordDegradeCheck enable:", Boolean.valueOf(bool)));
    if (bool) {}
    try
    {
      localObject2 = ((RecordConfigProvider)localObject1).oXZ;
      if (localObject2 != null)
      {
        int i = CodecHelper.getSupportMaxParallelCount(((VideoTransPara)localObject2).width, ((VideoTransPara)localObject2).width * 16 / 9, 30, ((VideoTransPara)localObject2).videoBitrate, "video/avc");
        localObject3 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVB, "\n       [{\"count\":1,\"width\":540,\"height\":960,\"fps\":30},{\"count\":2,\"width\":720,\"height\":1280,\"fps\":30}]\n    ");
        Log.i("Finder.FinderVideoEditorConfig", "count:" + i + " setting:" + localObject3);
        com.tencent.luggage.sdk.h.c.a((JSONArray)new f((String)localObject3), (b)new a(i, (VideoTransPara)localObject2));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        Log.printErrStackTrace("Finder.FinderVideoEditorConfig", (Throwable)localException, "recordDegradeCheck error", new Object[0]);
        continue;
        bool = false;
        continue;
        localException.bj(0.8571429F);
      }
    }
    ((RecordConfigProvider)localObject1).NHY = Boolean.FALSE;
    if (!w.hQT())
    {
      bool = true;
      ((RecordConfigProvider)localObject1).NHV = Boolean.valueOf(bool);
      ((RecordConfigProvider)localObject1).NIn.XKq = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoE, true);
      ((RecordConfigProvider)localObject1).NIn.XKs = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoF, -1);
      ((RecordConfigProvider)localObject1).NIn.XKt = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoG, -1);
      ((RecordConfigProvider)localObject1).NIn.XKu = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoH, -1);
      ((RecordConfigProvider)localObject1).NIn.XKv = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoI, -1);
      ((RecordConfigProvider)localObject1).NIn.XKw = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoJ, -1);
      ((RecordConfigProvider)localObject1).NHS = i.e.XYM;
      localObject2 = new UICustomParam.a();
      localObject3 = e.Uio;
      if (!e.hTa()) {
        break label557;
      }
      ((UICustomParam.a)localObject2).bj(0.75F);
      ((UICustomParam.a)localObject2).re(MMApplicationContext.getContext().getResources().getColor(l.b.orange_100));
      ((UICustomParam.a)localObject2).a(l.d.btn_solid_orange, 0, "", 0);
      ((RecordConfigProvider)localObject1).NHR = ((UICustomParam.a)localObject2).lZB;
      ((UICustomParam.a)localObject2).aQw();
      ((UICustomParam.a)localObject2).aQv();
      ((UICustomParam.a)localObject2).aQu();
      ((UICustomParam.a)localObject2).eL(false);
      ((UICustomParam.a)localObject2).aQx();
      a((RecordConfigProvider)localObject1, paramBoolean);
      AppMethodBeat.o(346912);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/json/InnerJSONObjectImpl;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<com.tencent.mm.ad.d, ah>
  {
    a(int paramInt, VideoTransPara paramVideoTransPara)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.edit.a
 * JD-Core Version:    0.7.0.1
 */