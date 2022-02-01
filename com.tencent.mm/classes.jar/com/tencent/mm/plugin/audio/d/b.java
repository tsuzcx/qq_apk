package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Stack;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/util/EarPieceUtil;", "", "()V", "TAG", "", "releaseEarPieceResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestEarPieceResource", "", "plugin-audio_release"})
public final class b
{
  public static final b nrZ;
  
  static
  {
    AppMethodBeat.i(199805);
    nrZ = new b();
    AppMethodBeat.o(199805);
  }
  
  public static final boolean c(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(199804);
    p.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.EarPieceUtil", " request the earpiece resource");
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
      AppMethodBeat.o(199804);
      return true;
    }
    AppMethodBeat.o(199804);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.b
 * JD-Core Version:    0.7.0.1
 */