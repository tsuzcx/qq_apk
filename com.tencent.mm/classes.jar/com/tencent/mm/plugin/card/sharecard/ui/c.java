package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.r;

public final class c
  extends r<ShareCardInfo>
{
  private final String TAG;
  long beginTime;
  long endTime;
  private int oCX;
  com.tencent.mm.plugin.card.base.c oCY;
  private int oCZ;
  
  public c(Context paramContext)
  {
    super(paramContext, new ShareCardInfo());
    AppMethodBeat.i(113074);
    this.TAG = "MicroMsg.ShareCardAdatper";
    this.oCX = 0;
    this.oCZ = -1;
    this.beginTime = 0L;
    this.endTime = 0L;
    xk(true);
    this.oCY = new j(paramContext, this);
    AppMethodBeat.o(113074);
  }
  
  public final void Ax(int paramInt)
  {
    AppMethodBeat.i(113078);
    this.oCZ = paramInt;
    a(null, null);
    AppMethodBeat.o(113078);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(113076);
    this.beginTime = System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.oCZ == -1)
    {
      localObject1 = am.bUV();
      localObject2 = n.a.ozI;
      localObject3 = new StringBuilder();
      switch (com.tencent.mm.plugin.card.sharecard.model.k.1.ozc[localObject2.ordinal()])
      {
      default: 
        localObject2 = "select * from ShareCardInfo" + ((StringBuilder)localObject3).toString() + " order by status asc , share_time desc";
        localObject1 = ((k)localObject1).db.rawQuery((String)localObject2, null);
        if (localObject1 != null)
        {
          this.oCX = ((Cursor)localObject1).getCount();
          ad.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", new Object[] { Integer.valueOf(this.oCZ), Integer.valueOf(this.oCX) });
        }
        break;
      }
    }
    for (;;)
    {
      setCursor((Cursor)localObject1);
      this.endTime = System.currentTimeMillis();
      notifyDataSetChanged();
      AppMethodBeat.o(113076);
      return;
      ((StringBuilder)localObject3).append(" where (status=0 OR status=5)");
      break;
      ((StringBuilder)localObject3).append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
      break;
      ((StringBuilder)localObject3).append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
      break;
      localObject3 = am.bUV();
      int i = this.oCZ;
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
        localObject1 = ((k)localObject3).db.rawQuery((String)localObject1, null);
        break;
        localStringBuilder.append(" AND (");
        localStringBuilder.append(" (");
        localStringBuilder.append(k.At(1));
        localStringBuilder.append(" categoryType= '10' ");
        localStringBuilder.append(") ");
        localStringBuilder.append(" OR (");
        localStringBuilder.append(k.At(2));
        localStringBuilder.append(" categoryType= '0' ");
        localStringBuilder.append(") ");
        localStringBuilder.append(" )");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND ");
        localStringBuilder.append(" (");
        localStringBuilder.append(k.At(1));
        localStringBuilder.append(" categoryType= '10' ");
        localStringBuilder.append(") ");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND ");
        localStringBuilder.append(" (");
        localStringBuilder.append(k.At(2));
        localStringBuilder.append(" categoryType= '0' ");
        localStringBuilder.append(") ");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND 1 != 1 ");
        localObject1 = localObject2;
      }
      ad.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", new Object[] { Integer.valueOf(this.oCZ) });
    }
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(113077);
    det();
    Zu();
    AppMethodBeat.o(113077);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113075);
    paramViewGroup = (ShareCardInfo)getItem(paramInt);
    paramView = this.oCY.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(113075);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.c
 * JD-Core Version:    0.7.0.1
 */