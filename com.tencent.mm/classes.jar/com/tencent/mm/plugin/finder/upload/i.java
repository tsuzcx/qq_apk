package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.v.a;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.a.j;
import d.g.b.k;
import d.l;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "updateContact", "url", "succ", "", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  private final String path;
  private final a qRr;
  final String userName;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167789);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadCoverImageTask";
    this.qRr = new a(this);
    AppMethodBeat.o(167789);
  }
  
  public final String abi()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167788);
    if (!com.tencent.mm.vfs.i.eK(this.path))
    {
      ad.d(this.TAG, "path " + this.path + " is not file");
      a(h.glb);
      AppMethodBeat.o(167788);
      return;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fnH = ((g.a)this.qRr);
    localg.field_mediaId = ai.du(this.path);
    localg.field_fullpath = this.path;
    e locale = e.qQW;
    localg.field_thumbpath = e.aVF(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = a.MediaType_FRIENDS;
    localg.field_appType = 100;
    localg.field_bzScene = 1;
    localg.fnL = 60;
    localg.fnM = 300;
    localg.field_priority = a.fmV;
    f.awL().e(localg);
    AppMethodBeat.o(167788);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167787);
      String str = this.qRs.TAG;
      Object localObject;
      if (paramd != null)
      {
        localObject = paramd.toString();
        paramc = (com.tencent.mm.i.c)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramc = "null";
      }
      ad.i(str, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
      if (paramInt != 0)
      {
        ad.e(this.qRs.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          i.a(this.qRs, "", false);
          this.qRs.a(h.glb);
        }
        AppMethodBeat.o(167787);
        return 0;
      }
      if ((!bt.isNullOrNil(paramString)) && (paramd != null))
      {
        ad.i(this.qRs.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          i.a(this.qRs, "", false);
          this.qRs.a(h.glb);
          AppMethodBeat.o(167787);
          return 0;
        }
        paramString = com.tencent.mm.plugin.finder.api.b.qnX;
        if (b.a.YL(this.qRs.userName) != null)
        {
          paramString = com.tencent.mm.kernel.g.afB();
          k.g(paramString, "MMKernel.storage()");
          paramString.afk().set(ae.a.Fwc, paramd.field_fileUrl);
          paramString = new ajz();
          paramString.coverImgUrl = paramd.field_fileUrl;
          paramc = new ahv();
          localObject = com.tencent.mm.plugin.finder.cgi.v.qpr;
          paramc.cmdId = com.tencent.mm.plugin.finder.cgi.v.ckR();
          paramc.Dkt = com.tencent.mm.bx.b.cd(paramString.toByteArray());
          paramString = j.listOf(paramc);
          paramc = new com.tencent.mm.plugin.finder.cgi.v(this.qRs.userName, paramString);
          com.tencent.mm.kernel.g.aeS().a(3870, (com.tencent.mm.al.g)new a(paramString, this, paramd));
          com.tencent.mm.kernel.g.aeS().b((n)paramc);
        }
      }
      AppMethodBeat.o(167787);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1$callback$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.al.g
    {
      a(List paramList, i.a parama, d paramd) {}
      
      public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
      {
        AppMethodBeat.i(167786);
        com.tencent.mm.kernel.g.aeS().b(3870, (com.tencent.mm.al.g)this);
        ad.i(jdField_this.qRs.TAG, "errType " + paramInt1 + " , errCode " + paramInt2 + ", errMsg " + paramString);
        if (paramn == null)
        {
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
          AppMethodBeat.o(167786);
          throw paramString;
        }
        paramString = ((com.tencent.mm.plugin.finder.cgi.v)paramn).ckQ();
        paramn = ((com.tencent.mm.plugin.finder.cgi.v)paramn).ckP();
        if ((paramInt1 == 0) && (paramInt2 == 0) && (k.g(this.qRt, paramn)))
        {
          paramString = paramString.iterator();
          paramInt1 = 0;
          if (paramString.hasNext())
          {
            paramn = (ahw)paramString.next();
            paramInt2 = paramn.cmdId;
            v.a locala = com.tencent.mm.plugin.finder.cgi.v.qpr;
            if ((paramInt2 == com.tencent.mm.plugin.finder.cgi.v.ckR()) && (paramn.retCode == 0))
            {
              paramInt2 = 1;
              label183:
              if (paramInt2 == 0) {
                break label262;
              }
            }
          }
          for (;;)
          {
            if (paramInt1 == -1) {
              break label274;
            }
            ad.i(jdField_this.qRs.TAG, "update coverImg succ");
            paramString = jdField_this.qRs;
            paramn = paramd.field_fileUrl;
            k.g(paramn, "sceneResult.field_fileUrl");
            i.a(paramString, paramn, true);
            jdField_this.qRs.a(h.gla);
            AppMethodBeat.o(167786);
            return;
            paramInt2 = 0;
            break label183;
            label262:
            paramInt1 += 1;
            break;
            paramInt1 = -1;
          }
          label274:
          ad.i(jdField_this.qRs.TAG, "update coverImg failed");
          paramString = jdField_this.qRs;
          paramn = paramd.field_fileUrl;
          k.g(paramn, "sceneResult.field_fileUrl");
          i.a(paramString, paramn, false);
          jdField_this.qRs.a(h.glb);
        }
        AppMethodBeat.o(167786);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.i
 * JD-Core Version:    0.7.0.1
 */