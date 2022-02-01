package com.tencent.mm.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
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
  private final TypedArray grn;
  private final a gro;
  public final a<com.tencent.mm.chatroom.d.a> grp;
  private final Collection<com.tencent.mm.chatroom.d.a> grq;
  private final Integer grr;
  private final Integer grs;
  private final boolean grt;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12437);
    this.grn = paramTypedArray;
    this.calendar = Calendar.getInstance();
    this.grs = Integer.valueOf(paramTypedArray.getInt(15, this.calendar.get(2) % 12));
    if (-1L != paramLong) {
      this.calendar.setTimeInMillis(paramLong);
    }
    this.grr = Integer.valueOf(paramTypedArray.getInt(13, this.calendar.get(2)));
    this.grt = paramTypedArray.getBoolean(16, false);
    this.grp = new a();
    this.grq = paramCollection;
    this.mContext = paramContext;
    this.gro = parama;
    if (this.grn.getBoolean(10, false)) {
      c(new com.tencent.mm.chatroom.d.a(System.currentTimeMillis()));
    }
    AppMethodBeat.o(12437);
  }
  
  private void c(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12440);
    this.gro.a(parama);
    d(parama);
    AppMethodBeat.o(12440);
  }
  
  private void d(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12441);
    if (this.grt)
    {
      int i;
      if ((this.grp.first != null) && (this.grp.gru == null))
      {
        this.grp.gru = parama;
        if (((com.tencent.mm.chatroom.d.a)this.grp.first).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.d.a)this.grp.first).month - parama.month - 1)
        {
          this.gro.a(parama);
          i += 1;
          continue;
          if (this.grp.gru == null) {
            break label144;
          }
          this.grp.first = parama;
          this.grp.gru = null;
        }
      }
    }
    for (;;)
    {
      this.atj.notifyChanged();
      AppMethodBeat.o(12441);
      return;
      label144:
      this.grp.first = parama;
      continue;
      this.grp.first = parama;
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
    int j = (new com.tencent.mm.chatroom.d.a(this.gro.alZ()).year - this.calendar.get(1) + 1) * 12;
    int i = j;
    if (this.grr.intValue() != -1) {
      i = j - this.grr.intValue();
    }
    j = i;
    if (this.grs.intValue() != -1) {
      j = i - (12 - this.grs.intValue() - 1);
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
    K gru;
  }
  
  public static final class b
    extends RecyclerView.v
  {
    final c grv;
    
    public b(View paramView, c.a parama)
    {
      super();
      AppMethodBeat.i(12436);
      this.grv = ((c)paramView);
      this.grv.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.grv.setClickable(true);
      this.grv.setOnDayClickListener(parama);
      AppMethodBeat.o(12436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */