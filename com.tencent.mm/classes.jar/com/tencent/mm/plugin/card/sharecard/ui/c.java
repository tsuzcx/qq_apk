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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.s;

public final class c
  extends s<ShareCardInfo>
{
  private final String TAG;
  long beginTime;
  long endTime;
  private int pXn;
  com.tencent.mm.plugin.card.base.c pXo;
  private int pXp;
  
  public c(Context paramContext)
  {
    super(paramContext, new ShareCardInfo());
    AppMethodBeat.i(113074);
    this.TAG = "MicroMsg.ShareCardAdatper";
    this.pXn = 0;
    this.pXp = -1;
    this.beginTime = 0L;
    this.endTime = 0L;
    Bh(true);
    this.pXo = new j(paramContext, this);
    AppMethodBeat.o(113074);
  }
  
  public final void Eo(int paramInt)
  {
    AppMethodBeat.i(113078);
    this.pXp = paramInt;
    onNotifyChange(null, null);
    AppMethodBeat.o(113078);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(113076);
    this.beginTime = System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.pXp == -1)
    {
      localObject1 = am.ctY();
      localObject2 = n.a.pTQ;
      localObject3 = new StringBuilder();
      switch (com.tencent.mm.plugin.card.sharecard.model.k.1.pTm[localObject2.ordinal()])
      {
      default: 
        localObject2 = "select * from ShareCardInfo" + ((StringBuilder)localObject3).toString() + " order by status asc , share_time desc";
        localObject1 = ((k)localObject1).db.rawQuery((String)localObject2, null);
        if (localObject1 != null)
        {
          this.pXn = ((Cursor)localObject1).getCount();
          Log.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", new Object[] { Integer.valueOf(this.pXp), Integer.valueOf(this.pXn) });
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
      ((StringBuilder)localObject3).append(" where (status=1 OR status=2 OR status").append("=3 OR status=4 OR status=6)");
      break;
      ((StringBuilder)localObject3).append(" where (status=0 OR status=5) and (block_mask").append("= '1' OR block_mask= '0' )");
      break;
      localObject3 = am.ctY();
      int i = this.pXp;
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
        localStringBuilder.append(k.Ek(1));
        localStringBuilder.append(" categoryType= '10' ");
        localStringBuilder.append(") ");
        localStringBuilder.append(" OR (");
        localStringBuilder.append(k.Ek(2));
        localStringBuilder.append(" categoryType= '0' ");
        localStringBuilder.append(") ");
        localStringBuilder.append(" )");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND ");
        localStringBuilder.append(" (");
        localStringBuilder.append(k.Ek(1));
        localStringBuilder.append(" categoryType= '10' ");
        localStringBuilder.append(") ");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND ");
        localStringBuilder.append(" (");
        localStringBuilder.append(k.Ek(2));
        localStringBuilder.append(" categoryType= '0' ");
        localStringBuilder.append(") ");
        localObject1 = " order by categoryType desc , itemIndex asc";
        continue;
        localStringBuilder.append(" AND 1 != 1 ");
        localObject1 = localObject2;
      }
      Log.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", new Object[] { Integer.valueOf(this.pXp) });
    }
  }
  
  public final void anq()
  {
    AppMethodBeat.i(113077);
    ebf();
    anp();
    AppMethodBeat.o(113077);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113075);
    paramViewGroup = (ShareCardInfo)getItem(paramInt);
    paramView = this.pXo.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(113075);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.c
 * JD-Core Version:    0.7.0.1
 */