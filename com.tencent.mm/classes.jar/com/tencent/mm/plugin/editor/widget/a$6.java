package com.tencent.mm.plugin.editor.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.editor.d.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

public final class a$6
  implements View.OnClickListener
{
  public a$6(a parama, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(181975);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = RecordConfigProvider.fvX();
    localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).avX();
    ((UICustomParam.a)localObject).avW();
    ((UICustomParam.a)localObject).dZ(true);
    paramView.HKT = ((UICustomParam.a)localObject).jwj;
    if (this.uwl.uwj)
    {
      localObject = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      com.tencent.mm.plugin.recordvideo.jumper.a.b(this.val$context, 4097, d.a.sight_slide_bottom_in, d.a.sight_slide_bottom_out, paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(181975);
      return;
      Intent localIntent = new Intent();
      localObject = (SightParams)localIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = new SightParams(4, 0);
      }
      localObject = "micromsg_" + System.currentTimeMillis();
      String str1 = com.tencent.mm.loader.j.b.aSX() + (String)localObject + ".mp4";
      String str2 = com.tencent.mm.loader.j.b.aSX() + (String)localObject + ".jpeg";
      int i = localIntent.getIntExtra("key_pick_local_media_duration", 60);
      SightParams localSightParams = new SightParams(4, 1);
      localSightParams.EYi = 2;
      localSightParams.mode = 0;
      if (localSightParams.lgX == null) {
        localSightParams.lgX = new VideoTransPara();
      }
      localSightParams.lgX.duration = i;
      localSightParams.A((String)localObject, str1, str2, AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
      localIntent.putExtra("KEY_SIGHT_PARAMS", paramView);
      u.a(this.val$context, 4098, localIntent, 4, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a.6
 * JD-Core Version:    0.7.0.1
 */