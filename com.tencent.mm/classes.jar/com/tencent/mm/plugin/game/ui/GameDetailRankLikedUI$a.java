package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.dl;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.List;

final class GameDetailRankLikedUI$a
  extends BaseAdapter
{
  private Context mContext;
  List<dl> nxh;
  
  public GameDetailRankLikedUI$a(Context paramContext)
  {
    AppMethodBeat.i(111825);
    this.nxh = new LinkedList();
    this.mContext = paramContext;
    AppMethodBeat.o(111825);
  }
  
  private dl xg(int paramInt)
  {
    AppMethodBeat.i(111827);
    dl localdl = (dl)this.nxh.get(paramInt);
    AppMethodBeat.o(111827);
    return localdl;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111826);
    int i = this.nxh.size();
    AppMethodBeat.o(111826);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111828);
    dl localdl;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2130969736, paramViewGroup, false);
      paramViewGroup = new GameDetailRankLikedUI.a.a((byte)0);
      paramViewGroup.gxs = ((ImageView)paramView.findViewById(2131824590));
      paramViewGroup.nwS = ((TextView)paramView.findViewById(2131824591));
      paramViewGroup.nxi = ((TextView)paramView.findViewById(2131824592));
      paramView.setTag(paramViewGroup);
      localdl = xg(paramInt);
      a.b.a(paramViewGroup.gxs, localdl.num, 0.5F, false);
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(localdl.num);
      if (localObject == null) {
        break label196;
      }
      localObject = new SpannableString(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, ((ad)localObject).Of(), paramViewGroup.nwS.getTextSize()));
      paramViewGroup.nwS.setText((CharSequence)localObject);
    }
    for (;;)
    {
      paramViewGroup.nxi.setText(localdl.nun);
      AppMethodBeat.o(111828);
      return paramView;
      paramViewGroup = (GameDetailRankLikedUI.a.a)paramView.getTag();
      break;
      label196:
      paramViewGroup.nwS.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.a
 * JD-Core Version:    0.7.0.1
 */