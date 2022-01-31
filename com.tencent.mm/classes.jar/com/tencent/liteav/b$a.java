package com.tencent.liteav;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.liteav.capturer.a;
import com.tencent.rtmp.ui.TXCloudVideoView;

class b$a
  implements Runnable
{
  private View b;
  private MotionEvent c;
  
  private b$a(b paramb) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.c = paramMotionEvent;
  }
  
  public void a(View paramView)
  {
    this.b = paramView;
  }
  
  public void run()
  {
    if ((b.e(this.a) != null) && (b.b(this.a).D)) {
      b.e(this.a).a(this.c.getX() / this.b.getWidth(), this.c.getY() / this.b.getHeight());
    }
    if ((b.g(this.a) != null) && (b.b(this.a).D)) {
      b.g(this.a).onTouchFocus((int)this.c.getX(), (int)this.c.getY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.b.a
 * JD-Core Version:    0.7.0.1
 */