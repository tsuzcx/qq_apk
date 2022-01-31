package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class e
{
  public static boolean a(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(52797);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(52797);
      return false;
    }
    boolean bool = ea(paramEmotionSummary.PackFlag, 1);
    AppMethodBeat.o(52797);
    return bool;
  }
  
  public static boolean b(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(52798);
    if ((c(paramEmotionSummary)) || (d(paramEmotionSummary)))
    {
      AppMethodBeat.o(52798);
      return true;
    }
    AppMethodBeat.o(52798);
    return false;
  }
  
  private static boolean c(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(52800);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(52800);
      return false;
    }
    boolean bool = ea(paramEmotionSummary.PackType, 4);
    AppMethodBeat.o(52800);
    return bool;
  }
  
  private static boolean d(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(52801);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(52801);
      return false;
    }
    boolean bool = ea(paramEmotionSummary.PackType, 8);
    AppMethodBeat.o(52801);
    return bool;
  }
  
  public static boolean e(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(52802);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(52802);
      return false;
    }
    boolean bool = ea(paramEmotionSummary.PackFlag, 8);
    AppMethodBeat.o(52802);
    return bool;
  }
  
  public static boolean ea(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  public static boolean uo(int paramInt)
  {
    AppMethodBeat.i(52799);
    if ((ea(paramInt, 4)) || (ea(paramInt, 8)))
    {
      AppMethodBeat.o(52799);
      return true;
    }
    AppMethodBeat.o(52799);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.e
 * JD-Core Version:    0.7.0.1
 */