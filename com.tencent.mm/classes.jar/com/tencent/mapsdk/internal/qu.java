package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class qu
  implements TrafficEvent
{
  private static final String a = "yyyy/MM/dd HH时";
  private static final String[] c = { "交通事故", "交通管制", "道路施工", "路上障碍物", "活动", "恶劣天气", "灾害", "拥堵", "检查", "一般事故", "积水", "其他事件" };
  private static final String[] d = { "发生", "出现", "有", "有", "有", "出现", "有", "出现", "有", "发生", "有", "有" };
  private Detail b;
  
  public qu(Detail paramDetail)
  {
    this.b = paramDetail;
  }
  
  private Detail a()
  {
    return this.b;
  }
  
  public final String getDescription()
  {
    AppMethodBeat.i(226235);
    if (this.b.basic.type > c.length) {}
    for (String str = d[(c.length - 1)];; str = d[(this.b.basic.type - 1)])
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH时", Locale.US);
      str = localSimpleDateFormat.format(new Date(this.b.basic.start_time * 1000L)) + " - " + localSimpleDateFormat.format(new Date(this.b.basic.end_time * 1000L)) + 65292 + getRoadName() + str + getType();
      AppMethodBeat.o(226235);
      return str;
    }
  }
  
  public final int getEndTime()
  {
    return this.b.basic.end_time;
  }
  
  public final String getMessage()
  {
    return this.b.basic.message;
  }
  
  public final String getRoadName()
  {
    return this.b.basic.roadname;
  }
  
  public final String getSource()
  {
    return this.b.basic.source;
  }
  
  public final int getStartTime()
  {
    return this.b.basic.start_time;
  }
  
  public final String getType()
  {
    if (this.b.basic.type > c.length)
    {
      String[] arrayOfString = c;
      return arrayOfString[(arrayOfString.length - 1)];
    }
    return c[(this.b.basic.type - 1)];
  }
  
  public final int getUpdateTime()
  {
    return this.b.basic.update_time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qu
 * JD-Core Version:    0.7.0.1
 */