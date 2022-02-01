package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t127;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class aa
  extends oicq_request
{
  public aa(u paramu)
  {
    this.t = 2064;
    this.u = 18;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = 0;
    int[] arrayOfInt = new int[6];
    int[] tmp11_9 = arrayOfInt;
    tmp11_9[0] = 260;
    int[] tmp17_11 = tmp11_9;
    tmp17_11[1] = 8;
    int[] tmp22_17 = tmp17_11;
    tmp22_17[2] = 295;
    int[] tmp28_22 = tmp22_17;
    tmp28_22[3] = 388;
    int[] tmp34_28 = tmp28_22;
    tmp34_28[4] = 278;
    int[] tmp40_34 = tmp34_28;
    tmp40_34[5] = 1313;
    tmp40_34;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    int i = 0;
    async_context localasync_context = u.b(this.x.h);
    int n = 0;
    if (n < i1)
    {
      Object localObject = new byte[0];
      switch (arrayOfInt[n])
      {
      }
      for (;;)
      {
        int k = i;
        int m = j;
        if (localObject.length > 4)
        {
          m = j + 1;
          k = i + localObject.length;
          localArrayList.add(localObject);
        }
        n += 1;
        j = m;
        i = k;
        break;
        localObject = localasync_context._t104.get_buf();
        continue;
        localObject = new tlv_t8().get_tlv_8(0, u.v, 0);
        continue;
        localObject = new tlv_t127().get_tlv_127(paramArrayOfByte, localasync_context._t126.get_random());
        continue;
        localObject = new tlv_t184().get_tlv_184(localasync_context._msalt, localasync_context._mpasswd);
        continue;
        localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
        continue;
        localObject = new tlv_t(1313);
        byte[] arrayOfByte = new byte[6];
        util.int32_to_buf(arrayOfByte, 0, u.aA);
        util.int16_to_buf(arrayOfByte, 4, 0);
        ((tlv_t)localObject).set_data(arrayOfByte, 6);
        localObject = ((tlv_t)localObject).get_buf();
      }
    }
    paramArrayOfByte = (tlv_t)paramWUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(1322));
    paramInt2 = i;
    paramInt1 = j;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = paramArrayOfByte.get_buf();
      paramInt1 = j + 1;
      paramInt2 = i + paramArrayOfByte.length;
      localArrayList.add(paramArrayOfByte);
    }
    paramArrayOfByte = new byte[paramInt2];
    i = 0;
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      paramArrayOfLong = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte, i, paramArrayOfLong.length);
      i += paramArrayOfLong.length;
      paramInt2 += 1;
    }
    return b(paramArrayOfByte, this.u, paramInt1);
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = u.x;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramString.getBytes(), paramInt1, paramInt2, paramArrayOfLong, paramWUserSigInfo);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, arrayOfByte);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      k = b();
      util.LOGI("retry num:" + i + " ret:" + k, "" + this.x.f);
      if (k != 180) {
        return k;
      }
      if (i >= 1) {
        return k;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.aa
 * JD-Core Version:    0.7.0.1
 */