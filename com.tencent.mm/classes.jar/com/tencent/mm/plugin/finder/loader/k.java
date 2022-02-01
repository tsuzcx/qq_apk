package com.tencent.mm.plugin.finder.loader;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.loader.h.a.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "Lcom/tencent/mm/loader/model/data/ILoaderDataMatrix;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "localThumbUrl", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;Ljava/lang/String;)V", "getLocalThumbUrl", "()Ljava/lang/String;", "setLocalThumbUrl", "(Ljava/lang/String;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getType", "()Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "setType", "(Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "getDecodeKey", "getMatrix", "Landroid/graphics/Matrix;", "width", "", "height", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public class k
  implements d, o
{
  public static final a uIz;
  cjl uIw;
  private x uIx;
  public String uIy;
  private String username;
  
  static
  {
    AppMethodBeat.i(248224);
    uIz = new a((byte)0);
    AppMethodBeat.o(248224);
  }
  
  private k(cjl paramcjl, x paramx, String paramString1, String paramString2)
  {
    AppMethodBeat.i(248222);
    String str = z.aTY();
    p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.uIw = paramcjl;
    this.uIx = paramx;
    this.username = paramString1;
    this.uIy = paramString2;
    if (paramcjl.url == null) {
      b.e("FinderImage", "mediaObj.url == null " + Util.getStack());
    }
    AppMethodBeat.o(248222);
  }
  
  public Matrix D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(248221);
    if (this.uIx == x.vEo)
    {
      AppMethodBeat.o(248221);
      return null;
    }
    Object localObject = this.uIw.MoU;
    if (localObject != null)
    {
      Matrix localMatrix = new Matrix();
      localObject = new Rect((int)((aty)localObject).left, (int)((aty)localObject).top, (int)((aty)localObject).right, (int)((aty)localObject).bottom);
      paramFloat1 = Math.max(paramFloat1 / ((Rect)localObject).width(), paramFloat2 / ((Rect)localObject).height());
      int i = -((Rect)localObject).left;
      int j = -((Rect)localObject).top;
      localMatrix.postScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate(i * paramFloat1, paramFloat1 * j);
      AppMethodBeat.o(248221);
      return localMatrix;
    }
    AppMethodBeat.o(248221);
    return null;
  }
  
  public String aBE()
  {
    AppMethodBeat.i(248219);
    int i;
    if (((CharSequence)this.uIy).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label61;
      }
      String str2 = this.uIw.thumbUrl;
      str1 = str2;
      if (str2 != null) {}
    }
    label61:
    for (String str1 = "";; str1 = this.uIy)
    {
      p.g(str1, "if (localThumbUrl.isEmpt… ?: \"\" else localThumbUrl");
      AppMethodBeat.o(248219);
      return str1;
      i = 0;
      break;
    }
  }
  
  public String auA()
  {
    AppMethodBeat.i(248218);
    StringBuilder localStringBuilder = new StringBuilder("finder_image_").append(this.uIx.detail).append('_');
    if (Util.isNullOrNil(this.uIw.mediaId)) {}
    for (String str = MD5Util.getMD5String(Util.nullAs(this.uIw.url, ""));; str = this.uIw.mediaId)
    {
      str = str;
      AppMethodBeat.o(248218);
      return str;
    }
  }
  
  public final x djU()
  {
    return this.uIx;
  }
  
  public final String djV()
  {
    String str2 = this.uIw.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String djW()
  {
    String str2 = this.uIw.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String djX()
  {
    AppMethodBeat.i(248220);
    if (((CharSequence)this.uIy).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      String str1;
      if (i != 0)
      {
        String str2 = this.uIw.thumb_url_token;
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "";
      }
      AppMethodBeat.o(248220);
      return str1;
    }
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(248217);
    if (((CharSequence)this.uIy).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = al.waC;
      localObject = al.a(this);
      AppMethodBeat.o(248217);
      return localObject;
    }
    Object localObject = this.uIy;
    AppMethodBeat.o(248217);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.uIw.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.k
 * JD-Core Version:    0.7.0.1
 */