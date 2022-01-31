package com.tencent.mm.plugin.f.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.f.a.b.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@TargetApi(18)
public class c
{
  public static final String TAG = c.class.getName();
  private static HashMap<String, Long> hUP = new HashMap();
  private static HashMap<String, Long> hVX;
  
  static
  {
    HashMap localHashMap = new HashMap();
    hVX = localHashMap;
    localHashMap.put(h.hVe, Long.valueOf(1L));
    hVX.put(h.hVf, Long.valueOf(1L));
    hVX.put(h.hVg, Long.valueOf(16L));
    hVX.put(h.hVh, Long.valueOf(16L));
    hVX.put(h.hVi, Long.valueOf(16L));
    hVX.put(h.hVj, Long.valueOf(16L));
    hUP.put(h.hVb, Long.valueOf(0L));
    hUP.put(h.hVk, Long.valueOf(2L));
    hUP.put(h.hVn, Long.valueOf(4L));
    hUP.put(h.hVr, Long.valueOf(8L));
  }
  
  public static long a(BluetoothGattService paramBluetoothGattService)
  {
    long l1 = 0L;
    if (paramBluetoothGattService == null)
    {
      y.e(TAG, "service is null");
      return 0L;
    }
    Object localObject = paramBluetoothGattService.getUuid().toString();
    if ((((String)localObject).equalsIgnoreCase(h.hVb)) && (paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVe)) != null))
    {
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristics();
      l1 = 0L;
      int i = 0;
      if (i < paramBluetoothGattService.size())
      {
        localObject = ((BluetoothGattCharacteristic)paramBluetoothGattService.get(i)).getUuid().toString();
        localObject = (Long)hVX.get(localObject);
        if (localObject == null) {}
        for (long l2 = 0L;; l2 = ((Long)localObject).longValue())
        {
          i += 1;
          l1 = l2 | l1;
          break;
        }
      }
      y.d(TAG, "wechat service, profileType = %d", new Object[] { Long.valueOf(l1) });
      return l1;
    }
    paramBluetoothGattService = (Long)hUP.get(localObject);
    if (paramBluetoothGattService == null) {}
    for (;;)
    {
      y.d(TAG, "service uuid = %s, profileType = %d", new Object[] { localObject, Long.valueOf(l1) });
      return l1;
      l1 = paramBluetoothGattService.longValue();
    }
  }
  
  public static byte[] a(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    if ((paramBluetoothGattCharacteristic == null) || (paramArrayOfByte == null))
    {
      y.e(TAG, "characteristic or recvData is null");
      return null;
    }
    long l = 0L;
    Object localObject = paramBluetoothGattCharacteristic.getUuid().toString();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getService();
    if (paramBluetoothGattCharacteristic != null)
    {
      l = a(paramBluetoothGattCharacteristic);
      y.d(TAG, "recv data. uuid = %s, data = %s", new Object[] { localObject, com.tencent.mm.plugin.exdevice.j.b.aq(paramArrayOfByte) });
      if ((0L == (1L & l)) || ((!((String)localObject).equalsIgnoreCase(f.hWz)) && (!((String)localObject).equalsIgnoreCase(f.hWA)))) {
        break label468;
      }
      paramBluetoothGattCharacteristic = new f();
      if ((paramArrayOfByte.length > 0) && ((paramArrayOfByte[0] & 0x1) != 0)) {
        break label202;
      }
      y.e(f.TAG, "pase step data error");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label458;
      }
      paramArrayOfByte = com.tencent.mm.plugin.exdevice.j.b.bi(paramBluetoothGattCharacteristic);
      y.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[] { Integer.valueOf(paramBluetoothGattCharacteristic.hWB), Integer.valueOf(paramBluetoothGattCharacteristic.hWC), Integer.valueOf(paramBluetoothGattCharacteristic.hWD) });
      return paramArrayOfByte;
      y.e(TAG, "the characteristic has no parent service");
      break;
      label202:
      if ((localObject == null) || ((!((String)localObject).equals(f.hWz)) && (!((String)localObject).equals(f.hWA))))
      {
        y.e(f.TAG, "uuid is not correct");
        i = 0;
      }
      else
      {
        paramBluetoothGattCharacteristic.hVw = ((String)localObject);
        i = 4;
        if ((paramArrayOfByte[0] & 0x2) != 0) {
          i = 7;
        }
        j = i;
        if ((paramArrayOfByte[0] & 0x4) != 0) {
          j = i + 3;
        }
        if (j > paramArrayOfByte.length)
        {
          y.e(f.TAG, "data len is not enough");
          i = 0;
        }
        else
        {
          paramBluetoothGattCharacteristic.hWB = 0;
          j = 0;
          i = 1;
          while (j < 3)
          {
            paramBluetoothGattCharacteristic.hWB += ((paramArrayOfByte[i] & 0xFF) << j * 8);
            i += 1;
            j += 1;
          }
          j = i;
          if ((paramArrayOfByte[0] & 0x2) != 0)
          {
            paramBluetoothGattCharacteristic.hWC = 0;
            k = 0;
            for (;;)
            {
              j = i;
              if (k >= 3) {
                break;
              }
              paramBluetoothGattCharacteristic.hWC += ((paramArrayOfByte[i] & 0xFF) << k * 8);
              i += 1;
              k += 1;
            }
          }
          if ((paramArrayOfByte[0] & 0x4) != 0)
          {
            paramBluetoothGattCharacteristic.hWD = 0;
            i = 0;
            while (i < 3)
            {
              paramBluetoothGattCharacteristic.hWD += ((paramArrayOfByte[j] & 0xFF) << i * 8);
              j += 1;
              i += 1;
            }
          }
          i = 1;
        }
      }
    }
    label458:
    y.e(TAG, "parse step data error");
    return null;
    label468:
    g localg;
    boolean bool;
    if ((0L != (0x2 & l)) && ((((String)localObject).equalsIgnoreCase(g.hVm)) || (((String)localObject).equalsIgnoreCase(g.hVl))))
    {
      localg = new g();
      if ((localObject == null) || (((String)localObject).length() <= 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        y.e(g.TAG, "characteristicUuid or data is null or nil");
        i = 0;
      }
      while (i != 0)
      {
        paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.j.b.bi(localg);
        y.d(TAG, "weight info. weight = %d", new Object[] { Integer.valueOf(localg.hWH.zI) });
        return paramBluetoothGattCharacteristic;
        localg.hVw = ((String)localObject);
        if (localg.hVw.equalsIgnoreCase(g.hVl))
        {
          if (4 > paramArrayOfByte.length)
          {
            y.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
            i = 0;
            continue;
          }
          localg.hWG = new g.c();
          paramBluetoothGattCharacteristic = localg.hWG;
          if ((paramArrayOfByte[0] & 0x1) != 0)
          {
            bool = true;
            paramBluetoothGattCharacteristic.hWL = bool;
            paramBluetoothGattCharacteristic = localg.hWG;
            if ((paramArrayOfByte[0] & 0x2) == 0) {
              break label872;
            }
            bool = true;
            paramBluetoothGattCharacteristic.hWM = bool;
            paramBluetoothGattCharacteristic = localg.hWG;
            if ((paramArrayOfByte[0] & 0x4) == 0) {
              break label878;
            }
            bool = true;
            paramBluetoothGattCharacteristic.hWN = bool;
            localg.hWG.hWO = ((byte)((paramArrayOfByte[0] & 0x78) >> 3));
            localg.hWG.hWP = ((byte)(((paramArrayOfByte[0] & 0x80) >> 7) + ((paramArrayOfByte[1] & 0x3) << 1)));
            str = g.TAG;
            if (!localg.hWG.hWL) {
              break label884;
            }
            paramBluetoothGattCharacteristic = "true";
            if (!localg.hWG.hWM) {
              break label891;
            }
            paramArrayOfByte = "true";
            if (!localg.hWG.hWN) {
              break label898;
            }
            localObject = "true";
            y.d(str, "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d", new Object[] { paramBluetoothGattCharacteristic, paramArrayOfByte, localObject, Byte.valueOf(localg.hWG.hWO), Byte.valueOf(localg.hWG.hWP) });
          }
        }
        label872:
        label878:
        label884:
        label891:
        while (!localg.hVw.equalsIgnoreCase(g.hVm)) {
          for (;;)
          {
            String str;
            i = 1;
            break;
            bool = false;
            continue;
            bool = false;
            continue;
            bool = false;
            continue;
            paramBluetoothGattCharacteristic = "false";
            continue;
            paramArrayOfByte = "false";
            continue;
            localObject = "false";
          }
        }
        label898:
        k = paramArrayOfByte[0];
        if ((k & 0x2) == 0) {
          break label3887;
        }
      }
    }
    label1029:
    label1554:
    label3882:
    label3887:
    for (j = 10;; j = 3)
    {
      i = j;
      if ((k & 0x4) != 0) {
        i = j + 1;
      }
      j = i;
      if ((k & 0x8) != 0) {
        j = i + 4;
      }
      if (j > paramArrayOfByte.length)
      {
        y.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(j) });
        i = 0;
        break;
      }
      localg.hWH = new g.b();
      paramBluetoothGattCharacteristic = localg.hWH;
      if ((k & 0x1) != 0)
      {
        bool = true;
        paramBluetoothGattCharacteristic.hWI = bool;
        localg.hWH.zI = ((paramArrayOfByte[1] & 0xFF) + ((paramArrayOfByte[2] & 0xFF) << 8));
        if ((k & 0x2) == 0) {
          break label3882;
        }
        localg.hWH.hWJ = new g.a();
        paramBluetoothGattCharacteristic = localg.hWH.hWJ;
        localObject = g.TAG;
        if (paramArrayOfByte != null) {
          break label1383;
        }
        i = 0;
        label1103:
        y.d((String)localObject, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 10)) {
          break label1389;
        }
        y.e(g.TAG, "data input error");
      }
      for (i = 10;; i = 3)
      {
        j = i;
        if ((k & 0x4) != 0)
        {
          localg.hWH.hVM = (paramArrayOfByte[i] & 0xFF);
          j = i + 1;
        }
        if ((k & 0x8) != 0)
        {
          localg.hWH.hWK = ((paramArrayOfByte[j] & 0xFF) + ((paramArrayOfByte[(j + 1)] & 0xFF) << 8));
          i = j + 2;
          paramBluetoothGattCharacteristic = localg.hWH;
          j = paramArrayOfByte[i];
          paramBluetoothGattCharacteristic.mHeight = (((paramArrayOfByte[(i + 1)] & 0xFF) << 8) + (j & 0xFF));
        }
        localObject = g.TAG;
        if (localg.hWH.hWI)
        {
          paramBluetoothGattCharacteristic = "lb&inch";
          i = localg.hWH.zI;
          if (localg.hWH.hWJ != null) {
            break label1554;
          }
        }
        for (paramArrayOfByte = "null";; paramArrayOfByte = "object")
        {
          y.d((String)localObject, "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d", new Object[] { paramBluetoothGattCharacteristic, Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(localg.hWH.hVM), Integer.valueOf(localg.hWH.hWK), Integer.valueOf(localg.hWH.mHeight) });
          break;
          bool = false;
          break label1029;
          label1383:
          i = paramArrayOfByte.length;
          break label1103;
          label1389:
          paramBluetoothGattCharacteristic.dtp = ((paramArrayOfByte[3] & 0xFF) + ((paramArrayOfByte[4] & 0xFF) << 8));
          paramBluetoothGattCharacteristic.dtl = (paramArrayOfByte[5] & 0xFF);
          paramBluetoothGattCharacteristic.hVT = (paramArrayOfByte[6] & 0xFF);
          paramBluetoothGattCharacteristic.hVU = (paramArrayOfByte[7] & 0xFF);
          paramBluetoothGattCharacteristic.hVV = (paramArrayOfByte[8] & 0xFF);
          paramBluetoothGattCharacteristic.hVW = (paramArrayOfByte[9] & 0xFF);
          y.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(paramBluetoothGattCharacteristic.dtp), Integer.valueOf(paramBluetoothGattCharacteristic.dtl), Integer.valueOf(paramBluetoothGattCharacteristic.hVT), Integer.valueOf(paramBluetoothGattCharacteristic.hVU), Integer.valueOf(paramBluetoothGattCharacteristic.hVV), Integer.valueOf(paramBluetoothGattCharacteristic.hVW) });
          break label1157;
          paramBluetoothGattCharacteristic = "kg&meter";
          break label1280;
        }
        y.e(TAG, "parse weight scale data error");
        return null;
        int m;
        if ((0L != (0x4 & l)) && ((((String)localObject).equalsIgnoreCase(d.hVy)) || (((String)localObject).equalsIgnoreCase(d.hVY)) || (((String)localObject).equalsIgnoreCase(d.hVZ))))
        {
          paramBluetoothGattCharacteristic = new d();
          if ((localObject == null) || (((String)localObject).length() <= 0) || (paramArrayOfByte == null)) {
            y.e(d.TAG, "characteristicUuid or data is null");
          }
          while (i != 0)
          {
            return com.tencent.mm.plugin.exdevice.j.b.bi(paramBluetoothGattCharacteristic);
            paramBluetoothGattCharacteristic.hVw = ((String)localObject);
            k = paramArrayOfByte.length;
            if (paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(d.hVy))
            {
              if (paramArrayOfByte.length < 2)
              {
                y.e(d.TAG, "Received data length is not right:" + k);
                continue;
              }
              paramBluetoothGattCharacteristic.hWg = new d.a(paramBluetoothGattCharacteristic);
              m = paramArrayOfByte[0];
              y.d(d.TAG, "flag=" + m);
              if (((m & 0x1) == 1) && (k >= 3))
              {
                y.d(d.TAG, "Value Format = uint16");
                i = paramArrayOfByte[2];
                paramBluetoothGattCharacteristic.hWg.hWh = ((i << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[1] & 0xFF));
                i = 3;
                y.v(d.TAG, "Data received from HR " + paramBluetoothGattCharacteristic.hWg.hWh);
                if ((m & 0x6) != 4) {
                  break label2124;
                }
                y.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                paramBluetoothGattCharacteristic.hWg.hWi = 1;
                j = i;
                if ((m & 0x8) == 8)
                {
                  j = i;
                  if (k >= i + 2)
                  {
                    y.d(d.TAG, "Energy Expend Present");
                    j = paramArrayOfByte[(i + 1)] << 8 & 0xFF00;
                    paramBluetoothGattCharacteristic.hWg.hWj = ((paramArrayOfByte[i] & 0xFF) + (j & 0xFF00));
                    y.v("H7ConnectThread", "energyExp from HR energyExph " + j + " " + paramBluetoothGattCharacteristic.hWg.hWj);
                    j = i + 2;
                  }
                }
                if (((m & 0x10) == 16) && (k >= j + 2))
                {
                  y.d(d.TAG, "RR Interval Present");
                  i = (paramArrayOfByte[(j + 1)] & 0xFF) << 8;
                  paramBluetoothGattCharacteristic.hWg.hWk = ((paramArrayOfByte[j] & 0xFF) + (i & 0xFF00));
                  y.v(d.TAG, "rrInterval from HR rrIntervalh" + i + " " + paramBluetoothGattCharacteristic.hWg.hWk);
                }
              }
            }
            label2124:
            while (!paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(d.hVY)) {
              for (;;)
              {
                i = 1;
                break;
                if (k >= 2)
                {
                  y.d(d.TAG, "Value Format = uint8");
                  paramBluetoothGattCharacteristic.hWg.hWh = (paramArrayOfByte[1] & 0xFF);
                  i = 2;
                }
                else
                {
                  y.d(d.TAG, "receive data error");
                  break;
                  if ((m & 0x6) == 6)
                  {
                    y.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                    paramBluetoothGattCharacteristic.hWg.hWi = 2;
                  }
                  else
                  {
                    y.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                    paramBluetoothGattCharacteristic.hWg.hWi = 0;
                  }
                }
              }
            }
            switch (paramArrayOfByte[0])
            {
            default: 
              paramBluetoothGattCharacteristic.hWf = "Unknown";
            }
            for (;;)
            {
              y.d(d.TAG, "position=" + paramBluetoothGattCharacteristic.hWf);
              break;
              paramBluetoothGattCharacteristic.hWf = "Other";
              continue;
              paramBluetoothGattCharacteristic.hWf = "Chest";
              continue;
              paramBluetoothGattCharacteristic.hWf = "Wrist";
              continue;
              paramBluetoothGattCharacteristic.hWf = "Finger";
              continue;
              paramBluetoothGattCharacteristic.hWf = "Hand";
              continue;
              paramBluetoothGattCharacteristic.hWf = "Ear Lobe";
              continue;
              paramBluetoothGattCharacteristic.hWf = "Foot";
            }
          }
          y.e(TAG, "parse heart rate data error");
          return null;
        }
        if ((0L != (0x8 & l)) && ((((String)localObject).equalsIgnoreCase(b.hVy)) || (((String)localObject).equalsIgnoreCase(b.hVz)) || (((String)localObject).equalsIgnoreCase(b.hVA))))
        {
          paramBluetoothGattCharacteristic = new b();
          if ((localObject == null) || (((String)localObject).length() <= 0) || (paramArrayOfByte == null))
          {
            y.e(b.TAG, "characteristicUuid or data is null");
            i = j;
          }
          while (i != 0)
          {
            return com.tencent.mm.plugin.exdevice.j.b.bi(paramBluetoothGattCharacteristic);
            paramBluetoothGattCharacteristic.hVw = ((String)localObject);
            k = paramArrayOfByte.length;
            if (paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(b.hVy))
            {
              if (k < 7)
              {
                y.e(b.TAG, "data len is not right.");
                i = j;
                continue;
              }
              paramBluetoothGattCharacteristic.hVG = new b.b(paramBluetoothGattCharacteristic);
              m = paramArrayOfByte[0];
              y.d(b.TAG, "flag=" + m);
              if ((m & 0x1) != 0)
              {
                y.d(b.TAG, "the value unit is kPa.");
                paramBluetoothGattCharacteristic.hVG.hVJ = true;
                label2547:
                paramBluetoothGattCharacteristic.hVG.hVQ = b.J(paramArrayOfByte, 1);
                paramBluetoothGattCharacteristic.hVG.hVR = b.J(paramArrayOfByte, 3);
                paramBluetoothGattCharacteristic.hVG.hVS = b.J(paramArrayOfByte, 5);
                i = 7;
                if (((m & 0x2) == 0) || (k < 14)) {
                  break label2866;
                }
                y.d(b.TAG, "TimeStamp Present.");
                paramBluetoothGattCharacteristic.hVG.hVO.K(paramArrayOfByte, 7);
                i = 14;
                label2626:
                if (((m & 0x4) == 0) || (k < i + 2)) {
                  break label2878;
                }
                y.d(b.TAG, "PulseRate Present.");
                paramBluetoothGattCharacteristic.hVG.hVL = ((int)b.J(paramArrayOfByte, i));
                i += 2;
                y.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.hVG.hVL);
                if ((m & 0x8) == 0) {
                  break label2890;
                }
                y.d(b.TAG, "UserId Present.");
                localObject = paramBluetoothGattCharacteristic.hVG;
                j = i + 1;
                ((b.b)localObject).hVM = paramArrayOfByte[i];
                y.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.hVG.hVM);
                i = j;
                label2762:
                if ((m & 0x10) == 0) {
                  break label2902;
                }
                y.d(b.TAG, "MeasurementStatus Present.");
                j = paramArrayOfByte[(i + 1)];
                paramBluetoothGattCharacteristic.hVG.hVN = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                y.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.hVG.hVN);
              }
            }
            for (;;)
            {
              i = 1;
              break;
              y.d(b.TAG, "the value unit is mmHg.");
              paramBluetoothGattCharacteristic.hVG.hVJ = false;
              break label2547;
              label2866:
              y.d(b.TAG, "TimeStamp not Present.");
              break label2626;
              label2878:
              y.d(b.TAG, "PulseRate not Present.");
              break label2696;
              label2890:
              y.d(b.TAG, "UserId not Present.");
              break label2762;
              label2902:
              y.d(b.TAG, "MeasurementStatus not Present.");
              continue;
              if (paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(b.hVz))
              {
                if (k < 3)
                {
                  y.e(b.TAG, "data len is not right.");
                  i = j;
                  break;
                }
                paramBluetoothGattCharacteristic.hVH = new b.a(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                y.d(b.TAG, "flag=" + m);
                if ((m & 0x1) != 0)
                {
                  y.d(b.TAG, "the value unit is kPa.");
                  paramBluetoothGattCharacteristic.hVH.hVJ = true;
                  label3012:
                  paramBluetoothGattCharacteristic.hVH.hVK = b.J(paramArrayOfByte, 1);
                  if (((m & 0x2) == 0) || (k < 10)) {
                    break label3301;
                  }
                  y.d(b.TAG, "TimeStamp Present.");
                  paramBluetoothGattCharacteristic.hVH.hVO.K(paramArrayOfByte, 3);
                  i = 10;
                  label3063:
                  if (((m & 0x4) == 0) || (k < i + 2)) {
                    break label3315;
                  }
                  y.d(b.TAG, "PulseRate Present.");
                  paramBluetoothGattCharacteristic.hVH.hVL = ((int)b.J(paramArrayOfByte, i));
                  i += 2;
                  y.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.hVH.hVL);
                  label3133:
                  if ((m & 0x8) == 0) {
                    break label3327;
                  }
                  y.d(b.TAG, "UserId Present.");
                  localObject = paramBluetoothGattCharacteristic.hVH;
                  j = i + 1;
                  ((b.a)localObject).hVM = paramArrayOfByte[i];
                  y.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.hVH.hVM);
                  i = j;
                }
                for (;;)
                {
                  if ((m & 0x10) == 0) {
                    break label3339;
                  }
                  y.d(b.TAG, "MeasurementStatus Present.");
                  j = paramArrayOfByte[(i + 1)];
                  paramBluetoothGattCharacteristic.hVH.hVN = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                  y.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.hVH.hVN);
                  break;
                  y.d(b.TAG, "the value unit is mmHg.");
                  paramBluetoothGattCharacteristic.hVH.hVJ = false;
                  break label3012;
                  label3301:
                  y.d(b.TAG, "TimeStamp not Present.");
                  i = 3;
                  break label3063;
                  label3315:
                  y.d(b.TAG, "PulseRate not Present.");
                  break label3133;
                  label3327:
                  y.d(b.TAG, "UserId not Present.");
                }
                y.d(b.TAG, "MeasurementStatus not Present.");
                continue;
              }
              if (paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(b.hVA))
              {
                y.d(b.TAG, "Blood Pressure Feature Characteristic.");
                if (k < 2)
                {
                  y.e(b.TAG, "data len is not right.");
                  i = j;
                  break;
                }
                paramBluetoothGattCharacteristic.hVI = ((paramArrayOfByte[1] << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[0] & 0xFF));
                y.d(b.TAG, "bloodPressureFeatureParameters=" + paramBluetoothGattCharacteristic.hVI);
              }
            }
          }
          y.e(TAG, "parse blood pressure data error");
          return null;
        }
        if ((0L != (l & 0x10)) && ((((String)localObject).equalsIgnoreCase(e.hWm)) || (((String)localObject).equalsIgnoreCase(e.hWn)) || (((String)localObject).equalsIgnoreCase(e.hWo)) || (((String)localObject).equalsIgnoreCase(e.hWp))))
        {
          paramBluetoothGattCharacteristic = new e();
          if ((localObject == null) || (((String)localObject).length() <= 0) || (paramArrayOfByte == null))
          {
            y.e(e.TAG, "characteristicUuid or data is null");
            i = k;
          }
          while (i != 0)
          {
            return com.tencent.mm.plugin.exdevice.j.b.bi(paramBluetoothGattCharacteristic);
            paramBluetoothGattCharacteristic.hVw = ((String)localObject);
            if (paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(e.hWm))
            {
              if (paramArrayOfByte.length != 3)
              {
                y.e(e.TAG, "Data length incorrect");
                i = k;
              }
              else
              {
                paramBluetoothGattCharacteristic.hWq = paramArrayOfByte[0];
                paramBluetoothGattCharacteristic.hWr = paramArrayOfByte[1];
                paramBluetoothGattCharacteristic.hWs = paramArrayOfByte[2];
              }
            }
            else
            {
              for (;;)
              {
                i = 1;
                break;
                if (paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(e.hWn))
                {
                  if (paramArrayOfByte.length != 1)
                  {
                    y.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.hWt = paramArrayOfByte[0];
                  continue;
                }
                if (paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(e.hWo))
                {
                  if (paramArrayOfByte.length < 2)
                  {
                    y.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.hWu[0] = paramArrayOfByte[0];
                  paramBluetoothGattCharacteristic.hWu[1] = paramArrayOfByte[1];
                  continue;
                }
                if (!paramBluetoothGattCharacteristic.hVw.equalsIgnoreCase(e.hWp)) {
                  break label3836;
                }
                if (paramArrayOfByte.length < 4)
                {
                  y.e(e.TAG, "Data length incorrect");
                  i = k;
                  break;
                }
                paramBluetoothGattCharacteristic.hWv = ((paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8));
                paramBluetoothGattCharacteristic.hWx = paramArrayOfByte[2];
                paramBluetoothGattCharacteristic.hWw = paramArrayOfByte[3];
                if (paramArrayOfByte.length > 4)
                {
                  paramBluetoothGattCharacteristic.hWy = new byte[paramArrayOfByte.length - 4];
                  System.arraycopy(paramArrayOfByte, 4, paramBluetoothGattCharacteristic.hWy, 0, paramArrayOfByte.length - 4);
                }
                else
                {
                  paramBluetoothGattCharacteristic.hWy = null;
                }
              }
              label3836:
              y.e(e.TAG, "characteristicUuid is incorrect");
              i = k;
            }
          }
          y.e(TAG, "parse light data error");
          return null;
        }
        y.e(TAG, "unknown characteristic uuid = %s", new Object[] { localObject });
        return null;
      }
    }
  }
  
  public static boolean aa(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte))
    {
      y.e(TAG, "parseBroadcastServiceUuid error. broadcast data is null or nil");
      return false;
    }
    int i = 0;
    int j;
    int m;
    label180:
    Object localObject;
    while ((i >= 0) && (i < paramArrayOfByte.length))
    {
      int k = i + 1;
      i = paramArrayOfByte[i];
      if (k + i > paramArrayOfByte.length)
      {
        y.w(TAG, "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramArrayOfByte.length) });
        return false;
      }
      if (i <= 0)
      {
        y.w(TAG, "current part of data's len = %d.", new Object[] { Integer.valueOf(i) });
        return false;
      }
      j = k + 1;
      int n = paramArrayOfByte[k];
      m = i - 1;
      i = m;
      k = j;
      switch (n)
      {
      case 0: 
      case 1: 
      case 4: 
      case 5: 
      default: 
        i = m + j;
        break;
      case 2: 
      case 3: 
        while (2 <= i)
        {
          m = k + 1;
          j = paramArrayOfByte[k];
          k = m + 1;
          m = paramArrayOfByte[m];
          i -= 2;
          localObject = String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Integer.valueOf((m & 0xFF) << 8 | j & 0xFF) });
          y.d(TAG, "find 16-bit broacast service = %s", new Object[] { localObject });
          if (hUP.containsKey(localObject)) {
            return true;
          }
        }
        i += k;
      }
    }
    j += 16;
    i -= 16;
    for (;;)
    {
      for (;;)
      {
        if (16 <= i) {
          try
          {
            localObject = ByteBuffer.wrap(paramArrayOfByte, j, 16).order(ByteOrder.LITTLE_ENDIAN);
            long l = ((ByteBuffer)localObject).getLong();
            localObject = new UUID(((ByteBuffer)localObject).getLong(), l).toString();
            y.d(TAG, "find 128-bit broacast service = %s", new Object[] { localObject });
            boolean bool = hUP.containsKey(localObject);
            if (!bool) {
              break;
            }
            return true;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            localIndexOutOfBoundsException = localIndexOutOfBoundsException;
            y.e("BlueToothDeviceFilter.parseUUID", localIndexOutOfBoundsException.toString());
            j += 16;
            i -= 16;
          }
          finally {}
        }
      }
      i = j + i;
      break;
      y.i(TAG, "Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(m) });
      y.i(TAG, "Manufacturer Specific Data = %s", new Object[] { com.tencent.mm.plugin.exdevice.j.b.aq(Arrays.copyOfRange(paramArrayOfByte, j, j + m)) });
      break label180;
      i = m;
    }
  }
  
  public static boolean b(BluetoothGattService paramBluetoothGattService)
  {
    if (paramBluetoothGattService == null) {
      y.e(TAG, "service is null");
    }
    long l;
    do
    {
      return false;
      l = a(paramBluetoothGattService);
      if (0L != (1L & l))
      {
        if (paramBluetoothGattService == null)
        {
          y.e(TAG, "service is null");
          return false;
        }
        localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVe));
        if (localBluetoothGattCharacteristic == null)
        {
          y.e(TAG, "no step measurement characteristic found");
          return false;
        }
        i = localBluetoothGattCharacteristic.getProperties();
        y.d(TAG, "step measurement characteristic properties = %d", new Object[] { Integer.valueOf(i) });
        if (((i & 0x30) == 0) || ((i & 0x2) == 0))
        {
          y.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
          return false;
        }
        paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVf));
        if (paramBluetoothGattService != null)
        {
          i = paramBluetoothGattService.getProperties();
          if (((i & 0x2) == 0) || ((i & 0x20) == 0))
          {
            y.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
            return false;
          }
        }
        return true;
      }
      if (0L != (0x2 & l))
      {
        if (paramBluetoothGattService == null)
        {
          y.e(TAG, "service is null");
          return false;
        }
        localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVl));
        if (localBluetoothGattCharacteristic == null)
        {
          y.e(TAG, "weight scale feature characteristic not found");
          return false;
        }
        i = localBluetoothGattCharacteristic.getProperties();
        if ((i & 0x2) == 0)
        {
          y.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
          return false;
        }
        paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVm));
        if (paramBluetoothGattService == null)
        {
          y.e(TAG, "weight measurement characteristic not found");
          return false;
        }
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x20) == 0)
        {
          y.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
          return false;
        }
        return true;
      }
      if (0L != (0x4 & l))
      {
        if (paramBluetoothGattService == null)
        {
          y.e(TAG, "service is null");
          return false;
        }
        localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVo));
        if (localBluetoothGattCharacteristic == null)
        {
          y.e(TAG, "heart rate measurement characteristic not found");
          return false;
        }
        i = localBluetoothGattCharacteristic.getProperties();
        if ((i & 0x10) == 0)
        {
          y.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
          return false;
        }
        localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVp));
        if (localBluetoothGattCharacteristic != null)
        {
          i = localBluetoothGattCharacteristic.getProperties();
          if ((i & 0x2) == 0)
          {
            y.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
            return false;
          }
        }
        paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVq));
        if (paramBluetoothGattService != null)
        {
          i = paramBluetoothGattService.getProperties();
          if ((i & 0x8) == 0)
          {
            y.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(8) });
            return false;
          }
        }
        return true;
      }
      if (0L != (0x8 & l))
      {
        if (paramBluetoothGattService == null)
        {
          y.e(TAG, "service is null");
          return false;
        }
        localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVs));
        if (localBluetoothGattCharacteristic == null)
        {
          y.e(TAG, "blood pressure measurement characteristic not found");
          return false;
        }
        i = localBluetoothGattCharacteristic.getProperties();
        if ((i & 0x20) == 0)
        {
          y.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
          return false;
        }
        localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVu));
        if (localBluetoothGattCharacteristic == null)
        {
          y.e(TAG, "blood pressure feature characteristic not found");
          return false;
        }
        i = localBluetoothGattCharacteristic.getProperties();
        if ((i & 0x2) == 0)
        {
          y.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
          return false;
        }
        paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVt));
        if (paramBluetoothGattService != null)
        {
          i = paramBluetoothGattService.getProperties();
          if ((i & 0x10) == 0)
          {
            y.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
            return false;
          }
        }
        return true;
      }
    } while (0L == (l & 0x10));
    if (paramBluetoothGattService == null)
    {
      y.e(TAG, "service is null");
      return false;
    }
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVg));
    if (localBluetoothGattCharacteristic == null)
    {
      y.e(TAG, "light color characteristic not found");
      return false;
    }
    int i = localBluetoothGattCharacteristic.getProperties();
    if (((i & 0x20) == 0) || ((i & 0x10) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
    {
      y.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
      return false;
    }
    localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVh));
    if (localBluetoothGattCharacteristic == null)
    {
      y.e(TAG, "light work state characteristic not found");
      return false;
    }
    i = localBluetoothGattCharacteristic.getProperties();
    if (((i & 0x20) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
    {
      y.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
      return false;
    }
    localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVi));
    if (localBluetoothGattCharacteristic == null)
    {
      y.e(TAG, "light state changed characteristic not found");
      return false;
    }
    i = localBluetoothGattCharacteristic.getProperties();
    if ((i & 0x20) == 0)
    {
      y.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
      return false;
    }
    paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.hVj));
    if (paramBluetoothGattService == null)
    {
      y.e(TAG, "control point characteristic not found");
      return false;
    }
    i = paramBluetoothGattService.getProperties();
    if (((i & 0x20) == 0) || ((i & 0x8) == 0))
    {
      y.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
      return false;
    }
    return true;
  }
  
  public static String cK(long paramLong)
  {
    Iterator localIterator = hUP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Long)hUP.get(str)).longValue() == paramLong) {
        return str;
      }
    }
    if (hVX.containsValue(Long.valueOf(paramLong))) {
      return h.hVb;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */