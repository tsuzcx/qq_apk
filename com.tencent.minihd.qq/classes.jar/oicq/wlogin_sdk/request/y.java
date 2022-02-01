package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t52c;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class y
  extends oicq_request
{
  public y(u paramu)
  {
    this.t = 2064;
    this.u = 17;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    int m = u.x;
    byte[] arrayOfByte1;
    int i;
    if ((paramString == null) && (paramInt4 == 1))
    {
      arrayOfByte1 = u.am;
      i = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      label32:
      int j;
      if (paramString == null)
      {
        arrayOfByte2 = null;
        arrayOfByte2 = a(paramLong1, paramLong2, paramInt1, m, paramArrayOfByte, arrayOfByte2, paramInt4, paramLong3, arrayOfByte1, paramInt2, paramInt3, paramArrayOfLong, paramWUserSigInfo);
        a(this.i, this.t, this.j, this.x.f, this.m, this.n, m, this.p, arrayOfByte2);
        j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (j == 0) {
          break label144;
        }
      }
      label144:
      do
      {
        int k;
        do
        {
          return j;
          arrayOfByte1 = null;
          break;
          arrayOfByte2 = paramString.getBytes();
          break label32;
          k = b();
          util.LOGI("retry num:" + i + " extra:" + paramLong3 + " ret:" + k, "" + this.x.f);
          j = k;
        } while (k != 180);
        j = k;
      } while (i >= 1);
      i += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, long paramLong3, byte[] paramArrayOfByte3, int paramInt4, int paramInt5, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    int[] arrayOfInt;
    ArrayList localArrayList;
    int j;
    int k;
    label117:
    byte[] arrayOfByte;
    Object localObject;
    if (paramArrayOfByte2 == null) {
      if (paramInt3 == 1)
      {
        arrayOfInt = new int[] { 256, 260, 264, 265, 1325, 8, 322, 325, 340, 1324, 278, 1313 };
        localArrayList = new ArrayList();
        int m = arrayOfInt.length;
        j = 0;
        k = 0;
        if (k >= m) {
          break label772;
        }
        arrayOfByte = new byte[0];
        switch (arrayOfInt[k])
        {
        default: 
          localObject = arrayOfByte;
          label252:
          if (localObject.length > 4)
          {
            int n = localObject.length;
            localArrayList.add(localObject);
            j = n + j;
            i += 1;
          }
          break;
        }
      }
    }
    for (;;)
    {
      k += 1;
      break label117;
      arrayOfInt = new int[] { 256, 264, 265, 1325, 8, 322, 325, 340, 1324, 278, 1313 };
      break;
      arrayOfInt = new int[] { 256, 264, 265, 1325, 8, 322, 325, 340, 274, 278, 1313 };
      break;
      localObject = new tlv_t100().get_tlv_100(paramLong1, paramLong2, paramInt2, paramInt1);
      break label252;
      localObject = new tlv_t104().get_tlv_104(paramArrayOfByte3);
      break label252;
      localObject = arrayOfByte;
      if (paramArrayOfByte1 == null) {
        break label252;
      }
      localObject = arrayOfByte;
      if (paramArrayOfByte1.length <= 0) {
        break label252;
      }
      localObject = new tlv_t108().get_tlv_108(paramArrayOfByte1);
      break label252;
      localObject = arrayOfByte;
      if (u.P == null) {
        break label252;
      }
      localObject = arrayOfByte;
      if (u.P.length <= 0) {
        break label252;
      }
      localObject = new tlv_t109().get_tlv_109(u.P);
      break label252;
      localObject = new tlv_t52d().get_tlv_52d(this.a);
      break label252;
      localObject = new tlv_t8().get_tlv_8(0, u.v, 0);
      break label252;
      localObject = new tlv_t142().get_tlv_142(u.F);
      break label252;
      localObject = new tlv_t145().get_tlv_145(u.B);
      break label252;
      localObject = new tlv_t154().get_tlv_154(this.x.i);
      break label252;
      localObject = new tlv_t112().get_tlv_112(paramArrayOfByte2);
      break label252;
      localObject = new tlv_t116().get_tlv_116(paramInt4, paramInt5, paramArrayOfLong);
      break label252;
      localObject = new tlv_t(1313);
      arrayOfByte = new byte[6];
      util.int32_to_buf(arrayOfByte, 0, u.aA);
      util.int16_to_buf(arrayOfByte, 4, 0);
      ((tlv_t)localObject).set_data(arrayOfByte, 6);
      localObject = ((tlv_t)localObject).get_buf();
      break label252;
      localObject = new tlv_t52c().get_tlv_52c(paramInt3, paramLong3);
      break label252;
      label772:
      paramArrayOfByte1 = (tlv_t)paramWUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(1322));
      paramInt1 = j;
      paramInt2 = i;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.get_buf();
        paramInt2 = i + 1;
        paramInt1 = j + paramArrayOfByte1.length;
        localArrayList.add(paramArrayOfByte1);
      }
      paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
      while (paramArrayOfByte1.hasNext())
      {
        paramArrayOfByte2 = (Integer)paramArrayOfByte1.next();
        paramArrayOfByte3 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
        paramInt1 += paramArrayOfByte3.length;
        localArrayList.add(paramArrayOfByte3);
        paramInt2 += 1;
        util.LOGI("Extra Tlv from user：0x" + paramArrayOfByte2);
      }
      paramArrayOfByte1 = new byte[paramInt1];
      paramInt3 = 0;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt3, paramArrayOfByte2.length);
        paramInt3 += paramArrayOfByte2.length;
        paramInt1 += 1;
      }
      return b(paramArrayOfByte1, this.u, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.y
 * JD-Core Version:    0.7.0.1
 */