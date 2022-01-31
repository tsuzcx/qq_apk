package com.tencent.mm.plugin.gallery.view;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public final class MultiGestureImageView$j
  extends ak
{
  WeakReference<MultiGestureImageView> aqT;
  boolean cJJ;
  private long nhU;
  
  public MultiGestureImageView$j(WeakReference<MultiGestureImageView> paramWeakReference)
  {
    Object localObject;
    this.aqT = localObject;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(21638);
    super.handleMessage(paramMessage);
    removeMessages(paramMessage.what);
    if (this.aqT != null)
    {
      MultiGestureImageView localMultiGestureImageView = (MultiGestureImageView)this.aqT.get();
      if (localMultiGestureImageView != null)
      {
        if (paramMessage.what == 0)
        {
          if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.cJJ))
          {
            ab.d("MicroMsg.MuitlGestureImageView", "single click over!");
            if (MultiGestureImageView.b(localMultiGestureImageView) != null) {
              localMultiGestureImageView.getHandler().post(new MultiGestureImageView.j.1(this, localMultiGestureImageView));
            }
          }
          MultiGestureImageView.c(this.nhM);
          AppMethodBeat.o(21638);
          return;
        }
        if (paramMessage.what == 1)
        {
          if ((MultiGestureImageView.d(this.nhM) != null) && (!MultiGestureImageView.d(this.nhM).bEL()))
          {
            MultiGestureImageView.d(this.nhM).play();
            sendEmptyMessageDelayed(paramMessage.what, this.nhU);
            AppMethodBeat.o(21638);
            return;
          }
          MultiGestureImageView.e(localMultiGestureImageView);
          AppMethodBeat.o(21638);
          return;
        }
        removeMessages(2);
        if (MultiGestureImageView.f(localMultiGestureImageView) != null) {
          localMultiGestureImageView.getHandler().post(new MultiGestureImageView.j.2(this, localMultiGestureImageView));
        }
      }
    }
    AppMethodBeat.o(21638);
  }
  
  public final void j(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21639);
    this.nhU = paramLong2;
    sendEmptyMessageDelayed(paramInt, paramLong1);
    AppMethodBeat.o(21639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.j
 * JD-Core Version:    0.7.0.1
 */