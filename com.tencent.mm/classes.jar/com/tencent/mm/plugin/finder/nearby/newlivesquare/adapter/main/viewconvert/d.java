package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.pluginsdk.ui.applet.m.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/HeadLivingConvertData;", "()V", "getLayoutId", "", "loadCoverBitmapWithUrl", "", "context", "Landroid/content/Context;", "url", "", "iv", "Landroid/widget/ImageView;", "defaultWidth", "defaultHeight", "callback", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "renderToBlurBg", "color", "bgIv", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends f<e>
{
  public static final a ENO;
  private static final int ENP;
  private static final int ENQ;
  private static final Map<String, Integer> vOT;
  
  static
  {
    AppMethodBeat.i(340550);
    ENO = new a((byte)0);
    ENP = a.fromDPToPix(MMApplicationContext.getContext(), 80);
    ENQ = a.fromDPToPix(MMApplicationContext.getContext(), 108);
    vOT = (Map)new HashMap();
    AppMethodBeat.o(340550);
  }
  
  private static void a(int paramInt, ImageView paramImageView, e parame)
  {
    AppMethodBeat.i(340536);
    Log.i("Finder.HeadLivingConvert", "#renderToBlurBg nickName=" + parame.feedObject.getNickName() + " load with url onProcessBitmap: color=" + paramInt);
    parame = (ShapeDrawable.ShaderFactory)new c(paramInt | 0xFF000000);
    PaintDrawable localPaintDrawable = new PaintDrawable();
    localPaintDrawable.setShape((Shape)new RectShape());
    localPaintDrawable.setShaderFactory(parame);
    paramImageView.setBackground((Drawable)localPaintDrawable);
    paramImageView.setVisibility(0);
    AppMethodBeat.o(340536);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340563);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(340563);
  }
  
  public final int getLayoutId()
  {
    return f.e.EGV;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingConvert$Companion;", "", "()V", "TAG", "", "bgColorMap", "", "", "dp108", "dp80", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingConvert$onBindViewHolder$5$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallbackEx;", "onFinish", "", "onProcessBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "onStart", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements m.b
  {
    b(e parame, ah.f<String> paramf, d paramd, ImageView paramImageView) {}
    
    private static final void a(e parame, ah.f paramf, d paramd, ImageView paramImageView, int paramInt)
    {
      AppMethodBeat.i(340473);
      s.u(parame, "$item");
      s.u(paramf, "$finallyBgUrl");
      s.u(paramd, "this$0");
      s.u(paramImageView, "$iv");
      Log.i("Finder.HeadLivingConvert", "#bind nickName=" + parame.feedObject.getNickName() + " load with url onProcessBitmap: color=" + paramInt);
      d.eFV().put(paramf.aqH, Integer.valueOf(paramInt));
      d.b(paramInt, paramImageView, parame);
      AppMethodBeat.o(340473);
    }
    
    public final boolean af(Bitmap paramBitmap)
    {
      AppMethodBeat.i(340490);
      com.tencent.mm.plugin.ball.f.d.a(paramBitmap, new d.b..ExternalSyntheticLambda0(this.ENR, this.ENS, this.ENT, this.ENU));
      AppMethodBeat.o(340490);
      return true;
    }
    
    public final void onFinish() {}
    
    public final void onStart() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/HeadLivingConvert$renderToBlurBg$sf$1", "Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;", "resize", "Landroid/graphics/Shader;", "width", "", "height", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ShapeDrawable.ShaderFactory
  {
    c(int paramInt) {}
    
    public final Shader resize(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(340472);
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt1 / 2.0F;
      float f3 = paramInt2;
      paramInt1 = this.ENV;
      paramInt2 = this.ENV;
      Object localObject = Shader.TileMode.CLAMP;
      localObject = (Shader)new LinearGradient(f1, 0.0F, f2, f3, new int[] { 0, paramInt1, paramInt2 }, new float[] { 0.0F, 0.58F, 1.0F }, (Shader.TileMode)localObject);
      AppMethodBeat.o(340472);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.d
 * JD-Core Version:    0.7.0.1
 */