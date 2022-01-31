package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.y;
import java.util.LinkedList;

final class EmojiStoreV2RewardUI$b
  extends BaseAdapter
{
  LinkedList<vl> hkd;
  
  EmojiStoreV2RewardUI$b(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final int getCount()
  {
    if (this.hkd == null) {
      return 0;
    }
    return this.hkd.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = y.gt(this.jhK.mController.uMN).inflate(f.f.emoji_store_v2_reward_item, null);
      paramViewGroup = new EmojiStoreV2RewardUI.c(this.jhK, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      vl localvl = qa(paramInt);
      if (localvl == null) {
        break;
      }
      paramViewGroup.jhP.setVisibility(0);
      paramViewGroup.jhP.setText(localvl.sSz + localvl.kVZ);
      return paramView;
      paramViewGroup = (EmojiStoreV2RewardUI.c)paramView.getTag();
    }
    paramViewGroup.jhP.setVisibility(8);
    return paramView;
  }
  
  public final vl qa(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getCount())) {}
    while (this.hkd == null) {
      return null;
    }
    return (vl)this.hkd.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.b
 * JD-Core Version:    0.7.0.1
 */