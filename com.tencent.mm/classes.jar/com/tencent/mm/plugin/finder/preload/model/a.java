package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.common.TPPlayerDecoderCapability;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/model/HdrCapability;", "", "()V", "TAG", "", "isSupportDolbyVersion", "", "()Z", "setSupportDolbyVersion", "(Z)V", "isSupportHDR10", "setSupportHDR10", "isSupportHDR10PLUS", "setSupportHDR10PLUS", "isSupportHDRHLG", "setSupportHDRHLG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EVb;
  private static boolean EVc;
  private static boolean EVd;
  private static boolean EVe;
  private static boolean EVf;
  
  static
  {
    AppMethodBeat.i(346323);
    EVb = new a();
    EVc = TPPlayerDecoderCapability.isHDRsupport(2, 0, 0);
    EVd = TPPlayerDecoderCapability.isHDRsupport(0, 0, 0);
    EVe = TPPlayerDecoderCapability.isHDRsupport(1, 0, 0);
    EVf = TPPlayerDecoderCapability.isHDRsupport(3, 0, 0);
    StringBuilder localStringBuilder = new StringBuilder("isSupportDolbyVersion:").append(eHK()).append(" isSupportHDR10:").append(eHL()).append(" isSupportHDR10PLUS:");
    Log.i("HdrCapability", s.X("isSupportHDR10PLUS:", Boolean.valueOf(EVe)));
    localStringBuilder = localStringBuilder.append(EVe).append(" isSupportHDRHLG:");
    Log.i("HdrCapability", s.X("isSupportHDRHLG:", Boolean.valueOf(EVf)));
    Log.i("HdrCapability", EVf);
    AppMethodBeat.o(346323);
  }
  
  public static boolean eHK()
  {
    AppMethodBeat.i(346306);
    Log.i("HdrCapability", s.X("isSupportDolbyVersion:", Boolean.valueOf(EVc)));
    boolean bool = EVc;
    AppMethodBeat.o(346306);
    return bool;
  }
  
  public static boolean eHL()
  {
    AppMethodBeat.i(346314);
    Log.i("HdrCapability", s.X("isSupportHDR10:", Boolean.valueOf(EVd)));
    boolean bool = EVd;
    AppMethodBeat.o(346314);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a
 * JD-Core Version:    0.7.0.1
 */