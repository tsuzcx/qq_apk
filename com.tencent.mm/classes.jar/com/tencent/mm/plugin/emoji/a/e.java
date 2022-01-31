package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.List;

public final class e
  extends ArrayAdapter<EmojiGroupInfo>
{
  private static final int lec = 2130969381;
  private final String TAG;
  private int led;
  public List<EmojiGroupInfo> lee;
  private Context mContext;
  
  public e(Context paramContext, List<EmojiGroupInfo> paramList)
  {
    super(paramContext, lec, paramList);
    AppMethodBeat.i(52740);
    this.TAG = "MicroMsg.emoji.EmojiSortAdapter";
    this.led = paramContext.getResources().getDimensionPixelSize(2131428372);
    this.mContext = paramContext;
    this.lee = paramList;
    AppMethodBeat.o(52740);
  }
  
  public final void bkF()
  {
    AppMethodBeat.i(52741);
    if (this.lee == null)
    {
      AppMethodBeat.o(52741);
      return;
    }
    int j = this.lee.size();
    int i = 0;
    while (i < j)
    {
      ((EmojiGroupInfo)this.lee.get(i)).field_idx = i;
      i += 1;
    }
    i.getEmojiStorageMgr().yNo.eQ(this.lee);
    EmojiGroupInfo localEmojiGroupInfo = i.getEmojiStorageMgr().yNo.cg(EmojiGroupInfo.yPe, false);
    localEmojiGroupInfo.field_sort = (this.lee.size() + 2);
    i.getEmojiStorageMgr();
    if (!com.tencent.mm.storage.emotion.a.dyZ())
    {
      com.tencent.mm.storage.emotion.a locala = i.getEmojiStorageMgr().yNo;
      if (localEmojiGroupInfo != null)
      {
        ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", new Object[] { localEmojiGroupInfo.field_packName, Long.valueOf(localEmojiGroupInfo.field_lastUseTime), Integer.valueOf(localEmojiGroupInfo.field_sort) });
        locala.replace(localEmojiGroupInfo);
        locala.doNotify("event_update_group", 0, bo.dtY().toString());
      }
    }
    AppMethodBeat.o(52741);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(52742);
    EmojiGroupInfo localEmojiGroupInfo;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(lec, null);
      paramViewGroup = new e.a(this, paramView);
      paramView.setTag(paramViewGroup);
      localEmojiGroupInfo = (EmojiGroupInfo)getItem(paramInt);
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label132;
      }
      paramViewGroup.gpL.setText(2131299259);
      label73:
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label147;
      }
      paramViewGroup.ivs.setImageResource(2130839105);
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.lef.setBackgroundResource(2130838447);
      }
      paramView.setVisibility(0);
      AppMethodBeat.o(52742);
      return paramView;
      paramViewGroup = (e.a)paramView.getTag();
      break;
      label132:
      paramViewGroup.gpL.setText(localEmojiGroupInfo.field_packName);
      break label73;
      label147:
      o.ahG().a(localEmojiGroupInfo.field_packIconUrl, paramViewGroup.ivs, g.dK(localEmojiGroupInfo.field_productID, localEmojiGroupInfo.field_packIconUrl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */