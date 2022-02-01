package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.h;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.w;

public final class al$3
  implements View.OnClickListener
{
  public al$3(al paramal, w paramw, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6070);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineVoiceItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if ((this.ogl.ofm.oay.isPlaying()) && (this.nOy.field_msgId == this.ogl.ofm.oay.oce))
    {
      this.ogl.ofm.oay.stopPlay();
      this.ogm.setImageResource(2131231675);
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineVoiceItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(6070);
      return;
    }
    paramView = this.ogl.ofm.oay;
    localObject = this.ogl.mContext;
    String str = s.getFullPath(this.nOy.field_imgPath);
    long l = this.nOy.field_msgId;
    paramView.bOv().a(paramView);
    ad.d("MicroMsg.FavVoiceLogic", "start play, path[%s]", new Object[] { str });
    if (paramView.bOv().cQ(str, -1)) {}
    for (paramView.oce = l;; paramView.oce = 0L)
    {
      paramView = ((l)g.ab(l.class)).dlK().xY(this.nOy.field_msgId);
      if (paramView.field_msgId == 0L) {
        break;
      }
      if (!s.Z(paramView)) {
        s.ab(paramView);
      }
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineVoiceItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(6070);
      return;
      Toast.makeText((Context)localObject, 2131756638, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.al.3
 * JD-Core Version:    0.7.0.1
 */