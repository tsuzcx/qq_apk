package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import fyp;
import fyr;
import fys;
import fyt;
import fyu;
import fyv;
import fyw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOImageListScene
  extends AbstractImageListScene
  implements DialogInterface.OnCancelListener
{
  private static final String jdField_a_of_type_JavaLangString = "AIOImageListScene";
  public static final int c = 20;
  public static final int d = 99;
  public static final int e = 98;
  static final int f = 20;
  static final int g = 0;
  static final int h = 1;
  static final int i = 2;
  static final int j = 0;
  static final int k = 1;
  static final int l = 2;
  static final int m = 3;
  static final int n = 4;
  static final int o = 5;
  static final int p = 1;
  static final int q = 2;
  static final int r = 1;
  static final int s = 2;
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  private IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private fyw jdField_a_of_type_Fyw;
  public ArrayList a;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String c;
  private String d;
  private int t = 1;
  
  public AIOImageListScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_b_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "0";
    }
  }
  
  private void a(String paramString)
  {
    if (paramString.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131369010)))
    {
      this.jdField_a_of_type_Boolean = true;
      a("Multi_Pic_choose", 0);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(String paramString, int paramInt) {}
  
  private boolean a(View paramView, GalleryImage paramGalleryImage)
  {
    Object localObject = (AIOPhotoListAdapter.Holder)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((AIOPhotoListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView;
      localObject = ((AIOPhotoListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView;
      switch (paramGalleryImage.b())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
    }
    return false;
  }
  
  private boolean a(AIOImageInfo paramAIOImageInfo, boolean paramBoolean)
  {
    int i1 = paramAIOImageInfo.b();
    if (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean))) {}
    long l1;
    do
    {
      return false;
      if ((i1 != 2) || (!paramBoolean) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 20)) {
        break;
      }
      l1 = System.currentTimeMillis();
    } while (l1 - this.jdField_a_of_type_Long < 700L);
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, "最多只能选择20张图片", 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492923));
    this.jdField_a_of_type_Long = l1;
    return false;
    if (paramBoolean)
    {
      paramAIOImageInfo.a(1);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAIOImageInfo);
    }
    for (;;)
    {
      return true;
      paramAIOImageInfo.a(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramAIOImageInfo);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showDownloadResult type = " + paramInt1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new fyr(this));
    Object localObject;
    switch (paramInt1)
    {
    case 2: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131369020), new Object[] { Integer.valueOf(paramInt2) }));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131365737, new DialogUtil.DialogOnClickAdapter());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131369019);
      localObject = new fys(this, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131365736, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131363612, (DialogInterface.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showSDCardResult type = " + paramInt2);
    }
    String str;
    if (paramInt2 == 22)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131366136);
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131366137);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, (String)localObject, str, null, null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(str);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131365737, new DialogUtil.DialogOnClickAdapter());
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (paramInt2 == 24)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131366134);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131366135);
      }
      else if (paramInt2 == 23)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131366132);
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131366133);
      }
      else
      {
        localObject = null;
        str = null;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "showProgressDialog step = " + paramInt1);
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131558902);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903413);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298140);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTextView.setText(str);
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      str = localTextView.getResources().getText(2131369013) + str;
      continue;
      str = localTextView.getResources().getText(2131369014) + str;
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    this.jdField_b_of_type_Boolean = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    if (this.jdField_b_of_type_Boolean)
    {
      this.c = localBundle.getString("extra.GROUP_UIN");
      this.d = localBundle.getString("extra.GROUP_CODE");
      if (((this.c == null) || (this.d == null) || (this.jdField_b_of_type_JavaLangString == null)) && (QLog.isColorLevel())) {
        QLog.i("AIOImageListScene", 2, "mGroupUin=" + this.c + ", mGroupCode=" + this.d + ", mMyUin=" + this.jdField_b_of_type_JavaLangString);
      }
    }
    this.t = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131366260), "qqsetting_auto_receive_pic_key", true);
    int i1;
    int i2;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      i1 = 1;
      if (NetworkUtil.b(BaseApplication.getContext()) != -1) {
        break label119;
      }
      i2 = 1;
      label64:
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((AIOImageInfo)((Iterator)localObject).next()).a.a(2) != null);
    }
    for (int i3 = 0;; i3 = 1)
    {
      if (i3 != 0)
      {
        s();
        return;
        i1 = 0;
        break;
        label119:
        i2 = 0;
        break label64;
      }
      if (i2 != 0)
      {
        b(1, this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
      }
      if ((bool) || (i1 != 0))
      {
        a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
        return;
      }
      b(0, 1);
      return;
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToGroupAlbum()");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AIOImageInfo localAIOImageInfo = (AIOImageInfo)localIterator.next();
      localArrayList1.add(localAIOImageInfo.a.d);
      localArrayList2.add(localAIOImageInfo.a.h);
      localArrayList3.add(Long.valueOf(localAIOImageInfo.a.b));
    }
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString, this.c, this.d, localArrayList1, localArrayList2, localArrayList3, 2);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "forwardToQZoneAlbum()");
    }
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString, this.d, this.t, (List)this.jdField_a_of_type_JavaUtilArrayList.clone(), this.jdField_b_of_type_Boolean, this.c);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null) && ((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof AIOImageInfo)))
    {
      localBundle = new Bundle();
      localBundle.putInt("forward_type", 12);
      localObject1 = (AIOImageInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localObject2 = ((AIOImageInfo)localObject1).a.a(2);
      localBundle.putString("forward_urldrawable_thumb_url", ((AIOImageInfo)localObject1).a.a(1));
      localBundle.putString("forward_urldrawable_big_url", (String)localObject2);
      localBundle.putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        localBundle.putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + "张图片");
      }
      localBundle.putBoolean("sendMultiple", true);
      localObject1 = new ArrayList();
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(((AIOImageInfo)((Iterator)localObject2).next()).a.jdField_e_of_type_JavaLangString);
      }
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
      localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(localBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 1);
    }
    while (!QLog.isColorLevel())
    {
      Bundle localBundle;
      Object localObject1;
      Object localObject2;
      return;
    }
    QLog.d("AIOImageListScene", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369011);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369010);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((GalleryImage)localIterator.next()).a(2);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
  }
  
  protected View.OnClickListener a()
  {
    return new fyv(this);
  }
  
  protected AbstractImageAdapter a(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = new AIOPhotoListAdapter(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  protected AdapterView.OnItemClickListener a()
  {
    return new fyt(this);
  }
  
  protected GestureSelectGridView.OnSelectListener a()
  {
    return new fyu(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    switch (paramInt1)
    {
    case 10: 
    default: 
      return;
    case 20: 
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131369015) + AppConstants.aK, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492923));
      return;
    case 21: 
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131369016) + AppConstants.aK, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492923));
      return;
    case 22: 
    case 23: 
    case 24: 
      b(3, 0);
      return;
    case 11: 
      b(1, paramInt2);
      return;
    }
    s();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label130;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SendPhotoActivity.class);
      paramIntent = new Bundle(paramIntent.getExtras());
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", false);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      paramIntent.putBoolean("friend_forward_photo", true);
      localIntent.putExtras(paramIntent);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    label130:
    do
    {
      do
      {
        return;
      } while ((99 != paramInt1) && (98 != paramInt1));
      paramIntent = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramIntent.hasNext()) {
        ((GalleryImage)paramIntent.next()).a(2);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter != null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369010);
      }
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 != 1) {
          break;
        }
        localObject1 = ???;
        int i1 = ((AIOImageListModel)localObject3).a(paramLong, paramInt1, paramInt2, (String)localObject1);
        if (paramInt2 == 1)
        {
          int i2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
          int i3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
          if ((i1 >= i2) && (i1 <= i3 + i2 - 1))
          {
            localObject1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i1 - i2);
            ((AIOPhotoListAdapter)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(i1), (View)localObject1);
          }
        }
      } while ((paramInt2 != 2) || (this.jdField_a_of_type_Fyw == null));
      localObject1 = this.jdField_a_of_type_Fyw;
    } while ((((fyw)localObject1).a == null) || (((fyw)localObject1).a.a.jdField_a_of_type_Long != paramLong) || (((fyw)localObject1).a.a.jdField_e_of_type_Int != paramInt1));
    Object localObject3 = ((fyw)localObject1).a.a;
    if (paramInt3 == 1) {}
    for (;;)
    {
      ((AIOImageData)localObject3).jdField_e_of_type_JavaLangString = ???;
      synchronized (((fyw)localObject1).a)
      {
        ((fyw)localObject1).a.notifyAll();
        return;
      }
      String str = "I:E";
      break;
      ??? = "I:E";
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    o();
    super.a(paramViewGroup);
  }
  
  public void a(Integer... paramVarArgs)
  {
    c(paramVarArgs[0].intValue(), 0);
    this.jdField_a_of_type_Fyw = new fyw(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Fyw.execute(paramVarArgs);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = null;
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onStart start FirstVisiblePosition " + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s() + " LastVisiblePosition " + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.t() + " SelectedIndex = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
      i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.d();
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c();
      if ((i2 > i3) || (i2 < i1) || (i2 - i1 < AIOConstants.c))
      {
        if ((i3 <= 0) || (i2 <= i3)) {
          break label312;
        }
        i2 -= i3;
        if ((i2 > AIOConstants.c) && (i2 % AIOConstants.c == 0))
        {
          i1 = i2 + i1 + AIOConstants.c;
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "onStart selectedIndex > lastPosition n " + i1);
          }
          this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.t());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("AIOImageListScene", 2, "onStart end FirstVisiblePosition " + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s() + " LastVisiblePosition " + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.t() + " SelectedIndex = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
      }
    }
    label312:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        int i2;
        int i3;
        return;
        int i1 = i2 + i1 + AIOConstants.c * 2;
        continue;
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
      }
    }
    QLog.d("AIOImageListScene", 2, "onStart error!! mAIOModel == null ");
  }
  
  protected void l()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localActionSheet.a(2131369005);
    localActionSheet.a(2131369006, 5);
    localActionSheet.c(2131368333);
    if (this.jdField_b_of_type_Boolean) {
      localActionSheet.a(2131368342, 5);
    }
    localActionSheet.e(2131365736);
    localActionSheet.a(new fyp(this, localActionSheet));
    localActionSheet.show();
    a("Multi_Pic_Forward", this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "saveAllImage");
    }
    Object localObject = BaseApplication.getContext();
    boolean bool = SettingCloneUtil.readValue((Context)localObject, null, ((Context)localObject).getString(2131366260), "qqsetting_auto_receive_pic_key", true);
    int i1;
    int i2;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      i1 = 1;
      if (NetworkUtil.b(BaseApplication.getContext()) != -1) {
        break label144;
      }
      i2 = 1;
      label64:
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((AIOImageInfo)((Iterator)localObject).next()).a.a(2) != null);
    }
    for (int i3 = 0;; i3 = 1)
    {
      if (i3 != 0) {
        a(new Integer[] { Integer.valueOf(1) });
      }
      for (;;)
      {
        a("Multi_Pic_Save", this.jdField_a_of_type_JavaUtilArrayList.size());
        return;
        i1 = 0;
        break;
        label144:
        i2 = 0;
        break label64;
        if (i2 != 0) {
          b(1, this.jdField_a_of_type_JavaUtilArrayList.size());
        } else if ((bool) || (i1 != 0)) {
          a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
        } else {
          b(0, 0);
        }
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppDialog = null;
    paramDialogInterface = this.jdField_a_of_type_Fyw;
    if (paramDialogInterface != null) {
      fyw.a(paramDialogInterface, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene
 * JD-Core Version:    0.7.0.1
 */