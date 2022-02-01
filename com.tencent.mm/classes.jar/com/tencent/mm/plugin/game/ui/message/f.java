package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class f<VH extends RecyclerView.w>
  extends RecyclerView.a<VH>
{
  private boolean Rl;
  Cursor Rn;
  private DataSetObserver Rq;
  private Context mContext;
  
  public f(Context paramContext, Cursor paramCursor)
  {
    this.mContext = paramContext;
    this.Rn = paramCursor;
    if (paramCursor != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Rl = bool;
      this.Rq = new a((byte)0);
      if (this.Rn != null) {
        this.Rn.registerDataSetObserver(this.Rq);
      }
      return;
    }
  }
  
  private Cursor swapCursor(Cursor paramCursor)
  {
    if (paramCursor == this.Rn) {
      return null;
    }
    Cursor localCursor = this.Rn;
    if ((localCursor != null) && (this.Rq != null)) {
      localCursor.unregisterDataSetObserver(this.Rq);
    }
    this.Rn = paramCursor;
    if (this.Rn != null)
    {
      if (this.Rq != null) {
        this.Rn.registerDataSetObserver(this.Rq);
      }
      this.Rl = true;
      this.arg.notifyChanged();
      return localCursor;
    }
    this.Rl = false;
    this.arg.notifyChanged();
    return localCursor;
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    if (!this.Rl) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.Rn.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    a(paramVH, this.Rn);
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
    if ((this.Rl) && (this.Rn != null)) {
      return this.Rn.getCount();
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
      f.this.arg.notifyChanged();
      AppMethodBeat.o(183904);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(183905);
      super.onInvalidated();
      f.a(f.this, false);
      f.this.arg.notifyChanged();
      AppMethodBeat.o(183905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.f
 * JD-Core Version:    0.7.0.1
 */