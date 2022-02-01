package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemVote
  extends AbsStructMsgTextElement
{
  public ArrayList a;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  
  public StructMsgItemVote()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangString = "checklist";
    d("12");
  }
  
  public View a(Context paramContext, View paramView)
  {
    int j = 0;
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = new LinearLayout(paramContext);
      ((LinearLayout)localObject2).setId(2131296344);
      ((LinearLayout)localObject2).setOrientation(1);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 2)
        {
          paramView = this.jdField_a_of_type_JavaUtilArrayList.subList(0, 2);
          j = 0;
          label65:
          localObject1 = localObject2;
          if (j >= paramView.size()) {
            break label402;
          }
          localObject1 = (StructMsgItemVote.OptionItem)paramView.get(j);
          if (localObject1 != null) {
            break label115;
          }
        }
        for (;;)
        {
          j += 1;
          break label65;
          paramView = this.jdField_a_of_type_JavaUtilArrayList;
          break;
          label115:
          TextView localTextView = new TextView(paramContext);
          localTextView.setSingleLine();
          localTextView.setEllipsize(a());
          localTextView.setGravity(16);
          localTextView.setTextSize(e());
          Drawable localDrawable = paramContext.getResources().getDrawable(2130841993);
          localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
          localTextView.setCompoundDrawables(localDrawable, null, null, null);
          localTextView.setText(" " + ((StructMsgItemVote.OptionItem)localObject1).b);
          ((LinearLayout)localObject2).addView(localTextView);
        }
      }
    }
    else
    {
      paramView = (LinearLayout)paramView;
      localObject1 = paramView;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 2) {
          paramContext = this.jdField_a_of_type_JavaUtilArrayList.subList(0, 2);
        }
        for (;;)
        {
          localObject1 = paramView;
          if (j >= paramContext.size()) {
            break label402;
          }
          localObject1 = (StructMsgItemVote.OptionItem)paramContext.get(j);
          if (localObject1 != null) {
            break;
          }
          j += 1;
          continue;
          paramContext = this.jdField_a_of_type_JavaUtilArrayList;
        }
        localObject2 = (TextView)paramView.getChildAt(j);
        if ((this.l == null) || (this.l.equals(""))) {}
        for (float f = e();; f = Integer.parseInt(this.l))
        {
          ((TextView)localObject2).setTextSize(f);
          ((TextView)localObject2).setText(" " + ((StructMsgItemVote.OptionItem)localObject1).b);
          break;
        }
      }
    }
    label402:
    ((LinearLayout)localObject1).setTag(this);
    return localObject1;
  }
  
  public View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return a(paramContext, paramView, null);
  }
  
  public String a()
  {
    return "Vote";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.h = paramObjectInput.readInt();
    this.g = paramObjectInput.readInt();
    this.i = paramObjectInput.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.i);
    int j = 0;
    while (j < this.i)
    {
      String str1 = paramObjectInput.readUTF();
      String str2 = paramObjectInput.readUTF();
      this.jdField_a_of_type_JavaUtilArrayList.add(new StructMsgItemVote.OptionItem(this, str1, str2));
      j += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.h);
    paramObjectOutput.writeInt(this.g);
    paramObjectOutput.writeInt(this.i);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == this.i))
    {
      int j = 0;
      if (j < this.i)
      {
        StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localOptionItem != null)
        {
          if (localOptionItem.jdField_a_of_type_JavaLangString != null) {
            break label127;
          }
          str = "";
          label95:
          paramObjectOutput.writeUTF(str);
          if (localOptionItem.b != null) {
            break label136;
          }
        }
        label136:
        for (String str = "";; str = localOptionItem.b)
        {
          paramObjectOutput.writeUTF(str);
          j += 1;
          break;
          label127:
          str = localOptionItem.jdField_a_of_type_JavaLangString;
          break label95;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("StructMsg", 2, "StructMsgItemVote writeExternal() mOptions is null, or size is error!");
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "checklist");
    paramXmlSerializer.attribute(null, "min", String.valueOf(this.h));
    paramXmlSerializer.attribute(null, "max", String.valueOf(this.g));
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int j = 0;
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        StructMsgItemVote.OptionItem localOptionItem = (StructMsgItemVote.OptionItem)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localOptionItem != null)
        {
          paramXmlSerializer.startTag(null, localOptionItem.jdField_a_of_type_JavaLangString);
          if (localOptionItem.b != null) {
            break label147;
          }
        }
        label147:
        for (String str = "";; str = localOptionItem.b)
        {
          paramXmlSerializer.attribute(null, "min", str);
          paramXmlSerializer.endTag(null, localOptionItem.jdField_a_of_type_JavaLangString);
          j += 1;
          break;
        }
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return true;
      Object localObject = paramStructMsgNode.a("min");
      String str = paramStructMsgNode.a("max");
      try
      {
        this.h = Integer.parseInt((String)localObject);
        this.g = Integer.parseInt(str);
        this.i = paramStructMsgNode.a();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.i);
        int j = 0;
        while (j < this.i)
        {
          localObject = paramStructMsgNode.a(j);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new StructMsgItemVote.OptionItem(this, (StructMsgNode)localObject));
          }
          j += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localNumberFormatException.getMessage());
          }
        }
      }
    }
  }
  
  protected int c()
  {
    return 2131296345;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVote
 * JD-Core Version:    0.7.0.1
 */