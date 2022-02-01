package androidx.camera.core.impl;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class a
  extends w
{
  private final Executor Kw;
  private final Handler Kx;
  
  public a(Executor paramExecutor, Handler paramHandler)
  {
    AppMethodBeat.i(198736);
    if (paramExecutor == null)
    {
      paramExecutor = new NullPointerException("Null cameraExecutor");
      AppMethodBeat.o(198736);
      throw paramExecutor;
    }
    this.Kw = paramExecutor;
    if (paramHandler == null)
    {
      paramExecutor = new NullPointerException("Null schedulerHandler");
      AppMethodBeat.o(198736);
      throw paramExecutor;
    }
    this.Kx = paramHandler;
    AppMethodBeat.o(198736);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198762);
    if (paramObject == this)
    {
      AppMethodBeat.o(198762);
      return true;
    }
    if ((paramObject instanceof w))
    {
      paramObject = (w)paramObject;
      if ((this.Kw.equals(paramObject.jK())) && (this.Kx.equals(paramObject.jL())))
      {
        AppMethodBeat.o(198762);
        return true;
      }
      AppMethodBeat.o(198762);
      return false;
    }
    AppMethodBeat.o(198762);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198770);
    int i = this.Kw.hashCode();
    int j = this.Kx.hashCode();
    AppMethodBeat.o(198770);
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public final Executor jK()
  {
    return this.Kw;
  }
  
  public final Handler jL()
  {
    return this.Kx;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198754);
    String str = "CameraThreadConfig{cameraExecutor=" + this.Kw + ", schedulerHandler=" + this.Kx + "}";
    AppMethodBeat.o(198754);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a
 * JD-Core Version:    0.7.0.1
 */