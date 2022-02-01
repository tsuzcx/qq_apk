package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.a;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.recovery.util.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curGiftId", "giftPlayView", "Lorg/libpag/PAGView;", "canClearScreen", "", "playGiftAnimation", "", "isForceReplace", "showGift", "giftId", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class bb
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final PAGView yqK;
  private String yqk;
  
  public bb(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(232047);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveGiftPlayPlugin";
    paramViewGroup = paramViewGroup.findViewById(b.f.finder_live_gift_play_view);
    p.j(paramViewGroup, "root.findViewById(R.id.finder_live_gift_play_view)");
    this.yqK = ((PAGView)paramViewGroup);
    AppMethodBeat.o(232047);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(232046);
    p.k(paramc, "status");
    switch (bc.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(232046);
      return;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("PARAM_LIVE_GIFT_INFO");
        paramc = str;
        if (str != null) {}
      }
      else
      {
        paramc = "";
      }
      p.j(paramc, "param?.getString(ILiveSt…RAM_LIVE_GIFT_INFO) ?: \"\"");
      boolean bool;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("PARAM_LIVE_GIFT_IS_FORCE_REPLACE", false);
      }
      while (paramc != null)
      {
        paramBundle = m.yfw;
        paramBundle = m.aCc(paramc);
        if ((paramBundle != null) && (!Util.isNullOrNil(paramBundle.field_animationPagUrl)))
        {
          Log.i(this.TAG, "show full screen gift,id:" + paramc + ", info:" + paramBundle + ",isForceReplace:" + bool);
          this.yqk = paramc;
          tU(0);
          Log.i(this.TAG, "playGiftAnimation playViewIsPlaying:" + this.yqK.isPlaying() + ", isForceReplace:" + bool + ", isLandscape:" + isLandscape());
          if (((this.yqK.isPlaying()) && (!bool)) || (isLandscape()))
          {
            AppMethodBeat.o(232046);
            return;
            bool = false;
          }
          else
          {
            this.yqK.post((Runnable)new a(this));
            AppMethodBeat.o(232046);
          }
        }
        else
        {
          Log.i(this.TAG, "skip show full screen gift id:" + paramc + ", giftPath is null");
        }
      }
      AppMethodBeat.o(232046);
      return;
      tU(8);
      this.yqK.setVisibility(8);
      this.yqK.stop();
      this.yqK.setFile(null);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(bb parambb) {}
    
    public final void run()
    {
      AppMethodBeat.i(288841);
      Object localObject = m.yfw;
      PAGView localPAGView;
      String str;
      if (m.getDebug())
      {
        localPAGView = bb.a(this.yqL);
        localObject = this.yqL.kiF.getContext();
        p.j(localObject, "root.context");
        AssetManager localAssetManager = ((Context)localObject).getAssets();
        localObject = m.yfw;
        str = m.aCb(bb.b(this.yqL));
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localPAGView.setFile(PAGFile.Load(localAssetManager, (String)localObject));
      }
      for (;;)
      {
        bb.a(this.yqL).setScaleMode(3);
        bb.a(this.yqL).setRepeatCount(0);
        bb.a(this.yqL).addListener((PAGView.PAGViewListener)new PAGView.PAGViewListener()
        {
          public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
          
          public final void onAnimationEnd(PAGView paramAnonymousPAGView) {}
          
          public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
          
          public final void onAnimationStart(PAGView paramAnonymousPAGView)
          {
            AppMethodBeat.i(285908);
            bb.a(this.yqM.yqL).setVisibility(0);
            AppMethodBeat.o(285908);
          }
        });
        bb.a(this.yqL).play();
        bb.a(this.yqL).flush();
        AppMethodBeat.o(288841);
        return;
        localPAGView = bb.a(this.yqL);
        localObject = m.yfw;
        str = m.aCb(bb.b(this.yqL));
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localPAGView.setFile(PAGFile.Load((String)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bb
 * JD-Core Version:    0.7.0.1
 */