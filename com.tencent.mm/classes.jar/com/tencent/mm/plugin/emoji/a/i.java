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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerImg;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.z;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends z
  implements View.OnClickListener
{
  public static int qXO = 60;
  private Context mContext;
  public LinkedList<com.tencent.mm.plugin.emoji.model.a> qXN;
  private int qXP;
  private boolean qXQ;
  private ArrayList<String> qXR;
  private a qXS;
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.a> paramLinkedList)
  {
    AppMethodBeat.i(108342);
    this.qXP = 0;
    this.qXQ = false;
    this.qXR = new ArrayList();
    this.qXS = new a((byte)0);
    if (paramLinkedList == null)
    {
      paramContext = new IllegalAccessError("must has emoji banner list");
      AppMethodBeat.o(108342);
      throw paramContext;
    }
    this.mContext = paramContext;
    this.qXN = new LinkedList();
    this.qXN.addAll(paramLinkedList);
    this.qXS.qXT = this;
    AppMethodBeat.o(108342);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108347);
    if (this.qXN != null) {
      this.qXN.clear();
    }
    if (this.qXR != null) {
      this.qXR.clear();
    }
    this.qXQ = true;
    this.qXS.qXT = null;
    AppMethodBeat.o(108347);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(176178);
    if (this.qXN == null)
    {
      AppMethodBeat.o(176178);
      return null;
    }
    int i = paramInt % this.qXN.size();
    View localView;
    b localb;
    if (paramView == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
      localView = View.inflate(this.mContext, 2131493986, null);
      localb = new b(localView);
      localView.setTag(localb);
    }
    Object localObject;
    for (;;)
    {
      localView.setTag(2131299988, Integer.valueOf(i));
      localView.setOnClickListener(this);
      localObject = (com.tencent.mm.plugin.emoji.model.a)this.qXN.get(i);
      if (localObject != null) {
        break;
      }
      Log.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      AppMethodBeat.o(176178);
      return null;
      localb = (b)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.getScreenWH(this.mContext)[0];
      int k = j * 3 / 8;
      localb.qXV.setLayoutParams(new RelativeLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.a)localObject).raX)
    {
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).raV.BannerImg.StripUrl;
      if (Util.isNullOrNil(((com.tencent.mm.plugin.emoji.model.a)localObject).raV.LocateUrl))
      {
        paramView = "H5";
        if ((localObject != null) && (!Util.isNullOrNil(str)))
        {
          com.tencent.mm.cb.a.getDensity(this.mContext);
          localObject = EmojiLogic.H(paramView, 8, str);
          if (localObject != null) {
            break label397;
          }
          if (!this.qXR.contains(str)) {
            break label351;
          }
          Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          localb.qXV.setImageFilePath("-");
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), str });
      AppMethodBeat.o(176178);
      return localView;
      paramView = "Toptic";
      break;
      str = ((com.tencent.mm.plugin.emoji.model.a)localObject).raW.BannerImg.StripUrl;
      paramView = ((com.tencent.mm.plugin.emoji.model.a)localObject).raW.BannerSummary.ProductID;
      break;
      label351:
      q.bcV().a(str, null, e.j(paramView, str, new Object[] { paramView, "BANNER" }), this.qXS);
      this.qXR.add(str);
      continue;
      label397:
      localb.qXV.setImageFilePath(((EmojiInfo)localObject).hRM());
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108343);
    if (this.qXN == null)
    {
      AppMethodBeat.o(108343);
      return 0;
    }
    if (this.qXN.size() == 1)
    {
      AppMethodBeat.o(108343);
      return 1;
    }
    int i = this.qXN.size();
    int j = qXO;
    AppMethodBeat.o(108343);
    return i * j;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(108345);
    if (this.qXP > 0)
    {
      this.qXP -= 1;
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
    if (!this.qXQ)
    {
      this.qXP = getCount();
      super.notifyDataSetChanged();
      AppMethodBeat.o(108344);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
    AppMethodBeat.o(108344);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108348);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    int i = ((Integer)paramView.getTag(2131299988)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.a)this.qXN.get(i);
    if (paramView != null)
    {
      if (!paramView.raX) {
        break label110;
      }
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, paramView.raV, true);
    }
    label110:
    do
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108348);
      return;
      localObject = paramView.raW.BannerSummary;
    } while (localObject == null);
    if (localObject == null) {}
    for (paramView = "";; paramView = ((EmotionSummary)localObject).ProductID)
    {
      Log.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      h.CyF.a(11929, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, (EmotionSummary)localObject, 15, -1, -1, "", 8);
      break;
    }
  }
  
  static final class a
    implements com.tencent.mm.av.a.c.k
  {
    i qXT;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(108340);
      Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108339);
          if (i.a.this.qXT != null) {
            i.a.this.qXT.notifyDataSetChanged();
          }
          AppMethodBeat.o(108339);
        }
      });
      AppMethodBeat.o(108340);
    }
  }
  
  final class b
  {
    StoreBannerEmojiView qXV;
    ImageView qXW;
    
    public b(View paramView)
    {
      AppMethodBeat.i(108341);
      this.qXV = ((StoreBannerEmojiView)paramView.findViewById(2131299944));
      this.qXW = ((ImageView)paramView.findViewById(2131305369));
      this.qXV.setDefaultImageResource(0);
      AppMethodBeat.o(108341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */