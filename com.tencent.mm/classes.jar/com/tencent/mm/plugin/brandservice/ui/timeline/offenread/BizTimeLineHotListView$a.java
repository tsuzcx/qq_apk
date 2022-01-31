package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class BizTimeLineHotListView$a
  extends RecyclerView.a<BizTimeLineHotListView.b>
{
  private Context mContext;
  
  public BizTimeLineHotListView$a(BizTimeLineHotListView paramBizTimeLineHotListView, Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void a(BizTimeLineHotListView.b paramb, b paramb1, int paramInt)
  {
    int j = this.ihu.getItemWidth();
    float f = this.ihu.getShowCountPerPage();
    int i = j;
    if (j <= 0) {
      i = (int)(this.ihu.getWidth() / f);
    }
    j = i;
    if (i <= 0) {
      j = (int)(this.ihu.getResources().getDisplayMetrics().widthPixels / f);
    }
    i = j;
    if (paramInt == BizTimeLineHotListView.e(this.ihu).getItemCount() - 1)
    {
      double d = j;
      i = (int)((1.0D - (Math.ceil(f) - f)) * d);
      y.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
    paramb.aie.getLayoutParams().width = i;
    paramb.aie.setScaleX(1.0F);
    paramb.aie.setScaleY(1.0F);
    paramb.eXr.setText("pos:" + paramInt);
    y.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((paramb1 != null) && (paramb1.type != 2))
    {
      a.b.n(paramb.gSx, paramb1.sxi);
      String str = r.gV(paramb1.sxi);
      paramb.eXr.setText(str);
      if (!paramb1.ihG) {
        break label283;
      }
      paramb.ihv.setVisibility(0);
    }
    for (;;)
    {
      BizTimeLineHotListView.a(this.ihu, paramb, paramb1, paramInt);
      return;
      label283:
      paramb.ihv.setVisibility(8);
    }
  }
  
  public final int getItemCount()
  {
    int i;
    if (bk.dk(BizTimeLineHotListView.b(this.ihu))) {
      i = 0;
    }
    int j;
    int k;
    do
    {
      return i;
      j = BizTimeLineHotListView.b(this.ihu).size();
      k = a.getCompletelyCountPerPage();
      i = j;
      if (this.ihu.getCustomItemCount() == 1) {
        i = j - 1;
      }
      j = i;
      if (i > this.ihu.getShowCount()) {
        j = this.ihu.getShowCount();
      }
      if (this.ihu.getCustomItemCount() == 1)
      {
        if (j % k == 0) {}
        for (i = j + 1;; i = j + (k + 1 - j % k)) {
          return i + this.ihu.getCustomItemCount();
        }
      }
      i = j;
    } while (j % k == 0);
    return j + (k - j % k);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.a
 * JD-Core Version:    0.7.0.1
 */