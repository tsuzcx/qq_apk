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
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(1)
public class UIPageFragmentActivity
  extends BaseFrActivity
  implements IEventFragment, com.tencent.mm.ui.tools.g
{
  private static HashMap<Integer, a> fUa;
  private boolean fTT;
  private FrLifeController fTU;
  public VoidBoolStringI32StringCallback fTV;
  public VoidCallback fTW;
  private boolean fTX;
  private boolean fTY;
  public AtomicInteger fTZ;
  private com.tencent.mm.ui.tools.h ftZ;
  KindaCacheServiceImpl kindaCacheService;
  
  static
  {
    AppMethodBeat.i(186473);
    fUa = new HashMap();
    AppMethodBeat.o(186473);
  }
  
  public UIPageFragmentActivity()
  {
    AppMethodBeat.i(186453);
    this.fTV = null;
    this.fTW = null;
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.fTZ = new AtomicInteger(4);
    AppMethodBeat.o(186453);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(186467);
    fUa.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(186467);
  }
  
  public final boolean acL()
  {
    AppMethodBeat.i(186470);
    if (this.fTU == null) {
      ad.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, controller is null!");
    }
    while ((this.fTU != null) && (this.fTU.getFragmentListSize() == 0))
    {
      AppMethodBeat.o(186470);
      return true;
      ad.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, fragment size: ", new Object[] { Integer.valueOf(this.fTU.getFragmentListSize()) });
    }
    AppMethodBeat.o(186470);
    return false;
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(186462);
    ad.i("MicroMsg.UIPageFragmentActivity", "addFragment: ".concat(String.valueOf(paramBaseFragment)));
    boolean bool = this.fTU.addFragment(paramBaseFragment);
    AppMethodBeat.o(186462);
    return bool;
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
    AppMethodBeat.i(186468);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.UIPageFragmentActivity", "onActivityResult requestCode: " + paramInt1 + ", resultCode: " + paramInt2 + ", data: " + paramIntent);
    int j;
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
        if ((this.fTV != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("token");
          this.fTV.call(false, (String)localObject, j, "");
          this.fTV = null;
        }
        if ((this.fTU != null) && (this.fTU.getFragmentListSize() <= 0)) {
          finish();
        }
        localObject = (a)fUa.get(Integer.valueOf(paramInt1));
        if (localObject == null) {
          break label470;
        }
        ((a)localObject).handle(paramInt2, paramIntent);
      }
    }
    label432:
    label470:
    for (paramIntent = Boolean.TRUE;; paramIntent = Boolean.FALSE)
    {
      if (!paramIntent.booleanValue()) {
        break label477;
      }
      AppMethodBeat.o(186468);
      return;
      if ((this.fTV != null) && (paramIntent.getExtras() != null))
      {
        localObject = paramIntent.getExtras().getString("click_other_verify_btn");
        if ((bt.isNullOrNil((String)localObject)) || (!((String)localObject).equalsIgnoreCase("yes"))) {
          break label432;
        }
      }
      for (i = 1;; i = 0)
      {
        ad.i("MicroMsg.UIPageFragmentActivity", "isClickOtherVerify: %s", new Object[] { localObject });
        if (i != 0)
        {
          ad.i("MicroMsg.UIPageFragmentActivity", "check face failed, click other verify");
          this.fTV.call(true, "", j, "");
          this.fTV = null;
        }
        if (paramInt2 != 0) {
          break;
        }
        ad.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_CANCELED");
        if (this.fTW == null) {
          break;
        }
        this.fTW.call();
        this.fTW = null;
        break;
      }
      if ((this.fTU == null) || (!this.fTU.processCallback(paramInt1)) || (!acL())) {
        break;
      }
      finish();
      break;
    }
    label477:
    AppMethodBeat.o(186468);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(186465);
    ad.i("MicroMsg.UIPageFragmentActivity", "onBackPressed");
    if (!this.fTU.getCurrent().onBackPressed()) {
      popFragment();
    }
    AppMethodBeat.o(186465);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(186454);
    this.fTX = getIntent().getBooleanExtra("check_wallet_lock", false);
    ad.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", new Object[] { this });
    com.tencent.mm.plugin.report.service.h.vKh.dB(782, 37);
    this.fTY = ai.Eq();
    ad.i("MicroMsg.UIPageFragmentActivity", "isDarkMode:%s", new Object[] { Boolean.valueOf(ai.Eq()) });
    this.fTU = new FrLifeController(this);
    this.fTT = getIntent().getBooleanExtra("key_support_swipe_back", true);
    super.onCreate(paramBundle);
    if (this.kindaCacheService != null)
    {
      ad.i("MicroMsg.UIPageFragmentActivity", "force kindaShowingDialog is false");
      this.kindaCacheService.setBool("kindaShowingDialog", false, 0L);
    }
    if (this.fTX) {
      bool = ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    if (!bool) {
      p(getIntent().getBundleExtra("intent_bundle"));
    }
    setTenpayKBStateCallBackListener(new BaseFrActivity.IWalletTenpayKBStateCallBackListener()
    {
      public final void onCallBackKinda(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(186452);
        BaseFragment localBaseFragment = UIPageFragmentActivity.a(UIPageFragmentActivity.this).getCurrent();
        if (localBaseFragment != null)
        {
          if (paramAnonymousBoolean)
          {
            localBaseFragment.onKeyboardShow(true, 230);
            AppMethodBeat.o(186452);
            return;
          }
          localBaseFragment.onKeyboardShow(false, 230);
        }
        AppMethodBeat.o(186452);
      }
    });
    this.ftZ = new com.tencent.mm.ui.tools.h(getContext());
    this.ftZ.Hro = this;
    AppMethodBeat.o(186454);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186460);
    super.onDestroy();
    KindaActionBarColorManager.getInstance().reset();
    com.tencent.mm.plugin.report.service.h.vKh.dB(782, 44);
    AppMethodBeat.o(186460);
  }
  
  public void onKeyboardStateChanged()
  {
    boolean bool = true;
    AppMethodBeat.i(186455);
    BaseFragment localBaseFragment = this.fTU.getCurrent();
    if (localBaseFragment != null) {
      if (keyboardState() != 1) {
        break label54;
      }
    }
    for (;;)
    {
      localBaseFragment.onKeyboardShow(bool, com.tencent.mm.cd.a.ar(getContext(), i.ik(getContext())));
      AppMethodBeat.o(186455);
      return;
      label54:
      bool = false;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(186459);
    ad.i("MicroMsg.UIPageFragmentActivity", "onPause");
    super.onPause();
    com.tencent.mm.plugin.report.service.h.vKh.dB(782, 42);
    com.tencent.mm.sdk.b.a.ESL.l(new ka());
    if (this.ftZ != null) {
      this.ftZ.close();
    }
    AppMethodBeat.o(186459);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(186472);
    boolean bool1 = paramBundle.getBoolean("key_dark_mode_state");
    boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxr, true);
    ad.i("MicroMsg.UIPageFragmentActivity", "onRestoreInstanceState，lastDarkMode:%s  nowDarkMode:%s,svgconfig:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(ai.Eq()), Boolean.valueOf(bool2) });
    if ((bool2) && ((ai.Eq() ^ bool1))) {
      finish();
    }
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(186472);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(186457);
    ad.i("MicroMsg.UIPageFragmentActivity", "onResume");
    super.onResume();
    if (this.fTX)
    {
      com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
      localb.a(this, localb.efN(), null);
    }
    com.tencent.mm.plugin.report.service.h.vKh.dB(782, 40);
    if ((this.fTU != null) && (this.fTU.processCallback(3)) && (acL())) {
      finish();
    }
    for (;;)
    {
      if (this.ftZ != null) {
        this.ftZ.start();
      }
      AppMethodBeat.o(186457);
      return;
      TenpaySecureEditText.setSalt(e.fkB());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(186471);
    paramBundle.putBoolean("key_dark_mode_state", this.fTY);
    ad.i("MicroMsg.UIPageFragmentActivity", "onSaveInstanceState，isDarkMode:%s", new Object[] { Boolean.valueOf(this.fTY) });
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(186471);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(186469);
    ad.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", new Object[] { Float.valueOf(paramFloat) });
    super.onSwipe(paramFloat);
    AppMethodBeat.o(186469);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(186466);
    ad.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", new Object[] { Boolean.valueOf(this.fTT), this });
    if (!this.fTT)
    {
      AppMethodBeat.o(186466);
      return;
    }
    super.onSwipeBack();
    AppMethodBeat.o(186466);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(186458);
    super.onWindowFocusChanged(paramBoolean);
    if (this.ftZ != null) {
      this.ftZ.start();
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(186458);
  }
  
  public final void p(Bundle paramBundle)
  {
    AppMethodBeat.i(186461);
    if (paramBundle == null)
    {
      AppMethodBeat.o(186461);
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
        this.fTU.startWebViewUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(186461);
        return;
      }
      if ((bool2) && ((localObject instanceof MainFragment)))
      {
        localObject = (MainFragment)localObject;
        this.fTU.startTinyAppUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(186461);
        return;
      }
      this.fTU.addFragment((BaseFragment)localObject);
      AppMethodBeat.o(186461);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(186461);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(186464);
    if (this.fTU.popFragment())
    {
      ad.i("MicroMsg.UIPageFragmentActivity", "popFragment, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(186464);
      return true;
    }
    ad.i("MicroMsg.UIPageFragmentActivity", "popFragment, finish the UIPageFragmentActivity.");
    finish();
    AppMethodBeat.o(186464);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(186463);
    if (this.fTU.removeModal(paramBaseFragment))
    {
      ad.i("MicroMsg.UIPageFragmentActivity", "removeModal, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(186463);
      return true;
    }
    ad.i("MicroMsg.UIPageFragmentActivity", "removeModal, hasOpenH5OrTinyApp: %b, kindaShowingDialog: %b", new Object[] { Boolean.valueOf(this.fTU.hasOpenH5OrTinyApp()), Boolean.valueOf(this.kindaCacheService.getBool("kindaShowingDialog")) });
    if ((!this.fTU.hasOpenH5OrTinyApp()) && (!this.kindaCacheService.getBool("kindaShowingDialog")))
    {
      ad.i("MicroMsg.UIPageFragmentActivity", "removeModal, finish the UIPageFragmentActivity.");
      finish();
    }
    AppMethodBeat.o(186463);
    return false;
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(186456);
    if (paramInt > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      BaseFragment localBaseFragment = this.fTU.getCurrent();
      if (localBaseFragment != null) {
        localBaseFragment.onKeyboardShow(paramBoolean, com.tencent.mm.cd.a.ar(getContext(), paramInt));
      }
      AppMethodBeat.o(186456);
      return;
    }
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