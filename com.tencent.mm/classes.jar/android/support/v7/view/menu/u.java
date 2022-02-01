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
  public h aeq;
  private j aer;
  
  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.aeq = paramh;
    this.aer = paramj;
  }
  
  public final void a(h.a parama)
  {
    this.aeq.a(parama);
  }
  
  final boolean d(h paramh, MenuItem paramMenuItem)
  {
    return (super.d(paramh, paramMenuItem)) || (this.aeq.d(paramh, paramMenuItem));
  }
  
  public final boolean g(j paramj)
  {
    return this.aeq.g(paramj);
  }
  
  public MenuItem getItem()
  {
    return this.aer;
  }
  
  public final boolean h(j paramj)
  {
    return this.aeq.h(paramj);
  }
  
  public final h hA()
  {
    return this.aeq.hA();
  }
  
  public final String hp()
  {
    if (this.aer != null) {}
    for (int i = this.aer.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.hp() + ":" + i;
  }
  
  public final boolean hq()
  {
    return this.aeq.hq();
  }
  
  public final boolean hr()
  {
    return this.aeq.hr();
  }
  
  public final boolean hs()
  {
    return this.aeq.hs();
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.aeq.setGroupDividerEnabled(paramBoolean);
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
    this.aer.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.aer.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.aeq.setQwertyMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.u
 * JD-Core Version:    0.7.0.1
 */