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
import com.tencent.mm.plugin.recordvideo.d.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "iconCheck", "Landroid/widget/ImageView;", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "enableBeauty", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class a
  implements t
{
  private final WeImageView HFs;
  private final ImageView Ldf;
  boolean iwN;
  private d vjo;
  private boolean vkU;
  boolean vkV;
  boolean vkW;
  final e vkY;
  ViewGroup vkj;
  
  public a(ViewGroup paramViewGroup, d paramd, e parame)
  {
    AppMethodBeat.i(199896);
    this.vkj = paramViewGroup;
    this.vjo = paramd;
    this.vkY = parame;
    this.iwN = true;
    this.vkW = true;
    this.HFs = ((WeImageView)this.vkj.findViewById(2131307264));
    this.Ldf = ((ImageView)this.vkj.findViewById(2131307265));
    this.HFs.setIconColor(-1);
    this.Ldf.setImageDrawable(com.tencent.mm.cd.a.l(this.vkj.getContext(), 2131691536));
    this.vkj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool2 = true;
        boolean bool1 = true;
        AppMethodBeat.i(199889);
        if (this.Ldg.iwN)
        {
          paramAnonymousView = this.Ldg;
          if (!this.Ldg.vkV) {}
          for (;;)
          {
            paramAnonymousView.vkV = bool1;
            this.Ldg.setEnable(this.Ldg.vkV);
            AppMethodBeat.o(199889);
            return;
            bool1 = false;
          }
        }
        paramAnonymousView = this.Ldg;
        if (!this.Ldg.vkW) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramAnonymousView.vkW = bool1;
          this.Ldg.setEnable(this.Ldg.vkW);
          AppMethodBeat.o(199889);
          return;
        }
      }
    });
    if ((bu.eGT()) || (h.IS_FLAVOR_PURPLE)) {
      this.vkj.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199890);
          paramAnonymousView = new android.support.design.widget.a(this.Ldg.vkj.getContext());
          Object localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = this.Ldg.vkj.getContext();
          k.g(localObject, "view.context");
          localObject = new XLabEffectSettingView((Context)localObject);
          ((XLabEffectSettingView)localObject).setCameraView(this.Ldg.vkY);
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          AppMethodBeat.o(199890);
          return true;
        }
      });
    }
    AppMethodBeat.o(199896);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(199893);
    k.h(paramRecordConfigProvider, "config");
    this.vkU = paramRecordConfigProvider.vif.vij;
    if (this.vkU)
    {
      this.vkj.setVisibility(0);
      if (this.iwN) {}
      for (boolean bool = this.vkV;; bool = this.vkW)
      {
        setEnable(bool);
        AppMethodBeat.o(199893);
        return;
      }
    }
    this.vkj.setVisibility(8);
    AppMethodBeat.o(199893);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final boolean fWA()
  {
    AppMethodBeat.i(199895);
    ImageView localImageView = this.Ldf;
    k.g(localImageView, "iconCheck");
    if (localImageView.getVisibility() == 0)
    {
      AppMethodBeat.o(199895);
      return true;
    }
    AppMethodBeat.o(199895);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void ot(boolean paramBoolean)
  {
    AppMethodBeat.i(199892);
    this.iwN = paramBoolean;
    if (this.vkU) {
      if (!this.iwN) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = this.vkV;; paramBoolean = this.vkW)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(199892);
      return;
    }
  }
  
  public final void release() {}
  
  public final void reset() {}
  
  final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(199894);
    Object localObject = this.Ldf;
    k.g(localObject, "iconCheck");
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = b.vpp;
      b.v("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.vjo.a(d.c.vnC, (Bundle)localObject);
      AppMethodBeat.o(199894);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(199891);
    if (this.vkU) {
      this.vkj.setVisibility(paramInt);
    }
    AppMethodBeat.o(199891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.a
 * JD-Core Version:    0.7.0.1
 */