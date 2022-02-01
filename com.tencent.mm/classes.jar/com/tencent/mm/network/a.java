package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.be;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  byte[] dMA;
  String dvq;
  private boolean foreground;
  private byte[] iHf;
  private byte[] iHg;
  private byte[] iHh;
  private b iHi;
  byte[] iHj;
  private Map<String, byte[]> iHk;
  private Map<Integer, bpj> iHl;
  private Map<bpi, a> iHm;
  List<String> iHn;
  private int uin;
  String username;
  
  public a(b paramb)
  {
    AppMethodBeat.i(132629);
    this.iHi = null;
    this.foreground = false;
    this.iHk = new HashMap();
    this.iHl = new HashMap();
    this.iHm = new HashMap();
    this.iHn = new ArrayList();
    this.iHi = paramb;
    aPb();
    AppMethodBeat.o(132629);
  }
  
  private void aPb()
  {
    AppMethodBeat.i(132631);
    this.dMA = bu.aSx(be.aCl().getString("server_id", ""));
    AppMethodBeat.o(132631);
  }
  
  private String aPc()
  {
    AppMethodBeat.i(132637);
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.iHf).put(this.iHg).put(this.iHh).put(this.iHj).put(this.dMA).putInt(this.uin).put(this.dvq.getBytes()).put(this.username.getBytes());
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
    this.iHf = null;
    this.iHg = null;
    this.iHh = null;
    this.dMA = null;
    this.uin = 0;
    this.iHj = null;
    this.dvq = null;
  }
  
  public final byte[] DO(String paramString)
  {
    AppMethodBeat.i(132635);
    paramString = (byte[])this.iHk.get(paramString);
    AppMethodBeat.o(132635);
    return paramString;
  }
  
  public final byte[] DP(String paramString)
  {
    AppMethodBeat.i(132647);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132647);
      return null;
    }
    Iterator localIterator = this.iHm.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bpi)localEntry.getKey()).HcV));
    for (paramString = ((a)localEntry.getValue()).iHp;; paramString = null)
    {
      AppMethodBeat.o(132647);
      return paramString;
    }
  }
  
  public final byte[] DQ(String paramString)
  {
    AppMethodBeat.i(132652);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132652);
      return null;
    }
    Iterator localIterator = this.iHm.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bpi)localEntry.getKey()).HcV));
    for (paramString = ((a)localEntry.getValue()).iHo;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.FRJ.getBufferToBytes();
          AppMethodBeat.o(132652);
          return paramString;
        }
        catch (Exception paramString)
        {
          ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bu.o(paramString) });
          AppMethodBeat.o(132652);
          return null;
        }
      }
      AppMethodBeat.o(132652);
      return null;
    }
  }
  
  public final byte[] DR(String paramString)
  {
    AppMethodBeat.i(132653);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132653);
      return null;
    }
    Iterator localIterator = this.iHm.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramString.equals(((bpi)localEntry.getKey()).HcV));
    for (paramString = ((a)localEntry.getValue()).iHo;; paramString = null)
    {
      if (paramString != null) {
        try
        {
          paramString = paramString.FRK.getBufferToBytes();
          AppMethodBeat.o(132653);
          return paramString;
        }
        catch (Exception paramString)
        {
          ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bu.o(paramString) });
          AppMethodBeat.o(132653);
          return null;
        }
      }
      AppMethodBeat.o(132653);
      return null;
    }
  }
  
  public final boolean DS(String paramString)
  {
    AppMethodBeat.i(132646);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(132646);
      return false;
    }
    bpi localbpi;
    do
    {
      Iterator localIterator = this.iHl.entrySet().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (bpj)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject == null) || (((bpj)localObject).nIE == null));
        localObject = ((bpj)localObject).nIE.iterator();
      }
      localbpi = (bpi)((Iterator)localObject).next();
    } while ((localbpi == null) || (!paramString.equals(localbpi.HcV)));
    AppMethodBeat.o(132646);
    return true;
    AppMethodBeat.o(132646);
    return false;
  }
  
  public final void IP(String paramString)
  {
    this.dvq = paramString;
  }
  
  public final boolean IQ(String paramString)
  {
    AppMethodBeat.i(132650);
    if ("axhost".equals(paramString))
    {
      bool = this.iHl.isEmpty();
      AppMethodBeat.o(132650);
      return bool;
    }
    boolean bool = this.iHn.isEmpty();
    AppMethodBeat.o(132650);
    return bool;
  }
  
  public final boolean IR(String paramString)
  {
    AppMethodBeat.i(132651);
    if (!DS(paramString))
    {
      AppMethodBeat.o(132651);
      return false;
    }
    byte[] arrayOfByte = DQ(paramString);
    paramString = DR(paramString);
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
    long l = bu.fpO();
    if (aFm())
    {
      ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
      AppMethodBeat.o(132639);
      return -2;
    }
    try
    {
      ab localab = new ab();
      int i = localab.cB(paramArrayOfByte);
      if (i != 0)
      {
        ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(132639);
        return -3;
      }
      this.username = localab.getString();
      this.dvq = localab.getString();
      this.uin = localab.getInt();
      this.dMA = localab.getBuffer();
      this.iHj = localab.getBuffer();
      this.iHf = localab.getBuffer();
      this.iHg = localab.getBuffer();
      this.iHh = localab.getBuffer();
      paramArrayOfByte = localab.getString();
      if ((bu.isNullOrNil(paramArrayOfByte)) || (!paramArrayOfByte.equals(aPc())))
      {
        clear();
        ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        AppMethodBeat.o(132639);
        return -4;
      }
      ae.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(bu.DD(l)), paramArrayOfByte });
      AppMethodBeat.o(132639);
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bu.o(paramArrayOfByte) });
      AppMethodBeat.o(132639);
    }
    return -5;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132632);
    ae.i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", new Object[] { bu.aSM(bu.cE(paramArrayOfByte1)), bu.aSM(bu.cE(paramArrayOfByte2)), bu.aSM(bu.cE(paramArrayOfByte3)), Integer.valueOf(this.uin), Integer.valueOf(paramInt), bu.fpN() });
    this.iHf = paramArrayOfByte1;
    this.iHg = paramArrayOfByte2;
    this.iHh = paramArrayOfByte3;
    this.uin = paramInt;
    if (this.iHi != null) {
      aFm();
    }
    AppMethodBeat.o(132632);
  }
  
  public final byte[] aFl()
  {
    return this.dMA;
  }
  
  public final boolean aFm()
  {
    return (this.iHf != null) && (this.iHg != null) && (this.iHh != null) && (this.iHf.length > 0) && (this.iHg.length > 0) && (this.iHh.length > 0);
  }
  
  public final byte[] aFn()
  {
    return this.iHj;
  }
  
  public final String aFo()
  {
    return this.dvq;
  }
  
  public final byte[] aFp()
  {
    AppMethodBeat.i(132638);
    long l = bu.fpO();
    int i;
    if (bu.isNullOrNil(this.username)) {
      i = 0;
    }
    while (i == 0)
    {
      ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
      AppMethodBeat.o(132638);
      return null;
      if (bu.cF(this.iHf)) {
        i = 0;
      } else if (bu.cF(this.iHg)) {
        i = 0;
      } else if (bu.cF(this.iHh)) {
        i = 0;
      } else if (bu.cF(this.dMA)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (bu.cF(this.iHj)) {
        i = 0;
      } else if (bu.isNullOrNil(this.dvq)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    try
    {
      Object localObject = new ab();
      ((ab)localObject).fod();
      ((ab)localObject).aRM(this.username);
      ((ab)localObject).aRM(this.dvq);
      ((ab)localObject).abc(this.uin);
      ((ab)localObject).cC(this.dMA);
      ((ab)localObject).cC(this.iHj);
      ((ab)localObject).cC(this.iHf);
      ((ab)localObject).cC(this.iHg);
      ((ab)localObject).cC(this.iHh);
      String str = aPc();
      ((ab)localObject).aRM(str);
      localObject = ((ab)localObject).foe();
      ae.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[] { Long.valueOf(bu.DD(l)), Integer.valueOf(localObject.length), str });
      AppMethodBeat.o(132638);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(132638);
    }
    return null;
  }
  
  public final void aFq()
  {
    AppMethodBeat.i(132644);
    this.iHm.clear();
    AppMethodBeat.o(132644);
  }
  
  public final void aFr()
  {
    AppMethodBeat.i(132645);
    ae.i("MicroMsg.AccInfo", "clearAxHost");
    this.iHl.clear();
    AppMethodBeat.o(132645);
  }
  
  public final void aPd()
  {
    AppMethodBeat.i(132643);
    if ((this.iHg != null) || (this.iHh != null) || (!this.iHm.isEmpty()))
    {
      this.iHg = null;
      this.iHh = null;
      this.iHm.clear();
    }
    AppMethodBeat.o(132643);
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    this.dMA = paramArrayOfByte;
  }
  
  public final void ah(byte[] paramArrayOfByte)
  {
    this.iHj = paramArrayOfByte;
  }
  
  public final void ai(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132648);
    this.iHn.add(new String(paramArrayOfByte));
    AppMethodBeat.o(132648);
  }
  
  public final boolean aj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132649);
    boolean bool = this.iHn.contains(new String(paramArrayOfByte));
    AppMethodBeat.o(132649);
    return bool;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132642);
    ae.i("MicroMsg.AccInfo", "setAxAuthSessionKey");
    Object localObject = (bpj)this.iHl.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((bpj)localObject).nIE.size() == 0))
    {
      ae.w("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(132642);
      return;
    }
    hr localhr = new hr();
    try
    {
      localhr.parseFrom(paramArrayOfByte1);
      ae.i("MicroMsg.AccInfo", "axsession key length: server [%d], client [%d]", new Object[] { Integer.valueOf(localhr.FRK.getILen()), Integer.valueOf(localhr.FRJ.getILen()) });
      paramArrayOfByte1 = new a();
      paramArrayOfByte1.iHo = localhr;
      paramArrayOfByte1.iHp = paramArrayOfByte2;
      paramArrayOfByte2 = ((bpj)localObject).nIE.iterator();
      while (paramArrayOfByte2.hasNext())
      {
        localObject = (bpi)paramArrayOfByte2.next();
        this.iHm.put(localObject, paramArrayOfByte1);
        ae.i("MicroMsg.AccInfo", "receive axauth host " + ((bpi)localObject).HcV);
      }
      AppMethodBeat.o(132642);
    }
    catch (Exception paramArrayOfByte1)
    {
      ae.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bu.o(paramArrayOfByte1) });
      AppMethodBeat.o(132642);
      return;
    }
  }
  
  public final void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(132636);
    this.foreground = paramBoolean;
    ae.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", new Object[] { Boolean.valueOf(this.foreground) });
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
    ae.i("MicroMsg.AccInfo", "addAxAuthHostList");
    bpj localbpj = new bpj();
    try
    {
      localbpj.parseFrom(paramArrayOfByte);
      this.iHl.put(Integer.valueOf(paramInt), localbpj);
      ae.i("MicroMsg.AccInfo", "add host " + paramInt + " host " + ((bpi)localbpj.nIE.get(0)).HcU);
      AppMethodBeat.o(132641);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.AccInfo", "exception:%s", new Object[] { bu.o(paramArrayOfByte) });
      AppMethodBeat.o(132641);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132634);
    this.iHk.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(132634);
  }
  
  public final boolean isForeground()
  {
    return this.foreground;
  }
  
  public final byte[] mR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.iHf;
    case 2: 
      return this.iHg;
    }
    return this.iHh;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132630);
    ae.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.iHf = null;
    aPb();
    this.uin = 0;
    this.iHg = null;
    this.iHh = null;
    AppMethodBeat.o(132630);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132640);
    ae.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(paramInt), bu.fpN() });
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
    str = str + "|-wxuser  =" + aFo() + "\n";
    str = str + "|-wxuser  =" + aFo() + "\n";
    str = str + "|-singlesession =" + bu.cE(mR(1)) + "\n";
    str = str + "|-clientsession =" + bu.cE(mR(2)) + "\n";
    str = str + "|-serversession =" + bu.cE(mR(3)) + "\n";
    str = str + "|-ecdhkey =" + bu.cE(aFn()) + "\n";
    str = str + "`-cookie  =" + bu.cE(aFl());
    AppMethodBeat.o(132633);
    return str;
  }
  
  final class a
  {
    public hr iHo;
    public byte[] iHp;
    
    a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */