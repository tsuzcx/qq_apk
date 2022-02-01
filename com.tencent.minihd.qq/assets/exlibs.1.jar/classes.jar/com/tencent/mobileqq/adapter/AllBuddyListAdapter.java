package com.tencent.mobileqq.adapter;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import heu;
import hfd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class AllBuddyListAdapter
  extends FacePreloadBaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Comparator jdField_a_of_type_JavaUtilComparator = new heu(this);
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private char[] jdField_a_of_type_ArrayOfChar = null;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private int b;
  private int c;
  
  public AllBuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    ChnToSpell.a(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(49));
    this.b = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.c = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    c();
  }
  
  private SpannableString a(hfd paramhfd, String paramString)
  {
    int k = 1;
    int m = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
    int i;
    boolean bool;
    if ((localObject != null) && (!TextUtils.isEmpty(((ExtensionInfo)localObject).feedContent)))
    {
      i = 1;
      if (localObject == null) {
        break label338;
      }
      if (this.jdField_a_of_type_Int == 0) {
        break label179;
      }
      bool = true;
    }
    label49:
    label71:
    label203:
    label338:
    for (paramString = ((ExtensionInfo)localObject).getRichStatus(bool);; paramString = null)
    {
      int j;
      label86:
      ImageView localImageView;
      if ((paramString != null) && (!paramString.a()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramString.c))) {
          break label191;
        }
        if ((i == 0) || ((((ExtensionInfo)localObject).feedTime <= ((ExtensionInfo)localObject).richTime) && (j != 0))) {
          break label203;
        }
        paramString = new SpannableString(((ExtensionInfo)localObject).feedContent);
        paramhfd.e.setCompoundDrawables(null, null, null, null);
        paramhfd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localImageView = paramhfd.jdField_b_of_type_AndroidWidgetImageView;
        if (!((ExtensionInfo)localObject).feedHasPhoto) {
          break label197;
        }
      }
      for (i = m;; i = 8)
      {
        localImageView.setVisibility(i);
        paramhfd.e.setText(paramString);
        return paramString;
        i = 0;
        break;
        bool = false;
        break label49;
        j = 0;
        break label71;
        k = 0;
        break label86;
      }
      if (k != 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramString.b, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = this.b;
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        paramhfd.e.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
      for (;;)
      {
        paramString = paramString.a(null);
        paramhfd.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramhfd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (j == 0)
        {
          paramString = RichStatus.a();
          paramhfd.e.setCompoundDrawables(null, null, null, null);
        }
      }
    }
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Friends localFriends;
    label158:
    String str;
    SpannableString localSpannableString;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903189, paramViewGroup, false);
      paramViewGroup = new hfd();
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296551));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297264));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297267));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297268));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131297269));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localFriends = (Friends)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangObject = localFriends;
      if (localFriends.groupid == -1007) {
        break label342;
      }
      paramViewGroup.jdField_b_of_type_JavaLangString = localFriends.uin;
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localFriends.uin));
      str = ContactUtils.a(localFriends);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      localSpannableString = a(paramViewGroup, localFriends.uin);
      if ((!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
        break label355;
      }
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427999));
      label239:
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label378;
      }
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.c);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842003, 0);
    }
    for (;;)
    {
      paramViewGroup = new StringBuilder(str);
      if (!TextUtils.isEmpty(localSpannableString)) {
        paramViewGroup.append("，个性签名 ，").append(localSpannableString);
      }
      paramViewGroup.append("，连按两次进入聊天界面");
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup = (hfd)paramView.getTag();
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label342:
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839616);
      break label158;
      label355:
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427934));
      break label239;
      label378:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.c);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842130, 0);
      }
      else
      {
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Object localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).d();
    try
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext()) {
        if (((Friends)localIterator.next()).cSpecialFlag == 1) {
          localIterator.remove();
        }
      }
      String str;
      char c1;
      label179:
      int i;
      label273:
      int j;
      int k;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((ArrayList)localObject1).addAll((Collection)localObject2);
      }
      Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Entity)((Iterator)localObject1).next();
        str = ChnToSpell.a(ContactUtils.a((Friends)localObject2).trim(), 2);
        if (str.length() > 0)
        {
          c1 = str.charAt(0);
          if (StringUtil.c(c1)) {
            break label273;
          }
        }
        for (c1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".charAt("ABCDEFGHIJKLMNOPQRSTUVWXYZ#".length() - 1);; c1 = Character.toUpperCase(c1))
        {
          if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(c1)) == null) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Character.valueOf(c1), new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(c1))).add(localObject2);
          break;
          c1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".charAt("ABCDEFGHIJKLMNOPQRSTUVWXYZ#".length() - 1);
          break label179;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet();
      this.jdField_a_of_type_ArrayOfInt = new int[((Set)localObject1).size() + 1];
      this.jdField_a_of_type_ArrayOfChar = new char[((Set)localObject1).size()];
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      i = 1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfInt;
        j = localObject2[i];
        k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
        localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + j);
        i += 1;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        this.jdField_a_of_type_ArrayOfChar[i] = ((Character)((Iterator)localObject1).next()).charValue();
        i += 1;
      }
    }
  }
  
  public int a(char paramChar)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfChar.length) {
      if (paramChar != this.jdField_a_of_type_ArrayOfChar[i]) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      i = -1;
    }
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.a = ((Friends)getItem(paramInt)).uin;
    return localFaceInfo;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        hfd localhfd = (hfd)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        if ((localhfd != null) && (localhfd.jdField_b_of_type_JavaLangString != null) && (localhfd.jdField_b_of_type_JavaLangString.length() > 0)) {
          a(localhfd, localhfd.jdField_b_of_type_JavaLangString);
        }
        i += 1;
      }
    }
    super.a(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return (Entity)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(this.jdField_a_of_type_ArrayOfChar[i]))).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i]);
    }
    i = -(i + 1) - 1;
    return (Entity)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(this.jdField_a_of_type_ArrayOfChar[i]))).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i]);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void notifyDataSetChanged()
  {
    c();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AllBuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */