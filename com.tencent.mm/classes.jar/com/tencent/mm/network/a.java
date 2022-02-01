package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ie;
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
  private static b.a jDx;
  String dMW;
  byte[] ees;
  private boolean foreground;
  private byte[] jDo;
  private byte[] jDp;
  private byte[] jDq;
  private b jDr;
  byte[] jDs;
  private Map<String, byte[]> jDt;
  private Map<Integer, ccb> jDu;
  private Map<cca, a> jDv;
  List<String> jDw;
  private int uin;
  String username;
  
  static
  {
    AppMethodBeat.i(197080);
    jDx = new b.a();
    AppMethodBeat.o(197080);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(132629);
    this.jDr = null;
    this.foreground = false;
    this.jDt = new HashMap();
    this.jDu = new HashMap();
    this.jDv = new HashMap();
    this.jDw = new ArrayList();
    this.jDr = paramb;
    bjn();
    AppMethodBeat.o(132629);
  }
  
  public static String[] aZl()
  {
    AppMethodBeat.i(197079);
    String[] arrayOfString = new String[2];
    if (jDx != null)
    {
      arrayOfString[0] = jDx.jDD;
      arrayOfString[1] = jDx.jDC;
      AppMethodBeat.o(197079);
      return arrayOfString;
    }
    Log.e("MicroMsg.AccInfo", "no find cgi sign keys");
    AppMethodBeat.o(197079);
    return arrayOfString;
  }
  
  public static void bK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197078);
    try
    {
      Log.i("MicroMsg.AccInfo", "saveBackUpCgiSignKeys " + paramString1.length() + " " + paramString2.length());
      jDx.jDD = paramString1;
      jDx.jDC = paramString2;
      AppMethodBeat.o(197078);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.AccInfo", paramString1.getLocalizedMessage());
      AppMethodBeat.o(197078);
    }
  }
  
  private void bjn()
  {
    AppMethodBeat.i(132631);
    this.ees = Util.decodeHexString(bi.aVK().getString("server_id", ""));
    AppMethodBeat.o(132631);
  }
  
  private String bjo()
  {
    AppMethodBeat.i(132637);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.jDo).put(this.jDp).put(this.jDq).put(this.jDs).put(this.ees).putInt(this.uin).put(this.dMW.getBytes()).put(this.username.getBytes());
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
  
  private void clear()
  {
    this.username = null;
    this.jDo = null;
    this.jDp = null;
    this.jDq = null;
    this.ees = null;
    this.uin = 0;
    this.jDs = null;
    this.dMW = null;
  }
  
  public final byte[] MC(String paramString)
  {
    AppMethodBeat.i(132635);
    paramString = (byte[])this.jDt.get(paramString);
    AppMethodBeat.o(132635);
    return paramString;
  }
  
  public final byte[] MD(String paramString)
  {
    AppMethodBeat.i(132647);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132647);
      return null;
    }
    Iterator localIterator = this.jDv.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((cca)localEntry.getKey()).MhY));
    for (paramString = ((a)localEntry.getValue()).jDz;; paramString = null)
    {
      AppMethodBeat.o(132647);
      return paramString;
    }
  }
  
  public final byte[] ME(String paramString)
  {
    AppMethodBeat.i(132652);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132652);
      return null;
    }
    Iterator localIterator = this.jDv.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((cca)localEntry.getKey()).MhY));
    for (paramString = ((a)localEntry.getValue()).jDy;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.KLq.getBufferToBytes();
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
  
  public final byte[] MF(String paramString)
  {
    AppMethodBeat.i(132653);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132653);
      return null;
    }
    Iterator localIterator = this.jDv.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((cca)localEntry.getKey()).MhY));
    for (paramString = ((a)localEntry.getValue()).jDy;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.KLr.getBufferToBytes();
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
  
  public final boolean MG(String paramString)
  {
    AppMethodBeat.i(132646);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132646);
      return false;
    }
    cca localcca;
    do
    {
      Iterator localIterator = this.jDu.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (ccb)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject == null) || (((ccb)localObject).oTA == null));
        localObject = ((ccb)localObject).oTA.iterator();
      }
      localcca = (cca)((Iterator)localObject).next();
    } while ((localcca == null) || (!paramString.equals(localcca.MhY)));
    AppMethodBeat.o(132646);
    return true;
    AppMethodBeat.o(132646);
    return false;
  }
  
  public final void RL(String paramString)
  {
    this.dMW = paramString;
  }
  
  public final boolean RM(String paramString)
  {
    AppMethodBeat.i(132650);
    if ("axhost".equals(paramString))
    {
      bool = this.jDu.isEmpty();
      AppMethodBeat.o(132650);
      return bool;
    }
    boolean bool = this.jDw.isEmpty();
    AppMethodBeat.o(132650);
    return bool;
  }
  
  public final boolean RN(String paramString)
  {
    AppMethodBeat.i(132651);
    if (!MG(paramString))
    {
      AppMethodBeat.o(132651);
      return false;
    }
    byte[] arrayOfByte = ME(paramString);
    paramString = MF(paramString);
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
    this.jDo = paramArrayOfByte1;
    this.jDp = paramArrayOfByte2;
    this.jDq = paramArrayOfByte3;
    this.uin = paramInt;
    if (this.jDr != null) {
      aZb();
    }
    AppMethodBeat.o(132632);
  }
  
  public final byte[] aZa()
  {
    return this.ees;
  }
  
  public final boolean aZb()
  {
    return (this.jDo != null) && (this.jDp != null) && (this.jDq != null) && (this.jDo.length > 0) && (this.jDp.length > 0) && (this.jDq.length > 0);
  }
  
  public final byte[] aZc()
  {
    return this.jDs;
  }
  
  public final String aZd()
  {
    return this.dMW;
  }
  
  public final byte[] aZe()
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
      if (Util.isNullOrNil(this.jDo)) {
        i = 0;
      } else if (Util.isNullOrNil(this.jDp)) {
        i = 0;
      } else if (Util.isNullOrNil(this.jDq)) {
        i = 0;
      } else if (Util.isNullOrNil(this.ees)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (Util.isNullOrNil(this.jDs)) {
        i = 0;
      } else if (Util.isNullOrNil(this.dMW)) {
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
      ((LVBuffer)localObject).putString(this.dMW);
      ((LVBuffer)localObject).putInt(this.uin);
      ((LVBuffer)localObject).putBuffer(this.ees);
      ((LVBuffer)localObject).putBuffer(this.jDs);
      ((LVBuffer)localObject).putBuffer(this.jDo);
      ((LVBuffer)localObject).putBuffer(this.jDp);
      ((LVBuffer)localObject).putBuffer(this.jDq);
      ((LVBuffer)localObject).putBuffer(jDx.jDD.getBytes(StandardCharsets.ISO_8859_1));
      ((LVBuffer)localObject).putBuffer(jDx.jDC.getBytes(StandardCharsets.ISO_8859_1));
      String str = bjo();
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
  
  public final void aZf()
  {
    AppMethodBeat.i(132644);
    this.jDv.clear();
    AppMethodBeat.o(132644);
  }
  
  public final void aZg()
  {
    AppMethodBeat.i(132645);
    Log.i("MicroMsg.AccInfo", "clearAxHost");
    this.jDu.clear();
    AppMethodBeat.o(132645);
  }
  
  public final int al(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132639);
    long l = Util.nowMilliSecond();
    if (aZb())
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
      this.dMW = localLVBuffer.getString();
      this.uin = localLVBuffer.getInt();
      this.ees = localLVBuffer.getBuffer();
      this.jDs = localLVBuffer.getBuffer();
      this.jDo = localLVBuffer.getBuffer();
      this.jDp = localLVBuffer.getBuffer();
      this.jDq = localLVBuffer.getBuffer();
      jDx.jDD = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      jDx.jDC = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      Log.i("MicroMsg.AccInfo", "parseBuf " + jDx.jDD.length() + " " + jDx.jDC.length());
      paramArrayOfByte = localLVBuffer.getString();
      if ((Util.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(bjo())))
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
  
  public final int am(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197077);
    long l = Util.nowMilliSecond();
    try
    {
      LVBuffer localLVBuffer = new LVBuffer();
      int i = localLVBuffer.initParse(paramArrayOfByte);
      if (i != 0)
      {
        Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(197077);
        return -3;
      }
      this.username = localLVBuffer.getString();
      this.dMW = localLVBuffer.getString();
      this.uin = localLVBuffer.getInt();
      this.ees = localLVBuffer.getBuffer();
      this.jDs = localLVBuffer.getBuffer();
      this.jDo = localLVBuffer.getBuffer();
      this.jDp = localLVBuffer.getBuffer();
      this.jDq = localLVBuffer.getBuffer();
      jDx.jDD = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      jDx.jDC = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      Log.i("MicroMsg.AccInfo", "parseBuf " + jDx.jDD.length() + " " + jDx.jDC.length());
      paramArrayOfByte = localLVBuffer.getString();
      if ((Util.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(bjo())))
      {
        clear();
        Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(197077);
        return -4;
      }
      Log.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), paramArrayOfByte });
      AppMethodBeat.o(197077);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(197077);
    }
    return -5;
  }
  
  public final void av(byte[] paramArrayOfByte)
  {
    this.ees = paramArrayOfByte;
  }
  
  public final void aw(byte[] paramArrayOfByte)
  {
    this.jDs = paramArrayOfByte;
  }
  
  public final void ax(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132648);
    this.jDw.add(new String(paramArrayOfByte));
    AppMethodBeat.o(132648);
  }
  
  public final boolean ay(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132649);
    boolean bool = this.jDw.contains(new String(paramArrayOfByte));
    AppMethodBeat.o(132649);
    return bool;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132642);
    Log.i("MicroMsg.AccInfo", "setAxAuthSessionKey");
    Object localObject = (ccb)this.jDu.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((ccb)localObject).oTA.size() == 0))
    {
      Log.w("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(132642);
      return;
    }
    ie localie = new ie();
    try
    {
      localie.parseFrom(paramArrayOfByte1);
      Log.i("MicroMsg.AccInfo", "axsession key length: server [%d], client [%d]", new Object[] { Integer.valueOf(localie.KLr.getILen()), Integer.valueOf(localie.KLq.getILen()) });
      paramArrayOfByte1 = new a();
      paramArrayOfByte1.jDy = localie;
      paramArrayOfByte1.jDz = paramArrayOfByte2;
      paramArrayOfByte2 = ((ccb)localObject).oTA.iterator();
      while (paramArrayOfByte2.hasNext())
      {
        localObject = (cca)paramArrayOfByte2.next();
        this.jDv.put(localObject, paramArrayOfByte1);
        Log.i("MicroMsg.AccInfo", "receive axauth host " + ((cca)localObject).MhY);
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
  
  public final void bjp()
  {
    AppMethodBeat.i(132643);
    if ((this.jDp != null) || (this.jDq != null) || (!this.jDv.isEmpty()))
    {
      this.jDp = null;
      this.jDq = null;
      this.jDv.clear();
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
  
  public final void h(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132641);
    Log.i("MicroMsg.AccInfo", "addAxAuthHostList");
    ccb localccb = new ccb();
    try
    {
      localccb.parseFrom(paramArrayOfByte);
      this.jDu.put(Integer.valueOf(paramInt), localccb);
      Log.i("MicroMsg.AccInfo", "add host " + paramInt + " host " + ((cca)localccb.oTA.get(0)).MhX);
      AppMethodBeat.o(132641);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.AccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(132641);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132634);
    this.jDt.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(132634);
  }
  
  public final boolean isForeground()
  {
    return this.foreground;
  }
  
  public final byte[] qe(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.jDo;
    case 2: 
      return this.jDp;
    }
    return this.jDq;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132630);
    Log.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.jDo = null;
    bjn();
    this.uin = 0;
    this.jDp = null;
    this.jDq = null;
    AppMethodBeat.o(132630);
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
    str = str + "|-wxuser  =" + aZd() + "\n";
    str = str + "|-wxuser  =" + aZd() + "\n";
    str = str + "|-singlesession =" + Util.dumpHex(qe(1)) + "\n";
    str = str + "|-clientsession =" + Util.dumpHex(qe(2)) + "\n";
    str = str + "|-serversession =" + Util.dumpHex(qe(3)) + "\n";
    str = str + "|-ecdhkey =" + Util.dumpHex(aZc()) + "\n";
    str = str + "`-cookie  =" + Util.dumpHex(aZa());
    AppMethodBeat.o(132633);
    return str;
  }
  
  final class a
  {
    public ie jDy;
    public byte[] jDz;
    
    a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */