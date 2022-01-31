package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.protocal.c.bcq;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.view.SmileySubGrid;
import java.util.LinkedList;

class EmojiStoreDetailUI$a
  extends BaseAdapter
  implements com.tencent.mm.view.a.e
{
  public EmojiStoreDetailUI$a(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public int getCount()
  {
    if (EmojiStoreDetailUI.b(this.jeK) == null) {
      return 0;
    }
    return EmojiStoreDetailUI.b(this.jeK).sSi;
  }
  
  public Object getItem(int paramInt)
  {
    if ((EmojiStoreDetailUI.b(this.jeK) == null) || (EmojiStoreDetailUI.b(this.jeK).sSs == null) || (EmojiStoreDetailUI.b(this.jeK).sSs.size() <= 0) || (EmojiStoreDetailUI.b(this.jeK).sSs.get(paramInt) == null) || (((bcq)EmojiStoreDetailUI.b(this.jeK).sSs.get(paramInt)).txX == null)) {
      return null;
    }
    y.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[] { Integer.valueOf(paramInt) });
    ut localut = new ut();
    bcq localbcq = (bcq)EmojiStoreDetailUI.b(this.jeK).sSs.get(paramInt);
    localut.jnU = localbcq.jnU;
    localut.kSC = localbcq.txX;
    localut.mQp = localbcq.mQp;
    localut.sRu = localbcq.sRu;
    localut.syc = EmojiStoreDetailUI.a(this.jeK);
    localut.sRv = localbcq.sRv;
    localut.sRw = localbcq.sRw;
    localut.sRx = localbcq.sRx;
    return localut;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(EmojiStoreDetailUI.w(this.jeK)).inflate(f.f.emoji_store_detail_grid_item, null);
      paramViewGroup = new EmojiStoreDetailUI.c(this.jeK, paramView);
      paramView.setTag(paramViewGroup);
      if (!EmojiStoreDetailUI.x(this.jeK).wwH) {
        break label146;
      }
      paramViewGroup.jeM.setBackgroundResource(f.d.smiley_item_bg2);
    }
    for (;;)
    {
      String str = "";
      if (EmojiStoreDetailUI.b(this.jeK).sSj != null) {
        str = aa.a((bml)EmojiStoreDetailUI.b(this.jeK).sSj.get(paramInt));
      }
      o.ON().a(str, paramViewGroup.jeM, com.tencent.mm.plugin.emoji.e.e.cJ(EmojiStoreDetailUI.a(this.jeK), str));
      return paramView;
      paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
      break;
      label146:
      paramViewGroup.jeM.setBackgroundDrawable(null);
    }
  }
  
  public final boolean pY(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.a
 * JD-Core Version:    0.7.0.1
 */