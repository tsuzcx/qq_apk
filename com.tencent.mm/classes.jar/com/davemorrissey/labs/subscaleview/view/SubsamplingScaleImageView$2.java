package com.davemorrissey.labs.subscaleview.view;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SubsamplingScaleImageView$2
  implements Handler.Callback
{
  SubsamplingScaleImageView$2(SubsamplingScaleImageView paramSubsamplingScaleImageView) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(115640);
    if ((paramMessage.what == 1) && (SubsamplingScaleImageView.b(this.ats) != null))
    {
      SubsamplingScaleImageView.c(this.ats);
      SubsamplingScaleImageView.a(this.ats, SubsamplingScaleImageView.b(this.ats));
      this.ats.performLongClick();
      SubsamplingScaleImageView.d(this.ats);
    }
    AppMethodBeat.o(115640);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.2
 * JD-Core Version:    0.7.0.1
 */