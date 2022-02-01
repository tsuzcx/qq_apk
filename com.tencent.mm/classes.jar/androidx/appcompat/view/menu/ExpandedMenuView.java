package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.ac;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ExpandedMenuView
  extends ListView
  implements AdapterView.OnItemClickListener, h.b, p
{
  private static final int[] mb = { 16842964, 16843049 };
  private h is;
  private int mc;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239231);
    setOnItemClickListener(this);
    paramContext = ac.a(paramContext, paramAttributeSet, mb, paramInt, 0);
    if (paramContext.aC(0)) {
      setBackgroundDrawable(paramContext.getDrawable(0));
    }
    if (paramContext.aC(1)) {
      setDivider(paramContext.getDrawable(1));
    }
    paramContext.wA.recycle();
    AppMethodBeat.o(239231);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(239234);
    boolean bool = this.is.a(paramj, null, 0);
    AppMethodBeat.o(239234);
    return bool;
  }
  
  public final void g(h paramh)
  {
    this.is = paramh;
  }
  
  public final int getWindowAnimations()
  {
    return this.mc;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(239233);
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
    AppMethodBeat.o(239233);
  }
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(239235);
    e((j)getAdapter().getItem(paramInt));
    AppMethodBeat.o(239235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.ExpandedMenuView
 * JD-Core Version:    0.7.0.1
 */