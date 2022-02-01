package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostMediaProcessStat;", "", "()V", "id_remux", "", "key_no_remux_moov", "key_postTotalCost", "key_postTotalCostCount", "key_postUploadCost", "key_postUploadCostCount", "key_progress_exception", "key_remuxCost", "key_remuxCount", "key_remuxFailed", "key_remuxSize", "key_remux_file_error", "key_remux_skip", "key_videoDuration", "key_zipCost", "key_zipCount", "key_zipFailed", "key_zipSize", "reportNoRemuxMoov", "", "isLongVideo", "", "reportPostTotalCost", "cost", "reportPostUploadCost", "reportRemuxCost", "reportRemuxCount", "reportRemuxFailed", "reportRemuxOutputFileError", "reportRemuxProgressException", "reportRemuxSize", "size", "reportSkipRemuxCount", "reportVideoDuration", "durationMs", "reportZipCost", "reportZipCount", "reportZipFailed", "reportZipSize", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah$c
{
  private static final long FoA;
  private static final long FoB;
  private static final long FoC;
  private static final long FoD;
  private static final long FoE;
  private static final long FoF;
  private static final long FoG;
  private static final long FoH;
  private static final long FoI;
  private static final long FoJ;
  private static final long FoK;
  private static final long FoL;
  private static final long FoM;
  private static final long FoN;
  private static final long FoO;
  private static final long FoP;
  private static final long Foy;
  private static final long Foz = 0L;
  public static final c Ftv;
  
  static
  {
    AppMethodBeat.i(166620);
    Ftv = new c();
    Foy = 1253L;
    FoA = 1L;
    FoB = 2L;
    FoC = 3L;
    FoD = 4L;
    FoE = 5L;
    FoF = 6L;
    FoG = 7L;
    FoH = 8L;
    FoI = 34L;
    FoJ = 36L;
    FoK = 54L;
    FoL = 64L;
    FoM = 9L;
    FoN = 10L;
    FoO = 11L;
    FoP = 12L;
    AppMethodBeat.o(166620);
  }
  
  public static void C(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(331169);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoA, paramLong, paramBoolean);
    AppMethodBeat.o(331169);
  }
  
  public static void D(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(331246);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoO, 1L, paramBoolean);
    localah = ah.Ftr;
    ah.idkeyStat(Foy, FoP, paramLong, paramBoolean);
    AppMethodBeat.o(331246);
  }
  
  public static void E(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(331251);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoM, 1L, paramBoolean);
    localah = ah.Ftr;
    ah.idkeyStat(Foy, FoN, paramLong, paramBoolean);
    AppMethodBeat.o(331251);
  }
  
  public static void F(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(331183);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoC, paramLong, paramBoolean);
    AppMethodBeat.o(331183);
  }
  
  public static void G(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(331227);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoE, paramLong, paramBoolean);
    AppMethodBeat.o(331227);
  }
  
  public static void H(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(331238);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoG, paramLong, paramBoolean);
    AppMethodBeat.o(331238);
  }
  
  public static void pO(long paramLong)
  {
    AppMethodBeat.i(331242);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoH, paramLong, false);
    AppMethodBeat.o(331242);
  }
  
  public static void tA(boolean paramBoolean)
  {
    AppMethodBeat.i(331210);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoL, 1L, paramBoolean);
    AppMethodBeat.o(331210);
  }
  
  public static void tP(boolean paramBoolean)
  {
    AppMethodBeat.i(331161);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, Foz, 1L, paramBoolean);
    AppMethodBeat.o(331161);
  }
  
  public static void tQ(boolean paramBoolean)
  {
    AppMethodBeat.i(331191);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoI, 1L, paramBoolean);
    AppMethodBeat.o(331191);
  }
  
  public static void tR(boolean paramBoolean)
  {
    AppMethodBeat.i(331204);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoK, 1L, paramBoolean);
    AppMethodBeat.o(331204);
  }
  
  public static void tS(boolean paramBoolean)
  {
    AppMethodBeat.i(331219);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoD, 1L, paramBoolean);
    AppMethodBeat.o(331219);
  }
  
  public static void tT(boolean paramBoolean)
  {
    AppMethodBeat.i(331233);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoF, 1L, paramBoolean);
    AppMethodBeat.o(331233);
  }
  
  public static void ty(boolean paramBoolean)
  {
    AppMethodBeat.i(331175);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoB, 1L, paramBoolean);
    AppMethodBeat.o(331175);
  }
  
  public static void tz(boolean paramBoolean)
  {
    AppMethodBeat.i(331196);
    ah localah = ah.Ftr;
    ah.idkeyStat(Foy, FoJ, 1L, paramBoolean);
    AppMethodBeat.o(331196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ah.c
 * JD-Core Version:    0.7.0.1
 */