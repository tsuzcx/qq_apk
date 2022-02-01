package com.tencent.mm.plugin.expansions;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "", "()V", "assetsCallback", "Lkotlin/Function1;", "Landroid/content/res/AssetManager;", "", "getAssetsCallback", "()Lkotlin/jvm/functions/Function1;", "setAssetsCallback", "(Lkotlin/jvm/functions/Function1;)V", "callbackFail", "Lkotlin/Function0;", "getCallbackFail", "()Lkotlin/jvm/functions/Function0;", "setCallbackFail", "(Lkotlin/jvm/functions/Function0;)V", "installSuccess", "getInstallSuccess", "setInstallSuccess", "invoke", "onFail", "block", "onGetAssets", "onInstalled", "expansions-visitor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public a<ah> yFv;
  a<ah> yFw;
  public b<? super AssetManager, ah> yFx;
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expansions/ExpansionsKtWrapper$invoke$1", "Lcom/tencent/mm/plugin/expansions/JExpansions$AssetsCallback;", "onFail", "", "onSuccess", "assetManager", "Landroid/content/res/AssetManager;", "expansions-visitor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements e.a
  {
    a(c paramc) {}
    
    public final void a(AssetManager paramAssetManager)
    {
      AppMethodBeat.i(152981);
      s.u(paramAssetManager, "assetManager");
      b localb = this.yFy.yFx;
      if (localb != null) {
        localb.invoke(paramAssetManager);
      }
      AppMethodBeat.o(152981);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expansions/ExpansionsKtWrapper$invoke$2", "Lcom/tencent/mm/plugin/expansions/JExpansions$Callback;", "onFail", "", "onSuccess", "behavior", "Lcom/tencent/mm/toolkit/frontia/ext/ShareLibrary$SoLibBehavior;", "expansions-visitor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements e.b
  {
    b(c paramc) {}
    
    public final void a(com.tencent.mm.toolkit.frontia.a.c.a parama)
    {
      AppMethodBeat.i(152982);
      s.u(parama, "behavior");
      parama = this.yFy.yFw;
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(152982);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.c
 * JD-Core Version:    0.7.0.1
 */