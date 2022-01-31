package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.r;

public final class c
  extends r<ShareCardInfo>
{
  private final String TAG = "MicroMsg.ShareCardAdatper";
  long beginTime = 0L;
  long endTime = 0L;
  private int iqc = 0;
  com.tencent.mm.plugin.card.base.c iqd;
  int iqe = -1;
  
  public c(Context paramContext)
  {
    super(paramContext, new ShareCardInfo());
    mR(true);
    this.iqd = new j(paramContext, this);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (ShareCardInfo)getItem(paramInt);
    return this.iqd.a(paramInt, paramView, paramViewGroup);
  }
  
  public final void yc()
  {
    this.beginTime = System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.iqe == -1)
    {
      localObject1 = am.aAA();
      localObject2 = n.a.inf;
      localObject3 = new StringBuilder();
      switch (com.tencent.mm.plugin.card.sharecard.model.k.1.imx[localObject2.ordinal()])
      {
      default: 
        localObject2 = "select * from ShareCardInfo" + ((StringBuilder)localObject3).toString() + " order by status asc , share_time desc";
        localObject1 = ((k)localObject1).dXw.rawQuery((String)localObject2, null);
        if (localObject1 != null)
        {
          this.iqc = ((Cursor)localObject1).getCount();
          y.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", new Object[] { Integer.valueOf(this.iqe), Integer.valueOf(this.iqc) });
        }
        break;
      }
    }
    for (;;)
    {
      setCursor((Cursor)localObject1);
      this.endTime = System.currentTimeMillis();
      notifyDataSetChanged();
      return;
      ((StringBuilder)localObject3).append(" where (status=0 OR status=5)");
      break;
      ((StringBuilder)localObject3).append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
      break;
      ((StringBuilder)localObject3).append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
      break;
      localObject3 = am.aAA();
      int i = this.iqe;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" where ( status=0) ");
      localObject2 = "";
      localObject1 = localObject2;
      switch (i)
      {
      default: 
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1 = "select * from ShareCardInfo" + localStringBuilder.toString() + (String)localObject1;
        localObject1 = ((k)localObject3).dXw.rawQuery((String)localObject1, null);
        break;
        localStringBuilder.append(" AND (");
        localStringBuilder.append(" (");
        localStringBuilder.append(k.oR(1));
        localStringBuilder.append(" categoryType= '10' ");
        localStringBuilder.append(") ");
        localStringBuilder.append(" OR (");
        localStringBuilder.append(k.oR(2));
        localStringBuilder.append(" categoryType= '0' ");
        localStringBuilder.append(") ");
        localStringBuilder.append(" )");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND ");
        localStringBuilder.append(" (");
        localStringBuilder.append(k.oR(1));
        localStringBuilder.append(" categoryType= '10' ");
        localStringBuilder.append(") ");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND ");
        localStringBuilder.append(" (");
        localStringBuilder.append(k.oR(2));
        localStringBuilder.append(" categoryType= '0' ");
        localStringBuilder.append(") ");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND 1 != 1 ");
        localObject1 = localObject2;
      }
      y.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", new Object[] { Integer.valueOf(this.iqe) });
    }
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.c
 * JD-Core Version:    0.7.0.1
 */