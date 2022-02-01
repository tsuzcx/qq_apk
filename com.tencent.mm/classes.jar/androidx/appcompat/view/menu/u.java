package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class u
  extends h
  implements SubMenu
{
  public h oA;
  private j oB;
  
  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.oA = paramh;
    this.oB = paramj;
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(200891);
    this.oA.a(parama);
    AppMethodBeat.o(200891);
  }
  
  public final String cT()
  {
    AppMethodBeat.i(201006);
    if (this.oB != null) {}
    for (int i = this.oB.getItemId(); i == 0; i = 0)
    {
      AppMethodBeat.o(201006);
      return null;
    }
    String str = super.cT() + ":" + i;
    AppMethodBeat.o(201006);
    return str;
  }
  
  public final boolean cU()
  {
    AppMethodBeat.i(201029);
    boolean bool = this.oA.cU();
    AppMethodBeat.o(201029);
    return bool;
  }
  
  public final boolean cV()
  {
    AppMethodBeat.i(200864);
    boolean bool = this.oA.cV();
    AppMethodBeat.o(200864);
    return bool;
  }
  
  public final boolean cW()
  {
    AppMethodBeat.i(200872);
    boolean bool = this.oA.cW();
    AppMethodBeat.o(200872);
    return bool;
  }
  
  final boolean d(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200907);
    if ((super.d(paramh, paramMenuItem)) || (this.oA.d(paramh, paramMenuItem)))
    {
      AppMethodBeat.o(200907);
      return true;
    }
    AppMethodBeat.o(200907);
    return false;
  }
  
  public final h de()
  {
    AppMethodBeat.i(200901);
    h localh = this.oA.de();
    AppMethodBeat.o(200901);
    return localh;
  }
  
  public final boolean f(j paramj)
  {
    AppMethodBeat.i(200986);
    boolean bool = this.oA.f(paramj);
    AppMethodBeat.o(200986);
    return bool;
  }
  
  public final boolean g(j paramj)
  {
    AppMethodBeat.i(200993);
    boolean bool = this.oA.g(paramj);
    AppMethodBeat.o(200993);
    return bool;
  }
  
  public MenuItem getItem()
  {
    return this.oB;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(201016);
    this.oA.setGroupDividerEnabled(paramBoolean);
    AppMethodBeat.o(201016);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    AppMethodBeat.i(200946);
    SubMenu localSubMenu = (SubMenu)super.ai(paramInt);
    AppMethodBeat.o(200946);
    return localSubMenu;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(200935);
    paramDrawable = (SubMenu)super.e(paramDrawable);
    AppMethodBeat.o(200935);
    return paramDrawable;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    AppMethodBeat.i(200966);
    SubMenu localSubMenu = (SubMenu)super.ah(paramInt);
    AppMethodBeat.o(200966);
    return localSubMenu;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200955);
    paramCharSequence = (SubMenu)super.d(paramCharSequence);
    AppMethodBeat.o(200955);
    return paramCharSequence;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    AppMethodBeat.i(200976);
    paramView = (SubMenu)super.i(paramView);
    AppMethodBeat.o(200976);
    return paramView;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    AppMethodBeat.i(200927);
    this.oB.setIcon(paramInt);
    AppMethodBeat.o(200927);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(200916);
    this.oB.setIcon(paramDrawable);
    AppMethodBeat.o(200916);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    AppMethodBeat.i(200857);
    this.oA.setQwertyMode(paramBoolean);
    AppMethodBeat.o(200857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.u
 * JD-Core Version:    0.7.0.1
 */