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
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(1)
public class UIPageFragmentActivity
  extends BaseFrActivity
  implements IEventFragment, com.tencent.mm.ui.tools.g
{
  private static HashMap<Integer, a> fXV;
  private boolean fXN;
  private FrLifeController fXO;
  public VoidBoolStringI32StringCallback fXP;
  public VoidCallback fXQ;
  private boolean fXR;
  private boolean fXS;
  private int fXT;
  public AtomicInteger fXU;
  private com.tencent.mm.ui.tools.h fxG;
  KindaCacheServiceImpl kindaCacheService;
  
  static
  {
    AppMethodBeat.i(207439);
    fXV = new HashMap();
    AppMethodBeat.o(207439);
  }
  
  public UIPageFragmentActivity()
  {
    AppMethodBeat.i(207419);
    this.fXP = null;
    this.fXQ = null;
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.fXT = 0;
    this.fXU = new AtomicInteger(4);
    AppMethodBeat.o(207419);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(207433);
    fXV.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(207433);
  }
  
  public final boolean adR()
  {
    AppMethodBeat.i(207436);
    if (this.fXO == null) {
      ac.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, controller is null!");
    }
    while ((this.fXO != null) && (this.fXO.getFragmentListSize() == 0))
    {
      AppMethodBeat.o(207436);
      return true;
      ac.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, fragment size: ", new Object[] { Integer.valueOf(this.fXO.getFragmentListSize()) });
    }
    AppMethodBeat.o(207436);
    return false;
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(207428);
    ac.i("MicroMsg.UIPageFragmentActivity", "addFragment: ".concat(String.valueOf(paramBaseFragment)));
    boolean bool = this.fXO.addFragment(paramBaseFragment);
    AppMethodBeat.o(207428);
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
    AppMethodBeat.i(207434);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.UIPageFragmentActivity", "onActivityResult requestCode: " + paramInt1 + ", resultCode: " + paramInt2 + ", data: " + paramIntent);
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
      ac.i("MicroMsg.UIPageFragmentActivity", "errCode： ".concat(String.valueOf(j)));
      ac.i("MicroMsg.UIPageFragmentActivity", "scene： ".concat(String.valueOf(i)));
      ac.i("MicroMsg.UIPageFragmentActivity", "countFace： ".concat(String.valueOf(k)));
      ac.i("MicroMsg.UIPageFragmentActivity", "totalTime： ".concat(String.valueOf(l)));
      ac.i("MicroMsg.UIPageFragmentActivity", "errorType： ".concat(String.valueOf(m)));
      if (paramInt2 == -1)
      {
        ac.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_OK");
        if ((this.fXP != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("token");
          this.fXP.call(false, (String)localObject, j, "");
          this.fXP = null;
        }
        if ((this.fXO != null) && (this.fXO.getFragmentListSize() <= 0)) {
          finish();
        }
        localObject = (a)fXV.get(Integer.valueOf(paramInt1));
        if (localObject == null) {
          break label471;
        }
        ((a)localObject).handle(paramInt2, paramIntent);
      }
    }
    label433:
    label471:
    for (paramIntent = Boolean.TRUE;; paramIntent = Boolean.FALSE)
    {
      if (!paramIntent.booleanValue()) {
        break label478;
      }
      AppMethodBeat.o(207434);
      return;
      if ((this.fXP != null) && (paramIntent.getExtras() != null))
      {
        localObject = paramIntent.getExtras().getString("click_other_verify_btn");
        if ((bs.isNullOrNil((String)localObject)) || (!((String)localObject).equalsIgnoreCase("yes"))) {
          break label433;
        }
      }
      for (i = 1;; i = 0)
      {
        ac.i("MicroMsg.UIPageFragmentActivity", "isClickOtherVerify: %s", new Object[] { localObject });
        if (i != 0)
        {
          ac.i("MicroMsg.UIPageFragmentActivity", "check face failed, click other verify");
          this.fXP.call(true, "", j, "");
          this.fXP = null;
        }
        if (paramInt2 != 0) {
          break;
        }
        ac.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_CANCELED");
        if (this.fXQ == null) {
          break;
        }
        this.fXQ.call();
        this.fXQ = null;
        break;
      }
      if ((this.fXO == null) || (!this.fXO.processCallback(paramInt1)) || (!adR())) {
        break;
      }
      finish();
      break;
    }
    label478:
    AppMethodBeat.o(207434);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(207431);
    ac.i("MicroMsg.UIPageFragmentActivity", "onBackPressed");
    if (!this.fXO.getCurrent().onBackPressed()) {
      popFragment();
    }
    AppMethodBeat.o(207431);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(207420);
    this.fXR = getIntent().getBooleanExtra("check_wallet_lock", false);
    ac.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", new Object[] { this });
    com.tencent.mm.plugin.report.service.h.wUl.dB(782, 37);
    this.fXS = aj.DT();
    ac.i("MicroMsg.UIPageFragmentActivity", "isDarkMode:%s", new Object[] { Boolean.valueOf(aj.DT()) });
    this.fXO = new FrLifeController(this);
    this.fXN = getIntent().getBooleanExtra("key_support_swipe_back", true);
    super.onCreate(paramBundle);
    if (this.kindaCacheService != null)
    {
      ac.i("MicroMsg.UIPageFragmentActivity", "force kindaShowingDialog is false");
      this.kindaCacheService.setBool("kindaShowingDialog", false, 0L);
    }
    if (this.fXR) {
      bool = ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    if (!bool) {
      p(getIntent().getBundleExtra("intent_bundle"));
    }
    setTenpayKBStateCallBackListener(new BaseFrActivity.IWalletTenpayKBStateCallBackListener()
    {
      public final void onCallBackKinda(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(207418);
        BaseFragment localBaseFragment = UIPageFragmentActivity.a(UIPageFragmentActivity.this).getCurrent();
        if (localBaseFragment != null)
        {
          if (paramAnonymousBoolean)
          {
            localBaseFragment.onKeyboardShow(true, 230);
            AppMethodBeat.o(207418);
            return;
          }
          localBaseFragment.onKeyboardShow(false, 230);
        }
        AppMethodBeat.o(207418);
      }
    });
    this.fxG = new com.tencent.mm.ui.tools.h(getContext());
    this.fxG.IRL = this;
    AppMethodBeat.o(207420);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(207426);
    super.onDestroy();
    KindaActionBarColorManager.getInstance().reset();
    com.tencent.mm.plugin.report.service.h.wUl.dB(782, 44);
    AppMethodBeat.o(207426);
  }
  
  public void onKeyboardStateChanged()
  {
    boolean bool = true;
    AppMethodBeat.i(207421);
    BaseFragment localBaseFragment = this.fXO.getCurrent();
    if (localBaseFragment != null) {
      if (keyboardState() != 1) {
        break label54;
      }
    }
    for (;;)
    {
      localBaseFragment.onKeyboardShow(bool, com.tencent.mm.cc.a.ax(getContext(), i.iv(getContext())));
      AppMethodBeat.o(207421);
      return;
      label54:
      bool = false;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(207425);
    ac.i("MicroMsg.UIPageFragmentActivity", "onPause");
    super.onPause();
    com.tencent.mm.plugin.report.service.h.wUl.dB(782, 42);
    com.tencent.mm.sdk.b.a.GpY.l(new ki());
    if (this.fxG != null) {
      this.fxG.close();
    }
    AppMethodBeat.o(207425);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(207438);
    boolean bool1 = paramBundle.getBoolean("key_dark_mode_state");
    boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbK, true);
    ac.i("MicroMsg.UIPageFragmentActivity", "onRestoreInstanceState，lastDarkMode:%s  nowDarkMode:%s,svgconfig:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(aj.DT()), Boolean.valueOf(bool2) });
    if ((bool2) && ((aj.DT() ^ bool1))) {
      finish();
    }
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(207438);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(207423);
    ac.i("MicroMsg.UIPageFragmentActivity", "onResume");
    super.onResume();
    if (this.fXR)
    {
      com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
      localb.a(this, localb.evh(), null);
    }
    com.tencent.mm.plugin.report.service.h.wUl.dB(782, 40);
    if ((this.fXO != null) && (this.fXO.processCallback(3)) && (adR())) {
      finish();
    }
    for (;;)
    {
      if (this.fxG != null) {
        this.fxG.start();
      }
      AppMethodBeat.o(207423);
      return;
      TenpaySecureEditText.setSalt(e.fAR());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(207437);
    paramBundle.putBoolean("key_dark_mode_state", this.fXS);
    ac.i("MicroMsg.UIPageFragmentActivity", "onSaveInstanceState，isDarkMode:%s", new Object[] { Boolean.valueOf(this.fXS) });
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(207437);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(207435);
    ac.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", new Object[] { Float.valueOf(paramFloat) });
    super.onSwipe(paramFloat);
    AppMethodBeat.o(207435);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(207432);
    ac.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", new Object[] { Boolean.valueOf(this.fXN), this });
    if (!this.fXN)
    {
      AppMethodBeat.o(207432);
      return;
    }
    super.onSwipeBack();
    AppMethodBeat.o(207432);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(207424);
    super.onWindowFocusChanged(paramBoolean);
    if (this.fxG != null) {
      this.fxG.start();
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(207424);
  }
  
  public final void p(Bundle paramBundle)
  {
    AppMethodBeat.i(207427);
    if (paramBundle == null)
    {
      AppMethodBeat.o(207427);
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
        this.fXO.startWebViewUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(207427);
        return;
      }
      if ((bool2) && ((localObject instanceof MainFragment)))
      {
        localObject = (MainFragment)localObject;
        this.fXO.startTinyAppUIPage(paramBundle, (MainFragment)localObject);
        AppMethodBeat.o(207427);
        return;
      }
      this.fXO.addFragment((BaseFragment)localObject);
      AppMethodBeat.o(207427);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(207427);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(207430);
    if (this.fXO.popFragment())
    {
      ac.i("MicroMsg.UIPageFragmentActivity", "popFragment, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(207430);
      return true;
    }
    ac.i("MicroMsg.UIPageFragmentActivity", "popFragment, finish the UIPageFragmentActivity.");
    finish();
    AppMethodBeat.o(207430);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(207429);
    if (this.fXO.removeModal(paramBaseFragment))
    {
      ac.i("MicroMsg.UIPageFragmentActivity", "removeModal, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(207429);
      return true;
    }
    ac.i("MicroMsg.UIPageFragmentActivity", "removeModal, hasOpenH5OrTinyApp: %b, kindaShowingDialog: %b", new Object[] { Boolean.valueOf(this.fXO.hasOpenH5OrTinyApp()), Boolean.valueOf(this.kindaCacheService.getBool("kindaShowingDialog")) });
    if ((!this.fXO.hasOpenH5OrTinyApp()) && (!this.kindaCacheService.getBool("kindaShowingDialog")))
    {
      ac.i("MicroMsg.UIPageFragmentActivity", "removeModal, finish the UIPageFragmentActivity.");
      finish();
    }
    AppMethodBeat.o(207429);
    return false;
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(207422);
    ac.d("MicroMsg.UIPageFragmentActivity", "onKeyboardHeightChanged %s", new Object[] { Integer.valueOf(paramInt) });
    BaseFragment localBaseFragment = this.fXO.getCurrent();
    if (localBaseFragment == null)
    {
      AppMethodBeat.o(207422);
      return;
    }
    if ((paramInt > 0) && (this.fXT <= 0))
    {
      this.fXT = paramInt;
      localBaseFragment.onKeyboardShow(true, com.tencent.mm.cc.a.ax(getContext(), paramInt));
      ac.d("MicroMsg.UIPageFragmentActivity", "show keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramInt <= 0) && (this.fXT > 0))
    {
      this.fXT = paramInt;
      localBaseFragment.onKeyboardShow(false, com.tencent.mm.cc.a.ax(getContext(), paramInt));
      ac.d("MicroMsg.UIPageFragmentActivity", "show keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(207422);
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