package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BindCardContext
{
  public String mBindCardUuid;
  public String mDeviceName;
  public String mDeviceType;
  
  public BindCardContext() {}
  
  public BindCardContext(String paramString1, String paramString2, String paramString3)
  {
    this.mBindCardUuid = paramString1;
    this.mDeviceName = paramString2;
    this.mDeviceType = paramString3;
  }
  
  public final String getBindCardUuid()
  {
    return this.mBindCardUuid;
  }
  
  public final String getDeviceName()
  {
    return this.mDeviceName;
  }
  
  public final String getDeviceType()
  {
    return this.mDeviceType;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135651);
    String str = "BindCardContext{mBindCardUuid=" + this.mBindCardUuid + ",mDeviceName=" + this.mDeviceName + ",mDeviceType=" + this.mDeviceType + "}";
    AppMethodBeat.o(135651);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.BindCardContext
 * JD-Core Version:    0.7.0.1
 */