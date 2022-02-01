package com.tencent.mm.framework.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl;
import com.tencent.kinda.framework.widget.base.BaseFrActivity;
import com.tencent.kinda.framework.widget.base.BaseFrActivity.IWalletTenpayKBStateCallBackListener;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.FrLifeController;
import com.tencent.kinda.framework.widget.base.IEventFragment;
import com.tencent.kinda.framework.widget.base.KindaActionBarColorManager;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.li;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.OnPasswdInputListener;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEditText.EditState;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(1)
public class UIPageFragmentActivity
  extends BaseFrActivity
  implements IEventFragment, com.tencent.mm.ui.tools.g
{
  private static HashMap<Integer, a> hgC;
  private boolean crv;
  private com.tencent.mm.ui.tools.h gyh;
  private boolean hgA;
  public AtomicInteger hgB;
  public boolean hgt;
  private boolean hgu;
  public FrLifeController hgv;
  public VoidBoolStringI32StringCallback hgw;
  public VoidCallback hgx;
  private boolean hgy;
  private int hgz;
  KindaCacheServiceImpl kindaCacheService;
  
  static
  {
    AppMethodBeat.i(214602);
    hgC = new HashMap();
    AppMethodBeat.o(214602);
  }
  
  public UIPageFragmentActivity()
  {
    AppMethodBeat.i(214579);
    this.hgt = true;
    this.hgw = null;
    this.hgx = null;
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.hgz = 0;
    this.hgA = false;
    this.hgB = new AtomicInteger(5);
    AppMethodBeat.o(214579);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(214592);
    hgC.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(214592);
  }
  
  private boolean awX()
  {
    AppMethodBeat.i(214599);
    Object localObject = getKeyboard();
    final TenpaySecureEditText localTenpaySecureEditText = getTenpaySecureEditText();
    if ((localObject == null) || (localTenpaySecureEditText == null))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "Keyboard or EditText not found");
      AppMethodBeat.o(214599);
      return false;
    }
    UIPageFragmentActivity.b localb = new UIPageFragmentActivity.b((byte)0);
    ((MyKeyboardWindow)localObject).setOnTouchListener(localb);
    localObject = new UIPageFragmentActivity.2(this, localb);
    d.AEF.a((com.tencent.mm.plugin.normsg.a.b)localObject);
    localTenpaySecureEditText.setOnPasswdInputListener(new OnPasswdInputListener()
    {
      public final void onDone()
      {
        AppMethodBeat.i(214577);
        if (localTenpaySecureEditText.getEditState() == TenpaySecureEditText.EditState.PASSWORD)
        {
          UIPageFragmentActivity.ej(true);
          AppMethodBeat.o(214577);
          return;
        }
        UIPageFragmentActivity.ej(false);
        AppMethodBeat.o(214577);
      }
    });
    AppMethodBeat.o(214599);
    return true;
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(214587);
    Log.i("MicroMsg.UIPageFragmentActivity", "addFragment: ".concat(String.valueOf(paramBaseFragment)));
    boolean bool = this.hgv.addFragment(paramBaseFragment);
    AppMethodBeat.o(214587);
    return bool;
  }
  
  public final boolean awW()
  {
    AppMethodBeat.i(214595);
    if (this.hgv == null) {
      Log.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, controller is null!");
    }
    while ((this.hgv != null) && (this.hgv.getFragmentListSize() == 0))
    {
      AppMethodBeat.o(214595);
      return true;
      Log.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, fragment size: ", new Object[] { Integer.valueOf(this.hgv.getFragmentListSize()) });
    }
    AppMethodBeat.o(214595);
    return false;
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(214598);
    super.finish();
    Log.i("MicroMsg.UIPageFragmentActivity", "finish onlyModal:" + this.hgt);
    if (this.hgt) {
      super.overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(214598);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495407;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(214593);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.UIPageFragmentActivity", "onActivityResult requestCode: " + paramInt1 + ", resultCode: " + paramInt2 + ", data: " + paramIntent);
    int j = 0;
    int i;
    Object localObject;
    if ((paramInt1 == 4) && (paramIntent != null))
    {
      j = paramIntent.getIntExtra("err_code", 0);
      i = paramIntent.getIntExtra("scene", 0);
      int k = paramIntent.getIntExtra("countFace", 0);
      long l = paramIntent.getLongExtra("totalTime", 0L);
      int m = paramIntent.getIntExtra("err_type", 6);
      Log.i("MicroMsg.UIPageFragmentActivity", "errCode： ".concat(String.valueOf(j)));
      Log.i("MicroMsg.UIPageFragmentActivity", "scene： ".concat(String.valueOf(i)));
      Log.i("MicroMsg.UIPageFragmentActivity", "countFace： ".concat(String.valueOf(k)));
      Log.i("MicroMsg.UIPageFragmentActivity", "totalTime： ".concat(String.valueOf(l)));
      Log.i("MicroMsg.UIPageFragmentActivity", "errorType： ".concat(String.valueOf(m)));
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_OK");
        if ((this.hgw != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("token");
          this.hgw.call(false, (String)localObject, j, "");
          this.hgw = null;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.hgv != null) && (this.hgv.getFragmentListSize() <= 0))
      {
        finish();
        AppMethodBeat.o(214593);
        return;
        if ((this.hgw != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("click_other_verify_btn");
          if ((Util.isNullOrNil((String)localObject)) || (!((String)localObject).equalsIgnoreCase("yes"))) {
            break label415;
          }
        }
        label415:
        for (i = 1;; i = 0)
        {
          Log.i("MicroMsg.UIPageFragmentActivity", "isClickOtherVerify: %s", new Object[] { localObject });
          if (i != 0)
          {
            Log.i("MicroMsg.UIPageFragmentActivity", "check face failed, click other verify");
            this.hgw.call(true, "", j, "");
            this.hgw = null;
          }
          if (paramInt2 != 0) {
            break;
          }
          Log.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_CANCELED");
          if (this.hgx == null) {
            break;
          }
          this.hgx.call();
          this.hgx = null;
          break;
        }
        i = j;
        if (this.hgv != null)
        {
          i = j;
          if (this.hgv.processCallback(paramInt1))
          {
            i = j;
            if (awW())
            {
              finish();
              AppMethodBeat.o(214593);
              return;
            }
          }
        }
      }
    }
    if (i == 0)
    {
      localObject = (a)hgC.get(Integer.valueOf(paramInt1));
      if (localObject != null) {
        ((a)localObject).handle(paramInt2, paramIntent);
      }
      for (paramIntent = Boolean.TRUE; paramIntent.booleanValue(); paramIntent = Boolean.FALSE)
      {
        AppMethodBeat.o(214593);
        return;
      }
    }
    AppMethodBeat.o(214593);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(214590);
    Log.i("MicroMsg.UIPageFragmentActivity", "onBackPressed");
    if (!this.hgv.getCurrent().onBackPressed()) {
      popFragment();
    }
    AppMethodBeat.o(214590);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(214580);
    this.hgy = getIntent().getBooleanExtra("check_wallet_lock", false);
    Log.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", new Object[] { this });
    com.tencent.mm.plugin.report.service.h.CyF.dN(782, 37);
    this.crv = ao.isDarkMode();
    Log.i("MicroMsg.UIPageFragmentActivity", "isDarkMode:%s", new Object[] { Boolean.valueOf(ao.isDarkMode()) });
    this.hgv = new FrLifeController(this);
    this.hgu = getIntent().getBooleanExtra("key_support_swipe_back", true);
    super.onCreate(paramBundle);
    if (this.kindaCacheService != null)
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "force kindaShowingDialog is false");
      this.kindaCacheService.setBool("kindaShowingDialog", false, 0L);
    }
    if (this.hgy) {
      bool = ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    if (!bool) {
      t(getIntent().getBundleExtra("intent_bundle"));
    }
    setTenpayKBStateCallBackListener(new BaseFrActivity.IWalletTenpayKBStateCallBackListener()
    {
      public final void onCallBackKinda(boolean paramAnonymousBoolean, float paramAnonymousFloat)
      {
        AppMethodBeat.i(214576);
        BaseFragment localBaseFragment = UIPageFragmentActivity.a(UIPageFragmentActivity.this).getCurrent();
        float f = paramAnonymousFloat;
        if (paramAnonymousFloat == 0.0F) {
          f = 230.0F;
        }
        if (localBaseFragment != null) {
          if (paramAnonymousBoolean)
          {
            localBaseFragment.onKeyboardShow(true, com.tencent.mm.cb.a.E(UIPageFragmentActivity.this.getContext(), (int)f));
            if (!UIPageFragmentActivity.b(UIPageFragmentActivity.this))
            {
              UIPageFragmentActivity.a(UIPageFragmentActivity.this, UIPageFragmentActivity.c(UIPageFragmentActivity.this));
              AppMethodBeat.o(214576);
            }
          }
          else
          {
            localBaseFragment.onKeyboardShow(false, com.tencent.mm.cb.a.E(UIPageFragmentActivity.this.getContext(), (int)f));
          }
        }
        AppMethodBeat.o(214576);
      }
    });
    this.gyh = new com.tencent.mm.ui.tools.h(getContext());
    this.gyh.Quk = this;
    AppMethodBeat.o(214580);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(214585);
    super.onDestroy();
    KindaActionBarColorManager.getInstance().reset();
    this.hgv.onActivityDestroy();
    com.tencent.mm.plugin.report.service.h.CyF.dN(782, 44);
    d.AEF.sw(false);
    AppMethodBeat.o(214585);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(214584);
    Log.i("MicroMsg.UIPageFragmentActivity", "onPause");
    super.onPause();
    com.tencent.mm.plugin.report.service.h.CyF.dN(782, 42);
    EventCenter.instance.publish(new li());
    if (this.gyh != null) {
      this.gyh.close();
    }
    AppMethodBeat.o(214584);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(214597);
    boolean bool1 = paramBundle.getBoolean("key_dark_mode_state");
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slZ, true);
    Log.i("MicroMsg.UIPageFragmentActivity", "onRestoreInstanceState，lastDarkMode:%s  nowDarkMode:%s,svgconfig:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(ao.isDarkMode()), Boolean.valueOf(bool2) });
    if ((bool2) && ((ao.isDarkMode() ^ bool1))) {
      finish();
    }
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(214597);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(214582);
    Log.i("MicroMsg.UIPageFragmentActivity", "onResume");
    super.onResume();
    if (this.hgy)
    {
      com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class);
      localb.a(this, localb.fUE(), null);
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(782, 40);
    if ((this.hgv != null) && (this.hgv.processCallback(3)) && (awW())) {
      finish();
    }
    for (;;)
    {
      if (this.gyh != null) {
        this.gyh.start();
      }
      this.hgv.setTinyCallbackTag(true);
      AppMethodBeat.o(214582);
      return;
      TenpaySecureEditText.setSalt(f.hhV());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(214596);
    paramBundle.putBoolean("key_dark_mode_state", this.crv);
    Log.i("MicroMsg.UIPageFragmentActivity", "onSaveInstanceState，isDarkMode:%s", new Object[] { Boolean.valueOf(this.crv) });
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(214596);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(214594);
    Log.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", new Object[] { Float.valueOf(paramFloat) });
    super.onSwipe(paramFloat);
    AppMethodBeat.o(214594);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(214591);
    Log.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", new Object[] { Boolean.valueOf(this.hgu), this });
    if (!this.hgu)
    {
      AppMethodBeat.o(214591);
      return;
    }
    super.onSwipeBack();
    AppMethodBeat.o(214591);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(214583);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.gyh != null) {
      this.gyh.start();
    }
    AppMethodBeat.o(214583);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(214589);
    if (this.hgv.popFragment())
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "popFragment, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(214589);
      return true;
    }
    Log.i("MicroMsg.UIPageFragmentActivity", "popFragment, finish the UIPageFragmentActivity.");
    finish();
    AppMethodBeat.o(214589);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(214588);
    if (this.hgv.removeModal(paramBaseFragment))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(214588);
      return true;
    }
    Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, hasOpenH5OrTinyApp: %b, kindaShowingDialog: %b", new Object[] { Boolean.valueOf(this.hgv.hasOpenH5OrTinyApp()), Boolean.valueOf(this.kindaCacheService.getBool("kindaShowingDialog")) });
    if ((!this.hgv.hasOpenH5OrTinyApp()) && (!this.kindaCacheService.getBool("kindaShowingDialog")))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, finish the UIPageFragmentActivity.");
      finish();
    }
    AppMethodBeat.o(214588);
    return false;
  }
  
  public final void t(Bundle paramBundle)
  {
    AppMethodBeat.i(214586);
    if (paramBundle == null)
    {
      AppMethodBeat.o(214586);
      return;
    }
    Object localObject = ActivityController.resolveFragment(paramBundle);
    if (localObject != null)
    {
      boolean bool1 = paramBundle.getBoolean("intent_webview", false);
      boolean bool2 = paramBundle.getBoolean("intent_tinyapp", false);
      if ((bool1) && ((localObject instanceof MainFragment)))
      {
        localObject = (MainFragment)localObject;
        this.hgv.startWebViewUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(214586);
        return;
      }
      if ((bool2) && ((localObject instanceof MainFragment)))
      {
        localObject = (MainFragment)localObject;
        this.hgv.startTinyAppUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(214586);
        return;
      }
      this.hgv.addFragment((BaseFragment)localObject);
      AppMethodBeat.o(214586);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(214586);
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(214581);
    Log.d("MicroMsg.UIPageFragmentActivity", "onKeyboardHeightChanged %s", new Object[] { Integer.valueOf(paramInt) });
    BaseFragment localBaseFragment = this.hgv.getCurrent();
    if (localBaseFragment == null)
    {
      AppMethodBeat.o(214581);
      return;
    }
    if ((paramInt > 0) && (this.hgz <= 0))
    {
      this.hgz = paramInt;
      localBaseFragment.onKeyboardShow(true, com.tencent.mm.cb.a.E(getContext(), paramInt));
      Log.d("MicroMsg.UIPageFragmentActivity", "show keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramInt <= 0) && (this.hgz > 0))
    {
      this.hgz = paramInt;
      localBaseFragment.onKeyboardShow(false, com.tencent.mm.cb.a.E(getContext(), paramInt));
      Log.d("MicroMsg.UIPageFragmentActivity", "hide keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(214581);
  }
  
  public static abstract interface a
  {
    public abstract void handle(int paramInt, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.framework.app.UIPageFragmentActivity
 * JD-Core Version:    0.7.0.1
 */