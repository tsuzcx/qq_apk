package com.tencent.mm.plugin.finder.edit;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.l;
import com.tencent.mm.plugin.recordvideo.plugin.m;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/edit/FinderFixRatioPhoneEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setOutputSize", "path", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFixRatioPhoneEditPluginLayout
  extends EditPhotoPluginLayout
{
  public FinderFixRatioPhoneEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(329832);
    AppMethodBeat.o(329832);
  }
  
  private static final void a(FinderFixRatioPhoneEditPluginLayout paramFinderFixRatioPhoneEditPluginLayout)
  {
    AppMethodBeat.i(329842);
    s.u(paramFinderFixRatioPhoneEditPluginLayout, "this$0");
    a.b.a((a)paramFinderFixRatioPhoneEditPluginLayout, a.c.NOV);
    AppMethodBeat.o(329842);
  }
  
  private final void setOutputSize(String paramString)
  {
    AppMethodBeat.i(329838);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      s.X("setOutputSize getOption error. path:", paramString);
      h.jXD();
      AppMethodBeat.o(329838);
      return;
    }
    new StringBuilder("setOutputSize config[origin[").append(localOptions.outWidth).append(',').append(localOptions.outHeight).append("] target[1080,1440").append(']');
    h.jXD();
    getEditPhotoWrapper().setOutputSize(1080, 1440);
    AppMethodBeat.o(329838);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    float f = 0.75F;
    AppMethodBeat.i(329850);
    super.a(paramb);
    com.tencent.mm.bt.b localb = getEditPhotoWrapper().Lsg;
    Object localObject;
    if (localb != null)
    {
      localObject = getConfigProvider();
      if (localObject != null) {
        break label74;
      }
    }
    for (;;)
    {
      localb.dG(f);
      post(new FinderFixRatioPhoneEditPluginLayout..ExternalSyntheticLambda0(this));
      if (paramb != null) {
        setOutputSize(paramb.nKb);
      }
      AppMethodBeat.o(329850);
      return;
      label74:
      localObject = ((RecordConfigProvider)localObject).oSS;
      if (localObject != null) {
        f = ((Bundle)localObject).getFloat("crop_fix_ratio");
      }
    }
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(329859);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
    }
    do
    {
      AppMethodBeat.o(329859);
      return;
      getEditPhotoWrapper().gIA();
      getEditPhotoWrapper().fti();
      AppMethodBeat.o(329859);
      return;
      paramc = getContext();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(329859);
        throw paramc;
      }
      ((Activity)paramc).finish();
      AppMethodBeat.o(329859);
      return;
      AppMethodBeat.o(329859);
      return;
      super.a(paramc, paramBundle);
      getPhotoControlUI().NKp.setVisibility(4);
      getPhotoControlUI().NKq.setVisibility(4);
      getPhotoControlUI().NKp.setOnClickListener(null);
      getPhotoControlUI().NKq.setOnClickListener(null);
      paramc = findViewById(b.e.editor_control_icons_layout);
      if (paramc != null) {
        paramc.setVisibility(8);
      }
      paramc = findViewById(b.e.editor_mix);
    } while (paramc == null);
    paramc.setVisibility(8);
    AppMethodBeat.o(329859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderFixRatioPhoneEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */