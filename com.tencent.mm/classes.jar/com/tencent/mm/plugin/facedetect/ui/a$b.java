package com.tencent.mm.plugin.facedetect.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class a$b
  extends CountDownTimer
{
  WeakReference<TextView> jQH = null;
  WeakReference<TextView> jQI = null;
  String jQJ = null;
  int jQK = 0;
  int jQL = 0;
  
  public a$b()
  {
    super(9223372036854775807L, 500L);
  }
  
  public final void onFinish() {}
  
  public final void onTick(long paramLong)
  {
    if ((this.jQH != null) && (this.jQH.get() != null) && (this.jQI != null) && (this.jQI.get() != null))
    {
      TextView localTextView1 = (TextView)this.jQH.get();
      TextView localTextView2 = (TextView)this.jQI.get();
      localTextView1.setText(this.jQJ.substring(0, this.jQK));
      localTextView2.setText(this.jQJ.substring(this.jQK, this.jQK + this.jQL % (this.jQJ.length() - this.jQK + 1)));
    }
    for (;;)
    {
      this.jQL += 1;
      return;
      y.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a.b
 * JD-Core Version:    0.7.0.1
 */