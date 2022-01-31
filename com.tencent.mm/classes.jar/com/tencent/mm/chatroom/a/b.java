package com.tencent.mm.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.c.a;
import java.util.Calendar;
import java.util.Collection;

public final class b
  extends RecyclerView.a<b.b>
  implements c.a
{
  private final Calendar calendar;
  private final TypedArray edZ;
  private final a eea;
  public final b.a<com.tencent.mm.chatroom.c.a> eeb;
  private final Collection<com.tencent.mm.chatroom.c.a> eec;
  private final Integer eed;
  private final Integer eee;
  private final boolean eef;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.c.a> paramCollection)
  {
    AppMethodBeat.i(103892);
    this.edZ = paramTypedArray;
    this.calendar = Calendar.getInstance();
    this.eee = Integer.valueOf(paramTypedArray.getInt(20, this.calendar.get(2) % 12));
    if (-1L != paramLong) {
      this.calendar.setTimeInMillis(paramLong);
    }
    this.eed = Integer.valueOf(paramTypedArray.getInt(19, this.calendar.get(2)));
    this.eef = paramTypedArray.getBoolean(18, false);
    this.eeb = new b.a();
    this.eec = paramCollection;
    this.mContext = paramContext;
    this.eea = parama;
    if (this.edZ.getBoolean(16, false)) {
      c(new com.tencent.mm.chatroom.c.a(System.currentTimeMillis()));
    }
    AppMethodBeat.o(103892);
  }
  
  private void c(com.tencent.mm.chatroom.c.a parama)
  {
    AppMethodBeat.i(103895);
    this.eea.a(parama);
    d(parama);
    AppMethodBeat.o(103895);
  }
  
  private void d(com.tencent.mm.chatroom.c.a parama)
  {
    AppMethodBeat.i(103896);
    if (this.eef)
    {
      int i;
      if ((this.eeb.first != null) && (this.eeb.eeg == null))
      {
        this.eeb.eeg = parama;
        if (((com.tencent.mm.chatroom.c.a)this.eeb.first).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.c.a)this.eeb.first).month - parama.month - 1)
        {
          this.eea.a(parama);
          i += 1;
          continue;
          if (this.eeb.eeg == null) {
            break label142;
          }
          this.eeb.first = parama;
          this.eeb.eeg = null;
        }
      }
    }
    for (;;)
    {
      this.ajb.notifyChanged();
      AppMethodBeat.o(103896);
      return;
      label142:
      this.eeb.first = parama;
      continue;
      this.eeb.first = parama;
    }
  }
  
  public final void b(com.tencent.mm.chatroom.c.a parama)
  {
    AppMethodBeat.i(103894);
    if (parama != null) {
      c(parama);
    }
    AppMethodBeat.o(103894);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(103893);
    int j = (new com.tencent.mm.chatroom.c.a(this.eea.Jy()).year - this.calendar.get(1) + 1) * 12;
    int i = j;
    if (this.eed.intValue() != -1) {
      i = j - this.eed.intValue();
    }
    j = i;
    if (this.eee.intValue() != -1) {
      j = i - (12 - this.eee.intValue() - 1);
    }
    AppMethodBeat.o(103893);
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