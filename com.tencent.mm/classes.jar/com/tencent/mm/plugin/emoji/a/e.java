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
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import java.util.List;

public final class e
  extends ArrayAdapter<EmojiGroupInfo>
{
  private static final int otM = 2131493792;
  private final String TAG;
  private Context mContext;
  private int otN;
  public List<EmojiGroupInfo> otO;
  
  public e(Context paramContext, List<EmojiGroupInfo> paramList)
  {
    super(paramContext, otM, paramList);
    AppMethodBeat.i(108316);
    this.TAG = "MicroMsg.emoji.EmojiSortAdapter";
    this.otN = paramContext.getResources().getDimensionPixelSize(2131166229);
    this.mContext = paramContext;
    this.otO = paramList;
    AppMethodBeat.o(108316);
  }
  
  public final void bUu()
  {
    AppMethodBeat.i(108317);
    if (this.otO == null)
    {
      AppMethodBeat.o(108317);
      return;
    }
    int j = this.otO.size();
    int i = 0;
    while (i < j)
    {
      ((EmojiGroupInfo)this.otO.get(i)).field_idx = i;
      i += 1;
    }
    k.getEmojiStorageMgr().FyZ.hl(this.otO);
    EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().FyZ.cy(EmojiGroupInfo.LBO, false);
    localEmojiGroupInfo.field_sort = (this.otO.size() + 2);
    k.getEmojiStorageMgr();
    if (!c.eNl())
    {
      c localc = k.getEmojiStorageMgr().FyZ;
      if (localEmojiGroupInfo != null)
      {
        ad.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", new Object[] { localEmojiGroupInfo.field_packName, Long.valueOf(localEmojiGroupInfo.field_lastUseTime), Integer.valueOf(localEmojiGroupInfo.field_sort) });
        localc.replace(localEmojiGroupInfo);
        localc.doNotify("event_update_group", 0, bt.eGN().toString());
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
      paramView = LayoutInflater.from(this.mContext).inflate(otM, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localEmojiGroupInfo = (EmojiGroupInfo)getItem(paramInt);
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label132;
      }
      paramViewGroup.ica.setText(2131758385);
      label73:
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label147;
      }
      paramViewGroup.kXS.setImageResource(2131232662);
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.otP.setBackgroundResource(2131231820);
      }
      paramView.setVisibility(0);
      AppMethodBeat.o(108318);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label132:
      paramViewGroup.ica.setText(localEmojiGroupInfo.field_packName);
      break label73;
      label147:
      o.ayJ().a(localEmojiGroupInfo.field_packIconUrl, paramViewGroup.kXS, com.tencent.mm.plugin.emoji.e.e.eX(localEmojiGroupInfo.field_productID, localEmojiGroupInfo.field_packIconUrl));
    }
  }
  
  final class a
  {
    TextView ica;
    ImageView kXS;
    View otP;
    ImageView otQ;
    
    public a(View paramView)
    {
      AppMethodBeat.i(108315);
      this.otQ = ((ImageView)paramView.findViewById(2131299444));
      this.kXS = ((ImageView)paramView.findViewById(2131299442));
      this.ica = ((TextView)paramView.findViewById(2131299443));
      this.otP = paramView.findViewById(2131299381);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */