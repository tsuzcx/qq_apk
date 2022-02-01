package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

public final class a
{
  public int day;
  private Calendar iVy;
  public long iWh;
  public int month;
  public long msgId;
  public int year;
  
  public a()
  {
    AppMethodBeat.i(12447);
    ER(System.currentTimeMillis());
    AppMethodBeat.o(12447);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12448);
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
    AppMethodBeat.o(12448);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(12449);
    this.iWh = paramLong;
    ER(paramLong);
    AppMethodBeat.o(12449);
  }
  
  private void ER(long paramLong)
  {
    AppMethodBeat.i(12450);
    this.iWh = paramLong;
    if (this.iVy == null) {
      this.iVy = Calendar.getInstance();
    }
    this.iVy.setTimeInMillis(paramLong);
    this.month = this.iVy.get(2);
    this.year = this.iVy.get(1);
    this.day = this.iVy.get(5);
    AppMethodBeat.o(12450);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (paramObject.day == this.day)
      {
        bool1 = bool2;
        if (paramObject.month == this.month)
        {
          bool1 = bool2;
          if (paramObject.year == this.year) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12451);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{ year: ");
    ((StringBuilder)localObject).append(this.year);
    ((StringBuilder)localObject).append(", month: ");
    ((StringBuilder)localObject).append(this.month);
    ((StringBuilder)localObject).append(", day: ");
    ((StringBuilder)localObject).append(this.day);
    ((StringBuilder)localObject).append(" }");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(12451);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.a
 * JD-Core Version:    0.7.0.1
 */