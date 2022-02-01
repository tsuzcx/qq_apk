package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class IPCallShareCouponUI$13
  implements View.OnClickListener
{
  IPCallShareCouponUI$13(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25950);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    bh.beI();
    if (((Boolean)c.aHp().get(ar.a.Vjw, Boolean.FALSE)).booleanValue())
    {
      bh.beI();
      i.ar(4, -1, ((Integer)c.aHp().get(ar.a.Vjx, Integer.valueOf(-1))).intValue());
    }
    bh.beI();
    c.aHp().set(ar.a.Vjx, Integer.valueOf(-1));
    bh.beI();
    c.aHp().set(ar.a.Vjw, Boolean.FALSE);
    IPCallShareCouponUI.g(this.DYL).setVisibility(8);
    localObject = new Intent();
    ((Intent)localObject).setClass(this.DYL.getContext(), IPCallMsgUI.class);
    paramView = this.DYL.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.13
 * JD-Core Version:    0.7.0.1
 */