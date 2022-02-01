package com.tencent.mm.media.k;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/util/VideoConfigUtil;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class e
{
  private static final int hrJ = 1;
  private static int hrK;
  private static int hrL;
  public static final a hrM;
  
  static
  {
    AppMethodBeat.i(94003);
    hrM = new a((byte)0);
    hrJ = 1;
    hrK = 2;
    hrL = 3;
    AppMethodBeat.o(94003);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/util/VideoConfigUtil$Companion;", "", "()V", "BASE_LEVEL_BITRATE", "", "getBASE_LEVEL_BITRATE", "()I", "HIGH_LEVEL_BITRATE", "getHIGH_LEVEL_BITRATE", "setHIGH_LEVEL_BITRATE", "(I)V", "LOW_LEVEL_BITRATE", "getLOW_LEVEL_BITRATE", "SUPER_HIGH_LEVEL_BITRATE", "getSUPER_HIGH_LEVEL_BITRATE", "setSUPER_HIGH_LEVEL_BITRATE", "TAG", "", "getCommandBitrate", "width", "mode", "getCommandHeight", "standardVideoParamWithWidth", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static int nS(int paramInt)
    {
      AppMethodBeat.i(94002);
      Point localPoint = al.ck(ak.getContext());
      paramInt = localPoint.y * paramInt / localPoint.x;
      AppMethodBeat.o(94002);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.k.e
 * JD-Core Version:    0.7.0.1
 */