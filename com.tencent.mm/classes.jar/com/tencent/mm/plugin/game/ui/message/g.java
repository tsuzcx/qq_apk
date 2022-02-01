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
  private boolean bxg;
  private DataSetObserver bxk;
  Cursor gw;
  private Context mContext;
  
  public g(Context paramContext, Cursor paramCursor)
  {
    this.mContext = paramContext;
    this.gw = paramCursor;
    if (paramCursor != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.bxg = bool;
      this.bxk = new a((byte)0);
      if (this.gw != null) {
        this.gw.registerDataSetObserver(this.bxk);
      }
      return;
    }
  }
  
  private Cursor m(Cursor paramCursor)
  {
    if (paramCursor == this.gw) {
      return null;
    }
    Cursor localCursor = this.gw;
    if ((localCursor != null) && (this.bxk != null)) {
      localCursor.unregisterDataSetObserver(this.bxk);
    }
    this.gw = paramCursor;
    if (this.gw != null)
    {
      if (this.bxk != null) {
        this.gw.registerDataSetObserver(this.bxk);
      }
      this.bxg = true;
      this.bZE.notifyChanged();
      return localCursor;
    }
    this.bxg = false;
    this.bZE.notifyChanged();
    return localCursor;
  }
  
  public abstract void a(VH paramVH, Cursor paramCursor);
  
  public final void bf(boolean paramBoolean)
  {
    super.bf(true);
  }
  
  public final void c(Cursor paramCursor)
  {
    paramCursor = m(paramCursor);
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public final void d(VH paramVH, int paramInt)
  {
    if (!this.bxg) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.gw.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    a(paramVH, this.gw);
  }
  
  public final int getItemCount()
  {
    if ((this.bxg) && (this.gw != null)) {
      return this.gw.getCount();
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
      g.this.bZE.notifyChanged();
      AppMethodBeat.o(183904);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(183905);
      super.onInvalidated();
      g.a(g.this, false);
      g.this.bZE.notifyChanged();
      AppMethodBeat.o(183905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.g
 * JD-Core Version:    0.7.0.1
 */