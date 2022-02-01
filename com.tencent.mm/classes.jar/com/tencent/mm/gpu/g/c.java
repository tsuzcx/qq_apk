package com.tencent.mm.gpu.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class c
{
  public static int aET()
  {
    AppMethodBeat.i(210790);
    try
    {
      int i = Integer.parseInt(new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/self/oom_score")))).readLine());
      AppMethodBeat.o(210790);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      AppMethodBeat.o(210790);
      return -4398;
    }
    catch (IOException localIOException)
    {
      label50:
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.gpu.g.c
 * JD-Core Version:    0.7.0.1
 */