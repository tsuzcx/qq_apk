package com.tencent.mm.flutter;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.k;

public abstract class b
{
  public k gqZ;
  private Handler handler;
  
  public abstract String agw();
  
  public final void e(final String paramString, final Object paramObject)
  {
    if (this.gqZ != null)
    {
      if (this.handler == null) {
        this.handler = new Handler(Looper.getMainLooper());
      }
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159064);
          b.this.gqZ.a(b.this.agw() + ":" + paramString, paramObject, null);
          AppMethodBeat.o(159064);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.flutter.b
 * JD-Core Version:    0.7.0.1
 */