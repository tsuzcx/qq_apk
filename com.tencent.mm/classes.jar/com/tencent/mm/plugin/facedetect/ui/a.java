package com.tencent.mm.plugin.facedetect.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class a
{
  static a zVD;
  
  static
  {
    AppMethodBeat.i(103917);
    zVD = new a();
    AppMethodBeat.o(103917);
  }
  
  public static final class a
    extends CountDownTimer
  {
    private WeakReference<TextView> zVE = null;
    private WeakReference<TextView> zVF = null;
    private String zVG = null;
    private int zVH = 0;
    int zVI = 0;
    
    public a()
    {
      super(500L);
    }
    
    public final void onFinish() {}
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(103904);
      if ((this.zVE != null) && (this.zVE.get() != null) && (this.zVF != null) && (this.zVF.get() != null))
      {
        TextView localTextView1 = (TextView)this.zVE.get();
        TextView localTextView2 = (TextView)this.zVF.get();
        localTextView1.setText(this.zVG.substring(0, this.zVH));
        localTextView2.setText(this.zVG.substring(this.zVH, this.zVH + this.zVI % (this.zVG.length() - this.zVH + 1)));
      }
      for (;;)
      {
        this.zVI += 1;
        AppMethodBeat.o(103904);
        return;
        Log.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
        cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a
 * JD-Core Version:    0.7.0.1
 */