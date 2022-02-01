package com.tencent.mm.plugin.expansions;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.frontia.a.c.a;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "", "()V", "assetsCallback", "Lkotlin/Function1;", "Landroid/content/res/AssetManager;", "", "getAssetsCallback", "()Lkotlin/jvm/functions/Function1;", "setAssetsCallback", "(Lkotlin/jvm/functions/Function1;)V", "callbackFail", "Lkotlin/Function0;", "getCallbackFail", "()Lkotlin/jvm/functions/Function0;", "setCallbackFail", "(Lkotlin/jvm/functions/Function0;)V", "installSuccess", "getInstallSuccess", "setInstallSuccess", "invoke", "onFail", "block", "onGetAssets", "onInstalled", "expansions-visitor_release"})
public final class b
{
  public a<z> qvT;
  a<z> qvU;
  public d.g.a.b<? super AssetManager, z> qvV;
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expansions/ExpansionsKtWrapper$invoke$1", "Lcom/tencent/mm/plugin/expansions/Expansions$AssetsCallback;", "onFail", "", "onSuccess", "assetManager", "Landroid/content/res/AssetManager;", "expansions-visitor_release"})
  public static final class a
    implements a.a
  {
    public final void a(AssetManager paramAssetManager)
    {
      AppMethodBeat.i(152981);
      p.h(paramAssetManager, "assetManager");
      d.g.a.b localb = this.qvW.qvV;
      if (localb != null)
      {
        localb.invoke(paramAssetManager);
        AppMethodBeat.o(152981);
        return;
      }
      AppMethodBeat.o(152981);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expansions/ExpansionsKtWrapper$invoke$2", "Lcom/tencent/mm/plugin/expansions/Expansions$Callback;", "onFail", "", "onSuccess", "behavior", "Lcom/tencent/mm/toolkit/frontia/ext/ShareLibrary$SoLibBehavior;", "expansions-visitor_release"})
  public static final class b
    implements a.b
  {
    public final void a(c.a parama)
    {
      AppMethodBeat.i(152982);
      p.h(parama, "behavior");
      parama = this.qvW.qvU;
      if (parama != null)
      {
        parama.invoke();
        AppMethodBeat.o(152982);
        return;
      }
      AppMethodBeat.o(152982);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.b
 * JD-Core Version:    0.7.0.1
 */