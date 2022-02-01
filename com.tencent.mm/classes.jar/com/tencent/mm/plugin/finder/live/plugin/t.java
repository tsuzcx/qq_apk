package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MUSIC_GUIDE_ANIMATION_FILE", "", "getMUSIC_GUIDE_ANIMATION_FILE", "()Ljava/lang/String;", "TAG", "enableMusic", "", "getEnableMusic", "()Z", "setEnableMusic", "(Z)V", "guideAnim", "Lorg/libpag/PAGView;", "getGuideAnim", "()Lorg/libpag/PAGView;", "setGuideAnim", "(Lorg/libpag/PAGView;)V", "guideTv", "Landroid/widget/TextView;", "getGuideTv", "()Landroid/widget/TextView;", "setGuideTv", "(Landroid/widget/TextView;)V", "haveShowGuide", "getHaveShowGuide", "setHaveShowGuide", "isPagEnable", "checkVisible", "", "enableVolumeGuide", "hideGuideView", "initGuideView", "showGuideView", "plugin-finder_release"})
public final class t
  extends d
{
  final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  final boolean yaB;
  private final String ynp;
  PAGView ynq;
  TextView ynr;
  private boolean yns;
  private boolean ynt;
  
  public t(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(290126);
    this.kCL = paramb;
    this.TAG = "Finder.LiveAnchorGuidePlugin";
    this.ynp = "finder_live_anchor_music_guide.pag";
    paramb = h.ag(PluginFinder.class);
    p.j(paramb, "MMKernel.plugin(PluginFinder::class.java)");
    this.yaB = ((PluginFinder)paramb).isPagEnable();
    paramb = h.aHG();
    p.j(paramb, "MMKernel.storage()");
    paramb = paramb.aHp().get(ar.a.VyZ, Boolean.FALSE);
    if (paramb == null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(290126);
      throw paramViewGroup;
    }
    this.yns = ((Boolean)paramb).booleanValue();
    paramb = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    this.ynt = com.tencent.mm.plugin.finder.live.utils.a.dEG();
    if (this.ynt) {
      paramViewGroup.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269766);
          Object localObject = this.kCW.getLayoutParams();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(269766);
            throw ((Throwable)localObject);
          }
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ax.aB(this.kCW.getContext());
          AppMethodBeat.o(269766);
        }
      });
    }
    AppMethodBeat.o(290126);
  }
  
  public final void dAH()
  {
    AppMethodBeat.i(290125);
    Object localObject = ah.yhC;
    localObject = ah.dzB();
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((com.tencent.mm.live.core.core.trtc.a)localObject).knH);
      boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGY();
      Log.i(this.TAG, "enableVolumeGuide isPlayingBgMusic:" + localObject + ", enableMusic:" + this.ynt + ", liveStatus:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfv + ", checkVisible haveShowGuide:" + this.yns + ", isPagEnable:" + this.yaB + ", isMicLinking:" + bool);
      if ((this.yns) || (!this.ynt) || (!p.h(localObject, Boolean.TRUE)) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) || (bool)) {
        break label398;
      }
    }
    label398:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((!this.yns) && (this.yaB))
        {
          Log.i(this.TAG, "showGuideView");
          localObject = h.aHG();
          p.j(localObject, "MMKernel.storage()");
          ((f)localObject).aHp().set(ar.a.VyZ, Boolean.TRUE);
          this.yns = true;
          localObject = aj.AGc;
          aj.aFQ("FinderLiveAnchorGuidePlugin");
          if (this.ynq == null)
          {
            this.ynq = ((PAGView)this.kiF.findViewById(b.f.music_guide_anim));
            localObject = this.ynq;
            if (localObject != null)
            {
              Context localContext = this.kiF.getContext();
              p.j(localContext, "root.context");
              ((PAGView)localObject).setFile(PAGFile.Load(localContext.getAssets(), this.ynp));
            }
            localObject = this.ynq;
            if (localObject != null) {
              ((PAGView)localObject).setRepeatCount(0);
            }
          }
          if (this.ynr == null) {
            this.ynr = ((TextView)this.kiF.findViewById(b.f.music_guide_tv));
          }
          localObject = this.ynq;
          if (localObject != null) {
            ((PAGView)localObject).play();
          }
          localObject = this.ynq;
          if (localObject != null) {
            ((PAGView)localObject).setVisibility(0);
          }
          localObject = this.ynr;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        tU(0);
      }
      AppMethodBeat.o(290125);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.t
 * JD-Core Version:    0.7.0.1
 */