package com.tencent.mm.plugin.finder.replay;

import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.be;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.bv;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.loader.v;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.replay.plugin.d;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayBaseUIC;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "playerGenerator", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "liveId", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "sourcePlayerWidget", "Lkotlin/Pair;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function2;)V", "audioModePreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAudioModePreviewPlugin;", "micAudioPreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin;", "micDecoratePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "replayerPlugin", "Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerPlugin;", "replayerSeekBarPlugin", "Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerSeekbarPlugin;", "activate", "", "deactivate", "initPlugins", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "onVideoSizeChange", "width", "", "height", "startPlay", "offset", "data", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "fromFloat", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends l
{
  public static final e.a FjW;
  private bf Ejo;
  private be Ejr;
  private ab Ejt;
  private final m<Long, com.tencent.mm.plugin.finder.replay.widget.c, r<com.tencent.mm.plugin.finder.replay.widget.c, Boolean>> FjX;
  private d FjY;
  private com.tencent.mm.plugin.finder.replay.plugin.e FjZ;
  
  static
  {
    AppMethodBeat.i(332675);
    FjW = new e.a((byte)0);
    AppMethodBeat.o(332675);
  }
  
  public e(AppCompatActivity paramAppCompatActivity, m<? super Long, ? super com.tencent.mm.plugin.finder.replay.widget.c, r<com.tencent.mm.plugin.finder.replay.widget.c, Boolean>> paramm)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(332657);
    this.FjX = paramm;
    AppMethodBeat.o(332657);
  }
  
  public final void a(int paramInt, v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(332709);
    s.u(paramv, "data");
    d locald = this.FjY;
    FeedData localFeedData;
    Object localObject1;
    Object localObject2;
    if (locald != null)
    {
      localFeedData = new FeedData();
      localFeedData.setPosition(((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).CEY);
      localObject1 = ((f)business(f.class)).EeY;
      if (localObject1 != null) {
        break label386;
      }
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = s.X("replay-", Integer.valueOf(localFeedData.hashCode()));
      }
      localFeedData.setDescription((String)localObject2);
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
      if (localObject1 != null) {
        break label396;
      }
      localObject1 = "";
      label124:
      localFeedData.setNickName((String)localObject1);
      localObject1 = ah.aiuX;
      s.u(paramv, "data");
      s.u(localFeedData, "feedData");
      localObject1 = new StringBuilder("bindMediaInfo:pos:").append(localFeedData.getPosition()).append(",desc:").append(localFeedData.getDescription()).append(",nickname:").append(localFeedData.getNickName()).append(",player:");
      localObject2 = locald.Fmd;
      if (localObject2 == null) {
        break label419;
      }
    }
    label386:
    label396:
    label419:
    for (int i = localObject2.hashCode();; i = 0)
    {
      Log.i("FinderLiveReplayerPlugin", i + ",fromFloat:" + paramBoolean + ", isPlaying:" + locald.isPlaying() + '!');
      if (!paramBoolean)
      {
        localObject1 = locald.Fmd;
        if (localObject1 != null)
        {
          s.u(paramv, "data");
          s.u(localFeedData, "feedData");
          Log.i("FinderLiveReplayerWidget", "bindMediaInfo " + ((com.tencent.mm.plugin.finder.replay.widget.c)localObject1).hashCode() + " playerView:" + ((com.tencent.mm.plugin.finder.replay.widget.c)localObject1).Fni.hashCode() + ",newContainer:" + paramv.ExE.mediaId);
          ((com.tencent.mm.plugin.finder.replay.widget.c)localObject1).Fni.a((x)paramv, false, localFeedData);
        }
      }
      paramv = this.FjY;
      if (paramv != null) {
        paramv.a(Integer.valueOf(paramInt), paramBoolean);
      }
      AppMethodBeat.o(332709);
      return;
      localObject1 = ((FinderObjectDesc)localObject1).description;
      break;
      localObject2 = ((FinderObject)localObject1).nickname;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label124;
      }
      localObject1 = "";
      break label124;
    }
  }
  
  public final void c(b.c paramc)
  {
    AppMethodBeat.i(332740);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(332740);
      return;
      paramc = this.Ejo;
      if (paramc != null) {
        paramc.era();
      }
      paramc = this.Ejr;
      if (paramc != null)
      {
        paramc.era();
        AppMethodBeat.o(332740);
        return;
        paramc = this.Ejo;
        if (paramc != null) {
          paramc.erb();
        }
        paramc = this.Ejr;
        if (paramc != null) {
          paramc.erb();
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(332691);
    s.u(parama, "baseRouter");
    super.c(parama);
    com.tencent.mm.plugin.finder.live.view.a locala = this.FkM;
    Object localObject1;
    Object localObject2;
    if (locala != null)
    {
      parama = (d)locala.getPlugin(d.class);
      if (parama != null) {
        break label380;
      }
      parama = locala.findViewById(p.e.BQY);
      s.s(parama, "it.findViewById(R.id.finder_live_preview_root)");
      parama = (ViewGroup)parama;
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add(Integer.valueOf(p.e.BGK));
      localObject2 = ah.aiuX;
      parama = new d(parama, (List)localObject1, (b)locala);
    }
    label380:
    for (;;)
    {
      this.FjY = parama;
      localObject1 = (ab)locala.getPlugin(ab.class);
      parama = (com.tencent.mm.plugin.finder.live.view.a)localObject1;
      if (localObject1 == null)
      {
        parama = locala.findViewById(p.e.BGK);
        s.s(parama, "it.findViewById(R.id.fin…dio_mode_preview_ui_root)");
        parama = new ab((ViewGroup)parama, (b)locala);
      }
      this.Ejt = parama;
      localObject1 = (bf)locala.getPlugin(bf.class);
      parama = (com.tencent.mm.plugin.finder.live.view.a)localObject1;
      if (localObject1 == null)
      {
        parama = locala.findViewById(p.e.BOx);
        s.s(parama, "it.findViewById(R.id.fin…ive_mic_decorate_ui_root)");
        parama = (ViewGroup)parama;
        localObject1 = (b)locala;
        localObject2 = locala.findViewById(p.e.BSi);
        s.s(localObject2, "it.findViewById(R.id.finder_live_shade_view)");
        parama = new bf(parama, (b)localObject1, (FinderLiveShadeView)localObject2, null);
      }
      this.Ejo = parama;
      localObject1 = (be)locala.getPlugin(be.class);
      parama = (com.tencent.mm.plugin.finder.live.view.a)localObject1;
      if (localObject1 == null)
      {
        parama = locala.findViewById(p.e.BOq);
        s.s(parama, "it.findViewById(R.id.fin…ic_audio_preview_ui_root)");
        parama = (ViewGroup)parama;
        localObject1 = (b)locala;
        localObject2 = locala.findViewById(p.e.BSi);
        s.s(localObject2, "it.findViewById(R.id.finder_live_shade_view)");
        parama = new be(parama, (b)localObject1, (FinderLiveShadeView)localObject2, (byte)0);
      }
      this.Ejr = parama;
      localObject1 = (com.tencent.mm.plugin.finder.replay.plugin.e)locala.getPlugin(com.tencent.mm.plugin.finder.replay.plugin.e.class);
      parama = (com.tencent.mm.plugin.finder.live.view.a)localObject1;
      if (localObject1 == null)
      {
        parama = locala.findViewById(p.e.BSb);
        s.s(parama, "it.findViewById(R.id.fin…_replay_seek_bar_ui_root)");
        parama = new com.tencent.mm.plugin.finder.replay.plugin.e((ViewGroup)parama, (b)locala);
      }
      this.FjZ = parama;
      AppMethodBeat.o(332691);
      return;
    }
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(332728);
    Object localObject = this.FjY;
    if (localObject != null) {
      ((d)localObject).stopVideo();
    }
    localObject = (com.tencent.mm.plugin.finder.live.business.a)business(com.tencent.mm.plugin.finder.live.business.a.class);
    ((com.tencent.mm.plugin.finder.live.business.a)localObject).qm(false);
    ((com.tencent.mm.plugin.finder.live.business.a)localObject).qn(false);
    AppMethodBeat.o(332728);
  }
  
  public final void eBc()
  {
    AppMethodBeat.i(332722);
    Object localObject1 = this.FjY;
    if (localObject1 != null) {
      ((d)localObject1).n((m)new c(this));
    }
    localObject1 = this.FkM;
    int i;
    Object localObject2;
    if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.live.view.a)localObject1).isLandscape() == true))
    {
      i = 1;
      if (i == 0) {
        break label264;
      }
      localObject1 = this.FkM;
      if (localObject1 != null)
      {
        localObject2 = (bv)((com.tencent.mm.plugin.finder.live.view.a)localObject1).getPlugin(bv.class);
        if (localObject2 != null)
        {
          localObject1 = this.FjY;
          if (localObject1 != null) {
            break label251;
          }
          localObject1 = null;
          label90:
          localObject1 = (View.OnTouchListener)localObject1;
          if (localObject1 != null)
          {
            if (((bv)localObject2).DiK == null) {
              ((bv)localObject2).DiK = new LinkedList();
            }
            LinkedList localLinkedList = ((bv)localObject2).DiK;
            if ((localLinkedList == null) || (localLinkedList.contains(localObject1) != true)) {
              break label259;
            }
            i = 1;
            label143:
            if (i == 0)
            {
              localObject2 = ((bv)localObject2).DiK;
              if (localObject2 != null) {
                ((LinkedList)localObject2).add(localObject1);
              }
            }
          }
        }
      }
      label166:
      i = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).offset;
      localObject1 = n.FkP;
      localObject2 = n.d(((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).getLiveInfo());
      localObject1 = this.FkM;
      if (!(localObject1 instanceof j)) {
        break label340;
      }
      localObject1 = (j)localObject1;
      label217:
      if ((localObject1 == null) || (((j)localObject1).getFromFloat() != true)) {
        break label345;
      }
    }
    label259:
    label264:
    label340:
    label345:
    for (boolean bool = true;; bool = false)
    {
      a(i, (v)localObject2, bool);
      AppMethodBeat.o(332722);
      return;
      i = 0;
      break;
      label251:
      localObject1 = ((d)localObject1).eLT();
      break label90;
      i = 0;
      break label143;
      localObject1 = this.FkM;
      if (localObject1 == null) {
        break label166;
      }
      localObject2 = (bv)((com.tencent.mm.plugin.finder.live.view.a)localObject1).getPlugin(bv.class);
      if (localObject2 == null) {
        break label166;
      }
      localObject1 = this.FjY;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((d)localObject1).eLT())
      {
        localObject1 = (View.OnTouchListener)localObject1;
        if (localObject1 == null) {
          break;
        }
        localObject2 = ((bv)localObject2).DiK;
        if (localObject2 == null) {
          break;
        }
        ((LinkedList)localObject2).remove(localObject1);
        break;
      }
      localObject1 = null;
      break label217;
    }
  }
  
  public final void eLu()
  {
    AppMethodBeat.i(332754);
    com.tencent.mm.plugin.finder.live.view.a locala;
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyE())
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv = null;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.clear();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM = false;
      locala = this.FkM;
      if (locala != null) {
        b.b.a((b)locala, b.c.neD);
      }
      locala = this.FkM;
      if (locala != null) {
        com.tencent.mm.plugin.finder.live.view.a.notifyRoomPKMicUserChange$default(locala, new JSONObject(), false, null, 6, null);
      }
      k.a(k.Fky.eLF(), 3, new JSONObject(), false, 4);
    }
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
    {
      locala = this.FkM;
      if (locala != null) {
        com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default(locala, false, 1, null);
      }
      locala = this.FkM;
      if (locala != null) {
        com.tencent.mm.plugin.finder.live.view.a.notifyPKMicUserChange$default(locala, false, 1, null);
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv != null)
      {
        k.a(k.Fky.eLF(), 1, null, false, 6);
        AppMethodBeat.o(332754);
        return;
      }
      k.a(k.Fky.eLF(), 2, null, false, 6);
    }
    AppMethodBeat.o(332754);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "", "liveId", "", "sourcePlayer"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Long, com.tencent.mm.plugin.finder.replay.widget.c, r<? extends com.tencent.mm.plugin.finder.replay.widget.c, ? extends Boolean>>
  {
    c(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.e
 * JD-Core Version:    0.7.0.1
 */