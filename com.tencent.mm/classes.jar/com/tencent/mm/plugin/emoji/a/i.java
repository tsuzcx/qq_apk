package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.af;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends af
  implements View.OnClickListener
{
  public static int xHg = 60;
  private Context mContext;
  public LinkedList<com.tencent.mm.plugin.emoji.model.b> xHf;
  private int xHh;
  public boolean xHi;
  public ArrayList<String> xHj;
  public a xHk;
  
  public i(Context paramContext, LinkedList<com.tencent.mm.plugin.emoji.model.b> paramLinkedList)
  {
    AppMethodBeat.i(108342);
    this.xHh = 0;
    this.xHi = false;
    this.xHj = new ArrayList();
    this.xHk = new a((byte)0);
    if (paramLinkedList == null)
    {
      paramContext = new IllegalAccessError("must has emoji banner list");
      AppMethodBeat.o(108342);
      throw paramContext;
    }
    this.mContext = paramContext;
    this.xHf = new LinkedList();
    this.xHf.addAll(paramLinkedList);
    this.xHk.xHl = this;
    AppMethodBeat.o(108342);
  }
  
  public final View g(int paramInt, View paramView)
  {
    AppMethodBeat.i(176178);
    if (this.xHf == null)
    {
      AppMethodBeat.o(176178);
      return null;
    }
    int i = paramInt % this.xHf.size();
    View localView;
    b localb;
    if (paramView == null)
    {
      Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
      localView = View.inflate(this.mContext, h.f.emoji_store_v3_banner_item, null);
      localb = new b(localView);
      localView.setTag(localb);
    }
    Object localObject;
    for (;;)
    {
      localView.setTag(h.e.emoji_header_vp_id, Integer.valueOf(i));
      localView.setOnClickListener(this);
      localObject = (com.tencent.mm.plugin.emoji.model.b)this.xHf.get(i);
      if (localObject != null) {
        break;
      }
      Log.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
      AppMethodBeat.o(176178);
      return null;
      localb = (b)paramView.getTag();
      int j = com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.getScreenWH(this.mContext)[0];
      int k = j * 3 / 8;
      localb.xHn.setLayoutParams(new LinearLayout.LayoutParams(j, k + 1));
      localView = paramView;
    }
    String str;
    if (((com.tencent.mm.plugin.emoji.model.b)localObject).xMp)
    {
      str = ((com.tencent.mm.plugin.emoji.model.b)localObject).xMn.akjS.akjT;
      if (Util.isNullOrNil(((com.tencent.mm.plugin.emoji.model.b)localObject).xMn.akjU))
      {
        paramView = "H5";
        if ((localObject != null) && (!Util.isNullOrNil(str)))
        {
          com.tencent.mm.cd.a.getDensity(this.mContext);
          localObject = EmojiLogic.K(paramView, 8, str);
          if (localObject != null) {
            break label399;
          }
          if (!this.xHj.contains(str)) {
            break label353;
          }
          Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
          localb.xHn.setImageFilePath("-");
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
      str = ((com.tencent.mm.plugin.emoji.model.b)localObject).xMo.akjS.akjT;
      paramView = ((com.tencent.mm.plugin.emoji.model.b)localObject).xMo.akjR.ProductID;
      break;
      label353:
      r.bKe().a(str, null, e.l(paramView, str, new Object[] { paramView, "BANNER" }), this.xHk);
      this.xHj.add(str);
      continue;
      label399:
      localb.xHn.setImageFilePath(((EmojiInfo)localObject).kMn());
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108343);
    if (this.xHf == null)
    {
      AppMethodBeat.o(108343);
      return 0;
    }
    if (this.xHf.size() == 1)
    {
      AppMethodBeat.o(108343);
      return 1;
    }
    int i = this.xHf.size();
    int j = xHg;
    AppMethodBeat.o(108343);
    return i * j;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(108345);
    if (this.xHh > 0)
    {
      this.xHh -= 1;
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
    if (!this.xHi)
    {
      this.xHh = getCount();
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i = ((Integer)paramView.getTag(h.e.emoji_header_vp_id)).intValue();
    paramView = (com.tencent.mm.plugin.emoji.model.b)this.xHf.get(i);
    if (paramView != null)
    {
      if (!paramView.xMp) {
        break label111;
      }
      com.tencent.mm.plugin.emoji.mgr.k.a(this.mContext, paramView.xMn, true);
    }
    label111:
    do
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108348);
      return;
      localObject = paramView.xMo.akjR;
    } while (localObject == null);
    if (localObject == null) {}
    for (paramView = "";; paramView = ((cjb)localObject).ProductID)
    {
      Log.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", new Object[] { paramView });
      h.OAn.b(11929, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.emoji.mgr.k.a(this.mContext, (cjb)localObject, 15, -1, -1, "", 8);
      break;
    }
  }
  
  public static final class a
    implements com.tencent.mm.modelimage.loader.b.k
  {
    public i xHl;
    
    public final void onImageLoadComplete(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(108340);
      Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108339);
          if (i.this != null) {
            i.this.notifyDataSetChanged();
          }
          AppMethodBeat.o(108339);
        }
      });
      AppMethodBeat.o(108340);
    }
  }
  
  final class b
  {
    StoreBannerEmojiView xHn;
    ImageView xHo;
    
    public b(View paramView)
    {
      AppMethodBeat.i(108341);
      this.xHn = ((StoreBannerEmojiView)paramView.findViewById(h.e.emoji_bar_view));
      this.xHo = ((ImageView)paramView.findViewById(h.e.new_tips));
      this.xHn.setDefaultImageResource(0);
      AppMethodBeat.o(108341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */