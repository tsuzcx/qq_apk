import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import appoint.define.appoint_define.AppointContent;
import appoint.define.appoint_define.AppointInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.DateEventMsg;
import com.tencent.mobileqq.dating.DateEventMsgActivity;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.ViewProfileCardSpan;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.ArrayList;
import java.util.List;

public class hzo
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 4;
  static final int b = -1;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(0);
  URLDrawable.URLDrawableOptions jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  hzq[] jdField_a_of_type_ArrayOfHzq = new hzq[0];
  
  public hzo(DateEventMsgActivity paramDateEventMsgActivity) {}
  
  public int a()
  {
    return 2130903889;
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130840249);
    case 1: 
      return paramResources.getDrawable(2130840249);
    case 2: 
      return paramResources.getDrawable(2130840255);
    case 3: 
      return paramResources.getDrawable(2130840252);
    }
    return paramResources.getDrawable(2130840258);
  }
  
  public void a(View paramView, int paramInt)
  {
    hzp localhzp2 = (hzp)paramView.getTag();
    hzp localhzp1 = localhzp2;
    if (localhzp2 == null)
    {
      localhzp1 = new hzp();
      localhzp1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296551));
      localhzp1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297001));
      localhzp1.b = ((ImageView)paramView.findViewById(2131298831));
      paramView.setTag(localhzp1);
    }
    a(paramView, localhzp1, paramInt, this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.e(paramInt));
  }
  
  public void a(View paramView, hzn paramhzn)
  {
    if ((paramhzn == null) || (paramView == null)) {
      return;
    }
    if (paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg == null)
    {
      paramhzn.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(null);
      paramhzn.jdField_b_of_type_ComTencentWidgetCustomImgView.setImageDrawable(null);
      paramhzn.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText("");
      paramhzn.jdField_b_of_type_AndroidWidgetTextView.setText("");
      paramView.setContentDescription("");
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info != null)
    {
      localObject1 = paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info.jdField_a_of_type_JavaLangString;
      localObject2 = String.valueOf(paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info.jdField_a_of_type_Long);
      localObject2 = DatingUtil.a((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.app, this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 3001);
      paramhzn.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject2);
      paramhzn.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if ((paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.type < 1) || (paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.type > 2)) {
        break label677;
      }
      if (paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.date_comment != null) {
        break label597;
      }
      localObject1 = null;
      label180:
      if (paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.date_comment != null) {
        break label612;
      }
      localObject2 = null;
      label193:
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      if ((localObject2 == null) || (TextUtils.isEmpty(((DatingStranger)localObject2).jdField_a_of_type_JavaLangString))) {
        break label627;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append(String.format("回复%s：", new Object[] { ((DatingStranger)localObject2).jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_JavaLangStringBuilder.append((String)localObject1);
      localObject1 = new QQText(this.jdField_a_of_type_JavaLangStringBuilder, 3, 16);
      i = ((DatingStranger)localObject2).jdField_a_of_type_JavaLangString.length();
      ((QQText)localObject1).setSpan(new DatingCommentTextView.ViewProfileCardSpan(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity, ((DatingStranger)localObject2).jdField_a_of_type_Long, paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.getDatingId()), 2, i + 2, 33);
      paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText((CharSequence)localObject1);
      label330:
      if (paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.date_info == null) {
        break label932;
      }
    }
    label929:
    label932:
    for (int i = ((appoint_define.AppointContent)paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.date_info.msg_appointment.get()).uint32_appoint_subject.get();; i = 0)
    {
      if (i == 5)
      {
        localObject2 = paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.getTravelImgUrl();
        label377:
        localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.getResources(), i);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label929;
        }
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.getResources().getDimensionPixelSize(2131493461);
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth;
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
          localObject2 = URLDrawable.getDrawable((String)localObject2, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);
          localObject1 = localObject2;
        }
        catch (Exception localException1)
        {
          label597:
          label612:
          label627:
          localException1.printStackTrace();
          label677:
          continue;
          ((StringBuilder)localObject1).append(paramhzn.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",评论了你的约会,").append(paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.getText().toString()).append(",").append(paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.strReadableTime);
          continue;
          ((StringBuilder)localObject1).append(paramhzn.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",回复了你的评论,").append(paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.getText().toString()).append(",").append(paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.strReadableTime);
          continue;
          ((StringBuilder)localObject1).append(paramhzn.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.getText().toString()).append(",").append(paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.strReadableTime);
          continue;
          ((StringBuilder)localObject1).append("你的约会结束了");
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = null;
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = null;
          paramhzn.jdField_b_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject1);
          paramhzn.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.strTime));
          localObject1 = new StringBuilder(100);
          switch (paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.type)
          {
          default: 
            ((StringBuilder)localObject1).append(",连按两次进入约会详情页查看");
            paramView.setContentDescription(((StringBuilder)localObject1).toString());
            return;
          }
        }
        catch (Exception localException2)
        {
          continue;
        }
        localObject1 = "";
        localObject2 = null;
        break;
        localObject1 = paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.date_comment.c;
        break label180;
        localObject2 = paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.date_comment.b;
        break label193;
        this.jdField_a_of_type_JavaLangStringBuilder.append((String)localObject1);
        localObject1 = new QQText(this.jdField_a_of_type_JavaLangStringBuilder.toString(), 11, 16);
        paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setMovementMethod(null);
        paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText((CharSequence)localObject1);
        break label330;
        if ((paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.type < 3) || (paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.type > 5)) {
          break label330;
        }
        paramhzn.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText(paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.str_event_tips);
        break label330;
        localObject2 = paramhzn.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.getBusiImgUrl();
        break label377;
      }
    }
  }
  
  public void a(View paramView, hzp paramhzp, int paramInt, boolean paramBoolean)
  {
    if ((paramhzp == null) || (paramView == null)) {
      return;
    }
    Object localObject = (hzq)getGroup(paramInt);
    if (localObject != null)
    {
      paramhzp.jdField_a_of_type_AndroidWidgetTextView.setText(((hzq)localObject).jdField_a_of_type_JavaLangString);
      paramhzp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((hzq)localObject).jdField_a_of_type_Int);
      StringBuilder localStringBuilder;
      if (paramBoolean)
      {
        paramhzp.b.setImageResource(2130841853);
        localObject = new StringBuilder(100);
        localStringBuilder = ((StringBuilder)localObject).append(paramhzp.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",分组,");
        if (!paramBoolean) {
          break label138;
        }
      }
      label138:
      for (paramhzp = "已展开";; paramhzp = "已折叠")
      {
        localStringBuilder.append(paramhzp);
        paramView.setContentDescription(((StringBuilder)localObject).toString());
        return;
        paramhzp.b.setImageResource(2130841854);
        break;
      }
    }
    paramhzp.jdField_a_of_type_AndroidWidgetTextView.setText("");
    paramhzp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(0);
    paramView.setContentDescription("");
  }
  
  public void a(List paramList)
  {
    int n = 0;
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.getResources().getStringArray(2131230779);
    SparseArray localSparseArray = new SparseArray(4);
    if (paramList == null) {}
    int i;
    DateEventMsg localDateEventMsg;
    for (int j = 0;; j = paramList.size())
    {
      int k = 0;
      for (i = 0;; i = m)
      {
        if (k >= j) {
          break label207;
        }
        localDateEventMsg = (DateEventMsg)paramList.get(k);
        m = i;
        if (localDateEventMsg != null)
        {
          m = i;
          if (localDateEventMsg.type >= 1)
          {
            if (localDateEventMsg.type <= 5) {
              break;
            }
            m = i;
          }
        }
        k += 1;
      }
    }
    int m = localDateEventMsg.type;
    m = new int[] { 0, 2, 2, 1, 0, 3 }[m];
    ArrayList localArrayList = (ArrayList)localSparseArray.get(m);
    if (localArrayList == null)
    {
      i += 1;
      localArrayList = new ArrayList(20);
      localSparseArray.put(m, localArrayList);
    }
    for (;;)
    {
      localArrayList.add(localDateEventMsg);
      m = i;
      break;
      label207:
      this.jdField_a_of_type_ArrayOfHzq = new hzq[i];
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(i);
      i = 0;
      j = n;
      if (j < 4)
      {
        paramList = (ArrayList)localSparseArray.get(j);
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label357;
        }
        this.jdField_a_of_type_ArrayOfHzq[i] = new hzq();
        this.jdField_a_of_type_ArrayOfHzq[i].jdField_a_of_type_JavaLangString = arrayOfString[j];
        this.jdField_a_of_type_ArrayOfHzq[i].jdField_a_of_type_Int = new int[] { 2130840229, 2130840231, 2130840230, 2130840232 }[j];
        this.jdField_a_of_type_ArrayOfHzq[i].b = j;
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramList);
        i += 1;
      }
      label357:
      for (;;)
      {
        j += 1;
        break;
        notifyDataSetChanged();
        return;
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt1 < 0)) {}
    for (ArrayList localArrayList = null; (localArrayList != null) && (paramInt2 >= 0) && (paramInt2 < localArrayList.size()); localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1)) {
      return localArrayList.get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    DateEventMsg localDateEventMsg = (DateEventMsg)getChild(paramInt1, paramInt2);
    if (localDateEventMsg == null) {
      return -1L;
    }
    return localDateEventMsg.event_id;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity).inflate(2130903891, null);
      paramViewGroup = new hzn();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)paramView.findViewById(2131299981));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)paramView.findViewById(2131298916));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297001));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView = ((DatingCommentTextView)paramView.findViewById(2131296744));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299202));
      paramView.setTag(-1, Integer.valueOf(0));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.getResources().getDrawable(2130840233);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(localDrawable);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetCustomImgView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetCustomImgView.setTag(-1, Integer.valueOf(1));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.getResources().getDrawable(2130840157);
      paramViewGroup.jdField_b_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(localDrawable);
      paramViewGroup.jdField_b_of_type_ComTencentWidgetCustomImgView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_ComTencentWidgetCustomImgView.setTag(-1, Integer.valueOf(2));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg = ((DateEventMsg)getChild(paramInt1, paramInt2));
      a(paramView, paramViewGroup);
      return paramView;
      paramViewGroup = (hzn)paramView.getTag();
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (paramInt < 0)) {}
    for (ArrayList localArrayList = null; localArrayList == null; localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getGroup(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfHzq != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfHzq.length)) {
      return this.jdField_a_of_type_ArrayOfHzq[paramInt];
    }
    return null;
  }
  
  public int getGroupCount()
  {
    if (this.jdField_a_of_type_ArrayOfHzq == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfHzq.length;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity).inflate(2130903889, null);
      paramView = new hzp();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296551));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297001));
      paramView.b = ((ImageView)localView.findViewById(2131298831));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(localView, paramViewGroup, paramInt, paramBoolean);
      return localView;
      paramViewGroup = (hzp)paramView.getTag();
      localView = paramView;
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (paramView == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag(-1);
      paramView = paramView.getTag();
    } while ((!(localObject instanceof Integer)) || (!(paramView instanceof hzn)));
    int j = ((Integer)localObject).intValue();
    paramView = (hzn)paramView;
    switch (j)
    {
    default: 
      return;
    case 0: 
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.b("0X8004F1B");
        DatingDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity, paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.getDatingId(), 1, paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.type, paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.getCommentId(), paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.attendIdx);
        return;
      }
      DatingUtil.b("onChildClick", new Object[] { "msg is null" });
      return;
    case 1: 
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info == null)) {
        break;
      }
    }
    for (long l = paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.user_info.jdField_a_of_type_Long;; l = 0L)
    {
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg != null) {}
      for (paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.getDatingId(); (l != 0L) && (!TextUtils.isEmpty(paramView)); paramView = null)
      {
        DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity, l, paramView, null, 18, null, 0, 0, 0, false);
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.date_info != null) {
          i = ((appoint_define.AppointContent)paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.date_info.msg_appointment.get()).uint32_appoint_subject.get();
        }
        if (i == 5) {
          paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.getTravelUrl();
        }
        while (TextUtils.isEmpty(paramView)) {
          if (i == 5)
          {
            this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.b(2131369813);
            return;
            paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataDateEventMsg.getBusiUrl();
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.b(2131369812);
            return;
          }
        }
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        this.jdField_a_of_type_ComTencentMobileqqDatingDateEventMsgActivity.startActivity((Intent)localObject);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzo
 * JD-Core Version:    0.7.0.1
 */