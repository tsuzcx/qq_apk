import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.qphone.base.util.QLog;

public class jea
  implements Runnable
{
  public jea(MagicFaceSuperBigDecoder paramMagicFaceSuperBigDecoder) {}
  
  public void run()
  {
    long l2;
    label670:
    int i;
    label697:
    long l1;
    for (;;)
    {
      long l3;
      Object localObject;
      try
      {
        if (!QLog.isColorLevel()) {
          break label697;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run begins, isStartDecodr:" + this.a.jdField_a_of_type_Boolean);
      }
      catch (Exception localException)
      {
        int j;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run ends, error is catched.msg:" + localException.getMessage());
        return;
        this.a.l = j;
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoderReturnYUV(this.a.e, this.a.k, this.a.jdField_f_of_type_ArrayOfByte);
        if (this.a.m != -1) {
          continue;
        }
        this.a.m = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthAlphaDecoder();
        this.a.n = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightAlphaDecoder();
        if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener == null) {
          continue;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener.a(this.a.c, this.a.jdField_f_of_type_ArrayOfByte, this.a.i, this.a.j, 0.0F);
        l3 = System.currentTimeMillis() - l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run, 【useFrameTime】 " + l3);
        if (l3 >= this.a.jdField_f_of_type_Int) {
          break label670;
        }
        if (localObject <= 0L) {
          continue;
        }
        l2 = this.a.jdField_f_of_type_Int - l3;
        if (l2 <= localObject) {
          break label716;
        }
        Thread.sleep(l2 - localObject);
        break label705;
        Thread.sleep(this.a.jdField_f_of_type_Int - l3);
        l2 = localObject;
        break label708;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        break;
      }
      l2 = System.currentTimeMillis();
      j = this.a.a(this.a.jdField_a_of_type_ArrayOfByte, this.a.h);
      this.a.g = (j - this.a.h);
      if (this.a.g <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run ends, 【condition】 frame len <= 0, videoFrameLength:" + this.a.g);
        return;
      }
      this.a.a(this.a.g, this.a.h, this.a.jdField_a_of_type_ArrayOfByte);
      this.a.h = j;
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoderReturnYUV(this.a.b, this.a.g, this.a.c);
      if (this.a.i == -1)
      {
        this.a.i = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
        this.a.j = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
      }
      j = this.a.a(this.a.d, this.a.l);
      this.a.k = (j - this.a.l);
      this.a.b(this.a.k, this.a.l, this.a.d);
      if (this.a.k <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run ends, 【condition】 frame len <= 0, alphaFrameLength:" + this.a.k);
        return;
      }
      l2 = localObject;
      if (i != 0) {
        break label708;
      }
      i = this.a.jdField_f_of_type_Int;
      l2 = localObject + (l3 - i);
      break label708;
      l1 = 0L;
      i = 1;
    }
    return;
    for (;;)
    {
      label705:
      l2 = l1;
      label708:
      i = 0;
      l1 = l2;
      break;
      label716:
      l1 -= l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jea
 * JD-Core Version:    0.7.0.1
 */