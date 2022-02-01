package com.tencent.mm.plugin.editor.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.pluginsdk.ui.tools.q;

public final class a$6
  implements View.OnClickListener
{
  public a$6(a parama, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(181975);
    paramView = RecordConfigProvider.dvn();
    Object localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).YX();
    ((UICustomParam.a)localObject).YW();
    ((UICustomParam.a)localObject).cN(true);
    paramView.wqu = ((UICustomParam.a)localObject).fKH;
    if (this.oUA.oUy)
    {
      localObject = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(this.val$context, 4097, paramView);
      AppMethodBeat.o(181975);
      return;
    }
    Intent localIntent = new Intent();
    localObject = (SightParams)localIntent.getParcelableExtra("KEY_SIGHT_PARAMS");
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = new SightParams(4, 0);
    }
    localObject = "micromsg_" + System.currentTimeMillis();
    String str1 = b.aps() + (String)localObject + ".mp4";
    String str2 = b.aps() + (String)localObject + ".jpeg";
    int i = localIntent.getIntExtra("key_pick_local_media_duration", 60);
    SightParams localSightParams = new SightParams(4, 1);
    localSightParams.uJv = 2;
    localSightParams.mode = 0;
    if (localSightParams.hcZ == null) {
      localSightParams.hcZ = new VideoTransPara();
    }
    localSightParams.hcZ.duration = i;
    localSightParams.r((String)localObject, str1, str2, b.aps() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    localIntent.putExtra("KEY_SIGHT_PARAMS", paramView);
    q.a(this.val$context, 4098, localIntent, 4, 1);
    AppMethodBeat.o(181975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a.6
 * JD-Core Version:    0.7.0.1
 */