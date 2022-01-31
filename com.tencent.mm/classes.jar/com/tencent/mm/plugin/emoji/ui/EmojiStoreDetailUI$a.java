package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.PackThumbExt;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.view.SmileySubGrid;
import java.util.LinkedList;

class EmojiStoreDetailUI$a
  extends BaseAdapter
  implements com.tencent.mm.view.a.g
{
  public EmojiStoreDetailUI$a(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public int getCount()
  {
    AppMethodBeat.i(53440);
    if (EmojiStoreDetailUI.b(this.lnA) == null)
    {
      AppMethodBeat.o(53440);
      return 0;
    }
    int i = EmojiStoreDetailUI.b(this.lnA).PackThumbCnt;
    AppMethodBeat.o(53440);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(53441);
    if ((EmojiStoreDetailUI.b(this.lnA) == null) || (EmojiStoreDetailUI.b(this.lnA).ThumbExtList == null) || (EmojiStoreDetailUI.b(this.lnA).ThumbExtList.size() <= 0) || (EmojiStoreDetailUI.b(this.lnA).ThumbExtList.get(paramInt) == null) || (((PackThumbExt)EmojiStoreDetailUI.b(this.lnA).ThumbExtList.get(paramInt)).PreviewUrl == null))
    {
      AppMethodBeat.o(53441);
      return null;
    }
    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[] { Integer.valueOf(paramInt) });
    PackThumbExt localPackThumbExt = (PackThumbExt)EmojiStoreDetailUI.b(this.lnA).ThumbExtList.get(paramInt);
    EmojiInfo localEmojiInfo = new EmojiInfo();
    localEmojiInfo.field_md5 = localPackThumbExt.Md5;
    localEmojiInfo.field_thumbUrl = localPackThumbExt.ThumbUrl;
    localEmojiInfo.field_cdnUrl = localPackThumbExt.CDNUrl;
    localEmojiInfo.field_aeskey = localPackThumbExt.AesKey;
    localEmojiInfo.field_encrypturl = localPackThumbExt.EncryptUrl;
    localEmojiInfo.field_externUrl = localPackThumbExt.ExternUrl;
    localEmojiInfo.field_externMd5 = localPackThumbExt.ExternMd5;
    localEmojiInfo.field_activityid = localPackThumbExt.ActivityID;
    localEmojiInfo.field_groupId = EmojiStoreDetailUI.a(this.lnA);
    localEmojiInfo.field_catalog = 84;
    localEmojiInfo.field_reserved4 |= EmojiInfo.APx;
    AppMethodBeat.o(53441);
    return localEmojiInfo;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(53442);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(EmojiStoreDetailUI.w(this.lnA)).inflate(2130969384, null);
      paramViewGroup = new EmojiStoreDetailUI.c(this.lnA, paramView);
      paramView.setTag(paramViewGroup);
      if (!EmojiStoreDetailUI.x(this.lnA).ARJ) {
        break label154;
      }
      paramViewGroup.lnC.setBackgroundResource(2130840356);
    }
    for (;;)
    {
      String str = "";
      if (EmojiStoreDetailUI.b(this.lnA).PackThumbList != null) {
        str = aa.a((bwc)EmojiStoreDetailUI.b(this.lnA).PackThumbList.get(paramInt));
      }
      o.ahG().a(str, paramViewGroup.lnC, com.tencent.mm.plugin.emoji.e.g.dK(EmojiStoreDetailUI.a(this.lnA), str));
      AppMethodBeat.o(53442);
      return paramView;
      paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
      break;
      label154:
      paramViewGroup.lnC.setBackgroundDrawable(null);
    }
  }
  
  public final boolean uu(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.a
 * JD-Core Version:    0.7.0.1
 */