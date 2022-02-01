package com.tencent.mm.plugin.finder.cgi.oplog;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.bx.a;
import com.tencent.mm.plugin.finder.cgi.cl;
import com.tencent.mm.plugin.finder.cgi.cl.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.x;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedMvReproduce", "show", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyUserAtShowTab", "private", "modifyUserAvatar", "avatarPath", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserPrivate", "modifyUserSex", "sex", "modifyUserSignature", "signature", "modifyUserWxProfile", "plugin-finder_release"})
public final class i
  extends k<azg>
  implements com.tencent.mm.ak.i, x
{
  final String TAG = "Finder.FinderModifyUserService";
  
  public final void a(int paramInt, ai<azg> paramai)
  {
    AppMethodBeat.i(242662);
    azg localazg = new azg();
    localazg.fuA = paramInt;
    localazg.LCk = 0;
    a(localazg, paramai, false);
    AppMethodBeat.o(242662);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, ai<azg> paramai)
  {
    AppMethodBeat.i(165313);
    p.h(paramString1, "country");
    p.h(paramString2, "province");
    p.h(paramString3, "city");
    azg localazg = new azg();
    localazg.country = paramString1;
    localazg.fuJ = paramString2;
    localazg.fuK = paramString3;
    localazg.LCj = paramInt;
    paramString1 = a.PRN;
    paramString1 = ((FinderGlobalLocationVM)a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
    if (paramString1 != null)
    {
      localazg.LCl = new app();
      paramString2 = localazg.LCl;
      if (paramString2 != null) {
        paramString2.country = paramString1.keh;
      }
      paramString2 = localazg.LCl;
      if (paramString2 != null) {
        paramString2.fuJ = paramString1.kdZ;
      }
      paramString2 = localazg.LCl;
      if (paramString2 != null) {
        paramString2.fuK = paramString1.kea;
      }
      a(localazg, paramai, false);
      AppMethodBeat.o(165313);
      return;
    }
    ((i)this).a(localazg, paramai, false);
    AppMethodBeat.o(165313);
  }
  
  public final void a(boolean paramBoolean, ai<azg> paramai)
  {
    AppMethodBeat.i(242665);
    azg localazg = new azg();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localazg.LJc = i;
      a(localazg, paramai, false);
      AppMethodBeat.o(242665);
      return;
    }
  }
  
  public final void b(int paramInt, ai<azg> paramai)
  {
    AppMethodBeat.i(242663);
    azg localazg = new azg();
    localazg.LJa = paramInt;
    a(localazg, paramai, false);
    AppMethodBeat.o(242663);
  }
  
  public final void c(int paramInt, ai<azg> paramai)
  {
    AppMethodBeat.i(242664);
    azg localazg = new azg();
    localazg.LJb = paramInt;
    a(localazg, paramai, false);
    AppMethodBeat.o(242664);
  }
  
  public final void c(String paramString, final ai<azg> paramai)
  {
    AppMethodBeat.i(165310);
    p.h(paramString, "avatarPath");
    cl.a locala = cl.twA;
    paramString = new cl(paramString, cl.cZi());
    g.azz().a(3759, (com.tencent.mm.ak.i)new a(this, paramai));
    g.azz().b((q)paramString);
    AppMethodBeat.o(165310);
  }
  
  public final void d(String paramString, ai<azg> paramai)
  {
    AppMethodBeat.i(165311);
    p.h(paramString, "nickname");
    azg localazg = new azg();
    localazg.nickname = paramString;
    a(localazg, paramai, false);
    AppMethodBeat.o(165311);
  }
  
  public final void e(String paramString, ai<azg> paramai)
  {
    AppMethodBeat.i(165314);
    p.h(paramString, "signature");
    azg localazg = new azg();
    localazg.signature = paramString;
    a(localazg, paramai, false);
    AppMethodBeat.o(165314);
  }
  
  public final int getCmdId()
  {
    AppMethodBeat.i(165309);
    bx.a locala = bx.tvW;
    int i = bx.cYO();
    AppMethodBeat.o(165309);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void mR(boolean paramBoolean)
  {
    AppMethodBeat.i(242666);
    azg localazg = new azg();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localazg.LJd = i;
      a(localazg, null, false);
      AppMethodBeat.o(242666);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService$modifyUserAvatar$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.ak.i
  {
    a(ai paramai) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(165307);
      Log.i(this.txN.TAG, "upload head img errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
      g.azz().b(3759, (com.tencent.mm.ak.i)this);
      paramString = new azg();
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUploadHeadImg");
        AppMethodBeat.o(165307);
        throw paramString;
      }
      paramString.iAR = ((cl)paramq).twt;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.txN.a(paramString, paramai, false);
        AppMethodBeat.o(165307);
        return;
      }
      paramq = paramai;
      if (paramq != null)
      {
        apg localapg = new apg();
        bx.a locala = bx.tvW;
        localapg.cmdId = bx.cYO();
        localapg.retCode = -1;
        paramq.a(paramString, localapg);
        AppMethodBeat.o(165307);
        return;
      }
      AppMethodBeat.o(165307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.i
 * JD-Core Version:    0.7.0.1
 */