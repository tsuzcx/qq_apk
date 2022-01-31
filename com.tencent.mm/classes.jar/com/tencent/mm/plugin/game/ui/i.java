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
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ab.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int Ls;
  int kQh;
  private ab kYS;
  private Context mContext;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void m(ViewGroup paramViewGroup)
  {
    paramViewGroup.setClipChildren(false);
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        ((ViewGroup)localView).setClipChildren(false);
        m((ViewGroup)localView);
      }
      i += 1;
    }
  }
  
  public final void a(ab paramab)
  {
    this.kYS = paramab;
    ai.d(new i.1(this));
  }
  
  public final int getCount()
  {
    if (this.kYS == null) {
      return 0;
    }
    return this.kYS.kQs.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.kYS.kQs.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(this.Ls, paramViewGroup, false);
      paramViewGroup = new i.a(this, (byte)0);
      paramViewGroup.kYU = ((TextView)paramView.findViewById(g.e.game_detail_rank_item_num));
      paramViewGroup.ffK = ((ImageView)paramView.findViewById(g.e.game_detail_rank_item_avatar));
      paramViewGroup.kYV = ((TextView)paramView.findViewById(g.e.game_detail_rank_item_name));
      paramViewGroup.kYW = ((TextView)paramView.findViewById(g.e.game_detail_rank_item_tag));
      paramViewGroup.kYX = ((TextView)paramView.findViewById(g.e.game_detail_rank_item_score));
      paramViewGroup.kYY = ((GameDetailRankLikeView)paramView.findViewById(g.e.game_detail_rank_item_like));
      paramViewGroup.kYY.setSourceScene(this.kQh);
      m((ViewGroup)paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (ab.a)getItem(paramInt);
      paramViewGroup.kYU.setText(((ab.a)localObject1).kQt);
      a.b.a(paramViewGroup.ffK, ((ab.a)localObject1).bVI, 0.5F, false);
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((ab.a)localObject1).bVI);
      if (localObject2 == null) {
        break label321;
      }
      localObject2 = new SpannableString(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, ((ad)localObject2).Bq(), paramViewGroup.kYV.getTextSize()));
      paramViewGroup.kYV.setText((CharSequence)localObject2);
      label256:
      if (!bk.bl(((ab.a)localObject1).tag)) {
        break label333;
      }
      paramViewGroup.kYW.setVisibility(8);
    }
    for (;;)
    {
      if (bk.bl(((ab.a)localObject1).kQw)) {
        break label356;
      }
      paramViewGroup.kYX.setText(((ab.a)localObject1).kQw);
      paramViewGroup.kYY.setVisibility(8);
      return paramView;
      paramViewGroup = (i.a)paramView.getTag();
      break;
      label321:
      paramViewGroup.kYV.setText("");
      break label256;
      label333:
      paramViewGroup.kYW.setVisibility(0);
      paramViewGroup.kYW.setText(((ab.a)localObject1).tag);
    }
    label356:
    paramViewGroup.kYX.setText(((ab.a)localObject1).kxj);
    Object localObject1 = paramViewGroup.kYY;
    Object localObject2 = this.kYS;
    ((GameDetailRankLikeView)localObject1).kYZ = ((ab)localObject2);
    ((GameDetailRankLikeView)localObject1).mAppId = ((ab)localObject2).mAppId;
    ((GameDetailRankLikeView)localObject1).kZa = ((ab.a)((ab)localObject2).kQs.get(paramInt));
    ((GameDetailRankLikeView)localObject1).bag();
    paramViewGroup.kYY.setVisibility(0);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.i
 * JD-Core Version:    0.7.0.1
 */