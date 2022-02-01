package com.tencent.mm.plugin.car_license_plate.ui;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$4", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-car-license-plate_release"})
public final class a$g
  implements InputFilter
{
  a$g(a parama, d.b paramb, String paramString, int paramInt) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(293080);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      AppMethodBeat.o(293080);
      return paramCharSequence;
    }
    paramSpanned = a.b(this.sXP)[6];
    if (paramSpanned == null) {
      p.iCn();
    }
    paramSpanned = paramSpanned.getText();
    if (paramSpanned != null)
    {
      paramSpanned = n.bl(paramSpanned);
      if ((paramSpanned != null) && (com.tencent.mm.plugin.car_license_plate.b.a.isChinese(paramSpanned.charValue()) == true))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(293080);
        return paramCharSequence;
      }
    }
    AppMethodBeat.o(293080);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.a.g
 * JD-Core Version:    0.7.0.1
 */