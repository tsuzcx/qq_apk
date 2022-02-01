package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import jxr;
import jxs;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemTimer
  extends StructMsgItemSummary
{
  protected long c;
  public boolean c;
  public long d;
  protected long e;
  protected int g;
  protected int h;
  private String n;
  private String o;
  
  public StructMsgItemTimer()
  {
    this.a = "timer";
  }
  
  public StructMsgItemTimer(String paramString)
  {
    this();
    this.m = paramString;
  }
  
  public StructMsgItemTimer(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this(paramString1);
    a(paramString2, paramString3, paramLong, paramInt1, paramInt2);
  }
  
  private long a()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      long l1 = MessageCache.a();
      long l2 = this.jdField_c_of_type_Long + this.g - l1;
      if (l2 < 0L)
      {
        this.jdField_c_of_type_Boolean = true;
        l1 = 0L;
      }
      do
      {
        return l1;
        if (l2 <= 0L) {
          break;
        }
        l1 = l2;
      } while (l2 < this.g);
      return this.g;
      this.jdField_c_of_type_Boolean = true;
      return l2;
    }
    return 0L;
  }
  
  private SpannableStringBuilder a(long paramLong)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-91585);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.n);
    localSpannableStringBuilder.append('\n');
    if (paramLong > 0L)
    {
      int i = localSpannableStringBuilder.length();
      String str = String.valueOf(paramLong) + "秒";
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(this.m);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan, i, str.length() + i, 33);
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(this.o);
    return localSpannableStringBuilder;
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    this.n = paramString1;
    this.o = paramString2;
    this.jdField_c_of_type_Long = paramLong;
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public View a(Context paramContext, View paramView)
  {
    if ((paramView != null) && ((paramView instanceof CountdownTextView)))
    {
      paramContext = (CountdownTextView)paramView;
      paramContext.a(a(), new jxr(this, paramContext));
      paramContext.setTag(this);
      return paramContext;
    }
    paramContext = new CountdownTextView(paramContext);
    paramContext.setId(2131296343);
    paramContext.setTag(this);
    paramContext.setMaxLines(3);
    paramContext.setTextColor(-10987432);
    paramContext.setTextSize(2, 12.0F);
    long l = a();
    if (this.m != null) {
      paramContext.setText(a(l));
    }
    paramContext.a(l, new jxs(this, paramContext));
    return paramContext;
  }
  
  public String a()
  {
    return "Timer";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.n = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.o = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.jdField_c_of_type_Long = paramObjectInput.readLong();
    this.g = paramObjectInput.readInt();
    this.h = paramObjectInput.readInt();
    this.d = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
    this.jdField_c_of_type_Boolean = paramObjectInput.readBoolean();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.n == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.o != null) {
        break label108;
      }
    }
    label108:
    for (String str = "";; str = this.o)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      paramObjectOutput.writeInt(this.g);
      paramObjectOutput.writeInt(this.h);
      paramObjectOutput.writeLong(this.d);
      paramObjectOutput.writeLong(this.e);
      paramObjectOutput.writeBoolean(this.jdField_c_of_type_Boolean);
      return;
      str = this.n;
      break;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "timer");
    paramXmlSerializer.attribute(null, "st", String.valueOf(this.jdField_c_of_type_Long));
    paramXmlSerializer.attribute(null, "dr", String.valueOf(this.g));
    paramXmlSerializer.attribute(null, "index", String.valueOf(this.h));
    if (this.n == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "summary", str);
      if (this.o != null) {
        break label133;
      }
    }
    label133:
    for (String str = "";; str = this.o)
    {
      paramXmlSerializer.attribute(null, "ending", str);
      paramXmlSerializer.text(this.m);
      paramXmlSerializer.endTag(null, "timer");
      return;
      str = this.n;
      break;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.jdField_c_of_type_Long = StructMsgUtils.a(paramStructMsgNode.a("st"));
    this.g = StructMsgUtils.a(paramStructMsgNode.a("dr"));
    this.h = StructMsgUtils.a(paramStructMsgNode.a("index"));
    this.n = MessageUtils.a(paramStructMsgNode.a("summary"), false);
    this.o = MessageUtils.a(paramStructMsgNode.a("st"), false);
    this.m = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTimer
 * JD-Core Version:    0.7.0.1
 */