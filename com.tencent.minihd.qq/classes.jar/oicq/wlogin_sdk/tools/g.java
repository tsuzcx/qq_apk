package oicq.wlogin_sdk.tools;

import java.util.Map;
import oicq.wlogin_sdk.tlv_type.tlv_t;

public class g
{
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Map<Integer, tlv_t> paramMap)
  {
    int k = 0;
    if (paramArrayOfByte.length != paramInt2 + paramInt3)
    {
      j = -1;
      return j;
    }
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    for (;;)
    {
      j = k;
      if (paramInt2 >= paramInt1) {
        break;
      }
      j = k;
      if (paramInt3 <= 0) {
        break;
      }
      j = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      int m = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      paramInt3 = paramInt3 - 2 - 2;
      if (paramInt3 < m) {
        return -2;
      }
      tlv_t localtlv_t = new tlv_t(j);
      localtlv_t.set_data(paramArrayOfByte, i, m);
      paramMap.put(new Integer(j), localtlv_t);
      i += m;
      paramInt3 -= m;
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.g
 * JD-Core Version:    0.7.0.1
 */