package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.data.MessageForPic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class PicReq
  implements Comparable
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 0;
  public static final int j = 256;
  public static final int k = 1536;
  public static final int l = 1537;
  public static final int m = 1538;
  public ICompressionCallBack a;
  public MessageForPic a;
  public CompressInfo a;
  public PicDownloadInfo a;
  public PicFowardInfo a;
  public PicUploadInfo a;
  public UiCallBack a;
  public String a;
  public ArrayList a;
  public String b;
  public int n = -1;
  public int o;
  public int p;
  public int q = 1;
  public int r = this.q;
  
  public PicReq()
  {
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a()
  {
    return this.p / 256;
  }
  
  public int a(PicReq paramPicReq)
  {
    if (this.q < paramPicReq.q) {
      return -1;
    }
    if (this.q > paramPicReq.q) {
      return 1;
    }
    return 0;
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicUiCallBack = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      PicFowardInfo localPicFowardInfo = (PicFowardInfo)localIterator.next();
      if (localPicFowardInfo != null)
      {
        if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)
        {
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int = this.o;
        }
        if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
        {
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = this.o;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.b = Logger.a(((PicFowardInfo)paramArrayList.get(0)).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b, 2, 1);
  }
  
  public boolean a(MessageForPic paramMessageForPic, PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramPicDownloadInfo.jdField_a_of_type_Int = this.o;
    this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = paramPicDownloadInfo;
    int i1;
    if (this.n == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatthumb";
      i1 = 65537;
    }
    for (;;)
    {
      this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b, 0, i1);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
      return true;
      if (this.n == 7)
      {
        i1 = 131075;
        this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatraw";
      }
      else
      {
        if (this.n == 6) {
          this.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatimg";
        }
        i1 = 1;
      }
    }
  }
  
  public boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {}
    do
    {
      return false;
      paramCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    } while (paramCompressInfo.c == null);
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    return true;
  }
  
  public boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_Int = this.o;
    }
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null)
    {
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = this.o;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo = paramPicFowardInfo;
    int i1 = -1;
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null) {
      i1 = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b;
    }
    this.b = Logger.a(i1, 2, 1);
    return true;
  }
  
  public boolean a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo == null)
    {
      Logger.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramPicUploadInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramPicUploadInfo.jdField_a_of_type_Int = this.o;
    this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = paramPicUploadInfo;
    this.b = Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b, 1, 1);
    return true;
  }
  
  public int b()
  {
    return this.p % 256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicReq
 * JD-Core Version:    0.7.0.1
 */