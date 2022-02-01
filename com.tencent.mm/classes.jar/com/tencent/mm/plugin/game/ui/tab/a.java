package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private String xXy;
  private GameTabData xYP;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(GameTabData paramGameTabData, String paramString)
  {
    AppMethodBeat.i(42431);
    this.xYP = paramGameTabData;
    this.xXy = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(42431);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42432);
    if (this.xYP == null)
    {
      AppMethodBeat.o(42432);
      return 0;
    }
    int i = this.xYP.avn().size();
    AppMethodBeat.o(42432);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42433);
    paramView = LayoutInflater.from(this.mContext).inflate(2131494957, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    GameTabData.TabItem localTabItem = (GameTabData.TabItem)this.xYP.avn().get(paramInt);
    Object localObject;
    c.a locala;
    if (localTabItem != null)
    {
      paramViewGroup.hbb.setText(localTabItem.title);
      if (!Util.nullAsNil(this.xXy).equalsIgnoreCase(localTabItem.xHB)) {
        break label185;
      }
      if (!Util.isNullOrNil(localTabItem.xHH))
      {
        localObject = aj.xHL + g.getMessageDigest(localTabItem.xHH.getBytes());
        locala = new c.a();
        locala.jbf = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bdv();
        com.tencent.mm.av.a.a.bdb().a(localTabItem.xHH, paramViewGroup.kc, (c)localObject);
      }
    }
    for (;;)
    {
      paramView.setTag(localTabItem);
      AppMethodBeat.o(42433);
      return paramView;
      label185:
      if (!Util.isNullOrNil(localTabItem.xHG))
      {
        localObject = aj.xHL + g.getMessageDigest(localTabItem.xHG.getBytes());
        locala = new c.a();
        locala.jbf = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bdv();
        com.tencent.mm.av.a.a.bdb().a(localTabItem.xHG, paramViewGroup.kc, (c)localObject);
      }
    }
  }
  
  public final class a
  {
    TextView hbb;
    ImageView kc;
    
    public a(View paramView)
    {
      AppMethodBeat.i(42430);
      this.hbb = ((TextView)paramView.findViewById(2131297708));
      this.kc = ((ImageView)paramView.findViewById(2131297705));
      AppMethodBeat.o(42430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */