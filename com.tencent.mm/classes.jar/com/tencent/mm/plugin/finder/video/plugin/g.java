package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$AudioStateListener;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addMusicDuration", "Landroid/widget/TextView;", "addMusicGroup", "Landroid/view/View;", "addMusicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addMusicIndicator", "addMusicText", "canAddMusic", "", "hasMusic", "getLayout", "()Landroid/view/ViewGroup;", "musicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "changeRecordDuration", "", "durationMs", "", "enableAddMusic", "enabled", "onAudioPause", "onAudioResume", "setMusic", "setVisibility", "visibility", "", "updateContent", "updateProgress", "timeMs", "Companion", "plugin-finder_release"})
public final class g
  implements u
{
  private static final long ARc = 60000L;
  public static final a ARd;
  final ViewGroup APk;
  final d APl;
  private final View AQU;
  private final WeImageView AQV;
  private final TextView AQW;
  private final View AQX;
  private final TextView AQY;
  public AudioCacheInfo AQZ;
  public boolean ARa;
  private boolean ARb;
  
  static
  {
    AppMethodBeat.i(277129);
    ARd = new a((byte)0);
    ARc = 60000L;
    AppMethodBeat.o(277129);
  }
  
  public g(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(277128);
    this.APk = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.APk.findViewById(b.f.record_add_music);
    p.j(paramViewGroup, "layout.findViewById(R.id.record_add_music)");
    this.AQU = paramViewGroup;
    paramViewGroup = this.APk.findViewById(b.f.record_add_music_icon);
    p.j(paramViewGroup, "layout.findViewById(R.id.record_add_music_icon)");
    this.AQV = ((WeImageView)paramViewGroup);
    paramViewGroup = this.APk.findViewById(b.f.record_add_music_text);
    p.j(paramViewGroup, "layout.findViewById(R.id.record_add_music_text)");
    this.AQW = ((TextView)paramViewGroup);
    paramViewGroup = this.APk.findViewById(b.f.record_add_music_indicator);
    p.j(paramViewGroup, "layout.findViewById(R.id…cord_add_music_indicator)");
    this.AQX = paramViewGroup;
    paramViewGroup = this.APk.findViewById(b.f.record_add_music_duration);
    p.j(paramViewGroup, "layout.findViewById(R.id…ecord_add_music_duration)");
    this.AQY = ((TextView)paramViewGroup);
    this.ARb = true;
    this.AQU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(279541);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (g.a(this.ARe)) {
          d.b.a(this.ARe.APl, d.c.HTH);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279541);
      }
    });
    this.AQW.setSelected(true);
    this.AQU.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(290122);
        int i = g.b(this.ARe).getWidth();
        int j = g.c(this.ARe).getWidth();
        int k = g.d(this.ARe).getWidth();
        int m = com.tencent.mm.ci.a.fromDPToPix(this.ARe.APk.getContext(), 54);
        g.e(this.ARe).setMaxWidth(i - j - k - m);
        AppMethodBeat.o(290122);
      }
    });
    rk(false);
    AppMethodBeat.o(277128);
  }
  
  public final void Ns(long paramLong)
  {
    AppMethodBeat.i(277127);
    if (this.AQZ != null)
    {
      this.AQY.setVisibility(0);
      this.AQY.setText((CharSequence)this.APk.getContext().getString(b.j.finder_record_add_music_duration, new Object[] { Integer.valueOf(kotlin.h.a.dm((float)paramLong / 1000.0F)) }));
      AppMethodBeat.o(277127);
      return;
    }
    this.AQY.setVisibility(8);
    AppMethodBeat.o(277127);
  }
  
  public final void bbp() {}
  
  public final void ehN()
  {
    Object localObject2 = null;
    AppMethodBeat.i(277126);
    if (this.AQZ == null)
    {
      this.AQW.setText((CharSequence)com.tencent.mm.ci.a.ba(this.APk.getContext(), b.j.finder_record_choose_music));
      Ns(ARc);
      AppMethodBeat.o(277126);
      return;
    }
    TextView localTextView = this.AQW;
    Object localObject1 = this.AQZ;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((AudioCacheInfo)localObject1).HLE;
      localObject1 = (Collection)localObject1;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label130;
      }
      i = 1;
      label90:
      if (i == 0) {
        break label140;
      }
      localObject1 = this.AQZ;
      if (localObject1 == null) {
        break label135;
      }
    }
    label130:
    label135:
    for (localObject1 = ((AudioCacheInfo)localObject1).HLH;; localObject1 = null)
    {
      localObject1 = (CharSequence)localObject1;
      localTextView.setText((CharSequence)localObject1);
      AppMethodBeat.o(277126);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label90;
    }
    label140:
    localObject1 = this.AQZ;
    if (localObject1 != null) {}
    for (localObject1 = ((AudioCacheInfo)localObject1).HLE;; localObject1 = null)
    {
      String str = Util.listToString((List)localObject1, ",");
      StringBuilder localStringBuilder = new StringBuilder();
      AudioCacheInfo localAudioCacheInfo = this.AQZ;
      localObject1 = localObject2;
      if (localAudioCacheInfo != null) {
        localObject1 = localAudioCacheInfo.HLH;
      }
      localObject1 = (CharSequence)((String)localObject1 + " - " + str);
      break;
    }
  }
  
  public final String name()
  {
    AppMethodBeat.i(277130);
    String str = getClass().getName();
    AppMethodBeat.o(277130);
    return str;
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
    AppMethodBeat.i(277131);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(277131);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void rk(boolean paramBoolean)
  {
    AppMethodBeat.i(277124);
    View localView;
    if (this.ARb != paramBoolean)
    {
      this.ARb = paramBoolean;
      localView = this.AQX;
      if (!paramBoolean) {
        break label42;
      }
    }
    label42:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(277124);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(277125);
    this.AQU.setVisibility(paramInt);
    if (paramInt == 0) {
      ehN();
    }
    AppMethodBeat.o(277125);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin$Companion;", "", "()V", "DURATION_HINT_THRESHOLD", "", "getDURATION_HINT_THRESHOLD", "()J", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.g
 * JD-Core Version:    0.7.0.1
 */