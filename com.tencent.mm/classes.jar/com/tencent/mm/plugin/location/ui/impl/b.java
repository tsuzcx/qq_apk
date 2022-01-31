package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.sdk.platformtools.y;

public abstract class b
  extends a
{
  public Activity activity;
  protected float hZz = 0.0F;
  protected float kXk = 0.0F;
  protected com.tencent.mm.plugin.p.d lFy;
  protected int type = 0;
  
  public b(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  protected final void XM()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.activity.getSystemService("input_method");
    if (localInputMethodManager == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.activity.getCurrentFocus();
      } while (localObject == null);
      localObject = ((View)localObject).getWindowToken();
    } while (localObject == null);
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
  }
  
  public final boolean beL()
  {
    return false;
  }
  
  public abstract com.tencent.mm.plugin.p.d beM();
  
  public void beN() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
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
  
  public abstract int getLayoutId();
  
  public final String getString(int paramInt)
  {
    return this.activity.getString(paramInt);
  }
  
  public final void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    this.activity.requestWindowFeature(1);
    this.activity.setContentView(getLayoutId());
    this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
    y.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[] { Integer.valueOf(this.type) });
    ((FrameLayout)findViewById(a.e.mapview_content)).addView(d.dH(this.activity));
    this.lFy = beM();
    this.lFy.setMapViewOnTouchListener(new b.1(this));
    this.lFy.setMapAnchor(0.5F, 0.5F);
  }
  
  public void onDestroy()
  {
    this.lFy.destroy();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public final void showVKB()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.activity.getSystemService("input_method");
    if (localInputMethodManager == null) {}
    View localView;
    do
    {
      return;
      localView = this.activity.getCurrentFocus();
    } while ((localView == null) || (localView.getWindowToken() == null));
    localInputMethodManager.toggleSoftInput(0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b
 * JD-Core Version:    0.7.0.1
 */