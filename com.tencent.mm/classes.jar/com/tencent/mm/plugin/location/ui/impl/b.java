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
import com.tencent.mm.sdk.platformtools.ae;

public abstract class b
  extends com.tencent.mm.plugin.k.a
{
  protected float aTL = 0.0F;
  protected float aTM = 0.0F;
  public Activity activity;
  protected int type = 0;
  protected com.tencent.mm.plugin.k.d vpk;
  
  public b(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ae.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean djW()
  {
    return false;
  }
  
  public abstract com.tencent.mm.plugin.k.d djX();
  
  public void djY() {}
  
  public void djZ() {}
  
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
    ae.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[] { Integer.valueOf(this.type) });
    ((FrameLayout)findViewById(2131302155)).addView(d.fM(this.activity));
    this.vpk = djX();
    this.vpk.setMapViewOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56000);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/MMBaseMapUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        int i = paramAnonymousMotionEvent.getAction();
        ae.i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/MMBaseMapUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(56000);
          return false;
          b.this.aTL = paramAnonymousMotionEvent.getX();
          b.this.aTM = paramAnonymousMotionEvent.getY();
          b.this.djY();
          continue;
          if ((Math.abs(paramAnonymousMotionEvent.getX() - b.this.aTL) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - b.this.aTM) > 10.0F)) {
            b.this.djZ();
          }
        }
      }
    });
    this.vpk.setMapAnchor(0.5F, 0.5F);
  }
  
  public void onDestroy()
  {
    this.vpk.destroy();
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b
 * JD-Core Version:    0.7.0.1
 */