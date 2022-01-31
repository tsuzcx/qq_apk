package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  public static final String TAG;
  private static HashMap<String, Long> jOJ;
  private static HashMap<String, Long> jPQ;
  
  static
  {
    AppMethodBeat.i(18467);
    TAG = c.class.getName();
    jOJ = new HashMap();
    HashMap localHashMap = new HashMap();
    jPQ = localHashMap;
    localHashMap.put(h.jOY, Long.valueOf(1L));
    jPQ.put(h.jOZ, Long.valueOf(1L));
    jPQ.put(h.jPa, Long.valueOf(16L));
    jPQ.put(h.jPb, Long.valueOf(16L));
    jPQ.put(h.jPc, Long.valueOf(16L));
    jPQ.put(h.jPd, Long.valueOf(16L));
    jOJ.put(h.jOV, Long.valueOf(0L));
    jOJ.put(h.jPe, Long.valueOf(2L));
    jOJ.put(h.jPh, Long.valueOf(4L));
    jOJ.put(h.jPl, Long.valueOf(8L));
    AppMethodBeat.o(18467);
  }
  
  public static long a(BluetoothGattService paramBluetoothGattService)
  {
    long l1 = 0L;
    AppMethodBeat.i(18464);
    if (paramBluetoothGattService == null)
    {
      ab.e(TAG, "service is null");
      AppMethodBeat.o(18464);
      return 0L;
    }
    Object localObject = paramBluetoothGattService.getUuid().toString();
    if ((((String)localObject).equalsIgnoreCase(h.jOV)) && (paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jOY)) != null))
    {
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristics();
      l1 = 0L;
      int i = 0;
      if (i < paramBluetoothGattService.size())
      {
        localObject = ((BluetoothGattCharacteristic)paramBluetoothGattService.get(i)).getUuid().toString();
        localObject = (Long)jPQ.get(localObject);
        if (localObject == null) {}
        for (long l2 = 0L;; l2 = ((Long)localObject).longValue())
        {
          i += 1;
          l1 = l2 | l1;
          break;
        }
      }
      ab.d(TAG, "wechat service, profileType = %d", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(18464);
      return l1;
    }
    paramBluetoothGattService = (Long)jOJ.get(localObject);
    if (paramBluetoothGattService == null) {}
    for (;;)
    {
      ab.d(TAG, "service uuid = %s, profileType = %d", new Object[] { localObject, Long.valueOf(l1) });
      AppMethodBeat.o(18464);
      return l1;
      l1 = paramBluetoothGattService.longValue();
    }
  }
  
  public static byte[] a(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    AppMethodBeat.i(18466);
    if ((paramBluetoothGattCharacteristic == null) || (paramArrayOfByte == null))
    {
      ab.e(TAG, "characteristic or recvData is null");
      AppMethodBeat.o(18466);
      return null;
    }
    long l = 0L;
    Object localObject1 = paramBluetoothGattCharacteristic.getUuid().toString();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getService();
    Object localObject2;
    if (paramBluetoothGattCharacteristic != null)
    {
      l = a(paramBluetoothGattCharacteristic);
      ab.d(TAG, "recv data. uuid = %s, data = %s", new Object[] { localObject1, com.tencent.mm.plugin.exdevice.j.b.aO(paramArrayOfByte) });
      if ((0L == (1L & l)) || ((!((String)localObject1).equalsIgnoreCase(f.jQs)) && (!((String)localObject1).equalsIgnoreCase(f.jQt)))) {
        break label504;
      }
      localObject2 = new f();
      if ((paramArrayOfByte.length > 0) && ((paramArrayOfByte[0] & 0x1) != 0)) {
        break label225;
      }
      ab.e(f.TAG, "pase step data error");
      i = 0;
      label151:
      if (i == 0) {
        break label491;
      }
      paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.j.b.bG(localObject2);
      ab.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[] { Integer.valueOf(((f)localObject2).jQu), Integer.valueOf(((f)localObject2).jQv), Integer.valueOf(((f)localObject2).jQw) });
    }
    for (;;)
    {
      AppMethodBeat.o(18466);
      return paramBluetoothGattCharacteristic;
      ab.e(TAG, "the characteristic has no parent service");
      break;
      label225:
      if ((localObject1 == null) || ((!((String)localObject1).equals(f.jQs)) && (!((String)localObject1).equals(f.jQt))))
      {
        ab.e(f.TAG, "uuid is not correct");
        i = 0;
        break label151;
      }
      ((f)localObject2).jPq = ((String)localObject1);
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
        ab.e(f.TAG, "data len is not enough");
        i = 0;
        break label151;
      }
      ((f)localObject2).jQu = 0;
      j = 0;
      i = 1;
      while (j < 3)
      {
        ((f)localObject2).jQu += ((paramArrayOfByte[i] & 0xFF) << j * 8);
        i += 1;
        j += 1;
      }
      j = i;
      if ((paramArrayOfByte[0] & 0x2) != 0)
      {
        ((f)localObject2).jQv = 0;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          ((f)localObject2).jQv += ((paramArrayOfByte[i] & 0xFF) << k * 8);
          i += 1;
          k += 1;
        }
      }
      if ((paramArrayOfByte[0] & 0x4) != 0)
      {
        ((f)localObject2).jQw = 0;
        i = 0;
        while (i < 3)
        {
          ((f)localObject2).jQw += ((paramArrayOfByte[j] & 0xFF) << i * 8);
          j += 1;
          i += 1;
        }
      }
      i = 1;
      break label151;
      label491:
      ab.e(TAG, "parse step data error");
      paramBluetoothGattCharacteristic = null;
    }
    label504:
    boolean bool;
    if ((0L != (0x2 & l)) && ((((String)localObject1).equalsIgnoreCase(g.jPg)) || (((String)localObject1).equalsIgnoreCase(g.jPf))))
    {
      localObject2 = new g();
      if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        ab.e(g.TAG, "characteristicUuid or data is null or nil");
        i = 0;
      }
      label909:
      label915:
      label921:
      label928:
      label935:
      for (;;)
      {
        label578:
        if (i != 0)
        {
          paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.j.b.bG(localObject2);
          ab.d(TAG, "weight info. weight = %d", new Object[] { Integer.valueOf(((g)localObject2).jQA.Ai) });
          break;
          ((g)localObject2).jPq = ((String)localObject1);
          if (((g)localObject2).jPq.equalsIgnoreCase(g.jPf))
          {
            if (4 > paramArrayOfByte.length)
            {
              ab.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
              i = 0;
              continue;
            }
            ((g)localObject2).jQz = new g.c();
            paramBluetoothGattCharacteristic = ((g)localObject2).jQz;
            if ((paramArrayOfByte[0] & 0x1) != 0)
            {
              bool = true;
              paramBluetoothGattCharacteristic.jQE = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).jQz;
              if ((paramArrayOfByte[0] & 0x2) == 0) {
                break label909;
              }
              bool = true;
              paramBluetoothGattCharacteristic.jQF = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).jQz;
              if ((paramArrayOfByte[0] & 0x4) == 0) {
                break label915;
              }
              bool = true;
              paramBluetoothGattCharacteristic.jQG = bool;
              ((g)localObject2).jQz.jQH = ((byte)((paramArrayOfByte[0] & 0x78) >> 3));
              ((g)localObject2).jQz.jQI = ((byte)(((paramArrayOfByte[0] & 0x80) >> 7) + ((paramArrayOfByte[1] & 0x3) << 1)));
              str = g.TAG;
              if (!((g)localObject2).jQz.jQE) {
                break label921;
              }
              paramBluetoothGattCharacteristic = "true";
              if (!((g)localObject2).jQz.jQF) {
                break label928;
              }
              paramArrayOfByte = "true";
              if (!((g)localObject2).jQz.jQG) {
                break label935;
              }
              localObject1 = "true";
              ab.d(str, "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d", new Object[] { paramBluetoothGattCharacteristic, paramArrayOfByte, localObject1, Byte.valueOf(((g)localObject2).jQz.jQH), Byte.valueOf(((g)localObject2).jQz.jQI) });
            }
          }
          while (!((g)localObject2).jPq.equalsIgnoreCase(g.jPg)) {
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
              localObject1 = "false";
            }
          }
          k = paramArrayOfByte[0];
          if ((k & 0x2) == 0) {
            break label3919;
          }
        }
      }
    }
    label1066:
    label1591:
    label2893:
    label3919:
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
        ab.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(j) });
        i = 0;
        break label578;
      }
      ((g)localObject2).jQA = new g.b();
      paramBluetoothGattCharacteristic = ((g)localObject2).jQA;
      if ((k & 0x1) != 0)
      {
        bool = true;
        paramBluetoothGattCharacteristic.jQB = bool;
        ((g)localObject2).jQA.Ai = ((paramArrayOfByte[1] & 0xFF) + ((paramArrayOfByte[2] & 0xFF) << 8));
        if ((k & 0x2) == 0) {
          break label3914;
        }
        ((g)localObject2).jQA.jQC = new g.a();
        paramBluetoothGattCharacteristic = ((g)localObject2).jQA.jQC;
        localObject1 = g.TAG;
        if (paramArrayOfByte != null) {
          break label1420;
        }
        i = 0;
        label1140:
        ab.d((String)localObject1, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 10)) {
          break label1426;
        }
        ab.e(g.TAG, "data input error");
      }
      for (i = 10;; i = 3)
      {
        j = i;
        if ((k & 0x4) != 0)
        {
          ((g)localObject2).jQA.jPG = (paramArrayOfByte[i] & 0xFF);
          j = i + 1;
        }
        if ((k & 0x8) != 0)
        {
          ((g)localObject2).jQA.jQD = ((paramArrayOfByte[j] & 0xFF) + ((paramArrayOfByte[(j + 1)] & 0xFF) << 8));
          i = j + 2;
          paramBluetoothGattCharacteristic = ((g)localObject2).jQA;
          j = paramArrayOfByte[i];
          paramBluetoothGattCharacteristic.mHeight = (((paramArrayOfByte[(i + 1)] & 0xFF) << 8) + (j & 0xFF));
        }
        localObject1 = g.TAG;
        if (((g)localObject2).jQA.jQB)
        {
          paramBluetoothGattCharacteristic = "lb&inch";
          i = ((g)localObject2).jQA.Ai;
          if (((g)localObject2).jQA.jQC != null) {
            break label1591;
          }
        }
        for (paramArrayOfByte = "null";; paramArrayOfByte = "object")
        {
          ab.d((String)localObject1, "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d", new Object[] { paramBluetoothGattCharacteristic, Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(((g)localObject2).jQA.jPG), Integer.valueOf(((g)localObject2).jQA.jQD), Integer.valueOf(((g)localObject2).jQA.mHeight) });
          break;
          bool = false;
          break label1066;
          i = paramArrayOfByte.length;
          break label1140;
          paramBluetoothGattCharacteristic.mYear = ((paramArrayOfByte[3] & 0xFF) + ((paramArrayOfByte[4] & 0xFF) << 8));
          paramBluetoothGattCharacteristic.mMonth = (paramArrayOfByte[5] & 0xFF);
          paramBluetoothGattCharacteristic.mDay = (paramArrayOfByte[6] & 0xFF);
          paramBluetoothGattCharacteristic.jPN = (paramArrayOfByte[7] & 0xFF);
          paramBluetoothGattCharacteristic.jPO = (paramArrayOfByte[8] & 0xFF);
          paramBluetoothGattCharacteristic.jPP = (paramArrayOfByte[9] & 0xFF);
          ab.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(paramBluetoothGattCharacteristic.mYear), Integer.valueOf(paramBluetoothGattCharacteristic.mMonth), Integer.valueOf(paramBluetoothGattCharacteristic.mDay), Integer.valueOf(paramBluetoothGattCharacteristic.jPN), Integer.valueOf(paramBluetoothGattCharacteristic.jPO), Integer.valueOf(paramBluetoothGattCharacteristic.jPP) });
          break label1194;
          paramBluetoothGattCharacteristic = "kg&meter";
          break label1317;
        }
        ab.e(TAG, "parse weight scale data error");
        paramBluetoothGattCharacteristic = null;
        break;
        int m;
        if ((0L != (0x4 & l)) && ((((String)localObject1).equalsIgnoreCase(d.jPs)) || (((String)localObject1).equalsIgnoreCase(d.jPR)) || (((String)localObject1).equalsIgnoreCase(d.jPS))))
        {
          paramBluetoothGattCharacteristic = new d();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null)) {
            ab.e(d.TAG, "characteristicUuid or data is null");
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.j.b.bG(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.jPq = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(d.jPs))
              {
                if (paramArrayOfByte.length < 2)
                {
                  ab.e(d.TAG, "Received data length is not right:".concat(String.valueOf(k)));
                  continue;
                }
                paramBluetoothGattCharacteristic.jPZ = new d.a(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                ab.d(d.TAG, "flag=".concat(String.valueOf(m)));
                if (((m & 0x1) == 1) && (k >= 3))
                {
                  ab.d(d.TAG, "Value Format = uint16");
                  i = paramArrayOfByte[2];
                  paramBluetoothGattCharacteristic.jPZ.jQa = ((i << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[1] & 0xFF));
                  i = 3;
                  ab.v(d.TAG, "Data received from HR " + paramBluetoothGattCharacteristic.jPZ.jQa);
                  if ((m & 0x6) != 4) {
                    break label2153;
                  }
                  ab.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                  paramBluetoothGattCharacteristic.jPZ.jQb = 1;
                  j = i;
                  if ((m & 0x8) == 8)
                  {
                    j = i;
                    if (k >= i + 2)
                    {
                      ab.d(d.TAG, "Energy Expend Present");
                      j = paramArrayOfByte[(i + 1)] << 8 & 0xFF00;
                      paramBluetoothGattCharacteristic.jPZ.jQc = ((paramArrayOfByte[i] & 0xFF) + (j & 0xFF00));
                      ab.v("H7ConnectThread", "energyExp from HR energyExph " + j + " " + paramBluetoothGattCharacteristic.jPZ.jQc);
                      j = i + 2;
                    }
                  }
                  if (((m & 0x10) == 16) && (k >= j + 2))
                  {
                    ab.d(d.TAG, "RR Interval Present");
                    i = (paramArrayOfByte[(j + 1)] & 0xFF) << 8;
                    paramBluetoothGattCharacteristic.jPZ.jQd = ((paramArrayOfByte[j] & 0xFF) + (i & 0xFF00));
                    ab.v(d.TAG, "rrInterval from HR rrIntervalh" + i + " " + paramBluetoothGattCharacteristic.jPZ.jQd);
                  }
                }
              }
              label2153:
              while (!paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(d.jPR)) {
                for (;;)
                {
                  i = 1;
                  break;
                  if (k >= 2)
                  {
                    ab.d(d.TAG, "Value Format = uint8");
                    paramBluetoothGattCharacteristic.jPZ.jQa = (paramArrayOfByte[1] & 0xFF);
                    i = 2;
                  }
                  else
                  {
                    ab.d(d.TAG, "receive data error");
                    break;
                    if ((m & 0x6) == 6)
                    {
                      ab.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                      paramBluetoothGattCharacteristic.jPZ.jQb = 2;
                    }
                    else
                    {
                      ab.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                      paramBluetoothGattCharacteristic.jPZ.jQb = 0;
                    }
                  }
                }
              }
              switch (paramArrayOfByte[0])
              {
              default: 
                paramBluetoothGattCharacteristic.jPY = "Unknown";
              }
              for (;;)
              {
                ab.d(d.TAG, "position=" + paramBluetoothGattCharacteristic.jPY);
                break;
                paramBluetoothGattCharacteristic.jPY = "Other";
                continue;
                paramBluetoothGattCharacteristic.jPY = "Chest";
                continue;
                paramBluetoothGattCharacteristic.jPY = "Wrist";
                continue;
                paramBluetoothGattCharacteristic.jPY = "Finger";
                continue;
                paramBluetoothGattCharacteristic.jPY = "Hand";
                continue;
                paramBluetoothGattCharacteristic.jPY = "Ear Lobe";
                continue;
                paramBluetoothGattCharacteristic.jPY = "Foot";
              }
            }
          }
          ab.e(TAG, "parse heart rate data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (0x8 & l)) && ((((String)localObject1).equalsIgnoreCase(b.jPs)) || (((String)localObject1).equalsIgnoreCase(b.jPt)) || (((String)localObject1).equalsIgnoreCase(b.jPu))))
        {
          paramBluetoothGattCharacteristic = new b();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null))
          {
            ab.e(b.TAG, "characteristicUuid or data is null");
            i = j;
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.j.b.bG(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.jPq = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(b.jPs))
              {
                if (k < 7)
                {
                  ab.e(b.TAG, "data len is not right.");
                  i = j;
                  continue;
                }
                paramBluetoothGattCharacteristic.jPA = new b.b(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                ab.d(b.TAG, "flag=".concat(String.valueOf(m)));
                if ((m & 0x1) != 0)
                {
                  ab.d(b.TAG, "the value unit is kPa.");
                  paramBluetoothGattCharacteristic.jPA.jPD = true;
                  paramBluetoothGattCharacteristic.jPA.jPK = b.K(paramArrayOfByte, 1);
                  paramBluetoothGattCharacteristic.jPA.jPL = b.K(paramArrayOfByte, 3);
                  paramBluetoothGattCharacteristic.jPA.jPM = b.K(paramArrayOfByte, 5);
                  i = 7;
                  if (((m & 0x2) == 0) || (k < 14)) {
                    break label2893;
                  }
                  ab.d(b.TAG, "TimeStamp Present.");
                  paramBluetoothGattCharacteristic.jPA.jPI.L(paramArrayOfByte, 7);
                  i = 14;
                  label2653:
                  if (((m & 0x4) == 0) || (k < i + 2)) {
                    break label2905;
                  }
                  ab.d(b.TAG, "PulseRate Present.");
                  paramBluetoothGattCharacteristic.jPA.jPF = ((int)b.K(paramArrayOfByte, i));
                  i += 2;
                  ab.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.jPA.jPF);
                  if ((m & 0x8) == 0) {
                    break label2917;
                  }
                  ab.d(b.TAG, "UserId Present.");
                  localObject1 = paramBluetoothGattCharacteristic.jPA;
                  j = i + 1;
                  ((b.b)localObject1).jPG = paramArrayOfByte[i];
                  ab.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.jPA.jPG);
                  i = j;
                  label2789:
                  if ((m & 0x10) == 0) {
                    break label2929;
                  }
                  ab.d(b.TAG, "MeasurementStatus Present.");
                  j = paramArrayOfByte[(i + 1)];
                  paramBluetoothGattCharacteristic.jPA.jPH = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                  ab.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.jPA.jPH);
                }
              }
              for (;;)
              {
                i = 1;
                break;
                ab.d(b.TAG, "the value unit is mmHg.");
                paramBluetoothGattCharacteristic.jPA.jPD = false;
                break label2574;
                ab.d(b.TAG, "TimeStamp not Present.");
                break label2653;
                label2905:
                ab.d(b.TAG, "PulseRate not Present.");
                break label2723;
                label2917:
                ab.d(b.TAG, "UserId not Present.");
                break label2789;
                label2929:
                ab.d(b.TAG, "MeasurementStatus not Present.");
                continue;
                if (paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(b.jPt))
                {
                  if (k < 3)
                  {
                    ab.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.jPB = new b.a(paramBluetoothGattCharacteristic);
                  m = paramArrayOfByte[0];
                  ab.d(b.TAG, "flag=".concat(String.valueOf(m)));
                  if ((m & 0x1) != 0)
                  {
                    ab.d(b.TAG, "the value unit is kPa.");
                    paramBluetoothGattCharacteristic.jPB.jPD = true;
                    label3032:
                    paramBluetoothGattCharacteristic.jPB.jPE = b.K(paramArrayOfByte, 1);
                    if (((m & 0x2) == 0) || (k < 10)) {
                      break label3321;
                    }
                    ab.d(b.TAG, "TimeStamp Present.");
                    paramBluetoothGattCharacteristic.jPB.jPI.L(paramArrayOfByte, 3);
                    i = 10;
                    if (((m & 0x4) == 0) || (k < i + 2)) {
                      break label3335;
                    }
                    ab.d(b.TAG, "PulseRate Present.");
                    paramBluetoothGattCharacteristic.jPB.jPF = ((int)b.K(paramArrayOfByte, i));
                    i += 2;
                    ab.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.jPB.jPF);
                    label3153:
                    if ((m & 0x8) == 0) {
                      break label3347;
                    }
                    ab.d(b.TAG, "UserId Present.");
                    localObject1 = paramBluetoothGattCharacteristic.jPB;
                    j = i + 1;
                    ((b.a)localObject1).jPG = paramArrayOfByte[i];
                    ab.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.jPB.jPG);
                    i = j;
                  }
                  for (;;)
                  {
                    if ((m & 0x10) == 0) {
                      break label3359;
                    }
                    ab.d(b.TAG, "MeasurementStatus Present.");
                    j = paramArrayOfByte[(i + 1)];
                    paramBluetoothGattCharacteristic.jPB.jPH = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                    ab.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.jPB.jPH);
                    break;
                    ab.d(b.TAG, "the value unit is mmHg.");
                    paramBluetoothGattCharacteristic.jPB.jPD = false;
                    break label3032;
                    label3321:
                    ab.d(b.TAG, "TimeStamp not Present.");
                    i = 3;
                    break label3083;
                    ab.d(b.TAG, "PulseRate not Present.");
                    break label3153;
                    ab.d(b.TAG, "UserId not Present.");
                  }
                  ab.d(b.TAG, "MeasurementStatus not Present.");
                  continue;
                }
                if (paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(b.jPu))
                {
                  ab.d(b.TAG, "Blood Pressure Feature Characteristic.");
                  if (k < 2)
                  {
                    ab.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.jPC = ((paramArrayOfByte[1] << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[0] & 0xFF));
                  ab.d(b.TAG, "bloodPressureFeatureParameters=" + paramBluetoothGattCharacteristic.jPC);
                }
              }
            }
          }
          ab.e(TAG, "parse blood pressure data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (l & 0x10)) && ((((String)localObject1).equalsIgnoreCase(e.jQf)) || (((String)localObject1).equalsIgnoreCase(e.jQg)) || (((String)localObject1).equalsIgnoreCase(e.jQh)) || (((String)localObject1).equalsIgnoreCase(e.jQi))))
        {
          paramBluetoothGattCharacteristic = new e();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null))
          {
            ab.e(e.TAG, "characteristicUuid or data is null");
            i = k;
          }
          for (;;)
          {
            if (i == 0) {
              break label3877;
            }
            paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.j.b.bG(paramBluetoothGattCharacteristic);
            break;
            paramBluetoothGattCharacteristic.jPq = ((String)localObject1);
            if (paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(e.jQf))
            {
              if (paramArrayOfByte.length != 3)
              {
                ab.e(e.TAG, "Data length incorrect");
                i = k;
              }
              else
              {
                paramBluetoothGattCharacteristic.jQj = paramArrayOfByte[0];
                paramBluetoothGattCharacteristic.jQk = paramArrayOfByte[1];
                paramBluetoothGattCharacteristic.jQl = paramArrayOfByte[2];
              }
            }
            else
            {
              for (;;)
              {
                i = 1;
                break;
                if (paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(e.jQg))
                {
                  if (paramArrayOfByte.length != 1)
                  {
                    ab.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.jQm = paramArrayOfByte[0];
                  continue;
                }
                if (paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(e.jQh))
                {
                  if (paramArrayOfByte.length < 2)
                  {
                    ab.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.jQn[0] = paramArrayOfByte[0];
                  paramBluetoothGattCharacteristic.jQn[1] = paramArrayOfByte[1];
                  continue;
                }
                if (!paramBluetoothGattCharacteristic.jPq.equalsIgnoreCase(e.jQi)) {
                  break label3862;
                }
                if (paramArrayOfByte.length < 4)
                {
                  ab.e(e.TAG, "Data length incorrect");
                  i = k;
                  break;
                }
                paramBluetoothGattCharacteristic.jQo = ((paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8));
                paramBluetoothGattCharacteristic.jQq = paramArrayOfByte[2];
                paramBluetoothGattCharacteristic.jQp = paramArrayOfByte[3];
                if (paramArrayOfByte.length > 4)
                {
                  paramBluetoothGattCharacteristic.jQr = new byte[paramArrayOfByte.length - 4];
                  System.arraycopy(paramArrayOfByte, 4, paramBluetoothGattCharacteristic.jQr, 0, paramArrayOfByte.length - 4);
                }
                else
                {
                  paramBluetoothGattCharacteristic.jQr = null;
                }
              }
              ab.e(e.TAG, "characteristicUuid is incorrect");
              i = k;
            }
          }
          ab.e(TAG, "parse light data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        ab.e(TAG, "unknown characteristic uuid = %s", new Object[] { localObject1 });
        paramBluetoothGattCharacteristic = null;
        break;
      }
    }
  }
  
  public static boolean at(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18462);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e(TAG, "parseBroadcastServiceUuid error. broadcast data is null or nil");
      AppMethodBeat.o(18462);
      return false;
    }
    int i = 0;
    int j;
    int m;
    label204:
    Object localObject;
    while ((i >= 0) && (i < paramArrayOfByte.length))
    {
      int k = i + 1;
      i = paramArrayOfByte[i];
      if (k + i > paramArrayOfByte.length)
      {
        ab.w(TAG, "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(18462);
        return false;
      }
      if (i <= 0)
      {
        ab.w(TAG, "current part of data's len = %d.", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(18462);
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
          ab.d(TAG, "find 16-bit broacast service = %s", new Object[] { localObject });
          if (jOJ.containsKey(localObject))
          {
            AppMethodBeat.o(18462);
            return true;
          }
        }
        i += k;
        continue;
        j += 16;
        i -= 16;
      }
    }
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
            ab.d(TAG, "find 128-bit broacast service = %s", new Object[] { localObject });
            boolean bool = jOJ.containsKey(localObject);
            if (!bool) {
              break;
            }
            return true;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            ab.e("BlueToothDeviceFilter.parseUUID", localIndexOutOfBoundsException.toString());
            j += 16;
            i -= 16;
          }
          finally
          {
            AppMethodBeat.o(18462);
          }
        }
      }
      i = j + i;
      break;
      ab.i(TAG, "Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(m) });
      ab.i(TAG, "Manufacturer Specific Data = %s", new Object[] { com.tencent.mm.plugin.exdevice.j.b.aO(Arrays.copyOfRange(paramArrayOfByte, j, j + m)) });
      break label204;
      AppMethodBeat.o(18462);
      return false;
      i = m;
    }
  }
  
  public static boolean b(BluetoothGattService paramBluetoothGattService)
  {
    AppMethodBeat.i(18465);
    if (paramBluetoothGattService == null)
    {
      ab.e(TAG, "service is null");
      AppMethodBeat.o(18465);
      return false;
    }
    long l = a(paramBluetoothGattService);
    BluetoothGattCharacteristic localBluetoothGattCharacteristic;
    int i;
    if (0L != (1L & l))
    {
      if (paramBluetoothGattService == null)
      {
        ab.e(TAG, "service is null");
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jOY));
      if (localBluetoothGattCharacteristic == null)
      {
        ab.e(TAG, "no step measurement characteristic found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      ab.d(TAG, "step measurement characteristic properties = %d", new Object[] { Integer.valueOf(i) });
      if (((i & 0x30) == 0) || ((i & 0x2) == 0))
      {
        ab.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(18465);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jOZ));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if (((i & 0x2) == 0) || ((i & 0x20) == 0))
        {
          ab.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(18465);
          return false;
        }
      }
      AppMethodBeat.o(18465);
      return true;
    }
    if (0L != (0x2 & l))
    {
      if (paramBluetoothGattService == null)
      {
        ab.e(TAG, "service is null");
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPf));
      if (localBluetoothGattCharacteristic == null)
      {
        ab.e(TAG, "weight scale feature characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x2) == 0)
      {
        ab.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        AppMethodBeat.o(18465);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPg));
      if (paramBluetoothGattService == null)
      {
        ab.e(TAG, "weight measurement characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = paramBluetoothGattService.getProperties();
      if ((i & 0x20) == 0)
      {
        ab.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(18465);
        return false;
      }
      AppMethodBeat.o(18465);
      return true;
    }
    if (0L != (0x4 & l))
    {
      if (paramBluetoothGattService == null)
      {
        ab.e(TAG, "service is null");
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPi));
      if (localBluetoothGattCharacteristic == null)
      {
        ab.e(TAG, "heart rate measurement characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x10) == 0)
      {
        ab.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPj));
      if (localBluetoothGattCharacteristic != null)
      {
        i = localBluetoothGattCharacteristic.getProperties();
        if ((i & 0x2) == 0)
        {
          ab.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
          AppMethodBeat.o(18465);
          return false;
        }
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPk));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x8) == 0)
        {
          ab.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(8) });
          AppMethodBeat.o(18465);
          return false;
        }
      }
      AppMethodBeat.o(18465);
      return true;
    }
    if (0L != (0x8 & l))
    {
      if (paramBluetoothGattService == null)
      {
        ab.e(TAG, "service is null");
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPm));
      if (localBluetoothGattCharacteristic == null)
      {
        ab.e(TAG, "blood pressure measurement characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x20) == 0)
      {
        ab.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPo));
      if (localBluetoothGattCharacteristic == null)
      {
        ab.e(TAG, "blood pressure feature characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x2) == 0)
      {
        ab.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        AppMethodBeat.o(18465);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPn));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x10) == 0)
        {
          ab.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
          AppMethodBeat.o(18465);
          return false;
        }
      }
      AppMethodBeat.o(18465);
      return true;
    }
    if (0L != (l & 0x10))
    {
      if (paramBluetoothGattService == null)
      {
        ab.e(TAG, "service is null");
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPa));
      if (localBluetoothGattCharacteristic == null)
      {
        ab.e(TAG, "light color characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x10) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
      {
        ab.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPb));
      if (localBluetoothGattCharacteristic == null)
      {
        ab.e(TAG, "light work state characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
      {
        ab.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(18465);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPc));
      if (localBluetoothGattCharacteristic == null)
      {
        ab.e(TAG, "light state changed characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x20) == 0)
      {
        ab.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(18465);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.jPd));
      if (paramBluetoothGattService == null)
      {
        ab.e(TAG, "control point characteristic not found");
        AppMethodBeat.o(18465);
        return false;
      }
      i = paramBluetoothGattService.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x8) == 0))
      {
        ab.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(18465);
        return false;
      }
      AppMethodBeat.o(18465);
      return true;
    }
    AppMethodBeat.o(18465);
    return false;
  }
  
  public static String hM(long paramLong)
  {
    AppMethodBeat.i(18463);
    Object localObject = jOJ.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (((Long)jOJ.get(str)).longValue() == paramLong)
      {
        AppMethodBeat.o(18463);
        return str;
      }
    }
    if (jPQ.containsValue(Long.valueOf(paramLong)))
    {
      localObject = h.jOV;
      AppMethodBeat.o(18463);
      return localObject;
    }
    AppMethodBeat.o(18463);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */