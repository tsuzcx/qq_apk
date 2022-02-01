package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.bj;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.hu;
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
  private static b.a mua;
  String fGe;
  byte[] fYH;
  private boolean foreground;
  private byte[] mtR;
  private byte[] mtS;
  private byte[] mtT;
  private b mtU;
  byte[] mtV;
  private Map<String, byte[]> mtW;
  private Map<Integer, cke> mtX;
  private Map<ckd, a> mtY;
  List<String> mtZ;
  private int uin;
  String username;
  
  static
  {
    AppMethodBeat.i(203917);
    mua = new b.a();
    AppMethodBeat.o(203917);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(132629);
    this.mtU = null;
    this.foreground = false;
    this.mtW = new HashMap();
    this.mtX = new HashMap();
    this.mtY = new HashMap();
    this.mtZ = new ArrayList();
    this.mtU = paramb;
    bsR();
    AppMethodBeat.o(132629);
  }
  
  public static void bN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203915);
    try
    {
      Log.i("MicroMsg.AccInfo", "saveBackUpCgiSignKeys " + paramString1.length() + " " + paramString2.length());
      mua.mug = paramString1;
      mua.muf = paramString2;
      AppMethodBeat.o(203915);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.AccInfo", paramString1.getLocalizedMessage());
      AppMethodBeat.o(203915);
    }
  }
  
  public static String[] biA()
  {
    AppMethodBeat.i(203916);
    String[] arrayOfString = new String[2];
    if (mua != null)
    {
      arrayOfString[0] = mua.mug;
      arrayOfString[1] = mua.muf;
      AppMethodBeat.o(203916);
      return arrayOfString;
    }
    Log.e("MicroMsg.AccInfo", "no find cgi sign keys");
    AppMethodBeat.o(203916);
    return arrayOfString;
  }
  
  private void bsR()
  {
    AppMethodBeat.i(132631);
    this.fYH = Util.decodeHexString(bj.beN().getString("server_id", ""));
    AppMethodBeat.o(132631);
  }
  
  private String bsS()
  {
    AppMethodBeat.i(132637);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.mtR).put(this.mtS).put(this.mtT).put(this.mtV).put(this.fYH).putInt(this.uin).put(this.fGe.getBytes()).put(this.username.getBytes());
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
    this.mtR = null;
    this.mtS = null;
    this.mtT = null;
    this.fYH = null;
    this.uin = 0;
    this.mtV = null;
    this.fGe = null;
  }
  
  public final byte[] TX(String paramString)
  {
    AppMethodBeat.i(132635);
    paramString = (byte[])this.mtW.get(paramString);
    AppMethodBeat.o(132635);
    return paramString;
  }
  
  public final byte[] TY(String paramString)
  {
    AppMethodBeat.i(132647);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132647);
      return null;
    }
    Iterator localIterator = this.mtY.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((ckd)localEntry.getKey()).TrL));
    for (paramString = ((a)localEntry.getValue()).muc;; paramString = null)
    {
      AppMethodBeat.o(132647);
      return paramString;
    }
  }
  
  public final byte[] TZ(String paramString)
  {
    AppMethodBeat.i(132652);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132652);
      return null;
    }
    Iterator localIterator = this.mtY.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((ckd)localEntry.getKey()).TrL));
    for (paramString = ((a)localEntry.getValue()).mub;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.RMm.Tkb.UH;
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
  
  public final byte[] Ua(String paramString)
  {
    AppMethodBeat.i(132653);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132653);
      return null;
    }
    Iterator localIterator = this.mtY.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((ckd)localEntry.getKey()).TrL));
    for (paramString = ((a)localEntry.getValue()).mub;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.RMn.Tkb.UH;
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
  
  public final boolean Ub(String paramString)
  {
    AppMethodBeat.i(132646);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132646);
      return false;
    }
    ckd localckd;
    do
    {
      Iterator localIterator = this.mtX.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (cke)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject == null) || (((cke)localObject).rVy == null));
        localObject = ((cke)localObject).rVy.iterator();
      }
      localckd = (ckd)((Iterator)localObject).next();
    } while ((localckd == null) || (!paramString.equals(localckd.TrL)));
    AppMethodBeat.o(132646);
    return true;
    AppMethodBeat.o(132646);
    return false;
  }
  
  public final void Zl(String paramString)
  {
    this.fGe = paramString;
  }
  
  public final boolean Zm(String paramString)
  {
    AppMethodBeat.i(132650);
    if ("axhost".equals(paramString))
    {
      bool = this.mtX.isEmpty();
      AppMethodBeat.o(132650);
      return bool;
    }
    boolean bool = this.mtZ.isEmpty();
    AppMethodBeat.o(132650);
    return bool;
  }
  
  public final boolean Zn(String paramString)
  {
    AppMethodBeat.i(132651);
    if (!Ub(paramString))
    {
      AppMethodBeat.o(132651);
      return false;
    }
    byte[] arrayOfByte = TZ(paramString);
    paramString = Ua(paramString);
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
    this.mtR = paramArrayOfByte1;
    this.mtS = paramArrayOfByte2;
    this.mtT = paramArrayOfByte3;
    this.uin = paramInt;
    if (this.mtU != null) {
      biq();
    }
    AppMethodBeat.o(132632);
  }
  
  public final void aG(byte[] paramArrayOfByte)
  {
    this.fYH = paramArrayOfByte;
  }
  
  public final void aH(byte[] paramArrayOfByte)
  {
    this.mtV = paramArrayOfByte;
  }
  
  public final void aI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132648);
    this.mtZ.add(new String(paramArrayOfByte));
    AppMethodBeat.o(132648);
  }
  
  public final boolean aJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132649);
    boolean bool = this.mtZ.contains(new String(paramArrayOfByte));
    AppMethodBeat.o(132649);
    return bool;
  }
  
  public final int av(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132639);
    long l = Util.nowMilliSecond();
    if (biq())
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
      this.fGe = localLVBuffer.getString();
      this.uin = localLVBuffer.getInt();
      this.fYH = localLVBuffer.getBuffer();
      this.mtV = localLVBuffer.getBuffer();
      this.mtR = localLVBuffer.getBuffer();
      this.mtS = localLVBuffer.getBuffer();
      this.mtT = localLVBuffer.getBuffer();
      mua.mug = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      mua.muf = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      Log.i("MicroMsg.AccInfo", "parseBuf " + mua.mug.length() + " " + mua.muf.length());
      paramArrayOfByte = localLVBuffer.getString();
      if ((Util.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(bsS())))
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
    AppMethodBeat.i(203913);
    long l = Util.nowMilliSecond();
    try
    {
      LVBuffer localLVBuffer = new LVBuffer();
      int i = localLVBuffer.initParse(paramArrayOfByte);
      if (i != 0)
      {
        Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(203913);
        return -3;
      }
      this.username = localLVBuffer.getString();
      this.fGe = localLVBuffer.getString();
      this.uin = localLVBuffer.getInt();
      this.fYH = localLVBuffer.getBuffer();
      this.mtV = localLVBuffer.getBuffer();
      this.mtR = localLVBuffer.getBuffer();
      this.mtS = localLVBuffer.getBuffer();
      this.mtT = localLVBuffer.getBuffer();
      mua.mug = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      mua.muf = new String(localLVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
      Log.i("MicroMsg.AccInfo", "parseBuf " + mua.mug.length() + " " + mua.muf.length());
      paramArrayOfByte = localLVBuffer.getString();
      if ((Util.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(bsS())))
      {
        clear();
        Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(203913);
        return -4;
      }
      Log.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), paramArrayOfByte });
      AppMethodBeat.o(203913);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(203913);
    }
    return -5;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132642);
    Log.i("MicroMsg.AccInfo", "setAxAuthSessionKey");
    Object localObject = (cke)this.mtX.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((cke)localObject).rVy.size() == 0))
    {
      Log.w("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(132642);
      return;
    }
    hu localhu = new hu();
    try
    {
      localhu.parseFrom(paramArrayOfByte1);
      Log.i("MicroMsg.AccInfo", "axsession key length: server [%d], client [%d]", new Object[] { Integer.valueOf(localhu.RMn.Ufv), Integer.valueOf(localhu.RMm.Ufv) });
      paramArrayOfByte1 = new a();
      paramArrayOfByte1.mub = localhu;
      paramArrayOfByte1.muc = paramArrayOfByte2;
      paramArrayOfByte2 = ((cke)localObject).rVy.iterator();
      while (paramArrayOfByte2.hasNext())
      {
        localObject = (ckd)paramArrayOfByte2.next();
        this.mtY.put(localObject, paramArrayOfByte1);
        Log.i("MicroMsg.AccInfo", "receive axauth host " + ((ckd)localObject).TrL);
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
  
  public final byte[] bip()
  {
    return this.fYH;
  }
  
  public final boolean biq()
  {
    return (this.mtR != null) && (this.mtS != null) && (this.mtT != null) && (this.mtR.length > 0) && (this.mtS.length > 0) && (this.mtT.length > 0);
  }
  
  public final byte[] bir()
  {
    return this.mtV;
  }
  
  public final String bis()
  {
    return this.fGe;
  }
  
  public final byte[] bit()
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
      if (Util.isNullOrNil(this.mtR)) {
        i = 0;
      } else if (Util.isNullOrNil(this.mtS)) {
        i = 0;
      } else if (Util.isNullOrNil(this.mtT)) {
        i = 0;
      } else if (Util.isNullOrNil(this.fYH)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (Util.isNullOrNil(this.mtV)) {
        i = 0;
      } else if (Util.isNullOrNil(this.fGe)) {
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
      ((LVBuffer)localObject).putString(this.fGe);
      ((LVBuffer)localObject).putInt(this.uin);
      ((LVBuffer)localObject).putBuffer(this.fYH);
      ((LVBuffer)localObject).putBuffer(this.mtV);
      ((LVBuffer)localObject).putBuffer(this.mtR);
      ((LVBuffer)localObject).putBuffer(this.mtS);
      ((LVBuffer)localObject).putBuffer(this.mtT);
      ((LVBuffer)localObject).putBuffer(mua.mug.getBytes(StandardCharsets.ISO_8859_1));
      ((LVBuffer)localObject).putBuffer(mua.muf.getBytes(StandardCharsets.ISO_8859_1));
      String str = bsS();
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
  
  public final void biu()
  {
    AppMethodBeat.i(132644);
    this.mtY.clear();
    AppMethodBeat.o(132644);
  }
  
  public final void biv()
  {
    AppMethodBeat.i(132645);
    Log.i("MicroMsg.AccInfo", "clearAxHost");
    this.mtX.clear();
    AppMethodBeat.o(132645);
  }
  
  public final void bsT()
  {
    AppMethodBeat.i(132643);
    if ((this.mtS != null) || (this.mtT != null) || (!this.mtY.isEmpty()))
    {
      this.mtS = null;
      this.mtT = null;
      this.mtY.clear();
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
    cke localcke = new cke();
    try
    {
      localcke.parseFrom(paramArrayOfByte);
      this.mtX.put(Integer.valueOf(paramInt), localcke);
      Log.i("MicroMsg.AccInfo", "add host " + paramInt + " host " + ((ckd)localcke.rVy.get(0)).TrK);
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
    this.mtW.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(132634);
  }
  
  public final boolean isForeground()
  {
    return this.foreground;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132630);
    Log.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.mtR = null;
    bsR();
    this.uin = 0;
    this.mtS = null;
    this.mtT = null;
    AppMethodBeat.o(132630);
  }
  
  public final byte[] sE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.mtR;
    case 2: 
      return this.mtS;
    }
    return this.mtT;
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
    str = str + "|-wxuser  =" + bis() + "\n";
    str = str + "|-wxuser  =" + bis() + "\n";
    str = str + "|-singlesession =" + Util.dumpHex(sE(1)) + "\n";
    str = str + "|-clientsession =" + Util.dumpHex(sE(2)) + "\n";
    str = str + "|-serversession =" + Util.dumpHex(sE(3)) + "\n";
    str = str + "|-ecdhkey =" + Util.dumpHex(bir()) + "\n";
    str = str + "`-cookie  =" + Util.dumpHex(bip());
    AppMethodBeat.o(132633);
    return str;
  }
  
  final class a
  {
    public hu mub;
    public byte[] muc;
    
    a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */