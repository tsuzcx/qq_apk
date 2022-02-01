package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.recovery.util.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curGiftId", "giftPlayView", "Lorg/libpag/PAGView;", "canClearScreen", "", "playGiftAnimation", "", "isForceReplace", "showGift", "giftId", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class ac
  extends d
{
  private final String TAG;
  private final b hOp;
  String upm;
  final PAGView upx;
  
  public ac(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246669);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveGiftPlayPlugin";
    paramViewGroup = paramViewGroup.findViewById(2131301014);
    p.g(paramViewGroup, "root.findViewById(R.id.finder_live_gift_play_view)");
    this.upx = ((PAGView)paramViewGroup);
    AppMethodBeat.o(246669);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246668);
    p.h(paramc, "status");
    switch (ad.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246668);
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
      p.g(paramc, "param?.getString(ILiveSt…RAM_LIVE_GIFT_INFO) ?: \"\"");
      boolean bool;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("PARAM_LIVE_GIFT_IS_FORCE_REPLACE", false);
      }
      while (paramc != null)
      {
        paramBundle = e.uiD;
        paramBundle = e.atA(paramc);
        if ((paramBundle != null) && (!Util.isNullOrNil(paramBundle.field_animationPagUrl)))
        {
          Log.i(this.TAG, "show full screen gift,id:" + paramc + ", info:" + paramBundle + ",isForceReplace:" + bool);
          this.upm = paramc;
          rg(0);
          Log.i(this.TAG, "playGiftAnimation playViewIsPlaying:" + this.upx.isPlaying() + ", isForceReplace:" + bool + ", isLandscape:" + isLandscape());
          if (((this.upx.isPlaying()) && (!bool)) || (isLandscape()))
          {
            AppMethodBeat.o(246668);
            return;
            bool = false;
          }
          else
          {
            this.upx.post((Runnable)new a(this));
            AppMethodBeat.o(246668);
          }
        }
        else
        {
          Log.i(this.TAG, "skip show full screen gift id:" + paramc + ", giftPath is null");
        }
      }
      AppMethodBeat.o(246668);
      return;
      rg(8);
      this.upx.stop();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ac paramac) {}
    
    public final void run()
    {
      AppMethodBeat.i(246667);
      Object localObject = e.uiD;
      PAGView localPAGView;
      String str;
      if (e.getDebug())
      {
        localPAGView = this.upy.upx;
        localObject = this.upy.hwr.getContext();
        p.g(localObject, "root.context");
        AssetManager localAssetManager = ((Context)localObject).getAssets();
        localObject = e.uiD;
        str = e.atz(this.upy.upm);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localPAGView.setFile(PAGFile.Load(localAssetManager, (String)localObject));
      }
      for (;;)
      {
        this.upy.upx.setScaleMode(3);
        this.upy.upx.setRepeatCount(0);
        this.upy.upx.addListener((PAGView.PAGViewListener)new PAGView.PAGViewListener()
        {
          public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
          
          public final void onAnimationEnd(PAGView paramAnonymousPAGView) {}
          
          public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
          
          public final void onAnimationStart(PAGView paramAnonymousPAGView)
          {
            AppMethodBeat.i(246666);
            this.upz.upy.upx.setVisibility(0);
            AppMethodBeat.o(246666);
          }
        });
        this.upy.upx.play();
        AppMethodBeat.o(246667);
        return;
        localPAGView = this.upy.upx;
        localObject = e.uiD;
        str = e.atz(this.upy.upm);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localPAGView.setFile(PAGFile.Load((String)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ac
 * JD-Core Version:    0.7.0.1
 */