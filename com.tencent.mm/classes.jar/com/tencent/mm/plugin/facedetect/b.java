package com.tencent.mm.plugin.facedetect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.expansions.e.a;
import com.tencent.mm.plugin.expansions.e.d;
import com.tencent.mm.plugin.facedetect.model.FaceDetectStartListener;
import com.tencent.mm.plugin.facedetect.model.FaceGetIsSupportListener;
import com.tencent.mm.plugin.facedetect.model.FaceInternalDetectListener;
import com.tencent.mm.plugin.facedetect.model.FaceModuleResUpdateListener;
import com.tencent.mm.plugin.facedetect.model.FaceStartManageListener;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetectaction.model.FaceCheckActionEventListener;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.IOException;

public final class b
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  private static FaceGetIsSupportListener zQY;
  private static FaceStartManageListener zQZ;
  private static FaceDetectStartListener zRa;
  private static FaceModuleResUpdateListener zRb;
  private static FaceCheckActionEventListener zRc;
  private static FaceInternalDetectListener zRd;
  private com.tencent.mm.vending.g.b pGe = null;
  
  static
  {
    AppMethodBeat.i(103581);
    zQY = new FaceGetIsSupportListener();
    zQZ = new FaceStartManageListener();
    zRa = new FaceDetectStartListener();
    zRb = new FaceModuleResUpdateListener();
    zRc = new FaceCheckActionEventListener();
    zRd = new FaceInternalDetectListener();
    AppMethodBeat.o(103581);
  }
  
  private static void B(Context paramContext, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(103576);
    if (!e.dHF())
    {
      k.n(paramContext, paramString1, paramString2);
      AppMethodBeat.o(103576);
      return;
    }
    e.getAssets(new e.a()
    {
      public final void a(AssetManager paramAnonymousAssetManager)
      {
        AppMethodBeat.i(271871);
        try
        {
          e.d.a(paramAnonymousAssetManager, b.this, new File(paramString2));
          AppMethodBeat.o(271871);
          return;
        }
        catch (IOException paramAnonymousAssetManager)
        {
          Log.w("MicroMsg.TaskInitFace", "copy assets from expansions file error, e = " + paramAnonymousAssetManager.getMessage());
          AppMethodBeat.o(271871);
        }
      }
    });
    AppMethodBeat.o(103576);
  }
  
  private void hy(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(103575);
    if (!e.dHF())
    {
      String str1 = y.bub(paramString1);
      String str2 = y.bub("assets:///".concat(String.valueOf(paramString2)));
      Log.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(str1)));
      Log.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(str2)));
      if ((str1 == null) || (str1.equals(str2)))
      {
        Log.i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", new Object[] { paramString1 });
        AppMethodBeat.o(103575);
        return;
      }
      y.deleteFile(paramString1);
      Log.i("MicroMsg.TaskInitFace", paramString1 + " md5 is wrong");
      k.n(MMApplicationContext.getContext(), paramString2, paramString1);
      AppMethodBeat.o(103575);
      return;
    }
    e.getAssets(new e.a()
    {
      public final void a(AssetManager paramAnonymousAssetManager)
      {
        AppMethodBeat.i(271872);
        String str = y.bub(paramString1);
        paramAnonymousAssetManager = e.d.a(paramAnonymousAssetManager, paramString2);
        Log.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(str)));
        Log.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(paramAnonymousAssetManager)));
        if ((str == null) || (str.equals(paramAnonymousAssetManager)))
        {
          Log.i("MicroMsg.TaskInitFace", "sdPath:%s   exists ", new Object[] { paramString1 });
          AppMethodBeat.o(271872);
          return;
        }
        y.deleteFile(paramString1);
        Log.i("MicroMsg.TaskInitFace", paramString1 + " md5 is wrong");
        b.access$100(MMApplicationContext.getContext(), paramString2, paramString1);
        AppMethodBeat.o(271872);
      }
    });
    AppMethodBeat.o(103575);
  }
  
  private static void safeAddListener(IListener paramIListener)
  {
    AppMethodBeat.i(103574);
    if (paramIListener == null)
    {
      Log.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
      AppMethodBeat.o(103574);
      return;
    }
    if (EventCenter.instance.hadListened(paramIListener))
    {
      Log.w("MicroMsg.TaskInitFace", "hy: already has listener");
      AppMethodBeat.o(103574);
      return;
    }
    paramIListener.alive();
    AppMethodBeat.o(103574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b
 * JD-Core Version:    0.7.0.1
 */