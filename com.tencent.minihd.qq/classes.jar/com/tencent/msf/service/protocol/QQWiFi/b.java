package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
  implements Cloneable
{
  static ArrayList d;
  public int a = 0;
  public ArrayList b = null;
  public int c = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    if (d == null)
    {
      d = new ArrayList();
      WiFiService localWiFiService = new WiFiService();
      d.add(localWiFiService);
    }
    this.b = ((ArrayList)paramJceInputStream.read(d, 1, false));
    this.c = paramJceInputStream.read(this.c, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    paramJceOutputStream.write(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.QQWiFi.b
 * JD-Core Version:    0.7.0.1
 */