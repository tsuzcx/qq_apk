package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class e
{
  public static boolean Ck(int paramInt)
  {
    AppMethodBeat.i(108375);
    if ((fl(paramInt, 4)) || (fl(paramInt, 8)))
    {
      AppMethodBeat.o(108375);
      return true;
    }
    AppMethodBeat.o(108375);
    return false;
  }
  
  public static boolean a(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(108373);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(108373);
      return false;
    }
    boolean bool = fl(paramEmotionSummary.PackFlag, 1);
    AppMethodBeat.o(108373);
    return bool;
  }
  
  public static boolean b(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(108374);
    if ((c(paramEmotionSummary)) || (d(paramEmotionSummary)))
    {
      AppMethodBeat.o(108374);
      return true;
    }
    AppMethodBeat.o(108374);
    return false;
  }
  
  private static boolean c(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(108376);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(108376);
      return false;
    }
    boolean bool = fl(paramEmotionSummary.PackType, 4);
    AppMethodBeat.o(108376);
    return bool;
  }
  
  private static boolean d(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(108377);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(108377);
      return false;
    }
    boolean bool = fl(paramEmotionSummary.PackType, 8);
    AppMethodBeat.o(108377);
    return bool;
  }
  
  public static boolean e(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(108378);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(108378);
      return false;
    }
    boolean bool = fl(paramEmotionSummary.PackFlag, 8);
    AppMethodBeat.o(108378);
    return bool;
  }
  
  public static boolean fl(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.e
 * JD-Core Version:    0.7.0.1
 */