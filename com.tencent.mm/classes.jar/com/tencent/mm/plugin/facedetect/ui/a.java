package com.tencent.mm.plugin.facedetect.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class a
{
  static a wzs;
  
  static
  {
    AppMethodBeat.i(103917);
    wzs = new a();
    AppMethodBeat.o(103917);
  }
  
  public static final class a
    extends CountDownTimer
  {
    private WeakReference<TextView> wzt = null;
    private WeakReference<TextView> wzu = null;
    private String wzv = null;
    private int wzw = 0;
    int wzx = 0;
    
    public a()
    {
      super(500L);
    }
    
    public final void onFinish() {}
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(103904);
      if ((this.wzt != null) && (this.wzt.get() != null) && (this.wzu != null) && (this.wzu.get() != null))
      {
        TextView localTextView1 = (TextView)this.wzt.get();
        TextView localTextView2 = (TextView)this.wzu.get();
        localTextView1.setText(this.wzv.substring(0, this.wzw));
        localTextView2.setText(this.wzv.substring(this.wzw, this.wzw + this.wzx % (this.wzv.length() - this.wzw + 1)));
      }
      for (;;)
      {
        this.wzx += 1;
        AppMethodBeat.o(103904);
        return;
        Log.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
        cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a
 * JD-Core Version:    0.7.0.1
 */