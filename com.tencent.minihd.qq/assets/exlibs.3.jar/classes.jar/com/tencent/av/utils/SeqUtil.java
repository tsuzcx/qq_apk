package com.tencent.av.utils;

import android.content.Intent;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public abstract class SeqUtil
{
  public static final String a = "seq";
  
  public static long a(Intent paramIntent)
  {
    return paramIntent.getLongExtra("seq", 0L);
  }
  
  public static long a(ToServiceMsg paramToServiceMsg)
  {
    return a(paramToServiceMsg.getAttribute("seq"));
  }
  
  public static long a(Object paramObject)
  {
    long l = 0L;
    if ((paramObject instanceof Long)) {
      l = ((Long)paramObject).longValue();
    }
    return l;
  }
  
  public static long a(HashMap paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("seq"))) {
      return a(paramHashMap.get("seq"));
    }
    return 0L;
  }
  
  public static long a(Object[] paramArrayOfObject, int paramInt)
  {
    long l = 0L;
    if (paramArrayOfObject.length > paramInt) {
      l = a(paramArrayOfObject[paramInt]);
    }
    return l;
  }
  
  public static void a(Intent paramIntent, long paramLong)
  {
    paramIntent.putExtra("seq", paramLong);
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    paramToServiceMsg.addAttribute("seq", Long.valueOf(paramLong));
  }
  
  public static void a(HashMap paramHashMap, long paramLong)
  {
    paramHashMap.put("seq", Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.SeqUtil
 * JD-Core Version:    0.7.0.1
 */