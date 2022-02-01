package com.tencent.mobileqq.adapter;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureManager.SigCommentInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SigCommentSessionListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private SigCommentListActivity jdField_a_of_type_ComTencentMobileqqActivitySigCommentListActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SignatureManager jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public SigCommentSessionListAdapter(SigCommentListActivity paramSigCommentListActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivitySigCommentListActivity = paramSigCommentListActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramSigCommentListActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
        localObject = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      } while (localObject == null);
      paramString = ((SignatureManager)localObject).a(paramString);
    } while (paramString == null);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(paramString.c))
    {
      ((StringBuilder)localObject).append(paramString.c);
      if (!TextUtils.isEmpty(paramString.d)) {
        ((StringBuilder)localObject).append(paramString.d);
      }
      ((StringBuilder)localObject).append(' ');
    }
    if (paramString.jdField_a_of_type_JavaUtilArrayList != null) {
      if (paramString.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label139;
      }
    }
    label139:
    for (paramString = (String)paramString.jdField_a_of_type_JavaUtilArrayList.get(0);; paramString = null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        ((StringBuilder)localObject).append(paramString);
      }
      paramTextView.setText(((StringBuilder)localObject).toString());
      return;
    }
  }
  
  public SignatureManager.SigCommentInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (SignatureManager.SigCommentInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b != null) {
      ((SigCommentSessionListAdapter.MoreViewHolder)this.b.getTag()).jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList != this.jdField_a_of_type_JavaUtilArrayList) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramList);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqActivitySigCommentListActivity = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public int getCount()
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size(); i == 0; i = 0) {
      return 1;
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return i + j;
      j = 1;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return 0;
    }
    if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentWidgetXListView.getHeight()));
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    }
    label377:
    do
    {
      return paramViewGroup;
      if (1 == i)
      {
        SignatureManager.SigCommentInfo localSigCommentInfo;
        if (paramView == null)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904445, this.jdField_a_of_type_ComTencentWidgetXListView, false);
          paramViewGroup = new SigCommentSessionListAdapter.ViewHolder();
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302219));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302220));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302222));
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302223));
          paramViewGroup.c = ((TextView)paramView.findViewById(2131302221));
          paramView.setTag(paramViewGroup);
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
          if (localObject != null) {
            ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).getRichStatus();
          }
          localSigCommentInfo = a(paramInt);
          localObject = String.valueOf(localSigCommentInfo.uin);
          FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject);
          if (localFaceDrawable != null) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
          }
          localObject = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130841760);
          localObject = Calendar.getInstance();
          ((Calendar)localObject).setTimeInMillis(localSigCommentInfo.time * 1000L);
          paramInt = ((Calendar)localObject).get(9);
          localObject = new SimpleDateFormat("hh:mm").format(new Date(localSigCommentInfo.time * 1000L));
          if (paramInt != 0) {
            break label377;
          }
        }
        for (Object localObject = "上午 " + (String)localObject;; localObject = "下午 " + (String)localObject)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          a(localSigCommentInfo.feedsid, paramViewGroup.c);
          return paramView;
          paramViewGroup = (SigCommentSessionListAdapter.ViewHolder)paramView.getTag();
          break;
        }
      }
      paramViewGroup = paramView;
    } while (2 != i);
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904134, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView.setOnClickListener(this);
      paramViewGroup = new SigCommentSessionListAdapter.MoreViewHolder();
      paramView.setTag(paramViewGroup);
      paramView.findViewById(2131297996).setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297997));
      this.b = paramView;
    }
    for (;;)
    {
      return this.b;
      paramView = (SigCommentSessionListAdapter.MoreViewHolder)paramView.getTag();
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    if (this.b == paramView)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(SigCommentListActivity.class);
      if (paramView != null) {
        paramView.sendMessageDelayed(paramView.obtainMessage(0, 1, 0), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SigCommentSessionListAdapter
 * JD-Core Version:    0.7.0.1
 */