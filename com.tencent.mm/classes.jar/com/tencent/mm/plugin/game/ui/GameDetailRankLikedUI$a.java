package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.dk;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.List;

final class GameDetailRankLikedUI$a
  extends BaseAdapter
{
  List<dk> kZk = new LinkedList();
  private Context mContext;
  
  public GameDetailRankLikedUI$a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private dk sh(int paramInt)
  {
    return (dk)this.kZk.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.kZk.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    dk localdk;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(g.f.game_detail2_rank_liked_item, paramViewGroup, false);
      paramViewGroup = new GameDetailRankLikedUI.a.a((byte)0);
      paramViewGroup.ffK = ((ImageView)paramView.findViewById(g.e.game_detail_rank_liked_item_avatar));
      paramViewGroup.kYV = ((TextView)paramView.findViewById(g.e.game_detail_rank_liked_item_name));
      paramViewGroup.kZl = ((TextView)paramView.findViewById(g.e.game_detail_rank_liked_item_time));
      paramView.setTag(paramViewGroup);
      localdk = sh(paramInt);
      a.b.a(paramViewGroup.ffK, localdk.kWn, 0.5F, false);
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(localdk.kWn);
      if (localObject == null) {
        break label190;
      }
      localObject = new SpannableString(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, ((ad)localObject).Bq(), paramViewGroup.kYV.getTextSize()));
      paramViewGroup.kYV.setText((CharSequence)localObject);
    }
    for (;;)
    {
      paramViewGroup.kZl.setText(localdk.kWo);
      return paramView;
      paramViewGroup = (GameDetailRankLikedUI.a.a)paramView.getTag();
      break;
      label190:
      paramViewGroup.kYV.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.a
 * JD-Core Version:    0.7.0.1
 */