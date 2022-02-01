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
  public h nB;
  private j nC;
  
  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.nB = paramh;
    this.nC = paramj;
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(239896);
    this.nB.a(parama);
    AppMethodBeat.o(239896);
  }
  
  public final String ca()
  {
    AppMethodBeat.i(239925);
    if (this.nC != null) {}
    for (int i = this.nC.getItemId(); i == 0; i = 0)
    {
      AppMethodBeat.o(239925);
      return null;
    }
    String str = super.ca() + ":" + i;
    AppMethodBeat.o(239925);
    return str;
  }
  
  public final boolean cb()
  {
    AppMethodBeat.i(239931);
    boolean bool = this.nB.cb();
    AppMethodBeat.o(239931);
    return bool;
  }
  
  public final boolean cc()
  {
    AppMethodBeat.i(239891);
    boolean bool = this.nB.cc();
    AppMethodBeat.o(239891);
    return bool;
  }
  
  public final boolean cd()
  {
    AppMethodBeat.i(239893);
    boolean bool = this.nB.cd();
    AppMethodBeat.o(239893);
    return bool;
  }
  
  public final h cl()
  {
    AppMethodBeat.i(239898);
    h localh = this.nB.cl();
    AppMethodBeat.o(239898);
    return localh;
  }
  
  final boolean d(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(239901);
    if ((super.d(paramh, paramMenuItem)) || (this.nB.d(paramh, paramMenuItem)))
    {
      AppMethodBeat.o(239901);
      return true;
    }
    AppMethodBeat.o(239901);
    return false;
  }
  
  public final boolean f(j paramj)
  {
    AppMethodBeat.i(239917);
    boolean bool = this.nB.f(paramj);
    AppMethodBeat.o(239917);
    return bool;
  }
  
  public final boolean g(j paramj)
  {
    AppMethodBeat.i(239921);
    boolean bool = this.nB.g(paramj);
    AppMethodBeat.o(239921);
    return bool;
  }
  
  public MenuItem getItem()
  {
    return this.nC;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(239928);
    this.nB.setGroupDividerEnabled(paramBoolean);
    AppMethodBeat.o(239928);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    AppMethodBeat.i(239910);
    SubMenu localSubMenu = (SubMenu)super.ak(paramInt);
    AppMethodBeat.o(239910);
    return localSubMenu;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239908);
    paramDrawable = (SubMenu)super.d(paramDrawable);
    AppMethodBeat.o(239908);
    return paramDrawable;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    AppMethodBeat.i(239912);
    SubMenu localSubMenu = (SubMenu)super.aj(paramInt);
    AppMethodBeat.o(239912);
    return localSubMenu;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239911);
    paramCharSequence = (SubMenu)super.d(paramCharSequence);
    AppMethodBeat.o(239911);
    return paramCharSequence;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    AppMethodBeat.i(239914);
    paramView = (SubMenu)super.i(paramView);
    AppMethodBeat.o(239914);
    return paramView;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    AppMethodBeat.i(239905);
    this.nC.setIcon(paramInt);
    AppMethodBeat.o(239905);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239903);
    this.nC.setIcon(paramDrawable);
    AppMethodBeat.o(239903);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    AppMethodBeat.i(239888);
    this.nB.setQwertyMode(paramBoolean);
    AppMethodBeat.o(239888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.u
 * JD-Core Version:    0.7.0.1
 */