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
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import java.util.List;

public final class e
  extends ArrayAdapter<EmojiGroupInfo>
{
  private static final int pHB = 2131493792;
  private final String TAG;
  private Context mContext;
  private int pHC;
  public List<EmojiGroupInfo> pHD;
  
  public e(Context paramContext, List<EmojiGroupInfo> paramList)
  {
    super(paramContext, pHB, paramList);
    AppMethodBeat.i(108316);
    this.TAG = "MicroMsg.emoji.EmojiSortAdapter";
    this.pHC = paramContext.getResources().getDimensionPixelSize(2131166229);
    this.mContext = paramContext;
    this.pHD = paramList;
    AppMethodBeat.o(108316);
  }
  
  public final void chB()
  {
    AppMethodBeat.i(108317);
    if (this.pHD == null)
    {
      AppMethodBeat.o(108317);
      return;
    }
    int j = this.pHD.size();
    int i = 0;
    while (i < j)
    {
      ((EmojiGroupInfo)this.pHD.get(i)).field_idx = i;
      i += 1;
    }
    k.getEmojiStorageMgr().JfV.hU(this.pHD);
    EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().JfV.cN(EmojiGroupInfo.OzS, false);
    localEmojiGroupInfo.field_sort = (this.pHD.size() + 2);
    k.getEmojiStorageMgr();
    if (!c.fwX())
    {
      c localc = k.getEmojiStorageMgr().JfV;
      if (localEmojiGroupInfo != null)
      {
        ae.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", new Object[] { localEmojiGroupInfo.field_packName, Long.valueOf(localEmojiGroupInfo.field_lastUseTime), Integer.valueOf(localEmojiGroupInfo.field_sort) });
        localc.replace(localEmojiGroupInfo);
        localc.doNotify("event_update_group", 0, bu.fpN().toString());
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
      paramView = LayoutInflater.from(this.mContext).inflate(pHB, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localEmojiGroupInfo = (EmojiGroupInfo)getItem(paramInt);
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label132;
      }
      paramViewGroup.iYj.setText(2131758385);
      label73:
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label147;
      }
      paramViewGroup.mdt.setImageResource(2131232662);
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.pHE.setBackgroundResource(2131231820);
      }
      paramView.setVisibility(0);
      AppMethodBeat.o(108318);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label132:
      paramViewGroup.iYj.setText(localEmojiGroupInfo.field_packName);
      break label73;
      label147:
      q.aJb().a(localEmojiGroupInfo.field_packIconUrl, paramViewGroup.mdt, com.tencent.mm.plugin.emoji.e.e.fy(localEmojiGroupInfo.field_productID, localEmojiGroupInfo.field_packIconUrl));
    }
  }
  
  final class a
  {
    TextView iYj;
    ImageView mdt;
    View pHE;
    ImageView pHF;
    
    public a(View paramView)
    {
      AppMethodBeat.i(108315);
      this.pHF = ((ImageView)paramView.findViewById(2131299444));
      this.mdt = ((ImageView)paramView.findViewById(2131299442));
      this.iYj = ((TextView)paramView.findViewById(2131299443));
      this.pHE = paramView.findViewById(2131299381);
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