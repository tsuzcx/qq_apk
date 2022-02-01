package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
    private static final transient Map<String, f> mIf;
    String mIb;
    String mIc;
    int mIe;
    
    static
    {
      AppMethodBeat.i(49031);
      mIf = new HashMap();
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(49031);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(49026);
      if (bt.isNullOrNil(this.mIb))
      {
        AppMethodBeat.o(49026);
        return;
      }
      synchronized (mIf)
      {
        if (mIf.containsKey(this.mIb)) {
          AppBrandStickyBannerLogic.b.c((f)mIf.get(this.mIb));
        }
        f local1 = new f()
        {
          public final void bB(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(49024);
            AppBrandStickyBannerLogic.Watcher.this.mIc = paramAnonymousString;
            AppBrandStickyBannerLogic.Watcher.this.mIe = paramAnonymousInt;
            AppBrandStickyBannerLogic.Watcher.a(AppBrandStickyBannerLogic.Watcher.this);
            AppMethodBeat.o(49024);
          }
        };
        AppBrandStickyBannerLogic.b.d(local1);
        mIf.put(this.mIb, local1);
        AppMethodBeat.o(49026);
        return;
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(49027);
      AppBrandStickyBannerLogic.a.cd(this.mIc, this.mIe);
      AppMethodBeat.o(49027);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(49029);
      this.mIb = paramParcel.readString();
      this.mIc = paramParcel.readString();
      this.mIe = paramParcel.readInt();
      AppMethodBeat.o(49029);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(49028);
      paramParcel.writeString(this.mIb);
      paramParcel.writeString(this.mIc);
      paramParcel.writeInt(this.mIe);
      AppMethodBeat.o(49028);
    }
  }
  
  public static final class a
  {
    private static final AppBrandStickyBannerLogic.Watcher mHR;
    private static final Set<f> mHS;
    private static final HashMap<String, Boolean> mHT;
    private static final HashMap<String, f> mHU;
    private static final c mHV;
    private static final Map<String, String> mHW;
    
    static
    {
      AppMethodBeat.i(49006);
      mHR = new AppBrandStickyBannerLogic.Watcher();
      mHS = new HashSet();
      mHT = new HashMap();
      mHU = new HashMap();
      mHV = new c();
      mHW = new HashMap();
      AppMethodBeat.o(49006);
    }
    
    public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      AppMethodBeat.i(49000);
      if (bt.isNullOrNil(paramString1))
      {
        AppMethodBeat.o(49000);
        return;
      }
      if (paramContext == null) {
        paramContext = aj.getContext();
      }
      for (;;)
      {
        Intent localIntent = new Intent().setClassName(paramContext, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
        synchronized (mHW)
        {
          String str = (String)mHW.get(paramString1);
          b.a(localIntent, paramString1, paramInt, paramString2, paramString3, bt.nullAsNil(str));
          paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString1.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {}
        }
        AppMethodBeat.o(49000);
        return;
      }
    }
    
    public static boolean bAc()
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
        synchronized (mHS)
        {
          mHS.remove(paramf);
          AppMethodBeat.o(49002);
          return;
        }
      }
      AppMethodBeat.o(49002);
    }
    
    static void cd(String paramString, int paramInt)
    {
      AppMethodBeat.i(48999);
      synchronized (mHS)
      {
        Iterator localIterator = mHS.iterator();
        if (localIterator.hasNext()) {
          ((f)localIterator.next()).bB(paramString, paramInt);
        }
      }
      AppMethodBeat.o(48999);
    }
    
    public static void d(f paramf)
    {
      AppMethodBeat.i(49003);
      mHR.mIb = aj.getProcessName();
      AppBrandMainProcessService.a(mHR);
      if (paramf != null) {
        synchronized (mHS)
        {
          mHS.add(paramf);
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