package com.tencent.mm.mj_template.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.api.c;
import com.tencent.mm.mj_template.plugin.c.e;
import com.tencent.mm.mj_template.plugin.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/common_widget/MaasPermissionCheckerImpl;", "Lcom/tencent/mm/mj_template/api/IMaasUserPermissoinChecker;", "()V", "ENABLED", "", "MMKV_KEY", "REQUESTED", "TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "checkPermission", "", "scene", "hasRequested", "requestPermission", "", "context", "Landroid/content/Context;", "resultOk", "Lkotlin/Function0;", "resultFail", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isCancel", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  private static final kotlin.j exj;
  public static final a nZt;
  
  static
  {
    AppMethodBeat.i(239560);
    nZt = new a();
    exj = k.cm((kotlin.g.a.a)a.a.nZu);
    AppMethodBeat.o(239560);
  }
  
  private static final void M(b paramb)
  {
    AppMethodBeat.i(239538);
    s.u(paramb, "$resultFail");
    Log.i("MaasPermissionCheckHelp", "requestPermission cancel");
    paramb.invoke(Boolean.TRUE);
    AppMethodBeat.o(239538);
  }
  
  private static final void a(String paramString, kotlin.g.a.a parama, com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(239554);
    s.u(paramString, "$scene");
    s.u(parama, "$resultOk");
    s.u(paramj, "$dialog");
    Log.i("MaasPermissionCheckHelp", "requestPermission ok");
    atj().putBoolean(s.X(paramString, "_enabled"), true);
    parama.invoke();
    paramj.agfT = a..ExternalSyntheticLambda3.INSTANCE;
    paramj.cyW();
    AppMethodBeat.o(239554);
  }
  
  private static final void a(b paramb, com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(239542);
    s.u(paramb, "$resultFail");
    s.u(paramj, "$dialog");
    Log.i("MaasPermissionCheckHelp", "requestPermission deny");
    paramb.invoke(Boolean.FALSE);
    paramj.agfT = a..ExternalSyntheticLambda4.INSTANCE;
    paramj.cyW();
    AppMethodBeat.o(239542);
  }
  
  private static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(239533);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(239533);
    return localMultiProcessMMKV;
  }
  
  private static final void bxl() {}
  
  private static final void bxm() {}
  
  public final boolean HC(String paramString)
  {
    AppMethodBeat.i(239592);
    s.u(paramString, "scene");
    boolean bool = atj().getBoolean(s.X(paramString, "_enabled"), false);
    Log.i("MaasPermissionCheckHelp", "checkPermission for " + paramString + ", hasPermission: " + bool);
    AppMethodBeat.o(239592);
    return bool;
  }
  
  public final boolean HD(String paramString)
  {
    AppMethodBeat.i(239596);
    s.u(paramString, "scene");
    boolean bool = atj().getBoolean(s.X(paramString, "_requested"), false);
    Log.i("MaasPermissionCheckHelp", "hasRequested for " + paramString + ", hasRequestes: " + bool);
    AppMethodBeat.o(239596);
    return bool;
  }
  
  public final void a(String paramString, Context paramContext, kotlin.g.a.a<ah> parama, b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(239606);
    s.u(paramString, "scene");
    s.u(paramContext, "context");
    s.u(parama, "resultOk");
    s.u(paramb, "resultFail");
    if (atj().getBoolean(s.X(paramString, "_enabled"), false))
    {
      Log.i("MaasPermissionCheckHelp", s.X("requestPermission has permission, no need to request for ", paramString));
      parama.invoke();
      AppMethodBeat.o(239606);
      return;
    }
    Log.i("MaasPermissionCheckHelp", s.X("requestPermission for ", paramString));
    atj().putBoolean(s.X(paramString, "_requested"), true);
    com.tencent.mm.ui.widget.a.j localj = new com.tencent.mm.ui.widget.a.j(paramContext, 1, 0, true);
    localj.d(paramContext.getText(c.g.odx), paramContext.getText(c.g.odw));
    localj.aFf(c.e.ocW);
    localj.agfT = new a..ExternalSyntheticLambda2(paramb);
    localj.a(new a..ExternalSyntheticLambda1(paramb, localj), new a..ExternalSyntheticLambda0(paramString, parama, localj));
    localj.dDn();
    AppMethodBeat.o(239606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.a.a
 * JD-Core Version:    0.7.0.1
 */