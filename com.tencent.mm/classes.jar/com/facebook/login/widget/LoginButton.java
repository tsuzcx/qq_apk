package com.facebook.login.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.support.v7.c.a.a;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.R.styleable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

public class LoginButton
  extends FacebookButtonBase
{
  private static final String TAG;
  private AccessTokenTracker accessTokenTracker;
  private boolean confirmLogout;
  private String loginLogoutEventName;
  private LoginManager loginManager;
  private String loginText;
  private String logoutText;
  private LoginButton.LoginButtonProperties properties;
  private boolean toolTipChecked;
  private long toolTipDisplayTime;
  private LoginButton.ToolTipMode toolTipMode;
  private ToolTipPopup toolTipPopup;
  private ToolTipPopup.Style toolTipStyle;
  
  static
  {
    AppMethodBeat.i(92687);
    TAG = LoginButton.class.getName();
    AppMethodBeat.o(92687);
  }
  
  public LoginButton(Context paramContext)
  {
    super(paramContext, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    AppMethodBeat.i(92647);
    this.properties = new LoginButton.LoginButtonProperties();
    this.loginLogoutEventName = "fb_login_view_usage";
    this.toolTipStyle = ToolTipPopup.Style.BLUE;
    this.toolTipDisplayTime = 6000L;
    AppMethodBeat.o(92647);
  }
  
  public LoginButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    AppMethodBeat.i(92648);
    this.properties = new LoginButton.LoginButtonProperties();
    this.loginLogoutEventName = "fb_login_view_usage";
    this.toolTipStyle = ToolTipPopup.Style.BLUE;
    this.toolTipDisplayTime = 6000L;
    AppMethodBeat.o(92648);
  }
  
  public LoginButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0, "fb_login_button_create", "fb_login_button_did_tap");
    AppMethodBeat.i(92649);
    this.properties = new LoginButton.LoginButtonProperties();
    this.loginLogoutEventName = "fb_login_view_usage";
    this.toolTipStyle = ToolTipPopup.Style.BLUE;
    this.toolTipDisplayTime = 6000L;
    AppMethodBeat.o(92649);
  }
  
  private void checkToolTipSettings()
  {
    AppMethodBeat.i(92668);
    switch (LoginButton.3.$SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[this.toolTipMode.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(92668);
      return;
      String str = Utility.getMetadataApplicationId(getContext());
      FacebookSdk.getExecutor().execute(new LoginButton.1(this, str));
      AppMethodBeat.o(92668);
      return;
      displayToolTip(getResources().getString(2131296327));
    }
  }
  
  private void displayToolTip(String paramString)
  {
    AppMethodBeat.i(92667);
    this.toolTipPopup = new ToolTipPopup(paramString, this);
    this.toolTipPopup.setStyle(this.toolTipStyle);
    this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
    this.toolTipPopup.show();
    AppMethodBeat.o(92667);
  }
  
  private int measureButtonWidth(String paramString)
  {
    AppMethodBeat.i(92677);
    int i = measureTextWidth(paramString);
    int j = getCompoundPaddingLeft();
    int k = getCompoundDrawablePadding();
    int m = getCompoundPaddingRight();
    AppMethodBeat.o(92677);
    return i + (j + k) + m;
  }
  
  private void parseLoginButtonAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92675);
    this.toolTipMode = LoginButton.ToolTipMode.DEFAULT;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_login_view, paramInt1, paramInt2);
    try
    {
      this.confirmLogout = paramContext.getBoolean(0, true);
      this.loginText = paramContext.getString(1);
      this.logoutText = paramContext.getString(2);
      this.toolTipMode = LoginButton.ToolTipMode.fromInt(paramContext.getInt(3, LoginButton.ToolTipMode.DEFAULT.getValue()));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(92675);
    }
  }
  
  private void setButtonText()
  {
    AppMethodBeat.i(92678);
    Resources localResources = getResources();
    if ((!isInEditMode()) && (AccessToken.isCurrentAccessTokenActive()))
    {
      if (this.logoutText != null) {}
      for (localObject = this.logoutText;; localObject = localResources.getString(2131296317))
      {
        setText((CharSequence)localObject);
        AppMethodBeat.o(92678);
        return;
      }
    }
    if (this.loginText != null)
    {
      setText(this.loginText);
      AppMethodBeat.o(92678);
      return;
    }
    String str = localResources.getString(2131296314);
    int i = getWidth();
    Object localObject = str;
    if (i != 0)
    {
      localObject = str;
      if (measureButtonWidth(str) > i) {
        localObject = localResources.getString(2131296313);
      }
    }
    setText((CharSequence)localObject);
    AppMethodBeat.o(92678);
  }
  
  private void showToolTipPerSettings(FetchedAppSettings paramFetchedAppSettings)
  {
    AppMethodBeat.i(92666);
    if ((paramFetchedAppSettings != null) && (paramFetchedAppSettings.getNuxEnabled()) && (getVisibility() == 0)) {
      displayToolTip(paramFetchedAppSettings.getNuxContent());
    }
    AppMethodBeat.o(92666);
  }
  
  public void clearPermissions()
  {
    AppMethodBeat.i(92656);
    this.properties.clearPermissions();
    AppMethodBeat.o(92656);
  }
  
  public void configureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92673);
    super.configureButton(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setInternalOnClickListener(getNewLoginClickListener());
    parseLoginButtonAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (isInEditMode())
    {
      setBackgroundColor(getResources().getColor(2131689893));
      this.loginText = "Continue with Facebook";
    }
    for (;;)
    {
      setButtonText();
      setCompoundDrawablesWithIntrinsicBounds(a.k(getContext(), 2130838430), null, null, null);
      AppMethodBeat.o(92673);
      return;
      this.accessTokenTracker = new LoginButton.2(this);
    }
  }
  
  public void dismissToolTip()
  {
    AppMethodBeat.i(92661);
    if (this.toolTipPopup != null)
    {
      this.toolTipPopup.dismiss();
      this.toolTipPopup = null;
    }
    AppMethodBeat.o(92661);
  }
  
  public String getAuthType()
  {
    AppMethodBeat.i(92659);
    String str = this.properties.getAuthType();
    AppMethodBeat.o(92659);
    return str;
  }
  
  public DefaultAudience getDefaultAudience()
  {
    AppMethodBeat.i(92651);
    DefaultAudience localDefaultAudience = this.properties.getDefaultAudience();
    AppMethodBeat.o(92651);
    return localDefaultAudience;
  }
  
  public int getDefaultRequestCode()
  {
    AppMethodBeat.i(92679);
    int i = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    AppMethodBeat.o(92679);
    return i;
  }
  
  public int getDefaultStyleResource()
  {
    return 2131493863;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    AppMethodBeat.i(92658);
    LoginBehavior localLoginBehavior = this.properties.getLoginBehavior();
    AppMethodBeat.o(92658);
    return localLoginBehavior;
  }
  
  LoginManager getLoginManager()
  {
    AppMethodBeat.i(92680);
    if (this.loginManager == null) {
      this.loginManager = LoginManager.getInstance();
    }
    LoginManager localLoginManager = this.loginManager;
    AppMethodBeat.o(92680);
    return localLoginManager;
  }
  
  protected LoginButton.LoginClickListener getNewLoginClickListener()
  {
    AppMethodBeat.i(92674);
    LoginButton.LoginClickListener localLoginClickListener = new LoginButton.LoginClickListener(this);
    AppMethodBeat.o(92674);
    return localLoginClickListener;
  }
  
  List<String> getPermissions()
  {
    AppMethodBeat.i(92672);
    List localList = this.properties.getPermissions();
    AppMethodBeat.o(92672);
    return localList;
  }
  
  public long getToolTipDisplayTime()
  {
    return this.toolTipDisplayTime;
  }
  
  public LoginButton.ToolTipMode getToolTipMode()
  {
    return this.toolTipMode;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(92664);
    super.onAttachedToWindow();
    if ((this.accessTokenTracker != null) && (!this.accessTokenTracker.isTracking()))
    {
      this.accessTokenTracker.startTracking();
      setButtonText();
    }
    AppMethodBeat.o(92664);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(92670);
    super.onDetachedFromWindow();
    if (this.accessTokenTracker != null) {
      this.accessTokenTracker.stopTracking();
    }
    dismissToolTip();
    AppMethodBeat.o(92670);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(92665);
    super.onDraw(paramCanvas);
    if ((!this.toolTipChecked) && (!isInEditMode()))
    {
      this.toolTipChecked = true;
      checkToolTipSettings();
    }
    AppMethodBeat.o(92665);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(92669);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    setButtonText();
    AppMethodBeat.o(92669);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92676);
    Object localObject = getPaint().getFontMetrics();
    paramInt2 = getCompoundPaddingTop();
    float f = Math.abs(((Paint.FontMetrics)localObject).top);
    int i = (int)Math.ceil(Math.abs(((Paint.FontMetrics)localObject).bottom) + f);
    int j = getCompoundPaddingBottom();
    Resources localResources = getResources();
    String str = this.loginText;
    localObject = str;
    if (str == null)
    {
      localObject = localResources.getString(2131296314);
      k = measureButtonWidth((String)localObject);
      if (resolveSize(k, paramInt1) < k) {
        localObject = localResources.getString(2131296313);
      }
    }
    int k = measureButtonWidth((String)localObject);
    str = this.logoutText;
    localObject = str;
    if (str == null) {
      localObject = localResources.getString(2131296317);
    }
    setMeasuredDimension(resolveSize(Math.max(k, measureButtonWidth((String)localObject)), paramInt1), j + (i + paramInt2));
    AppMethodBeat.o(92676);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(92671);
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      dismissToolTip();
    }
    AppMethodBeat.o(92671);
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    AppMethodBeat.i(92662);
    getLoginManager().registerCallback(paramCallbackManager, paramFacebookCallback);
    AppMethodBeat.o(92662);
  }
  
  public void setAuthType(String paramString)
  {
    AppMethodBeat.i(92660);
    this.properties.setAuthType(paramString);
    AppMethodBeat.o(92660);
  }
  
  public void setDefaultAudience(DefaultAudience paramDefaultAudience)
  {
    AppMethodBeat.i(92650);
    this.properties.setDefaultAudience(paramDefaultAudience);
    AppMethodBeat.o(92650);
  }
  
  public void setLoginBehavior(LoginBehavior paramLoginBehavior)
  {
    AppMethodBeat.i(92657);
    this.properties.setLoginBehavior(paramLoginBehavior);
    AppMethodBeat.o(92657);
  }
  
  void setLoginManager(LoginManager paramLoginManager)
  {
    this.loginManager = paramLoginManager;
  }
  
  void setProperties(LoginButton.LoginButtonProperties paramLoginButtonProperties)
  {
    this.properties = paramLoginButtonProperties;
  }
  
  public void setPublishPermissions(List<String> paramList)
  {
    AppMethodBeat.i(92654);
    this.properties.setPublishPermissions(paramList);
    AppMethodBeat.o(92654);
  }
  
  public void setPublishPermissions(String... paramVarArgs)
  {
    AppMethodBeat.i(92655);
    this.properties.setPublishPermissions(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(92655);
  }
  
  public void setReadPermissions(List<String> paramList)
  {
    AppMethodBeat.i(92652);
    this.properties.setReadPermissions(paramList);
    AppMethodBeat.o(92652);
  }
  
  public void setReadPermissions(String... paramVarArgs)
  {
    AppMethodBeat.i(92653);
    this.properties.setReadPermissions(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(92653);
  }
  
  public void setToolTipDisplayTime(long paramLong)
  {
    this.toolTipDisplayTime = paramLong;
  }
  
  public void setToolTipMode(LoginButton.ToolTipMode paramToolTipMode)
  {
    this.toolTipMode = paramToolTipMode;
  }
  
  public void setToolTipStyle(ToolTipPopup.Style paramStyle)
  {
    this.toolTipStyle = paramStyle;
  }
  
  public void unregisterCallback(CallbackManager paramCallbackManager)
  {
    AppMethodBeat.i(92663);
    getLoginManager().unregisterCallback(paramCallbackManager);
    AppMethodBeat.o(92663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.login.widget.LoginButton
 * JD-Core Version:    0.7.0.1
 */