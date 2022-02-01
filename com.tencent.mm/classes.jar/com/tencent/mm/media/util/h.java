package com.tencent.mm.media.util;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/VideoConfigUtil;", "", "()V", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final a nFI;
  private static final int nFJ;
  private static int nFK;
  private static int nFL;
  
  static
  {
    AppMethodBeat.i(94003);
    nFI = new a((byte)0);
    nFJ = 1;
    nFK = 2;
    nFL = 3;
    AppMethodBeat.o(94003);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/VideoConfigUtil$Companion;", "", "()V", "BASE_LEVEL_BITRATE", "", "getBASE_LEVEL_BITRATE", "()I", "HIGH_LEVEL_BITRATE", "getHIGH_LEVEL_BITRATE", "setHIGH_LEVEL_BITRATE", "(I)V", "LOW_LEVEL_BITRATE", "getLOW_LEVEL_BITRATE", "SUPER_HIGH_LEVEL_BITRATE", "getSUPER_HIGH_LEVEL_BITRATE", "setSUPER_HIGH_LEVEL_BITRATE", "TAG", "", "getCommandBitrate", "width", "mode", "getCommandHeight", "standardVideoParamWithWidth", "", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int uf(int paramInt)
    {
      AppMethodBeat.i(94002);
      Point localPoint = aw.bf(MMApplicationContext.getContext());
      paramInt = localPoint.y * paramInt / localPoint.x;
      AppMethodBeat.o(94002);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.util.h
 * JD-Core Version:    0.7.0.1
 */