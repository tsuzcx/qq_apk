package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;

public abstract class MMPresenterActivity
  extends MMActivity
{
  private c mGc = new c();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mGc.z(getIntent(), this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mGc.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mGc.aFE(3);
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
 * Qualified Name:     com.tencent.mm.kiss.MMPresenterActivity
 * JD-Core Version:    0.7.0.1
 */