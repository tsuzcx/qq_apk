package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgElement
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public long a;
  public String a;
  long b;
  public String b;
  public String c = null;
  int d;
  public String d;
  int e;
  public String e;
  int f;
  public String f = null;
  public String g = null;
  public String h = null;
  public String i;
  
  public AbsStructMsgElement()
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = -1L;
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public abstract View a(Context paramContext, View paramView);
  
  public abstract View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  public abstract String a();
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_d_of_type_Int = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
  }
  
  public abstract void a(XmlSerializer paramXmlSerializer);
  
  public boolean a(int paramInt)
  {
    return (this.jdField_e_of_type_Int & paramInt) == paramInt;
  }
  
  public abstract boolean a(StructMsgNode paramStructMsgNode);
  
  public void b(int paramInt)
  {
    if ((this.jdField_e_of_type_Int & paramInt) == 0) {
      this.jdField_e_of_type_Int |= paramInt;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_e_of_type_Int &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 1000L) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        localObject1 = paramView.getTag();
      } while (!getClass().isInstance(localObject1));
      localObject1 = (AbsStructMsgElement)localObject1;
      localObject2 = paramView.getContext();
    } while (!ChatActivity.class.isInstance(localObject2));
    Object localObject2 = ((ChatActivity)localObject2).a();
    if ((((AbsStructMsgElement)localObject1).jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(((AbsStructMsgElement)localObject1).h))) {
      ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", ((AbsStructMsgElement)localObject1).i, "mp_msg_msgpic_click", "aio_morpic_click", Integer.parseInt(this.h), 0, "", "", Long.toString(((AbsStructMsgElement)localObject1).jdField_a_of_type_Long), "");
    }
    paramView = new AbsStructMsgElement.ElementClickHandler((QQAppInterface)localObject2, paramView);
    if (((AbsStructMsgElement)localObject1).jdField_a_of_type_Long > 0L)
    {
      paramView.a(((AbsStructMsgElement)localObject1).c, ((AbsStructMsgElement)localObject1).jdField_b_of_type_JavaLangString, ((AbsStructMsgElement)localObject1).jdField_d_of_type_JavaLangString, ((AbsStructMsgElement)localObject1).jdField_e_of_type_JavaLangString, ((AbsStructMsgElement)localObject1).jdField_a_of_type_Long);
      return;
    }
    paramView.a(((AbsStructMsgElement)localObject1).c, ((AbsStructMsgElement)localObject1).jdField_b_of_type_JavaLangString, ((AbsStructMsgElement)localObject1).jdField_d_of_type_JavaLangString, ((AbsStructMsgElement)localObject1).jdField_e_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement
 * JD-Core Version:    0.7.0.1
 */