package com.tencent.av.gaudio;

import com.tencent.qav.log.AVLog;
import java.util.ArrayList;

public class AVInviteAccount
{
  private static final int SIZE = 48;
  private static final String TAG = "AVInviteAccount";
  public int inviteType;
  public TelInfo msg_tel_info = new TelInfo();
  public int result;
  public int uint32_account_type;
  public long uint64_account;
  
  private static int getIntFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i + paramInt)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  public static ArrayList<AVInviteAccount> getListFromBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = null;
    if (paramArrayOfByte == null)
    {
      AVLog.e("AVInviteAccount", "getListFromBuffer detail is null");
      return localObject;
    }
    if (paramInt == 0)
    {
      AVLog.e("AVInviteAccount", "getListFromBuffer buflen == 0");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramInt / 48;
    paramInt = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i) {
        break;
      }
      localObject = new AVInviteAccount();
      ((AVInviteAccount)localObject).uint32_account_type = getIntFromByte(paramArrayOfByte, paramInt * 48);
      ((AVInviteAccount)localObject).uint64_account = getLongFromByte(paramArrayOfByte, paramInt * 48 + 8);
      try
      {
        ((AVInviteAccount)localObject).msg_tel_info.bytes_nation = new String(paramArrayOfByte, paramInt * 48 + 16, 5, "UTF-8");
        ((AVInviteAccount)localObject).msg_tel_info.bytes_prefix = new String(paramArrayOfByte, paramInt * 48 + 21, 5, "UTF-8");
        ((AVInviteAccount)localObject).msg_tel_info.bytes_mobile = new String(paramArrayOfByte, paramInt * 48 + 26, 12, "UTF-8");
        ((AVInviteAccount)localObject).result = getIntFromByte(paramArrayOfByte, paramInt * 48 + 40);
        ((AVInviteAccount)localObject).inviteType = getIntFromByte(paramArrayOfByte, paramInt * 48 + 44);
        localArrayList.add(localObject);
        paramInt += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private static long getLongFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i + paramInt)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVInviteAccount
 * JD-Core Version:    0.7.0.1
 */