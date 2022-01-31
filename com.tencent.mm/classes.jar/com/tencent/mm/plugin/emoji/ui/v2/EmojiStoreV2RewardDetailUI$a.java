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
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.IOException;
import java.util.LinkedList;

final class EmojiStoreV2RewardDetailUI$a
  extends BaseAdapter
{
  private Bitmap bwa = null;
  private LinkedList<vk> hkd;
  int hrb;
  private int iVq;
  int jfV;
  boolean jhm = false;
  private Context mContext;
  private int mNumColumns = 1;
  
  public EmojiStoreV2RewardDetailUI$a(EmojiStoreV2RewardDetailUI paramEmojiStoreV2RewardDetailUI, Context paramContext)
  {
    this.mContext = paramContext;
    this.jfV = com.tencent.mm.cb.a.aa(paramEmojiStoreV2RewardDetailUI.mController.uMN, f.c.emoji_donors_avatar_size);
    int k = com.tencent.mm.cb.a.fj(paramEmojiStoreV2RewardDetailUI.mController.uMN) - com.tencent.mm.cb.a.aa(paramEmojiStoreV2RewardDetailUI.mController.uMN, f.c.LargePadding) * 2;
    int m = this.jfV;
    int n = com.tencent.mm.cb.a.aa(paramEmojiStoreV2RewardDetailUI.mController.uMN, f.c.LittlePadding);
    int j = k / (m + n);
    int i = j;
    if (k - j * m - n * (j - 1) > m) {
      i = j + 1;
    }
    this.mNumColumns = i;
    this.iVq = com.tencent.mm.cb.a.fj(this.mContext);
    this.hrb = ((int)((this.iVq - this.mNumColumns * this.jfV) / (this.mNumColumns + 1.0F)));
    try
    {
      this.bwa = BackwardSupportUtil.b.a(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      return;
    }
    catch (IOException paramEmojiStoreV2RewardDetailUI)
    {
      y.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { bk.csb() });
    }
  }
  
  private vk pZ(int paramInt)
  {
    if (this.hkd != null) {
      if (this.hkd != null) {
        break label23;
      }
    }
    label23:
    for (int i = 0; paramInt >= i; i = this.hkd.size()) {
      return null;
    }
    return (vk)this.hkd.get(paramInt);
  }
  
  public final void Q(LinkedList<vk> paramLinkedList)
  {
    if (this.hkd == null) {
      this.hkd = new LinkedList();
    }
    if (this.jhm)
    {
      this.hkd.clear();
      this.jhm = false;
    }
    this.hkd.addAll(paramLinkedList);
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    if (this.hkd == null) {}
    for (int i = 0;; i = this.hkd.size())
    {
      int j = i;
      if (i > 0) {
        j = (int)Math.ceil(i / this.mNumColumns);
      }
      return j;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject1 = new LinearLayout(this.mContext);
      paramView = new AbsListView.LayoutParams(-1, -2);
      ((LinearLayout)localObject1).setBackgroundResource(f.d.transparent_background);
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setLayoutParams(paramView);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, this.hrb);
      localObject2 = new EmojiStoreV2RewardDetailUI.b(this.jhl);
      ((EmojiStoreV2RewardDetailUI.b)localObject2).iVw = ((LinearLayout)localObject1);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        paramView = new LinearLayout.LayoutParams(this.jfV, this.jfV);
        paramView.leftMargin = this.hrb;
        paramViewGroup = new SquareImageView(this.mContext);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).iVw.addView(paramViewGroup, i, paramView);
        i += 1;
      }
    }
    paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      int j = this.mNumColumns;
      localObject1 = (SquareImageView)paramViewGroup.iVw.getChildAt(i);
      localObject2 = pZ(j * paramInt + i);
      if (localObject2 != null)
      {
        ((SquareImageView)localObject1).setVisibility(0);
        if (!bk.bl(((vk)localObject2).sSy)) {
          o.ON().a(((vk)localObject2).sSy, (ImageView)localObject1, e.s(EmojiStoreV2RewardDetailUI.c(this.jhl), ((vk)localObject2).sSy, this.jfV));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ((SquareImageView)localObject1).setImageBitmap(this.bwa);
        continue;
        ((SquareImageView)localObject1).setVisibility(8);
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI.a
 * JD-Core Version:    0.7.0.1
 */