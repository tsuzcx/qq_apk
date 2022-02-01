package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends JceStruct
{
  static Map<Integer, ArrayList<f>> JUp;
  public int JTT = 0;
  public int JTU = 0;
  public int JTV = 0;
  public int JTW = 0;
  public long JUm = 0L;
  public Map<Integer, ArrayList<f>> JUn = null;
  public int JUo = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138428);
    this.JUm = paramJceInputStream.read(this.JUm, 0, true);
    if (JUp == null)
    {
      JUp = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      JUp.put(Integer.valueOf(0), localArrayList);
    }
    this.JUn = ((Map)paramJceInputStream.read(JUp, 1, true));
    this.JTT = paramJceInputStream.read(this.JTT, 2, false);
    this.JTU = paramJceInputStream.read(this.JTU, 3, false);
    this.JTV = paramJceInputStream.read(this.JTV, 4, false);
    this.JTW = paramJceInputStream.read(this.JTW, 5, false);
    this.JUo = paramJceInputStream.read(this.JUo, 6, false);
    AppMethodBeat.o(138428);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138427);
    paramJceOutputStream.write(this.JUm, 0);
    paramJceOutputStream.write(this.JUn, 1);
    paramJceOutputStream.write(this.JTT, 2);
    paramJceOutputStream.write(this.JTU, 3);
    paramJceOutputStream.write(this.JTV, 4);
    paramJceOutputStream.write(this.JTW, 5);
    if (this.JUo != 0) {
      paramJceOutputStream.write(this.JUo, 6);
    }
    AppMethodBeat.o(138427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */