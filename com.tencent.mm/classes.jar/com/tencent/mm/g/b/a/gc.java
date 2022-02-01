package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gc
  extends a
{
  private long dRO = 0L;
  private long dVR = 0L;
  private long dXI = 0L;
  private String emV = "";
  private long emY = 0L;
  private long emZ = 0L;
  private long eng = 0L;
  private long enh = 0L;
  private long eni = 0L;
  private long enj = 2L;
  private long enk = 0L;
  private long enm = 0L;
  private long enn = 0L;
  private long eoA = 0L;
  private long eoB = 0L;
  private long eoC = 0L;
  private long eoD = 0L;
  private String eoE = "";
  private long eoy = 0L;
  private long eoz = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(74986);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eng);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eni);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enn);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(74986);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(74987);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dRO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishObjectId:").append(this.emV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dXI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dVR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QuitTime:").append(this.eoy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasRecordVideo:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterAllbum:").append(this.eoA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiWidgetCount:").append(this.emY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextWidgetCount:").append(this.emZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddMusic:").append(this.eoB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddPosition:").append(this.eoC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.eoD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewActionTrace:").append(this.eoE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.eng);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickSearchMusic:").append(this.enh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPublicTimeLine:").append(this.eni);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishVideoType:").append(this.enj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoCount:").append(this.enk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAddTextIntro:").append(this.enm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddTextIntroWordCount:").append(this.enn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74987);
    return localObject;
  }
  
  public final gc TW()
  {
    this.eoz = 1L;
    return this;
  }
  
  public final gc TX()
  {
    this.eoA = 1L;
    return this;
  }
  
  public final gc TY()
  {
    this.eoC = 1L;
    return this;
  }
  
  public final gc TZ()
  {
    this.enh = 1L;
    return this;
  }
  
  public final gc Ua()
  {
    this.enm = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16639;
  }
  
  public final gc lA(long paramLong)
  {
    this.dXI = paramLong;
    return this;
  }
  
  public final gc lB(long paramLong)
  {
    this.dVR = paramLong;
    return this;
  }
  
  public final gc lC(long paramLong)
  {
    this.eoy = paramLong;
    return this;
  }
  
  public final gc lD(long paramLong)
  {
    this.emY = paramLong;
    return this;
  }
  
  public final gc lE(long paramLong)
  {
    this.emZ = paramLong;
    return this;
  }
  
  public final gc lF(long paramLong)
  {
    this.eoB = paramLong;
    return this;
  }
  
  public final gc lG(long paramLong)
  {
    this.eng = paramLong;
    return this;
  }
  
  public final gc lH(long paramLong)
  {
    this.eni = paramLong;
    return this;
  }
  
  public final gc lI(long paramLong)
  {
    this.enj = paramLong;
    return this;
  }
  
  public final gc lJ(long paramLong)
  {
    this.enk = paramLong;
    return this;
  }
  
  public final gc lz(long paramLong)
  {
    this.dRO = paramLong;
    return this;
  }
  
  public final gc pm(String paramString)
  {
    AppMethodBeat.i(74984);
    this.emV = t("PublishObjectId", paramString, true);
    AppMethodBeat.o(74984);
    return this;
  }
  
  public final gc pn(String paramString)
  {
    AppMethodBeat.i(74985);
    this.eoE = t("NewActionTrace", paramString, true);
    AppMethodBeat.o(74985);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gc
 * JD-Core Version:    0.7.0.1
 */