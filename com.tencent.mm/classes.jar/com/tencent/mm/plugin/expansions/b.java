package com.tencent.mm.plugin.expansions;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.frontia.a.c.a;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "", "()V", "assetsCallback", "Lkotlin/Function1;", "Landroid/content/res/AssetManager;", "", "getAssetsCallback", "()Lkotlin/jvm/functions/Function1;", "setAssetsCallback", "(Lkotlin/jvm/functions/Function1;)V", "callbackFail", "Lkotlin/Function0;", "getCallbackFail", "()Lkotlin/jvm/functions/Function0;", "setCallbackFail", "(Lkotlin/jvm/functions/Function0;)V", "installSuccess", "getInstallSuccess", "setInstallSuccess", "invoke", "onFail", "block", "onGetAssets", "onInstalled", "expansions-visitor_release"})
public final class b
{
  public a<x> vtk;
  a<x> vtl;
  public kotlin.g.a.b<? super AssetManager, x> vtm;
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expansions/ExpansionsKtWrapper$invoke$1", "Lcom/tencent/mm/plugin/expansions/Expansions$AssetsCallback;", "onFail", "", "onSuccess", "assetManager", "Landroid/content/res/AssetManager;", "expansions-visitor_release"})
  public static final class a
    implements a.a
  {
    public final void a(AssetManager paramAssetManager)
    {
      AppMethodBeat.i(152981);
      p.k(paramAssetManager, "assetManager");
      kotlin.g.a.b localb = this.vtn.vtm;
      if (localb != null)
      {
        localb.invoke(paramAssetManager);
        AppMethodBeat.o(152981);
        return;
      }
      AppMethodBeat.o(152981);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expansions/ExpansionsKtWrapper$invoke$2", "Lcom/tencent/mm/plugin/expansions/Expansions$Callback;", "onFail", "", "onSuccess", "behavior", "Lcom/tencent/mm/toolkit/frontia/ext/ShareLibrary$SoLibBehavior;", "expansions-visitor_release"})
  public static final class b
    implements a.b
  {
    public final void a(c.a parama)
    {
      AppMethodBeat.i(152982);
      p.k(parama, "behavior");
      parama = this.vtn.vtl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.b
 * JD-Core Version:    0.7.0.1
 */