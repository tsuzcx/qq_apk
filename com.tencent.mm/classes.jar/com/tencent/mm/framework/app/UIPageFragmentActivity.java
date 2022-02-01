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
import com.tencent.mm.g.a.kr;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(1)
public class UIPageFragmentActivity
  extends BaseFrActivity
  implements IEventFragment, com.tencent.mm.ui.tools.g
{
  private static HashMap<Integer, a> grq;
  private h fQT;
  private boolean grj;
  public FrLifeController grk;
  public VoidBoolStringI32StringCallback grl;
  public VoidCallback grm;
  private boolean grn;
  private int gro;
  public AtomicInteger grp;
  private boolean isDarkMode;
  KindaCacheServiceImpl kindaCacheService;
  
  static
  {
    AppMethodBeat.i(199562);
    grq = new HashMap();
    AppMethodBeat.o(199562);
  }
  
  public UIPageFragmentActivity()
  {
    AppMethodBeat.i(199543);
    this.grl = null;
    this.grm = null;
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.gro = 0;
    this.grp = new AtomicInteger(5);
    AppMethodBeat.o(199543);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(199556);
    grq.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(199556);
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(199551);
    ad.i("MicroMsg.UIPageFragmentActivity", "addFragment: ".concat(String.valueOf(paramBaseFragment)));
    boolean bool = this.grk.addFragment(paramBaseFragment);
    AppMethodBeat.o(199551);
    return bool;
  }
  
  public final boolean agx()
  {
    AppMethodBeat.i(199559);
    if (this.grk == null) {
      ad.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, controller is null!");
    }
    while ((this.grk != null) && (this.grk.getFragmentListSize() == 0))
    {
      AppMethodBeat.o(199559);
      return true;
      ad.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, fragment size: ", new Object[] { Integer.valueOf(this.grk.getFragmentListSize()) });
    }
    AppMethodBeat.o(199559);
    return false;
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494681;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(199557);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.UIPageFragmentActivity", "onActivityResult requestCode: " + paramInt1 + ", resultCode: " + paramInt2 + ", data: " + paramIntent);
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
      ad.i("MicroMsg.UIPageFragmentActivity", "errCode： ".concat(String.valueOf(j)));
      ad.i("MicroMsg.UIPageFragmentActivity", "scene： ".concat(String.valueOf(i)));
      ad.i("MicroMsg.UIPageFragmentActivity", "countFace： ".concat(String.valueOf(k)));
      ad.i("MicroMsg.UIPageFragmentActivity", "totalTime： ".concat(String.valueOf(l)));
      ad.i("MicroMsg.UIPageFragmentActivity", "errorType： ".concat(String.valueOf(m)));
      if (paramInt2 == -1)
      {
        ad.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_OK");
        if ((this.grl != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("token");
          this.grl.call(false, (String)localObject, j, "");
          this.grl = null;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.grk != null) && (this.grk.getFragmentListSize() <= 0))
      {
        finish();
        AppMethodBeat.o(199557);
        return;
        if ((this.grl != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("click_other_verify_btn");
          if ((bt.isNullOrNil((String)localObject)) || (!((String)localObject).equalsIgnoreCase("yes"))) {
            break label396;
          }
        }
        label396:
        for (i = 1;; i = 0)
        {
          ad.i("MicroMsg.UIPageFragmentActivity", "isClickOtherVerify: %s", new Object[] { localObject });
          if (i != 0)
          {
            ad.i("MicroMsg.UIPageFragmentActivity", "check face failed, click other verify");
            this.grl.call(true, "", j, "");
            this.grl = null;
          }
          if (paramInt2 != 0) {
            break;
          }
          ad.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_CANCELED");
          if (this.grm == null) {
            break;
          }
          this.grm.call();
          this.grm = null;
          break;
        }
        i = j;
        if (this.grk != null)
        {
          i = j;
          if (this.grk.processCallback(paramInt1))
          {
            i = j;
            if (agx())
            {
              finish();
              AppMethodBeat.o(199557);
              return;
            }
          }
        }
      }
    }
    if (i == 0)
    {
      localObject = (a)grq.get(Integer.valueOf(paramInt1));
      if (localObject != null) {
        ((a)localObject).handle(paramInt2, paramIntent);
      }
      for (paramIntent = Boolean.TRUE; paramIntent.booleanValue(); paramIntent = Boolean.FALSE)
      {
        AppMethodBeat.o(199557);
        return;
      }
    }
    AppMethodBeat.o(199557);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(199554);
    ad.i("MicroMsg.UIPageFragmentActivity", "onBackPressed");
    if (!this.grk.getCurrent().onBackPressed()) {
      popFragment();
    }
    AppMethodBeat.o(199554);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(199544);
    this.grn = getIntent().getBooleanExtra("check_wallet_lock", false);
    ad.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", new Object[] { this });
    com.tencent.mm.plugin.report.service.g.yhR.dD(782, 37);
    this.isDarkMode = al.isDarkMode();
    ad.i("MicroMsg.UIPageFragmentActivity", "isDarkMode:%s", new Object[] { Boolean.valueOf(al.isDarkMode()) });
    this.grk = new FrLifeController(this);
    this.grj = getIntent().getBooleanExtra("key_support_swipe_back", true);
    super.onCreate(paramBundle);
    if (this.kindaCacheService != null)
    {
      ad.i("MicroMsg.UIPageFragmentActivity", "force kindaShowingDialog is false");
      this.kindaCacheService.setBool("kindaShowingDialog", false, 0L);
    }
    if (this.grn) {
      bool = ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    if (!bool) {
      p(getIntent().getBundleExtra("intent_bundle"));
    }
    setTenpayKBStateCallBackListener(new BaseFrActivity.IWalletTenpayKBStateCallBackListener()
    {
      public final void onCallBackKinda(boolean paramAnonymousBoolean, float paramAnonymousFloat)
      {
        AppMethodBeat.i(199542);
        BaseFragment localBaseFragment = UIPageFragmentActivity.a(UIPageFragmentActivity.this).getCurrent();
        float f = paramAnonymousFloat;
        if (paramAnonymousFloat == 0.0F) {
          f = 230.0F;
        }
        if (localBaseFragment != null)
        {
          if (paramAnonymousBoolean)
          {
            localBaseFragment.onKeyboardShow(true, com.tencent.mm.cc.a.aA(UIPageFragmentActivity.this.getContext(), (int)f));
            AppMethodBeat.o(199542);
            return;
          }
          localBaseFragment.onKeyboardShow(false, com.tencent.mm.cc.a.aA(UIPageFragmentActivity.this.getContext(), (int)f));
        }
        AppMethodBeat.o(199542);
      }
    });
    this.fQT = new h(getContext());
    this.fQT.KIP = this;
    AppMethodBeat.o(199544);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(199549);
    super.onDestroy();
    KindaActionBarColorManager.getInstance().reset();
    this.grk.onActivityDestroy();
    com.tencent.mm.plugin.report.service.g.yhR.dD(782, 44);
    AppMethodBeat.o(199549);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(199548);
    ad.i("MicroMsg.UIPageFragmentActivity", "onPause");
    super.onPause();
    com.tencent.mm.plugin.report.service.g.yhR.dD(782, 42);
    com.tencent.mm.sdk.b.a.IbL.l(new kr());
    if (this.fQT != null) {
      this.fQT.close();
    }
    AppMethodBeat.o(199548);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(199561);
    boolean bool1 = paramBundle.getBoolean("key_dark_mode_state");
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHm, true);
    ad.i("MicroMsg.UIPageFragmentActivity", "onRestoreInstanceState，lastDarkMode:%s  nowDarkMode:%s,svgconfig:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(al.isDarkMode()), Boolean.valueOf(bool2) });
    if ((bool2) && ((al.isDarkMode() ^ bool1))) {
      finish();
    }
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(199561);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(199546);
    ad.i("MicroMsg.UIPageFragmentActivity", "onResume");
    super.onResume();
    if (this.grn)
    {
      com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
      localb.a(this, localb.eJn(), null);
    }
    com.tencent.mm.plugin.report.service.g.yhR.dD(782, 40);
    if ((this.grk != null) && (this.grk.processCallback(3)) && (agx())) {
      finish();
    }
    for (;;)
    {
      if (this.fQT != null) {
        this.fQT.start();
      }
      this.grk.setTinyCallbackTag(true);
      AppMethodBeat.o(199546);
      return;
      TenpaySecureEditText.setSalt(e.fSb());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(199560);
    paramBundle.putBoolean("key_dark_mode_state", this.isDarkMode);
    ad.i("MicroMsg.UIPageFragmentActivity", "onSaveInstanceState，isDarkMode:%s", new Object[] { Boolean.valueOf(this.isDarkMode) });
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(199560);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(199558);
    ad.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", new Object[] { Float.valueOf(paramFloat) });
    super.onSwipe(paramFloat);
    AppMethodBeat.o(199558);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(199555);
    ad.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", new Object[] { Boolean.valueOf(this.grj), this });
    if (!this.grj)
    {
      AppMethodBeat.o(199555);
      return;
    }
    super.onSwipeBack();
    AppMethodBeat.o(199555);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(199547);
    super.onWindowFocusChanged(paramBoolean);
    if (this.fQT != null) {
      this.fQT.start();
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(199547);
  }
  
  public final void p(Bundle paramBundle)
  {
    AppMethodBeat.i(199550);
    if (paramBundle == null)
    {
      AppMethodBeat.o(199550);
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
        this.grk.startWebViewUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(199550);
        return;
      }
      if ((bool2) && ((localObject instanceof MainFragment)))
      {
        localObject = (MainFragment)localObject;
        this.grk.startTinyAppUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(199550);
        return;
      }
      this.grk.addFragment((BaseFragment)localObject);
      AppMethodBeat.o(199550);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(199550);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(199553);
    if (this.grk.popFragment())
    {
      ad.i("MicroMsg.UIPageFragmentActivity", "popFragment, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(199553);
      return true;
    }
    ad.i("MicroMsg.UIPageFragmentActivity", "popFragment, finish the UIPageFragmentActivity.");
    finish();
    AppMethodBeat.o(199553);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(199552);
    if (this.grk.removeModal(paramBaseFragment))
    {
      ad.i("MicroMsg.UIPageFragmentActivity", "removeModal, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(199552);
      return true;
    }
    ad.i("MicroMsg.UIPageFragmentActivity", "removeModal, hasOpenH5OrTinyApp: %b, kindaShowingDialog: %b", new Object[] { Boolean.valueOf(this.grk.hasOpenH5OrTinyApp()), Boolean.valueOf(this.kindaCacheService.getBool("kindaShowingDialog")) });
    if ((!this.grk.hasOpenH5OrTinyApp()) && (!this.kindaCacheService.getBool("kindaShowingDialog")))
    {
      ad.i("MicroMsg.UIPageFragmentActivity", "removeModal, finish the UIPageFragmentActivity.");
      finish();
    }
    AppMethodBeat.o(199552);
    return false;
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(199545);
    ad.d("MicroMsg.UIPageFragmentActivity", "onKeyboardHeightChanged %s", new Object[] { Integer.valueOf(paramInt) });
    BaseFragment localBaseFragment = this.grk.getCurrent();
    if (localBaseFragment == null)
    {
      AppMethodBeat.o(199545);
      return;
    }
    if ((paramInt > 0) && (this.gro <= 0))
    {
      this.gro = paramInt;
      localBaseFragment.onKeyboardShow(true, com.tencent.mm.cc.a.aA(getContext(), paramInt));
      ad.d("MicroMsg.UIPageFragmentActivity", "show keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramInt <= 0) && (this.gro > 0))
    {
      this.gro = paramInt;
      localBaseFragment.onKeyboardShow(false, com.tencent.mm.cc.a.aA(getContext(), paramInt));
      ad.d("MicroMsg.UIPageFragmentActivity", "hide keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(199545);
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