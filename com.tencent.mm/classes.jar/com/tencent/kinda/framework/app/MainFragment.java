package com.tencent.kinda.framework.app;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MainFragment
  extends BaseFragment
{
  public static final String TAG = "MicroMsg.MainFragment";
  private IUIPage page;
  
  private void initPage()
  {
    AppMethodBeat.i(144422);
    if (this.page != null)
    {
      this.page.setPlatformFuncDelegate(this.pagePlatformFuncDelegate);
      this.page.setPlatformDelegate(this.pagePlatformDelegate);
      covertPlatformData(getActivity().getIntent().getBundleExtra("key_platform_data"));
      initWithNavigationBarConfig(this.page.defaultNavigationBarConfig());
      ab.i("MicroMsg.MainFragment", "finish init page");
    }
    AppMethodBeat.o(144422);
  }
  
  public void attachPage(IUIPage paramIUIPage)
  {
    this.page = paramIUIPage;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(144430);
    super.finalize();
    ab.i("MicroMsg.MainFragment", "finalize " + this.page);
    AppMethodBeat.o(144430);
  }
  
  public int getIUIHashCode()
  {
    AppMethodBeat.i(144435);
    if (this.page != null)
    {
      int i = this.page.hashCode();
      AppMethodBeat.o(144435);
      return i;
    }
    AppMethodBeat.o(144435);
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2130969958;
  }
  
  public String getTagName()
  {
    return "MicroMsg.MainFragment";
  }
  
  public void initOnCreate()
  {
    AppMethodBeat.i(144428);
    initPage();
    if (this.page != null)
    {
      this.page.onCreate();
      initPageView();
    }
    AppMethodBeat.o(144428);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(144432);
    if (this.page != null)
    {
      this.page.onClickAndroidBack();
      AppMethodBeat.o(144432);
      return true;
    }
    AppMethodBeat.o(144432);
    return false;
  }
  
  public void onCreateLayout(PlatformWrapLayout paramPlatformWrapLayout)
  {
    AppMethodBeat.i(144429);
    this.page.onCreateLayout(paramPlatformWrapLayout);
    AppMethodBeat.o(144429);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(144427);
    super.onDestroy();
    if (this.page != null) {
      this.page.onDestroy();
    }
    this.page = null;
    AppMethodBeat.o(144427);
  }
  
  public void onKeyboardShow(boolean paramBoolean)
  {
    AppMethodBeat.i(144431);
    this.pagePlatformFuncDelegate.onKeyboardShow(paramBoolean);
    AppMethodBeat.o(144431);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(144426);
    super.onPause();
    AppMethodBeat.o(144426);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(144425);
    super.onResume();
    AppMethodBeat.o(144425);
  }
  
  public void setTopRightBtnImage(String paramString)
  {
    AppMethodBeat.i(144433);
    this.pagePlatformFuncDelegate.setTopRightBtnImage(paramString);
    AppMethodBeat.o(144433);
  }
  
  public void setTopRightBtnTitle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144434);
    this.pagePlatformFuncDelegate.setTopRightBtnTitle(paramString1, paramString2);
    AppMethodBeat.o(144434);
  }
  
  public void willActive()
  {
    AppMethodBeat.i(144423);
    super.willActive();
    if (this.page != null) {
      this.page.onVisible();
    }
    AppMethodBeat.o(144423);
  }
  
  public void willDeActive()
  {
    AppMethodBeat.i(144424);
    super.willDeActive();
    if (this.page != null) {
      this.page.onInvisible();
    }
    AppMethodBeat.o(144424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MainFragment
 * JD-Core Version:    0.7.0.1
 */