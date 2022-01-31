package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
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
  protected boolean Jq = false;
  protected boolean Jr = true;
  protected Cursor Js = null;
  protected int Jt;
  protected f.a Ju;
  protected DataSetObserver Jv;
  protected g Jw;
  protected FilterQueryProvider Jx;
  protected Context mContext;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.Jt = -1;
    this.Ju = new f.a(this);
    this.Jv = new f.b(this);
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor == this.Js) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.Js;
      if (localCursor != null)
      {
        if (this.Ju != null) {
          localCursor.unregisterContentObserver(this.Ju);
        }
        if (this.Jv != null) {
          localCursor.unregisterDataSetObserver(this.Jv);
        }
      }
      this.Js = paramCursor;
      if (paramCursor != null)
      {
        if (this.Ju != null) {
          paramCursor.registerContentObserver(this.Ju);
        }
        if (this.Jv != null) {
          paramCursor.registerDataSetObserver(this.Jv);
        }
        this.Jt = paramCursor.getColumnIndexOrThrow("_id");
        this.Jq = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.Jt = -1;
        this.Jq = false;
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
    if ((this.Jq) && (this.Js != null)) {
      return this.Js.getCount();
    }
    return 0;
  }
  
  public final Cursor getCursor()
  {
    return this.Js;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.Jq)
    {
      this.Js.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(this.mContext, this.Js, paramViewGroup);
      }
      a(localView, this.Js);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.Jw == null) {
      this.Jw = new g(this);
    }
    return this.Jw;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.Jq) && (this.Js != null))
    {
      this.Js.moveToPosition(paramInt);
      return this.Js;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.Jq)
    {
      l1 = l2;
      if (this.Js != null)
      {
        l1 = l2;
        if (this.Js.moveToPosition(paramInt)) {
          l1 = this.Js.getLong(this.Jt);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.Jq) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.Js.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.Js, paramViewGroup);
    }
    a(localView, this.Js);
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
    if ((this.Jr) && (this.Js != null) && (!this.Js.isClosed())) {
      this.Jq = this.Js.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (this.Jx != null) {
      return this.Jx.runQuery(paramCharSequence);
    }
    return this.Js;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.widget.f
 * JD-Core Version:    0.7.0.1
 */