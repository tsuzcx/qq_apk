package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import java.util.Observable;
import java.util.Observer;

public abstract class TroopAioAgent
  extends Observable
{
  public static int a;
  public static int b = 2;
  public static int c = 3;
  public Context a;
  public RelativeLayout a;
  public ChatAdapter1 a;
  public SessionInfo a;
  public QQAppInterface a;
  public ChatXListView a;
  public ScrollerRunnable a;
  public Observer a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public TroopAioAgent()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = false;
    deleteObservers();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_JavaUtilObserver = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1, ChatXListView paramChatXListView, ScrollerRunnable paramScrollerRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramChatXListView;
    this.jdField_a_of_type_JavaUtilObserver = paramObserver;
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = paramScrollerRunnable;
    deleteObservers();
    addObserver(paramObserver);
    paramContext = (FriendManager)paramQQAppInterface.getManager(8);
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(58);
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (!paramContext.f(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (!paramQQAppInterface.d(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Boolean = true;
      b();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected abstract void b();
  
  protected abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioAgent
 * JD-Core Version:    0.7.0.1
 */