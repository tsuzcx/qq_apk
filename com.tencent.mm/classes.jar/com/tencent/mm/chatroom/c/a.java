package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

public final class a
{
  private Calendar calendar;
  public long cpO;
  public int eel;
  public long eem;
  public int month;
  public int year;
  
  public a()
  {
    AppMethodBeat.i(103902);
    setTime(System.currentTimeMillis());
    AppMethodBeat.o(103902);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(103903);
    this.year = paramInt1;
    this.month = paramInt2;
    this.eel = paramInt3;
    AppMethodBeat.o(103903);
  }
  
  public a(long paramLong)
  {
    AppMethodBeat.i(103904);
    this.eem = paramLong;
    setTime(paramLong);
    AppMethodBeat.o(103904);
  }
  
  private void setTime(long paramLong)
  {
    AppMethodBeat.i(103905);
    this.eem = paramLong;
    if (this.calendar == null) {
      this.calendar = Calendar.getInstance();
    }
    this.calendar.setTimeInMillis(paramLong);
    this.month = this.calendar.get(2);
    this.year = this.calendar.get(1);
    this.eel = this.calendar.get(5);
    AppMethodBeat.o(103905);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (paramObject.eel == this.eel)
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
    AppMethodBeat.i(103906);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{ year: ");
    ((StringBuilder)localObject).append(this.year);
    ((StringBuilder)localObject).append(", month: ");
    ((StringBuilder)localObject).append(this.month);
    ((StringBuilder)localObject).append(", day: ");
    ((StringBuilder)localObject).append(this.eel);
    ((StringBuilder)localObject).append(" }");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(103906);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.a
 * JD-Core Version:    0.7.0.1
 */