package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerImg;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends x
  implements View.OnClickListener
{
  public static int oXO = 60;
  private Context mContext;
  public LinkedList<com.tencent.mm.plugin.emoji.model.a> oXN;
  private int oXP;
  private boolean oXQ;
  private ArrayList<String> oXR;
  private a oXS;
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.a> paramLinkedList)
  {
    AppMethodBeat.i(108342);
    this.oXP = 0;
    this.oXQ = false;
    this.oXR = new ArrayList();
    this.oXS = new a((byte)0);
    if (paramLinkedList == null)
    {
      paramContext = new IllegalAccessError("must has emoji banner list");
      AppMethodBeat.o(108342);
      throw paramContext;
    }
    this.mContext = paramContext;
    this.oXN = new LinkedList();
    this.oXN.addAll(paramLinkedList);
    this.oXS.oXT = this;
    AppMethodBeat.o(108342);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108347);
    if (this.oXN != null) {
      this.oXN.clear();
    }
    if (this.oXR != null) {
      this.oXR.clear();
    }
    this.oXQ = true;
    this.oXS.oXT = null;
    AppMethodBeat.o(108347);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(176178);
    if (this.oXN == null)
    {
      AppMethodBeat.o(176178);
      return null;
    }
    int i = paramInt % this.oXN.size();
    View localView;
    b localb;
    if (paramView == null)
    {
      ac.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
      localView = View.inflate(this.mContext, 2131493832, null);
      localb = new b(localView);
      localView.setTag(localb);
    }
    Object localObject;
    for (;;)
    {
      localView.setTag(2131299375, Integer.valueOf(i));
      localView.setOnClickListener(this);
      localObject = (com.tencent.mm.plugin.emoji.model.a)this.oXN.get(i);
      if (localObject != null) {
        break;
      }
      ac.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      AppMethodBeat.o(176178);
      return null;
      localb = (b)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.eB(this.mContext)[0];
      int k = j * 3 / 8;
      localb.oXV.setLayoutParams(new RelativeLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.a)localObject).pag)
    {
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).pae.BannerImg.StripUrl;
      if (bs.isNullOrNil(((com.tencent.mm.plugin.emoji.model.a)localObject).pae.LocateUrl))
      {
        paramView = "H5";
        if ((localObject != null) && (!bs.isNullOrNil(str)))
        {
          com.tencent.mm.cc.a.getDensity(this.mContext);
          localObject = EmojiLogic.x(paramView, 8, str);
          if (localObject != null) {
            break label397;
          }
          if (!this.oXR.contains(str)) {
            break label351;
          }
          ac.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          localb.oXV.setImageFilePath("-");
        }
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), str });
      AppMethodBeat.o(176178);
      return localView;
      paramView = "Toptic";
      break;
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).paf.BannerImg.StripUrl;
      paramView = ((com.tencent.mm.plugin.emoji.model.a)localObject).paf.BannerSummary.ProductID;
      break;
      label351:
      o.aFB().a(str, null, e.h(paramView, str, new Object[] { paramView, "BANNER" }), this.oXS);
      this.oXR.add(str);
      continue;
      label397:
      localb.oXV.setImageFilePath(((EmojiInfo)localObject).ghd());
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108343);
    if (this.oXN == null)
    {
      AppMethodBeat.o(108343);
      return 0;
    }
    if (this.oXN.size() == 1)
    {
      AppMethodBeat.o(108343);
      return 1;
    }
    int i = this.oXN.size();
    int j = oXO;
    AppMethodBeat.o(108343);
    return i * j;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(108345);
    if (this.oXP > 0)
    {
      this.oXP -= 1;
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
    if (!this.oXQ)
    {
      this.oXP = getCount();
      super.notifyDataSetChanged();
      AppMethodBeat.o(108344);
      return;
    }
    ac.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
    AppMethodBeat.o(108344);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108348);
    int i = ((Integer)paramView.getTag(2131299375)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.a)this.oXN.get(i);
    EmotionSummary localEmotionSummary;
    if (paramView != null)
    {
      if (paramView.pag)
      {
        com.tencent.mm.plugin.emoji.e.k.a(this.mContext, paramView.pae, true);
        AppMethodBeat.o(108348);
        return;
      }
      localEmotionSummary = paramView.paf.BannerSummary;
      if (localEmotionSummary != null) {
        if (localEmotionSummary != null) {
          break label141;
        }
      }
    }
    label141:
    for (paramView = "";; paramView = localEmotionSummary.ProductID)
    {
      ac.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      h.wUl.f(11929, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, localEmotionSummary, 15, -1, -1, "", 8);
      AppMethodBeat.o(108348);
      return;
    }
  }
  
  static final class a
    implements com.tencent.mm.av.a.c.k
  {
    i oXT;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(108340);
      ac.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108339);
          if (i.a.this.oXT != null) {
            i.a.this.oXT.notifyDataSetChanged();
          }
          AppMethodBeat.o(108339);
        }
      });
      AppMethodBeat.o(108340);
    }
  }
  
  final class b
  {
    StoreBannerEmojiView oXV;
    ImageView oXW;
    
    public b(View paramView)
    {
      AppMethodBeat.i(108341);
      this.oXV = ((StoreBannerEmojiView)paramView.findViewById(2131299332));
      this.oXW = ((ImageView)paramView.findViewById(2131302799));
      this.oXV.setDefaultImageResource(0);
      AppMethodBeat.o(108341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */