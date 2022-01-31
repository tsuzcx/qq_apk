package com.tencent.mm.plugin.facedetect.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class a$b
  extends CountDownTimer
{
  int eSO = 0;
  WeakReference<TextView> mlc = null;
  WeakReference<TextView> mld = null;
  String mle = null;
  int mlf = 0;
  
  public a$b()
  {
    super(9223372036854775807L, 500L);
  }
  
  public final void onFinish() {}
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(385);
    if ((this.mlc != null) && (this.mlc.get() != null) && (this.mld != null) && (this.mld.get() != null))
    {
      TextView localTextView1 = (TextView)this.mlc.get();
      TextView localTextView2 = (TextView)this.mld.get();
      localTextView1.setText(this.mle.substring(0, this.mlf));
      localTextView2.setText(this.mle.substring(this.mlf, this.mlf + this.eSO % (this.mle.length() - this.mlf + 1)));
    }
    for (;;)
    {
      this.eSO += 1;
      AppMethodBeat.o(385);
      return;
      ab.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a.b
 * JD-Core Version:    0.7.0.1
 */