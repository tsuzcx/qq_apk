package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

public class l
{
  d gSO;
  q gSP;
  List<n> gSQ;
  String mAppId;
  
  public l(q paramq, List<n> paramList)
  {
    this.mAppId = paramq.mAppId;
    this.gSP = paramq;
    this.gSQ = paramList;
    paramq = new d(paramq.mContext);
    this.gSO = paramq;
    a(paramq);
  }
  
  protected void a(d paramd)
  {
    paramd = this.gSP.ahb();
    if (paramd != null) {
      this.gSO.ej(paramd);
    }
    this.gSO.phH = new l.1(this);
    this.gSO.phI = new l.2(this);
    if (this.gSP.gTO)
    {
      paramd = this.gSO;
      int i = Color.parseColor("#000000");
      if (paramd.jdj != null) {
        paramd.jdj.setBackgroundColor(i);
      }
      paramd.wmY = Boolean.valueOf(an.Gf(i));
      if ((paramd.wmY.booleanValue()) && (paramd.wng != null)) {
        paramd.wng.setImageDrawable(paramd.mContext.getResources().getDrawable(a.c.dark_bg_line_color));
      }
    }
  }
  
  protected final boolean amW()
  {
    try
    {
      this.gSO.cfU();
      return true;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", new Object[] { localException });
    }
    return false;
  }
  
  protected final boolean amX()
  {
    try
    {
      this.gSO.bFp();
      return true;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", new Object[] { localException });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.l
 * JD-Core Version:    0.7.0.1
 */