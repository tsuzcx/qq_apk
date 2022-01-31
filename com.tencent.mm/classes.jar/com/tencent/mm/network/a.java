package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends d.a
  implements c
{
  byte[] cKp;
  private boolean foreground;
  private byte[] gcZ;
  private byte[] gda;
  private byte[] gdb;
  private a.b gdc;
  byte[] gdd;
  String gde;
  private Map<String, byte[]> gdf;
  private Map<Integer, avk> gdg;
  private Map<avj, a.a> gdh;
  List<String> gdi;
  private int uin;
  String username;
  
  public a(a.b paramb)
  {
    AppMethodBeat.i(58438);
    this.gdc = null;
    this.foreground = false;
    this.gdf = new HashMap();
    this.gdg = new HashMap();
    this.gdh = new HashMap();
    this.gdi = new ArrayList();
    this.gdc = paramb;
    and();
    AppMethodBeat.o(58438);
  }
  
  private void and()
  {
    AppMethodBeat.i(58440);
    this.cKp = bo.apQ(ay.aaF().getString("server_id", ""));
    AppMethodBeat.o(58440);
  }
  
  private String ane()
  {
    AppMethodBeat.i(58446);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.gcZ).put(this.gda).put(this.gdb).put(this.gdd).put(this.cKp).putInt(this.uin).put(this.gde.getBytes()).put(this.username.getBytes());
      localObject = g.w(((ByteBuffer)localObject).array());
      AppMethodBeat.o(58446);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(58446);
    }
    return "";
  }
  
  private void clear()
  {
    this.username = null;
    this.gcZ = null;
    this.gda = null;
    this.gdb = null;
    this.cKp = null;
    this.uin = 0;
    this.gdd = null;
    this.gde = null;
  }
  
  public final int R(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58448);
    long l = bo.aoy();
    if (adC())
    {
      ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
      AppMethodBeat.o(58448);
      return -2;
    }
    try
    {
      y localy = new y();
      int i = localy.ca(paramArrayOfByte);
      if (i != 0)
      {
        ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(58448);
        return -3;
      }
      this.username = localy.getString();
      this.gde = localy.getString();
      this.uin = localy.getInt();
      this.cKp = localy.getBuffer();
      this.gdd = localy.getBuffer();
      this.gcZ = localy.getBuffer();
      this.gda = localy.getBuffer();
      this.gdb = localy.getBuffer();
      paramArrayOfByte = localy.getString();
      if ((bo.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(ane())))
      {
        clear();
        ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(58448);
        return -4;
      }
      ab.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(bo.hl(l)), paramArrayOfByte });
      AppMethodBeat.o(58448);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bo.l(paramArrayOfByte) });
      AppMethodBeat.o(58448);
    }
    return -5;
  }
  
  public final void Y(byte[] paramArrayOfByte)
  {
    this.cKp = paramArrayOfByte;
  }
  
  public final void Z(byte[] paramArrayOfByte)
  {
    this.gdd = paramArrayOfByte;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(58441);
    ab.i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", new Object[] { bo.aqg(bo.cd(paramArrayOfByte1)), bo.aqg(bo.cd(paramArrayOfByte2)), bo.aqg(bo.cd(paramArrayOfByte3)), Integer.valueOf(this.uin), Integer.valueOf(paramInt), bo.dtY() });
    this.gcZ = paramArrayOfByte1;
    this.gda = paramArrayOfByte2;
    this.gdb = paramArrayOfByte3;
    this.uin = paramInt;
    if (this.gdc != null) {
      adC();
    }
    AppMethodBeat.o(58441);
  }
  
  public final void aa(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154738);
    this.gdi.add(new String(paramArrayOfByte));
    AppMethodBeat.o(154738);
  }
  
  public final boolean ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154739);
    boolean bool = this.gdi.contains(new String(paramArrayOfByte));
    AppMethodBeat.o(154739);
    return bool;
  }
  
  public final byte[] adB()
  {
    return this.cKp;
  }
  
  public final boolean adC()
  {
    return (this.gcZ != null) && (this.gda != null) && (this.gdb != null) && (this.gcZ.length > 0) && (this.gda.length > 0) && (this.gdb.length > 0);
  }
  
  public final byte[] adD()
  {
    return this.gdd;
  }
  
  public final String adE()
  {
    return this.gde;
  }
  
  public final byte[] adF()
  {
    AppMethodBeat.i(58447);
    long l = bo.aoy();
    int i;
    if (bo.isNullOrNil(this.username)) {
      i = 0;
    }
    while (i == 0)
    {
      ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
      AppMethodBeat.o(58447);
      return null;
      if (bo.ce(this.gcZ)) {
        i = 0;
      } else if (bo.ce(this.gda)) {
        i = 0;
      } else if (bo.ce(this.gdb)) {
        i = 0;
      } else if (bo.ce(this.cKp)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (bo.ce(this.gdd)) {
        i = 0;
      } else if (bo.isNullOrNil(this.gde)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    try
    {
      Object localObject = new y();
      ((y)localObject).dsv();
      ((y)localObject).ape(this.username);
      ((y)localObject).ape(this.gde);
      ((y)localObject).Nd(this.uin);
      ((y)localObject).cb(this.cKp);
      ((y)localObject).cb(this.gdd);
      ((y)localObject).cb(this.gcZ);
      ((y)localObject).cb(this.gda);
      ((y)localObject).cb(this.gdb);
      String str = ane();
      ((y)localObject).ape(str);
      localObject = ((y)localObject).dsw();
      ab.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[] { Long.valueOf(bo.hl(l)), Integer.valueOf(localObject.length), str });
      AppMethodBeat.o(58447);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58447);
    }
    return null;
  }
  
  public final void adG()
  {
    AppMethodBeat.i(154734);
    this.gdh.clear();
    AppMethodBeat.o(154734);
  }
  
  public final void adH()
  {
    AppMethodBeat.i(154735);
    ab.d("MicroMsg.AccInfo", "clearAxHost");
    this.gdg.clear();
    AppMethodBeat.o(154735);
  }
  
  public final void anf()
  {
    AppMethodBeat.i(154733);
    if ((this.gda != null) || (this.gdb != null) || (!this.gdh.isEmpty()))
    {
      this.gda = null;
      this.gdb = null;
      this.gdh.clear();
    }
    AppMethodBeat.o(154733);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(154732);
    ab.d("MicroMsg.AccInfo", "setAxAuthSessionKey");
    Object localObject = (avk)this.gdg.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((avk)localObject).jJv.size() == 0))
    {
      ab.d("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(154732);
      return;
    }
    gj localgj = new gj();
    try
    {
      localgj.parseFrom(paramArrayOfByte1);
      paramArrayOfByte1 = new a.a(this);
      paramArrayOfByte1.gdj = localgj;
      paramArrayOfByte1.gdk = paramArrayOfByte2;
      paramArrayOfByte2 = ((avk)localObject).jJv.iterator();
      while (paramArrayOfByte2.hasNext())
      {
        localObject = (avj)paramArrayOfByte2.next();
        this.gdh.put(localObject, paramArrayOfByte1);
      }
      AppMethodBeat.o(154732);
    }
    catch (Exception paramArrayOfByte1)
    {
      ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bo.l(paramArrayOfByte1) });
      AppMethodBeat.o(154732);
      return;
    }
  }
  
  public final void cP(boolean paramBoolean)
  {
    AppMethodBeat.i(58445);
    this.foreground = paramBoolean;
    ab.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", new Object[] { Boolean.valueOf(this.foreground) });
    AppMethodBeat.o(58445);
  }
  
  public final void g(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154731);
    avk localavk = new avk();
    try
    {
      localavk.parseFrom(paramArrayOfByte);
      this.gdg.put(Integer.valueOf(paramInt), localavk);
      ab.d("MicroMsg.AccInfo", "add host " + paramInt + " host " + ((avj)localavk.jJv.get(0)).xkP);
      AppMethodBeat.o(154731);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.AccInfo", "exception:%s", new Object[] { bo.l(paramArrayOfByte) });
      AppMethodBeat.o(154731);
    }
  }
  
  public final int getUin()
  {
    return this.uin;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public final boolean isForeground()
  {
    return this.foreground;
  }
  
  public final byte[] jN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.gcZ;
    case 2: 
      return this.gda;
    }
    return this.gdb;
  }
  
  public final void o(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58443);
    this.gdf.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(58443);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(58439);
    ab.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.gcZ = null;
    and();
    this.uin = 0;
    this.gda = null;
    this.gdb = null;
    AppMethodBeat.o(58439);
  }
  
  public final byte[] rm(String paramString)
  {
    AppMethodBeat.i(58444);
    paramString = (byte[])this.gdf.get(paramString);
    AppMethodBeat.o(58444);
    return paramString;
  }
  
  public final byte[] rn(String paramString)
  {
    AppMethodBeat.i(154737);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(154737);
      return null;
    }
    Iterator localIterator = this.gdh.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((avj)localEntry.getKey()).xkQ));
    for (paramString = ((a.a)localEntry.getValue()).gdk;; paramString = null)
    {
      AppMethodBeat.o(154737);
      return paramString;
    }
  }
  
  public final byte[] ro(String paramString)
  {
    AppMethodBeat.i(154742);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(154742);
      return null;
    }
    Iterator localIterator = this.gdh.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((avj)localEntry.getKey()).xkQ));
    for (paramString = ((a.a)localEntry.getValue()).gdj;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.wsc.getBufferToBytes();
          AppMethodBeat.o(154742);
          return paramString;
        }
        catch (Exception paramString)
        {
          ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bo.l(paramString) });
          AppMethodBeat.o(154742);
          return null;
        }
      }
      AppMethodBeat.o(154742);
      return null;
    }
  }
  
  public final byte[] rp(String paramString)
  {
    AppMethodBeat.i(154743);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(154743);
      return null;
    }
    Iterator localIterator = this.gdh.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((avj)localEntry.getKey()).xkQ));
    for (paramString = ((a.a)localEntry.getValue()).gdj;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.wsd.getBufferToBytes();
          AppMethodBeat.o(154743);
          return paramString;
        }
        catch (Exception paramString)
        {
          ab.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bo.l(paramString) });
          AppMethodBeat.o(154743);
          return null;
        }
      }
      AppMethodBeat.o(154743);
      return null;
    }
  }
  
  public final boolean rq(String paramString)
  {
    AppMethodBeat.i(154736);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(154736);
      return false;
    }
    avj localavj;
    do
    {
      Iterator localIterator = this.gdg.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (avk)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject == null) || (((avk)localObject).jJv == null));
        localObject = ((avk)localObject).jJv.iterator();
      }
      localavj = (avj)((Iterator)localObject).next();
    } while ((localavj == null) || (!paramString.equals(localavj.xkQ)));
    AppMethodBeat.o(154736);
    return true;
    AppMethodBeat.o(154736);
    return false;
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(58449);
    ab.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(paramInt), bo.dtY() });
    this.uin = paramInt;
    AppMethodBeat.o(58449);
  }
  
  public final void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58442);
    String str = "AccInfo:\n" + "|-uin     =" + getUin() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-wxuser  =" + adE() + "\n";
    str = str + "|-wxuser  =" + adE() + "\n";
    str = str + "|-singlesession =" + bo.cd(jN(1)) + "\n";
    str = str + "|-clientsession =" + bo.cd(jN(2)) + "\n";
    str = str + "|-serversession =" + bo.cd(jN(3)) + "\n";
    str = str + "|-ecdhkey =" + bo.cd(adD()) + "\n";
    str = str + "`-cookie  =" + bo.cd(adB());
    AppMethodBeat.o(58442);
    return str;
  }
  
  public final void vY(String paramString)
  {
    this.gde = paramString;
  }
  
  public final boolean vZ(String paramString)
  {
    AppMethodBeat.i(154740);
    if ("axhost".equals(paramString))
    {
      bool = this.gdg.isEmpty();
      AppMethodBeat.o(154740);
      return bool;
    }
    boolean bool = this.gdi.isEmpty();
    AppMethodBeat.o(154740);
    return bool;
  }
  
  public final boolean wa(String paramString)
  {
    AppMethodBeat.i(154741);
    if (!rq(paramString))
    {
      AppMethodBeat.o(154741);
      return false;
    }
    byte[] arrayOfByte = ro(paramString);
    paramString = rp(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (paramString != null) && (paramString.length > 0))
    {
      AppMethodBeat.o(154741);
      return true;
    }
    AppMethodBeat.o(154741);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */