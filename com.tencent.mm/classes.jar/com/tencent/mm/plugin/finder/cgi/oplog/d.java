package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.am.a;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.cgi.av.a;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyUserAvatar", "avatarPath", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserSex", "sex", "modifyUserSignature", "signature", "plugin-finder_release"})
public final class d
  extends e<amj>
  implements com.tencent.mm.ak.g, i
{
  final String TAG = "Finder.FinderModifyUserService";
  
  public final void a(int paramInt, com.tencent.mm.plugin.i.a.k<amj> paramk)
  {
    AppMethodBeat.i(201251);
    amj localamj = new amj();
    localamj.exL = paramInt;
    localamj.EEe = 0;
    a(localamj, paramk);
    AppMethodBeat.o(201251);
  }
  
  public final void a(String paramString, final com.tencent.mm.plugin.i.a.k<amj> paramk)
  {
    AppMethodBeat.i(165310);
    d.g.b.k.h(paramString, "avatarPath");
    av.a locala = av.qYN;
    paramString = new av(paramString, av.csT());
    com.tencent.mm.kernel.g.agi().a(3759, (com.tencent.mm.ak.g)new a(this, paramk));
    com.tencent.mm.kernel.g.agi().b((n)paramString);
    AppMethodBeat.o(165310);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, com.tencent.mm.plugin.i.a.k<amj> paramk)
  {
    AppMethodBeat.i(165313);
    d.g.b.k.h(paramString1, "country");
    d.g.b.k.h(paramString2, "province");
    d.g.b.k.h(paramString3, "city");
    amj localamj = new amj();
    localamj.country = paramString1;
    localamj.exV = paramString2;
    localamj.exW = paramString3;
    localamj.EEd = paramInt;
    a(localamj, paramk);
    AppMethodBeat.o(165313);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.i.a.k<amj> paramk)
  {
    AppMethodBeat.i(165311);
    d.g.b.k.h(paramString, "nickname");
    amj localamj = new amj();
    localamj.nickname = paramString;
    a(localamj, paramk);
    AppMethodBeat.o(165311);
  }
  
  public final void c(String paramString, com.tencent.mm.plugin.i.a.k<amj> paramk)
  {
    AppMethodBeat.i(165314);
    d.g.b.k.h(paramString, "signature");
    amj localamj = new amj();
    localamj.signature = paramString;
    a(localamj, paramk);
    AppMethodBeat.o(165314);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165309);
    am.a locala = am.qYu;
    int i = am.csI();
    AppMethodBeat.o(165309);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService$modifyUserAvatar$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.ak.g
  {
    a(com.tencent.mm.plugin.i.a.k paramk) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(165307);
      ac.i(this.qZB.TAG, "upload head img errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
      com.tencent.mm.kernel.g.agi().b(3759, (com.tencent.mm.ak.g)this);
      paramString = new amj();
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUploadHeadImg");
        AppMethodBeat.o(165307);
        throw paramString;
      }
      paramString.hlG = ((av)paramn).qYH;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.qZB.a(paramString, paramk);
        AppMethodBeat.o(165307);
        return;
      }
      paramn = paramk;
      if (paramn != null)
      {
        aiz localaiz = new aiz();
        am.a locala = am.qYu;
        localaiz.cmdId = am.csI();
        localaiz.retCode = -1;
        paramn.a(paramString, localaiz);
        AppMethodBeat.o(165307);
        return;
      }
      AppMethodBeat.o(165307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.d
 * JD-Core Version:    0.7.0.1
 */