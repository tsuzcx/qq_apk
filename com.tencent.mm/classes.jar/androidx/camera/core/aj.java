package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.a.g.a;
import androidx.camera.core.impl.bi;

abstract class aj
  implements af
{
  public static af a(bi parambi, long paramLong, int paramInt, Matrix paramMatrix)
  {
    return new f(parambi, paramLong, paramInt, paramMatrix);
  }
  
  public final void a(g.a parama)
  {
    parama.be(iB());
  }
  
  public abstract long getTimestamp();
  
  public abstract bi go();
  
  public abstract int iB();
  
  public abstract Matrix iC();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.aj
 * JD-Core Version:    0.7.0.1
 */