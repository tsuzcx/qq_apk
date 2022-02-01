package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.platformtools.Log;

final class CustomSmileyPreviewUI$2
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$2(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108790);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if ((CustomSmileyPreviewUI.q(this.xRd) != null) && (CustomSmileyPreviewUI.q(this.xRd).aarb != null))
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this.xRd.getContext(), EmojiStoreV2DesignerUI.class);
      ((Intent)localObject).putExtra("uin", CustomSmileyPreviewUI.q(this.xRd).aarb.ZtX);
      ((Intent)localObject).putExtra("name", CustomSmileyPreviewUI.q(this.xRd).aarb.IGU);
      ((Intent)localObject).putExtra("headurl", CustomSmileyPreviewUI.q(this.xRd).aarb.ZuK);
      ((Intent)localObject).putExtra("extra_scence", 9);
      paramView = this.xRd.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108790);
      return;
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */