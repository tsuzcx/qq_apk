package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;

public abstract class WxPresenterActivity
  extends MMActivity
{
  protected c mGc = new c();
  
  public final <T extends b<? extends com.tencent.mm.vending.app.a>> T aI(Class<? extends b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.mGc.a(this, paramClass);
  }
  
  public final com.tencent.mm.vending.app.a bbE()
  {
    return this.mGc.bbE();
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.mGc.keep(parama);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mGc.z(getIntent(), this);
  }
  
  public void onDestroy()
  {
    this.mGc.onDestroy();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.mGc.aFE(3);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mGc.aFE(2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kiss.WxPresenterActivity
 * JD-Core Version:    0.7.0.1
 */