package com.tencent.mm.framework.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.kinda.framework.R.layout;
import com.tencent.kinda.framework.animate.KindaAnimatorWatch;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl;
import com.tencent.kinda.framework.widget.base.BaseFrActivity;
import com.tencent.kinda.framework.widget.base.BaseFrActivity.IWalletTenpayKBStateCallBackListener;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.FrLifeController;
import com.tencent.kinda.framework.widget.base.IEventFragment;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lz;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.OnPasswdInputListener;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEditText.EditState;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(7)
@c(0)
public class UIPageFragmentActivity
  extends BaseFrActivity
  implements IEventFragment, com.tencent.mm.ui.tools.h
{
  private static HashMap<Integer, UIPageFragmentActivity.a> jSw;
  private boolean cpt;
  public boolean jSn;
  private boolean jSo;
  public FrLifeController jSp;
  public VoidBoolStringI32StringCallback jSq;
  public VoidCallback jSr;
  private boolean jSs;
  private int jSt;
  private boolean jSu;
  public AtomicInteger jSv;
  private i jij;
  KindaCacheServiceImpl kindaCacheService;
  
  static
  {
    AppMethodBeat.i(264540);
    jSw = new HashMap();
    AppMethodBeat.o(264540);
  }
  
  public UIPageFragmentActivity()
  {
    AppMethodBeat.i(264508);
    this.jSn = true;
    this.jSq = null;
    this.jSr = null;
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.jSt = 0;
    this.jSu = false;
    this.jSv = new AtomicInteger(5);
    AppMethodBeat.o(264508);
  }
  
  public static void a(int paramInt, UIPageFragmentActivity.a parama)
  {
    AppMethodBeat.i(264527);
    jSw.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(264527);
  }
  
  private boolean aEq()
  {
    AppMethodBeat.i(264534);
    Object localObject = getKeyboard();
    final TenpaySecureEditText localTenpaySecureEditText = getTenpaySecureEditText();
    if ((localObject == null) || (localTenpaySecureEditText == null))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "Keyboard or EditText not found");
      AppMethodBeat.o(264534);
      return false;
    }
    UIPageFragmentActivity.b localb = new UIPageFragmentActivity.b((byte)0);
    ((MyKeyboardWindow)localObject).setOnTouchListener(localb);
    localObject = new UIPageFragmentActivity.2(this, localb);
    d.GxJ.a((com.tencent.mm.plugin.normsg.a.b)localObject);
    localTenpaySecureEditText.setOnPasswdInputListener(new OnPasswdInputListener()
    {
      public final void onDone()
      {
        AppMethodBeat.i(262792);
        if (localTenpaySecureEditText.getEditState() == TenpaySecureEditText.EditState.PASSWORD)
        {
          UIPageFragmentActivity.eH(true);
          AppMethodBeat.o(262792);
          return;
        }
        UIPageFragmentActivity.eH(false);
        AppMethodBeat.o(262792);
      }
    });
    AppMethodBeat.o(264534);
    return true;
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(264513);
    Log.d("MicroMsg.UIPageFragmentActivity", "onKeyboardHeightChanged %s", new Object[] { Integer.valueOf(paramInt) });
    BaseFragment localBaseFragment = this.jSp.getCurrent();
    if (localBaseFragment == null)
    {
      AppMethodBeat.o(264513);
      return;
    }
    if ((paramInt > 0) && (this.jSt <= 0))
    {
      this.jSt = paramInt;
      localBaseFragment.onKeyboardShow(true, com.tencent.mm.ci.a.H(getContext(), paramInt));
      Log.d("MicroMsg.UIPageFragmentActivity", "show keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramInt <= 0) && (this.jSt > 0))
    {
      this.jSt = paramInt;
      localBaseFragment.onKeyboardShow(false, com.tencent.mm.ci.a.H(getContext(), paramInt));
      Log.d("MicroMsg.UIPageFragmentActivity", "hide keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(264513);
  }
  
  public final void A(Bundle paramBundle)
  {
    AppMethodBeat.i(264520);
    if (paramBundle == null)
    {
      AppMethodBeat.o(264520);
      return;
    }
    BaseFragment localBaseFragment = ActivityController.resolveFragment(paramBundle);
    if ((localBaseFragment instanceof MainFragment)) {
      this.jSn = false;
    }
    if (localBaseFragment != null)
    {
      boolean bool1 = paramBundle.getBoolean("intent_webview", false);
      boolean bool2 = paramBundle.getBoolean("intent_tinyapp", false);
      MainFragment localMainFragment;
      if ((bool1) && ((localBaseFragment instanceof MainFragment)))
      {
        localMainFragment = (MainFragment)localBaseFragment;
        KindaAnimatorWatch.didViewCreated(localBaseFragment.hashCode());
        this.jSp.startWebViewUIPage(paramBundle, localMainFragment);
        AppMethodBeat.o(264520);
        return;
      }
      if ((bool2) && ((localBaseFragment instanceof MainFragment)))
      {
        localMainFragment = (MainFragment)localBaseFragment;
        KindaAnimatorWatch.didViewCreated(localBaseFragment.hashCode());
        this.jSp.startTinyAppUIPage(paramBundle, localMainFragment);
        AppMethodBeat.o(264520);
        return;
      }
      this.jSp.addFragment(localBaseFragment);
      AppMethodBeat.o(264520);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(264520);
  }
  
  public final boolean aEp()
  {
    AppMethodBeat.i(264530);
    if (this.jSp == null) {
      Log.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, controller is null!");
    }
    while ((this.jSp != null) && (this.jSp.getFragmentListSize() == 0))
    {
      AppMethodBeat.o(264530);
      return true;
      Log.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, fragment size: ", new Object[] { Integer.valueOf(this.jSp.getFragmentListSize()) });
    }
    AppMethodBeat.o(264530);
    return false;
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(264522);
    Log.i("MicroMsg.UIPageFragmentActivity", "addFragment: ".concat(String.valueOf(paramBaseFragment)));
    if ((paramBaseFragment instanceof MainFragment)) {
      this.jSn = false;
    }
    boolean bool = this.jSp.addFragment(paramBaseFragment);
    AppMethodBeat.o(264522);
    return bool;
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(264533);
    super.finish();
    Log.i("MicroMsg.UIPageFragmentActivity", "finish onlyModal:" + this.jSn);
    if (this.jSn) {
      super.overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(264533);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.layout.main_fragment_activity_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(264528);
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
        if ((this.jSq != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("token");
          this.jSq.call(false, (String)localObject, j, "");
          this.jSq = null;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.jSp != null) && (this.jSp.getFragmentListSize() <= 0))
      {
        finish();
        AppMethodBeat.o(264528);
        return;
        if ((this.jSq != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("click_other_verify_btn");
          if ((Util.isNullOrNil((String)localObject)) || (!((String)localObject).equalsIgnoreCase("yes"))) {
            break label421;
          }
        }
        label421:
        for (i = 1;; i = 0)
        {
          Log.i("MicroMsg.UIPageFragmentActivity", "isClickOtherVerify: %s", new Object[] { localObject });
          if (i != 0)
          {
            Log.i("MicroMsg.UIPageFragmentActivity", "check face failed, click other verify");
            this.jSq.call(true, "", j, "");
            this.jSq = null;
          }
          if (paramInt2 != 0) {
            break;
          }
          Log.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_CANCELED");
          if (this.jSr == null) {
            break;
          }
          this.jSr.call();
          this.jSr = null;
          break;
        }
        i = j;
        if (this.jSp != null)
        {
          i = j;
          if (this.jSp.processCallback(paramInt1))
          {
            i = j;
            if (aEp())
            {
              finish();
              AppMethodBeat.o(264528);
              return;
            }
          }
        }
      }
    }
    if (i == 0)
    {
      localObject = (UIPageFragmentActivity.a)jSw.get(Integer.valueOf(paramInt1));
      if (localObject != null) {
        ((UIPageFragmentActivity.a)localObject).handle(paramInt2, paramIntent);
      }
      for (paramIntent = Boolean.TRUE; paramIntent.booleanValue(); paramIntent = Boolean.FALSE)
      {
        AppMethodBeat.o(264528);
        return;
      }
    }
    AppMethodBeat.o(264528);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(264525);
    Log.i("MicroMsg.UIPageFragmentActivity", "onBackPressed");
    if (!this.jSp.getCurrent().onBackPressed()) {
      popFragment();
    }
    AppMethodBeat.o(264525);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(264510);
    this.jSs = getIntent().getBooleanExtra("check_wallet_lock", false);
    Log.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", new Object[] { this });
    com.tencent.mm.plugin.report.service.h.IzE.el(782, 37);
    this.cpt = ar.isDarkMode();
    Log.i("MicroMsg.UIPageFragmentActivity", "isDarkMode:%s", new Object[] { Boolean.valueOf(ar.isDarkMode()) });
    this.jSp = new FrLifeController(this);
    this.jSo = getIntent().getBooleanExtra("key_support_swipe_back", true);
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    hideTitleView();
    getController().setStatusBarColor(0);
    if (this.kindaCacheService != null)
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "force kindaShowingDialog is false");
      this.kindaCacheService.setBool("kindaShowingDialog", false, 0L);
    }
    if (this.jSs) {
      bool = ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    if (!bool) {
      A(getIntent().getBundleExtra("intent_bundle"));
    }
    setTenpayKBStateCallBackListener(new BaseFrActivity.IWalletTenpayKBStateCallBackListener()
    {
      public final void onCallBackKinda(boolean paramAnonymousBoolean, float paramAnonymousFloat)
      {
        AppMethodBeat.i(264832);
        BaseFragment localBaseFragment = UIPageFragmentActivity.a(UIPageFragmentActivity.this).getCurrent();
        float f = paramAnonymousFloat;
        if (paramAnonymousFloat == 0.0F) {
          f = 230.0F;
        }
        if (localBaseFragment != null) {
          if (paramAnonymousBoolean)
          {
            localBaseFragment.onKeyboardShow(true, com.tencent.mm.ci.a.H(UIPageFragmentActivity.this.getContext(), (int)f));
            if (!UIPageFragmentActivity.b(UIPageFragmentActivity.this))
            {
              UIPageFragmentActivity.a(UIPageFragmentActivity.this, UIPageFragmentActivity.c(UIPageFragmentActivity.this));
              AppMethodBeat.o(264832);
            }
          }
          else
          {
            localBaseFragment.onKeyboardShow(false, com.tencent.mm.ci.a.H(UIPageFragmentActivity.this.getContext(), (int)f));
          }
        }
        AppMethodBeat.o(264832);
      }
    });
    this.jij = new i(getContext());
    this.jij.XSx = this;
    AppMethodBeat.o(264510);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(264519);
    super.onDestroy();
    this.jSp.onActivityDestroy();
    com.tencent.mm.plugin.report.service.h.IzE.el(782, 44);
    d.GxJ.vK(false);
    AppMethodBeat.o(264519);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(264518);
    Log.i("MicroMsg.UIPageFragmentActivity", "onPause");
    super.onPause();
    com.tencent.mm.plugin.report.service.h.IzE.el(782, 42);
    EventCenter.instance.publish(new lz());
    if (this.jij != null) {
      this.jij.close();
    }
    AppMethodBeat.o(264518);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(264532);
    boolean bool1 = paramBundle.getBoolean("key_dark_mode_state");
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWO, true);
    Log.i("MicroMsg.UIPageFragmentActivity", "onRestoreInstanceState，lastDarkMode:%s  nowDarkMode:%s,svgconfig:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(ar.isDarkMode()), Boolean.valueOf(bool2) });
    if ((bool2) && ((ar.isDarkMode() ^ bool1))) {
      finish();
    }
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(264532);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(264514);
    Log.i("MicroMsg.UIPageFragmentActivity", "onResume");
    super.onResume();
    if (this.jSs)
    {
      com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class);
      localb.a(this, localb.gNk(), null);
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(782, 40);
    if ((this.jSp != null) && (this.jSp.processCallback(3)) && (aEp())) {
      finish();
    }
    for (;;)
    {
      if (this.jij != null) {
        this.jij.start();
      }
      this.jSp.setTinyCallbackTag(true);
      AppMethodBeat.o(264514);
      return;
      TenpaySecureEditText.setSalt(g.ijw());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(264531);
    paramBundle.putBoolean("key_dark_mode_state", this.cpt);
    Log.i("MicroMsg.UIPageFragmentActivity", "onSaveInstanceState，isDarkMode:%s", new Object[] { Boolean.valueOf(this.cpt) });
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(264531);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(264529);
    Log.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", new Object[] { Float.valueOf(paramFloat) });
    super.onSwipe(paramFloat);
    AppMethodBeat.o(264529);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(264526);
    Log.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", new Object[] { Boolean.valueOf(this.jSo), this });
    if (!this.jSo)
    {
      AppMethodBeat.o(264526);
      return;
    }
    super.onSwipeBack();
    AppMethodBeat.o(264526);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(264515);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(264515);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(264524);
    if (this.jSp.popFragment())
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "popFragment, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(264524);
      return true;
    }
    Log.i("MicroMsg.UIPageFragmentActivity", "popFragment, finish the UIPageFragmentActivity.");
    finish();
    AppMethodBeat.o(264524);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(264523);
    if (this.jSp.removeModal(paramBaseFragment))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(264523);
      return true;
    }
    Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, hasOpenH5OrTinyApp: %b, kindaShowingDialog: %b", new Object[] { Boolean.valueOf(this.jSp.hasOpenH5OrTinyApp()), Boolean.valueOf(this.kindaCacheService.getBool("kindaShowingDialog")) });
    if ((!this.jSp.hasOpenH5OrTinyApp()) && (!this.kindaCacheService.getBool("kindaShowingDialog")))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, finish the UIPageFragmentActivity.");
      finish();
    }
    AppMethodBeat.o(264523);
    return false;
  }
  
  public BaseFragment topShowFragment()
  {
    AppMethodBeat.i(264512);
    if (this.jSp == null)
    {
      AppMethodBeat.o(264512);
      return null;
    }
    BaseFragment localBaseFragment = BaseFrActivity.topShowFragmentOf(this.jSp.getFragmentList());
    AppMethodBeat.o(264512);
    return localBaseFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.framework.app.UIPageFragmentActivity
 * JD-Core Version:    0.7.0.1
 */