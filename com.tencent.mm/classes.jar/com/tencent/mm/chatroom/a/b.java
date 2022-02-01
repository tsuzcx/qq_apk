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
  private final TypedArray frN;
  private final a frO;
  public final a<com.tencent.mm.chatroom.d.a> frP;
  private final Collection<com.tencent.mm.chatroom.d.a> frQ;
  private final Integer frR;
  private final Integer frS;
  private final boolean frT;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12437);
    this.frN = paramTypedArray;
    this.calendar = Calendar.getInstance();
    this.frS = Integer.valueOf(paramTypedArray.getInt(15, this.calendar.get(2) % 12));
    if (-1L != paramLong) {
      this.calendar.setTimeInMillis(paramLong);
    }
    this.frR = Integer.valueOf(paramTypedArray.getInt(13, this.calendar.get(2)));
    this.frT = paramTypedArray.getBoolean(16, false);
    this.frP = new a();
    this.frQ = paramCollection;
    this.mContext = paramContext;
    this.frO = parama;
    if (this.frN.getBoolean(10, false)) {
      c(new com.tencent.mm.chatroom.d.a(System.currentTimeMillis()));
    }
    AppMethodBeat.o(12437);
  }
  
  private void c(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12440);
    this.frO.a(parama);
    d(parama);
    AppMethodBeat.o(12440);
  }
  
  private void d(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12441);
    if (this.frT)
    {
      int i;
      if ((this.frP.first != null) && (this.frP.frU == null))
      {
        this.frP.frU = parama;
        if (((com.tencent.mm.chatroom.d.a)this.frP.first).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.d.a)this.frP.first).month - parama.month - 1)
        {
          this.frO.a(parama);
          i += 1;
          continue;
          if (this.frP.frU == null) {
            break label144;
          }
          this.frP.first = parama;
          this.frP.frU = null;
        }
      }
    }
    for (;;)
    {
      this.arg.notifyChanged();
      AppMethodBeat.o(12441);
      return;
      label144:
      this.frP.first = parama;
      continue;
      this.frP.first = parama;
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
    int j = (new com.tencent.mm.chatroom.d.a(this.frO.VL()).year - this.calendar.get(1) + 1) * 12;
    int i = j;
    if (this.frR.intValue() != -1) {
      i = j - this.frR.intValue();
    }
    j = i;
    if (this.frS.intValue() != -1) {
      j = i - (12 - this.frS.intValue() - 1);
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
    K first;
    K frU;
  }
  
  public static final class b
    extends RecyclerView.w
  {
    final c frV;
    
    public b(View paramView, c.a parama)
    {
      super();
      AppMethodBeat.i(12436);
      this.frV = ((c)paramView);
      this.frV.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.frV.setClickable(true);
      this.frV.setOnDayClickListener(parama);
      AppMethodBeat.o(12436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */