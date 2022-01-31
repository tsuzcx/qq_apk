package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LocationExtUI$1
  implements View.OnClickListener
{
  LocationExtUI$1(LocationExtUI paramLocationExtUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("key_fav_result_list", LocationExtUI.a(this.lEO));
    b.b(this.lEO.mController.uMN, ".ui.FavTagEditUI", paramView, 4098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI.1
 * JD-Core Version:    0.7.0.1
 */