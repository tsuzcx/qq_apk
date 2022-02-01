package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

class WXHardCoderJNI$3
  implements c.d
{
  public void sceneReport(int paramInt, long paramLong)
  {
    AppMethodBeat.i(155949);
    if (WXHardCoderJNI.access$000())
    {
      AppMethodBeat.o(155949);
      return;
    }
    Integer localInteger = (Integer)WXHardCoderJNI.SCENE_ID_MAP.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(155949);
      return;
    }
    WXHardCoderJNI.access$100(new j(localInteger.intValue()));
    AppMethodBeat.o(155949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.WXHardCoderJNI.3
 * JD-Core Version:    0.7.0.1
 */