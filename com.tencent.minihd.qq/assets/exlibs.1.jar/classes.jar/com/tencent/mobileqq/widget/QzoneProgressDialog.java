package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import cooperation.qzone.widget.ExtendButton;

public class QzoneProgressDialog
  extends Dialog
{
  public static final int a = 1;
  public static final String a = "QZoneUploadPhotoActivity.key_state_type_src";
  public static final int b = 2;
  public static final String b = "key_alubm_name";
  public static final int c = 0;
  public static final String c = "key_album_face_uin";
  public static final int d = 1;
  public static final String d = "key_album_face_nickname";
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 10;
  public static final int n = 11;
  private TextView a;
  
  public QzoneProgressDialog(Context paramContext, Intent paramIntent)
  {
    super(paramContext, 2131558900);
    String str2 = paramIntent.getStringExtra("qzone_plugin_activity_name");
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2130904277, null);
    Object localObject2 = getWindow();
    ((Window)localObject2).setWindowAnimations(2131558901);
    ((Window)localObject2).setContentView((View)localObject1);
    Object localObject3 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject3).width = -1;
    ((WindowManager.LayoutParams)localObject3).height = -1;
    ((WindowManager.LayoutParams)localObject3).gravity = 48;
    ((WindowManager.LayoutParams)localObject3).y = ((WindowManager.LayoutParams)localObject3).y;
    ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
    setCanceledOnTouchOutside(false);
    this.a = ((TextView)((View)localObject1).findViewById(2131297007));
    localObject2 = paramIntent.getStringExtra("leftViewText");
    if (localObject2 == null) {
      localObject2 = paramContext.getString(2131366374);
    }
    for (;;)
    {
      if ("com.qzone.album.ui.activity.QZonePersonalAlbumActivity".equals(str2))
      {
        localObject3 = ((ViewStub)((View)localObject1).findViewById(2131301590)).inflate();
        localObject1 = paramIntent.getStringExtra("key_left_tab_title");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1088;
        }
        localObject1 = paramContext.getString(2131365482);
      }
      label1088:
      for (;;)
      {
        paramIntent = paramIntent.getStringExtra("key_rihgt_tab_title");
        if (TextUtils.isEmpty(paramIntent)) {}
        for (paramContext = paramContext.getString(2131365484);; paramContext = paramIntent)
        {
          paramIntent = (ExtendButton)((View)localObject3).findViewById(2131301299);
          Object localObject4 = (ExtendButton)((View)localObject3).findViewById(2131301300);
          paramIntent.setText((CharSequence)localObject1);
          ((ExtendButton)localObject4).setText(paramContext);
          ((ExtendButton)localObject4).setSelected(false);
          paramIntent.setSelected(true);
          paramContext = (Context)localObject3;
          ((TextView)paramContext.findViewById(2131297357)).setText((CharSequence)localObject2);
          ((ProgressBar)((ViewStub)paramContext.findViewById(2131298584)).inflate()).setVisibility(0);
          return;
          localObject4 = ((ViewStub)((View)localObject1).findViewById(2131301591)).inflate();
          TextView localTextView = (TextView)((ViewStub)((View)localObject4).findViewById(2131297348)).inflate();
          String str1 = "";
          long l1;
          if ("com.qzone.homepage.ui.activity.QZoneUserHomeActivity".equals(str2))
          {
            l1 = paramIntent.getLongExtra("qqid", 0L);
            paramContext = paramIntent.getStringExtra("qzone_uin");
            if (String.valueOf(Long.valueOf(l1)).equals(paramContext))
            {
              localObject1 = "我的空间";
              localObject3 = localObject2;
            }
          }
          for (;;)
          {
            localTextView.setText((CharSequence)localObject1);
            paramContext = (Context)localObject4;
            localObject2 = localObject3;
            break;
            localObject1 = "";
            localObject3 = localObject2;
            continue;
            if ("com.qzone.feed.ui.activity.QZoneFriendFeedActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131366548);
              localObject3 = paramContext.getString(2131365116);
            }
            else if ("com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131365415);
              localObject3 = localObject2;
            }
            else if ("com.qzone.cover.ui.activity.QZoneCoverStoreActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131365420);
              localObject3 = localObject2;
            }
            else if ("com.qzone.detail.ui.activity.QzoneDetailActivity".equals(str2))
            {
              localObject1 = str1;
              localObject3 = localObject2;
              if (paramIntent.getBooleanExtra("qzone.sourceFrom", false))
              {
                localObject3 = paramContext.getString(2131369083);
                localObject1 = str1;
              }
            }
            else if ("com.qzone.publish.ui.activity.QZoneUploadPhotoActivity".equals(str2))
            {
              str1 = paramContext.getString(2131365189);
              int i1 = paramIntent.getIntExtra("QZoneUploadPhotoActivity.key_state_type_src", -1);
              paramIntent = paramIntent.getAction();
              localObject1 = str1;
              localObject3 = localObject2;
              if (!TextUtils.isEmpty(paramIntent))
              {
                if (paramIntent.equals("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN")) {
                  i1 = 5;
                }
                for (;;)
                {
                  switch (i1)
                  {
                  case 9: 
                  case 10: 
                  default: 
                    localObject1 = str1;
                    localObject3 = localObject2;
                    break;
                  case 3: 
                  case 4: 
                  case 5: 
                  case 6: 
                  case 7: 
                  case 8: 
                  case 11: 
                    localObject1 = paramContext.getString(2131365585);
                    localObject3 = localObject2;
                    break;
                    if (paramIntent.equals("com.tencent.intent.QZONE_QUOTE_FROM_AIO")) {
                      i1 = 11;
                    }
                    break;
                  }
                }
              }
            }
            else if ("com.qzone.lbsv2.ui.QZoneMoodSelectLocation".equals(str2))
            {
              localObject1 = paramContext.getString(2131365130);
              localObject3 = localObject2;
            }
            else if ("com.qzone.setting.QZoneSettingManager".equals(str2))
            {
              localObject1 = paramContext.getString(2131365276);
              localObject3 = localObject2;
            }
            else if ("com.qzone.album.ui.activity.QZonePersonalPhotoListActivity".equals(str2))
            {
              l1 = paramIntent.getLongExtra("key_album_face_uin", 0L);
              paramContext = paramIntent.getStringExtra("key_alubm_name");
              paramIntent = paramIntent.getStringExtra("key_album_face_nickname");
              if ((Long.valueOf(l1).longValue() != 0L) && (!TextUtils.isEmpty(paramIntent)))
              {
                localObject1 = paramIntent + "的照片";
                localObject3 = localObject2;
              }
              else
              {
                localObject1 = paramContext;
                localObject3 = localObject2;
                if (paramContext == null)
                {
                  localObject1 = "";
                  localObject3 = localObject2;
                }
              }
            }
            else if ("com.qzone.publish.ui.activity.QZonePublishMoodActivity".equals(str2))
            {
              localObject1 = paramIntent.getStringExtra("key_title");
              localObject3 = localObject2;
            }
            else if ("com.qzone.publish.ui.activity.QZonePublishQueueAcitvity".equals(str2))
            {
              localObject1 = paramContext.getString(2131369612);
              localObject3 = localObject2;
            }
            else if ("com.qzone.qun.ui.activity.QzoneQunFeedActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131365496);
              localObject3 = localObject2;
            }
            else if ("com.qzone.qun.ui.activity.QzoneQunMsgbListActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131365308);
              localObject3 = localObject2;
            }
            else if ("com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131365271);
              localObject3 = localObject2;
            }
            else if ("com.qzone.qun.ui.activity.QZoneTroopAlbumListActivity".equals(str2))
            {
              switch (paramIntent.getIntExtra("QZoneTroopAlbumListActivity.key_state_type_src", 0))
              {
              default: 
                localObject1 = paramContext.getString(2131365296);
                localObject3 = localObject2;
                break;
              case 1: 
                localObject1 = paramContext.getString(2131365160);
                localObject3 = localObject2;
                break;
              case 2: 
                localObject1 = paramContext.getString(2131365161);
                localObject3 = localObject2;
                break;
              }
            }
            else
            {
              localObject1 = str1;
              localObject3 = localObject2;
              if ("com.qzone.qun.ui.activity.QzoneTroopAlbumViewPhotoActivity".equals(str2))
              {
                localObject1 = paramIntent.getStringExtra("key_album_name");
                localObject3 = localObject2;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.a.setText(paramInt);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QzoneProgressDialog
 * JD-Core Version:    0.7.0.1
 */