package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerImg;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends x
  implements View.OnClickListener
{
  public static int leD = 60;
  public LinkedList<com.tencent.mm.plugin.emoji.model.a> leC;
  private int leE;
  private boolean leF;
  private ArrayList<String> leG;
  private i.a leH;
  private Context mContext;
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.a> paramLinkedList)
  {
    AppMethodBeat.i(52766);
    this.leE = 0;
    this.leF = false;
    this.leG = new ArrayList();
    this.leH = new i.a((byte)0);
    if (paramLinkedList == null)
    {
      paramContext = new IllegalAccessError("must has emoji banner list");
      AppMethodBeat.o(52766);
      throw paramContext;
    }
    this.mContext = paramContext;
    this.leC = new LinkedList();
    this.leC.addAll(paramLinkedList);
    this.leH.leI = this;
    AppMethodBeat.o(52766);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(52771);
    if (this.leC != null) {
      this.leC.clear();
    }
    if (this.leG != null) {
      this.leG.clear();
    }
    this.leF = true;
    this.leH.leI = null;
    AppMethodBeat.o(52771);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(52767);
    if (this.leC == null)
    {
      AppMethodBeat.o(52767);
      return 0;
    }
    if (this.leC.size() == 1)
    {
      AppMethodBeat.o(52767);
      return 1;
    }
    int i = this.leC.size();
    int j = leD;
    AppMethodBeat.o(52767);
    return i * j;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(52769);
    if (this.leE > 0)
    {
      this.leE -= 1;
      AppMethodBeat.o(52769);
      return -2;
    }
    int i = super.getItemPosition(paramObject);
    AppMethodBeat.o(52769);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(52770);
    if (this.leC == null)
    {
      AppMethodBeat.o(52770);
      return null;
    }
    int i = paramInt % this.leC.size();
    View localView;
    if (paramView == null)
    {
      ab.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
      localView = View.inflate(this.mContext, 2130969420, null);
      paramViewGroup = new b(localView);
      localView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localView.setTag(2131820595, Integer.valueOf(i));
      localView.setOnClickListener(this);
      localObject = (com.tencent.mm.plugin.emoji.model.a)this.leC.get(i);
      if (localObject != null) {
        break;
      }
      ab.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      AppMethodBeat.o(52770);
      return null;
      paramViewGroup = (b)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.dh(this.mContext)[0];
      int k = j * 3 / 8;
      paramViewGroup.leK.setLayoutParams(new RelativeLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.a)localObject).lgZ)
    {
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).lgX.BannerImg.StripUrl;
      if (bo.isNullOrNil(((com.tencent.mm.plugin.emoji.model.a)localObject).lgX.LocateUrl))
      {
        paramView = "H5";
        if ((localObject != null) && (!bo.isNullOrNil(str)))
        {
          com.tencent.mm.cb.a.getDensity(this.mContext);
          localObject = EmojiLogic.s(paramView, 8, str);
          if (localObject != null) {
            break label396;
          }
          if (!this.leG.contains(str)) {
            break label350;
          }
          ab.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          paramViewGroup.leK.setImageFilePath("-");
        }
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), str });
      AppMethodBeat.o(52770);
      return localView;
      paramView = "Toptic";
      break;
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).lgY.BannerImg.StripUrl;
      paramView = ((com.tencent.mm.plugin.emoji.model.a)localObject).lgY.BannerSummary.ProductID;
      break;
      label350:
      o.ahG().a(str, null, g.h(paramView, str, new Object[] { paramView, "BANNER" }), this.leH);
      this.leG.add(str);
      continue;
      label396:
      paramViewGroup.leK.setImageFilePath(((EmojiInfo)localObject).dQB());
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(52768);
    if (!this.leF)
    {
      this.leE = getCount();
      super.notifyDataSetChanged();
      AppMethodBeat.o(52768);
      return;
    }
    ab.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
    AppMethodBeat.o(52768);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(52772);
    int i = ((Integer)paramView.getTag(2131820595)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.a)this.leC.get(i);
    EmotionSummary localEmotionSummary;
    if (paramView != null)
    {
      if (paramView.lgZ)
      {
        m.a(this.mContext, paramView.lgX, true);
        AppMethodBeat.o(52772);
        return;
      }
      localEmotionSummary = paramView.lgY.BannerSummary;
      if (localEmotionSummary != null) {
        if (localEmotionSummary != null) {
          break label141;
        }
      }
    }
    label141:
    for (paramView = "";; paramView = localEmotionSummary.ProductID)
    {
      ab.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      h.qsU.e(11929, new Object[] { Integer.valueOf(0) });
      m.a(this.mContext, localEmotionSummary, 15, -1, -1, "", 8);
      AppMethodBeat.o(52772);
      return;
    }
  }
  
  final class b
  {
    StoreBannerEmojiView leK;
    ImageView leL;
    
    public b(View paramView)
    {
      AppMethodBeat.i(52765);
      this.leK = ((StoreBannerEmojiView)paramView.findViewById(2131823664));
      this.leL = ((ImageView)paramView.findViewById(2131823665));
      this.leK.setDefaultImageResource(0);
      AppMethodBeat.o(52765);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */