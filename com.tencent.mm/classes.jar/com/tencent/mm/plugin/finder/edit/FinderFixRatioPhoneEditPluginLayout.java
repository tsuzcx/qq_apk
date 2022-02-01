package com.tencent.mm.plugin.finder.edit;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/edit/FinderFixRatioPhoneEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setOutputSize", "path", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderFixRatioPhoneEditPluginLayout
  extends EditPhotoPluginLayout
{
  public FinderFixRatioPhoneEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286254);
    AppMethodBeat.o(286254);
  }
  
  private final void setOutputSize(String paramString)
  {
    AppMethodBeat.i(286253);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      "setOutputSize getOption error. path:".concat(String.valueOf(paramString));
      h.ioq();
      AppMethodBeat.o(286253);
      return;
    }
    new StringBuilder("setOutputSize config[origin[").append(localOptions.outWidth).append(',').append(localOptions.outHeight).append("] target[1080,1440").append(']');
    h.ioq();
    getEditPhotoWrapper().setOutputSize(1080, 1440);
    AppMethodBeat.o(286253);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(286251);
    super.a(paramb);
    com.tencent.mm.ca.b localb = getEditPhotoWrapper().FvS;
    Object localObject;
    if (localb != null)
    {
      localObject = getConfigProvider();
      if (localObject == null) {
        break label94;
      }
      localObject = ((RecordConfigProvider)localObject).mab;
      if (localObject == null) {
        break label94;
      }
    }
    label94:
    for (float f = ((Bundle)localObject).getFloat("crop_fix_ratio");; f = 0.75F)
    {
      localb.cv(f);
      post((Runnable)new a(this));
      if (paramb == null) {
        break;
      }
      setOutputSize(paramb.lfq);
      AppMethodBeat.o(286251);
      return;
    }
    AppMethodBeat.o(286251);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(286252);
    p.k(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(286252);
      return;
    case 1: 
      getEditPhotoWrapper().fwS();
      getEditPhotoWrapper().eof();
      AppMethodBeat.o(286252);
      return;
    case 2: 
      paramc = getContext();
      if (paramc == null)
      {
        paramc = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(286252);
        throw paramc;
      }
      ((Activity)paramc).finish();
      AppMethodBeat.o(286252);
      return;
    case 3: 
    case 4: 
      AppMethodBeat.o(286252);
      return;
    }
    super.a(paramc, paramBundle);
    paramc = getPhotoControlUI().HNt;
    p.j(paramc, "photoControlUI.unDoImg");
    paramc.setVisibility(4);
    paramc = getPhotoControlUI().HNu;
    p.j(paramc, "photoControlUI.rotateImg");
    paramc.setVisibility(4);
    getPhotoControlUI().HNt.setOnClickListener(null);
    getPhotoControlUI().HNu.setOnClickListener(null);
    paramc = findViewById(b.e.editor_control_icons_layout);
    if (paramc != null) {
      paramc.setVisibility(8);
    }
    paramc = findViewById(b.e.editor_mix);
    if (paramc != null)
    {
      paramc.setVisibility(8);
      AppMethodBeat.o(286252);
      return;
    }
    AppMethodBeat.o(286252);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderFixRatioPhoneEditPluginLayout paramFinderFixRatioPhoneEditPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(291010);
      d.b.a(this.xpU, d.c.HSp);
      AppMethodBeat.o(291010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderFixRatioPhoneEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */