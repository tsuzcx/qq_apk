package com.tencent.mm.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.c;
import com.tencent.mm.chatroom.ui.c.a;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

public final class b
  extends RecyclerView.a<b>
  implements c.a
{
  private final Calendar calendar;
  private final TypedArray fJW;
  private final a fJX;
  public final a<com.tencent.mm.chatroom.d.a> fJY;
  private final Collection<com.tencent.mm.chatroom.d.a> fJZ;
  private final Integer fKa;
  private final Integer fKb;
  private final boolean fKc;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12437);
    this.fJW = paramTypedArray;
    this.calendar = Calendar.getInstance();
    this.fKb = Integer.valueOf(paramTypedArray.getInt(15, this.calendar.get(2) % 12));
    if (-1L != paramLong) {
      this.calendar.setTimeInMillis(paramLong);
    }
    this.fKa = Integer.valueOf(paramTypedArray.getInt(13, this.calendar.get(2)));
    this.fKc = paramTypedArray.getBoolean(16, false);
    this.fJY = new a();
    this.fJZ = paramCollection;
    this.mContext = paramContext;
    this.fJX = parama;
    if (this.fJW.getBoolean(10, false)) {
      c(new com.tencent.mm.chatroom.d.a(System.currentTimeMillis()));
    }
    AppMethodBeat.o(12437);
  }
  
  private void c(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12440);
    this.fJX.a(parama);
    d(parama);
    AppMethodBeat.o(12440);
  }
  
  private void d(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12441);
    if (this.fKc)
    {
      int i;
      if ((this.fJY.first != null) && (this.fJY.fKd == null))
      {
        this.fJY.fKd = parama;
        if (((com.tencent.mm.chatroom.d.a)this.fJY.first).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.d.a)this.fJY.first).month - parama.month - 1)
        {
          this.fJX.a(parama);
          i += 1;
          continue;
          if (this.fJY.fKd == null) {
            break label144;
          }
          this.fJY.first = parama;
          this.fJY.fKd = null;
        }
      }
    }
    for (;;)
    {
      this.asY.notifyChanged();
      AppMethodBeat.o(12441);
      return;
      label144:
      this.fJY.first = parama;
      continue;
      this.fJY.first = parama;
    }
  }
  
  public final void b(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12439);
    if (parama != null) {
      c(parama);
    }
    AppMethodBeat.o(12439);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(12438);
    int j = (new com.tencent.mm.chatroom.d.a(this.fJX.Yc()).year - this.calendar.get(1) + 1) * 12;
    int i = j;
    if (this.fKa.intValue() != -1) {
      i = j - this.fKa.intValue();
    }
    j = i;
    if (this.fKb.intValue() != -1) {
      j = i - (12 - this.fKb.intValue() - 1);
    }
    AppMethodBeat.o(12438);
    return j;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static final class a<K>
    implements Serializable
  {
    K fKd;
    K first;
  }
  
  public static final class b
    extends RecyclerView.w
  {
    final c fKe;
    
    public b(View paramView, c.a parama)
    {
      super();
      AppMethodBeat.i(12436);
      this.fKe = ((c)paramView);
      this.fKe.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.fKe.setClickable(true);
      this.fKe.setOnDayClickListener(parama);
      AppMethodBeat.o(12436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */