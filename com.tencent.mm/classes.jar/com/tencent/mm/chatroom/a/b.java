package com.tencent.mm.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.a.j;
import com.tencent.mm.chatroom.ui.c;
import com.tencent.mm.chatroom.ui.c.a;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

public final class b
  extends RecyclerView.a<b>
  implements c.a
{
  private final Collection<com.tencent.mm.chatroom.d.a> iVA;
  private final Integer iVB;
  private final Integer iVC;
  private final boolean iVD;
  private final TypedArray iVw;
  private final a iVx;
  private final Calendar iVy;
  public final a<com.tencent.mm.chatroom.d.a> iVz;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12437);
    this.iVw = paramTypedArray;
    this.iVy = Calendar.getInstance();
    this.iVC = Integer.valueOf(paramTypedArray.getInt(a.j.jhz, this.iVy.get(2) % 12));
    if (-1L != paramLong) {
      this.iVy.setTimeInMillis(paramLong);
    }
    this.iVB = Integer.valueOf(paramTypedArray.getInt(a.j.jhx, this.iVy.get(2)));
    this.iVD = paramTypedArray.getBoolean(a.j.jhA, false);
    this.iVz = new a();
    this.iVA = paramCollection;
    this.mContext = paramContext;
    this.iVx = parama;
    if (this.iVw.getBoolean(a.j.jhu, false)) {
      c(new com.tencent.mm.chatroom.d.a(System.currentTimeMillis()));
    }
    AppMethodBeat.o(12437);
  }
  
  private void c(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12440);
    this.iVx.a(parama);
    d(parama);
    AppMethodBeat.o(12440);
  }
  
  private void d(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12441);
    if (this.iVD)
    {
      int i;
      if ((this.iVz.Mx != null) && (this.iVz.iVE == null))
      {
        this.iVz.iVE = parama;
        if (((com.tencent.mm.chatroom.d.a)this.iVz.Mx).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.d.a)this.iVz.Mx).month - parama.month - 1)
        {
          this.iVx.a(parama);
          i += 1;
          continue;
          if (this.iVz.iVE == null) {
            break label144;
          }
          this.iVz.Mx = parama;
          this.iVz.iVE = null;
        }
      }
    }
    for (;;)
    {
      this.alc.notifyChanged();
      AppMethodBeat.o(12441);
      return;
      label144:
      this.iVz.Mx = parama;
      continue;
      this.iVz.Mx = parama;
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
    int j = (new com.tencent.mm.chatroom.d.a(this.iVx.asa()).year - this.iVy.get(1) + 1) * 12;
    int i = j;
    if (this.iVB.intValue() != -1) {
      i = j - this.iVB.intValue();
    }
    j = i;
    if (this.iVC.intValue() != -1) {
      j = i - (12 - this.iVC.intValue() - 1);
    }
    AppMethodBeat.o(12438);
    return j;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static class a<K>
    implements Serializable
  {
    K Mx;
    K iVE;
  }
  
  public static final class b
    extends RecyclerView.v
  {
    final c iVF;
    
    public b(View paramView, c.a parama)
    {
      super();
      AppMethodBeat.i(12436);
      this.iVF = ((c)paramView);
      this.iVF.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.iVF.setClickable(true);
      this.iVF.setOnDayClickListener(parama);
      AppMethodBeat.o(12436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */