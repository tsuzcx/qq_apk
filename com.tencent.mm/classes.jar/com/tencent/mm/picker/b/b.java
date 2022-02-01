package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.c.a;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.picker.f.c;
import java.util.Calendar;

public final class b
{
  public a jKP;
  
  public b(Context paramContext, e parame)
  {
    AppMethodBeat.i(175330);
    this.jKP = new a(2);
    this.jKP.context = paramContext;
    this.jKP.jKS = parame;
    AppMethodBeat.o(175330);
  }
  
  public final b a(Calendar paramCalendar)
  {
    this.jKP.jKY = paramCalendar;
    return this;
  }
  
  public final b a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.jKP.jKZ = paramCalendar1;
    this.jKP.jLa = paramCalendar2;
    return this;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(175331);
    paramc.b(this.jKP);
    AppMethodBeat.o(175331);
  }
  
  public final b b(boolean[] paramArrayOfBoolean)
  {
    this.jKP.jKX = paramArrayOfBoolean;
    return this;
  }
  
  public final b bkZ()
  {
    this.jKP.jKV = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.b.b
 * JD-Core Version:    0.7.0.1
 */