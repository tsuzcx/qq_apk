package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIPagePlatformFuncDelegate;
import com.tencent.kinda.gen.VoidBoolI32Callback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.c;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import java.lang.ref.WeakReference;

public class UIPagePlatformFuncDelegateImpl
  implements IUIPagePlatformFuncDelegate
{
  private static final String TAG = "UIPagePlatformFuncDelegateImpl";
  private c mAndroidBug5497Workaround;
  private Dialog mTipDialog;
  private String mmTitle;
  private VoidBoolI32Callback onKeyboardShowCallback;
  private VoidCallback topLeftBtnCallback;
  private VoidCallback topRightBtnCallback;
  private String topRightBtnColor;
  private int topRightBtnResId;
  private String topRightBtnTitle;
  private WeakReference<MMFragment> weakFragment;
  
  public UIPagePlatformFuncDelegateImpl(MMFragment paramMMFragment)
  {
    AppMethodBeat.i(262968);
    this.topRightBtnResId = -1;
    this.mmTitle = "";
    this.mTipDialog = null;
    this.weakFragment = new WeakReference(paramMMFragment);
    AppMethodBeat.o(262968);
  }
  
  private void recreateTopRightBtn()
  {
    AppMethodBeat.i(18603);
    MMFragment localMMFragment = (MMFragment)this.weakFragment.get();
    if (localMMFragment == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(18603);
      return;
    }
    localMMFragment.removeAllOptionMenu();
    Object localObject1 = null;
    if (this.topRightBtnResId > 0)
    {
      localDrawable = localMMFragment.getResources().getDrawable(this.topRightBtnResId);
      localObject1 = localDrawable;
      if (localDrawable != null)
      {
        localObject1 = localDrawable;
        if (Util.isNullOrNil(this.topRightBtnColor)) {}
      }
    }
    try
    {
      localDrawable.setColorFilter(Color.parseColor(this.topRightBtnColor), PorterDuff.Mode.SRC_ATOP);
      localObject1 = localDrawable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localDrawable;
      }
    }
    localMMFragment.addIconOptionMenu(1, this.topRightBtnTitle, localObject1, new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(18593);
        if (UIPagePlatformFuncDelegateImpl.this.topRightBtnCallback != null)
        {
          UIPagePlatformFuncDelegateImpl.this.topRightBtnCallback.call();
          AppMethodBeat.o(18593);
          return true;
        }
        AppMethodBeat.o(18593);
        return false;
      }
    });
    AppMethodBeat.o(18603);
  }
  
  public void beginIgnoringInteractionEvents()
  {
    AppMethodBeat.i(18598);
    MMFragment localMMFragment = (MMFragment)this.weakFragment.get();
    if (localMMFragment == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(18598);
      return;
    }
    localMMFragment.getWindow().addFlags(16);
    AppMethodBeat.o(18598);
  }
  
  public void closeUI(boolean paramBoolean)
  {
    AppMethodBeat.i(262972);
    Object localObject = (MMFragment)this.weakFragment.get();
    if (localObject == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(262972);
      return;
    }
    if ((localObject instanceof BaseFragment))
    {
      localObject = (BaseFragment)localObject;
      if ((((BaseFragment)localObject).isTinyApp) && (((BaseFragment)localObject).tinyAppUserName != null)) {
        ((r)com.tencent.mm.kernel.h.ae(r.class)).ex(((BaseFragment)localObject).tinyAppUserName, "");
      }
      ((BaseFragment)localObject).popFragment();
    }
    AppMethodBeat.o(262972);
  }
  
  public void endEditing()
  {
    AppMethodBeat.i(18605);
    Object localObject = (MMFragment)this.weakFragment.get();
    if (localObject == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(18605);
      return;
    }
    ((MMFragment)localObject).hideVKB();
    if (((MMFragment)localObject).getActivity() != null)
    {
      localObject = getKBLayout();
      if ((localObject != null) && (((View)localObject).isShown())) {
        ((View)localObject).setVisibility(8);
      }
      localObject = getWcPayKeyboard();
      if (localObject != null)
      {
        ((WcPayKeyboard)localObject).hideWcKb();
        if (((WcPayKeyboard)localObject).mInputEditText != null) {
          ((WcPayKeyboard)localObject).mInputEditText.clearFocus();
        }
      }
    }
    AppMethodBeat.o(18605);
  }
  
  public void endIgnoringInteractionEvents()
  {
    AppMethodBeat.i(18599);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18591);
        MMFragment localMMFragment = (MMFragment)UIPagePlatformFuncDelegateImpl.this.weakFragment.get();
        if (localMMFragment == null)
        {
          Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
          AppMethodBeat.o(18591);
          return;
        }
        localMMFragment.getWindow().clearFlags(16);
        AppMethodBeat.o(18591);
      }
    });
    AppMethodBeat.o(18599);
  }
  
  protected View getKBLayout()
  {
    AppMethodBeat.i(262985);
    Object localObject = (MMFragment)this.weakFragment.get();
    if (localObject == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(262985);
      return null;
    }
    localObject = ((MMFragment)localObject).findViewById(R.id.tenpay_keyboard_layout);
    AppMethodBeat.o(262985);
    return localObject;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(18596);
    Object localObject = (MMFragment)this.weakFragment.get();
    if (localObject == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(18596);
      return "";
    }
    localObject = ((MMFragment)localObject).getMMTitle();
    AppMethodBeat.o(18596);
    return localObject;
  }
  
  protected WcPayKeyboard getWcPayKeyboard()
  {
    AppMethodBeat.i(262987);
    Object localObject = (MMFragment)this.weakFragment.get();
    if (localObject == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(262987);
      return null;
    }
    localObject = (WcPayKeyboard)((MMFragment)localObject).findViewById(R.id.wc_pay_keyboard);
    AppMethodBeat.o(262987);
    return localObject;
  }
  
  public void onKeyboardShow(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(262990);
    if (this.onKeyboardShowCallback != null) {
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(264046);
          UIPagePlatformFuncDelegateImpl.this.onKeyboardShowCallback.call(paramBoolean, paramInt);
          AppMethodBeat.o(264046);
        }
      }, 100L);
    }
    AppMethodBeat.o(262990);
  }
  
  public void refreshNavigationBar() {}
  
  public void reset()
  {
    AppMethodBeat.i(18604);
    MMFragment localMMFragment = (MMFragment)this.weakFragment.get();
    if (localMMFragment == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(18604);
      return;
    }
    localMMFragment.setMMNormalView();
    if (!Util.isNullOrNil(this.mmTitle)) {
      localMMFragment.setMMTitle(this.mmTitle);
    }
    recreateTopRightBtn();
    if (this.topLeftBtnCallback != null) {
      setTopLeftBackBtnCallbackImpl(this.topLeftBtnCallback);
    }
    AppMethodBeat.o(18604);
  }
  
  public void setBackgroundColor(DynamicColor paramDynamicColor) {}
  
  public void setKeyBoardShowCallbackImpl(VoidBoolI32Callback paramVoidBoolI32Callback)
  {
    this.onKeyboardShowCallback = paramVoidBoolI32Callback;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(18595);
    MMFragment localMMFragment = (MMFragment)this.weakFragment.get();
    if (localMMFragment == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(18595);
      return;
    }
    localMMFragment.setMMTitle(paramString);
    this.mmTitle = paramString;
    AppMethodBeat.o(18595);
  }
  
  public void setTopLeftBackBtnCallbackImpl(final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18600);
    this.topLeftBtnCallback = paramVoidCallback;
    MMFragment localMMFragment = (MMFragment)this.weakFragment.get();
    if (localMMFragment == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(18600);
      return;
    }
    localMMFragment.setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(18592);
        if (paramVoidCallback != null)
        {
          paramVoidCallback.call();
          AppMethodBeat.o(18592);
          return true;
        }
        AppMethodBeat.o(18592);
        return false;
      }
    });
    AppMethodBeat.o(18600);
  }
  
  public void setTopRightBtnImage(String paramString)
  {
    AppMethodBeat.i(18602);
    MMFragment localMMFragment = (MMFragment)this.weakFragment.get();
    if (localMMFragment == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(18602);
      return;
    }
    if (!Util.isNullOrNil(paramString))
    {
      this.topRightBtnResId = ResourcesUtils.getDrawableId(localMMFragment.getContext(), paramString);
      if (this.topRightBtnResId <= 0) {
        this.topRightBtnResId = ResourcesUtils.getResId(localMMFragment.getContext(), paramString, "raw");
      }
      recreateTopRightBtn();
    }
    AppMethodBeat.o(18602);
  }
  
  public void setTopRightBtnTitle(String paramString1, String paramString2)
  {
    this.topRightBtnTitle = paramString1;
    this.topRightBtnColor = paramString2;
  }
  
  public void setTopRightCallbackImpl(VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18601);
    this.topRightBtnCallback = paramVoidCallback;
    recreateTopRightBtn();
    AppMethodBeat.o(18601);
  }
  
  public void setWindowAdjustUnspecified(boolean paramBoolean)
  {
    AppMethodBeat.i(262996);
    Object localObject = (MMFragment)this.weakFragment.get();
    if (localObject == null)
    {
      Log.i("UIPagePlatformFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(262996);
      return;
    }
    if (((MMFragment)localObject).getActivity().getWindow() != null)
    {
      if (paramBoolean)
      {
        ((MMFragment)localObject).getActivity().getWindow().setSoftInputMode(19);
        this.mAndroidBug5497Workaround = c.bh(((MMFragment)localObject).getActivity());
        AppMethodBeat.o(262996);
        return;
      }
      ((MMFragment)localObject).getActivity().getWindow().setSoftInputMode(35);
      if (this.mAndroidBug5497Workaround != null)
      {
        localObject = this.mAndroidBug5497Workaround;
        ((c)localObject).VQp.getViewTreeObserver().removeOnGlobalLayoutListener(((c)localObject).qc);
        ((c)localObject).VQr.height = -1;
        ((c)localObject).VQp.requestLayout();
      }
    }
    AppMethodBeat.o(262996);
  }
  
  public void startLoading(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(18607);
    if (this.mTipDialog != null)
    {
      this.mTipDialog.show();
      AppMethodBeat.o(18607);
      return;
    }
    paramString = KindaContext.getTopOrUIPageFragmentActivity();
    if (paramString == null)
    {
      Log.e("UIPagePlatformFuncDelegateImpl", "IUIPagePlatformFuncDelegate can't startLoading because the activity is null!");
      AppMethodBeat.o(18607);
      return;
    }
    this.mTipDialog = com.tencent.mm.wallet_core.ui.i.c(paramString, paramString.getString(R.string.wallet_pay_loading), true, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(265237);
        if ((UIPagePlatformFuncDelegateImpl.this.mTipDialog != null) && (UIPagePlatformFuncDelegateImpl.this.mTipDialog.isShowing())) {
          UIPagePlatformFuncDelegateImpl.this.mTipDialog.dismiss();
        }
        AppMethodBeat.o(265237);
      }
    });
    this.mTipDialog.setCancelable(false);
    AppMethodBeat.o(18607);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(18608);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(18608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl
 * JD-Core Version:    0.7.0.1
 */