package com.tencent.mm.framework.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.h.a.f;
import com.tencent.h.a.g;
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
import com.tencent.mm.autogen.a.nf;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.y;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.MyKeyboardWindow.OnTouchListener;
import com.tenpay.android.wechat.OnPasswdInputListener;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEditText.EditState;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(7)
@e.b
@com.tencent.mm.ui.widget.pulldown.c(0)
public class UIPageFragmentActivity
  extends BaseFrActivity
  implements IEventFragment, com.tencent.mm.ui.tools.h
{
  private static HashMap<Integer, a> msN;
  private boolean ehd;
  KindaCacheServiceImpl kindaCacheService;
  private com.tencent.mm.ui.tools.i lKz;
  public boolean msE;
  private boolean msF;
  public FrLifeController msG;
  public VoidBoolStringI32StringCallback msH;
  public VoidCallback msI;
  private boolean msJ;
  private int msK;
  private boolean msL;
  public AtomicInteger msM;
  public boolean msO;
  
  static
  {
    AppMethodBeat.i(231319);
    msN = new HashMap();
    AppMethodBeat.o(231319);
  }
  
  public UIPageFragmentActivity()
  {
    AppMethodBeat.i(231293);
    this.msE = true;
    this.msH = null;
    this.msI = null;
    this.kindaCacheService = new KindaCacheServiceImpl();
    this.msK = 0;
    this.msL = false;
    this.msM = new AtomicInteger(5);
    this.msO = false;
    AppMethodBeat.o(231293);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(231297);
    msN.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(231297);
  }
  
  private boolean aXu()
  {
    AppMethodBeat.i(231303);
    Object localObject = getKeyboard();
    final TenpaySecureEditText localTenpaySecureEditText = getTenpaySecureEditText();
    if ((localObject == null) || (localTenpaySecureEditText == null))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "Keyboard or EditText not found");
      AppMethodBeat.o(231303);
      return false;
    }
    final b localb = new b((byte)0);
    ((MyKeyboardWindow)localObject).setOnTouchListener(localb);
    localObject = new com.tencent.mm.plugin.normsg.a.b()
    {
      public final boolean a(f paramAnonymousf)
      {
        UIPageFragmentActivity.b localb = localb;
        localb.msS = paramAnonymousf;
        localb.msT = this;
        return true;
      }
    };
    d.MtP.a((com.tencent.mm.plugin.normsg.a.b)localObject);
    localTenpaySecureEditText.setOnPasswdInputListener(new OnPasswdInputListener()
    {
      public final void onDone()
      {
        AppMethodBeat.i(231299);
        if (localTenpaySecureEditText.getEditState() == TenpaySecureEditText.EditState.PASSWORD)
        {
          UIPageFragmentActivity.fr(true);
          AppMethodBeat.o(231299);
          return;
        }
        UIPageFragmentActivity.fr(false);
        AppMethodBeat.o(231299);
      }
    });
    AppMethodBeat.o(231303);
    return true;
  }
  
  public final void H(Bundle paramBundle)
  {
    AppMethodBeat.i(231345);
    if (paramBundle == null)
    {
      AppMethodBeat.o(231345);
      return;
    }
    BaseFragment localBaseFragment = ActivityController.resolveFragment(paramBundle);
    if ((localBaseFragment instanceof MainFragment)) {
      this.msE = false;
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
        this.msG.startWebViewUIPage(paramBundle, localMainFragment);
        AppMethodBeat.o(231345);
        return;
      }
      if ((bool2) && ((localBaseFragment instanceof MainFragment)))
      {
        localMainFragment = (MainFragment)localBaseFragment;
        KindaAnimatorWatch.didViewCreated(localBaseFragment.hashCode());
        this.msG.startTinyAppUIPage(paramBundle, localMainFragment);
        AppMethodBeat.o(231345);
        return;
      }
      this.msG.addFragment(localBaseFragment);
      AppMethodBeat.o(231345);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(231345);
  }
  
  public final boolean aXt()
  {
    AppMethodBeat.i(231361);
    if (this.msG == null) {
      Log.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, controller is null!");
    }
    while ((this.msG != null) && (this.msG.getFragmentListSize() == 0))
    {
      AppMethodBeat.o(231361);
      return true;
      Log.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, fragment size: ", new Object[] { Integer.valueOf(this.msG.getFragmentListSize()) });
    }
    AppMethodBeat.o(231361);
    return false;
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(231347);
    Log.i("MicroMsg.UIPageFragmentActivity", "addFragment: ".concat(String.valueOf(paramBaseFragment)));
    if ((paramBaseFragment instanceof MainFragment)) {
      this.msE = false;
    }
    boolean bool = this.msG.addFragment(paramBaseFragment);
    AppMethodBeat.o(231347);
    return bool;
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(231366);
    super.finish();
    Log.i("MicroMsg.UIPageFragmentActivity", "finish onlyModal:" + this.msE);
    if (this.msE) {
      super.overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(231366);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.layout.main_fragment_activity_layout;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(231370);
    if ((this.msO) && (paramString != null) && (paramString.equals("location")))
    {
      AppMethodBeat.o(231370);
      return null;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(231370);
    return paramString;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(231357);
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
        if ((this.msH != null) && (paramIntent.getExtras() != null))
        {
          localObject = paramIntent.getExtras().getString("token");
          this.msH.call(false, (String)localObject, j, "");
          this.msH = null;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.msG != null) && (this.msG.getFragmentListSize() <= 0))
      {
        finish();
        AppMethodBeat.o(231357);
        return;
        if ((this.msH != null) && (paramIntent.getExtras() != null))
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
            this.msH.call(true, "", j, "");
            this.msH = null;
          }
          if (paramInt2 != 0) {
            break;
          }
          Log.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_CANCELED");
          if (this.msI == null) {
            break;
          }
          this.msI.call();
          this.msI = null;
          break;
        }
        i = j;
        if (this.msG != null)
        {
          i = j;
          if (this.msG.processCallback(paramInt1))
          {
            i = j;
            if (aXt())
            {
              finish();
              AppMethodBeat.o(231357);
              return;
            }
          }
        }
      }
    }
    if (i == 0)
    {
      localObject = (a)msN.get(Integer.valueOf(paramInt1));
      if (localObject != null) {
        ((a)localObject).handle(paramInt2, paramIntent);
      }
      for (paramIntent = Boolean.TRUE; paramIntent.booleanValue(); paramIntent = Boolean.FALSE)
      {
        AppMethodBeat.o(231357);
        return;
      }
    }
    AppMethodBeat.o(231357);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(231352);
    Log.i("MicroMsg.UIPageFragmentActivity", "onBackPressed");
    if (!this.msG.getCurrent().onBackPressed()) {
      popFragment();
    }
    AppMethodBeat.o(231352);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(231324);
    this.msJ = getIntent().getBooleanExtra("check_wallet_lock", false);
    Log.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", new Object[] { this });
    com.tencent.mm.plugin.report.service.h.OAn.kJ(782, 37);
    this.ehd = aw.isDarkMode();
    Log.i("MicroMsg.UIPageFragmentActivity", "isDarkMode:%s", new Object[] { Boolean.valueOf(aw.isDarkMode()) });
    this.msG = new FrLifeController(this);
    this.msF = getIntent().getBooleanExtra("key_support_swipe_back", true);
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    hideTitleView();
    getController().setStatusBarColor(0);
    if (this.kindaCacheService != null)
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "force kindaShowingDialog is false");
      this.kindaCacheService.setBool("kindaShowingDialog", false, 0L);
    }
    if (this.msJ) {
      bool = ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    if (!bool) {
      H(getIntent().getBundleExtra("intent_bundle"));
    }
    setTenpayKBStateCallBackListener(new BaseFrActivity.IWalletTenpayKBStateCallBackListener()
    {
      public final void onCallBackKinda(boolean paramAnonymousBoolean, float paramAnonymousFloat)
      {
        AppMethodBeat.i(231294);
        BaseFragment localBaseFragment = UIPageFragmentActivity.a(UIPageFragmentActivity.this).getCurrent();
        if (paramAnonymousFloat <= 0.0F) {
          paramAnonymousFloat = 230.0F;
        }
        while (localBaseFragment != null) {
          if (paramAnonymousBoolean)
          {
            localBaseFragment.onKeyboardShow(true, (int)paramAnonymousFloat);
            if (!UIPageFragmentActivity.b(UIPageFragmentActivity.this))
            {
              UIPageFragmentActivity.a(UIPageFragmentActivity.this, UIPageFragmentActivity.c(UIPageFragmentActivity.this));
              AppMethodBeat.o(231294);
              return;
              paramAnonymousFloat = com.tencent.mm.cd.a.K(UIPageFragmentActivity.this.getContext(), (int)paramAnonymousFloat);
            }
          }
          else
          {
            localBaseFragment.onKeyboardShow(false, (int)paramAnonymousFloat);
          }
        }
        AppMethodBeat.o(231294);
      }
    });
    this.lKz = new com.tencent.mm.ui.tools.i(getContext());
    this.lKz.afIL = this;
    AppMethodBeat.o(231324);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(231343);
    super.onDestroy();
    this.msG.onActivityDestroy();
    com.tencent.mm.plugin.report.service.h.OAn.kJ(782, 44);
    d.MtP.Ag(false);
    AppMethodBeat.o(231343);
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(231330);
    Log.d("MicroMsg.UIPageFragmentActivity", "onKeyboardHeightChanged %s", new Object[] { Integer.valueOf(paramInt) });
    BaseFragment localBaseFragment = this.msG.getCurrent();
    if (localBaseFragment == null)
    {
      AppMethodBeat.o(231330);
      return;
    }
    if ((paramInt > 0) && (this.msK <= 0))
    {
      this.msK = paramInt;
      localBaseFragment.onKeyboardShow(true, com.tencent.mm.cd.a.K(getContext(), paramInt));
      Log.d("MicroMsg.UIPageFragmentActivity", "show keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramInt <= 0) && (this.msK > 0))
    {
      this.msK = paramInt;
      localBaseFragment.onKeyboardShow(false, com.tencent.mm.cd.a.K(getContext(), paramInt));
      Log.d("MicroMsg.UIPageFragmentActivity", "hide keyboard %s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(231330);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(231339);
    Log.i("MicroMsg.UIPageFragmentActivity", "onPause");
    super.onPause();
    com.tencent.mm.plugin.report.service.h.OAn.kJ(782, 42);
    new nf().publish();
    if (this.lKz != null) {
      this.lKz.close();
    }
    AppMethodBeat.o(231339);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(231364);
    boolean bool1 = paramBundle.getBoolean("key_dark_mode_state");
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpt, true);
    Log.i("MicroMsg.UIPageFragmentActivity", "onRestoreInstanceState，lastDarkMode:%s  nowDarkMode:%s,svgconfig:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(aw.isDarkMode()), Boolean.valueOf(bool2) });
    if ((bool2) && ((aw.isDarkMode() ^ bool1))) {
      finish();
    }
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(231364);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(231335);
    Log.i("MicroMsg.UIPageFragmentActivity", "onResume");
    super.onResume();
    if (this.msJ)
    {
      com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class);
      localb.a(this, localb.imz(), null);
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(782, 40);
    if ((this.msG != null) && (this.msG.processCallback(3)) && (aXt())) {
      finish();
    }
    for (;;)
    {
      if (this.lKz != null) {
        this.lKz.start();
      }
      this.msG.setTinyCallbackTag(true);
      AppMethodBeat.o(231335);
      return;
      TenpaySecureEditText.setSalt(com.tencent.mm.wallet_core.ui.i.jPu());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(231362);
    paramBundle.putBoolean("key_dark_mode_state", this.ehd);
    Log.i("MicroMsg.UIPageFragmentActivity", "onSaveInstanceState，isDarkMode:%s", new Object[] { Boolean.valueOf(this.ehd) });
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(231362);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(231359);
    Log.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", new Object[] { Float.valueOf(paramFloat) });
    super.onSwipe(paramFloat);
    AppMethodBeat.o(231359);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(231355);
    Log.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", new Object[] { Boolean.valueOf(this.msF), this });
    if (!this.msF)
    {
      AppMethodBeat.o(231355);
      return;
    }
    super.onSwipeBack();
    AppMethodBeat.o(231355);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(231337);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(231337);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(231350);
    if (this.msG.popFragment())
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "popFragment, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(231350);
      return true;
    }
    Log.i("MicroMsg.UIPageFragmentActivity", "popFragment, finish the UIPageFragmentActivity.");
    finish();
    AppMethodBeat.o(231350);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(231348);
    if (this.msG.removeModal(paramBaseFragment))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, There is still Fragment, and UIPageFragmentActivity hold.");
      AppMethodBeat.o(231348);
      return true;
    }
    Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, hasOpenH5OrTinyApp: %b, kindaShowingDialog: %b", new Object[] { Boolean.valueOf(this.msG.hasOpenH5OrTinyApp()), Boolean.valueOf(this.kindaCacheService.getBool("kindaShowingDialog")) });
    if ((!this.msG.hasOpenH5OrTinyApp()) && (!this.kindaCacheService.getBool("kindaShowingDialog")))
    {
      Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, finish the UIPageFragmentActivity.");
      finish();
    }
    AppMethodBeat.o(231348);
    return false;
  }
  
  public BaseFragment topShowFragment()
  {
    AppMethodBeat.i(231328);
    if (this.msG == null)
    {
      AppMethodBeat.o(231328);
      return null;
    }
    BaseFragment localBaseFragment = BaseFrActivity.topShowFragmentOf(this.msG.getFragmentList());
    AppMethodBeat.o(231328);
    return localBaseFragment;
  }
  
  public static abstract interface a
  {
    public abstract void handle(int paramInt, Intent paramIntent);
  }
  
  static final class b
    implements MyKeyboardWindow.OnTouchListener
  {
    f msS;
    g msT;
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(231295);
      if (this.msS != null) {
        this.msS.a(this.msT, paramMotionEvent);
      }
      AppMethodBeat.o(231295);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.framework.app.UIPageFragmentActivity
 * JD-Core Version:    0.7.0.1
 */