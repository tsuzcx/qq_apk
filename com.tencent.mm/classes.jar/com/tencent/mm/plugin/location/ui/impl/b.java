package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class b
  extends a
{
  protected float aTD = 0.0F;
  protected float aTE = 0.0F;
  public Activity activity;
  protected int type = 0;
  protected com.tencent.mm.plugin.k.d yJa;
  
  public b(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean edH()
  {
    return false;
  }
  
  public abstract com.tencent.mm.plugin.k.d edI();
  
  public void edJ() {}
  
  public void edK() {}
  
  public final View findViewById(int paramInt)
  {
    return this.activity.findViewById(paramInt);
  }
  
  public final void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    this.activity.setContentView(2131495937);
    this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
    Log.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[] { Integer.valueOf(this.type) });
    ((FrameLayout)findViewById(2131304494)).addView(d.gs(this.activity));
    this.yJa = edI();
    this.yJa.setMapViewOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56000);
        int i = paramAnonymousMotionEvent.getAction();
        Log.i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(56000);
          return false;
          b.this.aTD = paramAnonymousMotionEvent.getX();
          b.this.aTE = paramAnonymousMotionEvent.getY();
          b.this.edJ();
          continue;
          if ((Math.abs(paramAnonymousMotionEvent.getX() - b.this.aTD) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - b.this.aTE) > 10.0F)) {
            b.this.edK();
          }
        }
      }
    });
    this.yJa.setMapAnchor(0.5F, 0.5F);
  }
  
  public void onDestroy()
  {
    this.yJa.destroy();
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b
 * JD-Core Version:    0.7.0.1
 */