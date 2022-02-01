package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gd
  extends a
{
  private String gCm = "";
  private int gCn = 0;
  private int giX = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(211607);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCn);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(211607);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(211609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubType:").append(this.gCm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiType:").append(this.gCn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211609);
    return localObject;
  }
  
  public final int getId()
  {
    return 21770;
  }
  
  public final gd mC(int paramInt)
  {
    this.giX = paramInt;
    return this;
  }
  
  public final gd mD(int paramInt)
  {
    this.gCn = paramInt;
    return this;
  }
  
  public final gd vs(String paramString)
  {
    AppMethodBeat.i(211605);
    this.gCm = z("SubType", paramString, true);
    AppMethodBeat.o(211605);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gd
 * JD-Core Version:    0.7.0.1
 */