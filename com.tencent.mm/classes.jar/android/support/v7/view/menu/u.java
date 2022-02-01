package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class u
  extends h
  implements SubMenu
{
  public h afk;
  private j afl;
  
  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.afk = paramh;
    this.afl = paramj;
  }
  
  public final void a(h.a parama)
  {
    this.afk.a(parama);
  }
  
  final boolean d(h paramh, MenuItem paramMenuItem)
  {
    return (super.d(paramh, paramMenuItem)) || (this.afk.d(paramh, paramMenuItem));
  }
  
  public final boolean g(j paramj)
  {
    return this.afk.g(paramj);
  }
  
  public MenuItem getItem()
  {
    return this.afl;
  }
  
  public final boolean h(j paramj)
  {
    return this.afk.h(paramj);
  }
  
  public final boolean hA()
  {
    return this.afk.hA();
  }
  
  public final h hI()
  {
    return this.afk.hI();
  }
  
  public final String hx()
  {
    if (this.afl != null) {}
    for (int i = this.afl.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.hx() + ":" + i;
  }
  
  public final boolean hy()
  {
    return this.afk.hy();
  }
  
  public final boolean hz()
  {
    return this.afk.hz();
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.afk.setGroupDividerEnabled(paramBoolean);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    super.a(0, null, paramInt, null, null);
    return (SubMenu)this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.a(0, null, 0, paramDrawable, null);
    return (SubMenu)this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    super.a(paramInt, null, 0, null, null);
    return (SubMenu)this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.a(0, paramCharSequence, 0, null, null);
    return (SubMenu)this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    super.a(0, null, 0, null, paramView);
    return (SubMenu)this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.afl.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.afl.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.afk.setQwertyMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.u
 * JD-Core Version:    0.7.0.1
 */