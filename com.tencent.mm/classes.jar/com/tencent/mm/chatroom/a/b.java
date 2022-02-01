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
  private final TypedArray fLZ;
  private final a fMa;
  public final a<com.tencent.mm.chatroom.d.a> fMb;
  private final Collection<com.tencent.mm.chatroom.d.a> fMc;
  private final Integer fMd;
  private final Integer fMe;
  private final boolean fMf;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12437);
    this.fLZ = paramTypedArray;
    this.calendar = Calendar.getInstance();
    this.fMe = Integer.valueOf(paramTypedArray.getInt(15, this.calendar.get(2) % 12));
    if (-1L != paramLong) {
      this.calendar.setTimeInMillis(paramLong);
    }
    this.fMd = Integer.valueOf(paramTypedArray.getInt(13, this.calendar.get(2)));
    this.fMf = paramTypedArray.getBoolean(16, false);
    this.fMb = new a();
    this.fMc = paramCollection;
    this.mContext = paramContext;
    this.fMa = parama;
    if (this.fLZ.getBoolean(10, false)) {
      c(new com.tencent.mm.chatroom.d.a(System.currentTimeMillis()));
    }
    AppMethodBeat.o(12437);
  }
  
  private void c(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12440);
    this.fMa.a(parama);
    d(parama);
    AppMethodBeat.o(12440);
  }
  
  private void d(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12441);
    if (this.fMf)
    {
      int i;
      if ((this.fMb.first != null) && (this.fMb.fMg == null))
      {
        this.fMb.fMg = parama;
        if (((com.tencent.mm.chatroom.d.a)this.fMb.first).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.d.a)this.fMb.first).month - parama.month - 1)
        {
          this.fMa.a(parama);
          i += 1;
          continue;
          if (this.fMb.fMg == null) {
            break label144;
          }
          this.fMb.first = parama;
          this.fMb.fMg = null;
        }
      }
    }
    for (;;)
    {
      this.asY.notifyChanged();
      AppMethodBeat.o(12441);
      return;
      label144:
      this.fMb.first = parama;
      continue;
      this.fMb.first = parama;
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
    int j = (new com.tencent.mm.chatroom.d.a(this.fMa.Ym()).year - this.calendar.get(1) + 1) * 12;
    int i = j;
    if (this.fMd.intValue() != -1) {
      i = j - this.fMd.intValue();
    }
    j = i;
    if (this.fMe.intValue() != -1) {
      j = i - (12 - this.fMe.intValue() - 1);
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
    K fMg;
    K first;
  }
  
  public static final class b
    extends RecyclerView.w
  {
    final c fMh;
    
    public b(View paramView, c.a parama)
    {
      super();
      AppMethodBeat.i(12436);
      this.fMh = ((c)paramView);
      this.fMh.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.fMh.setClickable(true);
      this.fMh.setOnDayClickListener(parama);
      AppMethodBeat.o(12436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */