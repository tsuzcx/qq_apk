package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.at.a;
import com.tencent.mm.plugin.finder.cgi.bd;
import com.tencent.mm.plugin.finder.cgi.bd.a;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyUserAvatar", "avatarPath", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserPrivate", "private", "modifyUserSex", "sex", "modifyUserSignature", "signature", "plugin-finder_release"})
public final class f
  extends h<aps>
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.i.a.n
{
  final String TAG = "Finder.FinderModifyUserService";
  
  public final void a(int paramInt, s<aps> params)
  {
    AppMethodBeat.i(201244);
    aps localaps = new aps();
    localaps.ePk = paramInt;
    localaps.GlT = 0;
    a(localaps, params);
    AppMethodBeat.o(201244);
  }
  
  public final void a(String paramString, final s<aps> params)
  {
    AppMethodBeat.i(165310);
    p.h(paramString, "avatarPath");
    bd.a locala = bd.rKe;
    paramString = new bd(paramString, bd.cyP());
    g.aiU().a(3759, (com.tencent.mm.al.f)new a(this, params));
    g.aiU().b((com.tencent.mm.al.n)paramString);
    AppMethodBeat.o(165310);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, s<aps> params)
  {
    AppMethodBeat.i(165313);
    p.h(paramString1, "country");
    p.h(paramString2, "province");
    p.h(paramString3, "city");
    aps localaps = new aps();
    localaps.country = paramString1;
    localaps.ePu = paramString2;
    localaps.ePv = paramString3;
    localaps.GlS = paramInt;
    a(localaps, params);
    AppMethodBeat.o(165313);
  }
  
  public final void b(int paramInt, s<aps> params)
  {
    AppMethodBeat.i(201245);
    aps localaps = new aps();
    localaps.GnY = paramInt;
    a(localaps, params);
    AppMethodBeat.o(201245);
  }
  
  public final void b(String paramString, s<aps> params)
  {
    AppMethodBeat.i(165311);
    p.h(paramString, "nickname");
    aps localaps = new aps();
    localaps.nickname = paramString;
    a(localaps, params);
    AppMethodBeat.o(165311);
  }
  
  public final void c(String paramString, s<aps> params)
  {
    AppMethodBeat.i(165314);
    p.h(paramString, "signature");
    aps localaps = new aps();
    localaps.signature = paramString;
    a(localaps, params);
    AppMethodBeat.o(165314);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165309);
    at.a locala = at.rJK;
    int i = at.cyz();
    AppMethodBeat.o(165309);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService$modifyUserAvatar$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.al.f
  {
    a(s params) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(165307);
      ad.i(this.rLg.TAG, "upload head img errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
      g.aiU().b(3759, (com.tencent.mm.al.f)this);
      paramString = new aps();
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUploadHeadImg");
        AppMethodBeat.o(165307);
        throw paramString;
      }
      paramString.hDQ = ((bd)paramn).rJX;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.rLg.a(paramString, params);
        AppMethodBeat.o(165307);
        return;
      }
      paramn = params;
      if (paramn != null)
      {
        alp localalp = new alp();
        at.a locala = at.rJK;
        localalp.cmdId = at.cyz();
        localalp.retCode = -1;
        paramn.a(paramString, localalp);
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