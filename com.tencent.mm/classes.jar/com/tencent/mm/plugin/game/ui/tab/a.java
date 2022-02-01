package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class a
  extends BaseAdapter
{
  private String Dcd;
  private GameTabData Ddu;
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(GameTabData paramGameTabData, String paramString)
  {
    AppMethodBeat.i(42431);
    this.Ddu = paramGameTabData;
    this.Dcd = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(42431);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(42432);
    if (this.Ddu == null)
    {
      AppMethodBeat.o(42432);
      return 0;
    }
    int i = this.Ddu.aCj().size();
    AppMethodBeat.o(42432);
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42433);
    paramView = LayoutInflater.from(this.mContext).inflate(g.f.Coi, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    GameTabData.TabItem localTabItem = (GameTabData.TabItem)this.Ddu.aCj().get(paramInt);
    Object localObject;
    c.a locala;
    if (localTabItem != null)
    {
      paramViewGroup.jMg.setText(localTabItem.title);
      if (!Util.nullAsNil(this.Dcd).equalsIgnoreCase(localTabItem.CLE)) {
        break label186;
      }
      if (!Util.isNullOrNil(localTabItem.CLK))
      {
        localObject = aj.CLO + g.getMessageDigest(localTabItem.CLK.getBytes());
        locala = new c.a();
        locala.lRD = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bmL();
        com.tencent.mm.ay.a.a.bms().a(localTabItem.CLK, paramViewGroup.bwJ, (c)localObject);
      }
    }
    for (;;)
    {
      paramView.setTag(localTabItem);
      AppMethodBeat.o(42433);
      return paramView;
      label186:
      if (!Util.isNullOrNil(localTabItem.CLJ))
      {
        localObject = aj.CLO + g.getMessageDigest(localTabItem.CLJ.getBytes());
        locala = new c.a();
        locala.lRD = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bmL();
        com.tencent.mm.ay.a.a.bms().a(localTabItem.CLJ, paramViewGroup.bwJ, (c)localObject);
      }
    }
  }
  
  public final class a
  {
    ImageView bwJ;
    TextView jMg;
    
    public a(View paramView)
    {
      AppMethodBeat.i(42430);
      this.jMg = ((TextView)paramView.findViewById(g.e.Chu));
      this.bwJ = ((ImageView)paramView.findViewById(g.e.Chs));
      AppMethodBeat.o(42430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */