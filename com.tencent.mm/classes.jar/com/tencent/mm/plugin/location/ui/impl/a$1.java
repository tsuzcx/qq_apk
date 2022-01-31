package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.RemarkUI;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113589);
    paramView = new Intent(this.ofz.activity, RemarkUI.class);
    paramView.putExtra("key_nullable", true);
    paramView.putExtra("key_value", this.ofz.bMc());
    paramView.putExtra("key_hint", this.ofz.getString(2131301102));
    paramView.putExtra("Kwebmap_locaion", this.ofz.ofm.nZY);
    paramView.putExtra("kFavInfoLocalId", this.ofz.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
    paramView.putExtra("kRemark", this.ofz.activity.getIntent().getStringExtra("kRemark"));
    this.ofz.activity.startActivityForResult(paramView, 4096);
    AppMethodBeat.o(113589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a.1
 * JD-Core Version:    0.7.0.1
 */