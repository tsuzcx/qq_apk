package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.LinkedList;

final class EmojiStoreV2RewardDetailUI$a
  extends BaseAdapter
{
  private Bitmap bXF;
  int jdO;
  private int lev;
  int loO;
  private LinkedList<EmotionDonor> lqf;
  boolean lqg;
  private Context mContext;
  private int mNumColumns;
  
  public EmojiStoreV2RewardDetailUI$a(EmojiStoreV2RewardDetailUI paramEmojiStoreV2RewardDetailUI, Context paramContext)
  {
    AppMethodBeat.i(53672);
    this.lqg = false;
    this.mNumColumns = 1;
    this.bXF = null;
    this.mContext = paramContext;
    this.loO = com.tencent.mm.cb.a.ao(paramEmojiStoreV2RewardDetailUI.getContext(), 2131428356);
    int k = com.tencent.mm.cb.a.gw(paramEmojiStoreV2RewardDetailUI.getContext()) - com.tencent.mm.cb.a.ao(paramEmojiStoreV2RewardDetailUI.getContext(), 2131427772) * 2;
    int m = this.loO;
    int n = com.tencent.mm.cb.a.ao(paramEmojiStoreV2RewardDetailUI.getContext(), 2131427782);
    int j = k / (m + n);
    int i = j;
    if (k - j * m - n * (j - 1) > m) {
      i = j + 1;
    }
    this.mNumColumns = i;
    this.lev = com.tencent.mm.cb.a.gw(this.mContext);
    this.jdO = ((int)((this.lev - this.mNumColumns * this.loO) / (this.mNumColumns + 1.0F)));
    try
    {
      this.bXF = BackwardSupportUtil.b.b(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      AppMethodBeat.o(53672);
      return;
    }
    catch (IOException paramEmojiStoreV2RewardDetailUI)
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { bo.dtY() });
      AppMethodBeat.o(53672);
    }
  }
  
  private EmotionDonor uv(int paramInt)
  {
    AppMethodBeat.i(53675);
    if (this.lqf != null) {
      if (this.lqf != null) {
        break label33;
      }
    }
    label33:
    for (int i = 0; paramInt >= i; i = this.lqf.size())
    {
      AppMethodBeat.o(53675);
      return null;
    }
    EmotionDonor localEmotionDonor = (EmotionDonor)this.lqf.get(paramInt);
    AppMethodBeat.o(53675);
    return localEmotionDonor;
  }
  
  public final void Q(LinkedList<EmotionDonor> paramLinkedList)
  {
    AppMethodBeat.i(53673);
    if (this.lqf == null) {
      this.lqf = new LinkedList();
    }
    if (this.lqg)
    {
      this.lqf.clear();
      this.lqg = false;
    }
    this.lqf.addAll(paramLinkedList);
    notifyDataSetChanged();
    AppMethodBeat.o(53673);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(53674);
    if (this.lqf == null) {}
    for (int i = 0; i > 0; i = this.lqf.size())
    {
      i = (int)Math.ceil(i / this.mNumColumns);
      AppMethodBeat.o(53674);
      return i;
    }
    AppMethodBeat.o(53674);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(53676);
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject1 = new LinearLayout(this.mContext);
      paramView = new AbsListView.LayoutParams(-1, -2);
      ((LinearLayout)localObject1).setBackgroundResource(2130840999);
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setLayoutParams(paramView);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, this.jdO);
      localObject2 = new EmojiStoreV2RewardDetailUI.b(this.lqe);
      ((EmojiStoreV2RewardDetailUI.b)localObject2).leB = ((LinearLayout)localObject1);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        paramView = new LinearLayout.LayoutParams(this.loO, this.loO);
        paramView.leftMargin = this.jdO;
        paramViewGroup = new SquareImageView(this.mContext);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).leB.addView(paramViewGroup, i, paramView);
        i += 1;
      }
    }
    paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      int j = this.mNumColumns;
      localObject1 = (SquareImageView)paramViewGroup.leB.getChildAt(i);
      localObject2 = uv(j * paramInt + i);
      if (localObject2 != null)
      {
        ((SquareImageView)localObject1).setVisibility(0);
        if (!bo.isNullOrNil(((EmotionDonor)localObject2).HeadUrl)) {
          o.ahG().a(((EmotionDonor)localObject2).HeadUrl, (ImageView)localObject1, g.z(EmojiStoreV2RewardDetailUI.c(this.lqe), ((EmotionDonor)localObject2).HeadUrl, this.loO));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ((SquareImageView)localObject1).setImageBitmap(this.bXF);
        continue;
        ((SquareImageView)localObject1).setVisibility(8);
      }
    }
    AppMethodBeat.o(53676);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI.a
 * JD-Core Version:    0.7.0.1
 */