package com.tencent.mm.plugin.car_license_plate.b;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/utils/CarLicensePlateUtilsKt$addInputFilterForLimitedCharRange$1", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-car-license-plate_release"})
public final class a$a
  implements InputFilter
{
  public a$a(CharSequence paramCharSequence) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt2 = 0;
    AppMethodBeat.i(186453);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      AppMethodBeat.o(186453);
      return null;
    }
    char c;
    do
    {
      paramInt2 += 1;
      if (paramInt2 >= paramCharSequence.length()) {
        break;
      }
      c = paramCharSequence.charAt(paramInt2);
    } while (n.c(this.sZm, c));
    paramCharSequence = (CharSequence)"";
    AppMethodBeat.o(186453);
    return paramCharSequence;
    AppMethodBeat.o(186453);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.b.a.a
 * JD-Core Version:    0.7.0.1
 */