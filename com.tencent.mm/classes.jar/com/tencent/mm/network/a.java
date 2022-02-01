package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.hr;
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
  byte[] dLl;
  String dul;
  private boolean foreground;
  private byte[] iEm;
  private byte[] iEn;
  private byte[] iEo;
  private b iEp;
  byte[] iEq;
  private Map<String, byte[]> iEr;
  private Map<Integer, bor> iEs;
  private Map<boq, a> iEt;
  List<String> iEu;
  private int uin;
  String username;
  
  public a(b paramb)
  {
    AppMethodBeat.i(132629);
    this.iEp = null;
    this.foreground = false;
    this.iEr = new HashMap();
    this.iEs = new HashMap();
    this.iEt = new HashMap();
    this.iEu = new ArrayList();
    this.iEp = paramb;
    aOE();
    AppMethodBeat.o(132629);
  }
  
  private void aOE()
  {
    AppMethodBeat.i(132631);
    this.dLl = bt.aRa(bc.aBV().getString("server_id", ""));
    AppMethodBeat.o(132631);
  }
  
  private String aOF()
  {
    AppMethodBeat.i(132637);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.iEm).put(this.iEn).put(this.iEo).put(this.iEq).put(this.dLl).putInt(this.uin).put(this.dul.getBytes()).put(this.username.getBytes());
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
    this.iEm = null;
    this.iEn = null;
    this.iEo = null;
    this.dLl = null;
    this.uin = 0;
    this.iEq = null;
    this.dul = null;
  }
  
  public final byte[] Dm(String paramString)
  {
    AppMethodBeat.i(132635);
    paramString = (byte[])this.iEr.get(paramString);
    AppMethodBeat.o(132635);
    return paramString;
  }
  
  public final byte[] Dn(String paramString)
  {
    AppMethodBeat.i(132647);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132647);
      return null;
    }
    Iterator localIterator = this.iEt.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((boq)localEntry.getKey()).GJu));
    for (paramString = ((a)localEntry.getValue()).iEw;; paramString = null)
    {
      AppMethodBeat.o(132647);
      return paramString;
    }
  }
  
  public final byte[] Do(String paramString)
  {
    AppMethodBeat.i(132652);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132652);
      return null;
    }
    Iterator localIterator = this.iEt.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((boq)localEntry.getKey()).GJu));
    for (paramString = ((a)localEntry.getValue()).iEv;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.Fzl.getBufferToBytes();
          AppMethodBeat.o(132652);
          return paramString;
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.n(paramString) });
          AppMethodBeat.o(132652);
          return null;
        }
      }
      AppMethodBeat.o(132652);
      return null;
    }
  }
  
  public final byte[] Dp(String paramString)
  {
    AppMethodBeat.i(132653);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132653);
      return null;
    }
    Iterator localIterator = this.iEt.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((boq)localEntry.getKey()).GJu));
    for (paramString = ((a)localEntry.getValue()).iEv;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.Fzm.getBufferToBytes();
          AppMethodBeat.o(132653);
          return paramString;
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.n(paramString) });
          AppMethodBeat.o(132653);
          return null;
        }
      }
      AppMethodBeat.o(132653);
      return null;
    }
  }
  
  public final boolean Dq(String paramString)
  {
    AppMethodBeat.i(132646);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132646);
      return false;
    }
    boq localboq;
    do
    {
      Iterator localIterator = this.iEs.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (bor)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject == null) || (((bor)localObject).nDj == null));
        localObject = ((bor)localObject).nDj.iterator();
      }
      localboq = (boq)((Iterator)localObject).next();
    } while ((localboq == null) || (!paramString.equals(localboq.GJu)));
    AppMethodBeat.o(132646);
    return true;
    AppMethodBeat.o(132646);
    return false;
  }
  
  public final void In(String paramString)
  {
    this.dul = paramString;
  }
  
  public final boolean Io(String paramString)
  {
    AppMethodBeat.i(132650);
    if ("axhost".equals(paramString))
    {
      bool = this.iEs.isEmpty();
      AppMethodBeat.o(132650);
      return bool;
    }
    boolean bool = this.iEu.isEmpty();
    AppMethodBeat.o(132650);
    return bool;
  }
  
  public final boolean Ip(String paramString)
  {
    AppMethodBeat.i(132651);
    if (!Dq(paramString))
    {
      AppMethodBeat.o(132651);
      return false;
    }
    byte[] arrayOfByte = Do(paramString);
    paramString = Dp(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (paramString != null) && (paramString.length > 0))
    {
      AppMethodBeat.o(132651);
      return true;
    }
    AppMethodBeat.o(132651);
    return false;
  }
  
  public final int X(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132639);
    long l = bt.flT();
    if (aEW())
    {
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
      AppMethodBeat.o(132639);
      return -2;
    }
    try
    {
      aa localaa = new aa();
      int i = localaa.cy(paramArrayOfByte);
      if (i != 0)
      {
        ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(132639);
        return -3;
      }
      this.username = localaa.getString();
      this.dul = localaa.getString();
      this.uin = localaa.getInt();
      this.dLl = localaa.getBuffer();
      this.iEq = localaa.getBuffer();
      this.iEm = localaa.getBuffer();
      this.iEn = localaa.getBuffer();
      this.iEo = localaa.getBuffer();
      paramArrayOfByte = localaa.getString();
      if ((bt.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(aOF())))
      {
        clear();
        ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(132639);
        return -4;
      }
      ad.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(bt.Df(l)), paramArrayOfByte });
      AppMethodBeat.o(132639);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.n(paramArrayOfByte) });
      AppMethodBeat.o(132639);
    }
    return -5;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132632);
    ad.i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", new Object[] { bt.aRp(bt.cB(paramArrayOfByte1)), bt.aRp(bt.cB(paramArrayOfByte2)), bt.aRp(bt.cB(paramArrayOfByte3)), Integer.valueOf(this.uin), Integer.valueOf(paramInt), bt.flS() });
    this.iEm = paramArrayOfByte1;
    this.iEn = paramArrayOfByte2;
    this.iEo = paramArrayOfByte3;
    this.uin = paramInt;
    if (this.iEp != null) {
      aEW();
    }
    AppMethodBeat.o(132632);
  }
  
  public final byte[] aEV()
  {
    return this.dLl;
  }
  
  public final boolean aEW()
  {
    return (this.iEm != null) && (this.iEn != null) && (this.iEo != null) && (this.iEm.length > 0) && (this.iEn.length > 0) && (this.iEo.length > 0);
  }
  
  public final byte[] aEX()
  {
    return this.iEq;
  }
  
  public final String aEY()
  {
    return this.dul;
  }
  
  public final byte[] aEZ()
  {
    AppMethodBeat.i(132638);
    long l = bt.flT();
    int i;
    if (bt.isNullOrNil(this.username)) {
      i = 0;
    }
    while (i == 0)
    {
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
      AppMethodBeat.o(132638);
      return null;
      if (bt.cC(this.iEm)) {
        i = 0;
      } else if (bt.cC(this.iEn)) {
        i = 0;
      } else if (bt.cC(this.iEo)) {
        i = 0;
      } else if (bt.cC(this.dLl)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (bt.cC(this.iEq)) {
        i = 0;
      } else if (bt.isNullOrNil(this.dul)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    try
    {
      Object localObject = new aa();
      ((aa)localObject).fkj();
      ((aa)localObject).aQp(this.username);
      ((aa)localObject).aQp(this.dul);
      ((aa)localObject).aaw(this.uin);
      ((aa)localObject).cz(this.dLl);
      ((aa)localObject).cz(this.iEq);
      ((aa)localObject).cz(this.iEm);
      ((aa)localObject).cz(this.iEn);
      ((aa)localObject).cz(this.iEo);
      String str = aOF();
      ((aa)localObject).aQp(str);
      localObject = ((aa)localObject).fkk();
      ad.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[] { Long.valueOf(bt.Df(l)), Integer.valueOf(localObject.length), str });
      AppMethodBeat.o(132638);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132638);
    }
    return null;
  }
  
  public final void aFa()
  {
    AppMethodBeat.i(132644);
    this.iEt.clear();
    AppMethodBeat.o(132644);
  }
  
  public final void aFb()
  {
    AppMethodBeat.i(132645);
    ad.i("MicroMsg.AccInfo", "clearAxHost");
    this.iEs.clear();
    AppMethodBeat.o(132645);
  }
  
  public final void aOG()
  {
    AppMethodBeat.i(132643);
    if ((this.iEn != null) || (this.iEo != null) || (!this.iEt.isEmpty()))
    {
      this.iEn = null;
      this.iEo = null;
      this.iEt.clear();
    }
    AppMethodBeat.o(132643);
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    this.dLl = paramArrayOfByte;
  }
  
  public final void ah(byte[] paramArrayOfByte)
  {
    this.iEq = paramArrayOfByte;
  }
  
  public final void ai(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132648);
    this.iEu.add(new String(paramArrayOfByte));
    AppMethodBeat.o(132648);
  }
  
  public final boolean aj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132649);
    boolean bool = this.iEu.contains(new String(paramArrayOfByte));
    AppMethodBeat.o(132649);
    return bool;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132642);
    ad.i("MicroMsg.AccInfo", "setAxAuthSessionKey");
    Object localObject = (bor)this.iEs.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((bor)localObject).nDj.size() == 0))
    {
      ad.w("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(132642);
      return;
    }
    hr localhr = new hr();
    try
    {
      localhr.parseFrom(paramArrayOfByte1);
      ad.i("MicroMsg.AccInfo", "axsession key length: server [%d], client [%d]", new Object[] { Integer.valueOf(localhr.Fzm.getILen()), Integer.valueOf(localhr.Fzl.getILen()) });
      paramArrayOfByte1 = new a();
      paramArrayOfByte1.iEv = localhr;
      paramArrayOfByte1.iEw = paramArrayOfByte2;
      paramArrayOfByte2 = ((bor)localObject).nDj.iterator();
      while (paramArrayOfByte2.hasNext())
      {
        localObject = (boq)paramArrayOfByte2.next();
        this.iEt.put(localObject, paramArrayOfByte1);
        ad.i("MicroMsg.AccInfo", "receive axauth host " + ((boq)localObject).GJu);
      }
      AppMethodBeat.o(132642);
    }
    catch (Exception paramArrayOfByte1)
    {
      ad.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.n(paramArrayOfByte1) });
      AppMethodBeat.o(132642);
      return;
    }
  }
  
  public final void eE(boolean paramBoolean)
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
    bor localbor = new bor();
    try
    {
      localbor.parseFrom(paramArrayOfByte);
      this.iEs.put(Integer.valueOf(paramInt), localbor);
      ad.i("MicroMsg.AccInfo", "add host " + paramInt + " host " + ((boq)localbor.nDj.get(0)).GJt);
      AppMethodBeat.o(132641);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.AccInfo", "exception:%s", new Object[] { bt.n(paramArrayOfByte) });
      AppMethodBeat.o(132641);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132634);
    this.iEr.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(132634);
  }
  
  public final boolean isForeground()
  {
    return this.foreground;
  }
  
  public final byte[] mO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.iEm;
    case 2: 
      return this.iEn;
    }
    return this.iEo;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132630);
    ad.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.iEm = null;
    aOE();
    this.uin = 0;
    this.iEn = null;
    this.iEo = null;
    AppMethodBeat.o(132630);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132640);
    ad.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(paramInt), bt.flS() });
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
    str = str + "|-wxuser  =" + aEY() + "\n";
    str = str + "|-wxuser  =" + aEY() + "\n";
    str = str + "|-singlesession =" + bt.cB(mO(1)) + "\n";
    str = str + "|-clientsession =" + bt.cB(mO(2)) + "\n";
    str = str + "|-serversession =" + bt.cB(mO(3)) + "\n";
    str = str + "|-ecdhkey =" + bt.cB(aEX()) + "\n";
    str = str + "`-cookie  =" + bt.cB(aEV());
    AppMethodBeat.o(132633);
    return str;
  }
  
  final class a
  {
    public hr iEv;
    public byte[] iEw;
    
    a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */