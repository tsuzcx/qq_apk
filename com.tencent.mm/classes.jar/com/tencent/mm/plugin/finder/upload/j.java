package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "updateContact", "url", "succ", "", "plugin-finder_release"})
public final class j
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  private final String path;
  private final a sJu;
  final String userName;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167789);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadCoverImageTask";
    this.sJu = new a(this);
    AppMethodBeat.o(167789);
  }
  
  public final String aeK()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167788);
    if (!i.fv(this.path))
    {
      ad.d(this.TAG, "path " + this.path + " is not file");
      a(com.tencent.mm.loader.g.j.hfL);
      AppMethodBeat.o(167788);
      return;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_FinderUploadCoverImageTask";
    localg.fJj = ((g.a)this.sJu);
    localg.field_mediaId = com.tencent.mm.sdk.platformtools.ai.ee(this.path);
    localg.field_fullpath = this.path;
    f localf = f.sJc;
    localg.field_thumbpath = f.aiL(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = a.MediaType_FRIENDS;
    localg.field_appType = 100;
    localg.field_bzScene = 1;
    localg.fJn = 60;
    localg.fJo = 300;
    localg.field_priority = a.fIw;
    com.tencent.mm.ao.f.aGI().f(localg);
    AppMethodBeat.o(167788);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167787);
      String str = this.sJv.TAG;
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
        ad.e(this.sJv.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          j.a(this.sJv, "", false);
          this.sJv.a(com.tencent.mm.loader.g.j.hfL);
        }
        AppMethodBeat.o(167787);
        return 0;
      }
      if ((!bt.isNullOrNil(paramString)) && (paramd != null))
      {
        ad.i(this.sJv.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          j.a(this.sJv, "", false);
          this.sJv.a(com.tencent.mm.loader.g.j.hfL);
          AppMethodBeat.o(167787);
          return 0;
        }
        paramString = com.tencent.mm.plugin.finder.api.c.rHn;
        if (c.a.agW(this.sJv.userName) != null)
        {
          paramString = com.tencent.mm.kernel.g.ajC();
          p.g(paramString, "MMKernel.storage()");
          paramString.ajl().set(al.a.IGC, paramd.field_fileUrl);
          paramString = new aps();
          paramString.coverImgUrl = paramd.field_fileUrl;
          paramc = new alo();
          localObject = at.rJK;
          paramc.cmdId = at.cyz();
          paramc.Glr = com.tencent.mm.bx.b.cj(paramString.toByteArray());
          paramString = d.a.j.listOf(paramc);
          paramc = new at(this.sJv.userName, paramString);
          com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)new a(paramString, this, paramd));
          com.tencent.mm.kernel.g.aiU().b((n)paramc);
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1$callback$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.al.f
    {
      a(List paramList, j.a parama, d paramd) {}
      
      public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
      {
        AppMethodBeat.i(167786);
        com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this);
        ad.i(jdField_this.sJv.TAG, "errType " + paramInt1 + " , errCode " + paramInt2 + ", errMsg " + paramString);
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
          AppMethodBeat.o(167786);
          throw paramString;
        }
        paramString = ((at)paramn).cyy();
        paramn = ((at)paramn).cyx();
        if ((paramInt1 == 0) && (paramInt2 == 0) && (p.i(this.sJw, paramn)))
        {
          paramString = paramString.iterator();
          paramInt1 = 0;
          if (paramString.hasNext())
          {
            paramn = (alp)paramString.next();
            paramInt2 = paramn.cmdId;
            at.a locala = at.rJK;
            if ((paramInt2 == at.cyz()) && (paramn.retCode == 0))
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
            ad.i(jdField_this.sJv.TAG, "update coverImg succ");
            paramString = jdField_this.sJv;
            paramn = paramd.field_fileUrl;
            p.g(paramn, "sceneResult.field_fileUrl");
            j.a(paramString, paramn, true);
            jdField_this.sJv.a(com.tencent.mm.loader.g.j.hfK);
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
          ad.i(jdField_this.sJv.TAG, "update coverImg failed");
          paramString = jdField_this.sJv;
          paramn = paramd.field_fileUrl;
          p.g(paramn, "sceneResult.field_fileUrl");
          j.a(paramString, paramn, false);
          jdField_this.sJv.a(com.tencent.mm.loader.g.j.hfL);
        }
        AppMethodBeat.o(167786);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.j
 * JD-Core Version:    0.7.0.1
 */