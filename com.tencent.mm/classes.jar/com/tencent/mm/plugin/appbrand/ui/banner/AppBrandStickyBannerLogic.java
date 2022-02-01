package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Deprecated
public enum AppBrandStickyBannerLogic
{
  static final class OperateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateTask> CREATOR;
    int op = 0;
    boolean uhI;
    String uhJ;
    int uhK;
    String uhL;
    
    static
    {
      AppMethodBeat.i(49023);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(49023);
    }
    
    static OperateTask dm(String paramString, int paramInt)
    {
      AppMethodBeat.i(322706);
      OperateTask localOperateTask = new OperateTask();
      localOperateTask.op = 1;
      localOperateTask.uhJ = paramString;
      localOperateTask.uhK = paramInt;
      AppMethodBeat.o(322706);
      return localOperateTask;
    }
    
    static OperateTask dn(String paramString, int paramInt)
    {
      AppMethodBeat.i(322710);
      OperateTask localOperateTask = new OperateTask();
      localOperateTask.op = 3;
      localOperateTask.uhJ = paramString;
      localOperateTask.uhK = paramInt;
      AppMethodBeat.o(322710);
      return localOperateTask;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(49019);
      switch (this.op)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(49019);
        return;
        this.uhI = AppBrandStickyBannerLogic.b.dk(this.uhJ, this.uhK);
        cpA();
        AppMethodBeat.o(49019);
        return;
        AppBrandStickyBannerLogic.b.dl(this.uhJ, this.uhK);
        AppMethodBeat.o(49019);
        return;
        AppBrandStickyBannerLogic.b.b(this);
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(49022);
      this.op = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.uhI = bool;
        this.uhJ = paramParcel.readString();
        this.uhK = paramParcel.readInt();
        this.uhL = paramParcel.readString();
        AppMethodBeat.o(49022);
        return;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(49021);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.op);
      if (this.uhI) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.uhJ);
        paramParcel.writeInt(this.uhK);
        paramParcel.writeString(this.uhL);
        AppMethodBeat.o(49021);
        return;
      }
    }
  }
  
  static final class Watcher
    extends MainProcessTask
  {
    public static final Parcelable.Creator<Watcher> CREATOR;
    private static final transient Map<String, f> uhP;
    String uhM;
    String uhN;
    int uhO;
    
    static
    {
      AppMethodBeat.i(49031);
      uhP = new HashMap();
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(49031);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(49026);
      if (Util.isNullOrNil(this.uhM))
      {
        AppMethodBeat.o(49026);
        return;
      }
      synchronized (uhP)
      {
        if (uhP.containsKey(this.uhM)) {
          AppBrandStickyBannerLogic.b.c((f)uhP.get(this.uhM));
        }
        f local1 = new f()
        {
          public final void cB(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(49024);
            AppBrandStickyBannerLogic.Watcher.this.uhN = paramAnonymousString;
            AppBrandStickyBannerLogic.Watcher.this.uhO = paramAnonymousInt;
            AppBrandStickyBannerLogic.Watcher.a(AppBrandStickyBannerLogic.Watcher.this);
            AppMethodBeat.o(49024);
          }
        };
        AppBrandStickyBannerLogic.b.d(local1);
        uhP.put(this.uhM, local1);
        AppMethodBeat.o(49026);
        return;
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(49027);
      AppBrandStickyBannerLogic.a.dj(this.uhN, this.uhO);
      AppMethodBeat.o(49027);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(49029);
      this.uhM = paramParcel.readString();
      this.uhN = paramParcel.readString();
      this.uhO = paramParcel.readInt();
      AppMethodBeat.o(49029);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(49028);
      paramParcel.writeString(this.uhM);
      paramParcel.writeString(this.uhN);
      paramParcel.writeInt(this.uhO);
      AppMethodBeat.o(49028);
    }
  }
  
  public static final class a
  {
    private static final AppBrandStickyBannerLogic.Watcher uhC;
    private static final Set<f> uhD;
    private static final HashMap<String, Boolean> uhE;
    private static final HashMap<String, f> uhF;
    private static final c uhG;
    private static final Map<String, String> uhH;
    
    static
    {
      AppMethodBeat.i(49006);
      uhC = new AppBrandStickyBannerLogic.Watcher();
      uhD = new HashSet();
      uhE = new HashMap();
      uhF = new HashMap();
      uhG = new c();
      uhH = new HashMap();
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
        synchronized (uhH)
        {
          String str = (String)uhH.get(paramString1);
          b.a(localIntent, paramString1, paramInt, paramString2, paramString3, Util.nullAsNil(str));
          paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString1.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {}
        }
        AppMethodBeat.o(49000);
        return;
      }
    }
    
    public static void agm(String paramString)
    {
      AppMethodBeat.i(322720);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(322720);
        return;
      }
      AppBrandSysConfigWC localAppBrandSysConfigWC = d.Ud(paramString);
      if (localAppBrandSysConfigWC == null)
      {
        AppMethodBeat.o(322720);
        return;
      }
      int i = localAppBrandSysConfigWC.qYY.qHO;
      if (i < 0)
      {
        AppMethodBeat.o(322720);
        return;
      }
      u.cpR();
      AppBrandStickyBannerLogic.OperateTask.dn(paramString, i).bQt();
      AppMethodBeat.o(322720);
    }
    
    public static void c(f paramf)
    {
      AppMethodBeat.i(49002);
      if (paramf != null) {
        synchronized (uhD)
        {
          uhD.remove(paramf);
          AppMethodBeat.o(49002);
          return;
        }
      }
      AppMethodBeat.o(49002);
    }
    
    public static void d(f paramf)
    {
      AppMethodBeat.i(49003);
      uhC.uhM = MMApplicationContext.getProcessName();
      uhC.bQt();
      if (paramf != null) {
        synchronized (uhD)
        {
          uhD.add(paramf);
          AppMethodBeat.o(49003);
          return;
        }
      }
      AppMethodBeat.o(49003);
    }
    
    static void dj(String paramString, int paramInt)
    {
      AppMethodBeat.i(48999);
      synchronized (uhD)
      {
        Iterator localIterator = uhD.iterator();
        if (localIterator.hasNext()) {
          ((f)localIterator.next()).cB(paramString, paramInt);
        }
      }
      AppMethodBeat.o(48999);
    }
    
    public static boolean dk(String paramString, int paramInt)
    {
      AppMethodBeat.i(322709);
      if (AppBrandStickyBannerLogic.ayB())
      {
        AppMethodBeat.o(322709);
        return false;
      }
      if ((Util.isNullOrNil(paramString)) || (paramInt < 0))
      {
        AppMethodBeat.o(322709);
        return false;
      }
      AppBrandStickyBannerLogic.OperateTask localOperateTask = AppBrandStickyBannerLogic.OperateTask.dm(paramString, paramInt);
      boolean bool = localOperateTask.cpB();
      if (!bool)
      {
        Log.w("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "execSync process task failed(%s, %s) use local state(%s).", new Object[] { paramString, Integer.valueOf(paramInt), uhE.get(paramString) });
        if ((uhE.containsKey(paramString)) && (((Boolean)uhE.get(paramString)).booleanValue()))
        {
          AppMethodBeat.o(322709);
          return true;
        }
        AppMethodBeat.o(322709);
        return false;
      }
      if ((bool) && (localOperateTask.uhI))
      {
        AppMethodBeat.o(322709);
        return true;
      }
      AppMethodBeat.o(322709);
      return false;
    }
  }
  
  public static final class b
  {
    static final Set<f> listeners;
    
    static
    {
      AppMethodBeat.i(49017);
      listeners = new HashSet();
      AppMethodBeat.o(49017);
    }
    
    public static void S(Intent paramIntent)
    {
      AppMethodBeat.i(49008);
      if ((paramIntent == null) || (!h.baz()))
      {
        AppMethodBeat.o(49008);
        return;
      }
      h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49007);
          if (b.R(AppBrandStickyBannerLogic.b.this)) {
            AppBrandStickyBannerLogic.b.access$100();
          }
          AppMethodBeat.o(49007);
        }
      });
      AppMethodBeat.o(49008);
    }
    
    static void b(AppBrandStickyBannerLogic.OperateTask paramOperateTask)
    {
      AppMethodBeat.i(49009);
      if (b.a(paramOperateTask)) {
        cMc();
      }
      AppMethodBeat.o(49009);
    }
    
    public static void c(f paramf)
    {
      AppMethodBeat.i(49013);
      if (paramf != null) {
        synchronized (listeners)
        {
          listeners.remove(paramf);
          AppMethodBeat.o(49013);
          return;
        }
      }
      AppMethodBeat.o(49013);
    }
    
    static void cLW()
    {
      AppMethodBeat.i(49010);
      if (AppBrandStickyBannerLogic.ayB())
      {
        AppMethodBeat.o(49010);
        return;
      }
      BannerModel localBannerModel = BannerModel.cMd();
      String str;
      if (localBannerModel == null)
      {
        str = null;
        if (localBannerModel != null) {
          break label69;
        }
      }
      label69:
      for (int i = -1;; i = localBannerModel.euz)
      {
        Log.i("MicroMsg.AppBrandStickyBannerLogic", "checkAfterProcessRestart stored banner %s, %d", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(49010);
        return;
        str = localBannerModel.appId;
        break;
      }
    }
    
    private static void cMc()
    {
      AppMethodBeat.i(49011);
      ??? = BannerModel.cMd();
      String str1;
      if (??? == null)
      {
        str1 = null;
        if (??? != null) {
          break label82;
        }
      }
      label82:
      for (int i = -1;; i = ((BannerModel)???).euz)
      {
        synchronized (listeners)
        {
          Iterator localIterator = listeners.iterator();
          if (!localIterator.hasNext()) {
            break label90;
          }
          ((f)localIterator.next()).cB(str1, i);
        }
        String str2 = ((BannerModel)???).appId;
        break;
      }
      label90:
      AppMethodBeat.o(49011);
    }
    
    public static void d(f paramf)
    {
      AppMethodBeat.i(49012);
      if (paramf != null) {
        synchronized (listeners)
        {
          listeners.add(paramf);
          AppMethodBeat.o(49012);
          return;
        }
      }
      AppMethodBeat.o(49012);
    }
    
    public static boolean dk(String paramString, int paramInt)
    {
      AppMethodBeat.i(322718);
      if (AppBrandStickyBannerLogic.ayB())
      {
        AppMethodBeat.o(322718);
        return false;
      }
      BannerModel localBannerModel = BannerModel.cMe();
      if ((localBannerModel != null) && (!Util.isNullOrNil(paramString)) && (paramString.equals(localBannerModel.appId)) && (paramInt == localBannerModel.euz))
      {
        AppMethodBeat.o(322718);
        return true;
      }
      AppMethodBeat.o(322718);
      return false;
    }
    
    public static void dl(String paramString, int paramInt)
    {
      AppMethodBeat.i(322721);
      if (dk(paramString, paramInt))
      {
        b.cLX();
        cMc();
      }
      AppMethodBeat.o(322721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic
 * JD-Core Version:    0.7.0.1
 */