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
  private final TypedArray fos;
  private final a fot;
  public final a<com.tencent.mm.chatroom.d.a> fou;
  private final Collection<com.tencent.mm.chatroom.d.a> fov;
  private final Integer fow;
  private final Integer fox;
  private final boolean foy;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12437);
    this.fos = paramTypedArray;
    this.calendar = Calendar.getInstance();
    this.fox = Integer.valueOf(paramTypedArray.getInt(15, this.calendar.get(2) % 12));
    if (-1L != paramLong) {
      this.calendar.setTimeInMillis(paramLong);
    }
    this.fow = Integer.valueOf(paramTypedArray.getInt(13, this.calendar.get(2)));
    this.foy = paramTypedArray.getBoolean(16, false);
    this.fou = new a();
    this.fov = paramCollection;
    this.mContext = paramContext;
    this.fot = parama;
    if (this.fos.getBoolean(10, false)) {
      c(new com.tencent.mm.chatroom.d.a(System.currentTimeMillis()));
    }
    AppMethodBeat.o(12437);
  }
  
  private void c(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12440);
    this.fot.a(parama);
    d(parama);
    AppMethodBeat.o(12440);
  }
  
  private void d(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12441);
    if (this.foy)
    {
      int i;
      if ((this.fou.first != null) && (this.fou.foz == null))
      {
        this.fou.foz = parama;
        if (((com.tencent.mm.chatroom.d.a)this.fou.first).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.d.a)this.fou.first).month - parama.month - 1)
        {
          this.fot.a(parama);
          i += 1;
          continue;
          if (this.fou.foz == null) {
            break label144;
          }
          this.fou.first = parama;
          this.fou.foz = null;
        }
      }
    }
    for (;;)
    {
      this.aql.notifyChanged();
      AppMethodBeat.o(12441);
      return;
      label144:
      this.fou.first = parama;
      continue;
      this.fou.first = parama;
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
    int j = (new com.tencent.mm.chatroom.d.a(this.fot.UP()).year - this.calendar.get(1) + 1) * 12;
    int i = j;
    if (this.fow.intValue() != -1) {
      i = j - this.fow.intValue();
    }
    j = i;
    if (this.fox.intValue() != -1) {
      j = i - (12 - this.fox.intValue() - 1);
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
    K foz;
  }
  
  public static final class b
    extends RecyclerView.v
  {
    final c foA;
    
    public b(View paramView, c.a parama)
    {
      super();
      AppMethodBeat.i(12436);
      this.foA = ((c)paramView);
      this.foA.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.foA.setClickable(true);
      this.foA.setOnDayClickListener(parama);
      AppMethodBeat.o(12436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */