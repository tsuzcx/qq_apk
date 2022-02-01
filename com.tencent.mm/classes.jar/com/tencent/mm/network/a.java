package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  byte[] dBl;
  private boolean foreground;
  private byte[] hKA;
  private b hKB;
  byte[] hKC;
  String hKD;
  private Map<String, byte[]> hKE;
  private Map<Integer, bgp> hKF;
  private Map<bgo, a> hKG;
  List<String> hKH;
  private byte[] hKy;
  private byte[] hKz;
  private int uin;
  String username;
  
  public a(b paramb)
  {
    AppMethodBeat.i(132629);
    this.hKB = null;
    this.foreground = false;
    this.hKE = new HashMap();
    this.hKF = new HashMap();
    this.hKG = new HashMap();
    this.hKH = new ArrayList();
    this.hKB = paramb;
    aED();
    AppMethodBeat.o(132629);
  }
  
  private void aED()
  {
    AppMethodBeat.i(132631);
    this.dBl = bt.aGd(bb.asa().getString("server_id", ""));
    AppMethodBeat.o(132631);
  }
  
  private String aEE()
  {
    AppMethodBeat.i(132637);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.hKy).put(this.hKz).put(this.hKA).put(this.hKC).put(this.dBl).putInt(this.uin).put(this.hKD.getBytes()).put(this.username.getBytes());
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
    this.hKy = null;
    this.hKz = null;
    this.hKA = null;
    this.dBl = null;
    this.uin = 0;
    this.hKC = null;
    this.hKD = null;
  }
  
  public final void AU(String paramString)
  {
    this.hKD = paramString;
  }
  
  public final boolean AV(String paramString)
  {
    AppMethodBeat.i(132650);
    if ("axhost".equals(paramString))
    {
      bool = this.hKF.isEmpty();
      AppMethodBeat.o(132650);
      return bool;
    }
    boolean bool = this.hKH.isEmpty();
    AppMethodBeat.o(132650);
    return bool;
  }
  
  public final boolean AW(String paramString)
  {
    AppMethodBeat.i(132651);
    if (!wl(paramString))
    {
      AppMethodBeat.o(132651);
      return false;
    }
    byte[] arrayOfByte = wj(paramString);
    paramString = wk(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (paramString != null) && (paramString.length > 0))
    {
      AppMethodBeat.o(132651);
      return true;
    }
    AppMethodBeat.o(132651);
    return false;
  }
  
  public final int Z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132639);
    long l = bt.eGO();
    if (ava())
    {
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
      AppMethodBeat.o(132639);
      return -2;
    }
    try
    {
      aa localaa = new aa();
      int i = localaa.cs(paramArrayOfByte);
      if (i != 0)
      {
        ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(132639);
        return -3;
      }
      this.username = localaa.getString();
      this.hKD = localaa.getString();
      this.uin = localaa.getInt();
      this.dBl = localaa.getBuffer();
      this.hKC = localaa.getBuffer();
      this.hKy = localaa.getBuffer();
      this.hKz = localaa.getBuffer();
      this.hKA = localaa.getBuffer();
      paramArrayOfByte = localaa.getString();
      if ((bt.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(aEE())))
      {
        clear();
        ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(132639);
        return -4;
      }
      ad.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(bt.vM(l)), paramArrayOfByte });
      AppMethodBeat.o(132639);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.m(paramArrayOfByte) });
      AppMethodBeat.o(132639);
    }
    return -5;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132632);
    ad.i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", new Object[] { bt.aGs(bt.cv(paramArrayOfByte1)), bt.aGs(bt.cv(paramArrayOfByte2)), bt.aGs(bt.cv(paramArrayOfByte3)), Integer.valueOf(this.uin), Integer.valueOf(paramInt), bt.eGN() });
    this.hKy = paramArrayOfByte1;
    this.hKz = paramArrayOfByte2;
    this.hKA = paramArrayOfByte3;
    this.uin = paramInt;
    if (this.hKB != null) {
      ava();
    }
    AppMethodBeat.o(132632);
  }
  
  public final void aEF()
  {
    AppMethodBeat.i(132643);
    if ((this.hKz != null) || (this.hKA != null) || (!this.hKG.isEmpty()))
    {
      this.hKz = null;
      this.hKA = null;
      this.hKG.clear();
    }
    AppMethodBeat.o(132643);
  }
  
  public final void ah(byte[] paramArrayOfByte)
  {
    this.dBl = paramArrayOfByte;
  }
  
  public final void ai(byte[] paramArrayOfByte)
  {
    this.hKC = paramArrayOfByte;
  }
  
  public final void aj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132648);
    this.hKH.add(new String(paramArrayOfByte));
    AppMethodBeat.o(132648);
  }
  
  public final boolean ak(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132649);
    boolean bool = this.hKH.contains(new String(paramArrayOfByte));
    AppMethodBeat.o(132649);
    return bool;
  }
  
  public final byte[] auZ()
  {
    return this.dBl;
  }
  
  public final boolean ava()
  {
    return (this.hKy != null) && (this.hKz != null) && (this.hKA != null) && (this.hKy.length > 0) && (this.hKz.length > 0) && (this.hKA.length > 0);
  }
  
  public final byte[] avb()
  {
    return this.hKC;
  }
  
  public final String avc()
  {
    return this.hKD;
  }
  
  public final byte[] avd()
  {
    AppMethodBeat.i(132638);
    long l = bt.eGO();
    int i;
    if (bt.isNullOrNil(this.username)) {
      i = 0;
    }
    while (i == 0)
    {
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
      AppMethodBeat.o(132638);
      return null;
      if (bt.cw(this.hKy)) {
        i = 0;
      } else if (bt.cw(this.hKz)) {
        i = 0;
      } else if (bt.cw(this.hKA)) {
        i = 0;
      } else if (bt.cw(this.dBl)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (bt.cw(this.hKC)) {
        i = 0;
      } else if (bt.isNullOrNil(this.hKD)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    try
    {
      Object localObject = new aa();
      ((aa)localObject).eFl();
      ((aa)localObject).aFs(this.username);
      ((aa)localObject).aFs(this.hKD);
      ((aa)localObject).Wi(this.uin);
      ((aa)localObject).ct(this.dBl);
      ((aa)localObject).ct(this.hKC);
      ((aa)localObject).ct(this.hKy);
      ((aa)localObject).ct(this.hKz);
      ((aa)localObject).ct(this.hKA);
      String str = aEE();
      ((aa)localObject).aFs(str);
      localObject = ((aa)localObject).eFm();
      ad.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[] { Long.valueOf(bt.vM(l)), Integer.valueOf(localObject.length), str });
      AppMethodBeat.o(132638);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132638);
    }
    return null;
  }
  
  public final void ave()
  {
    AppMethodBeat.i(132644);
    this.hKG.clear();
    AppMethodBeat.o(132644);
  }
  
  public final void avf()
  {
    AppMethodBeat.i(132645);
    ad.i("MicroMsg.AccInfo", "clearAxHost");
    this.hKF.clear();
    AppMethodBeat.o(132645);
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132642);
    ad.i("MicroMsg.AccInfo", "setAxAuthSessionKey");
    Object localObject = (bgp)this.hKF.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((bgp)localObject).mAL.size() == 0))
    {
      ad.w("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(132642);
      return;
    }
    hg localhg = new hg();
    try
    {
      localhg.parseFrom(paramArrayOfByte1);
      ad.i("MicroMsg.AccInfo", "axsession key length: server [%d], client [%d]", new Object[] { Integer.valueOf(localhg.CBu.getILen()), Integer.valueOf(localhg.CBt.getILen()) });
      paramArrayOfByte1 = new a();
      paramArrayOfByte1.hKI = localhg;
      paramArrayOfByte1.hKJ = paramArrayOfByte2;
      paramArrayOfByte2 = ((bgp)localObject).mAL.iterator();
      while (paramArrayOfByte2.hasNext())
      {
        localObject = (bgo)paramArrayOfByte2.next();
        this.hKG.put(localObject, paramArrayOfByte1);
        ad.i("MicroMsg.AccInfo", "receive axauth host " + ((bgo)localObject).DEA);
      }
      AppMethodBeat.o(132642);
    }
    catch (Exception paramArrayOfByte1)
    {
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.m(paramArrayOfByte1) });
      AppMethodBeat.o(132642);
      return;
    }
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(132636);
    this.foreground = paramBoolean;
    ad.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", new Object[] { Boolean.valueOf(this.foreground) });
    AppMethodBeat.o(132636);
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
    ad.i("MicroMsg.AccInfo", "addAxAuthHostList");
    bgp localbgp = new bgp();
    try
    {
      localbgp.parseFrom(paramArrayOfByte);
      this.hKF.put(Integer.valueOf(paramInt), localbgp);
      ad.i("MicroMsg.AccInfo", "add host " + paramInt + " host " + ((bgo)localbgp.mAL.get(0)).DEz);
      AppMethodBeat.o(132641);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.AccInfo", "exception:%s", new Object[] { bt.m(paramArrayOfByte) });
      AppMethodBeat.o(132641);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132634);
    this.hKE.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(132634);
  }
  
  public final boolean isForeground()
  {
    return this.foreground;
  }
  
  public final byte[] mq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.hKy;
    case 2: 
      return this.hKz;
    }
    return this.hKA;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132630);
    ad.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.hKy = null;
    aED();
    this.uin = 0;
    this.hKz = null;
    this.hKA = null;
    AppMethodBeat.o(132630);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132640);
    ad.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(paramInt), bt.eGN() });
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
    str = str + "|-wxuser  =" + avc() + "\n";
    str = str + "|-wxuser  =" + avc() + "\n";
    str = str + "|-singlesession =" + bt.cv(mq(1)) + "\n";
    str = str + "|-clientsession =" + bt.cv(mq(2)) + "\n";
    str = str + "|-serversession =" + bt.cv(mq(3)) + "\n";
    str = str + "|-ecdhkey =" + bt.cv(avb()) + "\n";
    str = str + "`-cookie  =" + bt.cv(auZ());
    AppMethodBeat.o(132633);
    return str;
  }
  
  public final byte[] wh(String paramString)
  {
    AppMethodBeat.i(132635);
    paramString = (byte[])this.hKE.get(paramString);
    AppMethodBeat.o(132635);
    return paramString;
  }
  
  public final byte[] wi(String paramString)
  {
    AppMethodBeat.i(132647);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132647);
      return null;
    }
    Iterator localIterator = this.hKG.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bgo)localEntry.getKey()).DEA));
    for (paramString = ((a)localEntry.getValue()).hKJ;; paramString = null)
    {
      AppMethodBeat.o(132647);
      return paramString;
    }
  }
  
  public final byte[] wj(String paramString)
  {
    AppMethodBeat.i(132652);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132652);
      return null;
    }
    Iterator localIterator = this.hKG.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bgo)localEntry.getKey()).DEA));
    for (paramString = ((a)localEntry.getValue()).hKI;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.CBt.getBufferToBytes();
          AppMethodBeat.o(132652);
          return paramString;
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.m(paramString) });
          AppMethodBeat.o(132652);
          return null;
        }
      }
      AppMethodBeat.o(132652);
      return null;
    }
  }
  
  public final byte[] wk(String paramString)
  {
    AppMethodBeat.i(132653);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132653);
      return null;
    }
    Iterator localIterator = this.hKG.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bgo)localEntry.getKey()).DEA));
    for (paramString = ((a)localEntry.getValue()).hKI;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.CBu.getBufferToBytes();
          AppMethodBeat.o(132653);
          return paramString;
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.m(paramString) });
          AppMethodBeat.o(132653);
          return null;
        }
      }
      AppMethodBeat.o(132653);
      return null;
    }
  }
  
  public final boolean wl(String paramString)
  {
    AppMethodBeat.i(132646);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132646);
      return false;
    }
    bgo localbgo;
    do
    {
      Iterator localIterator = this.hKF.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (bgp)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject == null) || (((bgp)localObject).mAL == null));
        localObject = ((bgp)localObject).mAL.iterator();
      }
      localbgo = (bgo)((Iterator)localObject).next();
    } while ((localbgo == null) || (!paramString.equals(localbgo.DEA)));
    AppMethodBeat.o(132646);
    return true;
    AppMethodBeat.o(132646);
    return false;
  }
  
  final class a
  {
    public hg hKI;
    public byte[] hKJ;
    
    a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */