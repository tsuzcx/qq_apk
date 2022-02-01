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
  protected boolean Ta = false;
  protected boolean Tb = true;
  protected Cursor Tc = null;
  protected int Td;
  protected a Te;
  protected DataSetObserver Tf;
  protected g Tg;
  protected FilterQueryProvider Th;
  protected Context mContext;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.Td = -1;
    this.Te = new a();
    this.Tf = new b();
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor == this.Tc) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.Tc;
      if (localCursor != null)
      {
        if (this.Te != null) {
          localCursor.unregisterContentObserver(this.Te);
        }
        if (this.Tf != null) {
          localCursor.unregisterDataSetObserver(this.Tf);
        }
      }
      this.Tc = paramCursor;
      if (paramCursor != null)
      {
        if (this.Te != null) {
          paramCursor.registerContentObserver(this.Te);
        }
        if (this.Tf != null) {
          paramCursor.registerDataSetObserver(this.Tf);
        }
        this.Td = paramCursor.getColumnIndexOrThrow("_id");
        this.Ta = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.Td = -1;
        this.Ta = false;
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
    if ((this.Ta) && (this.Tc != null)) {
      return this.Tc.getCount();
    }
    return 0;
  }
  
  public final Cursor getCursor()
  {
    return this.Tc;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.Ta)
    {
      this.Tc.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(this.mContext, this.Tc, paramViewGroup);
      }
      a(localView, this.Tc);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.Tg == null) {
      this.Tg = new g(this);
    }
    return this.Tg;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.Ta) && (this.Tc != null))
    {
      this.Tc.moveToPosition(paramInt);
      return this.Tc;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.Ta)
    {
      l1 = l2;
      if (this.Tc != null)
      {
        l1 = l2;
        if (this.Tc.moveToPosition(paramInt)) {
          l1 = this.Tc.getLong(this.Td);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.Ta) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.Tc.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.Tc, paramViewGroup);
    }
    a(localView, this.Tc);
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
    if ((this.Tb) && (this.Tc != null) && (!this.Tc.isClosed())) {
      this.Ta = this.Tc.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (this.Th != null) {
      return this.Th.runQuery(paramCharSequence);
    }
    return this.Tc;
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
      f.this.Ta = true;
      f.this.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      f.this.Ta = false;
      f.this.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.f
 * JD-Core Version:    0.7.0.1
 */