package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
    private static final transient Map<String, f> mNi;
    String mNf;
    String mNg;
    int mNh;
    
    static
    {
      AppMethodBeat.i(49031);
      mNi = new HashMap();
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(49031);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(49026);
      if (bu.isNullOrNil(this.mNf))
      {
        AppMethodBeat.o(49026);
        return;
      }
      synchronized (mNi)
      {
        if (mNi.containsKey(this.mNf)) {
          AppBrandStickyBannerLogic.b.c((f)mNi.get(this.mNf));
        }
        f local1 = new f()
        {
          public final void bE(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(49024);
            AppBrandStickyBannerLogic.Watcher.this.mNg = paramAnonymousString;
            AppBrandStickyBannerLogic.Watcher.this.mNh = paramAnonymousInt;
            AppBrandStickyBannerLogic.Watcher.a(AppBrandStickyBannerLogic.Watcher.this);
            AppMethodBeat.o(49024);
          }
        };
        AppBrandStickyBannerLogic.b.d(local1);
        mNi.put(this.mNf, local1);
        AppMethodBeat.o(49026);
        return;
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(49027);
      AppBrandStickyBannerLogic.a.ch(this.mNg, this.mNh);
      AppMethodBeat.o(49027);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(49029);
      this.mNf = paramParcel.readString();
      this.mNg = paramParcel.readString();
      this.mNh = paramParcel.readInt();
      AppMethodBeat.o(49029);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(49028);
      paramParcel.writeString(this.mNf);
      paramParcel.writeString(this.mNg);
      paramParcel.writeInt(this.mNh);
      AppMethodBeat.o(49028);
    }
  }
  
  public static final class a
  {
    private static final AppBrandStickyBannerLogic.Watcher mMV;
    private static final Set<f> mMW;
    private static final HashMap<String, Boolean> mMX;
    private static final HashMap<String, f> mMY;
    private static final c mMZ;
    private static final Map<String, String> mNa;
    
    static
    {
      AppMethodBeat.i(49006);
      mMV = new AppBrandStickyBannerLogic.Watcher();
      mMW = new HashSet();
      mMX = new HashMap();
      mMY = new HashMap();
      mMZ = new c();
      mNa = new HashMap();
      AppMethodBeat.o(49006);
    }
    
    public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(49000);
      if (bu.isNullOrNil(paramString1))
      {
        AppMethodBeat.o(49000);
        return;
      }
      if (paramContext == null) {
        paramContext = ak.getContext();
      }
      for (;;)
      {
        Intent localIntent = new Intent().setClassName(paramContext, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
        synchronized (mNa)
        {
          String str = (String)mNa.get(paramString1);
          b.a(localIntent, paramString1, paramInt, paramString2, paramString3, bu.nullAsNil(str));
          paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahE(), "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString1.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {}
        }
        AppMethodBeat.o(49000);
        return;
      }
    }
    
    public static boolean bAX()
    {
      AppMethodBeat.i(49001);
      AppBrandStickyBannerLogic.access$200();
      AppMethodBeat.o(49001);
      return false;
    }
    
    public static void c(f paramf)
    {
      AppMethodBeat.i(49002);
      if (paramf != null) {
        synchronized (mMW)
        {
          mMW.remove(paramf);
          AppMethodBeat.o(49002);
          return;
        }
      }
      AppMethodBeat.o(49002);
    }
    
    static void ch(String paramString, int paramInt)
    {
      AppMethodBeat.i(48999);
      synchronized (mMW)
      {
        Iterator localIterator = mMW.iterator();
        if (localIterator.hasNext()) {
          ((f)localIterator.next()).bE(paramString, paramInt);
        }
      }
      AppMethodBeat.o(48999);
    }
    
    public static void d(f paramf)
    {
      AppMethodBeat.i(49003);
      mMV.mNf = ak.getProcessName();
      AppBrandMainProcessService.a(mMV);
      if (paramf != null) {
        synchronized (mMW)
        {
          mMW.add(paramf);
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