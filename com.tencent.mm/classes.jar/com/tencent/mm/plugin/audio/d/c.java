package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/util/EarPieceUtil;", "", "()V", "TAG", "", "releaseEarPieceResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestEarPieceResource", "", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c uVt;
  
  static
  {
    AppMethodBeat.i(263720);
    uVt = new c();
    AppMethodBeat.o(263720);
  }
  
  public static final boolean c(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(263715);
    s.u(paramStack, "mDeviceQueue");
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
      AppMethodBeat.o(263715);
      return true;
    }
    AppMethodBeat.o(263715);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.c
 * JD-Core Version:    0.7.0.1
 */