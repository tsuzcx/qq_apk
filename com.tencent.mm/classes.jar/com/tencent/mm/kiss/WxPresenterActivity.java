package com.tencent.mm.kiss;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;

public abstract class WxPresenterActivity
  extends MMActivity
{
  protected c htH = new c();
  
  public final com.tencent.mm.vending.app.a aBf()
  {
    return this.htH.aBf();
  }
  
  public final <T extends b<? extends com.tencent.mm.vending.app.a>> T aq(Class<? extends b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.htH.a(this, paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.htH.keep(parama);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.htH.A(getIntent(), this);
  }
  
  public void onDestroy()
  {
    this.htH.onDestroy();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.htH.apB(3);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.htH.apB(2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.WxPresenterActivity
 * JD-Core Version:    0.7.0.1
 */