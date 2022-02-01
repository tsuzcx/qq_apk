package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$AudioStateListener;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addMusicDuration", "Landroid/widget/TextView;", "addMusicGroup", "Landroid/view/View;", "addMusicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addMusicIndicator", "addMusicText", "canAddMusic", "", "hasMusic", "getLayout", "()Landroid/view/ViewGroup;", "musicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "changeRecordDuration", "", "durationMs", "", "enableAddMusic", "enabled", "onAudioPause", "onAudioResume", "setMusic", "setVisibility", "visibility", "", "updateContent", "updateProgress", "timeMs", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements v
{
  public static final g.a GsZ;
  private static final long Gti;
  private final ViewGroup GrB;
  private final com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private final View Gta;
  private final WeImageView Gtb;
  private final TextView Gtc;
  private final View Gtd;
  private final TextView Gte;
  public AudioCacheInfo Gtf;
  public boolean Gtg;
  private boolean Gth;
  
  static
  {
    AppMethodBeat.i(335544);
    GsZ = new g.a((byte)0);
    Gti = 60000L;
    AppMethodBeat.o(335544);
  }
  
  public g(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(335511);
    this.GrB = paramViewGroup;
    this.GrC = parama;
    paramViewGroup = this.GrB.findViewById(l.e.record_add_music);
    s.s(paramViewGroup, "layout.findViewById(R.id.record_add_music)");
    this.Gta = paramViewGroup;
    paramViewGroup = this.GrB.findViewById(l.e.record_add_music_icon);
    s.s(paramViewGroup, "layout.findViewById(R.id.record_add_music_icon)");
    this.Gtb = ((WeImageView)paramViewGroup);
    paramViewGroup = this.GrB.findViewById(l.e.record_add_music_text);
    s.s(paramViewGroup, "layout.findViewById(R.id.record_add_music_text)");
    this.Gtc = ((TextView)paramViewGroup);
    paramViewGroup = this.GrB.findViewById(l.e.record_add_music_indicator);
    s.s(paramViewGroup, "layout.findViewById(R.id…cord_add_music_indicator)");
    this.Gtd = paramViewGroup;
    paramViewGroup = this.GrB.findViewById(l.e.record_add_music_duration);
    s.s(paramViewGroup, "layout.findViewById(R.id…ecord_add_music_duration)");
    this.Gte = ((TextView)paramViewGroup);
    this.Gth = true;
    this.Gta.setOnClickListener(new g..ExternalSyntheticLambda0(this));
    this.Gtc.setSelected(true);
    uL(false);
    AppMethodBeat.o(335511);
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(335531);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    if (paramg.Gth) {
      a.b.a(paramg.GrC, a.c.NQn);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(335531);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335634);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(335634);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(335677);
    s.u(this, "this");
    AppMethodBeat.o(335677);
  }
  
  public final void eAL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(335604);
    if (this.Gtf == null)
    {
      this.Gtc.setText((CharSequence)com.tencent.mm.cd.a.bt(this.GrB.getContext(), l.i.finder_record_choose_music));
      qX(Gti);
      this.Gtc.requestLayout();
      AppMethodBeat.o(335604);
      return;
    }
    TextView localTextView = this.Gtc;
    Object localObject1 = this.Gtf;
    label74:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (Collection)localObject1;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label131;
      }
      i = 1;
      label94:
      if (i == 0) {
        break label144;
      }
      localObject1 = this.Gtf;
      if (localObject1 != null) {
        break label136;
      }
    }
    label131:
    label136:
    for (localObject1 = null;; localObject1 = ((AudioCacheInfo)localObject1).songName)
    {
      localObject1 = (CharSequence)localObject1;
      localTextView.setText((CharSequence)localObject1);
      break;
      localObject1 = ((AudioCacheInfo)localObject1).NIF;
      break label74;
      i = 0;
      break label94;
    }
    label144:
    localObject1 = this.Gtf;
    label155:
    String str;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      localObject1 = null;
      str = Util.listToString((List)localObject1, ",");
      localStringBuilder = new StringBuilder();
      localObject1 = this.Gtf;
      if (localObject1 != null) {
        break label222;
      }
    }
    label222:
    for (localObject1 = localObject2;; localObject1 = ((AudioCacheInfo)localObject1).songName)
    {
      localObject1 = (CharSequence)(localObject1 + " - " + str);
      break;
      localObject1 = ((AudioCacheInfo)localObject1).NIF;
      break label155;
    }
  }
  
  public final String name()
  {
    AppMethodBeat.i(335651);
    String str = v.a.b(this);
    AppMethodBeat.o(335651);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(335666);
    s.u(this, "this");
    AppMethodBeat.o(335666);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(335689);
    s.u(this, "this");
    AppMethodBeat.o(335689);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(335699);
    s.u(this, "this");
    AppMethodBeat.o(335699);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(335714);
    s.u(this, "this");
    AppMethodBeat.o(335714);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(335727);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(335727);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(335739);
    s.u(this, "this");
    AppMethodBeat.o(335739);
  }
  
  public final void qX(long paramLong)
  {
    AppMethodBeat.i(335619);
    if (this.Gtf != null)
    {
      this.Gte.setVisibility(0);
      this.Gte.setText((CharSequence)this.GrB.getContext().getString(l.i.finder_record_add_music_duration, new Object[] { Integer.valueOf(kotlin.h.a.eH((float)paramLong / 1000.0F)) }));
      AppMethodBeat.o(335619);
      return;
    }
    this.Gte.setVisibility(8);
    AppMethodBeat.o(335619);
  }
  
  public final void release()
  {
    AppMethodBeat.i(335751);
    s.u(this, "this");
    AppMethodBeat.o(335751);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(335762);
    s.u(this, "this");
    AppMethodBeat.o(335762);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(335588);
    this.Gta.setVisibility(paramInt);
    if (paramInt == 0) {
      eAL();
    }
    AppMethodBeat.o(335588);
  }
  
  public final void uL(boolean paramBoolean)
  {
    AppMethodBeat.i(335574);
    View localView;
    if (this.Gth != paramBoolean)
    {
      this.Gth = paramBoolean;
      localView = this.Gtd;
      if (!paramBoolean) {
        break label42;
      }
    }
    label42:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(335574);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.g
 * JD-Core Version:    0.7.0.1
 */