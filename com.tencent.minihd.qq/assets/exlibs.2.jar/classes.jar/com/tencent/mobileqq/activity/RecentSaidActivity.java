package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XListView;
import evt;
import evu;
import evv;
import evw;
import evx;
import ewb;
import ewc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecentSaidActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 50;
  public static final String a = "troop_uin";
  public static final int[] a;
  static final int b = 0;
  public static final String b = "member_uin";
  static final int c = 10;
  public static final String c = "member_is_shield";
  static final int d = 11;
  static final int jdField_e_of_type_Int = 12;
  static final int f = 20;
  static final int g = 21;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new evx(this);
  public Handler a;
  public TextView a;
  public RecentSaidActivity.ListAdapter a;
  public XListView a;
  ewb jdField_a_of_type_Ewb = new ewb(this);
  boolean jdField_a_of_type_Boolean;
  public TextView b;
  public boolean b;
  public boolean c = false;
  public String d;
  String jdField_e_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1000, -2000, -20000, -2002, -2022, -1035, -2001, -2007 };
  }
  
  public RecentSaidActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void a()
  {
    super.setContentView(2130903701);
    this.centerView.setText(2131363749);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131299361));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299362));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(new View(this));
    if (!super.getPreferences(0).getBoolean(this.app.a(), false))
    {
      View localView = super.getLayoutInflater().inflate(2130903705, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      localView.findViewById(2131298164).setOnClickListener(new evt(this, localView));
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.getLayoutInflater().inflate(2130903702, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity$ListAdapter = new RecentSaidActivity.ListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity$ListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new evu(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new evv(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new evw(this));
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return false;
      this.d = paramIntent.getStringExtra("troop_uin");
      this.e = paramIntent.getStringExtra("member_uin");
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("member_is_shield", false);
    } while ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.app.a())));
    return true;
  }
  
  public List a()
  {
    boolean bool = false;
    if (this.jdField_b_of_type_Boolean) {}
    Object localObject1;
    do
    {
      return null;
      if ((jdField_a_of_type_ArrayOfInt == null) || (jdField_a_of_type_ArrayOfInt.length <= 0)) {
        break;
      }
      localObject1 = new StringBuilder();
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfInt.length)
      {
        ((StringBuilder)localObject1).append(jdField_a_of_type_ArrayOfInt[i]);
        if (i < jdField_a_of_type_ArrayOfInt.length - 1) {
          ((StringBuilder)localObject1).append(" , ");
        }
        i += 1;
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = this.app.a().createEntityManager();
      localObject1 = ((EntityManager)localObject2).a(MessageRecord.class, MessageRecord.getTableName(this.d, 1), false, String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype in (%s)", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), localObject1 }), new String[] { this.e }, null, null, "shmsgseq DESC", String.valueOf(50));
      ((EntityManager)localObject2).a();
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    if (((List)localObject1).size() < 50) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    Object localObject2 = new LinkedList();
    Iterator localIterator = ((List)localObject1).iterator();
    label207:
    MessageRecord localMessageRecord;
    if (localIterator.hasNext())
    {
      localMessageRecord = (MessageRecord)localIterator.next();
      switch (localMessageRecord.msgtype)
      {
      default: 
        localObject1 = "[其他消息]";
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Long > localMessageRecord.shmsgseq) {
        this.jdField_a_of_type_Long = localMessageRecord.shmsgseq;
      }
      ((List)localObject2).add(new ewc(this, localMessageRecord.time, (CharSequence)localObject1, localMessageRecord.shmsgseq));
      break label207;
      localObject1 = new QQText(localMessageRecord.msg, 13, 32, 1);
      continue;
      localObject1 = getString(2131365739);
      continue;
      localObject1 = getString(2131368067);
      continue;
      localObject1 = getString(2131368070);
      continue;
      localObject1 = new MessageForMixedMsg();
      ((MessageForMixedMsg)localObject1).msgData = localMessageRecord.msgData;
      ((MessageForMixedMsg)localObject1).parse();
      if (((MessageForMixedMsg)localObject1).msg == null) {}
      for (localObject1 = "[其他消息]";; localObject1 = new QQText(((MessageForMixedMsg)localObject1).msg, 13, 32, 1)) {
        break;
      }
      localObject1 = getString(2131368619);
      continue;
      localObject1 = getResources().getString(2131367594);
      continue;
      try
      {
        localObject1 = StructMsgFactory.a(localMessageRecord.msgData);
        if (localObject1 == null) {
          localObject1 = "[结构化消息]";
        } else {
          localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
        }
      }
      catch (Exception localException)
      {
        str = "[结构化消息]";
      }
      continue;
      return localObject2;
      String str = null;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Ewb.a(paramInt);
      ThreadManager.a(this.jdField_a_of_type_Ewb);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363754);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363750);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      super.startTitleProgress();
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363750);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(String paramString)
  {
    ReportController.a(null, "P_CliOper", "Grp_manage", "", "mber_card", paramString, 0, 0, this.d, "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!a(super.getIntent()))
    {
      finish();
      return false;
    }
    a();
    a(20);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentSaidActivity
 * JD-Core Version:    0.7.0.1
 */