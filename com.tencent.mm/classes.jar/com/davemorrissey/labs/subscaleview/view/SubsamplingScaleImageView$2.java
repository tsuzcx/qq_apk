package com.davemorrissey.labs.subscaleview.view;

import android.os.Handler.Callback;
import android.os.Message;

final class SubsamplingScaleImageView$2
  implements Handler.Callback
{
  SubsamplingScaleImageView$2(SubsamplingScaleImageView paramSubsamplingScaleImageView) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (SubsamplingScaleImageView.b(this.aqZ) != null))
    {
      SubsamplingScaleImageView.c(this.aqZ);
      SubsamplingScaleImageView.a(this.aqZ, SubsamplingScaleImageView.b(this.aqZ));
      this.aqZ.performLongClick();
      SubsamplingScaleImageView.d(this.aqZ);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.2
 * JD-Core Version:    0.7.0.1
 */