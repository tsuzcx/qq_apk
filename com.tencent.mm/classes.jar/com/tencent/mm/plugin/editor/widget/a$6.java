package com.tencent.mm.plugin.editor.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

public final class a$6
  implements View.OnClickListener
{
  public a$6(a parama, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(181975);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    paramView = RecordConfigProvider.eJM();
    localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).apE();
    ((UICustomParam.a)localObject).apD();
    ((UICustomParam.a)localObject).dz(true);
    paramView.BOn = ((UICustomParam.a)localObject).gLU;
    if (this.qUf.qUd)
    {
      localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(this.val$context, 4097, paramView);
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
      String str1 = com.tencent.mm.loader.j.b.aKV() + (String)localObject + ".mp4";
      String str2 = com.tencent.mm.loader.j.b.aKV() + (String)localObject + ".jpeg";
      int i = localIntent.getIntExtra("key_pick_local_media_duration", 60);
      SightParams localSightParams = new SightParams(4, 1);
      localSightParams.zsH = 2;
      localSightParams.mode = 0;
      if (localSightParams.irT == null) {
        localSightParams.irT = new VideoTransPara();
      }
      localSightParams.irT.duration = i;
      localSightParams.v((String)localObject, str1, str2, AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
      localIntent.putExtra("KEY_SIGHT_PARAMS", paramView);
      s.a(this.val$context, 4098, localIntent, 4, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a.6
 * JD-Core Version:    0.7.0.1
 */