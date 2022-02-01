package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import fwm;
import fwo;
import fwp;
import fwq;
import java.io.File;
import java.net.URL;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class ShortVideoItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  static long jdField_a_of_type_Long = 0L;
  static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "ShortVideoItemBuilder";
  protected final float a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new fwq(this);
  boolean d = false;
  public int f;
  int g;
  
  static
  {
    b = 1000L;
  }
  
  public ShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.f = 0;
  }
  
  public static Drawable a(Context paramContext, int paramInt1, int paramInt2)
  {
    return new RoundRectColorDrawable(-16777216, 12.0F * paramContext.getResources().getDisplayMetrics().density, paramInt1, paramInt2);
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startDownloadVideo");
    }
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "短视频已过期不启动下载流程");
      }
      return;
    }
    Object localObject1 = Environment.getExternalStorageDirectory();
    Object localObject2 = (SplashActivity)SplashActivity.a();
    if (((SplashActivity)localObject2).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      ((SplashActivity)localObject2).permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new fwm(this, (SplashActivity)localObject2));
      return;
    }
    if ((((File)localObject1).exists()) && (((File)localObject1).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label168;
      }
    }
    label168:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label173;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131367289, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
      return;
      i = 0;
      break;
    }
    label173:
    localObject1 = ShortVideoBusiManager.a(2, this.f);
    localObject2 = paramMessageForShortVideo.getDownloadInfo();
    ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_JavaLangString = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.c(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext));
    if (paramMessageForShortVideo.istroop == 0)
    {
      ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1001;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int);
      }
      ((ShortVideoReq)localObject1).a((ShortVideoDownloadInfo)localObject2);
      ((ShortVideoReq)localObject1).a(paramMessageForShortVideo);
      ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (paramMessageForShortVideo.istroop == 3000)
      {
        ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1005;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
      }
      else if (paramMessageForShortVideo.istroop == 1)
      {
        ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1003;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
      }
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    a(paramMessageForShortVideo, paramString1, paramString2, null);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2, Throwable paramThrowable)
  {
    RichMediaUtil.a(paramMessageForShortVideo.istroop, paramMessageForShortVideo.isSendFromLocal(), 65537, String.valueOf(paramMessageForShortVideo.uniseq), "ShortVideoItemBuilder." + paramString1, paramString2, paramThrowable);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramView != null) {
      paramView.a(paramChatMessage, this);
    }
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (ShortVideoItemBuilder.Holder)paramViewHolder;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramViewHolder = paramView;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setBackgroundResource(2130837995);
      paramView = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131298829);
      if (!jdField_a_of_type_Boolean) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMinimumWidth((int)(this.jdField_a_of_type_Float * 100.0F + 0.5F));
      paramView.setMinimumHeight((int)(this.jdField_a_of_type_Float * 100.0F + 0.5F));
      paramView.setMaxWidth((int)(this.jdField_a_of_type_Float * 220.0F + 0.5F));
      paramView.setMaxHeight((int)(this.jdField_a_of_type_Float * 220.0F + 0.5F));
      paramViewHolder.addView(paramView);
      localObject2 = new View(this.jdField_a_of_type_AndroidContentContext);
      ((View)localObject2).setBackgroundResource(2130837996);
      localObject3 = new RelativeLayout.LayoutParams(-2, AIOUtils.a(22.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131298829);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131298829);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131298829);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setTextSize(1, 12.0F);
      ((TextView)localObject2).setTextColor(-1);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(5.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.a(3.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131298829);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131298829);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setTextSize(1, 12.0F);
      ((TextView)localObject3).setTextColor(-1);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).rightMargin = AIOUtils.a(5.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject4).bottomMargin = AIOUtils.a(3.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131298829);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131298829);
      paramViewHolder.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setImageResource(2130841671);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(30.0F, (Resources)localObject1), AIOUtils.a(30.0F, (Resources)localObject1));
      localLayoutParams.addRule(13);
      ((RelativeLayout)localObject4).addView(localImageView, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = AIOUtils.a(22.0F, (Resources)localObject1);
      localLayoutParams.addRule(13);
      paramViewHolder.addView((View)localObject4, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramView;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView = localImageView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewHolder;
    }
    paramView = (MessageForShortVideo)paramChatMessage;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, " getBubbleView " + paramView.toLogString() + "\n" + paramView.toString());
    }
    paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView.videoFileSize));
    paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramView.videoFileTime * 1000));
    localObject1 = ShortVideoUtils.a(paramView.md5, "jpg");
    paramOnLongClickAndTouchListener = ShortVideoUtils.a(paramView, "mp4");
    int i;
    int j;
    if (paramView.thumbWidth > 0)
    {
      i = paramView.thumbWidth;
      if (paramView.thumbHeight <= 0) {
        break label897;
      }
      j = paramView.thumbHeight;
      label720:
      localObject2 = ShortVideoUtils.a(new int[] { i, j });
      localObject3 = this.jdField_a_of_type_AndroidContentContext;
      i = (int)(this.jdField_a_of_type_Float * localObject2[0] + 0.5F);
      float f1 = this.jdField_a_of_type_Float;
      localObject2 = a((Context)localObject3, i, (int)(localObject2[1] * f1 + 0.5F));
      if (paramView.isSendFromLocal()) {
        break label1435;
      }
      if (!FileUtils.b((String)localObject1)) {
        break label904;
      }
      localObject1 = ShortVideoUtils.a((String)localObject1);
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localObject1)))
      {
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (Drawable)localObject2, (Drawable)localObject2);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable((Drawable)localObject1);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject1);
      }
      label863:
      if (!FileUtils.b(paramOnLongClickAndTouchListener)) {
        break label1104;
      }
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841671);
      b(paramBaseChatItemLayout);
    }
    label897:
    label904:
    label1104:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewHolder;
            i = 100;
            break;
            j = 100;
            break label720;
            if (paramView.videoFileStatus == 5002)
            {
              if (!QLog.isColorLevel()) {
                break label863;
              }
              QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载");
              break label863;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图 ");
            }
            paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable((Drawable)localObject2);
            localObject1 = ShortVideoBusiManager.a(2, this.f);
            localObject2 = paramView.getDownloadInfo();
            ((ShortVideoDownloadInfo)localObject2).h = ShortVideoUtils.a(paramView.md5, "jpg");
            if (paramView.istroop == 0) {
              ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1002;
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType=" + ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int);
              }
              ((ShortVideoReq)localObject1).a((ShortVideoDownloadInfo)localObject2);
              ((ShortVideoReq)localObject1).a(paramView);
              ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              break;
              if (paramView.istroop == 3000) {
                ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1006;
              } else if (paramView.istroop == 1) {
                ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1004;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "getBubbleView ，video no exits && not SendFromLocal: fileType:" + ShortVideoUtils.a(paramView.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.b(paramView.videoFileStatus));
            }
            paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841673);
            b(paramBaseChatItemLayout);
          } while ((paramView.fileType != 6) && (paramView.fileType != 17) && (paramView.fileType != 9) && (paramView.fileType != 19));
          switch (paramView.videoFileStatus)
          {
          default: 
            b(paramBaseChatItemLayout);
            return paramViewHolder;
          case 2001: 
            a(paramBaseChatItemLayout);
            j = paramView.videoFileProgress;
            paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar;
            i = j;
            if (j == 0) {
              i = 1;
            }
            paramChatMessage.setProgress(i);
            return paramViewHolder;
          case 2004: 
            a(paramBaseChatItemLayout);
            j = paramView.videoFileProgress;
            paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar;
            i = j;
            if (j == 0) {
              i = 1;
            }
            paramChatMessage.setProgress(i);
            paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837578);
            return paramViewHolder;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq) != null);
        b(paramBaseChatItemLayout);
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : SHORT_VIDEO <-- STATUS_RECV_PROCESS, 下载过程中被杀进程然后恢复");
      return paramViewHolder;
      b(paramBaseChatItemLayout);
      return paramViewHolder;
      b(paramBaseChatItemLayout);
      return paramViewHolder;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841671);
      paramOnLongClickAndTouchListener = ShortVideoUtils.a((String)localObject1);
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramOnLongClickAndTouchListener)))
      {
        paramOnLongClickAndTouchListener = URLDrawable.getDrawable(paramOnLongClickAndTouchListener, (Drawable)localObject2, (Drawable)localObject2);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = paramOnLongClickAndTouchListener;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView SendFromLocal: fileType:" + ShortVideoUtils.a(paramView.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.b(paramView.videoFileStatus) + ",videoFileProgress:" + paramView.videoFileProgress);
      }
      if ((paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768)) {
        break label1792;
      }
    } while ((paramView.fileType != 6) && (paramView.fileType != 17) && (paramView.fileType != 9) && (paramView.fileType != 19));
    label1435:
    switch (paramView.videoFileStatus)
    {
    default: 
      return paramViewHolder;
    case 1001: 
      a(paramBaseChatItemLayout);
      j = paramView.videoFileProgress;
      paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar;
      i = j;
      if (j == 0) {
        i = 1;
      }
      paramChatMessage.setProgress(i);
      return paramViewHolder;
    case 1004: 
      a(paramBaseChatItemLayout);
      j = paramView.videoFileProgress;
      paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar;
      i = j;
      if (j == 0) {
        i = 1;
      }
      paramChatMessage.setProgress(i);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837578);
      return paramViewHolder;
    case 1002: 
      a(paramBaseChatItemLayout, paramView);
      return paramViewHolder;
    case 1003: 
      b(paramBaseChatItemLayout);
      return paramViewHolder;
    }
    b(paramBaseChatItemLayout);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    return paramViewHolder;
    label1792:
    b(paramBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "视频消息";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      paramContext = (MessageForShortVideo)paramChatMessage;
      this.jdField_g_of_type_Int = paramInt;
      if (paramInt == 2131302479) {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.a(2131366317, 5);
      localActionSheet.e(2131365736);
      localActionSheet.a(new fwp(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject1 = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((MessageForShortVideo)localObject1).uniseq != paramFileMsg.c) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + ((MessageForShortVideo)localObject1).uniseq + ",fileType:" + ShortVideoUtils.a(paramFileMsg.jdField_e_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(paramFileMsg.D));
                  }
                  if ((paramFileMsg.jdField_e_of_type_Int != 6) && (paramFileMsg.jdField_e_of_type_Int != 17) && (paramFileMsg.jdField_e_of_type_Int != 9)) {
                    break;
                  }
                  switch (paramFileMsg.D)
                  {
                  case 1004: 
                  case 2004: 
                  default: 
                    return;
                  case 1001: 
                    a(paramView);
                    if (paramFileMsg.jdField_a_of_type_Long != 0L)
                    {
                      paramInt2 = (int)(100L * paramFileMsg.jdField_e_of_type_Long / paramFileMsg.jdField_a_of_type_Long);
                      paramFileMsg = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
                      paramInt1 = paramInt2;
                      if (paramInt2 == 0) {
                        paramInt1 = 1;
                      }
                      paramFileMsg.setProgress(paramInt1);
                    }
                    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                    return;
                  case 1003: 
                    b(paramView);
                    return;
                  case 1005: 
                    b(paramView);
                    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                    return;
                  }
                } while (!((MessageForShortVideo)localObject1).isSendFromLocal());
                if (paramFileMsg.jdField_a_of_type_Long != 0L)
                {
                  paramInt2 = (int)(100L * paramFileMsg.jdField_e_of_type_Long / paramFileMsg.jdField_a_of_type_Long);
                  if ((paramView.jdField_a_of_type_AndroidWidgetProgressBar == null) || (paramView.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)) {
                    a(paramView);
                  }
                  paramView = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
                  if (paramInt2 == 0) {}
                  for (paramInt1 = 1;; paramInt1 = paramInt2)
                  {
                    paramView.setProgress(paramInt1);
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS, progress=" + paramInt2);
                    return;
                  }
                }
              } while (!QLog.isColorLevel());
              QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
              return;
              if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
                paramView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841673);
              }
              a(paramView);
            } while (paramFileMsg.jdField_a_of_type_Long == 0L);
            paramInt1 = (int)(100L * paramFileMsg.jdField_e_of_type_Long / paramFileMsg.jdField_a_of_type_Long);
            paramView = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
            if (paramInt1 == 0) {
              paramInt1 = 1;
            }
            for (;;)
            {
              paramView.setProgress(paramInt1);
              return;
            }
            if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
              paramView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841671);
            }
            b(paramView);
            paramView = ShortVideoUtils.a(((MessageForShortVideo)localObject1).md5, "jpg");
          } while (FileUtils.b(paramView));
          paramFileMsg = ShortVideoBusiManager.a(2, this.f);
          localObject2 = ((MessageForShortVideo)localObject1).getDownloadInfo();
          ((ShortVideoDownloadInfo)localObject2).h = paramView;
          if (((MessageForShortVideo)localObject1).istroop == 0) {
            ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1002;
          }
          for (;;)
          {
            paramFileMsg.a((ShortVideoDownloadInfo)localObject2);
            paramFileMsg.a((MessageForShortVideo)localObject1);
            ShortVideoBusiManager.a(paramFileMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
            if (((MessageForShortVideo)localObject1).istroop == 3000) {
              ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1006;
            } else if (((MessageForShortVideo)localObject1).istroop == 1) {
              ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1004;
            }
          }
          b(paramView);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131369551, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
          return;
          b(paramView);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131369552, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
          return;
          b(paramView);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131369553, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
          return;
        } while (((MessageForShortVideo)localObject1).isSendFromLocal());
        if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
          paramView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841673);
        }
        if (paramFileMsg.jdField_a_of_type_Long != 0L)
        {
          paramInt2 = (int)(100L * paramFileMsg.jdField_e_of_type_Long / paramFileMsg.jdField_a_of_type_Long);
          if ((paramView.jdField_a_of_type_AndroidWidgetProgressBar == null) || (paramView.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)) {
            a(paramView);
          }
          paramView = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
          if (paramInt2 == 0) {}
          for (paramInt1 = 1;; paramInt1 = paramInt2)
          {
            paramView.setProgress(paramInt1);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: progress=" + paramInt2);
            return;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: fileSize == 0 ");
      return;
    } while ((paramFileMsg.jdField_e_of_type_Int != 7) && (paramFileMsg.jdField_e_of_type_Int != 18) && (paramFileMsg.jdField_e_of_type_Int != 16));
    switch (paramFileMsg.D)
    {
    case 2001: 
    case 2002: 
    default: 
      return;
    }
    paramFileMsg = ShortVideoUtils.a(ShortVideoUtils.a(((MessageForShortVideo)localObject1).md5, "jpg"));
    if (((MessageForShortVideo)localObject1).thumbWidth > 0)
    {
      paramInt1 = ((MessageForShortVideo)localObject1).thumbWidth;
      label986:
      if (((MessageForShortVideo)localObject1).thumbHeight <= 0) {
        break label1117;
      }
    }
    label1117:
    for (paramInt2 = ((MessageForShortVideo)localObject1).thumbHeight;; paramInt2 = 100)
    {
      localObject1 = ShortVideoUtils.a(new int[] { paramInt1, paramInt2 });
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      paramInt1 = (int)(this.jdField_a_of_type_Float * localObject1[0] + 0.5F);
      float f1 = this.jdField_a_of_type_Float;
      localObject1 = a((Context)localObject2, paramInt1, (int)(localObject1[1] * f1 + 0.5F));
      if ((paramView.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramFileMsg))) {
        break;
      }
      paramFileMsg = URLDrawable.getDrawable(paramFileMsg, (Drawable)localObject1, (Drawable)localObject1);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramFileMsg);
      paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
      return;
      paramInt1 = 100;
      break label986;
    }
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder)
  {
    BaseChatItemLayout localBaseChatItemLayout = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    Object localObject;
    if (paramHolder.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903152, null));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131296322);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131296322);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131296322);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.k;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseChatItemLayout.k;
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(-2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localBaseChatItemLayout.addView(paramHolder.jdField_a_of_type_AndroidWidgetProgressBar, (ViewGroup.LayoutParams)localObject);
    }
    while (paramHolder.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject).setId(2131296423);
      ((ImageView)localObject).setImageResource(2130837577);
      ((ImageView)localObject).setContentDescription("取消");
      ((ImageView)localObject).setOnClickListener(this);
      int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject).setPadding(i, i, i, i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131297111);
      localLayoutParams.addRule(3, 2131296322);
      localLayoutParams.topMargin = (-(BaseChatItemLayout.i + i));
      localLayoutParams.leftMargin = (-i);
      localBaseChatItemLayout.addView((View)localObject, localLayoutParams);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
      return;
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837577);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq) == null)
    {
      b(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复");
      }
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo");
    }
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.md5, "jpg");
    if (!FileUtils.b(str1))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131369542, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
      b(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.b(str2))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131369543, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
      b(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    paramHolder = ShortVideoBusiManager.a(1, this.f);
    paramHolder.a(ShortVideoBusiManager.a(this.f, paramMessageForShortVideo, paramHolder));
    ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      if (paramChatMessage.videoFileStatus != 1005)
      {
        bool1 = bool2;
        if (paramChatMessage.extraflag != 32768) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForShortVideo)((ShortVideoItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.d = true;
    return paramView.a();
  }
  
  protected void b(ShortVideoItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
    }
    if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("cancelpic", 2, "mMenuClickedID:" + this.jdField_g_of_type_Int);
    }
    if ((this.jdField_g_of_type_Int != 2131302480) && (this.jdField_g_of_type_Int != 2131302481)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_g_of_type_Int = -1;
    this.d = false;
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = 0;
    AIOUtils.h = true;
    long l = System.currentTimeMillis();
    if ((l - jdField_a_of_type_Long < b) && (l > jdField_a_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
      return;
    }
    jdField_a_of_type_Long = l;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == 2131296322)
    {
      localObject3 = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
      localObject1 = (MessageForShortVideo)((ShortVideoItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "click bubble, msg.uniseq:" + ((MessageForShortVideo)localObject1).uniseq + ",fileType:" + ShortVideoUtils.a(((MessageForShortVideo)localObject1).fileType) + " ===> fileStatus:" + ShortVideoUtils.b(((MessageForShortVideo)localObject1).videoFileStatus));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131369561, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
        return;
      }
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        localObject2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
        if (!FileUtils.b((String)localObject2)) {
          if ((((ShortVideoItemBuilder.Holder)localObject3).jdField_a_of_type_AndroidWidgetImageView == null) || (((ShortVideoItemBuilder.Holder)localObject3).jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0))
          {
            a((MessageForShortVideo)localObject1);
            if (((MessageForShortVideo)localObject1).videoFileStatus == 5002)
            {
              b((ShortVideoItemBuilder.Holder)localObject3);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131369553, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
            }
          }
        }
      }
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      boolean bool2 = ShortVideoUtils.a((String)localObject2, ((MessageForShortVideo)localObject1).lastModified);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = ShortVideoUtils.a((String)localObject2, ((MessageForShortVideo)localObject1).md5);
      }
      if (bool1)
      {
        localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.class);
        ((Intent)localObject3).putExtra("file_send_path", (String)localObject2);
        ((Intent)localObject3).putExtra("file_send_duration", ((MessageForShortVideo)localObject1).videoFileTime);
        ((Intent)localObject3).putExtra("file_shortvideo_md5", ((MessageForShortVideo)localObject1).md5);
        ((Intent)localObject3).putExtra("uintype", ((MessageForShortVideo)localObject1).istroop);
        ((Intent)localObject3).putExtra("is_activity_to_fragment", false);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
        ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968627, 2130968628);
        ThreadManager.a().post(this.jdField_a_of_type_JavaLangRunnable);
      }
      else
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, this.jdField_a_of_type_AndroidContentContext.getString(2131369554), null, new fwo(this, (String)localObject2, (ShortVideoItemBuilder.Holder)localObject3), null).show();
        continue;
        localObject2 = ((MessageForShortVideo)localObject1).videoFileName;
        if (!FileUtils.b((String)localObject2))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131369541, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
        }
        else
        {
          localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.class);
          ((Intent)localObject3).putExtra("file_send_path", (String)localObject2);
          ((Intent)localObject3).putExtra("file_send_duration", ((MessageForShortVideo)localObject1).videoFileTime);
          ((Intent)localObject3).putExtra("file_shortvideo_md5", ((MessageForShortVideo)localObject1).md5);
          ((Intent)localObject3).putExtra("uintype", ((MessageForShortVideo)localObject1).istroop);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
          ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968627, 2130968628);
          ThreadManager.a().post(this.jdField_a_of_type_JavaLangRunnable);
          continue;
          if (paramView.getId() == 2131296423)
          {
            localObject1 = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
            localObject2 = (MessageForShortVideo)((ShortVideoItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "click cancleBtn msg.uniseq:" + ((MessageForShortVideo)localObject2).uniseq + ",fileType:" + ShortVideoUtils.a(((MessageForShortVideo)localObject2).fileType) + " ===> fileStatus:" + ShortVideoUtils.b(((MessageForShortVideo)localObject2).videoFileStatus));
            }
            if (!((MessageForShortVideo)localObject2).isSendFromLocal())
            {
              if (((((MessageForShortVideo)localObject2).fileType == 6) || (((MessageForShortVideo)localObject2).fileType == 17) || (((MessageForShortVideo)localObject2).fileType == 9)) && (((MessageForShortVideo)localObject2).videoFileStatus == 2004)) {}
              for (;;)
              {
                if (i == 0) {
                  break label821;
                }
                ((ShortVideoItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837577);
                a((MessageForShortVideo)localObject2);
                break;
                i = 0;
              }
              label821:
              if (((MessageForShortVideo)localObject2).videoFileStatus == 2005)
              {
                b((ShortVideoItemBuilder.Holder)localObject1);
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131369551, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
              }
              else if (((MessageForShortVideo)localObject2).videoFileStatus == 5001)
              {
                b((ShortVideoItemBuilder.Holder)localObject1);
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131369552, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
              }
              else if (((MessageForShortVideo)localObject2).videoFileStatus == 5002)
              {
                b((ShortVideoItemBuilder.Holder)localObject1);
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131369553, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492923));
              }
              else
              {
                ((ShortVideoItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837578);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).uniseq);
              }
            }
            else
            {
              i = j;
              if (((MessageForShortVideo)localObject2).videoFileStatus == 1004) {
                i = 1;
              }
              if (i != 0)
              {
                ((ShortVideoItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837577);
                a((MessageForShortVideo)localObject2, (ShortVideoItemBuilder.Holder)localObject1);
              }
              else if (((MessageForShortVideo)localObject2).videoFileStatus == 1005)
              {
                b((ShortVideoItemBuilder.Holder)localObject1);
                ((ShortVideoItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              }
              else
              {
                ((ShortVideoItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837578);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).uniseq);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */