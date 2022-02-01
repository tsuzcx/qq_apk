package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.h.a;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.io.ByteArrayOutputStream;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/loader/FinderCdnDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
public final class c$b
  implements g.a
{
  c$b(j paramj, b.b paramb, String paramString) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(166302);
    k.h(paramString, "mediaId");
    ac.i("Finder.FinderCdnDownloader", "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
    if (paramd != null)
    {
      if (this.rti == null)
      {
        AppMethodBeat.o(166302);
        return 0;
      }
      paramString = this.rtj;
      paramc = a.av(this.rtk, "");
      k.g(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
      paramString.a((f)paramc);
    }
    AppMethodBeat.o(166302);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(166303);
    k.h(paramString, "mediaId");
    k.h(paramByteArrayOutputStream, "buff");
    AppMethodBeat.o(166303);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(166304);
    k.h(paramString, "mediaId");
    k.h(paramArrayOfByte, "inbuf");
    AppMethodBeat.o(166304);
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.c.b
 * JD-Core Version:    0.7.0.1
 */