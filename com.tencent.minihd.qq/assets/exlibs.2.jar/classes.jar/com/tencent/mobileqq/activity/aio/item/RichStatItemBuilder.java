package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IImageListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fwe;
import fwf;
import fwg;
import fwh;
import fwi;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;

public class RichStatItemBuilder
  extends AbstractChatItemBuilder
  implements IIconListener, IImageListener
{
  public static final int a = 1;
  public static long a;
  protected static final Handler a;
  private static RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fwf(this);
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = null;
  private SignatureManager jdField_a_of_type_ComTencentMobileqqAppSignatureManager;
  private MessageForRichState jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private int jdField_b_of_type_Int;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new fwg(this);
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  RichStatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)paramQQAppInterface.getManager(56));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_b_of_type_Int = (SizeMeasure.e(paramContext) - Utils.a(paramContext, 38.0F));
  }
  
  private CharSequence a(String paramString1, String paramString2, String paramString3, String paramString4, JSONArray paramJSONArray, int paramInt)
  {
    paramString3 = this.jdField_a_of_type_JavaLangStringBuilder;
    paramString3.setLength(0);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      paramString3.append(paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      paramString3.append(paramString2);
    }
    int j = Integer.parseInt(paramString4);
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      i = 0;
      while (i < j)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int k = paramJSONArray.length();
      i = j;
      while (i < k)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    paramString4 = new SpannableString(paramString3.toString());
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        paramInt = paramString1.length() + paramString2.length();
        paramString4.setSpan(new ForegroundColorSpan(-16754769), 0, paramInt, 33);
      }
    }
    for (;;)
    {
      paramString3.setLength(0);
      return paramString4;
      paramInt = paramString2.length();
      break;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        paramString4.setSpan(new ForegroundColorSpan(paramInt), 0, paramString1.length(), 33);
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "icon" + paramInt;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "cover" + paramString2;
  }
  
  private void a(View paramView, RichStatItemBuilder.Holder paramHolder, MessageForRichState paramMessageForRichState)
  {
    if (jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f = paramMessageForRichState.feedId;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_Int = paramMessageForRichState.tplId;
    paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (TextUtils.isEmpty(paramMessageForRichState.actionId))
    {
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_b_of_type_Int;
      paramView.jdField_b_of_type_Int = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_JavaLangString = paramMessageForRichState.actionText;
      paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty(paramMessageForRichState.dataId)) {
        break label260;
      }
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_c_of_type_Int;
      label97:
      paramView.jdField_c_of_type_Int = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_JavaLangString = paramMessageForRichState.dataText;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.e = paramMessageForRichState.locText;
      paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty(paramMessageForRichState.locPos)) {
        break label272;
      }
    }
    label260:
    label272:
    for (int i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.g;; i = Integer.parseInt(paramMessageForRichState.locPos))
    {
      paramView.g = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_Long = paramMessageForRichState.time;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList = null;
      if ((paramMessageForRichState.plainText == null) || (paramMessageForRichState.plainText.length() <= 0)) {
        break label284;
      }
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramMessageForRichState.plainText.length());
      i = 0;
      while (i < paramMessageForRichState.plainText.length())
      {
        jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_JavaUtilArrayList.add(paramMessageForRichState.plainText.optString(i));
        i += 1;
      }
      i = Integer.parseInt(paramMessageForRichState.actionId);
      break;
      i = Integer.parseInt(paramMessageForRichState.dataId);
      break label97;
    }
    label284:
    paramHolder.jdField_c_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f;
    paramHolder.jdField_b_of_type_Int = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_Int;
    paramHolder.jdField_d_of_type_Int = paramMessageForRichState.count;
    paramHolder.jdField_c_of_type_Int = paramMessageForRichState.zanFlag;
    paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a(paramHolder.jdField_c_of_type_AndroidWidgetTextView, TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), 3, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_Long * 1000L) + "    "));
    a(paramHolder);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f))
    {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setClickable(true);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMessageForRichState.count));
      i = 8;
      if (paramMessageForRichState.zanFlag == 0) {
        i = 7;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(paramHolder.jdField_b_of_type_Int, i);
      if (paramView != null) {
        paramHolder.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramView, null, null, null);
      }
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      ThreadManager.b(new fwe(this, paramMessageForRichState));
      return;
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText("0");
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
    }
  }
  
  private void a(RichStatItemBuilder.Holder paramHolder)
  {
    SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    paramHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
    Object localObject2 = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    if (localObject2 != null) {}
    for (int i = ((Layout)localObject2).getLineCount();; i = 1)
    {
      float f;
      Object localObject1;
      if (i < 3)
      {
        f = 0.35F;
        i = 2;
        Object localObject3 = (ViewGroup)paramHolder.jdField_a_of_type_AndroidWidgetImageView.getParent();
        ViewGroup.LayoutParams localLayoutParams = ((ViewGroup)localObject3).getLayoutParams();
        SignatureManager localSignatureManager = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        localObject1 = localSignatureManager.a(Integer.toString(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_Int));
        int j = (int)(f * this.jdField_b_of_type_Int);
        localLayoutParams.height = (((Layout)localObject2).getHeight() + Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 77.0F));
        f = this.jdField_b_of_type_Int;
        localLayoutParams.width = ((int)(localLayoutParams.height / j * f));
        ((ViewGroup)localObject3).setLayoutParams(localLayoutParams);
        if (localSignatureManager != null)
        {
          localObject2 = localSignatureManager.a(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.jdField_d_of_type_Int, i);
          if (localObject2 != null)
          {
            if (!(localObject2 instanceof URLDrawable)) {
              break label404;
            }
            localObject3 = (URLDrawable)localObject2;
            if (((URLDrawable)localObject3).getStatus() == 1)
            {
              SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
              if (!TextUtils.isEmpty(((SignatureTemplateInfo)localObject1).p)) {
                paramHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(((SignatureTemplateInfo)localObject1).p));
              }
            }
            ((URLDrawable)localObject3).setURLDrawableListener(new fwh(this, paramHolder));
          }
        }
      }
      for (;;)
      {
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject2);
        if ((SignatureManager.y != null) && (SignatureManager.a != null))
        {
          localObject1 = SignatureManager.y;
          localObject2 = SignatureManager.a;
          jdField_a_of_type_AndroidOsHandler.post(new fwi(this, paramHolder, (String)localObject1, (SignatureTemplateInfo.DynamicItem)localObject2));
        }
        return;
        if (i < 5)
        {
          f = 0.46F;
          i = 3;
          break;
        }
        f = 0.577F;
        i = 4;
        break;
        label404:
        SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        if (!TextUtils.isEmpty(((SignatureTemplateInfo)localObject1).p)) {
          paramHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(((SignatureTemplateInfo)localObject1).p));
        }
      }
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = ((MessageForRichState)paramMessageRecord);
    jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout = (RichStatItemBuilder.Holder)paramViewHolder;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903151, null);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramMessageRecord.findViewById(2131297104));
      paramLinearLayout.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramMessageRecord.findViewById(2131297108));
      paramLinearLayout.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramMessageRecord.findViewById(2131297110));
      paramLinearLayout.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramMessageRecord.findViewById(2131297105));
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView = ((ClickableColorSpanTextView)paramMessageRecord.findViewById(2131297107));
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramMessageRecord.findViewById(2131297106));
      paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      paramViewHolder = paramLinearLayout.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramViewHolder.width = this.jdField_b_of_type_Int;
      paramLinearLayout.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramViewHolder);
    }
    paramMessageRecord.setContentDescription(null);
    paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.length(), "");
    paramLinearLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramLinearLayout.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
    paramLinearLayout.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin;
    paramLinearLayout.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.istroop;
    paramLinearLayout.jdField_b_of_type_JavaLangString = null;
    paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.ver;
    if ((paramViewHolder != null) && (paramViewHolder.equals("1.0"))) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time <= 0L) {
        break label905;
      }
    }
    label388:
    label905:
    for (paramViewHolder = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time * 1000L);; paramViewHolder = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum.trim().length() > 0))
      {
        paramLinearLayout.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString == null) {
          break label757;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        paramView = Utils.b(paramView, 10);
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText(paramView + "更新了签名");
        int i = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(Integer.toString(paramLinearLayout.jdField_b_of_type_Int)).e);
        paramOnLongClickAndTouchListener = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.locText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.locPos, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.plainText, i);
        paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append(paramView);
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time > 0L) {
          paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append("于").append(paramViewHolder);
        }
        paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append("更新了签名，内容是：").append(paramOnLongClickAndTouchListener);
        paramMessageRecord.setContentDescription(paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.toString());
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText.length() <= 0)) {
          break label768;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId.trim().length() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId = "0";
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId.trim().length() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId = "0";
        }
        paramViewHolder = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId);
        if (QLog.isColorLevel()) {
          QLog.d("AIOSign", 2, "taskKey is:" + paramViewHolder);
        }
        paramLinearLayout.jdField_b_of_type_JavaLangString = paramViewHolder;
      }
      for (;;)
      {
        a(paramMessageRecord, paramLinearLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState);
        paramLinearLayout.jdField_d_of_type_AndroidWidgetTextView.setTag(paramLinearLayout);
        paramLinearLayout.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        return paramMessageRecord;
        paramLinearLayout.jdField_d_of_type_AndroidWidgetTextView.setText("0");
        break;
        label757:
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break label388;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText.length() > 0))
        {
          paramViewHolder = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId, 201);
          if (QLog.isColorLevel()) {
            QLog.d("AIOSign", 2, "taskKey is:" + paramViewHolder);
          }
          paramLinearLayout.jdField_b_of_type_JavaLangString = paramViewHolder;
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("AIOSign", 2, "bindViewForRichSignature(),dataText is:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText + ",actionText is:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText);
        }
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new RichStatItemBuilder.Holder(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, String paramString, SignatureTemplateInfo.DynamicItem paramDynamicItem)
  {
    if ((paramString == null) || (SignatureManager.a == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(4), Long.valueOf(paramMessageRecord.uniseq), Integer.valueOf(paramInt), paramString, Boolean.valueOf(true), null, paramDynamicItem });
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder
 * JD-Core Version:    0.7.0.1
 */