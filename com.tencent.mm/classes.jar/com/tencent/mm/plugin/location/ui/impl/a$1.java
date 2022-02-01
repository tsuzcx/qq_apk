package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.mm.plugin.map.a.i;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55995);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent(this.KhF.activity, RemarkUI.class);
    paramView.putExtra("key_nullable", true);
    paramView.putExtra("key_value", this.KhF.fVs());
    paramView.putExtra("key_hint", this.KhF.getString(a.i.location_remark_hint));
    paramView.putExtra("Kwebmap_locaion", this.KhF.sai.KbZ);
    paramView.putExtra("kFavInfoLocalId", this.KhF.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
    paramView.putExtra("kRemark", this.KhF.activity.getIntent().getStringExtra("kRemark"));
    com.tencent.mm.hellhoundlib.a.a.a(this.KhF.activity, c.a(4096, new com.tencent.mm.hellhoundlib.b.a()).cG(paramView).aYi(), "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "onClick", "(Landroid/view/View;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(55995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a.1
 * JD-Core Version:    0.7.0.1
 */