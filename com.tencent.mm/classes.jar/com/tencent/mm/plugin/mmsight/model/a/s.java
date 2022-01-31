package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class s
{
  SparseArray<WeakReference<d.b>> mkA = new SparseArray();
  private ah mkB = new s.1(this, Looper.getMainLooper());
  public d.c mkz = d.c.miD;
  
  public final void a(d.c paramc)
  {
    y.i("MicroMsg.SightMediaStatusHandler", "status change to %s", new Object[] { paramc.toString() });
    this.mkz = paramc;
    this.mkB.sendMessage(this.mkB.obtainMessage(257, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s
 * JD-Core Version:    0.7.0.1
 */