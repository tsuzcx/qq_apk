package com.tencent.mobileqq.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import jmz;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class VipProfileCardPhotoHandlerActivity
  extends BaseActivity
{
  public static final String a = "select_photo";
  public static final String b = "take_photo";
  public static final String c = "photo_edit_complete";
  public static final String d = "action";
  private Uri jdField_a_of_type_AndroidNetUri;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("PhotoConst.COMPRESS_QUALITY", 80);
    PhotoUtils.a(localIntent, this, VipProfileCardPhotoHandlerActivity.class.getName(), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.d());
    finish();
  }
  
  private void b()
  {
    if ((!this.permissionManager.checkPermission("android.permission.CAMERA")) || (!this.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
    {
      this.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 100) }).requests(new jmz(this));
      return;
    }
    this.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this, 5);
  }
  
  protected void a(Uri paramUri)
  {
    paramUri = ImageUtil.c(this, paramUri);
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("PhotoConst.COMPRESS_QUALITY", 80);
    PhotoUtils.a(localIntent, this, VipProfileCardPhotoHandlerActivity.class.getName(), ProfileCardUtil.b(this), ProfileCardUtil.a(this), ProfileCardUtil.b(this), ProfileCardUtil.a(this), paramUri, ProfileCardUtil.d());
  }
  
  protected void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent(this, VipProfileCardPreviewActivity.class);
      localIntent.putExtra("custom_card_background", paramString);
      startActivity(localIntent);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 5) && (paramInt2 == -1))
    {
      this.b = true;
      a(this.jdField_a_of_type_AndroidNetUri);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getStringExtra("action"))))
    {
      if (!paramBundle.getStringExtra("action").equals("select_photo")) {
        break label47;
      }
      a();
    }
    for (;;)
    {
      return true;
      label47:
      if (paramBundle.getStringExtra("action").equals("take_photo")) {
        b();
      } else if (paramBundle.getStringExtra("action").equals("photo_edit_complete")) {
        doOnNewIntent(paramBundle);
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"));
    finish();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Boolean)
    {
      if (!this.b) {
        finish();
      }
    }
    else {
      return;
    }
    this.b = false;
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity
 * JD-Core Version:    0.7.0.1
 */