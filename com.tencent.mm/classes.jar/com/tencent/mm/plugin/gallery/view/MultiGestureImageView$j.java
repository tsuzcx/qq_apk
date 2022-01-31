package com.tencent.mm.plugin.gallery.view;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class MultiGestureImageView$j
  extends ah
{
  WeakReference<MultiGestureImageView> aoA;
  boolean cbg;
  private long kLr;
  
  public MultiGestureImageView$j(WeakReference<MultiGestureImageView> paramWeakReference)
  {
    Object localObject;
    this.aoA = localObject;
  }
  
  public final void h(int paramInt, long paramLong1, long paramLong2)
  {
    this.kLr = paramLong2;
    sendEmptyMessageDelayed(paramInt, paramLong1);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    removeMessages(paramMessage.what);
    MultiGestureImageView localMultiGestureImageView;
    if (this.aoA != null)
    {
      localMultiGestureImageView = (MultiGestureImageView)this.aoA.get();
      if (localMultiGestureImageView != null)
      {
        if (paramMessage.what != 0) {
          break label97;
        }
        if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.cbg))
        {
          y.d("MicroMsg.MuitlGestureImageView", "single click over!");
          if (MultiGestureImageView.b(localMultiGestureImageView) != null) {
            localMultiGestureImageView.getHandler().post(new MultiGestureImageView.j.1(this, localMultiGestureImageView));
          }
        }
        MultiGestureImageView.c(this.kLj);
      }
    }
    label97:
    do
    {
      return;
      if (paramMessage.what == 1)
      {
        if ((MultiGestureImageView.d(this.kLj) != null) && (!MultiGestureImageView.d(this.kLj).aXY()))
        {
          MultiGestureImageView.d(this.kLj).play();
          sendEmptyMessageDelayed(paramMessage.what, this.kLr);
          return;
        }
        MultiGestureImageView.e(localMultiGestureImageView);
        return;
      }
      removeMessages(2);
    } while (MultiGestureImageView.f(localMultiGestureImageView) == null);
    localMultiGestureImageView.getHandler().post(new MultiGestureImageView.j.2(this, localMultiGestureImageView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.j
 * JD-Core Version:    0.7.0.1
 */