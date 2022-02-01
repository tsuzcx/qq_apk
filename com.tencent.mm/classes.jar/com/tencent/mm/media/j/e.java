package com.tencent.mm.media.j;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/util/VideoConfigUtil;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class e
{
  private static final int gWP = 1;
  private static int gWQ;
  private static int gWR;
  public static final a gWS;
  
  static
  {
    AppMethodBeat.i(94003);
    gWS = new a((byte)0);
    gWP = 1;
    gWQ = 2;
    gWR = 3;
    AppMethodBeat.o(94003);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/util/VideoConfigUtil$Companion;", "", "()V", "BASE_LEVEL_BITRATE", "", "getBASE_LEVEL_BITRATE", "()I", "HIGH_LEVEL_BITRATE", "getHIGH_LEVEL_BITRATE", "setHIGH_LEVEL_BITRATE", "(I)V", "LOW_LEVEL_BITRATE", "getLOW_LEVEL_BITRATE", "SUPER_HIGH_LEVEL_BITRATE", "getSUPER_HIGH_LEVEL_BITRATE", "setSUPER_HIGH_LEVEL_BITRATE", "TAG", "", "getCommandBitrate", "width", "mode", "getCommandHeight", "standardVideoParamWithWidth", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static int nq(int paramInt)
    {
      AppMethodBeat.i(94002);
      Point localPoint = aj.cl(ai.getContext());
      paramInt = localPoint.y * paramInt / localPoint.x;
      AppMethodBeat.o(94002);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.e
 * JD-Core Version:    0.7.0.1
 */