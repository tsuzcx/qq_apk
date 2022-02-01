package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.c.a;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.picker.d.f;
import com.tencent.mm.picker.f.c;
import java.util.Calendar;

public final class b
{
  private a pyC;
  
  public b(Context paramContext, f paramf)
  {
    AppMethodBeat.i(175330);
    this.pyC = new a(2);
    this.pyC.context = paramContext;
    this.pyC.pyF = paramf;
    AppMethodBeat.o(175330);
  }
  
  public final b a(e parame)
  {
    this.pyC.pyG = parame;
    return this;
  }
  
  public final b a(Calendar paramCalendar)
  {
    this.pyC.pyL = paramCalendar;
    return this;
  }
  
  public final b a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.pyC.pyM = paramCalendar1;
    this.pyC.pyN = paramCalendar2;
    return this;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(175331);
    paramc.b(this.pyC);
    AppMethodBeat.o(175331);
  }
  
  public final b bSW()
  {
    this.pyC.pyI = false;
    return this;
  }
  
  public final b d(boolean[] paramArrayOfBoolean)
  {
    this.pyC.pyK = paramArrayOfBoolean;
    return this;
  }
  
  public final b xV(int paramInt)
  {
    this.pyC.pyf = paramInt;
    return this;
  }
  
  public final b xW(int paramInt)
  {
    this.pyC.dpX = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.picker.b.b
 * JD-Core Version:    0.7.0.1
 */