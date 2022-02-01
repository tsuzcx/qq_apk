package com.tencent.mm.plugin.car_license_plate.b;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/utils/CarLicensePlateUtilsKt$addInputFilterForLimitedCharRange$1", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  implements InputFilter
{
  public a$a(CharSequence paramCharSequence) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt2 = 0;
    AppMethodBeat.i(277548);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      AppMethodBeat.o(277548);
      return null;
    }
    paramSpanned = this.wdx;
    paramInt1 = paramInt2;
    while (paramInt1 < paramCharSequence.length())
    {
      if (!n.c(paramSpanned, paramCharSequence.charAt(paramInt1)))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(277548);
        return paramCharSequence;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(277548);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.b.a.a
 * JD-Core Version:    0.7.0.1
 */