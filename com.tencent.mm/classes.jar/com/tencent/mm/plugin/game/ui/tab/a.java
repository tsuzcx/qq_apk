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
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private GameTabData tvP;
  private String tvQ;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(GameTabData paramGameTabData, String paramString)
  {
    AppMethodBeat.i(42431);
    this.tvP = paramGameTabData;
    this.tvQ = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(42431);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42432);
    if (this.tvP == null)
    {
      AppMethodBeat.o(42432);
      return 0;
    }
    int i = this.tvP.acH().size();
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
    paramView = LayoutInflater.from(this.mContext).inflate(2131494391, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    GameTabData.TabItem localTabItem = (GameTabData.TabItem)this.tvP.acH().get(paramInt);
    Object localObject;
    c.a locala;
    if (localTabItem != null)
    {
      paramViewGroup.fUk.setText(localTabItem.title);
      if (!bs.nullAsNil(this.tvQ).equalsIgnoreCase(localTabItem.tgk)) {
        break label185;
      }
      if (!bs.isNullOrNil(localTabItem.tgq))
      {
        localObject = aj.tgu + g.getMessageDigest(localTabItem.tgq.getBytes());
        locala = new c.a();
        locala.hKx = true;
        locala.gKe = ((String)localObject);
        localObject = locala.aFT();
        com.tencent.mm.av.a.a.aFG().a(localTabItem.tgq, paramViewGroup.ig, (c)localObject);
      }
    }
    for (;;)
    {
      paramView.setTag(localTabItem);
      AppMethodBeat.o(42433);
      return paramView;
      label185:
      if (!bs.isNullOrNil(localTabItem.tgp))
      {
        localObject = aj.tgu + g.getMessageDigest(localTabItem.tgp.getBytes());
        locala = new c.a();
        locala.hKx = true;
        locala.gKe = ((String)localObject);
        localObject = locala.aFT();
        com.tencent.mm.av.a.a.aFG().a(localTabItem.tgp, paramViewGroup.ig, (c)localObject);
      }
    }
  }
  
  public final class a
  {
    TextView fUk;
    ImageView ig;
    
    public a(View paramView)
    {
      AppMethodBeat.i(42430);
      this.fUk = ((TextView)paramView.findViewById(2131297471));
      this.ig = ((ImageView)paramView.findViewById(2131297469));
      AppMethodBeat.o(42430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */