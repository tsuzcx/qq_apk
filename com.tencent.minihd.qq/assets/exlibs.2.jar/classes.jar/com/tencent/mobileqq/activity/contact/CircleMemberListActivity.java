package com.tencent.mobileqq.activity.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import geb;
import gec;
import ged;
import gee;
import geg;
import geh;
import gei;
import gej;
import gek;
import gel;
import java.util.ArrayList;
import java.util.List;

public class CircleMemberListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  static final long jdField_a_of_type_Long = 1000L;
  public static final String a = "k_group_name";
  public static final String b = "k_group_id";
  static final boolean jdField_b_of_type_Boolean = true;
  static final int jdField_c_of_type_Int = 1000;
  public volatile int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new gee(this);
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SearchResultDialog a;
  public CircleManager a;
  FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ged(this);
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private IFriendObserver jdField_a_of_type_ComTencentMobileqqServiceCircleIFriendObserver = new gec(this);
  IGroupObserver jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver = new geb(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public gek a;
  public ArrayList a;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  public int b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int e;
  
  public CircleMemberListActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    Contacts.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new geg(this, this, this.app, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations, 4);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new geh(this));
    localTranslateAnimation2.setAnimationListener(new gei(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(new gej(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation1);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838136);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.e = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, true);
    if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c(i) == 0)) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_Gek = new gek(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Gek);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.e);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296742);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297738));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131366374);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297358));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297360));
      if (!this.jdField_a_of_type_Boolean) {
        break label419;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131365736);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297361));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
      IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
      findViewById(2131296742).setBackgroundResource(2130838126);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299816));
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      View localView = getLayoutInflater().inflate(2130904390, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      localView.findViewById(2131299461).setVisibility(8);
      Object localObject = (EditText)localView.findViewById(2131299473);
      ((EditText)localObject).setFocusableInTouchMode(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      localObject = (TextView)localView.findViewById(2131299474);
      ((TextView)localObject).setText(2131366040);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("返回" + this.jdField_c_of_type_AndroidWidgetTextView.getText());
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      localView.setContentDescription(((TextView)localObject).getText());
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription("取消本次转发");
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText("人脉圈");
      break;
      label419:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void d()
  {
    Object localObject = (ViewGroup)findViewById(2131297347);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131297738);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131297357);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public View a()
  {
    View localView = getLayoutInflater().inflate(2130903847, null);
    gel localgel = new gel(null);
    localgel.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296551));
    localgel.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297264));
    localgel.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297269));
    localgel.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298103));
    localgel.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298104));
    localgel.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localgel.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    localView.setTag(localgel);
    localView.setOnClickListener(this);
    localgel.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localgel.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    return localView;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1000)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 1000L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList1 == null) || (paramInt1 < 0) || (paramInt1 > localArrayList1.size()) || (paramInt2 < 0) || (paramInt2 > localArrayList1.size())) {}
    ArrayList localArrayList2;
    int i;
    label114:
    do
    {
      int j;
      do
      {
        return;
        localArrayList2 = new ArrayList(50);
        i = paramInt1;
        for (;;)
        {
          if (i > paramInt2) {
            break label114;
          }
          if (this.jdField_a_of_type_Int != 0) {
            break;
          }
          localCircleBuddy = (CircleBuddy)localArrayList1.get(i);
          if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy.uin) == 2) {
            localArrayList2.add(localCircleBuddy.uin);
          }
          i += 1;
        }
        j = localArrayList2.size();
      } while (j == 0);
      i = j;
      if (paramInt2 + 1 < localArrayList1.size())
      {
        i = paramInt2 + 1;
        for (paramInt2 = j;; paramInt2 = j)
        {
          if ((i >= localArrayList1.size()) || (paramInt2 >= 50)) {
            break label231;
          }
          if (this.jdField_a_of_type_Int != 0) {
            break;
          }
          localCircleBuddy = (CircleBuddy)localArrayList1.get(i);
          j = paramInt2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy.uin) == 2)
          {
            localArrayList2.add(localCircleBuddy.uin);
            j = paramInt2 + 1;
          }
          i += 1;
        }
        i = paramInt2;
      }
      if ((i >= 50) || (paramInt1 <= 0)) {
        break;
      }
      paramInt2 = paramInt1 - 1;
      if ((paramInt2 < 0) || (i >= 50)) {
        break;
      }
    } while (this.jdField_a_of_type_Int != 0);
    label231:
    CircleBuddy localCircleBuddy = (CircleBuddy)localArrayList1.get(paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy.uin) == 2) {
      localArrayList2.add(localCircleBuddy.uin);
    }
    for (paramInt1 = i + 1;; paramInt1 = i)
    {
      paramInt2 -= 1;
      i = paramInt1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localArrayList2);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Int != 2))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof gel)))
        {
          localObject = (gel)localObject;
          if (((gel)localObject).jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin.equals(paramString)) {
            ((gel)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(View paramView, CircleBuddy paramCircleBuddy)
  {
    gel localgel = (gel)paramView.getTag();
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramCircleBuddy.uin);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (this.jdField_a_of_type_Int != 2) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramCircleBuddy.uin, 1, false, (byte)1);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localgel.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    localgel.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy));
    a(localgel, paramCircleBuddy);
    localgel.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy = paramCircleBuddy;
    paramCircleBuddy = localgel.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    paramView.setContentDescription(paramCircleBuddy);
    localgel.jdField_a_of_type_AndroidWidgetButton.setContentDescription("向" + paramCircleBuddy + "发消息按钮");
    localgel.jdField_b_of_type_AndroidWidgetButton.setContentDescription("添加" + paramCircleBuddy + "为好友");
  }
  
  void a(CircleBuddy paramCircleBuddy)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.b(paramCircleBuddy.uin);
    Intent localIntent = new Intent(getActivity(), ChatActivity.class);
    localIntent.putExtra("uin", paramCircleBuddy.uin);
    if (bool)
    {
      paramCircleBuddy = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(paramCircleBuddy.uin);
      if (paramCircleBuddy != null)
      {
        localIntent.putExtra("cSpecialFlag", paramCircleBuddy.cSpecialFlag);
        localIntent.putExtra("uinname", ContactUtils.a(paramCircleBuddy));
      }
      if (!bool) {
        break label170;
      }
    }
    label170:
    for (int i = 0;; i = 1021)
    {
      localIntent.putExtra("uintype", i);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Circle_list_send", 0, 0, "", "", "", "");
      return;
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy));
      break;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    if (paramInt < i)
    {
      paramAbsListView = (gel)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      Bitmap localBitmap;
      if (paramAbsListView != null)
      {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin);
        if (localBitmap != null) {
          break label168;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin, 1, false, (byte)1);
      }
      for (;;)
      {
        if (paramAbsListView.jdField_b_of_type_AndroidWidgetTextView.getText().length() == 0) {
          paramAbsListView.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin, 0).a(""));
        }
        paramInt += 1;
        break;
        label168:
        paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(gel paramgel, CircleBuddy paramCircleBuddy)
  {
    paramCircleBuddy = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy.uin, this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(paramCircleBuddy.jdField_c_of_type_JavaLangString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramCircleBuddy.jdField_b_of_type_Int, 200);
      localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
      int i = this.jdField_d_of_type_Int;
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
      paramgel.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    for (paramgel.jdField_a_of_type_Int = paramCircleBuddy.jdField_b_of_type_Int;; paramgel.jdField_a_of_type_Int = 0)
    {
      paramCircleBuddy = paramCircleBuddy.a(null);
      paramgel.jdField_b_of_type_AndroidWidgetTextView.setText(paramCircleBuddy);
      if (this.jdField_a_of_type_Int == 0) {
        a();
      }
      return;
      paramgel.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  void b(CircleBuddy paramCircleBuddy)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.b(paramCircleBuddy.uin))
    {
      QQToast.a(this, 2131366964, 0).b(getTitleBarHeight());
      return;
    }
    startActivity(AddFriendLogicActivity.a(this, 1, paramCircleBuddy.uin, null, 3003, 2, this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy), null, null, null));
    ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Circle_list_add", 0, 0, "", "", "", "");
  }
  
  void c(CircleBuddy paramCircleBuddy)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.b(paramCircleBuddy.uin);
    Object localObject;
    ForwardOperations localForwardOperations;
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(paramCircleBuddy.uin);
      if (localObject != null)
      {
        localObject = ContactUtils.a((Friends)localObject);
        localForwardOperations = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
        paramCircleBuddy = paramCircleBuddy.uin;
        if (!bool) {
          break label101;
        }
      }
    }
    label101:
    for (int i = 0;; i = 1021)
    {
      localForwardOperations.a(paramCircleBuddy, i, "", (String)localObject);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy);
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy);
      break;
    }
  }
  
  void d(CircleBuddy paramCircleBuddy)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.b(paramCircleBuddy.uin);
    Object localObject = paramCircleBuddy.uin;
    if (bool) {}
    for (int i = 1;; i = 71)
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, i);
      ((ProfileActivity.AllInOne)localObject).n = paramCircleBuddy.remark;
      ((ProfileActivity.AllInOne)localObject).h = paramCircleBuddy.nickName;
      ((ProfileActivity.AllInOne)localObject).g = 84;
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903846);
    getWindow().setBackgroundDrawable(null);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("k_group_id", 0);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("k_group_name");
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.app.getManager(34));
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)this.app.getManager(8));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_d_of_type_Int = ((int)DisplayUtils.a(this, 12.0F));
    c();
    b();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      paramView = (gel)paramView.getTag();
      if (this.jdField_a_of_type_Boolean)
      {
        setResult(1);
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Forward_frd_send", 0, 0, "", "", "", "");
        c(paramView.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
      }
      break;
    case 2131298103: 
    case 2131298104: 
    case 2131299473: 
    case 2131297357: 
    case 2131297360: 
      do
      {
        return;
        a(((gel)((View)paramView.getParent()).getTag()).jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
        return;
        b(((gel)((View)paramView.getParent()).getTag()).jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          a(14);
          return;
        }
        a(13);
        return;
        finish();
        return;
      } while (!this.jdField_a_of_type_Boolean);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 11))
      {
        ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a);
        com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
      }
      setResult(1);
      finish();
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "P_prof", "Prof_in_client", 84, 0, "", "", "", "");
    d(paramView.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.CircleMemberListActivity
 * JD-Core Version:    0.7.0.1
 */