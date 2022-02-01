package com.tencent.mm.media.k;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/util/VideoConfigUtil;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class e
{
  private static final int hoV = 1;
  private static int hoW;
  private static int hoX;
  public static final a hoY;
  
  static
  {
    AppMethodBeat.i(94003);
    hoY = new a((byte)0);
    hoV = 1;
    hoW = 2;
    hoX = 3;
    AppMethodBeat.o(94003);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/util/VideoConfigUtil$Companion;", "", "()V", "BASE_LEVEL_BITRATE", "", "getBASE_LEVEL_BITRATE", "()I", "HIGH_LEVEL_BITRATE", "getHIGH_LEVEL_BITRATE", "setHIGH_LEVEL_BITRATE", "(I)V", "LOW_LEVEL_BITRATE", "getLOW_LEVEL_BITRATE", "SUPER_HIGH_LEVEL_BITRATE", "getSUPER_HIGH_LEVEL_BITRATE", "setSUPER_HIGH_LEVEL_BITRATE", "TAG", "", "getCommandBitrate", "width", "mode", "getCommandHeight", "standardVideoParamWithWidth", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static int nP(int paramInt)
    {
      AppMethodBeat.i(94002);
      Point localPoint = al.ci(aj.getContext());
      paramInt = localPoint.y * paramInt / localPoint.x;
      AppMethodBeat.o(94002);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.k.e
 * JD-Core Version:    0.7.0.1
 */