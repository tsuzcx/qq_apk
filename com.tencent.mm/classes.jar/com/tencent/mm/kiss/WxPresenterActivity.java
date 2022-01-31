package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;

public abstract class WxPresenterActivity
  extends MMActivity
{
  protected c dNd = new c();
  
  public final com.tencent.mm.vending.app.a EB()
  {
    return this.dNd.EB();
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.dNd.keep(parama);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dNd.B(getIntent(), this);
  }
  
  public void onDestroy()
  {
    this.dNd.onDestroy();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.dNd.a(3);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.dNd.a(2);
  }
  
  public final <T extends b<? extends com.tencent.mm.vending.app.a>> T z(Class<? extends b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.dNd.a(this, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kiss.WxPresenterActivity
 * JD-Core Version:    0.7.0.1
 */