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
import com.tencent.mm.autogen.a.tn;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.b.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.k.h.c;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.aa.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class WebViewLongClickHelper
{
  private static Map<String, Boolean> GYh;
  private static long GYi;
  private static IListener GYo;
  private static long mSessionId;
  private ArrayList<ImageQBarDataBean> GYe;
  private String GYf;
  private com.tencent.mm.plugin.webview.k.q GYg;
  private HashMap<String, Long> GYj;
  public Long GYk;
  public Long GYl;
  private Long GYm;
  private WeakReference<m> GYn;
  private com.tencent.mm.ui.widget.a.f rAK;
  private ScanCodeSheetItemLogic rAP;
  com.tencent.mm.plugin.webview.k.h sLJ;
  private WebView.b sLK;
  private WebView.b sLL;
  private h.c sLQ;
  private String sML;
  
  static
  {
    AppMethodBeat.i(334795);
    GYh = new HashMap();
    mSessionId = 0L;
    GYi = 0L;
    AppMethodBeat.o(334795);
  }
  
  public WebViewLongClickHelper(m paramm)
  {
    AppMethodBeat.i(334473);
    this.GYe = new ArrayList();
    this.sML = "";
    this.GYj = new HashMap();
    this.GYk = Long.valueOf(0L);
    this.GYl = Long.valueOf(0L);
    this.GYm = Long.valueOf(0L);
    this.sLQ = new h.c()
    {
      public final void acB(String paramAnonymousString)
      {
        AppMethodBeat.i(334436);
        if (WebViewLongClickHelper.a(WebViewLongClickHelper.this))
        {
          AppMethodBeat.o(334436);
          return;
        }
        Log.i("MicroMsg.WebViewLongClickHelper", "onCaptureFinish:".concat(String.valueOf(paramAnonymousString)));
        WebViewLongClickHelper.rj(System.currentTimeMillis());
        WebViewLongClickHelper.b(WebViewLongClickHelper.this).put(paramAnonymousString, Long.valueOf(WebViewLongClickHelper.GYi));
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new WebViewLongClickHelper.ScanImageData(paramAnonymousString, WebViewLongClickHelper.GYi, WebViewLongClickHelper.c(WebViewLongClickHelper.this).fpY().floatValue(), WebViewLongClickHelper.c(WebViewLongClickHelper.this).fpZ().floatValue(), WebViewLongClickHelper.c(WebViewLongClickHelper.this).getWebView().getMeasuredWidth(), WebViewLongClickHelper.c(WebViewLongClickHelper.this).getWebView().getMeasuredHeight()), WebViewLongClickHelper.c.class, new WebViewLongClickHelper.b(new WeakReference(WebViewLongClickHelper.this), paramAnonymousString));
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(334436);
      }
    };
    this.GYn = new WeakReference(paramm);
    fqh();
    this.rAP = new ScanCodeSheetItemLogic(fqg().getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
      {
        AppMethodBeat.i(334409);
        if ((WebViewLongClickHelper.h(WebViewLongClickHelper.this) != null) && (WebViewLongClickHelper.h(WebViewLongClickHelper.this).isShowing())) {
          WebViewLongClickHelper.f(WebViewLongClickHelper.this);
        }
        AppMethodBeat.o(334409);
      }
    });
    AppMethodBeat.o(334473);
  }
  
  private void a(int paramInt, ImageQBarDataBean paramImageQBarDataBean)
  {
    AppMethodBeat.i(334516);
    if (this.GYg == null)
    {
      AppMethodBeat.o(334516);
      return;
    }
    this.GYg.url = this.sML;
    this.GYg.iiA = 40;
    if (paramImageQBarDataBean != null)
    {
      this.GYg.Xtt = true;
      this.GYg.avd(paramImageQBarDataBean.hDb);
      this.GYg.scanResult = paramImageQBarDataBean.OGQ;
    }
    if (URLUtil.isDataUrl(this.GYf)) {}
    for (;;)
    {
      try
      {
        paramImageQBarDataBean = n.hv(this.GYf);
        this.GYg.KEa = paramImageQBarDataBean;
        this.GYg.rG(paramInt);
        AppMethodBeat.o(334516);
        return;
      }
      catch (Exception paramImageQBarDataBean)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "getSHA1 ex %s", new Object[] { paramImageQBarDataBean.getMessage() });
        paramImageQBarDataBean = "";
        continue;
      }
      paramImageQBarDataBean = aa.aUC(this.GYf);
    }
  }
  
  private boolean a(WebView.b paramb)
  {
    AppMethodBeat.i(334493);
    boolean bool = aCU(paramb.mExtra);
    if ((Util.isNullOrNil(this.GYe)) && (fqg().fpX().iwp().iPP()) && (fqk()))
    {
      this.sLL = paramb;
      this.sLJ = new com.tencent.mm.plugin.webview.k.h();
      this.sLJ.a(fqg().getWebView(), this.sLQ);
    }
    AppMethodBeat.o(334493);
    return bool;
  }
  
  private boolean aCU(final String paramString)
  {
    AppMethodBeat.i(334510);
    if (bpe())
    {
      AppMethodBeat.o(334510);
      return false;
    }
    if (!fqi())
    {
      AppMethodBeat.o(334510);
      return true;
    }
    this.GYf = paramString;
    if (this.rAK == null) {
      this.rAK = new com.tencent.mm.ui.widget.a.f(fqg().getContext(), 1, false);
    }
    this.rAK.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(334390);
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramAnonymouss);
        AppMethodBeat.o(334390);
      }
    };
    this.rAK.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(334382);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(334382);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 1, null);
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(334382);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 2, null);
          WebViewLongClickHelper.b(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(334382);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 3, null);
          WebViewLongClickHelper.c(WebViewLongClickHelper.this, paramString);
          AppMethodBeat.o(334382);
          return;
          WebViewLongClickHelper.a(WebViewLongClickHelper.this, 7, null);
          WebViewLongClickHelper.d(WebViewLongClickHelper.this, paramString);
        }
      }
    };
    this.rAK.aeLi = new f.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(334378);
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, 5, null);
        if ((WebViewLongClickHelper.this.sLJ != null) && (WebViewLongClickHelper.c(WebViewLongClickHelper.this).fpW() != null)) {
          try
          {
            WebViewLongClickHelper.e(WebViewLongClickHelper.this).clear();
            WebViewLongClickHelper.m(WebViewLongClickHelper.this).onDismiss();
            WebViewLongClickHelper.e(WebViewLongClickHelper.this, WebViewLongClickHelper.this.sLJ.XsV);
            WebViewLongClickHelper.this.sLJ.iCR();
            AppMethodBeat.o(334378);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.WebViewLongClickHelper", "cancel capture failed");
          }
        }
        AppMethodBeat.o(334378);
      }
    };
    if (!fqg().bpe()) {
      this.rAK.dDn();
    }
    boolean bool = this.rAK.isShowing();
    AppMethodBeat.o(334510);
    return bool;
  }
  
  private boolean b(WebView.b paramb)
  {
    AppMethodBeat.i(334500);
    boolean bool = aCU(paramb.mExtra);
    if ((Util.isNullOrNil(this.GYe)) && (fqg().fpX().iwp().iPP()) && (fqk()))
    {
      this.sLK = paramb;
      this.sLJ = new com.tencent.mm.plugin.webview.k.h();
      this.sLJ.a(fqg().getWebView(), this.sLQ);
    }
    AppMethodBeat.o(334500);
    return bool;
  }
  
  private boolean bpe()
  {
    AppMethodBeat.i(334466);
    if ((fqg() == null) || (fqg().bpe()))
    {
      AppMethodBeat.o(334466);
      return true;
    }
    AppMethodBeat.o(334466);
    return false;
  }
  
  public static void d(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(334548);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yNd, 0) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(334548);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
    i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yNe, 500);
    if ((i < 150) || (i > 2500))
    {
      Log.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(334548);
      return;
    }
    Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", new Object[] { Integer.valueOf(i) });
    paramMMWebView.getSettings().enableCustomizedLongPressTimeout(i);
    AppMethodBeat.o(334548);
  }
  
  private m fqg()
  {
    AppMethodBeat.i(334447);
    m localm = (m)this.GYn.get();
    AppMethodBeat.o(334447);
    return localm;
  }
  
  private boolean fqi()
  {
    AppMethodBeat.i(334524);
    boolean bool1 = false;
    try
    {
      boolean bool2 = fqg().fpW().isSDCardAvailable();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + localException.getMessage());
      }
    }
    AppMethodBeat.o(334524);
    return bool1;
  }
  
  private boolean fqj()
  {
    boolean bool1 = false;
    AppMethodBeat.i(334530);
    try
    {
      boolean bool2 = fqg().fpW().iwU();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(334530);
    return bool1;
  }
  
  private boolean fqk()
  {
    boolean bool1 = false;
    AppMethodBeat.i(334541);
    try
    {
      if (fqg().fpW() == null)
      {
        Log.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
        AppMethodBeat.o(334541);
        return false;
      }
      boolean bool2 = fqg().fpW().ixf();
      bool1 = bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + localRemoteException.getMessage());
      }
    }
    AppMethodBeat.o(334541);
    return bool1;
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(334458);
    Context localContext = fqg().getContext();
    AppMethodBeat.o(334458);
    return localContext;
  }
  
  private boolean ho(View paramView)
  {
    AppMethodBeat.i(334485);
    if (bpe())
    {
      AppMethodBeat.o(334485);
      return false;
    }
    for (;;)
    {
      try
      {
        if (!(paramView instanceof WebView)) {
          continue;
        }
        paramView = fqg().getWebView().getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(334485);
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
      AppMethodBeat.o(334485);
      return false;
      if ((paramView instanceof MMWebView))
      {
        paramView = ((MMWebView)paramView).getHitTestResult();
        if (paramView == null)
        {
          AppMethodBeat.o(334485);
          return false;
        }
        if ((paramView.mType == 5) || (paramView.mType == 8)) {
          a(paramView);
        }
      }
    }
  }
  
  public final void fqh()
  {
    AppMethodBeat.i(334799);
    if (fqg().getWebView() == null)
    {
      AppMethodBeat.o(334799);
      return;
    }
    fqg().getWebView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(334370);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/webview/WebViewLongClickHelper$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, new com.tencent.mm.plugin.webview.k.q());
        WebViewLongClickHelper.k(WebViewLongClickHelper.this).iF(1);
        Log.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
        WebViewLongClickHelper.l(WebViewLongClickHelper.this);
        if (WebViewLongClickHelper.c(WebViewLongClickHelper.this).getWebView() == null)
        {
          a.a(false, this, "com/tencent/mm/plugin/finder/webview/WebViewLongClickHelper$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(334370);
          return false;
        }
        WebViewLongClickHelper.a(WebViewLongClickHelper.this, paramAnonymousView);
        a.a(false, this, "com/tencent/mm/plugin/finder/webview/WebViewLongClickHelper$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(334370);
        return false;
      }
    });
    AppMethodBeat.o(334799);
  }
  
  static class CancelRecogQBarData
    implements Parcelable
  {
    public static final Parcelable.Creator<CancelRecogQBarData> CREATOR;
    String filePath;
    long hBk;
    
    static
    {
      AppMethodBeat.i(334570);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(334570);
    }
    
    protected CancelRecogQBarData(Parcel paramParcel)
    {
      AppMethodBeat.i(334564);
      this.filePath = paramParcel.readString();
      this.hBk = paramParcel.readLong();
      AppMethodBeat.o(334564);
    }
    
    public CancelRecogQBarData(String paramString, long paramLong)
    {
      this.filePath = paramString;
      this.hBk = paramLong;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(334580);
      paramParcel.writeString(this.filePath);
      paramParcel.writeLong(this.hBk);
      AppMethodBeat.o(334580);
    }
  }
  
  static class ImageQBarData
    implements Parcelable
  {
    public static final Parcelable.Creator<ImageQBarData> CREATOR;
    String GYs;
    boolean GYt;
    ArrayList<ImageQBarDataBean> mDataList;
    
    static
    {
      AppMethodBeat.i(334424);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(334424);
    }
    
    protected ImageQBarData(Parcel paramParcel)
    {
      AppMethodBeat.i(334413);
      this.mDataList = paramParcel.createTypedArrayList(ImageQBarDataBean.CREATOR);
      this.GYs = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.GYt = bool;
        AppMethodBeat.o(334413);
        return;
      }
    }
    
    public ImageQBarData(ArrayList<ImageQBarDataBean> paramArrayList, String paramString, Boolean paramBoolean)
    {
      AppMethodBeat.i(334395);
      this.mDataList = paramArrayList;
      this.GYs = paramString;
      this.GYt = paramBoolean.booleanValue();
      AppMethodBeat.o(334395);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(334433);
      paramParcel.writeTypedList(this.mDataList);
      paramParcel.writeString(this.GYs);
      if (this.GYt) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(334433);
        return;
      }
    }
  }
  
  static class ScanImageData
    implements Parcelable
  {
    public static final Parcelable.Creator<ScanImageData> CREATOR;
    String filePath;
    long hBk;
    int height;
    float tZl;
    float tZm;
    int width;
    
    static
    {
      AppMethodBeat.i(334393);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(334393);
    }
    
    protected ScanImageData(Parcel paramParcel)
    {
      AppMethodBeat.i(334387);
      this.filePath = paramParcel.readString();
      this.hBk = paramParcel.readLong();
      this.tZl = paramParcel.readFloat();
      this.tZm = paramParcel.readFloat();
      this.width = paramParcel.readInt();
      this.height = paramParcel.readInt();
      AppMethodBeat.o(334387);
    }
    
    public ScanImageData(String paramString, long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      this.filePath = paramString;
      this.hBk = paramLong;
      this.tZl = paramFloat1;
      this.tZm = paramFloat2;
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(334403);
      paramParcel.writeString(this.filePath);
      paramParcel.writeLong(this.hBk);
      paramParcel.writeFloat(this.tZl);
      paramParcel.writeFloat(this.tZm);
      paramParcel.writeInt(this.width);
      paramParcel.writeInt(this.height);
      AppMethodBeat.o(334403);
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
    implements com.tencent.mm.ipcinvoker.f<WebViewLongClickHelper.ImageQBarData>
  {
    private WeakReference<WebViewLongClickHelper> GYu;
    private String mPath;
    
    public b(WeakReference<WebViewLongClickHelper> paramWeakReference, String paramString)
    {
      this.GYu = paramWeakReference;
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