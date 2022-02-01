package com.tencent.biz.pubaccount.assistant;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ckk;
import ckl;
import ckm;
import ckn;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.NewIntent;

public class PubAccountAssistantSettingAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  
  PubAccountAssistantSettingAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130838151);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130838156);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130838153);
      return;
    }
    paramView.setBackgroundResource(2130838155);
  }
  
  private void a(PublicAccountInfo paramPublicAccountInfo, int paramInt1, int paramInt2)
  {
    int i = 2;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidContentContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.luin.set(paramPublicAccountInfo.uin);
    localSetFunctionFlagRequset.type.set(paramInt1);
    localSetFunctionFlagRequset.value.set(paramInt2);
    PBUInt32Field localPBUInt32Field = localSetFunctionFlagRequset.account_type;
    if (paramPublicAccountInfo.extendType == 2) {}
    for (paramInt1 = i;; paramInt1 = 1)
    {
      localPBUInt32Field.set(paramInt1);
      localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      localNewIntent.setObserver(new ckm(this, paramPublicAccountInfo));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PublicAccountInfo localPublicAccountInfo;
    Object localObject;
    label111:
    String str;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903606, null);
      paramViewGroup = new ckn();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296551));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297001));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131298962));
      paramView.setTag(paramViewGroup);
      localPublicAccountInfo = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localPublicAccountInfo.getUin(), true);
      if (localObject == null) {
        break label248;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPublicAccountInfo.name);
      if (localPublicAccountInfo.messageSettingFlag == 0) {
        break label315;
      }
      if (localPublicAccountInfo.messageSettingFlag != 2) {
        break label292;
      }
      paramViewGroup.b.setBackgroundResource(2130838071);
      label149:
      paramView.setOnClickListener(new ckl(this, localPublicAccountInfo, paramViewGroup, paramView));
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131363643);
      str = localPublicAccountInfo.name;
      if (localPublicAccountInfo.mShowMsgFlag != 1) {
        break label367;
      }
    }
    label292:
    label315:
    label367:
    for (paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131367642);; paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131367671))
    {
      paramView.setContentDescription(String.format((String)localObject, new Object[] { str, paramViewGroup }));
      a(paramView, paramInt, getCount());
      return paramView;
      paramViewGroup = (ckn)paramView.getTag();
      break;
      label248:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
      if (this.jdField_a_of_type_Boolean) {
        break label111;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ckk(this), 1000L);
      break label111;
      paramViewGroup.b.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427375));
      break label149;
      if (localPublicAccountInfo.mShowMsgFlag == 0)
      {
        paramViewGroup.b.setBackgroundResource(2130838071);
        break label149;
      }
      if (localPublicAccountInfo.mShowMsgFlag != 1) {
        break label149;
      }
      paramViewGroup.b.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427375));
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter
 * JD-Core Version:    0.7.0.1
 */