package com.tencent.mm.media.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.media.util.a.a;

public class VideoColorSpaceDetectorApi
  extends f
  implements a
{
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public String getVideoColorSpaceJson(String paramString)
  {
    AppMethodBeat.i(236918);
    g localg = g.nFH;
    paramString = g.GU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(236918);
      return null;
    }
    paramString = paramString.toString();
    AppMethodBeat.o(236918);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.util.VideoColorSpaceDetectorApi
 * JD-Core Version:    0.7.0.1
 */