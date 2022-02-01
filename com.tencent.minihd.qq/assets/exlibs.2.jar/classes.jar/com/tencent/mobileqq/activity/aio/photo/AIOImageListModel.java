package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.galleryactivity.AbstractImageListModel;
import java.util.ArrayList;
import java.util.List;

public class AIOImageListModel
  implements AbstractImageListModel
{
  static final String jdField_a_of_type_JavaLangString = "AIOImageListModel";
  int jdField_a_of_type_Int;
  AIOImageInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  int jdField_b_of_type_Int;
  AIOImageInfo jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo;
  int c;
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      AIOImageInfo localAIOImageInfo = (AIOImageInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localAIOImageInfo.a.jdField_a_of_type_Long == paramLong) && (localAIOImageInfo.a.jdField_e_of_type_Int == paramInt1))
      {
        if ("I:E".equals(paramString))
        {
          switch (paramInt2)
          {
          case 3: 
          default: 
            return i;
          case 2: 
            localAIOImageInfo.a.b = true;
            return i;
          case 4: 
            localAIOImageInfo.a.c = true;
            return i;
          }
          localAIOImageInfo.a.jdField_a_of_type_Boolean = true;
          return i;
        }
        switch (paramInt2)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          return i;
        case 1: 
          localAIOImageInfo.a.d = paramString;
          return i;
        case 2: 
          localAIOImageInfo.a.jdField_e_of_type_JavaLangString = paramString;
          return i;
        case 4: 
          localAIOImageInfo.a.f = paramString;
          return i;
        }
        localAIOImageInfo.a.g = paramString;
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public AIOImageInfo a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo;
  }
  
  public AIOImageInfo a(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt >= 0)) {
      return (AIOImageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo = a(paramInt);
  }
  
  public void a(AIOImageInfo paramAIOImageInfo)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo = paramAIOImageInfo;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.b = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo;
    this.jdField_a_of_type_JavaUtilList.add(paramAIOImageInfo);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfAIOImageData.length - 1;
    int i = 0;
    if (i < paramArrayOfAIOImageData.length)
    {
      AIOImageData localAIOImageData = paramArrayOfAIOImageData[i];
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.jdField_a_of_type_Long == localAIOImageData.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.jdField_e_of_type_Int == localAIOImageData.jdField_e_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.b = true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo == this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo) {
          j = i;
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.jdField_a_of_type_Long == localAIOImageData.jdField_a_of_type_Long) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.jdField_e_of_type_Int == localAIOImageData.jdField_e_of_type_Int))
        {
          localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo);
          j = i;
        }
        else
        {
          localArrayList.add(new AIOImageInfo(localAIOImageData));
        }
      }
    }
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < paramArrayOfAIOImageData.length) {}
    }
    else
    {
      i = j;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AIOImageInfo b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListModel
 * JD-Core Version:    0.7.0.1
 */