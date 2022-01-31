package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;

public abstract class MMPresenterActivity
  extends MMActivity
{
  private c dNd = new c();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dNd.B(getIntent(), this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.dNd.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.dNd.a(3);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.dNd.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kiss.MMPresenterActivity
 * JD-Core Version:    0.7.0.1
 */