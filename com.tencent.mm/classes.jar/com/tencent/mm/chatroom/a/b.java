package com.tencent.mm.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.chatroom.ui.a.j;
import com.tencent.mm.chatroom.ui.c.a;
import java.util.Calendar;
import java.util.Collection;

public final class b
  extends RecyclerView.a<b.b>
  implements c.a
{
  private final Calendar calendar;
  private final Integer dmA;
  private final Integer dmB;
  private final boolean dmC;
  private final TypedArray dmw;
  private final a dmx;
  public final b.a<com.tencent.mm.chatroom.c.a> dmy;
  private final Collection<com.tencent.mm.chatroom.c.a> dmz;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.c.a> paramCollection)
  {
    this.dmw = paramTypedArray;
    this.calendar = Calendar.getInstance();
    this.dmB = Integer.valueOf(paramTypedArray.getInt(a.j.DayPickerView_lastMonth, this.calendar.get(2) % 12));
    if (-1L != paramLong) {
      this.calendar.setTimeInMillis(paramLong);
    }
    this.dmA = Integer.valueOf(paramTypedArray.getInt(a.j.DayPickerView_firstMonth, this.calendar.get(2)));
    this.dmC = paramTypedArray.getBoolean(a.j.DayPickerView_selectRangeEnable, false);
    this.dmy = new b.a();
    this.dmz = paramCollection;
    this.mContext = paramContext;
    this.dmx = parama;
    if (this.dmw.getBoolean(a.j.DayPickerView_currentDaySelected, false)) {
      c(new com.tencent.mm.chatroom.c.a(System.currentTimeMillis()));
    }
  }
  
  private void c(com.tencent.mm.chatroom.c.a parama)
  {
    this.dmx.a(parama);
    if (this.dmC)
    {
      int i;
      if ((this.dmy.first != null) && (this.dmy.dmD == null))
      {
        this.dmy.dmD = parama;
        if (((com.tencent.mm.chatroom.c.a)this.dmy.first).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.c.a)this.dmy.first).month - parama.month - 1)
        {
          this.dmx.a(parama);
          i += 1;
          continue;
          if (this.dmy.dmD == null) {
            break label142;
          }
          this.dmy.first = parama;
          this.dmy.dmD = null;
        }
      }
    }
    for (;;)
    {
      this.agL.notifyChanged();
      return;
      label142:
      this.dmy.first = parama;
      continue;
      this.dmy.first = parama;
    }
  }
  
  public final void b(com.tencent.mm.chatroom.c.a parama)
  {
    if (parama != null) {
      c(parama);
    }
  }
  
  public final int getItemCount()
  {
    int j = (new com.tencent.mm.chatroom.c.a(this.dmx.xg()).year - this.calendar.get(1) + 1) * 12;
    int i = j;
    if (this.dmA.intValue() != -1) {
      i = j - this.dmA.intValue();
    }
    j = i;
    if (this.dmB.intValue() != -1) {
      j = i - (12 - this.dmB.intValue() - 1);
    }
    return j;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */