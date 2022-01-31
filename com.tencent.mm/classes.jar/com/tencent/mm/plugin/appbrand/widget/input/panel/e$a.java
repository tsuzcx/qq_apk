package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

public final class e$a
  implements e
{
  int htS;
  boolean mInLayout;
  private View mView;
  
  public e$a(Context paramContext)
  {
    this.mView = new e.a.1(this, paramContext);
  }
  
  public final boolean arZ()
  {
    return true;
  }
  
  public final void asG()
  {
    this.mView.setVisibility(0);
  }
  
  public final void asH()
  {
    this.mView.setVisibility(4);
  }
  
  public final boolean asd()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return this.mView.isInLayout();
    }
    return this.mInLayout;
  }
  
  public final View getPanelView()
  {
    return this.mView;
  }
  
  public final boolean mQ(int paramInt)
  {
    if ((paramInt > 0) && (this.htS != paramInt))
    {
      this.htS = paramInt;
      return true;
    }
    return false;
  }
  
  public final void onDestroy() {}
  
  public final void setOnTextOperationListener(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.e.a
 * JD-Core Version:    0.7.0.1
 */