package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.RemarkUI;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55995);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent(this.yLf.activity, RemarkUI.class);
    paramView.putExtra("key_nullable", true);
    paramView.putExtra("key_value", this.yLf.edE());
    paramView.putExtra("key_hint", this.yLf.getString(2131762467));
    paramView.putExtra("Kwebmap_locaion", this.yLf.lXk.yFx);
    paramView.putExtra("kFavInfoLocalId", this.yLf.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
    paramView.putExtra("kRemark", this.yLf.activity.getIntent().getStringExtra("kRemark"));
    this.yLf.activity.startActivityForResult(paramView, 4096);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(55995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a.1
 * JD-Core Version:    0.7.0.1
 */