package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.QQToast;
import java.net.URL;

public class FloatPicItemBuilder
  extends FloatBaseBubbleBuilder
  implements FileTransferManager.Callback
{
  FloatImagePreview a;
  
  public FloatPicItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private void a(Context paramContext, ChatThumbView paramChatThumbView, MessageForPic paramMessageForPic, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview = new FloatImagePreview(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramContext = new Bundle();
    paramContext.putParcelable("FLOAT_IMAGE_DATA", AIOGalleryUtils.a(paramMessageForPic));
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(paramContext, paramMessageForPic);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a();
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, FloatPicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_AndroidViewView == null) {}
    int i;
    Object localObject;
    do
    {
      return;
      if (!(paramIHttpCommunicatorListener instanceof BaseTransProcessor)) {
        break;
      }
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      i = (int)paramIHttpCommunicatorListener.c();
      switch (i)
      {
      default: 
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
        }
        if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setProgressVisable(false);
        return;
      case 1006: 
        if (paramIHttpCommunicatorListener.b())
        {
          if (paramHolder.jdField_a_of_type_AndroidWidgetImageView == null)
          {
            paramIHttpCommunicatorListener = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramIHttpCommunicatorListener.setImageResource(2130841544);
            paramIHttpCommunicatorListener.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131298829);
            ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131298829);
            ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131298829);
            ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131298829);
            ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView(paramIHttpCommunicatorListener, (ViewGroup.LayoutParams)localObject);
            paramHolder.jdField_a_of_type_AndroidWidgetImageView = paramIHttpCommunicatorListener;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
          {
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
            ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setProgressVisable(false);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setProgressVisable(false);
      }
    } while (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a = true;
    return;
    if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
    {
      localObject = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
      ((MessageProgressTextView)localObject).setTextColor(-1);
      ((MessageProgressTextView)localObject).setTextSize(2, 15.0F);
      ((MessageProgressTextView)localObject).setGravity(17);
      ((MessageProgressTextView)localObject).setBackgroundDrawable(new AIOSendMask(2130706432, this.jdField_a_of_type_Float * 12.0F));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131298829);
      localLayoutParams.addRule(8, 2131298829);
      localLayoutParams.addRule(5, 2131298829);
      localLayoutParams.addRule(7, 2131298829);
      ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView((View)localObject, localLayoutParams);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)localObject);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(paramIHttpCommunicatorListener);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null) && ((1001 == i) || (1002 == i))) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a = false;
    }
    if (i != 1002)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setProgressVisable(true);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setProgressVisable(false);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
    return;
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
      ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
    }
    if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout.setProgressVisable(false);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected View a(ChatMessage paramChatMessage, FloatBaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    paramFloatBaseChatItemLayout = (FloatPicItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
      ((ChatThumbView)localObject).setId(2131298829);
      if (!BaseBubbleBuilder.a) {
        ((ChatThumbView)localObject).setAdjustViewBounds(true);
      }
      ((ChatThumbView)localObject).setMaxWidth(AIOUtils.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((ChatThumbView)localObject).setMaxHeight(AIOUtils.a(URLDrawableHelper.f, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramViewHolder = new RelativeLayout.LayoutParams(-2, -2);
      paramViewHolder.addRule(13);
      paramView.addView((View)localObject, paramViewHolder);
      paramViewHolder = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.addView(paramView, new FrameLayout.LayoutParams(-2, -2));
      paramViewHolder.setOnClickListener(this);
      paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = ((ChatThumbView)localObject);
      paramFloatBaseChatItemLayout.b = paramViewHolder;
    }
    paramView = (MessageForPic)paramChatMessage;
    Object localObject = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null) {
      ((FileTransferManager)localObject).a(paramViewHolder, this);
    }
    b(paramViewHolder, paramChatMessage);
    if (!paramView.isSendFromLocal())
    {
      if (paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
      {
        paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.clearAnimation();
        paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        ((RelativeLayout)paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidViewView).removeView(paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
        paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
      }
      if (paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramChatMessage = URLDrawableHelper.a(paramView, 65537);
      if ((paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramChatMessage)))
      {
        paramChatMessage = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, 28.0F);
        paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramChatMessage);
        paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, 2);
      }
      return paramViewHolder;
    }
    paramChatMessage = URLDrawableHelper.a(paramView, 65537);
    if ((paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramChatMessage)))
    {
      paramChatMessage = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, 28.0F);
      paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramChatMessage);
      paramFloatBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
    }
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq);
    paramFloatBaseChatItemLayout.jdField_a_of_type_AndroidViewView = paramViewHolder;
    a(paramChatMessage, paramFloatBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected FloatBaseBubbleBuilder.ViewHolder a()
  {
    return new FloatPicItemBuilder.Holder(this);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (((paramFileMsg.e != 1) && (paramFileMsg.e != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001)) {}
    do
    {
      MessageForPic localMessageForPic;
      do
      {
        do
        {
          return;
          paramView = (FloatPicItemBuilder.Holder)AIOUtils.a(paramView);
        } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while (localMessageForPic.uniseq != paramFileMsg.c);
      if (localMessageForPic.isSendFromLocal())
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
        if (paramInt1 == 1005) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatBaseChatItemLayout);
        }
      }
    } while (paramInt1 != 2003);
    paramFileMsg = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, 28.0F);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramFileMsg);
    paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
  }
  
  protected boolean a(ChatMessage paramChatMessage, FloatBaseChatItemLayout paramFloatBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        return false;
      } while (!paramChatMessage.isSendFromLocal());
      paramChatMessage = (MessageForPic)paramChatMessage;
    } while (paramChatMessage.size > 0L);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
    if ((paramChatMessage instanceof BaseTransProcessor))
    {
      if (((BaseTransProcessor)paramChatMessage).c() == 1005L) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(true);
    }
  }
  
  protected void b(View paramView, ChatMessage paramChatMessage)
  {
    int i = (int)(this.jdField_a_of_type_Float * 2.0F + 0.5F);
    int j = (int)(this.jdField_a_of_type_Float * 8.0F + 0.5F);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(i, i, j, i);
      return;
    }
    paramView.setPadding(j, i, i, i);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.h = true;
    if (paramView.getId() == 2131296322)
    {
      paramView = (FloatPicItemBuilder.Holder)AIOUtils.a(paramView);
      MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      Object localObject = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
      if (!localMessageForPic.isSendFromLocal())
      {
        switch (((URLDrawable)localObject).getStatus())
        {
        default: 
        case 2: 
        case 0: 
          do
          {
            do
            {
              return;
              if ((Utils.e()) && (Utils.b() < 20971520L))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, "手机存储空间已满，请清理后重新进入QQ。", 0).a();
                return;
              }
            } while (!FileUtils.a(this.jdField_a_of_type_AndroidContentContext));
            ((URLDrawable)localObject).restartDownload();
            return;
          } while (((URLDrawable)localObject).isDownloadStarted());
          ((URLDrawable)localObject).startDownload();
          return;
        }
        a(this.jdField_a_of_type_AndroidContentContext, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
      if (((URLDrawable)localObject).getStatus() == 2)
      {
        if ((Utils.e()) && (Utils.b() < 20971520L))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, "手机存储空间已满，请清理后重试。", 0).a();
          return;
        }
        if (FileUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
          ((URLDrawable)localObject).restartDownload();
        }
      }
      if (localMessageForPic.size <= 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
        if ((localObject instanceof BaseTransProcessor))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((((BaseTransProcessor)localObject).b()) && (((BaseTransProcessor)localObject).c()))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localMessageForPic.frienduin, String.valueOf(localMessageForPic.uniseq));
            return;
          }
        }
      }
      a(this.jdField_a_of_type_AndroidContentContext, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */