package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static HashMap<String, Long> mNM;
  private static HashMap<String, Long> mOT;
  
  static
  {
    AppMethodBeat.i(22578);
    TAG = c.class.getName();
    mNM = new HashMap();
    HashMap localHashMap = new HashMap();
    mOT = localHashMap;
    localHashMap.put(h.mOb, Long.valueOf(1L));
    mOT.put(h.mOc, Long.valueOf(1L));
    mOT.put(h.mOd, Long.valueOf(16L));
    mOT.put(h.mOe, Long.valueOf(16L));
    mOT.put(h.mOf, Long.valueOf(16L));
    mOT.put(h.mOg, Long.valueOf(16L));
    mNM.put(h.mNY, Long.valueOf(0L));
    mNM.put(h.mOh, Long.valueOf(2L));
    mNM.put(h.mOk, Long.valueOf(4L));
    mNM.put(h.mOo, Long.valueOf(8L));
    AppMethodBeat.o(22578);
  }
  
  public static long a(BluetoothGattService paramBluetoothGattService)
  {
    long l1 = 0L;
    AppMethodBeat.i(22575);
    if (paramBluetoothGattService == null)
    {
      ad.e(TAG, "service is null");
      AppMethodBeat.o(22575);
      return 0L;
    }
    Object localObject = paramBluetoothGattService.getUuid().toString();
    if ((((String)localObject).equalsIgnoreCase(h.mNY)) && (paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOb)) != null))
    {
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristics();
      l1 = 0L;
      int i = 0;
      if (i < paramBluetoothGattService.size())
      {
        localObject = ((BluetoothGattCharacteristic)paramBluetoothGattService.get(i)).getUuid().toString();
        localObject = (Long)mOT.get(localObject);
        if (localObject == null) {}
        for (long l2 = 0L;; l2 = ((Long)localObject).longValue())
        {
          i += 1;
          l1 = l2 | l1;
          break;
        }
      }
      ad.d(TAG, "wechat service, profileType = %d", new Object[] { Long.valueOf(l1) });
      AppMethodBeat.o(22575);
      return l1;
    }
    paramBluetoothGattService = (Long)mNM.get(localObject);
    if (paramBluetoothGattService == null) {}
    for (;;)
    {
      ad.d(TAG, "service uuid = %s, profileType = %d", new Object[] { localObject, Long.valueOf(l1) });
      AppMethodBeat.o(22575);
      return l1;
      l1 = paramBluetoothGattService.longValue();
    }
  }
  
  public static byte[] a(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    AppMethodBeat.i(22577);
    if ((paramBluetoothGattCharacteristic == null) || (paramArrayOfByte == null))
    {
      ad.e(TAG, "characteristic or recvData is null");
      AppMethodBeat.o(22577);
      return null;
    }
    long l = 0L;
    Object localObject1 = paramBluetoothGattCharacteristic.getUuid().toString();
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getService();
    Object localObject2;
    if (paramBluetoothGattCharacteristic != null)
    {
      l = a(paramBluetoothGattCharacteristic);
      ad.d(TAG, "recv data. uuid = %s, data = %s", new Object[] { localObject1, com.tencent.mm.plugin.exdevice.k.b.be(paramArrayOfByte) });
      if ((0L == (1L & l)) || ((!((String)localObject1).equalsIgnoreCase(f.mPv)) && (!((String)localObject1).equalsIgnoreCase(f.mPw)))) {
        break label504;
      }
      localObject2 = new f();
      if ((paramArrayOfByte.length > 0) && ((paramArrayOfByte[0] & 0x1) != 0)) {
        break label225;
      }
      ad.e(f.TAG, "pase step data error");
      i = 0;
      label151:
      if (i == 0) {
        break label491;
      }
      paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cU(localObject2);
      ad.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[] { Integer.valueOf(((f)localObject2).mPx), Integer.valueOf(((f)localObject2).mPy), Integer.valueOf(((f)localObject2).mPz) });
    }
    for (;;)
    {
      AppMethodBeat.o(22577);
      return paramBluetoothGattCharacteristic;
      ad.e(TAG, "the characteristic has no parent service");
      break;
      label225:
      if ((localObject1 == null) || ((!((String)localObject1).equals(f.mPv)) && (!((String)localObject1).equals(f.mPw))))
      {
        ad.e(f.TAG, "uuid is not correct");
        i = 0;
        break label151;
      }
      ((f)localObject2).mOt = ((String)localObject1);
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
        ad.e(f.TAG, "data len is not enough");
        i = 0;
        break label151;
      }
      ((f)localObject2).mPx = 0;
      j = 0;
      i = 1;
      while (j < 3)
      {
        ((f)localObject2).mPx += ((paramArrayOfByte[i] & 0xFF) << j * 8);
        i += 1;
        j += 1;
      }
      j = i;
      if ((paramArrayOfByte[0] & 0x2) != 0)
      {
        ((f)localObject2).mPy = 0;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= 3) {
            break;
          }
          ((f)localObject2).mPy += ((paramArrayOfByte[i] & 0xFF) << k * 8);
          i += 1;
          k += 1;
        }
      }
      if ((paramArrayOfByte[0] & 0x4) != 0)
      {
        ((f)localObject2).mPz = 0;
        i = 0;
        while (i < 3)
        {
          ((f)localObject2).mPz += ((paramArrayOfByte[j] & 0xFF) << i * 8);
          j += 1;
          i += 1;
        }
      }
      i = 1;
      break label151;
      label491:
      ad.e(TAG, "parse step data error");
      paramBluetoothGattCharacteristic = null;
    }
    label504:
    boolean bool;
    if ((0L != (0x2 & l)) && ((((String)localObject1).equalsIgnoreCase(g.mOj)) || (((String)localObject1).equalsIgnoreCase(g.mOi))))
    {
      localObject2 = new g();
      if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        ad.e(g.TAG, "characteristicUuid or data is null or nil");
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
          paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cU(localObject2);
          ad.d(TAG, "weight info. weight = %d", new Object[] { Integer.valueOf(((g)localObject2).mPD.GE) });
          break;
          ((g)localObject2).mOt = ((String)localObject1);
          if (((g)localObject2).mOt.equalsIgnoreCase(g.mOi))
          {
            if (4 > paramArrayOfByte.length)
            {
              ad.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
              i = 0;
              continue;
            }
            ((g)localObject2).mPC = new g.c();
            paramBluetoothGattCharacteristic = ((g)localObject2).mPC;
            if ((paramArrayOfByte[0] & 0x1) != 0)
            {
              bool = true;
              paramBluetoothGattCharacteristic.mPH = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).mPC;
              if ((paramArrayOfByte[0] & 0x2) == 0) {
                break label909;
              }
              bool = true;
              paramBluetoothGattCharacteristic.mPI = bool;
              paramBluetoothGattCharacteristic = ((g)localObject2).mPC;
              if ((paramArrayOfByte[0] & 0x4) == 0) {
                break label915;
              }
              bool = true;
              paramBluetoothGattCharacteristic.mPJ = bool;
              ((g)localObject2).mPC.mPK = ((byte)((paramArrayOfByte[0] & 0x78) >> 3));
              ((g)localObject2).mPC.mPL = ((byte)(((paramArrayOfByte[0] & 0x80) >> 7) + ((paramArrayOfByte[1] & 0x3) << 1)));
              str = g.TAG;
              if (!((g)localObject2).mPC.mPH) {
                break label921;
              }
              paramBluetoothGattCharacteristic = "true";
              if (!((g)localObject2).mPC.mPI) {
                break label928;
              }
              paramArrayOfByte = "true";
              if (!((g)localObject2).mPC.mPJ) {
                break label935;
              }
              localObject1 = "true";
              ad.d(str, "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d", new Object[] { paramBluetoothGattCharacteristic, paramArrayOfByte, localObject1, Byte.valueOf(((g)localObject2).mPC.mPK), Byte.valueOf(((g)localObject2).mPC.mPL) });
            }
          }
          while (!((g)localObject2).mOt.equalsIgnoreCase(g.mOj)) {
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
        ad.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(j) });
        i = 0;
        break label578;
      }
      ((g)localObject2).mPD = new g.b();
      paramBluetoothGattCharacteristic = ((g)localObject2).mPD;
      if ((k & 0x1) != 0)
      {
        bool = true;
        paramBluetoothGattCharacteristic.mPE = bool;
        ((g)localObject2).mPD.GE = ((paramArrayOfByte[1] & 0xFF) + ((paramArrayOfByte[2] & 0xFF) << 8));
        if ((k & 0x2) == 0) {
          break label3914;
        }
        ((g)localObject2).mPD.mPF = new g.a();
        paramBluetoothGattCharacteristic = ((g)localObject2).mPD.mPF;
        localObject1 = g.TAG;
        if (paramArrayOfByte != null) {
          break label1420;
        }
        i = 0;
        label1140:
        ad.d((String)localObject1, "data size = %d, offset = %d, lenght = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(7) });
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 10)) {
          break label1426;
        }
        ad.e(g.TAG, "data input error");
      }
      for (i = 10;; i = 3)
      {
        j = i;
        if ((k & 0x4) != 0)
        {
          ((g)localObject2).mPD.mOJ = (paramArrayOfByte[i] & 0xFF);
          j = i + 1;
        }
        if ((k & 0x8) != 0)
        {
          ((g)localObject2).mPD.mPG = ((paramArrayOfByte[j] & 0xFF) + ((paramArrayOfByte[(j + 1)] & 0xFF) << 8));
          i = j + 2;
          paramBluetoothGattCharacteristic = ((g)localObject2).mPD;
          j = paramArrayOfByte[i];
          paramBluetoothGattCharacteristic.mHeight = (((paramArrayOfByte[(i + 1)] & 0xFF) << 8) + (j & 0xFF));
        }
        localObject1 = g.TAG;
        if (((g)localObject2).mPD.mPE)
        {
          paramBluetoothGattCharacteristic = "lb&inch";
          i = ((g)localObject2).mPD.GE;
          if (((g)localObject2).mPD.mPF != null) {
            break label1591;
          }
        }
        for (paramArrayOfByte = "null";; paramArrayOfByte = "object")
        {
          ad.d((String)localObject1, "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d", new Object[] { paramBluetoothGattCharacteristic, Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(((g)localObject2).mPD.mOJ), Integer.valueOf(((g)localObject2).mPD.mPG), Integer.valueOf(((g)localObject2).mPD.mHeight) });
          break;
          bool = false;
          break label1066;
          i = paramArrayOfByte.length;
          break label1140;
          paramBluetoothGattCharacteristic.mYear = ((paramArrayOfByte[3] & 0xFF) + ((paramArrayOfByte[4] & 0xFF) << 8));
          paramBluetoothGattCharacteristic.mMonth = (paramArrayOfByte[5] & 0xFF);
          paramBluetoothGattCharacteristic.mDay = (paramArrayOfByte[6] & 0xFF);
          paramBluetoothGattCharacteristic.mOQ = (paramArrayOfByte[7] & 0xFF);
          paramBluetoothGattCharacteristic.mOR = (paramArrayOfByte[8] & 0xFF);
          paramBluetoothGattCharacteristic.mOS = (paramArrayOfByte[9] & 0xFF);
          ad.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[] { Integer.valueOf(paramBluetoothGattCharacteristic.mYear), Integer.valueOf(paramBluetoothGattCharacteristic.mMonth), Integer.valueOf(paramBluetoothGattCharacteristic.mDay), Integer.valueOf(paramBluetoothGattCharacteristic.mOQ), Integer.valueOf(paramBluetoothGattCharacteristic.mOR), Integer.valueOf(paramBluetoothGattCharacteristic.mOS) });
          break label1194;
          paramBluetoothGattCharacteristic = "kg&meter";
          break label1317;
        }
        ad.e(TAG, "parse weight scale data error");
        paramBluetoothGattCharacteristic = null;
        break;
        int m;
        if ((0L != (0x4 & l)) && ((((String)localObject1).equalsIgnoreCase(d.mOv)) || (((String)localObject1).equalsIgnoreCase(d.mOU)) || (((String)localObject1).equalsIgnoreCase(d.mOV))))
        {
          paramBluetoothGattCharacteristic = new d();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null)) {
            ad.e(d.TAG, "characteristicUuid or data is null");
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cU(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.mOt = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(d.mOv))
              {
                if (paramArrayOfByte.length < 2)
                {
                  ad.e(d.TAG, "Received data length is not right:".concat(String.valueOf(k)));
                  continue;
                }
                paramBluetoothGattCharacteristic.mPc = new d.a(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                ad.d(d.TAG, "flag=".concat(String.valueOf(m)));
                if (((m & 0x1) == 1) && (k >= 3))
                {
                  ad.d(d.TAG, "Value Format = uint16");
                  i = paramArrayOfByte[2];
                  paramBluetoothGattCharacteristic.mPc.mPd = ((i << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[1] & 0xFF));
                  i = 3;
                  ad.v(d.TAG, "Data received from HR " + paramBluetoothGattCharacteristic.mPc.mPd);
                  if ((m & 0x6) != 4) {
                    break label2153;
                  }
                  ad.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                  paramBluetoothGattCharacteristic.mPc.mPe = 1;
                  j = i;
                  if ((m & 0x8) == 8)
                  {
                    j = i;
                    if (k >= i + 2)
                    {
                      ad.d(d.TAG, "Energy Expend Present");
                      j = paramArrayOfByte[(i + 1)] << 8 & 0xFF00;
                      paramBluetoothGattCharacteristic.mPc.mPf = ((paramArrayOfByte[i] & 0xFF) + (j & 0xFF00));
                      ad.v("H7ConnectThread", "energyExp from HR energyExph " + j + " " + paramBluetoothGattCharacteristic.mPc.mPf);
                      j = i + 2;
                    }
                  }
                  if (((m & 0x10) == 16) && (k >= j + 2))
                  {
                    ad.d(d.TAG, "RR Interval Present");
                    i = (paramArrayOfByte[(j + 1)] & 0xFF) << 8;
                    paramBluetoothGattCharacteristic.mPc.mPg = ((paramArrayOfByte[j] & 0xFF) + (i & 0xFF00));
                    ad.v(d.TAG, "rrInterval from HR rrIntervalh" + i + " " + paramBluetoothGattCharacteristic.mPc.mPg);
                  }
                }
              }
              label2153:
              while (!paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(d.mOU)) {
                for (;;)
                {
                  i = 1;
                  break;
                  if (k >= 2)
                  {
                    ad.d(d.TAG, "Value Format = uint8");
                    paramBluetoothGattCharacteristic.mPc.mPd = (paramArrayOfByte[1] & 0xFF);
                    i = 2;
                  }
                  else
                  {
                    ad.d(d.TAG, "receive data error");
                    break;
                    if ((m & 0x6) == 6)
                    {
                      ad.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                      paramBluetoothGattCharacteristic.mPc.mPe = 2;
                    }
                    else
                    {
                      ad.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                      paramBluetoothGattCharacteristic.mPc.mPe = 0;
                    }
                  }
                }
              }
              switch (paramArrayOfByte[0])
              {
              default: 
                paramBluetoothGattCharacteristic.mPb = "Unknown";
              }
              for (;;)
              {
                ad.d(d.TAG, "position=" + paramBluetoothGattCharacteristic.mPb);
                break;
                paramBluetoothGattCharacteristic.mPb = "Other";
                continue;
                paramBluetoothGattCharacteristic.mPb = "Chest";
                continue;
                paramBluetoothGattCharacteristic.mPb = "Wrist";
                continue;
                paramBluetoothGattCharacteristic.mPb = "Finger";
                continue;
                paramBluetoothGattCharacteristic.mPb = "Hand";
                continue;
                paramBluetoothGattCharacteristic.mPb = "Ear Lobe";
                continue;
                paramBluetoothGattCharacteristic.mPb = "Foot";
              }
            }
          }
          ad.e(TAG, "parse heart rate data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (0x8 & l)) && ((((String)localObject1).equalsIgnoreCase(b.mOv)) || (((String)localObject1).equalsIgnoreCase(b.mOw)) || (((String)localObject1).equalsIgnoreCase(b.mOx))))
        {
          paramBluetoothGattCharacteristic = new b();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null))
          {
            ad.e(b.TAG, "characteristicUuid or data is null");
            i = j;
          }
          for (;;)
          {
            if (i != 0)
            {
              paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cU(paramBluetoothGattCharacteristic);
              break;
              paramBluetoothGattCharacteristic.mOt = ((String)localObject1);
              k = paramArrayOfByte.length;
              if (paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(b.mOv))
              {
                if (k < 7)
                {
                  ad.e(b.TAG, "data len is not right.");
                  i = j;
                  continue;
                }
                paramBluetoothGattCharacteristic.mOD = new b.b(paramBluetoothGattCharacteristic);
                m = paramArrayOfByte[0];
                ad.d(b.TAG, "flag=".concat(String.valueOf(m)));
                if ((m & 0x1) != 0)
                {
                  ad.d(b.TAG, "the value unit is kPa.");
                  paramBluetoothGattCharacteristic.mOD.mOG = true;
                  paramBluetoothGattCharacteristic.mOD.mON = b.O(paramArrayOfByte, 1);
                  paramBluetoothGattCharacteristic.mOD.mOO = b.O(paramArrayOfByte, 3);
                  paramBluetoothGattCharacteristic.mOD.mOP = b.O(paramArrayOfByte, 5);
                  i = 7;
                  if (((m & 0x2) == 0) || (k < 14)) {
                    break label2893;
                  }
                  ad.d(b.TAG, "TimeStamp Present.");
                  paramBluetoothGattCharacteristic.mOD.mOL.P(paramArrayOfByte, 7);
                  i = 14;
                  label2653:
                  if (((m & 0x4) == 0) || (k < i + 2)) {
                    break label2905;
                  }
                  ad.d(b.TAG, "PulseRate Present.");
                  paramBluetoothGattCharacteristic.mOD.mOI = ((int)b.O(paramArrayOfByte, i));
                  i += 2;
                  ad.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.mOD.mOI);
                  if ((m & 0x8) == 0) {
                    break label2917;
                  }
                  ad.d(b.TAG, "UserId Present.");
                  localObject1 = paramBluetoothGattCharacteristic.mOD;
                  j = i + 1;
                  ((b.b)localObject1).mOJ = paramArrayOfByte[i];
                  ad.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.mOD.mOJ);
                  i = j;
                  label2789:
                  if ((m & 0x10) == 0) {
                    break label2929;
                  }
                  ad.d(b.TAG, "MeasurementStatus Present.");
                  j = paramArrayOfByte[(i + 1)];
                  paramBluetoothGattCharacteristic.mOD.mOK = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                  ad.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.mOD.mOK);
                }
              }
              for (;;)
              {
                i = 1;
                break;
                ad.d(b.TAG, "the value unit is mmHg.");
                paramBluetoothGattCharacteristic.mOD.mOG = false;
                break label2574;
                ad.d(b.TAG, "TimeStamp not Present.");
                break label2653;
                label2905:
                ad.d(b.TAG, "PulseRate not Present.");
                break label2723;
                label2917:
                ad.d(b.TAG, "UserId not Present.");
                break label2789;
                label2929:
                ad.d(b.TAG, "MeasurementStatus not Present.");
                continue;
                if (paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(b.mOw))
                {
                  if (k < 3)
                  {
                    ad.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.mOE = new b.a(paramBluetoothGattCharacteristic);
                  m = paramArrayOfByte[0];
                  ad.d(b.TAG, "flag=".concat(String.valueOf(m)));
                  if ((m & 0x1) != 0)
                  {
                    ad.d(b.TAG, "the value unit is kPa.");
                    paramBluetoothGattCharacteristic.mOE.mOG = true;
                    label3032:
                    paramBluetoothGattCharacteristic.mOE.mOH = b.O(paramArrayOfByte, 1);
                    if (((m & 0x2) == 0) || (k < 10)) {
                      break label3321;
                    }
                    ad.d(b.TAG, "TimeStamp Present.");
                    paramBluetoothGattCharacteristic.mOE.mOL.P(paramArrayOfByte, 3);
                    i = 10;
                    if (((m & 0x4) == 0) || (k < i + 2)) {
                      break label3335;
                    }
                    ad.d(b.TAG, "PulseRate Present.");
                    paramBluetoothGattCharacteristic.mOE.mOI = ((int)b.O(paramArrayOfByte, i));
                    i += 2;
                    ad.d(b.TAG, "PulseRate =" + paramBluetoothGattCharacteristic.mOE.mOI);
                    label3153:
                    if ((m & 0x8) == 0) {
                      break label3347;
                    }
                    ad.d(b.TAG, "UserId Present.");
                    localObject1 = paramBluetoothGattCharacteristic.mOE;
                    j = i + 1;
                    ((b.a)localObject1).mOJ = paramArrayOfByte[i];
                    ad.d(b.TAG, "UserId = " + paramBluetoothGattCharacteristic.mOE.mOJ);
                    i = j;
                  }
                  for (;;)
                  {
                    if ((m & 0x10) == 0) {
                      break label3359;
                    }
                    ad.d(b.TAG, "MeasurementStatus Present.");
                    j = paramArrayOfByte[(i + 1)];
                    paramBluetoothGattCharacteristic.mOE.mOK = ((paramArrayOfByte[i] & 0xFF) + (j << 8 & 0xFF00 & 0xFF00));
                    ad.d(b.TAG, "MeasurementStatus = " + paramBluetoothGattCharacteristic.mOE.mOK);
                    break;
                    ad.d(b.TAG, "the value unit is mmHg.");
                    paramBluetoothGattCharacteristic.mOE.mOG = false;
                    break label3032;
                    label3321:
                    ad.d(b.TAG, "TimeStamp not Present.");
                    i = 3;
                    break label3083;
                    ad.d(b.TAG, "PulseRate not Present.");
                    break label3153;
                    ad.d(b.TAG, "UserId not Present.");
                  }
                  ad.d(b.TAG, "MeasurementStatus not Present.");
                  continue;
                }
                if (paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(b.mOx))
                {
                  ad.d(b.TAG, "Blood Pressure Feature Characteristic.");
                  if (k < 2)
                  {
                    ad.e(b.TAG, "data len is not right.");
                    i = j;
                    break;
                  }
                  paramBluetoothGattCharacteristic.mOF = ((paramArrayOfByte[1] << 8 & 0xFF00 & 0xFF00) + (paramArrayOfByte[0] & 0xFF));
                  ad.d(b.TAG, "bloodPressureFeatureParameters=" + paramBluetoothGattCharacteristic.mOF);
                }
              }
            }
          }
          ad.e(TAG, "parse blood pressure data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        if ((0L != (l & 0x10)) && ((((String)localObject1).equalsIgnoreCase(e.mPi)) || (((String)localObject1).equalsIgnoreCase(e.mPj)) || (((String)localObject1).equalsIgnoreCase(e.mPk)) || (((String)localObject1).equalsIgnoreCase(e.mPl))))
        {
          paramBluetoothGattCharacteristic = new e();
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (paramArrayOfByte == null))
          {
            ad.e(e.TAG, "characteristicUuid or data is null");
            i = k;
          }
          for (;;)
          {
            if (i == 0) {
              break label3877;
            }
            paramBluetoothGattCharacteristic = com.tencent.mm.plugin.exdevice.k.b.cU(paramBluetoothGattCharacteristic);
            break;
            paramBluetoothGattCharacteristic.mOt = ((String)localObject1);
            if (paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(e.mPi))
            {
              if (paramArrayOfByte.length != 3)
              {
                ad.e(e.TAG, "Data length incorrect");
                i = k;
              }
              else
              {
                paramBluetoothGattCharacteristic.mPm = paramArrayOfByte[0];
                paramBluetoothGattCharacteristic.mPn = paramArrayOfByte[1];
                paramBluetoothGattCharacteristic.mPo = paramArrayOfByte[2];
              }
            }
            else
            {
              for (;;)
              {
                i = 1;
                break;
                if (paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(e.mPj))
                {
                  if (paramArrayOfByte.length != 1)
                  {
                    ad.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.mPp = paramArrayOfByte[0];
                  continue;
                }
                if (paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(e.mPk))
                {
                  if (paramArrayOfByte.length < 2)
                  {
                    ad.e(e.TAG, "Data length incorrect");
                    i = k;
                    break;
                  }
                  paramBluetoothGattCharacteristic.mPq[0] = paramArrayOfByte[0];
                  paramBluetoothGattCharacteristic.mPq[1] = paramArrayOfByte[1];
                  continue;
                }
                if (!paramBluetoothGattCharacteristic.mOt.equalsIgnoreCase(e.mPl)) {
                  break label3862;
                }
                if (paramArrayOfByte.length < 4)
                {
                  ad.e(e.TAG, "Data length incorrect");
                  i = k;
                  break;
                }
                paramBluetoothGattCharacteristic.mPr = ((paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8));
                paramBluetoothGattCharacteristic.mPt = paramArrayOfByte[2];
                paramBluetoothGattCharacteristic.mPs = paramArrayOfByte[3];
                if (paramArrayOfByte.length > 4)
                {
                  paramBluetoothGattCharacteristic.mPu = new byte[paramArrayOfByte.length - 4];
                  System.arraycopy(paramArrayOfByte, 4, paramBluetoothGattCharacteristic.mPu, 0, paramArrayOfByte.length - 4);
                }
                else
                {
                  paramBluetoothGattCharacteristic.mPu = null;
                }
              }
              ad.e(e.TAG, "characteristicUuid is incorrect");
              i = k;
            }
          }
          ad.e(TAG, "parse light data error");
          paramBluetoothGattCharacteristic = null;
          break;
        }
        ad.e(TAG, "unknown characteristic uuid = %s", new Object[] { localObject1 });
        paramBluetoothGattCharacteristic = null;
        break;
      }
    }
  }
  
  public static boolean aI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22573);
    if (bt.cw(paramArrayOfByte))
    {
      ad.e(TAG, "parseBroadcastServiceUuid error. broadcast data is null or nil");
      AppMethodBeat.o(22573);
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
        ad.w(TAG, "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(22573);
        return false;
      }
      if (i <= 0)
      {
        ad.w(TAG, "current part of data's len = %d.", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(22573);
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
          ad.d(TAG, "find 16-bit broacast service = %s", new Object[] { localObject });
          if (mNM.containsKey(localObject))
          {
            AppMethodBeat.o(22573);
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
            ad.d(TAG, "find 128-bit broacast service = %s", new Object[] { localObject });
            boolean bool = mNM.containsKey(localObject);
            if (!bool) {
              break;
            }
            return true;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            ad.e("BlueToothDeviceFilter.parseUUID", localIndexOutOfBoundsException.toString());
            j += 16;
            i -= 16;
          }
          finally
          {
            AppMethodBeat.o(22573);
          }
        }
      }
      i = j + i;
      break;
      ad.i(TAG, "Manufacturer Specific Data size = %s", new Object[] { Integer.valueOf(m) });
      ad.i(TAG, "Manufacturer Specific Data = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.be(Arrays.copyOfRange(paramArrayOfByte, j, j + m)) });
      break label204;
      AppMethodBeat.o(22573);
      return false;
      i = m;
    }
  }
  
  public static boolean b(BluetoothGattService paramBluetoothGattService)
  {
    AppMethodBeat.i(22576);
    if (paramBluetoothGattService == null)
    {
      ad.e(TAG, "service is null");
      AppMethodBeat.o(22576);
      return false;
    }
    long l = a(paramBluetoothGattService);
    BluetoothGattCharacteristic localBluetoothGattCharacteristic;
    int i;
    if (0L != (1L & l))
    {
      if (paramBluetoothGattService == null)
      {
        ad.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOb));
      if (localBluetoothGattCharacteristic == null)
      {
        ad.e(TAG, "no step measurement characteristic found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      ad.d(TAG, "step measurement characteristic properties = %d", new Object[] { Integer.valueOf(i) });
      if (((i & 0x30) == 0) || ((i & 0x2) == 0))
      {
        ad.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOc));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if (((i & 0x2) == 0) || ((i & 0x20) == 0))
        {
          ad.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      AppMethodBeat.o(22576);
      return true;
    }
    if (0L != (0x2 & l))
    {
      if (paramBluetoothGattService == null)
      {
        ad.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOi));
      if (localBluetoothGattCharacteristic == null)
      {
        ad.e(TAG, "weight scale feature characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x2) == 0)
      {
        ad.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOj));
      if (paramBluetoothGattService == null)
      {
        ad.e(TAG, "weight measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = paramBluetoothGattService.getProperties();
      if ((i & 0x20) == 0)
      {
        ad.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      AppMethodBeat.o(22576);
      return true;
    }
    if (0L != (0x4 & l))
    {
      if (paramBluetoothGattService == null)
      {
        ad.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOl));
      if (localBluetoothGattCharacteristic == null)
      {
        ad.e(TAG, "heart rate measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x10) == 0)
      {
        ad.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOm));
      if (localBluetoothGattCharacteristic != null)
      {
        i = localBluetoothGattCharacteristic.getProperties();
        if ((i & 0x2) == 0)
        {
          ad.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOn));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x8) == 0)
        {
          ad.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(8) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      AppMethodBeat.o(22576);
      return true;
    }
    if (0L != (0x8 & l))
    {
      if (paramBluetoothGattService == null)
      {
        ad.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOp));
      if (localBluetoothGattCharacteristic == null)
      {
        ad.e(TAG, "blood pressure measurement characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x20) == 0)
      {
        ad.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOr));
      if (localBluetoothGattCharacteristic == null)
      {
        ad.e(TAG, "blood pressure feature characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x2) == 0)
      {
        ad.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOq));
      if (paramBluetoothGattService != null)
      {
        i = paramBluetoothGattService.getProperties();
        if ((i & 0x10) == 0)
        {
          ad.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(16) });
          AppMethodBeat.o(22576);
          return false;
        }
      }
      AppMethodBeat.o(22576);
      return true;
    }
    if (0L != (l & 0x10))
    {
      if (paramBluetoothGattService == null)
      {
        ad.e(TAG, "service is null");
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOd));
      if (localBluetoothGattCharacteristic == null)
      {
        ad.e(TAG, "light color characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x10) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
      {
        ad.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOe));
      if (localBluetoothGattCharacteristic == null)
      {
        ad.e(TAG, "light work state characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x2) == 0) || ((i & 0x8) == 0))
      {
        ad.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOf));
      if (localBluetoothGattCharacteristic == null)
      {
        ad.e(TAG, "light state changed characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = localBluetoothGattCharacteristic.getProperties();
      if ((i & 0x20) == 0)
      {
        ad.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      paramBluetoothGattService = paramBluetoothGattService.getCharacteristic(UUID.fromString(h.mOg));
      if (paramBluetoothGattService == null)
      {
        ad.e(TAG, "control point characteristic not found");
        AppMethodBeat.o(22576);
        return false;
      }
      i = paramBluetoothGattService.getProperties();
      if (((i & 0x20) == 0) || ((i & 0x8) == 0))
      {
        ad.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[] { Integer.valueOf(i), Integer.valueOf(32) });
        AppMethodBeat.o(22576);
        return false;
      }
      AppMethodBeat.o(22576);
      return true;
    }
    AppMethodBeat.o(22576);
    return false;
  }
  
  public static String nw(long paramLong)
  {
    AppMethodBeat.i(22574);
    Object localObject = mNM.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (((Long)mNM.get(str)).longValue() == paramLong)
      {
        AppMethodBeat.o(22574);
        return str;
      }
    }
    if (mOT.containsValue(Long.valueOf(paramLong)))
    {
      localObject = h.mNY;
      AppMethodBeat.o(22574);
      return localObject;
    }
    AppMethodBeat.o(22574);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */