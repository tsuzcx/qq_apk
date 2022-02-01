package cooperation.qzone;

import QMF_PROTOCAL.RetryInfo;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import cooperation.qzone.util.ProtocolUtils;

public abstract class QzoneExternalRequest
{
  public static final String p = "hostuin";
  public static final String q = "refer";
  public static final String r = "tail_name";
  public static final int v = 1000027;
  private long jdField_a_of_type_Long;
  private RetryInfo jdField_a_of_type_QMF_PROTOCALRetryInfo;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = 0L;
  public JceStruct b;
  private String jdField_b_of_type_JavaLangString = "utf-8";
  protected boolean b;
  private String c;
  
  public QzoneExternalRequest()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected static JceStruct a(byte[] paramArrayOfByte, String paramString)
  {
    return ProtocolUtils.a(paramArrayOfByte, paramString);
  }
  
  public RetryInfo a()
  {
    return this.jdField_a_of_type_QMF_PROTOCALRetryInfo;
  }
  
  public JceStruct a()
  {
    return this.jdField_b_of_type_ComQqTafJceJceStruct;
  }
  
  public abstract String a();
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(RetryInfo paramRetryInfo)
  {
    this.jdField_a_of_type_QMF_PROTOCALRetryInfo = paramRetryInfo;
  }
  
  public void a(JceStruct paramJceStruct)
  {
    this.jdField_b_of_type_ComQqTafJceJceStruct = paramJceStruct;
  }
  
  protected byte[] a()
  {
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.setEncodeName("utf8");
    localUniAttribute.put("hostuin", Long.valueOf(c()));
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      localUniAttribute.put(str, this.jdField_b_of_type_ComQqTafJceJceStruct);
    }
    this.jdField_a_of_type_JavaLangString = k();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localUniAttribute.put("refer", this.jdField_a_of_type_JavaLangString);
    }
    str = g();
    if (!TextUtils.isEmpty(str)) {
      localUniAttribute.put("tail_name", str);
    }
    return localUniAttribute.encode();
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public byte[] b()
  {
    Object localObject1 = h();
    Object localObject2 = QUA.a();
    long l = b();
    RetryInfo localRetryInfo = a();
    localObject1 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = a();
    if (localObject2 != null) {
      return ProtocolUtils.a(((WNSStream)localObject1).a(MsfSdkUtils.getNextAppSeq(), f(), (byte[])localObject2, this.jdField_b_of_type_Boolean));
    }
    return null;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void e(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public abstract String f();
  
  public void f(String paramString)
  {
    this.c = paramString;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public String h()
  {
    return PlatformInfor.a().e();
  }
  
  public String k()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String l()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QzoneExternalRequest
 * JD-Core Version:    0.7.0.1
 */