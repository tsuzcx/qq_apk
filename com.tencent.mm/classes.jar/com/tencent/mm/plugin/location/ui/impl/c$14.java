package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.ui.g;
import com.tencent.mm.sdk.platformtools.ab;

final class c$14
  implements AdapterView.OnItemClickListener
{
  c$14(c paramc) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(113609);
    ab.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramInt) });
    double d1;
    double d2;
    if (!c.q(this.ogD))
    {
      if (paramInt >= c.o(this.ogD).getCount())
      {
        ab.i("MicroMsg.MMPoiMapUI", "wrong position");
        AppMethodBeat.o(113609);
        return;
      }
      paramAdapterView = c.o(this.ogD).ye(paramInt);
      if (paramAdapterView.type != 0) {
        break label214;
      }
      paramView = c.r(this.ogD);
      d1 = paramAdapterView.bnl;
      d2 = paramAdapterView.bnm;
      if (paramView.oct) {
        break label197;
      }
      paramView.oct = true;
      paramView.ocL.addPinView(paramView, d1, d2);
      c.l(this.ogD).setBackgroundResource(2130839295);
    }
    for (;;)
    {
      this.ogD.ocL.getIController().animateTo(paramAdapterView.bnl, paramAdapterView.bnm);
      c.o(this.ogD).lxQ = paramInt;
      c.o(this.ogD).notifyDataSetChanged();
      c.n(this.ogD);
      AppMethodBeat.o(113609);
      return;
      label197:
      paramView.ocL.updateLocaitonPinLayout(paramView, d1, d2);
      break;
      label214:
      c.r(this.ogD).remove();
      c.l(this.ogD).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.14
 * JD-Core Version:    0.7.0.1
 */