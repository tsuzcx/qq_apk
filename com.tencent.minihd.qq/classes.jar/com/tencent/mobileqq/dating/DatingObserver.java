package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.List;

public class DatingObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, DatingInfo paramDatingInfo, byte[] paramArrayOfByte, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, List paramList, String paramString) {}
  
  public void a(boolean paramBoolean, DatingConfig paramDatingConfig) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, DatingInfo paramDatingInfo, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString, DatingInfo paramDatingInfo, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, DatingInfo paramDatingInfo, String paramString2, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean1, List paramList1, List paramList2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString, boolean paramBoolean4, boolean paramBoolean5) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt1, int paramInt2, DatingInfo paramDatingInfo) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean, int paramInt, ArrayList paramArrayList, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void b(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3], (byte[])paramObject[4], (String)paramObject[5]);
      return;
    case 2: 
      a(paramBoolean, (DatingConfig)((Object[])(Object[])paramObject)[0]);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (DatingInfo)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 6: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (List)paramObject[2], (String)paramObject[3]);
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (DatingInfo)paramObject[2], (byte[])paramObject[3], (String)paramObject[4]);
      return;
    case 8: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, (String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
      return;
    case 9: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (List)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), (byte[])paramObject[3], (String)paramObject[4], ((Boolean)paramObject[5]).booleanValue(), ((Boolean)paramObject[6]).booleanValue());
      return;
    case 10: 
      a(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
      return;
    case 11: 
      a(paramBoolean);
      return;
    case 12: 
      b();
      return;
    case 13: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (String)paramObject[2]);
      return;
    case 15: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (String)paramObject[2]);
      return;
    case 14: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
      return;
    case 16: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
      return;
    case 17: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (DatingInfo)paramObject[4]);
      return;
    case 18: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (DatingInfo)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue());
      return;
    case 19: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
      return;
    case 20: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (DatingInfo)paramObject[3], (String)paramObject[4]);
      return;
    case 21: 
      a();
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramBoolean)
    {
      a(paramBoolean, (List)paramObject[0], (List)paramObject[1], (ByteStringMicro)paramObject[2], ((Boolean)paramObject[3]).booleanValue());
      return;
    }
    a(paramBoolean, null, null, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingObserver
 * JD-Core Version:    0.7.0.1
 */