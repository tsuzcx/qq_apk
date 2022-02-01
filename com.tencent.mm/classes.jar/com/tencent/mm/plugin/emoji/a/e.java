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
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import java.util.List;

public final class e
  extends ArrayAdapter<EmojiGroupInfo>
{
  private static final int pAX = 2131493792;
  private final String TAG;
  private Context mContext;
  private int pAY;
  public List<EmojiGroupInfo> pAZ;
  
  public e(Context paramContext, List<EmojiGroupInfo> paramList)
  {
    super(paramContext, pAX, paramList);
    AppMethodBeat.i(108316);
    this.TAG = "MicroMsg.emoji.EmojiSortAdapter";
    this.pAY = paramContext.getResources().getDimensionPixelSize(2131166229);
    this.mContext = paramContext;
    this.pAZ = paramList;
    AppMethodBeat.o(108316);
  }
  
  public final void cgl()
  {
    AppMethodBeat.i(108317);
    if (this.pAZ == null)
    {
      AppMethodBeat.o(108317);
      return;
    }
    int j = this.pAZ.size();
    int i = 0;
    while (i < j)
    {
      ((EmojiGroupInfo)this.pAZ.get(i)).field_idx = i;
      i += 1;
    }
    k.getEmojiStorageMgr().ILo.hK(this.pAZ);
    EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().ILo.cJ(EmojiGroupInfo.OeL, false);
    localEmojiGroupInfo.field_sort = (this.pAZ.size() + 2);
    k.getEmojiStorageMgr();
    if (!c.fsW())
    {
      c localc = k.getEmojiStorageMgr().ILo;
      if (localEmojiGroupInfo != null)
      {
        ad.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", new Object[] { localEmojiGroupInfo.field_packName, Long.valueOf(localEmojiGroupInfo.field_lastUseTime), Integer.valueOf(localEmojiGroupInfo.field_sort) });
        localc.replace(localEmojiGroupInfo);
        localc.doNotify("event_update_group", 0, bt.flS().toString());
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
      paramView = LayoutInflater.from(this.mContext).inflate(pAX, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localEmojiGroupInfo = (EmojiGroupInfo)getItem(paramInt);
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label132;
      }
      paramViewGroup.iVq.setText(2131758385);
      label73:
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label147;
      }
      paramViewGroup.lZa.setImageResource(2131232662);
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.pBa.setBackgroundResource(2131231820);
      }
      paramView.setVisibility(0);
      AppMethodBeat.o(108318);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label132:
      paramViewGroup.iVq.setText(localEmojiGroupInfo.field_packName);
      break label73;
      label147:
      q.aIJ().a(localEmojiGroupInfo.field_packIconUrl, paramViewGroup.lZa, com.tencent.mm.plugin.emoji.e.e.fu(localEmojiGroupInfo.field_productID, localEmojiGroupInfo.field_packIconUrl));
    }
  }
  
  final class a
  {
    TextView iVq;
    ImageView lZa;
    View pBa;
    ImageView pBb;
    
    public a(View paramView)
    {
      AppMethodBeat.i(108315);
      this.pBb = ((ImageView)paramView.findViewById(2131299444));
      this.lZa = ((ImageView)paramView.findViewById(2131299442));
      this.iVq = ((TextView)paramView.findViewById(2131299443));
      this.pBa = paramView.findViewById(2131299381);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */