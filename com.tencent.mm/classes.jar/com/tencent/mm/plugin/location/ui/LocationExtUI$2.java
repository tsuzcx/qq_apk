package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LocationExtUI$2
  implements View.OnClickListener
{
  LocationExtUI$2(LocationExtUI paramLocationExtUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113432);
    paramView = new Intent(this.occ.getContext(), RemarkUI.class);
    paramView.putExtra("key_nullable", true);
    paramView.putExtra("key_value", this.occ.getIntent().getStringExtra("key_value"));
    paramView.putExtra("key_hint", this.occ.getString(2131301102));
    paramView.putExtra("Kwebmap_locaion", this.occ.getIntent().getStringExtra("Kwebmap_locaion"));
    paramView.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
    paramView.putExtra("kFavInfoLocalId", this.occ.getIntent().getLongExtra("kFavInfoLocalId", -1L));
    paramView.putExtra("kRemark", this.occ.getIntent().getStringExtra("kRemark"));
    this.occ.startActivityForResult(paramView, 4097);
    AppMethodBeat.o(113432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI.2
 * JD-Core Version:    0.7.0.1
 */