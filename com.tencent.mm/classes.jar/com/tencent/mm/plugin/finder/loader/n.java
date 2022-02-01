package com.tencent.mm.plugin.finder.loader;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.loader.g.a.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "Lcom/tencent/mm/loader/model/data/ILoaderDataMatrix;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "localThumbUrl", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;Ljava/lang/String;)V", "getLocalThumbUrl", "()Ljava/lang/String;", "setLocalThumbUrl", "(Ljava/lang/String;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getType", "()Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "setType", "(Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "getDecodeKey", "getMatrix", "Landroid/graphics/Matrix;", "width", "", "height", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class n
  implements d, r
{
  public static final n.a ExD;
  private dji ExE;
  private v ExF;
  public String ExG;
  private String username;
  
  static
  {
    AppMethodBeat.i(331744);
    ExD = new n.a((byte)0);
    AppMethodBeat.o(331744);
  }
  
  private n(dji paramdji, v paramv, String paramString1, String paramString2)
  {
    AppMethodBeat.i(331735);
    String str = z.bAM();
    s.s(str, "getUsernameFromUserInfo()");
    this.username = str;
    this.ExE = paramdji;
    this.ExF = paramv;
    this.username = paramString1;
    this.ExG = paramString2;
    if (paramdji.url == null) {
      b.e("FinderImage", s.X("mediaObj.url == null ", Util.getStack()));
    }
    AppMethodBeat.o(331735);
  }
  
  public String aUt()
  {
    AppMethodBeat.i(331765);
    StringBuilder localStringBuilder = new StringBuilder("finder_image_").append(this.ExF.detail).append('_');
    if (Util.isNullOrNil(this.ExE.mediaId)) {}
    for (String str = MD5Util.getMD5String(Util.nullAs(this.ExE.url, ""));; str = this.ExE.mediaId)
    {
      str = str;
      AppMethodBeat.o(331765);
      return str;
    }
  }
  
  public Matrix aj(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(331793);
    if (this.ExF == v.FKZ)
    {
      AppMethodBeat.o(331793);
      return null;
    }
    Object localObject = this.ExE.aaPl;
    if (localObject != null)
    {
      Matrix localMatrix = new Matrix();
      localObject = new Rect((int)((bbn)localObject).left, (int)((bbn)localObject).top, (int)((bbn)localObject).right, (int)((bbn)localObject).bottom);
      paramFloat1 = Math.max(paramFloat1 / ((Rect)localObject).width(), paramFloat2 / ((Rect)localObject).height());
      int i = -((Rect)localObject).left;
      int j = -((Rect)localObject).top;
      localMatrix.postScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate(i * paramFloat1, paramFloat1 * j);
      AppMethodBeat.o(331793);
      return localMatrix;
    }
    AppMethodBeat.o(331793);
    return null;
  }
  
  public final v eCd()
  {
    return this.ExF;
  }
  
  public final String eCe()
  {
    String str2 = this.ExE.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String eCf()
  {
    String str2 = this.ExE.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String eCg()
  {
    AppMethodBeat.i(331783);
    int i;
    if (((CharSequence)this.ExG).length() == 0) {
      i = 1;
    }
    while (i != 0)
    {
      String str = this.ExE.thumb_url_token;
      if (str == null)
      {
        AppMethodBeat.o(331783);
        return "";
        i = 0;
      }
      else
      {
        AppMethodBeat.o(331783);
        return str;
      }
    }
    AppMethodBeat.o(331783);
    return "";
  }
  
  public String eCi()
  {
    AppMethodBeat.i(331778);
    int i;
    if (((CharSequence)this.ExG).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label64;
      }
      String str2 = this.ExE.thumbUrl;
      str1 = str2;
      if (str2 != null) {}
    }
    label64:
    for (String str1 = "";; str1 = this.ExG)
    {
      s.s(str1, "if (localThumbUrl.isEmpt… ?: \"\" else localThumbUrl");
      AppMethodBeat.o(331778);
      return str1;
      i = 0;
      break;
    }
  }
  
  public final dji eCk()
  {
    return this.ExE;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(331758);
    if (((CharSequence)this.ExG).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = bm.GlZ;
      localObject = bm.a(this);
      AppMethodBeat.o(331758);
      return localObject;
    }
    Object localObject = this.ExG;
    AppMethodBeat.o(331758);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.ExE.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.n
 * JD-Core Version:    0.7.0.1
 */