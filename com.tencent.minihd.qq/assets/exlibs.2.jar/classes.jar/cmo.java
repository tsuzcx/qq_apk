import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

class cmo
  implements QRCodeEncodeCallback
{
  cmo(cmn paramcmn, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QRDisplayActivity.jdField_a_of_type_JavaLangString, 2, "onReceive qrcode url: " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Cmn.a.b) || (this.jdField_a_of_type_Cmn.a.isFinishing())) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Cmn.a.e();
      return;
    }
    this.jdField_a_of_type_Cmn.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramString);
    paramString = QRUtils.a(paramString, -1);
    if (paramString != null)
    {
      this.jdField_a_of_type_Cmn.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramString;
      this.jdField_a_of_type_Cmn.a.d();
      return;
    }
    this.jdField_a_of_type_Cmn.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cmo
 * JD-Core Version:    0.7.0.1
 */