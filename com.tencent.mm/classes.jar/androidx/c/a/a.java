package androidx.c.a;

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
  protected boolean QP = false;
  protected boolean QQ = true;
  protected int QR;
  protected a QS;
  protected DataSetObserver QT;
  protected b QU;
  protected FilterQueryProvider QV;
  protected Cursor fB = null;
  protected Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.QR = -1;
    this.QS = new a();
    this.QT = new b();
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract void a(View paramView, Cursor paramCursor);
  
  public void c(Cursor paramCursor)
  {
    if (paramCursor == this.fB) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = this.fB;
      if (localCursor != null)
      {
        if (this.QS != null) {
          localCursor.unregisterContentObserver(this.QS);
        }
        if (this.QT != null) {
          localCursor.unregisterDataSetObserver(this.QT);
        }
      }
      this.fB = paramCursor;
      if (paramCursor != null)
      {
        if (this.QS != null) {
          paramCursor.registerContentObserver(this.QS);
        }
        if (this.QT != null) {
          paramCursor.registerDataSetObserver(this.QT);
        }
        this.QR = paramCursor.getColumnIndexOrThrow("_id");
        this.QP = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        this.QR = -1;
        this.QP = false;
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
    if (this.QV != null) {
      return this.QV.runQuery(paramCharSequence);
    }
    return this.fB;
  }
  
  public int getCount()
  {
    if ((this.QP) && (this.fB != null)) {
      return this.fB.getCount();
    }
    return 0;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.QP)
    {
      this.fB.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = a(this.mContext, this.fB, paramViewGroup);
      }
      a(localView, this.fB);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.QU == null) {
      this.QU = new b(this);
    }
    return this.QU;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.QP) && (this.fB != null))
    {
      this.fB.moveToPosition(paramInt);
      return this.fB;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.QP)
    {
      l1 = l2;
      if (this.fB != null)
      {
        l1 = l2;
        if (this.fB.moveToPosition(paramInt)) {
          l1 = this.fB.getLong(this.QR);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.QP) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!this.fB.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(paramInt)));
    }
    View localView = paramView;
    if (paramView == null) {
      localView = newView(this.mContext, this.fB, paramViewGroup);
    }
    a(localView, this.fB);
    return localView;
  }
  
  public final Cursor hK()
  {
    return this.fB;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  protected final void onContentChanged()
  {
    if ((this.QQ) && (this.fB != null) && (!this.fB.isClosed())) {
      this.QP = this.fB.requery();
    }
  }
  
  final class a
    extends ContentObserver
  {
    a()
    {
      super();
      AppMethodBeat.i(218382);
      AppMethodBeat.o(218382);
    }
    
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(218384);
      a.this.onContentChanged();
      AppMethodBeat.o(218384);
    }
  }
  
  final class b
    extends DataSetObserver
  {
    b() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(218387);
      a.this.QP = true;
      a.this.notifyDataSetChanged();
      AppMethodBeat.o(218387);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(218388);
      a.this.QP = false;
      a.this.notifyDataSetInvalidated();
      AppMethodBeat.o(218388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.c.a.a
 * JD-Core Version:    0.7.0.1
 */