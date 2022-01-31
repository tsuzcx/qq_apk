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
  protected boolean JK = false;
  protected boolean JL = true;
  public Cursor JM = null;
  protected int JN;
  protected f.a JO;
  protected DataSetObserver JP;
  protected g JQ;
  protected FilterQueryProvider JR;
  public Context mContext;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.JN = -1;
    this.JO = new f.a(this);
    this.JP = new f.b(this);
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor == this.JM) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.JM;
      if (localCursor != null)
      {
        if (this.JO != null) {
          localCursor.unregisterContentObserver(this.JO);
        }
        if (this.JP != null) {
          localCursor.unregisterDataSetObserver(this.JP);
        }
      }
      this.JM = paramCursor;
      if (paramCursor != null)
      {
        if (this.JO != null) {
          paramCursor.registerContentObserver(this.JO);
        }
        if (this.JP != null) {
          paramCursor.registerDataSetObserver(this.JP);
        }
        this.JN = paramCursor.getColumnIndexOrThrow("_id");
        this.JK = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.JN = -1;
        this.JK = false;
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
    if ((this.JK) && (this.JM != null)) {
      return this.JM.getCount();
    }
    return 0;
  }
  
  public final Cursor getCursor()
  {
    return this.JM;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.JK)
    {
      this.JM.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(this.mContext, this.JM, paramViewGroup);
      }
      a(localView, this.JM);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.JQ == null) {
      this.JQ = new g(this);
    }
    return this.JQ;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.JK) && (this.JM != null))
    {
      this.JM.moveToPosition(paramInt);
      return this.JM;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.JK)
    {
      l1 = l2;
      if (this.JM != null)
      {
        l1 = l2;
        if (this.JM.moveToPosition(paramInt)) {
          l1 = this.JM.getLong(this.JN);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.JK) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.JM.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position " + paramInt);
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.JM, paramViewGroup);
    }
    a(localView, this.JM);
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
    if ((this.JL) && (this.JM != null) && (!this.JM.isClosed())) {
      this.JK = this.JM.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (this.JR != null) {
      return this.JR.runQuery(paramCharSequence);
    }
    return this.JM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.widget.f
 * JD-Core Version:    0.7.0.1
 */