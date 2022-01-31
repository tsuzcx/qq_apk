package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends w
  implements View.OnClickListener
{
  public static int iVy = 60;
  public boolean iVA = false;
  public ArrayList<String> iVB = new ArrayList();
  private com.tencent.mm.as.a.c.i iVC = new i.1(this);
  public LinkedList<com.tencent.mm.plugin.emoji.model.a> iVx;
  private int iVz = 0;
  private Context mContext;
  private ah mHandler = new ah();
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.a> paramLinkedList)
  {
    if (paramLinkedList == null) {
      throw new IllegalAccessError("must has emoji banner list");
    }
    this.mContext = paramContext;
    this.iVx = new LinkedList();
    this.iVx.addAll(paramLinkedList);
  }
  
  public final int F(Object paramObject)
  {
    if (this.iVz > 0)
    {
      this.iVz -= 1;
      return -2;
    }
    return super.F(paramObject);
  }
  
  public final int getCount()
  {
    int i = 1;
    if (this.iVx == null) {
      i = 0;
    }
    while (this.iVx.size() == 1) {
      return i;
    }
    return this.iVx.size() * iVy;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.iVx == null) {
      return null;
    }
    int i = paramInt % this.iVx.size();
    View localView;
    if (paramView == null)
    {
      y.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
      localView = View.inflate(this.mContext, f.f.emoji_store_vp_header_item, null);
      paramViewGroup = new i.a(this, localView);
      localView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localView.setTag(f.e.emoji_header_vp_id, Integer.valueOf(i));
      localView.setOnClickListener(this);
      localObject = (com.tencent.mm.plugin.emoji.model.a)this.iVx.get(i);
      if (localObject != null) {
        break;
      }
      y.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      return null;
      paramViewGroup = (i.a)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.cY(this.mContext)[0];
      int k = j * 3 / 8;
      paramViewGroup.iVF.setLayoutParams(new RelativeLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.a)localObject).iXS)
    {
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).iXQ.sRR.sRS;
      if (bk.bl(((com.tencent.mm.plugin.emoji.model.a)localObject).iXQ.sRT))
      {
        paramView = "H5";
        if ((localObject != null) && (!bk.bl(str)))
        {
          com.tencent.mm.cb.a.getDensity(this.mContext);
          localObject = EmojiLogic.t(paramView, 8, str);
          if (localObject != null) {
            break label378;
          }
          if (!this.iVB.contains(str)) {
            break label332;
          }
          y.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          paramViewGroup.iVF.setImageFilePath("-");
        }
      }
    }
    for (;;)
    {
      y.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), str });
      return localView;
      paramView = "Toptic";
      break;
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).iXR.sRR.sRS;
      paramView = ((com.tencent.mm.plugin.emoji.model.a)localObject).iXR.sRQ.syc;
      break;
      label332:
      o.ON().a(str, null, e.h(paramView, str, new Object[] { paramView, "BANNER" }), this.iVC);
      this.iVB.add(str);
      continue;
      label378:
      paramViewGroup.iVF.setImageFilePath(((EmojiInfo)localObject).cwL());
    }
  }
  
  public final void notifyDataSetChanged()
  {
    if (!this.iVA)
    {
      this.iVz = getCount();
      super.notifyDataSetChanged();
      return;
    }
    y.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
  }
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(f.e.emoji_header_vp_id)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.a)this.iVx.get(i);
    if (paramView != null)
    {
      if (!paramView.iXS) {
        break label50;
      }
      k.a(this.mContext, paramView.iXQ, true);
    }
    label50:
    vn localvn;
    do
    {
      return;
      localvn = paramView.iXR.sRQ;
    } while (localvn == null);
    if (localvn == null) {}
    for (paramView = "";; paramView = localvn.syc)
    {
      y.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      h.nFQ.f(11929, new Object[] { Integer.valueOf(0) });
      k.a(this.mContext, localvn, 15, -1, -1, "", 8);
      return;
    }
  }
  
  public final void setData(LinkedList<com.tencent.mm.plugin.emoji.model.a> paramLinkedList)
  {
    this.iVx.clear();
    this.iVx.addAll(paramLinkedList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */