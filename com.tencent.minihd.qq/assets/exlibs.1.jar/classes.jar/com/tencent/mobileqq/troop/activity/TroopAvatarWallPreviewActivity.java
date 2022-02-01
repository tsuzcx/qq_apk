package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ImagePreviewAnimationUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kfj;
import kfk;
import kfl;
import kfm;
import kfn;
import kfo;
import kfp;
import kfq;

public class TroopAvatarWallPreviewActivity
  extends BaseActivity
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "curType";
  public static final String b = "url";
  public static final String c = "_id";
  public static final String d = "friendUin";
  public static final String e = "requestTypeKey";
  static boolean e = false;
  public static final String f = "faceid";
  public static final String g = "index";
  public static final String h = "KEY_THUMBNAL_BOUND";
  public static final String i = "default_avator_index";
  public int a;
  protected long a;
  protected View.OnClickListener a;
  protected View a;
  protected FrameLayout a;
  protected ImageButton a;
  protected RelativeLayout a;
  public TextView a;
  public TroopAvatarBigPhotoAdapter a;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  protected ImageAnimationView a;
  protected Gallery a;
  protected ArrayList a;
  protected List a;
  public boolean a;
  public int b;
  protected List b;
  protected boolean b;
  public boolean c;
  protected boolean d;
  boolean f = false;
  public String j;
  protected String k;
  
  public TroopAvatarWallPreviewActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 300L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new kfq(this);
  }
  
  private Bitmap a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, Drawable paramDrawable, boolean paramBoolean)
  {
    Rect localRect;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localRect = (Rect)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      localObject = a(paramBoolean);
      if ((localObject == null) || (localRect == null)) {
        return null;
      }
    }
    else
    {
      return null;
    }
    String str = b(paramBoolean);
    if (((String)localObject).equals("-5")) {}
    for (Object localObject = paramDrawable; localObject == null; localObject = a(paramBoolean, (String)localObject)) {
      return null;
    }
    if ((paramDrawable == null) && ((!paramBoolean) || (localObject == null))) {
      return null;
    }
    int i3;
    int i4;
    int m;
    label184:
    int n;
    label195:
    int i2;
    label259:
    int i1;
    if (paramDrawable == null)
    {
      if ((TextUtils.isEmpty(str)) && (str.equals("-5"))) {
        return null;
      }
      paramDrawable = a(paramBoolean, str);
      if (paramDrawable == null) {
        return null;
      }
      ((URLDrawable)paramDrawable).setAutoDownload(true);
      i3 = this.jdField_a_of_type_ComTencentWidgetGallery.getWidth();
      i4 = this.jdField_a_of_type_ComTencentWidgetGallery.getHeight();
      if (((Drawable)localObject).getIntrinsicWidth() != 0) {
        break label428;
      }
      m = 1;
      if (((Drawable)localObject).getIntrinsicHeight() != 0) {
        break label438;
      }
      n = 1;
      localObject = AnimationUtils.a(this.jdField_a_of_type_ComTencentWidgetGallery);
      if (localObject != null) {
        localRect.offset(((Rect)localObject).left, -((Rect)localObject).top);
      }
      paramRect3.set(localRect);
      if ((!paramBoolean) || (((URLDrawable)paramDrawable).getStatus() != 1)) {
        break label468;
      }
      if (paramDrawable.getIntrinsicWidth() != 0) {
        break label448;
      }
      i2 = 1;
      if (paramDrawable.getIntrinsicHeight() != 0) {
        break label458;
      }
      i1 = 1;
    }
    for (;;)
    {
      float f1 = ImagePreviewAnimationUtil.a(i2, i1);
      paramRect1.set(ImagePreviewAnimationUtil.a(m, n, i2, i1));
      paramRect2.set(ImagePreviewAnimationUtil.b(i2, i1, i3, i4));
      paramRect4.set(ImagePreviewAnimationUtil.c(i2, i1, i3, i4));
      ImagePreviewAnimationUtil.a(paramRect1, f1);
      ImagePreviewAnimationUtil.a(paramRect2, f1);
      m = (int)(i2 * f1);
      n = (int)(i1 * f1);
      try
      {
        paramRect3 = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_4444);
        paramRect4 = new Canvas(paramRect3);
        localObject = new Rect(0, 0, i2, i1);
        ImagePreviewAnimationUtil.a((Rect)localObject, f1);
        paramDrawable.setBounds((Rect)localObject);
        paramRect4.clipRect(ImagePreviewAnimationUtil.a(paramRect1, paramRect2));
        paramDrawable.draw(paramRect4);
        return paramRect3;
      }
      catch (Throwable paramRect1)
      {
        if (!QLog.isColorLevel()) {
          break label514;
        }
        QLog.e("ImagePreveiew", 2, "makeAnimationRect " + paramRect1.getMessage());
      }
      break;
      label428:
      m = ((Drawable)localObject).getIntrinsicWidth();
      break label184;
      label438:
      n = ((Drawable)localObject).getIntrinsicHeight();
      break label195;
      label448:
      i2 = paramDrawable.getIntrinsicWidth();
      break label259;
      label458:
      i1 = paramDrawable.getIntrinsicHeight();
      continue;
      label468:
      i1 = n;
      i2 = m;
    }
    label514:
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.a();
    if (localObject == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    localObject = ((ImageView)((View)localObject).findViewById(2131296300)).getDrawable();
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      if (((URLDrawable)localObject).getStatus() != 1) {
        return false;
      }
    }
    else if (localObject == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setVisibility(0);
    finish();
    return true;
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new kfp(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentWidgetGallery.a();
        } while (localObject == null);
        localObject = ((ImageView)((View)localObject).findViewById(2131296300)).getDrawable();
      } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
      localObject = (URLDrawable)localObject;
    } while (((URLDrawable)localObject).getStatus() != 1);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    Object localObject = new kfm(this, (URLDrawable)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368326, (View.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368331, (View.OnClickListener)localObject);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363781, (View.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368337, (View.OnClickListener)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(this.jdField_a_of_type_ComTencentWidgetGallery, 4);
  }
  
  Drawable a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return URLDrawable.getDrawable(paramString);
    }
    BitmapFactory.Options localOptions = ImageUtil.a(paramString, 100);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return new BitmapDrawable(paramString);
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "getDrawable out off memory");
      }
      System.gc();
    }
    return null;
  }
  
  public String a(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "picIndex" + this.jdField_a_of_type_Int + ",mSeqNumList.size()" + this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals("-5"))) {
      return "-5";
    }
    return AvatarTroopUtil.a(AvatarTroopUtil.a(str, this.j, 1));
  }
  
  public void a()
  {
    if ((!this.f) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentWidgetGallery.a() != this.jdField_a_of_type_Int)) {
        break label53;
      }
      if (!a()) {
        b();
      }
    }
    return;
    label53:
    b();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(0).equals("-5")))
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() > 1)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_b_of_type_JavaUtilList.add("" + paramInt);
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        getIntent().putStringArrayListExtra("del_list", (ArrayList)this.jdField_b_of_type_JavaUtilList);
        setResult(-1, getIntent());
      }
      finish();
      return;
    }
    QQToast.a(this, getString(2131363770), 1).b(getTitleBarHeight());
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (this.k != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.k, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.aK).mkdirs();
      str = AppConstants.aK + this.j + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            b(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131367113), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131367116)).setMessage(getString(2131367118)).setPositiveButton(getString(2131367117), new kfo(this, paramURLDrawable, str)).setNegativeButton(getString(2131365733), new kfn(this)).show();
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.k != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.k, "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    Object localObject = new File(AppConstants.bp);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    String str = AppConstants.bp + this.j + Utils.Crc64String(paramURLDrawable.getURL().toString());
    localObject = str;
    if (!new File(str).exists()) {}
    try
    {
      localObject = paramURLDrawable.saveTo(str);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", paramString);
      localBundle.putString("forward_filepath", (String)localObject);
      localBundle.putString("forward_urldrawable_big_url", paramURLDrawable.getURL().toString());
      localBundle.putString("forward_extra", (String)localObject);
      paramURLDrawable = new Intent(this, ForwardRecentActivity.class);
      paramURLDrawable.putExtras(localBundle);
      paramURLDrawable.putExtra("forward_photo_no_nav", true);
      startActivityForResult(paramURLDrawable, 21);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", localIOException);
          localObject = str;
        }
      }
    }
  }
  
  protected void addTopLayout() {}
  
  public String b(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "picIndex" + this.jdField_a_of_type_Int + ",mSeqNumList.size()" + this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals("-5"))) {
      return "-5";
    }
    return AvatarTroopUtil.b(AvatarTroopUtil.a(str, this.j, 1));
  }
  
  public void b()
  {
    finish();
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {
      return;
    }
    getIntent().putExtra("default_avator_index", paramInt);
    setResult(-1, getIntent());
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void onBackPressed()
  {
    a();
  }
  
  protected void onCreate(Bundle arg1)
  {
    super.onCreate(???);
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (e)
        {
          super.finish();
          return;
        }
        e = true;
        setContentView(2130903346);
        ??? = getWindow();
        ???.addFlags(1024);
        if (Build.VERSION.SDK_INT >= 14) {
          ???.getAttributes().systemUiVisibility = 1;
        }
        ??? = getIntent().getExtras();
        this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131297712));
        this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296554));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296742));
        this.jdField_a_of_type_AndroidViewView = findViewById(2131296573);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297793));
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131296568));
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView = ((ImageAnimationView)findViewById(2131297794));
        ((ImageView)findViewById(2131297795)).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_Boolean = ???.getBoolean("IS_EDIT");
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_JavaUtilArrayList = ???.getParcelableArrayList("KEY_THUMBNAL_BOUND");
          this.c = ???.getBoolean("is_show_action", true);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter = new TroopAvatarBigPhotoAdapter(this, this.app);
          this.j = ???.getString("troop_uin");
          this.jdField_a_of_type_Boolean = ???.getBoolean("troop_info_is_member");
          this.jdField_a_of_type_JavaUtilList = ???.getStringArrayList("seqNum");
          this.d = ???.getBoolean("is_not_show_index", true);
          this.k = ???.getString("src_id");
          if (this.k != null) {
            ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer", "open", 0, 0, this.k, "", "", "");
          }
          if (this.jdField_a_of_type_JavaUtilList != null) {
            this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
          }
          if (!this.d) {
            break label568;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.j);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(???.getBoolean("is_use_path", false));
          this.jdField_a_of_type_Int = ???.getInt("index", -1);
          this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter);
          this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131492982));
          this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new kfj(this));
          this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new kfk(this));
          this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new kfl(this));
          return;
        }
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      continue;
      label568:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void onDestroy()
  {
    System.gc();
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      e = false;
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      c();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */