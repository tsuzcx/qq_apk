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
  protected c kfE = new c();
  
  public final com.tencent.mm.vending.app.a aII()
  {
    return this.kfE.aII();
  }
  
  public final <T extends b<? extends com.tencent.mm.vending.app.a>> T ap(Class<? extends b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.kfE.a(this, paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.kfE.keep(parama);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kfE.z(getIntent(), this);
  }
  
  public void onDestroy()
  {
    this.kfE.onDestroy();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.kfE.ayZ(3);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.kfE.ayZ(2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kiss.WxPresenterActivity
 * JD-Core Version:    0.7.0.1
 */