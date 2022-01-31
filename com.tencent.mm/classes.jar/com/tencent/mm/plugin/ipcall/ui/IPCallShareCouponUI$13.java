package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class IPCallShareCouponUI$13
  implements View.OnClickListener
{
  IPCallShareCouponUI$13(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22331);
    aw.aaz();
    if (((Boolean)c.Ru().get(ac.a.yAu, Boolean.FALSE)).booleanValue())
    {
      aw.aaz();
      i.Y(4, -1, ((Integer)c.Ru().get(ac.a.yAv, Integer.valueOf(-1))).intValue());
    }
    aw.aaz();
    c.Ru().set(ac.a.yAv, Integer.valueOf(-1));
    aw.aaz();
    c.Ru().set(ac.a.yAu, Boolean.FALSE);
    IPCallShareCouponUI.g(this.nWj).setVisibility(8);
    paramView = new Intent();
    paramView.setClass(this.nWj.getContext(), IPCallMsgUI.class);
    this.nWj.getContext().startActivity(paramView);
    AppMethodBeat.o(22331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.13
 * JD-Core Version:    0.7.0.1
 */