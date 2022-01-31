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
  public h Xl;
  private j Xm;
  
  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.Xl = paramh;
    this.Xm = paramj;
  }
  
  public final void a(h.a parama)
  {
    this.Xl.a(parama);
  }
  
  final boolean d(h paramh, MenuItem paramMenuItem)
  {
    return (super.d(paramh, paramMenuItem)) || (this.Xl.d(paramh, paramMenuItem));
  }
  
  public final String fT()
  {
    if (this.Xm != null) {}
    for (int i = this.Xm.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.fT() + ":" + i;
  }
  
  public final boolean fU()
  {
    return this.Xl.fU();
  }
  
  public final boolean fV()
  {
    return this.Xl.fV();
  }
  
  public final boolean fW()
  {
    return this.Xl.fW();
  }
  
  public final boolean g(j paramj)
  {
    return this.Xl.g(paramj);
  }
  
  public MenuItem getItem()
  {
    return this.Xm;
  }
  
  public final h gf()
  {
    return this.Xl.gf();
  }
  
  public final boolean h(j paramj)
  {
    return this.Xl.h(paramj);
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.Xl.setGroupDividerEnabled(paramBoolean);
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
    this.Xm.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.Xm.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.Xl.setQwertyMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.u
 * JD-Core Version:    0.7.0.1
 */