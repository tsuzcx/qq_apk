package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

final class s$1
  extends ah
{
  s$1(s params, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (257 == paramMessage.what)
    {
      paramMessage = (d.c)paramMessage.obj;
      int i = 0;
      while (i < this.mkC.mkA.size())
      {
        if ((d.b)((WeakReference)this.mkC.mkA.valueAt(i)).get() != null)
        {
          int[] arrayOfInt = s.2.mkD;
          paramMessage.ordinal();
        }
        i += 1;
      }
    }
    if (258 == paramMessage.what)
    {
      paramMessage = (d.b)paramMessage.obj;
      if (paramMessage != null) {}
    }
    do
    {
      do
      {
        return;
        this.mkC.mkA.put(paramMessage.hashCode(), new WeakReference(paramMessage));
        return;
      } while (259 != paramMessage.what);
      paramMessage = (d.b)paramMessage.obj;
    } while (paramMessage == null);
    this.mkC.mkA.remove(paramMessage.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s.1
 * JD-Core Version:    0.7.0.1
 */