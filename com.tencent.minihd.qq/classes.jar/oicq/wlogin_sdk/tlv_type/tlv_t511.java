package oicq.wlogin_sdk.tlv_type;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tlv_t511
  extends tlv_t
{
  public tlv_t511()
  {
    this._cmd = 1297;
  }
  
  public byte[] get_tlv_511(List<String> paramList)
  {
    Object localObject2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (String)paramList.next();
      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
        ((List)localObject2).add(localObject1);
      }
    }
    Object localObject1 = ByteBuffer.allocate(1024);
    ((ByteBuffer)localObject1).putShort((short)((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    int i;
    int k;
    int j;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        paramList = (String)((Iterator)localObject2).next();
        if ((paramList != null) && (paramList.length() != 0))
        {
          i = paramList.indexOf('(');
          k = paramList.indexOf(')');
          if ((i == 0) && (k > 0))
          {
            j = Integer.valueOf(paramList.substring(i + 1, k)).intValue();
            if ((0x100000 & j) > 0)
            {
              i = 1;
              label180:
              if ((j & 0x8000000) <= 0) {
                break label257;
              }
              j = 1;
              label191:
              if (i == 0) {
                break label299;
              }
            }
          }
        }
      }
    }
    label257:
    label299:
    for (byte b1 = (byte)1;; b1 = 0)
    {
      byte b2 = b1;
      if (j != 0) {
        b2 = (byte)(b1 | 0x2);
      }
      paramList = paramList.substring(k + 1);
      for (;;)
      {
        ((ByteBuffer)localObject1).put(b2);
        ((ByteBuffer)localObject1).putShort((short)paramList.length());
        ((ByteBuffer)localObject1).put(paramList.getBytes());
        break;
        i = 0;
        break label180;
        j = 0;
        break label191;
        b2 = 1;
      }
      fill_head(this._cmd);
      fill_body(((ByteBuffer)localObject1).array(), ((ByteBuffer)localObject1).position());
      set_length();
      return get_buf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t511
 * JD-Core Version:    0.7.0.1
 */