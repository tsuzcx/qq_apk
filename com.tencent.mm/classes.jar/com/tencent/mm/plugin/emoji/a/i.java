package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerImg;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends x
  implements View.OnClickListener
{
  public static int pBy = 60;
  private Context mContext;
  private boolean pBA;
  private ArrayList<String> pBB;
  private a pBC;
  public LinkedList<com.tencent.mm.plugin.emoji.model.a> pBx;
  private int pBz;
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.a> paramLinkedList)
  {
    AppMethodBeat.i(108342);
    this.pBz = 0;
    this.pBA = false;
    this.pBB = new ArrayList();
    this.pBC = new a((byte)0);
    if (paramLinkedList == null)
    {
      paramContext = new IllegalAccessError("must has emoji banner list");
      AppMethodBeat.o(108342);
      throw paramContext;
    }
    this.mContext = paramContext;
    this.pBx = new LinkedList();
    this.pBx.addAll(paramLinkedList);
    this.pBC.pBD = this;
    AppMethodBeat.o(108342);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108347);
    if (this.pBx != null) {
      this.pBx.clear();
    }
    if (this.pBB != null) {
      this.pBB.clear();
    }
    this.pBA = true;
    this.pBC.pBD = null;
    AppMethodBeat.o(108347);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(176178);
    if (this.pBx == null)
    {
      AppMethodBeat.o(176178);
      return null;
    }
    int i = paramInt % this.pBx.size();
    View localView;
    b localb;
    if (paramView == null)
    {
      ad.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
      localView = View.inflate(this.mContext, 2131493832, null);
      localb = new b(localView);
      localView.setTag(localb);
    }
    Object localObject;
    for (;;)
    {
      localView.setTag(2131299375, Integer.valueOf(i));
      localView.setOnClickListener(this);
      localObject = (com.tencent.mm.plugin.emoji.model.a)this.pBx.get(i);
      if (localObject != null) {
        break;
      }
      ad.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      AppMethodBeat.o(176178);
      return null;
      localb = (b)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.eB(this.mContext)[0];
      int k = j * 3 / 8;
      localb.pBF.setLayoutParams(new RelativeLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.a)localObject).pDQ)
    {
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).pDO.BannerImg.StripUrl;
      if (bt.isNullOrNil(((com.tencent.mm.plugin.emoji.model.a)localObject).pDO.LocateUrl))
      {
        paramView = "H5";
        if ((localObject != null) && (!bt.isNullOrNil(str)))
        {
          com.tencent.mm.cc.a.getDensity(this.mContext);
          localObject = EmojiLogic.y(paramView, 8, str);
          if (localObject != null) {
            break label397;
          }
          if (!this.pBB.contains(str)) {
            break label351;
          }
          ad.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          localb.pBF.setImageFilePath("-");
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), str });
      AppMethodBeat.o(176178);
      return localView;
      paramView = "Toptic";
      break;
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).pDP.BannerImg.StripUrl;
      paramView = ((com.tencent.mm.plugin.emoji.model.a)localObject).pDP.BannerSummary.ProductID;
      break;
      label351:
      q.aIJ().a(str, null, e.h(paramView, str, new Object[] { paramView, "BANNER" }), this.pBC);
      this.pBB.add(str);
      continue;
      label397:
      localb.pBF.setImageFilePath(((EmojiInfo)localObject).gzQ());
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108343);
    if (this.pBx == null)
    {
      AppMethodBeat.o(108343);
      return 0;
    }
    if (this.pBx.size() == 1)
    {
      AppMethodBeat.o(108343);
      return 1;
    }
    int i = this.pBx.size();
    int j = pBy;
    AppMethodBeat.o(108343);
    return i * j;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(108345);
    if (this.pBz > 0)
    {
      this.pBz -= 1;
      AppMethodBeat.o(108345);
      return -2;
    }
    int i = super.getItemPosition(paramObject);
    AppMethodBeat.o(108345);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108344);
    if (!this.pBA)
    {
      this.pBz = getCount();
      super.notifyDataSetChanged();
      AppMethodBeat.o(108344);
      return;
    }
    ad.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
    AppMethodBeat.o(108344);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108348);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    int i = ((Integer)paramView.getTag(2131299375)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.a)this.pBx.get(i);
    if (paramView != null)
    {
      if (!paramView.pDQ) {
        break label110;
      }
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, paramView.pDO, true);
    }
    label110:
    do
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108348);
      return;
      localObject = paramView.pDP.BannerSummary;
    } while (localObject == null);
    if (localObject == null) {}
    for (paramView = "";; paramView = ((EmotionSummary)localObject).ProductID)
    {
      ad.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      g.yhR.f(11929, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, (EmotionSummary)localObject, 15, -1, -1, "", 8);
      break;
    }
  }
  
  static final class a
    implements com.tencent.mm.aw.a.c.k
  {
    i pBD;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(108340);
      ad.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108339);
          if (i.a.this.pBD != null) {
            i.a.this.pBD.notifyDataSetChanged();
          }
          AppMethodBeat.o(108339);
        }
      });
      AppMethodBeat.o(108340);
    }
  }
  
  final class b
  {
    StoreBannerEmojiView pBF;
    ImageView pBG;
    
    public b(View paramView)
    {
      AppMethodBeat.i(108341);
      this.pBF = ((StoreBannerEmojiView)paramView.findViewById(2131299332));
      this.pBG = ((ImageView)paramView.findViewById(2131302799));
      this.pBF.setDefaultImageResource(0);
      AppMethodBeat.o(108341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */