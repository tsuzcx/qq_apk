package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.a.a.b;
import android.support.v4.view.b.b;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class l
  extends k
{
  l(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  final k.a a(ActionProvider paramActionProvider)
  {
    return new a(this.mContext, paramActionProvider);
  }
  
  final class a
    extends k.a
    implements ActionProvider.VisibilityListener
  {
    b.b agO;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public final void a(b.b paramb)
    {
      this.agO = paramb;
      this.agL.setVisibilityListener(this);
    }
    
    public final boolean isVisible()
    {
      return this.agL.isVisible();
    }
    
    public final void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      if (this.agO != null) {
        this.agO.ft();
      }
    }
    
    public final View onCreateActionView(MenuItem paramMenuItem)
    {
      return this.agL.onCreateActionView(paramMenuItem);
    }
    
    public final boolean overridesItemVisibility()
    {
      return this.agL.overridesItemVisibility();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.l
 * JD-Core Version:    0.7.0.1
 */