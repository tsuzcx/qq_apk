package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class j
  extends a
{
  public int cQm = 0;
  public int cQn = 0;
  public int cQo = 0;
  private String cQp;
  private String cQq;
  private String cQr;
  private String cQs;
  private String cQt;
  private String cQu;
  private String cQv;
  private String cQw;
  
  public final String Ff()
  {
    AppMethodBeat.i(40569);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cQm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQw);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(40569);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(40570);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CgiCmd:").append(this.cQm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrType:").append(this.cQn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.cQo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptKey:").append(this.cQp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptUserinfo:").append(this.cQq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfoLength:").append(this.cQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_01:").append(this.cQs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_02:").append(this.cQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_03:").append(this.cQu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_04:").append(this.cQv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EncryptCellinfo_05:").append(this.cQw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(40570);
    return localObject;
  }
  
  public final j eX(String paramString)
  {
    AppMethodBeat.i(40561);
    this.cQp = t("EncryptKey", paramString, true);
    AppMethodBeat.o(40561);
    return this;
  }
  
  public final j eY(String paramString)
  {
    AppMethodBeat.i(40562);
    this.cQq = t("EncryptUserinfo", paramString, true);
    AppMethodBeat.o(40562);
    return this;
  }
  
  public final j eZ(String paramString)
  {
    AppMethodBeat.i(40563);
    this.cQr = t("EncryptCellinfoLength", paramString, true);
    AppMethodBeat.o(40563);
    return this;
  }
  
  public final j fa(String paramString)
  {
    AppMethodBeat.i(40564);
    this.cQs = t("EncryptCellinfo_01", paramString, true);
    AppMethodBeat.o(40564);
    return this;
  }
  
  public final j fb(String paramString)
  {
    AppMethodBeat.i(40565);
    this.cQt = t("EncryptCellinfo_02", paramString, true);
    AppMethodBeat.o(40565);
    return this;
  }
  
  public final j fc(String paramString)
  {
    AppMethodBeat.i(40566);
    this.cQu = t("EncryptCellinfo_03", paramString, true);
    AppMethodBeat.o(40566);
    return this;
  }
  
  public final j fd(String paramString)
  {
    AppMethodBeat.i(40567);
    this.cQv = t("EncryptCellinfo_04", paramString, true);
    AppMethodBeat.o(40567);
    return this;
  }
  
  public final j fe(String paramString)
  {
    AppMethodBeat.i(40568);
    this.cQw = t("EncryptCellinfo_05", paramString, true);
    AppMethodBeat.o(40568);
    return this;
  }
  
  public final int getId()
  {
    return 15548;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.j
 * JD-Core Version:    0.7.0.1
 */