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
    AppMethodBeat.i(200892);
    ((c)this.mr).clearHeader();
    AppMethodBeat.o(200892);
  }
  
  public final MenuItem getItem()
  {
    AppMethodBeat.i(200917);
    MenuItem localMenuItem = b(((c)this.mr).getItem());
    AppMethodBeat.o(200917);
    return localMenuItem;
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    AppMethodBeat.i(200866);
    ((c)this.mr).setHeaderIcon(paramInt);
    AppMethodBeat.o(200866);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(200875);
    ((c)this.mr).setHeaderIcon(paramDrawable);
    AppMethodBeat.o(200875);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    AppMethodBeat.i(200849);
    ((c)this.mr).setHeaderTitle(paramInt);
    AppMethodBeat.o(200849);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200859);
    ((c)this.mr).setHeaderTitle(paramCharSequence);
    AppMethodBeat.o(200859);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    AppMethodBeat.i(200884);
    ((c)this.mr).setHeaderView(paramView);
    AppMethodBeat.o(200884);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    AppMethodBeat.i(200899);
    ((c)this.mr).setIcon(paramInt);
    AppMethodBeat.o(200899);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(200909);
    ((c)this.mr).setIcon(paramDrawable);
    AppMethodBeat.o(200909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.v
 * JD-Core Version:    0.7.0.1
 */