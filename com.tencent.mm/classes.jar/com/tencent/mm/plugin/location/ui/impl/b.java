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
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.q.a;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class b
  extends a
{
  protected com.tencent.mm.plugin.q.d EmT;
  protected float aCa = 0.0F;
  protected float aCb = 0.0F;
  public Activity activity;
  protected int type = 0;
  
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
  
  public final boolean eNc()
  {
    return false;
  }
  
  public abstract com.tencent.mm.plugin.q.d eNd();
  
  public void eNe() {}
  
  public void eNf() {}
  
  public final View findViewById(int paramInt)
  {
    return this.activity.findViewById(paramInt);
  }
  
  public abstract int getLayoutId();
  
  public final void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    this.activity.setContentView(getLayoutId());
    this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
    Log.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[] { Integer.valueOf(this.type) });
    ((FrameLayout)findViewById(a.e.mapview_content)).addView(d.hq(this.activity));
    this.EmT = eNd();
    this.EmT.setMapViewOnTouchListener(new View.OnTouchListener()
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
          b.this.aCa = paramAnonymousMotionEvent.getX();
          b.this.aCb = paramAnonymousMotionEvent.getY();
          b.this.eNe();
          continue;
          if ((Math.abs(paramAnonymousMotionEvent.getX() - b.this.aCa) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - b.this.aCb) > 10.0F)) {
            b.this.eNf();
          }
        }
      }
    });
    this.EmT.setMapAnchor(0.5F, 0.5F);
  }
  
  public void onDestroy()
  {
    this.EmT.destroy();
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b
 * JD-Core Version:    0.7.0.1
 */