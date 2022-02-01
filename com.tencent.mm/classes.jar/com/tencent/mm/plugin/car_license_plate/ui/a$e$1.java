package com.tencent.mm.plugin.car_license_plate.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$3$afterTextChanged$1"})
final class a$e$1
  implements Runnable
{
  a$e$1(a.e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(293072);
    TextView localTextView = a.b(this.GWy.sXP)[7];
    if (localTextView == null) {
      p.iCn();
    }
    localTextView.setText((CharSequence)"");
    AppMethodBeat.o(293072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.a.e.1
 * JD-Core Version:    0.7.0.1
 */