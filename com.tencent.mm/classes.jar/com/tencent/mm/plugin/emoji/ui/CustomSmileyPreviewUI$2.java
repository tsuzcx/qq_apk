package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.Log;

final class CustomSmileyPreviewUI$2
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$2(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108790);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if ((CustomSmileyPreviewUI.n(this.uIo) != null) && (CustomSmileyPreviewUI.n(this.uIo).TdN != null))
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this.uIo.getContext(), EmojiStoreV2DesignerUI.class);
      ((Intent)localObject).putExtra("uin", CustomSmileyPreviewUI.n(this.uIo).TdN.TdG);
      ((Intent)localObject).putExtra("name", CustomSmileyPreviewUI.n(this.uIo).TdN.CMP);
      ((Intent)localObject).putExtra("headurl", CustomSmileyPreviewUI.n(this.uIo).TdN.SuR);
      ((Intent)localObject).putExtra("extra_scence", 9);
      paramView = this.uIo.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */