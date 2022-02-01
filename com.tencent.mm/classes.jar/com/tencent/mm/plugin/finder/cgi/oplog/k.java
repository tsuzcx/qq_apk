package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.cgi.ca.a;
import com.tencent.mm.plugin.finder.cgi.cp;
import com.tencent.mm.plugin.finder.cgi.cp.a;
import com.tencent.mm.plugin.finder.viewmodel.a;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "Lcom/tencent/mm/plugin/finder/service/IFinderModifyUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedMvReproduce", "show", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyUserAtShowTab", "private", "modifyUserAvatar", "avatarPath", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserPrivate", "modifyUserSex", "sex", "modifyUserSignature", "signature", "modifyUserWxProfile", "plugin-finder_release"})
public final class k
  extends m<bfc>
  implements com.tencent.mm.plugin.finder.service.m
{
  final String TAG = "Finder.FinderModifyUserService";
  
  public final void a(int paramInt, aj<bfc> paramaj)
  {
    AppMethodBeat.i(271043);
    bfc localbfc = new bfc();
    localbfc.sex = paramInt;
    localbfc.SFl = 0;
    m.a(this, localbfc, paramaj);
    AppMethodBeat.o(271043);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, aj<bfc> paramaj)
  {
    AppMethodBeat.i(165313);
    p.k(paramString1, "country");
    p.k(paramString2, "province");
    p.k(paramString3, "city");
    bfc localbfc = new bfc();
    localbfc.country = paramString1;
    localbfc.province = paramString2;
    localbfc.city = paramString3;
    localbfc.SFk = paramInt;
    paramString1 = g.Xox;
    paramString1 = ((a)g.bD(PluginFinder.class).i(a.class)).Bgf;
    if (paramString1 != null)
    {
      localbfc.SFm = new ard();
      paramString2 = localbfc.SFm;
      if (paramString2 != null) {
        paramString2.country = paramString1.mVH;
      }
      paramString2 = localbfc.SFm;
      if (paramString2 != null) {
        paramString2.province = paramString1.mVz;
      }
      paramString2 = localbfc.SFm;
      if (paramString2 != null) {
        paramString2.city = paramString1.mVA;
      }
      m.a(this, localbfc, paramaj);
      AppMethodBeat.o(165313);
      return;
    }
    m.a((k)this, localbfc, paramaj);
    AppMethodBeat.o(165313);
  }
  
  public final void a(boolean paramBoolean, aj<bfc> paramaj)
  {
    AppMethodBeat.i(271046);
    bfc localbfc = new bfc();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbfc.SPP = i;
      m.a(this, localbfc, paramaj);
      AppMethodBeat.o(271046);
      return;
    }
  }
  
  public final void b(int paramInt, aj<bfc> paramaj)
  {
    AppMethodBeat.i(271044);
    bfc localbfc = new bfc();
    localbfc.SPN = paramInt;
    m.a(this, localbfc, paramaj);
    AppMethodBeat.o(271044);
  }
  
  public final void c(int paramInt, aj<bfc> paramaj)
  {
    AppMethodBeat.i(271045);
    bfc localbfc = new bfc();
    localbfc.SPO = paramInt;
    m.a(this, localbfc, paramaj);
    AppMethodBeat.o(271045);
  }
  
  public final void c(String paramString, final aj<bfc> paramaj)
  {
    AppMethodBeat.i(165310);
    p.k(paramString, "avatarPath");
    cp.a locala = cp.xep;
    paramString = new cp(paramString, cp.dpa());
    h.aGY().a(3759, (i)new a(this, paramaj));
    h.aGY().b((q)paramString);
    AppMethodBeat.o(165310);
  }
  
  public final void d(String paramString, aj<bfc> paramaj)
  {
    AppMethodBeat.i(165311);
    p.k(paramString, "nickname");
    bfc localbfc = new bfc();
    localbfc.nickname = paramString;
    m.a(this, localbfc, paramaj);
    AppMethodBeat.o(165311);
  }
  
  public final void e(String paramString, aj<bfc> paramaj)
  {
    AppMethodBeat.i(165314);
    p.k(paramString, "signature");
    bfc localbfc = new bfc();
    localbfc.signature = paramString;
    m.a(this, localbfc, paramaj);
    AppMethodBeat.o(165314);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165309);
    ca.a locala = ca.xdJ;
    int i = ca.doD();
    AppMethodBeat.o(165309);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void oj(boolean paramBoolean)
  {
    AppMethodBeat.i(271047);
    bfc localbfc = new bfc();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localbfc.SPQ = i;
      m.a(this, localbfc, null);
      AppMethodBeat.o(271047);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService$modifyUserAvatar$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    implements i
  {
    a(aj paramaj) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(165307);
      Log.i(this.xfP.TAG, "upload head img errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
      h.aGY().b(3759, (i)this);
      paramString = new bfc();
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUploadHeadImg");
        AppMethodBeat.o(165307);
        throw paramString;
      }
      paramString.lqp = ((cp)paramq).xei;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.xfP.a(paramString, paramaj, false);
        AppMethodBeat.o(165307);
        return;
      }
      paramq = paramaj;
      if (paramq != null)
      {
        aqu localaqu = new aqu();
        ca.a locala = ca.xdJ;
        localaqu.cmdId = ca.doD();
        localaqu.retCode = -1;
        paramq.a(paramString, localaqu);
        AppMethodBeat.o(165307);
        return;
      }
      AppMethodBeat.o(165307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.k
 * JD-Core Version:    0.7.0.1
 */