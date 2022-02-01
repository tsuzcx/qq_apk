package androidx.camera.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends r.a
{
  private final Throwable cause;
  private final int code;
  
  e(int paramInt, Throwable paramThrowable)
  {
    this.code = paramInt;
    this.cause = paramThrowable;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198520);
    if (paramObject == this)
    {
      AppMethodBeat.o(198520);
      return true;
    }
    if ((paramObject instanceof r.a))
    {
      paramObject = (r.a)paramObject;
      if (this.code == paramObject.getCode()) {
        if (this.cause == null)
        {
          if (paramObject.getCause() != null) {}
        }
        else {
          while (this.cause.equals(paramObject.getCause()))
          {
            AppMethodBeat.o(198520);
            return true;
          }
        }
      }
      AppMethodBeat.o(198520);
      return false;
    }
    AppMethodBeat.o(198520);
    return false;
  }
  
  public final Throwable getCause()
  {
    return this.cause;
  }
  
  public final int getCode()
  {
    return this.code;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198526);
    int j = this.code;
    if (this.cause == null) {}
    for (int i = 0;; i = this.cause.hashCode())
    {
      AppMethodBeat.o(198526);
      return i ^ 1000003 * (j ^ 0xF4243);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198513);
    String str = "StateError{code=" + this.code + ", cause=" + this.cause + "}";
    AppMethodBeat.o(198513);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.e
 * JD-Core Version:    0.7.0.1
 */