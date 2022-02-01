package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.ab;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends ab
  implements View.OnClickListener
{
  public static int uAD = 60;
  private Context mContext;
  public LinkedList<com.tencent.mm.plugin.emoji.model.b> uAC;
  private int uAE;
  private boolean uAF;
  private ArrayList<String> uAG;
  private a uAH;
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.b> paramLinkedList)
  {
    AppMethodBeat.i(108342);
    this.uAE = 0;
    this.uAF = false;
    this.uAG = new ArrayList();
    this.uAH = new a((byte)0);
    if (paramLinkedList == null)
    {
      paramContext = new IllegalAccessError("must has emoji banner list");
      AppMethodBeat.o(108342);
      throw paramContext;
    }
    this.mContext = paramContext;
    this.uAC = new LinkedList();
    this.uAC.addAll(paramLinkedList);
    this.uAH.uAI = this;
    AppMethodBeat.o(108342);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108347);
    if (this.uAC != null) {
      this.uAC.clear();
    }
    if (this.uAG != null) {
      this.uAG.clear();
    }
    this.uAF = true;
    this.uAH.uAI = null;
    AppMethodBeat.o(108347);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(176178);
    if (this.uAC == null)
    {
      AppMethodBeat.o(176178);
      return null;
    }
    int i = paramInt % this.uAC.size();
    View localView;
    b localb;
    if (paramView == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
      localView = View.inflate(this.mContext, i.f.emoji_store_vp_header_item, null);
      localb = new b(localView);
      localView.setTag(localb);
    }
    Object localObject;
    for (;;)
    {
      localView.setTag(i.e.emoji_header_vp_id, Integer.valueOf(i));
      localView.setOnClickListener(this);
      localObject = (com.tencent.mm.plugin.emoji.model.b)this.uAC.get(i);
      if (localObject != null) {
        break;
      }
      Log.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      AppMethodBeat.o(176178);
      return null;
      localb = (b)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.getScreenWH(this.mContext)[0];
      int k = j * 3 / 8;
      localb.uAK.setLayoutParams(new RelativeLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.b)localObject).uDY)
    {
      str = ((com.tencent.mm.plugin.emoji.model.b)localObject).uDW.Tel.Tem;
      if (Util.isNullOrNil(((com.tencent.mm.plugin.emoji.model.b)localObject).uDW.Ten))
      {
        paramView = "H5";
        if ((localObject != null) && (!Util.isNullOrNil(str)))
        {
          com.tencent.mm.ci.a.getDensity(this.mContext);
          localObject = EmojiLogic.I(paramView, 8, str);
          if (localObject != null) {
            break label399;
          }
          if (!this.uAG.contains(str)) {
            break label353;
          }
          Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          localb.uAK.setImageFilePath("-");
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
      str = ((com.tencent.mm.plugin.emoji.model.b)localObject).uDX.Tel.Tem;
      paramView = ((com.tencent.mm.plugin.emoji.model.b)localObject).uDX.Tej.ProductID;
      break;
      label353:
      q.bml().a(str, null, e.k(paramView, str, new Object[] { paramView, "BANNER" }), this.uAH);
      this.uAG.add(str);
      continue;
      label399:
      localb.uAK.setImageFilePath(((EmojiInfo)localObject).ifh());
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108343);
    if (this.uAC == null)
    {
      AppMethodBeat.o(108343);
      return 0;
    }
    if (this.uAC.size() == 1)
    {
      AppMethodBeat.o(108343);
      return 1;
    }
    int i = this.uAC.size();
    int j = uAD;
    AppMethodBeat.o(108343);
    return i * j;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(108345);
    if (this.uAE > 0)
    {
      this.uAE -= 1;
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
    if (!this.uAF)
    {
      this.uAE = getCount();
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
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i = ((Integer)paramView.getTag(i.e.emoji_header_vp_id)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.b)this.uAC.get(i);
    if (paramView != null)
    {
      if (!paramView.uDY) {
        break label111;
      }
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, paramView.uDW, true);
    }
    label111:
    do
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108348);
      return;
      localObject = paramView.uDX.Tej;
    } while (localObject == null);
    if (localObject == null) {}
    for (paramView = "";; paramView = ((akh)localObject).ProductID)
    {
      Log.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      h.IzE.a(11929, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.emoji.e.k.a(this.mContext, (akh)localObject, 15, -1, -1, "", 8);
      break;
    }
  }
  
  static final class a
    implements com.tencent.mm.ay.a.c.k
  {
    i uAI;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(108340);
      Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108339);
          if (i.a.this.uAI != null) {
            i.a.this.uAI.notifyDataSetChanged();
          }
          AppMethodBeat.o(108339);
        }
      });
      AppMethodBeat.o(108340);
    }
  }
  
  final class b
  {
    StoreBannerEmojiView uAK;
    ImageView uAL;
    
    public b(View paramView)
    {
      AppMethodBeat.i(108341);
      this.uAK = ((StoreBannerEmojiView)paramView.findViewById(i.e.emoji_bar_view));
      this.uAL = ((ImageView)paramView.findViewById(i.e.new_tips));
      this.uAK.setDefaultImageResource(0);
      AppMethodBeat.o(108341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */