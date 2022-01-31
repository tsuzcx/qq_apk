package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(114931);
    if (this.juW.jut <= 0L)
    {
      ab.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
      AppMethodBeat.o(114931);
      return;
    }
    ab.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", new Object[] { Long.valueOf(this.juW.jut), Integer.valueOf(this.juW.juw), Integer.valueOf(this.juW.jux), Integer.valueOf(this.juW.juu), Integer.valueOf(this.juW.juy), this.juW.juB.toString(), Integer.valueOf(this.juW.juz), this.juW.juC.toString(), Integer.valueOf(this.juW.juv), Integer.valueOf(this.juW.juF), Integer.valueOf(this.juW.juG), Integer.valueOf(this.juW.juH), this.juW.juM.toString(), Integer.valueOf(this.juW.juI), this.juW.juN.toString(), Integer.valueOf(this.juW.juJ), this.juW.juD.toString(), this.juW.juP.toString(), this.juW.juO.toString(), Integer.valueOf(this.juW.juA), this.juW.juE.toString() });
    h.qsU.e(15081, new Object[] { Long.valueOf(this.juW.jut), Integer.valueOf(this.juW.juw), Integer.valueOf(this.juW.jux), Integer.valueOf(this.juW.juu), Integer.valueOf(this.juW.juy), this.juW.juB.toString(), Integer.valueOf(this.juW.juz), this.juW.juC.toString(), Integer.valueOf(this.juW.juv), Integer.valueOf(this.juW.juF), Integer.valueOf(this.juW.juG), Integer.valueOf(this.juW.juH), this.juW.juM.toString(), Integer.valueOf(this.juW.juI), this.juW.juN.toString(), Integer.valueOf(this.juW.juJ), this.juW.juD.toString(), this.juW.juP.toString(), this.juW.juO.toString(), Integer.valueOf(this.juW.juA), this.juW.juE.toString() });
    b.a(this.juW);
    AppMethodBeat.o(114931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b.1
 * JD-Core Version:    0.7.0.1
 */