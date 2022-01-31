package com.qq.taf;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class RequestPacket
  extends JceStruct
{
  static Map<String, String> cache_context;
  static byte[] cache_sBuffer;
  public byte cPacketType = 0;
  public Map<String, String> context;
  public int iMessageType = 0;
  public int iRequestId = 0;
  public int iTimeout = 0;
  public short iVersion = 0;
  public byte[] sBuffer;
  public String sFuncName = null;
  public String sServantName = null;
  public Map<String, String> status;
  
  static
  {
    AppMethodBeat.i(117036);
    if (!RequestPacket.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_sBuffer = null;
      cache_context = null;
      AppMethodBeat.o(117036);
      return;
    }
  }
  
  public RequestPacket() {}
  
  public RequestPacket(short paramShort, byte paramByte, int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt3, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    this.iVersion = paramShort;
    this.cPacketType = paramByte;
    this.iMessageType = paramInt1;
    this.iRequestId = paramInt2;
    this.sServantName = paramString1;
    this.sFuncName = paramString2;
    this.sBuffer = paramArrayOfByte;
    this.iTimeout = paramInt3;
    this.context = paramMap1;
    this.status = paramMap2;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(117038);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(117038);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(117038);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(117041);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.iVersion, "iVersion");
    paramStringBuilder.display(this.cPacketType, "cPacketType");
    paramStringBuilder.display(this.iMessageType, "iMessageType");
    paramStringBuilder.display(this.iRequestId, "iRequestId");
    paramStringBuilder.display(this.sServantName, "sServantName");
    paramStringBuilder.display(this.sFuncName, "sFuncName");
    paramStringBuilder.display(this.sBuffer, "sBuffer");
    paramStringBuilder.display(this.iTimeout, "iTimeout");
    paramStringBuilder.display(this.context, "context");
    paramStringBuilder.display(this.status, "status");
    AppMethodBeat.o(117041);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(117037);
    paramObject = (RequestPacket)paramObject;
    if ((JceUtil.equals(1, paramObject.iVersion)) && (JceUtil.equals(1, paramObject.cPacketType)) && (JceUtil.equals(1, paramObject.iMessageType)) && (JceUtil.equals(1, paramObject.iRequestId)) && (JceUtil.equals(Integer.valueOf(1), paramObject.sServantName)) && (JceUtil.equals(Integer.valueOf(1), paramObject.sFuncName)) && (JceUtil.equals(Integer.valueOf(1), paramObject.sBuffer)) && (JceUtil.equals(1, paramObject.iTimeout)) && (JceUtil.equals(Integer.valueOf(1), paramObject.context)) && (JceUtil.equals(Integer.valueOf(1), paramObject.status)))
    {
      AppMethodBeat.o(117037);
      return true;
    }
    AppMethodBeat.o(117037);
    return false;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(117040);
    try
    {
      this.iVersion = paramJceInputStream.read(this.iVersion, 1, true);
      this.cPacketType = paramJceInputStream.read(this.cPacketType, 2, true);
      this.iMessageType = paramJceInputStream.read(this.iMessageType, 3, true);
      this.iRequestId = paramJceInputStream.read(this.iRequestId, 4, true);
      this.sServantName = paramJceInputStream.readString(5, true);
      this.sFuncName = paramJceInputStream.readString(6, true);
      if (cache_sBuffer == null) {
        cache_sBuffer = new byte[1];
      }
      this.sBuffer = paramJceInputStream.read(cache_sBuffer, 7, true);
      this.iTimeout = paramJceInputStream.read(this.iTimeout, 8, true);
      HashMap localHashMap;
      if (cache_context == null)
      {
        localHashMap = new HashMap();
        cache_context = localHashMap;
        localHashMap.put("", "");
      }
      this.context = ((Map)paramJceInputStream.read(cache_context, 9, true));
      if (cache_context == null)
      {
        localHashMap = new HashMap();
        cache_context = localHashMap;
        localHashMap.put("", "");
      }
      this.status = ((Map)paramJceInputStream.read(cache_context, 10, true));
      AppMethodBeat.o(117040);
      return;
    }
    catch (Exception paramJceInputStream)
    {
      paramJceInputStream = new RuntimeException(paramJceInputStream);
      AppMethodBeat.o(117040);
      throw paramJceInputStream;
    }
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(117039);
    paramJceOutputStream.write(this.iVersion, 1);
    paramJceOutputStream.write(this.cPacketType, 2);
    paramJceOutputStream.write(this.iMessageType, 3);
    paramJceOutputStream.write(this.iRequestId, 4);
    paramJceOutputStream.write(this.sServantName, 5);
    paramJceOutputStream.write(this.sFuncName, 6);
    paramJceOutputStream.write(this.sBuffer, 7);
    paramJceOutputStream.write(this.iTimeout, 8);
    paramJceOutputStream.write(this.context, 9);
    paramJceOutputStream.write(this.status, 10);
    AppMethodBeat.o(117039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.taf.RequestPacket
 * JD-Core Version:    0.7.0.1
 */