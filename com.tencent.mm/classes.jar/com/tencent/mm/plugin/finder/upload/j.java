package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.au.a;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "updateContact", "url", "succ", "", "plugin-finder_release"})
public final class j
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  private final String path;
  private final a sUH;
  final String userName;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167789);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadCoverImageTask";
    this.sUH = new a(this);
    AppMethodBeat.o(167789);
  }
  
  public final String aeW()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167788);
    if (!o.fB(this.path))
    {
      ae.d(this.TAG, "path " + this.path + " is not file");
      a(com.tencent.mm.loader.g.j.hiz);
      AppMethodBeat.o(167788);
      return;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_FinderUploadCoverImageTask";
    localg.fLm = ((g.a)this.sUH);
    localg.field_mediaId = com.tencent.mm.sdk.platformtools.aj.ej(this.path);
    localg.field_fullpath = this.path;
    f localf = f.sUp;
    localg.field_thumbpath = f.ajI(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = a.MediaType_FRIENDS;
    localg.field_appType = 100;
    localg.field_bzScene = 1;
    localg.fLq = 60;
    localg.fLr = 300;
    localg.field_priority = a.fKA;
    com.tencent.mm.an.f.aGZ().f(localg);
    AppMethodBeat.o(167788);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167787);
      String str = this.sUI.TAG;
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
      ae.i(str, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
      if (paramInt != 0)
      {
        ae.e(this.sUI.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          j.a(this.sUI, "", false);
          this.sUI.a(com.tencent.mm.loader.g.j.hiz);
        }
        AppMethodBeat.o(167787);
        return 0;
      }
      if ((!bu.isNullOrNil(paramString)) && (paramd != null))
      {
        ae.i(this.sUI.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          j.a(this.sUI, "", false);
          this.sUI.a(com.tencent.mm.loader.g.j.hiz);
          AppMethodBeat.o(167787);
          return 0;
        }
        paramString = com.tencent.mm.plugin.finder.api.c.rPy;
        if (c.a.ahT(this.sUI.userName) != null)
        {
          paramString = com.tencent.mm.kernel.g.ajR();
          p.g(paramString, "MMKernel.storage()");
          paramString.ajA().set(am.a.Jbc, paramd.field_fileUrl);
          paramString = new aqf();
          paramString.coverImgUrl = paramd.field_fileUrl;
          paramc = new ama();
          localObject = au.rRY;
          paramc.cmdId = au.cAa();
          paramc.GEu = com.tencent.mm.bw.b.cm(paramString.toByteArray());
          paramString = d.a.j.listOf(paramc);
          paramc = new au(this.sUI.userName, paramString);
          com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)new a(paramString, this, paramd));
          com.tencent.mm.kernel.g.ajj().b((n)paramc);
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1$callback$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.ak.f
    {
      a(List paramList, j.a parama, d paramd) {}
      
      public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
      {
        AppMethodBeat.i(167786);
        com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this);
        ae.i(jdField_this.sUI.TAG, "errType " + paramInt1 + " , errCode " + paramInt2 + ", errMsg " + paramString);
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
          AppMethodBeat.o(167786);
          throw paramString;
        }
        paramString = ((au)paramn).czZ();
        paramn = ((au)paramn).czY();
        if ((paramInt1 == 0) && (paramInt2 == 0) && (p.i(this.sUJ, paramn)))
        {
          paramString = paramString.iterator();
          paramInt1 = 0;
          if (paramString.hasNext())
          {
            paramn = (amb)paramString.next();
            paramInt2 = paramn.cmdId;
            au.a locala = au.rRY;
            if ((paramInt2 == au.cAa()) && (paramn.retCode == 0))
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
            ae.i(jdField_this.sUI.TAG, "update coverImg succ");
            paramString = jdField_this.sUI;
            paramn = paramd.field_fileUrl;
            p.g(paramn, "sceneResult.field_fileUrl");
            j.a(paramString, paramn, true);
            jdField_this.sUI.a(com.tencent.mm.loader.g.j.hiy);
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
          ae.i(jdField_this.sUI.TAG, "update coverImg failed");
          paramString = jdField_this.sUI;
          paramn = paramd.field_fileUrl;
          p.g(paramn, "sceneResult.field_fileUrl");
          j.a(paramString, paramn, false);
          jdField_this.sUI.a(com.tencent.mm.loader.g.j.hiz);
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