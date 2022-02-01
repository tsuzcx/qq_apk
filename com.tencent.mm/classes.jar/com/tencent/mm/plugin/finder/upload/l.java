package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "updateContact", "url", "succ", "", "plugin-finder_release"})
public final class l
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  private final String path;
  final String userName;
  private final a vTb;
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167789);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadCoverImageTask";
    this.vTb = new a(this);
    AppMethodBeat.o(167789);
  }
  
  public final String auK()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167788);
    if (!s.YS(this.path))
    {
      Log.d(this.TAG, "path " + this.path + " is not file");
      a(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(167788);
      return;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_FinderUploadCoverImageTask";
    localg.gqy = ((g.a)this.vTb);
    localg.field_mediaId = MD5Util.getMD5String(this.path);
    localg.field_fullpath = this.path;
    f localf = f.vSz;
    localg.field_thumbpath = f.avU(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = a.MediaType_FRIENDS;
    localg.field_appType = 100;
    localg.field_bzScene = 1;
    localg.gqC = 60;
    localg.gqD = 300;
    localg.field_priority = a.gpM;
    com.tencent.mm.an.f.baQ().f(localg);
    AppMethodBeat.o(167788);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, final d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167787);
      String str = this.vTc.TAG;
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
      Log.i(str, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
      if (paramInt != 0)
      {
        Log.e(this.vTc.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          l.a(this.vTc, "", false);
          this.vTc.a(com.tencent.mm.loader.g.j.ibx);
        }
        AppMethodBeat.o(167787);
        return 0;
      }
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i(this.vTc.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          l.a(this.vTc, "", false);
          this.vTc.a(com.tencent.mm.loader.g.j.ibx);
          AppMethodBeat.o(167787);
          return 0;
        }
        paramString = com.tencent.mm.plugin.finder.api.c.tsp;
        if (c.a.asG(this.vTc.userName) != null)
        {
          paramString = com.tencent.mm.kernel.g.aAh();
          p.g(paramString, "MMKernel.storage()");
          paramString.azQ().set(ar.a.OjM, paramd.field_fileUrl);
          paramString = new azg();
          paramString.coverImgUrl = paramd.field_fileUrl;
          paramc = new apf();
          localObject = bx.tvW;
          paramc.cmdId = bx.cYO();
          paramc.LBo = com.tencent.mm.bw.b.cD(paramString.toByteArray());
          paramString = kotlin.a.j.listOf(paramc);
          paramc = new bx(this.vTc.userName, paramString);
          com.tencent.mm.kernel.g.azz().a(3870, (i)new a(paramString, this, paramd));
          com.tencent.mm.kernel.g.azz().b((q)paramc);
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
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1$callback$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class a
      implements i
    {
      a(List paramList, l.a parama, d paramd) {}
      
      public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
      {
        AppMethodBeat.i(167786);
        com.tencent.mm.kernel.g.azz().b(3870, (i)this);
        Log.i(jdField_this.vTc.TAG, "errType " + paramInt1 + " , errCode " + paramInt2 + ", errMsg " + paramString);
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
          AppMethodBeat.o(167786);
          throw paramString;
        }
        paramString = ((bx)paramq).cYN();
        paramq = ((bx)paramq).cYM();
        if ((paramInt1 == 0) && (paramInt2 == 0) && (p.j(this.vTd, paramq)))
        {
          paramString = paramString.iterator();
          paramInt1 = 0;
          if (paramString.hasNext())
          {
            paramq = (apg)paramString.next();
            paramInt2 = paramq.cmdId;
            bx.a locala = bx.tvW;
            if ((paramInt2 == bx.cYO()) && (paramq.retCode == 0))
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
            Log.i(jdField_this.vTc.TAG, "update coverImg succ");
            paramString = jdField_this.vTc;
            paramq = paramd.field_fileUrl;
            p.g(paramq, "sceneResult.field_fileUrl");
            l.a(paramString, paramq, true);
            jdField_this.vTc.a(com.tencent.mm.loader.g.j.ibw);
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
          Log.i(jdField_this.vTc.TAG, "update coverImg failed");
          paramString = jdField_this.vTc;
          paramq = paramd.field_fileUrl;
          p.g(paramq, "sceneResult.field_fileUrl");
          l.a(paramString, paramq, false);
          jdField_this.vTc.a(com.tencent.mm.loader.g.j.ibx);
        }
        AppMethodBeat.o(167786);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.l
 * JD-Core Version:    0.7.0.1
 */