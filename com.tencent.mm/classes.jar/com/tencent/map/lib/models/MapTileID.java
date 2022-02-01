package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class MapTileID
{
  private int dataSource;
  private int priority;
  private int tileTag;
  private String url;
  private int x;
  private int y;
  private int z;
  
  public DataSource getDataSource()
  {
    AppMethodBeat.i(180748);
    DataSource localDataSource = DataSource.get(this.dataSource);
    AppMethodBeat.o(180748);
    return localDataSource;
  }
  
  public DownloadPriority getPriority()
  {
    AppMethodBeat.i(180747);
    DownloadPriority localDownloadPriority = DownloadPriority.get(this.priority);
    AppMethodBeat.o(180747);
    return localDownloadPriority;
  }
  
  public int getTileTag()
  {
    return this.tileTag;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public int getZ()
  {
    return this.z;
  }
  
  public String toString()
  {
    AppMethodBeat.i(180749);
    String str = "MapTileID{x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", url='" + this.url + '\'' + ", priority=" + this.priority + ", dataSource=" + this.dataSource + ", tileTag=" + this.tileTag + '}';
    AppMethodBeat.o(180749);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.lib.models.MapTileID
 * JD-Core Version:    0.7.0.1
 */