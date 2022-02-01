package com.tencent.mm.plugin.facedetect.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class a$a
  extends CountDownTimer
{
  private int sTA = 0;
  int sTB = 0;
  private WeakReference<TextView> sTx = null;
  private WeakReference<TextView> sTy = null;
  private String sTz = null;
  
  public a$a()
  {
    super(9223372036854775807L, 500L);
  }
  
  public final void onFinish() {}
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(103904);
    if ((this.sTx != null) && (this.sTx.get() != null) && (this.sTy != null) && (this.sTy.get() != null))
    {
      TextView localTextView1 = (TextView)this.sTx.get();
      TextView localTextView2 = (TextView)this.sTy.get();
      localTextView1.setText(this.sTz.substring(0, this.sTA));
      localTextView2.setText(this.sTz.substring(this.sTA, this.sTA + this.sTB % (this.sTz.length() - this.sTA + 1)));
    }
    for (;;)
    {
      this.sTB += 1;
      AppMethodBeat.o(103904);
      return;
      Log.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a.a
 * JD-Core Version:    0.7.0.1
 */