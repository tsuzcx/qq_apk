package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.mm.plugin.map.a.h;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.lIm.activity, RemarkUI.class);
    paramView.putExtra("key_nullable", true);
    paramView.putExtra("key_value", this.lIm.beI());
    paramView.putExtra("key_hint", this.lIm.getString(a.h.location_remark_hint));
    paramView.putExtra("Kwebmap_locaion", this.lIm.lHZ.lCM);
    paramView.putExtra("kFavInfoLocalId", this.lIm.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L));
    paramView.putExtra("kRemark", this.lIm.activity.getIntent().getStringExtra("kRemark"));
    this.lIm.activity.startActivityForResult(paramView, 4096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a.1
 * JD-Core Version:    0.7.0.1
 */