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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "iconCheck", "Landroid/widget/ImageView;", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "enableBeauty", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class a
  implements t
{
  boolean jpZ;
  boolean sQA;
  private final WeImageView sQB;
  private final ImageView sQC;
  ViewGroup sQD;
  private d sQE;
  final e sQF;
  private boolean sQy;
  boolean sQz;
  
  public a(ViewGroup paramViewGroup, d paramd, e parame)
  {
    AppMethodBeat.i(204921);
    this.sQD = paramViewGroup;
    this.sQE = paramd;
    this.sQF = parame;
    this.jpZ = true;
    this.sQA = true;
    this.sQB = ((WeImageView)this.sQD.findViewById(2131307278));
    this.sQC = ((ImageView)this.sQD.findViewById(2131307279));
    this.sQB.setIconColor(-1);
    this.sQC.setImageDrawable(com.tencent.mm.cc.a.l(this.sQD.getContext(), 2131691551));
    this.sQD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(204914);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.sQG.jpZ)
        {
          paramAnonymousView = this.sQG;
          if (!this.sQG.sQz) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousView.sQz = bool;
            this.sQG.setEnable(this.sQG.sQz);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(204914);
            return;
          }
        }
        paramAnonymousView = this.sQG;
        if (!this.sQG.sQA) {}
        for (;;)
        {
          paramAnonymousView.sQA = bool;
          this.sQG.setEnable(this.sQG.sQA);
          break;
          bool = false;
        }
      }
    });
    if ((bu.flY()) || (i.IS_FLAVOR_PURPLE)) {
      this.sQD.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(204915);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
          paramAnonymousView = new android.support.design.widget.a(this.sQG.sQD.getContext());
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = this.sQG.sQD.getContext();
          p.g(localObject, "view.context");
          localObject = new XLabEffectSettingView((Context)localObject);
          ((XLabEffectSettingView)localObject).setCameraView(this.sQG.sQF);
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(204915);
          return true;
        }
      });
    }
    AppMethodBeat.o(204921);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(204918);
    p.h(paramRecordConfigProvider, "config");
    this.sQy = paramRecordConfigProvider.xyG.xyK;
    if (this.sQy)
    {
      this.sQD.setVisibility(0);
      if (this.jpZ) {}
      for (boolean bool = this.sQz;; bool = this.sQA)
      {
        setEnable(bool);
        AppMethodBeat.o(204918);
        return;
      }
    }
    this.sQD.setVisibility(8);
    AppMethodBeat.o(204918);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final boolean cML()
  {
    AppMethodBeat.i(204920);
    ImageView localImageView = this.sQC;
    p.g(localImageView, "iconCheck");
    if (localImageView.getVisibility() == 0)
    {
      AppMethodBeat.o(204920);
      return true;
    }
    AppMethodBeat.o(204920);
    return false;
  }
  
  public final void ml(boolean paramBoolean)
  {
    AppMethodBeat.i(204917);
    this.jpZ = paramBoolean;
    if (this.sQy) {
      if (!this.jpZ) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = this.sQz;; paramBoolean = this.sQA)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(204917);
      return;
    }
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(204922);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(204922);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(204919);
    Object localObject = this.sQC;
    p.g(localObject, "iconCheck");
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = c.xHa;
      c.u("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.sQE.a(d.c.xEl, (Bundle)localObject);
      AppMethodBeat.o(204919);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(204916);
    if (this.sQy) {
      this.sQD.setVisibility(paramInt);
    }
    AppMethodBeat.o(204916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.a
 * JD-Core Version:    0.7.0.1
 */