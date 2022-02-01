package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractGalleryPageView;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryPageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UnCompletedCode;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import fya;
import fyb;
import fyc;
import fyd;
import fye;
import fyf;
import fyh;
import fyi;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOGalleryScene
  extends AbstractGalleryScene
{
  static final int jdField_a_of_type_Int = 0;
  public static final String a = "AIOGalleryScene";
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new fyd(this);
  View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AIOGalleryAdapter a;
  public AIOImageListModel a;
  public IAIOImageProvider a;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  public ArrayList a;
  boolean jdField_a_of_type_Boolean = false;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  public String b;
  public ArrayList b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  private final int jdField_d_of_type_Int = -3321;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean;
  private final int f = -2147483648;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 1;
  private boolean jdField_h_of_type_Boolean = false;
  private boolean i = false;
  
  public AIOGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.jdField_b_of_type_JavaLangString = ((PeakActivity)paramActivity).a.a();
    }
  }
  
  private fyh a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fyh localfyh = (fyh)localIterator.next();
      if ((localfyh.jdField_a_of_type_Long == paramLong) && (localfyh.jdField_a_of_type_Int == paramInt)) {
        return localfyh;
      }
    }
    return null;
  }
  
  private fyi a(long paramLong, int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fyi localfyi = (fyi)localIterator.next();
      if ((localfyi.jdField_a_of_type_Long == paramLong) && (localfyi.jdField_a_of_type_Int == paramInt)) {
        return localfyi;
      }
    }
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
    paramBundle = new Bundle(paramBundle);
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ForwardHandlerActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    paramBundle = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBundle);
    PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, localArrayList, 0, true);
  }
  
  private void a(View paramView, int paramInt)
  {
    AIOImageInfo localAIOImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    Object localObject2 = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2);
    }
    if ((localObject1 == null) && (this.jdField_c_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this.jdField_a_of_type_AndroidAppActivity);
    localObject2 = new fyf(this, localAIOImageInfo, (File)localObject1);
    if (localObject1 != null)
    {
      if (this.jdField_g_of_type_Boolean) {
        break label192;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368326, (View.OnClickListener)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368334, (View.OnClickListener)localObject2);
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368342, (View.OnClickListener)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368331, (View.OnClickListener)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368329, (View.OnClickListener)localObject2);
    }
    for (;;)
    {
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368335, (View.OnClickListener)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, paramInt);
      return;
      label192:
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131368331, (View.OnClickListener)localObject2);
    }
  }
  
  @UnCompletedCode
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramString, paramInt);
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903982, null);
  }
  
  protected AbstractGalleryPageView a(Context paramContext)
  {
    paramContext = new GalleryPageView();
    paramContext.jdField_a_of_type_Int = 25;
    return paramContext;
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
  }
  
  public void a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    AIOImageInfo localAIOImageInfo = new AIOImageInfo((AIOImageData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(localAIOImageInfo);
    localAIOImageInfo.jdField_b_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.jdField_e_of_type_Int = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
    this.jdField_g_of_type_Int = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
    this.jdField_h_of_type_Boolean = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
      this.jdField_d_of_type_JavaLangString = localBundle.getString("extra.GROUP_CODE");
      if (((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null)) && (QLog.isColorLevel())) {
        QLog.i("AIOGalleryScene", 2, "mGroupUin=" + this.jdField_c_of_type_JavaLangString + ", mGroupCode=" + this.jdField_d_of_type_JavaLangString + ", mMyUin=" + this.jdField_b_of_type_JavaLangString);
      }
    }
    this.jdField_h_of_type_Int = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_g_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      paramInt2 = 0;
      if (paramInt2 < ((List)localObject1).size())
      {
        localObject2 = (AIOImageInfo)((List)localObject1).get(paramInt2);
        if ((((AIOImageInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_Long != paramLong1) || (((AIOImageInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_e_of_type_Int != paramInt1)) {
          break label156;
        }
        ((AIOImageInfo)localObject2).jdField_a_of_type_Int = paramInt3;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramInt3 / 100);
        if (paramBoolean)
        {
          paramInt1 = this.jdField_a_of_type_ComTencentWidgetGallery.s();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt2 >= paramInt1) && (paramInt2 <= paramInt3 + paramInt1 - 1))
          {
            localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - paramInt1);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt2, (View)localObject1, paramBoolean);
          }
        }
      }
    }
    label156:
    do
    {
      do
      {
        return;
        paramInt2 += 1;
        break;
      } while (paramInt2 != 4);
      localObject1 = a(paramLong1, paramInt1);
    } while ((localObject1 == null) || (((fyh)localObject1).jdField_a_of_type_Long != paramLong1) || (((fyh)localObject1).jdField_a_of_type_Int != paramInt1) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
    if (paramLong2 > 0L)
    {
      localObject1 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)paramLong2);
      localObject2 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)(paramInt3 * paramLong2) / 10000.0F);
      localObject1 = (String)localObject2 + "/" + (String)localObject1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt3 / 100 + "%");
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
      if (paramInt3 == 1)
      {
        paramInt2 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString);
        paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.s();
        int j = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        if ((paramInt2 >= paramInt3) && (paramInt2 <= j + paramInt3 - 1))
        {
          paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - paramInt3);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramString, paramBoolean);
        }
        paramString = ((AIOImageInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt2)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
        if ((!TextUtils.isEmpty(paramString.a(4))) && (paramLong == this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_Long) && (paramInt1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_e_of_type_Int) && (NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramString.jdField_a_of_type_Long, paramString.jdField_e_of_type_Int, 4, true);
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "predownload raw after big, id = " + paramString.jdField_a_of_type_Long);
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt2);
        }
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return;
          paramString = "I:E";
          break;
        } while (paramInt2 != 4);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 != 1) {
          break label425;
        }
        ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString);
        paramString = a(paramLong, paramInt1);
      } while (paramString == null);
      if (paramInt3 != 1) {
        break label460;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramString.jdField_b_of_type_Int).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4);
    } while (str == null);
    Object localObject = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
    switch (((URLDrawable)localObject).getStatus())
    {
    }
    for (;;)
    {
      ((URLDrawable)localObject).setTag(Integer.valueOf(1));
      ((URLDrawable)localObject).setURLDrawableListener(paramString);
      ((URLDrawable)localObject).startDownload();
      paramString.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      return;
      label425:
      paramString = "I:E";
      break;
      paramString.onLoadSuccessed((URLDrawable)localObject);
      return;
      paramString.onLoadFialed((URLDrawable)localObject, null);
      return;
      paramString.onLoadCanceled((URLDrawable)localObject);
    }
    label460:
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131368502), 0).a();
    c(true);
    a(false);
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    int j = 1;
    if (paramView == null) {}
    do
    {
      return;
      paramView = (URLDrawable)((ImageView)paramView).getDrawable();
    } while (paramView.getStatus() != 1);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1).jdField_b_of_type_Int = j;
      paramView = new File(paramView.getURL().getFile());
      if (!paramView.exists()) {
        break;
      }
      new fye(this, paramView, paramInt2).execute(new Void[0]);
      return;
      j = 3;
      continue;
      j = 8;
      continue;
      j = 6;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    paramViewGroup = (RelativeLayout)a();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    this.jdField_a_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130840455);
    this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131368495));
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageButton, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837575);
    this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    int j = AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int k = AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int m = AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_b_of_type_AndroidWidgetImageButton.setPadding(j, j, k, m);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    paramViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageButton, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(new fya(this));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903985, null);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131298193));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300345));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new fyb(this));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new fyc(this));
    if ((ProGallery.OnProGalleryListener.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
      ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
    }
  }
  
  public void a(AIOImageInfo paramAIOImageInfo)
  {
    File localFile = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4);
    if (localFile == null) {
      localFile = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2);
    }
    for (int j = 0;; j = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(1));
      paramAIOImageInfo = paramAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
      if (j != 0) {}
      for (j = 4;; j = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", paramAIOImageInfo.a(j));
        localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
        }
        paramAIOImageInfo = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        paramAIOImageInfo.putExtras(localBundle);
        paramAIOImageInfo.putExtra("display_like_dialog", true);
        paramAIOImageInfo.putExtra("dialog_full_screen", true);
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramAIOImageInfo, 0);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(false);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryScene", 2, "notifyImageListChanged list size " + paramArrayOfAIOImageData.length + ", selected " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramArrayOfAIOImageData, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == 0)
    {
      PicReporter.b(false);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131368340, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
      if (paramInt != this.jdField_a_of_type_ComTencentWidgetGallery.r()) {
        break;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(this.jdField_a_of_type_ComTencentWidgetGallery, paramInt);
      return;
      PicReporter.b(true);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(paramInt);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {
      try
      {
        a(this.jdField_a_of_type_ComTencentWidgetGallery, 4);
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
          }
        }
      }
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    try
    {
      a(paramAdapterView, 4);
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
        }
      }
    }
  }
  
  public void b()
  {
    o();
    this.jdField_e_of_type_Boolean = true;
    AIOImageInfo localAIOImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.b(paramAdapterView, paramView, paramInt, paramLong);
    if (AIOGalleryAdapter.GalleryURLImageView.class.isInstance(paramView))
    {
      paramAdapterView = (AIOGalleryAdapter.GalleryURLImageView)paramView;
      paramView = paramAdapterView.getDrawable();
      if ((!paramAdapterView.jdField_b_of_type_Boolean) && (paramView != null) && ((paramView instanceof URLDrawable)))
      {
        paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
        if ((paramAdapterView != null) && (paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4)))
        {
          AIOImageInfo localAIOImageInfo = (AIOImageInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt);
          if ((localAIOImageInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()))
          {
            paramView = a(localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_Long, localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_e_of_type_Int);
            paramAdapterView = paramView;
            if (paramView == null)
            {
              paramAdapterView = new fyh(this, null);
              paramAdapterView.jdField_a_of_type_Long = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_Long;
              paramAdapterView.jdField_a_of_type_Int = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_e_of_type_Int;
              this.jdField_a_of_type_JavaUtilArrayList.add(paramAdapterView);
            }
            paramAdapterView.jdField_b_of_type_Int = paramInt;
          }
          if (NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_Long, localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_e_of_type_Int, 4, true);
            if (QLog.isColorLevel()) {
              QLog.d("AIOGalleryScene", 2, "predownload raw when selected, id = " + localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_a_of_type_Long);
            }
          }
          c(true);
          return;
        }
      }
    }
    c(false);
  }
  
  public void c()
  {
    this.jdField_e_of_type_Boolean = false;
    c(this.jdField_d_of_type_Boolean);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
  }
  
  protected boolean c()
  {
    if ((this.jdField_e_of_type_Int == -3321) || (this.jdField_e_of_type_Int == 1)) {
      return false;
    }
    if (this.jdField_g_of_type_Int == -2147483648) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
    localObject1 = ((ActivityManager)((Activity)localObject1).getSystemService("activity")).getRunningAppProcesses().iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
    } while (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals("com.tencent.minihd.qq"));
    for (int j = ((ActivityManager.RunningAppProcessInfo)localObject2).pid;; j = -2147483648) {
      return j == this.jdField_g_of_type_Int;
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
  }
  
  public void e() {}
  
  public boolean e()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
    {
      a(false);
      c(true);
      return true;
    }
    a(false);
    return super.e();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    if (this.jdField_c_of_type_Int > 0) {
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, "" + this.jdField_c_of_type_Int, "", "", "");
    }
  }
  
  public void l()
  {
    super.l();
    AIOImageInfo localAIOImageInfo = ((AIOImageListModel)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel).b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void m()
  {
    super.m();
    AIOImageInfo localAIOImageInfo = ((AIOImageListModel)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel).b();
    if (localAIOImageInfo != null) {
      localAIOImageInfo.jdField_a_of_type_Boolean = false;
    }
  }
  
  @TargetApi(11)
  public void o()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
    }
  }
  
  void p() {}
  
  public void q()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        n();
        a("Pic_view", 0);
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131367031, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene
 * JD-Core Version:    0.7.0.1
 */