package com.tencent.mm.plugin.fav.ui.d;

import com.tencent.mm.plugin.fav.a.g;
import java.util.Map;

public final class a$a
{
  public String drv;
  public boolean idd;
  public boolean keG;
  public Map<Long, g> keH;
  public boolean keO;
  public a.c kiq;
  public long lastUpdateTime;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
    localStringBuilder.append("isSearching:").append(this.idd).append('\n');
    localStringBuilder.append("search str:").append(this.drv).append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a.a
 * JD-Core Version:    0.7.0.1
 */