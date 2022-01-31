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
  public h Wy;
  private j Wz;
  
  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.Wy = paramh;
    this.Wz = paramj;
  }
  
  public final void a(h.a parama)
  {
    this.Wy.a(parama);
  }
  
  final boolean d(h paramh, MenuItem paramMenuItem)
  {
    return (super.d(paramh, paramMenuItem)) || (this.Wy.d(paramh, paramMenuItem));
  }
  
  public final String fe()
  {
    if (this.Wz != null) {}
    for (int i = this.Wz.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.fe() + ":" + i;
  }
  
  public final boolean ff()
  {
    return this.Wy.ff();
  }
  
  public final boolean fg()
  {
    return this.Wy.fg();
  }
  
  public final h fo()
  {
    return this.Wy.fo();
  }
  
  public final boolean g(j paramj)
  {
    return this.Wy.g(paramj);
  }
  
  public MenuItem getItem()
  {
    return this.Wz;
  }
  
  public final boolean h(j paramj)
  {
    return this.Wy.h(paramj);
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
    this.Wz.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.Wz.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.Wy.setQwertyMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.u
 * JD-Core Version:    0.7.0.1
 */