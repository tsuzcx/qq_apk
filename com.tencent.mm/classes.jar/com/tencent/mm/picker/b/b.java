package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.c.a;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.picker.f.c;
import java.util.Calendar;

public final class b
{
  public a iLi;
  
  public b(Context paramContext, e parame)
  {
    AppMethodBeat.i(175330);
    this.iLi = new a(2);
    this.iLi.context = paramContext;
    this.iLi.iLk = parame;
    AppMethodBeat.o(175330);
  }
  
  public final b a(Calendar paramCalendar)
  {
    this.iLi.iLq = paramCalendar;
    return this;
  }
  
  public final b a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.iLi.iLr = paramCalendar1;
    this.iLi.iLs = paramCalendar2;
    return this;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(175331);
    paramc.b(this.iLi);
    AppMethodBeat.o(175331);
  }
  
  public final b aPV()
  {
    this.iLi.iLn = false;
    return this;
  }
  
  public final b b(boolean[] paramArrayOfBoolean)
  {
    this.iLi.iLp = paramArrayOfBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.picker.b.b
 * JD-Core Version:    0.7.0.1
 */