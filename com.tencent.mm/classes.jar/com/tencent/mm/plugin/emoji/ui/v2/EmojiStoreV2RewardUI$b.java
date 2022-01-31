package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.ui.w;
import java.util.LinkedList;

final class EmojiStoreV2RewardUI$b
  extends BaseAdapter
{
  private LinkedList<EmotionPrice> lqf;
  
  EmojiStoreV2RewardUI$b(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void Q(LinkedList<EmotionPrice> paramLinkedList)
  {
    AppMethodBeat.i(53706);
    if (this.lqf == null) {
      this.lqf = new LinkedList();
    }
    this.lqf.clear();
    this.lqf.addAll(paramLinkedList);
    notifyDataSetChanged();
    AppMethodBeat.o(53706);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(53707);
    if (this.lqf == null)
    {
      AppMethodBeat.o(53707);
      return 0;
    }
    int i = this.lqf.size();
    AppMethodBeat.o(53707);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(53709);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = w.hM(this.lqH.getContext()).inflate(2130969408, null);
      paramViewGroup = new EmojiStoreV2RewardUI.c(this.lqH, paramView);
      paramView.setTag(paramViewGroup);
      EmotionPrice localEmotionPrice = uw(paramInt);
      if (localEmotionPrice == null) {
        break label122;
      }
      paramViewGroup.lqL.setVisibility(0);
      paramViewGroup.lqL.setText(localEmotionPrice.Number + localEmotionPrice.Label);
    }
    for (;;)
    {
      AppMethodBeat.o(53709);
      return paramView;
      paramViewGroup = (EmojiStoreV2RewardUI.c)paramView.getTag();
      break;
      label122:
      paramViewGroup.lqL.setVisibility(8);
    }
  }
  
  public final EmotionPrice uw(int paramInt)
  {
    AppMethodBeat.i(53708);
    if ((paramInt < 0) || (paramInt > getCount()))
    {
      AppMethodBeat.o(53708);
      return null;
    }
    if (this.lqf == null)
    {
      AppMethodBeat.o(53708);
      return null;
    }
    EmotionPrice localEmotionPrice = (EmotionPrice)this.lqf.get(paramInt);
    AppMethodBeat.o(53708);
    return localEmotionPrice;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.b
 * JD-Core Version:    0.7.0.1
 */