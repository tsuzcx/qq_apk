package com.tencent.mm.picker.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.i;
import com.tencent.mm.picker.base.a.a;
import junit.framework.Assert;

public final class b
  implements a
{
  private Context ctx;
  private final String[] mAV;
  private final int[] mAW;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(175287);
    this.mAV = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
    this.mAW = new int[] { a.i.picker_time_jan, a.i.picker_time_feb, a.i.picker_time_mar, a.i.picker_time_apr, a.i.picker_time_may, a.i.picker_time_jun, a.i.picker_time_jul, a.i.picker_time_aug, a.i.picker_time_sept, a.i.picker_time_oct, a.i.picker_time_nov, a.i.picker_time_dec };
    this.ctx = paramContext;
    AppMethodBeat.o(175287);
  }
  
  public final String ZH(String paramString)
  {
    AppMethodBeat.i(175288);
    Assert.assertEquals(12, this.mAV.length);
    Assert.assertEquals(12, this.mAW.length);
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < this.mAV.length)
      {
        if (paramString.equals(this.mAV[i])) {
          str = this.ctx.getResources().getString(this.mAW[i]);
        }
      }
      else
      {
        AppMethodBeat.o(175288);
        return str;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.a.b
 * JD-Core Version:    0.7.0.1
 */