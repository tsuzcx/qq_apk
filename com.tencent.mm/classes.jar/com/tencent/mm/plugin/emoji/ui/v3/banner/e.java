package com.tencent.mm.plugin.emoji.ui.v3.banner;

import android.graphics.Bitmap;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/ImageLoaderListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoaderListener;", "()V", "adapter", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerAdapter;", "onImageLoadComplete", "", "url", "", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "extraObj", "", "", "(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;[Ljava/lang/Object;)V", "setAdapter", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements k
{
  public a ybz;
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(270562);
    s.u(parame, "this$0");
    parame = parame.ybz;
    if (parame != null) {
      parame.bZE.notifyChanged();
    }
    AppMethodBeat.o(270562);
  }
  
  public final void onImageLoadComplete(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(270577);
    s.u(paramVarArgs, "extraObj");
    paramView = new StringBuilder("onImageLoadComplete url:").append(paramString).append(", bitmap byteCount:");
    if (paramBitmap == null) {}
    for (paramString = null;; paramString = Integer.valueOf(paramBitmap.getByteCount()))
    {
      Log.i("MicroMsg.EmojiStoreV3Banner.ImageLoaderListener", paramString);
      MMHandlerThread.postToMainThread(new e..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(270577);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.banner.e
 * JD-Core Version:    0.7.0.1
 */