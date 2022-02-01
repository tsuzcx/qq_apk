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
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIPagePlatformFuncDelegate;
import com.tencent.kinda.gen.VoidBoolI32Callback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import java.util.List;

public class UIPagePlatformFuncDelegateImpl
  implements IUIPagePlatformFuncDelegate
{
  private static final String TAG = "UIPagePlatformFuncDelegateImpl";
  private MMFragment activity;
  private Dialog mTipDialog = null;
  private String mmTitle = "";
  private VoidBoolI32Callback onKeyboardShowCallback;
  private VoidCallback topLeftBtnCallback;
  private VoidCallback topRightBtnCallback;
  private String topRightBtnColor;
  private int topRightBtnResId = -1;
  private String topRightBtnTitle;
  
  public UIPagePlatformFuncDelegateImpl(MMActivity paramMMActivity) {}
  
  public UIPagePlatformFuncDelegateImpl(MMFragment paramMMFragment)
  {
    this.activity = paramMMFragment;
  }
  
  private void recreateTopRightBtn()
  {
    AppMethodBeat.i(18603);
    this.activity.removeAllOptionMenu();
    Object localObject1 = null;
    if (this.topRightBtnResId > 0)
    {
      localDrawable = this.activity.getResources().getDrawable(this.topRightBtnResId);
      localObject1 = localDrawable;
      if (localDrawable != null)
      {
        localObject1 = localDrawable;
        if (bs.isNullOrNil(this.topRightBtnColor)) {}
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
    this.activity.addIconOptionMenu(1, this.topRightBtnTitle, localObject1, new MenuItem.OnMenuItemClickListener()
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
    this.activity.getWindow().addFlags(16);
    AppMethodBeat.o(18598);
  }
  
  public void closeUI(boolean paramBoolean)
  {
    AppMethodBeat.i(207381);
    if ((this.activity instanceof BaseFragment)) {
      ((BaseFragment)this.activity).popFragment();
    }
    AppMethodBeat.o(207381);
  }
  
  public void endEditing()
  {
    AppMethodBeat.i(18605);
    this.activity.hideVKB();
    if (this.activity.getActivity() != null)
    {
      View localView = getKBLayout(this.activity.getActivity());
      if ((localView != null) && (localView.isShown())) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(18605);
  }
  
  public void endIgnoringInteractionEvents()
  {
    AppMethodBeat.i(18599);
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18591);
        UIPagePlatformFuncDelegateImpl.this.activity.getWindow().clearFlags(16);
        AppMethodBeat.o(18591);
      }
    });
    AppMethodBeat.o(18599);
  }
  
  protected View getKBLayout(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(207382);
    int i = paramFragmentActivity.getSupportFragmentManager().getFragments().size();
    if (i <= 0)
    {
      paramFragmentActivity = paramFragmentActivity.findViewById(2131305693);
      AppMethodBeat.o(207382);
      return paramFragmentActivity;
    }
    paramFragmentActivity = ((BaseFragment)paramFragmentActivity.getSupportFragmentManager().getFragments().get(i - 1)).findViewById(2131305693);
    AppMethodBeat.o(207382);
    return paramFragmentActivity;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(18596);
    String str = this.activity.getMMTitle();
    AppMethodBeat.o(18596);
    return str;
  }
  
  public void onKeyboardShow(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(207383);
    if (this.onKeyboardShowCallback != null) {
      this.onKeyboardShowCallback.call(paramBoolean, paramInt);
    }
    AppMethodBeat.o(207383);
  }
  
  public void refreshNavigationBar() {}
  
  public void reset()
  {
    AppMethodBeat.i(18604);
    this.activity.setMMNormalView();
    if (!bs.isNullOrNil(this.mmTitle)) {
      this.activity.setMMTitle(this.mmTitle);
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
    this.activity.setMMTitle(paramString);
    this.mmTitle = paramString;
    AppMethodBeat.o(18595);
  }
  
  public void setTopLeftBackBtnCallbackImpl(final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18600);
    this.topLeftBtnCallback = paramVoidCallback;
    this.activity.setBackBtn(new MenuItem.OnMenuItemClickListener()
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
    if (!bs.isNullOrNil(paramString))
    {
      this.topRightBtnResId = ResourcesUtils.getDrawableId(this.activity.getContext(), paramString);
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
    AppMethodBeat.i(207384);
    if (this.activity.getActivity().getWindow() != null)
    {
      if (paramBoolean)
      {
        this.activity.getActivity().getWindow().setSoftInputMode(19);
        AppMethodBeat.o(207384);
        return;
      }
      this.activity.getActivity().getWindow().setSoftInputMode(35);
    }
    AppMethodBeat.o(207384);
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
      ac.e("UIPagePlatformFuncDelegateImpl", "IUIPagePlatformFuncDelegate can't startLoading because the activity is null!");
      AppMethodBeat.o(18607);
      return;
    }
    this.mTipDialog = com.tencent.mm.wallet_core.ui.g.b(paramString, paramString.getString(2131765693), true, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(18594);
        if ((UIPagePlatformFuncDelegateImpl.this.mTipDialog != null) && (UIPagePlatformFuncDelegateImpl.this.mTipDialog.isShowing())) {
          UIPagePlatformFuncDelegateImpl.this.mTipDialog.dismiss();
        }
        AppMethodBeat.o(18594);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl
 * JD-Core Version:    0.7.0.1
 */