package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import java.util.List;

public final class e
  extends ArrayAdapter<EmojiGroupInfo>
{
  private static final int uAb = i.f.emoji_sort_item;
  private final String TAG;
  private Context mContext;
  private int uAc;
  public List<EmojiGroupInfo> uAd;
  
  public e(Context paramContext, List<EmojiGroupInfo> paramList)
  {
    super(paramContext, uAb, paramList);
    AppMethodBeat.i(108316);
    this.TAG = "MicroMsg.emoji.EmojiSortAdapter";
    this.uAc = paramContext.getResources().getDimensionPixelSize(i.c.emoji_item_list_height);
    this.mContext = paramContext;
    this.uAd = paramList;
    AppMethodBeat.o(108316);
  }
  
  public final void cTP()
  {
    AppMethodBeat.i(108317);
    if (this.uAd == null)
    {
      AppMethodBeat.o(108317);
      return;
    }
    int j = this.uAd.size();
    int i = 0;
    while (i < j)
    {
      ((EmojiGroupInfo)this.uAd.get(i)).field_idx = i;
      i += 1;
    }
    p.getEmojiStorageMgr().VFI.jQ(this.uAd);
    EmojiGroupInfo localEmojiGroupInfo = p.getEmojiStorageMgr().VFI.dt(EmojiGroupInfo.YCv, false);
    localEmojiGroupInfo.field_sort = (this.uAd.size() + 2);
    p.getEmojiStorageMgr();
    if (!c.hAZ())
    {
      c localc = p.getEmojiStorageMgr().VFI;
      if (localEmojiGroupInfo != null)
      {
        Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", new Object[] { localEmojiGroupInfo.field_packName, Long.valueOf(localEmojiGroupInfo.field_lastUseTime), Integer.valueOf(localEmojiGroupInfo.field_sort) });
        localc.replace(localEmojiGroupInfo);
        localc.doNotify("event_update_group", 0, Util.getStack().toString());
      }
    }
    AppMethodBeat.o(108317);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108318);
    EmojiGroupInfo localEmojiGroupInfo;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(uAb, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localEmojiGroupInfo = (EmojiGroupInfo)getItem(paramInt);
      if (!com.tencent.mm.plugin.emoji.i.a.b(localEmojiGroupInfo)) {
        break label135;
      }
      paramViewGroup.mNb.setText(i.h.emoji_store_tuzi_title);
      label74:
      if (!com.tencent.mm.plugin.emoji.i.a.b(localEmojiGroupInfo)) {
        break label150;
      }
      paramViewGroup.qps.setImageResource(i.d.icon_002_cover);
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.uAe.setBackgroundResource(i.d.comm_list_item_selector_no_divider);
      }
      paramView.setVisibility(0);
      AppMethodBeat.o(108318);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label135:
      paramViewGroup.mNb.setText(localEmojiGroupInfo.field_packName);
      break label74;
      label150:
      q.bml().a(localEmojiGroupInfo.field_packIconUrl, paramViewGroup.qps, com.tencent.mm.plugin.emoji.e.e.gd(localEmojiGroupInfo.field_productID, localEmojiGroupInfo.field_packIconUrl));
    }
  }
  
  final class a
  {
    TextView mNb;
    ImageView qps;
    View uAe;
    ImageView uAf;
    
    public a(View paramView)
    {
      AppMethodBeat.i(108315);
      this.uAf = ((ImageView)paramView.findViewById(i.e.emoji_store_manager_list_item_updonw));
      this.qps = ((ImageView)paramView.findViewById(i.e.emoji_store_manager_list_item_icon));
      this.mNb = ((TextView)paramView.findViewById(i.e.emoji_store_manager_list_item_title));
      this.uAe = paramView.findViewById(i.e.emoji_item_container);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = e.a(e.this);
        paramView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(108315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */