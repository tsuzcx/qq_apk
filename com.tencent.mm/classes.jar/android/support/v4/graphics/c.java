package android.support.v4.graphics;

import android.graphics.Path;
import java.util.ArrayList;

public final class c
{
  private static void a(ArrayList<b> paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new b(paramChar, paramArrayOfFloat));
  }
  
  public static boolean a(b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    if ((paramArrayOfb1 == null) || (paramArrayOfb2 == null)) {}
    while (paramArrayOfb1.length != paramArrayOfb2.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfb1.length) {
        break label64;
      }
      if ((paramArrayOfb1[i].HQ != paramArrayOfb2[i].HQ) || (paramArrayOfb1[i].HR.length != paramArrayOfb2[i].HR.length)) {
        break;
      }
      i += 1;
    }
    label64:
    return true;
  }
  
  static float[] a(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfFloat.length;
    if (i < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt += 0;
    i = Math.min(paramInt, i + 0);
    float[] arrayOfFloat = new float[paramInt];
    System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, i);
    return arrayOfFloat;
  }
  
  public static b[] a(b[] paramArrayOfb)
  {
    if (paramArrayOfb == null) {
      return null;
    }
    b[] arrayOfb = new b[paramArrayOfb.length];
    int i = 0;
    while (i < paramArrayOfb.length)
    {
      arrayOfb[i] = new b(paramArrayOfb[i]);
      i += 1;
    }
    return arrayOfb;
  }
  
  private static int e(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((((i - 65) * (i - 90) > 0) && ((i - 97) * (i - 122) > 0)) || (i == 101) || (i == 69)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public static Path x(String paramString)
  {
    Path localPath = new Path();
    b[] arrayOfb = y(paramString);
    if (arrayOfb != null) {
      try
      {
        b.a(arrayOfb, localPath);
        return localPath;
      }
      catch (RuntimeException localRuntimeException)
      {
        throw new RuntimeException("Error in parsing ".concat(String.valueOf(paramString)), localRuntimeException);
      }
    }
    return null;
  }
  
  public static b[] y(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length())
    {
      j = e(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = z(str);
        a(localArrayList, str.charAt(0), arrayOfFloat);
      }
      int k = j + 1;
      i = j;
      j = k;
    }
    if ((j - i == 1) && (i < paramString.length())) {
      a(localArrayList, paramString.charAt(i), new float[0]);
    }
    return (b[])localArrayList.toArray(new b[localArrayList.size()]);
  }
  
  private static float[] z(String paramString)
  {
    if ((paramString.charAt(0) == 'z') || (paramString.charAt(0) == 'Z')) {
      return new float[0];
    }
    for (;;)
    {
      int i1;
      int m;
      int n;
      try
      {
        float[] arrayOfFloat = new float[paramString.length()];
        a locala = new a();
        int i2 = paramString.length();
        k = 1;
        j = 0;
        if (k < i2)
        {
          locala.HP = false;
          i = 0;
          i1 = 0;
          m = 0;
          n = k;
          if (n >= paramString.length()) {}
        }
        switch (paramString.charAt(n))
        {
        case '-': 
          if ((n == k) || (i != 0)) {
            break label289;
          }
          locala.HP = true;
          i = 0;
          m = 1;
          break label291;
          label172:
          locala.HP = true;
          i = 0;
          m = 1;
          break label291;
          locala.HO = n;
          m = locala.HO;
          if (k < m)
          {
            i = j + 1;
            arrayOfFloat[j] = Float.parseFloat(paramString.substring(k, m));
            if (!locala.HP) {
              break label331;
            }
            k = m;
            j = i;
            continue;
            arrayOfFloat = a(arrayOfFloat, j);
            return arrayOfFloat;
          }
          break;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new RuntimeException("error in parsing \"" + paramString + "\"", localNumberFormatException);
      }
      int i = j;
      continue;
      label289:
      i = 0;
      for (;;)
      {
        label291:
        if (m != 0) {
          break label329;
        }
        n += 1;
        break;
        i = 0;
        m = 1;
        continue;
        if (i1 != 0) {
          break label172;
        }
        i = 0;
        i1 = 1;
        continue;
        i = 1;
      }
      label329:
      continue;
      label331:
      int k = m + 1;
      int j = i;
    }
  }
  
  static final class a
  {
    int HO;
    boolean HP;
  }
  
  public static final class b
  {
    public char HQ;
    public float[] HR;
    
    b(char paramChar, float[] paramArrayOfFloat)
    {
      this.HQ = paramChar;
      this.HR = paramArrayOfFloat;
    }
    
    b(b paramb)
    {
      this.HQ = paramb.HQ;
      this.HR = c.a(paramb.HR, paramb.HR.length);
    }
    
    private static void a(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
    {
      int j = (int)Math.ceil(Math.abs(4.0D * paramDouble9 / 3.141592653589793D));
      double d6 = Math.cos(paramDouble7);
      double d7 = Math.sin(paramDouble7);
      paramDouble7 = Math.cos(paramDouble8);
      double d2 = Math.sin(paramDouble8);
      double d1 = -paramDouble3 * d6 * d2 - paramDouble4 * d7 * paramDouble7;
      d2 = paramDouble7 * (paramDouble4 * d6) + d2 * (-paramDouble3 * d7);
      double d8 = paramDouble9 / j;
      int i = 0;
      paramDouble9 = paramDouble8;
      paramDouble8 = paramDouble6;
      paramDouble7 = paramDouble5;
      paramDouble6 = d1;
      paramDouble5 = d2;
      while (i < j)
      {
        double d3 = paramDouble9 + d8;
        double d5 = Math.sin(d3);
        double d9 = Math.cos(d3);
        d1 = paramDouble3 * d6 * d9 + paramDouble1 - paramDouble4 * d7 * d5;
        d2 = paramDouble4 * d6 * d5 + (paramDouble3 * d7 * d9 + paramDouble2);
        double d4 = -paramDouble3 * d6 * d5 - paramDouble4 * d7 * d9;
        d5 = d9 * (paramDouble4 * d6) + d5 * (-paramDouble3 * d7);
        d9 = Math.tan((d3 - paramDouble9) / 2.0D);
        paramDouble9 = Math.sin(d3 - paramDouble9);
        paramDouble9 = (Math.sqrt(d9 * (3.0D * d9) + 4.0D) - 1.0D) * paramDouble9 / 3.0D;
        paramPath.rLineTo(0.0F, 0.0F);
        paramPath.cubicTo((float)(paramDouble6 * paramDouble9 + paramDouble7), (float)(paramDouble8 + paramDouble5 * paramDouble9), (float)(d1 - paramDouble9 * d4), (float)(d2 - paramDouble9 * d5), (float)d1, (float)d2);
        paramDouble5 = d5;
        paramDouble6 = d4;
        paramDouble9 = d3;
        i += 1;
        paramDouble8 = d2;
        paramDouble7 = d1;
      }
    }
    
    private static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
    {
      double d5;
      double d6;
      double d7;
      double d8;
      double d9;
      double d4;
      double d11;
      double d10;
      double d3;
      double d2;
      double d13;
      for (;;)
      {
        d5 = Math.toRadians(paramFloat7);
        d6 = Math.cos(d5);
        d7 = Math.sin(d5);
        d8 = (paramFloat1 * d6 + paramFloat2 * d7) / paramFloat5;
        d9 = (-paramFloat1 * d7 + paramFloat2 * d6) / paramFloat6;
        d1 = (paramFloat3 * d6 + paramFloat4 * d7) / paramFloat5;
        d4 = (-paramFloat3 * d7 + paramFloat4 * d6) / paramFloat6;
        d11 = d8 - d1;
        d10 = d9 - d4;
        d3 = (d8 + d1) / 2.0D;
        d2 = (d9 + d4) / 2.0D;
        d12 = d11 * d11 + d10 * d10;
        if (d12 == 0.0D) {
          return;
        }
        d13 = 1.0D / d12 - 0.25D;
        if (d13 >= 0.0D) {
          break;
        }
        float f = (float)(Math.sqrt(d12) / 1.99999D);
        paramFloat5 *= f;
        paramFloat6 *= f;
      }
      double d12 = Math.sqrt(d13);
      d11 *= d12;
      d10 *= d12;
      if (paramBoolean1 == paramBoolean2)
      {
        d3 -= d10;
        d2 = d11 + d2;
        d8 = Math.atan2(d9 - d2, d8 - d3);
        d4 = Math.atan2(d4 - d2, d1 - d3) - d8;
        if (d4 < 0.0D) {
          break label384;
        }
        paramBoolean1 = true;
        label282:
        d1 = d4;
        if (paramBoolean2 != paramBoolean1) {
          if (d4 <= 0.0D) {
            break label390;
          }
        }
      }
      label384:
      label390:
      for (double d1 = d4 - 6.283185307179586D;; d1 = d4 + 6.283185307179586D)
      {
        d3 *= paramFloat5;
        d2 = paramFloat6 * d2;
        a(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d6 * d2, paramFloat5, paramFloat6, paramFloat1, paramFloat2, d5, d8, d1);
        return;
        d3 = d10 + d3;
        d2 -= d11;
        break;
        paramBoolean1 = false;
        break label282;
      }
    }
    
    private static void a(Path paramPath, float[] paramArrayOfFloat1, char paramChar1, char paramChar2, float[] paramArrayOfFloat2)
    {
      float f6 = paramArrayOfFloat1[0];
      float f5 = paramArrayOfFloat1[1];
      float f4 = paramArrayOfFloat1[2];
      float f3 = paramArrayOfFloat1[3];
      float f1 = paramArrayOfFloat1[4];
      float f2 = paramArrayOfFloat1[5];
      char c1;
      float f7;
      int i;
      label236:
      float f8;
      float f9;
      float f10;
      switch (paramChar2)
      {
      default: 
        c1 = '\002';
        char c2 = '\000';
        f7 = f3;
        f3 = f4;
        f4 = f5;
        f5 = f6;
        i = paramChar1;
        f6 = f4;
        paramChar1 = c2;
        f4 = f7;
        if (paramChar1 < paramArrayOfFloat2.length) {
          switch (paramChar2)
          {
          default: 
            f7 = f2;
            f2 = f4;
            f4 = f6;
            f6 = f5;
            f5 = f4;
            f4 = f3;
            f3 = f1;
            f1 = f7;
          }
        }
        break;
      case 'Z': 
      case 'z': 
      case 'L': 
      case 'M': 
      case 'T': 
      case 'l': 
      case 'm': 
      case 't': 
      case 'H': 
      case 'V': 
      case 'h': 
      case 'v': 
      case 'C': 
      case 'c': 
      case 'Q': 
      case 'S': 
      case 'q': 
      case 's': 
      case 'A': 
      case 'a': 
        for (;;)
        {
          paramChar1 += c1;
          f7 = f3;
          f3 = f4;
          f8 = f6;
          i = paramChar2;
          f4 = f2;
          f2 = f1;
          f1 = f7;
          f6 = f5;
          f5 = f8;
          break label236;
          paramPath.close();
          paramPath.moveTo(f1, f2);
          f3 = f2;
          f4 = f1;
          f5 = f2;
          f6 = f1;
          c1 = '\002';
          break;
          c1 = '\002';
          break;
          c1 = '\001';
          break;
          c1 = '\006';
          break;
          c1 = '\004';
          break;
          c1 = '\007';
          break;
          f5 += paramArrayOfFloat2[(paramChar1 + '\000')];
          f6 = paramArrayOfFloat2[(paramChar1 + '\001')] + f6;
          if (paramChar1 > 0)
          {
            paramPath.rLineTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
            f7 = f1;
            f9 = f4;
            f4 = f3;
            f8 = f5;
            f1 = f2;
            f2 = f9;
            f3 = f7;
            f5 = f6;
            f6 = f8;
          }
          else
          {
            paramPath.rMoveTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
            f1 = f6;
            f7 = f5;
            f2 = f4;
            f4 = f3;
            f8 = f5;
            f3 = f7;
            f5 = f6;
            f6 = f8;
            continue;
            f5 = paramArrayOfFloat2[(paramChar1 + '\000')];
            f6 = paramArrayOfFloat2[(paramChar1 + '\001')];
            if (paramChar1 > 0)
            {
              paramPath.lineTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
              f7 = f1;
              f9 = f4;
              f4 = f3;
              f8 = f5;
              f1 = f2;
              f2 = f9;
              f3 = f7;
              f5 = f6;
              f6 = f8;
            }
            else
            {
              paramPath.moveTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
              f1 = f6;
              f7 = f5;
              f2 = f4;
              f4 = f3;
              f8 = f5;
              f3 = f7;
              f5 = f6;
              f6 = f8;
              continue;
              paramPath.rLineTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
              f9 = paramArrayOfFloat2[(paramChar1 + '\000')];
              f10 = paramArrayOfFloat2[(paramChar1 + '\001')];
              f7 = f1;
              f8 = f4;
              f4 = f3;
              f6 = f10 + f6;
              f9 = f5 + f9;
              f1 = f2;
              f2 = f8;
              f3 = f7;
              f5 = f6;
              f6 = f9;
              continue;
              paramPath.lineTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
              f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
              f6 = paramArrayOfFloat2[(paramChar1 + '\001')];
              f5 = f1;
              f8 = f4;
              f4 = f3;
              f1 = f2;
              f2 = f8;
              f3 = f5;
              f5 = f6;
              f6 = f7;
              continue;
              paramPath.rLineTo(paramArrayOfFloat2[(paramChar1 + '\000')], 0.0F);
              f9 = paramArrayOfFloat2[(paramChar1 + '\000')];
              f7 = f1;
              f8 = f4;
              f4 = f3;
              f9 = f5 + f9;
              f1 = f2;
              f2 = f8;
              f3 = f7;
              f5 = f6;
              f6 = f9;
              continue;
              paramPath.lineTo(paramArrayOfFloat2[(paramChar1 + '\000')], f6);
              f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
              f5 = f1;
              f8 = f4;
              f4 = f3;
              f1 = f2;
              f2 = f8;
              f3 = f5;
              f5 = f6;
              f6 = f7;
              continue;
              paramPath.rLineTo(0.0F, paramArrayOfFloat2[(paramChar1 + '\000')]);
              f9 = paramArrayOfFloat2[(paramChar1 + '\000')];
              f7 = f1;
              f8 = f4;
              f4 = f3;
              f9 += f6;
              f6 = f5;
              f1 = f2;
              f2 = f8;
              f3 = f7;
              f5 = f9;
              continue;
              paramPath.lineTo(f5, paramArrayOfFloat2[(paramChar1 + '\000')]);
              f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
              f6 = f1;
              f9 = f4;
              f4 = f3;
              f8 = f5;
              f1 = f2;
              f2 = f9;
              f3 = f6;
              f5 = f7;
              f6 = f8;
              continue;
              paramPath.rCubicTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')], paramArrayOfFloat2[(paramChar1 + '\004')], paramArrayOfFloat2[(paramChar1 + '\005')]);
              f4 = paramArrayOfFloat2[(paramChar1 + '\002')];
              f7 = paramArrayOfFloat2[(paramChar1 + '\003')];
              f8 = paramArrayOfFloat2[(paramChar1 + '\004')];
              f9 = paramArrayOfFloat2[(paramChar1 + '\005')];
              f3 = f1;
              f7 = f6 + f7;
              f4 = f5 + f4;
              f6 = f9 + f6;
              f8 = f5 + f8;
              f1 = f2;
              f2 = f7;
              f5 = f6;
              f6 = f8;
              continue;
              paramPath.cubicTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')], paramArrayOfFloat2[(paramChar1 + '\004')], paramArrayOfFloat2[(paramChar1 + '\005')]);
              f6 = paramArrayOfFloat2[(paramChar1 + '\004')];
              f5 = paramArrayOfFloat2[(paramChar1 + '\005')];
              f4 = paramArrayOfFloat2[(paramChar1 + '\002')];
              f7 = paramArrayOfFloat2[(paramChar1 + '\003')];
              f3 = f1;
              f1 = f2;
              f2 = f7;
              continue;
              f7 = 0.0F;
              f8 = 0.0F;
              if ((i == 99) || (i == 115) || (i == 67) || (i == 83))
              {
                f7 = f5 - f3;
                f8 = f6 - f4;
              }
              paramPath.rCubicTo(f7, f8, paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')]);
              f4 = paramArrayOfFloat2[(paramChar1 + '\000')];
              f7 = paramArrayOfFloat2[(paramChar1 + '\001')];
              f8 = paramArrayOfFloat2[(paramChar1 + '\002')];
              f9 = paramArrayOfFloat2[(paramChar1 + '\003')];
              f3 = f1;
              f7 = f6 + f7;
              f4 = f5 + f4;
              f6 = f9 + f6;
              f8 = f5 + f8;
              f1 = f2;
              f2 = f7;
              f5 = f6;
              f6 = f8;
            }
          }
        }
        if ((i == 99) || (i == 115) || (i == 67) || (i == 83))
        {
          f3 = 2.0F * f5 - f3;
          f6 = 2.0F * f6 - f4;
        }
        break;
      }
      for (;;)
      {
        paramPath.cubicTo(f3, f6, paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')]);
        f4 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f7 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f6 = paramArrayOfFloat2[(paramChar1 + '\002')];
        f5 = paramArrayOfFloat2[(paramChar1 + '\003')];
        f3 = f1;
        f1 = f2;
        f2 = f7;
        break;
        paramPath.rQuadTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')]);
        f4 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f7 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f8 = paramArrayOfFloat2[(paramChar1 + '\002')];
        f9 = paramArrayOfFloat2[(paramChar1 + '\003')];
        f3 = f1;
        f7 = f6 + f7;
        f4 = f5 + f4;
        f6 = f9 + f6;
        f8 = f5 + f8;
        f1 = f2;
        f2 = f7;
        f5 = f6;
        f6 = f8;
        break;
        paramPath.quadTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')]);
        f4 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f7 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f6 = paramArrayOfFloat2[(paramChar1 + '\002')];
        f5 = paramArrayOfFloat2[(paramChar1 + '\003')];
        f3 = f1;
        f1 = f2;
        f2 = f7;
        break;
        f7 = 0.0F;
        f8 = 0.0F;
        if ((i == 113) || (i == 116) || (i == 81) || (i == 84))
        {
          f7 = f5 - f3;
          f8 = f6 - f4;
        }
        paramPath.rQuadTo(f7, f8, paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
        f9 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f10 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f3 = f1;
        f8 = f6 + f8;
        f4 = f5 + f7;
        f6 = f10 + f6;
        f7 = f5 + f9;
        f1 = f2;
        f2 = f8;
        f5 = f6;
        f6 = f7;
        break;
        if ((i != 113) && (i != 116) && (i != 81))
        {
          f8 = f6;
          f7 = f5;
          if (i != 84) {}
        }
        else
        {
          f7 = 2.0F * f5 - f3;
          f8 = 2.0F * f6 - f4;
        }
        paramPath.quadTo(f7, f8, paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
        f6 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f5 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f3 = f1;
        f4 = f7;
        f1 = f2;
        f2 = f8;
        break;
        f3 = paramArrayOfFloat2[(paramChar1 + '\005')];
        f4 = paramArrayOfFloat2[(paramChar1 + '\006')];
        f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
        boolean bool1;
        if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F)
        {
          bool1 = true;
          label2166:
          if (paramArrayOfFloat2[(paramChar1 + '\004')] == 0.0F) {
            break label2268;
          }
        }
        label2268:
        for (boolean bool2 = true;; bool2 = false)
        {
          a(paramPath, f5, f6, f3 + f5, f4 + f6, f7, f8, f9, bool1, bool2);
          f3 = f5 + paramArrayOfFloat2[(paramChar1 + '\005')];
          f5 = f6 + paramArrayOfFloat2[(paramChar1 + '\006')];
          f7 = f1;
          f8 = f5;
          f4 = f3;
          f6 = f3;
          f1 = f2;
          f2 = f8;
          f3 = f7;
          break;
          bool1 = false;
          break label2166;
        }
        f3 = paramArrayOfFloat2[(paramChar1 + '\005')];
        f4 = paramArrayOfFloat2[(paramChar1 + '\006')];
        f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
        if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F)
        {
          bool1 = true;
          label2329:
          if (paramArrayOfFloat2[(paramChar1 + '\004')] == 0.0F) {
            break label2411;
          }
        }
        label2411:
        for (bool2 = true;; bool2 = false)
        {
          a(paramPath, f5, f6, f3, f4, f7, f8, f9, bool1, bool2);
          f6 = paramArrayOfFloat2[(paramChar1 + '\005')];
          f5 = paramArrayOfFloat2[(paramChar1 + '\006')];
          f3 = f1;
          f7 = f5;
          f4 = f6;
          f1 = f2;
          f2 = f7;
          break;
          bool1 = false;
          break label2329;
        }
        paramArrayOfFloat1[0] = f5;
        paramArrayOfFloat1[1] = f6;
        paramArrayOfFloat1[2] = f3;
        paramArrayOfFloat1[3] = f4;
        paramArrayOfFloat1[4] = f1;
        paramArrayOfFloat1[5] = f2;
        return;
        f3 = f5;
      }
    }
    
    public static void a(b[] paramArrayOfb, Path paramPath)
    {
      float[] arrayOfFloat = new float[6];
      char c = 'm';
      int i = 0;
      while (i < paramArrayOfb.length)
      {
        a(paramPath, arrayOfFloat, c, paramArrayOfb[i].HQ, paramArrayOfb[i].HR);
        c = paramArrayOfb[i].HQ;
        i += 1;
      }
    }
    
    public final void a(b paramb1, b paramb2, float paramFloat)
    {
      int i = 0;
      while (i < paramb1.HR.length)
      {
        this.HR[i] = (paramb1.HR[i] * (1.0F - paramFloat) + paramb2.HR[i] * paramFloat);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.c
 * JD-Core Version:    0.7.0.1
 */