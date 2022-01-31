package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private Object bjn = new Object();
  private QbarNative gpf;
  private volatile boolean gpg = false;
  private byte[] gph;
  byte[] gpi;
  private String type;
  
  public a(b.a parama, String paramString)
  {
    super(parama);
    this.type = paramString;
  }
  
  private void nm()
  {
    synchronized (this.bjn)
    {
      if (this.gpg)
      {
        int i = this.gpf.release();
        this.gpf = null;
        this.gpg = false;
        y.d("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Release():%d", new Object[] { Integer.valueOf(i) });
      }
      return;
    }
  }
  
  public final boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1;
    for (;;)
    {
      synchronized (this.bjn)
      {
        if (!this.gpg)
        {
          y.e("MicroMsg.appbrand.ScanQBarDecoder", "not init");
          return false;
        }
        y.d("MicroMsg.appbrand.ScanQBarDecoder", "decode start");
        localObject1 = new int[2];
        localObject1[0] = paramInt1;
        localObject1[1] = paramInt2;
        if (this.gph == null)
        {
          this.gph = new byte[paramInt1 * paramInt2 * 3 / 2];
          this.gpi = new byte[paramInt1 * paramInt2];
          y.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[] { Integer.valueOf(paramInt1 * paramInt2 * 3 / 2) });
          y.d("MicroMsg.appbrand.ScanQBarDecoder", "onFrameData: %s, width: %s, height: %s cameraRotation:%d", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramInt1 = QbarNative.a(this.gph, (int[])localObject1, paramArrayOfByte, paramInt1, paramInt2, 0, 0, paramInt1, paramInt2, paramInt3);
          if (paramInt1 == 0) {
            break;
          }
          y.e("MicroMsg.appbrand.ScanQBarDecoder", "decode isProOk %s", new Object[] { Integer.valueOf(paramInt1) });
          return false;
        }
      }
      if (this.gph.length != paramInt1 * paramInt2 * 3 / 2)
      {
        this.gph = null;
        this.gph = new byte[paramInt1 * paramInt2 * 3 / 2];
        this.gpi = null;
        this.gpi = new byte[paramInt1 * paramInt2];
        y.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[] { Integer.valueOf(paramInt1 * paramInt2 * 3 / 2) });
      }
    }
    System.arraycopy(this.gph, 0, this.gpi, 0, this.gpi.length);
    if (this.gpi != null) {
      y.d("MicroMsg.appbrand.ScanQBarDecoder", "tempGrayData.len: %d, width: %d, height: %d", new Object[] { Integer.valueOf(this.gpi.length), Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]) });
    }
    if (this.gpi != null)
    {
      paramInt1 = this.gpf.w(this.gpi, localObject1[0], localObject1[1]);
      y.i("MicroMsg.appbrand.ScanQBarDecoder", "after scanImage, result:%d", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        return false;
      }
      List localList = this.gpf.cOp();
      if (localList.size() == 0) {
        return false;
      }
      y.i("MicroMsg.appbrand.ScanQBarDecoder", "GetResults size %d", new Object[] { Integer.valueOf(localList.size()) });
      localObject1 = localList.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        paramArrayOfByte = (QbarNative.QBarResult)((Iterator)localObject1).next();
        y.i("MicroMsg.appbrand.ScanQBarDecoder", "decode type:%s, sCharset: %s, data:%s", new Object[] { paramArrayOfByte.typeName, paramArrayOfByte.charset, paramArrayOfByte.data });
      } while (!com.tencent.qbar.a.afx(paramArrayOfByte.data));
      for (;;)
      {
        localObject1 = paramArrayOfByte;
        if (paramArrayOfByte == null)
        {
          localObject1 = paramArrayOfByte;
          if (localList.size() > 0) {
            localObject1 = (QbarNative.QBarResult)localList.get(0);
          }
        }
        if ((localObject1 != null) && (!bk.bl(((QbarNative.QBarResult)localObject1).data)))
        {
          paramArrayOfByte = ((QbarNative.QBarResult)localObject1).typeName;
          if ((paramArrayOfByte.equals("QR_CODE")) || (paramArrayOfByte.equals("WX_CODE")))
          {
            b(((QbarNative.QBarResult)localObject1).data, 1, ((QbarNative.QBarResult)localObject1).rawData);
            return true;
          }
          b(((QbarNative.QBarResult)localObject1).data, 2, null);
          return true;
        }
        return false;
        paramArrayOfByte = null;
      }
      paramInt1 = -1;
    }
  }
  
  public final void init()
  {
    y.i("MicroMsg.appbrand.ScanQBarDecoder", "init");
    Object localObject1 = this.type;
    synchronized (this.bjn)
    {
      if (this.gpg)
      {
        y.i("MicroMsg.appbrand.ScanQBarDecoder", "the QbarDecoder is already init");
        return;
      }
      this.gpf = new QbarNative();
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
    int i = this.gpf.a(0, "ANY", "UTF-8", com.tencent.qbar.a.hp(ae.getContext()));
    int j = this.gpf.h(arrayOfInt, arrayOfInt.length);
    y.i("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Init = [%d], SetReaders = [%d], version = [%s], readers: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), QbarNative.getVersion(), Arrays.toString(arrayOfInt) });
    if ((i != 0) || (j != 0))
    {
      y.e("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative failed");
      nm();
      return;
    }
    synchronized (this.bjn)
    {
      this.gpg = true;
      return;
    }
  }
  
  public final void release()
  {
    y.i("MicroMsg.appbrand.ScanQBarDecoder", "release");
    nm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.a
 * JD-Core Version:    0.7.0.1
 */