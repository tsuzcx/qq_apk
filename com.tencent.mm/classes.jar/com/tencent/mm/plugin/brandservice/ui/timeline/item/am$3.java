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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.w;

public final class am$3
  implements View.OnClickListener
{
  public am$3(am paramam, w paramw, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6070);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineVoiceItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if ((this.omk.oll.ogo.isPlaying()) && (this.nUe.field_msgId == this.omk.oll.ogo.ohT))
    {
      this.omk.oll.ogo.stopPlay();
      this.oml.setImageResource(2131231675);
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineVoiceItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(6070);
      return;
    }
    paramView = this.omk.oll.ogo;
    localObject = this.omk.mContext;
    String str = s.getFullPath(this.nUe.field_imgPath);
    long l = this.nUe.field_msgId;
    paramView.bPs().a(paramView);
    ae.d("MicroMsg.FavVoiceLogic", "start play, path[%s]", new Object[] { str });
    if (paramView.bPs().cU(str, -1)) {}
    for (paramView.ohT = l;; paramView.ohT = 0L)
    {
      paramView = ((l)g.ab(l.class)).doJ().ys(this.nUe.field_msgId);
      if (paramView.field_msgId == 0L) {
        break;
      }
      if (!s.Y(paramView)) {
        s.aa(paramView);
      }
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineVoiceItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(6070);
      return;
      Toast.makeText((Context)localObject, 2131756638, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.am.3
 * JD-Core Version:    0.7.0.1
 */