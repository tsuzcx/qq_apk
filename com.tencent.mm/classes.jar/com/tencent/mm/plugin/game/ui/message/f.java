package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class f<VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  private boolean Qq;
  Cursor Qs;
  private DataSetObserver Qv;
  private Context mContext;
  
  public f(Context paramContext, Cursor paramCursor)
  {
    this.mContext = paramContext;
    this.Qs = paramCursor;
    if (paramCursor != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Qq = bool;
      this.Qv = new a((byte)0);
      if (this.Qs != null) {
        this.Qs.registerDataSetObserver(this.Qv);
      }
      return;
    }
  }
  
  private Cursor swapCursor(Cursor paramCursor)
  {
    if (paramCursor == this.Qs) {
      return null;
    }
    Cursor localCursor = this.Qs;
    if ((localCursor != null) && (this.Qv != null)) {
      localCursor.unregisterDataSetObserver(this.Qv);
    }
    this.Qs = paramCursor;
    if (this.Qs != null)
    {
      if (this.Qv != null) {
        this.Qs.registerDataSetObserver(this.Qv);
      }
      this.Qq = true;
      this.aql.notifyChanged();
      return localCursor;
    }
    this.Qq = false;
    this.aql.notifyChanged();
    return localCursor;
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    if (!this.Qq) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.Qs.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    a(paramVH, this.Qs);
  }
  
  public abstract void a(VH paramVH, Cursor paramCursor);
  
  public final void av(boolean paramBoolean)
  {
    super.av(true);
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
    if ((this.Qq) && (this.Qs != null)) {
      return this.Qs.getCount();
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
      f.a(f.this, true);
      f.this.aql.notifyChanged();
      AppMethodBeat.o(183904);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(183905);
      super.onInvalidated();
      f.a(f.this, false);
      f.this.aql.notifyChanged();
      AppMethodBeat.o(183905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.f
 * JD-Core Version:    0.7.0.1
 */