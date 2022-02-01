package com.tencent.mm.gpu.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class b
{
  public static int ahl()
  {
    AppMethodBeat.i(209682);
    try
    {
      int i = Integer.parseInt(new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/self/oom_score")))).readLine());
      AppMethodBeat.o(209682);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      AppMethodBeat.o(209682);
      return -4398;
    }
    catch (IOException localIOException)
    {
      label50:
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.gpu.f.b
 * JD-Core Version:    0.7.0.1
 */