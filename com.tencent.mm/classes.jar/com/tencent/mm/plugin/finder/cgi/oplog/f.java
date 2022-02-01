package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.au.a;
import com.tencent.mm.plugin.finder.cgi.be;
import com.tencent.mm.plugin.finder.cgi.be.a;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyUserAvatar", "avatarPath", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserPrivate", "private", "modifyUserSex", "sex", "modifyUserSignature", "signature", "plugin-finder_release"})
public final class f
  extends h<aqf>
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.i.a.n
{
  final String TAG = "Finder.FinderModifyUserService";
  
  public final void a(int paramInt, s<aqf> params)
  {
    AppMethodBeat.i(201671);
    aqf localaqf = new aqf();
    localaqf.eQV = paramInt;
    localaqf.GEV = 0;
    a(localaqf, params);
    AppMethodBeat.o(201671);
  }
  
  public final void a(String paramString, final s<aqf> params)
  {
    AppMethodBeat.i(165310);
    p.h(paramString, "avatarPath");
    be.a locala = be.rSs;
    paramString = new be(paramString, be.cAq());
    g.ajj().a(3759, (com.tencent.mm.ak.f)new a(this, params));
    g.ajj().b((com.tencent.mm.ak.n)paramString);
    AppMethodBeat.o(165310);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, s<aqf> params)
  {
    AppMethodBeat.i(165313);
    p.h(paramString1, "country");
    p.h(paramString2, "province");
    p.h(paramString3, "city");
    aqf localaqf = new aqf();
    localaqf.country = paramString1;
    localaqf.eRf = paramString2;
    localaqf.eRg = paramString3;
    localaqf.GEU = paramInt;
    a(localaqf, params);
    AppMethodBeat.o(165313);
  }
  
  public final void b(int paramInt, s<aqf> params)
  {
    AppMethodBeat.i(201672);
    aqf localaqf = new aqf();
    localaqf.GHe = paramInt;
    a(localaqf, params);
    AppMethodBeat.o(201672);
  }
  
  public final void b(String paramString, s<aqf> params)
  {
    AppMethodBeat.i(165311);
    p.h(paramString, "nickname");
    aqf localaqf = new aqf();
    localaqf.nickname = paramString;
    a(localaqf, params);
    AppMethodBeat.o(165311);
  }
  
  public final void c(String paramString, s<aqf> params)
  {
    AppMethodBeat.i(165314);
    p.h(paramString, "signature");
    aqf localaqf = new aqf();
    localaqf.signature = paramString;
    a(localaqf, params);
    AppMethodBeat.o(165314);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165309);
    au.a locala = au.rRY;
    int i = au.cAa();
    AppMethodBeat.o(165309);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService$modifyUserAvatar$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.ak.f
  {
    a(s params) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(165307);
      ae.i(this.rTu.TAG, "upload head img errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
      g.ajj().b(3759, (com.tencent.mm.ak.f)this);
      paramString = new aqf();
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUploadHeadImg");
        AppMethodBeat.o(165307);
        throw paramString;
      }
      paramString.hGI = ((be)paramn).rSl;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.rTu.a(paramString, params);
        AppMethodBeat.o(165307);
        return;
      }
      paramn = params;
      if (paramn != null)
      {
        amb localamb = new amb();
        au.a locala = au.rRY;
        localamb.cmdId = au.cAa();
        localamb.retCode = -1;
        paramn.a(paramString, localamb);
        AppMethodBeat.o(165307);
        return;
      }
      AppMethodBeat.o(165307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.f
 * JD-Core Version:    0.7.0.1
 */