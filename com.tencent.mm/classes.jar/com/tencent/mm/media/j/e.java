package com.tencent.mm.media.j;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ai;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/util/VideoConfigUtil;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class e
{
  private static final int gws = 1;
  private static int gwt;
  private static int gwu;
  public static final a gwv;
  
  static
  {
    AppMethodBeat.i(94003);
    gwv = new a((byte)0);
    gws = 1;
    gwt = 2;
    gwu = 3;
    AppMethodBeat.o(94003);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/util/VideoConfigUtil$Companion;", "", "()V", "BASE_LEVEL_BITRATE", "", "getBASE_LEVEL_BITRATE", "()I", "HIGH_LEVEL_BITRATE", "getHIGH_LEVEL_BITRATE", "setHIGH_LEVEL_BITRATE", "(I)V", "LOW_LEVEL_BITRATE", "getLOW_LEVEL_BITRATE", "SUPER_HIGH_LEVEL_BITRATE", "getSUPER_HIGH_LEVEL_BITRATE", "setSUPER_HIGH_LEVEL_BITRATE", "TAG", "", "getCommandBitrate", "width", "mode", "getCommandHeight", "standardVideoParamWithWidth", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static int mC(int paramInt)
    {
      AppMethodBeat.i(94002);
      Point localPoint = ai.cf(aj.getContext());
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