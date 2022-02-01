package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPrice;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgItem
  extends AbsStructMsgElement
{
  public static final int g = 0;
  public static final int h = 2;
  private static final String j;
  public ArrayList a;
  public int i;
  protected int j;
  protected int k;
  public int l;
  
  static
  {
    jdField_j_of_type_JavaLangString = AbsStructMsgItem.class.getSimpleName();
  }
  
  protected AbsStructMsgItem()
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected AbsStructMsgItem(int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt);
  }
  
  protected AbsStructMsgItem(Collection paramCollection)
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramCollection);
  }
  
  private boolean b()
  {
    return (this.jdField_j_of_type_Int >= 0) && (this.jdField_j_of_type_Int <= 3);
  }
  
  public int a(Context paramContext)
  {
    return (int)(TypedValue.applyDimension(1, 7.0F, paramContext.getResources().getDisplayMetrics()) + 0.5F);
  }
  
  public View a(Context paramContext, View paramView)
  {
    return b(paramContext, paramView);
  }
  
  public View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return b(paramContext, paramView, paramOnLongClickAndTouchListener);
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(b()).append(this.i);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((AbsStructMsgElement)localIterator.next()).a());
      }
    }
    return localStringBuffer.toString();
  }
  
  protected void a(View paramView)
  {
    if (!TextUtils.isEmpty(this.b)) {}
    switch (a())
    {
    default: 
      return;
    case 0: 
      paramView.setBackgroundResource(2130837638);
      return;
    case 1: 
      paramView.setBackgroundResource(2130837639);
      return;
    case 2: 
      paramView.setBackgroundResource(2130837637);
      return;
    }
    paramView.setBackgroundResource(2130837636);
  }
  
  public void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if (((paramAbsStructMsgElement instanceof AbsStructMsgTextElement)) && (!b())) {
      ((AbsStructMsgTextElement)paramAbsStructMsgElement).jdField_j_of_type_JavaLangString = null;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_d_of_type_Int = paramObjectInput.readInt();
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2))
    {
      this.b = paramObjectInput.readUTF();
      this.c = paramObjectInput.readUTF();
      this.jdField_d_of_type_JavaLangString = paramObjectInput.readUTF();
      this.e = paramObjectInput.readUTF();
      this.jdField_f_of_type_JavaLangString = paramObjectInput.readUTF();
      this.g = paramObjectInput.readUTF();
      this.jdField_f_of_type_Int = paramObjectInput.readInt();
      this.i = paramObjectInput.readInt();
      if (this.jdField_d_of_type_Int == 2) {
        this.jdField_j_of_type_Int = paramObjectInput.readInt();
      }
      int n = paramObjectInput.readInt();
      int m = 0;
      if (m < n)
      {
        Object localObject = paramObjectInput.readUTF();
        if ("item".equals(localObject)) {
          localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
        }
        for (;;)
        {
          if (localObject != null)
          {
            ((AbsStructMsgElement)localObject).a(paramObjectInput);
            a((AbsStructMsgElement)localObject);
          }
          m += 1;
          break;
          AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a((String)localObject);
          localObject = localAbsStructMsgElement;
          if (localAbsStructMsgElement != null)
          {
            localObject = localAbsStructMsgElement;
            if (AbsStructMsgItem.class.isInstance(localAbsStructMsgElement))
            {
              paramObjectInput.readInt();
              localObject = localAbsStructMsgElement;
            }
          }
        }
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.l);
    paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
    if (this.b == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.c != null) {
        break label216;
      }
      localObject = "";
      label57:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label224;
      }
      localObject = "";
      label74:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.e != null) {
        break label232;
      }
      localObject = "";
      label91:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label240;
      }
      localObject = "";
      label108:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.g != null) {
        break label248;
      }
    }
    label216:
    label224:
    label232:
    label240:
    label248:
    for (Object localObject = "";; localObject = this.g)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.jdField_f_of_type_Int);
      paramObjectOutput.writeInt(this.i);
      paramObjectOutput.writeInt(this.jdField_j_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.b;
      break;
      localObject = this.c;
      break label57;
      localObject = this.jdField_d_of_type_JavaLangString;
      break label74;
      localObject = this.e;
      break label91;
      localObject = this.jdField_f_of_type_JavaLangString;
      break label108;
    }
  }
  
  public void a(String paramString)
  {
    a(new StructMsgItemTitle(paramString));
    a(new StructMsgItemHr());
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, 0);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.i = paramInt;
    a(new StructMsgItemCover(paramString1));
    a(new StructMsgItemTitle(paramString2));
    a(new StructMsgItemSummary(paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.i = paramInt;
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      a(new StructMsgItemTitle(paramString2));
    }
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      a(new StructMsgItemCover(paramString1));
    }
    if ((paramString3 != null) && (!paramString3.equals(""))) {
      a(new StructMsgItemSummary(paramString3));
    }
    if ((paramString4 != null) && (!paramString4.equals(""))) {
      a(new StructMsgItemPrice(paramString4, paramString5));
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.l < 0) {}
    for (Object localObject = "0";; localObject = String.valueOf(this.l))
    {
      paramXmlSerializer.attribute(null, "layout", (String)localObject);
      if (!TextUtils.isEmpty(this.c)) {
        paramXmlSerializer.attribute(null, "action", this.c);
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "actionData", this.jdField_d_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.e)) {
        paramXmlSerializer.attribute(null, "a_actionData", this.e);
      }
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "i_actionData", this.jdField_f_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.b)) {
        paramXmlSerializer.attribute(null, "url", this.b);
      }
      if (!TextUtils.isEmpty(this.g)) {
        paramXmlSerializer.attribute(null, "brief", this.g);
      }
      if (this.jdField_f_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "flag", String.valueOf(this.jdField_f_of_type_Int));
      }
      if (this.i != 0) {
        paramXmlSerializer.attribute(null, "mode", String.valueOf(this.i));
      }
      if (this.jdField_j_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "bg", String.valueOf(this.jdField_j_of_type_Int));
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramXmlSerializer);
      }
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return a() == 1;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramStructMsgNode == null) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      this.c = paramStructMsgNode.a("action");
      this.jdField_d_of_type_JavaLangString = paramStructMsgNode.a("actionData");
      this.e = paramStructMsgNode.a("a_actionData");
      this.jdField_f_of_type_JavaLangString = paramStructMsgNode.a("i_actionData");
      this.b = paramStructMsgNode.a("url");
      this.g = paramStructMsgNode.a("brief");
      String str = paramStructMsgNode.a("flag");
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        this.jdField_f_of_type_Int = Integer.parseInt(str);
        str = paramStructMsgNode.a("mode");
        if (TextUtils.isEmpty(str)) {}
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          this.i = Integer.parseInt(str);
          label125:
          str = paramStructMsgNode.a("bg");
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {}
            for (int m = Integer.parseInt(str);; m = this.jdField_j_of_type_Int)
            {
              this.jdField_j_of_type_Int = m;
              int i1 = paramStructMsgNode.a();
              m = 0;
              for (;;)
              {
                if (m >= i1) {
                  break label387;
                }
                localStructMsgNode = paramStructMsgNode.a(m);
                if (localStructMsgNode != null) {
                  break;
                }
                label179:
                m += 1;
              }
              localNumberFormatException1 = localNumberFormatException1;
              this.jdField_f_of_type_Int = 0;
              break;
              localNumberFormatException2 = localNumberFormatException2;
              this.i = 0;
              break label125;
            }
          }
          catch (NumberFormatException localNumberFormatException3)
          {
            StructMsgNode localStructMsgNode;
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i(jdField_j_of_type_JavaLangString, 2, "Item bg value is " + this.jdField_j_of_type_Int);
              }
            }
            if ("item".equals(localStructMsgNode.b)) {}
            for (Object localObject = localStructMsgNode.a("layout");; localObject = StructMsgElementFactory.a(localStructMsgNode.b))
            {
              try
              {
                if (!TextUtils.isEmpty((CharSequence)localObject)) {}
                for (int n = Integer.parseInt((String)localObject);; n = 0)
                {
                  localObject = StructMsgElementFactory.a(n);
                  bool1 = bool2;
                  if (localObject == null) {
                    break;
                  }
                  bool1 = bool2;
                  if (!((AbsStructMsgElement)localObject).a(localStructMsgNode)) {
                    break;
                  }
                  a((AbsStructMsgElement)localObject);
                  break label179;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
              }
              catch (NumberFormatException paramStructMsgNode)
              {
                bool1 = bool2;
              }
              QLog.i(jdField_j_of_type_JavaLangString, 2, "Item layout value is " + 0);
              return false;
            }
          }
        }
      }
    }
    label387:
    return true;
  }
  
  public abstract View b(Context paramContext, View paramView);
  
  public abstract View b(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  public abstract String b();
  
  protected void b(View paramView)
  {
    if ((b()) && (a())) {
      switch (this.jdField_j_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if ((paramView != null) && (this.k != 0) && (a() == 1)) {
        paramView.setBackgroundResource(this.k);
      }
      return;
      if (!TextUtils.isEmpty(this.b))
      {
        this.k = 2130837640;
      }
      else
      {
        this.k = 2130837648;
        continue;
        if (!TextUtils.isEmpty(this.b)) {
          this.k = 2130837641;
        } else {
          this.k = 2130837649;
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    a(new StructMsgItemSummary(paramString));
    a(new StructMsgItemHr());
  }
  
  public void c(String paramString)
  {
    a(new StructMsgItemSummary(paramString));
    a(new StructMsgItemHr());
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(String paramString)
  {
    this.l = 0;
    a(new StructMsgItemImage(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgItem
 * JD-Core Version:    0.7.0.1
 */