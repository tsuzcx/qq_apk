package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public long hCa = 0L;
  private int hCb;
  public int hCc;
  public int hCd;
  private int hCe;
  public int hCf;
  public int hCg;
  public int hCh;
  public StringBuilder hCi = new StringBuilder();
  public StringBuilder hCj = new StringBuilder();
  public StringBuilder hCk = new StringBuilder();
  public StringBuilder hCl = new StringBuilder();
  public int hCm;
  private int hCn;
  public int hCo;
  public int hCp;
  public int hCq;
  public StringBuilder hCr = new StringBuilder();
  public StringBuilder hCs = new StringBuilder();
  public StringBuilder hCt = new StringBuilder();
  public StringBuilder hCu = new StringBuilder();
  
  public final void A(int paramInt1, int paramInt2, int paramInt3)
  {
    this.hCe = paramInt1;
    this.hCn = paramInt2;
    this.hCb = paramInt3;
    if (this.hCa <= 0L)
    {
      y.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
      return;
    }
    y.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", new Object[] { Long.valueOf(this.hCa), Integer.valueOf(this.hCd), Integer.valueOf(this.hCe), Integer.valueOf(this.hCb), Integer.valueOf(this.hCf), this.hCi.toString(), Integer.valueOf(this.hCg), this.hCj.toString(), Integer.valueOf(this.hCc), Integer.valueOf(this.hCm), Integer.valueOf(this.hCn), Integer.valueOf(this.hCo), this.hCr.toString(), Integer.valueOf(this.hCp), this.hCs.toString(), Integer.valueOf(this.hCq), this.hCk.toString(), this.hCu.toString(), this.hCt.toString(), Integer.valueOf(this.hCh), this.hCl.toString() });
    h.nFQ.f(15081, new Object[] { Long.valueOf(this.hCa), Integer.valueOf(this.hCd), Integer.valueOf(this.hCe), Integer.valueOf(this.hCb), Integer.valueOf(this.hCf), this.hCi.toString(), Integer.valueOf(this.hCg), this.hCj.toString(), Integer.valueOf(this.hCc), Integer.valueOf(this.hCm), Integer.valueOf(this.hCn), Integer.valueOf(this.hCo), this.hCr.toString(), Integer.valueOf(this.hCp), this.hCs.toString(), Integer.valueOf(this.hCq), this.hCk.toString(), this.hCu.toString(), this.hCt.toString(), Integer.valueOf(this.hCh), this.hCl.toString() });
    this.hCa = 0L;
    this.hCb = 0;
    this.hCc = 0;
    this.hCd = 0;
    this.hCe = 0;
    this.hCf = 0;
    this.hCg = 0;
    this.hCq = 0;
    this.hCh = 0;
    this.hCi = new StringBuilder();
    this.hCj = new StringBuilder();
    this.hCk = new StringBuilder();
    this.hCl = new StringBuilder();
    this.hCm = 0;
    this.hCn = 0;
    this.hCo = 0;
    this.hCp = 0;
    this.hCr = new StringBuilder();
    this.hCs = new StringBuilder();
    this.hCt = new StringBuilder();
    this.hCu = new StringBuilder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b
 * JD-Core Version:    0.7.0.1
 */