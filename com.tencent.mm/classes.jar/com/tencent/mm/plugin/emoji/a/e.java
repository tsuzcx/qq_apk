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
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.List;

public final class e
  extends ArrayAdapter<EmojiGroupInfo>
{
  private static final int xGE = h.f.emoji_sort_item;
  private final String TAG;
  private Context mContext;
  private int xGF;
  public List<EmojiGroupInfo> xGG;
  
  public e(Context paramContext, List<EmojiGroupInfo> paramList)
  {
    super(paramContext, xGE, paramList);
    AppMethodBeat.i(108316);
    this.TAG = "MicroMsg.emoji.EmojiSortAdapter";
    this.xGF = paramContext.getResources().getDimensionPixelSize(h.c.emoji_item_list_height);
    this.mContext = paramContext;
    this.xGG = paramList;
    AppMethodBeat.o(108316);
  }
  
  public final void dyk()
  {
    AppMethodBeat.i(108317);
    if (this.xGG == null)
    {
      AppMethodBeat.o(108317);
      return;
    }
    int j = this.xGG.size();
    int i = 0;
    while (i < j)
    {
      ((EmojiGroupInfo)this.xGG.get(i)).field_idx = i;
      i += 1;
    }
    s.getEmojiStorageMgr().adjv.ne(this.xGG);
    EmojiGroupInfo localEmojiGroupInfo = s.getEmojiStorageMgr().adjv.ec(EmojiGroupInfo.aklE, false);
    localEmojiGroupInfo.field_sort = (this.xGG.size() + 2);
    s.getEmojiStorageMgr();
    if (!com.tencent.mm.storage.emotion.c.jda())
    {
      com.tencent.mm.storage.emotion.c localc = s.getEmojiStorageMgr().adjv;
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
      paramView = LayoutInflater.from(this.mContext).inflate(xGE, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localEmojiGroupInfo = (EmojiGroupInfo)getItem(paramInt);
      if (!com.tencent.mm.plugin.emoji.g.c.a(localEmojiGroupInfo)) {
        break label115;
      }
      paramViewGroup.pJJ.setText(h.h.emoji_store_tuzi_title);
      label74:
      if (!com.tencent.mm.plugin.emoji.g.c.a(localEmojiGroupInfo)) {
        break label130;
      }
      paramViewGroup.ttT.setImageResource(h.d.icon_002_cover);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(108318);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label115:
      paramViewGroup.pJJ.setText(localEmojiGroupInfo.field_packName);
      break label74;
      label130:
      r.bKe().a(localEmojiGroupInfo.field_packIconUrl, paramViewGroup.ttT, com.tencent.mm.plugin.emoji.mgr.e.gJ(localEmojiGroupInfo.field_productID, localEmojiGroupInfo.field_packIconUrl));
    }
  }
  
  final class a
  {
    TextView pJJ;
    ImageView ttT;
    View xGH;
    ImageView xGI;
    
    public a(View paramView)
    {
      AppMethodBeat.i(108315);
      this.xGI = ((ImageView)paramView.findViewById(h.e.emoji_store_manager_list_item_updonw));
      this.ttT = ((ImageView)paramView.findViewById(h.e.emoji_store_manager_list_item_icon));
      this.pJJ = ((TextView)paramView.findViewById(h.e.emoji_store_manager_list_item_title));
      this.xGH = paramView.findViewById(h.e.emoji_item_container);
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