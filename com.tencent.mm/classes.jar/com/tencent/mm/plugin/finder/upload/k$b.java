package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$b
  implements g.a
{
  k$b(k paramk) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(342842);
    if (paramd == null) {
      paramc = "null";
    }
    for (;;)
    {
      Log.i("Finder.UploadActivityCoverTask", "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
      if (paramInt == 0) {
        break;
      }
      Log.e("Finder.UploadActivityCoverTask", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      if (paramInt != -21005) {
        k.a(this.Gcf, i.nrH);
      }
      AppMethodBeat.o(342842);
      return 0;
      String str = paramd.toString();
      paramc = str;
      if (str == null) {
        paramc = "null";
      }
    }
    if ((!Util.isNullOrNil(paramString)) && (paramd != null))
    {
      Log.i("Finder.UploadActivityCoverTask", "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
      if (paramd.field_retCode != 0)
      {
        k.a(this.Gcf, i.nrH);
        AppMethodBeat.o(342842);
        return 0;
      }
      paramString = this.Gcf;
      paramc = paramd.field_fileUrl;
      s.s(paramc, "sceneResult.field_fileUrl");
      s.u(paramc, "<set-?>");
      paramString.coverUrl = paramc;
      k.a(this.Gcf, i.nrG);
    }
    AppMethodBeat.o(342842);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.k.b
 * JD-Core Version:    0.7.0.1
 */