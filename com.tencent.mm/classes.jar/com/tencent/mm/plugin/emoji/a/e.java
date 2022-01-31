package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.List;

public final class e
  extends ArrayAdapter<EmojiGroupInfo>
{
  private static final int iUY = f.f.emoji_sort_item;
  private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
  private int iUZ;
  public List<EmojiGroupInfo> iVa;
  private Context mContext;
  
  public e(Context paramContext, List<EmojiGroupInfo> paramList)
  {
    super(paramContext, iUY, paramList);
    this.iUZ = paramContext.getResources().getDimensionPixelSize(f.c.emoji_item_list_height);
    this.mContext = paramContext;
    this.iVa = paramList;
  }
  
  public final void aGT()
  {
    if (this.iVa == null) {}
    EmojiGroupInfo localEmojiGroupInfo;
    com.tencent.mm.storage.emotion.a locala;
    do
    {
      do
      {
        return;
        int j = this.iVa.size();
        int i = 0;
        while (i < j)
        {
          ((EmojiGroupInfo)this.iVa.get(i)).field_idx = i;
          i += 1;
        }
        i.getEmojiStorageMgr().uBc.dH(this.iVa);
        localEmojiGroupInfo = i.getEmojiStorageMgr().uBc.bE(EmojiGroupInfo.uCR, false);
        localEmojiGroupInfo.field_sort = (this.iVa.size() + 2);
        locala = i.getEmojiStorageMgr().uBc;
      } while (com.tencent.mm.storage.emotion.a.cwo());
      locala = i.getEmojiStorageMgr().uBc;
    } while (localEmojiGroupInfo == null);
    y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", new Object[] { localEmojiGroupInfo.field_packName, Long.valueOf(localEmojiGroupInfo.field_lastUseTime), Integer.valueOf(localEmojiGroupInfo.field_sort) });
    locala.a(localEmojiGroupInfo);
    locala.b("event_update_group", 0, bk.csb().toString());
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EmojiGroupInfo localEmojiGroupInfo;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(iUY, null);
      paramViewGroup = new e.a(this, paramView);
      paramView.setTag(paramViewGroup);
      localEmojiGroupInfo = (EmojiGroupInfo)getItem(paramInt);
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label125;
      }
      paramViewGroup.eXO.setText(f.h.emoji_store_tuzi_title);
      label69:
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label140;
      }
      paramViewGroup.gSx.setImageResource(f.d.icon_002_cover);
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.iVb.setBackgroundResource(f.d.comm_list_item_selector_no_divider);
      }
      paramView.setVisibility(0);
      return paramView;
      paramViewGroup = (e.a)paramView.getTag();
      break;
      label125:
      paramViewGroup.eXO.setText(localEmojiGroupInfo.field_packName);
      break label69;
      label140:
      o.ON().a(localEmojiGroupInfo.field_packIconUrl, paramViewGroup.gSx, com.tencent.mm.plugin.emoji.e.e.cJ(localEmojiGroupInfo.field_productID, localEmojiGroupInfo.field_packIconUrl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */