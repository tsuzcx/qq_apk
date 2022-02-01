package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MUSIC_GUIDE_ANIMATION_FILE", "", "getMUSIC_GUIDE_ANIMATION_FILE", "()Ljava/lang/String;", "TAG", "enableMusic", "", "getEnableMusic", "()Z", "setEnableMusic", "(Z)V", "guideAnim", "Lorg/libpag/PAGView;", "getGuideAnim", "()Lorg/libpag/PAGView;", "setGuideAnim", "(Lorg/libpag/PAGView;)V", "guideTv", "Landroid/widget/TextView;", "getGuideTv", "()Landroid/widget/TextView;", "setGuideTv", "(Landroid/widget/TextView;)V", "haveShowGuide", "getHaveShowGuide", "setHaveShowGuide", "isPagEnable", "kotlin.jvm.PlatformType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "checkVisible", "", "enableVolumeGuide", "hideGuideView", "initGuideView", "showGuideView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends b
{
  private final String CWi;
  PAGView CWj;
  TextView CWk;
  private boolean CWl;
  private boolean CWm;
  final Boolean CyU;
  final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public t(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353795);
    this.nfT = paramb;
    this.TAG = "Finder.LiveAnchorGuidePlugin";
    this.CWi = "finder_live_anchor_music_guide.pag";
    this.CyU = ((cn)h.az(cn.class)).isPagEnable();
    paramb = h.baE().ban().get(at.a.adaV, Boolean.FALSE);
    if (paramb == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(353795);
      throw paramViewGroup;
    }
    this.CWl = ((Boolean)paramb).booleanValue();
    paramb = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    this.CWm = com.tencent.mm.plugin.finder.live.utils.a.euF();
    if (this.CWm) {
      paramViewGroup.post(new t..ExternalSyntheticLambda0(paramViewGroup));
    }
    AppMethodBeat.o(353795);
  }
  
  private static final void x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(353801);
    s.u(paramViewGroup, "$root");
    Object localObject = paramViewGroup.getLayoutParams();
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(353801);
      throw paramViewGroup;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += bf.bk(paramViewGroup.getContext());
    AppMethodBeat.o(353801);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(353818);
    Object localObject = aj.CGT;
    localObject = aj.elM();
    if (localObject == null)
    {
      localObject = null;
      boolean bool = ((e)business(e.class)).eyK();
      Log.i(this.TAG, "enableVolumeGuide isPlayingBgMusic:" + localObject + ", enableMusic:" + this.CWm + ", liveStatus:" + ((e)business(e.class)).EcT + ", checkVisible haveShowGuide:" + this.CWl + ", isPagEnable:" + this.CyU + ", isMicLinking:" + bool);
      if ((this.CWl) || (!this.CWm) || (!s.p(localObject, Boolean.TRUE)) || (!((e)business(e.class)).isLiveStarted()) || (bool)) {
        break label390;
      }
    }
    label390:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!this.CWl)
        {
          localObject = this.CyU;
          s.s(localObject, "isPagEnable");
          if (((Boolean)localObject).booleanValue())
          {
            Log.i(this.TAG, "showGuideView");
            h.baE().ban().set(at.a.adaV, Boolean.TRUE);
            this.CWl = true;
            localObject = aw.Gjk;
            aw.aBW("FinderLiveAnchorGuidePlugin");
            if (this.CWj == null)
            {
              this.CWj = ((PAGView)this.mJe.findViewById(p.e.BYq));
              localObject = this.CWj;
              if (localObject != null) {
                ((PAGView)localObject).setFile(PAGFile.Load(this.mJe.getContext().getAssets(), this.CWi));
              }
              localObject = this.CWj;
              if (localObject != null) {
                ((PAGView)localObject).setRepeatCount(0);
              }
            }
            if (this.CWk == null) {
              this.CWk = ((TextView)this.mJe.findViewById(p.e.BYr));
            }
            localObject = this.CWj;
            if (localObject != null) {
              ((PAGView)localObject).play();
            }
            localObject = this.CWj;
            if (localObject != null) {
              ((PAGView)localObject).setVisibility(0);
            }
            localObject = this.CWk;
            if (localObject != null) {
              ((TextView)localObject).setVisibility(0);
            }
          }
        }
        tO(0);
      }
      AppMethodBeat.o(353818);
      return;
      localObject = Boolean.valueOf(((com.tencent.mm.live.core.core.trtc.a)localObject).mRI);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.t
 * JD-Core Version:    0.7.0.1
 */