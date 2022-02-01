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
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "iconCheck", "Landroid/widget/ImageView;", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "enableBeauty", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class a
  implements t
{
  boolean iWQ;
  private boolean rTN;
  boolean rTO;
  boolean rTP;
  private final WeImageView rTQ;
  private final ImageView rTR;
  ViewGroup rTS;
  private d rTT;
  final e rTU;
  
  public a(ViewGroup paramViewGroup, d paramd, e parame)
  {
    AppMethodBeat.i(203964);
    this.rTS = paramViewGroup;
    this.rTT = paramd;
    this.rTU = parame;
    this.iWQ = true;
    this.rTP = true;
    this.rTQ = ((WeImageView)this.rTS.findViewById(2131307278));
    this.rTR = ((ImageView)this.rTS.findViewById(2131307279));
    this.rTQ.setIconColor(-1);
    this.rTR.setImageDrawable(com.tencent.mm.cc.a.l(this.rTS.getContext(), 2131691551));
    this.rTS.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool2 = true;
        boolean bool1 = true;
        AppMethodBeat.i(203957);
        if (this.rTV.iWQ)
        {
          paramAnonymousView = this.rTV;
          if (!this.rTV.rTO) {}
          for (;;)
          {
            paramAnonymousView.rTO = bool1;
            this.rTV.setEnable(this.rTV.rTO);
            AppMethodBeat.o(203957);
            return;
            bool1 = false;
          }
        }
        paramAnonymousView = this.rTV;
        if (!this.rTV.rTP) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramAnonymousView.rTP = bool1;
          this.rTV.setEnable(this.rTV.rTP);
          AppMethodBeat.o(203957);
          return;
        }
      }
    });
    if ((bt.eWo()) || (h.IS_FLAVOR_PURPLE)) {
      this.rTS.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203958);
          paramAnonymousView = new android.support.design.widget.a(this.rTV.rTS.getContext());
          Object localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = this.rTV.rTS.getContext();
          k.g(localObject, "view.context");
          localObject = new XLabEffectSettingView((Context)localObject);
          ((XLabEffectSettingView)localObject).setCameraView(this.rTV.rTU);
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          AppMethodBeat.o(203958);
          return true;
        }
      });
    }
    AppMethodBeat.o(203964);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(203961);
    k.h(paramRecordConfigProvider, "config");
    this.rTN = paramRecordConfigProvider.wqP.wqT;
    if (this.rTN)
    {
      this.rTS.setVisibility(0);
      if (this.iWQ) {}
      for (boolean bool = this.rTO;; bool = this.rTP)
      {
        setEnable(bool);
        AppMethodBeat.o(203961);
        return;
      }
    }
    this.rTS.setVisibility(8);
    AppMethodBeat.o(203961);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final boolean cEr()
  {
    AppMethodBeat.i(203963);
    ImageView localImageView = this.rTR;
    k.g(localImageView, "iconCheck");
    if (localImageView.getVisibility() == 0)
    {
      AppMethodBeat.o(203963);
      return true;
    }
    AppMethodBeat.o(203963);
    return false;
  }
  
  public final void lT(boolean paramBoolean)
  {
    AppMethodBeat.i(203960);
    this.iWQ = paramBoolean;
    if (this.rTN) {
      if (!this.iWQ) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = this.rTO;; paramBoolean = this.rTP)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(203960);
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
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(203962);
    Object localObject = this.rTR;
    k.g(localObject, "iconCheck");
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = c.wyg;
      c.w("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.rTT.a(d.c.wwd, (Bundle)localObject);
      AppMethodBeat.o(203962);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(203959);
    if (this.rTN) {
      this.rTS.setVisibility(paramInt);
    }
    AppMethodBeat.o(203959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.a
 * JD-Core Version:    0.7.0.1
 */