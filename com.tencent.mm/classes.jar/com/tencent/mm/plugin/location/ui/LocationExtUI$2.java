package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LocationExtUI$2
  implements View.OnClickListener
{
  LocationExtUI$2(LocationExtUI paramLocationExtUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.lEO.mController.uMN, RemarkUI.class);
    paramView.putExtra("key_nullable", true);
    paramView.putExtra("key_value", this.lEO.getIntent().getStringExtra("key_value"));
    paramView.putExtra("key_hint", this.lEO.getString(a.h.location_remark_hint));
    paramView.putExtra("Kwebmap_locaion", this.lEO.getIntent().getStringExtra("Kwebmap_locaion"));
    paramView.putExtra("MMActivity.OverrideExitAnimation", a.a.push_down_out);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", a.a.fast_faded_in);
    paramView.putExtra("kFavInfoLocalId", this.lEO.getIntent().getLongExtra("kFavInfoLocalId", -1L));
    paramView.putExtra("kRemark", this.lEO.getIntent().getStringExtra("kRemark"));
    this.lEO.startActivityForResult(paramView, 4097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI.2
 * JD-Core Version:    0.7.0.1
 */