package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.bi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
  extends aj
{
  private final bi Gi;
  private final int Gj;
  private final Matrix Gk;
  private final long timestamp;
  
  f(bi parambi, long paramLong, int paramInt, Matrix paramMatrix)
  {
    AppMethodBeat.i(198484);
    if (parambi == null)
    {
      parambi = new NullPointerException("Null tagBundle");
      AppMethodBeat.o(198484);
      throw parambi;
    }
    this.Gi = parambi;
    this.timestamp = paramLong;
    this.Gj = paramInt;
    if (paramMatrix == null)
    {
      parambi = new NullPointerException("Null sensorToBufferTransformMatrix");
      AppMethodBeat.o(198484);
      throw parambi;
    }
    this.Gk = paramMatrix;
    AppMethodBeat.o(198484);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198514);
    if (paramObject == this)
    {
      AppMethodBeat.o(198514);
      return true;
    }
    if ((paramObject instanceof aj))
    {
      paramObject = (aj)paramObject;
      if ((this.Gi.equals(paramObject.go())) && (this.timestamp == paramObject.getTimestamp()) && (this.Gj == paramObject.iB()) && (this.Gk.equals(paramObject.iC())))
      {
        AppMethodBeat.o(198514);
        return true;
      }
      AppMethodBeat.o(198514);
      return false;
    }
    AppMethodBeat.o(198514);
    return false;
  }
  
  public final long getTimestamp()
  {
    return this.timestamp;
  }
  
  public final bi go()
  {
    return this.Gi;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198521);
    int i = this.Gi.hashCode();
    int j = (int)(this.timestamp >>> 32 ^ this.timestamp);
    int k = this.Gj;
    int m = this.Gk.hashCode();
    AppMethodBeat.o(198521);
    return (((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m;
  }
  
  public final int iB()
  {
    return this.Gj;
  }
  
  public final Matrix iC()
  {
    return this.Gk;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198510);
    String str = "ImmutableImageInfo{tagBundle=" + this.Gi + ", timestamp=" + this.timestamp + ", rotationDegrees=" + this.Gj + ", sensorToBufferTransformMatrix=" + this.Gk + "}";
    AppMethodBeat.o(198510);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.f
 * JD-Core Version:    0.7.0.1
 */