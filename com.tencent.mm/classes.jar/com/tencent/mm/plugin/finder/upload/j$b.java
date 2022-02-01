package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
public final class j$b
  implements g.a
{
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(167791);
    Object localObject1 = j.rNC;
    String str = j.access$getTAG$cp();
    Object localObject2;
    if (paramd != null)
    {
      localObject2 = paramd.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "null";
    }
    ac.i(str, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject1 });
    j.a(this.rND, paramString, paramc);
    if (paramInt != 0)
    {
      paramc = j.rNC;
      ac.e(j.access$getTAG$cp(), "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      if (paramInt != -21005)
      {
        paramc = this.rND.rMD.getMediaList();
        if (paramc != null)
        {
          paramd = ((Iterable)paramc).iterator();
          do
          {
            if (!paramd.hasNext()) {
              break;
            }
            paramc = paramd.next();
          } while (!k.g(((bqs)paramc).mediaId, j.aex(paramString)));
        }
      }
      for (paramString = paramc;; paramString = null)
      {
        paramString = (bqs)paramString;
        if (paramString != null) {
          j.a(this.rND, paramInt, paramString);
        }
        j.a(this.rND, false);
        j.a(this.rND, h.gLO);
        AppMethodBeat.o(167791);
        return 0;
      }
    }
    if ((!bs.isNullOrNil(paramString)) && (paramd != null))
    {
      paramc = j.rNC;
      ac.i(j.access$getTAG$cp(), "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
      if (paramd.field_retCode != 0)
      {
        paramc = this.rND.rMD.getMediaList();
        if (paramc != null)
        {
          localObject1 = ((Iterable)paramc).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramc = ((Iterator)localObject1).next();
          } while (!k.g(((bqs)paramc).mediaId, j.aex(paramString)));
        }
        for (paramString = paramc;; paramString = null)
        {
          paramString = (bqs)paramString;
          if (paramString != null) {
            j.a(this.rND, paramd.field_retCode, paramString);
          }
          j.a(this.rND, false);
          j.a(this.rND, h.gLO);
          AppMethodBeat.o(167791);
          return 0;
        }
      }
      j.a(this.rND).remove(paramString);
      localObject1 = this.rND.rMD.getMediaList();
      paramInt = j.a(this.rND).size();
      paramc = j.rNC;
      ac.i(j.access$getTAG$cp(), "%s waitToUpload %d media localId:" + this.rND.rMD.getLocalId(), new Object[] { Long.valueOf(this.rND.rMD.getLocalId()), Integer.valueOf(paramInt) });
      if (localObject1 == null) {
        break label822;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          paramc = ((Iterator)localObject2).next();
          if (k.g(((bqs)paramc).mediaId, j.aex(paramString)))
          {
            paramc = (bqs)paramc;
            label557:
            if (paramc != null)
            {
              paramc.mediaId = ah.dg(paramc.url);
              paramc.FfN = paramd.field_fileUrl;
              paramc.FfO = paramd.field_thumbUrl;
              paramc.md5sum = paramd.field_filemd5;
              this.rND.rMD.setMediaList((LinkedList)localObject1);
              j.a(this.rND, 0, paramc);
              ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().a(this.rND.rMD.getLocalId(), this.rND.rMD);
            }
            if (paramc == null)
            {
              localObject1 = ((Iterable)localObject1).iterator();
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                paramc = ((Iterator)localObject1).next();
              } while (!k.g(ah.dg(((bqs)paramc).coverUrl), j.aex(paramString)));
            }
          }
        }
      }
    }
    for (paramString = paramc;; paramString = null)
    {
      paramString = (bqs)paramString;
      if (paramString != null)
      {
        paramc = j.rNC;
        ac.i(j.access$getTAG$cp(), "upload cover ok, url:" + paramd.field_fileUrl);
        paramString.FfR = paramd.field_fileUrl;
      }
      ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().a(this.rND.rMD.getLocalId(), this.rND.rMD);
      if (paramInt == 0)
      {
        j.a(this.rND, true);
        j.a(this.rND, h.gLN);
      }
      AppMethodBeat.o(167791);
      return 0;
      paramc = null;
      break;
      label822:
      paramc = null;
      break label557;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.j.b
 * JD-Core Version:    0.7.0.1
 */