package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgTextElement
  extends AbsStructMsgElement
  implements View.OnClickListener
{
  protected boolean a;
  protected boolean b = false;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  
  public AbsStructMsgTextElement()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public AbsStructMsgTextElement(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.m = paramString1;
  }
  
  protected TextUtils.TruncateAt a()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public View a(Context paramContext, View paramView)
  {
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      paramView = (TextView)paramView;
      paramView.setTag(this);
      if (!this.b) {
        break label136;
      }
      paramView.setSingleLine(true);
    }
    for (;;)
    {
      if ((this.b) || (!this.jdField_a_of_type_Boolean)) {
        paramView.setEllipsize(a());
      }
      paramContext = a(paramContext.getResources());
      if (paramContext == null) {
        break label151;
      }
      paramView.setTextColor(paramContext.jdField_a_of_type_Int);
      paramView.requestLayout();
      paramView.setTypeface(Typeface.DEFAULT, paramContext.b);
      paramView.setTextSize(paramContext.c);
      paramView.setText(paramContext.jdField_a_of_type_JavaLangString);
      return paramView;
      paramView = new TextView(paramContext);
      paramView.setGravity(16);
      paramView.setId(c());
      break;
      label136:
      if (!this.jdField_a_of_type_Boolean) {
        paramView.setSingleLine(true);
      }
    }
    label151:
    paramView.setText("");
    return paramView;
  }
  
  public AbsStructMsgTextElement.RichText a(Resources paramResources)
  {
    paramResources = new AbsStructMsgTextElement.RichText();
    for (;;)
    {
      try
      {
        if ((this.j == null) || (this.j.equals("")))
        {
          i = d();
          paramResources.jdField_a_of_type_Int = i;
        }
      }
      catch (Exception localException1)
      {
        paramResources.jdField_a_of_type_Int = d();
        continue;
        int i = Integer.parseInt(this.k);
        continue;
        paramResources.jdField_a_of_type_JavaLangString = b();
        return paramResources;
      }
      try
      {
        if ((this.k != null) && (!this.k.equals(""))) {
          continue;
        }
        i = f();
        paramResources.b = i;
      }
      catch (Exception localException2)
      {
        continue;
      }
      if ((paramResources.b < 0) || (paramResources.b >= 4)) {
        paramResources.b = f();
      }
      paramResources.c = e();
      if ((b() != null) && (!b().equals(""))) {
        continue;
      }
      return null;
      i = Color.parseColor(this.j);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.d == 1) {
      this.m = MessageUtils.a(paramObjectInput.readUTF(), false);
    }
    while (this.d != 2) {
      return;
    }
    this.j = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.k = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.l = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.m = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.d == 1) {
      if (this.m == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
      }
    }
    while (this.d != 2) {
      for (;;)
      {
        return;
        str = MessageUtils.a(this.m, false);
      }
    }
    if (this.j == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.k != null) {
        break label128;
      }
      str = "";
      label78:
      paramObjectOutput.writeUTF(str);
      if (this.l != null) {
        break label136;
      }
      str = "";
      label95:
      paramObjectOutput.writeUTF(str);
      if (this.m != null) {
        break label144;
      }
    }
    label128:
    label136:
    label144:
    for (String str = "";; str = MessageUtils.a(this.m, false))
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.j;
      break;
      str = this.k;
      break label78;
      str = this.l;
      break label95;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.m = paramString;
      return;
    }
    this.m = StringUtil.g(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.m != null)
    {
      if (!TextUtils.isEmpty(this.l)) {
        paramXmlSerializer.attribute(null, "size", this.l);
      }
      if (!TextUtils.isEmpty(this.j)) {
        paramXmlSerializer.attribute(null, "color", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        paramXmlSerializer.attribute(null, "style", this.k);
      }
      paramXmlSerializer.text(this.m);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.j = paramStructMsgNode.a("color");
    this.k = paramStructMsgNode.a("style");
    this.l = paramStructMsgNode.a("size");
    this.m = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
  
  public int b()
  {
    return 2;
  }
  
  public String b()
  {
    if (this.m == null) {}
    for (String str = "";; str = this.m)
    {
      this.m = str;
      return this.m;
    }
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
  }
  
  public abstract int c();
  
  public void c(String paramString)
  {
    this.k = paramString;
  }
  
  public int d()
  {
    return -16777216;
  }
  
  public void d(String paramString)
  {
    this.l = paramString;
  }
  
  public int e()
  {
    return 18;
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgTextElement
 * JD-Core Version:    0.7.0.1
 */