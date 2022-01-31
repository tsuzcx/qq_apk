package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import com.tencent.mm.plugin.location.ui.g;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.y;

final class c$14
  implements AdapterView.OnItemClickListener
{
  c$14(c paramc) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramInt) });
    double d1;
    double d2;
    if (!c.q(this.lJp))
    {
      if (paramInt >= c.o(this.lJp).getCount())
      {
        y.i("MicroMsg.MMPoiMapUI", "wrong position");
        return;
      }
      paramAdapterView = c.o(this.lJp).tc(paramInt);
      if (paramAdapterView.type != 0) {
        break label200;
      }
      paramView = c.r(this.lJp);
      d1 = paramAdapterView.aWE;
      d2 = paramAdapterView.aWF;
      if (paramView.lFf) {
        break label183;
      }
      paramView.lFf = true;
      paramView.lFy.addPinView(paramView, d1, d2);
      c.l(this.lJp).setBackgroundResource(a.d.location_my);
    }
    for (;;)
    {
      this.lJp.lFy.getIController().animateTo(paramAdapterView.aWE, paramAdapterView.aWF);
      c.o(this.lJp).lJz = paramInt;
      c.o(this.lJp).notifyDataSetChanged();
      c.n(this.lJp);
      return;
      label183:
      paramView.lFy.updateLocaitonPinLayout(paramView, d1, d2);
      break;
      label200:
      c.r(this.lJp).remove();
      c.l(this.lJp).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.14
 * JD-Core Version:    0.7.0.1
 */