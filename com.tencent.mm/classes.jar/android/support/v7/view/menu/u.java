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
  public h ahb;
  private j ahc;
  
  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.ahb = paramh;
    this.ahc = paramj;
  }
  
  public final void a(h.a parama)
  {
    this.ahb.a(parama);
  }
  
  final boolean d(h paramh, MenuItem paramMenuItem)
  {
    return (super.d(paramh, paramMenuItem)) || (this.ahb.d(paramh, paramMenuItem));
  }
  
  public final boolean g(j paramj)
  {
    return this.ahb.g(paramj);
  }
  
  public MenuItem getItem()
  {
    return this.ahc;
  }
  
  public final boolean h(j paramj)
  {
    return this.ahb.h(paramj);
  }
  
  public final String hN()
  {
    if (this.ahc != null) {}
    for (int i = this.ahc.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.hN() + ":" + i;
  }
  
  public final boolean hO()
  {
    return this.ahb.hO();
  }
  
  public final boolean hP()
  {
    return this.ahb.hP();
  }
  
  public final boolean hQ()
  {
    return this.ahb.hQ();
  }
  
  public final h hY()
  {
    return this.ahb.hY();
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.ahb.setGroupDividerEnabled(paramBoolean);
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
    this.ahc.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.ahc.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.ahb.setQwertyMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.u
 * JD-Core Version:    0.7.0.1
 */