package com.tencent.mm.picker.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.a.a;
import junit.framework.Assert;

public final class b
  implements a
{
  private Context ctx;
  private final String[] iKo;
  private final int[] iKp;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(175287);
    this.iKo = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
    this.iKp = new int[] { 2131761916, 2131761915, 2131761919, 2131761912, 2131761920, 2131761918, 2131761917, 2131761913, 2131761923, 2131761922, 2131761921, 2131761914 };
    this.ctx = paramContext;
    AppMethodBeat.o(175287);
  }
  
  public final String IJ(String paramString)
  {
    AppMethodBeat.i(175288);
    Assert.assertEquals(12, this.iKo.length);
    Assert.assertEquals(12, this.iKp.length);
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < this.iKo.length)
      {
        if (paramString.equals(this.iKo[i])) {
          str = this.ctx.getResources().getString(this.iKp[i]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.picker.a.b
 * JD-Core Version:    0.7.0.1
 */