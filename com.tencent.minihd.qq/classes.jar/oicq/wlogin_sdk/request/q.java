package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t401;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class q
  extends oicq_request
{
  public q(u paramu)
  {
    this.t = 2064;
    this.u = 20;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = u.x;
    async_context localasync_context = u.b(this.x.h);
    tlv_t104 localtlv_t104 = localasync_context._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      Object localObject2 = localasync_context._t402;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new tlv_t402();
      }
      tlv_t403 localtlv_t403 = localasync_context._t403;
      localObject2 = localtlv_t403;
      if (localtlv_t403 == null) {
        localObject2 = new tlv_t403();
      }
      localasync_context._dpwd = util.get_mpasswd().getBytes();
      localasync_context._G = c(u.B, localasync_context._dpwd, ((tlv_t402)localObject1).get_data());
      if ((((tlv_t402)localObject1).get_data_len() > 0) && (((tlv_t403)localObject2).get_data_len() > 0)) {
        localasync_context._sec_guid_flag = true;
      }
      int i = 0;
      for (;;)
      {
        localObject1 = a(localtlv_t104.get_data(), paramInt1, paramInt2, paramArrayOfLong, localasync_context._G);
        a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, (byte[])localObject1);
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
  
  public byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte2)
  {
    Object localObject1 = new tlv_t8();
    tlv_t104 localtlv_t104 = new tlv_t104();
    tlv_t116 localtlv_t116 = new tlv_t116();
    Object localObject2 = new tlv_t401();
    localObject1 = ((tlv_t8)localObject1).get_tlv_8(0, u.v, 0);
    paramArrayOfByte1 = localtlv_t104.get_tlv_104(paramArrayOfByte1);
    paramArrayOfLong = localtlv_t116.get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
    paramArrayOfByte2 = ((tlv_t401)localObject2).get_tlv_401(paramArrayOfByte2);
    localObject2 = new byte[localObject1.length + paramArrayOfByte1.length + paramArrayOfLong.length + paramArrayOfByte2.length];
    System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
    paramInt1 = localObject1.length + 0;
    System.arraycopy(paramArrayOfByte1, 0, localObject2, paramInt1, paramArrayOfByte1.length);
    paramInt1 += paramArrayOfByte1.length;
    System.arraycopy(paramArrayOfLong, 0, localObject2, paramInt1, paramArrayOfLong.length);
    paramInt1 += paramArrayOfLong.length;
    System.arraycopy(paramArrayOfByte2, 0, localObject2, paramInt1, paramArrayOfByte2.length);
    paramInt1 = paramArrayOfByte2.length;
    return b((byte[])localObject2, this.u, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.q
 * JD-Core Version:    0.7.0.1
 */