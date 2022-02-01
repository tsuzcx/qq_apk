package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.DeviceSingleStructItemCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import ftj;
import ftk;

public class DeviceSingleStructBuilder
  extends AbstractChatItemBuilder
  implements MessageForDeviceSingleStruct.DeviceSingleStructItemCallback
{
  private static final String b = DeviceSingleStructBuilder.class.getSimpleName();
  protected final float a;
  View.OnClickListener a;
  
  public DeviceSingleStructBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ftj(this);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = (ftk)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903140, null);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131297051));
      paramLinearLayout.c = ((TextView)paramViewHolder.findViewById(2131297052));
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131297054));
      paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131297055));
      paramLinearLayout.d = ((TextView)paramViewHolder.findViewById(2131297056));
      paramLinearLayout.e = ((TextView)paramViewHolder.findViewById(2131297058));
    }
    if ((paramLinearLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {}
    for (paramMessageRecord = (MessageForDeviceSingleStruct)paramMessageRecord;; paramMessageRecord = null)
    {
      if (paramMessageRecord == null) {
        return paramViewHolder;
      }
      long l;
      if ((paramMessageRecord.strTitle != null) && (!TextUtils.isEmpty(paramMessageRecord.strTitle)))
      {
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.strTitle);
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramMessageRecord.nAppearTime == 0L) {
          break label415;
        }
        l = paramMessageRecord.nAppearTime;
        label205:
        if (l == 0L) {
          break label424;
        }
        paramLinearLayout.c.setText(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
        paramLinearLayout.c.setVisibility(0);
        label242:
        if ((paramMessageRecord.strDigest == null) || (TextUtils.isEmpty(paramMessageRecord.strDigest))) {
          break label437;
        }
        paramLinearLayout.d.setText(paramMessageRecord.strDigest);
        paramLinearLayout.d.setVisibility(0);
        label280:
        if ((paramMessageRecord.strGuideWords == null) || (TextUtils.isEmpty(paramMessageRecord.strGuideWords))) {
          break label450;
        }
        paramLinearLayout.e.setText(paramMessageRecord.strGuideWords);
        paramLinearLayout.e.setVisibility(0);
        label318:
        if (paramMessageRecord.nDataType != 2) {
          break label463;
        }
        paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        a(paramMessageRecord, paramLinearLayout);
        if (!FileUtils.b(paramMessageRecord.strCoverPath)) {
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a().a(paramMessageRecord, paramViewHolder, this);
        }
        paramViewHolder.setTag(paramLinearLayout);
        paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramViewHolder;
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label415:
        l = paramMessageRecord.time;
        break label205;
        label424:
        paramLinearLayout.c.setVisibility(8);
        break label242;
        label437:
        paramLinearLayout.d.setVisibility(8);
        break label280;
        label450:
        paramLinearLayout.e.setVisibility(8);
        break label318;
        label463:
        paramLinearLayout.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new ftk(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    ftk localftk = (ftk)AIOUtils.a(paramView);
    if (localftk == null) {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "error get holder in updateview");
      }
    }
    do
    {
      return;
      paramView = null;
      if ((localftk.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForDeviceSingleStruct)) {
        paramView = (MessageForDeviceSingleStruct)localftk.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      }
    } while ((paramView == null) || (paramView.uniseq != paramMessageForDeviceSingleStruct.uniseq) || (paramView.nCoverSessionID != paramMessageForDeviceSingleStruct.nCoverSessionID));
    paramView.strCoverPath = paramMessageForDeviceSingleStruct.strCoverPath;
    a(paramView, localftk);
  }
  
  protected void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, ftk paramftk)
  {
    if (FileUtils.b(paramMessageForDeviceSingleStruct.strCoverPath)) {
      try
      {
        int k = ((WindowManager)CommonDataAdapter.a().a().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
        int j = (int)(150.0F * this.jdField_a_of_type_Float);
        int i = k;
        if (k <= 0) {
          i = j;
        }
        paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(DeviceMsgThumbDownloader.a(paramMessageForDeviceSingleStruct.strCoverPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5));
        paramftk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForDeviceSingleStruct);
        return;
      }
      catch (Exception paramMessageForDeviceSingleStruct)
      {
        paramftk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837579);
        return;
      }
    }
    paramftk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837579);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131302479, this.jdField_a_of_type_AndroidContentContext.getString(2131366320));
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder
 * JD-Core Version:    0.7.0.1
 */