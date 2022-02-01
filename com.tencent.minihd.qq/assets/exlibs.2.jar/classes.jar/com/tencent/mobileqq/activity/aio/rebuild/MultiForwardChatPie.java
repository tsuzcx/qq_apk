package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import gao;
import java.util.List;

public class MultiForwardChatPie
  extends BaseChatPie
{
  public static final String K = "MultiForwardActivity";
  String L;
  public String M;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private ChatAdapter1 jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
  private ChatXListView jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  ScrollerRunnable jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public List b;
  List c;
  private final int cf = 300;
  private int cg;
  private View d;
  private RelativeLayout e;
  public long f;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private long jdField_g_of_type_Long;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  
  public MultiForwardChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
  }
  
  protected void A() {}
  
  protected void C() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      ApngImage.resumeAll();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
      return;
    }
    URLDrawable.pause();
    if (!PicItemBuilder.g)
    {
      AbstractGifImage.pauseAll();
      ApngImage.pauseAll();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setContentView(2130903080);
    this.L = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("multi_url");
    this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getLongExtra("multi_uniseq", 0L);
    this.M = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("multi_source");
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg", 4, "MultiForwardActivity.doOnCreate ResID = " + this.L + "  msg.uniseq = " + this.jdField_f_of_type_Long);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297347));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297357));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297361));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297390));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842090);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367787));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297001));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131297389));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366374));
    a(false);
    this.e = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296717));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296720));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296721));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296722));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296718));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296719));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
    this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
    String str1 = ((Bundle)localObject).getString("uin");
    String str2 = ((Bundle)localObject).getString("troop_code");
    int i = ((Bundle)localObject).getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = str2;
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, i, this.jdField_f_of_type_Long);
    if (localObject != null)
    {
      MultiMsgManager.a().a(((MessageRecord)localObject).issend);
      this.d = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.d.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics())));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.b(this.d);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localObject = LayoutInflater.from(a()).inflate(2130903177, null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader(a().getResources().getDrawable(2130840064));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
      if (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        this.e.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_b_of_type_JavaUtilList = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.M);
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0)) {
        break label941;
      }
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "MultiForwardActivity.doOnCreate, start requestReceiveMultiMsg");
      }
      k();
      MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.L, this.jdField_f_of_type_Long, new gao(this));
    }
    label941:
    do
    {
      return true;
      MultiMsgManager.a().a(0);
      break;
      localObject = ChatActivityUtils.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(this.jdField_b_of_type_JavaUtilList, (CharSequence)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "MultiForwardActivity.doOnCreate, MultiMsg has been downloaded");
    return true;
  }
  
  protected boolean d()
  {
    return false;
  }
  
  protected boolean k()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838136);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.cg = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public boolean l()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.cg);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    v();
  }
  
  protected void u()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
  }
  
  public void x() {}
  
  protected void y() {}
  
  protected void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie
 * JD-Core Version:    0.7.0.1
 */