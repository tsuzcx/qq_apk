package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.cd.e;
import com.tencent.mm.sdk.platformtools.ae;

public class c
{
  boolean hxQ = false;
  b hxS;
  f hxT;
  int hxU;
  int hxV;
  Context hxz;
  
  public static int[] api()
  {
    Display localDisplay = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay();
    return new int[] { localDisplay.getWidth(), localDisplay.getHeight() };
  }
  
  public final a asJ()
  {
    if (this.hxS == null)
    {
      this.hxS = new b();
      this.hxS.hxz = this.hxz;
      this.hxS.setPanelManager(this);
    }
    return this.hxS;
  }
  
  public e asu()
  {
    return e.csH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.c
 * JD-Core Version:    0.7.0.1
 */