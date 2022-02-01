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
  protected boolean Tm = false;
  protected boolean Tn = true;
  protected Cursor To = null;
  protected int Tp;
  protected a Tq;
  protected DataSetObserver Tr;
  protected g Ts;
  protected FilterQueryProvider Tt;
  protected Context mContext;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.Tp = -1;
    this.Tq = new a();
    this.Tr = new b();
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor == this.To) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.To;
      if (localCursor != null)
      {
        if (this.Tq != null) {
          localCursor.unregisterContentObserver(this.Tq);
        }
        if (this.Tr != null) {
          localCursor.unregisterDataSetObserver(this.Tr);
        }
      }
      this.To = paramCursor;
      if (paramCursor != null)
      {
        if (this.Tq != null) {
          paramCursor.registerContentObserver(this.Tq);
        }
        if (this.Tr != null) {
          paramCursor.registerDataSetObserver(this.Tr);
        }
        this.Tp = paramCursor.getColumnIndexOrThrow("_id");
        this.Tm = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.Tp = -1;
        this.Tm = false;
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
    if ((this.Tm) && (this.To != null)) {
      return this.To.getCount();
    }
    return 0;
  }
  
  public final Cursor getCursor()
  {
    return this.To;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.Tm)
    {
      this.To.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(this.mContext, this.To, paramViewGroup);
      }
      a(localView, this.To);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.Ts == null) {
      this.Ts = new g(this);
    }
    return this.Ts;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.Tm) && (this.To != null))
    {
      this.To.moveToPosition(paramInt);
      return this.To;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.Tm)
    {
      l1 = l2;
      if (this.To != null)
      {
        l1 = l2;
        if (this.To.moveToPosition(paramInt)) {
          l1 = this.To.getLong(this.Tp);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.Tm) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.To.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.To, paramViewGroup);
    }
    a(localView, this.To);
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
    if ((this.Tn) && (this.To != null) && (!this.To.isClosed())) {
      this.Tm = this.To.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (this.Tt != null) {
      return this.Tt.runQuery(paramCharSequence);
    }
    return this.To;
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
      f.this.Tm = true;
      f.this.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      f.this.Tm = false;
      f.this.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.f
 * JD-Core Version:    0.7.0.1
 */