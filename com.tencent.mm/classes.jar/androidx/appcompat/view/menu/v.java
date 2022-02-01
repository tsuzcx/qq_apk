package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class v
  extends r
  implements SubMenu
{
  v(Context paramContext, c paramc)
  {
    super(paramContext, paramc);
  }
  
  public final void clearHeader()
  {
    AppMethodBeat.i(239952);
    ((c)this.lv).clearHeader();
    AppMethodBeat.o(239952);
  }
  
  public final MenuItem getItem()
  {
    AppMethodBeat.i(239959);
    MenuItem localMenuItem = b(((c)this.lv).getItem());
    AppMethodBeat.o(239959);
    return localMenuItem;
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    AppMethodBeat.i(239944);
    ((c)this.lv).setHeaderIcon(paramInt);
    AppMethodBeat.o(239944);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239947);
    ((c)this.lv).setHeaderIcon(paramDrawable);
    AppMethodBeat.o(239947);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    AppMethodBeat.i(239940);
    ((c)this.lv).setHeaderTitle(paramInt);
    AppMethodBeat.o(239940);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239941);
    ((c)this.lv).setHeaderTitle(paramCharSequence);
    AppMethodBeat.o(239941);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    AppMethodBeat.i(239949);
    ((c)this.lv).setHeaderView(paramView);
    AppMethodBeat.o(239949);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    AppMethodBeat.i(239954);
    ((c)this.lv).setIcon(paramInt);
    AppMethodBeat.o(239954);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239957);
    ((c)this.lv).setIcon(paramDrawable);
    AppMethodBeat.o(239957);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.v
 * JD-Core Version:    0.7.0.1
 */