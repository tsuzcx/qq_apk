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
import com.tencent.mm.chatroom.ui.e;
import com.tencent.mm.chatroom.ui.e.a;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

public final class b
  extends RecyclerView.a<b>
  implements e.a
{
  private final TypedArray lxB;
  private final a lxC;
  private final Calendar lxD;
  public final a<com.tencent.mm.chatroom.d.a> lxE;
  private final Collection<com.tencent.mm.chatroom.d.a> lxF;
  private final Integer lxG;
  private final Integer lxH;
  private final boolean lxI;
  private final Context mContext;
  
  public b(Context paramContext, a parama, TypedArray paramTypedArray, long paramLong, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12437);
    this.lxB = paramTypedArray;
    this.lxD = Calendar.getInstance();
    this.lxH = Integer.valueOf(paramTypedArray.getInt(a.j.lJP, this.lxD.get(2) % 12));
    if (-1L != paramLong) {
      this.lxD.setTimeInMillis(paramLong);
    }
    this.lxG = Integer.valueOf(paramTypedArray.getInt(a.j.lJN, this.lxD.get(2)));
    this.lxI = paramTypedArray.getBoolean(a.j.lJQ, false);
    this.lxE = new a();
    this.lxF = paramCollection;
    this.mContext = paramContext;
    this.lxC = parama;
    if (this.lxB.getBoolean(a.j.lJK, false)) {
      c(new com.tencent.mm.chatroom.d.a(System.currentTimeMillis()));
    }
    AppMethodBeat.o(12437);
  }
  
  private void c(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12440);
    this.lxC.a(parama);
    d(parama);
    AppMethodBeat.o(12440);
  }
  
  private void d(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12441);
    if (this.lxI)
    {
      int i;
      if ((this.lxE.bsC != null) && (this.lxE.lxJ == null))
      {
        this.lxE.lxJ = parama;
        if (((com.tencent.mm.chatroom.d.a)this.lxE.bsC).month < parama.month) {
          i = 0;
        }
      }
      else
      {
        while (i < ((com.tencent.mm.chatroom.d.a)this.lxE.bsC).month - parama.month - 1)
        {
          this.lxC.a(parama);
          i += 1;
          continue;
          if (this.lxE.lxJ == null) {
            break label144;
          }
          this.lxE.bsC = parama;
          this.lxE.lxJ = null;
        }
      }
    }
    for (;;)
    {
      this.bZE.notifyChanged();
      AppMethodBeat.o(12441);
      return;
      label144:
      this.lxE.bsC = parama;
      continue;
      this.lxE.bsC = parama;
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
    int j = (new com.tencent.mm.chatroom.d.a(this.lxC.aLW()).year - this.lxD.get(1) + 1) * 12;
    int i = j;
    if (this.lxG.intValue() != -1) {
      i = j - this.lxG.intValue();
    }
    j = i;
    if (this.lxH.intValue() != -1) {
      j = i - (12 - this.lxH.intValue() - 1);
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
    K bsC;
    K lxJ;
  }
  
  public static final class b
    extends RecyclerView.v
  {
    final e lxK;
    
    public b(View paramView, e.a parama)
    {
      super();
      AppMethodBeat.i(12436);
      this.lxK = ((e)paramView);
      this.lxK.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.lxK.setClickable(true);
      this.lxK.setOnDayClickListener(parama);
      AppMethodBeat.o(12436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */