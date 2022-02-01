package oicq.wlogin_sdk.request;

import java.io.Serializable;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class WloginAllSigInfo
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  public TreeMap<Long, WloginSigInfo> _tk_map = new TreeMap();
  public long _uin = 0L;
  public WloginSimpleInfo _useInfo = new WloginSimpleInfo();
  public int mainSigMap;
  
  /* Error */
  public WloginAllSigInfo get_clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 45	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 34	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   16: ifnull +79 -> 95
    //   19: aload_0
    //   20: getfield 34	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   23: invokevirtual 49	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   26: invokeinterface 55 1 0
    //   31: astore 5
    //   33: aload 4
    //   35: astore_3
    //   36: aload 5
    //   38: invokeinterface 61 1 0
    //   43: ifeq +52 -> 95
    //   46: aload 5
    //   48: invokeinterface 64 1 0
    //   53: checkcast 66	java/lang/Long
    //   56: invokevirtual 70	java/lang/Long:longValue	()J
    //   59: lstore_1
    //   60: aload_0
    //   61: getfield 34	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   64: lload_1
    //   65: invokestatic 74	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: invokevirtual 78	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 80	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull -43 -> 33
    //   79: aload_3
    //   80: aconst_null
    //   81: putfield 84	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheTickets	Ljava/util/List;
    //   84: aload_3
    //   85: lconst_0
    //   86: putfield 87	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheUpdateStamp	J
    //   89: goto -56 -> 33
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_3
    //   95: aload_3
    //   96: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	WloginAllSigInfo
    //   59	6	1	l	long
    //   11	74	3	localObject	Object
    //   92	1	3	localException	java.lang.Exception
    //   94	2	3	localWloginAllSigInfo1	WloginAllSigInfo
    //   7	27	4	localWloginAllSigInfo2	WloginAllSigInfo
    //   31	16	5	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   0	9	92	java/lang/Exception
    //   12	33	92	java/lang/Exception
    //   36	75	92	java/lang/Exception
    //   79	89	92	java/lang/Exception
  }
  
  public void putNewST(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong), localWloginSigInfo.setNetST(paramArrayOfByte1, paramArrayOfByte2));
    }
  }
  
  public int put_da2(long paramLong, byte[] paramArrayOfByte)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong), localWloginSigInfo.setDA2(paramArrayOfByte));
    }
    return 0;
  }
  
  public int put_randseed(long paramLong, byte[] paramArrayOfByte)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong), localWloginSigInfo.setRandSeed(paramArrayOfByte));
    }
    return 0;
  }
  
  public int put_siginfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong1));
    if (localWloginSigInfo != null)
    {
      localWloginSigInfo.mainSigMap = this.mainSigMap;
      this._tk_map.put(Long.valueOf(paramLong1), localWloginSigInfo.Set(paramLong2, paramLong3, paramLong4, paramLong5, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte, paramArrayOfLong, paramInt));
    }
    for (;;)
    {
      return 0;
      this._tk_map.put(Long.valueOf(paramLong1), new WloginSigInfo(paramLong2, paramLong3, paramLong4, paramLong5, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte, paramArrayOfLong, paramInt, this.mainSigMap));
    }
  }
  
  public int put_siginfo(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this._tk_map.put(Long.valueOf(paramLong1), new WloginSigInfo(paramLong2, paramLong3, paramArrayOfByte1, paramArrayOfByte2));
    return 0;
  }
  
  public int put_siginfo(long paramLong1, byte[][] paramArrayOfByte, long paramLong2)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong1));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong1), localWloginSigInfo.Set(paramArrayOfByte, paramLong2));
    }
    return 0;
  }
  
  public int put_simpleinfo(WloginSimpleInfo paramWloginSimpleInfo)
  {
    if (this._useInfo == null) {
      this._useInfo = paramWloginSimpleInfo;
    }
    for (;;)
    {
      return 0;
      this._useInfo.set_info(paramWloginSimpleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WloginAllSigInfo
 * JD-Core Version:    0.7.0.1
 */