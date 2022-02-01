package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.a.j;
import d.g.b.k;
import d.l;
import java.io.ByteArrayOutputStream;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "updateContact", "url", "succ", "", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  private final String path;
  private final a rNs;
  final String userName;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167789);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadCoverImageTask";
    this.rNs = new a(this);
    AppMethodBeat.o(167789);
  }
  
  public final String acg()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167788);
    if (!com.tencent.mm.vfs.i.eA(this.path))
    {
      ac.d(this.TAG, "path " + this.path + " is not file");
      a(h.gLO);
      AppMethodBeat.o(167788);
      return;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = ((g.a)this.rNs);
    localg.field_mediaId = ah.dg(this.path);
    localg.field_fullpath = this.path;
    e locale = e.rMX;
    localg.field_thumbpath = e.aer(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = a.MediaType_FRIENDS;
    localg.field_appType = 100;
    localg.field_bzScene = 1;
    localg.frf = 60;
    localg.frg = 300;
    localg.field_priority = a.fqp;
    f.aDD().f(localg);
    AppMethodBeat.o(167788);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(167787);
      String str = this.rNt.TAG;
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
      ac.i(str, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
      if (paramInt != 0)
      {
        ac.e(this.rNt.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005)
        {
          i.a(this.rNt, "", false);
          this.rNt.a(h.gLO);
        }
        AppMethodBeat.o(167787);
        return 0;
      }
      if ((!bs.isNullOrNil(paramString)) && (paramd != null))
      {
        ac.i(this.rNt.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          i.a(this.rNt, "", false);
          this.rNt.a(h.gLO);
          AppMethodBeat.o(167787);
          return 0;
        }
        paramString = com.tencent.mm.plugin.finder.api.b.qWt;
        if (b.a.adh(this.rNt.userName) != null)
        {
          paramString = com.tencent.mm.kernel.g.agR();
          k.g(paramString, "MMKernel.storage()");
          paramString.agA().set(ah.a.GTW, paramd.field_fileUrl);
          paramString = new amj();
          paramString.coverImgUrl = paramd.field_fileUrl;
          paramc = new aiy();
          localObject = am.qYu;
          paramc.cmdId = am.csI();
          paramc.EDH = com.tencent.mm.bw.b.cc(paramString.toByteArray());
          paramString = j.listOf(paramc);
          paramc = new am(this.rNt.userName, paramString);
          com.tencent.mm.kernel.g.agi().a(3870, (com.tencent.mm.ak.g)new i.a.a(paramString, this, paramd));
          com.tencent.mm.kernel.g.agi().b((n)paramc);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.i
 * JD-Core Version:    0.7.0.1
 */