package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Deprecated
public enum AppBrandStickyBannerLogic
{
  static final class Watcher
    extends MainProcessTask
  {
    public static final Parcelable.Creator<Watcher> CREATOR;
    private static final transient Map<String, f> rca;
    String rbX;
    String rbY;
    int rbZ;
    
    static
    {
      AppMethodBeat.i(49031);
      rca = new HashMap();
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(49031);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(49026);
      if (Util.isNullOrNil(this.rbX))
      {
        AppMethodBeat.o(49026);
        return;
      }
      synchronized (rca)
      {
        if (rca.containsKey(this.rbX)) {
          AppBrandStickyBannerLogic.b.c((f)rca.get(this.rbX));
        }
        f local1 = new f()
        {
          public final void ce(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(49024);
            AppBrandStickyBannerLogic.Watcher.this.rbY = paramAnonymousString;
            AppBrandStickyBannerLogic.Watcher.this.rbZ = paramAnonymousInt;
            AppBrandStickyBannerLogic.Watcher.a(AppBrandStickyBannerLogic.Watcher.this);
            AppMethodBeat.o(49024);
          }
        };
        AppBrandStickyBannerLogic.b.d(local1);
        rca.put(this.rbX, local1);
        AppMethodBeat.o(49026);
        return;
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(49027);
      AppBrandStickyBannerLogic.a.cK(this.rbY, this.rbZ);
      AppMethodBeat.o(49027);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(49029);
      this.rbX = paramParcel.readString();
      this.rbY = paramParcel.readString();
      this.rbZ = paramParcel.readInt();
      AppMethodBeat.o(49029);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(49028);
      paramParcel.writeString(this.rbX);
      paramParcel.writeString(this.rbY);
      paramParcel.writeInt(this.rbZ);
      AppMethodBeat.o(49028);
    }
  }
  
  public static final class a
  {
    private static final AppBrandStickyBannerLogic.Watcher rbN;
    private static final Set<f> rbO;
    private static final HashMap<String, Boolean> rbP;
    private static final HashMap<String, f> rbQ;
    private static final c rbR;
    private static final Map<String, String> rbS;
    
    static
    {
      AppMethodBeat.i(49006);
      rbN = new AppBrandStickyBannerLogic.Watcher();
      rbO = new HashSet();
      rbP = new HashMap();
      rbQ = new HashMap();
      rbR = new c();
      rbS = new HashMap();
      AppMethodBeat.o(49006);
    }
    
    public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(49000);
      if (Util.isNullOrNil(paramString1))
      {
        AppMethodBeat.o(49000);
        return;
      }
      if (paramContext == null) {
        paramContext = MMApplicationContext.getContext();
      }
      for (;;)
      {
        Intent localIntent = new Intent().setClassName(paramContext, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
        synchronized (rbS)
        {
          String str = (String)rbS.get(paramString1);
          b.a(localIntent, paramString1, paramInt, paramString2, paramString3, Util.nullAsNil(str));
          paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString1.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {}
        }
        AppMethodBeat.o(49000);
        return;
      }
    }
    
    public static void c(f paramf)
    {
      AppMethodBeat.i(49002);
      if (paramf != null) {
        synchronized (rbO)
        {
          rbO.remove(paramf);
          AppMethodBeat.o(49002);
          return;
        }
      }
      AppMethodBeat.o(49002);
    }
    
    static void cK(String paramString, int paramInt)
    {
      AppMethodBeat.i(48999);
      synchronized (rbO)
      {
        Iterator localIterator = rbO.iterator();
        if (localIterator.hasNext()) {
          ((f)localIterator.next()).ce(paramString, paramInt);
        }
      }
      AppMethodBeat.o(48999);
    }
    
    public static boolean ckN()
    {
      AppMethodBeat.i(49001);
      AppBrandStickyBannerLogic.access$200();
      AppMethodBeat.o(49001);
      return false;
    }
    
    public static void d(f paramf)
    {
      AppMethodBeat.i(49003);
      rbN.rbX = MMApplicationContext.getProcessName();
      rbN.bsM();
      if (paramf != null) {
        synchronized (rbO)
        {
          rbO.add(paramf);
          AppMethodBeat.o(49003);
          return;
        }
      }
      AppMethodBeat.o(49003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic
 * JD-Core Version:    0.7.0.1
 */