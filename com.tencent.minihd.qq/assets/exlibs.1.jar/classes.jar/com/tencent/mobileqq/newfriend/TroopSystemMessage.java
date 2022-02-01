package com.tencent.mobileqq.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.List;
import jlc;
import jld;
import jle;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopSystemMessage
  extends NewFriendMessage
{
  public static final String b = "TroopSystemMessage";
  public Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public MessageObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForSystemMsg jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg = null;
  public boolean b = false;
  
  public TroopSystemMessage()
  {
    super(4);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new jlc(this);
  }
  
  public TroopSystemMessage(int paramInt)
  {
    super(4, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new jlc(this);
  }
  
  public TroopSystemMessage(int paramInt, QQAppInterface paramQQAppInterface)
  {
    super(4, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new jlc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public TroopSystemMessage(MessageForSystemMsg paramMessageForSystemMsg, int paramInt, QQAppInterface paramQQAppInterface)
  {
    super(4);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new jlc(this);
    if (paramMessageForSystemMsg != null)
    {
      this.o = paramInt;
      paramMessageForSystemMsg.getSystemMsg();
      this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg = paramMessageForSystemMsg;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.msg_describe.get())) {
        this.o = 0;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ImageView paramImageView)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramImageView.getContext().getResources().getDrawable(2130841870);
    }
    paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    paramString1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString1);
    if ((paramString1 != null) && (paramString1.troopcode != null)) {
      localIntent.putExtra("troop_uin", paramString1.troopcode);
    }
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramString2);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramStructMsg != null)
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      int k = paramStructMsg.msg.src_id.get();
      int m = paramStructMsg.msg.sub_src_id.get();
      int n = paramStructMsg.msg.group_msg_type.get();
      paramStructMsg = paramStructMsg.msg.actions.get();
      bool1 = bool2;
      if (paramStructMsg != null)
      {
        bool1 = bool2;
        if (paramInt < paramStructMsg.size())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramStructMsg.get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public View a(ViewGroup paramViewGroup, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    jle localjle = new jle();
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903511, paramViewGroup, false);
      localjle.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296751));
      localjle.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298579));
      localjle.b = ((TextView)localView.findViewById(2131298580));
      localjle.c = ((TextView)localView.findViewById(2131298581));
      localjle.d = ((TextView)localView.findViewById(2131298582));
    }
    a(localjle.jdField_a_of_type_AndroidWidgetImageView);
    if (!a(localjle)) {
      localView = null;
    }
    return localView;
  }
  
  public void a(MessageForSystemMsg paramMessageForSystemMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg = paramMessageForSystemMsg;
  }
  
  boolean a(jle paramjle)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.msg_describe.has()) {
      str = this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.msg_describe.get();
    }
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    paramjle.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramjle.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    paramjle.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
    str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.msg_additional.has()) {
      str = this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.msg_additional.get();
    }
    if (!TextUtils.isEmpty(str))
    {
      paramjle.b.setVisibility(0);
      paramjle.b.setText(str);
      paramjle.b.setContentDescription(str);
      if ((this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.sub_type.get() != 1) || (this.o != 1) || (this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.actions.get() == null) || (this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.actions.get().size() <= 0)) {
        break label385;
      }
      paramjle.c.setVisibility(0);
      paramjle.d.setVisibility(8);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.actions.get().get(0)).name.get();
      if (!TextUtils.isEmpty(str)) {
        break label405;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131363434);
    }
    label385:
    label405:
    for (;;)
    {
      if (((structmsg.SystemMsgAction)this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.actions.get(0)).action_info.type.get() == 12)
      {
        paramjle.c.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131558826);
        paramjle.c.setBackgroundResource(2130838088);
      }
      paramjle.c.setText(str);
      paramjle.c.setContentDescription(str);
      paramjle.c.setOnClickListener(new jld(this));
      for (;;)
      {
        return true;
        paramjle.b.setVisibility(8);
        break;
        paramjle.c.setVisibility(8);
        paramjle.d.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.TroopSystemMessage
 * JD-Core Version:    0.7.0.1
 */