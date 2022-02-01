package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.dr;
import com.tencent.mm.plugin.finder.cgi.dr.a;
import com.tencent.mm.plugin.finder.service.r;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "Lcom/tencent/mm/plugin/finder/service/IFinderModifyUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedMvReproduce", "show", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyProfileCover", "coverUrl", "modifyUserAtShowTab", "private", "modifyUserAvatar", "avatarPath", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserMpIdentity", "switchToMpIdentity", "modifyUserNickname", "nickname", "modifyUserPrivate", "modifyUserSex", "sex", "modifyUserSignature", "signature", "modifyUserWxProfile", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends n<bqe>
  implements r
{
  final String TAG = "Finder.FinderModifyUserService";
  
  public final void a(int paramInt, ck<bqe> paramck)
  {
    AppMethodBeat.i(336548);
    bqe localbqe = new bqe();
    localbqe.sex = paramInt;
    localbqe.ZHa = 0;
    n.a((n)this, localbqe, paramck, false, false, 12);
    AppMethodBeat.o(336548);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, ck<bqe> paramck)
  {
    AppMethodBeat.i(165313);
    kotlin.g.b.s.u(paramString1, "country");
    kotlin.g.b.s.u(paramString2, "province");
    kotlin.g.b.s.u(paramString3, "city");
    bqe localbqe = new bqe();
    localbqe.country = paramString1;
    localbqe.province = paramString2;
    localbqe.city = paramString3;
    localbqe.ZGZ = paramInt;
    paramString1 = k.aeZF;
    paramString1 = ((b)k.cn(PluginFinder.class).q(b.class)).GJZ;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = ah.aiuX)
    {
      if (paramString1 == null) {
        n.a((n)this, localbqe, paramck, false, false, 12);
      }
      AppMethodBeat.o(165313);
      return;
      localbqe.ZHb = new avl();
      paramString2 = localbqe.ZHb;
      if (paramString2 != null) {
        paramString2.country = paramString1.pSo;
      }
      paramString2 = localbqe.ZHb;
      if (paramString2 != null) {
        paramString2.province = paramString1.pSg;
      }
      paramString2 = localbqe.ZHb;
      if (paramString2 != null) {
        paramString2.city = paramString1.pSh;
      }
      n.a((n)this, localbqe, paramck, false, false, 12);
    }
  }
  
  public final void a(boolean paramBoolean, ck<bqe> paramck)
  {
    AppMethodBeat.i(336558);
    bqe localbqe = new bqe();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbqe.ZYi = i;
      n.a((n)this, localbqe, paramck, false, false, 12);
      AppMethodBeat.o(336558);
      return;
    }
  }
  
  public final void b(int paramInt, ck<bqe> paramck)
  {
    AppMethodBeat.i(336552);
    bqe localbqe = new bqe();
    localbqe.ZYg = paramInt;
    n.a((n)this, localbqe, paramck, false, false, 12);
    AppMethodBeat.o(336552);
  }
  
  public final void b(boolean paramBoolean, ck<bqe> paramck)
  {
    AppMethodBeat.i(336560);
    bqe localbqe = new bqe();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbqe.ZYk = i;
      n.a((n)this, localbqe, paramck, false, false, 12);
      AppMethodBeat.o(336560);
      return;
    }
  }
  
  public final void c(int paramInt, ck<bqe> paramck)
  {
    AppMethodBeat.i(336553);
    bqe localbqe = new bqe();
    localbqe.ZYh = paramInt;
    n.a((n)this, localbqe, paramck, false, false, 12);
    AppMethodBeat.o(336553);
  }
  
  public final void c(String paramString, ck<bqe> paramck)
  {
    AppMethodBeat.i(165310);
    kotlin.g.b.s.u(paramString, "avatarPath");
    dr.a locala = dr.ADr;
    paramString = new dr(paramString, dr.dWA());
    com.tencent.mm.kernel.h.aZW().a(3759, (com.tencent.mm.am.h)new l.a(this, paramck));
    com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
    AppMethodBeat.o(165310);
  }
  
  public final void d(String paramString, ck<bqe> paramck)
  {
    AppMethodBeat.i(165311);
    kotlin.g.b.s.u(paramString, "nickname");
    bqe localbqe = new bqe();
    localbqe.nickname = paramString;
    n.a((n)this, localbqe, paramck, false, false, 12);
    AppMethodBeat.o(165311);
  }
  
  public final void e(String paramString, ck<bqe> paramck)
  {
    AppMethodBeat.i(165314);
    kotlin.g.b.s.u(paramString, "signature");
    bqe localbqe = new bqe();
    localbqe.signature = paramString;
    n.a((n)this, localbqe, paramck, false, false, 12);
    AppMethodBeat.o(165314);
  }
  
  public final void f(String paramString, ck<bqe> paramck)
  {
    AppMethodBeat.i(336571);
    kotlin.g.b.s.u(paramString, "coverUrl");
    bqe localbqe = new bqe();
    localbqe.coverUrl = paramString;
    n.a((n)this, localbqe, paramck, false, true, 4);
    AppMethodBeat.o(336571);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165309);
    AppMethodBeat.o(165309);
    return 1;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void pL(boolean paramBoolean)
  {
    AppMethodBeat.i(336566);
    bqe localbqe = new bqe();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localbqe.ZYj = i;
      n.a((n)this, localbqe, null, false, false, 12);
      AppMethodBeat.o(336566);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.l
 * JD-Core Version:    0.7.0.1
 */