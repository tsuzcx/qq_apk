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
  protected boolean Qq = false;
  protected boolean Qr = true;
  protected Cursor Qs = null;
  protected int Qt;
  protected a Qu;
  protected DataSetObserver Qv;
  protected g Qw;
  protected FilterQueryProvider Qx;
  protected Context mContext;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.Qt = -1;
    this.Qu = new a();
    this.Qv = new b();
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor == this.Qs) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.Qs;
      if (localCursor != null)
      {
        if (this.Qu != null) {
          localCursor.unregisterContentObserver(this.Qu);
        }
        if (this.Qv != null) {
          localCursor.unregisterDataSetObserver(this.Qv);
        }
      }
      this.Qs = paramCursor;
      if (paramCursor != null)
      {
        if (this.Qu != null) {
          paramCursor.registerContentObserver(this.Qu);
        }
        if (this.Qv != null) {
          paramCursor.registerDataSetObserver(this.Qv);
        }
        this.Qt = paramCursor.getColumnIndexOrThrow("_id");
        this.Qq = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.Qt = -1;
        this.Qq = false;
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
    if ((this.Qq) && (this.Qs != null)) {
      return this.Qs.getCount();
    }
    return 0;
  }
  
  public final Cursor getCursor()
  {
    return this.Qs;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.Qq)
    {
      this.Qs.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(this.mContext, this.Qs, paramViewGroup);
      }
      a(localView, this.Qs);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.Qw == null) {
      this.Qw = new g(this);
    }
    return this.Qw;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.Qq) && (this.Qs != null))
    {
      this.Qs.moveToPosition(paramInt);
      return this.Qs;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.Qq)
    {
      l1 = l2;
      if (this.Qs != null)
      {
        l1 = l2;
        if (this.Qs.moveToPosition(paramInt)) {
          l1 = this.Qs.getLong(this.Qt);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.Qq) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.Qs.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.Qs, paramViewGroup);
    }
    a(localView, this.Qs);
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
    if ((this.Qr) && (this.Qs != null) && (!this.Qs.isClosed())) {
      this.Qq = this.Qs.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (this.Qx != null) {
      return this.Qx.runQuery(paramCharSequence);
    }
    return this.Qs;
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
      f.this.Qq = true;
      f.this.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      f.this.Qq = false;
      f.this.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.f
 * JD-Core Version:    0.7.0.1
 */