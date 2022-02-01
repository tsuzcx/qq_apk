package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.empty.MusicCallActivity;
import com.tencent.mobileqq.activity.empty.MusicContactsActivity;
import com.tencent.mobileqq.activity.empty.MusicConversationActivity;
import com.tencent.mobileqq.activity.empty.MusicQzoneActivity;
import com.tencent.mobileqq.activity.empty.MusicSettingMeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserEmptyActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileViewerParamParser;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.NotRemoveFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.EmptyTextView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class QQBasePluginActivity
  extends PluginProxyActivity
{
  protected static final int a = 0;
  private static SparseArray a;
  protected static final int[] a;
  protected static final int b = 1;
  protected static final int c = 2;
  public static final String c = "show_shadow_on_page";
  protected static final int d = 3;
  public static final String d = "shadow_anim";
  public static final String e = "shadow_visible";
  public String a;
  public boolean a;
  public String b;
  boolean b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2130841805, 2130841808, 2130841806, -1 };
  }
  
  public static SparseArray a()
  {
    int i = 0;
    if (jdField_a_of_type_AndroidUtilSparseArray == null)
    {
      Class[] arrayOfClass = new Class[6];
      arrayOfClass[0] = MusicSettingMeActivity.class;
      arrayOfClass[1] = MusicConversationActivity.class;
      arrayOfClass[2] = MusicCallActivity.class;
      arrayOfClass[3] = MusicContactsActivity.class;
      arrayOfClass[4] = MusicQzoneActivity.class;
      arrayOfClass[5] = null;
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(arrayOfClass.length);
      while (i < arrayOfClass.length)
      {
        jdField_a_of_type_AndroidUtilSparseArray.put(i, arrayOfClass[i]);
        i += 1;
      }
    }
    return jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject;
    if (!paramIntent.getExtras().containsKey("display_like_dialog"))
    {
      localObject = paramIntent.getComponent();
      if (localObject != null) {
        break label85;
      }
      localObject = null;
      if ((localObject != null) && ((((String)localObject).endsWith("SelectMemberActivity")) || (((String)localObject).endsWith("ForwardRecentActivity"))))
      {
        paramIntent.putExtra("display_like_dialog", true);
        if ((getWindow().getAttributes().flags & 0x400) == 0) {
          break label93;
        }
      }
    }
    label85:
    label93:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramIntent.putExtra("dialog_full_screen", true);
      }
      return;
      localObject = ((ComponentName)localObject).getClassName();
      break;
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.findViewById(2131297227) == null) && ((paramView instanceof FrameLayout)))
    {
      View localView = new View(this);
      int i = getResources().getDimensionPixelSize(2131492913);
      localView.setBackgroundResource(2130838495);
      localView.setId(2131297227);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, -1);
      localLayoutParams.gravity = 3;
      ((FrameLayout)paramView).addView(localView, localLayoutParams);
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    boolean bool = false;
    if ((getParent() != null) && (getClass().getSimpleName().endsWith("Leba"))) {
      bool = true;
    }
    do
    {
      return bool;
      paramIntent = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
    } while (paramIntent == null);
    return paramIntent.getBoolean("open_fragment_no_anim_once", false);
  }
  
  private boolean a(Intent paramIntent, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    int i;
    if (!isModeleWindow())
    {
      localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (QQAppInterface)localObject2;
        if (!paramString.endsWith("FileBrowserActivity")) {
          break label305;
        }
        try
        {
          localObject2 = new FileViewerParamParser((QQAppInterface)localObject2);
          ((FileViewerParamParser)localObject2).a(true);
          paramString = paramIntent.getStringExtra("c2c_discussion_recentfile");
          if ((paramString != null) && (paramString.trim().length() != 0)) {
            ((FileViewerParamParser)localObject2).a(paramString);
          }
          if (!((FileViewerParamParser)localObject2).a(paramIntent)) {
            return false;
          }
          switch (((FileViewerParamParser)localObject2).a())
          {
          case 2: 
          case 3: 
            while (paramString != null)
            {
              paramString = (IFileViewerAdapter)paramString.get(i);
              if (paramString != null)
              {
                i = paramString.b();
                Log.i("app2", "fileType=" + i);
                if (i == 2)
                {
                  paramIntent.putExtra("my_file_fullscreen", true);
                  paramIntent.setClass(this, FileBrowserEmptyActivity.class);
                  return true;
                  paramString = ((FileViewerParamParser)localObject2).a();
                  i = ((FileViewerParamParser)localObject2).b();
                  continue;
                  paramString = new ArrayList(1);
                  paramString.add(((FileViewerParamParser)localObject2).a());
                  i = 0;
                }
                else if ((paramString.f()) || (paramString.e()) || (paramString.d()))
                {
                  paramIntent.setClass(this, FileBrowserActivity.class);
                  paramIntent.putExtra("my_file_fullscreen", true);
                  return true;
                }
              }
            }
          }
        }
        catch (Exception paramIntent)
        {
          Log.e("app2", "check file browser error", paramIntent);
        }
      }
    }
    for (;;)
    {
      label303:
      return false;
      label305:
      if (paramString.endsWith("TroopFileDetailBrowserActivity")) {
        for (;;)
        {
          try
          {
            paramString = new TroopFileViewerParamParser((QQAppInterface)localObject2);
            if (!paramString.a(paramIntent, this)) {
              return false;
            }
            switch (paramString.a())
            {
            case 2: 
              if (!QLog.isDevelopLevel()) {
                break label522;
              }
              throw new NullPointerException("未知的mFileViewerType");
            }
          }
          catch (Exception paramIntent) {}
          paramString = paramString.a();
          if (paramString != null)
          {
            paramString = (IFileViewerAdapter)paramString.get(0);
            if (paramString == null) {
              break label303;
            }
            i = paramString.b();
            Log.i("app2", "fileType=" + i);
            if (i != 2) {
              continue;
            }
            paramIntent.putExtra("my_file_fullscreen", true);
            return true;
            paramString = paramString.a();
            continue;
          }
          break label303;
          if ((!paramString.f()) && (!paramString.e()) && (!paramString.d())) {
            break label303;
          }
          paramIntent.putExtra("my_file_fullscreen", true);
          return true;
          i = 0;
          paramString = localObject1;
          break;
          return true;
        }
      }
    }
    return true;
    label522:
    return false;
  }
  
  private void b(Intent paramIntent)
  {
    if (getIntent().hasExtra("from_float_aio"))
    {
      paramIntent.putExtra("from_float_aio", getIntent().getBooleanExtra("from_float_aio", false));
      paramIntent.putExtra("from_float_nick", getIntent().getStringExtra("from_float_nick"));
    }
    if (getIntent().hasExtra("open_hb_detail")) {
      paramIntent.putExtra("open_hb_detail", getIntent().getBooleanExtra("open_hb_detail", false));
    }
  }
  
  private void b(View paramView)
  {
    if ((paramView.findViewById(16908316) == null) && ((paramView instanceof FrameLayout)))
    {
      View localView = new View(this);
      int i = getResources().getDimensionPixelSize(2131493219);
      localView.setBackgroundResource(2130841653);
      localView.setId(16908316);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, -1);
      localLayoutParams.gravity = 3;
      ((ViewGroup)paramView).addView(localView, localLayoutParams);
      localView.setVisibility(8);
    }
  }
  
  private boolean b(Intent paramIntent)
  {
    Object localObject = paramIntent.getComponent();
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || ((!((String)localObject).endsWith("QQBrowserDelegationActivity")) && (!((String)localObject).endsWith("PayBridgeActivity")) && (!((String)localObject).endsWith("QzonePicturePluginProxyActivity")) && (!((String)localObject).endsWith("TroopAvatarWallPreviewActivity")) && (!((String)localObject).endsWith("AddFriendLogicActivity")) && (!((String)localObject).endsWith("VipProfileCardPhotoHandlerActivity")) && (!((String)localObject).endsWith("PhotoListActivity")) && (!((String)localObject).endsWith("PhotoCropActivity")) && (!((String)localObject).endsWith("UniformDownloadActivity")))) {
        break label115;
      }
    }
    label115:
    do
    {
      String str;
      do
      {
        return true;
        localObject = ((ComponentName)localObject).getClassName();
        break;
        str = paramIntent.getStringExtra("pluginsdk_launchActivity");
      } while ((!TextUtils.isEmpty(str)) && ((((String)localObject).endsWith("FavoriteIpcDelegate")) || (str.endsWith("QZoneFriendFeedActivity")) || (str.endsWith("GrapHbActivity")) || (str.endsWith("PsdMgrActivity")) || (str.endsWith("BindBankActivity")) || (str.endsWith("DepositStartActivity")) || (str.endsWith("WithdrawActivity")) || (str.endsWith("PayActivity")) || (str.endsWith("PaySuccessActivity")) || (str.endsWith("HbDetailActivity")) || (str.endsWith("HbListActivity"))));
      localObject = paramIntent.getAction();
    } while ((localObject != null) && (((String)localObject).length() > 0));
    paramIntent = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
    if (paramIntent != null) {
      return paramIntent.getBoolean("fragment_no_anim", false);
    }
    return false;
  }
  
  private final boolean c(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label54:
    for (;;)
    {
      return false;
      Object localObject = paramIntent.getComponent();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((ComponentName)localObject).getClassName())
      {
        if ((localObject != null) && (a(paramIntent, (String)localObject))) {
          break label54;
        }
        paramIntent = paramIntent.getAction();
        if ((paramIntent != null) && (paramIntent.length() > 0)) {
          break;
        }
        return true;
      }
    }
  }
  
  private boolean d()
  {
    String str = getIntent().getStringExtra("pluginsdk_launchActivity");
    return (str == null) || ((!str.endsWith("GrapHbActivity")) && (!str.endsWith("QfavFileViewerActivity")));
  }
  
  private boolean e()
  {
    return (getIntent() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || ((isModeleWindow()) && (this.jdField_a_of_type_JavaLangString.endsWith("ChatActivity"))) || (this.jdField_a_of_type_JavaLangString.endsWith("Conversation")) || (this.jdField_a_of_type_JavaLangString.endsWith("Call")) || (this.jdField_a_of_type_JavaLangString.endsWith("Contacts")) || (this.jdField_a_of_type_JavaLangString.endsWith("QzoneWrapperActivity")) || (this.jdField_a_of_type_JavaLangString.endsWith("Leba")) || (this.jdField_a_of_type_JavaLangString.endsWith("SettingMe"));
  }
  
  private void f()
  {
    View localView = findViewById(2131297357);
    if ((localView != null) && (a(this.jdField_a_of_type_JavaLangString)) && (!isModeleWindow()))
    {
      if (getResources().getConfiguration().orientation == 2) {
        localView.setVisibility(8);
      }
    }
    else {
      return;
    }
    localView.setVisibility(0);
  }
  
  private boolean f()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (a(this.jdField_a_of_type_JavaLangString))
    {
      bool1 = bool2;
      if (getParent() == null)
      {
        bool1 = bool2;
        if (isNewTaskActivity())
        {
          bool1 = bool2;
          if (getResources().getConfiguration().orientation == 2) {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private void g()
  {
    if (b(this.jdField_a_of_type_JavaLangString))
    {
      if (a(this.jdField_a_of_type_JavaLangString))
      {
        a(false, false);
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    a(true, true);
  }
  
  protected void a()
  {
    int k = 2131427929;
    Object localObject2;
    Object localObject1;
    int j;
    if ((isModeleWindow()) || (a()))
    {
      i = 1;
      localObject2 = findViewById(2131297357);
      Object localObject3 = findViewById(2131297348);
      localObject1 = findViewById(2131297360);
      if ((localObject3 != null) && ((localObject3 instanceof TextView)))
      {
        localObject3 = (TextView)localObject3;
        if (i == 0) {
          break label173;
        }
        j = -1;
        label73:
        ((TextView)localObject3).setTextColor(j);
      }
      if ((localObject2 != null) && ((localObject2 instanceof TextView)))
      {
        localObject2 = (TextView)localObject2;
        localObject3 = getResources();
        if (i == 0) {
          break label180;
        }
        j = 2131427929;
        label113:
        ((TextView)localObject2).setTextColor(((Resources)localObject3).getColorStateList(j));
      }
      if ((localObject1 != null) && ((localObject1 instanceof TextView)))
      {
        localObject1 = (TextView)localObject1;
        localObject2 = getResources();
        if (i == 0) {
          break label187;
        }
      }
    }
    label173:
    label180:
    label187:
    for (int i = k;; i = 2131427927)
    {
      ((TextView)localObject1).setTextColor(((Resources)localObject2).getColorStateList(i));
      return;
      i = 0;
      break;
      j = -16777216;
      break label73;
      j = 2131427927;
      break label113;
    }
  }
  
  protected void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_a_of_type_ArrayOfInt.length))
    {
      localObject = findViewById(2131297357);
      if (localObject != null)
      {
        localObject = (ViewGroup)((View)localObject).getParent();
        if (localObject != null)
        {
          i = getResources().getDimensionPixelSize(2131492916);
          if (paramInt != 3) {
            break label72;
          }
          ((ViewGroup)localObject).setBackground(new ColorDrawable());
          ((ViewGroup)localObject).setPadding(i, 0, i, 0);
        }
      }
    }
    label72:
    while ((paramInt >= 0) || (!isModeleWindow())) {
      for (;;)
      {
        Object localObject;
        int i;
        return;
        ((ViewGroup)localObject).setBackgroundResource(jdField_a_of_type_ArrayOfInt[paramInt]);
      }
    }
    a(1);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = findViewById(16908316);
    if (localView != null) {
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getActivity().findViewById(2131297224);
    if (localObject != null) {
      if (paramBoolean1)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
      }
    }
    while (getParent() != null) {
      for (;;)
      {
        return;
        int i = 4;
      }
    }
    localObject = new Intent("Common_BroadcastReceiver");
    ((Intent)localObject).putExtra("show_shadow_on_page", true);
    ((Intent)localObject).putExtra("shadow_anim", paramBoolean2);
    ((Intent)localObject).putExtra("shadow_visible", paramBoolean1);
    sendBroadcast((Intent)localObject);
  }
  
  protected boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.endsWith("HbListActivity"));
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.endsWith("Leba"))
      {
        bool1 = bool2;
        if (!paramString.endsWith("SettingMe")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void allowContainerNotRemove(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof NotRemoveFrameLayout)) {
      ((NotRemoveFrameLayout)paramView).jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  protected void b()
  {
    View localView = findViewById(2131297357);
    if (((localView instanceof EmptyTextView)) && (!((EmptyTextView)localView).jdField_a_of_type_Boolean))
    {
      if (!isModeleWindow()) {
        break label85;
      }
      if (!e()) {
        break label78;
      }
    }
    label78:
    for (int i = 2130838413;; i = 2130842088)
    {
      localView.setBackgroundResource(i);
      f();
      localView = findViewById(2131296922);
      if ((localView instanceof TextView)) {
        ((TextView)localView).setText("");
      }
      return;
    }
    label85:
    if (e()) {}
    for (i = 2130838414;; i = 2130842089)
    {
      localView.setBackgroundResource(i);
      break;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if ((!paramString.endsWith("Conversation")) && (!paramString.endsWith("Call")) && (!paramString.endsWith("Contacts")) && (!paramString.endsWith("QzoneWrapperActivity")) && (!paramString.endsWith("Leba")))
      {
        bool1 = bool2;
        if (!paramString.endsWith("SettingMe")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    if ((!a(this.jdField_a_of_type_JavaLangString)) && (b(this.jdField_a_of_type_JavaLangString)))
    {
      a(false, false);
      a(true);
    }
  }
  
  public boolean c()
  {
    return (b()) || (getResources().getConfiguration().orientation == 1);
  }
  
  public void d()
  {
    if ((!a(this.jdField_a_of_type_JavaLangString)) && (b(this.jdField_a_of_type_JavaLangString)))
    {
      a(true, false);
      a(false);
    }
  }
  
  protected void e()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    NotRemoveFrameLayout localNotRemoveFrameLayout = new NotRemoveFrameLayout(this);
    View localView = localViewGroup.getChildAt(0);
    if (localView != null)
    {
      localViewGroup.addView(localNotRemoveFrameLayout);
      localViewGroup.removeView(localView);
      localNotRemoveFrameLayout.addView(localView);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a(false, false);
    }
  }
  
  public int getLefPanelWidth()
  {
    return SizeMeasure.b(this);
  }
  
  protected int getModalWindowFinishAnim()
  {
    return 2130968584;
  }
  
  protected int getModalWindowOpenAnim()
  {
    return 2131559055;
  }
  
  protected int getRightPanelWidth()
  {
    return SizeMeasure.e(this);
  }
  
  protected int getTabIndex()
  {
    int i = Utils.b(getActivity());
    if (i >= 0) {
      return i;
    }
    return super.getTabIndex();
  }
  
  protected void notAnim(boolean paramBoolean)
  {
    if ((paramBoolean) && (hasContentView())) {
      g();
    }
  }
  
  protected void onAnimEnd(boolean paramBoolean)
  {
    super.onAnimEnd(paramBoolean);
    if ((paramBoolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      a(true, false);
    }
  }
  
  protected void onAnimStart(boolean paramBoolean)
  {
    super.onAnimStart(paramBoolean);
    if (paramBoolean) {
      g();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SizeMeasure.b(this);
    a(-1);
    b();
    a();
    if (a(this.jdField_a_of_type_JavaLangString)) {
      a(getWindow().getDecorView());
    }
    if ((!a(this.jdField_a_of_type_JavaLangString)) && (b(this.jdField_a_of_type_JavaLangString))) {
      b(getWindow().getDecorView());
    }
  }
  
  public void onBackPressed()
  {
    if (f())
    {
      super.onBackPressed();
      return;
    }
    Utils.a(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    SizeMeasure.b(this);
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    SizeMeasure.b(this);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from_activity");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("pluginsdk_launchActivity");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("open_by_default_first_page", false);
    getIntent().removeExtra("open_by_default_first_page");
    if ((!this.bActivityToFragment) && (d())) {}
  }
  
  protected void onRestart()
  {
    super.onRestart();
    f();
  }
  
  public void onResume()
  {
    super.onResume();
    if (getIntent().getBooleanExtra("back_finish", false)) {}
    try
    {
      onKeyDown(4, null);
      return;
    }
    catch (Exception localException)
    {
      Log.e("app2", "onResume backFinish error", localException);
    }
  }
  
  protected void redirectNewTaskActivity(Intent paramIntent)
  {
    paramIntent.setFlags(0);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    paramIntent.putExtra("from_activity", getClass().getName());
    b(paramIntent);
    if ((a(this.jdField_a_of_type_JavaLangString)) || ((this.jdField_a_of_type_Boolean) && (!hasContentView()))) {
      paramIntent.putExtra("open_by_default_first_page", true);
    }
    a(paramIntent);
    if (isBaseFragment()) {
      paramIntent.putExtra("open_from_base_fragment", true);
    }
    int i;
    Bundle localBundle;
    if (getActivity().getParent() != null)
    {
      i = 1;
      if ((!paramIntent.getExtras().containsKey("is_activity_to_fragment")) || (!paramIntent.getExtras().containsKey("clear_fragment_stack")))
      {
        localBundle = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
        if (localBundle == null) {
          break label363;
        }
        if (localBundle.containsKey("is_activity_to_fragment")) {
          break label324;
        }
        if ((!c(paramIntent)) || (i == 0)) {
          break label318;
        }
        bool = true;
        label157:
        paramIntent.putExtra("is_activity_to_fragment", bool);
        label167:
        if (!localBundle.containsKey("clear_fragment_stack")) {
          break label344;
        }
        paramIntent.putExtra("clear_fragment_stack", localBundle.getBoolean("clear_fragment_stack", false));
      }
    }
    for (;;)
    {
      if (!paramIntent.getExtras().containsKey("open_fragment_no_anim_once")) {
        paramIntent.putExtra("open_fragment_no_anim_once", a(paramIntent));
      }
      if (!paramIntent.getExtras().containsKey("fragment_no_anim")) {
        paramIntent.putExtra("fragment_no_anim", b(paramIntent));
      }
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "plugin: plugin: " + getClass().getName() + " -> " + paramIntent.getStringExtra("pluginsdk_launchActivity"));
      }
      super.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
      i = 0;
      break;
      label318:
      bool = false;
      break label157;
      label324:
      paramIntent.putExtra("is_activity_to_fragment", localBundle.getBoolean("is_activity_to_fragment", false));
      break label167;
      label344:
      if (isBaseFragment()) {
        paramIntent.putExtra("clear_fragment_stack", true);
      }
    }
    label363:
    if ((c(paramIntent)) && (i != 0)) {}
    for (;;)
    {
      paramIntent.putExtra("is_activity_to_fragment", bool);
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBasePluginActivity
 * JD-Core Version:    0.7.0.1
 */