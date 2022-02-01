package com.tencent.liteav.basic.opengl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class d
  extends IOException
{
  private static final long serialVersionUID = 2723743254380545567L;
  private final int mErrorCode;
  private final String mErrorMessage;
  
  public d(int paramInt)
  {
    this(paramInt, null);
  }
  
  public d(int paramInt, String paramString)
  {
    this.mErrorCode = paramInt;
    this.mErrorMessage = paramString;
  }
  
  public String getMessage()
  {
    AppMethodBeat.i(230202);
    if (this.mErrorMessage != null)
    {
      str = "EGL error code: " + this.mErrorCode + this.mErrorMessage;
      AppMethodBeat.o(230202);
      return str;
    }
    String str = "EGL error code: " + this.mErrorCode;
    AppMethodBeat.o(230202);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.d
 * JD-Core Version:    0.7.0.1
 */