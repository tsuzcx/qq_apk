package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends JceStruct
{
  static int Ssu = 0;
  public float Ekw = 0.0F;
  public float Ekx = 0.0F;
  public float Eky = 0.0F;
  public long RNA = 0L;
  public int RNh = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214764);
    this.RNh = paramJceInputStream.read(this.RNh, 0, true);
    this.Ekw = paramJceInputStream.read(this.Ekw, 1, false);
    this.Ekx = paramJceInputStream.read(this.Ekx, 2, false);
    this.Eky = paramJceInputStream.read(this.Eky, 3, false);
    this.RNA = paramJceInputStream.read(this.RNA, 4, false);
    AppMethodBeat.o(214764);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214763);
    paramJceOutputStream.write(this.RNh, 0);
    paramJceOutputStream.write(this.Ekw, 1);
    paramJceOutputStream.write(this.Ekx, 2);
    paramJceOutputStream.write(this.Eky, 3);
    paramJceOutputStream.write(this.RNA, 4);
    AppMethodBeat.o(214763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.g
 * JD-Core Version:    0.7.0.1
 */