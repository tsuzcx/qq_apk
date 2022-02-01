package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends b
{
  private Object fnq;
  private g oMJ;
  private volatile boolean oMK;
  private byte[] oML;
  byte[] oMM;
  private String type;
  
  public a(b.a parama, String paramString)
  {
    super(parama);
    AppMethodBeat.i(46229);
    this.oMJ = new g("MicroMsg.appbrand.ScanQBarDecoder");
    this.fnq = new Object();
    this.oMK = false;
    this.type = paramString;
    AppMethodBeat.o(46229);
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(46233);
    synchronized (this.fnq)
    {
      if (this.oMK)
      {
        if (this.oMJ != null) {
          this.oMJ.release();
        }
        this.oMJ = null;
        this.oMK = false;
        Log.d("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Release()");
      }
      AppMethodBeat.o(46233);
      return;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Point paramPoint, Rect paramRect, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(282895);
    int i;
    int k;
    Object localObject2;
    boolean bool;
    label404:
    int m;
    for (;;)
    {
      int n;
      int i1;
      int i2;
      int i3;
      synchronized (this.fnq)
      {
        if (!this.oMK)
        {
          Log.e("MicroMsg.appbrand.ScanQBarDecoder", "not init");
          AppMethodBeat.o(282895);
          return false;
        }
        Log.d("MicroMsg.appbrand.ScanQBarDecoder", "decode start");
        if (paramRect == null)
        {
          Log.i("MicroMsg.appbrand.ScanQBarDecoder", "scanArea is null, use whole screen area, left: %d, top: %d, right: %d, bottom: %d", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          paramInt6 = paramInt2;
          i = paramInt1;
          j = 0;
          k = 0;
          paramRect = new int[2];
          paramRect[0] = i;
          paramRect[1] = paramInt6;
          if (this.oML != null) {
            break label1315;
          }
          this.oML = new byte[i * paramInt6 * 3 / 2];
          this.oMM = new byte[i * paramInt6];
          Log.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[] { Integer.valueOf(paramInt1 * paramInt2 * 3 / 2) });
          Log.d("MicroMsg.appbrand.ScanQBarDecoder", "onFrameData: %s, width: %s, height: %s decodeDegrees:%d", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
          localObject2 = new Point(paramInt1, paramInt2);
          Rect localRect = new Rect(k, j, k + i, j + paramInt6);
          paramPoint = new int[2];
          this.oML = this.oMJ.a(paramArrayOfByte, (Point)localObject2, paramInt5, localRect, paramPoint);
          System.arraycopy(this.oML, 0, this.oMM, 0, this.oMM.length);
          if (this.oMM != null) {
            Log.d("MicroMsg.appbrand.ScanQBarDecoder", "tempGrayData.len: %d, width: %d, height: %d", new Object[] { Integer.valueOf(this.oMM.length), Integer.valueOf(paramRect[0]), Integer.valueOf(paramRect[1]) });
          }
          paramArrayOfByte = new ArrayList();
          paramRect = new ArrayList();
          if (this.oMM == null) {
            break;
          }
          paramPoint = this.oMJ.a(this.oMM, paramPoint[0], paramPoint[1], paramRect, paramArrayOfByte);
          if ((paramPoint == null) || (paramPoint.isEmpty())) {
            break label2186;
          }
          bool = true;
          Log.i("MicroMsg.appbrand.ScanQBarDecoder", "after scanImage, result:%b", new Object[] { Boolean.valueOf(bool) });
          if ((paramPoint != null) && (!paramPoint.isEmpty()) && (!paramRect.isEmpty())) {
            break label1405;
          }
          AppMethodBeat.o(282895);
          return false;
        }
        Log.i("MicroMsg.appbrand.ScanQBarDecoder", "origin scan area decodeDegrees: %d, left: %d, top: %d, right: %d, bottom: %d", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramRect.left), Integer.valueOf(paramRect.top), Integer.valueOf(paramRect.right), Integer.valueOf(paramRect.bottom) });
        localObject2 = new Rect();
        n = paramRect.left;
        i1 = paramRect.top;
        i2 = paramRect.right;
        i3 = paramRect.bottom;
        m = 0;
        k = 0;
        if (paramPoint == null) {
          break label2121;
        }
        if ((paramInt5 == 90) || (paramInt5 == 270))
        {
          if (paramInt1 - paramPoint.y <= 0)
          {
            j = 0;
            if (paramInt2 - paramPoint.x <= 0)
            {
              i = 0;
              k = i;
              m = j;
              if (paramInt6 != 1) {
                break label2121;
              }
              paramInt6 = i / 2;
              m = j / 2;
              break label2125;
              label639:
              Log.i("MicroMsg.appbrand.ScanQBarDecoder", "translated scan area decodeDegrees: %d, left: %d, top: %d, right: %d, bottom: %d", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(((Rect)localObject2).left), Integer.valueOf(((Rect)localObject2).top), Integer.valueOf(((Rect)localObject2).right), Integer.valueOf(((Rect)localObject2).bottom) });
              if (((Rect)localObject2).left < paramInt1) {
                break label1269;
              }
              paramInt6 = paramInt1 - 1;
              if (((Rect)localObject2).top < paramInt2) {
                break label1279;
              }
              j = paramInt2 - 1;
              if (Math.abs(((Rect)localObject2).width()) + paramInt6 <= paramInt1) {
                break label1289;
              }
              i = paramInt1 - paramInt6;
              if (Math.abs(((Rect)localObject2).height()) + j <= paramInt2) {
                break label1302;
              }
              k = paramInt2 - j;
              break label2171;
            }
          }
          else
          {
            j = paramInt1 - paramPoint.y;
            continue;
          }
          i = paramInt2 - paramPoint.x;
          continue;
        }
        if (paramInt2 - paramPoint.y <= 0)
        {
          j = 0;
          if (paramInt1 - paramPoint.x <= 0) {
            i = 0;
          }
        }
        else
        {
          j = paramInt2 - paramPoint.y;
          continue;
        }
        i = paramInt1 - paramPoint.x;
        continue;
        ((Rect)localObject2).left = (n + paramInt6);
        ((Rect)localObject2).top = (i1 + m);
        ((Rect)localObject2).right = (i2 + paramInt6);
        paramInt6 = i3 + m;
        ((Rect)localObject2).bottom = paramInt6;
      }
      ((Rect)localObject2).left = (paramInt1 - i3 - m);
      if (((Rect)localObject2).left < 0)
      {
        i = 0;
        label933:
        ((Rect)localObject2).left = i;
        ((Rect)localObject2).top = (n + paramInt6);
        ((Rect)localObject2).right = (paramInt1 - i1 - m);
        if (((Rect)localObject2).right >= 0) {
          break label1000;
        }
      }
      label1000:
      for (i = 0;; i = ((Rect)localObject2).right)
      {
        ((Rect)localObject2).right = i;
        paramInt6 = i2 + paramInt6;
        break;
        i = ((Rect)localObject2).left;
        break label933;
      }
      ((Rect)localObject2).left = (paramInt1 - i2 - paramInt6);
      if (((Rect)localObject2).left < 0)
      {
        i = 0;
        label1033:
        ((Rect)localObject2).left = i;
        ((Rect)localObject2).top = (paramInt2 - i3 - m);
        if (((Rect)localObject2).top >= 0) {
          break label1143;
        }
        i = 0;
        label1063:
        ((Rect)localObject2).top = i;
        ((Rect)localObject2).right = (paramInt1 - n - paramInt6);
        if (((Rect)localObject2).right >= 0) {
          break label1153;
        }
        paramInt6 = 0;
        label1093:
        ((Rect)localObject2).right = paramInt6;
        ((Rect)localObject2).bottom = (paramInt2 - i1 - m);
        if (((Rect)localObject2).bottom >= 0) {
          break label1163;
        }
      }
      label1153:
      label1163:
      for (paramInt6 = 0;; paramInt6 = ((Rect)localObject2).bottom)
      {
        ((Rect)localObject2).bottom = paramInt6;
        break;
        i = ((Rect)localObject2).left;
        break label1033;
        label1143:
        i = ((Rect)localObject2).top;
        break label1063;
        paramInt6 = ((Rect)localObject2).right;
        break label1093;
      }
      ((Rect)localObject2).left = (i1 + m);
      ((Rect)localObject2).top = (paramInt2 - i2 - paramInt6);
      if (((Rect)localObject2).top < 0) {}
      for (i = 0;; i = ((Rect)localObject2).top)
      {
        ((Rect)localObject2).top = i;
        ((Rect)localObject2).right = (i3 + m);
        ((Rect)localObject2).bottom = (paramInt2 - n - paramInt6);
        if (((Rect)localObject2).bottom >= 0) {
          break label1259;
        }
        paramInt6 = 0;
        break;
      }
      label1259:
      paramInt6 = ((Rect)localObject2).bottom;
      continue;
      label1269:
      paramInt6 = ((Rect)localObject2).left;
      continue;
      label1279:
      int j = ((Rect)localObject2).top;
      continue;
      label1289:
      i = Math.abs(((Rect)localObject2).width());
      continue;
      label1302:
      k = Math.abs(((Rect)localObject2).height());
      break label2171;
      label1315:
      if (this.oML.length != i * paramInt6 * 3 / 2)
      {
        this.oML = null;
        this.oML = new byte[i * paramInt6 * 3 / 2];
        this.oMM = null;
        this.oMM = new byte[i * paramInt6];
        Log.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[] { Integer.valueOf(paramInt1 * paramInt2 * 3 / 2) });
      }
    }
    AppMethodBeat.o(282895);
    return false;
    label1405:
    Log.i("MicroMsg.appbrand.ScanQBarDecoder", "GetResults size %d", new Object[] { Integer.valueOf(paramPoint.size()) });
    paramPoint = (a.a)paramPoint.get(0);
    paramRect = (QbarNative.QBarPoint)paramRect.get(0);
    label1478:
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    float f8;
    if (paramRect != null)
    {
      if (paramInt5 == 90) {
        break label2192;
      }
      if (paramInt5 != 270) {
        break label2111;
      }
      break label2192;
      f1 = paramRect.x0;
      f2 = paramRect.x1;
      f3 = paramRect.x2;
      f4 = paramRect.x3;
      f5 = paramRect.y0;
      f6 = paramRect.y1;
      f7 = paramRect.y2;
      f8 = paramRect.y3;
      switch (360 - paramInt5 * 2 % 360)
      {
      }
    }
    for (;;)
    {
      f1 = Math.max(paramInt4 * 1.0F / paramInt1, paramInt3 * 1.0F / paramInt6);
      paramRect.x0 *= f1;
      paramRect.x1 *= f1;
      paramRect.x2 *= f1;
      paramRect.x3 *= f1;
      paramRect.y0 *= f1;
      paramRect.y1 *= f1;
      paramRect.y2 *= f1;
      paramRect.y3 = (f1 * paramRect.y3);
      Log.i("MicroMsg.appbrand.ScanQBarDecoder", "decode type:%s, sCharset: %s, data:%s", new Object[] { paramPoint.typeName, paramPoint.charset, paramPoint.data });
      if ((paramPoint != null) && (!Util.isNullOrNil(paramPoint.data)))
      {
        localObject2 = paramPoint.typeName;
        if (paramArrayOfByte.isEmpty()) {}
        for (paramInt1 = 0;; paramInt1 = ((WxQbarNative.QBarReportMsg)paramArrayOfByte.get(0)).qrcodeVersion)
        {
          if ((!((String)localObject2).equals("QR_CODE")) && (!((String)localObject2).equals("WX_CODE"))) {
            break label2077;
          }
          a(paramPoint.data, 1, paramInt1, paramPoint.rawData, paramRect);
          AppMethodBeat.o(282895);
          return true;
          float f9 = paramInt6;
          paramRect.x0 = (f9 - f4);
          paramRect.x1 = (paramInt6 - f1);
          paramRect.x2 = (paramInt6 - f2);
          paramRect.x3 = (paramInt6 - f3);
          paramRect.y0 = f8;
          paramRect.y1 = f5;
          paramRect.y2 = f6;
          paramRect.y3 = f7;
          break;
          paramRect.x0 = (paramInt6 - f3);
          paramRect.x1 = (paramInt6 - f4);
          paramRect.x2 = (paramInt6 - f1);
          paramRect.x3 = (paramInt6 - f2);
          paramRect.y0 = (paramInt1 - f7);
          paramRect.y1 = (paramInt1 - f8);
          paramRect.y2 = (paramInt1 - f5);
          paramRect.y3 = (paramInt1 - f6);
          break;
          paramRect.x0 = f2;
          paramRect.x1 = f3;
          paramRect.x2 = f4;
          paramRect.x3 = f1;
          paramRect.y0 = (paramInt1 - f6);
          paramRect.y1 = (paramInt1 - f7);
          paramRect.y2 = (paramInt1 - f8);
          paramRect.y3 = (paramInt1 - f5);
          break;
        }
        label2077:
        a(paramPoint.data, 2, paramInt1, null, paramRect);
        AppMethodBeat.o(282895);
        return true;
      }
      AppMethodBeat.o(282895);
      return false;
      label2111:
      paramInt1 = paramInt6;
      paramInt6 = i;
      break label1478;
      label2121:
      paramInt6 = k;
      label2125:
      switch (paramInt5)
      {
      }
      break label639;
      label2171:
      m = k;
      k = paramInt6;
      paramInt6 = m;
      break;
      label2186:
      bool = false;
      break label404;
      label2192:
      paramInt1 = i;
      break label1478;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(46230);
    Log.i("MicroMsg.appbrand.ScanQBarDecoder", "init");
    Object localObject2 = this.type;
    for (;;)
    {
      synchronized (this.fnq)
      {
        if (this.oMK)
        {
          Log.i("MicroMsg.appbrand.ScanQBarDecoder", "the QbarDecoder is already init");
          AppMethodBeat.o(46230);
          return;
        }
        if (this.oMJ.hasInited()) {
          break label332;
        }
        this.oMJ.a(0, com.tencent.scanlib.b.lZ(MMApplicationContext.getContext()));
        if (this.oMJ.hasInited())
        {
          this.oMJ.inL();
          break label332;
          Object localObject4 = new HashSet();
          if (((String)localObject2).contains("barcode")) {
            ((Set)localObject4).add(Integer.valueOf(1));
          }
          if (((String)localObject2).contains("qrcode")) {
            ((Set)localObject4).add(Integer.valueOf(2));
          }
          ((Set)localObject4).add(Integer.valueOf(4));
          localObject2 = new int[((Set)localObject4).size()];
          localObject4 = ((Set)localObject4).iterator();
          int i = 0;
          if (((Iterator)localObject4).hasNext())
          {
            Integer localInteger = (Integer)((Iterator)localObject4).next();
            if (localInteger == null) {
              continue;
            }
            localObject2[i] = localInteger.intValue();
            i += 1;
            continue;
          }
          i = this.oMJ.S((int[])localObject2);
          Log.i("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Init = [%b], SetReaders = [%d], readers: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Arrays.toString((int[])localObject2) });
          if ((!bool) || (i != 0))
          {
            Log.e("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative failed");
            releaseDecoder();
            AppMethodBeat.o(46230);
            return;
          }
          this.oMK = true;
          AppMethodBeat.o(46230);
          return;
        }
      }
      boolean bool = false;
      continue;
      label332:
      bool = true;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(46232);
    Log.i("MicroMsg.appbrand.ScanQBarDecoder", "release");
    releaseDecoder();
    AppMethodBeat.o(46232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.a
 * JD-Core Version:    0.7.0.1
 */