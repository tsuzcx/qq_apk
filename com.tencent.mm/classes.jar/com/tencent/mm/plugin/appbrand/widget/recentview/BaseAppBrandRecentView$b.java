package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.g.c.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class BaseAppBrandRecentView$b
  extends c.a
{
  private List<a> hjX;
  private List<a> hjY;
  
  public BaseAppBrandRecentView$b(BaseAppBrandRecentView paramBaseAppBrandRecentView, List paramList1, List paramList2)
  {
    this.hjY = paramList1;
    this.hjX = paramList2;
  }
  
  public final boolean C(int paramInt1, int paramInt2)
  {
    a locala1 = (a)this.hjY.get(paramInt2);
    a locala2 = (a)this.hjX.get(paramInt1);
    if ((locala1 != null) && (locala2 != null) && (locala1.hqw != null) && (locala2.hqw != null)) {
      return (bk.pm(locala2.hqw.username).equals(locala1.hqw.username)) && (locala2.hqw.fJy == locala1.hqw.fJy);
    }
    if ((locala1 != null) && (locala2 != null)) {
      return (locala1.type == 3) && (locala2.type == 3);
    }
    return false;
  }
  
  public final boolean D(int paramInt1, int paramInt2)
  {
    a locala1 = (a)this.hjY.get(paramInt2);
    a locala2 = (a)this.hjX.get(paramInt1);
    if ((locala1 != null) && (locala2 != null) && (locala1.hqw != null) && (locala2.hqw != null)) {
      return bk.pm(locala2.hqw.fJY).equals(locala1.hqw.fJY);
    }
    if ((locala1 != null) && (locala2 != null)) {
      return (locala1.type == 3) && (locala2.type == 3);
    }
    return false;
  }
  
  public final int eI()
  {
    if (this.hjX != null) {
      return this.hjX.size();
    }
    return 0;
  }
  
  public final int eJ()
  {
    if (this.hjY != null) {
      return this.hjY.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b
 * JD-Core Version:    0.7.0.1
 */