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
  public h aho;
  private j ahp;
  
  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.aho = paramh;
    this.ahp = paramj;
  }
  
  public final void a(h.a parama)
  {
    this.aho.a(parama);
  }
  
  final boolean d(h paramh, MenuItem paramMenuItem)
  {
    return (super.d(paramh, paramMenuItem)) || (this.aho.d(paramh, paramMenuItem));
  }
  
  public final boolean g(j paramj)
  {
    return this.aho.g(paramj);
  }
  
  public MenuItem getItem()
  {
    return this.ahp;
  }
  
  public final boolean h(j paramj)
  {
    return this.aho.h(paramj);
  }
  
  public final String hW()
  {
    if (this.ahp != null) {}
    for (int i = this.ahp.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.hW() + ":" + i;
  }
  
  public final boolean hX()
  {
    return this.aho.hX();
  }
  
  public final boolean hY()
  {
    return this.aho.hY();
  }
  
  public final boolean hZ()
  {
    return this.aho.hZ();
  }
  
  public final h ii()
  {
    return this.aho.ii();
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.aho.setGroupDividerEnabled(paramBoolean);
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
    this.ahp.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.ahp.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.aho.setQwertyMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.u
 * JD-Core Version:    0.7.0.1
 */