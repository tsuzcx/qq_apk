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
  private static final int qXn = 2131493946;
  private final String TAG;
  private Context mContext;
  private int qXo;
  public List<EmojiGroupInfo> qXp;
  
  public e(Context paramContext, List<EmojiGroupInfo> paramList)
  {
    super(paramContext, qXn, paramList);
    AppMethodBeat.i(108316);
    this.TAG = "MicroMsg.emoji.EmojiSortAdapter";
    this.qXo = paramContext.getResources().getDimensionPixelSize(2131166272);
    this.mContext = paramContext;
    this.qXp = paramList;
    AppMethodBeat.o(108316);
  }
  
  public final void cFn()
  {
    AppMethodBeat.i(108317);
    if (this.qXp == null)
    {
      AppMethodBeat.o(108317);
      return;
    }
    int j = this.qXp.size();
    int i = 0;
    while (i < j)
    {
      ((EmojiGroupInfo)this.qXp.get(i)).field_idx = i;
      i += 1;
    }
    k.getEmojiStorageMgr().OpO.iY(this.qXp);
    EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().OpO.di(EmojiGroupInfo.Uun, false);
    localEmojiGroupInfo.field_sort = (this.qXp.size() + 2);
    k.getEmojiStorageMgr();
    if (!c.gEJ())
    {
      c localc = k.getEmojiStorageMgr().OpO;
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
      paramView = LayoutInflater.from(this.mContext).inflate(qXn, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localEmojiGroupInfo = (EmojiGroupInfo)getItem(paramInt);
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label132;
      }
      paramViewGroup.jVO.setText(2131758679);
      label73:
      if (!com.tencent.mm.plugin.emoji.h.a.b(localEmojiGroupInfo)) {
        break label147;
      }
      paramViewGroup.nnL.setImageResource(2131233072);
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.qXq.setBackgroundResource(2131231901);
      }
      paramView.setVisibility(0);
      AppMethodBeat.o(108318);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label132:
      paramViewGroup.jVO.setText(localEmojiGroupInfo.field_packName);
      break label73;
      label147:
      q.bcV().a(localEmojiGroupInfo.field_packIconUrl, paramViewGroup.nnL, com.tencent.mm.plugin.emoji.e.e.fQ(localEmojiGroupInfo.field_productID, localEmojiGroupInfo.field_packIconUrl));
    }
  }
  
  final class a
  {
    TextView jVO;
    ImageView nnL;
    View qXq;
    ImageView qXr;
    
    public a(View paramView)
    {
      AppMethodBeat.i(108315);
      this.qXr = ((ImageView)paramView.findViewById(2131300058));
      this.nnL = ((ImageView)paramView.findViewById(2131300056));
      this.jVO = ((TextView)paramView.findViewById(2131300057));
      this.qXq = paramView.findViewById(2131299994);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */