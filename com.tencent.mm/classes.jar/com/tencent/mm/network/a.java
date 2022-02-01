package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.z;
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
  String diA;
  byte[] dyZ;
  private boolean foreground;
  private byte[] ikV;
  private byte[] ikW;
  private byte[] ikX;
  private b ikY;
  byte[] ikZ;
  private Map<String, byte[]> ila;
  private Map<Integer, bkh> ilb;
  private Map<bkg, a> ilc;
  List<String> ild;
  private int uin;
  String username;
  
  public a(b paramb)
  {
    AppMethodBeat.i(132629);
    this.ikY = null;
    this.foreground = false;
    this.ila = new HashMap();
    this.ilb = new HashMap();
    this.ilc = new HashMap();
    this.ild = new ArrayList();
    this.ikY = paramb;
    aLu();
    AppMethodBeat.o(132629);
  }
  
  private void aLu()
  {
    AppMethodBeat.i(132631);
    this.dyZ = bs.aLu(bb.ayR().getString("server_id", ""));
    AppMethodBeat.o(132631);
  }
  
  private String aLv()
  {
    AppMethodBeat.i(132637);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.ikV).put(this.ikW).put(this.ikX).put(this.ikZ).put(this.dyZ).putInt(this.uin).put(this.diA.getBytes()).put(this.username.getBytes());
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
    this.ikV = null;
    this.ikW = null;
    this.ikX = null;
    this.dyZ = null;
    this.uin = 0;
    this.ikZ = null;
    this.diA = null;
  }
  
  public final byte[] An(String paramString)
  {
    AppMethodBeat.i(132635);
    paramString = (byte[])this.ila.get(paramString);
    AppMethodBeat.o(132635);
    return paramString;
  }
  
  public final byte[] Ao(String paramString)
  {
    AppMethodBeat.i(132647);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132647);
      return null;
    }
    Iterator localIterator = this.ilc.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bkg)localEntry.getKey()).EZV));
    for (paramString = ((a)localEntry.getValue()).ilf;; paramString = null)
    {
      AppMethodBeat.o(132647);
      return paramString;
    }
  }
  
  public final byte[] Ap(String paramString)
  {
    AppMethodBeat.i(132652);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132652);
      return null;
    }
    Iterator localIterator = this.ilc.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bkg)localEntry.getKey()).EZV));
    for (paramString = ((a)localEntry.getValue()).ile;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.DTR.getBufferToBytes();
          AppMethodBeat.o(132652);
          return paramString;
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bs.m(paramString) });
          AppMethodBeat.o(132652);
          return null;
        }
      }
      AppMethodBeat.o(132652);
      return null;
    }
  }
  
  public final byte[] Aq(String paramString)
  {
    AppMethodBeat.i(132653);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132653);
      return null;
    }
    Iterator localIterator = this.ilc.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bkg)localEntry.getKey()).EZV));
    for (paramString = ((a)localEntry.getValue()).ile;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.DTS.getBufferToBytes();
          AppMethodBeat.o(132653);
          return paramString;
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bs.m(paramString) });
          AppMethodBeat.o(132653);
          return null;
        }
      }
      AppMethodBeat.o(132653);
      return null;
    }
  }
  
  public final boolean Ar(String paramString)
  {
    AppMethodBeat.i(132646);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132646);
      return false;
    }
    bkg localbkg;
    do
    {
      Iterator localIterator = this.ilb.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (bkh)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject == null) || (((bkh)localObject).ncM == null));
        localObject = ((bkh)localObject).ncM.iterator();
      }
      localbkg = (bkg)((Iterator)localObject).next();
    } while ((localbkg == null) || (!paramString.equals(localbkg.EZV)));
    AppMethodBeat.o(132646);
    return true;
    AppMethodBeat.o(132646);
    return false;
  }
  
  public final void EZ(String paramString)
  {
    this.diA = paramString;
  }
  
  public final boolean Fa(String paramString)
  {
    AppMethodBeat.i(132650);
    if ("axhost".equals(paramString))
    {
      bool = this.ilb.isEmpty();
      AppMethodBeat.o(132650);
      return bool;
    }
    boolean bool = this.ild.isEmpty();
    AppMethodBeat.o(132650);
    return bool;
  }
  
  public final boolean Fb(String paramString)
  {
    AppMethodBeat.i(132651);
    if (!Ar(paramString))
    {
      AppMethodBeat.o(132651);
      return false;
    }
    byte[] arrayOfByte = Ap(paramString);
    paramString = Aq(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (paramString != null) && (paramString.length > 0))
    {
      AppMethodBeat.o(132651);
      return true;
    }
    AppMethodBeat.o(132651);
    return false;
  }
  
  public final int Y(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132639);
    long l = bs.eWj();
    if (aBT())
    {
      ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
      AppMethodBeat.o(132639);
      return -2;
    }
    try
    {
      z localz = new z();
      int i = localz.cr(paramArrayOfByte);
      if (i != 0)
      {
        ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(132639);
        return -3;
      }
      this.username = localz.getString();
      this.diA = localz.getString();
      this.uin = localz.getInt();
      this.dyZ = localz.getBuffer();
      this.ikZ = localz.getBuffer();
      this.ikV = localz.getBuffer();
      this.ikW = localz.getBuffer();
      this.ikX = localz.getBuffer();
      paramArrayOfByte = localz.getString();
      if ((bs.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(aLv())))
      {
        clear();
        ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(132639);
        return -4;
      }
      ac.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(bs.Ap(l)), paramArrayOfByte });
      AppMethodBeat.o(132639);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bs.m(paramArrayOfByte) });
      AppMethodBeat.o(132639);
    }
    return -5;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132632);
    ac.i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", new Object[] { bs.aLJ(bs.cu(paramArrayOfByte1)), bs.aLJ(bs.cu(paramArrayOfByte2)), bs.aLJ(bs.cu(paramArrayOfByte3)), Integer.valueOf(this.uin), Integer.valueOf(paramInt), bs.eWi() });
    this.ikV = paramArrayOfByte1;
    this.ikW = paramArrayOfByte2;
    this.ikX = paramArrayOfByte3;
    this.uin = paramInt;
    if (this.ikY != null) {
      aBT();
    }
    AppMethodBeat.o(132632);
  }
  
  public final byte[] aBS()
  {
    return this.dyZ;
  }
  
  public final boolean aBT()
  {
    return (this.ikV != null) && (this.ikW != null) && (this.ikX != null) && (this.ikV.length > 0) && (this.ikW.length > 0) && (this.ikX.length > 0);
  }
  
  public final byte[] aBU()
  {
    return this.ikZ;
  }
  
  public final String aBV()
  {
    return this.diA;
  }
  
  public final byte[] aBW()
  {
    AppMethodBeat.i(132638);
    long l = bs.eWj();
    int i;
    if (bs.isNullOrNil(this.username)) {
      i = 0;
    }
    while (i == 0)
    {
      ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
      AppMethodBeat.o(132638);
      return null;
      if (bs.cv(this.ikV)) {
        i = 0;
      } else if (bs.cv(this.ikW)) {
        i = 0;
      } else if (bs.cv(this.ikX)) {
        i = 0;
      } else if (bs.cv(this.dyZ)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (bs.cv(this.ikZ)) {
        i = 0;
      } else if (bs.isNullOrNil(this.diA)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    try
    {
      Object localObject = new z();
      ((z)localObject).eUF();
      ((z)localObject).aKJ(this.username);
      ((z)localObject).aKJ(this.diA);
      ((z)localObject).Yr(this.uin);
      ((z)localObject).cs(this.dyZ);
      ((z)localObject).cs(this.ikZ);
      ((z)localObject).cs(this.ikV);
      ((z)localObject).cs(this.ikW);
      ((z)localObject).cs(this.ikX);
      String str = aLv();
      ((z)localObject).aKJ(str);
      localObject = ((z)localObject).eUG();
      ac.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[] { Long.valueOf(bs.Ap(l)), Integer.valueOf(localObject.length), str });
      AppMethodBeat.o(132638);
      return localObject;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132638);
    }
    return null;
  }
  
  public final void aBX()
  {
    AppMethodBeat.i(132644);
    this.ilc.clear();
    AppMethodBeat.o(132644);
  }
  
  public final void aBY()
  {
    AppMethodBeat.i(132645);
    ac.i("MicroMsg.AccInfo", "clearAxHost");
    this.ilb.clear();
    AppMethodBeat.o(132645);
  }
  
  public final void aLw()
  {
    AppMethodBeat.i(132643);
    if ((this.ikW != null) || (this.ikX != null) || (!this.ilc.isEmpty()))
    {
      this.ikW = null;
      this.ikX = null;
      this.ilc.clear();
    }
    AppMethodBeat.o(132643);
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    this.dyZ = paramArrayOfByte;
  }
  
  public final void ah(byte[] paramArrayOfByte)
  {
    this.ikZ = paramArrayOfByte;
  }
  
  public final void ai(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132648);
    this.ild.add(new String(paramArrayOfByte));
    AppMethodBeat.o(132648);
  }
  
  public final boolean aj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132649);
    boolean bool = this.ild.contains(new String(paramArrayOfByte));
    AppMethodBeat.o(132649);
    return bool;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132642);
    ac.i("MicroMsg.AccInfo", "setAxAuthSessionKey");
    Object localObject = (bkh)this.ilb.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((bkh)localObject).ncM.size() == 0))
    {
      ac.w("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(132642);
      return;
    }
    hk localhk = new hk();
    try
    {
      localhk.parseFrom(paramArrayOfByte1);
      ac.i("MicroMsg.AccInfo", "axsession key length: server [%d], client [%d]", new Object[] { Integer.valueOf(localhk.DTS.getILen()), Integer.valueOf(localhk.DTR.getILen()) });
      paramArrayOfByte1 = new a();
      paramArrayOfByte1.ile = localhk;
      paramArrayOfByte1.ilf = paramArrayOfByte2;
      paramArrayOfByte2 = ((bkh)localObject).ncM.iterator();
      while (paramArrayOfByte2.hasNext())
      {
        localObject = (bkg)paramArrayOfByte2.next();
        this.ilc.put(localObject, paramArrayOfByte1);
        ac.i("MicroMsg.AccInfo", "receive axauth host " + ((bkg)localObject).EZV);
      }
      AppMethodBeat.o(132642);
    }
    catch (Exception paramArrayOfByte1)
    {
      ac.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bs.m(paramArrayOfByte1) });
      AppMethodBeat.o(132642);
      return;
    }
  }
  
  public final void eC(boolean paramBoolean)
  {
    AppMethodBeat.i(132636);
    this.foreground = paramBoolean;
    ac.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", new Object[] { Boolean.valueOf(this.foreground) });
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
    ac.i("MicroMsg.AccInfo", "addAxAuthHostList");
    bkh localbkh = new bkh();
    try
    {
      localbkh.parseFrom(paramArrayOfByte);
      this.ilb.put(Integer.valueOf(paramInt), localbkh);
      ac.i("MicroMsg.AccInfo", "add host " + paramInt + " host " + ((bkg)localbkh.ncM.get(0)).EZU);
      AppMethodBeat.o(132641);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.AccInfo", "exception:%s", new Object[] { bs.m(paramArrayOfByte) });
      AppMethodBeat.o(132641);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132634);
    this.ila.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(132634);
  }
  
  public final boolean isForeground()
  {
    return this.foreground;
  }
  
  public final byte[] mp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.ikV;
    case 2: 
      return this.ikW;
    }
    return this.ikX;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132630);
    ac.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.ikV = null;
    aLu();
    this.uin = 0;
    this.ikW = null;
    this.ikX = null;
    AppMethodBeat.o(132630);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132640);
    ac.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(paramInt), bs.eWi() });
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
    str = str + "|-wxuser  =" + aBV() + "\n";
    str = str + "|-wxuser  =" + aBV() + "\n";
    str = str + "|-singlesession =" + bs.cu(mp(1)) + "\n";
    str = str + "|-clientsession =" + bs.cu(mp(2)) + "\n";
    str = str + "|-serversession =" + bs.cu(mp(3)) + "\n";
    str = str + "|-ecdhkey =" + bs.cu(aBU()) + "\n";
    str = str + "`-cookie  =" + bs.cu(aBS());
    AppMethodBeat.o(132633);
    return str;
  }
  
  final class a
  {
    public hk ile;
    public byte[] ilf;
    
    a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */