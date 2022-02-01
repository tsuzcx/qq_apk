package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class f
  extends BaseAdapter
  implements g.a, Filterable
{
  protected boolean Rl = false;
  protected boolean Rm = true;
  protected Cursor Rn = null;
  protected int Ro;
  protected a Rp;
  protected DataSetObserver Rq;
  protected g Rr;
  protected FilterQueryProvider Rs;
  protected Context mContext;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.Ro = -1;
    this.Rp = new a();
    this.Rq = new b();
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor == this.Rn) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.Rn;
      if (localCursor != null)
      {
        if (this.Rp != null) {
          localCursor.unregisterContentObserver(this.Rp);
        }
        if (this.Rq != null) {
          localCursor.unregisterDataSetObserver(this.Rq);
        }
      }
      this.Rn = paramCursor;
      if (paramCursor != null)
      {
        if (this.Rp != null) {
          paramCursor.registerContentObserver(this.Rp);
        }
        if (this.Rq != null) {
          paramCursor.registerDataSetObserver(this.Rq);
        }
        this.Ro = paramCursor.getColumnIndexOrThrow("_id");
        this.Rl = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.Ro = -1;
        this.Rl = false;
        notifyDataSetInvalidated();
        paramCursor = localCursor;
      }
    }
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return "";
    }
    return paramCursor.toString();
  }
  
  public int getCount()
  {
    if ((this.Rl) && (this.Rn != null)) {
      return this.Rn.getCount();
    }
    return 0;
  }
  
  public final Cursor getCursor()
  {
    return this.Rn;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.Rl)
    {
      this.Rn.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(this.mContext, this.Rn, paramViewGroup);
      }
      a(localView, this.Rn);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.Rr == null) {
      this.Rr = new g(this);
    }
    return this.Rr;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.Rl) && (this.Rn != null))
    {
      this.Rn.moveToPosition(paramInt);
      return this.Rn;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.Rl)
    {
      l1 = l2;
      if (this.Rn != null)
      {
        l1 = l2;
        if (this.Rn.moveToPosition(paramInt)) {
          l1 = this.Rn.getLong(this.Ro);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.Rl) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.Rn.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.Rn, paramViewGroup);
    }
    a(localView, this.Rn);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  protected final void onContentChanged()
  {
    if ((this.Rm) && (this.Rn != null) && (!this.Rn.isClosed())) {
      this.Rl = this.Rn.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (this.Rs != null) {
      return this.Rs.runQuery(paramCharSequence);
    }
    return this.Rn;
  }
  
  final class a
    extends ContentObserver
  {
    a()
    {
      super();
    }
    
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      f.this.onContentChanged();
    }
  }
  
  final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      f.this.Rl = true;
      f.this.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      f.this.Rl = false;
      f.this.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.widget.f
 * JD-Core Version:    0.7.0.1
 */