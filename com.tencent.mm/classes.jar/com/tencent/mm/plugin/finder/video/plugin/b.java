package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "iconCheck", "Landroid/widget/ImageView;", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "enableBeauty", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class b
  implements t
{
  boolean krh;
  private final WeImageView uGm;
  private boolean wgN;
  boolean wgO;
  boolean wgP;
  private final ImageView wgQ;
  ViewGroup wgR;
  final e wgS;
  private d wgr;
  
  public b(ViewGroup paramViewGroup, d paramd, e parame)
  {
    AppMethodBeat.i(254465);
    this.wgR = paramViewGroup;
    this.wgr = paramd;
    this.wgS = parame;
    this.krh = true;
    this.wgP = true;
    this.uGm = ((WeImageView)this.wgR.findViewById(2131297342));
    this.wgQ = ((ImageView)this.wgR.findViewById(2131297343));
    this.uGm.setIconColor(com.tencent.mm.cb.a.n(this.wgR.getContext(), 2131101307));
    this.wgQ.setImageDrawable(com.tencent.mm.cb.a.l(this.wgR.getContext(), 2131691337));
    this.wgR.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(254458);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.wgT.krh)
        {
          paramAnonymousView = this.wgT;
          if (!this.wgT.wgO) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousView.wgO = bool;
            this.wgT.setEnable(this.wgT.wgO);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254458);
            return;
          }
        }
        paramAnonymousView = this.wgT;
        if (!this.wgT.wgP) {}
        for (;;)
        {
          paramAnonymousView.wgP = bool;
          this.wgT.setEnable(this.wgT.wgP);
          break;
          bool = false;
        }
      }
    });
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      this.wgR.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(254459);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = new android.support.design.widget.a(this.wgT.wgR.getContext());
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = this.wgT.wgR.getContext();
          p.g(localObject, "view.context");
          localObject = new XLabEffectSettingView((Context)localObject);
          ((XLabEffectSettingView)localObject).setCameraView(this.wgT.wgS);
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(254459);
          return true;
        }
      });
    }
    AppMethodBeat.o(254465);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(254462);
    p.h(paramRecordConfigProvider, "config");
    this.wgN = paramRecordConfigProvider.BOJ.BOM;
    if (this.wgN)
    {
      this.wgR.setVisibility(0);
      if (this.krh) {}
      for (boolean bool = this.wgO;; bool = this.wgP)
      {
        setEnable(bool);
        AppMethodBeat.o(254462);
        return;
      }
    }
    this.wgR.setVisibility(8);
    AppMethodBeat.o(254462);
  }
  
  public final void aSs() {}
  
  public final boolean dFS()
  {
    AppMethodBeat.i(254464);
    ImageView localImageView = this.wgQ;
    p.g(localImageView, "iconCheck");
    if (localImageView.getVisibility() == 0)
    {
      AppMethodBeat.o(254464);
      return true;
    }
    AppMethodBeat.o(254464);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void oS(boolean paramBoolean)
  {
    AppMethodBeat.i(254461);
    this.krh = paramBoolean;
    if (this.wgN) {
      if (!this.krh) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = this.wgO;; paramBoolean = this.wgP)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(254461);
      return;
    }
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
    AppMethodBeat.i(254466);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(254466);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(254463);
    Object localObject = this.wgQ;
    p.g(localObject, "iconCheck");
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = c.BXI;
      c.x("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.wgr.a(d.c.BUF, (Bundle)localObject);
      AppMethodBeat.o(254463);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(254460);
    if (this.wgN) {
      this.wgR.setVisibility(paramInt);
    }
    AppMethodBeat.o(254460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.b
 * JD-Core Version:    0.7.0.1
 */