package com.facebook.login.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.a.a.a;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.common.R.color;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.R.drawable;
import com.facebook.login.R.string;
import com.facebook.login.R.style;
import com.facebook.login.R.styleable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
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
  private LoginButtonProperties properties;
  private boolean toolTipChecked;
  private long toolTipDisplayTime;
  private ToolTipMode toolTipMode;
  private ToolTipPopup toolTipPopup;
  private ToolTipPopup.Style toolTipStyle;
  
  static
  {
    AppMethodBeat.i(40454);
    TAG = LoginButton.class.getName();
    AppMethodBeat.o(40454);
  }
  
  public LoginButton(Context paramContext)
  {
    super(paramContext, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    AppMethodBeat.i(40414);
    this.properties = new LoginButtonProperties();
    this.loginLogoutEventName = "fb_login_view_usage";
    this.toolTipStyle = ToolTipPopup.Style.BLUE;
    this.toolTipDisplayTime = 6000L;
    AppMethodBeat.o(40414);
  }
  
  public LoginButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    AppMethodBeat.i(40415);
    this.properties = new LoginButtonProperties();
    this.loginLogoutEventName = "fb_login_view_usage";
    this.toolTipStyle = ToolTipPopup.Style.BLUE;
    this.toolTipDisplayTime = 6000L;
    AppMethodBeat.o(40415);
  }
  
  public LoginButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0, "fb_login_button_create", "fb_login_button_did_tap");
    AppMethodBeat.i(40416);
    this.properties = new LoginButtonProperties();
    this.loginLogoutEventName = "fb_login_view_usage";
    this.toolTipStyle = ToolTipPopup.Style.BLUE;
    this.toolTipDisplayTime = 6000L;
    AppMethodBeat.o(40416);
  }
  
  private void checkToolTipSettings()
  {
    AppMethodBeat.i(40435);
    switch (3.$SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[this.toolTipMode.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40435);
      return;
      final String str = Utility.getMetadataApplicationId(getContext());
      FacebookSdk.getExecutor().execute(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(40399);
          final FetchedAppSettings localFetchedAppSettings = FetchedAppSettingsManager.queryAppSettings(str, false);
          LoginButton.access$100(LoginButton.this).runOnUiThread(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(40398);
              LoginButton.access$000(LoginButton.this, localFetchedAppSettings);
              AppMethodBeat.o(40398);
            }
          });
          AppMethodBeat.o(40399);
        }
      });
      AppMethodBeat.o(40435);
      return;
      displayToolTip(getResources().getString(R.string.com_facebook_tooltip_default));
    }
  }
  
  private void displayToolTip(String paramString)
  {
    AppMethodBeat.i(40434);
    this.toolTipPopup = new ToolTipPopup(paramString, this);
    this.toolTipPopup.setStyle(this.toolTipStyle);
    this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
    this.toolTipPopup.show();
    AppMethodBeat.o(40434);
  }
  
  private int measureButtonWidth(String paramString)
  {
    AppMethodBeat.i(40444);
    int i = measureTextWidth(paramString);
    int j = getCompoundPaddingLeft();
    int k = getCompoundDrawablePadding();
    int m = getCompoundPaddingRight();
    AppMethodBeat.o(40444);
    return i + (j + k) + m;
  }
  
  private void parseLoginButtonAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40442);
    this.toolTipMode = ToolTipMode.DEFAULT;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_login_view, paramInt1, paramInt2);
    try
    {
      this.confirmLogout = paramContext.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
      this.loginText = paramContext.getString(R.styleable.com_facebook_login_view_com_facebook_login_text);
      this.logoutText = paramContext.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text);
      this.toolTipMode = ToolTipMode.fromInt(paramContext.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.DEFAULT.getValue()));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(40442);
    }
  }
  
  private void setButtonText()
  {
    AppMethodBeat.i(40445);
    Resources localResources = getResources();
    if ((!isInEditMode()) && (AccessToken.isCurrentAccessTokenActive()))
    {
      if (this.logoutText != null) {}
      for (localObject = this.logoutText;; localObject = localResources.getString(R.string.com_facebook_loginview_log_out_button))
      {
        setText((CharSequence)localObject);
        AppMethodBeat.o(40445);
        return;
      }
    }
    if (this.loginText != null)
    {
      setText(this.loginText);
      AppMethodBeat.o(40445);
      return;
    }
    String str = localResources.getString(R.string.com_facebook_loginview_log_in_button_continue);
    int i = getWidth();
    Object localObject = str;
    if (i != 0)
    {
      localObject = str;
      if (measureButtonWidth(str) > i) {
        localObject = localResources.getString(R.string.com_facebook_loginview_log_in_button);
      }
    }
    setText((CharSequence)localObject);
    AppMethodBeat.o(40445);
  }
  
  private void showToolTipPerSettings(FetchedAppSettings paramFetchedAppSettings)
  {
    AppMethodBeat.i(40433);
    if ((paramFetchedAppSettings != null) && (paramFetchedAppSettings.getNuxEnabled()) && (getVisibility() == 0)) {
      displayToolTip(paramFetchedAppSettings.getNuxContent());
    }
    AppMethodBeat.o(40433);
  }
  
  public void clearPermissions()
  {
    AppMethodBeat.i(40423);
    this.properties.clearPermissions();
    AppMethodBeat.o(40423);
  }
  
  public void configureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40440);
    super.configureButton(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setInternalOnClickListener(getNewLoginClickListener());
    parseLoginButtonAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (isInEditMode())
    {
      setBackgroundColor(getResources().getColor(R.color.com_facebook_blue));
      this.loginText = "Continue with Facebook";
    }
    for (;;)
    {
      setButtonText();
      setCompoundDrawablesWithIntrinsicBounds(a.m(getContext(), R.drawable.com_facebook_button_login_logo), null, null, null);
      AppMethodBeat.o(40440);
      return;
      this.accessTokenTracker = new AccessTokenTracker()
      {
        public void onCurrentAccessTokenChanged(AccessToken paramAnonymousAccessToken1, AccessToken paramAnonymousAccessToken2)
        {
          AppMethodBeat.i(40400);
          LoginButton.access$200(LoginButton.this);
          AppMethodBeat.o(40400);
        }
      };
    }
  }
  
  public void dismissToolTip()
  {
    AppMethodBeat.i(40428);
    if (this.toolTipPopup != null)
    {
      this.toolTipPopup.dismiss();
      this.toolTipPopup = null;
    }
    AppMethodBeat.o(40428);
  }
  
  public String getAuthType()
  {
    AppMethodBeat.i(40426);
    String str = this.properties.getAuthType();
    AppMethodBeat.o(40426);
    return str;
  }
  
  public DefaultAudience getDefaultAudience()
  {
    AppMethodBeat.i(40418);
    DefaultAudience localDefaultAudience = this.properties.getDefaultAudience();
    AppMethodBeat.o(40418);
    return localDefaultAudience;
  }
  
  public int getDefaultRequestCode()
  {
    AppMethodBeat.i(40446);
    int i = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    AppMethodBeat.o(40446);
    return i;
  }
  
  public int getDefaultStyleResource()
  {
    return R.style.com_facebook_loginview_default_style;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    AppMethodBeat.i(40425);
    LoginBehavior localLoginBehavior = this.properties.getLoginBehavior();
    AppMethodBeat.o(40425);
    return localLoginBehavior;
  }
  
  LoginManager getLoginManager()
  {
    AppMethodBeat.i(40447);
    if (this.loginManager == null) {
      this.loginManager = LoginManager.getInstance();
    }
    LoginManager localLoginManager = this.loginManager;
    AppMethodBeat.o(40447);
    return localLoginManager;
  }
  
  protected LoginClickListener getNewLoginClickListener()
  {
    AppMethodBeat.i(40441);
    LoginClickListener localLoginClickListener = new LoginClickListener();
    AppMethodBeat.o(40441);
    return localLoginClickListener;
  }
  
  List<String> getPermissions()
  {
    AppMethodBeat.i(40439);
    List localList = this.properties.getPermissions();
    AppMethodBeat.o(40439);
    return localList;
  }
  
  public long getToolTipDisplayTime()
  {
    return this.toolTipDisplayTime;
  }
  
  public ToolTipMode getToolTipMode()
  {
    return this.toolTipMode;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(40431);
    super.onAttachedToWindow();
    if ((this.accessTokenTracker != null) && (!this.accessTokenTracker.isTracking()))
    {
      this.accessTokenTracker.startTracking();
      setButtonText();
    }
    AppMethodBeat.o(40431);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(40437);
    super.onDetachedFromWindow();
    if (this.accessTokenTracker != null) {
      this.accessTokenTracker.stopTracking();
    }
    dismissToolTip();
    AppMethodBeat.o(40437);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(40432);
    super.onDraw(paramCanvas);
    if ((!this.toolTipChecked) && (!isInEditMode()))
    {
      this.toolTipChecked = true;
      checkToolTipSettings();
    }
    AppMethodBeat.o(40432);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(40436);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    setButtonText();
    AppMethodBeat.o(40436);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40443);
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
      localObject = localResources.getString(R.string.com_facebook_loginview_log_in_button_continue);
      k = measureButtonWidth((String)localObject);
      if (resolveSize(k, paramInt1) < k) {
        localObject = localResources.getString(R.string.com_facebook_loginview_log_in_button);
      }
    }
    int k = measureButtonWidth((String)localObject);
    str = this.logoutText;
    localObject = str;
    if (str == null) {
      localObject = localResources.getString(R.string.com_facebook_loginview_log_out_button);
    }
    setMeasuredDimension(resolveSize(Math.max(k, measureButtonWidth((String)localObject)), paramInt1), j + (i + paramInt2));
    AppMethodBeat.o(40443);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(40438);
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      dismissToolTip();
    }
    AppMethodBeat.o(40438);
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, FacebookCallback<LoginResult> paramFacebookCallback)
  {
    AppMethodBeat.i(40429);
    getLoginManager().registerCallback(paramCallbackManager, paramFacebookCallback);
    AppMethodBeat.o(40429);
  }
  
  public void setAuthType(String paramString)
  {
    AppMethodBeat.i(40427);
    this.properties.setAuthType(paramString);
    AppMethodBeat.o(40427);
  }
  
  public void setDefaultAudience(DefaultAudience paramDefaultAudience)
  {
    AppMethodBeat.i(40417);
    this.properties.setDefaultAudience(paramDefaultAudience);
    AppMethodBeat.o(40417);
  }
  
  public void setLoginBehavior(LoginBehavior paramLoginBehavior)
  {
    AppMethodBeat.i(40424);
    this.properties.setLoginBehavior(paramLoginBehavior);
    AppMethodBeat.o(40424);
  }
  
  void setLoginManager(LoginManager paramLoginManager)
  {
    this.loginManager = paramLoginManager;
  }
  
  void setProperties(LoginButtonProperties paramLoginButtonProperties)
  {
    this.properties = paramLoginButtonProperties;
  }
  
  public void setPublishPermissions(List<String> paramList)
  {
    AppMethodBeat.i(40421);
    this.properties.setPublishPermissions(paramList);
    AppMethodBeat.o(40421);
  }
  
  public void setPublishPermissions(String... paramVarArgs)
  {
    AppMethodBeat.i(40422);
    this.properties.setPublishPermissions(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(40422);
  }
  
  public void setReadPermissions(List<String> paramList)
  {
    AppMethodBeat.i(40419);
    this.properties.setReadPermissions(paramList);
    AppMethodBeat.o(40419);
  }
  
  public void setReadPermissions(String... paramVarArgs)
  {
    AppMethodBeat.i(40420);
    this.properties.setReadPermissions(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(40420);
  }
  
  public void setToolTipDisplayTime(long paramLong)
  {
    this.toolTipDisplayTime = paramLong;
  }
  
  public void setToolTipMode(ToolTipMode paramToolTipMode)
  {
    this.toolTipMode = paramToolTipMode;
  }
  
  public void setToolTipStyle(ToolTipPopup.Style paramStyle)
  {
    this.toolTipStyle = paramStyle;
  }
  
  public void unregisterCallback(CallbackManager paramCallbackManager)
  {
    AppMethodBeat.i(40430);
    getLoginManager().unregisterCallback(paramCallbackManager);
    AppMethodBeat.o(40430);
  }
  
  static class LoginButtonProperties
  {
    private String authType;
    private LoginAuthorizationType authorizationType;
    private DefaultAudience defaultAudience;
    private LoginBehavior loginBehavior;
    private List<String> permissions;
    
    LoginButtonProperties()
    {
      AppMethodBeat.i(40402);
      this.defaultAudience = DefaultAudience.FRIENDS;
      this.permissions = Collections.emptyList();
      this.authorizationType = null;
      this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
      this.authType = "rerequest";
      AppMethodBeat.o(40402);
    }
    
    public void clearPermissions()
    {
      this.permissions = null;
      this.authorizationType = null;
    }
    
    public String getAuthType()
    {
      return this.authType;
    }
    
    public DefaultAudience getDefaultAudience()
    {
      return this.defaultAudience;
    }
    
    public LoginBehavior getLoginBehavior()
    {
      return this.loginBehavior;
    }
    
    List<String> getPermissions()
    {
      return this.permissions;
    }
    
    public void setAuthType(String paramString)
    {
      this.authType = paramString;
    }
    
    public void setDefaultAudience(DefaultAudience paramDefaultAudience)
    {
      this.defaultAudience = paramDefaultAudience;
    }
    
    public void setLoginBehavior(LoginBehavior paramLoginBehavior)
    {
      this.loginBehavior = paramLoginBehavior;
    }
    
    public void setPublishPermissions(List<String> paramList)
    {
      AppMethodBeat.i(40404);
      if (LoginAuthorizationType.READ.equals(this.authorizationType))
      {
        paramList = new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
        AppMethodBeat.o(40404);
        throw paramList;
      }
      if (Utility.isNullOrEmpty(paramList))
      {
        paramList = new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
        AppMethodBeat.o(40404);
        throw paramList;
      }
      this.permissions = paramList;
      this.authorizationType = LoginAuthorizationType.PUBLISH;
      AppMethodBeat.o(40404);
    }
    
    public void setReadPermissions(List<String> paramList)
    {
      AppMethodBeat.i(40403);
      if (LoginAuthorizationType.PUBLISH.equals(this.authorizationType))
      {
        paramList = new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
        AppMethodBeat.o(40403);
        throw paramList;
      }
      this.permissions = paramList;
      this.authorizationType = LoginAuthorizationType.READ;
      AppMethodBeat.o(40403);
    }
  }
  
  protected class LoginClickListener
    implements View.OnClickListener
  {
    protected LoginClickListener() {}
    
    protected LoginManager getLoginManager()
    {
      AppMethodBeat.i(40409);
      LoginManager localLoginManager = LoginManager.getInstance();
      localLoginManager.setDefaultAudience(LoginButton.this.getDefaultAudience());
      localLoginManager.setLoginBehavior(LoginButton.this.getLoginBehavior());
      localLoginManager.setAuthType(LoginButton.this.getAuthType());
      AppMethodBeat.o(40409);
      return localLoginManager;
    }
    
    public void onClick(View paramView)
    {
      int j = 1;
      AppMethodBeat.i(40406);
      LoginButton.access$300(LoginButton.this, paramView);
      paramView = AccessToken.getCurrentAccessToken();
      AppEventsLogger localAppEventsLogger;
      Bundle localBundle;
      if (AccessToken.isCurrentAccessTokenActive())
      {
        performLogout(LoginButton.this.getContext());
        localAppEventsLogger = AppEventsLogger.newLogger(LoginButton.this.getContext());
        localBundle = new Bundle();
        if (paramView == null) {
          break label115;
        }
        i = 0;
        label63:
        localBundle.putInt("logging_in", i);
        if (!AccessToken.isCurrentAccessTokenActive()) {
          break label120;
        }
      }
      label115:
      label120:
      for (int i = j;; i = 0)
      {
        localBundle.putInt("access_token_expired", i);
        localAppEventsLogger.logSdkEvent(LoginButton.this.loginLogoutEventName, null, localBundle);
        AppMethodBeat.o(40406);
        return;
        performLogin();
        break;
        i = 1;
        break label63;
      }
    }
    
    protected void performLogin()
    {
      AppMethodBeat.i(40407);
      LoginManager localLoginManager = getLoginManager();
      if (LoginAuthorizationType.PUBLISH.equals(LoginButton.access$500(LoginButton.this).authorizationType))
      {
        if (LoginButton.this.getFragment() != null)
        {
          localLoginManager.logInWithPublishPermissions(LoginButton.this.getFragment(), LoginButton.access$500(LoginButton.this).permissions);
          AppMethodBeat.o(40407);
          return;
        }
        if (LoginButton.this.getNativeFragment() != null)
        {
          localLoginManager.logInWithPublishPermissions(LoginButton.this.getNativeFragment(), LoginButton.access$500(LoginButton.this).permissions);
          AppMethodBeat.o(40407);
          return;
        }
        localLoginManager.logInWithPublishPermissions(LoginButton.access$800(LoginButton.this), LoginButton.access$500(LoginButton.this).permissions);
        AppMethodBeat.o(40407);
        return;
      }
      if (LoginButton.this.getFragment() != null)
      {
        localLoginManager.logInWithReadPermissions(LoginButton.this.getFragment(), LoginButton.access$500(LoginButton.this).permissions);
        AppMethodBeat.o(40407);
        return;
      }
      if (LoginButton.this.getNativeFragment() != null)
      {
        localLoginManager.logInWithReadPermissions(LoginButton.this.getNativeFragment(), LoginButton.access$500(LoginButton.this).permissions);
        AppMethodBeat.o(40407);
        return;
      }
      localLoginManager.logInWithReadPermissions(LoginButton.access$900(LoginButton.this), LoginButton.access$500(LoginButton.this).permissions);
      AppMethodBeat.o(40407);
    }
    
    protected void performLogout(Context paramContext)
    {
      AppMethodBeat.i(40408);
      final LoginManager localLoginManager = getLoginManager();
      if (LoginButton.this.confirmLogout)
      {
        String str1 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_log_out_action);
        String str2 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
        Object localObject = Profile.getCurrentProfile();
        if ((localObject != null) && (((Profile)localObject).getName() != null)) {}
        for (localObject = String.format(LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_as), new Object[] { ((Profile)localObject).getName() });; localObject = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook))
        {
          paramContext = new AlertDialog.Builder(paramContext);
          paramContext.setMessage((CharSequence)localObject).setCancelable(true).setPositiveButton(str1, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(40405);
              localLoginManager.logOut();
              AppMethodBeat.o(40405);
            }
          }).setNegativeButton(str2, null);
          paramContext.create().show();
          AppMethodBeat.o(40408);
          return;
        }
      }
      localLoginManager.logOut();
      AppMethodBeat.o(40408);
    }
  }
  
  public static enum ToolTipMode
  {
    public static ToolTipMode DEFAULT;
    private int intValue;
    private String stringValue;
    
    static
    {
      AppMethodBeat.i(40413);
      AUTOMATIC = new ToolTipMode("AUTOMATIC", 0, "automatic", 0);
      DISPLAY_ALWAYS = new ToolTipMode("DISPLAY_ALWAYS", 1, "display_always", 1);
      NEVER_DISPLAY = new ToolTipMode("NEVER_DISPLAY", 2, "never_display", 2);
      $VALUES = new ToolTipMode[] { AUTOMATIC, DISPLAY_ALWAYS, NEVER_DISPLAY };
      DEFAULT = AUTOMATIC;
      AppMethodBeat.o(40413);
    }
    
    private ToolTipMode(String paramString, int paramInt)
    {
      this.stringValue = paramString;
      this.intValue = paramInt;
    }
    
    public static ToolTipMode fromInt(int paramInt)
    {
      AppMethodBeat.i(40412);
      ToolTipMode[] arrayOfToolTipMode = values();
      int j = arrayOfToolTipMode.length;
      int i = 0;
      while (i < j)
      {
        ToolTipMode localToolTipMode = arrayOfToolTipMode[i];
        if (localToolTipMode.getValue() == paramInt)
        {
          AppMethodBeat.o(40412);
          return localToolTipMode;
        }
        i += 1;
      }
      AppMethodBeat.o(40412);
      return null;
    }
    
    public final int getValue()
    {
      return this.intValue;
    }
    
    public final String toString()
    {
      return this.stringValue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.widget.LoginButton
 * JD-Core Version:    0.7.0.1
 */