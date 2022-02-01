package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t178;
import oicq.wlogin_sdk.tlv_type.tlv_t179;
import oicq.wlogin_sdk.tlv_type.tlv_t17d;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.util;

public class v
  extends oicq_request
{
  public v(u paramu)
  {
    this.t = 2064;
    this.u = 23;
    this.v = "wtlogin.login";
    this.x = paramu;
    this.x.m = 0;
  }
  
  public int a(WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramWUserSigInfo.extraLoginTLVMap);
      a(this.x.f, arrayOfByte, this.y);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      util.LOGI("quickLoginByGateway.request_login_by_gateway,retry num:" + i + ",ret:" + j, "" + this.x.f);
      if (j != 180) {
        return j;
      }
      if (i >= 1) {
        return j;
      }
      i += 1;
    }
  }
  
  public byte[] a(Map<Integer, tlv_t> paramMap)
  {
    int i = 0;
    Object localObject2 = new int[7];
    Object tmp10_8 = localObject2;
    tmp10_8[0] = 256;
    Object tmp16_10 = tmp10_8;
    tmp16_10[1] = 322;
    Object tmp22_16 = tmp16_10;
    tmp22_16[2] = 325;
    Object tmp28_22 = tmp22_16;
    tmp28_22[3] = 387;
    Object tmp34_28 = tmp28_22;
    tmp34_28[4] = 388;
    Object tmp40_34 = tmp34_28;
    tmp40_34[5] = 1331;
    Object tmp46_40 = tmp40_34;
    tmp46_40[6] = 1313;
    tmp46_40;
    ArrayList localArrayList = new ArrayList();
    int m = localObject2.length;
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder("quickLoginByGateway.request_login_by_gateway").append(" getRequestBody");
    Object localObject3 = u.b(this.x.h);
    int k = 0;
    Object localObject1;
    if (k < m)
    {
      localObject1 = new byte[0];
      switch (localObject2[k])
      {
      default: 
        label176:
        if (localObject1.length > 4)
        {
          int n = localObject1.length;
          localArrayList.add(localObject1);
          j = n + j;
          i += 1;
        }
        break;
      }
    }
    for (;;)
    {
      k += 1;
      break;
      localObject1 = new tlv_t100().get_tlv_100(((async_context)localObject3)._appid, ((async_context)localObject3)._sub_appid, 0, ((async_context)localObject3)._main_sigmap);
      localStringBuilder.append(",appid=").append(((async_context)localObject3)._appid).append(",subAppid=").append(((async_context)localObject3)._sub_appid);
      break label176;
      localObject1 = new tlv_t142().get_tlv_142(u.F);
      localStringBuilder.append(",apk_id=").append(new String(u.F));
      break label176;
      localObject1 = new tlv_t145().get_tlv_145(u.B);
      localStringBuilder.append(",guid=").append(new String(u.B));
      break label176;
      localObject1 = new tlv_t183().get_tlv_183(((async_context)localObject3)._msalt);
      localStringBuilder.append(",_msalt=").append(((async_context)localObject3)._msalt);
      break label176;
      Object localObject4 = new tlv_t184();
      localObject1 = ((tlv_t184)localObject4).get_tlv_184(((async_context)localObject3)._msalt, ((async_context)localObject3)._mpasswd);
      localStringBuilder.append(",_mS2=").append(((tlv_t184)localObject4).get_data_len());
      break label176;
      localObject1 = new tlv_t(1313);
      localObject4 = new byte[6];
      util.int32_to_buf((byte[])localObject4, 0, u.aA);
      util.int16_to_buf((byte[])localObject4, 4, 0);
      ((tlv_t)localObject1).set_data((byte[])localObject4, 6);
      localObject1 = ((tlv_t)localObject1).get_buf();
      localStringBuilder.append(",_productType=").append(u.aA);
      break label176;
      m = j;
      k = i;
      if (paramMap != null)
      {
        localObject1 = paramMap.keySet().iterator();
        for (;;)
        {
          m = j;
          k = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Integer)((Iterator)localObject1).next();
          localObject3 = (tlv_t)paramMap.get(localObject2);
          if (localObject3 != null)
          {
            localObject3 = ((tlv_t)localObject3).get_buf();
            i += 1;
            localArrayList.add(localObject3);
            j += localObject3.length;
            localStringBuilder.append(",key=").append(localObject2).append(",Buff=").append(localObject3.length);
          }
        }
      }
      paramMap = new byte[m];
      j = 0;
      i = 0;
      while (i < k)
      {
        localObject1 = (byte[])localArrayList.get(i);
        System.arraycopy(localObject1, 0, paramMap, j, localObject1.length);
        j += localObject1.length;
        i += 1;
      }
      localStringBuilder.append(",tlvCnt=").append(k);
      util.LOGI(localStringBuilder.toString(), "");
      return b(paramMap, this.u, k);
    }
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 5) {
      return -1009;
    }
    async_context localasync_context = u.b(this.x.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    int i = paramInt1 + 5;
    Object localObject1 = new tlv_t543();
    paramInt1 = ((tlv_t543)localObject1).get_tlv(paramArrayOfByte, i, this.c - i);
    localasync_context._t543 = ((tlv_t543)localObject1);
    localObject1 = new StringBuilder("quickLoginByGateway.request_login_by_gateway");
    ((StringBuilder)localObject1).append(",get_response_body ret=").append(paramInt2).append(",ret543=").append(paramInt1);
    Object localObject2;
    if (paramInt2 == 0)
    {
      localObject2 = new tlv_t113();
      paramInt1 = ((tlv_t113)localObject2).get_tlv(paramArrayOfByte, i, this.c - i - 1);
      ((StringBuilder)localObject1).append(",ret113=").append(paramInt1);
      if (paramInt1 >= 0)
      {
        this.x.f = ((tlv_t113)localObject2).get_uin();
        localasync_context._uin = this.x.f;
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      localObject2 = new tlv_t104();
      paramInt2 = ((tlv_t104)localObject2).get_tlv(paramArrayOfByte, i, this.c - i);
      ((StringBuilder)localObject1).append(",ret104=").append(paramInt2);
      if (paramInt2 >= 0) {
        localasync_context._t104 = ((tlv_t104)localObject2);
      }
      a(paramArrayOfByte, i, new tlv_t178(), new tlv_t179(), new tlv_t17d(), localasync_context);
      util.LOGI(((StringBuilder)localObject1).toString(), "");
      return paramInt1;
      paramInt1 = -2004;
      continue;
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.v
 * JD-Core Version:    0.7.0.1
 */