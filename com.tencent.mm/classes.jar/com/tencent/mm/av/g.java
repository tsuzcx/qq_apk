package com.tencent.mm.av;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class g
{
  public int cSx = -2;
  public long dTS;
  public int fQW = 0;
  public int iKP;
  private boolean iXA;
  private boolean iXB;
  private boolean iXC;
  private boolean iXD;
  private boolean iXE;
  private boolean iXF;
  private boolean iXG;
  private boolean iXH;
  private boolean iXI;
  private boolean iXJ;
  private boolean iXK;
  private boolean iXL;
  private boolean iXM;
  private boolean iXN;
  private boolean iXO;
  private boolean iXP;
  private boolean iXQ;
  private boolean iXR;
  private boolean iXS;
  private boolean iXT;
  private boolean iXU;
  public String iXm = "";
  public String iXn = "";
  public String iXo = "";
  public int iXp;
  public int iXq;
  public String iXr = "";
  int iXs = 0;
  private String iXt = "";
  public int iXu;
  public long iXv;
  int iXw;
  public int iXx = 0;
  public String iXy = "";
  int iXz = 1;
  public long localId;
  public int offset;
  int source;
  public int status;
  
  public final void Aw(long paramLong)
  {
    this.iXv = paramLong;
    this.iXI = true;
  }
  
  public final void Op(String paramString)
  {
    this.iXt = paramString;
    this.iXQ = true;
  }
  
  public final void Oq(String paramString)
  {
    this.iXm = paramString;
    this.iXE = true;
  }
  
  public final void Or(String paramString)
  {
    this.iXn = paramString;
    this.iXF = true;
  }
  
  public final void Os(String paramString)
  {
    this.iXo = paramString;
    this.iXG = true;
  }
  
  public final void Ot(String paramString)
  {
    AppMethodBeat.i(150551);
    if (((this.iXy == null) && (paramString != null)) || ((this.iXy != null) && (!this.iXy.equals(paramString)))) {
      this.iXN = true;
    }
    this.iXy = paramString;
    AppMethodBeat.o(150551);
  }
  
  public final void Ou(String paramString)
  {
    this.iXr = paramString;
    this.iXT = true;
  }
  
  public final int bcq()
  {
    return this.iKP;
  }
  
  public final String bcr()
  {
    return this.iXm;
  }
  
  public final String bcs()
  {
    return this.iXn;
  }
  
  public final String bct()
  {
    return this.iXo;
  }
  
  public final boolean bcu()
  {
    return (this.iKP != 0) && (this.iKP == this.offset);
  }
  
  public final boolean bcv()
  {
    return this.iXx > 0;
  }
  
  public final void bcw()
  {
    this.fQW = 1;
    this.iXO = true;
  }
  
  public final void bcx()
  {
    this.iXA = false;
    this.iXB = false;
    this.iXC = false;
    this.iXD = false;
    this.iXE = false;
    this.iXF = false;
    this.iXG = false;
    this.iXH = false;
    this.iXI = false;
    this.iXJ = false;
    this.iXK = false;
    this.iXL = false;
    this.iXM = false;
    this.iXN = false;
    this.iXO = false;
    this.iXP = false;
    this.iXQ = false;
    this.iXR = false;
    this.iXS = false;
    this.iXT = false;
    this.iXU = false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150552);
    this.localId = paramCursor.getInt(0);
    this.dTS = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.iKP = paramCursor.getInt(3);
    this.iXm = paramCursor.getString(4);
    this.iXo = paramCursor.getString(5);
    this.iXu = paramCursor.getInt(6);
    this.iXv = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.iXw = paramCursor.getInt(9);
    this.iXx = paramCursor.getInt(10);
    this.source = paramCursor.getInt(11);
    this.iXy = paramCursor.getString(12);
    this.fQW = paramCursor.getInt(14);
    this.iXz = paramCursor.getInt(15);
    this.iXt = paramCursor.getString(16);
    this.iXp = paramCursor.getInt(17);
    this.iXn = paramCursor.getString(18);
    this.iXq = paramCursor.getInt(19);
    this.iXr = paramCursor.getString(20);
    this.iXs = paramCursor.getInt(21);
    AppMethodBeat.o(150552);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150553);
    ContentValues localContentValues = new ContentValues();
    if (this.iXA) {
      localContentValues.put("id", Long.valueOf(this.localId));
    }
    if (this.iXB) {
      localContentValues.put("msgSvrId", Long.valueOf(this.dTS));
    }
    if (this.iXC) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.iXD) {
      localContentValues.put("totalLen", Integer.valueOf(this.iKP));
    }
    if (this.iXE) {
      localContentValues.put("bigImgPath", this.iXm);
    }
    if (this.iXF) {
      localContentValues.put("midImgPath", this.iXn);
    }
    if (this.iXG) {
      localContentValues.put("thumbImgPath", this.iXo);
    }
    if (this.iXH) {
      localContentValues.put("createtime", Integer.valueOf(this.iXu));
    }
    if (this.iXI) {
      localContentValues.put("msglocalid", Long.valueOf(this.iXv));
    }
    if (this.iXJ) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.iXK) {
      localContentValues.put("nettimes", Integer.valueOf(this.iXw));
    }
    if (this.iXL) {
      localContentValues.put("reserved1", Integer.valueOf(this.iXx));
    }
    if (this.iXM) {
      localContentValues.put("reserved2", Integer.valueOf(this.source));
    }
    if (this.iXN) {
      localContentValues.put("reserved3", this.iXy);
    }
    if (this.iXO) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.fQW));
    }
    if (this.iXP) {
      if (this.offset >= this.iKP) {
        break label437;
      }
    }
    label437:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.iXQ) {
        localContentValues.put("origImgMD5", this.iXt);
      }
      if (this.iXR) {
        localContentValues.put("compressType", Integer.valueOf(this.iXp));
      }
      if (this.iXS) {
        localContentValues.put("forwardType", Integer.valueOf(this.iXq));
      }
      if (this.iXT) {
        localContentValues.put("hevcPath", this.iXr);
      }
      if (this.iXU) {
        localContentValues.put("sendImgType", Integer.valueOf(this.iXs));
      }
      AppMethodBeat.o(150553);
      return localContentValues;
    }
  }
  
  public final String getAesKey()
  {
    AppMethodBeat.i(223574);
    Object localObject = XmlParser.parseXml(this.iXy, "msg", null);
    if (localObject != null)
    {
      localObject = (String)((Map)localObject).get(".msg.img.$aeskey");
      AppMethodBeat.o(223574);
      return localObject;
    }
    AppMethodBeat.o(223574);
    return null;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(223573);
    int i = this.iXp;
    Object localObject = XmlParser.parseXml(this.iXy, "msg", null);
    if (localObject == null)
    {
      AppMethodBeat.o(223573);
      return null;
    }
    if (i != 1)
    {
      localObject = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
      AppMethodBeat.o(223573);
      return localObject;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
    AppMethodBeat.o(223573);
    return localObject;
  }
  
  public final long getLocalId()
  {
    return this.localId;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.iXu = paramInt;
    this.iXH = true;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.localId = paramLong;
    this.iXA = true;
  }
  
  public final void setOffset(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(150550);
    if (this.offset != paramInt) {
      this.iXC = true;
    }
    this.offset = paramInt;
    Log.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.iXv), Integer.valueOf(this.iKP) });
    if (paramInt < this.iKP) {}
    for (paramInt = i;; paramInt = 1)
    {
      tj(paramInt);
      AppMethodBeat.o(150550);
      return;
    }
  }
  
  public final void setSource(int paramInt)
  {
    this.source = paramInt;
    this.iXM = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.iXJ = true;
  }
  
  public final void te(int paramInt)
  {
    this.iXw = paramInt;
    this.iXK = true;
  }
  
  public final void tf(int paramInt)
  {
    this.iKP = paramInt;
    this.iXD = true;
  }
  
  public final void tg(int paramInt)
  {
    this.iXx = paramInt;
    this.iXL = true;
  }
  
  public final void th(int paramInt)
  {
    this.iXq = paramInt;
    this.iXS = true;
  }
  
  public final void ti(int paramInt)
  {
    this.iXs = paramInt;
    this.iXU = true;
  }
  
  public final void tj(int paramInt)
  {
    if (this.iXz != paramInt) {
      this.iXP = true;
    }
    this.iXz = paramInt;
  }
  
  public final void tk(int paramInt)
  {
    this.iXp = paramInt;
    this.iXR = true;
  }
  
  public final void yF(long paramLong)
  {
    if (this.dTS != paramLong) {
      this.iXB = true;
    }
    this.dTS = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.g
 * JD-Core Version:    0.7.0.1
 */