package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/util/EarPieceUtil;", "", "()V", "TAG", "", "releaseEarPieceResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestEarPieceResource", "", "plugin-audio_release"})
public final class c
{
  public static final c rKf;
  
  static
  {
    AppMethodBeat.i(257578);
    rKf = new c();
    AppMethodBeat.o(257578);
  }
  
  public static final boolean c(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(257577);
    p.k(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.EarPieceUtil", " request the earpiece resource");
    Integer localInteger;
    if (!paramStack.isEmpty())
    {
      localInteger = (Integer)paramStack.lastElement();
      if (localInteger != null) {
        break label73;
      }
    }
    label73:
    while (localInteger.intValue() != 2)
    {
      if (paramStack.contains(Integer.valueOf(2))) {
        paramStack.removeElement(Integer.valueOf(2));
      }
      paramStack.push(Integer.valueOf(2));
      AppMethodBeat.o(257577);
      return true;
    }
    AppMethodBeat.o(257577);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.c
 * JD-Core Version:    0.7.0.1
 */