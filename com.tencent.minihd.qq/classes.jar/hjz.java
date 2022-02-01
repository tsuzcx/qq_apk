import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class hjz
{
  private static final float jdField_a_of_type_Float = 0.0F;
  private static hjz jdField_a_of_type_Hjz;
  private static final float jdField_b_of_type_Float = 15.0F;
  private static final String jdField_b_of_type_JavaLangString = "qq_process_gm";
  private static final String c = ";";
  public static final int d = 0;
  private static final String d = "\\|";
  public static final int e = 1;
  private static final String e = "__";
  public static final int f = 2;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  static final int j = 3;
  static final int k = 15;
  private static final int l = 20;
  private static final int m = 200;
  private static final int n = 5;
  private static final int o = 100;
  private static final int p = 1;
  private static final int q = 120;
  public int a;
  long jdField_a_of_type_Long = 720000L;
  public String a;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.94F, 0.6F, 0.0F };
  int[] jdField_a_of_type_ArrayOfInt = { 47185920, 68157440, 89128960, 120586240 };
  public int b;
  int[] jdField_b_of_type_ArrayOfInt = { 3840000, 1920000, 960000, 720000, 600000 };
  public int c = 0;
  private int r = 1;
  private int s = -1;
  private int t = 1;
  
  private hjz()
  {
    this.jdField_a_of_type_Int = 12;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_JavaLangString = "";
    Object localObject1 = DeviceProfileManager.a();
    Object localObject2 = ((DeviceProfileManager)localObject1).a("qq_process_gm");
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "config = " + (String)localObject2);
    }
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals("0"))) {}
    int i1;
    label359:
    do
    {
      do
      {
        return;
        localObject2 = ((String)localObject2).split("__");
        if (localObject2.length > 1) {
          localObject1 = localObject2[(localObject1.jdField_a_of_type_Int % localObject2.length)];
        }
        for (;;)
        {
          localObject1 = ((String)localObject1).split(";");
          if (localObject1.length < 4) {
            break;
          }
          try
          {
            localObject2 = localObject1[0].split("\\|");
            i1 = 0;
            for (;;)
            {
              if (i1 >= this.jdField_a_of_type_ArrayOfInt.length) {
                break label359;
              }
              i2 = Integer.parseInt(localObject2[i1]);
              if ((i2 <= 20) || (i2 >= 200)) {
                break;
              }
              this.jdField_a_of_type_ArrayOfInt[i1] = (i2 * 1024 * 1024);
              i1 += 1;
            }
            localObject1 = localObject2[0];
            continue;
            throw new IllegalArgumentException("Illegal memory size " + i2);
          }
          catch (Throwable localThrowable) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("GuardManager", 2, "Exception: ", localThrowable);
      return;
      localObject2 = localThrowable[1].split("\\|");
      i1 = 0;
      while (i1 < this.jdField_b_of_type_ArrayOfInt.length)
      {
        i2 = Integer.parseInt(localObject2[i1]);
        if ((i2 > 5) && (i2 < 100))
        {
          this.jdField_b_of_type_ArrayOfInt[i1] = (i2 * 60 * 1000);
          i1 += 1;
        }
        else
        {
          throw new IllegalArgumentException("Illegal timeout value " + i2);
        }
      }
      localObject2 = localThrowable[2].split("\\|");
      float f1;
      if (this.jdField_a_of_type_ArrayOfFloat.length < localObject2.length)
      {
        i1 = this.jdField_a_of_type_ArrayOfFloat.length;
        break label762;
        for (;;)
        {
          if (i2 >= i1) {
            break label553;
          }
          f1 = Float.parseFloat(localObject2[i2]);
          if ((f1 < 0.0F) || (f1 > 15.0F)) {
            break;
          }
          this.jdField_a_of_type_ArrayOfFloat[i2] = f1;
          i2 += 1;
        }
      }
      i1 = localObject2.length;
      break label762;
      throw new IllegalArgumentException("Illegal fraction value " + f1);
      i1 = Integer.parseInt(localThrowable[3].split("\\|")[0]);
      if ((i1 <= 1) || (i1 >= 120)) {
        break;
      }
      this.jdField_a_of_type_Long = (i1 * 60 * 1000);
    } while (localThrowable.length <= 4);
    label479:
    localObject2 = localThrowable[4].split("\\|");
    label553:
    int i2 = Integer.parseInt(localObject2[0]);
    if (i2 < 1) {
      i1 = 1;
    }
    for (;;)
    {
      if (24 % i1 == 0) {
        this.jdField_a_of_type_Int = i1;
      }
      i2 = Integer.parseInt(localObject2[1]);
      if (i2 < 0) {
        i1 = 0;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i1;
        if (localThrowable.length > 6)
        {
          this.c = Integer.parseInt(localThrowable[5]);
          this.jdField_a_of_type_JavaLangString = localThrowable[6];
        }
        if (localThrowable.length <= 7) {
          break;
        }
        i1 = Integer.parseInt(localThrowable[7]);
        if ((i1 < 1) || (i1 >= 10)) {
          break;
        }
        com.tencent.mobileqq.app.GuardManager.p = i1;
        return;
        throw new IllegalArgumentException("Illegal wake interval " + i1);
        i1 = i2;
        if (i2 > this.jdField_a_of_type_Int) {
          i1 = this.jdField_a_of_type_Int;
        }
      }
      label762:
      i2 = 0;
      break label479;
      i1 = i2;
      if (i2 > 24) {
        i1 = 24;
      }
    }
  }
  
  public static hjz a()
  {
    if (jdField_a_of_type_Hjz == null) {}
    try
    {
      if (jdField_a_of_type_Hjz == null) {
        jdField_a_of_type_Hjz = new hjz();
      }
      return jdField_a_of_type_Hjz;
    }
    finally {}
  }
  
  public int a(long paramLong)
  {
    int i2 = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, (int)paramLong);
    int i1 = i2;
    if (i2 < 0) {
      i1 = -1 - i2;
    }
    i2 = i1 - this.r;
    if (i2 > 2) {
      i1 = 2;
    }
    do
    {
      return i1;
      i1 = i2;
    } while (i2 >= 0);
    return 0;
  }
  
  public int a(long[][] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    if (paramInt2 != this.s)
    {
      paramInt1 = 0;
      float f2;
      for (float f1 = 0.0F; paramInt1 < 3; f1 += f2)
      {
        int i1 = 0;
        f2 = 0.0F;
        while (i1 < 15)
        {
          f2 += (float)paramArrayOfLong[paramInt1][i1];
          i1 += 1;
        }
        f2 = this.jdField_a_of_type_ArrayOfFloat[paramInt1] * f2 * 5.0F / 15.0F;
        paramInt1 += 1;
      }
      paramInt1 = (int)(3.0F - f1);
      if (paramInt1 < 0) {
        paramInt1 = i2;
      }
    }
    for (;;)
    {
      this.s = paramInt2;
      this.t = paramInt1;
      return paramInt1;
      if (paramInt1 > 2)
      {
        paramInt1 = 2;
        continue;
        return this.t;
      }
    }
  }
  
  public long a(long[][] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    return this.jdField_b_of_type_ArrayOfInt[(a(paramLong) + a(paramArrayOfLong, paramInt1, paramInt2))];
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjz
 * JD-Core Version:    0.7.0.1
 */