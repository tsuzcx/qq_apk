package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.f.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$l
  implements View.OnClickListener
{
  b$l(b paramb, int paramInt, v paramv, z paramz) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(266039);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$setCommonAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (this.sBa == 0)
    {
      paramView = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.aqv(this.sBb.vid);
    }
    int j = (int)(System.currentTimeMillis() / 1000L);
    paramView = new Bundle();
    localObject = h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((n)localObject).bbL().RG(this.sAV.field_talker);
    if ((localObject != null) && (!((as)localObject).axZ())) {}
    for (int i = 157;; i = 90)
    {
      paramView.putInt(f.b.VRT, i);
      i = this.sAP.sAm.getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      paramView.putInt(f.b.VRU, i);
      paramView.putInt("geta8key_scene", 56);
      localObject = MPVideoPreviewMgr.sSn;
      paramView.putString("biz_video_autoplay_id", MPVideoPreviewMgr.aqz(this.sBb.vid));
      paramView.putString("webpageTitle", this.sBb.title);
      localObject = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
      com.tencent.mm.plugin.webview.ui.tools.video.a.bnh(this.sBb.vid);
      d.a((Context)this.sAP.sAm, this.sAV.field_msgId, this.sAV.field_msgSvrId, this.sBa, paramView);
      b.b(this.sAP).a(this.sAV, this.sBa, j);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$setCommonAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(266039);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b.l
 * JD-Core Version:    0.7.0.1
 */