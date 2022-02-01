import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class hlg
{
  public int a;
  public long a;
  public int b;
  public long b;
  public long c;
  public long d;
  public long e;
  
  public hlg(MemoryManager paramMemoryManager) {}
  
  public void a()
  {
    long l = DeviceInfoUtil.c();
    try
    {
      Object localObject = BaseApplicationImpl.a().getSharedPreferences("MemoryInfomation", 0).getString("LowMemoryStat", null);
      if (localObject == null) {
        return;
      }
      if (((String)localObject).length() == 0) {
        return;
      }
      localObject = new DataInputStream(new ByteArrayInputStream(Base64Util.decode((String)localObject, 0)));
      this.jdField_a_of_type_Long = ((DataInputStream)localObject).readLong();
      this.jdField_b_of_type_Long = ((DataInputStream)localObject).readLong();
      this.jdField_a_of_type_Int = ((DataInputStream)localObject).readInt();
      this.c = ((DataInputStream)localObject).readLong();
      this.d = ((DataInputStream)localObject).readLong();
      this.jdField_b_of_type_Int = ((DataInputStream)localObject).readInt();
      this.e = ((DataInputStream)localObject).readLong();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b();
      }
    }
    if ((l < this.jdField_a_of_type_Long) || (l < this.jdField_b_of_type_Long) || (l < this.c) || (l < this.d))
    {
      b();
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.c = 0L;
    this.d = 0L;
    this.jdField_b_of_type_Int = 0;
    this.e = 0L;
  }
  
  public void c()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(this.jdField_a_of_type_Long);
      localDataOutputStream.writeLong(this.jdField_b_of_type_Long);
      localDataOutputStream.writeInt(this.jdField_a_of_type_Int);
      localDataOutputStream.writeLong(this.c);
      localDataOutputStream.writeLong(this.d);
      localDataOutputStream.writeInt(this.jdField_b_of_type_Int);
      localDataOutputStream.writeLong(this.e);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      BaseApplicationImpl.a().getSharedPreferences("MemoryInfomation", 0).edit().putString("LowMemoryStat", Base64Util.encodeToString((byte[])localObject, 0)).commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hlg
 * JD-Core Version:    0.7.0.1
 */