package com.tencent.map.sdk.comps.offlinemap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OfflineItem
{
  private String name;
  private int percentage;
  private String pinyin;
  private long size;
  private boolean upgrade = true;
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193502);
    if (this == paramObject)
    {
      AppMethodBeat.o(193502);
      return true;
    }
    if (!(paramObject instanceof OfflineItem))
    {
      AppMethodBeat.o(193502);
      return false;
    }
    paramObject = (OfflineItem)paramObject;
    if (this.name != null)
    {
      if (this.name.equals(paramObject.name)) {}
    }
    else {
      while (paramObject.name != null)
      {
        AppMethodBeat.o(193502);
        return false;
      }
    }
    if (this.pinyin != null)
    {
      boolean bool = this.pinyin.equals(paramObject.pinyin);
      AppMethodBeat.o(193502);
      return bool;
    }
    if (paramObject.pinyin == null)
    {
      AppMethodBeat.o(193502);
      return true;
    }
    AppMethodBeat.o(193502);
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPercentage()
  {
    return this.percentage;
  }
  
  public String getPinyin()
  {
    return this.pinyin;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(193503);
    if (this.name != null) {}
    for (int i = this.name.hashCode();; i = 0)
    {
      if (this.pinyin != null) {
        j = this.pinyin.hashCode();
      }
      AppMethodBeat.o(193503);
      return i * 31 + j;
    }
  }
  
  public boolean isUpgrade()
  {
    return this.upgrade;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPercentage(int paramInt)
  {
    this.percentage = paramInt;
  }
  
  public void setPinyin(String paramString)
  {
    this.pinyin = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void setUpgrade(boolean paramBoolean)
  {
    this.upgrade = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(193504);
    Object localObject = new StringBuffer("OfflineItem{");
    ((StringBuffer)localObject).append("name='").append(this.name).append('\'');
    ((StringBuffer)localObject).append(", pinyin='").append(this.pinyin).append('\'');
    ((StringBuffer)localObject).append(", size=").append(this.size);
    ((StringBuffer)localObject).append(", upgrade=").append(this.upgrade);
    ((StringBuffer)localObject).append(", percentage=").append(this.percentage);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193504);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.comps.offlinemap.OfflineItem
 * JD-Core Version:    0.7.0.1
 */