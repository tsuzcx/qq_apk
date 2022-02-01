package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.cz;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$a
  implements g.a
{
  l$a(l paraml) {}
  
  public final int a(String paramString, int paramInt, final c paramc, final com.tencent.mm.g.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(167787);
    String str = this.Gch.TAG;
    if (paramd == null) {
      paramc = "null";
    }
    Object localObject;
    for (;;)
    {
      Log.i(str, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
      if (paramInt == 0) {
        break;
      }
      Log.e(this.Gch.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      if (paramInt != -21005)
      {
        l.a(this.Gch, "", false);
        this.Gch.a(i.nrH);
      }
      AppMethodBeat.o(167787);
      return 0;
      localObject = paramd.toString();
      paramc = (c)localObject;
      if (localObject == null) {
        paramc = "null";
      }
    }
    if ((!Util.isNullOrNil(paramString)) && (paramd != null))
    {
      Log.i(this.Gch.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
      if (paramd.field_retCode != 0)
      {
        l.a(this.Gch, "", false);
        this.Gch.a(i.nrH);
        AppMethodBeat.o(167787);
        return 0;
      }
      paramString = com.tencent.mm.plugin.finder.api.d.AwY;
      if (d.a.auT(this.Gch.userName) != null)
      {
        paramString = this.Gch;
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adab, paramd.field_fileUrl);
        paramc = new bqe();
        paramc.coverImgUrl = paramd.field_fileUrl;
        localObject = new auw();
        ((auw)localObject).cmdId = 1;
        ((auw)localObject).ZFn = b.cX(paramc.toByteArray());
        paramc = kotlin.a.p.listOf(localObject);
        localObject = new cz(paramString.userName, paramc);
        com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)new a(paramString, paramc, paramd));
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      }
    }
    AppMethodBeat.o(167787);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1$callback$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.am.h
  {
    a(l paraml, List<? extends auw> paramList, com.tencent.mm.g.d paramd) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(342837);
      com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this);
      Log.i(this.Gch.TAG, "errType " + paramInt1 + " , errCode " + paramInt2 + ", errMsg " + paramString);
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
        AppMethodBeat.o(342837);
        throw paramString;
      }
      paramString = ((cz)paramp).dWp();
      paramp = ((cz)paramp).dWo();
      if ((paramInt1 == 0) && (paramInt2 == 0) && (kotlin.g.b.s.p(paramc, paramp)))
      {
        paramString = paramString.iterator();
        paramInt1 = 0;
        if (paramString.hasNext())
        {
          paramp = (aux)paramString.next();
          if ((paramp.cmdId == 1) && (paramp.retCode == 0))
          {
            paramInt2 = 1;
            label171:
            if (paramInt2 == 0) {
              break label241;
            }
          }
        }
        for (;;)
        {
          if (paramInt1 == -1) {
            break label253;
          }
          Log.i(this.Gch.TAG, "update coverImg succ");
          paramString = this.Gch;
          paramp = paramd.field_fileUrl;
          kotlin.g.b.s.s(paramp, "sceneResult.field_fileUrl");
          l.a(paramString, paramp, true);
          this.Gch.a(i.nrG);
          AppMethodBeat.o(342837);
          return;
          paramInt2 = 0;
          break label171;
          label241:
          paramInt1 += 1;
          break;
          paramInt1 = -1;
        }
        label253:
        Log.i(this.Gch.TAG, "update coverImg failed");
        paramString = this.Gch;
        paramp = paramd.field_fileUrl;
        kotlin.g.b.s.s(paramp, "sceneResult.field_fileUrl");
        l.a(paramString, paramp, false);
        this.Gch.a(i.nrH);
      }
      AppMethodBeat.o(342837);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.l.a
 * JD-Core Version:    0.7.0.1
 */