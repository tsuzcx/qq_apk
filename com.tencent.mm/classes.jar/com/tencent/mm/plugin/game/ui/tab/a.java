package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private GameTabData lfQ;
  private String lfR;
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(GameTabData paramGameTabData, String paramString)
  {
    this.lfQ = paramGameTabData;
    this.lfR = paramString;
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    if (this.lfQ == null) {
      return 0;
    }
    return this.lfQ.getItemList().size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.mContext).inflate(g.f.game_tab_item_view, paramViewGroup, false);
    paramViewGroup = new a.a(this, paramView);
    GameTabData.TabItem localTabItem = (GameTabData.TabItem)this.lfQ.getItemList().get(paramInt);
    Object localObject;
    c.a locala;
    if (localTabItem != null)
    {
      paramViewGroup.fcy.setText(localTabItem.title);
      if (!bk.pm(this.lfR).equalsIgnoreCase(localTabItem.kQT)) {
        break label176;
      }
      if (!bk.bl(localTabItem.kQZ))
      {
        localObject = ak.kRe + g.o(localTabItem.kQZ.getBytes());
        locala = new c.a();
        locala.erf = true;
        locala.erh = ((String)localObject);
        localObject = locala.OV();
        com.tencent.mm.as.a.a.OT().a(localTabItem.kQZ, paramViewGroup.hic, (c)localObject);
      }
    }
    for (;;)
    {
      paramView.setTag(localTabItem);
      return paramView;
      label176:
      if (!bk.bl(localTabItem.kQY))
      {
        localObject = ak.kRe + g.o(localTabItem.kQY.getBytes());
        locala = new c.a();
        locala.erf = true;
        locala.erh = ((String)localObject);
        localObject = locala.OV();
        com.tencent.mm.as.a.a.OT().a(localTabItem.kQY, paramViewGroup.hic, (c)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */