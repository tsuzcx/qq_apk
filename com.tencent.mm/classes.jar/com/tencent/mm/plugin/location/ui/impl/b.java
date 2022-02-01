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
import com.tencent.mm.sdk.platformtools.ac;

public abstract class b
  extends a
{
  public Activity activity;
  protected float rYu = 0.0F;
  protected float tmJ = 0.0F;
  protected int type = 0;
  protected com.tencent.mm.plugin.k.d uaq;
  
  public b(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final boolean cXL()
  {
    return false;
  }
  
  public abstract com.tencent.mm.plugin.k.d cXM();
  
  public void cXN() {}
  
  public void cXO() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final View findViewById(int paramInt)
  {
    return this.activity.findViewById(paramInt);
  }
  
  public final void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    this.activity.requestWindowFeature(1);
    this.activity.setContentView(2131495097);
    this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
    ac.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[] { Integer.valueOf(this.type) });
    ((FrameLayout)findViewById(2131302155)).addView(d.fB(this.activity));
    this.uaq = cXM();
    this.uaq.setMapViewOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56000);
        int i = paramAnonymousMotionEvent.getAction();
        ac.i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(56000);
          return false;
          b.this.rYu = paramAnonymousMotionEvent.getX();
          b.this.tmJ = paramAnonymousMotionEvent.getY();
          b.this.cXN();
          continue;
          if ((Math.abs(paramAnonymousMotionEvent.getX() - b.this.rYu) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - b.this.tmJ) > 10.0F)) {
            b.this.cXO();
          }
        }
      }
    });
    this.uaq.setMapAnchor(0.5F, 0.5F);
  }
  
  public void onDestroy()
  {
    this.uaq.destroy();
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b
 * JD-Core Version:    0.7.0.1
 */