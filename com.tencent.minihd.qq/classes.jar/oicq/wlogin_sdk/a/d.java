package oicq.wlogin_sdk.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class d
  extends c
{
  public d()
  {
    this.b = 6;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, boolean paramBoolean, byte[] paramArrayOfByte7, long paramLong, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, int paramInt2, byte[] paramArrayOfByte10, Map<Integer, RegTLV> paramMap)
  {
    byte[] arrayOfByte1 = paramArrayOfByte6;
    if (paramArrayOfByte6 == null) {
      arrayOfByte1 = new byte[0];
    }
    paramArrayOfByte6 = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte6 = new byte[0];
    }
    byte[] arrayOfByte2 = paramArrayOfByte7;
    if (paramArrayOfByte7 == null) {
      arrayOfByte2 = new byte[0];
    }
    paramArrayOfByte7 = paramArrayOfByte10;
    if (paramArrayOfByte10 == null) {
      paramArrayOfByte7 = new byte[0];
    }
    StringBuilder localStringBuilder = new StringBuilder("reg_request_get_account");
    ArrayList localArrayList;
    int n;
    if (paramBoolean)
    {
      paramArrayOfByte10 = new int[14];
      byte[] tmp80_78 = paramArrayOfByte10;
      tmp80_78[0] = 1;
      byte[] tmp84_80 = tmp80_78;
      tmp84_80[1] = 5;
      byte[] tmp88_84 = tmp84_80;
      tmp88_84[2] = 6;
      byte[] tmp93_88 = tmp88_84;
      tmp93_88[3] = 8;
      byte[] tmp98_93 = tmp93_88;
      tmp98_93[4] = 15;
      byte[] tmp103_98 = tmp98_93;
      tmp103_98[5] = 37;
      byte[] tmp108_103 = tmp103_98;
      tmp108_103[6] = 9;
      byte[] tmp114_108 = tmp108_103;
      tmp114_108[7] = 10;
      byte[] tmp120_114 = tmp114_108;
      tmp120_114[8] = 11;
      byte[] tmp126_120 = tmp120_114;
      tmp126_120[9] = 13;
      byte[] tmp132_126 = tmp126_120;
      tmp132_126[10] = 14;
      byte[] tmp138_132 = tmp132_126;
      tmp138_132[11] = 18;
      byte[] tmp144_138 = tmp138_132;
      tmp144_138[12] = 56;
      byte[] tmp150_144 = tmp144_138;
      tmp150_144[13] = 544;
      tmp150_144;
      localArrayList = new ArrayList();
      int i1 = paramArrayOfByte10.length;
      j = 0;
      i = 0;
      n = 0;
      label181:
      if (n >= i1) {
        break label976;
      }
      paramArrayOfByte4 = new byte[0];
      switch (paramArrayOfByte10[n])
      {
      }
    }
    for (;;)
    {
      int k = i;
      int m = j;
      if (paramArrayOfByte4.length >= 2)
      {
        m = j + 1;
        k = i + paramArrayOfByte4.length;
        localArrayList.add(paramArrayOfByte4);
      }
      n += 1;
      j = m;
      i = k;
      break label181;
      paramArrayOfByte10 = new int[12];
      byte[] tmp382_380 = paramArrayOfByte10;
      tmp382_380[0] = 1;
      byte[] tmp386_382 = tmp382_380;
      tmp386_382[1] = 5;
      byte[] tmp390_386 = tmp386_382;
      tmp390_386[2] = 6;
      byte[] tmp395_390 = tmp390_386;
      tmp395_390[3] = 8;
      byte[] tmp400_395 = tmp395_390;
      tmp400_395[4] = 15;
      byte[] tmp405_400 = tmp400_395;
      tmp405_400[5] = 37;
      byte[] tmp410_405 = tmp405_400;
      tmp410_405[6] = 10;
      byte[] tmp416_410 = tmp410_405;
      tmp416_410[7] = 13;
      byte[] tmp422_416 = tmp416_410;
      tmp422_416[8] = 14;
      byte[] tmp428_422 = tmp422_416;
      tmp428_422[9] = 18;
      byte[] tmp434_428 = tmp428_422;
      tmp434_428[10] = 56;
      byte[] tmp440_434 = tmp434_428;
      tmp440_434[11] = 544;
      tmp440_434;
      break;
      paramArrayOfByte4 = new RegTLV(1);
      paramArrayOfByte4.setData(paramArrayOfByte5, paramArrayOfByte5.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(5);
      paramArrayOfByte4.setData(arrayOfByte1, arrayOfByte1.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(6);
      paramArrayOfByte4.setData(paramArrayOfByte6, paramArrayOfByte6.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(8);
      paramArrayOfByte4.setByte((byte)1);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(15);
      paramArrayOfByte4.setInt(paramInt2);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(37);
      paramArrayOfByte4.setShort(u.aA);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(9);
      paramArrayOfByte4.setByte((byte)1);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(10);
      paramArrayOfByte4.setData(arrayOfByte2, arrayOfByte2.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(11);
      paramArrayOfByte4.setData(paramArrayOfByte3, paramArrayOfByte3.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(13);
      paramArrayOfByte4.setInt((int)paramLong);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(14);
      paramArrayOfByte4.setData(paramArrayOfByte8, paramArrayOfByte8.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(18);
      paramArrayOfByte4.setData(paramArrayOfByte9, paramArrayOfByte9.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(56);
      paramArrayOfByte4.setData(paramArrayOfByte7, paramArrayOfByte7.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = MD5.toMD5Byte(paramArrayOfByte1);
      byte[] arrayOfByte3 = MD5.toMD5Byte(paramArrayOfByte3);
      byte[] arrayOfByte4 = new byte[paramArrayOfByte4.length + paramArrayOfByte5.length + arrayOfByte3.length + 6];
      util.int16_to_buf(arrayOfByte4, 0, paramArrayOfByte4.length);
      System.arraycopy(paramArrayOfByte4, 0, arrayOfByte4, 0, paramArrayOfByte4.length);
      k = paramArrayOfByte4.length + 2;
      util.int16_to_buf(arrayOfByte4, k, paramArrayOfByte5.length);
      k += 2;
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte4, k, paramArrayOfByte5.length);
      k += paramArrayOfByte5.length;
      util.int16_to_buf(arrayOfByte4, k, arrayOfByte3.length);
      System.arraycopy(arrayOfByte3, 0, arrayOfByte4, k + 2, arrayOfByte3.length);
      paramArrayOfByte4 = new tlv_t544().get_tlv_544("", "812_6", arrayOfByte4);
    }
    label976:
    paramArrayOfByte4 = paramMap.keySet().iterator();
    while (paramArrayOfByte4.hasNext())
    {
      paramArrayOfByte5 = (Integer)paramArrayOfByte4.next();
      paramArrayOfByte6 = ((RegTLV)paramMap.get(paramArrayOfByte5)).getBuf();
      localArrayList.add(paramArrayOfByte6);
      i += paramArrayOfByte6.length;
      localStringBuilder.append(",key=").append(paramArrayOfByte5).append(",value=").append(paramArrayOfByte6.length);
    }
    int j = localArrayList.size();
    paramArrayOfByte4 = new byte[i + 2];
    util.int16_to_buf(paramArrayOfByte4, 0, (byte)j);
    localStringBuilder.append(",tlv cnt=").append(j);
    util.LOGI(localStringBuilder.toString(), "");
    int i = 2;
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      paramArrayOfByte5 = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte4, i, paramArrayOfByte5.length);
      i += paramArrayOfByte5.length;
      paramInt2 += 1;
    }
    paramArrayOfByte5 = new ByteArrayOutputStream();
    paramArrayOfByte6 = new DataOutputStream(paramArrayOfByte5);
    try
    {
      paramArrayOfByte6.writeByte(paramArrayOfByte1.length);
      paramArrayOfByte6.write(paramArrayOfByte1);
      paramArrayOfByte6.writeByte(paramArrayOfByte3.length);
      paramArrayOfByte6.write(paramArrayOfByte3);
      paramArrayOfByte6.writeByte(paramInt1);
      paramArrayOfByte6.write(paramArrayOfByte4);
      paramArrayOfByte3 = paramArrayOfByte5.toByteArray();
      if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0)) {
        util.LOGI("msgchk is null or length is 0", "");
      }
      for (paramArrayOfByte2 = k.a.getBytes();; paramArrayOfByte2 = MD5.toMD5Byte(paramArrayOfByte2))
      {
        paramArrayOfByte2 = cryptor.encrypt(paramArrayOfByte3, 0, paramArrayOfByte3.length, paramArrayOfByte2);
        this.d = (paramArrayOfByte1.length + 1 + 2 + paramArrayOfByte2.length);
        paramArrayOfByte3 = new byte[this.d];
        util.int8_to_buf(paramArrayOfByte3, 0, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 1, paramArrayOfByte1.length);
        paramInt1 = paramArrayOfByte1.length + 1;
        util.int16_to_buf(paramArrayOfByte3, paramInt1, paramArrayOfByte2.length);
        paramInt1 += 2;
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt1, paramArrayOfByte2.length);
        paramInt1 = paramArrayOfByte2.length;
        util.LOGI("encryptedContent length " + paramArrayOfByte2.length, "");
        return a(paramArrayOfByte3);
        util.LOGI("msgchk is " + util.buf_to_string(paramArrayOfByte2, paramArrayOfByte2.length), "");
      }
      return null;
    }
    catch (Exception paramArrayOfByte1)
    {
      util.LOGI("get account failed " + paramArrayOfByte1.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.d
 * JD-Core Version:    0.7.0.1
 */