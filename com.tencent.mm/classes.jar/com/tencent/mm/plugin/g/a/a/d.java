package com.tencent.mm.plugin.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import junit.framework.Assert;

public final class d
{
  private final HashMap<c, Vector<Integer>> bIx;
  private b vtY;
  
  public d(b paramb)
  {
    AppMethodBeat.i(22439);
    this.bIx = new HashMap();
    this.vtY = null;
    this.vtY = paramb;
    AppMethodBeat.o(22439);
  }
  
  private void a(Vector<Integer> paramVector, c paramc)
  {
    AppMethodBeat.i(22441);
    Log.i("MicroMsg.exdevie.IBeaconManager", "calDistance");
    Object localObject = new int[paramVector.size()];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((Integer)paramVector.elementAt(i)).intValue();
      i += 1;
    }
    paramVector = new a((int[])localObject);
    if (1 == paramVector.vtT.length)
    {
      Log.d("MicroMsg.exdevice.GaussianFilter", "data group length = 1, no need to filter, just return");
      paramVector = paramVector.vtT;
    }
    while ((paramVector == null) || (paramVector.length == 0))
    {
      paramVector = new NullPointerException("null == ret || 0 == ret.length");
      AppMethodBeat.o(22441);
      throw paramVector;
      localObject = new StringBuilder("");
      ((StringBuilder)localObject).append("Data Before GaussianFilter \r\n");
      i = 0;
      while (i < paramVector.vtT.length)
      {
        ((StringBuilder)localObject).append(" " + paramVector.vtT[i]);
        i += 1;
      }
      Log.d("MicroMsg.exdevice.GaussianFilter", ((StringBuilder)localObject).toString());
      d1 = i.z(paramVector.vtT);
      d2 = i.A(paramVector.vtT);
      d3 = i.l(0.15D, d2).add(new BigDecimal(d1)).doubleValue();
      double d4 = i.l(3.09D, d2).add(new BigDecimal(d1)).doubleValue();
      Log.d("MicroMsg.exdevice.GaussianFilter", "Mean = " + d1 + "SD = " + d2 + "LowerLimit = " + d3 + " UpperLimit = " + d4);
      i = 0;
      localObject = new int[paramVector.vtT.length];
      int j = 0;
      while (j < paramVector.vtT.length)
      {
        int k = i;
        if (paramVector.vtT[j] >= d3)
        {
          k = i;
          if (paramVector.vtT[j] <= d4)
          {
            localObject[i] = paramVector.vtT[j];
            k = i + 1;
          }
        }
        j += 1;
        i = k;
      }
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        paramVector = new int[i];
        j = 0;
        while (j < i)
        {
          paramVector[j] = localObject[j];
          j += 1;
        }
      }
      localObject = new StringBuilder("");
      ((StringBuilder)localObject).append("Data After GaussianFilter \r\n");
      i = 0;
      while (i < paramVector.length)
      {
        ((StringBuilder)localObject).append(" " + paramVector[i]);
        i += 1;
      }
      Log.d("MicroMsg.exdevice.GaussianFilter", ((StringBuilder)localObject).toString());
    }
    double d2 = i.z(paramVector);
    paramc.vtW = new BigDecimal(d2).divide(new BigDecimal(1), 3, 4).doubleValue();
    double d3 = paramc.vtV.vua.vuE;
    double d1 = 1.0D * d2 / d3;
    if (d1 < 1.0D) {}
    for (d1 = Math.pow(d1, 10.0D);; d1 = Math.pow(d1, 9.9476D) * 0.92093D + 0.54992D)
    {
      Log.i("MicroMsg.exdevie.IBeaconManager", "txPower = %f , rssi = %f,distance = %f", new Object[] { Double.valueOf(d3), Double.valueOf(d2), Double.valueOf(d1) });
      this.vtY.a(d1, paramc);
      AppMethodBeat.o(22441);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString, e parame)
  {
    AppMethodBeat.i(22440);
    Log.i("MicroMsg.exdevie.IBeaconManager", "advertismentProcess, brand = %s, rssi = %d", new Object[] { null, Integer.valueOf(paramInt) });
    if (parame == null)
    {
      Log.e("MicroMsg.exdevie.IBeaconManager", "null == aProtocal");
      AppMethodBeat.o(22440);
      return;
    }
    c localc = new c();
    localc.vtU = null;
    localc.vtV = parame;
    localc.vtX = paramString;
    if (!this.bIx.containsKey(localc))
    {
      paramString = new Vector();
      paramString.add(Integer.valueOf(paramInt));
      this.bIx.put(localc, paramString);
      AppMethodBeat.o(22440);
      return;
    }
    paramString = (Vector)this.bIx.get(localc);
    paramString.add(Integer.valueOf(paramInt));
    if (1 <= paramString.size()) {
      try
      {
        a(paramString, localc);
        return;
      }
      catch (Exception parame)
      {
        Log.e("MicroMsg.exdevie.IBeaconManager", "calDistance failed!!!, %s", new Object[] { parame.getMessage() });
        return;
      }
      finally
      {
        paramString.clear();
        AppMethodBeat.o(22440);
      }
    }
    AppMethodBeat.o(22440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.a.d
 * JD-Core Version:    0.7.0.1
 */