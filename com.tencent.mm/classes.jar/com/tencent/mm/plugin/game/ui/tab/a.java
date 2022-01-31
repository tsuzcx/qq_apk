package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private GameTabData nDL;
  private String nDM;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(GameTabData paramGameTabData, String paramString)
  {
    AppMethodBeat.i(112233);
    this.nDL = paramGameTabData;
    this.nDM = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(112233);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(112234);
    if (this.nDL == null)
    {
      AppMethodBeat.o(112234);
      return 0;
    }
    int i = this.nDL.getItemList().size();
    AppMethodBeat.o(112234);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(112235);
    paramView = LayoutInflater.from(this.mContext).inflate(2130969824, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    GameTabData.TabItem localTabItem = (GameTabData.TabItem)this.nDL.getItemList().get(paramInt);
    Object localObject;
    c.a locala;
    if (localTabItem != null)
    {
      paramViewGroup.gui.setText(localTabItem.title);
      if (!bo.nullAsNil(this.nDM).equalsIgnoreCase(localTabItem.noX)) {
        break label185;
      }
      if (!bo.isNullOrNil(localTabItem.npd))
      {
        localObject = aj.nph + g.w(localTabItem.npd.getBytes());
        locala = new c.a();
        locala.eNM = true;
        locala.eNO = ((String)localObject);
        localObject = locala.ahY();
        com.tencent.mm.at.a.a.ahM().a(localTabItem.npd, paramViewGroup.iTH, (c)localObject);
      }
    }
    for (;;)
    {
      paramView.setTag(localTabItem);
      AppMethodBeat.o(112235);
      return paramView;
      label185:
      if (!bo.isNullOrNil(localTabItem.npc))
      {
        localObject = aj.nph + g.w(localTabItem.npc.getBytes());
        locala = new c.a();
        locala.eNM = true;
        locala.eNO = ((String)localObject);
        localObject = locala.ahY();
        com.tencent.mm.at.a.a.ahM().a(localTabItem.npc, paramViewGroup.iTH, (c)localObject);
      }
    }
  }
  
  public final class a
  {
    TextView gui;
    ImageView iTH;
    
    public a(View paramView)
    {
      AppMethodBeat.i(112232);
      this.gui = ((TextView)paramView.findViewById(2131824777));
      this.iTH = ((ImageView)paramView.findViewById(2131824776));
      AppMethodBeat.o(112232);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */