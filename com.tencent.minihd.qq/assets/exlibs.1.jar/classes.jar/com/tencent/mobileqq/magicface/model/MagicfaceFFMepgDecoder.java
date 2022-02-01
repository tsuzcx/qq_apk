package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceFFMepgDecoder
  extends MagicfaceDecoder
{
  private static final String a = "MagicfaceFFMepgDecoder";
  public DecoderUtil a;
  public byte[] a;
  public int[] a;
  public byte[] b = new byte[51200];
  public byte[] c = null;
  public byte[] d = null;
  public byte[] e = new byte[51200];
  public byte[] f;
  public int g;
  public int h = 0;
  public int i = -1;
  public int j = -1;
  public int k;
  public int l = 0;
  public int m = -1;
  public int n = -1;
  
  public MagicfaceFFMepgDecoder()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder begins");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends");
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1;
    if (paramInt == paramArrayOfByte.length) {
      i1 = -1;
    }
    do
    {
      return i1;
      int i2 = paramInt + 1;
      int i3 = 0;
      int i4 = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
      i1 = i3;
      paramInt = i2;
      if (i4 != 7)
      {
        i1 = i3;
        paramInt = i2;
        if (i4 != 8)
        {
          i1 = 1;
          paramInt = i2;
        }
      }
      while (paramInt < paramArrayOfByte.length - 4) {
        if ((paramArrayOfByte[paramInt] == 0) && (paramArrayOfByte[(paramInt + 1)] == 0) && (paramArrayOfByte[(paramInt + 2)] == 0) && (paramArrayOfByte[(paramInt + 3)] == 1))
        {
          i2 = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
          if ((i2 != 7) && (i2 != 8))
          {
            if (i1 != 0) {
              break;
            }
            paramInt += 1;
            i1 = 1;
          }
          else
          {
            paramInt += 1;
          }
        }
        else
        {
          paramInt += 1;
        }
      }
      i1 = paramInt;
    } while (paramInt != paramArrayOfByte.length - 4);
    return paramArrayOfByte.length;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func maigcfaceDecoder begins:,isStartDecodr:" + this.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
        if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder() == 0) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder() != 0)) {}
        this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b;
        arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        if (arrayOfByte == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicfaceFFMepgDecoder", 2, "===MagicfaceDecoder=Exception==" + localException.getMessage());
        return;
        i1 = 1;
        l2 = 0L;
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        l1 = System.currentTimeMillis();
        i2 = a(this.jdField_a_of_type_ArrayOfByte, this.h);
        this.g = (i2 - this.h);
        i3 = this.g;
        if (i3 > 0) {
          continue;
        }
        return;
        a(this.g, this.h, this.jdField_a_of_type_ArrayOfByte);
        this.h = i2;
        l3 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoder(this.b, this.g, this.c);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicfaceFFMepgDecoder", 2, "decodeVideoDecoder==usetime=" + (System.currentTimeMillis() - l3) + "==videoFrameLength==" + this.g);
        try
        {
          if (this.i == -1)
          {
            this.i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
            this.j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
            if ((this.i > 500) || (this.j > 500))
            {
              this.i = -1;
              return;
            }
            this.jdField_a_of_type_ArrayOfInt = new int[this.j * this.i];
          }
          i2 = a(this.d, this.l);
          this.k = (i2 - this.l);
          b(this.k, this.l, this.d);
          this.l = i2;
          l3 = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoder(this.e, this.k, this.jdField_f_of_type_ArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "decodeAlphaDecoder==usetime=" + (System.currentTimeMillis() - l3) + "==alphaFrameLength==" + this.k);
          }
          l3 = System.currentTimeMillis();
          arrayOfInt = a(this.c, this.jdField_f_of_type_ArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "convertByteToColor==usetime=" + (System.currentTimeMillis() - l3));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener.a(arrayOfInt, this.i, this.j);
          }
          l3 = System.currentTimeMillis() - l1;
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "==============frameTime=============" + l3);
          }
          if (l3 >= this.jdField_f_of_type_Int) {
            continue;
          }
          if (l2 <= 0L) {
            continue;
          }
          l1 = this.jdField_f_of_type_Int - l3;
          if (l1 <= l2) {
            continue;
          }
          Thread.sleep(l1 - l2);
          l1 = l2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MagicfaceFFMepgDecoder", 2, "magicfaceffMepgDecoder outofMemoryError");
          }
          this.i = -1;
          System.gc();
        }
        return;
        l1 = l2 - l1;
        break label1004;
        Thread.sleep(this.jdField_f_of_type_Int - l3);
        l1 = l2;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        localOutOfMemoryError3.printStackTrace();
        return;
        l1 = l2;
        if (i1 != 0) {
          break label1004;
        }
        i1 = this.jdField_f_of_type_Int;
        l1 = l2 + (l3 - i1);
      }
      finally
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
      }
      this.d = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_ArrayOfByte;
      arrayOfByte = this.d;
      if (arrayOfByte == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
        }
      }
      else {
        try
        {
          this.c = new byte[480000];
          this.jdField_f_of_type_ArrayOfByte = new byte[480000];
          arrayOfByte = this.c;
          if (arrayOfByte == null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localOutOfMemoryError1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends, OOM.");
          }
        }
      }
    }
    for (;;)
    {
      long l1;
      int i2;
      int i3;
      long l3;
      int[] arrayOfInt;
      label1004:
      int i1 = 0;
      long l2 = l1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.b.length < paramInt1)
    {
      this.b = new byte[paramInt1];
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceFFMepgDecoder", 2, "videoFrame.length = " + this.b.length + "new framelength = " + paramInt1);
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.b, 0, paramInt1);
  }
  
  public int[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i2 = 0;
    if (i2 < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int i4 = i2 * 3;
      int i3 = paramArrayOfByte2[i4] & 0xFF;
      int i1;
      if (i3 <= 50) {
        i1 = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfInt[i2] = (i1 << 24 & 0xFF000000 | paramArrayOfByte1[(i4 + 2)] << 16 & 0xFF0000 | paramArrayOfByte1[(i4 + 1)] << 8 & 0xFF00 | paramArrayOfByte1[i4] & 0xFF);
        i2 += 1;
        break;
        i1 = i3;
        if (i3 >= 235) {
          i1 = 255;
        }
      }
    }
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.e.length < paramInt1)
    {
      this.e = new byte[paramInt1];
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceFFMepgDecoder", 2, "alphaFrame.length = " + this.e.length + " new fillFrameAlpha = " + paramInt1);
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.e, 0, paramInt1);
  }
  
  public void c()
  {
    super.c();
    this.b = null;
    this.e = null;
    this.jdField_f_of_type_ArrayOfByte = null;
    this.c = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    System.gc();
  }
  
  protected void f()
  {
    super.f();
    this.h = 0;
    this.l = 0;
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceFFMepgDecoder
 * JD-Core Version:    0.7.0.1
 */