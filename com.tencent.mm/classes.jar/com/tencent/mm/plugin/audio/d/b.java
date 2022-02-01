package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Stack;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/util/EarPieceUtil;", "", "()V", "TAG", "", "releaseEarPieceResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestEarPieceResource", "", "plugin-audio_release"})
public final class b
{
  public static final b nxs;
  
  static
  {
    AppMethodBeat.i(201117);
    nxs = new b();
    AppMethodBeat.o(201117);
  }
  
  public static final boolean c(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(201116);
    p.h(paramStack, "mDeviceQueue");
    ae.i("MicroMsg.EarPieceUtil", " request the earpiece resource");
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
      AppMethodBeat.o(201116);
      return true;
    }
    AppMethodBeat.o(201116);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.b
 * JD-Core Version:    0.7.0.1
 */