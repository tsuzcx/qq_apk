package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e;
import com.tencent.mm.storage.q;

final class a$6
  implements View.OnClickListener
{
  a$6(a parama, int paramInt, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14103);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if ((this.jMC > 0) || (!this.jMz.ywA)) {}
    for (paramView = paramView.findViewById(2131821891);; paramView = paramView.findViewById(2131821438))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("biz_video_scene", 90);
      localBundle.putInt("biz_video_subscene", a.a(this.jVZ).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000));
      localBundle.putInt("geta8key_scene", 56);
      e.a(a.a(this.jVZ), this.jMz.field_msgId, this.jMz.field_msgSvrId, this.jMC, paramView, localBundle);
      a.f(this.jVZ).a(this.jMz, this.jMC, i);
      AppMethodBeat.o(14103);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.6
 * JD-Core Version:    0.7.0.1
 */