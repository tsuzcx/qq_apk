package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.Executor;

public final class d
{
  private static final a bTX;
  static final a bTY;
  
  static
  {
    AppMethodBeat.i(194306);
    bTX = new a()
    {
      public final void r(int paramAnonymousInt, Object paramAnonymousObject) {}
      
      public final void s(int paramAnonymousInt, Object paramAnonymousObject) {}
    };
    bTY = new a()
    {
      public final void r(int paramAnonymousInt, Object paramAnonymousObject) {}
      
      public final void s(int paramAnonymousInt, Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(194306);
  }
  
  public static void a(Context paramContext, Executor paramExecutor, a parama)
  {
    AppMethodBeat.i(194287);
    paramContext = paramContext.getApplicationContext();
    String str = paramContext.getPackageName();
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    a(paramContext.getAssets(), str, new File(localApplicationInfo.sourceDir).getName(), paramExecutor, parama);
    AppMethodBeat.o(194287);
  }
  
  private static void a(AssetManager paramAssetManager, String paramString1, String paramString2, Executor paramExecutor, a parama)
  {
    AppMethodBeat.i(194269);
    if (Build.VERSION.SDK_INT < 19)
    {
      a(paramExecutor, parama, 3);
      AppMethodBeat.o(194269);
      return;
    }
    paramAssetManager = new a(paramAssetManager, paramExecutor, parama, paramString2, "dexopt/baseline.prof", new File(new File("/data/misc/profiles/cur/0", paramString1), "primary.prof"), new File(new File("/data/misc/profiles/ref", paramString1), "primary.prof"));
    if (!paramAssetManager.II())
    {
      AppMethodBeat.o(194269);
      return;
    }
    paramString1 = new d..ExternalSyntheticLambda0(paramExecutor, parama);
    paramAssetManager.IK().IL().a(paramString1);
    AppMethodBeat.o(194269);
  }
  
  private static void a(Executor paramExecutor, a parama, int paramInt)
  {
    AppMethodBeat.i(194249);
    paramExecutor.execute(new d..ExternalSyntheticLambda1(parama, paramInt, null));
    AppMethodBeat.o(194249);
  }
  
  public static void ap(Context paramContext)
  {
    AppMethodBeat.i(194279);
    a(paramContext, ProfileInstallReceiver..ExternalSyntheticLambda0.INSTANCE, bTX);
    AppMethodBeat.o(194279);
  }
  
  private static void b(Executor paramExecutor, a parama, int paramInt)
  {
    AppMethodBeat.i(194256);
    paramExecutor.execute(new d..ExternalSyntheticLambda2(parama, paramInt, null));
    AppMethodBeat.o(194256);
  }
  
  public static abstract interface a
  {
    public abstract void r(int paramInt, Object paramObject);
    
    public abstract void s(int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.profileinstaller.d
 * JD-Core Version:    0.7.0.1
 */