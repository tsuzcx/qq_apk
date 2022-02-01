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
import com.tencent.mm.sdk.platformtools.ad;

public abstract class b
  extends a
{
  public Activity activity;
  protected float qXK = 0.0F;
  protected com.tencent.mm.plugin.k.d sSd;
  protected float seQ = 0.0F;
  protected int type = 0;
  
  public b(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final boolean cKg()
  {
    return false;
  }
  
  public abstract com.tencent.mm.plugin.k.d cKh();
  
  public void cKi() {}
  
  public void cKj() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
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
    ad.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[] { Integer.valueOf(this.type) });
    ((FrameLayout)findViewById(2131302155)).addView(d.fp(this.activity));
    this.sSd = cKh();
    this.sSd.setMapViewOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56000);
        int i = paramAnonymousMotionEvent.getAction();
        ad.i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(56000);
          return false;
          b.this.qXK = paramAnonymousMotionEvent.getX();
          b.this.seQ = paramAnonymousMotionEvent.getY();
          b.this.cKi();
          continue;
          if ((Math.abs(paramAnonymousMotionEvent.getX() - b.this.qXK) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - b.this.seQ) > 10.0F)) {
            b.this.cKj();
          }
        }
      }
    });
    this.sSd.setMapAnchor(0.5F, 0.5F);
  }
  
  public void onDestroy()
  {
    this.sSd.destroy();
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b
 * JD-Core Version:    0.7.0.1
 */