package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.n;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.k.m;
import com.tencent.mm.plugin.webview.modeltools.g.c;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.pluginsdk.ui.tools.ab.a;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class WebViewLongClickHelper
{
  private static Map<String, Boolean> BrL;
  private static long BrM;
  private static IListener BrS;
  private static long mSessionId;
  private ArrayList<ImageQBarDataBean> BrI;
  private String BrJ;
  private m BrK;
  private HashMap<String, Long> BrN;
  public Long BrO;
  public Long BrP;
  private Long BrQ;
  private WeakReference<l> BrR;
  private com.tencent.mm.ui.widget.a.e oxl;
  private ScanCodeSheetItemLogic oxq;
  com.tencent.mm.plugin.webview.modeltools.g pGJ;
  private WebView.b pGK;
  private WebView.b pGL;
  private g.c pGQ;
  private String pHO;
  
  static
  {
    AppMethodBeat.i(292228);
    BrL = new HashMap();
    mSessionId = 0L;
    BrM = 0L;
    AppMethodBeat.o(292228);
  }
  
  public WebViewLongClickHelper(l paraml)
  {
    AppMethodBeat.i(292197);
    this.BrI = new ArrayList();
    this.pHO = "";
    this.BrN = new HashMap();
    this.BrO = Long.valueOf(0L);
    this.BrP = Long.valueOf(0L);
    this.BrQ = Long.valueOf(0L);
    this.pGQ = new g.c()
    {
      public final void ajA(String paramAnonymousString)
      {
        AppMethodBeat.i(286448);
        if (WebViewLongClickHelper.a(WebViewLongClickHelper.this))
        {
          AppMethodBeat.o(286448);
          return;
        }
        Log.i("MicroMsg.WebViewLongClickHelper", "onCaptureFinish:".concat(String.valueOf(paramAnonymousString)));
        WebViewLongClickHelper.NC(System.currentTimeMillis());
        WebViewLongClickHelper.b(WebViewLongClickHelper.this).put(paramAnonymousString, Long.valueOf(WebViewLongClickHelper.BrM));
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new WebViewLongClickHelper.ScanImageData(paramAnonymousString, WebViewLongClickHelper.BrM, WebViewLongClickHelper.c(WebViewLongClickHelper.this).elV().floatValue(), WebViewLongClickHelper.c(WebViewLongClickHelper.this).elW().floatValue(), WebViewLongClickHelper.c(WebViewLongClickHelper.this).getWebView().getMeasuredWidth(), WebViewLongClickHelper.c(WebViewLongClickHelper.this).getWebView().getMeasuredHeight()), WebViewLongClickHelper.c.class, new WebViewLongClickHelper.b(new WeakReference(WebViewLongClickHelper.this), paramAnonymousString));
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(286448);
      }
    };
    this.BrR = new WeakReference(paraml);
    emd();
    this.oxq = new ScanCodeSheetItemLogic(emc().getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
      {
        AppMethodBeat.i(269669);
        if ((WebViewLongClickHelper.h(WebViewLongClickHelper.this) != null) && (WebViewLongClickHelper.h(WebViewLongClickHelper.this).isShowing())) {
          WebViewLongClickHelper.f(WebViewLongClickHelper.this);
        }
        AppMethodBeat.o(269669);
      }
    });
    AppMethodBeat.o(292197);
  }
  
  private void a(int paramInt, ImageQBarDataBean paramImageQBarDataBean)
  {
    AppMethodBeat.i(292203);
    if (this.BrK == null)
    {
      AppMethodBeat.o(292203);
      return;
    }
    this.BrK.url = this.pHO;
    this.BrK.gco = 40;
    if (paramImageQBarDataBean != null)
    {
      this.BrK.QAl = true;
      this.BrK.apf(paramImageQBarDataBean.fys);
      this.BrK.scanResult = paramImageQBarDataBean.IAH;
    }
    if (URLUtil.isDataUrl(this.BrJ)) {}
    for (;;)
    {
      try
      {
        paramImageQBarDataBean = n.fS(this.BrJ);
        this.BrK.EKt = paramImageQBarDataBean;
        this.BrK.rE(paramInt);
        AppMethodBeat.o(292203);
        return;
      }
      catch (Exception paramImageQBarDataBean)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "getSHA1 ex %s", new Object[] { paramImageQBarDataBean.getMessage() });
        paramImageQBarDataBean = "";
        continue;
      }
      paramImageQBarDataBean = ab.aXb(this.BrJ);
    }
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(292200);
    boolean bool = aGF(paramb.mExtra);
    if ((Util.isNullOrNil(this.BrI)) && (emc().elU().gWJ().hoT()) && (emg()))
    {
      this.pGL = paramb;
      this.pGJ = new com.tencent.mm.plugin.webview.modeltools.g();
      this.pGJ.a(emc().getWebView(), this.pGQ);
    }
    AppMethodBeat.o(292200);
    return bool;
  }
  
  private boolean aGF(final String paramString)
  {
    AppMethodBeat.i(292202);
    if (elX())
    {
      AppMethodBeat.o(292202);
      return false;
    }
    if (!eme())
    {
      AppMethodBeat.o(292202);
      return true;
    }
    this.BrJ = paramString;
    if (this.oxl == null) {
      this.oxl = new com.tencent.mm.ui.widget.a.e(emc().getContext(), 1, false);
    }
    this.oxl.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(292073);
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramAnonymouso);
        AppMethodBeat.o(292073);
      }
    };
    this.oxl.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(267028);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(267028);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 1, null);
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(267028);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 2, null);
          WebViewLongClickHelper.b(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(267028);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 3, null);
          WebViewLongClickHelper.c(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(267028);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 7, null);
          WebViewLongClickHelper.d(WebViewLongClickHelper.this, paramString);
        }
      }
    };
    this.oxl.XbB = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(277945);
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, 5, null);
        if ((WebViewLongClickHelper.this.pGJ != null) && (WebViewLongClickHelper.c(WebViewLongClickHelper.this).elT() != null)) {
          try
          {
            WebViewLongClickHelper.e(WebViewLongClickHelper.this).clear();
            WebViewLongClickHelper.m(WebViewLongClickHelper.this).onDismiss();
            WebViewLongClickHelper.e(WebViewLongClickHelper.this, WebViewLongClickHelper.this.pGJ.PXC);
            WebViewLongClickHelper.this.pGJ.gWy();
            AppMethodBeat.o(277945);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.WebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(277945);
      }
    };
    if (!emc().elX()) {
      this.oxl.eik();
    }
    boolean bool = this.oxl.isShowing();
    AppMethodBeat.o(292202);
    return bool;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(292201);
    boolean bool = aGF(paramb.mExtra);
    if ((Util.isNullOrNil(this.BrI)) && (emc().elU().gWJ().hoT()) && (emg()))
    {
      this.pGK = paramb;
      this.pGJ = new com.tencent.mm.plugin.webview.modeltools.g();
      this.pGJ.a(emc().getWebView(), this.pGQ);
    }
    AppMethodBeat.o(292201);
    return bool;
  }
  
  public static void d(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(292207);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzy, 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(292207);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
    i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzz, 500);
    if ((i < 150) || (i > 2500))
    {
      Log.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(292207);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", new Object[] { Integer.valueOf(i) });
    paramMMWebView.getSettings().enableCustomizedLongPressTimeout(i);
    AppMethodBeat.o(292207);
  }
  
  private boolean eX(View paramView)
  {
    AppMethodBeat.i(292199);
    if (elX())
    {
      AppMethodBeat.o(292199);
      return false;
    }
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = emc().getWebView().getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(292199);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          b(paramView);
        }
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", new Object[] { paramView.getMessage() });
        continue;
      }
      AppMethodBeat.o(292199);
      return false;
      if ((paramView instanceof MMWebView))
      {
        paramView = ((MMWebView)paramView).getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(292199);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          a(paramView);
        }
      }
    }
  }
  
  private boolean elX()
  {
    AppMethodBeat.i(292196);
    if ((emc() == null) || (emc().elX()))
    {
      AppMethodBeat.o(292196);
      return true;
    }
    AppMethodBeat.o(292196);
    return false;
  }
  
  private l emc()
  {
    AppMethodBeat.i(292193);
    l locall = (l)this.BrR.get();
    AppMethodBeat.o(292193);
    return locall;
  }
  
  private boolean eme()
  {
    AppMethodBeat.i(292204);
    boolean bool1 = false;
    try
    {
      boolean bool2 = emc().elT().isSDCardAvailable();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + localException.getMessage());
      }
    }
    AppMethodBeat.o(292204);
    return bool1;
  }
  
  private boolean emf()
  {
    boolean bool1 = false;
    AppMethodBeat.i(292205);
    try
    {
      boolean bool2 = emc().elT().gWY();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(292205);
    return bool1;
  }
  
  private boolean emg()
  {
    boolean bool1 = false;
    AppMethodBeat.i(292206);
    try
    {
      if (emc().elT() == null)
      {
        Log.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(292206);
        return false;
      }
      boolean bool2 = emc().elT().gXj();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(292206);
    return bool1;
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(292195);
    Context localContext = emc().getContext();
    AppMethodBeat.o(292195);
    return localContext;
  }
  
  public final void emd()
  {
    AppMethodBeat.i(292198);
    if (emc().getWebView() == null)
    {
      AppMethodBeat.o(292198);
      return;
    }
    emc().getWebView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(269104);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/webview/WebViewLongClickHelper$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, new m());
        WebViewLongClickHelper.k(WebViewLongClickHelper.this).fs(1);
        Log.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
        WebViewLongClickHelper.l(WebViewLongClickHelper.this);
        if (WebViewLongClickHelper.c(WebViewLongClickHelper.this).getWebView() == null)
        {
          a.a(false, this, "com/tencent/mm/plugin/finder/webview/WebViewLongClickHelper$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(269104);
          return false;
        }
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramAnonymousView);
        a.a(false, this, "com/tencent/mm/plugin/finder/webview/WebViewLongClickHelper$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(269104);
        return false;
      }
    });
    AppMethodBeat.o(292198);
  }
  
  static class CancelRecogQBarData
    implements Parcelable
  {
    public static final Parcelable.Creator<CancelRecogQBarData> CREATOR;
    String filePath;
    long fwK;
    
    static
    {
      AppMethodBeat.i(282730);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(282730);
    }
    
    protected CancelRecogQBarData(Parcel paramParcel)
    {
      AppMethodBeat.i(282728);
      this.filePath = paramParcel.readString();
      this.fwK = paramParcel.readLong();
      AppMethodBeat.o(282728);
    }
    
    public CancelRecogQBarData(String paramString, long paramLong)
    {
      this.filePath = paramString;
      this.fwK = paramLong;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(282729);
      paramParcel.writeString(this.filePath);
      paramParcel.writeLong(this.fwK);
      AppMethodBeat.o(282729);
    }
  }
  
  static class ImageQBarData
    implements Parcelable
  {
    public static final Parcelable.Creator<ImageQBarData> CREATOR;
    String BrW;
    boolean BrX;
    ArrayList<ImageQBarDataBean> mDataList;
    
    static
    {
      AppMethodBeat.i(279485);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(279485);
    }
    
    protected ImageQBarData(Parcel paramParcel)
    {
      AppMethodBeat.i(279481);
      this.mDataList = paramParcel.createTypedArrayList(ImageQBarDataBean.CREATOR);
      this.BrW = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.BrX = bool;
        AppMethodBeat.o(279481);
        return;
      }
    }
    
    public ImageQBarData(ArrayList<ImageQBarDataBean> paramArrayList, String paramString, Boolean paramBoolean)
    {
      AppMethodBeat.i(279480);
      this.mDataList = paramArrayList;
      this.BrW = paramString;
      this.BrX = paramBoolean.booleanValue();
      AppMethodBeat.o(279480);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(279483);
      paramParcel.writeTypedList(this.mDataList);
      paramParcel.writeString(this.BrW);
      if (this.BrX) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(279483);
        return;
      }
    }
  }
  
  static class ScanImageData
    implements Parcelable
  {
    public static final Parcelable.Creator<ScanImageData> CREATOR;
    String filePath;
    long fwK;
    int height;
    float qUk;
    float qUl;
    int width;
    
    static
    {
      AppMethodBeat.i(288673);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(288673);
    }
    
    protected ScanImageData(Parcel paramParcel)
    {
      AppMethodBeat.i(288671);
      this.filePath = paramParcel.readString();
      this.fwK = paramParcel.readLong();
      this.qUk = paramParcel.readFloat();
      this.qUl = paramParcel.readFloat();
      this.width = paramParcel.readInt();
      this.height = paramParcel.readInt();
      AppMethodBeat.o(288671);
    }
    
    public ScanImageData(String paramString, long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      this.filePath = paramString;
      this.fwK = paramLong;
      this.qUk = paramFloat1;
      this.qUl = paramFloat2;
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(288672);
      paramParcel.writeString(this.filePath);
      paramParcel.writeLong(this.fwK);
      paramParcel.writeFloat(this.qUk);
      paramParcel.writeFloat(this.qUl);
      paramParcel.writeInt(this.width);
      paramParcel.writeInt(this.height);
      AppMethodBeat.o(288672);
    }
  }
  
  static final class a
  {
    final int id;
    final String title;
    
    public a(int paramInt, String paramString)
    {
      this.id = paramInt;
      this.title = paramString;
    }
  }
  
  static final class b
    implements f<WebViewLongClickHelper.ImageQBarData>
  {
    private WeakReference<WebViewLongClickHelper> BrY;
    private String mPath;
    
    public b(WeakReference<WebViewLongClickHelper> paramWeakReference, String paramString)
    {
      this.BrY = paramWeakReference;
      this.mPath = paramString;
    }
  }
  
  public static class c
    implements d<WebViewLongClickHelper.ScanImageData, WebViewLongClickHelper.ImageQBarData>
  {}
  
  public static class d
    implements d<WebViewLongClickHelper.CancelRecogQBarData, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.WebViewLongClickHelper
 * JD-Core Version:    0.7.0.1
 */