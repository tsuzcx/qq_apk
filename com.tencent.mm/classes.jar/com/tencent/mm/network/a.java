package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends d.a
  implements c
{
  byte[] cbM;
  private byte[] eNt;
  private a.a eNu = null;
  byte[] eNv;
  String eNw;
  private Map<String, byte[]> eNx = new HashMap();
  private boolean foreground = false;
  private int uin;
  String username;
  
  public a(a.a parama)
  {
    this.eNu = parama;
    TQ();
  }
  
  private void TQ()
  {
    this.cbM = bk.ZM(aw.HD().getString("server_id", ""));
  }
  
  private String TR()
  {
    try
    {
      Object localObject = ByteBuffer.allocate(4096);
      ((ByteBuffer)localObject).put(this.eNt).put(this.eNv).put(this.cbM).putInt(this.uin).put(this.eNw.getBytes()).put(this.username.getBytes());
      localObject = g.o(((ByteBuffer)localObject).array());
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private void clear()
  {
    this.username = null;
    this.eNt = null;
    this.cbM = null;
    this.uin = 0;
    this.eNv = null;
    this.eNw = null;
  }
  
  public final int C(byte[] paramArrayOfByte)
  {
    long l = bk.UY();
    if (KN())
    {
      y.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
      return -2;
    }
    try
    {
      v localv = new v();
      int i = localv.bA(paramArrayOfByte);
      if (i != 0)
      {
        y.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[] { Integer.valueOf(i) });
        return -3;
      }
      this.username = localv.getString();
      this.eNw = localv.getString();
      this.uin = localv.getInt();
      this.cbM = localv.getBuffer();
      this.eNv = localv.getBuffer();
      this.eNt = localv.getBuffer();
      paramArrayOfByte = localv.getString();
      if ((bk.bl(paramArrayOfByte)) || (!paramArrayOfByte.equals(TR())))
      {
        clear();
        y.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
        return -4;
      }
      y.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[] { Long.valueOf(bk.co(l)), paramArrayOfByte });
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      clear();
      y.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bk.j(paramArrayOfByte) });
    }
    return -5;
  }
  
  public final int CK()
  {
    return this.uin;
  }
  
  public final byte[] Dj()
  {
    return this.eNt;
  }
  
  public final void G(byte[] paramArrayOfByte)
  {
    this.cbM = paramArrayOfByte;
  }
  
  public final void H(byte[] paramArrayOfByte)
  {
    this.eNv = paramArrayOfByte;
  }
  
  public final byte[] KM()
  {
    return this.cbM;
  }
  
  public final boolean KN()
  {
    return (this.eNt != null) && (this.eNt.length > 0);
  }
  
  public final byte[] KO()
  {
    return this.eNv;
  }
  
  public final boolean KP()
  {
    return this.foreground;
  }
  
  public final byte[] KQ()
  {
    long l = bk.UY();
    int i;
    if (bk.bl(this.username)) {
      i = 0;
    }
    while (i == 0)
    {
      y.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
      return null;
      if (bk.bE(this.eNt)) {
        i = 0;
      } else if (bk.bE(this.cbM)) {
        i = 0;
      } else if ((this.uin == 0) || (this.uin == -1)) {
        i = 0;
      } else if (bk.bE(this.eNv)) {
        i = 0;
      } else if (bk.bl(this.eNw)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    try
    {
      Object localObject = new v();
      ((v)localObject).cqy();
      ((v)localObject).Zg(this.username);
      ((v)localObject).Zg(this.eNw);
      ((v)localObject).Fb(this.uin);
      ((v)localObject).bB(this.cbM);
      ((v)localObject).bB(this.eNv);
      ((v)localObject).bB(this.eNt);
      String str = TR();
      ((v)localObject).Zg(str);
      localObject = ((v)localObject).cqz();
      y.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[] { Long.valueOf(bk.co(l)), Integer.valueOf(localObject.length), str });
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final String Lm()
  {
    return this.eNw;
  }
  
  public final void bN(boolean paramBoolean)
  {
    this.foreground = paramBoolean;
    y.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", new Object[] { Boolean.valueOf(this.foreground) });
  }
  
  public final void fn(int paramInt)
  {
    y.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(paramInt), bk.csb() });
    this.uin = paramInt;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    this.eNx.put(paramString, paramArrayOfByte);
  }
  
  public final byte[] ks(String paramString)
  {
    return (byte[])this.eNx.get(paramString);
  }
  
  public final void oK(String paramString)
  {
    this.eNw = paramString;
  }
  
  public final void reset()
  {
    y.i("MicroMsg.AccInfo", "reset accinfo");
    this.username = "";
    this.eNt = null;
    TQ();
    this.uin = 0;
  }
  
  public final void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public final String toString()
  {
    String str = "AccInfo:\n" + "|-uin     =" + CK() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-wxuser  =" + Lm() + "\n";
    str = str + "|-session =" + bk.bD(Dj()) + "\n";
    str = str + "|-ecdhkey =" + bk.bD(KO()) + "\n";
    return str + "`-cookie  =" + bk.bD(KM());
  }
  
  public final void w(byte[] paramArrayOfByte, int paramInt)
  {
    y.i("MicroMsg.AccInfo", "summerauth update session info: session:%s, uin:%d -> %d stack:[%s]", new Object[] { bk.aac(bk.bD(paramArrayOfByte)), Integer.valueOf(this.uin), Integer.valueOf(paramInt), bk.csb() });
    this.eNt = paramArrayOfByte;
    this.uin = paramInt;
    if (this.eNu != null) {
      KN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.a
 * JD-Core Version:    0.7.0.1
 */