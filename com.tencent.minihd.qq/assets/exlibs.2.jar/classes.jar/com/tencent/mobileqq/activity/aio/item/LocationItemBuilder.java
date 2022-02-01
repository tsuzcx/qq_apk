package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import fup;
import fuq;
import fur;
import fus;
import java.net.MalformedURLException;
import java.net.URL;

public class LocationItemBuilder
  extends BaseBubbleBuilder
{
  float jdField_a_of_type_Float = 2.0F;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fup(this);
  
  public LocationItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a()
  {
    Bitmap localBitmap1 = BitmapManager.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838295);
    if (localBitmap1 == null) {
      return null;
    }
    int i = localBitmap1.getWidth();
    int j = localBitmap1.getHeight();
    Bitmap localBitmap2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localBitmap2.setDensity(160);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-16777216);
    Rect localRect = new Rect(0, 0, i, j);
    RectF localRectF = new RectF(localRect);
    float f = 11.0F * this.jdField_a_of_type_Float;
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(localBitmap1, localRect, localRect, localPaint);
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
      localBitmap1.recycle();
    }
    return new BitmapDrawable(localBitmap2);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (fus)paramChatMessage.getTag();
    paramInt1 = AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt2 = paramView.c.getPaddingLeft();
    int i = paramView.c.getPaddingRight();
    int j = paramView.c.getPaddingTop();
    int k = paramView.c.getPaddingBottom();
    paramView.c.setPadding(paramInt2 + paramInt1, j + paramInt1, i + paramInt1, paramInt1 + k);
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    fus localfus = (fus)paramViewHolder;
    paramBaseChatItemLayout = (MessageForText)paramChatMessage;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903142, null);
      localfus.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297062));
      localfus.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131297061));
    }
    paramView = paramBaseChatItemLayout.location;
    if ((paramView == null) || (paramView.length() == 0)) {
      localfus.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramView = paramBaseChatItemLayout.locationUrl;
      try
      {
        paramBaseChatItemLayout = new URL("location", paramView.getAuthority(), paramView.getFile());
        paramView = paramBaseChatItemLayout;
      }
      catch (MalformedURLException paramBaseChatItemLayout)
      {
        for (;;)
        {
          paramBaseChatItemLayout.printStackTrace();
        }
      }
      paramView = URLDrawable.getDrawable(paramView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramChatMessage);
      localfus.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
      paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      return paramViewHolder;
      localfus.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localfus.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new fus(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了地理位置";
  }
  
  String a(MessageForText paramMessageForText)
  {
    return AppConstants.bu + paramMessageForText.latitude + "_" + paramMessageForText.longitude + ".png";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131298174)
    {
      Object localObject = (MessageForText)paramChatMessage;
      paramChatMessage = new Bundle();
      paramChatMessage.putInt("forward_type", -2);
      paramChatMessage.putString("forward_latitude", ((MessageForText)localObject).latitude);
      paramChatMessage.putString("forward_longitude", ((MessageForText)localObject).longitude);
      paramChatMessage.putString("forward_location", ((MessageForText)localObject).location);
      paramChatMessage.putString("forward_filepath", ((MessageForText)localObject).url);
      paramChatMessage.putString("forward_thumb", a((MessageForText)localObject));
      paramChatMessage.putString("forward_location_string", ((MessageForText)localObject).location);
      localObject = new Intent(paramContext, ForwardRecentActivity.class);
      ((Intent)localObject).putExtras(paramChatMessage);
      ((ChatActivity)paramContext).startActivityForResult((Intent)localObject, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 2131302479)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131298924)
      {
        paramContext = (MessageForText)paramChatMessage;
        QfavBuilder.a(Float.valueOf(paramContext.latitude).floatValue(), Float.valueOf(paramContext.longitude).floatValue(), null, paramContext.location, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
        return;
      }
    } while (paramInt != 2131302486);
    a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131366317);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131366318);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new fuq(this, paramView), new fur(this)).show();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131298174, this.jdField_a_of_type_AndroidContentContext.getString(2131367595));
    paramView.a(2131298924, this.jdField_a_of_type_AndroidContentContext.getString(2131364620));
    a(paramView);
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LocationItemBuilder
 * JD-Core Version:    0.7.0.1
 */