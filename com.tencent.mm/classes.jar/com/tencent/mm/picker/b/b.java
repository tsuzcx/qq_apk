package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.c.a;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.picker.f.c;
import java.util.Calendar;

public final class b
{
  public a hSa;
  
  public b(Context paramContext, e parame)
  {
    AppMethodBeat.i(175330);
    this.hSa = new a(2);
    this.hSa.context = paramContext;
    this.hSa.hSc = parame;
    AppMethodBeat.o(175330);
  }
  
  public final b a(Calendar paramCalendar)
  {
    this.hSa.hSi = paramCalendar;
    return this;
  }
  
  public final b a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.hSa.hSj = paramCalendar1;
    this.hSa.hSk = paramCalendar2;
    return this;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(175331);
    paramc.b(this.hSa);
    AppMethodBeat.o(175331);
  }
  
  public final b aFX()
  {
    this.hSa.hSf = false;
    return this;
  }
  
  public final b b(boolean[] paramArrayOfBoolean)
  {
    this.hSa.hSh = paramArrayOfBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.b.b
 * JD-Core Version:    0.7.0.1
 */