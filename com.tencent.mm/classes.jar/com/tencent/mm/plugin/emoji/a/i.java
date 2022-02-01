package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
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
  public static int oun = 60;
  private Context mContext;
  public LinkedList<com.tencent.mm.plugin.emoji.model.a> oum;
  private int ouo;
  private boolean oup;
  private ArrayList<String> ouq;
  private a our;
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.a> paramLinkedList)
  {
    AppMethodBeat.i(108342);
    this.ouo = 0;
    this.oup = false;
    this.ouq = new ArrayList();
    this.our = new a((byte)0);
    if (paramLinkedList == null)
    {
      paramContext = new IllegalAccessError("must has emoji banner list");
      AppMethodBeat.o(108342);
      throw paramContext;
    }
    this.mContext = paramContext;
    this.oum = new LinkedList();
    this.oum.addAll(paramLinkedList);
    this.our.ous = this;
    AppMethodBeat.o(108342);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108347);
    if (this.oum != null) {
      this.oum.clear();
    }
    if (this.ouq != null) {
      this.ouq.clear();
    }
    this.oup = true;
    this.our.ous = null;
    AppMethodBeat.o(108347);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(176178);
    if (this.oum == null)
    {
      AppMethodBeat.o(176178);
      return null;
    }
    int i = paramInt % this.oum.size();
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
      localObject = (com.tencent.mm.plugin.emoji.model.a)this.oum.get(i);
      if (localObject != null) {
        break;
      }
      ad.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      AppMethodBeat.o(176178);
      return null;
      localb = (b)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.et(this.mContext)[0];
      int k = j * 3 / 8;
      localb.ouv.setLayoutParams(new RelativeLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.a)localObject).owG)
    {
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).owE.BannerImg.StripUrl;
      if (bt.isNullOrNil(((com.tencent.mm.plugin.emoji.model.a)localObject).owE.LocateUrl))
      {
        paramView = "H5";
        if ((localObject != null) && (!bt.isNullOrNil(str)))
        {
          com.tencent.mm.cd.a.getDensity(this.mContext);
          localObject = EmojiLogic.x(paramView, 8, str);
          if (localObject != null) {
            break label397;
          }
          if (!this.ouq.contains(str)) {
            break label351;
          }
          ad.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          localb.ouv.setImageFilePath("-");
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
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).owF.BannerImg.StripUrl;
      paramView = ((com.tencent.mm.plugin.emoji.model.a)localObject).owF.BannerSummary.ProductID;
      break;
      label351:
      o.ayJ().a(str, null, e.h(paramView, str, new Object[] { paramView, "BANNER" }), this.our);
      this.ouq.add(str);
      continue;
      label397:
      localb.ouv.setImageFilePath(((EmojiInfo)localObject).gaa());
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108343);
    if (this.oum == null)
    {
      AppMethodBeat.o(108343);
      return 0;
    }
    if (this.oum.size() == 1)
    {
      AppMethodBeat.o(108343);
      return 1;
    }
    int i = this.oum.size();
    int j = oun;
    AppMethodBeat.o(108343);
    return i * j;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(108345);
    if (this.ouo > 0)
    {
      this.ouo -= 1;
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
    if (!this.oup)
    {
      this.ouo = getCount();
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
    int i = ((Integer)paramView.getTag(2131299375)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.a)this.oum.get(i);
    EmotionSummary localEmotionSummary;
    if (paramView != null)
    {
      if (paramView.owG)
      {
        com.tencent.mm.plugin.emoji.e.k.a(this.mContext, paramView.owE, true);
        AppMethodBeat.o(108348);
        return;
      }
      localEmotionSummary = paramView.owF.BannerSummary;
      if (localEmotionSummary != null) {
        if (localEmotionSummary != null) {
          break label141;
        }
      }
    }
    label141:
    for (paramView = "";; paramView = localEmotionSummary.ProductID)
    {
      ad.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      h.vKh.f(11929, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, localEmotionSummary, 15, -1, -1, "", 8);
      AppMethodBeat.o(108348);
      return;
    }
  }
  
  static final class a
    implements com.tencent.mm.aw.a.c.k
  {
    i ous;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(108340);
      ad.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108339);
          if (i.a.this.ous != null) {
            i.a.this.ous.notifyDataSetChanged();
          }
          AppMethodBeat.o(108339);
        }
      });
      AppMethodBeat.o(108340);
    }
  }
  
  final class b
  {
    StoreBannerEmojiView ouv;
    ImageView ouw;
    
    public b(View paramView)
    {
      AppMethodBeat.i(108341);
      this.ouv = ((StoreBannerEmojiView)paramView.findViewById(2131299332));
      this.ouw = ((ImageView)paramView.findViewById(2131302799));
      this.ouv.setDefaultImageResource(0);
      AppMethodBeat.o(108341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */