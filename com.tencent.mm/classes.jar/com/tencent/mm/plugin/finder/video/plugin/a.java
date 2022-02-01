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
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "iconCheck", "Landroid/widget/ImageView;", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "enableBeauty", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class a
  implements t
{
  boolean jsS;
  private boolean tbJ;
  boolean tbK;
  boolean tbL;
  private final WeImageView tbM;
  private final ImageView tbN;
  ViewGroup tbO;
  private d tbP;
  final e tbQ;
  
  public a(ViewGroup paramViewGroup, d paramd, e parame)
  {
    AppMethodBeat.i(205546);
    this.tbO = paramViewGroup;
    this.tbP = paramd;
    this.tbQ = parame;
    this.jsS = true;
    this.tbL = true;
    this.tbM = ((WeImageView)this.tbO.findViewById(2131307278));
    this.tbN = ((ImageView)this.tbO.findViewById(2131307279));
    this.tbM.setIconColor(-1);
    this.tbN.setImageDrawable(com.tencent.mm.cb.a.l(this.tbO.getContext(), 2131691551));
    this.tbO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(205539);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (this.tbR.jsS)
        {
          paramAnonymousView = this.tbR;
          if (!this.tbR.tbK) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousView.tbK = bool;
            this.tbR.setEnable(this.tbR.tbK);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(205539);
            return;
          }
        }
        paramAnonymousView = this.tbR;
        if (!this.tbR.tbL) {}
        for (;;)
        {
          paramAnonymousView.tbL = bool;
          this.tbR.setEnable(this.tbR.tbL);
          break;
          bool = false;
        }
      }
    });
    if ((bv.fpT()) || (j.IS_FLAVOR_PURPLE)) {
      this.tbO.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(205540);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
          paramAnonymousView = new android.support.design.widget.a(this.tbR.tbO.getContext());
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = this.tbR.tbO.getContext();
          p.g(localObject, "view.context");
          localObject = new XLabEffectSettingView((Context)localObject);
          ((XLabEffectSettingView)localObject).setCameraView(this.tbR.tbQ);
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(205540);
          return true;
        }
      });
    }
    AppMethodBeat.o(205546);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(205543);
    p.h(paramRecordConfigProvider, "config");
    this.tbJ = paramRecordConfigProvider.xOC.xOG;
    if (this.tbJ)
    {
      this.tbO.setVisibility(0);
      if (this.jsS) {}
      for (boolean bool = this.tbK;; bool = this.tbL)
      {
        setEnable(bool);
        AppMethodBeat.o(205543);
        return;
      }
    }
    this.tbO.setVisibility(8);
    AppMethodBeat.o(205543);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final boolean cPu()
  {
    AppMethodBeat.i(205545);
    ImageView localImageView = this.tbN;
    p.g(localImageView, "iconCheck");
    if (localImageView.getVisibility() == 0)
    {
      AppMethodBeat.o(205545);
      return true;
    }
    AppMethodBeat.o(205545);
    return false;
  }
  
  public final void mq(boolean paramBoolean)
  {
    AppMethodBeat.i(205542);
    this.jsS = paramBoolean;
    if (this.tbJ) {
      if (!this.jsS) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = this.tbK;; paramBoolean = this.tbL)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(205542);
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
    AppMethodBeat.i(205547);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(205547);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(205544);
    Object localObject = this.tbN;
    p.g(localObject, "iconCheck");
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = c.xWV;
      c.u("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.tbP.a(d.c.xUg, (Bundle)localObject);
      AppMethodBeat.o(205544);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(205541);
    if (this.tbJ) {
      this.tbO.setVisibility(paramInt);
    }
    AppMethodBeat.o(205541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.a
 * JD-Core Version:    0.7.0.1
 */