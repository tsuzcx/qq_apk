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
  private boolean Ta;
  Cursor Tc;
  private DataSetObserver Tf;
  private Context mContext;
  
  public f(Context paramContext, Cursor paramCursor)
  {
    this.mContext = paramContext;
    this.Tc = paramCursor;
    if (paramCursor != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ta = bool;
      this.Tf = new a((byte)0);
      if (this.Tc != null) {
        this.Tc.registerDataSetObserver(this.Tf);
      }
      return;
    }
  }
  
  private Cursor swapCursor(Cursor paramCursor)
  {
    if (paramCursor == this.Tc) {
      return null;
    }
    Cursor localCursor = this.Tc;
    if ((localCursor != null) && (this.Tf != null)) {
      localCursor.unregisterDataSetObserver(this.Tf);
    }
    this.Tc = paramCursor;
    if (this.Tc != null)
    {
      if (this.Tf != null) {
        this.Tc.registerDataSetObserver(this.Tf);
      }
      this.Ta = true;
      this.asY.notifyChanged();
      return localCursor;
    }
    this.Ta = false;
    this.asY.notifyChanged();
    return localCursor;
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    if (!this.Ta) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.Tc.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    a(paramVH, this.Tc);
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
    if ((this.Ta) && (this.Tc != null)) {
      return this.Tc.getCount();
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
      f.this.asY.notifyChanged();
      AppMethodBeat.o(183904);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(183905);
      super.onInvalidated();
      f.a(f.this, false);
      f.this.asY.notifyChanged();
      AppMethodBeat.o(183905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.f
 * JD-Core Version:    0.7.0.1
 */