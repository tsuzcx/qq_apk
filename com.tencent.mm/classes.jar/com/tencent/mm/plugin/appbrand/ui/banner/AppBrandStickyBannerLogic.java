package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
    private static final transient Map<String, f> mhE;
    String mhB;
    String mhC;
    int mhD;
    
    static
    {
      AppMethodBeat.i(49031);
      mhE = new HashMap();
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(49031);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(49026);
      if (bs.isNullOrNil(this.mhB))
      {
        AppMethodBeat.o(49026);
        return;
      }
      synchronized (mhE)
      {
        if (mhE.containsKey(this.mhB)) {
          AppBrandStickyBannerLogic.b.c((f)mhE.get(this.mhB));
        }
        f local1 = new f()
        {
          public final void bz(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(49024);
            AppBrandStickyBannerLogic.Watcher.this.mhC = paramAnonymousString;
            AppBrandStickyBannerLogic.Watcher.this.mhD = paramAnonymousInt;
            AppBrandStickyBannerLogic.Watcher.a(AppBrandStickyBannerLogic.Watcher.this);
            AppMethodBeat.o(49024);
          }
        };
        AppBrandStickyBannerLogic.b.d(local1);
        mhE.put(this.mhB, local1);
        AppMethodBeat.o(49026);
        return;
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(49027);
      AppBrandStickyBannerLogic.a.ca(this.mhC, this.mhD);
      AppMethodBeat.o(49027);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(49029);
      this.mhB = paramParcel.readString();
      this.mhC = paramParcel.readString();
      this.mhD = paramParcel.readInt();
      AppMethodBeat.o(49029);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(49028);
      paramParcel.writeString(this.mhB);
      paramParcel.writeString(this.mhC);
      paramParcel.writeInt(this.mhD);
      AppMethodBeat.o(49028);
    }
  }
  
  public static final class a
  {
    private static final AppBrandStickyBannerLogic.Watcher mhr;
    private static final Set<f> mhs;
    private static final HashMap<String, Boolean> mht;
    private static final HashMap<String, f> mhu;
    private static final c mhv;
    private static final Map<String, String> mhw;
    
    static
    {
      AppMethodBeat.i(49006);
      mhr = new AppBrandStickyBannerLogic.Watcher();
      mhs = new HashSet();
      mht = new HashMap();
      mhu = new HashMap();
      mhv = new c();
      mhw = new HashMap();
      AppMethodBeat.o(49006);
    }
    
    public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(49000);
      if (bs.isNullOrNil(paramString1))
      {
        AppMethodBeat.o(49000);
        return;
      }
      if (paramContext == null) {
        paramContext = ai.getContext();
      }
      for (;;)
      {
        Intent localIntent = new Intent().setClassName(paramContext, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
        synchronized (mhw)
        {
          String str = (String)mhw.get(paramString1);
          b.a(localIntent, paramString1, paramInt, paramString2, paramString3, bs.nullAsNil(str));
          paramString1 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.aeD(), "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString1.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {}
        }
        AppMethodBeat.o(49000);
        return;
      }
    }
    
    public static boolean bvW()
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
        synchronized (mhs)
        {
          mhs.remove(paramf);
          AppMethodBeat.o(49002);
          return;
        }
      }
      AppMethodBeat.o(49002);
    }
    
    static void ca(String paramString, int paramInt)
    {
      AppMethodBeat.i(48999);
      synchronized (mhs)
      {
        Iterator localIterator = mhs.iterator();
        if (localIterator.hasNext()) {
          ((f)localIterator.next()).bz(paramString, paramInt);
        }
      }
      AppMethodBeat.o(48999);
    }
    
    public static void d(f paramf)
    {
      AppMethodBeat.i(49003);
      mhr.mhB = ai.getProcessName();
      AppBrandMainProcessService.a(mhr);
      if (paramf != null) {
        synchronized (mhs)
        {
          mhs.add(paramf);
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