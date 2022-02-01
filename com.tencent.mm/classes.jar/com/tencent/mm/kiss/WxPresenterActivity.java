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
  protected c gfW = new c();
  
  public final com.tencent.mm.vending.app.a agy()
  {
    return this.gfW.agy();
  }
  
  public final <T extends b<? extends com.tencent.mm.vending.app.a>> T am(Class<? extends b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.gfW.a(this, paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.gfW.keep(parama);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.gfW.B(getIntent(), this);
  }
  
  public void onDestroy()
  {
    this.gfW.onDestroy();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.gfW.abd(3);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.gfW.abd(2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.WxPresenterActivity
 * JD-Core Version:    0.7.0.1
 */