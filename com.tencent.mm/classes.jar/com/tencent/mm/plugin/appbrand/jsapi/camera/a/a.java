package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarResult;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends b
{
  private Object ceY;
  private QbarNative hJj;
  private volatile boolean hJk;
  private byte[] hJl;
  byte[] hJm;
  private String type;
  
  public a(b.a parama, String paramString)
  {
    super(parama);
    AppMethodBeat.i(130973);
    this.ceY = new Object();
    this.hJk = false;
    this.type = paramString;
    AppMethodBeat.o(130973);
  }
  
  private void pJ()
  {
    AppMethodBeat.i(130977);
    synchronized (this.ceY)
    {
      if (this.hJk)
      {
        int i = this.hJj.release();
        this.hJj = null;
        this.hJk = false;
        ab.d("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Release():%d", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(130977);
      return;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(130975);
    Object localObject2;
    synchronized (this.ceY)
    {
      if (!this.hJk)
      {
        ab.e("MicroMsg.appbrand.ScanQBarDecoder", "not init");
        AppMethodBeat.o(130975);
        return false;
      }
      ab.d("MicroMsg.appbrand.ScanQBarDecoder", "decode start");
      localObject2 = new int[2];
      localObject2[0] = paramInt1;
      localObject2[1] = paramInt2;
      if (this.hJl == null)
      {
        this.hJl = new byte[paramInt1 * paramInt2 * 3 / 2];
        this.hJm = new byte[paramInt1 * paramInt2];
        ab.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[] { Integer.valueOf(paramInt1 * paramInt2 * 3 / 2) });
      }
      while (this.hJl.length == paramInt1 * paramInt2 * 3 / 2)
      {
        ab.d("MicroMsg.appbrand.ScanQBarDecoder", "onFrameData: %s, width: %s, height: %s cameraRotation:%d", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        paramInt1 = QbarNative.a(this.hJl, (int[])localObject2, paramArrayOfByte, paramInt1, paramInt2, 0, 0, paramInt1, paramInt2, paramInt3);
        if (paramInt1 == 0) {
          break;
        }
        ab.e("MicroMsg.appbrand.ScanQBarDecoder", "decode isProOk %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(130975);
        return false;
      }
      this.hJl = null;
      this.hJl = new byte[paramInt1 * paramInt2 * 3 / 2];
      this.hJm = null;
      this.hJm = new byte[paramInt1 * paramInt2];
      ab.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[] { Integer.valueOf(paramInt1 * paramInt2 * 3 / 2) });
    }
    System.arraycopy(this.hJl, 0, this.hJm, 0, this.hJm.length);
    if (this.hJm != null) {
      ab.d("MicroMsg.appbrand.ScanQBarDecoder", "tempGrayData.len: %d, width: %d, height: %d", new Object[] { Integer.valueOf(this.hJm.length), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
    }
    if (this.hJm != null)
    {
      paramInt1 = this.hJj.A(this.hJm, localObject2[0], localObject2[1]);
      ab.i("MicroMsg.appbrand.ScanQBarDecoder", "after scanImage, result:%d", new Object[] { Integer.valueOf(paramInt1) });
    }
    while (paramInt1 != 0)
    {
      AppMethodBeat.o(130975);
      return false;
      paramInt1 = -1;
    }
    paramArrayOfByte = this.hJj.dUc();
    if (paramArrayOfByte.size() == 0)
    {
      AppMethodBeat.o(130975);
      return false;
    }
    ab.i("MicroMsg.appbrand.ScanQBarDecoder", "GetResults size %d", new Object[] { Integer.valueOf(paramArrayOfByte.size()) });
    paramArrayOfByte = (QbarNative.QBarResult)paramArrayOfByte.get(0);
    ab.i("MicroMsg.appbrand.ScanQBarDecoder", "decode type:%s, sCharset: %s, data:%s", new Object[] { paramArrayOfByte.typeName, paramArrayOfByte.charset, paramArrayOfByte.data });
    if ((paramArrayOfByte != null) && (!bo.isNullOrNil(paramArrayOfByte.data)))
    {
      localObject2 = paramArrayOfByte.typeName;
      if ((((String)localObject2).equals("QR_CODE")) || (((String)localObject2).equals("WX_CODE")))
      {
        b(paramArrayOfByte.data, 1, paramArrayOfByte.rawData);
        AppMethodBeat.o(130975);
        return true;
      }
      b(paramArrayOfByte.data, 2, null);
      AppMethodBeat.o(130975);
      return true;
    }
    AppMethodBeat.o(130975);
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(130974);
    ab.i("MicroMsg.appbrand.ScanQBarDecoder", "init");
    Object localObject1 = this.type;
    synchronized (this.ceY)
    {
      if (this.hJk)
      {
        ab.i("MicroMsg.appbrand.ScanQBarDecoder", "the QbarDecoder is already init");
        AppMethodBeat.o(130974);
        return;
      }
      this.hJj = new QbarNative();
      ??? = new HashSet();
      if (((String)localObject1).contains("barcode")) {
        ((Set)???).add(Integer.valueOf(1));
      }
      if (((String)localObject1).contains("qrcode")) {
        ((Set)???).add(Integer.valueOf(2));
      }
      ((Set)???).add(Integer.valueOf(4));
      localObject1 = new int[((Set)???).size()];
      ??? = ((Set)???).iterator();
      i = 0;
      while (((Iterator)???).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)???).next();
        if (localInteger != null)
        {
          localObject1[i] = localInteger.intValue();
          i += 1;
        }
      }
    }
    int i = this.hJj.a(0, "ANY", "UTF-8", com.tencent.qbar.a.iQ(ah.getContext()));
    com.tencent.qbar.a.a(this.hJj);
    int j = this.hJj.i(arrayOfInt, arrayOfInt.length);
    ab.i("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Init = [%d], SetReaders = [%d], version = [%s], readers: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), QbarNative.getVersion(), Arrays.toString(arrayOfInt) });
    if ((i != 0) || (j != 0))
    {
      ab.e("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative failed");
      pJ();
      AppMethodBeat.o(130974);
      return;
    }
    synchronized (this.ceY)
    {
      this.hJk = true;
      AppMethodBeat.o(130974);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(130976);
    ab.i("MicroMsg.appbrand.ScanQBarDecoder", "release");
    pJ();
    AppMethodBeat.o(130976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.a
 * JD-Core Version:    0.7.0.1
 */