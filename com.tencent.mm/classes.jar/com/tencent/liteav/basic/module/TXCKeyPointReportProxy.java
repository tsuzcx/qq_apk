package com.tencent.liteav.basic.module;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TXCKeyPointReportProxy
{
  public static final String a;
  
  static
  {
    AppMethodBeat.i(146469);
    a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp/ssoreport.txt";
    AppMethodBeat.o(146469);
  }
  
  public static void a(int paramInt)
  {
    AppMethodBeat.i(146465);
    nativeTagKeyPointStart(paramInt);
    AppMethodBeat.o(146465);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146466);
    nativeTagKeyPointEnd(paramInt1, paramInt2);
    AppMethodBeat.o(146466);
  }
  
  public static void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(146467);
    nativeTagKeyPoint(paramString, paramInt);
    AppMethodBeat.o(146467);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146468);
    nativeSetQuality(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(146468);
  }
  
  private static native void nativeSetQuality(String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeTagKeyPoint(String paramString, int paramInt);
  
  private static native void nativeTagKeyPointEnd(int paramInt1, int paramInt2);
  
  private static native void nativeTagKeyPointStart(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCKeyPointReportProxy
 * JD-Core Version:    0.7.0.1
 */