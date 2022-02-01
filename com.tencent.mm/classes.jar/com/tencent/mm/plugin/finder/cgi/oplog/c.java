package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.ad.a;
import com.tencent.mm.plugin.finder.cgi.v.a;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.ajz;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyUserAvatar", "avatarPath", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserSex", "sex", "modifyUserSignature", "signature", "plugin-finder_release"})
public final class c
  extends d<ajz>
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.i.a.g
{
  final String TAG = "Finder.FinderModifyUserService";
  
  public final void a(int paramInt, i<ajz> parami)
  {
    AppMethodBeat.i(197376);
    ajz localajz = new ajz();
    localajz.evp = paramInt;
    localajz.DkJ = 0;
    a(localajz, parami);
    AppMethodBeat.o(197376);
  }
  
  public final void a(String paramString, final i<ajz> parami)
  {
    AppMethodBeat.i(165310);
    k.h(paramString, "avatarPath");
    ad.a locala = com.tencent.mm.plugin.finder.cgi.ad.qpH;
    paramString = new com.tencent.mm.plugin.finder.cgi.ad(paramString, com.tencent.mm.plugin.finder.cgi.ad.cla());
    com.tencent.mm.kernel.g.aeS().a(3759, (com.tencent.mm.al.g)new a(this, parami));
    com.tencent.mm.kernel.g.aeS().b((n)paramString);
    AppMethodBeat.o(165310);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, i<ajz> parami)
  {
    AppMethodBeat.i(165313);
    k.h(paramString1, "country");
    k.h(paramString2, "province");
    k.h(paramString3, "city");
    ajz localajz = new ajz();
    localajz.country = paramString1;
    localajz.evz = paramString2;
    localajz.evA = paramString3;
    localajz.DkI = paramInt;
    a(localajz, parami);
    AppMethodBeat.o(165313);
  }
  
  public final void b(String paramString, i<ajz> parami)
  {
    AppMethodBeat.i(165311);
    k.h(paramString, "nickname");
    ajz localajz = new ajz();
    localajz.nickname = paramString;
    a(localajz, parami);
    AppMethodBeat.o(165311);
  }
  
  public final void c(String paramString, i<ajz> parami)
  {
    AppMethodBeat.i(165314);
    k.h(paramString, "signature");
    ajz localajz = new ajz();
    localajz.signature = paramString;
    a(localajz, parami);
    AppMethodBeat.o(165314);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165309);
    v.a locala = com.tencent.mm.plugin.finder.cgi.v.qpr;
    int i = com.tencent.mm.plugin.finder.cgi.v.ckR();
    AppMethodBeat.o(165309);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService$modifyUserAvatar$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.al.g
  {
    a(i parami) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(165307);
      com.tencent.mm.sdk.platformtools.ad.i(this.qpU.TAG, "upload head img errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
      com.tencent.mm.kernel.g.aeS().b(3759, (com.tencent.mm.al.g)this);
      paramString = new ajz();
      if (paramn == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUploadHeadImg");
        AppMethodBeat.o(165307);
        throw paramString;
      }
      paramString.gLg = ((com.tencent.mm.plugin.finder.cgi.ad)paramn).qpB;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.qpU.a(paramString, parami);
        AppMethodBeat.o(165307);
        return;
      }
      paramn = parami;
      if (paramn != null)
      {
        ahw localahw = new ahw();
        v.a locala = com.tencent.mm.plugin.finder.cgi.v.qpr;
        localahw.cmdId = com.tencent.mm.plugin.finder.cgi.v.ckR();
        localahw.retCode = -1;
        paramn.a(paramString, localahw);
        AppMethodBeat.o(165307);
        return;
      }
      AppMethodBeat.o(165307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.c
 * JD-Core Version:    0.7.0.1
 */