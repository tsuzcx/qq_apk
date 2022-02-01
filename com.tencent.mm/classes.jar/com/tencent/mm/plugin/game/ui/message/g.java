package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class g<VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  private boolean Tm;
  Cursor To;
  private DataSetObserver Tr;
  private Context mContext;
  
  public g(Context paramContext, Cursor paramCursor)
  {
    this.mContext = paramContext;
    this.To = paramCursor;
    if (paramCursor != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Tm = bool;
      this.Tr = new a((byte)0);
      if (this.To != null) {
        this.To.registerDataSetObserver(this.Tr);
      }
      return;
    }
  }
  
  private Cursor swapCursor(Cursor paramCursor)
  {
    if (paramCursor == this.To) {
      return null;
    }
    Cursor localCursor = this.To;
    if ((localCursor != null) && (this.Tr != null)) {
      localCursor.unregisterDataSetObserver(this.Tr);
    }
    this.To = paramCursor;
    if (this.To != null)
    {
      if (this.Tr != null) {
        this.To.registerDataSetObserver(this.Tr);
      }
      this.Tm = true;
      this.atj.notifyChanged();
      return localCursor;
    }
    this.Tm = false;
    this.atj.notifyChanged();
    return localCursor;
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    if (!this.Tm) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.To.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    a(paramVH, this.To);
  }
  
  public abstract void a(VH paramVH, Cursor paramCursor);
  
  public final void au(boolean paramBoolean)
  {
    super.au(true);
  }
  
  public final void changeCursor(Cursor paramCursor)
  {
    paramCursor = swapCursor(paramCursor);
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public final int getItemCount()
  {
    if ((this.Tm) && (this.To != null)) {
      return this.To.getCount();
    }
    return 0;
  }
  
  final class a
    extends DataSetObserver
  {
    private a() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(183904);
      super.onChanged();
      g.a(g.this, true);
      g.this.atj.notifyChanged();
      AppMethodBeat.o(183904);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(183905);
      super.onInvalidated();
      g.a(g.this, false);
      g.this.atj.notifyChanged();
      AppMethodBeat.o(183905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.g
 * JD-Core Version:    0.7.0.1
 */