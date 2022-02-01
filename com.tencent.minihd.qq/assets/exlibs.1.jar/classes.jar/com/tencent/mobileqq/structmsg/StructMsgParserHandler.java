package com.tencent.mobileqq.structmsg;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class StructMsgParserHandler
  extends DefaultHandler
  implements StructMsgConstants
{
  StructMsgNode jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode;
  Stack jdField_a_of_type_JavaUtilStack = new Stack();
  private boolean b = false;
  
  public AbsStructMsg a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode == null) {}
    label175:
    for (;;)
    {
      return null;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode.a() > 0) {}
      for (StructMsgNode localStructMsgNode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode.a(0);; localStructMsgNode = null)
      {
        if (localStructMsgNode == null) {
          break label175;
        }
        int j = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode.a();
        int i = 0;
        while (i < j)
        {
          localStructMsgNode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode.a(i);
          if ((localStructMsgNode.b.equals("item")) && (localStructMsgNode.a() > 0))
          {
            localStructMsgNode = localStructMsgNode.a(0);
            if (localStructMsgNode.b.equals("audio")) {
              return new StructMsgForAudioShare(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode);
            }
            if (localStructMsgNode.b.equals("hypertext")) {
              return new StructMsgForHypertext(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode);
            }
            if (localStructMsgNode.b.equals("image")) {
              return new StructMsgForImageShare(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode);
            }
            return new StructMsgForGeneralShare(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode);
          }
          i += 1;
        }
        break;
      }
    }
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    super.characters(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    StructMsgNode localStructMsgNode;
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      localStructMsgNode = (StructMsgNode)this.jdField_a_of_type_JavaUtilStack.peek();
      if (localStructMsgNode != null) {
        if (localStructMsgNode.jdField_a_of_type_JavaLangString != null) {
          break label60;
        }
      }
    }
    for (;;)
    {
      localStructMsgNode.jdField_a_of_type_JavaLangString = paramArrayOfChar;
      return;
      label60:
      paramArrayOfChar = localStructMsgNode.jdField_a_of_type_JavaLangString.concat(paramArrayOfChar);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
    this.jdField_a_of_type_JavaUtilStack.clear();
    this.jdField_a_of_type_JavaUtilStack = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    super.endElement(paramString1, paramString2, paramString3);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString1 = (StructMsgNode)this.jdField_a_of_type_JavaUtilStack.pop();
      if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode = paramString1;
      }
      if (this.b)
      {
        if ((paramString1 != null) && (!"".equals(paramString1.jdField_a_of_type_JavaLangString))) {
          paramString1.jdField_a_of_type_Int = 3;
        }
        this.b = false;
      }
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    super.startElement(paramString1, paramString2, paramString3, paramAttributes);
    paramString1 = new HashMap();
    int i = 0;
    while (i < paramAttributes.getLength())
    {
      paramString1.put(paramAttributes.getLocalName(i), paramAttributes.getValue(i));
      i += 1;
    }
    paramString1 = new StructMsgNode(paramString2, paramString1);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString2 = (StructMsgNode)this.jdField_a_of_type_JavaUtilStack.peek();
      if (paramString2 != null)
      {
        paramString1.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgNode = paramString2;
        paramString2.a(paramString1);
      }
    }
    this.jdField_a_of_type_JavaUtilStack.push(paramString1);
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgParserHandler
 * JD-Core Version:    0.7.0.1
 */