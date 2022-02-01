package com.tencent.mm.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.c.a;
import com.tencent.mm.picker.d.d;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.picker.f.c;
import java.util.Calendar;

public final class b
{
  private a mBU;
  
  public b(Context paramContext, e parame)
  {
    AppMethodBeat.i(175330);
    this.mBU = new a(2);
    this.mBU.context = paramContext;
    this.mBU.mBX = parame;
    AppMethodBeat.o(175330);
  }
  
  public final b a(d paramd)
  {
    this.mBU.mBY = paramd;
    return this;
  }
  
  public final b a(Calendar paramCalendar)
  {
    this.mBU.mCd = paramCalendar;
    return this;
  }
  
  public final b a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.mBU.mCe = paramCalendar1;
    this.mBU.mCf = paramCalendar2;
    return this;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(175331);
    paramc.b(this.mBU);
    AppMethodBeat.o(175331);
  }
  
  public final b buN()
  {
    this.mBU.mCa = false;
    return this;
  }
  
  public final b c(boolean[] paramArrayOfBoolean)
  {
    this.mBU.mCc = paramArrayOfBoolean;
    return this;
  }
  
  public final b xQ(int paramInt)
  {
    this.mBU.mBx = paramInt;
    return this;
  }
  
  public final b xR(int paramInt)
  {
    this.mBU.bwU = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.b.b
 * JD-Core Version:    0.7.0.1
 */