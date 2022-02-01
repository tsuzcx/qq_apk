package com.tencent.mm.plugin.finder.loader;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.loader.h.a.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "Lcom/tencent/mm/loader/model/data/ILoaderDataMatrix;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "localThumbUrl", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;Ljava/lang/String;)V", "getLocalThumbUrl", "()Ljava/lang/String;", "setLocalThumbUrl", "(Ljava/lang/String;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getType", "()Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "setType", "(Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "getDecodeKey", "getMatrix", "Landroid/graphics/Matrix;", "width", "", "height", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public class r
  implements d, w
{
  public static final a ztR;
  private String username;
  private csg ztO;
  private u ztP;
  public String ztQ;
  
  static
  {
    AppMethodBeat.i(271912);
    ztR = new a((byte)0);
    AppMethodBeat.o(271912);
  }
  
  private r(csg paramcsg, u paramu, String paramString1, String paramString2)
  {
    AppMethodBeat.i(271910);
    String str = z.bcZ();
    p.j(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.ztO = paramcsg;
    this.ztP = paramu;
    this.username = paramString1;
    this.ztQ = paramString2;
    if (paramcsg.url == null) {
      b.e("FinderImage", "mediaObj.url == null " + Util.getStack());
    }
    AppMethodBeat.o(271910);
  }
  
  public Matrix F(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(271907);
    if (this.ztP == u.Alz)
    {
      AppMethodBeat.o(271907);
      return null;
    }
    Object localObject = this.ztO.TAa;
    if (localObject != null)
    {
      Matrix localMatrix = new Matrix();
      localObject = new Rect((int)((awc)localObject).left, (int)((awc)localObject).top, (int)((awc)localObject).right, (int)((awc)localObject).bottom);
      paramFloat1 = Math.max(paramFloat1 / ((Rect)localObject).width(), paramFloat2 / ((Rect)localObject).height());
      int i = -((Rect)localObject).left;
      int j = -((Rect)localObject).top;
      localMatrix.postScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate(i * paramFloat1, paramFloat1 * j);
      AppMethodBeat.o(271907);
      return localMatrix;
    }
    AppMethodBeat.o(271907);
    return null;
  }
  
  public String aBv()
  {
    AppMethodBeat.i(271904);
    StringBuilder localStringBuilder = new StringBuilder("finder_image_").append(this.ztP.detail).append('_');
    if (Util.isNullOrNil(this.ztO.mediaId)) {}
    for (String str = MD5Util.getMD5String(Util.nullAs(this.ztO.url, ""));; str = this.ztO.mediaId)
    {
      str = str;
      AppMethodBeat.o(271904);
      return str;
    }
  }
  
  public String aJi()
  {
    AppMethodBeat.i(271905);
    int i;
    if (((CharSequence)this.ztQ).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label61;
      }
      String str2 = this.ztO.thumbUrl;
      str1 = str2;
      if (str2 != null) {}
    }
    label61:
    for (String str1 = "";; str1 = this.ztQ)
    {
      p.j(str1, "if (localThumbUrl.isEmpt… ?: \"\" else localThumbUrl");
      AppMethodBeat.o(271905);
      return str1;
      i = 0;
      break;
    }
  }
  
  public final u dIX()
  {
    return this.ztP;
  }
  
  public final String dIY()
  {
    String str2 = this.ztO.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String dIZ()
  {
    String str2 = this.ztO.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String dJa()
  {
    AppMethodBeat.i(271906);
    if (((CharSequence)this.ztQ).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      String str1;
      if (i != 0)
      {
        String str2 = this.ztO.thumb_url_token;
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "";
      }
      AppMethodBeat.o(271906);
      return str1;
    }
  }
  
  public final csg dJd()
  {
    return this.ztO;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(271903);
    if (((CharSequence)this.ztQ).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = av.AJz;
      localObject = av.a(this);
      AppMethodBeat.o(271903);
      return localObject;
    }
    Object localObject = this.ztQ;
    AppMethodBeat.o(271903);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.ztO.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.r
 * JD-Core Version:    0.7.0.1
 */