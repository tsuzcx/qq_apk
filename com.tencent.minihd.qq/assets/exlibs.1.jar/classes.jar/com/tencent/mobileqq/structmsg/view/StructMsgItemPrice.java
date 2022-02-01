package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemPrice
  extends StructMsgItemSummary
{
  private String n;
  
  public StructMsgItemPrice()
  {
    this.a = "price";
  }
  
  public StructMsgItemPrice(String paramString)
  {
    this();
    this.m = paramString;
  }
  
  public StructMsgItemPrice(String paramString1, String paramString2)
  {
    this(paramString1);
    this.n = paramString2;
  }
  
  public View a(Context paramContext, View paramView)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramContext = (LinearLayout)paramView;
      ((TextView)paramContext.findViewById(2131296357)).setText(this.m);
      ((TextView)paramContext.findViewById(2131296358)).setText(this.n);
      return paramContext;
    }
    paramView = new LinearLayout(paramContext);
    paramView.setOrientation(0);
    TextView localTextView = new TextView(paramContext);
    localTextView.setId(2131296357);
    localTextView.setText(this.m);
    localTextView.setTextColor(-65536);
    localTextView.setTextSize(14.0F);
    localTextView.setSingleLine();
    localTextView.setEllipsize(a());
    localTextView.setGravity(3);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131296358);
    paramContext.setText(this.n);
    paramContext.setSingleLine();
    paramContext.setEllipsize(a());
    paramContext.setTextSize(10.0F);
    paramContext.setTextColor(-65536);
    paramContext.setGravity(80);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(5, 0, 0, 0);
    paramContext.setLayoutParams(localLayoutParams);
    paramView.addView(localTextView);
    paramView.addView(paramContext);
    paramView.setTag(this);
    return paramView;
  }
  
  public String a()
  {
    return "Price";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.n = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.n == null) {}
    for (String str = "";; str = this.n)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "price");
    if (this.n == null) {}
    for (String str = "";; str = this.n)
    {
      paramXmlSerializer.attribute(null, "unit", str);
      paramXmlSerializer.text(this.m);
      paramXmlSerializer.endTag(null, "price");
      return;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.n = MessageUtils.a(paramStructMsgNode.a("unit"), false);
    this.m = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPrice
 * JD-Core Version:    0.7.0.1
 */