package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class g<VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  private boolean QP;
  private DataSetObserver QT;
  Cursor fB;
  private Context mContext;
  
  public g(Context paramContext, Cursor paramCursor)
  {
    this.mContext = paramContext;
    this.fB = paramCursor;
    if (paramCursor != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.QP = bool;
      this.QT = new a((byte)0);
      if (this.fB != null) {
        this.fB.registerDataSetObserver(this.QT);
      }
      return;
    }
  }
  
  private Cursor l(Cursor paramCursor)
  {
    if (paramCursor == this.fB) {
      return null;
    }
    Cursor localCursor = this.fB;
    if ((localCursor != null) && (this.QT != null)) {
      localCursor.unregisterDataSetObserver(this.QT);
    }
    this.fB = paramCursor;
    if (this.fB != null)
    {
      if (this.QT != null) {
        this.fB.registerDataSetObserver(this.QT);
      }
      this.QP = true;
      this.alc.notifyChanged();
      return localCursor;
    }
    this.QP = false;
    this.alc.notifyChanged();
    return localCursor;
  }
  
  public abstract void a(VH paramVH, Cursor paramCursor);
  
  public final void aw(boolean paramBoolean)
  {
    super.aw(true);
  }
  
  public final void c(Cursor paramCursor)
  {
    paramCursor = l(paramCursor);
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public final void d(VH paramVH, int paramInt)
  {
    if (!this.QP) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.fB.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    a(paramVH, this.fB);
  }
  
  public final int getItemCount()
  {
    if ((this.QP) && (this.fB != null)) {
      return this.fB.getCount();
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
      g.this.alc.notifyChanged();
      AppMethodBeat.o(183904);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(183905);
      super.onInvalidated();
      g.a(g.this, false);
      g.this.alc.notifyChanged();
      AppMethodBeat.o(183905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.g
 * JD-Core Version:    0.7.0.1
 */