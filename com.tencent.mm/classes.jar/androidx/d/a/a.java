package androidx.d.a;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a
  extends BaseAdapter
  implements Filterable, b.a
{
  protected boolean bxg = false;
  protected boolean bxh = true;
  protected int bxi;
  protected a bxj;
  protected DataSetObserver bxk;
  protected b bxl;
  protected FilterQueryProvider bxm;
  protected Cursor gw = null;
  protected Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.bxi = -1;
    this.bxj = new a();
    this.bxk = new b();
  }
  
  public final Cursor Fv()
  {
    return this.gw;
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public void c(Cursor paramCursor)
  {
    if (paramCursor == this.gw) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.gw;
      if (localCursor != null)
      {
        if (this.bxj != null) {
          localCursor.unregisterContentObserver(this.bxj);
        }
        if (this.bxk != null) {
          localCursor.unregisterDataSetObserver(this.bxk);
        }
      }
      this.gw = paramCursor;
      if (paramCursor != null)
      {
        if (this.bxj != null) {
          paramCursor.registerContentObserver(this.bxj);
        }
        if (this.bxk != null) {
          paramCursor.registerDataSetObserver(this.bxk);
        }
        this.bxi = paramCursor.getColumnIndexOrThrow("_id");
        this.bxg = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.bxi = -1;
        this.bxg = false;
        notifyDataSetInvalidated();
        paramCursor = localCursor;
      }
    }
  }
  
  public CharSequence d(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return "";
    }
    return paramCursor.toString();
  }
  
  public Cursor g(CharSequence paramCharSequence)
  {
    if (this.bxm != null) {
      return this.bxm.runQuery(paramCharSequence);
    }
    return this.gw;
  }
  
  public int getCount()
  {
    if ((this.bxg) && (this.gw != null)) {
      return this.gw.getCount();
    }
    return 0;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.bxg)
    {
      this.gw.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = a(this.mContext, this.gw, paramViewGroup);
      }
      a(localView, this.gw);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.bxl == null) {
      this.bxl = new b(this);
    }
    return this.bxl;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.bxg) && (this.gw != null))
    {
      this.gw.moveToPosition(paramInt);
      return this.gw;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.bxg)
    {
      l1 = l2;
      if (this.gw != null)
      {
        l1 = l2;
        if (this.gw.moveToPosition(paramInt)) {
          l1 = this.gw.getLong(this.bxi);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.bxg) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.gw.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.gw, paramViewGroup);
    }
    a(localView, this.gw);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  protected final void onContentChanged()
  {
    if ((this.bxh) && (this.gw != null) && (!this.gw.isClosed())) {
      this.bxg = this.gw.requery();
    }
  }
  
  final class a
    extends ContentObserver
  {
    a()
    {
      super();
      AppMethodBeat.i(192805);
      AppMethodBeat.o(192805);
    }
    
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(192825);
      a.this.onContentChanged();
      AppMethodBeat.o(192825);
    }
  }
  
  final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(192826);
      a.this.bxg = true;
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(192826);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(192836);
      a.this.bxg = false;
      a.this.notifyDataSetInvalidated();
      AppMethodBeat.o(192836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.d.a.a
 * JD-Core Version:    0.7.0.1
 */