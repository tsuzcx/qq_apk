package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import jxn;
import jxo;
import jxp;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemButton
  extends AbsStructMsgTextElement
{
  View.OnClickListener a;
  public long c;
  
  public StructMsgItemButton()
  {
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new jxp(this);
    this.jdField_a_of_type_JavaLangString = "button";
  }
  
  public View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramContext = (TextView)super.a(paramContext, paramView);
    paramContext.setBackgroundResource(2130837637);
    paramContext.setGravity(17);
    paramContext.setClickable(true);
    paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramContext.setOnLongClickListener(new jxn(this, paramOnLongClickAndTouchListener));
    paramContext.setOnTouchListener(new jxo(this, paramOnLongClickAndTouchListener));
    return paramContext;
  }
  
  public String a()
  {
    return "Confirm";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.b = paramObjectInput.readUTF();
    this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
    this.d = paramObjectInput.readUTF();
    this.e = paramObjectInput.readUTF();
    this.f = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.b == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label99;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.d != null) {
        break label107;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.e != null) {
        break label115;
      }
      str = "";
      label66:
      paramObjectOutput.writeUTF(str);
      if (this.f != null) {
        break label123;
      }
    }
    label99:
    label107:
    label115:
    label123:
    for (String str = "";; str = this.f)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.b;
      break;
      str = this.jdField_c_of_type_JavaLangString;
      break label32;
      str = this.d;
      break label49;
      str = this.e;
      break label66;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    paramXmlSerializer.startTag(null, "button");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.d)) {
      paramXmlSerializer.attribute(null, "actionData", this.d);
    }
    if (!TextUtils.isEmpty(this.e)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.e);
    }
    if (!TextUtils.isEmpty(this.f)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.f);
    }
    if (!TextUtils.isEmpty(this.b)) {
      paramXmlSerializer.attribute(null, "url", this.b);
    }
    paramXmlSerializer.endTag(null, "button");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    super.a(paramStructMsgNode);
    this.jdField_c_of_type_JavaLangString = paramStructMsgNode.a("action");
    this.d = paramStructMsgNode.a("actionData");
    this.e = paramStructMsgNode.a("a_actionData");
    this.f = paramStructMsgNode.a("i_actionData");
    this.b = paramStructMsgNode.a("url");
    return true;
  }
  
  protected int c()
  {
    return 2131296359;
  }
  
  public int d()
  {
    return -16734752;
  }
  
  public int e()
  {
    return 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemButton
 * JD-Core Version:    0.7.0.1
 */