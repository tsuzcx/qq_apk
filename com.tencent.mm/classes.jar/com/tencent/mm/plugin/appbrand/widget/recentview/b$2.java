package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class b$2
  implements Runnable
{
  public b$2(b paramb) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(114932);
    if (this.juW.jut <= 0L)
    {
      ab.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
      AppMethodBeat.o(114932);
      return;
    }
    ab.i("MicroMsg.AppBrandRecentViewReporter", "mOpenTime: %d, mRecentCountAtOpen: %d, mRecentCountAtClose: %d, mCloseType: %d, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %d, mDeleteRecentAppBrandList: %s,\nmStarCountAtOpen: %d, mStarCountAtClose: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s,\nmClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s, fullScreen: %b,\nmMoveStarAppBrandForwardCount: %d, mMoveStarAppBrandBackwardCount: %d, mScrollUpDown: %d, mShowSearchViewCount: %d, mClickSearchViewCount: %d,\nmMoveStarAppBrandForwardList: %s, mMoveStarAppBrandBackwardList: %s, mEnableNativeDynamicBackground: %b", new Object[] { Long.valueOf(this.juW.jut), Integer.valueOf(this.juW.juw), Integer.valueOf(this.juW.jux), Integer.valueOf(this.juW.juu), this.juW.juB.toString(), Integer.valueOf(this.juW.juz), this.juW.juC.toString(), Integer.valueOf(this.juW.juF), Integer.valueOf(this.juW.juG), this.juW.juM.toString(), Integer.valueOf(this.juW.juI), this.juW.juN.toString(), this.juW.juD.toString(), this.juW.juP.toString(), Integer.valueOf(this.juW.juA), this.juW.juE.toString(), Boolean.TRUE, Integer.valueOf(this.juW.juK), Integer.valueOf(this.juW.juL), Integer.valueOf(this.juW.juS), Integer.valueOf(this.juW.juT), Integer.valueOf(this.juW.juU), this.juW.juQ.toString(), this.juW.juR.toString(), Boolean.valueOf(this.juW.juV) });
    h localh = h.qsU;
    long l = this.juW.jut;
    int j = this.juW.juw;
    int k = this.juW.jux;
    int m = this.juW.juu;
    String str1 = this.juW.juB.toString();
    int n = this.juW.juz;
    String str2 = this.juW.juC.toString();
    int i1 = this.juW.juF;
    int i2 = this.juW.juG;
    String str3 = this.juW.juM.toString();
    int i3 = this.juW.juI;
    String str4 = this.juW.juN.toString();
    String str5 = this.juW.juD.toString();
    String str6 = this.juW.juP.toString();
    int i4 = this.juW.juA;
    String str7 = this.juW.juE.toString();
    int i5 = this.juW.juK;
    int i6 = this.juW.juL;
    int i7 = this.juW.juS;
    int i8 = this.juW.juT;
    int i9 = this.juW.juU;
    String str8 = this.juW.juQ.toString();
    String str9 = this.juW.juR.toString();
    if (this.juW.juV) {}
    for (;;)
    {
      localh.e(15081, new Object[] { Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(0), str1, Integer.valueOf(n), str2, Integer.valueOf(0), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(0), str3, Integer.valueOf(i3), str4, Integer.valueOf(0), str5, str6, "", Integer.valueOf(i4), str7, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str8, str9, Integer.valueOf(i) });
      b.a(this.juW);
      AppMethodBeat.o(114932);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b.2
 * JD-Core Version:    0.7.0.1
 */