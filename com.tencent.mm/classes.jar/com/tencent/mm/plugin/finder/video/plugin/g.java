package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$AudioStateListener;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addMusicDuration", "Landroid/widget/TextView;", "addMusicGroup", "Landroid/view/View;", "addMusicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addMusicIndicator", "addMusicText", "canAddMusic", "", "hasMusic", "getLayout", "()Landroid/view/ViewGroup;", "musicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "changeRecordDuration", "", "durationMs", "", "enableAddMusic", "enabled", "onAudioPause", "onAudioResume", "setMusic", "setVisibility", "visibility", "", "updateContent", "updateProgress", "timeMs", "Companion", "plugin-finder_release"})
public final class g
  implements t
{
  private static final long whm = 60000L;
  public static final g.a whn;
  final ViewGroup wgq;
  final d wgr;
  private final View whe;
  private final WeImageView whf;
  private final TextView whg;
  private final View whh;
  private final TextView whi;
  public AudioCacheInfo whj;
  public boolean whk;
  private boolean whl;
  
  static
  {
    AppMethodBeat.i(254501);
    whn = new g.a((byte)0);
    whm = 60000L;
    AppMethodBeat.o(254501);
  }
  
  public g(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(254500);
    this.wgq = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.wgq.findViewById(2131306692);
    p.g(paramViewGroup, "layout.findViewById(R.id.record_add_music)");
    this.whe = paramViewGroup;
    paramViewGroup = this.wgq.findViewById(2131306694);
    p.g(paramViewGroup, "layout.findViewById(R.id.record_add_music_icon)");
    this.whf = ((WeImageView)paramViewGroup);
    paramViewGroup = this.wgq.findViewById(2131306696);
    p.g(paramViewGroup, "layout.findViewById(R.id.record_add_music_text)");
    this.whg = ((TextView)paramViewGroup);
    paramViewGroup = this.wgq.findViewById(2131306695);
    p.g(paramViewGroup, "layout.findViewById(R.id…cord_add_music_indicator)");
    this.whh = paramViewGroup;
    paramViewGroup = this.wgq.findViewById(2131306693);
    p.g(paramViewGroup, "layout.findViewById(R.id…ecord_add_music_duration)");
    this.whi = ((TextView)paramViewGroup);
    this.whl = true;
    this.whe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254495);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (g.a(this.who)) {
          d.b.a(this.who.wgr, d.c.BWV);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254495);
      }
    });
    this.whg.setSelected(true);
    this.whe.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254496);
        int i = g.b(this.who).getWidth();
        int j = g.c(this.who).getWidth();
        int k = g.d(this.who).getWidth();
        int m = com.tencent.mm.cb.a.fromDPToPix(this.who.wgq.getContext(), 54);
        g.e(this.who).setMaxWidth(i - j - k - m);
        AppMethodBeat.o(254496);
      }
    });
    if (this.whl)
    {
      this.whl = false;
      this.whh.setVisibility(4);
    }
    AppMethodBeat.o(254500);
  }
  
  public final void Gt(long paramLong)
  {
    AppMethodBeat.i(254499);
    if (paramLong < whm)
    {
      this.whi.setVisibility(0);
      this.whi.setText((CharSequence)this.wgq.getContext().getString(2131760508, new Object[] { Integer.valueOf(kotlin.h.a.cR((float)paramLong / 1000.0F)) }));
      AppMethodBeat.o(254499);
      return;
    }
    this.whi.setVisibility(8);
    AppMethodBeat.o(254499);
  }
  
  public final void aSs() {}
  
  public final void dFW()
  {
    Object localObject2 = null;
    AppMethodBeat.i(254498);
    if (this.whj == null)
    {
      this.whg.setText(2131760509);
      Gt(whm);
      AppMethodBeat.o(254498);
      return;
    }
    TextView localTextView = this.whg;
    Object localObject1 = this.whj;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((AudioCacheInfo)localObject1).BOZ;
      localObject1 = (Collection)localObject1;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label116;
      }
      i = 1;
      label76:
      if (i == 0) {
        break label126;
      }
      localObject1 = this.whj;
      if (localObject1 == null) {
        break label121;
      }
    }
    label116:
    label121:
    for (localObject1 = ((AudioCacheInfo)localObject1).BPc;; localObject1 = null)
    {
      localObject1 = (CharSequence)localObject1;
      localTextView.setText((CharSequence)localObject1);
      AppMethodBeat.o(254498);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label76;
    }
    label126:
    localObject1 = this.whj;
    if (localObject1 != null) {}
    for (localObject1 = ((AudioCacheInfo)localObject1).BOZ;; localObject1 = null)
    {
      String str = Util.listToString((List)localObject1, ",");
      StringBuilder localStringBuilder = new StringBuilder();
      AudioCacheInfo localAudioCacheInfo = this.whj;
      localObject1 = localObject2;
      if (localAudioCacheInfo != null) {
        localObject1 = localAudioCacheInfo.BPc;
      }
      localObject1 = (CharSequence)((String)localObject1 + " - " + str);
      break;
    }
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
    AppMethodBeat.i(254502);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(254502);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(254497);
    this.whe.setVisibility(paramInt);
    if (paramInt == 0) {
      dFW();
    }
    AppMethodBeat.o(254497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.g
 * JD-Core Version:    0.7.0.1
 */