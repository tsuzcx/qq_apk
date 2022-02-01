package com.tencent.mobileqq.newfriend;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecommendContact;
import java.util.ArrayList;
import java.util.List;

public class RecommendMessage
  extends NewFriendMessage
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  
  public RecommendMessage()
  {
    super(0);
  }
  
  public RecommendMessage(int paramInt)
  {
    super(0, paramInt);
  }
  
  public RecommendMessage(RecommendContact paramRecommendContact, QQAppInterface paramQQAppInterface)
  {
    super(0);
    if (paramRecommendContact != null)
    {
      this.o = 1;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
      this.jdField_a_of_type_JavaUtilList.add(paramRecommendContact);
    }
    this.jdField_a_of_type_JavaLangString = ("你可能认识 " + a());
    this.jdField_a_of_type_Long = 0L;
    if (paramRecommendContact != null) {
      this.jdField_a_of_type_Long = paramRecommendContact.timeStamp;
    }
  }
  
  public RecommendMessage(List paramList, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(0);
    if (paramList != null)
    {
      this.o = paramList.size();
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_JavaLangString = ("你可能认识 " + a());
    this.jdField_a_of_type_Long = 0L;
    if (this.o > 0) {
      this.jdField_a_of_type_Long = ((RecommendContact)paramList.get(0)).timeStamp;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    i -= 1;
    for (;;)
    {
      RecommendContact localRecommendContact;
      if (i >= 0)
      {
        localRecommendContact = (RecommendContact)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localRecommendContact.type != 1) {
          break label94;
        }
        localStringBuilder.append(localRecommendContact.nickName);
      }
      for (;;)
      {
        j += 1;
        if (j <= 10) {
          break;
        }
        localStringBuilder.append("...");
        return localStringBuilder.toString();
        label94:
        if (localRecommendContact.type == 0) {
          localStringBuilder.append(localRecommendContact.contactName);
        }
      }
      if (i > 0) {
        localStringBuilder.append("、");
      }
      i -= 1;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.RecommendMessage
 * JD-Core Version:    0.7.0.1
 */