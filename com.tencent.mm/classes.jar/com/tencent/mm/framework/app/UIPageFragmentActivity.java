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
import com.tencent.mm.g.a.ks;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(1)
public class UIPageFragmentActivity
  extends BaseFrActivity
  implements IEventFragment, com.tencent.mm.ui.tools.g
{
  private static HashMap<Integer, a> gtR;
  private h fSZ;
  private boolean gtJ;
  public FrLifeController gtK;
  public VoidBoolStringI32StringCallback gtL;
  public VoidCallback gtM;
  private boolean gtN;
  private boolean gtO;
  private int gtP;
  public AtomicInteger gtQ;
  KindaCacheServiceImpl kindaCacheService;
  
  static
  {
    AppMethodBeat.i(193279);
    gtR = new HashMap();
    AppMethodBeat.o(193279);
  }
  
  public UIPageFragmentActivity()
  {
    AppMethodBeat.i(193260);
    this.gtL = null;
    this.gtM = null;
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.gtP = 0;
    this.gtQ = new AtomicInteger(5);
    AppMethodBeat.o(193260);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(193273);
    gtR.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(193273);
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(193268);
    ae.i("MicroMsg.UIPageFragmentActivity", "addFragment: ".concat(String.valueOf(paramBaseFragment)));
    boolean bool = this.gtK.addFragment(paramBaseFragment);
    AppMethodBeat.o(193268);
    return bool;
  }
  
  public final boolean agL()
  {
    AppMethodBeat.i(193276);
    if (this.gtK == null) {
      ae.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, controller is null!");
    }
    while ((this.gtK != null) && (this.gtK.getFragmentListSize() == 0))
    {
      AppMethodBeat.o(193276);
      return true;
      ae.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, fragment size: ", new Object[] { Integer.valueOf(this.gtK.getFragmentListSize()) });
    }
    AppMethodBeat.o(193276);
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
    AppMethodBeat.i(193274);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.UIPageFragmentActivity", "onActivityResult requestCode: " + paramInt1 + ", resultCode: " + paramInt2 + ", data: " + paramIntent);
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
      ae.i("MicroMsg.UIPageFragmentActivity", "errCode： ".concat(String.valueOf(j)));
      ae.i("MicroMsg.UIPageFragmentActivity", "scene： ".concat(String.valueOf(i)));
      ae.i("MicroMsg.UIPageFragmentActivity", "countFace： ".concat(String.valueOf(k)));
      ae.i("MicroMsg.UIPageFragmentActivity", "totalTime： ".concat(String.valueOf(l)));
      ae.i("MicroMsg.UIPageFragmentActivity", "errorType： ".concat(String.valueOf(m)));
      if (paramInt2 == -1)
      {
        ae.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_OK");
        if ((this.gtL != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("token");
          this.gtL.call(false, (String)localObject, j, "");
          this.gtL = null;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.gtK != null) && (this.gtK.getFragmentListSize() <= 0))
      {
        finish();
        AppMethodBeat.o(193274);
        return;
        if ((this.gtL != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("click_other_verify_btn");
          if ((bu.isNullOrNil((String)localObject)) || (!((String)localObject).equalsIgnoreCase("yes"))) {
            break label396;
          }
        }
        label396:
        for (i = 1;; i = 0)
        {
          ae.i("MicroMsg.UIPageFragmentActivity", "isClickOtherVerify: %s", new Object[] { localObject });
          if (i != 0)
          {
            ae.i("MicroMsg.UIPageFragmentActivity", "check face failed, click other verify");
            this.gtL.call(true, "", j, "");
            this.gtL = null;
          }
          if (paramInt2 != 0) {
            break;
          }
          ae.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_CANCELED");
          if (this.gtM == null) {
            break;
          }
          this.gtM.call();
          this.gtM = null;
          break;
        }
        i = j;
        if (this.gtK != null)
        {
          i = j;
          if (this.gtK.processCallback(paramInt1))
          {
            i = j;
            if (agL())
            {
              finish();
              AppMethodBeat.o(193274);
              return;
            }
          }
        }
      }
    }
    if (i == 0)
    {
      localObject = (a)gtR.get(Integer.valueOf(paramInt1));
      if (localObject != null) {
        ((a)localObject).handle(paramInt2, paramIntent);
      }
      for (paramIntent = Boolean.TRUE; paramIntent.booleanValue(); paramIntent = Boolean.FALSE)
      {
        AppMethodBeat.o(193274);
        return;
      }
    }
    AppMethodBeat.o(193274);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(193271);
    ae.i("MicroMsg.UIPageFragmentActivity", "onBackPressed");
    if (!this.gtK.getCurrent().onBackPressed()) {
      popFragment();
    }
    AppMethodBeat.o(193271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(193261);
    this.gtN = getIntent().getBooleanExtra("check_wallet_lock", false);
    ae.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", new Object[] { this });
    com.tencent.mm.plugin.report.service.g.yxI.dD(782, 37);
    this.gtO = al.isDarkMode();
    ae.i("MicroMsg.UIPageFragmentActivity", "isDarkMode:%s", new Object[] { Boolean.valueOf(al.isDarkMode()) });
    this.gtK = new FrLifeController(this);
    this.gtJ = getIntent().getBooleanExtra("key_support_swipe_back", true);
    super.onCreate(paramBundle);
    if (this.kindaCacheService != null)
    {
      ae.i("MicroMsg.UIPageFragmentActivity", "force kindaShowingDialog is false");
      this.kindaCacheService.setBool("kindaShowingDialog", false, 0L);
    }
    if (this.gtN) {
      bool = ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    if (!bool) {
      p(getIntent().getBundleExtra("intent_bundle"));
    }
    setTenpayKBStateCallBackListener(new BaseFrActivity.IWalletTenpayKBStateCallBackListener()
    {
      public final void onCallBackKinda(boolean paramAnonymousBoolean, float paramAnonymousFloat)
      {
        AppMethodBeat.i(193259);
        BaseFragment localBaseFragment = UIPageFragmentActivity.a(UIPageFragmentActivity.this).getCurrent();
        float f = paramAnonymousFloat;
        if (paramAnonymousFloat == 0.0F) {
          f = 230.0F;
        }
        if (localBaseFragment != null)
        {
          if (paramAnonymousBoolean)
          {
            localBaseFragment.onKeyboardShow(true, com.tencent.mm.cb.a.aA(UIPageFragmentActivity.this.getContext(), (int)f));
            AppMethodBeat.o(193259);
            return;
          }
          localBaseFragment.onKeyboardShow(false, com.tencent.mm.cb.a.aA(UIPageFragmentActivity.this.getContext(), (int)f));
        }
        AppMethodBeat.o(193259);
      }
    });
    this.fSZ = new h(getContext());
    this.fSZ.Lfj = this;
    AppMethodBeat.o(193261);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193266);
    super.onDestroy();
    KindaActionBarColorManager.getInstance().reset();
    this.gtK.onActivityDestroy();
    com.tencent.mm.plugin.report.service.g.yxI.dD(782, 44);
    AppMethodBeat.o(193266);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(193265);
    ae.i("MicroMsg.UIPageFragmentActivity", "onPause");
    super.onPause();
    com.tencent.mm.plugin.report.service.g.yxI.dD(782, 42);
    com.tencent.mm.sdk.b.a.IvT.l(new ks());
    if (this.fSZ != null) {
      this.fSZ.close();
    }
    AppMethodBeat.o(193265);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(193278);
    boolean bool1 = paramBundle.getBoolean("key_dark_mode_state");
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOS, true);
    ae.i("MicroMsg.UIPageFragmentActivity", "onRestoreInstanceState，lastDarkMode:%s  nowDarkMode:%s,svgconfig:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(al.isDarkMode()), Boolean.valueOf(bool2) });
    if ((bool2) && ((al.isDarkMode() ^ bool1))) {
      finish();
    }
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(193278);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(193263);
    ae.i("MicroMsg.UIPageFragmentActivity", "onResume");
    super.onResume();
    if (this.gtN)
    {
      com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
      localb.a(this, localb.eMV(), null);
    }
    com.tencent.mm.plugin.report.service.g.yxI.dD(782, 40);
    if ((this.gtK != null) && (this.gtK.processCallback(3)) && (agL())) {
      finish();
    }
    for (;;)
    {
      if (this.fSZ != null) {
        this.fSZ.start();
      }
      this.gtK.setTinyCallbackTag(true);
      AppMethodBeat.o(193263);
      return;
      TenpaySecureEditText.setSalt(f.fWx());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(193277);
    paramBundle.putBoolean("key_dark_mode_state", this.gtO);
    ae.i("MicroMsg.UIPageFragmentActivity", "onSaveInstanceState，isDarkMode:%s", new Object[] { Boolean.valueOf(this.gtO) });
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(193277);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(193275);
    ae.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", new Object[] { Float.valueOf(paramFloat) });
    super.onSwipe(paramFloat);
    AppMethodBeat.o(193275);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(193272);
    ae.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", new Object[] { Boolean.valueOf(this.gtJ), this });
    if (!this.gtJ)
    {
      AppMethodBeat.o(193272);
      return;
    }
    super.onSwipeBack();
    AppMethodBeat.o(193272);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(193264);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.fSZ != null) {
      this.fSZ.start();
    }
    AppMethodBeat.o(193264);
  }
  
  public final void p(Bundle paramBundle)
  {
    AppMethodBeat.i(193267);
    if (paramBundle == null)
    {
      AppMethodBeat.o(193267);
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
        this.gtK.startWebViewUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(193267);
        return;
      }
      if ((bool2) && ((localObject instanceof MainFragment)))
      {
        localObject = (MainFragment)localObject;
        this.gtK.startTinyAppUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(193267);
        return;
      }
      this.gtK.addFragment((BaseFragment)localObject);
      AppMethodBeat.o(193267);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(193267);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(193270);
    if (this.gtK.popFragment())
    {
      ae.i("MicroMsg.UIPageFragmentActivity", "popFragment, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(193270);
      return true;
    }
    ae.i("MicroMsg.UIPageFragmentActivity", "popFragment, finish the UIPageFragmentActivity.");
    finish();
    AppMethodBeat.o(193270);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(193269);
    if (this.gtK.removeModal(paramBaseFragment))
    {
      ae.i("MicroMsg.UIPageFragmentActivity", "removeModal, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(193269);
      return true;
    }
    ae.i("MicroMsg.UIPageFragmentActivity", "removeModal, hasOpenH5OrTinyApp: %b, kindaShowingDialog: %b", new Object[] { Boolean.valueOf(this.gtK.hasOpenH5OrTinyApp()), Boolean.valueOf(this.kindaCacheService.getBool("kindaShowingDialog")) });
    if ((!this.gtK.hasOpenH5OrTinyApp()) && (!this.kindaCacheService.getBool("kindaShowingDialog")))
    {
      ae.i("MicroMsg.UIPageFragmentActivity", "removeModal, finish the UIPageFragmentActivity.");
      finish();
    }
    AppMethodBeat.o(193269);
    return false;
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(193262);
    ae.d("MicroMsg.UIPageFragmentActivity", "onKeyboardHeightChanged %s", new Object[] { Integer.valueOf(paramInt) });
    BaseFragment localBaseFragment = this.gtK.getCurrent();
    if (localBaseFragment == null)
    {
      AppMethodBeat.o(193262);
      return;
    }
    if ((paramInt > 0) && (this.gtP <= 0))
    {
      this.gtP = paramInt;
      localBaseFragment.onKeyboardShow(true, com.tencent.mm.cb.a.aA(getContext(), paramInt));
      ae.d("MicroMsg.UIPageFragmentActivity", "show keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramInt <= 0) && (this.gtP > 0))
    {
      this.gtP = paramInt;
      localBaseFragment.onKeyboardShow(false, com.tencent.mm.cb.a.aA(getContext(), paramInt));
      ae.d("MicroMsg.UIPageFragmentActivity", "hide keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(193262);
  }
  
  public static abstract interface a
  {
    public abstract void handle(int paramInt, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.framework.app.UIPageFragmentActivity
 * JD-Core Version:    0.7.0.1
 */