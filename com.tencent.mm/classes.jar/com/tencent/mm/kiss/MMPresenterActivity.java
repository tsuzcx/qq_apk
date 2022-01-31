package com.tencent.mm.kiss;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;

public abstract class MMPresenterActivity
  extends MMActivity
{
  private c eKO = new c();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.eKO.A(getIntent(), this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.eKO.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.eKO.a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    this.eKO.a(2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.MMPresenterActivity
 * JD-Core Version:    0.7.0.1
 */