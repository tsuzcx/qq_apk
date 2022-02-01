package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.bk;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends f.a
  implements e
{
  private static b.a pnu;
  private boolean foreground;
  String hLv;
  byte[] ieJ;
  private byte[] pnl;
  private byte[] pnm;
  private byte[] pnn;
  private b pno;
  byte[] pnp;
  private Map<String, byte[]> pnq;
  private Map<Integer, dal> pnr;
  private Map<dak, a> pns;
  List<String> pnt;
  private int uin;
  String username;
  
  static
  {
    AppMethodBeat.i(241181);
    pnu = new b.a();
    AppMethodBeat.o(241181);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(132629);
    this.pno = null;
    this.foreground = false;
    this.pnq = new HashMap();
    this.pnr = new HashMap();
    this.pns = new HashMap();
    this.pnt = new ArrayList();
    this.pno = paramb;
    bQA();
    AppMethodBeat.o(132629);
  }
  
  public static String[] bGk()
  {
    AppMethodBeat.i(241177);
    String[] arrayOfString = new String[2];
    if (pnu != null)
    {
      arrayOfString[0] = pnu.pnA;
      arrayOfString[1] = pnu.pnz;
      AppMethodBeat.o(241177);
      return arrayOfString;
    }
    Log.e("MicroMsg.AccInfo", "no find cgi sign keys");
    AppMethodBeat.o(241177);
    return arrayOfString;
  }
  
  private void bQA()
  {
    AppMethodBeat.i(132631);
    this.ieJ = Util.decodeHexString(bk.bCE().getString("server_id", ""));
    AppMethodBeat.o(132631);
  }
  
  private String bQB()
  {
    AppMethodBeat.i(132637);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.pnl).put(this.pnm).put(this.pnn).put(this.pnp).put(this.ieJ).putInt(this.uin).put(this.hLv.getBytes()).put(this.username.getBytes());
      localObject = g.getMessageDigest(((ByteBuffer)localObject).array());
      AppMethodBeat.o(132637);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(132637);
    }
    return "";
  }
  
  public static void bY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241174);
    try
    {
      Log.i("MicroMsg.AccInfo", "saveBackUpCgiSignKeys " + paramString1.length() + " " + paramString2.length());
      pnu.pnA = paramString1;
      pnu.pnz = paramString2;
      AppMethodBeat.o(241174);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.AccInfo", paramString1.getLocalizedMessage());
      AppMethodBeat.o(241174);
    }
  }
  
  private void clear()
  {
    this.username = null;
    this.pnl = null;
    this.pnm = null;
    this.pnn = null;
    this.ieJ = null;
    this.uin = 0;
    this.pnp = null;
    this.hLv = null;
  }
  
  public final byte[] LW(String paramString)
  {
    AppMethodBeat.i(132635);
    paramString = (byte[])this.pnq.get(paramString);
    AppMethodBeat.o(132635);
    return paramString;
  }
  
  public final byte[] LX(String paramString)
  {
    AppMethodBeat.i(132647);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132647);
      return null;
    }
    Iterator localIterator = this.pns.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((dak)localEntry.getKey()).aaFX));
    for (paramString = ((a)localEntry.getValue()).pnw;; paramString = null)
    {
      AppMethodBeat.o(132647);
      return paramString;
    }
  }
  
  public final byte[] LY(String paramString)
  {
    AppMethodBeat.i(132652);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132652);
      return null;
    }
    Iterator localIterator = this.pns.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((dak)localEntry.getKey()).aaFX));
    for (paramString = ((a)localEntry.getValue()).pnv;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.YJA.aaxD.Op;
          AppMethodBeat.o(132652);
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          AppMethodBeat.o(132652);
          return null;
        }
      }
      AppMethodBeat.o(132652);
      return null;
    }
  }
  
  public final byte[] LZ(String paramString)
  {
    AppMethodBeat.i(132653);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132653);
      return null;
    }
    Iterator localIterator = this.pns.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((dak)localEntry.getKey()).aaFX));
    for (paramString = ((a)localEntry.getValue()).pnv;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.YJB.aaxD.Op;
          AppMethodBeat.o(132653);
          return paramString;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          AppMethodBeat.o(132653);
          return null;
        }
      }
      AppMethodBeat.o(132653);
      return null;
    }
  }
  
  public final boolean Ma(String paramString)
  {
    AppMethodBeat.i(132646);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132646);
      return false;
    }
    dak localdak;
    do
    {
      Iterator localIterator = this.pnr.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (dal)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject == null) || (((dal)localObject).vgO == null));
        localObject = ((dal)localObject).vgO.iterator();
      }
      localdak = (dak)((Iterator)localObject).next();
    } while ((localdak == null) || (!paramString.equals(localdak.aaFX)));
    AppMethodBeat.o(132646);
    return true;
    AppMethodBeat.o(132646);
    return false;
  }
  
  public final void Rp(String paramString)
  {
    this.hLv = paramString;
  }
  
  public final boolean Rq(String paramString)
  {
    AppMethodBeat.i(132650);
    if ("axhost".equals(paramString))
    {
      bool = this.pnr.isEmpty();
      AppMethodBeat.o(132650);
      return bool;
    }
    boolean bool = this.pnt.isEmpty();
    AppMethodBeat.o(132650);
    return bool;
  }
  
  public final boolean Rr(String paramString)
  {
    AppMethodBeat.i(132651);
    if (!Ma(paramString))
    {
      AppMethodBeat.o(132651);
      return false;
    }
    byte[] arrayOfByte = LY(paramString);
    paramString = LZ(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (paramString != null) && (paramString.length > 0))
    {
      AppMethodBeat.o(132651);
      return true;
    }
    AppMethodBeat.o(132651);
    return false;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132632);
    Log.i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", new Object[] { Util.secPrint(Util.dumpHex(paramArrayOfByte1)), Util.secPrint(Util.dumpHex(paramArrayOfByte2)), Util.secPrint(Util.dumpHex(paramArrayOfByte3)), Integer.valueOf(this.uin), Integer.valueOf(paramInt), Util.getStack() });
    this.pnl = paramArrayOfByte1;
    this.pnm = paramArrayOfByte2;
    this.pnn = paramArrayOfByte3;
    this.uin = paramInt;
    if (this.pno != null) {
      bGa();
    }
    AppMethodBeat.o(132632);
  }
  
  public final void aG(byte[] paramArrayOfByte)
  {
    this.ieJ = paramArrayOfByte;
  }
  
  public final void aH(byte[] paramArrayOfByte)
  {
    this.pnp = paramArrayOfByte;
  }
  
  public final void aI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132648);
    this.pnt.add(new String(paramArrayOfByte));
    AppMethodBeat.o(132648);
  }
  
  public final boolean aJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132649);
    boolean bool = this.pnt.contains(new String(paramArrayOfByte));
    AppMethodBeat.o(132649);
    return bool;
  }
  
  public final int av(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132639);
    long l = Util.nowMilliSecond();
    if (bGa())
    {
      Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
      AppMethodBeat.o(132639);
      return -2;
    }
    try
    {
      LVBuffer localLVBuffer = new LVBuffer();
      int i = localLVBuffer.initParse(paramArrayOfByte);
      if (i != 0)
      {
        Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(132639);
        return -3;
      }
      this.username = localLVBuffer.getString();
      this.hLv = localLVBuffer.getString();
      this.uin = localLVBuffer.getInt();
      this.ieJ = localLVBuffer.getBuffer();
      this.pnp = localLVBuffer.getBuffer();
      this.pnl = localLVBuffer.getBuffer();
      this.pnm = localLVBuffer.getBuffer();
      this.pnn = localLVBuffer.getBuffer();
      pnu.pnA = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      pnu.pnz = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      Log.i("MicroMsg.AccInfo", "parseBuf " + pnu.pnA.length() + " " + pnu.pnz.length());
      paramArrayOfByte = localLVBuffer.getString();
      if ((Util.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(bQB())))
      {
        clear();
        Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(132639);
        return -4;
      }
      Log.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), paramArrayOfByte });
      AppMethodBeat.o(132639);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(132639);
    }
    return -5;
  }
  
  public final int aw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(241225);
    long l = Util.nowMilliSecond();
    try
    {
      LVBuffer localLVBuffer = new LVBuffer();
      int i = localLVBuffer.initParse(paramArrayOfByte);
      if (i != 0)
      {
        Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(241225);
        return -3;
      }
      this.username = localLVBuffer.getString();
      this.hLv = localLVBuffer.getString();
      this.uin = localLVBuffer.getInt();
      this.ieJ = localLVBuffer.getBuffer();
      this.pnp = localLVBuffer.getBuffer();
      this.pnl = localLVBuffer.getBuffer();
      this.pnm = localLVBuffer.getBuffer();
      this.pnn = localLVBuffer.getBuffer();
      pnu.pnA = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      pnu.pnz = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      Log.i("MicroMsg.AccInfo", "parseBuf " + pnu.pnA.length() + " " + pnu.pnz.length());
      paramArrayOfByte = localLVBuffer.getString();
      if ((Util.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(bQB())))
      {
        clear();
        Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(241225);
        return -4;
      }
      Log.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), paramArrayOfByte });
      AppMethodBeat.o(241225);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(241225);
    }
    return -5;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132642);
    Log.i("MicroMsg.AccInfo", "setAxAuthSessionKey");
    Object localObject = (dal)this.pnr.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((dal)localObject).vgO.size() == 0))
    {
      Log.w("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(132642);
      return;
    }
    iq localiq = new iq();
    try
    {
      localiq.parseFrom(paramArrayOfByte1);
      Log.i("MicroMsg.AccInfo", "axsession key length: server [%d], client [%d]", new Object[] { Integer.valueOf(localiq.YJB.abwJ), Integer.valueOf(localiq.YJA.abwJ) });
      paramArrayOfByte1 = new a();
      paramArrayOfByte1.pnv = localiq;
      paramArrayOfByte1.pnw = paramArrayOfByte2;
      paramArrayOfByte2 = ((dal)localObject).vgO.iterator();
      while (paramArrayOfByte2.hasNext())
      {
        localObject = (dak)paramArrayOfByte2.next();
        this.pns.put(localObject, paramArrayOfByte1);
        Log.i("MicroMsg.AccInfo", "receive axauth host " + ((dak)localObject).aaFX);
      }
      AppMethodBeat.o(132642);
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte1) });
      AppMethodBeat.o(132642);
      return;
    }
  }
  
  public final byte[] bFZ()
  {
    return this.ieJ;
  }
  
  public final boolean bGa()
  {
    return (this.pnl != null) && (this.pnm != null) && (this.pnn != null) && (this.pnl.length > 0) && (this.pnm.length > 0) && (this.pnn.length > 0);
  }
  
  public final byte[] bGb()
  {
    return this.pnp;
  }
  
  public final String bGc()
  {
    return this.hLv;
  }
  
  public final byte[] bGd()
  {
    AppMethodBeat.i(132638);
    long l = Util.nowMilliSecond();
    int i;
    if (Util.isNullOrNil(this.username)) {
      i = 0;
    }
    while (i == 0)
    {
      Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
      AppMethodBeat.o(132638);
      return null;
      if (Util.isNullOrNil(this.pnl)) {
        i = 0;
      } else if (Util.isNullOrNil(this.pnm)) {
        i = 0;
      } else if (Util.isNullOrNil(this.pnn)) {
        i = 0;
      } else if (Util.isNullOrNil(this.ieJ)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (Util.isNullOrNil(this.pnp)) {
        i = 0;
      } else if (Util.isNullOrNil(this.hLv)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    try
    {
      Object localObject = new LVBuffer();
      ((LVBuffer)localObject).initBuild();
      ((LVBuffer)localObject).putString(this.username);
      ((LVBuffer)localObject).putString(this.hLv);
      ((LVBuffer)localObject).putInt(this.uin);
      ((LVBuffer)localObject).putBuffer(this.ieJ);
      ((LVBuffer)localObject).putBuffer(this.pnp);
      ((LVBuffer)localObject).putBuffer(this.pnl);
      ((LVBuffer)localObject).putBuffer(this.pnm);
      ((LVBuffer)localObject).putBuffer(this.pnn);
      ((LVBuffer)localObject).putBuffer(pnu.pnA.getBytes(StandardCharsets.ISO_8859_1));
      ((LVBuffer)localObject).putBuffer(pnu.pnz.getBytes(StandardCharsets.ISO_8859_1));
      String str = bQB();
      ((LVBuffer)localObject).putString(str);
      localObject = ((LVBuffer)localObject).buildFinish();
      Log.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(localObject.length), str });
      AppMethodBeat.o(132638);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132638);
    }
    return null;
  }
  
  public final void bGe()
  {
    AppMethodBeat.i(132644);
    this.pns.clear();
    AppMethodBeat.o(132644);
  }
  
  public final void bGf()
  {
    AppMethodBeat.i(132645);
    Log.i("MicroMsg.AccInfo", "clearAxHost");
    this.pnr.clear();
    AppMethodBeat.o(132645);
  }
  
  public final void bQC()
  {
    AppMethodBeat.i(132643);
    if ((this.pnm != null) || (this.pnn != null) || (!this.pns.isEmpty()))
    {
      this.pnm = null;
      this.pnn = null;
      this.pns.clear();
    }
    AppMethodBeat.o(132643);
  }
  
  public final int getUin()
  {
    return this.uin;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public final void i(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132641);
    Log.i("MicroMsg.AccInfo", "addAxAuthHostList");
    dal localdal = new dal();
    try
    {
      localdal.parseFrom(paramArrayOfByte);
      this.pnr.put(Integer.valueOf(paramInt), localdal);
      Log.i("MicroMsg.AccInfo", "add host " + paramInt + " host " + ((dak)localdal.vgO.get(0)).aaFW);
      AppMethodBeat.o(132641);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.AccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(132641);
    }
  }
  
  public final boolean isForeground()
  {
    return this.foreground;
  }
  
  public final void k(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132634);
    this.pnq.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(132634);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132630);
    Log.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.pnl = null;
    bQA();
    this.uin = 0;
    this.pnm = null;
    this.pnn = null;
    AppMethodBeat.o(132630);
  }
  
  public final byte[] sA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.pnl;
    case 2: 
      return this.pnm;
    }
    return this.pnn;
  }
  
  public final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(132636);
    this.foreground = paramBoolean;
    Log.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", new Object[] { Boolean.valueOf(this.foreground) });
    AppMethodBeat.o(132636);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132640);
    Log.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(paramInt), Util.getStack() });
    this.uin = paramInt;
    AppMethodBeat.o(132640);
  }
  
  public final void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132633);
    String str = "AccInfo:\n" + "|-uin     =" + getUin() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-wxuser  =" + bGc() + "\n";
    str = str + "|-wxuser  =" + bGc() + "\n";
    str = str + "|-singlesession =" + Util.dumpHex(sA(1)) + "\n";
    str = str + "|-clientsession =" + Util.dumpHex(sA(2)) + "\n";
    str = str + "|-serversession =" + Util.dumpHex(sA(3)) + "\n";
    str = str + "|-ecdhkey =" + Util.dumpHex(bGb()) + "\n";
    str = str + "`-cookie  =" + Util.dumpHex(bFZ());
    AppMethodBeat.o(132633);
    return str;
  }
  
  final class a
  {
    public iq pnv;
    public byte[] pnw;
    
    a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */