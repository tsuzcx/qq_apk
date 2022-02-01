package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24073);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = a.b(this.qrx);
    localObject = new Intent(paramView, ExdeviceProfileUI.class);
    ((Intent)localObject).putExtra("username", this.fOp);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAdapter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAdapter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(24073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a.2
 * JD-Core Version:    0.7.0.1
 */