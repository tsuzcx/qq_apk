package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> JUk;
  public int JTj = 0;
  public long JUh = 0L;
  public ArrayList<g> JUi = null;
  public double JUj = 0.0D;
  public int action = 0;
  public double lat = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138424);
    this.JUh = paramJceInputStream.read(this.JUh, 0, true);
    if (JUk == null)
    {
      JUk = new ArrayList();
      g localg = new g();
      JUk.add(localg);
    }
    this.JUi = ((ArrayList)paramJceInputStream.read(JUk, 1, true));
    this.JTj = paramJceInputStream.read(this.JTj, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.JUj = paramJceInputStream.read(this.JUj, 5, false);
    AppMethodBeat.o(138424);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138423);
    paramJceOutputStream.write(this.JUh, 0);
    paramJceOutputStream.write(this.JUi, 1);
    if (this.JTj != 0) {
      paramJceOutputStream.write(this.JTj, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.JUj != 0.0D) {
      paramJceOutputStream.write(this.JUj, 5);
    }
    AppMethodBeat.o(138423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */