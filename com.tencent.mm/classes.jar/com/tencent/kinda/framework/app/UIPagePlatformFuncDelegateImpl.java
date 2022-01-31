package com.tencent.kinda.framework.app;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.IUIPagePlatformFuncDelegate;
import com.tencent.kinda.gen.VoidBoolI32Callback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;

public class UIPagePlatformFuncDelegateImpl
  implements IUIPagePlatformFuncDelegate
{
  private MMFragment activity;
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
    AppMethodBeat.i(144495);
    this.activity.removeAllOptionMenu();
    Object localObject1 = null;
    if (this.topRightBtnResId > 0)
    {
      localDrawable = this.activity.getResources().getDrawable(this.topRightBtnResId);
      localObject1 = localDrawable;
      if (localDrawable != null)
      {
        localObject1 = localDrawable;
        if (bo.isNullOrNil(this.topRightBtnColor)) {}
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
    this.activity.addIconOptionMenu(1, this.topRightBtnTitle, localObject1, new UIPagePlatformFuncDelegateImpl.3(this));
    AppMethodBeat.o(144495);
  }
  
  public void beginIgnoringInteractionEvents()
  {
    AppMethodBeat.i(144490);
    this.activity.getWindow().addFlags(16);
    AppMethodBeat.o(144490);
  }
  
  public void closeUI()
  {
    AppMethodBeat.i(144489);
    if ((this.activity instanceof BaseFragment)) {
      ((BaseFragment)this.activity).popFragment();
    }
    AppMethodBeat.o(144489);
  }
  
  public void endEditing()
  {
    AppMethodBeat.i(144497);
    this.activity.hideVKB();
    AppMethodBeat.o(144497);
  }
  
  public void endIgnoringInteractionEvents()
  {
    AppMethodBeat.i(144491);
    new ak(Looper.getMainLooper()).post(new UIPagePlatformFuncDelegateImpl.1(this));
    AppMethodBeat.o(144491);
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(144488);
    String str = this.activity.getMMTitle();
    AppMethodBeat.o(144488);
    return str;
  }
  
  public void onKeyboardShow(boolean paramBoolean)
  {
    AppMethodBeat.i(144498);
    if (this.onKeyboardShowCallback != null) {
      this.onKeyboardShowCallback.call(paramBoolean, j.gI(this.activity.getContext()));
    }
    AppMethodBeat.o(144498);
  }
  
  public void refreshNavigationBar() {}
  
  public void reset()
  {
    AppMethodBeat.i(144496);
    this.activity.setMMNormalView();
    if (!bo.isNullOrNil(this.mmTitle)) {
      this.activity.setMMTitle(this.mmTitle);
    }
    recreateTopRightBtn();
    if (this.topLeftBtnCallback != null) {
      setTopLeftBackBtnCallbackImpl(this.topLeftBtnCallback);
    }
    AppMethodBeat.o(144496);
  }
  
  public void setBackgroundColor(long paramLong) {}
  
  public void setKeyBoardShowCallbackImpl(VoidBoolI32Callback paramVoidBoolI32Callback)
  {
    this.onKeyboardShowCallback = paramVoidBoolI32Callback;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(144487);
    this.activity.setMMTitle(paramString);
    this.mmTitle = paramString;
    AppMethodBeat.o(144487);
  }
  
  public void setTopLeftBackBtnCallbackImpl(final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144492);
    this.topLeftBtnCallback = paramVoidCallback;
    this.activity.setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(144485);
        if (paramVoidCallback != null)
        {
          paramVoidCallback.call();
          AppMethodBeat.o(144485);
          return true;
        }
        AppMethodBeat.o(144485);
        return false;
      }
    });
    AppMethodBeat.o(144492);
  }
  
  public void setTopRightBtnImage(String paramString)
  {
    AppMethodBeat.i(144494);
    if (!bo.isNullOrNil(paramString))
    {
      this.topRightBtnResId = ResourcesUtils.getDrawableId(this.activity.getContext(), paramString);
      recreateTopRightBtn();
    }
    AppMethodBeat.o(144494);
  }
  
  public void setTopRightBtnTitle(String paramString1, String paramString2)
  {
    this.topRightBtnTitle = paramString1;
    this.topRightBtnColor = paramString2;
  }
  
  public void setTopRightCallbackImpl(VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144493);
    this.topRightBtnCallback = paramVoidCallback;
    recreateTopRightBtn();
    AppMethodBeat.o(144493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl
 * JD-Core Version:    0.7.0.1
 */