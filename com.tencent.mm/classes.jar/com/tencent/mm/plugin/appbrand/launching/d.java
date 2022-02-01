package com.tencent.mm.plugin.appbrand.launching;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchCodeSceneLogic;", "", "()V", "RELATED_SCENE", "", "", "[Ljava/lang/Integer;", "TAG", "", "parseCodeScene", "scene", "statObj", "Landroid/os/Bundle;", "CodeScene", "ScanScene", "StatKey", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d sVF;
  private static final Integer[] sVG;
  
  static
  {
    AppMethodBeat.i(320779);
    sVF = new d();
    sVG = new Integer[] { Integer.valueOf(1012), Integer.valueOf(1031), Integer.valueOf(1048), Integer.valueOf(1125) };
    AppMethodBeat.o(320779);
  }
  
  public static final int n(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(320772);
    Log.i("MicroMsg.AppBrandLaunchCodeSceneLogic", s.X("parseCodeScene, scene: ", Integer.valueOf(paramInt)));
    if (!k.contains(sVG, Integer.valueOf(paramInt)))
    {
      Log.i("MicroMsg.AppBrandLaunchCodeSceneLogic", "parseCodeScene, scene is not related");
      AppMethodBeat.o(320772);
      return 0;
    }
    if (paramBundle == null)
    {
      Log.i("MicroMsg.AppBrandLaunchCodeSceneLogic", "parseCodeScene, statObj is null");
      AppMethodBeat.o(320772);
      return 9;
    }
    paramInt = paramBundle.getInt("LaunchCodeScene_ScanScene");
    Object localObject = b.sVI;
    if (!b.uB(paramInt))
    {
      Log.i("MicroMsg.AppBrandLaunchCodeSceneLogic", "parseCodeScene, scanScene(" + paramInt + ") is invalid 1");
      AppMethodBeat.o(320772);
      return 9;
    }
    if (1 == paramInt)
    {
      int i = paramBundle.getInt("LaunchCodeScene_ChatType");
      Log.i("MicroMsg.AppBrandLaunchCodeSceneLogic", s.X("parseCodeScene, chatType: ", Integer.valueOf(i)));
      localObject = a.opM;
      paramInt = i;
      if (!a.uB(i))
      {
        paramBundle = paramBundle.getString("LaunchCodeScene_Username");
        if (paramBundle == null)
        {
          Log.w("MicroMsg.AppBrandLaunchCodeSceneLogic", "parseCodeScene, chatType is invalid, username is null");
          AppMethodBeat.o(320772);
          return 9;
        }
        paramInt = a.KG(paramBundle);
        Log.i("MicroMsg.AppBrandLaunchCodeSceneLogic", "parseCodeScene, username: " + paramBundle + ", chatType: " + paramInt);
      }
      switch (paramInt)
      {
      default: 
        Log.w("MicroMsg.AppBrandLaunchCodeSceneLogic", "parseCodeScene, chatType is invalid");
        AppMethodBeat.o(320772);
        return 9;
      case 1: 
        AppMethodBeat.o(320772);
        return 1;
      case 2: 
        AppMethodBeat.o(320772);
        return 2;
      case 3: 
        AppMethodBeat.o(320772);
        return 3;
      }
      AppMethodBeat.o(320772);
      return 4;
    }
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.AppBrandLaunchCodeSceneLogic", "parseCodeScene, scanScene(" + paramInt + ") is invalid 2");
      AppMethodBeat.o(320772);
      return 9;
    case 2: 
      AppMethodBeat.o(320772);
      return 5;
    case 3: 
      AppMethodBeat.o(320772);
      return 6;
    case 4: 
      AppMethodBeat.o(320772);
      return 7;
    case 5: 
      AppMethodBeat.o(320772);
      return 8;
    }
    AppMethodBeat.o(320772);
    return 9;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchCodeSceneLogic$CodeScene;", "", "()V", "APP_BRAND", "", "FAV", "GROUP_CHAT", "H5", "INVALID", "OTHER", "SINGLE_CHAT", "SNS", "WEWORK_GROUP_CHAT", "WEWORK_SINGLE_CHAT", "isValid", "", "scene", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a sVH;
    
    static
    {
      AppMethodBeat.i(320681);
      sVH = new a();
      AppMethodBeat.o(320681);
    }
    
    public static final boolean uB(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramInt <= 9)
      {
        bool1 = bool2;
        if (paramInt > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchCodeSceneLogic$ScanScene;", "", "()V", "APP_BRAND", "", "CHAT", "FAV", "H5", "INVALID", "OTHER", "SNS", "isValid", "", "scene", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b sVI;
    
    static
    {
      AppMethodBeat.i(320667);
      sVI = new b();
      AppMethodBeat.o(320667);
    }
    
    public static boolean uB(int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramInt > 0)
      {
        bool1 = bool2;
        if (paramInt <= 6) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d
 * JD-Core Version:    0.7.0.1
 */