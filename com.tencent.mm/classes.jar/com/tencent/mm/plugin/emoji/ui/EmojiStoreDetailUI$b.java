package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

final class EmojiStoreDetailUI$b
  extends EmojiStoreDetailUI.a
{
  private ArrayList<EmojiInfo> jeL = new ArrayList();
  
  public EmojiStoreDetailUI$b(EmojiStoreDetailUI paramEmojiStoreDetailUI)
  {
    super(paramEmojiStoreDetailUI);
  }
  
  private EmojiInfo pW(int paramInt)
  {
    if (this.jeL == null) {
      return null;
    }
    return (EmojiInfo)this.jeL.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.jeL == null) {
      return 0;
    }
    return this.jeL.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(EmojiStoreDetailUI.w(this.jeK)).inflate(f.f.emoji_store_detail_grid_item, null);
      paramViewGroup = new EmojiStoreDetailUI.c(this.jeK, paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jeM.setBackgroundResource(f.d.smiley_item_bg2);
      localObject = pW(paramInt);
      if (!bk.bl(((EmojiInfo)localObject).getContent())) {
        break label121;
      }
    }
    label121:
    for (Object localObject = ((EmojiInfo)localObject).getName();; localObject = ((EmojiInfo)localObject).getContent())
    {
      localObject = localObject.split("\\.")[0];
      o.ON().a((String)localObject, paramViewGroup.jeM, e.aHe());
      return paramView;
      paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.b
 * JD-Core Version:    0.7.0.1
 */