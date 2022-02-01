package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerImg;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends x
  implements View.OnClickListener
{
  public static int pIc = 60;
  private Context mContext;
  public LinkedList<com.tencent.mm.plugin.emoji.model.a> pIb;
  private int pId;
  private boolean pIe;
  private ArrayList<String> pIf;
  private a pIg;
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.a> paramLinkedList)
  {
    AppMethodBeat.i(108342);
    this.pId = 0;
    this.pIe = false;
    this.pIf = new ArrayList();
    this.pIg = new a((byte)0);
    if (paramLinkedList == null)
    {
      paramContext = new IllegalAccessError("must has emoji banner list");
      AppMethodBeat.o(108342);
      throw paramContext;
    }
    this.mContext = paramContext;
    this.pIb = new LinkedList();
    this.pIb.addAll(paramLinkedList);
    this.pIg.pIh = this;
    AppMethodBeat.o(108342);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108347);
    if (this.pIb != null) {
      this.pIb.clear();
    }
    if (this.pIf != null) {
      this.pIf.clear();
    }
    this.pIe = true;
    this.pIg.pIh = null;
    AppMethodBeat.o(108347);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(176178);
    if (this.pIb == null)
    {
      AppMethodBeat.o(176178);
      return null;
    }
    int i = paramInt % this.pIb.size();
    View localView;
    b localb;
    if (paramView == null)
    {
      ae.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
      localView = View.inflate(this.mContext, 2131493832, null);
      localb = new b(localView);
      localView.setTag(localb);
    }
    Object localObject;
    for (;;)
    {
      localView.setTag(2131299375, Integer.valueOf(i));
      localView.setOnClickListener(this);
      localObject = (com.tencent.mm.plugin.emoji.model.a)this.pIb.get(i);
      if (localObject != null) {
        break;
      }
      ae.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      AppMethodBeat.o(176178);
      return null;
      localb = (b)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.eF(this.mContext)[0];
      int k = j * 3 / 8;
      localb.pIj.setLayoutParams(new RelativeLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.a)localObject).pKu)
    {
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).pKs.BannerImg.StripUrl;
      if (bu.isNullOrNil(((com.tencent.mm.plugin.emoji.model.a)localObject).pKs.LocateUrl))
      {
        paramView = "H5";
        if ((localObject != null) && (!bu.isNullOrNil(str)))
        {
          com.tencent.mm.cb.a.getDensity(this.mContext);
          localObject = EmojiLogic.A(paramView, 8, str);
          if (localObject != null) {
            break label397;
          }
          if (!this.pIf.contains(str)) {
            break label351;
          }
          ae.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          localb.pIj.setImageFilePath("-");
        }
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), str });
      AppMethodBeat.o(176178);
      return localView;
      paramView = "Toptic";
      break;
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).pKt.BannerImg.StripUrl;
      paramView = ((com.tencent.mm.plugin.emoji.model.a)localObject).pKt.BannerSummary.ProductID;
      break;
      label351:
      q.aJb().a(str, null, e.h(paramView, str, new Object[] { paramView, "BANNER" }), this.pIg);
      this.pIf.add(str);
      continue;
      label397:
      localb.pIj.setImageFilePath(((EmojiInfo)localObject).fSQ());
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108343);
    if (this.pIb == null)
    {
      AppMethodBeat.o(108343);
      return 0;
    }
    if (this.pIb.size() == 1)
    {
      AppMethodBeat.o(108343);
      return 1;
    }
    int i = this.pIb.size();
    int j = pIc;
    AppMethodBeat.o(108343);
    return i * j;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(108345);
    if (this.pId > 0)
    {
      this.pId -= 1;
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
    if (!this.pIe)
    {
      this.pId = getCount();
      super.notifyDataSetChanged();
      AppMethodBeat.o(108344);
      return;
    }
    ae.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
    AppMethodBeat.o(108344);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108348);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    int i = ((Integer)paramView.getTag(2131299375)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.a)this.pIb.get(i);
    if (paramView != null)
    {
      if (!paramView.pKu) {
        break label110;
      }
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, paramView.pKs, true);
    }
    label110:
    do
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108348);
      return;
      localObject = paramView.pKt.BannerSummary;
    } while (localObject == null);
    if (localObject == null) {}
    for (paramView = "";; paramView = ((EmotionSummary)localObject).ProductID)
    {
      ae.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      g.yxI.f(11929, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, (EmotionSummary)localObject, 15, -1, -1, "", 8);
      break;
    }
  }
  
  static final class a
    implements com.tencent.mm.av.a.c.k
  {
    i pIh;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(108340);
      ae.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108339);
          if (i.a.this.pIh != null) {
            i.a.this.pIh.notifyDataSetChanged();
          }
          AppMethodBeat.o(108339);
        }
      });
      AppMethodBeat.o(108340);
    }
  }
  
  final class b
  {
    StoreBannerEmojiView pIj;
    ImageView pIk;
    
    public b(View paramView)
    {
      AppMethodBeat.i(108341);
      this.pIj = ((StoreBannerEmojiView)paramView.findViewById(2131299332));
      this.pIk = ((ImageView)paramView.findViewById(2131302799));
      this.pIj.setDefaultImageResource(0);
      AppMethodBeat.o(108341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */