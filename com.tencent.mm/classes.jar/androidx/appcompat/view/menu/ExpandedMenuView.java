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
  private static final int[] na = { 16842964, 16843049 };
  private h jo;
  private int nb;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200815);
    setOnItemClickListener(this);
    paramContext = ac.a(paramContext, paramAttributeSet, na, paramInt, 0);
    if (paramContext.az(0)) {
      setBackgroundDrawable(paramContext.getDrawable(0));
    }
    if (paramContext.az(1)) {
      setDivider(paramContext.getDrawable(1));
    }
    paramContext.xv.recycle();
    AppMethodBeat.o(200815);
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(200867);
    boolean bool = this.jo.a(paramj, null, 0);
    AppMethodBeat.o(200867);
    return bool;
  }
  
  public final void g(h paramh)
  {
    this.jo = paramh;
  }
  
  public final int getWindowAnimations()
  {
    return this.nb;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(200855);
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
    AppMethodBeat.o(200855);
  }
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(200879);
    e((j)getAdapter().getItem(paramInt));
    AppMethodBeat.o(200879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.ExpandedMenuView
 * JD-Core Version:    0.7.0.1
 */